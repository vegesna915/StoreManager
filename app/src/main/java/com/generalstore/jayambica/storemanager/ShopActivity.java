package com.generalstore.jayambica.storemanager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.Fragments.ShopActivityFragments.MainShopActivityFragment;
import com.generalstore.jayambica.storemanager.Fragments.ShopActivityFragments.SalesFragment;
import com.generalstore.jayambica.storemanager.Fragments.ShopActivityFragments.StockAlertShopActivityFragment;

public class ShopActivity extends AppCompatActivity {

    String intentFrom;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        intentFrom = getIntent().getStringExtra(Constants.INTENT_FROM);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_shopActivity);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();
        setFragment();

    }

    private void setFragment() {

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.shopActivity_main_linearLayout, new MainShopActivityFragment());

        fragmentTransaction.commit();

    }

    public void openSalesFragment() {

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.shopActivity_main_linearLayout, new SalesFragment());
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();

    }

    public void openStockAlertFragment() {

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.shopActivity_main_linearLayout, new StockAlertShopActivityFragment());
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home: {
                onBackPressed();
            }

        }

        return true;
    }


}
