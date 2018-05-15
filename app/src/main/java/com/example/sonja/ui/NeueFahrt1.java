package com.example.sonja.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class NeueFahrt1 extends AppCompatActivity implements View.OnClickListener{

    Button btn_weiter_screen2;
    Button btn_search;
    Button btn_offer;
    Button btn_both;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neue_fahrt1);

        // Buttons OnClickListener
        btn_weiter_screen2 = findViewById(R.id.btn_weiter_screen2);
        btn_weiter_screen2.setOnClickListener(this);

        btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(this);

        btn_offer = findViewById(R.id.btn_offer);
        btn_offer.setOnClickListener(this);

        btn_both = findViewById(R.id.btn_both);
        btn_both.setOnClickListener(this);

        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner_umweg);
        //create a list of items for the spinner.
        String[] items = new String[]{"5", "0", "7", "10", "15"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);

        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_weiter_screen2:
                // auf Screen3 weiterleiten
                Intent intent = new Intent(this, NeueFahrt2.class);
                startActivity(intent);
                this.finish();
                break;

            case R.id.btn_search:
                // do your code
                btn_offer.setBackgroundResource(R.color.button_color);
                btn_both.setBackgroundResource(R.color.button_color);
                btn_search.setBackgroundColor(Color.CYAN);
                break;

            case R.id.btn_offer:
                // do your code
                btn_search.setBackgroundResource(R.color.button_color);
                btn_both.setBackgroundResource(R.color.button_color);
                btn_offer.setBackgroundColor(Color.CYAN);
                break;

            case R.id.btn_both:
                // do your code
                btn_search.setBackgroundResource(R.color.button_color);
                btn_offer.setBackgroundResource(R.color.button_color);
                btn_both.setBackgroundColor(Color.CYAN);
                break;

            default:
                break;
        }

    }

    // When clicking back you get redirected to starting screen.
    public void onBackPressed(){
        System.out.println("Neue Fahrt1 onBackPressed() aufgerufen.");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}