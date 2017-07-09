package com.generalstore.jayambica.storemanager.Fragments.ShopActivityFragments;


import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.generalstore.jayambica.storemanager.CurrentStockActivity;
import com.generalstore.jayambica.storemanager.ExpireItemsActivity;
import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.ShopActivity;
import com.generalstore.jayambica.storemanager.ShowInvoiceActivity;

public class MainShopActivityFragment extends Fragment implements View.OnClickListener {


    ShopActivity shopActivity;
    String intentFrom;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        shopActivity = (ShopActivity) getActivity();
        intentFrom = shopActivity.getIntent().getStringExtra(Constants.INTENT_FROM);


        View v = inflater.inflate(R.layout.fragment_main_shop_activity, container, false);

        setActionbarTitle();

        setListeners(v);

        return v;
    }

    private void setListeners(View v) {

        Button shop1Button = (Button) v.findViewById(R.id.currentStockButton_mainFragment_shopActivity);
        shop1Button.setOnClickListener(this);

        Button shop2Button = (Button) v.findViewById(R.id.purchaseInvoiceButton_mainFragment_shopActivity);
        shop2Button.setOnClickListener(this);

        Button shop3Button = (Button) v.findViewById(R.id.salesPerDayButton_mainFragment_shopActivity);
        shop3Button.setOnClickListener(this);

        Button shop4Button = (Button) v.findViewById(R.id.stockAlertButton_mainFragment_shopActivity);
        shop4Button.setOnClickListener(this);

        Button shop5Button = (Button) v.findViewById(R.id.expireItemsButton_mainFragment_shopActivity);
        shop5Button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();

        switch (v.getId()) {

            case R.id.currentStockButton_mainFragment_shopActivity: {
                intent.setComponent(new ComponentName(shopActivity, CurrentStockActivity.class));

                intent.putExtra(Constants.INTENT_FROM, intentFrom);

                startActivity(intent);
                break;
            }

            case R.id.purchaseInvoiceButton_mainFragment_shopActivity: {
                intent.setComponent(new ComponentName(shopActivity, ShowInvoiceActivity.class));

                intent.putExtra(Constants.ShowInvoiceActivity.TO_SHOW,
                        Constants.ShowInvoiceActivity.SHOW_PURCHASE_INVOICE);
                intent.putExtra(Constants.INTENT_FROM, intentFrom);

                startActivity(intent);
                break;
            }

            case R.id.salesPerDayButton_mainFragment_shopActivity: {

                shopActivity.openSalesFragment();

                break;
            }

            case R.id.stockAlertButton_mainFragment_shopActivity: {

                shopActivity.openStockAlertFragment();

                break;
            }

            case R.id.expireItemsButton_mainFragment_shopActivity: {
                intent.setComponent(new ComponentName(shopActivity, ExpireItemsActivity.class));

                intent.putExtra(Constants.INTENT_FROM, intentFrom);

                startActivity(intent);
                break;
            }

        }

    }

    private void setActionbarTitle() {

        if (shopActivity.getSupportActionBar() == null) {
            return;
        }


        shopActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        shopActivity.setTitle(intentFrom);


    }

}
