package br.com.vsgdev.donapp.utils;

/**
 * Created by Jose Lins on 22/10/2016.
 */

import android.content.Context;
import android.widget.EditText;

public class ValidateUtils {

    public static Boolean checkEmpty(EditText editText) {
        if (editText.getText().toString().matches(""))
            return true;
        return false;
    }

    public static EditText checkEmptyWithErro(EditText editText, Context context, String erroMessage) {
        if (editText.getText().toString().matches(""))
            editText.setError(erroMessage);
        return editText;
    }

    public static boolean checkDigit(String string) {
        String pattern = "\\d";
        if (string.matches(pattern))
            return true;
        return false;
    }
}
