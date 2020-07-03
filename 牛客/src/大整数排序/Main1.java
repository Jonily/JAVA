package 大整数排序;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n ; i++) {
                list.add(in.next());
            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o1.length() < o2.length()){
                        return 1;
                    }else if(o1.length() > o2.length()){
                        return 0;
                    }else {
                        for (int i = 0; i <o1.length() ; i++) {
                            if(o1.charAt(i)<o2.charAt(i)){
                                return 1;
                            }else {
                                return 0;
                            }
                        }
                    }
                    return 0;
                }
            });
            System.out.println(list);
        }
    }
}
