package com.generalstore.jayambica.storemanager.Objects;


public class Item {

    private String itemCode, itemName, itemBrandName, itemWeight, itemWeightUnit, itemExpiresIn,
            itemActualPrice, itemProfit, itemTax, itemOtherTax, itemPrice, itemIsUpdatedToSever;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }


    public String getItemTax() {
        return itemTax;
    }

    public void setItemTax(String itemTax) {
        this.itemTax = itemTax;
    }


    public String getItemIsUpdatedToSever() {
        return itemIsUpdatedToSever;
    }

    public void setItemIsUpdatedToSever(String itemIsUpdatedToSever) {
        this.itemIsUpdatedToSever = itemIsUpdatedToSever;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemBrandName() {
        return itemBrandName;
    }

    public void setItemBrandName(String itemBrandName) {
        this.itemBrandName = itemBrandName;
    }

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getItemWeightUnit() {
        return itemWeightUnit;
    }

    public void setItemWeightUnit(String itemWeightUnit) {
        this.itemWeightUnit = itemWeightUnit;
    }

    public String getItemExpiresIn() {
        return itemExpiresIn;
    }

    public void setItemExpiresIn(String itemExpiresIn) {
        this.itemExpiresIn = itemExpiresIn;
    }

    public String getItemActualPrice() {
        return itemActualPrice;
    }

    public void setItemActualPrice(String itemActualPrice) {
        this.itemActualPrice = itemActualPrice;
    }

    public String getItemProfit() {
        return itemProfit;
    }

    public void setItemProfit(String itemProfit) {
        this.itemProfit = itemProfit;
    }

    public String getItemOtherTax() {
        return itemOtherTax;
    }

    public void setItemOtherTax(String itemOtherTax) {
        this.itemOtherTax = itemOtherTax;
    }
}
