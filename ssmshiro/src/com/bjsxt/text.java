package com.bjsxt;

/**
 * 输出10000-100000中AABB类数
 */
public class text {
    public static void main(String[] args) {
        for (int i = 10000; i < 100000; i++) {
            String s = String.valueOf(i);
            if (s.charAt(0) == s.charAt(1) && s.charAt(1) != s.charAt(2) &&
                    s.charAt(2) ==s.charAt(3) && s.charAt(0) != s.charAt(3)){
                System.out.println(i);
            }
        }
    }
}
