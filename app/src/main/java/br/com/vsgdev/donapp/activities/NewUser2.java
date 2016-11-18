package br.com.vsgdev.donapp.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;

import br.com.vsgdev.donapp.R;
import br.com.vsgdev.donapp.dao.UserDAO;
import br.com.vsgdev.donapp.daoImpl.UserDAOImpl;
import br.com.vsgdev.donapp.models.User;
import br.com.vsgdev.donapp.utils.ValidateUtils;


public class NewUser2 extends BaseActivity {

    private Button next;
    private EditText email;
    private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_2);
        email = (EditText) findViewById(R.id.et_email_new_user_2);
        next = (Button) findViewById(R.id.btn_next_new_user_2);
    }

    public void next(View view) {
        email = ValidateUtils.checkEmptyWithErro(email, getApplicationContext(), getString(R.string.this_field_is_required));
        if (email.getError() == null) {
            user.setEmail(email.getText().toString());
            UserDAO userDAO = new UserDAOImpl();
            BackendlessCollection response = (BackendlessCollection) userDAO.searchByEmail(user);
            if (response.getTotalObjects() > 0) {
                email.setError("Email already exist");
            } else {
                user = (User) getIntent().getSerializableExtra("USER");
                user.setEmail(email.getText().toString());
                Intent newUser3 = new Intent(getApplicationContext(), NewUser3.class);
                newUser3.putExtra("USER", user);
                startActivity(newUser3);
            }
        }

    }

}

