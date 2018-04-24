package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuRecommendActivity extends AppCompatActivity {

    //lugares fotos paola
    public void nextActivity1(View view){
        startActivity(new Intent(this, PhotoGalleryActivity.class));
    }

    //hoteles lucy
    public void nextActivity2(View view){
        startActivity(new Intent(this, HotelDhActivity.class));
    }

    //estacionamientos  y baños paola
    public void nextActivity3(View view){
        startActivity(new Intent(this, ParkingDhActivity.class));
    }

    //restaurantes lucy
    public void nextActivity4(View view){
        startActivity(new Intent(this, RestaurantDhActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_menu_recommend);
    }
}
