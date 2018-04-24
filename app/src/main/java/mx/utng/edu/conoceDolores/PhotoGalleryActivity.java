package mx.utng.edu.conoceDolores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class PhotoGalleryActivity extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;
    private PhotoAdapter photoAdapter;
    private List<PhotoActivity> photoList = new ArrayList<>();
    private TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_photo_gallery);

        initData();
        mTitle = (TextSwitcher)findViewById(mx.utng.edu.conoceDolores.R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(PhotoGalleryActivity.this);
                TextView txt = (TextView)inflater.inflate(mx.utng.edu.conoceDolores.R.layout.layout_title,null);
                return txt;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this, mx.utng.edu.conoceDolores.R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this, mx.utng.edu.conoceDolores.R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        //set adapter for cover flow
        photoAdapter = new PhotoAdapter(photoList,this);
        coverFlow = (FeatureCoverFlow)findViewById(mx.utng.edu.conoceDolores.R.id.coverFlow);
        coverFlow.setAdapter(photoAdapter);

        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(photoList.get(position).getName());
            }

            @Override
            public void onScrolling() {

            }
        });
    }

    private void initData() {
        photoList.add(new PhotoActivity("Callejón Casiano Éxiga","https://78.media.tumblr.com/5dc57a2907e0b29560e0667e27327dc7/tumblr_p5ejm35LSs1x8mcx9o1_1280.jpg"));
        photoList.add(new PhotoActivity("Jardín Principal","https://78.media.tumblr.com/4e56d2ea7a680287b11aba03a7ddab58/tumblr_p5ejj3WJno1x8mcx9o1_1280.jpg"));
        photoList.add(new PhotoActivity("Jardín Principal","https://78.media.tumblr.com/db1aed86a64cb2e2d5cb2727d35eb3d9/tumblr_p5ejgezC921x8mcx9o1_1280.jpg"));
        photoList.add(new PhotoActivity("Callejón Casiano Éxiga","https://78.media.tumblr.com/c361eec1b37c841af7bdde966be1abf9/tumblr_p5emjdpnpU1x8mcx9o1_540.jpg"));
        photoList.add(new PhotoActivity("Jardín Principal","https://78.media.tumblr.com/bf888029db6613bb7cf86dba8e180d82/tumblr_p5emm5VJff1x8mcx9o1_1280.jpg"));
        photoList.add(new PhotoActivity("Tumba José Alfredo J","https://68.media.tumblr.com/0442850f039240f9871da057fe5cbeba/tumblr_p6w6dz967R1x8mcx9o1_1280.jpg"));
        photoList.add(new PhotoActivity("Casa de visitas","https://78.media.tumblr.com/914885c7072b87dea95a3d88e4a246b9/tumblr_p6w6h2LiOJ1x8mcx9o1_540.jpg"));

    }
}
