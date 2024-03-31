package algorithm.string;

public class KMP {
    public static void main(String[] args) {
        //KMP字符串匹配算法
        //  在匹配字符串时，如果出现字符不匹配，首先匹配串检查之前已经匹配成功的部分中里是否存在相同的「前缀」和「后缀」
        //      如果存在，则跳转到「前缀」的下一个位置继续往下匹配：
        //
        //实现： 扫描完整原串这一操作不可避免，我们可以优化的只能是「检查已匹配部分的相同前缀和后缀」这一过程。
        //  对于匹配串的任意一个位置而言，该位置发起的下一个匹配点位置其实与原串无关：例如： abcabd 的d字符而言，它的下一个匹配点时c，因为它们的前缀都是ab

        //  next 数组：
        //      k=0:    next[k]=-1  当k为0时
        //      k>0:    next[k]=最长公共元素长度, 比如 aba的前缀有 a,ab. 后缀有 ba,a. 那公共元素就是a
        //
    }

    /**
     * 采用KMP算法，查找字符串子串的位置
     *
     * @param source 源字符串
     * @param target 目标(子)字符串
     * @return 目标字符串在源字符串中第一次出现的索引位置
     */
    public int indexOfToKMP(String source, String target) {
        int i, j;
        // 调用接口中的方法，获取next数组
        int[] next = getNext(target);
        // 初始化遍历
        i = 0;j = 0;
        // 判断i和j的索引都不能大于等于字符串长度，否则说明比较完成
        while (i < source.length() && j < target.length()) {
            // 如果j==-1 或者 公共元素相等，继续比较
            if (j == -1 || source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                //按照数组回溯j
                j = next[j];
            }
        }
        // 判断子字符的索引是否大于等于子字符串，如果为true说明查找成功，返回源字符串当前位置-子字符串长度
        return j >= target.length() ? i - target.length() : -1;
    }

    public int[] getNext(String target) {
        // 初始化数组大小
        int[] next = new int[target.length()];
        // 0 位置默认为-1
        next[0] = -1;
        // 遍历字符串每一位，计算每个位置上的值
        for (int i = 0, k = -1; i < target.length() - 1; ) {
            //如果前后缀一致或者k回到最初位置
            if (k == -1 || target.charAt(i) == target.charAt(k)) {
                i++;k++;
                // 判断当前字符 和 k位置的字符是否相等
                if (target.charAt(i) == target.charAt(k)) {
                    // 若相等，则继承k位置的值
                    next[i] = next[k];
                } else {
                    // 不等，则还是使用原来next数组的值
                    next[i] = k;
                }
            } else {//否则回溯，
                k = next[k];
            }
        }
        return next;
    }
}
