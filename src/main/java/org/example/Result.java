package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {
    List<Integer> result_items;
    Integer total_weight;
    Integer total_value;
    Integer num_of_items;


    public Result(List<Integer> result_items, int num_of_items, int total_value, int total_weight) {
        this.result_items = result_items;
        this.num_of_items = num_of_items;
        this.total_value = total_value;
        this.total_weight = total_weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total weight: ").append(total_weight).append("\n");
        sb.append("Total value: ").append(total_value).append("\n");
        sb.append("Number of items in backpack: ").append(num_of_items).append("\n");
        sb.append("Items numbers:\n");
        for (Integer result_items : result_items) {
            sb.append("Id: ").append(result_items).append("\n");
        }
        return sb.toString();
    }
}
