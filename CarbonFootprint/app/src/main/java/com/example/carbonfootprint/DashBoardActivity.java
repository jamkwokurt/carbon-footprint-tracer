package com.example.carbonfootprint;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.carbonfootprint.databinding.ActivityDashBoardBinding;
import com.example.carbonfootprint.ui.login.LoginActivity;
import com.google.android.material.navigation.NavigationView;

public class DashBoardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityDashBoardBinding binding;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
//    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawerLayout = findViewById(R.id.drawer_layout);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_account,R.id.nav_settings,R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();

        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nav_user_name);
        TextView navEmail = (TextView) headerView.findViewById(R.id.nav_user_email);
        String userName = getIntent().getStringExtra(getString(R.string.user_name));
        String userEmail = getIntent().getStringExtra(getString(R.string.user_email));

        navUsername.setText(userName);
        navEmail.setText(userEmail);

//        currentUser = new User(userName,userEmail);
//        TravelRecord currentTravelRecord = new TravelRecord(currentUser);
//        Utils.getTravelRecords().put(currentUser,currentTravelRecord);

        ImageView weeklyReport = findViewById(R.id.reportView);
        ImageView recordEmission = findViewById(R.id.plusView);
        ImageView offsetEmission = findViewById(R.id.minusView);
        Button startTrackingJourney = findViewById(R.id.btnStartTrackingJourney);

        weeklyReport.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),getString(R.string.not_implemented),Toast.LENGTH_LONG).show();
        });

        recordEmission.setOnClickListener(v -> {
            Intent intent = new Intent(DashBoardActivity.this,TransportActivity.class);
            intent.putExtra(getString(R.string.user_name),userName);
            intent.putExtra(getString(R.string.user_email),userEmail);
//            intent.putExtra(getString(R.string.user_data),currentTravelRecord.toString());
            startActivity(intent);
        });

        offsetEmission.setOnClickListener(v -> {
            Intent intentOffset = new Intent(DashBoardActivity.this,OffsetActivity.class);
            intentOffset.putExtra(getString(R.string.user_name),userName);
            intentOffset.putExtra(getString(R.string.user_email),userEmail);
//            intent.putExtra(getString(R.string.user_data),currentTravelRecord.toString());
            startActivity(intentOffset);
        });

        startTrackingJourney.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),getString(R.string.not_implemented),Toast.LENGTH_LONG).show();
        });

        TextView dashWelcomeMsgView = findViewById(R.id.dashWelcomeMsgView);
        String welcomeMsg = getString(R.string.welcome_back) + " " + userName +"!";
        dashWelcomeMsgView.setText(welcomeMsg);

//        MenuItem menuHome = findViewById(R.id.nav_home);
//        MenuItem menuAccount = findViewById(R.id.nav_account);
//        MenuItem menuSettings = findViewById(R.id.nav_settings);
//        MenuItem menuLogout = findViewById(R.id.nav_logout);

        navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
//        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }else{
            super.onBackPressed();
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dash_board, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dash_board);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        drawerLayout = findViewById(R.id.drawer_layout);
        String userName = getIntent().getStringExtra(getString(R.string.user_name));
        String userEmail = getIntent().getStringExtra(getString(R.string.user_email));
        switch (id){
            case R.id.nav_home:
                Toast.makeText(getApplicationContext(),getString(R.string.back_to_dash),Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_account:
                Toast.makeText(getApplicationContext(),getString(R.string.not_implemented),Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_settings:
                Toast.makeText(getApplicationContext(),getString(R.string.locale),Toast.LENGTH_LONG).show();
                Intent IntentLocale = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                IntentLocale.putExtra(getString(R.string.user_name),userName);
                IntentLocale.putExtra(getString(R.string.user_email),userEmail);
//            intent.putExtra(getString(R.string.user_data),currentTravelRecord.toString());
                startActivity(IntentLocale);
                break;
            case R.id.nav_logout:
                Intent intent = new Intent(this, LoginActivity.class);
                intent.putExtra(getString(R.string.user_name),userName);
                intent.putExtra(getString(R.string.user_email),userEmail);
//            intent.putExtra(getString(R.string.user_data),currentTravelRecord.toString());
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}