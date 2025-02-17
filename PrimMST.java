import java.util.*;

public class PrimMST {
    public static List<int[]> primMST(List<City> cities) {
        int n = cities.size();
        boolean[] visited = new boolean[n];
        double[] minEdge = new double[n];
        int[] parent = new int[n];
        Arrays.fill(minEdge, Double.MAX_VALUE);
        minEdge[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[2]));

        // [current, parent, weight]
        pq.offer(new int[]{0, -1, 0});
        List<int[]> mstEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int current = edge[0];

            if (visited[current]) continue;
            visited[current] = true;

            if (edge[1] != -1) {
                mstEdges.add(new int[]{edge[1], current});
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    double dist = cities.get(current).distanceTo(cities.get(i));
                    if (dist < minEdge[i]) {
                        minEdge[i] = dist;
                        parent[i] = current;
                        pq.offer(new int[]{i, current, (int) dist});
                    }
                }
            }
        }

        return mstEdges;
    }

    public static void dfs(List<int[]> mstEdges, int current, boolean[] visited, List<Integer> order) {
        visited[current] = true;
        order.add(current);

        for (int[] edge : mstEdges) {
            if (edge[0] == current && !visited[edge[1]]) {
                dfs(mstEdges, edge[1], visited, order);
            } else if (edge[1] == current && !visited[edge[0]]) {
                dfs(mstEdges, edge[0], visited, order);
            }
        }
    }
}
