import java.util.Arrays;
import java.util.Scanner;

class Item implements Comparable<Item> {
    int profit;
    int weight;

    Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }

    @Override
    public int compareTo(Item other) {
        double ratio1 = (double) this.profit / this.weight;
        double ratio2 = (double) other.profit / other.weight;
        return Double.compare(ratio2, ratio1);
    }
}

public class greedy {

    public static double fractionalKnapsack(int capacity, Item[] items) {
        Arrays.sort(items);

        double totalProfit = 0.0;

        for (Item item : items) {
            if (capacity <= 0)
                break;

            if (item.weight <= capacity) {
                totalProfit += item.profit;
                capacity -= item.weight;
            } else {
                double fraction = (double) capacity / item.weight;
                totalProfit += fraction * item.profit;
                capacity = 0;
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        Item[] items = new Item[n];
        System.out.println("Enter the profit and weight of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Profit: ");
            int profit = scanner.nextInt();
            System.out.print("       - Weight: ");
            int weight = scanner.nextInt();
            items[i] = new Item(profit, weight);
        }

        double maxProfit = fractionalKnapsack(capacity, items);
        System.out.println("\nMaximum total profit in the knapsack: " + maxProfit);
    }
}