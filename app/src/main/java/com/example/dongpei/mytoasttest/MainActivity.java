package com.example.dongpei.mytoasttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomToast toast;
    private Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button.setOnClickListener(this);

        CustomToast.makeText(getApplicationContext(), "弹出自定义背景Toast",
                CustomToast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                CustomToast.makeText(getApplicationContext(),  "确定",
                        0).show();
                break;
            case R.id.button2:
                CustomToast.makeText(getApplicationContext(), this, "这是另外一个演示样式",
                        1).show();
                break;
        }

    }

}
