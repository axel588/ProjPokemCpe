package fr.cpe.pokemongoplagiat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import fr.cpe.pokemongoplagiat.databinding.PokedexFragmentBinding;

import fr.cpe.pokemongoplagiat.interfaces.OnClickOnNoteListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnPokemonFromListListener;
import fr.cpe.pokemongoplagiat.models.POKEMON_TYPE;
import fr.cpe.pokemongoplagiat.models.Pokemon;

public class PokedexFragment extends Fragment {
    @Nullable

    private static Map<String, String> typeConversion = new HashMap<>();
        static {
            typeConversion.put("normal", "Normal");
            typeConversion.put("fighting", "Combat");
            typeConversion.put("flying", "Vol");
            typeConversion.put("poison", "Poison");
            typeConversion.put("ground", "Sol");
            typeConversion.put("rock", "Roche");
            typeConversion.put("bug", "Insecte");
            typeConversion.put("ghost", "Spectre");
            typeConversion.put("steel", "Acier");
            typeConversion.put("fire", "Feu");
            typeConversion.put("feu", "Feu");
            typeConversion.put("water", "Eau");
            typeConversion.put("grass", "Plante");
            typeConversion.put("plante", "Plante");
            typeConversion.put("electric", "Electrique");
            typeConversion.put("psychic", "Psy");
            typeConversion.put("ice", "Glace");
            typeConversion.put("dragon", "Dragon");
            typeConversion.put("dark", "Tenebre");
            typeConversion.put("plant", "Plante");
            typeConversion.put("fairy", "Fee");
            typeConversion.put("unknown", "Inconnu");
        }



    private OnClickOnNoteListener listener;
    public void setOnClickOnNoteListener(OnClickOnNoteListener listener)
    {
        this.listener = listener;
    }

    private OnClickOnPokemonFromListListener onClickOnPokemonFromListListener;
    public void setOnClickOnPokemonFromListListener(OnClickOnPokemonFromListListener listener)
    {
        this.onClickOnPokemonFromListListener = listener;
    }

    public void onEventFunction(long noteId) {
        if (listener != null)
            listener.onClickOnNote(noteId);
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        PokedexFragmentBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.pokedex_fragment,container,false);
        binding.pokemonList.setLayoutManager(new LinearLayoutManager(
                binding.getRoot().getContext()));

        List<Pokemon> pokemonList = new ArrayList<>();


        InputStreamReader isr = new InputStreamReader(getResources().openRawResource(R.raw.data));


        BufferedReader reader = new BufferedReader(isr);
        StringBuilder builder = new StringBuilder();
        String data = "";
        //lecture du fichier. data == null => EOF
        while(data != null) {
            try {
                data = reader.readLine();
                builder.append(data);
            } catch ( IOException e) {
                e.printStackTrace();
            }
        }
        //Traitement du fichier
        try {
            JSONArray array = new JSONArray(builder.toString());
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                String name = object.getString("name");
                String image = object.getString("image");
                String type1 = object.getString("type1");
                String type2 = null;
                if (object.has("type2"))
                    type2 = object.getString("type2");
                Pokemon pokemon = new Pokemon();
                pokemon.setName(name);
                if(type1!=null)
                {
                    pokemon.setType1(POKEMON_TYPE.valueOf(typeConversion.get(type1)));
                }
                if(type2!=null)
                {
                    pokemon.setType2(POKEMON_TYPE.valueOf(typeConversion.get(type2)));
                }

                int id = getResources().getIdentifier(image,"drawable",
                        binding.getRoot().getContext().getPackageName());

                pokemon.setFrontResource(id);
                pokemonList.add(pokemon);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        PokemonListAdapter adapter = new PokemonListAdapter(pokemonList);
        adapter.setOnClickOnNoteListener(this.listener);
        adapter.setOnClickOnPokemonFromListListener(this.onClickOnPokemonFromListListener);
        binding.pokemonList.setAdapter(adapter);


        return binding.getRoot();
    }
}