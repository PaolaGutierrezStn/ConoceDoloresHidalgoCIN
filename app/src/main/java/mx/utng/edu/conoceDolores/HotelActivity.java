package mx.utng.edu.conoceDolores;

public class HotelActivity {
    private int imageId;
    private String nameHotel;
    private String direcction;
    private String price;

    public HotelActivity(int imageId, String nameHotel, String direcction, String price) {
        this.imageId = imageId;
        this.nameHotel = nameHotel;
        this.direcction = direcction;
        this.price = price;
    }

    public HotelActivity(){
        this(mx.utng.edu.conoceDolores.R.mipmap.ic_launcher_round, "unname", "undirecction", "unprice");
    }

    public int getImageId(){ return imageId;}

    public String getNameHotel(){ return nameHotel; }

    public String getPrice(){ return price; }

    public String getDirecction() { return direcction; }
}
