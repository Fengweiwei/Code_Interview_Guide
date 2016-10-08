package io.fww.ch1;

import java.util.LinkedList;

/**
 * Created by fengweiwei on 10/7/16.
 */
public class Q7 {
    /*生成窗口最大值*/
    /*有一个大小为w的窗口从一个整型数组的最左边滑到最右边，窗口每次向右边滑动一个位置*/
    public int [] getMaxWindow(int [] arr, int w){
        if(arr.length<w){
            int max = Integer.MIN_VALUE;
            for (int i : arr) {
                max = max>i?max:i;
            }
            return new int []{max};
        }
        LinkedList<Integer> q = new LinkedList<>();//用双端队列，保存可能是最大值的数
        //最大值在队首
        int [] ret = new int[arr.length-w+1];

        for(int i=0; i<arr.length; i++){
        }

        return ret;
    }
}
