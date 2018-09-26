package com.ypx.imagepickerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ypx.imagepicker.ImagePicker;
import com.ypx.imagepicker.bean.ImageItem;
import com.ypx.imagepicker.interf.OnImagePickCompleteListener;
import com.ypx.imagepicker.utils.ProcessUtil;

import java.util.List;

/**
 * 作者：yangpeixing on 2018/6/21 14:10
 * 功能：
 * 产权：南京婚尚信息技术
 */
public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.withImageLoader(new GlideImgLoader())
                        .pick(SecondActivity.this, new OnImagePickCompleteListener() {
                            @Override
                            public void onImagePickComplete(List<ImageItem> items) {
                                Toast.makeText(SecondActivity.this, "调用了" + items.size(), 0).show();
                            }
                        });
            }
        });
        Log.e("process", "SecondActivity: " + ProcessUtil.getAppName(this));
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
