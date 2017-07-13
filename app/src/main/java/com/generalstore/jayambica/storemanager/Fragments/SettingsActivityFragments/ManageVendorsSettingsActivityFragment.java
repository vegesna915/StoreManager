package com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.generalstore.jayambica.storemanager.Adapters.RecyclerViewAdapters.RecyclerViewAdapter_ManageVendorsFragment;
import com.generalstore.jayambica.storemanager.Database.VendorsDb;
import com.generalstore.jayambica.storemanager.Objects.Vendor;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.SettingsActivity;

import java.util.ArrayList;

public class ManageVendorsSettingsActivityFragment extends Fragment {

    SettingsActivity settingsActivity;
    ArrayList<Vendor> vendors = new ArrayList<>();
    RecyclerViewAdapter_ManageVendorsFragment adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        settingsActivity = (SettingsActivity) getActivity();
        if (settingsActivity.getSupportActionBar() != null) {
            settingsActivity.getSupportActionBar().setTitle("Vendors");
        }


        View v = inflater.inflate(R.layout.fragment_manage_vendors_settings_activity, container, false);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab_addVendor_manageVendors_settingsActivity);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsActivity.changeToAddVendorsFragment();
            }
        });

        setRecyclerView(v);

        return v;
    }

    private void setRecyclerView(View v) {

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_mangeVendorsFragment_SettingsActivity);

        adapter = new
                RecyclerViewAdapter_ManageVendorsFragment(getActivity(), vendors);

        recyclerView.setLayoutManager(new LinearLayoutManager(settingsActivity));

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();

        refreshVendors();
        adapter.notifyDataSetChanged();

    }

    private void refreshVendors() {

        VendorsDb vendorsDb = new VendorsDb(settingsActivity);

        vendors.clear();
        vendors.addAll(vendorsDb.getAllVendors());

    }
}
