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
import androidx.room.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import fr.cpe.pokemongoplagiat.bdddao.PokemonDao;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.databinding.PokemonTeamEchangeFragmentBinding;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnEchangerPokemonListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnNoteListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnPokemonFromListListener;
import fr.cpe.pokemongoplagiat.models.POKEMON_TYPE;

public class PokemonTeamEchangeFragment extends Fragment {
    @Nullable

    private static final Map<String, String> typeConversion = new HashMap<>();
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

    private OnClickOnEchangerPokemonListener onClickOnEchangerPokemonListener;
    public void setOnClickOnEchangerPokemonListener(OnClickOnEchangerPokemonListener listener)
    {
        this.onClickOnEchangerPokemonListener = listener;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        PokemonTeamEchangeFragmentBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.pokemon_team_echange_fragment,container,false);
        binding.pokemonList.setLayoutManager(new LinearLayoutManager(
                binding.getRoot().getContext()));

        List<Pokemon> pokemonList = new ArrayList<>();


       /* InputStreamReader isr = new InputStreamReader(getResources().openRawResource(R.raw.data));


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
                int idtype1 = -1;
                int idtype2 = -1;
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
                    pokemon.setType1_(POKEMON_TYPE.valueOf(typeConversion.get(type1)));
                }
                if(type2!=null)
                {
                    pokemon.setType2_(POKEMON_TYPE.valueOf(typeConversion.get(type2)));
                }
                if (type1 != null) {
                    idtype1 = getResources().getIdentifier(type1, "drawable",
                            binding.getRoot().getContext().getPackageName());
                }
                if (type2 != null) {
                    idtype2 = getResources().getIdentifier(type2, "drawable",
                            binding.getRoot().getContext().getPackageName());
                }


                int id = getResources().getIdentifier(image,"drawable",
                        binding.getRoot().getContext().getPackageName());

                pokemon.setType1Img(idtype1);
                pokemon.setType2Img(idtype2);

                pokemon.setFrontRessource((long)id);
                pokemonList.add(pokemon);

                AppDatabase db = Room.databaseBuilder(binding.getRoot().getContext(),
                        AppDatabase.class, "poke-plagiat").build();


                //PokemonDao pokemonDao = db.pokemonDao();
                //pokemonList = pokemonDao.getAll();
            }
        } catch (JSONException e) {
            e.printStackTrace();

        }*/

        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<List<Pokemon>> futureTask = new FutureTask<>(new Callable<List<Pokemon>>() {
            @Override
            public List<Pokemon> call() throws Exception {
                AppDatabase db = Room.databaseBuilder(binding.getRoot().getContext(),
                        AppDatabase.class, "poke-plagiat").build();
                PokemonDao pokemonDao = db.pokemonDao();
                List<Pokemon> allpokemon = pokemonDao.getAll();
                for(int m = 0;m<allpokemon.size();m++)
                {
                    Pokemon poke = allpokemon.get(m);
                    poke.setType2_(POKEMON_TYPE.valueOf((int)poke.getType2()));
                    poke.setType1_(POKEMON_TYPE.valueOf((int)poke.getType1()));
                    int idtype1 = getResources().getIdentifier(POKEMON_TYPE.valueOf((int)poke.getType1()).name().toLowerCase(), "drawable",
                        binding.getRoot().getContext().getPackageName());
                    int idtype2 = 0;

                    poke.setType1_img(idtype1);
                    if(poke.getType2_() != POKEMON_TYPE.None)
                    {
                        idtype2 = getResources().getIdentifier(POKEMON_TYPE.valueOf((int)poke.getType2()).name().toLowerCase(), "drawable",
                                binding.getRoot().getContext().getPackageName());
                        poke.setType2_img(idtype2);
                    }

                    allpokemon.set(m, poke);

                }
                return allpokemon;
            }
        });

        executor.execute(futureTask);

        try {
            pokemonList = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle any exceptions that occurred while executing the task
        }

// Don't forget to shutdown the executor when it's no longer needed
        executor.shutdown();

        PokemonTeamEchangeListAdapter adapter = new PokemonTeamEchangeListAdapter (pokemonList);
        adapter.setOnClickOnNoteListener(this.listener);
        adapter.setOnClickOnPokemonFromListListener(this.onClickOnPokemonFromListListener);
        binding.pokemonList.setAdapter(adapter);


        return binding.getRoot();
    }
}