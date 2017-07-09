package com.generalstore.jayambica.storemanager.Database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String databaseName = "StoreManager.db";

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FRIENDS_TABLE = "CREATE TABLE " + ItemDetailsDb.TABLE_ITEM_DETAILS
                + "("
                + ItemDetailsDb.ITEM_NAME + " TEXT PRIMARY KEY,"
                + ItemDetailsDb.ITEM_PRICE + " TEXT,"
                + ItemDetailsDb.ITEM_TAX + " TEXT,"
                + ItemDetailsDb.ITEM_EXPIRE_TIME + " TEXT,"
                + ItemDetailsDb.ITEM_MIN_EXPIRE_ALERT + " TEXT,"
                + ItemDetailsDb.ITEM_IS_UPDATED_TO_SERVER + " TEXT"
                + ")";
        db.execSQL(CREATE_FRIENDS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
