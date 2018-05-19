package avaj_project.com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static int count;
    private static List<Flyable> flyables = new LinkedList<Flyable>();
    static PrintWriter printWriter;

    public static void main(String[] args) throws MyException {

    WeatherTower weatherTower = new WeatherTower();
    AircraftFactory af = new AircraftFactory();
        try {
            printWriter = null;
            File file = new File("simulation.txt");
            printWriter = new PrintWriter(file);

            if (args.length != 1) throw new MyException("Bad number of arg length");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String line = bufferedReader.readLine();
            if (!line.isEmpty())
                count = Integer.parseInt(line.split(" ")[0]);
            if (count <= 0) throw new IOException("Number of simulation can not be NEGATIVE or ZERO. It is: " + count);
            while((line = bufferedReader.readLine()) != null) {
                String regExp = "(Baloon|JetPlane|Helicopter) (\\w+) (\\d+) (\\d+) (\\d+)";
                Pattern pattern = Pattern.compile(regExp);
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    if (Integer.parseInt(matcher.group(5)) > 0) {
                        Flyable flyable = af.newAircraft(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)),
                                Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));
                        if (flyable != null)
                            flyables.add(flyable);
                    }
                }
                else throw  new IOException("Wrong format in line: \"" + line + "\"");
            }
            for (Flyable flyable : flyables)
                flyable.registerTower(weatherTower);
        } catch (FileNotFoundException e){
            System.out.println("Please, create file \'scenario.txt\'");
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (NullPointerException e){
            System.out.println("NULL in the begining of file");
        }
        catch (NumberFormatException e){
            System.out.println("Bad number in the beginning of file");
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < count; i++)
            weatherTower.changeWeather();
        if ( printWriter != null )
            printWriter.close();
    }
}
