package avaj_project.com.Avaj_launcher;

public class Ballon extends Aircrafts implements Flyable {
    private WeatherTower weatherTower = new WeatherTower();

    Ballon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        switch (weatherTower.getWeather(this.coordinates)) {
            case "SUN": {
                coordinates = new Coordinates(coordinates.getLongitude() + 2,
                        coordinates.getLatitude(), coordinates.getHeight() + 4);
                break;
            }
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 4);
                break;
            }
            case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 3);
                break;
            }
            case "SNOW": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 15);
                break;
            }
            default:
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
//            this.coordinates.getHeight() = 0;
            System.out.println("Baloon " + this.name + " " + this.id + " landing.");
            this.weatherTower.unregister(this);
            System.out.println("Baloon " + this.name + " " + this.id + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println(this.name + " " + this.id + "registered in weather tower.");
    }
}