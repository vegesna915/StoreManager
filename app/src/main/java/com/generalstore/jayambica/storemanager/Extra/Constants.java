package com.generalstore.jayambica.storemanager.Extra;


public class Constants {


    public static class Login {
        static String Email = "store.manager@gmail.com";
        static String Password = "jayambica";

        public static boolean isLogin(String email, String password) {
            return Email.equals(email) && Password.equals(password);
        }

    }

    public static class SharedPreference {
        public static String SHARED_PREFERENCE = "com.generalstore.jayambica.storemanager";
        public static String PIN = "pin_shared_preference";
        public static String IS_LOGIN = "is_login";
    }

}
