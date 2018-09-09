package com.bwie.week02.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bwie.week02.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class FourActivity extends AppCompatActivity {


    private Button btn01;
    private ImageView img02;
    private EditText sao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        //初始化

        btn01 = findViewById(R.id.btn01);
        img02 = findViewById(R.id.img02);
        sao = findViewById(R.id.sao);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = sao.toString();
                Bitmap bitmap = CodeUtils.createImage(s, 200, 200, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                img02.setImageBitmap(bitmap);
            }
        });

    }
}
