package com.generalstore.jayambica.storemanager.Fragments.AddInvoiceFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.generalstore.jayambica.storemanager.Adapters.RecyclerViewAdapters.RecyclerViewAdapter_AddPurchaseInvoice;
import com.generalstore.jayambica.storemanager.AddInvoiceActivity;
import com.generalstore.jayambica.storemanager.Database.ItemsDb;
import com.generalstore.jayambica.storemanager.Database.VendorsDb;
import com.generalstore.jayambica.storemanager.Extra.Utilis;
import com.generalstore.jayambica.storemanager.Objects.Item;
import com.generalstore.jayambica.storemanager.Objects.Vendor;
import com.generalstore.jayambica.storemanager.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;

public class AddPurchaseInvoiceFragment extends Fragment implements DatePickerDialog.OnDateSetListener {


    AddInvoiceActivity addInvoiceActivity;
    RecyclerViewAdapter_AddPurchaseInvoice adapterRecyclerView;
    ArrayAdapter<String> adapterVendorName;
    ArrayList<Vendor> vendors = new ArrayList<>();
    ArrayList<String> vendorNames = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();
    float invoiceSubTotal = 0;
    float invoiceTax, invoiceTotalPrice;
    private EditText vendorPhoneEdit, vendorEmailEdit, vendorAddressEdit, invoiceNumberEdit,
            invoicePONUmberEdit, invoiceSubTotalEdit, invoiceTaxEdit, invoiceTotalPriceEdit;
    private AutoCompleteTextView vendorNameEdit;
    private Button invoiceDateEdit;
    private String vendorName, vendorPhone, vendorEmail, vendorAddress, invoiceNumber,
            invoicePONUmber, invoiceDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        addInvoiceActivity = (AddInvoiceActivity) getActivity();
        if (addInvoiceActivity.getSupportActionBar() != null) {
            addInvoiceActivity.getSupportActionBar().setTitle("Add Purchase Invoice");
        }

        View v = inflater.inflate(R.layout.fragment_add_purchase_invoice, container, false);


        declarations(v);

        setRecyclerView(v);

