package com.generalstore.jayambica.storemanager.Adapters.RecyclerViewAdapters;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.generalstore.jayambica.storemanager.Adapters.RecyclerViewAdapters.RecyclerViewAdapter_ManageVendorsFragment.ManageVendorsViewHolder;
import com.generalstore.jayambica.storemanager.Database.VendorsDb;
import com.generalstore.jayambica.storemanager.Interface.RecyclerView_ManageVendors_Interface;
import com.generalstore.jayambica.storemanager.Objects.Vendor;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.SettingsActivity;

import java.util.ArrayList;

public class RecyclerViewAdapter_ManageVendorsFragment extends RecyclerView.Adapter<ManageVendorsViewHolder> {

    private SettingsActivity settingsActivity;
    private ArrayList<Vendor> vendors;
    private int longClickPosition;

    public RecyclerViewAdapter_ManageVendorsFragment(Activity activity, ArrayList<Vendor> vendors) {
        this.settingsActivity = (SettingsActivity) activity;
        this.vendors = vendors;

        this.settingsActivity.setRecyclerView_manageVendors_interface(new RecyclerView_ManageVendors_Interface() {
            @Override
            public void passMenuItem(MenuItem menuItem) {
                onClickContextMenuItem(menuItem);
            }
        });
    }

    @Override
    public ManageVendorsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(settingsActivity).inflate(
                R.layout.recycler_view_vendor_manage_vendor_fragment, parent, false);

        return new ManageVendorsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ManageVendorsViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        Vendor vendor = vendors.get(position);

        holder.vendorNameView.setText(vendor.getVendorName());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsActivity.editId = vendors.get(longClickPosition).getVendorId();
                settingsActivity.changeToEditVendorFragment();
            }
        });

        holder.v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                longClickPosition = position;
                settingsActivity.contextMenu(v, "ManageVendorsRecyclerView");

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return vendors.size();
    }

    private void onClickContextMenuItem(MenuItem menuItem) {
        switch (menuItem.getTitle().toString()) {

            case "Edit": {

                settingsActivity.editId = vendors.get(longClickPosition).getVendorId();
                settingsActivity.changeToEditVendorFragment();

                break;
            }

            case "Remove": {

                VendorsDb vendorsDb = new VendorsDb(settingsActivity);
                boolean isDeleted = vendorsDb.deleteVendorById(vendors.get(longClickPosition).getVendorId());

                if (isDeleted) {

                    vendors.remove(longClickPosition);
                    notifyDataSetChanged();

                    Toast.makeText(settingsActivity, "Vendor removed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(settingsActivity, "Failed to remove Vendor", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }

    }

    class ManageVendorsViewHolder extends RecyclerView.ViewHolder {

        public View v;
        private TextView vendorNameView;

        ManageVendorsViewHolder(View itemView) {
            super(itemView);

            v = itemView;

            vendorNameView = (TextView) v.findViewById(R.id.vendorName_recyclerView_manageVendorFragment);

        }
    }
}
