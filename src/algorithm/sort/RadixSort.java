package algorithm.sort;

import java.util.Arrays;

public class RadixSort {
    //基于计数排序的基数排序
    public int[] radixSort(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length;

        // 找到 arr 中绝对值最大值
        int max = Math.abs(arr[0]);
        for (int i = 1; i < n; i++) {
            max = Math.max(max, Math.abs(arr[i]));
        }

        // 求最大数的位数
        int width = 0, base = 10;
        while (max != 0) {
            width++;
            max /= base;
        }

        //创建排序数组,开始排序
        int[] sortedArr = new int[n];
        for (int i = 0; i < width; i++) { // 每一轮都对当前位(基数)执行一次计数排序
            int[] countArr = new int[19]; // 为应对有负数的情况，countArr范围为[-9, 9]

            //统计桶（对应于当前位上的一个数字）中元素的个数。
            for (int num : arr) { // 根据每一个数字当前位的数字，累计计数
                int bucketIdx = (num % base) / (base / 10) + 9; // 求当前位上的数字 (+9处理负数)
                countArr[bucketIdx]++;
            }

            // 变形
            for (int j = 1; j < countArr.length; j++) { //变形主要是为了让 在后续遍历中 让 当前元素 在 排序后数组 中的位置可以在 桶 中找到
                countArr[j] += countArr[j - 1];
            }

            //从输入数组 arr 的末尾开始,根据当前位上的数字找到对应的桶, 然后将该元素放到该桶在排序后数组中的正确位置
            for (int j = n - 1; j >= 0; j--) { // 逆序输出保持稳定性
                // arr[j] 元素当前位对应 countArr 中的下标
                int countIdx = (arr[j] % base) / (base / 10) + 9;
                // 在排序后数组中的下标
                int sortedIdx = countArr[countIdx] - 1;
                sortedArr[sortedIdx] = arr[j]; // 在排序后数组中填入值
                countArr[countIdx]--; // 更新桶的计数值，确保下一个相同数字放入桶时位置正确
            }
            arr = Arrays.copyOf(sortedArr, n); // 完成当前位的计数排序后将排序结果拷贝回原数组
            base *= 10; // base进一位，准备下一轮对高一位的计数排序
        }
        return arr;
    }
}
