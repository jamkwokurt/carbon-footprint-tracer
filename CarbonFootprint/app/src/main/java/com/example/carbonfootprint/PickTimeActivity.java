package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class PickTimeActivity extends AppCompatActivity {
    TimePicker timePicker;
    Button buttonGetTime, submit;
    TextView resultView;
    int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_time);

        timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        buttonGetTime = findViewById(R.id.buttonGetTime);
        submit = findViewById(R.id.btnSubmit);
        submit.setEnabled(false);
        resultView = findViewById(R.id.resultView);

        if (Build.VERSION.SDK_INT >= 23 ){
            hour = timePicker.getHour();
            minute = timePicker.getMinute();
        }
        else{
            hour = timePicker.getCurrentHour();
            minute = timePicker.getCurrentMinute();
        }

        buttonGetTime.setOnClickListener(v->{
            submit.setEnabled(true);
            resultView.setText(getString(R.string.total_time)+ " "+ hour + " "+ getString(R.string.hours) + " " + minute + " " + getString(R.string.minutes));
        });

        String userName = getIntent().getStringExtra(getString(R.string.user_name));
        String userEmail = getIntent().getStringExtra(getString(R.string.user_email));
//        String user_data = getIntent().getStringExtra(getString(R.string.user_data));
//        String[]record = user_data.split(",");
//        record[4] = hour + " : " + minute;

        submit.setOnClickListener(v1->{
            Intent intent = new Intent(PickTimeActivity.this, SaveJourneyActivity.class);
            intent.putExtra(getString(R.string.user_name),userName);
            intent.putExtra(getString(R.string.user_email),userEmail);
//            intent.putExtra(getString(R.string.user_data),record.toString());
            startActivity(intent);
        });

        TextView btnBackTime = findViewById(R.id.btnBackTime);
        btnBackTime.setOnClickListener(v->{
            onBackPressed();
        });

        Button btnCancelTime = findViewById(R.id.btnCancelTime);
        btnCancelTime.setOnClickListener(v->{
            Intent intent = new Intent(PickTimeActivity.this, DashBoardActivity.class);
            intent.putExtra(getString(R.string.user_name),userName);
            intent.putExtra(getString(R.string.user_email),userEmail);
            startActivity(intent);
        });

    }

    public void getResults(int hour, int minute) {

    }

}