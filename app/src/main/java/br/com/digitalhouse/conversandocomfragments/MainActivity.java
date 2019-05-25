package br.com.digitalhouse.conversandocomfragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import br.com.digitalhouse.conversandocomfragments.fragments.FirstFragment;
import br.com.digitalhouse.conversandocomfragments.fragments.SecondFragment;
import br.com.digitalhouse.conversandocomfragments.interfaces.Comunicador;
import br.com.digitalhouse.conversandocomfragments.model.Pessoa;

public class MainActivity extends AppCompatActivity implements Comunicador {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
replaceFragment(R.id.container_2, new FirstFragment());

    }

    public void replaceFragment(int container, Fragment fragment){
        FragmentManager  manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container,fragment);
        transaction.commit();
    }


    @Override
    public void receberMenssagem(Pessoa pessoa) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("PERSON", pessoa);
        Fragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        replaceFragment(R.id.container_1, secondFragment);
    }
}
