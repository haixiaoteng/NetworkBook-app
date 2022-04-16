package com.example.networkbook_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ShowBook extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private List<Book> Booklist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_showbook);
        dbHelper = new MyDatabaseHelper(this,"library.db",null,3);

        initBook();
        BookAdapter adapter = new BookAdapter(ShowBook.this,R.layout.layout_data_item,Booklist);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }
    private void initBook(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query("book",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String auther = cursor.getString(cursor.getColumnIndex("suther"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));

            }while (cursor.moveToFirst());
        }
    }
}
