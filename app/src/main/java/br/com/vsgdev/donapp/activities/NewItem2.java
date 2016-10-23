package br.com.vsgdev.donapp.activities;

/**
 * Created by Jose Lins on 22/10/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.vsgdev.donapp.R;
import br.com.vsgdev.donapp.models.Institution;
import br.com.vsgdev.donapp.models.Item;
import br.com.vsgdev.donapp.utils.InstituitionChoseAdapter;


public class NewItem2 extends Activity {

    private ListView lvInstitutions;
    private Button next;
    private InstituitionChoseAdapter instituitionChoseAdapter;
    private Item item;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item_2);
        item = (Item) getIntent().getSerializableExtra("ITEM");
        Institution i1 = new Institution("1", "Lar de maria", getString(R.string.grande_600), null, null);
        Institution i2 = new Institution("2", "APIPA", getString(R.string.grande_600), null, null);
        Institution i3 = new Institution("3", "Teste1", getString(R.string.grande_600), null, null);
        Institution i4 = new Institution("4", "teste2", getString(R.string.grande_600), null, null);
        Institution i5 = new Institution("5", "teste3", getString(R.string.grande_600), null, null);
        Institution i6 = new Institution("6", "test54", getString(R.string.grande_600), null, null);
        Institution i7 = new Institution("7", "La", getString(R.string.grande_600), null, null);
        Institution i8 = new Institution("8", "teste56", getString(R.string.grande_600), null, null);
        Institution i9 = new Institution("9", "teste7", getString(R.string.grande_600), null, null);
        ArrayList<Institution> institutions = new ArrayList<>();
        institutions.add(i1);
        institutions.add(i2);
        institutions.add(i3);
        institutions.add(i4);
        institutions.add(i5);
        institutions.add(i6);
        institutions.add(i7);
        institutions.add(i8);
        institutions.add(i9);

        lvInstitutions = (ListView) findViewById(R.id.lv_institutions_new_item_2);
        instituitionChoseAdapter = new InstituitionChoseAdapter(this, institutions);
        lvInstitutions.setAdapter(instituitionChoseAdapter);

        next = (Button) findViewById(R.id.btn_next_new_item_2);
    }

    public void choosePrice(View view) {
        if (next.isPressed()) {
            if (instituitionChoseAdapter.getSelected().isEmpty()) {
                Toast.makeText(this, getString(R.string.you_need_to_chose_at_least_one), Toast.LENGTH_SHORT).show();
            } else {
                item.setInstitutions(instituitionChoseAdapter.getSelected());
                Intent newItem3 = new Intent(this, NewItem3.class);
                newItem3.putExtra("ITEM", item);
                startActivity(newItem3);
            }
        }
    }

    public void cancel(View view){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }
}
