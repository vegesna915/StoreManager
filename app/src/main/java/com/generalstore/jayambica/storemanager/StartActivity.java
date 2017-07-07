package com.generalstore.jayambica.storemanager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.Fragments.EntryPinFragment;
import com.generalstore.jayambica.storemanager.Fragments.LoginFragment;
import com.generalstore.jayambica.storemanager.Fragments.SetPinFragment;

public class StartActivity extends AppCompatActivity {

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        SharedPreferences sharedPref = getSharedPreferences(
                Constants.SharedPreference.SHARED_PREFERENCE, Context.MODE_PRIVATE);

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (sharedPref.getBoolean(Constants.SharedPreference.IS_LOGIN, false)) {

            EntryPinFragment entryPinFragment = new EntryPinFragment();
            fragmentTransaction.add(R.id.startActivity_main_linearLayout, entryPinFragment, "Tag");

        } else {

            LoginFragment loginFragment = new LoginFragment();
            fragmentTransaction.add(R.id.startActivity_main_linearLayout, loginFragment, "Tag");

        }

        fragmentTransaction.commit();


    }

    public void changeFragmentToLogin() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        fragmentTransaction.replace(R.id.startActivity_main_linearLayout, loginFragment);
        fragmentTransaction.commit();
    }

    public void changeFragmentToSetPin() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SetPinFragment setPinFragment = new SetPinFragment();
        fragmentTransaction.replace(R.id.startActivity_main_linearLayout, setPinFragment);
        fragmentTransaction.commit();
    }


}
