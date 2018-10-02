
import java.util.ArrayList;

/**
 * @author adam2
 * 
Problem description
Given a sequence of n floating point numbers [x 1 , x 2 , ... , x n ], a contiguous sub sequence is a
sequence formed using the elements of the original sequence, where all the elements were adjacent
in the original sequence and appear in the same order in the subsequence as in the original
sequence. A contiguous sub sequence can be constructed by selecting two numbers in the original
sequence and forming the sub sequence by including all numbers in between the two selected. For
example, if we have the sequence [9.4, 8.2, 0.01, 3, 4.222, 2.6, 6.1, 1.1, 5.9], then [9.4, 8.2, 0.01],
[3, 4.222], and [4.222, 2.6, 6.1, 1.1, 5.9] are all contiguous sub sequences. However, 
[8.2, 0.01, 4.222, 2.6, 6.1] is not contiguous, as it is missing the number 3. 
Your task is, given a sequence of floating
point numbers, to find the length of the contiguous subsequence with the maximum product.
* 
Example
You are given the sequence [0.5, 1.0, 1.5, 0.001, 20, 1.1, 0.01]. The contiguous subsequence with the
maximum product is [20, 1.1], which has length 2.
* 
Input and output
Program input and output will make use of stdio streams (System.in and System.out in Java) i.e. not
file I/O.
* 
Input
The input will consist of a single line of n real numbers, separated by spaces.
* 
Sample Input:
0.1 20 5 6.6 7 0 20 0.01 0.5 0.0067
* 
Output
Your output should consist of single integer, which is the length of the contiguous subsequence with
the maximum product.
* 
Sample output:
4
* 
Constraints
1 ≤ n ≤ 100 000
-10 000 ≤ x i ≤ 10 000
 * 
 */

public class Product {
    //the solution is algorithm #26: Coin Row Problem
    static ArrayList<Float> floats = new ArrayList<>();
    static float max = 0; //float variable used to store the maximum product
    static float currentProduct; //float variable used to store the maximum product of the current iteration
    static int maxLength = 0; //float variable used to store the length of the maximum product
    
    public static void main(String[] args){
        String inputString = "0.1 20 5 6.6 7 0 20 0.01 0.5 0.0067";
        
        read(inputString);
    } 
    
    static void read(String input){
        String[] elements = input.split(" ");
        for (String s: elements){
            float i = Float.parseFloat(s);
            floats.add(i);
        }
        //by this point all float elements have been stored in the floats array
        compute();
        output();
    }
    
    static void compute(){
        for (int i = 0; i < floats.size()-1; i++){ //for each element in the floats array
            //multiply by next element, and then the next element...
            currentProduct = floats.get(i) * 1; //compare with the next element
            int currentMaxLength = 1;
            for (int j = (i+1); j < floats.size(); j++) { //compare with the subsequent elements in the floats array
                //if the max is greater than current
                if (currentProduct > max){
                    max = currentProduct;
                    //print out that you've found a new max and its value
                    //System.out.println("Maximum value updated to "+ max);
                    maxLength = currentMaxLength;
                    //System.out.println("Maximum length updated to "+ maxLength);
                }
                //System.out.println("Current product = "+currentProduct+" * "+floats.get(j)+" = "+currentProduct*floats.get(j));
                currentProduct = currentProduct *  floats.get(j);
                currentMaxLength++;
            }
            //System.out.println("");
            
        }
    }
    
    static void output(){
        System.out.println("Max length: "+maxLength);
    }
}

//Comparisons I want given ---> 0.1 20 5 6.6 7 0 20 0.01 0.5 0.0067:
//
//0.1 * 20 = 2
//0.1 * 20 * 5 = 10
//0.1 * 20 * 5 * 6.6 = 66
//...