        return v;
    }

    private void setRecyclerView(View v) {

        RecyclerView recyclerView = (RecyclerView) v.findViewById(
                R.id.recyclerView_itemsList_addPurchaseInvoice_SettingsActivity);

        adapterRecyclerView = new RecyclerViewAdapter_AddPurchaseInvoice(addInvoiceActivity, items);


        recyclerView.setLayoutManager(new LinearLayoutManager(addInvoiceActivity));
        recyclerView.setAdapter(adapterRecyclerView);

    }

    private void declarations(View v) {

        vendorNameEdit = (AutoCompleteTextView) v.findViewById(R.id.vendorName_addPurchaseInvoice_addInvoiceActivity);
        vendorPhoneEdit = (EditText) v.findViewById(R.id.vendorPhoneNumber_addPurchaseInvoice_addInvoiceActivity);
        vendorEmailEdit = (EditText) v.findViewById(R.id.vendorEmail_addPurchaseInvoice_addInvoiceActivity);
        vendorAddressEdit = (EditText) v.findViewById(R.id.vendorAddress_addPurchaseInvoice_addInvoiceActivity);
        invoiceNumberEdit = (EditText) v.findViewById(R.id.invoiceNumber_addPurchaseInvoice_addInvoiceActivity);
        invoicePONUmberEdit = (EditText) v.findViewById(R.id.invoicePONumber_addPurchaseInvoice_addInvoiceActivity);
        invoiceDateEdit = (Button) v.findViewById(R.id.invoiceDate_addPurchaseInvoice_addInvoiceActivity);
        invoiceSubTotalEdit = (EditText) v.findViewById(R.id.invoiceSubTotal_addPurchaseInvoice_addInvoiceActivity);
        invoiceTaxEdit = (EditText) v.findViewById(R.id.invoiceTax_addPurchaseInvoice_addInvoiceActivity);
        invoiceTotalPriceEdit = (EditText) v.findViewById(R.id.invoiceTotalPrice_addPurchaseInvoice_addInvoiceActivity);

        Button saveButton = (Button) v.findViewById(R.id.savePurchaseInvoiceButton_addPurchaseInvoice_settingsActivity);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilis.closeKeyboard(addInvoiceActivity, v);
                saveButtonClicked();
            }
        });

        View layout = v.findViewById(R.id.linearLayout_main_addPurchaseInvoice_addInvoiceActivity);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilis.closeKeyboard(addInvoiceActivity, v);
            }
        });


        final Calendar calender = Calendar.getInstance();
        invoiceDate = calender.get(Calendar.DAY_OF_MONTH) + "/" +
                (calender.get(Calendar.MONTH) + 1) + "/" + calender.get(Calendar.YEAR);
        invoiceDateEdit.setText(invoiceDate);
        invoiceDateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePicker = DatePickerDialog.newInstance(
                        AddPurchaseInvoiceFragment.this,
                        calender.get(Calendar.YEAR),
                        calender.get(Calendar.MONTH),
                        calender.get(Calendar.DAY_OF_MONTH));

                datePicker.vibrate(false);
                datePicker.dismissOnPause(false);
                datePicker.show(getFragmentManager(), "datePicker");
            }
        });

        setVendorName();

    }

    private void setVendorName() {

        VendorsDb vendorsDb = new VendorsDb(addInvoiceActivity);

        vendors.clear();
        vendors.addAll(vendorsDb.getAllVendors());

        vendorNames = new ArrayList<>();
        vendorNames.clear();
        for (Vendor vendor : vendors) {
            vendorNames.add(vendor.getVendorName());
        }

        adapterVendorName = new ArrayAdapter<>(
                addInvoiceActivity, android.R.layout.simple_dropdown_item_1line, vendorNames);

        vendorNameEdit.setAdapter(adapterVendorName);


        vendorNameEdit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                setVendorDetails(position);

            }
        });

    }

    private void setVendorDetails(int position) {

        Vendor vendor = vendors.get(position);

        vendorPhoneEdit.setText(vendor.getVendorPhone());
        vendorAddressEdit.setText(vendor.getVendorStreet() + ","
                + vendor.getVendorCity() + ","
                + vendor.getVendorState() + ","
                + vendor.getVendorCountry() + ","
                + "ZIP Code - " + vendor.getVendorZip());

    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        invoiceDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

        invoiceDateEdit.setText(invoiceDate);
    }

    private void refreshInputs() {
        if (invoiceTaxEdit.getText().toString().equals("")) {
            invoiceTax = 0;
        } else {
            invoiceTax = Float.parseFloat(invoiceTaxEdit.getText().toString());
        }

        for (Item i : items) {
            invoiceSubTotal += Float.parseFloat(i.getItemActualPrice());
        }

        invoiceTotalPrice = invoiceSubTotal + invoiceSubTotal * invoiceTax;

        invoiceSubTotalEdit.setText(invoiceSubTotal + "");
        invoiceTotalPriceEdit.setText(invoiceTotalPrice + "");

    }

    private void saveButtonClicked() {
        refreshInputs();

        vendorName = vendorNameEdit.getText().toString();
        vendorPhone = vendorPhoneEdit.getText().toString();
        vendorEmail = vendorEmailEdit.getText().toString();
        vendorAddress = vendorAddressEdit.getText().toString();
        invoiceNumber = invoiceNumberEdit.getText().toString();
        invoicePONUmber = invoicePONUmberEdit.getText().toString();
        invoiceDate = invoiceDateEdit.getText().toString();

    }


    private void refreshItems() {
        ItemsDb itemDb = new ItemsDb(addInvoiceActivity);
        items.clear();
        items.addAll(itemDb.getAllItems());

        adapterRecyclerView.notifyDataSetChanged();

    }

    private void refreshVendors() {

        VendorsDb vendorsDb = new VendorsDb(addInvoiceActivity);
        vendors.clear();
        vendors.addAll(vendorsDb.getAllVendors());
        vendorNames.clear();
        for (Vendor vendor : vendors) {
            vendorNames.add(vendor.getVendorName());
        }
        adapterVendorName.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshItems();
        refreshVendors();
        refreshInputs();
    }
}
