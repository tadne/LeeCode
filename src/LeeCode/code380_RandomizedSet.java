package LeeCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class code380_RandomizedSet {
    public static void main(String[] args) {
        //实现RandomizedSet 类：
        //
        //RandomizedSet() 初始化 RandomizedSet 对象
        //bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
        //bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
        //int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
        //你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
        code380_RandomizedSet randomizedSet=new code380_RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
    //我觉得吧,这个题出的怪怪的,你说我要是自己用哈希表和链表实现set集合的话,也太麻烦了,不应该是middle难度
    //但是直接用现成的又有点不好意思
    private List<Integer> list=new ArrayList<>();
    public code380_RandomizedSet() {

    }
    public boolean insert(int val) {
        if (!list.contains(val)) {
            list.add(val);
            return true;
        }else return false;
    }

    public boolean remove(int val) {
        if (list.contains(val)){
            list.remove((Integer) val);
            return true;
        }else return false;
    }


    public int getRandom() {
        Random r=new Random();
        int i = r.nextInt(list.size());
        return list.get(i);
    }
}


