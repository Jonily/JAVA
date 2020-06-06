package 字符串中全是括号并且左右括号匹配;

import java.util.Scanner;
import java.util.Stack;

public class Match {
    public static void main(String[] args) {
        System.out.println("输入字符串：");
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        int n = a.length();
        System.out.println(Match(a,n));

    }
    public static boolean Match(String a,int n){
            Stack<Character>  stack = new Stack<>();
            for (int i = 0; i < n ; i++) {
                char c = a.charAt(i);
                if('(' == c || ')' == c){
                    if('(' == c){
                        stack.push(c);
                    }else {
                        if(stack.isEmpty()){
                            return false;
                        }
                        char b =  stack.pop();
                        if(b == '(' &&  c != ')'){
                            return false;
                        }

                    }
                }else {
                    return false;
                }
            }
            if(stack.isEmpty()){
                return true;
            }
            return false;
     }
}

class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n ; i++) {
            char c = A.charAt(i);
            if('(' == c || ')' == c){
                if('(' == c){
                    stack.push(c);
                }else {
                    if(stack.isEmpty()){
                        return false;
                    }
                    char b = stack.pop();
                    if(b == '(' && c != ')'){
                        return false;
                    }
                }
            }else {
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}