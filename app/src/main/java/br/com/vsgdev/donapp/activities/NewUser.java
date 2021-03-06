package br.com.vsgdev.donapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.vsgdev.donapp.R;
import br.com.vsgdev.donapp.models.User;
import br.com.vsgdev.donapp.utils.UserLogedSingleton;
import br.com.vsgdev.donapp.utils.ValidateUtils;


public class NewUser extends Activity implements View.OnClickListener {

    private Button next;
    private User user = new User();
    private EditText name, surname;
    private TextView termOfUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_1);
        name = (EditText) findViewById(R.id.et_name_new_user);
        surname = (EditText) findViewById(R.id.et_surname_new_user);
        next = (Button) findViewById(R.id.btn_next_new_user_1);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (next.isPressed()) {
            name = ValidateUtils.checkEmptyWithErro(name, getApplicationContext(), getString(R.string.this_field_is_required));
            surname = ValidateUtils.checkEmptyWithErro(surname, getApplicationContext(), getString(R.string.this_field_is_required));
            if (name.getError() == null && surname.getError() == null) {
                user.setName(name.getText().toString());
                user.setSurname(surname.getText().toString());
                Intent newUser2 = new Intent(this, NewUser2.class);
                newUser2.putExtra("USER", user);
                startActivity(newUser2);
            }
        }
    }
}
