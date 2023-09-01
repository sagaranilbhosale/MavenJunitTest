package com.sb.dg.prob;

import java.util.*;

/**
 * You wrote a trendy new messaging app, MeshMessage, to get around flaky cell phone coverage.
 * <p>
 * Instead of routing texts through cell towers, your app sends messages via the phones of nearby users, passing each message along from one phone to the next until it reaches the intended recipient. (Don't worry—the messages are encrypted while they're in transit.)
 * <p>
 * Some friends have been using your service, and they're complaining that it takes a long time for messages to get delivered. After some preliminary debugging, you suspect messages might not be taking the most direct route from the sender to the recipient.
 * <p>
 * Given information about active users on the network, find the shortest route for a message from one user (the sender) to another (the recipient). Return an array of users that make up this route.
 * <p/><a href="https://www.interviewcake.com/question/java/mesh-message">Mesh Messahe Interview Cake</a>
 */
public class MeshMessage {
    static Map<String, String[]> network = new HashMap<String, String[]>() {{
        put("Min", new String[]{"William", "Jayden", "Omar"});
        put("William", new String[]{"Min", "Noam"});
        put("Jayden", new String[]{"Min", "Amelia", "Ren", "Noam"});
        put("Ren", new String[]{"Jayden", "Omar"});
        put("Amelia", new String[]{"Jayden", "Adam", "Miguel"});
        put("Adam", new String[]{"Amelia", "Miguel", "Sofia", "Lucas"});
        put("Miguel", new String[]{"Amelia", "Adam", "Liam", "Nathan"});
        put("Noam", new String[]{"Nathan", "Jayden", "William"});
        put("Omar", new String[]{"Ren", "Min", "Scott"});
    }};

    public static List<String> bfs(String startNode, String endNode) {
        Queue<String> nodesToBeVisited = new LinkedList<>();
        Map<String, String> pathToNode = new HashMap<>();
        if (startNode.equals(endNode)) {
            return new ArrayList<String>() {{
                add(startNode);
            }};
        }

        nodesToBeVisited.add(startNode);
        pathToNode.put(startNode, null);

        while (!nodesToBeVisited.isEmpty()) {
            String currentNode = nodesToBeVisited.remove();

            String[] adjacentNodes = network.get(currentNode);
            if (adjacentNodes == null)
                continue;
            for (String node : adjacentNodes) {
                if (node.equals(endNode)) {
                    pathToNode.put(node, currentNode);
                    List<String> path = constructPath(pathToNode, startNode, endNode);
                    Collections.reverse(path);
                    return path;
                } else {
                    if (!pathToNode.containsKey(node)) {
                        pathToNode.put(node, currentNode);
                        nodesToBeVisited.add(node);
                    }
                }

            }
        }
        return null;
    }

    private static List<String> constructPath(Map<String, String> pathToNode, String startNode, String endNode) {
        List<String> path = new ArrayList<>();
        String currentNode = endNode;

        while (currentNode != null) {
            path.add(currentNode);
            currentNode = pathToNode.get(currentNode);
        }
        return path;
    }
}
