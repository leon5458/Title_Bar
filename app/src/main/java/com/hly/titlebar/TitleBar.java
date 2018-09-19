package com.hly.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2018/9/18~~~~~~
 * ~~~~~~更改时间:2018/9/18~~~~~~
 * ~~~~~~版本号:1~~~~~~
 */
public class TitleBar extends RelativeLayout {
    private RelativeLayout layout_title;//主布局
    private TextView text_left;//左边文字
    private ImageView img_left;//左边图片
    private TextView text_right;//右边文字
    private ImageView img_right;//右边图片
    private TextView text_title;//标题

    public TitleBar(Context context) {
        super(context);
        builder(context, null, 0);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        builder(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        builder(context, attrs, defStyleAttr);
    }

    private void builder(Context context, AttributeSet attrs, int defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.toolbar_layout, this, true);
        layout_title = findViewById(R.id.layout_title);
        text_title = findViewById(R.id.text_title);
        text_left = findViewById(R.id.text_left);
        img_left = findViewById(R.id.img_left);
        text_right = findViewById(R.id.text_right);
        img_right = findViewById(R.id.img_right);

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
            if (typedArray != null) {
                //处理titleBar背景色
                int title_background_color = typedArray.getColor(R.styleable.TitleBar_layout_background_color, Color.WHITE);
                setTitlebackground_color(title_background_color);//设置
                //左边文字
                boolean leftTextVisible = typedArray.getBoolean(R.styleable.TitleBar_left_text_visible, false);
                if (leftTextVisible) {
                    text_left.setVisibility(View.GONE);
                } else {
                    text_left.setVisibility(View.VISIBLE);
                }
                setShowleftTextVisible(leftTextVisible);//设置
                //左边图片
                boolean leftImageVisible = typedArray.getBoolean(R.styleable.TitleBar_left_img_visible, true);
                if (leftImageVisible) {
                    img_left.setVisibility(View.VISIBLE);
                } else {
                    img_left.setVisibility(View.GONE);
                }
                setShowleftImageVisible(leftImageVisible);//设置
                // 标题
                boolean titleTextVisible = typedArray.getBoolean(R.styleable.TitleBar_title_text_visible, true);
                if (titleTextVisible) {
                    text_title.setVisibility(View.VISIBLE);
                } else {
                    text_title.setVisibility(View.GONE);
                }
                setShowtitleTextVisible(titleTextVisible);//设置
                //右边文字
                boolean rightTextVisible = typedArray.getBoolean(R.styleable.TitleBar_right_text_visible, false);
                if (rightTextVisible) {
                    text_right.setVisibility(View.GONE);
                } else {
                    text_right.setVisibility(View.VISIBLE);
                }
                setShowrightTextVisible(rightTextVisible);//设置
                //右边图片
                boolean rightimgVisible = typedArray.getBoolean(R.styleable.TitleBar_right_img_visible, false);
                if (rightimgVisible) {
                    img_right.setVisibility(View.GONE);
                } else {
                    img_right.setVisibility(View.VISIBLE);
                }
                setShowrightimgVisible(rightimgVisible);


                int left_img = typedArray.getResourceId(R.styleable.TitleBar_left_img, R.mipmap.icon_back_b);
                int right_img = typedArray.getResourceId(R.styleable.TitleBar_right_img, R.mipmap.icon_back_b);
                setRightimage(right_img);
                setLeftImage(left_img);
                //设置左边文字大小
                int leftTextSize = typedArray.getDimensionPixelSize(R.styleable.TitleBar_left_text_size, TypedValue.COMPLEX_UNIT_MASK);
                String leftText = typedArray.getString(R.styleable.TitleBar_left_text);
                int lefttextColor = typedArray.getColor(R.styleable.TitleBar_left_textcolor, Color.BLACK);
                //设置右边文字大小
                int rightTextSize = typedArray.getDimensionPixelSize(R.styleable.TitleBar_right_text_size, TypedValue.COMPLEX_UNIT_MASK);
                String rightText = typedArray.getString(R.styleable.TitleBar_right_text);
                int righttextColor = typedArray.getColor(R.styleable.TitleBar_right_textcolor, Color.BLACK);
                //设置标题文字大小
                int titleTextSize = typedArray.getDimensionPixelSize(R.styleable.TitleBar_title_text_size, TypedValue.COMPLEX_UNIT_MASK);
                String titleText = typedArray.getString(R.styleable.TitleBar_title_text);
                int titleTextColor = typedArray.getColor(R.styleable.TitleBar_title_textcolor, Color.BLACK);

                if (!TextUtils.isEmpty(titleText)) {
                    settitleTextSize(titleTextSize);
                    settitleText(titleText);
                    settitleTextColor(titleTextColor);
                }

                if (!TextUtils.isEmpty(leftText)) {
                    setleftTextSize(leftTextSize);
                    setleftText(leftText);
                    setlefttextColor(lefttextColor);
                }

                if (!TextUtils.isEmpty(rightText)) {
                    setrightTextSize(rightTextSize);
                    setrightText(rightText);
                    setrighttextColor(righttextColor);
                }

                typedArray.recycle();
            }
        }

    }

    //获取标题栏跟布局
    public RelativeLayout getLayout_title() {
        return layout_title;
    }

    public TextView getText_left() {
        return text_left;
    }

    public ImageView getImg_left() {
        return img_left;
    }

    public TextView getText_right() {
        return text_right;
    }

    public ImageView getImg_right() {
        return img_right;
    }

    public TextView getText_title() {
        return text_title;
    }

    //设置标题栏颜色
    public void setTitlebackground_color(int title_background_color) {
        layout_title.setBackgroundColor(title_background_color);
    }

    //设置左边文字是否显示
    public void setShowleftTextVisible(boolean showleftTextVisible) {
        text_left.setVisibility(showleftTextVisible ? VISIBLE : GONE);
    }

    public void setShowleftImageVisible(boolean showleftImageVisible) {
        img_left.setVisibility(showleftImageVisible ? VISIBLE : GONE);
    }

    public void setShowtitleTextVisible(boolean showtitleTextVisible) {
        text_title.setVisibility(showtitleTextVisible ? VISIBLE : GONE);
    }

    public void setShowrightTextVisible(boolean showrightTextVisible) {
        text_right.setVisibility(showrightTextVisible ? VISIBLE : GONE);
    }

    public void setShowrightimgVisible(boolean showrightimgVisible) {
        img_right.setVisibility(showrightimgVisible ? VISIBLE : GONE);
    }

    public void setleftTextSize(int leftTextSize) {
        text_left.setTextSize(leftTextSize);
    }

    public void setleftText(String leftText) {
        text_left.setText(leftText);
    }

    public void setlefttextColor(int lefttextColor) {
        text_left.setTextColor(lefttextColor);
    }

    public void setrightTextSize(int rightTextSize) {
        text_right.setTextSize(rightTextSize);
    }

    public void setrightText(String rightText) {
        text_right.setText(rightText);
    }

    public void setrighttextColor(int righttextColor) {
        text_right.setTextColor(righttextColor);
    }

    public void settitleTextSize(int titleTextSize) {
        text_title.setTextSize(titleTextSize);
    }

    public void settitleText(String titleText) {
        text_title.setText(titleText);
    }

    public void settitleTextColor(int titleTextColor) {
        text_title.setTextColor(titleTextColor);
    }

    public void setLeftImage(int leftImage) {
        img_left.setImageResource(leftImage);
    }

    public void setRightimage(int rightimage) {
        img_right.setImageResource(rightimage);
    }


    public void setTvLeftClick(OnClickListener onClickListener){
        if (onClickListener!=null){
            text_left.setOnClickListener(onClickListener);
        }
    }

    public void setTvRightClick(OnClickListener onClickListener){
        if (onClickListener!=null){
            text_right.setOnClickListener(onClickListener);
        }
    }

    public void setTvTitleClick(OnClickListener onClickListener){
        if (onClickListener!=null){
            img_left.setOnClickListener(onClickListener);
        }
    }

    public void setImgLeftClick(OnClickListener onClickListener){
        if (onClickListener!=null){
            img_left.setOnClickListener(onClickListener);
        }
    }

    public void setImgRightClick(OnClickListener onClickListener){
        if (onClickListener!=null){
            img_right.setOnClickListener(onClickListener);
        }
    }


//  public interface TitleBarOnClick{
//        void tvLeftClick();
//        void ivLeftClick();
//        void tvRightClick();
//        void ivRightClick();
//
//  }

}
