package fr.cpe.pokemongoplagiat;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.android.material.navigation.NavigationView;

import fr.cpe.pokemongoplagiat.interfaces.OnClickOnMenuListener;

public class BottomMenuViewModel  extends BaseObservable {
    private int menu = 0;

    public NavigationView.OnNavigationItemSelectedListener getListener() {
        return (item) -> {
            onNavigationItemSelected(item);
            return true;
        };
        /*return new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                onNavigationItemSelected(item);
                return true;
            }
        };*/
    }
    public void onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu:
                this.listener.onClickOnItem(0);
                this.menu = 0;
                break;
            case R.id.maps:
                this.listener.onClickOnItem(1);
                this.menu = 1;
                break;
            case R.id.inventory:
                this.listener.onClickOnItem(2);
                this.menu = 2;
                break;
        }
    }


    private OnClickOnMenuListener listener;

    public void setOnClickOnMenu(OnClickOnMenuListener listener)
    {
        this.listener = listener;
    }


}