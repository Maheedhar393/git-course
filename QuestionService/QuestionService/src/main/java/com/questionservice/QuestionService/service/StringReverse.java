package com.questionservice.QuestionService.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringReverse {

    public static void main(String args[]){
        String st = "Hello";
//        String st1 = "Hello";
//        String st2 = new String("Hello");
//        String res ="";
//        for(int i=st.length()-1;i>=0;i--){
//            res = res + st.charAt(i);
//        }
//        System.out.println(res);
//        System.out.println(st == st1);
//        System.out.println(st == st2);
//        System.out.println(st.equals(st2));

        String pa1 = "Maheedhar";
        String pa2 = "silant";
        char ar[] = pa1.toCharArray();
        Arrays.sort(ar);
        char ar1[]=pa2.toCharArray();
        Arrays.sort(ar1);
        String he1 = new String(ar);
        String he2 = new String(ar1);
        System.out.println(he1.equals(he2));

        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i<ar.length;i++){
            if(map.containsKey(ar[i])){
                int c = map.get(ar[i]);
                c++;
                map.put(ar[i],c);
            }
            else{
                map.put(ar[i],1);
            }
        }
        System.out.println(map);

    }
}
