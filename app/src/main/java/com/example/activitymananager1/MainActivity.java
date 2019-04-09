package com.example.activitymananager1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvName; //text view
    private EditText etInput; //edit text

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //connects to activity main

        //show a message
        Toast.makeText(this,"onCreate()",Toast.LENGTH_SHORT).show();

        Button btnLoad = findViewById(R.id.activity_main__btn__load);
        btnLoad.setOnClickListener(this);

        Button btnLaunch = findViewById(R.id.activity_name_btn__launch__activity);
        btnLaunch.setOnClickListener(this);

        TextView tvTitle = findViewById(R.id.activity_main__tv__title);
        tvTitle.setOnClickListener(this);

        tvName = findViewById(R.id.activity_main__tv___name);
        tvName.setOnClickListener(this);

        etInput = findViewById(R.id.activity_main__et__input);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) { //when a lot of repetitions

        String message = null;

        switch (v.getId()) {
            case R.id.activity_main__btn__load:
                message = "button clicked";
                tvName.setText(etInput.getText().toString());
                tvName.setBackgroundColor(getResources().getColor(R.color.myFavColor));
                break;
            case R.id.activity_main__tv__title:
                message = "title clicked";
                break;
            case  R.id.activity_main__tv___name:
                message = "";
                break;
            case R.id.activity_name_btn__launch__activity:
                Intent intent = new Intent(this, DetailActivity.class);
                intent.putExtra("data from main-activity", tvName.getText());

                startActivityForResult(intent,101);

                //startActivity(intent);
                break;

            default:
        }

        if (message != null) { //run this message as long the message is not empty
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override //rotate the screen to save the information on screen on a bundle (parcelable information)
    protected void onSaveInstanceState(Bundle outState) { //Bundle is a map between a string and parcelable value (primitive value)
        super.onSaveInstanceState(outState);
        outState.putString("data from edit-text", etInput.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) { //outState = savedInstanceState
        super.onRestoreInstanceState(inState);
        tvName.setText(inState.getString("data from edit-text"));
        tvName.setBackgroundColor(getResources().getColor(R.color.myFavColor));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == Activity.RESULT_OK && data != null) {

        String returnData = data.getStringExtra("return_data");
        Toast.makeText(this,
                "Data returned: " + returnData,
        Toast.LENGTH_SHORT).show();
    }
}}
