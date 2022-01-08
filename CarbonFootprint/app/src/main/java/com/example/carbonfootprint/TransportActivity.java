package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TransportActivity extends AppCompatActivity {
    private String selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        Button continue_record = findViewById(R.id.button_transport_continue);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        if(radioGroup.getCheckedRadioButtonId() == -1){
            continue_record.setEnabled(false);
        }
        RadioButton rbTrain = findViewById(R.id.rbTrain);
        RadioButton rbBus = findViewById(R.id.rbBus);
        RadioButton rbCar = findViewById(R.id.rbCar);
        RadioButton rbMotorcycle = findViewById(R.id.rbMotorcycle);
        RadioButton rbBicycle = findViewById(R.id.rbBicycle);
        rbTrain.setOnClickListener(v -> {
            continue_record.setEnabled(true);
            selection = getString(R.string.train);
            TransportActivity.this.setSelection(selection);
        });
        rbBus.setOnClickListener(v -> {
            continue_record.setEnabled(true);
            selection = getString(R.string.bus);
            TransportActivity.this.setSelection(selection);
        });
        rbCar.setOnClickListener(v -> {
            continue_record.setEnabled(true);
            selection = getString(R.string.car);
            TransportActivity.this.setSelection(selection);
        });
        rbMotorcycle.setOnClickListener(v -> {
            continue_record.setEnabled(true);
            selection = getString(R.string.motorcycle);
            TransportActivity.this.setSelection(selection);
        });
        rbBicycle.setOnClickListener(v -> {
            continue_record.setEnabled(true);
            selection = getString(R.string.bicycle);
            TransportActivity.this.setSelection(selection);
        });

        String userName = getIntent().getStringExtra(getString(R.string.user_name));
        String userEmail = getIntent().getStringExtra(getString(R.string.user_email));
//        String user_data = getIntent().getStringExtra(getString(R.string.user_data));
//        String[] record = user_data.split(",");
//        record[0] = userName;
//        record[1] = userEmail;
//        record[2] = selection;


        continue_record.setOnClickListener(v -> {
            Intent intent = new Intent(TransportActivity.this, PickDateActivity.class);
            intent.putExtra(getString(R.string.user_name),userName);
            intent.putExtra(getString(R.string.user_email),userEmail);
//            intent.putExtra(getString(R.string.user_data),record.toString());
            startActivity(intent);
        });

        TextView btnBackTransport = findViewById(R.id.btnBackTransport);
        btnBackTransport.setOnClickListener(v->{
            onBackPressed();
        });

        Button btnCancelTransport = findViewById(R.id.btnCancelTransport);
        btnCancelTransport.setOnClickListener(v->{
            Intent intent = new Intent(TransportActivity.this, DashBoardActivity.class);
            intent.putExtra(getString(R.string.user_name),userName);
            intent.putExtra(getString(R.string.user_email),userEmail);
            startActivity(intent);
        });
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }
}