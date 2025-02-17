import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class project {
    public static void main(String[] args) {
        ArrayList<City> cities = map.generateCities("E:/SessionMaterial/Session2024Fall/CPS3440/city.txt");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of cities:");
        int n = input.nextInt();
        ArrayList<City> selectedCities = map.generateNumCities(n, cities);

        System.out.println("Selected Cities:");
        for (City city : selectedCities) {
            System.out.printf("City: %s, X: %d, Y: %d%n", city.name, city.x, city.y);
        }
        List<int[]> mstEdges = PrimMST.primMST(selectedCities);
        System.out.println("\nMST Edges:");
        for (int[] edge : mstEdges) {
            System.out.printf("%s -- %s%n", selectedCities.get(edge[0]).name, selectedCities.get(edge[1]).name);
        }

        List<City> tspPath = CalculatePath.constructTSPPath(selectedCities, mstEdges);

        System.out.println("\nTSP Path:");
        for (City city : tspPath) {
            System.out.printf("City: %s, X: %d, Y: %d%n", city.name, city.x, city.y);
        }

        double pathLength = CalculatePath.calculatePathLength(tspPath);
        System.out.printf("\nTotal TSP Path Length: %.2f%n", pathLength);

        // Visualize the TSP Path
        visualizePath(selectedCities, tspPath);
    }

    public static void visualizePath(List<City> cities, List<City> tspPath) {
        JFrame frame = new JFrame("TSP Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Draw cities
                g2d.setColor(Color.GRAY);
                for (City city : cities) {
                    g2d.fillOval(city.x, city.y, 12, 12);
                    g2d.drawString(city.name, city.x + 10, city.y - 10);
                }

                // Draw TSP Path
                g2d.setColor(Color.RED);
                for (int i = 0; i < tspPath.size() - 1; i++) {
                    City c1 = tspPath.get(i);
                    City c2 = tspPath.get(i + 1);
                    g2d.drawLine(c1.x, c1.y, c2.x, c2.y);
                }
            }
        };
        frame.add(panel);
        frame.setVisible(true);
    }


}