package avaj_project.com.Avaj_launcher;

public class Aircrafts {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    Aircrafts(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId();
    }

    private long nextId(){
        return idCounter++;
    }
}
