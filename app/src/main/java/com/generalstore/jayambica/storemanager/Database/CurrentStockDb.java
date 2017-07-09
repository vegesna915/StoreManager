package com.generalstore.jayambica.storemanager.Database;


import android.content.Context;

public class CurrentStockDb {

    static final String TABLE_ITEM_DETAILS = "CURRENT_STOCK_TABLE";
    static final String ITEM_NAME = "ITEM_NAME";
    static final String ITEM_QTY = "ITEM_QTY_VALUE";
    static final String ITEM_WEIGHT = "ITEM_WEIGHT";
    static final String ITEM_PRICE = "ITEM_PRICE";
    static final String ITEM_EXPIRE_TIME = "ITEM_EXPIRE_TIME";
    static final String ITEM_TAX = "ITEM_TAX";


    private Context context;

    public CurrentStockDb(Context context) {
        this.context = context;
    }


}
