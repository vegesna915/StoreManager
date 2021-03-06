package com.generalstore.jayambica.storemanager.Fragments.StartActivityFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.generalstore.jayambica.storemanager.Extra.Constants;
import com.generalstore.jayambica.storemanager.Extra.Utilis;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.StartActivity;

public class LoginFragment extends Fragment {

    StartActivity startActivity;
    EditText userEmailView, passwordView;
    Button loginButton, forgotButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        startActivity = (StartActivity) getActivity();

        View v = inflater.inflate(R.layout.fragment_login, container, false);
        userEmailView = (EditText) v.findViewById(R.id.userName_login);
        passwordView = (EditText) v.findViewById(R.id.password_login);

        loginButton = (Button) v.findViewById(R.id.loginButton_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Utilis.closeKeyboard(startActivity, v);

                String email = userEmailView.getText().toString();
                String password = passwordView.getText().toString();

                if (email.equals("")) {
                    userEmailView.setError("Enter Email Address");
                }

                if (password.equals("")) {
                    passwordView.setError("Enter password");
                }

                if (Constants.Login.isLogin(email, password)) {

                    startActivity.changeFragmentToSetPin();

                }

            }
        });

        forgotButton = (Button) v.findViewById(R.id.forgotPassword_login);
        forgotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(startActivity, "Sorry, can't do anything", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
