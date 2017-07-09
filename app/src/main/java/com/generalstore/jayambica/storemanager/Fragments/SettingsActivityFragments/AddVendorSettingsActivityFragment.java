package com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.SettingsActivity;

public class AddVendorSettingsActivityFragment extends Fragment {


    SettingsActivity settingsActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        settingsActivity = (SettingsActivity) getActivity();

        View v = inflater.inflate(R.layout.fragment_add_vendor_settings_activity, container, false);

        if (settingsActivity.getSupportActionBar() != null) {

            settingsActivity.getSupportActionBar().setTitle("Add vendor");

        }


        return v;
    }

}
