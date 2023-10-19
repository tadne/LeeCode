package LeeCode;

import java.util.*;

public class code127_单词接龙 {
    public static void main(String[] args) {
        //字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
        //
        //每一对相邻的单词只差一个字母。
        // 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
        //sk == endWord
        //给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
        // 如果不存在这样的转换序列，返回 0 。
        //1 <= beginWord.length <= 10
        //endWord.length == beginWord.length
        //1 <= wordList.length <= 5000
        //wordList[i].length == beginWord.length
        //beginWord、endWord 和 wordList[i] 由小写英文字母组成
        //beginWord != endWord
        //wordList 中的所有字符串 互不相同
        String beginWord = "qa", endWord = "sq";
       List<String> wordList =Arrays.asList(
               "si","go","se","cm","so","ph","mt","db","mb","sb",
               "kr","ln","tm","le","av","sm","ar","ci","ca","br",
               "ti","ba","to","ra","fa","yo","ow","sn","ya","cr",
               "po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt",
               "lo","as","fr","nb","yb","if","pb","ge","th","pm",
               "rb","sh","co","ga","li","ha","hz","no","bi","di",
               "hi","qa","pi","os","uh","wm","an","me","mo","na",
               "la","st","er","sc","ne","mn","mi","am","ex","pt",
               "io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //定义一个Map来储存已经搜索的单词,并放置它所在长度
        Map<String,Integer> map=new HashMap<>();
        //创建一个队列,来做广度优先搜索
        Queue<String> queue=new ArrayDeque<>();
        Queue<String> queue1=new PriorityQueue<>();
        //放开始节点
        queue.add(beginWord);
        //给开始节点的步数设置为0
        map.put(beginWord,1);
        while (!queue.isEmpty()){//开始搜索
            String poll = queue.poll();
            for (String s : wordList) {
                if (!map.containsKey(s)&&getDiffOfStr(s, poll)) {//如果节点没有被搜索过,而且可以转换
                    if (s.equals(endWord)) return map.get(poll)+1;//找到目标
                    map.put(s, map.get(poll)+1);//设置值
                    queue.add(s);//准备继续向下搜索
                }
            }
        }
        return 0;
    }

    public static boolean getDiffOfStr(String s,String s1){
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=s1.charAt(i)) {
                count++;
                if (count==2) return false;
            }
        }
        return true;
    }

}
