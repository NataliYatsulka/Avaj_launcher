package avaj_project.com.company;

public class Baloon extends Aircraft implements Flyable {
    WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        switch (weatherTower.getWeather(this.coordinates)) {
            case "SUN": {
                coordinates = new Coordinates(coordinates.getLongitude() + 2,
                        coordinates.getLatitude(), coordinates.getHeight() + 4);
                if (coordinates.getHeight() > 0)
                    Main.printWriter.println("Baloon#" + this.name + "(" + this.id + "): Hot, I want an ice cream.");
//                    System.out.println("Baloon#" + this.name + "(" + this.id + "): Hot, I want an ice cream.");
                break;
            }
            case "RAIN": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 4);
                if (coordinates.getHeight() > 0)

                    Main.printWriter.println("Baloon#" + this.name + "(" + this.id + "): Go down!.");
                break;
            }
            case "FOG": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 3);
                if (coordinates.getHeight() > 0) Main.printWriter.println("Baloon#" + this.name + "(" + this.id + "): Can't see the mountain because of fog.");
                break;
            }
            case "SNOW": {
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
                        coordinates.getHeight() - 15);
                if (coordinates.getHeight() > 0) Main.printWriter.println("Baloon#" + this.name + "(" + this.id + "): This is amazing. Jingle bells, jingle bells.");
                break;
            }
            default:
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            this.coordinates.setHeight(0);
            Main.printWriter.println("Baloon#" + this.name + "(" + this.id + ") landing.");
            this.weatherTower.unregister(this);
            Main.printWriter.println("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
        else if (this.coordinates.getHeight() >= 100)
            this.coordinates.setHeight(100);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Main.printWriter.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}