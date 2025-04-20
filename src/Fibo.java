import java.util.Arrays;

public class Fibo {

    int[] memo;
    int count = 0;

    public Fibo() {
        memo = new int[50];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
    }

    public int fiboIter(int n) {
        int[] val = new int[n + 1]; //n으로 1들어오면 배열은 2개 있어야 0, "1" 번째 줄 수 있어서
        val[0] = 0;
        val[1] = 1;

        for (int i = 2; i <= n; i++) {
            val[i] = val[i - 1] + val[i - 2];
        }
        return val[n];
    }

    public int fiboRecMemo(int n) {
        count++;
        if (n < 2) {
            return memo[n];
        } else {
            if (memo[n - 1] == -1) {
                memo[n - 1] = fiboRecMemo(n - 1);
            }
            if (memo[n - 2] == -1) {
                memo[n - 2] = fiboRecMemo(n - 2);
            }
            return memo[n - 1] + memo[n - 2]; //2일때는 이것만.
        }
    }

    public int fiboRec(int n) {
        count++;
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return fiboRec(n - 1) + fiboRec(n - 2);
    }

    public static void main(String[] args) {
        Fibo f = new Fibo();
        int n = 10;
        System.out.println("Iterative: " + f.fiboIter(n));
        System.out.println("Recursive Memo: " + f.fiboRecMemo(n));
        System.out.println("Recursive: " + f.fiboRec(n));
        System.out.println("Count: " + f.count);
    }
}
