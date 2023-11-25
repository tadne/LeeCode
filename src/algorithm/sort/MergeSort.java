package algorithm.sort;

public class MergeSort {
    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int[] tmpArr = new int[arr.length];
        mergeSort(arr, tmpArr, 0, arr.length - 1);
        return arr;
    }
    // mergeSort 递归方法
    private void mergeSort(int[] arr, int[] tmpArr, int l, int r) {
        if(l < r) {
            int mid = l + (r - l) / 2;
            //不停划分小区间
            mergeSort(arr, tmpArr, l, mid);
            mergeSort(arr, tmpArr, mid + 1, r);
            //所有小区间长度在2或3时开始合并所有小区间
            merge(arr, tmpArr, l, mid, r);
        }
    }

    // 自顶向下非原地合并方法
    // 其实就是合并两个有序数组
    private void merge(int[] arr, int[] tmpArr, int l, int mid, int r) {
        int lh = l, rh = mid + 1, h = l; // lh: 区间左半边左指针, rh: 区间右半边左指针, h: tmpArr 对应的区间的左指针
        //限制lh和rh只遍历左右半边
        while (lh <= mid && rh <= r) {
            tmpArr[h++] = arr[lh] <= arr[rh] ? arr[lh++] : arr[rh++];//小的放前面,大的放后面,并移动指针
        }
        while (lh <= mid) tmpArr[h++] = arr[lh++]; // 左半边还有剩余，加入 tmpArr 末尾
        while (rh <= r) tmpArr[h++] = arr[rh++]; // 右半边还有剩余，加入 tmpArr 末尾
        System.arraycopy(tmpArr,l,arr,l,r-l+1);// 将 tmpArr 拷回 arr 中
    }

    // 自顶向下原地归并（手摇算法）
    private void merge(int[] arr, int l, int c, int r) {
        int i = l, j = c + 1; // #1
        while(i < j && j <= r) {
            while(i < j && arr[i] <= arr[j]) i++; // #2
            int index = j; // #3
            while(j <= r && arr[j] < arr[i]) j++; // #4 注意是 arr[j] < arr[i]，即找到j使得arr[j] 为第一个大于等于 arr[i]值
            exchange(arr, i, index - 1, j - 1); // #5
        }
    }
    // 三次翻转实现交换
    private void exchange(int[] arr, int l, int c, int r) {
        reverse(arr, l, c);
        reverse(arr, c + 1, r);
        reverse(arr, l, r);
    }
    // 原地翻转
    private void reverse(int[] arr, int l, int r) {
        while(l < r) {
            swap(arr, l++, r--);
        }
    }

    //归并排序三,自动底向上非原地
    public int[] mergeSortBU(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length;
        int[] tmpArr = new int[n];
        for(int gap = 1; gap < n; gap *= 2) { // 基本分区合并(随着间隔的成倍增长，一一合并，二二合并，四四合并...)
            for(int l = 0; l < n - gap; l += 2 * gap) { // leftEnd = left+gap-1; rightEnd = left+2*gap-1;
                int r = Math.min(l + 2 * gap - 1, n - 1); // 防止最后一次合并越界
                merge(arr, tmpArr, l, l + gap - 1, r);
            }
        }
        return arr;
    }


    // 归并排序四：自底向上原地
    public int[] mergeSortBUInPlace(int[] arr) {
        if (arr.length < 2) return arr;
        int n = arr.length;
        for(int gap = 1; gap < n; gap *= 2) {
            for(int l = 0; l < n - gap; l += 2 * gap) { // 基本分区合并(随着间隔的成倍增长，一一合并，二二合并，四四合并...)
                int r = Math.min(l + 2 * gap - 1, n - 1); // leftEnd = left+gap-1; rightEnd = left+2*gap-1;
                merge(arr, l, l + gap - 1, r);
            }
        }
        return arr;
    }





    private void swap(int[] arr, int i, int j) {
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
