package br.com.vsgdev.donapp.activities;

import android.app.ProgressDialog;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.Array;

import br.com.vsgdev.donapp.R;

/**
 * This classe is a base activity, help us to reuse some common codes called in almost all activities
 * <p/>
 * <p/>
 * Created by Stênio Galvão on 09/08/16.
 */

public class BaseActivity extends AppCompatActivity {

    @VisibleForTesting
    public ProgressDialog mProgressDialog;

    /**
     * Show a progressDialog to user, give the idea that are something running in background
     */

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getApplicationContext());
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    /**
     * hide a progressDialog to user, give the idea that what we are doing in background are finish
     */
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }


}