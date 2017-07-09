package com.generalstore.jayambica.storemanager.Fragments.HomeActivityFragments;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.generalstore.jayambica.storemanager.CurrentStockActivity;
import com.generalstore.jayambica.storemanager.ExpireItemsActivity;
import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.HomeActivity;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.ShowInvoiceActivity;

public class MainStoreFragment extends Fragment implements View.OnClickListener {

    HomeActivity homeActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        homeActivity = (HomeActivity) getActivity();

        View v = inflater.inflate(R.layout.fragment_main_store, container, false);


        setListeners(v);


        return v;
    }

    private void setListeners(View v) {

        Button currentStockButton = (Button) v.findViewById(R.id.currentStockButton_mainStoreFragment);
        currentStockButton.setOnClickListener(this);

        Button purchaseInvoiceButton = (Button) v.findViewById(R.id.purchaseInvoiceButton_mainStoreFragment);
        purchaseInvoiceButton.setOnClickListener(this);

        Button saleInvoiceButton = (Button) v.findViewById(R.id.saleInvoiceButton_mainStoreFragment);
        saleInvoiceButton.setOnClickListener(this);

        Button expireItemsButton = (Button) v.findViewById(R.id.expireItemsButton_mainStoreFragment);
        expireItemsButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();

        switch (v.getId()) {

            case R.id.currentStockButton_mainStoreFragment: {
                intent.setComponent(new ComponentName(homeActivity, CurrentStockActivity.class));
                intent.putExtra(Constants.INTENT_FROM,
                        Constants.HomeActivity.INTENT_FROM_MAIN_STORE_FRAGMENT);
                break;
            }

            case R.id.purchaseInvoiceButton_mainStoreFragment: {
                intent.setComponent(new ComponentName(homeActivity, ShowInvoiceActivity.class));

                intent.putExtra(Constants.INTENT_FROM,
                        Constants.HomeActivity.INTENT_FROM_MAIN_STORE_FRAGMENT);

                intent.putExtra(Constants.ShowInvoiceActivity.TO_SHOW,
                        Constants.ShowInvoiceActivity.SHOW_PURCHASE_INVOICE);
                break;
            }

            case R.id.saleInvoiceButton_mainStoreFragment: {
                intent.setComponent(new ComponentName(homeActivity, ShowInvoiceActivity.class));

                intent.putExtra(Constants.INTENT_FROM,
                        Constants.HomeActivity.INTENT_FROM_MAIN_STORE_FRAGMENT);

                intent.putExtra(Constants.ShowInvoiceActivity.TO_SHOW,
                        Constants.ShowInvoiceActivity.SHOW_SALE_INVOICE);
                break;
            }

            case R.id.expireItemsButton_mainStoreFragment: {
                intent.setComponent(new ComponentName(homeActivity, ExpireItemsActivity.class));
                intent.putExtra(Constants.INTENT_FROM,
                        Constants.HomeActivity.INTENT_FROM_MAIN_STORE_FRAGMENT);
                break;
            }


        }

        startActivity(intent);
    }
}
