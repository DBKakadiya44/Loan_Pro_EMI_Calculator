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
import com.loan.emi.loanpro_emicalculator.databinding.ActivityPancard3Binding;

public class Pancard3Activity extends AppCompatActivity {
    ActivityPancard3Binding binding;
    InterstitialAD helper;
    AdsManager adsManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPancard3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.maincolor));

        showAlertDialog(this);

        addsload();

        binding.imageView7.setOnClickListener(view -> {
            onBackPressed();
        });

        binding.pan1.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 10);
                    startActivity(intent);
                }

                @Override
                public void onInterstitialDismissed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 10);
                    startActivity(intent);
                }
            });

        });
        binding.pan2.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 11);
                    startActivity(intent);
                }

                @Override
                public void onInterstitialDismissed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 11);
                    startActivity(intent);
                }
            });
        });
        binding.pan3.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 12);
                    startActivity(intent);
                }

                @Override
                public void onInterstitialDismissed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 12);
                    startActivity(intent);
                }
            });
        });
        binding.pan4.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 13);
                    startActivity(intent);
                }

                @Override
                public void onInterstitialDismissed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 13);
                    startActivity(intent);
                }
            });
        });
        binding.pan5.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 14);
                    startActivity(intent);
                }

                @Override
                public void onInterstitialDismissed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 14);
                    startActivity(intent);
                }
            });
        });
        binding.pan6.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 15);
                    startActivity(intent);
                }

                @Override
                public void onInterstitialDismissed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 15);
                    startActivity(intent);
                }
            });
        });
        binding.pan7.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 16);
                    startActivity(intent);
                }

                @Override
                public void onInterstitialDismissed() {
                    Intent intent = new Intent(Pancard3Activity.this, AadharLoanDetailsActivity.class);
                    intent.putExtra("cnt", 16);
                    startActivity(intent);
                }
            });
        });

    }

    private void addsload() {
        Native aNative = new Native(this);
        aNative.ShowNative(this, findViewById(R.id.native_container), 2);

        Native aNative1 = new Native(this);
        aNative1.ShowNative(this, findViewById(R.id.native_container1), 2);

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