package 子串判断;
import java.util.*;
//现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p，请设计一个高效算法，对于p中的每一个较短字符串，判断其是否为s的子串。
//给定一个string数组p和它的大小n，同时给定string s，为母串，请返回一个bool数组，
// 每个元素代表p中的对应字符串是否为s的子串。保证p中的串长度小于等于8，且p中的串的个数小于等于500，同时保证s的长度小于等于1000。
public class Substr {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] f = new boolean[n];
        for (int i = 0; i < p.length; i++) {
            if(s.contains(p[i])){
                f[i] = true;
            }
        }
        return f;
    }

    public static void main(String[] args) {
        String[] p = {"1","2","33","5"};
        String s = "1235";

        System.out.println(Arrays.toString(chkSubStr(p,p.length,s)));
    }
}