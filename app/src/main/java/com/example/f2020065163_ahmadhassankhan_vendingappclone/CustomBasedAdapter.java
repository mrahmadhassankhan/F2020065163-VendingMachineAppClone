package com.example.f2020065163_ahmadhassankhan_vendingappclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBasedAdapter extends BaseAdapter {
    Context context;
    String listbook[];
    int listimages[];
    LayoutInflater inflater;

    public CustomBasedAdapter(Context ctx, String[] bookList, int[] images) {
        this.context = ctx;
        this.listbook = bookList;
        this.listimages = images;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return this.listbook.length; //The rows will be equal to the count of the list book
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.customlistview, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textview);
        ImageView bookimg = (ImageView) convertView.findViewById(R.id.imageIcon);
        textView.setText(listbook[position]);
        bookimg.setImageResource(listimages[position]);
        return convertView;
    }
}