package com.generalstore.jayambica.storemanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.generalstore.jayambica.storemanager.Extra.Constants;

public class CurrentStockActivity extends AppCompatActivity {

    String intentFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_stock);

        intentFrom = getIntent().getStringExtra(Constants.INTENT_FROM);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_currentStockActivity);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setTitle("Stock - " + intentFrom);

        }


    }


}
