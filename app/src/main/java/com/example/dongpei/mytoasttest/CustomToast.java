package com.example.dongpei.mytoasttest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dong.pei on 2017/3/30.
 */
/**
   自定义toast，各种类型都有
 */

public class CustomToast {

    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT; //数值为0
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;   //数值为1
    private GradientDrawable myGrad;

    Toast toast;
    Context mContext;
    TextView toastTextField;

    // 带图片的toast
    public CustomToast(Context context) {
        mContext = context;
        toast = new Toast(mContext);
        toast.setGravity(Gravity.CENTER, 0, 0);// 位置会比原来的Toast偏上一些
        View toastRoot = LayoutInflater.from(context).inflate(R.layout.custom_toast, null);

//        View toastRoot = activity.getLayoutInflater().inflate(R.layout.custom_toast, null);
        toastTextField = (TextView) toastRoot.findViewById(R.id.toast_text);

        Drawable drawable = context.getResources().getDrawable(R.drawable.icon_pro_xhdpi);
        //设定图片大小
        drawable.setBounds(0,0,33,33);
        toastTextField.setCompoundDrawables(drawable,null,null,null);
        toast.setView(toastRoot);
    }

    // 自定义背景颜色的纯文字toast
    public CustomToast(Context context,@StringRes int strContent, @ColorRes int bgColor, @ColorRes int tvColor) {
        mContext = context;
        toast = new Toast(mContext);
        toast.setGravity(Gravity.CENTER, 0, 0);// 位置会比原来的Toast偏上一些
        View toastRoot = LayoutInflater.from(context).inflate(R.layout.toast_customer, null);
//        // 设置View的颜色
//        toastRoot.setBackgroundColor(context.getResources().getColor(bgColor));

//        View toastRoot = activity.getLayoutInflater().inflate(R.layout.custom_toast, null);
        toastTextField = (TextView) toastRoot.findViewById(R.id.toast_text);
        toastTextField.setText(context.getResources().getString(strContent));
        // 设置背景shape颜色
        myGrad = (GradientDrawable) toastTextField.getBackground();
        myGrad.setColor(context.getResources().getColor(bgColor));
//        toastTextField.setBackgroundResource(bgColor);

//        toastTextField.setBackgroundColor(context.getResources().getColor(bgColor));
        // 设定文本文字颜色
        toastTextField.setTextColor(context.getResources().getColor(tvColor));
        toast.setView(toastRoot);
    }

    // 不带图片的纯文字toast
    public CustomToast(Context context,Activity activity) {
        mContext = context;
        toast = new Toast(mContext);
        toast.setGravity(Gravity.CENTER, 0, 0);// 位置会比原来的Toast偏上一些
        View toastRoot = activity.getLayoutInflater().inflate(R.layout.toast_custom, null);
//        View toastRoot = activity.getLayoutInflater().inflate(R.layout.custom_toast, null);
        toastTextField = (TextView) toastRoot.findViewById(R.id.toast_text);
        toast.setView(toastRoot);
    }

    //带有标题栏的的toast
    public CustomToast(Context context,@StringRes int strId,@StringRes int strId2) {
        mContext = context;
        toast = new Toast(mContext);
        toast.setGravity(Gravity.CENTER, 0, 0);// 位置会比原来的Toast偏上一些
        View toastRoot = LayoutInflater.from(context).inflate(R.layout.customer_toast, null);
        // 设定标题内容
        TextView tvTitleName = (TextView) toastRoot.findViewById(R.id.tvTitleName);
        tvTitleName.setText(context.getResources().getString(strId));
        // 设定文字内容
        TextView tvContent = (TextView) toastRoot.findViewById(R.id.tvContent);
        tvContent.setText(context.getResources().getString(strId2));
        Drawable drawable = context.getResources().getDrawable(R.drawable.icon_pro_xhdpi);
        //设定图片大小
        drawable.setBounds(0,0,33,33);
        tvContent.setCompoundDrawables(drawable,null,null,null);
        toast.setView(toastRoot);
    }



    public void setDuration(int d) {
        toast.setDuration(d);
    }

    public void setText(String t) {
        toastTextField.setText(t);
    }

    //显示带图片的toast
    public static CustomToast makeText(Context context, String text, int duration) {
        CustomToast toastCustom = new CustomToast(context);
        toastCustom.setText(text);
        toastCustom.setDuration(duration);
        return toastCustom;
    }

    // 显示纯文字的toast
    public static CustomToast makeText(Context context,Activity activity, String text, int duration) {
        CustomToast toastCustom = new CustomToast(context,activity);
        toastCustom.setText(text);
        toastCustom.setDuration(duration);
        return toastCustom;
    }

    //显示自定义样式的toast
    public static CustomToast makeText(Context context,@StringRes int strContent,@ColorRes int bgColor, @ColorRes int tvColor,int duration) {
        CustomToast toastCustom = new CustomToast(context,strContent,bgColor,tvColor);
        toastCustom.setDuration(duration);
        return toastCustom;
    }

    //显示带有标题栏样式的toast
    public static CustomToast makeText(Context context,@StringRes int strTitle,@StringRes int strContent,int duration) {
        CustomToast toastCustom = new CustomToast(context,strTitle,strContent);
        toastCustom.setDuration(duration);
        return toastCustom;
    }

    public void show() {
        toast.show();
    }
    
}