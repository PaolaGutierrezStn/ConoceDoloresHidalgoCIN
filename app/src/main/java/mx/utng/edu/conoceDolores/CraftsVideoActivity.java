package mx.utng.edu.conoceDolores;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

/**
 * Created by Paola on 10/03/2018.
 */

public class CraftsVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public static final String DEVELOPER_KEY = ConfigYoutube2Activity.DEVELOPER_KEY;
    private static String VIDEO_ID = "dM_J-tuFVRk";
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    YouTubePlayerFragment myYouTubePlayerFragment;

    CarouselPicker carouselPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mx.utng.edu.conoceDolores.R.layout.activity_crafts);
        myYouTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager()
                .findFragmentById(mx.utng.edu.conoceDolores.R.id.videoV);

        myYouTubePlayerFragment.initialize(ConfigYoutube2Activity.DEVELOPER_KEY, CraftsVideoActivity.this);

        carouselPicker = (CarouselPicker)findViewById(mx.utng.edu.conoceDolores.R.id.carouselPicker);

        List<CarouselPicker.PickerItem> itemsImages = new ArrayList<>();
        itemsImages.add(new CarouselPicker.DrawableItem(mx.utng.edu.conoceDolores.R.drawable.ic_crafts1));
        itemsImages.add(new CarouselPicker.DrawableItem(mx.utng.edu.conoceDolores.R.drawable.ic_crafts2));
        itemsImages.add(new CarouselPicker.DrawableItem(mx.utng.edu.conoceDolores.R.drawable.ic_crafts3));
        CarouselPicker.CarouselViewAdapter imageAdapter = new CarouselPicker.CarouselViewAdapter(this,itemsImages,0);
        carouselPicker.setAdapter(imageAdapter);
    }


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "There was an error initializing the YouTubePlayer (%1$s)",
                    errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
// Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(mx.utng.edu.conoceDolores.R.id.videoV);
    }
}
