package com.generalstore.jayambica.storemanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.generalstore.jayambica.storemanager.Adapters.FragmentAdapters.FragmentAdapter_ShowInvoice;
import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.Fragments.ShowInvoiceFragments.PurchaseInvoiceShowFragment;
import com.generalstore.jayambica.storemanager.Fragments.ShowInvoiceFragments.SaleInvoiceShowFragment;

import java.util.ArrayList;

public class ShowInvoiceActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    FloatingActionButton fab;
    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();

    String intentFrom;
    String toShow;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_invoice);

        sharedPref = getSharedPreferences(Constants.SharedPreference.SHARED_PREFERENCE, Context.MODE_PRIVATE);

        intentFrom = getIntent().getStringExtra(Constants.INTENT_FROM);
        toShow = getIntent().getStringExtra(Constants.ShowInvoiceActivity.TO_SHOW);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_showInvoiceActivity);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Invoice - " + intentFrom);

        }

        viewPager = (ViewPager) findViewById(R.id.viewPager_showInvoiceActivity);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout_showInvoiceActivity);
        fab = (FloatingActionButton) findViewById(R.id.fab_showInvoiceActivity);

        setViewPager();
        setFab();

    }

    private void setFab() {

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ShowInvoiceActivity.this, AddInvoiceActivity.class);
                intent.putExtra(Constants.INTENT_FROM, intentFrom);
                switch (viewPager.getCurrentItem()) {
                    case 0: {//Purchase invoice
                        intent.putExtra(Constants.AddInvoiceActivity.TO_ADD,
                                Constants.AddInvoiceActivity.ADD_PURCHASE_INVOICE);

                        break;
                    }
                    case 1: {//Sale invoice
                        intent.putExtra(Constants.AddInvoiceActivity.TO_ADD,
                                Constants.AddInvoiceActivity.ADD_SALE_INVOICE);
                        break;
                    }

                }

                startActivity(intent);
            }
        });

    }

    private void setViewPager() {

        fragments.add(new PurchaseInvoiceShowFragment());
        fragments.add(new SaleInvoiceShowFragment());

        titles.add("Purchase invoice");
        titles.add("Sale invoice");

        FragmentAdapter_ShowInvoice adapter_showInvoice = new FragmentAdapter_ShowInvoice(
                getSupportFragmentManager(), fragments, titles);


        viewPager.setAdapter(adapter_showInvoice);
        tabLayout.setupWithViewPager(viewPager);

        setViewPagerPage();

    }

    private void setViewPagerPage() {

        switch (toShow) {


            case Constants.ShowInvoiceActivity.SHOW_PURCHASE_INVOICE: {
                viewPager.setCurrentItem(0);
                break;
            }

            case Constants.ShowInvoiceActivity.SHOW_SALE_INVOICE: {
                viewPager.setCurrentItem(1);
                break;
            }


        }

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
}
