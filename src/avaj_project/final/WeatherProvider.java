package avaj_project.com.company;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider(){
        return (WeatherProvider.weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates){
        return weather[(coordinates.getLongitude()
                + coordinates.getLatitude() + coordinates.getHeight()) % 4];
    }
}
