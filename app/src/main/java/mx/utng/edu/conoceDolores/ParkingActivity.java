package mx.utng.edu.conoceDolores;

public class ParkingActivity {
    private int imageId;
    private String nameParking;
    private String direcction;
    private String price;

    public ParkingActivity(int imageId, String nameParking, String direcction, String price) {
        this.imageId = imageId;
        this.nameParking = nameParking;
        this.direcction = direcction;
        this.price = price;
    }

    public ParkingActivity(){
        this(mx.utng.edu.conoceDolores.R.mipmap.ic_launcher_round, "unnameparking", "undirecction", "unprice");
    }

    public int getImageId(){ return imageId;}

    public String getNameParking(){ return nameParking; }

    public String getPrice(){ return price; }

    public String getDirecction() { return direcction; }
}
