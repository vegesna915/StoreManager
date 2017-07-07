package com.generalstore.jayambica.storemanager.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.StartActivity;


public class EntryPinFragment extends Fragment {


    Button button;
    StartActivity startActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        startActivity = (StartActivity)getActivity();

        View v = inflater.inflate(R.layout.entry_pin_fragment,container,false);

        button = (Button) v.findViewById(R.id.button_next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity.onNextClicked();
            }
        });



        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
