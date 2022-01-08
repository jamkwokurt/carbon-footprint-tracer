package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SaveJourneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_journey);

        String userName = getIntent().getStringExtra(getString(R.string.user_name));
        String userEmail = getIntent().getStringExtra(getString(R.string.user_email));
//        String user_data = getIntent().getStringExtra(getString(R.string.user_data));
//        String[]record = user_data.split(",");

        TextView fpConfirmationTextView = findViewById(R.id.fpConfirmationTextView);
        String confirmationMsg = getString(R.string.confirmation) + "\n"
//                + user_data
                ;
        fpConfirmationTextView.setText(confirmationMsg);

        TextView btnBackConfirmation = findViewById(R.id.btnBackConfirmation);
        btnBackConfirmation.setOnClickListener(v -> {
            onBackPressed();
        });

        Button btnBackToDashboard = findViewById(R.id.btnBackToDashboard);
        btnBackToDashboard.setOnClickListener(v->{
            Intent intent = new Intent(SaveJourneyActivity.this, DashBoardActivity.class);
            intent.putExtra(getString(R.string.user_name),userName);
            intent.putExtra(getString(R.string.user_email),userEmail);
            startActivity(intent);
        });
    }
}