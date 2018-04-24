package mx.utng.edu.conoceDolores;

import java.util.Map;

/**
 * Created by vazquez on 02/03/2018.
 */

public class MessageShareActivity extends MessageActivity {

    private Map time;

    public MessageShareActivity(){

    }

    public MessageShareActivity(Map time) {
        this.time = time;
    }


    public MessageShareActivity(String message, String name, String photoPerfil, String type_message, Map time) {
        super(message, name, photoPerfil, type_message);
        this.time = time;
    }

    public MessageShareActivity(String message, String name, String photoPerfil, String type_message, String urlPhoto, Map time) {
        super(message, name, photoPerfil, type_message, urlPhoto);
        this.time = time;
    }

    public Map getTime() {
        return time;
    }

    public void setTime(Map time) {
        this.time = time;
    }
}

