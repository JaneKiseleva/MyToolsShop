package com.example.mytoolsshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DrillDetailActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageViewDrill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);
        imageViewDrill = findViewById(R.id.imageViewDrill);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null) {
            actionBar.hide(); //Метод hide() позволяет скрывать объекты
        }
        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewDrill.setImageResource(resId);
        } else {
            Intent backToCategory = new Intent(this, DrillGategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}
