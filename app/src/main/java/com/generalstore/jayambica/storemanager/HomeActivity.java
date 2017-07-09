package com.generalstore.jayambica.storemanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.generalstore.jayambica.storemanager.Adapters.FragmentAdapter_Home;
import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.Fragments.HomeActivityFragments.MainStoreFragment;
import com.generalstore.jayambica.storemanager.Fragments.HomeActivityFragments.ShopListFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    SharedPreferences sharedPref;
    ArrayList<String> tabTitles = new ArrayList<>();
    ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPref = getSharedPreferences(Constants.SharedPreference.SHARED_PREFERENCE, Context.MODE_PRIVATE);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_homeActivity);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout_homeActivity);
        viewPager = (ViewPager) findViewById(R.id.viewPager_homeActivity);

        setViewPager();
    }

    private void setViewPager() {

        tabTitles.add("Main Store");
        tabTitles.add("Shops");

        fragments.add(new MainStoreFragment());
        fragments.add(new ShopListFragment());


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentAdapter_Home adapterFragment = new FragmentAdapter_Home(fragmentManager, fragments, tabTitles);

        viewPager.setAdapter(adapterFragment);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu_home_activity, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case R.id.settings_MainMenu_homeActivity: {

                Intent toSettingActivity = new Intent(HomeActivity.this, SettingsActivity.class);
                toSettingActivity.putExtra(Constants.SettingsActivity.FRAGMENT_SETTING_ACTIVITY,
                        Constants.SettingsActivity.DEFAULT_SETTINGS_ACTIVITY);
                startActivity(toSettingActivity);

                break;
            }

            case R.id.logOut_MainMenu_homeActivity: {

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean(Constants.SharedPreference.IS_LOGIN, false);
                editor.putString(Constants.SharedPreference.PIN, "");
                editor.apply();

                Intent toStartActivity = new Intent(HomeActivity.this, StartActivity.class);
                startActivity(toStartActivity);

                finish();
                break;
            }


        }

        return true;
    }
}
