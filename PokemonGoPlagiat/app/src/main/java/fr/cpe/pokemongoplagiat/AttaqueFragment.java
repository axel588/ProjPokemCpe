package fr.cpe.pokemongoplagiat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import fr.cpe.pokemongoplagiat.bdddao.AttackDao;
import fr.cpe.pokemongoplagiat.bdddao.PlayerDao;
import fr.cpe.pokemongoplagiat.bdddao.PokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.relation.OwnedPokemonPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relation.WildPokemonPokemon;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.PlayerPokemonDao;
import fr.cpe.pokemongoplagiat.bdddao.relationdao.WildPokemonPokemonDao;
import fr.cpe.pokemongoplagiat.bddmodels.Attack;
import fr.cpe.pokemongoplagiat.bddmodels.OwnedPokemon;
import fr.cpe.pokemongoplagiat.bddmodels.Player;
import fr.cpe.pokemongoplagiat.bddmodels.Pokemon;
import fr.cpe.pokemongoplagiat.databinding.AttaqueFragmentBinding;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAnnulerListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAttaqueListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnAttaquerPokemonListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnEchangerListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnEchangerPokemonListener;
import fr.cpe.pokemongoplagiat.interfaces.OnClickOnFuireListener;
import fr.cpe.pokemongoplagiat.models.POKEMON_TYPE;

public class AttaqueFragment extends Fragment {


    AttaqueViewModel viewModel = new AttaqueViewModel();

    public AttaqueFragmentBinding binding;

    public void setWildPokemonPokemon(WildPokemonPokemon wildPokemonPokemon) {
        this.wildPokemonPokemon = wildPokemonPokemon;
    }

