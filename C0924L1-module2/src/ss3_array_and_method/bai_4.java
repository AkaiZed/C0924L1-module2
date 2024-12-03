package ss3_array_and_method;

public class bai_4 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int result = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[i].length; j++) {
                if (arr[i][j] > result) {
                    result = arr[i][j];
                }
            }
        }
        System.out.print("The largest element in a two-dimensional array is "+result);
    }
}
