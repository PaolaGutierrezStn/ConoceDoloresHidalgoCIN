package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import mx.utng.edu.conoceDolores.adapter.GalleryAdapter;
import mx.utng.edu.conoceDolores.model.Gallery;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import mx.utng.edu.conoceDolores.common.Common;


public class GalleryActivityTwo extends AppCompatActivity {

    FeatureCoverFlow coverFlow;
    GalleryAdapter galleryAdapter;
    TextSwitcher mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_gallery_two);

        //create data first
        initData();
        galleryAdapter = new GalleryAdapter(mx.utng.edu.conoceDolores.common.Common.galleryList, this);


        coverFlow = findViewById(mx.utng.edu.conoceDolores.R.id.cover_flow);
        mTitle = findViewById(mx.utng.edu.conoceDolores.R.id.m_title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(GalleryActivityTwo.this);
                TextView text = (TextView)inflater.inflate(mx.utng.edu.conoceDolores.R.layout.layout_title,null);
                return text;
            }
        });
        coverFlow.setAdapter(galleryAdapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.galleryList.get(position).getTitle());
            }

            @Override
            public void onScrolling() {

            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(GalleryActivityTwo.this,GalleryDetail.class);
                intent.putExtra("gallery_index",i);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        //summary data you can get from idmb
        Gallery gallery = new Gallery("José Alfredo Jiménez con su mascota", "https://78.media.tumblr.com/55cbb7c6a4a32bcf075d17c1cbd41887/tumblr_p7ed3gslMX1x8mcx9o2_1280.jpg",
                "En esta foto se puede apreciar a José Alfredo Jiménez con su mascota.");
        Common.galleryList.add(gallery);

        gallery = new Gallery("José Alfredo Jiménez en su infancia", "https://78.media.tumblr.com/2df3d088e93cc1bfcdad91e01fb73651/tumblr_p7ed3gslMX1x8mcx9o1_1280.jpg",
                "Dentro de la casa museo podrás encontrar fotografías de Josè Alfredo Jimenéz.");
        Common.galleryList.add(gallery);


        gallery = new Gallery("José Alfredo", "https://78.media.tumblr.com/37d6896168aa9d72b7e79a272d669ce4/tumblr_p7ed3gslMX1x8mcx9o3_1280.jpg",
                "José Alfredo Jimémez como actor");
        Common.galleryList.add(gallery);

        Common.galleryList.add(new Gallery("Sala de la casa museo José Alfredo Jiménez", "https://78.media.tumblr.com/ac45934ec58bff38a47580e779a1ad5b/tumblr_p7ed3gslMX1x8mcx9o4_1280.jpg",
                "El museo casa José Alfredo Jiménez cuenta con múltiples salas donde se puede apreciar las grandes obras músicales del artista"));

        Common.galleryList.add(new Gallery("Patio de la casa museo José Alfredo Jiménez", "https://78.media.tumblr.com/4b14c7f6f06a3f9f9165b4c0dea485bc/tumblr_p7ed3gslMX1x8mcx9o5_1280.jpg",
                "Esta es una de las agradables vistas que son encontradas a la entrada de la casa museo José Alfredo Jiménez"));

        Common.galleryList.add(new Gallery("Zarape de José Alfredo Jiménez", "https://78.media.tumblr.com/5532d2b24e7c535e838e88db5429530e/tumblr_p7ed3gslMX1x8mcx9o6_1280.jpg\n",
                "Dentro de la casa museo se pueden encontrar vestimentas del cantante, como la que se ve en la imagen"));


        Common.galleryList.add(new Gallery("José Alfredo Jiménez en su infancia", "https://78.media.tumblr.com/945eac4f2d1d7ba9500afd5c9aefcffd/tumblr_p7ed3gslMX1x8mcx9o7_1280.jpg\n",
                "Desde pequeño José Alfedo Jiménez ya era todo un galán, como se muestra en la imagen."));

        Common.galleryList.add(new Gallery("Sombrero de José Alfredo Jiménez", "https://78.media.tumblr.com/7a37135ebf25b4c31d0dabe0b2601744/tumblr_p7ed3gslMX1x8mcx9o8_1280.jpg\n",
                "Sombrero de José Alfredo Jiménez"));


        Common.galleryList.add(new Gallery("Canciones", "https://78.media.tumblr.com/776394834a50d31db0904c69cb1120d0/tumblr_p7ed3gslMX1x8mcx9o9_1280.jpg\n",
                "Dentro de la casa museo de José Alfredo Jiménez se pueden leer algunos de los exitos del cantante, un motivo más para visitar este gran museo."));




    }
}
