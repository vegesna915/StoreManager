package com.generalstore.jayambica.storemanager.Fragments.ShowInvoiceFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.ShowInvoiceActivity;

public class PurchaseInvoiceShowFragment extends Fragment {

    ShowInvoiceActivity showInvoiceActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        showInvoiceActivity = (ShowInvoiceActivity) getActivity();

        View v = inflater.inflate(R.layout.fragment_purchase_invoice_show, container, false);

        return v;
    }

}
