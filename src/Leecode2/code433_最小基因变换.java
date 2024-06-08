package Leecode2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class code433_最小基因变换 {
    public static void main(String[] args) {
        //基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
        //
        //我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化:表示基因序列中的一个字符发生了变化。
        //
        //例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
        //另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
        //
        //给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
        //
        //注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
    }
    //采用广度优先搜索，每到一个节点都遍历bank数组找寻满足一次基因变化的节点并标记
    //实现：用map集合标记节点并记录基因变化的次数，用队列实现向下一层搜索

    Map<String,Integer> map=new HashMap<>();
    Deque<String> deque = new ArrayDeque<>();//队列实现广度优先搜索
    public int minMutation(String startGene, String endGene, String[] bank) {
        map.put(startGene,0);
        deque.offer(startGene);
        while (!deque.isEmpty()){
            String pop = deque.poll();
            for (String s : bank) {
                if (getDifOfGenes(s,pop)&&!map.containsKey(s)){
                    if (s.equals(endGene)) return map.get(pop) + 1;//如果找到目标
                    deque.add(s);//继续向下搜索
                    map.put(s,map.get(pop) + 1);//标记当前节点
                }
            }
        }
        return -1;
    }

    public boolean getDifOfGenes(String startGene, String endGene){
        int count = 0;
        for (int i = 0; i < 8 ; i++) {
            if (startGene.charAt(i)!=endGene.charAt(i)) count++;
        }
        return count==1;
    }
}
