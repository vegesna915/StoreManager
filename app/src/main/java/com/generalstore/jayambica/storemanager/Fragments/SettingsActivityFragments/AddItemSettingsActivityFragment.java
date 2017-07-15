package com.generalstore.jayambica.storemanager.Fragments.SettingsActivityFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.generalstore.jayambica.storemanager.Database.ItemsDb;
import com.generalstore.jayambica.storemanager.Extra.Utilis;
import com.generalstore.jayambica.storemanager.Objects.Item;
import com.generalstore.jayambica.storemanager.R;
import com.generalstore.jayambica.storemanager.SettingsActivity;

import java.text.DecimalFormat;

public class AddItemSettingsActivityFragment extends Fragment {

    SettingsActivity settingsActivity;
    Spinner spinnerTime, spinnerUnits;
    EditText itemNameEdit, itemBrandNameEdit, itemWeightEdit, itemExpireInEdit,
            itemActualPriceEdit, itemProfitEdit, itemTaxEdit, itemOtherTaxEdit, itemPriceEdit;
    String itemName, itemBrandName, itemWeight;
    String spinnerUnitSelection = "kg";
    float itemExpireIn, itemActualPrice, itemProfit, itemTax, itemOtherTax, itemPrice;
    float spinnerTimeSelection = 1;

    boolean isAddOrEdit;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        settingsActivity = (SettingsActivity) getActivity();
        isAddOrEdit = settingsActivity.isAddOrEdit;
        View v = inflater.inflate(R.layout.fragment_add_item_settings_activity, container, false);

        if (settingsActivity.getSupportActionBar() != null) {

            if (isAddOrEdit) {

                settingsActivity.getSupportActionBar().setTitle("Add Item");
            } else {

                settingsActivity.getSupportActionBar().setTitle("Edit Item");
            }

        }

        declarations(v);


        setListeners();


        if (!isAddOrEdit) {

            ItemsDb itemsDb = new ItemsDb(settingsActivity);
            Item item = itemsDb.getItemById(settingsActivity.editId);

            itemNameEdit.setText(item.getItemName());
            itemBrandNameEdit.setText(item.getItemBrandName());
            itemWeightEdit.setText(item.getItemWeight());
            itemActualPriceEdit.setText(item.getItemActualPrice());
            itemProfitEdit.setText(item.getItemProfit());
            itemTaxEdit.setText(item.getItemTax());
            itemOtherTaxEdit.setText(item.getItemOtherTax());
            itemPriceEdit.setText(item.getItemPrice());


            spinnerTimeSelection = Float.parseFloat(item.getItemExpiresIn());

            if (spinnerTimeSelection > 365) {

                spinnerTime.setSelection(2);

                DecimalFormat decimalFormat = new DecimalFormat("#.##");

                itemExpireInEdit.setText(decimalFormat.format(spinnerTimeSelection / 365));

            } else if (spinnerTimeSelection > 30) {
                spinnerTime.setSelection(1);

                DecimalFormat decimalFormat = new DecimalFormat("#.##");

                itemExpireInEdit.setText(decimalFormat.format(spinnerTimeSelection / 30));
            } else {
                itemExpireInEdit.setText(String.valueOf(spinnerTimeSelection));
            }

            refreshInputs();

        }


