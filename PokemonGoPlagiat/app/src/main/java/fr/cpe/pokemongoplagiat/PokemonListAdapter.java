package fr.cpe.pokemongoplagiat;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.cpe.pokemongoplagiat.databinding.PokemonItemBinding;

import fr.cpe.pokemongoplagiat.interfaces.OnClickOnNoteListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnPokemonFromListListener;
import fr.cpe.pokemongoplagiat.models.Pokemon;

public class PokemonListAdapter extends
        RecyclerView.Adapter<PokemonListAdapter.ViewHolder> {
    List<Pokemon> pokemonList;
    public PokemonListAdapter(List<Pokemon> pokemonList) {
        assert pokemonList != null;
        this.pokemonList =pokemonList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PokemonItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.pokemon_item, parent, false);
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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.viewModel.setOnClickOnPokemonFromListListener(this.onClickOnPokemonFromListListener);
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
        private final PokemonItemBinding binding;
        private final PokemonViewModel viewModel = new PokemonViewModel();
        ViewHolder(PokemonItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.setPokemonViewModel(viewModel);
        }
    }
}
