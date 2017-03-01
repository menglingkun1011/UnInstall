package com.meng.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, SDCardListenSer.class);
        startService(intent);

//        Log.e("路径：",getFilesDir().toString());
        init("http://www.baidu.com");

    }


    private native void init(String url);

    static {
        //android 5.0不行的，进程被杀时，同一个uid下的所有进程都会被干掉
        Log.d("onEvent", "load jni lib");
        System.loadLibrary("uninstall");
    }

    public void openSecond(View view){
        startActivity(new Intent(this,SecondActivity.class));
    }
}
