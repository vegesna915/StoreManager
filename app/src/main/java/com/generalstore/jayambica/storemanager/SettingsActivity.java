package com.generalstore.jayambica.storemanager;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments.AddItemSettingsActivityFragment;
import com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments.AddVendorSettingsActivityFragment;
import com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments.MainSettingsActivityFragment;
import com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments.ManageItemsSettingsActivityFragment;
import com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments.ManageVendorsSettingsActivityFragment;

public class SettingsActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String runFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_settingsActivity);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        runFragment = getIntent().getStringExtra(Constants.SettingsActivity.FRAGMENT_SETTING_ACTIVITY);

        fragmentManager = getSupportFragmentManager();
        setFragment();


    }

    void setFragment() {

        fragmentTransaction = fragmentManager.beginTransaction();

        switch (runFragment) {

            case Constants.SettingsActivity.DEFAULT_SETTINGS_ACTIVITY: {
                fragmentTransaction.add(R.id.settingsActivity_main_linearLayout, new MainSettingsActivityFragment());
                break;
            }
            case Constants.SettingsActivity.ADD_ITEM_SETTINGS_ACTIVITY: {
                fragmentTransaction.add(R.id.settingsActivity_main_linearLayout, new AddItemSettingsActivityFragment());
                break;
            }
            case Constants.SettingsActivity.ADD_VENDOR_SETTINGS_ACTIVITY: {
                fragmentTransaction.add(R.id.settingsActivity_main_linearLayout, new AddVendorSettingsActivityFragment());
                break;
            }
        }

        fragmentTransaction.commit();
    }


    public void changeToManageItemsFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.settingsActivity_main_linearLayout, new ManageItemsSettingsActivityFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void changeToManageVendorsFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.settingsActivity_main_linearLayout, new ManageVendorsSettingsActivityFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void changeToAddItemsFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.settingsActivity_main_linearLayout, new AddItemSettingsActivityFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void changeToAddVendorsFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.settingsActivity_main_linearLayout, new AddVendorSettingsActivityFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home: {
                onBackPressed();
                break;
            }

        }
        return true;
    }
}
