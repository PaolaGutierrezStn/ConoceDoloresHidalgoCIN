package mx.utng.edu.conoceDolores;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by vazquez on 28/02/2018.
 */

public class HolderMessageActivity extends RecyclerView.ViewHolder {

    private TextView name;
    private  TextView message;
    private TextView time;
    private CircleImageView photoMessagePerfil;
    private ImageView photoMessage;

    public HolderMessageActivity(View itemView) {
        super(itemView);
        name =(TextView) itemView.findViewById(mx.utng.edu.conoceDolores.R.id.txv_message);
        message= (TextView) itemView.findViewById(mx.utng.edu.conoceDolores.R.id.txv_message_one);
        time = (TextView) itemView.findViewById(mx.utng.edu.conoceDolores.R.id.txv_message_two);
        photoMessagePerfil= (CircleImageView) itemView.findViewById(mx.utng.edu.conoceDolores.R.id.photo_perfil_messaje);
        photoMessage = (ImageView) itemView.findViewById(mx.utng.edu.conoceDolores.R.id.imv_message_photo);
 }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getMessage() {
        return message;
    }

    public void setMessage(TextView message) {
        this.message = message;
    }

    public TextView getTime() {
        return time;
    }

    public void setTime(TextView time) {
        this.time = time;
    }

    public CircleImageView getPhotoMessagePerfil() {
        return photoMessagePerfil;
    }

    public void setPhotoMessagePerfil(CircleImageView photoMessage) {
        this.photoMessagePerfil = photoMessage;
    }

    public ImageView getPhotoMessage() {
        return photoMessage;
    }

    public void setPhotoMessage(ImageView photoMessage) {
        this.photoMessage = photoMessage;
    }
}
