package avaj_project.com.company;

public class Coordinates
{
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = setLongitude(longitude);
        this.latitude = setLatitude(latitude);
        this.height = setHeight(height);
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public int setLongitude(int longitude) {

        this.longitude = longitude;
        return this.longitude;
    }

    public int setLatitude(int latitude) {

        this.latitude = latitude;
        return this.latitude;
    }

    public int setHeight(int height) {
//        if (height <= 0 || (height > 0 &&  (this.height - height) <= 0))
//            this.height = 0;
//        else if (this.height + height >= 100)
//            this.height = 100;
//        else
            this.height = height;
//        System.out.println("this.height = " + this.height);
        return this.height;
    }
}
