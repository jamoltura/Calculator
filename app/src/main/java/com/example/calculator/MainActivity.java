package com.example.calculator;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.calculator.classes.Format;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String s = "1000,54+1,7000000";
        String v = Format.textToFormat(s);
        Log.d(TAG, "v : " + v);
        s = Format.formatToText(v);
        Log.d(TAG, "s : " + s);

    }

    private String f(int i){
        i++;
        Log.d(TAG, "f  i : " + i);
        return null;
    }
}
