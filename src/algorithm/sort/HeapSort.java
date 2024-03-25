package algorithm.sort;

public class HeapSort {
    public static void main(String[] args) {

    }
    public void sort(int arr[]) {
        int n = arr.length;

        // 构建最大堆（从最后一个非叶子节点开始）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 依次从堆中取出元素，并重新构建最大堆
        for (int i = n - 1; i > 0; i--) {
            // 将当前堆顶元素（最大值）与末尾元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 重新构建最大堆
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i; // 初始化最大值为根节点
        int left = 2 * i + 1; // 左子节点索引
        int right = 2 * i + 2; // 右子节点索引

        // 如果左子节点比根节点大，则更新最大值索引
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点比根节点大，则更新最大值索引
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值不是根节点，则交换它们，并递归地调整堆
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

}
