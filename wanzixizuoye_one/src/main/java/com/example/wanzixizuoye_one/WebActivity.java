package com.example.wanzixizuoye_one;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class WebActivity extends AppCompatActivity {

    private ImageView mWebImg;
    private TextView mWebTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
        Intent intent = getIntent();
        String pic = intent.getStringExtra("11");
        String title = intent.getStringExtra("22");

        mWebTitle.setText(title);
        Glide.with(this).load(mWebImg);
    }

    private void initView() {
        mWebImg = (ImageView) findViewById(R.id.WebImg);
        mWebTitle = (TextView) findViewById(R.id.webTitle);
    }
}
