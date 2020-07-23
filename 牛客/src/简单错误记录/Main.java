package 简单错误记录;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        int count = 0;
        while (in.hasNext()){
            String s1 = in.nextLine();
            fun(s1,map);

        }
        // 输出后8位
        for (String st : map.keySet()) {
            count++;
            if (count > (map.size() - 8)) {
                System.out.println(st + " " + map.get(st));
            }
        }
    }

    private static void fun(String s1, Map<String, Integer> map) {
        String[] str = s1.split(" ");
        // "\\\\"按照反斜杠分割
        String[] nameStr = str[0].split("\\\\");
        int num =Integer.parseInt(str[1]);
        String name = nameStr[nameStr.length-1];
        // 取最后有效的16个字符为最终文件名
        if(name.length()>16){
            name = name.substring(name.length()-16);
        }
        // 将文件名和行号组成字符串 作为map的key值存放
        String key = name+" "+num;
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
}
