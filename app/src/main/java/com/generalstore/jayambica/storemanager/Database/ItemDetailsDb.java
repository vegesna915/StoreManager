package com.generalstore.jayambica.storemanager.Database;


import android.content.Context;

public class ItemDetailsDb {

    static final String TABLE_ITEM_DETAILS = "ITEM_DETAILS_TABLE";
    static final String ITEM_NAME = "ITEM_NAME";
    static final String ITEM_PRICE = "ITEM_PRICE";
    static final String ITEM_EXPIRE_TIME = "ITEM_EXPIRE_TIME";
    static final String ITEM_TAX = "ITEM_TAX";
    static final String ITEM_MIN_EXPIRE_ALERT = "ITEM_MIN_EXPIRE_ALERT";
    static final String ITEM_IS_UPDATED_TO_SERVER = "ITEM_IS_UPDATED_TO_SERVER";


    private Context context;

    public ItemDetailsDb(Context context) {
        this.context = context;
    }


}
