package com.example.dongpei.mytoasttest;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dong.pei on 2017/3/30.
 */

public class CustomToast {

    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT; //数值为0
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;   //数值为1

    Toast toast;
    Context mContext;
    TextView toastTextField;

    public CustomToast(Context context) {
        mContext = context;
        toast = new Toast(mContext);
        toast.setGravity(Gravity.CENTER, 0, 0);// 位置会比原来的Toast偏上一些
        View toastRoot = LayoutInflater.from(context).inflate(R.layout.custom_toast, null);
//        View toastRoot = activity.getLayoutInflater().inflate(R.layout.custom_toast, null);
        toastTextField = (TextView) toastRoot.findViewById(R.id.toast_text);
        Drawable drawable = context.getResources().getDrawable(R.drawable.icon_pro_xhdpi);
        drawable.setBounds(0,0,33,33);
        toastTextField.setCompoundDrawables(drawable,null,null,null);
        toast.setView(toastRoot);
    }

    public CustomToast(Context context,Activity activity) {
        mContext = context;
        toast = new Toast(mContext);
        toast.setGravity(Gravity.CENTER, 0, 0);// 位置会比原来的Toast偏上一些
        View toastRoot = activity.getLayoutInflater().inflate(R.layout.toast_custom, null);
//        View toastRoot = activity.getLayoutInflater().inflate(R.layout.custom_toast, null);
        toastTextField = (TextView) toastRoot.findViewById(R.id.toast_text);
        toast.setView(toastRoot);
    }

    public void setDuration(int d) {
        toast.setDuration(d);
    }

    public void setText(String t) {
        toastTextField.setText(t);
    }

    public static CustomToast makeText(Context context, String text, int duration) {
        CustomToast toastCustom = new CustomToast(context);
        toastCustom.setText(text);
        toastCustom.setDuration(duration);
        return toastCustom;
    }

    public static CustomToast makeText(Context context,Activity activity, String text, int duration) {
        CustomToast toastCustom = new CustomToast(context,activity);
        toastCustom.setText(text);
        toastCustom.setDuration(duration);
        return toastCustom;
    }

    public void show() {
        toast.show();
    }
    
}