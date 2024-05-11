package graph.advance_problems;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {

//        String[][] airportsArray = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        String[][] airportsArray = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
//        String[][] airportsArray = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
//        String[][] airportsArray = {{"JFK", "ATL"},{"ORD", "PHL"}, {"JFK", "ORD"}, {"PHX", "LAX"},{"LAX", "JFK"}, {"PHL", "ATL"}, {"ATL", "PHX"}};

        List<List<String>> tickets = new ArrayList<>();

        for (String[] strings : airportsArray) {
            tickets.add(List.of(strings[0], strings[1]));
        }

        System.out.println(findItinerary(tickets));

    }


    public static List<String> findItinerary(List<List<String>> tickets) {

        // create an adjacency list, we use priority queue to meet lexical ordering
        Map<String, PriorityQueue<String>> adjacencyList = new HashMap<>();
        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);
            adjacencyList.computeIfAbsent(source, k -> new PriorityQueue<>()).add(destination);
        }

        LinkedList<String> itinerary = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        // we iterate until stack is not empty
        while (!stack.isEmpty()) {
            String airport = stack.peek();
            // check whether we can go to other airports from this airport
            // if we can we go to that airport, or else we add this airport to our itinerary
            // list.
            PriorityQueue<String> destinations = adjacencyList.getOrDefault(airport, new PriorityQueue<>());
            if (!destinations.isEmpty()) {
                stack.push(destinations.poll());
            } else {
                itinerary.addFirst(stack.pop());
            }
        }
        return itinerary;
    }
}
