package com.mapps.currencyconvertor;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view)  {

        EditText dollarinp= (EditText) findViewById(R.id.dollar_inp);
        Log.i("DollarField: ",dollarinp.getText().toString());
        Double dollaramt= Double.parseDouble(dollarinp.getText().toString());
        Double rupeeamt= dollaramt*68.17;
        Log.i("RupeeAmount: ",rupeeamt.toString());
        Toast.makeText(getApplicationContext(),"Rs. " + rupeeamt.toString(),Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
