package com.generalstore.jayambica.storemanager.Fragments.AddInvoiceFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.generalstore.jayambica.storemanager.AddInvoiceActivity;
import com.generalstore.jayambica.storemanager.R;


public class AddSaleInvoiceFragment extends Fragment {


    AddInvoiceActivity addInvoiceActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        addInvoiceActivity = (AddInvoiceActivity) getActivity();

        addInvoiceActivity = (AddInvoiceActivity) getActivity();
        if (addInvoiceActivity.getSupportActionBar() != null) {
            addInvoiceActivity.getSupportActionBar().setTitle("Add Sale Invoice");
        }

        View v = inflater.inflate(R.layout.fragment_purchase_invoice_show, container, false);

        return v;
    }

}
