package avaj_project.com.company;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        switch (type){
            case ("Baloon"): return new Baloon(name, coordinates);
            case ("Helicopter"): return new Helicopter(name, coordinates);
            case ("JetPlane"): return new JetPlane(name, coordinates);
            default: return null;
        }
    }
}