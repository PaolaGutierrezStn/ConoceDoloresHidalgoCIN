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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RestaurantDhActivity extends AppCompatActivity {

    public void nextActivity33(View view){
        startActivity(new Intent(this, MapsRouteActivity.class));
    }

    public RestaurantActivity[] restaurants = {
            new RestaurantActivity(mx.utng.edu.conoceDolores.R.drawable.ic_carnitas, "Carnitas Vicente Fernandéz ", "Av. Sur 44, Dolores Hidalgo", "418 157 9863"),
            new RestaurantActivity(mx.utng.edu.conoceDolores.R.drawable.ic_plaza, "Restaurant Plaza", "Principal 17, Dolores Hidalgo", "418 182 0259"),
            new RestaurantActivity(mx.utng.edu.conoceDolores.R.drawable.ic_josefa, "Restaurant La Josefa", "Guanajuato 5, Dolores Hidalgo", "418 181 0648"),
            new RestaurantActivity(mx.utng.edu.conoceDolores.R.drawable.ic_delfin, "Restaurant el Delfín ", "Calle Veracruz 2 Centro, Dolores Hidalgo", "418 182 2299"),
            new RestaurantActivity(mx.utng.edu.conoceDolores.R.drawable.ic_fruti, "Fruti Yogurt", "Hidalgo 2 Centro, Dolores Hidalgo", "418 182 3679"),
            new RestaurantActivity(mx.utng.edu.conoceDolores.R.drawable.ic_mama, "Mamá Dolores", "Principal 27, Dolores Hidalgo", "418 182 1778"),
            new RestaurantActivity(mx.utng.edu.conoceDolores.R.drawable.ic_pisso, "Tercer Pisso", "Calzada de los Héroes 112, Dolores Hidalgo", "418 101 1865"),
            new RestaurantActivity(mx.utng.edu.conoceDolores.R.drawable.ic_blue, "Blue Bar", "Calzada de los heroes 179, Dolores Hidalgo", "418 117 5233"),

    };

    private ListView lsvRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_restaurant_dh);
        lsvRestaurants = (ListView) findViewById(mx.utng.edu.conoceDolores.R.id.lsv_restaurants);
        RestaurantAdapter adapter = new RestaurantAdapter(this, restaurants);
        lsvRestaurants.setAdapter(adapter);
    }

    static class ViewHolder{
        TextView txvNameRestaurant;
        TextView txvDirecction;
        TextView txvPrice;
        ImageView imvPhoto;
    }


    class RestaurantAdapter extends ArrayAdapter<RestaurantActivity> {
        public RestaurantAdapter(@NonNull Context context, RestaurantActivity[] data) {
            super(context, mx.utng.edu.conoceDolores.R.layout.activity_restaurant, data);
        }

        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
            View cell = convertView;
            ViewHolder holder;
            if (cell == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell = inflater.inflate(mx.utng.edu.conoceDolores.R.layout.activity_restaurant, null);

                holder = new ViewHolder();
                holder.imvPhoto = cell.findViewById(mx.utng.edu.conoceDolores.R.id.imv_photo);
                holder.txvNameRestaurant = cell.findViewById(mx.utng.edu.conoceDolores.R.id.txv_name_parking);
                holder.txvDirecction = cell.findViewById(mx.utng.edu.conoceDolores.R.id.txv_direcction);
                holder.txvPrice = cell.findViewById(mx.utng.edu.conoceDolores.R.id.txv_price);

                cell.setTag(holder);
            } else {
                holder = (ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(restaurants[position].getImageId());
            holder.txvNameRestaurant.setText(restaurants[position].getNameRestaurant());
            holder.txvDirecction.setText(restaurants[position].getDirecction());
            holder.txvPrice.setText(restaurants[position].getPrice());
            return cell;
        }
    }
}