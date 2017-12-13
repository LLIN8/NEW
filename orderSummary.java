package com.example.liangminglin.mytab;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.app.AlertDialog.Builder;

import org.w3c.dom.Text;

public class orderSummary extends AppCompatActivity {

    //create db object
    DBManager db;

    //create a text object
    TextView orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        //point to the database
        db = new DBManager(this);

        //point to the textbox
        orders = (TextView) findViewById(R.id.name_O);



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
    }
}
