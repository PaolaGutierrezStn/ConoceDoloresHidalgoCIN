package mx.utng.edu.conoceDolores;

/**
 * Created by Paola on 10/03/2018.
 */

public class PhotoActivity {
    private String Name;
    private String ImageUrl;

    public PhotoActivity(String name, String imageUrl) {
        Name = name;
        ImageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
