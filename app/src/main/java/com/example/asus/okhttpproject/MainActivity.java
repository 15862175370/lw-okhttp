package com.example.asus.okhttpproject;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.okhttp.sdk.HttpUtility;
import com.okhttp.sdk.callback.StringCallback;
import com.okhttp.sdk.config.HttpMethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("哈哈哈哈","哈哈哈哈=");
                Map<String, String> params = new HashMap<>();
                try {
                    HttpUtility.getInstance().execute(HttpMethod.POST,"http:www.baidu.com",params,new StringCallback() {
                        @Override
                        public void onResponse(String response) {
                            Log.i("哈哈哈哈","哈哈哈哈="+response);
                            File file = new File(Environment.getExternalStorageDirectory()+"/imgehh/");
                            if(!file.exists()){
                                try {
                                    file.mkdirs();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            try {
                                FileOutputStream outputStream = new FileOutputStream(Environment.getExternalStorageDirectory()+"/imgehh/aaaa.txt");
                                try {
                                    outputStream.write(response.getBytes());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }


                        }

                        @Override
                        public void onError(Call call, Exception e) {
                            super.onError(call, e);
                            Log.i("哈哈哈哈","哈哈哈哈="+e.getMessage());
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
