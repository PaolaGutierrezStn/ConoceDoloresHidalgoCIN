package mx.utng.edu.conoceDolores;

/**
 * Created by vazquez on 02/03/2018.
 */

public class MessageReceiveActivity extends MessageActivity {
    private  Long time;

    public MessageReceiveActivity() {
    }

    public MessageReceiveActivity(Long time) {
        this.time = time;
    }

    public MessageReceiveActivity(String message, String name, String photoPerfil, String type_message, Long time) {
        super(message, name, photoPerfil, type_message);
        this.time = time;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
