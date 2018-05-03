package avaj_project.com.Avaj_launcher;

public class Helicopter extends Aircrafts implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        switch (weatherTower.getWeather(this.coordinates)){
            case "SUN": {
                coordinates = new Coordinates(coordinates.getLongitude() + 10,
                        coordinates.getLatitude(), coordinates.getHeight() + 2);
                break;
            }
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),
                        coordinates.getHeight());
                break;
            }
            case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(),
                        coordinates.getHeight());
                break;
            }
            case "SNOW": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 12);
                break;
            }
            default: break;
        }
        if (this.coordinates.getHeight() <= 0){
//            this.coordinates.getHeight() = 0;
            System.out.println("Helicopter " + this.name + " " + this.id + " landing.");
            this.weatherTower.unregister(this);
            System.out.println("Helicopter " + this.name + " " + this.id + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println(this.name + " " + this.id + "registered in weather tower.");
    }
}
