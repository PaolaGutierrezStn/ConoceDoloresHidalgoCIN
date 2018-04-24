package mx.utng.edu.conoceDolores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Paola on 10/03/2018.
 */

public class PhotoAdapter extends BaseAdapter {
    private List<PhotoActivity> photoList;
    private Context mContext;

    public PhotoAdapter(List<PhotoActivity> photoList, Context mContext) {
        this.photoList = photoList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return photoList.size();
    }

    @Override
    public Object getItem(int i) {
        return photoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView == null){
            rowView = LayoutInflater.from(mContext).inflate(mx.utng.edu.conoceDolores.R.layout.layout_item,null);
            TextView name = (TextView)rowView.findViewById(mx.utng.edu.conoceDolores.R.id.label);
            ImageView image = (ImageView)rowView.findViewById(mx.utng.edu.conoceDolores.R.id.image);

            //set data
            Picasso.with(mContext).load(photoList.get(i).getImageUrl()).into(image);
            name.setText(photoList.get(i).getName());
        }

        return rowView;
    }
}
