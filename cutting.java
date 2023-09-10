import java.util.List;

public class cutting {
    public static void main(String[] args) {
        List<Integer> x = List.of(1, 2, 3, 4);
        List<Integer> y = List.of(1, 2, 4);
        int m = 6, n = 4;
        int noofvertical = 1;
        int noofhorizontal = 1;
        int totalcost = 0;
        int i = 0, j = 0;

        while (i < m - 1 && j < n - 1) {
            if (x.get(i) > y.get(i)) {
                totalcost += x.get(i) * noofhorizontal;
                noofvertical++;
                i++;
            } else if (x.get(i) < y.get(i)) {
                totalcost += y.get(i) * noofvertical;
                noofhorizontal++;
                j++;
            }
        }
        while (i < m - 1) {
            totalcost += x.get(i) * noofhorizontal;
            i++;
        }
        while (j < n - 1) {
            totalcost += y.get(i) * noofvertical;
            j++;

        }
        System.out.println(totalcost);

    }
}
