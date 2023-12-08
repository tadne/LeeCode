package LeeCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class code284_窥视迭代器 {
    public static void main(String[] args) {
        //请你在设计一个迭代器，在集成现有迭代器拥有的 hasNext 和 next 操作的基础上，还额外支持 peek 操作。
        //
        //实现 PeekingIterator 类：
        //
        //PeekingIterator(Iterator<int> nums) 使用指定整数迭代器 nums 初始化迭代器。
        //int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
        //bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
        //int peek() 返回数组中的下一个元素，但 不 移动指针。
    }
   private static class PeekingIterator implements Iterator<Integer> {
        public static List<Integer> iterators;
        private static int idx;
        public PeekingIterator(Iterator<Integer> iterator) {
            iterators=new ArrayList<>();
            iterators.add(null);
            idx=0;
            while (iterator.hasNext()){
                iterators.add(iterator.next());
            }
        }
        public Integer peek() {
            return iterators.get(idx+1);
        }
        @Override
        public Integer next() {
            return iterators.get(++idx);
        }
        @Override
        public boolean hasNext() {
            return idx<iterators.size()-1;
        }
    }
}
