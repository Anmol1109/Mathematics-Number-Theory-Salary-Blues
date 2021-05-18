import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int Q = Integer.parseInt(str[1]);

        long[] numbers = new long[N];

        str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(str[i]);
        }


        int[] queries = new int[Q];
        for (int i = 0; i < Q; i++) {
            queries[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);
        if (numbers[0] == numbers[N - 1]) {
            for (int i = 0; i < Q; i++) {
                System.out.println(numbers[0] + queries[i]);
            }
            return;
        }

        long[] result = new long[Q];

        long gcdWM = gcdWithoutMin(numbers);

        for (int i = 0; i < Q; i++) {
            result[i] = gcd(gcdWM, queries[i] + numbers[0]);
        }

        for (long r : result) {
            System.out.println(r);
        }

    }


    private static long gcdWithoutMin(long[] numbers) {
        int start = 1;
        while (numbers[start] == numbers[0]){
            start++;
        }
        long ans = numbers[start];

        for (int i = start + 1; i < numbers.length; i++) {
            ans = gcd(ans, numbers[i]);
        }

        return ans;
    }

    private static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }

}
