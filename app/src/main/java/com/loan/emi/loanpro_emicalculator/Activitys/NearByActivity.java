package com.loan.emi.loanpro_emicalculator.Activitys;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.loan.emi.loanpro_emicalculator.ADS.AdsManager;
import com.loan.emi.loanpro_emicalculator.ADS.InterstitialAD;
import com.loan.emi.loanpro_emicalculator.ADS.Native;
import com.loan.emi.loanpro_emicalculator.R;
import com.loan.emi.loanpro_emicalculator.databinding.ActivityNearByBinding;

public class NearByActivity extends AppCompatActivity {
    ActivityNearByBinding binding;
    InterstitialAD helper;
    AdsManager adsManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNearByBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.maincolor));

        showAlertDialog(this);

        adsload();

        adsManager = new AdsManager(this);
        helper = new InterstitialAD(this, this, adsManager);

        binding.imageView7.setOnClickListener(view -> {
            onBackPressed();
        });



        binding.near4.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Delivery");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Delivery");
                }
            });
        });

        binding.near5.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("ATM");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("ATM");
                }
            });
        });

        binding.near6.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Bank");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Bank");
                }
            });
        });
        binding.near1.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Restaurants");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Restaurants");
                }
            });
        });

        binding.near2.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Bars");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Bars");
                }
            });
        });

        binding.near3.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Coffee");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Coffee");
                }
            });
        });
        binding.near7.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Hospitals");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Hospitals");
                }
            });
        });

        binding.near8.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Beauty Salons");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Beauty Salons");
                }
            });
        });



        binding.near12.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Book Store");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Book Store");
                }
            });
        });

        binding.near13.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Clothes");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Clothes");
                }
            });
        });

        binding.near14.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Car Dealers");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Car Dealers");
                }
            });
        });
        binding.near9.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Park");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Park");
                }
            });
        });

        binding.near10.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Art");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Art");
                }
            });
        });

        binding.near11.setOnClickListener(view -> {
            helper.showCounterInterstitialAd(new InterstitialAD.AdLoadListeners() {
                @Override
                public void onAdLoadFailed() {
                    gmap("Gyms");
                }

                @Override
                public void onInterstitialDismissed() {
                    gmap("Gyms");
                }
            });
        });
    }

    private void adsload() {
        Native aNative = new Native(this);
        aNative.ShowNative(this, findViewById(R.id.native_container), 1);

        Native aNative1 = new Native(this);
        aNative1.ShowNative(this, findViewById(R.id.native_container1), 2);
    }

    private void gmap(String i)
    {
        String locationToSearch = i;

        // Create an intent with the action and the URI for Google Maps
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + locationToSearch);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        // Set the package to ensure only the Google Maps app is opened
        mapIntent.setPackage("com.google.android.apps.maps");

        // Check if the Google Maps app is installed
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            // Start the activity
            startActivity(mapIntent);
        } else {
            // If Google Maps app is not installed, you can open the browser
            // with the Google Maps website or prompt the user to install the app.
            // For simplicity, we'll just log a message in this example.
            // You can customize this part based on your app's requirements.
             Log.d("MainActivity", "Google Maps app not installed");
        }
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
        },5000);
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