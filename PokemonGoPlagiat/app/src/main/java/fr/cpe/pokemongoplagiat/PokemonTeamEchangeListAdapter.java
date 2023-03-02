package fr.cpe.pokemongoplagiat;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.databinding.PokemonTeamEchangeItemBinding;
import fr.cpe.pokemongoplagiat.databinding.PokemonTeamItemBinding;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnEchangerPokemonListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnNoteListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnPokemonFromListListener;

public class PokemonTeamEchangeListAdapter extends
        RecyclerView.Adapter<PokemonTeamEchangeListAdapter.ViewHolder> {
    List<Pokemon> pokemonList;
    public PokemonTeamEchangeListAdapter(List<Pokemon> pokemonList) {
        assert pokemonList != null;
        this.pokemonList =pokemonList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PokemonTeamEchangeItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.pokemon_team_echange_item, parent, false);
        return new ViewHolder(binding);
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

    private OnClickOnEchangerPokemonListener onClickOnEchangerPokemonListener;
    public void setOnClickOnEchangerPokemonListener(OnClickOnPokemonFromListListener listener)
    {
        this.onClickOnPokemonFromListListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.viewModel.setOnClickOnPokemonFromListListener(this.onClickOnPokemonFromListListener);
        holder.viewModel.setOnClickOnEchangerPokemonListener(this.onClickOnEchangerPokemonListener);
        holder.viewModel.setOnClickOnNoteListener(this.listener);
        holder.viewModel.setPokemon(pokemon);
        
        /*
        holder.binding.front.setImageResource(pokemon.getFrontResource());
        holder.binding.name.setText(pokemon.getName());
        holder.binding.type1Text.setText(pokemon.getType1String());
        holder.binding.number.setText("#"+pokemon.getOrder());
        if (pokemon.getType2() != null) {
            holder.binding.type2Text.setText(pokemon.getType2String());
        }*/
    }
    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        private final PokemonTeamEchangeItemBinding binding;
        private final PokemonTeamEchangeViewModel viewModel = new PokemonTeamEchangeViewModel();
        ViewHolder(PokemonTeamEchangeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.setPokemonTeamEchangeViewModel(viewModel);
        }
    }
}
