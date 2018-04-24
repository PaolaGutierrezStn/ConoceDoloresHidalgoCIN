package mx.utng.edu.conoceDolores;

/**
 * Created by Paola on 15/02/2018.
 */

public class RouteActivity {
    private int imageId;
    private String nameRoute;
    private String description;

    public RouteActivity(int imageId, String nameRoute, String description){
        this.imageId = imageId;
        this.nameRoute = nameRoute;
        this.description = description;
    }

    public RouteActivity(){
        this(mx.utng.edu.conoceDolores.R.mipmap.ic_launcher_round, "unnameroute", "undescription");
    }

    public int getImageId(){ return imageId;}

    public String getNameRoute(){ return nameRoute; }

    public String getDescription(){ return description; }
}
