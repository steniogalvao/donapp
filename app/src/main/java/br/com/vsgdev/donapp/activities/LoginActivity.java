package br.com.vsgdev.donapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.local.UserTokenStorageFactory;

import java.math.BigDecimal;

import br.com.vsgdev.donapp.R;
import br.com.vsgdev.donapp.dao.ItemDAO;
import br.com.vsgdev.donapp.dao.UserDAO;
import br.com.vsgdev.donapp.daoImpl.ItemDAOImpl;
import br.com.vsgdev.donapp.daoImpl.UserDAOImpl;
import br.com.vsgdev.donapp.models.Category;
import br.com.vsgdev.donapp.models.Item;
import br.com.vsgdev.donapp.models.User;
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
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnSignIn;

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
        //TODO: Verificar como checka usuario logado na aplicação
        if (userToken != null && !userToken.equals("")) {
            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivity);
            finish();

        }
        /**
         * Set up the login form.
         * */
        edtEmail = (EditText) findViewById(R.id.edt_login_login);
        edtPassword = (EditText) findViewById(R.id.edt_password_login);
        /*
        btnSignIn = (Button) findViewById(R.id.btn_login_login);
        btnSignIn.setOnClickListener(this);
        */

    }

    public void fazerLogin(View view){
        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainActivity);
        finish();
    }


    /**
     * Attempts to sign in specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors.
        edtEmail.setError(null);
        edtPassword.setError(null);

        // Store values at the time of the login attempt.
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            edtPassword.setError(getString(R.string.error_invalid_password));
            focusView = edtPassword;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            edtEmail.setError(getString(R.string.error_field_required));
            focusView = edtEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            edtEmail.setError(getString(R.string.error_invalid_email));
            focusView = edtEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            //TODO: remove before test

            final User user = new User();
            user.setEmail(email);
            user.setPassword(password);

            UserDAO userDAO = new UserDAOImpl();
            /**
             * call the class that same a user, returning a object as response, this object can be a User if everything is ok
             * or a String with a error message if some problem occur
             * */
            Object response = userDAO.createUser(user);
            if (response instanceof User) {
                Toast.makeText(this, "salvo com sucesso", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show();
            }
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
        //TODO remover apos teste
//        User user = new User();
//        user.setObjectId("E8EF1065-7B88-60C2-FFC8-C8B834540E00");
//        ItemDAO itemDAO = new ItemDAOImpl();
//        UserDAO userDAO = new UserDAOImpl();
//        user = (User) userDAO.loadUser(user);
//        Category category = new Category(null, "categoria 1", "descricao");
//        Item item = new Item(null, "serviço 1", "descrição", new BigDecimal(50), 1, true, user.getUser(), category, null);
//        Object responseItem = itemDAO.createItem(item);
//        if (responseItem instanceof BackendlessCollection) {
//            Toast.makeText(this, "deu certo", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(this, responseItem.toString(), Toast.LENGTH_LONG).show();
//        }
//        Object response = itemDAO.searchItem(null);
//        if (response instanceof BackendlessCollection) {
//            BackendlessCollection<Item> itens = (BackendlessCollection<Item>) response;
//            Toast.makeText(this, "deu certo", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(this, response.toString(), Toast.LENGTH_LONG).show();
//        }
//        if (v.getId() == btnSignIn.getId())
//            attemptLogin();
    }

    public void login(String username, String password) {
//        /**
//         * This will call the login service of Backendless
//         * @param String username
//         * @param String password
//         * @param AsyncCallback<BackendlessUser> callback
//         * @param Boolean stayLoggedIn
//         * */
//        Backendless.UserService.login(username, password, new AsyncCallback<BackendlessUser>() {
//
//            public void handleResponse(BackendlessUser user) {
//                //new activity
//                hideProgressDialog();
////                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
////                startActivity(mainActivity);
////                finish();
//                Toast.makeText(getApplicationContext(), "Logado", Toast.LENGTH_LONG).show();
//            }
//
//            public void handleFault(BackendlessFault fault) {
//                //show some error
//                hideProgressDialog();
//                Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_LONG).show();
//            }
//
//        }, true);
    }
}





