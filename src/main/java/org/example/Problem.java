package org.example;

import java.util.*;

public class Problem {

    int num;
    int seed;
    int lowerBound = 1;
    int upperBound = 10;
    List<Item> items = new ArrayList<Item>();
    public Problem( int num, int seed, int lowerBound, int upperBound) {
        this.num = num;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append("Id: ").append(item.id).append(", Waga: ").append(item.weight).append(", Wartość: ").append(item.value).append("\n");
        }
        return sb.toString();
    }

    public Problem GenerateProblem() {
        Random rand = new Random(seed);
        Problem problem = new Problem(num, seed, lowerBound, upperBound);
        for (int i = 0; i < num; i++) {
            int weight = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int value = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            Item item = new Item(weight, value, i+1);
            problem.items.add(item);
        }
        return problem;
    }
    public void Sort (){
        Collections.sort(items, Comparator.comparingDouble(item -> -1.0 * item.value / item.weight));
    }
    public Result Solve (int capacity){

        List<Integer> items_id = new ArrayList<>();
        int num_of_items = 0;
        int total_value = 0;
        int total_weight = 0;

        for (Item item : items) {
            while (total_weight + item.weight <= capacity) {
                items_id.add(item.id);
                num_of_items++;
                total_value += item.value;
                total_weight += item.weight;
            }
        }

        return new Result(items_id, num_of_items, total_value, total_weight);
    }
}
