package mx.utng.edu.conoceDolores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import mx.utng.edu.conoceDolores.common.CommonTwo;
import mx.utng.edu.conoceDolores.model.Gallery;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;


public class GalleryDetailTwo extends AppCompatActivity {

    KenBurnsView gallery_image;
    TextView gallery_title, gallery_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_gallery_detail);

        gallery_image = findViewById(mx.utng.edu.conoceDolores.R.id.gallery_image);
        gallery_title = findViewById(mx.utng.edu.conoceDolores.R.id.gallery_title);
        gallery_summary = findViewById(mx.utng.edu.conoceDolores.R.id.gallery_summary);

        if(getIntent() != null){
            int gallery_index = getIntent().getIntExtra("gallery_index",-1);
            if (gallery_index != -1){
                loadGalleryDetail(gallery_index);
            }
        }
    }

    private void loadGalleryDetail(int index) {
        Gallery gallery = CommonTwo.galleryListTwo.get(index);

        //Load image
        Picasso.with(getBaseContext()).load(gallery.getUrl()).into(gallery_image);//.placeholder(R.drawable.mcclaren).into(gallery_image);
        gallery_title.setText(gallery.getTitle());
        gallery_summary.setText(gallery.getSummary());
    }
}
