package avaj_project.com.company;

public class JetPlane extends Aircrafts implements Flyable{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        switch (weatherTower.getWeather(this.coordinates)){
            case "SUN": {
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                if (coordinates.getHeight() > 0)
                    Main.printWriter.println("JetPlane#" + this.name + "(" + this.id + "): Summer is over.");
                break;
            }
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5,
                        coordinates.getHeight());
                if (coordinates.getHeight() > 0)
                    Main.printWriter.println("JetPlane#" + this.name + "(" + this.id + "): I wet anywhere.");
                break;
            }
            case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1,
                        coordinates.getHeight());
                if (coordinates.getHeight() > 0)
                    Main.printWriter.println("JetPlane#" + this.name + "(" + this.id + "): FOG.");
                break;
            }
            case "SNOW": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 7);
                if (coordinates.getHeight() > 0)
                    Main.printWriter.println("JetPlane#" + this.name + "(" + this.id + "): Christmas tree, where are you?.");
                break;
            }
            default: break;
        }
        if (this.coordinates.getHeight() <= 0){
            this.coordinates.setHeight(0);
            Main.printWriter.println("JetPlane#" + this.name + "(" + this.id + ") landing.");
            this.weatherTower.unregister(this);
            Main.printWriter.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
        else if (this.coordinates.getHeight() >= 100)
            this.coordinates.setHeight(100);
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Main.printWriter.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
