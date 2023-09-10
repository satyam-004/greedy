import java.util.ArrayList;
import java.util.List;

public class permut {
    public static void main(String[] args) {
        String num = "313551";
        List<Integer> frequency = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            frequency.add(0);

        }
        int n = num.length();
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';// minus 0 for get proper digit other wise it gave Ascii value;
            System.out.println(digit);

            frequency.set(digit, frequency.get(digit) + 1);// frequency array making in it
        }
        if (!validate(frequency)) {
            System.out.println("not posssible");
            return;
        }
        String first = "";
        for (int i = 9; i > 0; i--) {
            while (frequency.get(i) > 0) {
                first += i;
                frequency.set(i, frequency.get(i) - 2);
            }

        }
        StringBuilder sb = new StringBuilder(first);
        sb.reverse();
        String second = sb.toString();
        for (int i = 9; i > 0; i--) {
            if (frequency.get(i) == 1)
                first += i;

        }
        System.out.println(first + second);

    }

    private static boolean validate(List<Integer> frequency) {
        boolean isodd = false;
        for (int i = 0; i < frequency.size(); i++) {
            if (frequency.get(i) % 2 != 0) {
                if (isodd == true)
                    return false;
                isodd = true;
            }

        }
        return true;
    }
}
