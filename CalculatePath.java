import java.util.ArrayList;
import java.util.List;

public class CalculatePath {
    public static List<City> constructTSPPath(List<City> cities, List<int[]> mstEdges) {
        boolean[] visited = new boolean[cities.size()];
        List<Integer> order = new ArrayList<>();
        PrimMST.dfs(mstEdges, 0, visited, order);

        List<City> tspPath = new ArrayList<>();
        for (int index : order) {
            tspPath.add(cities.get(index));
        }
        tspPath.add(cities.get(order.get(0))); // Close the loop

        return tspPath;
    }

    public static double calculatePathLength(List<City> path) {
        double totalLength = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            totalLength += path.get(i).distanceTo(path.get(i + 1));
        }
        return totalLength;
    }
}
