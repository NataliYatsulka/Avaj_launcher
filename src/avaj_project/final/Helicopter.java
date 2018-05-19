package avaj_project.com.company;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        switch (weatherTower.getWeather(this.coordinates)){
            case "SUN": {
                coordinates = new Coordinates(coordinates.getLongitude() + 10,
                        coordinates.getLatitude(), coordinates.getHeight() + 2);
                if (coordinates.getHeight() > 0)
                    Main.printWriter.println("Helicopter#" + this.name + "(" + this.id + "): Hello sunshine.");
                break;
            }
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),
                        coordinates.getHeight());
                if (coordinates.getHeight() > 0)
                    Main.printWriter.println("Helicopter#" + this.name + "(" + this.id + "): I like rain.");
                break;
            }
            case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(),
                        coordinates.getHeight());
                if (coordinates.getHeight() > 0)
                    Main.printWriter.println("Helicopter#" + this.name + "(" + this.id + "): I don't like this weather.");
                break;
            }
            case "SNOW": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 12);
                if (coordinates.getHeight() > 0)
                    Main.printWriter.println("Helicopter#" + this.name + "(" + this.id + "): HoHoHo, Merry Christmas.");
                break;
            }
            default: break;
        }
        if (this.coordinates.getHeight() <= 0){
            this.coordinates.setHeight(0);
            Main.printWriter.println("Helicopter#" + this.name + "(" + this.id + ") landing.");
            this.weatherTower.unregister(this);
            Main.printWriter.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
        else if (this.coordinates.getHeight() >= 100)
            this.coordinates.setHeight(100);
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Main.printWriter.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
