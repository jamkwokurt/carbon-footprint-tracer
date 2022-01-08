package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Date;

public class PickDateActivity extends AppCompatActivity {

    DatePicker datePicker;
    Button buttonGetDate,btnContinueToTime;
    TextView resultView;
    Date date_selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_date);
        btnContinueToTime = (Button)findViewById(R.id.btnContinueToTime);
        btnContinueToTime.setEnabled(false);
        resultView=(TextView)findViewById(R.id.resultView);
        datePicker =(DatePicker)findViewById(R.id.datePicker);
        buttonGetDate =(Button)findViewById(R.id.buttonSelectDate);

        buttonGetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnContinueToTime.setEnabled(true);
                resultView.setText(getString(R.string.selected_date)+ datePicker.getDayOfMonth()+"/"+ (datePicker.getMonth() + 1)+"/"+ datePicker.getYear());
            }
        });

        String userName = getIntent().getStringExtra(getString(R.string.user_name));
        String userEmail = getIntent().getStringExtra(getString(R.string.user_email));
//        String user_data = getIntent().getStringExtra(getString(R.string.user_data));
//        String[]record = user_data.split(",");
//        record[3] = datePicker.getDayOfMonth()+"/"+ (datePicker.getMonth() + 1)+"/"+ datePicker.getYear();

        btnContinueToTime.setOnClickListener(v->{
            Intent intent = new Intent(PickDateActivity.this, PickTimeActivity.class);
            intent.putExtra(getString(R.string.user_name),userName);
            intent.putExtra(getString(R.string.user_email),userEmail);
//            intent.putExtra(getString(R.string.user_data),record.toString());
            startActivity(intent);
        });

        TextView btnBackDate = findViewById(R.id.btnBackDate);
        btnBackDate.setOnClickListener(v->{
            onBackPressed();
        });

        Button btnCancelDate = findViewById(R.id.btnCancelDate);
        btnCancelDate.setOnClickListener(v->{
            Intent intent = new Intent(PickDateActivity.this, DashBoardActivity.class);
            intent.putExtra(getString(R.string.user_name),userName);
            intent.putExtra(getString(R.string.user_email),userEmail);
            startActivity(intent);
        });
    }
}
