package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class OffsetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offset);

        Button btnContinueDonation = findViewById(R.id.btnContinueDonation);
        Button btnCancelOffset = findViewById(R.id.btnCancelOffset);
        TextView btnBackOffset = findViewById(R.id.btnBackOffset);
        TextView donationTitleView = findViewById(R.id.donationTitleView);
        TextView donationTextView = findViewById(R.id.donationTextView);
        TextView donationDetailView = findViewById(R.id.donationDetailView);
        RadioGroup rbgroupDonation = findViewById(R.id.rbgroupDonation);

        btnBackOffset.setOnClickListener(v2 -> {
            onBackPressed();
        });

//        if(rbgroupDonation.getCheckedRadioButtonId() == -1){
//            btnContinueDonation.setEnabled(false);
//        }

        rbgroupDonation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {

                    case R.id.rbTree:
                        btnContinueDonation.setEnabled(true);
                        donationTitleView.setVisibility(View.VISIBLE);
                        donationTitleView.setText(R.string.tree_title);
                        donationTextView.setText(R.string.tree_detail);
                        donationDetailView.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rbEnergy:
                        btnContinueDonation.setEnabled(true);
                        donationTitleView.setVisibility(View.VISIBLE);
                        donationTitleView.setText(R.string.energy_title);
                        donationTextView.setText(R.string.energy_detail);
                        donationDetailView.setVisibility(View.VISIBLE);
                        break;

                    case R.id.rbWWF:
                        btnContinueDonation.setEnabled(true);
                        donationTitleView.setVisibility(View.VISIBLE);
                        donationTitleView.setText(R.string.wwf_title);
                        donationTextView.setText(R.string.wwf_detail);
                        donationDetailView.setVisibility(View.VISIBLE);
                }
            }
        });

        donationDetailView.setOnClickListener(v -> {
            int checkedButton = rbgroupDonation.getCheckedRadioButtonId();
            switch (checkedButton) {
                case R.id.rbWWF:
                    Toast.makeText(OffsetActivity.this, "WWF", Toast.LENGTH_LONG);
                    Intent intent1 = new Intent(OffsetActivity.this, DonationWebViewActivity.class);
                    intent1.putExtra("url", getString(R.string.wwf_url));
                    startActivity(intent1);
                    break;
                case R.id.rbTree:
                    Toast.makeText(OffsetActivity.this, "Tree", Toast.LENGTH_LONG);
                    Intent intent2 = new Intent(OffsetActivity.this, DonationWebViewActivity.class);
                    intent2.putExtra("url", getString(R.string.tree_url));
                    startActivity(intent2);
                    break;
                case R.id.rbEnergy:
                    Toast.makeText(OffsetActivity.this, "Energy", Toast.LENGTH_LONG);
                    Intent intent3 = new Intent(OffsetActivity.this, DonationWebViewActivity.class);
                    intent3.putExtra("url", getString(R.string.energy_url));
                    startActivity(intent3);
                    break;
            }
        });

        String userName = getIntent().getStringExtra(getString(R.string.user_name));
        String userEmail = getIntent().getStringExtra(getString(R.string.user_email));
//        String user_data = getIntent().getStringExtra(getString(R.string.user_data));
//        String[] record = user_data.split(",");


        btnContinueDonation.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), getString(R.string.not_implemented), Toast.LENGTH_LONG).show();
        });

        btnCancelOffset.setOnClickListener(v -> {
            Intent intent = new Intent(OffsetActivity.this, DashBoardActivity.class);
            intent.putExtra(getString(R.string.user_name), userName);
            intent.putExtra(getString(R.string.user_email), userEmail);
            startActivity(intent);
        });
    }
}