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

import com.generalstore.jayambica.storemanager.Adapters.RecyclerViewAdapters.RecycleViewAdapter_ManageItemsFragment.ManageItemsViewHolder;
import com.generalstore.jayambica.storemanager.Database.ItemsDb;
import com.generalstore.jayambica.storemanager.Interface.RecyclerView_ManageItems_Interface;
import com.generalstore.jayambica.storemanager.Objects.Item;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.SettingsActivity;

import java.util.ArrayList;

public class RecycleViewAdapter_ManageItemsFragment extends RecyclerView.Adapter<ManageItemsViewHolder> {

    private SettingsActivity settingsActivity;
    private ArrayList<Item> items;
    private int longClickPosition;

    public RecycleViewAdapter_ManageItemsFragment(Activity activity, ArrayList<Item> items) {
        this.settingsActivity = (SettingsActivity) activity;
        this.items = items;


        this.settingsActivity.setRecyclerView_manageItems_interface(new RecyclerView_ManageItems_Interface() {

            @Override
            public void passMenuItem(MenuItem menuItem) {
                onClickContextMenuItem(menuItem);
            }

        });


    }

    @Override
    public ManageItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(settingsActivity).inflate(
                R.layout.recycler_view_item_manage_item_fragment, parent, false);

        return new ManageItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ManageItemsViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        Item item = items.get(position);

        holder.itemName.setText(item.getItemName() + " " + item.getItemBrandName());
        holder.itemPrice.setText(item.getItemPrice());
        holder.itemWeight.setText(item.getItemWeight() + item.getItemWeightUnit());


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsActivity.editId = items.get(position).getItemCode();
                settingsActivity.changeToEditItemFragment();
            }
        });

        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                longClickPosition = position;
                settingsActivity.contextMenu(v, "ManageItemsRecyclerView");

                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void onClickContextMenuItem(MenuItem menuItem) {
        switch (menuItem.getTitle().toString()) {

            case "Edit": {

                settingsActivity.editId = items.get(longClickPosition).getItemCode();
                settingsActivity.changeToEditItemFragment();

                break;
            }

            case "Remove": {

                ItemsDb itemDb = new ItemsDb(settingsActivity);
                boolean isDeleted = itemDb.deleteItemById(items.get(longClickPosition).getItemCode());

                if (isDeleted) {

                    items.remove(longClickPosition);
                    notifyDataSetChanged();

                    Toast.makeText(settingsActivity, "Item removed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(settingsActivity, "Failed to remove item", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    class ManageItemsViewHolder extends RecyclerView.ViewHolder {

        View view;
        TextView itemName, itemWeight, itemPrice;

        ManageItemsViewHolder(View v) {
            super(v);

            view = v;

            itemName = (TextView) v.findViewById(R.id.itemName_recyclerView_manageItemFragment);
            itemPrice = (TextView) v.findViewById(R.id.itemPrice_recyclerView_manageItemFragment);
            itemWeight = (TextView) v.findViewById(R.id.itemWeight_recyclerView_manageItemFragment);

        }
    }


}
