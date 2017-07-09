package com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.SettingsActivity;

public class ManageItemsSettingsActivityFragment extends Fragment {


    SettingsActivity settingsActivity;
    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        settingsActivity = (SettingsActivity) getActivity();
        if (settingsActivity.getSupportActionBar() != null) {
            settingsActivity.getSupportActionBar().setTitle("Items");
        }


        View v = inflater.inflate(R.layout.fragment_manage_items_settings_activity, container, false);

        fab = (FloatingActionButton) v.findViewById(R.id.fab_addItem_manageItems_settingsActivity);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsActivity.changeToAddItemsFragment();
            }
        });


        return v;
    }

}