        return v;
    }

    private void declarations(View v) {

        spinnerUnits = (Spinner) v.findViewById(R.id.spinnerUnits_weight_addItemFragment_SettingsActivity);
        spinnerTime = (Spinner) v.findViewById(R.id.spinner_expiresIn_addItemFragment_SettingsActivity);
        itemNameEdit = (EditText) v.findViewById(R.id.itemName_addItem_SettingsActivity);
        itemBrandNameEdit = (EditText) v.findViewById(R.id.itemBrand_addItemFragment_SettingsActivity);
        itemWeightEdit = (EditText) v.findViewById(R.id.itemWeight_addItemFragment_SettingsActivity);
        itemExpireInEdit = (EditText) v.findViewById(R.id.itemExpireTime_addItemFragment_SettingsActivity);
        itemActualPriceEdit = (EditText) v.findViewById(R.id.itemActualPrice_addItemFragment_SettingsActivity);
        itemProfitEdit = (EditText) v.findViewById(R.id.itemProfit_addItemFragment_SettingsActivity);
        itemTaxEdit = (EditText) v.findViewById(R.id.itemTax_addItemFragment_SettingsActivity);
        itemOtherTaxEdit = (EditText) v.findViewById(R.id.itemOtherTax_addItemFragment_SettingsActivity);
        itemPriceEdit = (EditText) v.findViewById(R.id.itemPrice_addItemFragment_SettingsActivity);


        Button saveButton = (Button) v.findViewById(R.id.saveItemButton_addItemFragment_settingsActivity);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Utilis.closeKeyboard(settingsActivity, v);
                onSaveButtonClicked();
            }
        });

        View linearLayout = v.findViewById(R.id.linearLayout_main_addItemFragment_settingsActivity);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Utilis.closeKeyboard(settingsActivity, v2);
            }
        });

    }

    private void setListeners() {

        spinnerTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        spinnerTimeSelection = 1;
                        break;
                    case 1:
                        spinnerTimeSelection = 30;
                        break;
                    case 2:
                        spinnerTimeSelection = 365;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        spinnerUnitSelection = "kg";
                        break;
                    case 1:
                        spinnerUnitSelection = "gram";
                        break;
                    case 2:
                        spinnerUnitSelection = "litre";
                        break;
                    case 3:
                        spinnerUnitSelection = "ml";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        TextChangeListener textChangeListener = new TextChangeListener();
        itemActualPriceEdit.addTextChangedListener(textChangeListener);
        itemProfitEdit.addTextChangedListener(textChangeListener);
        itemTaxEdit.addTextChangedListener(textChangeListener);
        itemOtherTaxEdit.addTextChangedListener(textChangeListener);

    }

    void refreshInputs() {
        if (itemActualPriceEdit.getText().toString().equals("")) {
            itemActualPrice = 0;
        } else {
            itemActualPrice = Float.parseFloat(itemActualPriceEdit.getText().toString());
        }

        if (itemProfitEdit.getText().toString().equals("")) {
            itemProfit = 0;
        } else {
            itemProfit = Float.parseFloat(itemProfitEdit.getText().toString());
        }

        if (itemTaxEdit.getText().toString().equals("")) {
            itemTax = 0;
        } else {
            itemTax = Float.parseFloat(itemTaxEdit.getText().toString());
        }

        if (itemOtherTaxEdit.getText().toString().equals("")) {
            itemOtherTax = 0;
        } else {
            itemOtherTax = Float.parseFloat(itemOtherTaxEdit.getText().toString());
        }

        itemPrice = itemActualPrice + itemProfit + (itemActualPrice * itemTax / 100) + (itemActualPrice * itemOtherTax / 100);
        itemPriceEdit.setText(itemPrice + "");

    }

    void onSaveButtonClicked() {


        itemName = itemNameEdit.getText().toString();
        itemBrandName = itemBrandNameEdit.getText().toString();
        itemWeight = itemWeightEdit.getText().toString();


        if (itemName.equals("")) {
            itemNameEdit.setError("Enter Item Name");
            itemNameEdit.requestFocus();
            return;
        }
        if (itemBrandName.equals("")) {
            itemBrandNameEdit.setError("Enter Brand Name");
            itemBrandNameEdit.requestFocus();
            return;
        }


        if (itemPrice == 0) {
            itemPriceEdit.setError("Item price can't be 0");
            itemPriceEdit.requestFocus();
            return;
        }

        if (itemExpireInEdit.getText().toString().equals("")) {
            itemExpireIn = 0;
        } else {
            itemExpireIn = Float.parseFloat(itemExpireInEdit.getText().toString()) * spinnerTimeSelection;
        }

        Item item = new Item();

        item.setItemName(itemName);
        item.setItemBrandName(itemBrandName);
        item.setItemWeight(itemWeight + "");
        item.setItemWeightUnit(spinnerUnitSelection);
        item.setItemExpiresIn(itemExpireIn + "");
        item.setItemActualPrice(itemActualPrice + "");
        item.setItemProfit(itemProfit + "");
        item.setItemTax(itemTax + "");
        item.setItemOtherTax(itemOtherTax + "");
        item.setItemPrice(itemPrice + "");
        item.setItemIsUpdatedToSever("0");

        ItemsDb itemDb = new ItemsDb(settingsActivity);

        long row;

        if (isAddOrEdit) {

            item.setItemCode(System.currentTimeMillis() + "");
            row = itemDb.addItem(item);

            if (row < 0) {
                Toast.makeText(settingsActivity, "Item Name Already Exists", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(settingsActivity, "Item added", Toast.LENGTH_SHORT).show();

                settingsActivity.onBackPressed();
            }
        } else {
            row = itemDb.updateItemById(item);

            if (row < 0) {
                Toast.makeText(settingsActivity, "Item Update Failed", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(settingsActivity, "Item updated", Toast.LENGTH_SHORT).show();
                settingsActivity.onBackPressed();
            }
        }


    }

    private class TextChangeListener implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            refreshInputs();

        }

    }


}
