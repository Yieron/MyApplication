package com.example.howdo.myapplication.ui.activity;

import android.Manifest;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.howdo.myapplication.R;
import com.example.howdo.myapplication.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class ContentProviderActivity extends AppCompatActivity {
    private ListView LvContentProvider;
    ArrayAdapter<String> arrayAdapter;
    List<String> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        LvContentProvider = (ListView) findViewById(R.id.first_code_lv_content_provider);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactList);
        LvContentProvider.setAdapter(arrayAdapter);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        } else {
            readContacts();
        }

    }

    private void readContacts() {
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    contactList.add(displayName + "\n" + number);
                }
                arrayAdapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readContacts();
                } else {
                    ToastUtil.showText("you denied the permission");
                }
                break;
            default:

        }
    }

    static class MyContentprovider extends ContentProvider {
        public static final int TABLE1_DIR = 0;
        public static final int TABLE1_ITEM = 1;
        public static final int TABLE2_DIR = 2;
        public static final int TABLE2_ITEM = 3;
        static UriMatcher uriMatcher;

        static {
            uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
            uriMatcher.addURI("com.example.howdo.myapplication.provider", "table1", TABLE1_DIR);
            uriMatcher.addURI("com.example.howdo.myapplication.provider", "table1/#", TABLE1_ITEM);
            uriMatcher.addURI("com.example.howdo.myapplication.provider", "table2", TABLE2_DIR);
            uriMatcher.addURI("com.example.howdo.myapplication.provider", "table2/#", TABLE2_ITEM);

        }

        @Override
        public boolean onCreate() {
            return false;
        }

        @Nullable
        @Override
        public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
            switch (uriMatcher.match(uri)) {
                case TABLE1_DIR:
                    break;
                case TABLE1_ITEM:
                    break;
                case TABLE2_DIR:
                    break;
                case TABLE2_ITEM:
                    break;
                default:
                    break;
            }
            return null;
        }

        @Nullable
        @Override
        public String getType(@NonNull Uri uri) {
            switch (uriMatcher.match(uri)) {
                case TABLE1_DIR:
                    break;
                case TABLE1_ITEM:
                    break;
                case TABLE2_DIR:
                    break;
                case TABLE2_ITEM:
                    break;
                default:
                    break;
            }
            return null;
        }

        @Nullable
        @Override
        public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
            return null;
        }

        @Override
        public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
            return 0;
        }

        @Override
        public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
            return 0;
        }
    }
}
