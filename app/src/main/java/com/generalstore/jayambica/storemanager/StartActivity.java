package com.generalstore.jayambica.storemanager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.generalstore.jayambica.storemanager.Fragments.EntryPinFragment;
import com.generalstore.jayambica.storemanager.Fragments.LoginFragment;

public class StartActivity extends AppCompatActivity {

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EntryPinFragment entryPinFragment = new EntryPinFragment();
        fragmentTransaction.add(R.id.startActivity_main_linearLayout,entryPinFragment,"Tag");
        fragmentTransaction.commit();

    }

    public void onNextClicked(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment = new LoginFragment();
        fragmentTransaction.replace(R.id.startActivity_main_linearLayout,loginFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}
