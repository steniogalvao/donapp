package br.com.vsgdev.donapp.utils;

/**
 * configurations that Backendless need to work
 * <p/>
 * <p/>
 * Created by Stênio Galvão on 10/08/16.
 */
public class BackendlessConfig {

    private static String APPLICATION_ID = "65D4D310-0907-EEE1-FFA1-CF8F6136B900";

    private static String ANDROID_SECRET_KEY = "56183717-6112-88D7-FF5A-0519C4C76000";

    private static String VERSION = "v1";


    public static String getApplicationId() {
        return APPLICATION_ID;
    }

    public static String getAndroidSecretKey() {
        return ANDROID_SECRET_KEY;
    }

    public static String getVersion() {
        return VERSION;
    }
}
