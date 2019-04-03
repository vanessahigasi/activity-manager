package com.example.activitymananager1;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class A implements View.OnClickListener {
    @Override
    public void onClick(View v) {

        Toast.makeText(v.getContext(),"A Clicked",Toast.LENGTH_SHORT).show();
    }
}
