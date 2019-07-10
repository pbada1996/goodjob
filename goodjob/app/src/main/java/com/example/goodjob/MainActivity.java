package com.example.goodjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.goodjob.classes.ValidSession;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private FloatingActionButton publicarActividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.ImgProfile);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ValidSession.usuarioLogueado == null) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                } else {
                    navigation.setSelectedItemId(R.id.navigation_profile);
                }
            }
        });
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // boton flotante
        publicarActividad = findViewById(R.id.fabPublicarActividad);
        publicarActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ValidSession.usuarioLogueado != null)
                    startActivity(new Intent(MainActivity.this, PublicarActividadActivity.class));
            }
        });

        // setting the initial fragment on app start
        Fragment initialFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.containerFragments, initialFragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.navigation_profile:
                    selectedFragment = new ProfileFragment();
                    break;
                case R.id.navigation_premiun:
                    startActivity(new Intent(MainActivity.this, SuscriptionActivity.class));
                    return true;
                case R.id.navigation_estado_mis_actividades:
                    selectedFragment = new EstadoMisActividadesFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.containerFragments, selectedFragment).commit();
            return true;
        }
    };

}
