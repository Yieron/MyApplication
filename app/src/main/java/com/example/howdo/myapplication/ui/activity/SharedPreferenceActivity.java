package com.example.howdo.myapplication.ui.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.util.ToastUtil;

public class SharedPreferenceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sharedPreference, readSharedPreference, writeSqlite;
    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        sharedPreference = (Button) findViewById(R.id.first_code_sharedPreference);
        readSharedPreference = (Button) findViewById(R.id.first_code_read_sharedPreference);
        writeSqlite = (Button) findViewById(R.id.first_code_write_sqlite);

        myDatabaseHelper = new MyDatabaseHelper(this,"BookStore.db",null,1);

        sharedPreference.setOnClickListener(this);
        readSharedPreference.setOnClickListener(this);
        writeSqlite.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_code_sharedPreference:
                SharedPreferences.Editor editor = getSharedPreferences("dataSharedPreference", MODE_PRIVATE).edit();
                editor.putBoolean("married", true);
                editor.putInt("age", 28);
                editor.putString("name", "Yieron2");
                editor.apply();
                break;
            case R.id.first_code_read_sharedPreference:
                SharedPreferences preferences = getSharedPreferences("dataSharedPreference", MODE_PRIVATE);
                String name = preferences.getString("name", "");
                int age = preferences.getInt("age", 0);
                boolean married = preferences.getBoolean("married", false);

                ToastUtil.showText("hhhhhhhh" + name);
                break;
            case R.id.first_code_write_sqlite:
                myDatabaseHelper.getWritableDatabase();
                break;
            default:
                break;
        }

    }

    public class MyDatabaseHelper extends SQLiteOpenHelper {

        public static final String CREATE_BOOK = "create table Book ("
                + "id integer primary key autoincrement, "
                + "author text,"
                + "price real,"
                + "pages integer,"
                + "name text)";

        private Context mContext;

        public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            mContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_BOOK);
            ToastUtil.showText("Created succeed");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
