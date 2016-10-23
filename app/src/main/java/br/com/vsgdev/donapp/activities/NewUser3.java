package br.com.vsgdev.donapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.vsgdev.donapp.R;


public class NewUser3 extends Activity implements View.OnClickListener {
    private Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_3);
        finish = (Button) findViewById(R.id.btn_next_new_user_3);
        finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
