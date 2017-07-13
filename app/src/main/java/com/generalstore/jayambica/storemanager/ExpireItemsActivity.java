package com.generalstore.jayambica.storemanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.generalstore.jayambica.storemanager.Extra.Constants;

public class ExpireItemsActivity extends AppCompatActivity {

    String intentFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expire_items);

        intentFrom = getIntent().getStringExtra(Constants.INTENT_FROM);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_expireItemsActivity);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setTitle("Expire Items - " + intentFrom);
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
