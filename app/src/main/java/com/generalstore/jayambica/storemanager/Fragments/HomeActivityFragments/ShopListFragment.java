package com.generalstore.jayambica.storemanager.Fragments.HomeActivityFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.HomeActivity;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.ShopActivity;

public class ShopListFragment extends Fragment implements View.OnClickListener {

    HomeActivity homeActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        homeActivity = (HomeActivity) getActivity();

        View v = inflater.inflate(R.layout.fragment_shop_list, container, false);

        setListeners(v);

        return v;
    }

    private void setListeners(View v) {

        Button shop1Button = (Button) v.findViewById(R.id.shop1Button_shopListFragment);
        shop1Button.setOnClickListener(this);

        Button shop2Button = (Button) v.findViewById(R.id.shop2Button_shopListFragment);
        shop2Button.setOnClickListener(this);

        Button shop3Button = (Button) v.findViewById(R.id.shop3Button_shopListFragment);
        shop3Button.setOnClickListener(this);

        Button shop4Button = (Button) v.findViewById(R.id.shop4Button_shopListFragment);
        shop4Button.setOnClickListener(this);

        Button shop5Button = (Button) v.findViewById(R.id.shop5Button_shopListFragment);
        shop5Button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(homeActivity, ShopActivity.class);

        switch (v.getId()) {

            case R.id.shop1Button_shopListFragment: {
                intent.putExtra(Constants.INTENT_FROM,
                        Constants.HomeActivity.INTENT_FROM_SHOP_SHOP1);
                break;
            }

            case R.id.shop2Button_shopListFragment: {

                intent.putExtra(Constants.INTENT_FROM,
                        Constants.HomeActivity.INTENT_FROM_SHOP_SHOP2);

                break;
            }

            case R.id.shop3Button_shopListFragment: {


                intent.putExtra(Constants.INTENT_FROM,
                        Constants.HomeActivity.INTENT_FROM_SHOP_SHOP3);

                break;
            }

            case R.id.shop4Button_shopListFragment: {
                intent.putExtra(Constants.INTENT_FROM,
                        Constants.HomeActivity.INTENT_FROM_SHOP_SHOP4);
                break;
            }

            case R.id.shop5Button_shopListFragment: {
                intent.putExtra(Constants.INTENT_FROM,
                        Constants.HomeActivity.INTENT_FROM_SHOP_SHOP5);
                break;
            }


        }

        startActivity(intent);
    }
}
