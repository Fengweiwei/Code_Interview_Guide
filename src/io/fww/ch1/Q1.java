package io.fww.ch1;

import java.util.Stack;

/**
 * Created by fengweiwei on 10/7/16.
 */
public class Q1{
    /*设计具有getMin功能的栈
    * 要求：pop，push，getMin时间复杂度O（1）*/
    /*思路：用另外一个栈专门记录min，同步栈的状态*/
    private Stack<Integer> data;
    private Stack<Integer> min;

    public Q1(){
        this.data = new Stack<>();
        this.min = new Stack<>();
    }

    public Integer pop() throws Exception {
        if(data.empty())
            throw new Exception("stack is empty!");
        Integer val = data.pop();
        min.pop();
        return data.pop();
    }

    public void push(int elem) throws Exception {
        if(min.isEmpty())
            min.push(elem);
        else
            min.push(elem>this.getMin()?this.getMin():elem);
        data.push(elem);
    }

    public Integer getMin() throws Exception {
        if(min.empty())
            throw new Exception("stack is empty!");
        return min.peek();
    }
}
