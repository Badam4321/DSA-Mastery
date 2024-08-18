package array.TwoPointersPatterns;

import java.util.Arrays;

public class ProductOfArrayExceptItSelf {
    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3 , 4};
        int[] res =  productOfArrayExceptItSelf(arr);
        System.out.println(Arrays.toString(res));

    }

    private static int[] productOfArrayExceptItSelf(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        // Calculate left prefix products
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= arr[i];
        }
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= arr[i];
        }
        return  result;
    }
}
