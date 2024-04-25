package Leecode2;

import java.util.*;

public class code146_LRU缓存 {
    public static void main(String[] args) {
        //请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
        //实现 LRUCache 类：
        //LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
        //int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
        //void put(int key, int value)
        //      如果关键字 key 已经存在，则变更其数据值 value ；
        //      如果不存在，则向缓存中插入该组 key-value 。
        //      如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
        //函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
    }
    private static class LRUCache {
        static class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            public DLinkedNode() {}
            public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
        }
        private final Map<Integer, DLinkedNode> cache = new HashMap<>();
        //容量和当前容量
        private int curSize;
        private final int capacity;
        //头尾节点
        private final DLinkedNode head;
        private final DLinkedNode tail;

        public LRUCache(int capacity) {
            this.curSize = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;//后地址值
            tail.prev = head;//前地址值
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            // 不存在返回-1
            if (node == null) return -1;
            // 存在，通过哈希表定位移到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                //key 不存在，创建新节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 加入哈希表
                cache.put(key, newNode);
                // 加入双向链表
                addToHead(newNode);
                //调整当前容量
                curSize++;
                if (curSize > capacity) {
                    // 超出容量，删除链表的尾节点
                    DLinkedNode tail = removeTail();
                    // 删除哈希表中尾节点数据
                    cache.remove(tail.key);
                    curSize--;
                }
            } else {
                // key 存在，先通过哈希表定位修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }

        //将节点放到头部,头部就是head的后一个
        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }
        //删除节点
        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        //将节点移到头部
        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }
        //删除尾部元素
        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }
}
