package com.example.huzaifaabid_contextmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
public class MyListView extends ArrayAdapter {

    private final Activity context;
    private final String[] name;
    private final int[] image;
    private final String[] numbers;


    public MyListView(@NonNull Context context, String[] name, int[] image,String[] numbers) {
        super(context, R.layout.list_item,name);
        this.context= (Activity) context;
        this.name=name;
        this.image=image;
        this.numbers=numbers;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        titleText.setText(name[position]);
        imageView.setImageResource(image[position]);

        Button btn= rowView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                String no=numbers[position];
                no="tel:"+no;
                System.out.println(no);
                intent.setData(Uri.parse(no));
                context.startActivity(intent);
            }
        });

        Button btn2= rowView.findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, message.class);
                intent.putExtra("number",numbers[position]);
                context.startActivity(intent);
            }
        });



        return rowView;
    };

}
