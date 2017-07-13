package com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.generalstore.jayambica.storemanager.Adapters.RecyclerViewAdapters.RecycleViewAdapter_ManageItemsFragment;
import com.generalstore.jayambica.storemanager.Database.ItemsDb;
import com.generalstore.jayambica.storemanager.Objects.Item;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.SettingsActivity;

import java.util.ArrayList;

public class ManageItemsSettingsActivityFragment extends Fragment {


    SettingsActivity settingsActivity;
    FloatingActionButton fab;
    ArrayList<Item> items = new ArrayList<>();
    RecycleViewAdapter_ManageItemsFragment adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        settingsActivity = (SettingsActivity) getActivity();
        if (settingsActivity.getSupportActionBar() != null) {
            settingsActivity.getSupportActionBar().setTitle("Items");
        }

        View v = inflater.inflate(R.layout.fragment_manage_items_settings_activity, container, false);

        setRecyclerView(v);

        fab = (FloatingActionButton) v.findViewById(R.id.fab_addItem_manageItemsFragment_settingsActivity);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsActivity.changeToAddItemsFragment();
            }
        });

        return v;
    }

    private void setRecyclerView(View v) {


        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_mangeItemsFragment_SettingsActivity);
        adapter = new RecycleViewAdapter_ManageItemsFragment(getActivity(), items);

        LinearLayoutManager linearLayoutmanager = new LinearLayoutManager(settingsActivity);

        recyclerView.setLayoutManager(linearLayoutmanager);
        recyclerView.setAdapter(adapter);


    }

    private void getItems() {

        ItemsDb itemDb = new ItemsDb(settingsActivity);
        items.clear();
        items.addAll(itemDb.getAllItems());

    }

    @Override
    public void onResume() {
        super.onResume();

        refreshItems();

    }

    public void refreshItems() {

        getItems();
        adapter.notifyDataSetChanged();
    }




}
