
import java.util.ArrayList;
import java.util.Scanner;

/*
Problem Description
A lumber yard has a stock of N long wooden planks with lengths L 1 , ..., L N . Planks can be divided into
shorter planks --- a plank of length 12, for example, can be divided into three shorter planks, each of
length 4 --- but separate pieces can't be joined to form longer planks.
A large order has been placed, requesting that at least K planks of equal length, M, be delivered.
Write a program that, given K and the lengths of planks in stock, L 1 , ..., L N, determines the maximum
possible value for M.
Note that as the length increases, the number of planks that can be made will decrease.
Example
You are given N = 4 planks with lengths 10, 14, 15, 11. The order requests a minimum of 6 planks.
The order can be fulfilled with 6 planks of length 7 each:
 The plank of length 10 is divide into one plank of length 7, and one of length 3 (which is
discarded).
 The plank of length 14 is divide into two planks of length 7.
 The plank of length 15 is divide into two planks of length 7, and one of length 1 (which is
discarded).
 The plank of length 11 is divide into one plank of length 7, and one of length 4 (which is
discarded).
The order can’t be fulfilled with planks of length 8 or more, so 7 is the maximum length.
Note that although the discarded pieces have a combined length greater than 7, they can't be
combined to form a longer plank.
 * Input and Output
Program input and output will make use of stdio streams (System.in and System.out in
Java) i.e. not file I/O.
Input consists of a series of integer values, each on a separate line. The first value is N, the number
of planks in stock, followed by the lengths of those planks, L 1 , ..., L N , followed by K, the minimum
number of planks required.
Output consists of a single integer, M (the maximum possible length that will allow K planks to be
delivered), followed by a line break --- in Java, for example, use System.out.println, not
System.out.print. The automatic marker expects output in this precise form.
Constraints:
1 ≤ N ≤ 10,000
1 ≤ L i ≤ 1,000,000,000
1 ≤ K ≤ 10,000,000
The answer, M, will be bounded by:
1 ≤ M ≤ 10,000,000
Sample Input:
4
10
14
15
11
6
Sample output:
7
Scoring
Each test case that is answered correctly will earn 10 points.
 */

/**
 *
 * @author adam2
 */
public class Dividing {
    static int minNoOfPlanks;
    static ArrayList<Integer> logs = new ArrayList<>();
    static ArrayList<String> inputs = new ArrayList<>();
    static int GCD = 10000000; //start with upper bound and reduce
    
    //this program attemps to find the maximumLength for diving planks L1...Ln into a minNoOfPlanks of equal size
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Sample Input: 4 10 14 15 11 6
        String input = sc.nextLine();
        while (!"".equals(input)){
            inputs.add(input);
            //System.out.println("= "+input);
            input = sc.nextLine();
            
        }
        
        for (int i = 0; i < inputs.size(); i++) {
            if (i == inputs.size()-1){
                //System.out.println("Minimum # of planks: "+inputs[i]);
                minNoOfPlanks = Integer.parseInt(inputs.get(i));
            }
            else{
                //System.out.println("Log "+i+" size: "+inputs[i]);
                int j = Integer.parseInt(inputs.get(i));
                logs.add(j);
                
            }
        }
        //input complete. Now to finding the greatest common denominator...
        gcd();
        output();
    }
    
    static void gcd(){
        int j = 0; //stores the longest log size
        for (int i = 0; i < logs.size(); i++) {
            //find the longest log
            if (logs.get(i) > j){
                j = logs.get(i);
            }
        }
        GCD = gcd(j);
        
    }
    
    static int gcd(int maxLength){
        int outBox = 0;
        for (int k = 0; k < logs.size(); k++) {
            int out = logs.get(k)/maxLength; //# of logs out
            //System.out.println("Out: "+out);
            outBox = outBox + out;
        }
        //check if outBox meets requirements
        //System.out.println("OutBox: "+outBox+", min # required: "+minNoOfPlanks);
        if (outBox < minNoOfPlanks){
            return gcd(maxLength-1);
        }
        else{
            return maxLength;
        }
    }
    
    static void output(){
        System.out.println(GCD+"\n");
    }
}
