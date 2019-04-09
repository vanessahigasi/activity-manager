package com.example.activitymananager1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    private EditText etReturnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvInfo = findViewById(R.id.activity_detail__tv__info);
        String data = getIntent().getStringExtra("data from main-activity");
        tvInfo.setText(data);

        etReturnData = findViewById(R.id.activity_detail___et___return_data);

        Button btnReturnInfo = findViewById(R.id.activity_detail__btn__return__info);
        btnReturnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("return_data", etReturnData.getText().toString());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }

}
