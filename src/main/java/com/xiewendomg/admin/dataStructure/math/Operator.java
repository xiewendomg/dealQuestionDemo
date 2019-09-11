package com.xiewendomg.admin.dataStructure.math;

/**
 * java 运算符
 */
public class Operator {
    public static void main(String[] args) {
        result();
    }

    /**
     * >> 除以  / ,<<,>>>
     */
    private static void result(){
        int a=-12;
        /**
         * -12 的二进制为：1111  1111  1111  1111  1111  1111  1111  0100；
         *
         * -12 >> 3 即带符号右移3位，结果是：1111  1111  1111  1111  1111  1111  1111  1110，十进制为： -2；
         *
         * -12 >>> 3 就是右移三位，前面补零，为：0001  1111  1111  1111  1111  1111  1111  1110，十进制为：536870910。
         */
        System.out.println("a>>1="+String.valueOf(a>>2)); //  >> 表示除以2，取商
        System.out.println("a<<1="+String.valueOf(a<<2)); // << 表示乘以2
        System.out.println("a>>>1="+String.valueOf(a>>>-2)); //
    }
}
