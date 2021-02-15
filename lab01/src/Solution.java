import java.util.Arrays;

public class Solution {
    static int[] binaryDigits;

    public static void knapsack(int n, String[] s, int[] w, int[] v, int W) {
        int solutionMaxWeight = 0;
        int solutionMaxValue = 0;
        String[] solutionItems = new String[n];

        int powerOfTwo = (int) Math.pow(2, n);
        System.out.println(powerOfTwo);

        for (int decimal_number = 1; decimal_number < powerOfTwo; decimal_number++) {

            System.out.print(binaryConversion(decimal_number, 0));
            System.out.print(Arrays.toString(binaryDigits));

            int sumWeight = 0;
            int sumValue = 0;

            for (int j = 0; j < n; j++) {
                sumWeight += binaryDigits[j] * w[j];
                sumValue += binaryDigits[j] * v[j];
            }

            if (sumWeight <= W) {
                if (sumValue > solutionMaxValue) {
                    solutionMaxWeight = sumWeight;
                    solutionMaxValue = sumValue;
                    for (int i = 0; i < n; i++) {
                        if (binaryDigits[i] == 1) solutionItems[i] = s[i];
                        else solutionItems[i] = " ";
                    }
                }
            }
            System.out.print(" , " + sumWeight);
            System.out.println(" , " + sumValue);
        }

        System.out.println("Solution: Value=" + solutionMaxValue + " Weight = " + solutionMaxWeight);
        System.out.println(Arrays.toString(solutionItems));


    }


    public static void main(String[] args) {

        int n = 6; // change item number here
        int maxWeight = 60; // maximum weight
        String[] items = new String[]{"#1", "#2", "#3", "#4", "#5", "#6", "#7", "#8", "#9", "#10"};
        int[] weightArray = new int[]{10, 21, 13, 24, 15, 21, 8, 17, 6, 3};
        int[] valueArray = new int[]{13, 17, 12, 5, 19, 4, 25, 30, 7, 22};

        binaryDigits = new int[n];
        knapsack(n, items, weightArray, valueArray, maxWeight);

    }

    // Decimal to binary conversion using recursion
    static int binaryConversion(int decimal_number, int i) {

        if (decimal_number == 0) {
            if (i < binaryDigits.length) binaryDigits[i] = 0;
            return 0;
        } else {
            {
                binaryDigits[i] = decimal_number % 2;
                return (decimal_number % 2 + 10 * binaryConversion(decimal_number / 2, i + 1));
            }
        }

    }
}
