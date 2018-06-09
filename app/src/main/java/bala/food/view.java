package bala.food;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sankar on 6/17/2017.
 */

public class view extends ArrayAdapter<String>{
    Activity context;
     String[] item;
       Integer[] image;

public view(Activity context, Integer[] image, String[] item) {
    super(context, R.layout.view1, item);
    this.context = context;
    this.item = item;
      this.image = image;
}
    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.view1, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView);

        txtTitle.setText(item[position]);
        imageView.setImageResource(image[position]);
        extratxt.setText(item[position]);
        return rowView;

    };
}

