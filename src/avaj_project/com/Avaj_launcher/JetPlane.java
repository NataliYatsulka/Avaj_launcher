package avaj_project.com.Avaj_launcher;

public class JetPlane extends Aircrafts implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        switch (weatherTower.getWeather(this.coordinates)){
            case "SUN": {
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                break;
            }
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5,
                        coordinates.getHeight());
                break;
            }
            case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1,
                        coordinates.getHeight());
                break;
            }
            case "SNOW": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 7);
                break;
            }
            default: break;
        }
        if (this.coordinates.getHeight() <= 0){
//            this.coordinates.getHeight() = 0;
            System.out.println("JetPlane " + this.name + " " + this.id + " landing.");
            this.weatherTower.unregister(this);
            System.out.println("JetPlane " + this.name + " " + this.id + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println(this.name + " " + this.id + "registered in weather tower.");
    }
}
