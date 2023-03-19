package net.guides.springboot2.persist.depersist;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY num
     *  2. INTEGER k
     */

    public static int minSum(List<Integer> num, int k) {
    // Write your code here
    int size = num.size();
    int finalSum=0;
    double result;
    while(k>0){
    if(size>1)
    {
            int numToRed = num.get(1);
            result = Math.ceil(numToRed/2);
            num.remove(1);
            num.add(1, (int)result);
            
    }
    k--;
    }
    
    System.out.println("New List is: "+num);
    
    for(int ele : num)
    {
        finalSum = finalSum+ele;
    }
    
    return finalSum;
}

}

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> num = new ArrayList<Integer>();
        num.add(2);
        num.add(5);
        num.add(6);
        num.add(8);
        int result = Result.minSum(num, 4);
        System.out.println("Output "+result);

    }
}


