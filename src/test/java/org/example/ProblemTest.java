package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTest {
@Test
public void AtLeastOneItemReturned() {
    Problem problem = new Problem(5, 3, 1, 10);
    problem.items.addAll(Arrays.asList(
            new Item(2, 3, 1),
            new Item(6, 4, 2),
            new Item(1, 5, 3),
            new Item(10, 6, 4),
            new Item(7, 7, 5)
    ));

    Result result = problem.Solve(10);
    assertFalse(result.result_items.isEmpty());
}
    @Test
    public void EmptySolutionReturned() {
        Problem problem = new Problem(5, 3, 1, 10);
        problem.items.addAll(Arrays.asList(
                new Item(10, 3, 1),
                new Item(8, 4, 2),
                new Item(5, 5, 3),
                new Item(6, 6, 4),
                new Item(9, 7, 5)
        ));

        Result result = problem.Solve(4);
        assertEquals(0, result.num_of_items);
    }

    @Test
    public void ItemsWithinRange() {
        Problem problem = new Problem(5, 2, 1, 10);
        problem.GenerateProblem();

        for (Item item : problem.items) {
            assertTrue(item.weight >= 1 && item.weight <= 10);
            assertTrue(item.value >= 1 && item.value <= 10);
        }
    }

    @Test
    public void SolutionCorrectness() {
        Problem problem = new Problem(5, 2, 1, 10);
        problem.items.addAll(Arrays.asList(
                new Item(1, 3, 1),
                new Item(7, 4, 2),
                new Item(5, 5, 3),
                new Item(3, 6, 4),
                new Item(8, 7, 5)
        ));

        Result result = problem.Solve(10);
        assertEquals(10, result.total_weight);
        assertEquals(30, result.total_value);
        assertEquals(10, result.num_of_items);

    }
}