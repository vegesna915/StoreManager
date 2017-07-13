package com.generalstore.jayambica.storemanager;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments.AddItemSettingsActivityFragment;
import com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments.AddVendorSettingsActivityFragment;
import com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments.MainSettingsActivityFragment;
import com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments.ManageItemsSettingsActivityFragment;
import com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments.ManageVendorsSettingsActivityFragment;
import com.generalstore.jayambica.storemanager.Interface.RecyclerView_ManageItems_Interface;
import com.generalstore.jayambica.storemanager.Interface.RecyclerView_ManageVendors_Interface;

public class SettingsActivity extends AppCompatActivity {

    public boolean isAddOrEdit = true;
    public String editId = "";
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String runFragment, contextMenuId;
    RecyclerView_ManageItems_Interface recyclerView_manageItems_interface;
    RecyclerView_ManageVendors_Interface recyclerView_manageVendors_interface;

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

        View v = findViewById(R.id.settingsActivity_main_linearLayout);
        registerForContextMenu(v);


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

        isAddOrEdit = true;

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.settingsActivity_main_linearLayout, new AddItemSettingsActivityFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    public void changeToAddVendorsFragment() {

        isAddOrEdit = true;

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.settingsActivity_main_linearLayout, new AddVendorSettingsActivityFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void changeToEditItemFragment() {

        isAddOrEdit = false;

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.settingsActivity_main_linearLayout, new AddItemSettingsActivityFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void changeToEditVendorFragment() {

        isAddOrEdit = false;

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


    public void contextMenu(View v, String id) {

        contextMenuId = id;
        openContextMenu(v);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (contextMenuId) {
            case "ManageItemsRecyclerView": {
                getMenuInflater().inflate(
                        R.menu.context_menu_manage_items_fragment_settings_activty, menu);
                break;
            }

            case "ManageVendorsRecyclerView": {

                getMenuInflater().inflate(
                        R.menu.context_menu_manage_vendors_fragment_settins_activity, menu);

                break;
            }

        }


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (contextMenuId) {

            case "ManageItemsRecyclerView": {

                this.recyclerView_manageItems_interface.passMenuItem(item);
                break;
            }

            case "ManageVendorsRecyclerView": {

                this.recyclerView_manageVendors_interface.passMenuItem(item);
                break;
            }

        }

        return true;
    }

    public void setRecyclerView_manageItems_interface(RecyclerView_ManageItems_Interface manageItems_interface) {
        this.recyclerView_manageItems_interface = manageItems_interface;
    }

    public void setRecyclerView_manageVendors_interface(RecyclerView_ManageVendors_Interface manageVendors_interface) {
        this.recyclerView_manageVendors_interface = manageVendors_interface;
    }
}
