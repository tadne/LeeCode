package Leecode2;

import java.util.*;

public class code380_O1时间插入删除获取随机元素 {

}
class RandomizedSet {

    private List<Integer> list;
    private Map<Integer,Integer>  map;
    private Random r;
    public RandomizedSet() {
        list=new ArrayList<>();
        map=new HashMap<>();
        r=new Random();
    }
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    //因为用了List集合，所以要维护集合的长度，避免集合中间出现空值
    //这里是使用list集合的最后一个元素来覆盖被删除元素，再删除最后一个元素
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Integer idx = map.get(val);
        Integer last = list.get(list.size() - 1);
        list.set(idx,last);
        list.remove(list.size()-1);
        map.put(last,idx);
        map.remove(val);
        return true;
    }
    public int getRandom() {
        int i = r.nextInt(list.size());
        return list.get(i);
    }
}
