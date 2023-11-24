package com.loan.emi.loanpro_emicalculator.Activitys;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.loan.emi.loanpro_emicalculator.ADS.AdsManager;
import com.loan.emi.loanpro_emicalculator.ADS.InterstitialAD;
import com.loan.emi.loanpro_emicalculator.ADS.Native;
import com.loan.emi.loanpro_emicalculator.R;
import com.loan.emi.loanpro_emicalculator.databinding.ActivityCcValidatorBinding;

public class CcValidatorActivity extends AppCompatActivity {
    ActivityCcValidatorBinding binding;
    InterstitialAD helper;
    AdsManager adsManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCcValidatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.maincolor));

        showAlertDialog(this);

        adsload();

        binding.imageView7.setOnClickListener(view -> {
            onBackPressed();
        });

        binding.imageView5.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    Intent intent = new Intent(CcValidatorActivity.this, DetailPageActivity.class);
                    intent.putExtra("cnt", 7);
                    startActivity(intent);
                }

                @Override
                public void onInterstitialDismissed() {
                    Intent intent = new Intent(CcValidatorActivity.this, DetailPageActivity.class);
                    intent.putExtra("cnt", 7);
                    startActivity(intent);
                }
            });
        });
        binding.imageView4.setOnClickListener(view -> {

            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    Intent intent = new Intent(CcValidatorActivity.this, DetailPageActivity.class);
                    intent.putExtra("cnt", 7);
                    startActivity(intent);
                }

                @Override
                public void onInterstitialDismissed() {
                    Intent intent = new Intent(CcValidatorActivity.this, DetailPageActivity.class);
                    intent.putExtra("cnt", 7);
                    startActivity(intent);
                }
            });

        });



    }

    private void adsload() {
        Native aNative = new Native(this);
        aNative.ShowNative(this, findViewById(R.id.native_container), 1);

        adsManager = new AdsManager(this);
        helper = new InterstitialAD(this, this, adsManager);
    }

    private void showAlertDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Data Loading..."); // Set your loading message
        progressDialog.setCancelable(false);
        progressDialog.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        },3000);
    }

    @Override
    public void onBackPressed() {
        helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
            @Override
            public void onAdLoadFailed() {
                finish();
            }

            @Override
            public void onInterstitialDismissed() {
                finish();
            }
        });
        super.onBackPressed();
    }
}