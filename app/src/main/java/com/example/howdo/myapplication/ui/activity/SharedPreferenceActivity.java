package com.example.howdo.myapplication.ui.activity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.model.Book;
import com.example.howdo.myapplication.util.ToastUtil;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class SharedPreferenceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button contentProviderButton, sharedPreference, readSharedPreference, writeSqlite, createButton,
            updateButton, retrieveButton, deleteButton, litePalCreateButton, litePalUpdateButton,
            litePalRetrieveButton, litePaleleteButton;
    private MyDatabaseHelper myDatabaseHelper;
    private static final String TAG = "SharedPreferenceActivit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        sharedPreference = (Button) findViewById(R.id.first_code_sharedPreference);
        readSharedPreference = (Button) findViewById(R.id.first_code_read_sharedPreference);
        writeSqlite = (Button) findViewById(R.id.first_code_write_sqlite);
        createButton = (Button) findViewById(R.id.first_code_C);
        updateButton = (Button) findViewById(R.id.first_code_u);
        retrieveButton = (Button) findViewById(R.id.first_code_r);
        deleteButton = (Button) findViewById(R.id.first_code_d);
        litePalCreateButton = (Button) findViewById(R.id.first_code_litepal_c);
        litePalRetrieveButton = (Button) findViewById(R.id.first_code_litepal_r);
        litePalUpdateButton = (Button) findViewById(R.id.first_code_litepal_u);
        litePaleleteButton = (Button) findViewById(R.id.first_code_litepal_d);
        contentProviderButton = (Button) findViewById(R.id.first_code_contentProvider);

        myDatabaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 3);

        sharedPreference.setOnClickListener(this);
        readSharedPreference.setOnClickListener(this);
        writeSqlite.setOnClickListener(this);
        createButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        retrieveButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);
        litePalCreateButton.setOnClickListener(this);
        litePalRetrieveButton.setOnClickListener(this);
        litePalUpdateButton.setOnClickListener(this);
        litePaleleteButton.setOnClickListener(this);
        contentProviderButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase database = myDatabaseHelper.getWritableDatabase();
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
            case R.id.first_code_C:
                ContentValues values = new ContentValues();
                values.put("name", "YINDONG");
                values.put("author", "YINHANG");
                values.put("pages", 454);
                values.put("price", 18);
                database.insert("Book", null, values);
                values.clear();
                values.put("name", "YULI");
                values.put("author", "XIAXIAXIA");
                values.put("pages", 520);
                values.put("price", 19);
                database.insert("Book", null, values);
                break;
            case R.id.first_code_u:
                ContentValues values1 = new ContentValues();
                values1.put("price", 10.99);
                database.update("Book", values1, "name = ?", new String[]{
                        "YINDONG"
                });
                break;
            case R.id.first_code_d:
                database.delete("Book", "pages>?", new String[]{"1"});
                break;
            case R.id.first_code_r:
                Cursor book = database.query("Book", null, null, null, null, null, null);
                if (book.moveToFirst()) {
                    do {
                        String name1 = book.getString(book.getColumnIndex("name"));
                        String author = book.getString(book.getColumnIndex("author"));
                        int pages = book.getInt(book.getColumnIndex("pages"));
                        double price = book.getDouble(book.getColumnIndex("price"));

                        Log.d(TAG, "onClick: name" + name1);
                        Log.d(TAG, "onClick: author" + author);
                        Log.d(TAG, "onClick: pages" + pages);
                        Log.d(TAG, "onClick: price" + price);

                    } while (book.moveToNext());
                }
                book.close();
                break;
            case R.id.first_code_litepal_c:
                LitePal.getDatabase();
                Book book1 = new Book();
                book1.setName("dddddd");
                book1.setAuthor("eeeeeee");
                book1.setPages(50);
                book1.setPrice(24);
                book1.setPress("UNKNOW");
                book1.save();
                break;
            case R.id.first_code_litepal_d:
                DataSupport.deleteAll(Book.class, "price>?", "1");
                break;

            case R.id.first_code_litepal_r:
                List<Book> all = DataSupport.findAll(Book.class);
                for (Book book2 : all) {
                    Log.d(TAG, "onClick: name:   " + book2.getName());
                    Log.d(TAG, "onClick: Author:   " + book2.getAuthor());
                    Log.d(TAG, "onClick: Pages:   " + book2.getPages());
                    Log.d(TAG, "onClick: getPrice:   " + book2.getPrice());
                    Log.d(TAG, "onClick: getPress:   " + book2.getPress());
                }
                break;

            case R.id.first_code_litepal_u:
                Book book2 = new Book();
                book2.setPrice(1999);
                book2.updateAll("name=?and author = ?", "dddddd", "eeeeeee");

                break;
            case R.id.first_code_contentProvider:
                if (ContextCompat.checkSelfPermission(SharedPreferenceActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(SharedPreferenceActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                }else {
                    call();
                }

                break;
            default:
                break;
        }

    }

    private void call() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

    public static class MyDatabaseHelper extends SQLiteOpenHelper {

        public static final String CREATE_CATEGORY = "create table Category("
                + "id integer primary key autoincrement,"
                + "category_name text,"
                + "category_code integer)";

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
            db.execSQL(CREATE_CATEGORY);
            ToastUtil.showText("Created succeed");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists Book");
            db.execSQL("drop table if exists Category");
            onCreate(db);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    call();
                }
                break;
            default:
        }
    }
}
