package org.example;

import java.util.*;

public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if(!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new ArrayList<>());
                }
                ArrayList<Integer> temp = map.get(routes[i][j]);
                temp.add(i);
                map.put(routes[i][j], temp);
            }
        }
        if (!map.containsKey(source) || !map.containsKey(target)) {
            return -1;
        }
        HashSet<Integer> stops = new HashSet<>();
        HashSet<Integer> buses = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        int move = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                size--;
                int stop = q.remove();
                if (stop == target) {
                    return move;
                }
                for (int here : map.get(stop)) {
                    if (stops.contains(here)) {
                        continue;
                    }
                    stops.add(here);
                    for (int bus : routes[here]) {
                        if (buses.contains(bus)) {
                            continue;
                        }
                        buses.add(bus);
                        q.offer(bus);
                    }
                }
            }
            move++;
        }
        return -1;
    }
}
