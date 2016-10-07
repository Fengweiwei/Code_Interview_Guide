package io.fww.ch1;

import java.util.Stack;

/**
 * Created by fengweiwei on 10/7/16.
 */
public class Q2 <E>{
    /*两个栈组成队列*/
    private Stack<E> stack1;
    private Stack<E> stack2;
    /*栈，后入先出，用两个栈组成队列，
    * 那么stack1专门用来push，直到有
    * 出队请求时，一次push到stack2，
    * stack2就是按照出现顺序的，符合队
    * 列性质，直到stack2为空*/
    public Q2(){
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void add(E elem){
        stack1.push(elem);
    }

    public E poll() throws Exception {
        if(stack2.empty()){
            if(stack1.empty())
                throw new Exception("queue is empty!");
            while(!stack1.empty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
