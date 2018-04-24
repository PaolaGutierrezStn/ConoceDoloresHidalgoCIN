package mx.utng.edu.conoceDolores;

/**
 * Created by vazquez on 08/04/2018.
 */

public class RestaurantActivity {
    private int imageId;
    private String nameRestaurant;
    private String direcction;
    private String price;

    public RestaurantActivity(int imageId, String nameRestaurant, String direcction, String price) {
        this.imageId = imageId;
        this.nameRestaurant = nameRestaurant;
        this.direcction = direcction;
        this.price = price;
    }

    public RestaurantActivity(){
        this(mx.utng.edu.conoceDolores.R.mipmap.ic_launcher_round, "unname", "undirecction", "unprice");
    }

    public int getImageId(){ return imageId;}

    public String getNameRestaurant(){ return nameRestaurant; }

    public String getPrice(){ return price; }

    public String getDirecction() { return direcction; }

}

