import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class map{
    public ArrayList cities;
    public ArrayList<City> NumCities;
    public static void main(String[] args) {

        String fileName = "E:/SessionMaterial/Session2024Fall/CPS3440/city.txt";
        ArrayList<City> cities = generateCities(fileName);

        for (City city : cities) {
            System.out.println("City: " + city.name + ", X: " + city.x + ", Y: " + city.y);
        }
    }

    public static ArrayList generateCities(String fileName) {
        ArrayList<City> cities = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    double latitude = Double.parseDouble(parts[0]);
                    double longitude = Double.parseDouble(parts[1]);
                    String name = parts[2];
                    int x = mapToRange(latitude, -90, 90, 0, 300);
                    int y = mapToRange(longitude, -180, 180, 0, 300);
                    cities.add(new City(x, y, name));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static ArrayList<City> generateNumCities(int n, ArrayList citiesFromA) {
        ArrayList<City> matchedCities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = (int)(Math.random()*301);
            int y = (int)(Math.random()*301);
            City matchedCity = findClosestCity(x, y, citiesFromA);
            matchedCities.add(matchedCity);
        }
        return matchedCities;
    }

    public static City findClosestCity(int x, int y, ArrayList<City> cities) {
        City closestCity = null;
        double minDistance = Double.MAX_VALUE;
        for (City city : cities) {
            double distance = Math.sqrt(Math.pow(x - city.x, 2) + Math.pow(y - city.y, 2));
            if (distance < minDistance) {
                minDistance = distance;
                closestCity = city;
            }
        }
        return closestCity;
    }

    public static int mapToRange(double value, double fromLow, double fromHigh, int toLow, int toHigh) {
        double scale = (toHigh - toLow) / (fromHigh - fromLow);
        return (int) ((value - fromLow) * scale + toLow);
    }


}
class City {
    public int x;
    public int y;
    public String name;

    public City(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public double distanceTo(City other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
    public String toString() {
        return String.format("City{name='%s', x=%d, y=%d}", name, x, y);
    }
}