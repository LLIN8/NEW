package com.example.liangminglin.menu2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;


public class orderSummary extends AppCompatActivity {

    //create db object
    DBManager db;

    //create a text object
    TextView orders;

    //create a button
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        //point to the database
        db = new DBManager(this);

        //point to the object
        orders = (TextView) findViewById(R.id.name_O);
        go = (Button) findViewById(R.id.Pay);




        Cursor res = db.getAllData();

        StringBuffer buff = new StringBuffer();
        StringBuffer buff1 = new StringBuffer();
        StringBuffer buff2 = new StringBuffer();

        do {

            buff.append("Name: " + res.getString(0) + " X " + res.getString(1) + "     Price: " + res.getString(2) + "\n");
            //buff1.append("# of Orders: " + res.getString(1) + "\n");
            //buff2.append("Price: " + res.getString(2) + "\n");
        }while(res.moveToNext());

        orders.setText(buff);
        goTo();
    }

    public void goTo()
    {
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(orderSummary.this, Payment.class));
            }
        });
    }

}
