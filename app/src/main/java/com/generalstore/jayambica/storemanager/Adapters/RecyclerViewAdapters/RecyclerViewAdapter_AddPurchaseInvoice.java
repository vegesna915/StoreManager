package com.generalstore.jayambica.storemanager.Adapters.RecyclerViewAdapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.generalstore.jayambica.storemanager.Adapters.RecyclerViewAdapters.RecyclerViewAdapter_AddPurchaseInvoice.AddPurchaseInvoice_viewHolder;
import com.generalstore.jayambica.storemanager.AddInvoiceActivity;
import com.generalstore.jayambica.storemanager.Objects.Item;
import com.generalstore.jayambica.storemanager.R;

import java.util.ArrayList;

public class RecyclerViewAdapter_AddPurchaseInvoice extends RecyclerView.Adapter<AddPurchaseInvoice_viewHolder> {

    private AddInvoiceActivity addInvoiceActivity;
    private ArrayList<Item> items;

    public RecyclerViewAdapter_AddPurchaseInvoice(AddInvoiceActivity addInvoiceActivity, ArrayList<Item> items) {
        this.addInvoiceActivity = addInvoiceActivity;
        this.items = items;
    }

    @Override
    public AddPurchaseInvoice_viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(addInvoiceActivity).inflate(
                R.layout.recycler_view_items_list_add_purchase_invoice, parent, false);

        return new AddPurchaseInvoice_viewHolder(v);
    }

    @Override
    public void onBindViewHolder(AddPurchaseInvoice_viewHolder holder, int position) {

        Item item = items.get(position);

        holder.itemNameView.setText(item.getItemName());
        holder.itemBrandView.setText(item.getItemBrandName());
        holder.itemWeightView.setText(item.getItemWeight() + item.getItemWeightUnit());
        holder.itemQtyView.setText("1 x " + item.getItemActualPrice());
        holder.itemTotalPriceView.setText(item.getItemActualPrice());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class AddPurchaseInvoice_viewHolder extends RecyclerView.ViewHolder {

        View v;
        TextView itemNameView, itemBrandView, itemWeightView, itemQtyView, itemTotalPriceView;


        AddPurchaseInvoice_viewHolder(View itemView) {
            super(itemView);

            v = itemView;

            itemNameView = (TextView) v.findViewById(R.id.itemName_recyclerView_addPurchaseInvoice);
            itemBrandView = (TextView) v.findViewById(R.id.itemBrand_recyclerView_addPurchaseInvoice);
            itemWeightView = (TextView) v.findViewById(R.id.itemWeight_recyclerView_addPurchaseInvoice);
            itemQtyView = (TextView) v.findViewById(R.id.itemQty_recyclerView_addPurchaseInvoice);
            itemTotalPriceView = (TextView) v.findViewById(R.id.itemTotalPrice_recyclerView_addPurchaseInvoice);

        }
    }


}
