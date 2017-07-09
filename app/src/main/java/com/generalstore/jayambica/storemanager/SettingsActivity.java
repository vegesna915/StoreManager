package com.generalstore.jayambica.storemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.generalstore.jayambica.storemanager.Extra.Constants;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_settingsActivity);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Button changePinButton = (Button) findViewById(R.id.changePinButton_SettingsActivity);
        changePinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toStartActivity = new Intent(SettingsActivity.this, StartActivity.class);

                toStartActivity.putExtra(Constants.INTENT_FROM, Constants.StartActivity.INTENT_FROM_SETTINGS);
                startActivity(toStartActivity);

            }
        });

    }
}
