package LeeCode;

import java.util.*;


public class code433_最小基因变化 {
    public static void main(String[] args) {
        //基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
        //
        //要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
        //例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
        //另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
        //
        //给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
        //
        //注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
        //start.length == 8
        //end.length == 8
        //0 <= bank.length <= 10
        //bank[i].length == 8
        //start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
       String start = "AACCGGTT", end = "AAACGGTA";String[] bank = {"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"};
        System.out.println(minMutation(start, end, bank));
    }
    public static int minMutation(String start, String end, String[] bank) {
        char[] keys = {'A', 'C', 'G', 'T'};
        Set<String> cnt = new HashSet<>(Arrays.asList(bank));//基因库

        Set<String> visited = new HashSet<>();//给节点加状态,表示已经正在搜索的节点

        if (start.equals(end)) return 0;//一开始就一样
        if (!cnt.contains(end)) return -1;//基因库中没有目标基因

        Queue<String> queue = new ArrayDeque<>();//队列
        queue.offer(start);
        visited.add(start);//进入状态
        int step = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {//遍历队列
                String curr = queue.poll();//弹出当前基因
                for (int j = 0; j < 8; j++) {//遍历当前基因
                    for (int k = 0; k < 4; k++) {//遍历基因种类
                        if (keys[k] != curr.charAt(j)) {//如果种类不匹配
                            StringBuffer sb = new StringBuffer(curr);//就对当前基因片段进行操作
                            sb.setCharAt(j, keys[k]);//将当前基因与遍历的基因匹配
                            String next = sb.toString();//将修改后的基因取出
                            if (!visited.contains(next) && cnt.contains(next)) {//如果基因库中存在修改后的基因,并且这个基因没有被标记状态
                                if (next.equals(end)) return step;//如果达到目标就返回
                                queue.offer(next);//添加该基因
                                visited.add(next);//标记状态
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }


    //以start节点为根节点
    //这个树的节点的子节点都是变动一次就可以到达的节点
    //并且这个树没有重复节点
    Map<String,Integer> map = new HashMap<>();//用map集合构建树
    Deque<String> deque = new ArrayDeque<>();//队列实现优先广度搜索
    public int minMutation1(String startGene, String endGene, String[] bank) {
        map.put(startGene,0);//放入根节点
        deque.offer(startGene);//从根节点开始搜索
        while (!deque.isEmpty()) {
            String poll = deque.poll();
            for (String s : bank) {
                if (getDifferent(poll,s) == 1 && !map.containsKey(s)) {//如果找到下一个节点并且这个节点没有被遍历过
                    if (s.equals(endGene)) return map.get(poll) + 1;//如果找到目标
                    deque.add(s);//继续向下搜索
                    map.put(s,map.get(poll) + 1);//标记当前节点
                }
            }
        }
        return -1;
    }
    //找到两个字符串有几个不同的字符,如果是1说明可以直接基因变换
    public static int getDifferent(String s,String s1){
        int count = 0;
        for (int j = 0; j < 8; j++) {
            if (s.charAt(j) != s1.charAt(j)) count++;
        }
        return count;
    }
}
