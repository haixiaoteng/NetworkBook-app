package com.example.networkbook_app;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBookActivity extends AppCompatActivity {

    private MyDatabaseHelper dbHelper;
    private EditText id;
    private EditText auther;
    private EditText price;
    private EditText pages;
    private EditText name;
    private EditText category_id;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_addbookactivity);

        id = (EditText) findViewById(R.id.EditText_id);
        auther = (EditText) findViewById(R.id.EditText_auther);
        price = (EditText) findViewById(R.id.EditText_price);
        pages = (EditText) findViewById(R.id.EditText_pages);
        name = (EditText) findViewById(R.id.EditText_name);
        category_id = (EditText) findViewById(R.id.EditText_category_id);

        dbHelper = new MyDatabaseHelper(this,"library.db",null,2);
        Button button_add = (Button) findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                String id_data =id.getText().toString();
                String auther_data = auther.getText().toString();
                String price_data = price.getText().toString();
                String pages_data = pages.getText().toString();
                String name_data = name.getText().toString();
                String category_id_data = category_id.getText().toString();

                ContentValues values = new ContentValues();

                values.put("id",id_data);
                values.put("auther",auther_data);
                values.put("price",price_data);
                values.put("pages",pages_data);
                values.put("name",name_data);
                values.put("category_id",category_id_data);

                db.insert("Book",null,values);
                values.clear();
            }
        });
    }
}
