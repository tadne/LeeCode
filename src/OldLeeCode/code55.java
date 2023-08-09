package OldLeeCode;

public class code55 {
    public static void main(String[] args) {
        //给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
        //
        //数组中的每个元素代表你在该位置可以跳跃的最大长度。
        //
        //判断你是否能够到达最后一个下标。
    }

    public boolean canJump(int[] nums) {
        int len=nums.length;
        int index=0;
        for (int i = 0; i < len; i++) {
            index= Math.max(nums[i], index);//后面的值与(前面的值减去它的位置偏移)比较
            index--;//减去位置偏移
            if (index==-1&&i!=len-1) return false;//如果当前位置是0且前面的值减去位置偏移到这个位置是0
        }
        return true;
    }
}

