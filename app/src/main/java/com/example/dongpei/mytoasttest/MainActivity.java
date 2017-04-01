package com.example.dongpei.mytoasttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
/**
*  测试用例
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    private CustomToast toast;
    private Button button,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button2.setOnClickListener(this);
        button.setOnClickListener(this);

        CustomToast.makeText(getApplicationContext(),R.string.details,R.string.back_cancel,0).show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                CustomToast.makeText(getApplicationContext(),"确定",
                        0).show();
                break;
            case R.id.button2:
                CustomToast.makeText(getApplicationContext(),R.string.account_bind,R.color.colorPrimary,R.color.colorAccent,0).show();
                break;
            case R.id.button3:
                PhiToast.makeText(getApplicationContext(),R.string.account_manage,R.color.colorPrimaryDark,R.color.colorAccent,0).show();
                break;
        }

    }

}
