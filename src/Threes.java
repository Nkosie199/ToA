/**
 * @author adam2
 * 
Problem description
Given the binary string representation of a number, your job is to find the minimum number of cuts
that need to be made to this string, such that each of the resulting binary strings represents a
number which is a power of three.
* 
Example
You are given the string 1010001111001. The minimum number of cuts required is 2. This can be
done by cutting the string into 1010001 = 3^4 , 11 = 3^1 , and 1001 = 3^2 .
* 
Input and output
Program input and output will make use of stdio streams (System.in and System.out in Java) i.e. not
file I/O.
* 
Input
The input will consist of a single line, which is a binary string.
Sample Input:
1011011001100010001011
* 
Output
Your output should be a single integer, which is the number of cuts required.
Sample output:
1 
 */
public class Threes {
    static int cuts = 0;
    
    public static void main (String[] args){
        //String sampleInput = "1010001111001";
        String sampleInput = "1011011001100010001011";
        compute(sampleInput);
    }
    
    public static int compute(String binary){
        String b = binary;
        for (int i = 0; i < binary.length(); i++) {
            //do for 1
            //and then 10
            //...
            String s = (String) binary.subSequence(0, i+1);
            int dec = binary2Decimal(s);
            //System.out.println(s+" = "+dec);
            if (dec % 3 == 0 && dec > 0){ //if the decimal is perfectly divisible by 3
                System.out.println(s+" = "+dec);
                cuts++;
                return compute((String) binary.subSequence(i+1, binary.length()));
                
            }
        }
        System.out.println("Cuts: "+cuts);
        return cuts;
    }
    
    public static int binary2Decimal(String binary){
        int b = Integer.parseInt(binary,2);
        return b;
    }
}
