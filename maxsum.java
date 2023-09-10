import java.util.ArrayList;
import java.util.List;

public class maxsum {
    public static void main(String[] args) {

        int S = 9;
        int D = 2;
        if (S == 0 || S > D * 9) {
            System.out.println("not post");
            return;
        }
        S -= 1;
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < D; i++) {
            num.add(0);

        }
        for (int i = D - 1; i >= 1; i--) {
            if (S > 9) {
                num.set(i, 9);
                S -= 9;
            } else {
                num.set(i, S);
                S = 0;
                break;
            }

        }
        num.set(0, S + 1);
        System.out.println(num);
    }

}
