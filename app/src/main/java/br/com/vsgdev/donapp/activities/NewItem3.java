package br.com.vsgdev.donapp.activities;

/**
 * Created by Jose Lins on 22/10/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;

import java.math.BigDecimal;

import br.com.vsgdev.donapp.R;
import br.com.vsgdev.donapp.dao.ItemDAO;
import br.com.vsgdev.donapp.daoImpl.ItemDAOImpl;
import br.com.vsgdev.donapp.models.Item;
import br.com.vsgdev.donapp.utils.InstituitionMoneyAdapter;


public class NewItem3 extends Activity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar sbToMe, sbCharity;
    private Button btnValueToMe, btnValueCharity, btnTaxValue, btnNext;
    private BigDecimal charityValue, avaliableValue;
    private int toMePercentage, charityPercentage;
    private Item item;
    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
    private InstituitionMoneyAdapter instituitionMoneyAdapter;
    private static final BigDecimal TAX_VALUE = new BigDecimal(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item_3);
        sbToMe = (SeekBar) findViewById(R.id.sb_me_new_item_3);
        btnValueToMe = (Button) findViewById(R.id.btn_value_tome_new_item_3);
        sbCharity = (SeekBar) findViewById(R.id.sb_charity_new_item_3);
        btnValueCharity = (Button) findViewById(R.id.btn_value_charity_new_item_3);
        btnTaxValue = (Button) findViewById(R.id.btn_tax_new_item_3);
        btnNext = (Button) findViewById(R.id.btn_next_new_item_3);
        item = (Item) getIntent().getSerializableExtra("ITEM");
        toMePercentage = 0;
        charityPercentage = 100;
        avaliableValue = calcPercentage(item.getValue(), ONE_HUNDRED.subtract(TAX_VALUE));
        btnTaxValue.setText("R$ " + calcPercentage(item.getValue(), TAX_VALUE));
        sbToMe.setProgress(toMePercentage);
        sbCharity.setProgress(charityPercentage);

        btnValueToMe.setText("R$ 0");
        btnValueCharity.setText("R$ " + avaliableValue);
        sbToMe.setOnSeekBarChangeListener(this);
        sbCharity.setOnSeekBarChangeListener(this);

        ListView lvCharities = (ListView) findViewById(R.id.lv_charity_new_item_3);
        instituitionMoneyAdapter = new InstituitionMoneyAdapter(this, item.getInstitutions());
        instituitionMoneyAdapter.setCharityValue(avaliableValue);
        lvCharities.setAdapter(instituitionMoneyAdapter);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (sbToMe.isPressed()) {
            if (fromUser) {
                sbCharity.setProgress(100 - progress);
                refreshValues();
            }
        }
        if (sbCharity.isPressed()) {
            if (fromUser) {
                sbToMe.setProgress(100 - progress);
                refreshValues();
            }
        }
        checkSeekBarBlock();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void checkSeekBarBlock() {
        if (sbCharity.getProgress() < 30) {
            sbCharity.setProgress(30);
            sbToMe.setProgress(70);
        }
    }

    private void refreshValues() {
        charityValue = calcPercentage(avaliableValue, new BigDecimal(sbCharity.getProgress()));
        btnValueCharity.setText("R$ " + charityValue);
        btnValueToMe.setText("R$ " + calcPercentage(item.getValue(), new BigDecimal(sbToMe.getProgress())));
        instituitionMoneyAdapter.setCharityValue(charityValue);
    }
 
    private BigDecimal calcPercentage(BigDecimal value, BigDecimal percentage) {
        return value.multiply(percentage).divide(ONE_HUNDRED);
    }

    public void confirmNewItem(View view) {
        if (btnNext.isPressed()) {
            ItemDAO itemDAO = new ItemDAOImpl();
            Object response = itemDAO.createItem(item);
            if (response instanceof Item) {
                Snackbar.make(getCurrentFocus(), "Salvo com sucesso", Snackbar.LENGTH_LONG).show();
            } else {
                Snackbar.make(getCurrentFocus(), "erro ao salvar", Snackbar.LENGTH_LONG).show();
            }
            Intent main = new Intent(this, MainActivity.class);
            startActivity(main);
            finish();
        }
    }

    public void cancel(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
        finish();
    }
}
