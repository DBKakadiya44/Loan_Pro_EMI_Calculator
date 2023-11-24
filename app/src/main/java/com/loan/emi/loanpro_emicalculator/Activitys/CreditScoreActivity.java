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
import com.loan.emi.loanpro_emicalculator.databinding.ActivityCreditScoreBinding;

public class CreditScoreActivity extends AppCompatActivity {
    ActivityCreditScoreBinding binding;
    InterstitialAD helper;
    AdsManager adsManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreditScoreBinding.inflate(getLayoutInflater());
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

        binding.imageView4.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    startActivity(new Intent(CreditScoreActivity.this, CcValidatorActivity.class));
                }

                @Override
                public void onInterstitialDismissed() {
                    startActivity(new Intent(CreditScoreActivity.this, CcValidatorActivity.class));
                }
            });

        });
        binding.imageView6.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    Intent intent = new Intent(CreditScoreActivity.this, DetailPageActivity.class);
                    intent.putExtra("cnt", 8);
                    startActivity(intent);
                }

                @Override
                public void onInterstitialDismissed() {
                    Intent intent = new Intent(CreditScoreActivity.this, DetailPageActivity.class);
                    intent.putExtra("cnt", 8);
                    startActivity(intent);
                }
            });

        });
        binding.imageView5.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    startActivity(new Intent(CreditScoreActivity.this, CcScoreActivity.class));
                }

                @Override
                public void onInterstitialDismissed() {
                    startActivity(new Intent(CreditScoreActivity.this, CcScoreActivity.class));
                }
            });

        });

    }

    private void adsload() {
        Native aNative = new Native(this);
        aNative.ShowNative(this, findViewById(R.id.native_container), 3);

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