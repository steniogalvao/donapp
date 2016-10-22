package br.com.vsgdev.donapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

import br.com.vsgdev.donapp.models.Item;
import br.com.vsgdev.donapp.utils.ValidateUtils;

import br.com.vsgdev.donapp.R;

/**
 * Created by Jose Lins on 22/10/2016.
 */

public class NewItem1 extends Activity implements View.OnClickListener {

    private Button next;
    private EditText name, description, value, amount;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item_1);

        next = (Button) findViewById(R.id.btn_next_new_item_1);
        next.setOnClickListener(this);
        name = (EditText) findViewById(R.id.et_item_name_new_item_1);
        description = (EditText) findViewById(R.id.et_description_new_item_1);
        value = (EditText) findViewById(R.id.et_value_new_item_1);
        amount = (EditText) findViewById(R.id.et_amount_new_item_1);
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            Item item = (Item) bundle.getSerializable("ITEM");
            if (item != null) {
                name.setText(item.getName());
                description.setText(item.getDescription());
                value.setText(item.getValue().toString());
                amount.setText(String.valueOf(item.getQuantity()));
            }
        }

    }

    @Override
    public void onClick(View view) {

    }
}