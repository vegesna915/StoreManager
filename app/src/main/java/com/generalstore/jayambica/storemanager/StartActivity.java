package com.generalstore.jayambica.storemanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.Fragments.StartActivityFragments.EntryPinFragment;
import com.generalstore.jayambica.storemanager.Fragments.StartActivityFragments.LoginFragment;
import com.generalstore.jayambica.storemanager.Fragments.StartActivityFragments.SetPinFragment;

public class StartActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        sharedPref = getSharedPreferences(
                Constants.SharedPreference.SHARED_PREFERENCE, Context.MODE_PRIVATE);

        setFragment();

    }

    void setFragment() {

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (sharedPref.getBoolean(Constants.SharedPreference.IS_LOGIN, false)) {


            String intentFrom = getIntent().getStringExtra(Constants.INTENT_FROM);

            if (intentFrom != null && intentFrom.equals(Constants.StartActivity.INTENT_FROM_SETTINGS)) {
                fragmentTransaction.add(R.id.startActivity_main_linearLayout, new SetPinFragment());
            } else {

                fragmentTransaction.add(R.id.startActivity_main_linearLayout, new EntryPinFragment());
            }
        } else {

            fragmentTransaction.add(R.id.startActivity_main_linearLayout, new LoginFragment());

        }

        fragmentTransaction.commit();
    }

    public void changeFragmentToLogin() {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.startActivity_main_linearLayout, new LoginFragment());
        fragmentTransaction.commit();

    }

    public void changeFragmentToSetPin() {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.startActivity_main_linearLayout, new SetPinFragment());
        fragmentTransaction.commit();

    }


}
