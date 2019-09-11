package com.xiewendomg.admin.java.LeetCode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 将所有元素做异或运算，即a[1] ⊕  a[2] ⊕  a[3] ⊕ …⊕  a[n]，所得的结果就是那个只出现一次的数字，时间复杂度为O(n)。
 * <p>
 * ^是异或运算符，异或的规则是转换成二进制比较，相同为0，不同为1.
 * 一个数a与另一个数b异或的结果等于a^b，用结果（ a^b)异或a，就会得到b；
 */
public class FindOddNumber {

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int c = 2;
        int d = a ^ b;
        System.out.println(a ^ c);
        System.out.println(d ^ c);
        System.out.println(findOddNumber(new int[]{2,2,1,1,0}));
    }

    public static int findOddNumber(int[] array) {
        int result = 0;
        for (int number : array) {
            result = number ^ result;
        }
        return result;
    }


}
