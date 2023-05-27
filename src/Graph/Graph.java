package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private int numberOfNodes;
    private final Map<String, List<String>> adjacentList;

    public Graph() {
        this.numberOfNodes = 0;
        this.adjacentList = new HashMap<>();
    }

    public void addVertex(String node) {
        adjacentList.put(node, new ArrayList<>());
        numberOfNodes++;
    }

    public void addEdge(String node1, String node2) {
        // Undirected Graph
        adjacentList.get(node1).add(node2);
        adjacentList.get(node2).add(node1);
    }

    public void showConnections() {
        for (String node : adjacentList.keySet()) {
            List<String> nodeConnections = adjacentList.get(node);
            String connections = "";
            for (String vertex : nodeConnections) {
                connections += vertex + " ";
            }
            System.out.println(node + "-->" + connections);
        }
    }
}



