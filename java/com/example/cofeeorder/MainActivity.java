package com.example.cofeeorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int c = 0;
    String val;
    String name;
    int coffeeprice = 10;
    public static final String TAG = "MainActivity";

    public void submitOrder(View view) {
        displayQuantity(c);
        orderSummary(c);
       // Log.i(TAG, "displayQuantity: " + a);
       //          displayMsg(a);

    }
    public void displayMsg(String msg) {
        TextView tv = findViewById(R.id.price);
        tv.setText(msg);
    }

    private void displayQuantity(int num) {
        TextView tv = findViewById(R.id.text1);
        tv.setText("" + num);

        Log.i(TAG,"displayQuantity: "+num);
    }

    public void add(View view) {
        c = c + 1;
        displayQuantity(c);
    }

    public void sub(View view) {
        c = c - 1;
        displayQuantity(c);
    }


    public void orderSummary(int c) {

        //coffeeprice=5;
     val= radioCheck(c);
     Log.i(TAG, "orderSummary: Radiocheck completed");
      // return val;

        String email = "samantaroypriyanka@gmail.com";
        String sub = "Order bill";
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_EMAIL,email);
            intent.putExtra(Intent.EXTRA_SUBJECT,sub);
            intent.putExtra(Intent.EXTRA_TEXT,val);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }



    public String radioCheck(int c)
    {
        RadioButton r1, r2, r3, r4;
        CheckBox cb1, cb2, cb3;
        TextView tv1, tv2;
        RadioGroup rg;
        EditText edit;
        final String greeting = "\nThank You";

        cb1 = (CheckBox)findViewById(R.id.cb1);
        cb2 = (CheckBox)findViewById(R.id.cb2);
        cb3 = (CheckBox)findViewById(R.id.cb3);
        r1 = (RadioButton) findViewById(R.id.rb1);
        r2 = (RadioButton) findViewById(R.id.rb2);
        r3 = (RadioButton) findViewById(R.id.rb3);
        rg = (RadioGroup) findViewById(R.id.rg);
        edit = (EditText) findViewById(R.id.edit);
        boolean isr1 = r1.isChecked();
        boolean isr2 = r2.isChecked();
        boolean isr3 = r3.isChecked();

        boolean iscb1 = cb1.isChecked();
        boolean iscb2 = cb2.isChecked();
        boolean iscb3 = cb3.isChecked();
        name = edit.getText().toString();
        val = "Name : " + name + "\nQuantity : " + c + "\n Price : $" +coffeeprice*c;


        if(iscb1)
        {
            val = val + "\nWhipped Cream added.";
            coffeeprice = coffeeprice+1;
        }
        else
        {
            val = val + "\nNo Whipped Cream added." ;
        }

        if(iscb2)
        {
            val = val + "\nChocolate Sauce added.";
            coffeeprice = coffeeprice+2;
        }
        else {
            val = val + "\nNo Chocolate Sauce added.";
        }

        if(iscb3)
        {
            val = val + "\nCaramel added.";
            coffeeprice = coffeeprice+3;
        }
        else
        {
            val = val + "\nNo Caramel added.";
        }

        if (isr1)
        {
            val = val + "\nYou have chosen Latté." + greeting;
            //coffeeprice = coffeeprice + 5;
            return val;
        }
        else if(isr2)
        {
            val = val + "\nYou have chosen Esprésso." + greeting;
           //coffeeprice = coffeeprice + 7;
            return val;
        }
        else if(isr3)
        {
            val = val + "\nYou have chosen Frappuchino." + greeting;
            //coffeeprice = coffeeprice + 10;
            return val;
        }
        else
        {
            val = "\nPlease choose a coffee type.";
            return val;
        }



    }

}