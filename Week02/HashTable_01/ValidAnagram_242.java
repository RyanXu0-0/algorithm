package HashTable_01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @projectName:IDEAProject
 * @see:PACKAGE_NAME
 * @author:徐东
 * @createTime:2020/11/9 22:38
 * @version:1.0
 */
public class ValidAnagram_242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    /*
     * description 方法一：暴力法
     * param [s, t]
     * return boolean
     * author Ryan Xu
     * createTime 2020/11/9 22:39
     **/
    public static boolean isAnagram(String s, String t) {
        List<String> sArr = Arrays.stream(s.split("")).collect(Collectors.toList());
        String[] tArr = t.split("");

        if (sArr.size() != tArr.length) return false;

        for (int i = 0; i < tArr.length; i++) {
            for (String s1 : sArr) {
                if(tArr[i].equals(s1)) {
                    sArr.remove(s1);
                    break;
                }
            }
        }
        return sArr.isEmpty();
    }

    /**
     * description 方法二：排序
     * param [s, t]
     * return boolean
     * author Ryan Xu
     * createTime 2020/11/9 23:03
     **/
    public boolean isAnagram1(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        if (sArr.length != tArr.length) return false;

        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a'] ++;
            alpha[t.charAt(i) - 'a'] --;
        }
        for (int i: alpha){
            if (i != 0) return false;
        }
        return true;
    }
}
