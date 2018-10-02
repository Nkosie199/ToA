
import java.util.Scanner;

/*
Problem Description
Write a program that, given a positive integer, N, and a non-negative integer, Z, counts the number of
pairs of positive integers X and Y (0<X<N, 0<Y<N) for which (X * Y) *modulo* N == Z.
The modulus (or modulo) operation finds the remainder when one number is divided by another. For
example: 8 *modulo* 3 is 2. (This is expressed in C, C++ and Java with the % operator, so 8 % 3 == 2.)
Example:
Given that N = 6 and Z = 3, the following pairs of integers would be counted, giving an answer of 5:
1, 3
3, 1
3, 3
3, 5
5, 3
Note that the order within the pair matters. For example, (1, 3) and (3, 1) are counted as distinct pairs.
Input and Output
Program input and output will make use of stdio streams (System.in and System.out in Java)
i.e. not file I/O.
Input consists of two lines, the first containing the integer N, and the second containing the integer Z.
Constraints:
1 ≤ N ≤ 1,000
0 ≤ Z < N
Output consists of a single integer (the number of different pairs of positive integers, X and Y, for which
(X * Y) *modulo* N == Z) followed by a line break --- in Java, for example, use System.out.println,
not System.out.print. The automatic marker expects this precise form.
Sample Input:
6
3
Sample output:
5
 */

/**
 *
 * @author adam2
 */
public class Modulus {
    static int N, Z, X, Y;
    static int count = 0;
//    counts the number of pairs of positive integers X and Y (0<X<N, 0<Y<N) for which (X * Y) *modulo* N == Z
    
    public static void main(String[] args){
//        Sample Input:
//        6
//        3
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Z = sc.nextInt();
        checker(N, Z);
        
    }
    
    static void checker(int n, int z){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i * j)%n == z){
                    System.out.println("X: "+i+", Y: "+j);
                    count++;
                }
            }
        }
        System.out.println("Count = "+count);
    }
}
