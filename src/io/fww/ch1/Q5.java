package io.fww.ch1;

import java.util.Stack;

/**
 * Created by fengweiwei on 10/7/16.
 */
public class Q5 {
    /*用一个栈实现另一个栈排序*/
    /*要求：想将栈s从顶到底按从大到小顺序排序，只许申请一个栈help*/
    /*设想，把help弄成从顶到底按从小到大排序，那么help pop到s就行了
    * */
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            int tmp = stack.pop();
            //每一次stack pop，把help排序好
            while (!help.empty() && tmp > help.peek())
                stack.push(help.pop());
            help.push(tmp);
        }
        //finally
        while(!help.empty())
            stack.push(help.pop());
    }
}
