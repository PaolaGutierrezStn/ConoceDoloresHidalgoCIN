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


public class RouteDhActivity extends AppCompatActivity {

    public void nextActivity11(View view){
        startActivity(new Intent(this, Direcction1Activity.class));
    }

    public RouteActivity[] routes = {
            new RouteActivity(mx.utng.edu.conoceDolores.R.drawable.dh1_compressor, "Ruta independencia", "Conoce los lugares más importantes para la independencia del municipio"),
            new RouteActivity(mx.utng.edu.conoceDolores.R.drawable.dh2_compressor, "Ruta Jose Alfredo", "Descubre los bares  donde el cantante y compositor mexicano creó una gran cantidad de temas, principalmente rancheras, huapangos y corridos"),
            new RouteActivity(mx.utng.edu.conoceDolores.R.drawable.at1_compressor, "Artesanias y Talavera", "Compra las mejores piezas artesanales del municipio"),
    };

    private ListView lsvRoutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_route_dh);
        lsvRoutes = findViewById(mx.utng.edu.conoceDolores.R.id.lsv_routes);
        RouteAdapter adapter = new RouteAdapter(this, routes);
        lsvRoutes.setAdapter(adapter);
    }

    static class ViewHolder {
        TextView txvNameRoute;
        TextView txvDescription;
        ImageView imvPhoto;
    }

    class RouteAdapter extends ArrayAdapter<RouteActivity> {
        public RouteAdapter(@NonNull Context context, RouteActivity[] data) {
            super(context, mx.utng.edu.conoceDolores.R.layout.activity_route, data);
        }

        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
            View cell = convertView;
            ViewHolder holder;
            if (cell == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell = inflater.inflate(mx.utng.edu.conoceDolores.R.layout.activity_route, null);

                holder = new ViewHolder();
                holder.imvPhoto = cell.findViewById(mx.utng.edu.conoceDolores.R.id.imv_photo);
                holder.txvNameRoute = cell.findViewById(mx.utng.edu.conoceDolores.R.id.txv_name_route);
                holder.txvDescription = cell.findViewById(mx.utng.edu.conoceDolores.R.id.txv_description);

                cell.setTag(holder);
            } else {
                holder = (ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(routes[position].getImageId());
            holder.txvNameRoute.setText(routes[position].getNameRoute());
            holder.txvDescription.setText(routes[position].getDescription());
            return cell;
        }
    }
}



