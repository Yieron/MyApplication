package com.example.howdo.myapplication.ui.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.util.ToastUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FilePersistenceActivity extends AppCompatActivity {
    private EditText Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_persistence);

        Edit = (EditText) findViewById(R.id.first_code_edit_file);

        String inputText = loadFile();
        if (!TextUtils.isEmpty(inputText)){
            Edit.setText(inputText);
            Edit.setSelection(inputText.length());
            ToastUtil.showText("Restoring succeed!");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String s = Edit.getText().toString();
        saveFile(s);
    }

    public void saveFile(String s) {
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = openFileOutput("Yierondata", Context.MODE_PRIVATE);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String loadFile(){
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();
        try{
            fileInputStream = openFileInput("Yierondata");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line="";
            while ((line = bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }
}
