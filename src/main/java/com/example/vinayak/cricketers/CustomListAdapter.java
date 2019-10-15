package com.example.vinayak.cricketers;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] cricket;
    private final Integer[] imgid;
    private final String[] subitem1;
    private final String[] subitem2;


    public CustomListAdapter(Activity context, String[] cricket, String[] subitem1, String[] subitem2, Integer[] imgid) {
        super(context, R.layout.players, cricket);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.cricket = cricket;
        this.imgid = imgid;
        this.subitem1 = subitem1;
        this.subitem2 = subitem2;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.players, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtext1 = (TextView) rowView.findViewById(R.id.textView1);
        TextView subtext2 = (TextView) rowView.findViewById(R.id.textView2);

        txtTitle.setText(cricket[position]);
        imageView.setImageResource(imgid[position]);
        subtext1.setText(subitem1[position]);
        subtext2.setText(subitem2[position]);
        subtext2.setText(subitem2[position]);

        return rowView;

    }

    ;
}
