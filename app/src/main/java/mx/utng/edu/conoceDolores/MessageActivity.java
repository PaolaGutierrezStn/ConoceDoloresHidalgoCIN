package mx.utng.edu.conoceDolores;

/**
 * Created by vazquez on 28/02/2018.
 */

public class MessageActivity {
    private String message;

    private String name;
    private String photoPerfil;
    private  String type_message;

    private  String urlPhoto;

    public MessageActivity() {
    }

    public MessageActivity(String message, String name, String photoPerfil, String type_message) {
        this.message = message;
        this.name = name;
        this.photoPerfil = photoPerfil;
        this.type_message = type_message;

    }

    public MessageActivity(String message, String name, String photoPerfil, String type_message, String urlPhoto) {
        this.message = message;
        this.name = name;
        this.photoPerfil = photoPerfil;
        this.type_message = type_message;
        this.urlPhoto = urlPhoto;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoPerfil() {
        return photoPerfil;
    }

    public void setPhotoPerfil(String photoPerfil) {
        this.photoPerfil = photoPerfil;
    }

    public String getType_message() {
        return type_message;
    }

    public void setType_message(String type_message) {
        this.type_message = type_message;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }
    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
