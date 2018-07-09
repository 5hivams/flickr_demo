package com.flickr.shivam.flickrsearch.Adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.flickr.shivam.flickrsearch.ImageHelper.ImageLoader;
import com.flickr.shivam.flickrsearch.R;
import com.flickr.shivam.flickrsearch.model.Image_model;


public class LazyAdapter extends BaseAdapter {
    
    private Activity activity;
    private List<Image_model> data = new ArrayList<>();
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader;
    
    public LazyAdapter(Activity a, List<Image_model> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        return data.size();
    } 

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.item, null);

        //TextView owner=(TextView)vi.findViewById(R.id.owner);
        ImageView image=(ImageView)vi.findViewById(R.id.image);
        //owner.setText(data.get(position).getOwner());
        
       
        
//        TextView desc =(TextView)vi.findViewById(R.id.description);
//        desc.setText(data.get(position).getTitle());
//
//        TextView date = (TextView)vi.findViewById(R.id.date);
//        date.setText(data.get(position).getDate());
        
        imageLoader.DisplayImage(data.get(position).getUrl(), image);
        return vi;
    }


    

}

