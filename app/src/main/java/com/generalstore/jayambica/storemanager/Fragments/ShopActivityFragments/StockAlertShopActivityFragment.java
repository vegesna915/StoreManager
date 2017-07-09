package com.generalstore.jayambica.storemanager.Fragments.ShopActivityFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.ShopActivity;

public class StockAlertShopActivityFragment extends Fragment {


    ShopActivity shopActivity;
    String intentFrom;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        shopActivity = (ShopActivity) getActivity();
        intentFrom = shopActivity.getIntent().getStringExtra(Constants.INTENT_FROM);

        View v = inflater.inflate(R.layout.fragment_stock_alert_shop_activity, container, false);

        setActionbarTitle();

        return v;
    }

    private void setActionbarTitle() {

        if (shopActivity.getSupportActionBar() == null) {
            return;
        }

        shopActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        shopActivity.setTitle("Stock Alert - " + intentFrom);

    }
}
