package com.generalstore.jayambica.storemanager.Extra;


public class Constants {


    public static final String INTENT_FROM = "INTENT_FROM";

    public static class Login {
        static String Email = "store.manager@gmail.com";
        static String Password = "jayambica";

        public static boolean isLogin(String email, String password) {
            return Email.equals(email) && Password.equals(password);
        }

    }

    public static class SharedPreference {
        public static final String SHARED_PREFERENCE = "com.generalstore.jayambica.storemanager";
        public static final String PIN = "pin_shared_preference";
        public static final String IS_LOGIN = "is_login";

    }

    public static class StartActivity {
        public static final String INTENT_FROM_SETTINGS = "INTENT_FROM_SETTINGS";

    }

    public static class HomeActivity {
        public static final String INTENT_FROM_MAIN_STORE_FRAGMENT = "Main Store";
        public static final String INTENT_FROM_SHOP_SHOP1 = "Shop 1";
        public static final String INTENT_FROM_SHOP_SHOP2 = "Shop 2";
        public static final String INTENT_FROM_SHOP_SHOP3 = "Shop 3";
        public static final String INTENT_FROM_SHOP_SHOP4 = "Shop 4";
        public static final String INTENT_FROM_SHOP_SHOP5 = "Shop 5";

    }

    public static class CurrentStockActivity {


    }

    public static class ShowInvoiceActivity {
        public static final String TO_SHOW = "TO_SHOW";
        public static final String SHOW_PURCHASE_INVOICE = "SHOW_PURCHASE_INVOICE";
        public static final String SHOW_SALE_INVOICE = "SHOW_SALE_INVOICE";


    }

    public static class AddInvoiceActivity {


        public static final String TO_ADD = "TO_ADD";
        public static final String ADD_PURCHASE_INVOICE = "SHOW_PURCHASE_INVOICE";
        public static final String ADD_SALE_INVOICE = "SHOW_SALE_INVOICE";

    }

    public static class ExpireItemsActivity {

    }

}
