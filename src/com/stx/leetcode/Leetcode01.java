package com.stx.leetcode;


import java.util.ArrayList;
import java.util.List;

public class Leetcode01 {
    public static void main(String [] args){
        List<String> strings = generateParenthesis(3);

        System.out.println(strings);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gen("",result,n,n);
        return result;
    }

    public static void gen(String subList, List<String> result, int left, int right){
        if(left == 0 && right == 0){
            result.add(subList);
            return;
        }
        if(left > 0){
            gen(subList + "(",result,left -1 ,right);
        }
        if(right > 0){
            gen(subList + ")",result,left,right - 1);
        }
    }


    public int maxProfit(int[] prices) {
        int len = prices.length;
        int price = 0;

        for(int i = 1;i<len;i++){
            if(prices[i] > prices[i-1]){
                int p = prices[i] - prices[i - 1];
                price += p;
            }
        }
        return price;
    }
}
