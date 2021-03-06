import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * 2d Array - DS.
 *
 * @author: Kennedy Alex Omondi Owiro 
 * {@Phone: +254704026160}
 * {@email: jambotechsolutions@gmail.com }
 */
public class TestHourGlass {


        public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                int arr[][] = new int[6][6]; 
                int hourGlassSum[] = new int[16];
                int pos = 0;

                //Reads data from user input and store in 6*6 Array
                for (int arr_i = 0; arr_i < 6; arr_i++) {
                    for (int arr_j = 0; arr_j < 6; arr_j++) {
                        arr[arr_i][arr_j] = in.nextInt();
                    }
                }
                //Find each possible hourGlass and calculate sum of each hourGlass
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        hourGlassSum[pos] = calculateHourGlassSum(arr, i, i + 2, j, j + 2);
                        pos++;
                    }
                }
                System.out.println(findmax(hourGlassSum));

            }
            /**
             * @param arr 
             * @param pos1 - Row startPoint
             * @param pos2 - Row endPoint
             * @param pos3 - column startPoint
             * @param pos4 - column endPoint
             * @return
             */
            public static int calculateHourGlassSum(int arr[][], int pos1, int pos2, int pos3, int pos4) {

                int sum = 0;
                int exclRowNum = pos1 + 1;
                int exclColNum1 = pos3;
                int exclColNum2 = pos4;
                for (int arr_i = pos1; arr_i <= pos2; arr_i++) {
                    for (int arr_j = pos3; arr_j <= pos4; arr_j++) {
                        sum = sum + arr[arr_i][arr_j];
                    }
                }
                sum = sum - (arr[exclRowNum][exclColNum1] + arr[exclRowNum][exclColNum2]);
                return sum;
            }

            /**
             * @param arr
             * @return max elem of Array
             */
            public static int findmax(int arr[]) {
                int max = arr[0];
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] >= max)
                        max = arr[i];
                }
                return max;
            }
}