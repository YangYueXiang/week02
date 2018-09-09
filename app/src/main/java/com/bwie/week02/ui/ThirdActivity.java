package com.bwie.week02.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.week02.R;
import com.fyales.tagcloud.library.TagBaseAdapter;
import com.fyales.tagcloud.library.TagCloudLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdActivity extends AppCompatActivity {

    @BindView(R.id.ss)
    EditText ss;
    @BindView(R.id.btn_ss)
    Button btnSs;
    @BindView(R.id.container)
    TagCloudLayout container;
    private ArrayList<String> list;
    private TagBaseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        mAdapter = new TagBaseAdapter(this, list);
        btnSs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = ss.getText().toString();
                list.add(s);
                mAdapter.notifyDataSetChanged();
            }
        });
        container.setAdapter(mAdapter);
       container.setItemClickListener(new TagCloudLayout.TagItemClickListener() {
           @Override
           public void itemClick(int position) {
               Toast.makeText(ThirdActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(ThirdActivity.this, FourActivity.class);
               startActivity(intent);
           }
       });
    }
}
