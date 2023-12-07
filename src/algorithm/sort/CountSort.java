package algorithm.sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 1, 9, 5, 8, 3, 6};
        System.out.println("原始数组: " + Arrays.toString(array));
        countingSort(array);
        System.out.println("排序后数组: " + Arrays.toString(array));
    }

    //计数排序
    //基本原理: 取出数组的最大值和最小值,然后创建一个长度为max-min的数组,遍历原数组,给数组中的元做标记,再重新遍历数组即可
    public static void countingSort(int[] array) {
        if (array == null || array.length == 0) return;
        // 找到数组中的最大值，确定计数数组的大小
        int max = Arrays.stream(array).max().getAsInt();
        // 创建计数数组，并初始化为0
        int[] countArray = new int[max + 1];
        // 统计每个元素的出现次数
        for (int num : array) {
            countArray[num]++;
        }
        // 根据计数数组重新排序原数组
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                array[index++] = i;
                countArray[i]--;
            }
        }
    }



}
