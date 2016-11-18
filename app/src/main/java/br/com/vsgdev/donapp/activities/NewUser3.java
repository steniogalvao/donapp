package br.com.vsgdev.donapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.persistence.local.UserTokenStorageFactory;

import br.com.vsgdev.donapp.R;
import br.com.vsgdev.donapp.dao.UserDAO;
import br.com.vsgdev.donapp.daoImpl.UserDAOImpl;
import br.com.vsgdev.donapp.models.User;
import br.com.vsgdev.donapp.utils.ValidateUtils;


public class NewUser3 extends Activity  {
    private Button finish;
    private EditText password;
    private EditText password2;
    private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_3);
        password = (EditText) findViewById(R.id.et_password_newuser3);
        password2 = (EditText) findViewById(R.id.et_repeat_password_newuser3);

        finish = (Button) findViewById(R.id.btn_next_new_user_3);
    }


    public void signup(View v) {
        password.setError(null);
        password2.setError(null);
        password = ValidateUtils.checkEmptyWithErro(password, getApplicationContext(), getString(R.string.this_field_is_required));
        password2 = ValidateUtils.checkEmptyWithErro(password2, getApplicationContext(), getString(R.string.this_field_is_required));
        if (!password.getText().toString().equals( password2.getText().toString())) {
            password.setError(getString(R.string.passwords_dont_match));
            password2.setError(getString(R.string.passwords_dont_match));
        } else if (password.getError() == null && password2.getError() == null) {
            user = (User) getIntent().getSerializableExtra("USER");
            user.setPassword(password.getText().toString());
            UserDAO userDAO = new UserDAOImpl();
            Object response = userDAO.createUser(user);
            if (response instanceof String) {
                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
            } else {
                response = userDAO.login(user);
                if (UserTokenStorageFactory.instance().getStorage().get() != null) {
                    Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(mainActivity);
                    finish();
                }
            }

        }
    }
}
