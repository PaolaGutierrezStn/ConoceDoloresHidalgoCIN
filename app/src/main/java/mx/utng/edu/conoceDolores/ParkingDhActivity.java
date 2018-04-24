package mx.utng.edu.conoceDolores;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ParkingDhActivity extends AppCompatActivity {
    private Button btnGo;
    private EditText place;




    public ParkingActivity[] parkings = {
            new ParkingActivity(mx.utng.edu.conoceDolores.R.drawable.ic_doloresh12, "Estacionamiento 1", "Querétaro 6, Centro, Dolores Hidalgo", "$10 por hora"),
            new ParkingActivity(mx.utng.edu.conoceDolores.R.drawable.ic_doloresh13, "Estacionamiento 2", "Querétaro 6, Centro, Dolores Hidalgo", "$15 por hora"),
            new ParkingActivity(mx.utng.edu.conoceDolores.R.drawable.ic_doloresh2, "Centro artesanal", "Querétaro 4, Centro, Dolores Hidalgo", "Baño $3"),
    };

    private ListView lsvParkings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_parking_dh);
        lsvParkings = findViewById(mx.utng.edu.conoceDolores.R.id.lsv_parkings);
        ParkingAdapter adapter = new ParkingAdapter(this, parkings);
        lsvParkings.setAdapter(adapter);

    }

    static class ViewHolder{
        TextView txvNameParking;
        TextView txvDirecction;
        TextView txvPrice;
        ImageView imvPhoto;
    }


    class ParkingAdapter extends ArrayAdapter<ParkingActivity> {
        public ParkingAdapter(@NonNull Context context, ParkingActivity[] data) {
            super(context, mx.utng.edu.conoceDolores.R.layout.activity_parking, data);
        }

        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
            View cell = convertView;
            ViewHolder holder;
            if (cell == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell = inflater.inflate(mx.utng.edu.conoceDolores.R.layout.activity_parking, null);

                holder = new ViewHolder();
                holder.imvPhoto = cell.findViewById(mx.utng.edu.conoceDolores.R.id.imv_photo);
                holder.txvNameParking = cell.findViewById(mx.utng.edu.conoceDolores.R.id.txv_name_parking);
                holder.txvDirecction = cell.findViewById(mx.utng.edu.conoceDolores.R.id.txv_direcction);
                holder.txvPrice = cell.findViewById(mx.utng.edu.conoceDolores.R.id.txv_price);

                cell.setTag(holder);
            } else {
                holder = (ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(parkings[position].getImageId());
            holder.txvNameParking.setText(parkings[position].getNameParking());
            holder.txvDirecction.setText(parkings[position].getDirecction());
            holder.txvPrice.setText(parkings[position].getPrice());
            return cell;
        }
    }

    public void nextActivity33(View view){
        startActivity(new Intent(this, MapsRouteActivity.class));


    }

}