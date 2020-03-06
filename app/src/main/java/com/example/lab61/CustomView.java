package com.example.lab61;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class CustomView extends LinearLayout {
    TextView textView;
    RadioButton radioButton1,radioButton2,radioButton3,radioButton4;

    public CustomView(Context context){
        super(context);

        //Inflate the view
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.custom_view,this,true);

        textView = findViewById(R.id.textView);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);


    }
    public CustomView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);

        //Inflate the view
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        li = (LayoutInflater)getContext().getSystemService(infService);
        li.inflate(R.layout.custom_view,this,true);

        textView = findViewById(R.id.textView);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
    }
}
