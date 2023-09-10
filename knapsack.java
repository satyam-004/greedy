import java.util.ArrayList;
import java.util.List;

/**
 * knapsack
 */
public class knapsack {

    public static void main(String[] args) {
        int[] w = { 60, 100, 150, 120 };
        int[] p = { 10, 20, 50, 15 };
        List<Integer> r = new ArrayList<>();

        for (int i = 0; i < p.length; i++) {
            r.add(p[i] / w[i]);
        }
        int tw = 30;
        int profit = 0;
        r.sort(null);
        for (int i = 0; i < r.size() && tw > 0; i++) {

            if (w[i] <= tw) {
                profit += p[i];
                tw -= w[i];
            }

            else {
                profit += (p[i]) / (w[i]) * tw;
                tw = 0;
            }

            System.out.println(profit);
        }
    }
}