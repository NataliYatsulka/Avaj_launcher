package avaj_project.com.company;

public class WeatherTower extends Tower{

    WeatherTower(){}public String getWeather(Coordinates coordinates){
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    void changeWeather(){
        this.conditionsChanged();
    }
}
