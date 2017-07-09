package com.generalstore.jayambica.storemanager.Database;

import android.content.Context;

public class InvoiceDb {

    static final String TABLE_ITEM_DETAILS = "INVOICE_TABLE";
    static final String INVOICE_ID = "INVOICE_ID";
    static final String INVOICE_NUMBER = "INVOICE_NUMBER";
    static final String INVOICE_P_O_NUMBER = "INVOICE_P_O_NUMBER";
    static final String INVOICE_DATE = "INVOICE_DATE";
    static final String INVOICE_TO_VENDOR_ID = "INVOICE_TO_VENDOR_ID";
    static final String INVOICE_FROM_VENDOR_ID = "INVOICE_FROM_VENDOR_ID";


    private Context context;

    public InvoiceDb(Context context) {
        this.context = context;
    }


}
