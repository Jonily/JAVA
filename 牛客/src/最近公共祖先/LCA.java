package 最近公共祖先;

import java.util.*;

public class LCA {
    public int getLCA(int a, int b) {
        while(a != b) {
            if(a > b)
                a /= 2;
            else
                b /= 2;
        }
        return a;
    }
}