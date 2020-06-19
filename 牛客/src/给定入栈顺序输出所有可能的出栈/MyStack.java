package 给定入栈顺序输出所有可能的出栈;

import java.util.*;

public class MyStack {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        ArrayList<Integer> outPut = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){

            int num=in.nextInt();
            int[] nums=new int[num];
            for(int i=0;i<num;i++) {
                nums[i]=in.nextInt();
            }
            stackOut(nums,0,0,stack,outPut);

        }
    }
    public static void stackOut(int[] nums, int inNum, int outNum, LinkedList<Integer> stack, ArrayList<Integer> output)
    {
        if(inNum==nums.length&&outNum==nums.length)
        {

            System.out.println(output);

            //nums++;
        }
        else
        {
            LinkedList<Integer> stack1=(LinkedList<Integer>)stack.clone();
            LinkedList<Integer> stack2=(LinkedList<Integer>)stack.clone();

            if(inNum<nums.length)
            {
                stack1.push(nums[inNum]);
                stackOut(nums,inNum+1,outNum,stack1,output);
                stack1.pop();
            }
            ArrayList<Integer> output1=(ArrayList<Integer>)output.clone();
            if(inNum>outNum)
            {
                output1.add(stack2.pop());
                stackOut(nums,inNum,outNum+1,stack2,output1);
            }
        }
    }


}
