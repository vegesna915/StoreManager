package com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.generalstore.jayambica.storemanager.Database.VendorsDb;
import com.generalstore.jayambica.storemanager.Extra.Utilis;
import com.generalstore.jayambica.storemanager.Objects.Vendor;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.SettingsActivity;


public class AddVendorSettingsActivityFragment extends Fragment {


    SettingsActivity settingsActivity;
    boolean isAddOrEdit;
    private EditText vendorNameEdit, vendorPhoneEdit, vendorEmailEdit, vendorStreetEdit,
            vendorCityEdit, vendorStateEdit, vendorCountryEdit, vendorZipEdit;
    private String vendorName, vendorPhone, vendorEmail, vendorStreet, vendorCity, vendorState,
            vendorCountry, vendorZip;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        settingsActivity = (SettingsActivity) getActivity();
        isAddOrEdit = settingsActivity.isAddOrEdit;

        View v = inflater.inflate(R.layout.fragment_add_vendor_settings_activity, container, false);

        if (settingsActivity.getSupportActionBar() != null) {
            if (isAddOrEdit) {

                settingsActivity.getSupportActionBar().setTitle("Add Vendor");
            } else {

                settingsActivity.getSupportActionBar().setTitle("Edit vendor");
            }

        }


        declarations(v);


        if (!isAddOrEdit) {
            VendorsDb vendorsDb = new VendorsDb(settingsActivity);
            Vendor vendor = vendorsDb.getVendorById(settingsActivity.editId);

            vendorNameEdit.setText(vendor.getVendorName());
            vendorPhoneEdit.setText(vendor.getVendorPhone());
            vendorEmailEdit.setText(vendor.getVendorEmail());
            vendorStreetEdit.setText(vendor.getVendorStreet());
            vendorCityEdit.setText(vendor.getVendorCity());
            vendorStateEdit.setText(vendor.getVendorState());
            vendorCountryEdit.setText(vendor.getVendorCountry());
            vendorZipEdit.setText(vendor.getVendorZip());
            refreshInputs();
        }

        return v;
    }


    private void declarations(View v) {


        vendorNameEdit = (EditText) v.findViewById(R.id.vendorName_addVendor_SettingsActivity);
        vendorPhoneEdit = (EditText) v.findViewById(R.id.vendorPhoneNumber_addVendorFragment_SettingsActivity);
        vendorEmailEdit = (EditText) v.findViewById(R.id.vendorEmail_addVendorFragment_SettingsActivity);
        vendorStreetEdit = (EditText) v.findViewById(R.id.vendorStreet_addVendorFragment_SettingsActivity);
        vendorCityEdit = (EditText) v.findViewById(R.id.vendorTown_addVendorFragment_SettingsActivity);
        vendorStateEdit = (EditText) v.findViewById(R.id.vendorState_addVendorFragment_SettingsActivity);
        vendorCountryEdit = (EditText) v.findViewById(R.id.vendorCountry_addVendorFragment_SettingsActivity);
        vendorZipEdit = (EditText) v.findViewById(R.id.vendorZipCode_addVendorFragment_SettingsActivity);

        Button saveButton = (Button) v.findViewById(R.id.saveVendorButton_addVendorFragment_settingsActivity);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilis.closeKeyboard(settingsActivity, v);
                onClickSaveButton();
            }
        });


        View linearLayout = v.findViewById(R.id.linearLayout_main_addVendorFragment_settingsActivity);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Utilis.closeKeyboard(settingsActivity, v2);
            }
        });

    }

    private void refreshInputs() {
        vendorName = vendorNameEdit.getText().toString();
        vendorPhone = vendorPhoneEdit.getText().toString();
        vendorEmail = vendorEmailEdit.getText().toString();
        vendorStreet = vendorStreetEdit.getText().toString();
        vendorCity = vendorCityEdit.getText().toString();
        vendorState = vendorStateEdit.getText().toString();
        vendorCountry = vendorCountryEdit.getText().toString();
        vendorZip = vendorZipEdit.getText().toString();
    }

    private void onClickSaveButton() {

        refreshInputs();


        if (vendorName.equals("")) {
            vendorNameEdit.setError("Enter Name");
            vendorNameEdit.requestFocus();
            return;
        }
        if (vendorPhone.equals("")) {
            vendorPhoneEdit.setError("Enter Phone");
            vendorPhoneEdit.requestFocus();
            return;
        }
        if (vendorEmail.equals("")) {
            vendorEmailEdit.setError("Enter Email");
            vendorEmailEdit.requestFocus();
            return;
        }
        if (vendorStreet.equals("")) {
            vendorStreetEdit.setError("Enter Street/P0 box");
            vendorStreetEdit.requestFocus();
            return;
        }
        if (vendorCity.equals("")) {
            vendorCityEdit.setError("Enter Town/City");
            vendorCityEdit.requestFocus();
            return;
        }
        if (vendorState.equals("")) {
            vendorStateEdit.setError("Enter State");
            vendorStateEdit.requestFocus();
            return;
        }
        if (vendorCountry.equals("")) {
            vendorCountryEdit.setError("Enter Vendor Name");
            vendorCountryEdit.requestFocus();
            return;
        }
        if (vendorZip.equals("")) {
            vendorZipEdit.setError("Enter Vendor Name");
            vendorZipEdit.requestFocus();
            return;
        }

        Vendor vendor = new Vendor();

        vendor.setVendorId(System.currentTimeMillis() + "");
        vendor.setVendorName(vendorName);
        vendor.setVendorPhone(vendorPhone);
        vendor.setVendorEmail(vendorEmail);
        vendor.setVendorStreet(vendorStreet);
        vendor.setVendorCity(vendorCity);
        vendor.setVendorState(vendorState);
        vendor.setVendorCountry(vendorCountry);
        vendor.setVendorZip(vendorZip);
        vendor.setVendorIsUpdatedToServer("0");


        VendorsDb vendorsDb = new VendorsDb(settingsActivity);

        long row;

        if (isAddOrEdit) {

            row = vendorsDb.addVendor(vendor);

            if (row > 0) {
                Toast.makeText(settingsActivity, "Vendor added successfully", Toast.LENGTH_SHORT).show();
                settingsActivity.onBackPressed();
            } else {
                Toast.makeText(settingsActivity, "Failed to Add Vendor", Toast.LENGTH_SHORT).show();
            }

        } else {

            row = vendorsDb.updateVendorById(vendor);

            if (row < 0) {
                Toast.makeText(settingsActivity, "Vendor Update Failed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(settingsActivity, "Vendor updated", Toast.LENGTH_SHORT).show();
                settingsActivity.onBackPressed();
            }


        }


    }
}
