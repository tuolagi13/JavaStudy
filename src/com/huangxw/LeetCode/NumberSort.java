package com.huangxw.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 有1、2、3、4四个数，输出能组成的所有三位数，要求三位数个、十、百位不能同时相同
 */
public class NumberSort {
    public static List<Integer> conut(int[] input) {
        List<Integer> result = new ArrayList<Integer>();
        int A = 0;//百位数
        int B = 0;//十位数
        int C = 0;//个位数
        int sum = 0;//加起来数值
        for (int i = 0; i < input.length; i++) {
            A = input[i] * 100;
            for (int j = 0; j < input.length; j++) {
                B = input[j] * 10;
                for (int k = 0; k < input.length; k++) {
                    C = input[k];
                }
            }
            if (A / 100 == B / 10 && B / 10 == C) continue;
            sum = A + B + C;

            if (result.indexOf(sum) == -1) {
                result.add(sum);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4};
        List<Integer> out = new ArrayList<>();
        out = conut(input);
        System.out.println(out);

    }
}