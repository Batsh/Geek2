package com.example.muradmomani.anothaone;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    FloatingActionButton fab;
    TextView userMail, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
            setTheme(R.style.darktheme);
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        //setSupportActionBar(toolbar);.
        //getSupportActionBar().setTitle(null);

        fab = (FloatingActionButton) findViewById(R.id.fab);




        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        userMail = (TextView) headerView.findViewById(R.id.emailhead);
        userName = (TextView) headerView.findViewById(R.id.usernamehead);

        try {
            Intent temp = getIntent();
            String extra = temp.getStringExtra("email");

            if (extra.equals("")) {
                userMail.setText("User@email.com");
                userName.setText("User");
            } else {
                String split[] = extra.split("@");
                userMail.setText(extra);
                userName.setText(split[0].toUpperCase());
            }
        }catch (NullPointerException e){
            userMail.setText("User@email.com");
            userName.setText("User");
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_profile:
                        Intent back=new Intent(MainActivity.this,login.class);
                        startActivity(back);
                        break;
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new HomeFragment()).commit();
                        break;

                    case R.id.nav_movie:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new MovieFragment()).commit();
                        break;
                    case R.id.nav_tv:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new TvFragment()).commit();
                        break;
                    case R.id.nav_watchlist:
                        Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                        /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new WatchlistFragment()).commit();*/
                        break;
                    case R.id.nav_tools:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new ToolsFragment()).commit();
                        break;
                    case R.id.nav_share:
                        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        String shareBodyText = "GeekFilm on Github: https://github.com/Batsh/Geek2";
                        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "GeekFilm");
                        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBodyText);
                        startActivity(Intent.createChooser(intent, "Choose sharing method"));
                        break;
                    case R.id.nav_send:
                        Intent intent2 = new Intent(Intent.ACTION_SENDTO);
                        intent2.setType("text/plain");
                        intent2.setData(Uri.parse("mailto:"));
                        intent2.putExtra(Intent.EXTRA_EMAIL, new String[]{"ahmad.rashid.albatch@gmail.com","qaisas49@hotmail.com"});
                        intent2.putExtra(Intent.EXTRA_SUBJECT, "GeekFilm");
                        if (intent2.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent2);
                        }
                        else Toast.makeText(MainActivity.this, "Email error", Toast.LENGTH_SHORT).show();
                        break;
                }

                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_SHORT).show();
                /*
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SearchFragment()).commit();*/
            }
        });


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}


