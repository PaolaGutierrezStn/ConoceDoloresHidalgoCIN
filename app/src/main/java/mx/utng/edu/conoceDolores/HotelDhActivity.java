package mx.utng.edu.conoceDolores;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class HotelDhActivity extends AppCompatActivity {

    public void nextActivity33(View view){
        startActivity(new Intent(this, MapsRouteActivity.class));
    }

    public HotelActivity[] hotels = {
            new HotelActivity(mx.utng.edu.conoceDolores.R.drawable.ic_pozo, "Casa Pozo del Rayo ", "Nuevo León 7, Centro, Dolores Hidalgo", "01 418 182 7086"),
            new HotelActivity(mx.utng.edu.conoceDolores.R.drawable.ic_hidalgo, "Hidalgo", "Hidalgo 15, Centro, Dolores Hidalgo", "01 418 182 0477"),
            new HotelActivity(mx.utng.edu.conoceDolores.R.drawable.ic_relicario, "El Relicario ", "Av. De los Heroes 12, Revolucion, Dolores Hidalgo", "01 418 120 0712"),
            new HotelActivity(mx.utng.edu.conoceDolores.R.drawable.ic_anber, "Anber", "Guanajuato 9, Dolores Hidalgo", " 01 418 185 0012"),
            new HotelActivity(mx.utng.edu.conoceDolores.R.drawable.ic_cocomacan, "Posada Cocomacan", "Principal 4, Centro, Dolores Hidalgo", " 01 418 182 6086"),
    };

    private ListView lsvHotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_hotel_dh);
        lsvHotels = (ListView) findViewById(mx.utng.edu.conoceDolores.R.id.lsv_hoteles);
        HotelAdapter adapter = new HotelAdapter(this, hotels);
        lsvHotels.setAdapter(adapter);
    }

    static class ViewHolder{
        TextView txvNameHotel;
        TextView txvDirecction;
        TextView txvPrice;
        ImageView imvPhoto;
    }


    class HotelAdapter extends ArrayAdapter<HotelActivity> {
        public HotelAdapter(@NonNull Context context, HotelActivity[] data) {
            super(context, mx.utng.edu.conoceDolores.R.layout.activity_hotel, data);
        }

        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
            View cell = convertView;
            ViewHolder holder;
            if (cell == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell = inflater.inflate(mx.utng.edu.conoceDolores.R.layout.activity_hotel, null);

                holder = new ViewHolder();
                holder.imvPhoto = cell.findViewById(mx.utng.edu.conoceDolores.R.id.imv_photo);
                holder.txvNameHotel = cell.findViewById(mx.utng.edu.conoceDolores.R.id.txv_name_parking);
                holder.txvDirecction = cell.findViewById(mx.utng.edu.conoceDolores.R.id.txv_direcction);
                holder.txvPrice = cell.findViewById(mx.utng.edu.conoceDolores.R.id.txv_price);

                cell.setTag(holder);
            } else {
                holder = (ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(hotels[position].getImageId());
            holder.txvNameHotel.setText(hotels[position].getNameHotel());
            holder.txvDirecction.setText(hotels[position].getDirecction());
            holder.txvPrice.setText(hotels[position].getPrice());
            return cell;
        }
    }
}