package mx.utng.edu.conoceDolores.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import mx.utng.edu.conoceDolores.R;
import mx.utng.edu.conoceDolores.model.Gallery;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jairo on 10/03/2018.
 */

public class GalleryAdapterTwo extends BaseAdapter {
    List<Gallery> galleryList;
    Context context;

    public GalleryAdapterTwo(List<Gallery> galleryList, Context context){
        this.context=context;
        this.galleryList=galleryList;
    }

    @Override
    public int getCount() {
        return galleryList.size();
    }

    @Override
    public Object getItem(int i) {
        return galleryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = view;
        if (rootView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View itemView = inflater.inflate(R.layout.layout_item, null);
            TextView name = itemView.findViewById(R.id.label);
            ImageView imageView = itemView.findViewById(R.id.image);



            Picasso.with(context).load(galleryList.get(i).getUrl()).into(imageView);//.placeholder(R.drawable.mcclaren).into(imageView);
            name.setText(galleryList.get(i).getTitle());
            return itemView;
        }
        return rootView;
    }
}
