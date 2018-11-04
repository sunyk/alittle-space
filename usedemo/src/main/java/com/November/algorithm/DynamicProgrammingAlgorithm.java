package com.November.algorithm;

/**
 * Create by sunyang on 2018/11/3 15:55
 * For me:One handred lines of code every day,make myself stronger.
 */
public class DynamicProgrammingAlgorithm {

    int[] result = new int[1000];

    public int de(int n){
        if (n == 0){
            return 1;
        }else if (n == 1){
            return 1;
        }else if (result[n] != -1){
            return result[n];
        }else{
            result[n] = de(n - 1) + de(n -2);
            return result[n];
        }
    }


    public static void main(String[] args) {
        DynamicProgrammingAlgorithm dynamicProgrammingAlgorithm = new DynamicProgrammingAlgorithm();
        System.out.println(dynamicProgrammingAlgorithm.de(58));
    }
}
