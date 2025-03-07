package com.example.gismovies;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.gismovies.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;

    TextInputEditText name, email, pass1, pass2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass1 = findViewById(R.id.pass1);
        pass2 = findViewById(R.id.pass2);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout= findViewById(R.id.main);
        NavigationView navigationView = findViewById(R.id.nav_views);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,
                toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }


    public void Register(View view){
        String username = name.getText().toString().trim();
        String useremail = email.getText().toString().trim();
        String userpass_1 = pass1.getText().toString().trim();
        String userpass_2 = pass2.getText().toString().trim();

        Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();



        if (!(username.isEmpty() && useremail.isEmpty() && userpass_1.isEmpty() && userpass_2.isEmpty())){
            if (useremail.contains("@") && useremail.endsWith(".com")){
                Toast.makeText(MainActivity.this, username  + useremail + userpass_1 + userpass_2, Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this, "Type A Valid Email", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(MainActivity.this, "All Filed Is Required", Toast.LENGTH_SHORT).show();

        }




    }


    public void Signin(View view){
//        Intent intent = new Intent(MainActivity.this, List.clase);
//        startActivity(intent);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, Blank)
    }

}




