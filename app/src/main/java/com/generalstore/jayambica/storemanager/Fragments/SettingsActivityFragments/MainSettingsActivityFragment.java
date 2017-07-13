package com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.SettingsActivity;
import com.generalstore.jayambica.storemanager.StartActivity;

public class MainSettingsActivityFragment extends Fragment implements View.OnClickListener {


    SettingsActivity settingsActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        settingsActivity = (SettingsActivity) getActivity();

        if (settingsActivity.getSupportActionBar() != null) {
            settingsActivity.getSupportActionBar().setTitle("Settings");
        }


        View v = inflater.inflate(R.layout.fragment_main_settings_activity, container, false);

        registerForContextMenu(v);

        setListeners(v);

        return v;
    }

    private void setListeners(View v) {

        Button changePinButton = (Button) v.findViewById(R.id.changePinButton_SettingsActivity);
        changePinButton.setOnClickListener(this);

        Button manageItemButton = (Button) v.findViewById(R.id.manageItemsButton_SettingsActivity);
        manageItemButton.setOnClickListener(this);

        Button manageVendors = (Button) v.findViewById(R.id.manageVendorButton_SettingsActivity);
        manageVendors.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.changePinButton_SettingsActivity: {

                Intent toStartActivity = new Intent(settingsActivity, StartActivity.class);

                toStartActivity.putExtra(Constants.INTENT_FROM, Constants.StartActivity.INTENT_FROM_SETTINGS);
                startActivity(toStartActivity);

                break;
            }
            case R.id.manageItemsButton_SettingsActivity: {

                settingsActivity.changeToManageItemsFragment();

                break;
            }
            case R.id.manageVendorButton_SettingsActivity: {

                settingsActivity.changeToManageVendorsFragment();

                break;
            }

        }


    }


}