    public WildPokemonPokemon wildPokemonPokemon;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,
                R.layout.attaque_fragment,container,false);

        binding.buttonGagne.setVisibility(View.GONE);
        binding.myPokemonKill.setVisibility(View.GONE);
        binding.buttonAttaque1.setEnabled(false);
        binding.buttonAttaque2.setEnabled(false);
        binding.buttonAttaque3.setEnabled(false);
        binding.buttonAttaque4.setEnabled(false);
        binding.buttonAttaque5.setEnabled(false);
        binding.buttonAttaque6.setEnabled(false);

        List<OwnedPokemonPokemon> ownedPokemon = new ArrayList<>();
        WildPokemonPokemon pokemonAttaque = getWildPokemon();
        if(wildPokemonPokemon!=null)
        {
            pokemonAttaque = wildPokemonPokemon;
        }


        Long idPlayer = getIdPlayer();
        ownedPokemon = getMyPokemon(idPlayer);
        viewModel.setPokemennAttaque(pokemonAttaque);
        viewModel.setAttackPokemonWild(getAttackByPokemon(pokemonAttaque.getPokemon().getId()));
        if(ownedPokemon.size()>0)
        {
            viewModel.setMyPokemon(ownedPokemon.get(0));


            viewModel.setAttackOwnedPokemon(getAttackByPokemon(ownedPokemon.get(0).getPokemon().getId()));
        }

        //viewModel.setPokemon(pokemon);



        OnClickOnAttaqueListener argent = new OnClickOnAttaqueListener()
        {
            @Override
            public void onClickOnAttaque()
            {
                if (viewModel.getPvOwnedPokemon() > 0) {
                    binding.buttonAttaquer.setVisibility(View.GONE);
                    binding.buttonFuir.setVisibility(View.GONE);
                    binding.buttonInventaire.setVisibility(View.GONE);
                    binding.buttonEchanger.setVisibility(View.GONE);
                    binding.buttonAnnuler.setVisibility(View.VISIBLE);

                    binding.buttonAttaque1.setEnabled(true);
                    binding.buttonAttaque2.setEnabled(true);
                    binding.buttonAttaque3.setEnabled(true);
                    binding.buttonAttaque4.setEnabled(true);
                    binding.buttonAttaque5.setEnabled(true);
                    binding.buttonAttaque6.setEnabled(true);
                }
            }
        };



        OnClickOnAnnulerListener annulerListnerAgent = new OnClickOnAnnulerListener ()
        {
            @Override
            public void onClickOnAnnuler()
            {
                binding.buttonAttaquer.setVisibility(View.VISIBLE);
                binding.buttonFuir.setVisibility(View.VISIBLE);
                binding.buttonInventaire.setVisibility(View.VISIBLE);
                binding.buttonEchanger.setVisibility(View.VISIBLE);
                binding.buttonAnnuler.setVisibility(View.GONE);
            }
        };


        OnClickOnAttaquerPokemonListener attaquerPokemonListnerAgent = new OnClickOnAttaquerPokemonListener ()
        {
            @Override
            public void onClickOnAttaquerPokemon(int i)
            {
                if (viewModel.getPvOwnedPokemon() > 0) {
                    long dammage = viewModel.getDamageMyPokemon(i);
                    viewModel.subPvWildPokemon(dammage);
                    if (viewModel.getPvPokemonAttaque() > 0) {
                        Random rand = new Random();
                        int val = Math.abs(rand.nextInt()) % 6;
                        dammage = viewModel.getDamageWildPokemon(val);
                        viewModel.subPvMyPokemon(dammage);
                        if (viewModel.getPvOwnedPokemon() <= 0) {


                            binding.buttonAttaque1.setEnabled(false);
                            binding.buttonAttaque2.setEnabled(false);
                            binding.buttonAttaque3.setEnabled(false);
                            binding.buttonAttaque4.setEnabled(false);
                            binding.buttonAttaque5.setEnabled(false);
                            binding.buttonAttaque6.setEnabled(false);

                            binding.buttonAttaquer.setVisibility(View.VISIBLE);
                            binding.buttonFuir.setVisibility(View.VISIBLE);
                            binding.buttonInventaire.setVisibility(View.VISIBLE);
                            binding.buttonEchanger.setVisibility(View.VISIBLE);
                            binding.buttonAnnuler.setVisibility(View.GONE);
                            binding.myPokemonKill.setVisibility(View.VISIBLE);


                        }

                    } else {
                        binding.buttonAttaque1.setEnabled(false);
                        binding.buttonAttaque2.setEnabled(false);
                        binding.buttonAttaque3.setEnabled(false);
                        binding.buttonAttaque4.setEnabled(false);
                        binding.buttonAttaque5.setEnabled(false);
                        binding.buttonAttaque6.setEnabled(false);

                        binding.buttonGagne.setVisibility(View.VISIBLE);
                    }
                }
                else
                {
                    binding.buttonAttaque1.setEnabled(false);
                    binding.buttonAttaque2.setEnabled(false);
                    binding.buttonAttaque3.setEnabled(false);
                    binding.buttonAttaque4.setEnabled(false);
                    binding.buttonAttaque5.setEnabled(false);
                    binding.buttonAttaque6.setEnabled(false);

                    binding.myPokemonKill.setVisibility(View.VISIBLE);
                    binding.buttonAttaquer.setVisibility(View.VISIBLE);
                    binding.buttonFuir.setVisibility(View.VISIBLE);
                    binding.buttonInventaire.setVisibility(View.VISIBLE);
                    binding.buttonEchanger.setVisibility(View.VISIBLE);
                    binding.buttonAnnuler.setVisibility(View.GONE);
                }


            }
        };

        viewModel.setOnClickOnAnnulerListener(annulerListnerAgent);
        viewModel.setOnClickOnAttaqueListener(argent);
        viewModel.setOnClickOnAttaquerPokemonListener(attaquerPokemonListnerAgent);
        binding.setAttaqueViewModel(viewModel);
            /*@Override
            public boolean OnClickOnAttaqueListener(@NonNull MenuItem item) {
                FragmentTransaction transaction = manager.beginTransaction();
            }*/

        return binding.getRoot();
    }

    public void setOnClickOnFuireListener(OnClickOnFuireListener listener)
    {
        viewModel.setOnClickOnFuireListener(listener);
    }

    public void setOnClickOnEchnagerListener(OnClickOnEchangerListener listener)
    {
        viewModel.setOnClickOnEchangerListener(listener);
    }


    public List<OwnedPokemonPokemon> getMyPokemon(Long idPlayer)
    {
        List<OwnedPokemonPokemon> ownedPokemon = new ArrayList<>();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<List<OwnedPokemonPokemon>> futureTask = new FutureTask<>(new Callable<List<OwnedPokemonPokemon>>() {
            @Override
            public List<OwnedPokemonPokemon> call() throws Exception {
                AppDatabase db = Room.databaseBuilder(binding.getRoot().getContext(),
                        AppDatabase.class, "poke-plagiat").build();

                PlayerPokemonDao playerPokemonDao = db.playerpokemonDao();
                List<OwnedPokemonPokemon> monPoke = playerPokemonDao.getOwnedPokemonsByPlayerId(idPlayer);
                return monPoke;
            }
        });

        executor.execute(futureTask);

        try {
            ownedPokemon = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle any exceptions that occurred while executing the task
        }

// Don't forget to shutdown the executor when it's no longer needed
        executor.shutdown();

        return ownedPokemon;
    }

    public WildPokemonPokemon getWildPokemon()
    {
        WildPokemonPokemon wildPokemonPokemon = new  WildPokemonPokemon();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<WildPokemonPokemon> futureTask = new FutureTask<>(new Callable<WildPokemonPokemon>() {
            @Override
            public  WildPokemonPokemon call() throws Exception {
                AppDatabase db = Room.databaseBuilder(binding.getRoot().getContext(),
                        AppDatabase.class, "poke-plagiat").build();

                WildPokemonPokemonDao wildPokemonPokemonDao = db.wildPokemonPokemonDao();
                List<WildPokemonPokemon> pokes = wildPokemonPokemonDao.getAllWildPokemonPokemon();
                return pokes.get(0);
            }
        });

        executor.execute(futureTask);

        try {
            wildPokemonPokemon = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle any exceptions that occurred while executing the task
        }

// Don't forget to shutdown the executor when it's no longer needed
        executor.shutdown();

        return wildPokemonPokemon;
    }

    public Long getIdPlayer()
    {
        Long idPlayer = new Long(0);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<Long> futureTask = new FutureTask<>(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                AppDatabase db = Room.databaseBuilder(binding.getRoot().getContext(),
                        AppDatabase.class, "poke-plagiat").build();

                PlayerDao playerDao = db.playerDao();
                List<Player> player = playerDao.getAll();
                return player.get(0).getId();
            }
        });

        executor.execute(futureTask);

        try {
            idPlayer = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle any exceptions that occurred while executing the task
        }

// Don't forget to shutdown the executor when it's no longer needed
        executor.shutdown();

        return idPlayer;
    }

    public List<Attack> getAttackByPokemon(long idPokemon)
    {
        List<Attack> attackPokemon = new ArrayList<>();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<List<Attack>> futureTask = new FutureTask<>(new Callable<List<Attack>>() {
            @Override
            public List<Attack> call() throws Exception {
                AppDatabase db = Room.databaseBuilder(binding.getRoot().getContext(),
                        AppDatabase.class, "poke-plagiat").build();

                AttackDao attackDao = db.attackDao();
                List<Attack> attackPokemon = attackDao.getAllByPokemon(idPokemon);
                return attackPokemon ;
            }
        });

        executor.execute(futureTask);

        try {
            attackPokemon = futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            // Handle any exceptions that occurred while executing the task
        }

// Don't forget to shutdown the executor when it's no longer needed
        executor.shutdown();

        return attackPokemon;
    }


}
