import java.util.*;
public class Main {
    public static class Graph {
        private Map<String, List<String>> adjList;

        public Graph() {
            adjList = new HashMap<>();
        }
        public Set<String> getAllNodes() {
            return adjList.keySet();
        }

        public void addVertex(String vertex) {
            adjList.putIfAbsent(vertex, new ArrayList<>());
        }

        public void addEdge(String v1, String v2) {
            addVertex(v1);
            addVertex(v2);
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }

        public void printGraph() {
            for (String vertex : adjList.keySet()) {
                System.out.print(vertex + " -> ");
                System.out.println(adjList.get(vertex));
            }
        }
        public void bfs(String start, Set<String> visited){
            Queue<String> queue = new LinkedList<>();
            queue.add(start);
            visited.add(start);
            while (!queue.isEmpty()){
                String curr = queue.poll();
                for(String neighbor : adjList.getOrDefault(curr, new ArrayList<>())){
                    if(!visited.contains(neighbor)){
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
    public static int numIslands(char[][] grid) {
        Graph islands = new Graph();
        Set<String> visited = new HashSet<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    islands.addVertex(i + "" + j);
                    if(!visited.contains(i + "" + j)){
                        visited.add(i + "" + j);
                        int rows = grid.length;
                        int cols = grid[0].length;
                        if (i + 1 < rows && grid[i + 1][j] == '1') {
                            islands.addEdge(i + "" + j, (i + 1) + "" + j);
                        }
                        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                            islands.addEdge(i + "" + j, (i - 1) + "" + j);
                        }
                        if (j + 1 < cols && grid[i][j + 1] == '1') {
                            islands.addEdge(i + "" + j, i + "" + (j + 1));
                        }
                        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                            islands.addEdge(i + "" + j, i + "" + (j - 1));
                        }

                    }
                }
            }
        }
        Set<String> visitedG = new HashSet<>();
        int count = 0;
        for (String node : islands.getAllNodes()) {
            if (!visitedG.contains(node)) {
                islands.bfs(node, visitedG);
                count++;
            }
        }
        //islands.printGraph();
        return count;
    }
    public static void main(String[] args) {
        char[][] inp = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(inp));
    }

}
