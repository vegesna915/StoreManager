package com.generalstore.jayambica.storemanager.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.HomeActivity;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.StartActivity;

import java.util.ArrayList;


public class EntryPinFragment extends Fragment implements View.OnClickListener {


    Button button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button0, forgot_button;
    ImageButton back_button;
    StartActivity startActivity;
    ArrayList<ImageView> pinImages = new ArrayList<>();
    String pinOriginal;

    String pinString = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        startActivity = (StartActivity) getActivity();

        SharedPreferences sharedPreferences = startActivity.getSharedPreferences(
                Constants.SharedPreference.SHARED_PREFERENCE, Context.MODE_PRIVATE);
        pinOriginal = sharedPreferences.getString(Constants.SharedPreference.PIN, "");
        pinOriginal = "1969";

        View v = inflater.inflate(R.layout.entry_pin_fragment, container, false);

        button1 = (Button) v.findViewById(R.id.number_1);
        button1.setOnClickListener(this);
        button2 = (Button) v.findViewById(R.id.number_2);
        button2.setOnClickListener(this);
        button3 = (Button) v.findViewById(R.id.number_3);
        button3.setOnClickListener(this);
        button4 = (Button) v.findViewById(R.id.number_4);
        button4.setOnClickListener(this);
        button5 = (Button) v.findViewById(R.id.number_5);
        button5.setOnClickListener(this);
        button6 = (Button) v.findViewById(R.id.number_6);
        button6.setOnClickListener(this);
        button7 = (Button) v.findViewById(R.id.number_7);
        button7.setOnClickListener(this);
        button8 = (Button) v.findViewById(R.id.number_8);
        button8.setOnClickListener(this);
        button9 = (Button) v.findViewById(R.id.number_9);
        button9.setOnClickListener(this);
        button0 = (Button) v.findViewById(R.id.number_0);
        button0.setOnClickListener(this);
        forgot_button = (Button) v.findViewById(R.id.forgotButton_pin);
        forgot_button.setOnClickListener(this);
        back_button = (ImageButton) v.findViewById(R.id.back_pin);
        back_button.setOnClickListener(this);

        pinImages.add((ImageView) v.findViewById(R.id.pinImage1));
        pinImages.add((ImageView) v.findViewById(R.id.pinImage2));
        pinImages.add((ImageView) v.findViewById(R.id.pinImage3));
        pinImages.add((ImageView) v.findViewById(R.id.pinImage4));

        return v;
    }


    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.forgotButton_pin: {
                SharedPreferences sharedPref = startActivity.getSharedPreferences(
                        Constants.SharedPreference.SHARED_PREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean(Constants.SharedPreference.IS_LOGIN, false);
                editor.apply();
                startActivity.changeFragmentToLogin();
                break;
            }
            case R.id.back_pin: {
                if (pinString.length() > 0) {
                    pinString = pinString.substring(0, pinString.length() - 1);
                }
                break;
            }
            default: {

                if (pinString.length() < 4) {
                    Button button = (Button) v;
                    pinString += button.getText().toString();
                }
                break;
            }
        }

        setPinImage();

        if (pinString.length() >= 4) {

            if (pinOriginal.equals(pinString)) {
                Intent toHomeActivity = new Intent(startActivity, HomeActivity.class);
                startActivity.startActivity(toHomeActivity);
                startActivity.finish();
            } else {
                Vibrator vibrator = (Vibrator) startActivity.getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(250);
                pinString = "";
                setPinImage();
            }

        }

    }

    private void setPinImage() {

        for (int i = 0; i < pinImages.size(); i++) {

            if (i >= pinString.length()) {
                pinImages.get(i).setImageResource(R.drawable.ic_pin_normal);
            } else {
                pinImages.get(i).setImageResource(R.drawable.ic_pin_large);
            }

        }

    }

}
