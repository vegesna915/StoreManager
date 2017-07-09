package com.generalstore.jayambica.storemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.generalstore.jayambica.storemanager.Extra.Constants;

public class AddInvoiceItemsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_invoice_items);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu_add_invoice_item_activity, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case android.R.id.home: {
                onBackPressed();
                break;
            }

            case R.id.addNewItem_mainMenu_addInvoiceItemActivity: {

                Intent toSettingsActivity = new Intent(this, SettingsActivity.class);
                toSettingsActivity.putExtra(Constants.SettingsActivity.FRAGMENT_SETTING_ACTIVITY,
                        Constants.SettingsActivity.ADD_ITEM_SETTINGS_ACTIVITY);

                startActivity(toSettingsActivity);

                break;
            }

        }


        return true;
    }

}
