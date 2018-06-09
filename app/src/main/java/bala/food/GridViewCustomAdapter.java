package bala.food;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sankar on 7/24/2017.
 */

class GridViewCustomAdapter extends BaseAdapter {
    //Context c;
    String title[];
    String rs[];
    Integer[] image;
    Activity context;
    LayoutInflater inflater;

    GridViewCustomAdapter(Activity context, String[] title, String[] rs, Integer[] image) {
        super();
        this.context = context;
        this.title = title;
        this.rs = rs;
        this.image = image;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {

        return title.length;
    }

    @Override
    public Object getItem(int i) {
        return title[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {


        if (view == null) {
            LayoutInflater inflator=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view=inflator.inflate(R.layout.breakfastview,null);
        }

        TextView titles=(TextView) view.findViewById(R.id.name);
        TextView rss=(TextView) view.findViewById(R.id.rs);
        ImageView img=(ImageView) view.findViewById(R.id.imageView2);

        titles.setText(title[i]);
        rss.setText(rs[i]);
        img.setImageResource(image[i]);


        return view;
    }
}