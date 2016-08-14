package br.com.vsgdev.donapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.local.UserTokenStorageFactory;

import br.com.vsgdev.donapp.R;
import br.com.vsgdev.donapp.utils.BackendlessConfig;


/**
 * This activity take care about the Login, and registration
 * <p/>
 * <hr/>
 * Creation Date: 09/08/16 <br/>
 * Update Date: 09/08/16 <br/>
 * <hr/>
 *
 * @author Stênio Galvão
 * @version 1.0.0
 */
public class LoginActivity extends BaseActivity implements OnClickListener {


    /**
     * UI references.
     */
    private EditText mEmailView;
    private EditText mPasswordView;
    private Button mEmailSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**
         * initializing the Backendless application
         * */
        Backendless.initApp(this.getApplicationContext(), BackendlessConfig.getApplicationId(), BackendlessConfig.getAndroidSecretKey(), BackendlessConfig.getVersion());
        /**
         * checking if are some user already loged in application
         * */
        String userToken = UserTokenStorageFactory.instance().getStorage().get();
        /**
         * if are any user, skip the login screen and go to MainActivity
         * */
        if (userToken != null && !userToken.equals("")) {
            //TODO: change this toast, lead user to a new activity
//            Toast.makeText(getApplicationContext(), "Logado", Toast.LENGTH_LONG).show();
//            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(mainActivity);
//            finish();


        }
        /**
         * Set up the login form.
         * */
//        mEmailView = (EditText) findViewById(R.id.email);
//        mPasswordView = (EditText) findViewById(R.id.password);
//        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
//                if (id == R.id.login || id == EditorInfo.IME_NULL) {
//                    attemptLogin();
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
//        mEmailSignInButton.setOnClickListener(this);
//
    }


    /**
     * Attempts to sign in specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgressDialog();
            login(email, password);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == mEmailSignInButton.getId())
            attemptLogin();
    }

    public void login(String username, String password) {
        /**
         * This will call the login service of Backendless
         * @param String username
         * @param String password
         * @param AsyncCallback<BackendlessUser> callback
         * @param Boolean stayLoggedIn
         * */
        Backendless.UserService.login(username, password, new AsyncCallback<BackendlessUser>() {

            public void handleResponse(BackendlessUser user) {
                //new activity
                hideProgressDialog();
//                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(mainActivity);
//                finish();
                Toast.makeText(getApplicationContext(), "Logado", Toast.LENGTH_LONG).show();
            }

            public void handleFault(BackendlessFault fault) {
                //show some error
                hideProgressDialog();
                Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();
            }

        }, true);
    }
}





