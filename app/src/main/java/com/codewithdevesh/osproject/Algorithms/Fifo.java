package com.codewithdevesh.osproject.Algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Fifo {
    public int performFifo(int[] pages,int frames){
        HashSet<Integer> set = new HashSet<>(frames);
        Queue <Integer> queue = new LinkedList<>();
        int faults=0;

        for (int page : pages) {
            if (set.size() < frames) {
                if (!set.contains(page)) {
                    set.add(page);
                    faults++;
                    queue.add(page);
                }
            } else {
                if (!set.contains(page)) {
                    int x = queue.peek();
                    queue.poll();
                    set.remove(x);
                    set.add(page);
                    queue.add(page);
                    faults++;
                }
            }
        }
        return faults;

    }
}
