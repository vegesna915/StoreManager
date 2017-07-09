package com.generalstore.jayambica.storemanager;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.Fragments.AddInvoiceFragments.AddPurchaseInvoiceFragment;
import com.generalstore.jayambica.storemanager.Fragments.AddInvoiceFragments.AddSaleInvoiceFragment;

public class AddInvoiceActivity extends AppCompatActivity {

    String intentFrom;
    String toAdd;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_invoice);


        intentFrom = getIntent().getStringExtra(Constants.INTENT_FROM);
        toAdd = getIntent().getStringExtra(Constants.AddInvoiceActivity.TO_ADD);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_addInvoiceActivity);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        fragmentManager = getSupportFragmentManager();

        setFragment();

    }

    private void setFragment() {

        fragmentTransaction = fragmentManager.beginTransaction();

        switch (toAdd) {

            case Constants.AddInvoiceActivity.ADD_PURCHASE_INVOICE: {

                fragmentTransaction.add(R.id.addInvoiceActivity_main_linearLayout, new AddPurchaseInvoiceFragment());

                break;
            }

            case Constants.AddInvoiceActivity.ADD_SALE_INVOICE: {

                fragmentTransaction.add(R.id.addInvoiceActivity_main_linearLayout, new AddSaleInvoiceFragment());

                break;
            }

        }

        fragmentTransaction.commit();


    }
}
