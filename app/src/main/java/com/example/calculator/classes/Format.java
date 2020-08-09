package com.example.calculator.classes;

import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
@RequiresApi(api = Build.VERSION_CODES.O)
public class Format {

    private static final String TAG = "myLogs";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String textToFormat(String value) {

        if (isSymbol(value)){
            return textToFormatOfSymbol(value);
        }else{
            return textToFormatOfNumber(value);
        }
    }

    public static String formatToText(String value) {
        return value.replace(" ", "");
    }

    public static String[] textToArithmetic(String value) {
        return null;
    }

    private static String textToFormatOfNumber(String value){
        return _format3(value);
    }

    private static String textToFormatOfSymbol(String value){
        String result = value;

        int count = value.length();

        int index = 1;

        while (index < count){

            if(isSymbol(result, index)){

                if(index + 1 == count) {
                    result = _format1(result, index, count);
                    index++;
                }else {
                    result = _format2(result, index, count);
                    index = index + 3;
                }
            }

            index++;
            count = result.length();

        }

        result = formating(result);

        return result;
    }

    private static String formating(String value) {
        String result = "";

        String[] values = value.split(" ");
        int count = values.length;

        for (int i = 0; i < count; i++) {

            if (values[i].length() > 3){
                values[i] = _format3(values[i]);
            }
            if (i == 0){
                result = result.concat(values[i]);
            }else {
                result = String.join(" ", result, values[i]);
            }
        }

        return result;
    }

    private static String _format(String value, int index, int count){
        if(index + 1 == count) {
            return _format1(value, index, count);
        }else {
            return _format2(value, index, count);
        }
    }

    private static String _format1(String value, int index, int count){
        return String.join(" ", value.substring(0, index), value.substring(index, count));
    }

    private static String _format2(String value, int index, int count){
        return String.join(" ", value.substring(0, index), value.substring(index, index + 1), value.substring(index + 1, count));
    }

    private static String _format3(String value){
        int index = value.indexOf(",");
        int count = value.length();
        if (index == -1){
            return _format4(value);
        }else {
            return _format4(value.substring(0, index)).concat(value.substring(index, count));
        }
    }

    private static String _format4(String value){
        int count = value.length();
        String result = "";

        if (count > 3){
            int startNum = count % 3;

            if (startNum == 0){
                startNum = 3;
            }

            int c = (count - (count % 3)) / 3;

            for (int i = 0; i < c; i++){

                    value = _format1(value, startNum, count);
                    startNum = startNum + 4;
                    count++;

            }
            result = value;
        }else{
            result = value;
        }
        return result;
    }


    private static Boolean isSymbol(String value, int index){
        boolean result = false;
        char v = value.charAt(index);

        switch (v){
            case 42:
                result = true;
                break;
            case 43:
                result = true;
                break;
            case 45:
                result = true;
                break;
            case 47:
                result = true;
        }
        return result;
    }

    private static Boolean isSymbol(String value){
        return (value.contains("+") || value.contains("-") || value.contains("*") || value.contains("/"));
    }
}
