package com.xiewendomg.admin.dataStructure.math;

import java.util.*;

/**
 * 希尔排序
 */
public class HeerSort {

    public  static void heerSort(int[]  array){
        int d=4;
        while (d>0){
            for (int i=0;i<array.length;i++){
                for (int j=i;j+d<array.length;j+=d){
                    if (array[j+d]<array[j]){
                        int tmp=array[j];
                        array[j]=array[j+d];
                        array[j+d]=tmp;
                    }
                }
            }
            d--;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
       int[] array={1,2,4,6,8,9,-1,0,-3,34,56,78,23,7};
        heerSort(array);
        List<String> strs = new ArrayList<String>(16);
        List<Integer> ints = new ArrayList<Integer>(16);
        List<Map<String, Object>> maps = new ArrayList(16);
        System.out.printf("%s,%s,%s,%s",
                strs.size(),
                strs.getClass() == ints.getClass(),
                Objects.equals(strs.getClass(), maps.getClass()),
                List.class.getSimpleName() == "List");

    }
}
class ThreadA extends Thread {

    ThreadLocal<Integer> something = new ThreadLocal();

    public void run() {
        something.set(10);
        System.out.println(something.get()+"1");

      /*  new Thread(() -> {
            System.out.println(something.get()+"2");
        }).run();

        new Thread(() -> {
            System.out.println(something.get()+"3");
        }).start();*/
    }

    public static void main(String... args) {



    }


        public boolean Find(int target, int [][] array) {
            for(int i=0;i<array.length;i++){
                for(int j=0;j<array.length;j++){
                    if(target==array[i][j]){
                        return true;
                    }
                }
            }
            return false;
        }
    public String replaceSpace(StringBuffer str) {
        if(str!=null){
        }
        return str.toString();
    }
}
