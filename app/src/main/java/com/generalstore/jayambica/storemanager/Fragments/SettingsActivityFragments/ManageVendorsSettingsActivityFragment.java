package com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.SettingsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManageVendorsSettingsActivityFragment extends Fragment {

    SettingsActivity settingsActivity;
    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        settingsActivity = (SettingsActivity) getActivity();
        if (settingsActivity.getSupportActionBar() != null) {
            settingsActivity.getSupportActionBar().setTitle("Vendors");
        }


        View v = inflater.inflate(R.layout.fragment_manage_vendors_settings_activity, container, false);

        fab = (FloatingActionButton) v.findViewById(R.id.fab_addVendor_manageVendors_settingsActivity);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsActivity.changeToAddVendorsFragment();
            }
        });


        return v;
    }

}
