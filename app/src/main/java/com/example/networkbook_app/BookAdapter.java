package com.example.networkbook_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    
    private int resourceId;

    public BookAdapter(Context context , int textViewResourceId, List<Book> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView (int position,View convertView, ViewGroup parent){

        Book books = (Book) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        TextView textView_name = (TextView) view.findViewById(R.id.textView_name);
        TextView textView_price = (TextView) view.findViewById(R.id.textView_price);
        TextView textView_category = (TextView) view.findViewById(R.id.textView_category);

        textView_name.setText(books.getName());
        textView_price.setText((int) books.getPrice());
        textView_category.setText(books.getCategory_id());

        return view;

    }
}
