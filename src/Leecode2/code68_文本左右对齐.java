package Leecode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class code68_文本左右对齐 {
    public static void main(String[] args) {
        //给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
        //
        //你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
        //
        //要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
        //
        //文本的最后一行应为左对齐，且单词之间不插入额外的空格。
        //
        //注意:
        //
        //单词是指由非空格字符组成的字符序列。
        //每个单词的长度大于 0，小于等于 maxWidth。
        //输入单词数组 words 至少包含一个单词。
        String [] arr={"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        List<String> list = fullJustify(arr, 20);
        List<String> list1 = List.of("Science  is  what we", "understand      well", "enough to explain to", "a  computer.  Art is", "everything  else  we", "do                  ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).equals(list1.get(i)));
        }
    }

    /**
     * 文本左右对齐
     * @param words 文本单词集
     * @param maxWidth 单行固定字符数量
     * @return 对齐后行集合
     */
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        List<String> rowList=new ArrayList<>();
        int rowLen=0;//单词间只有一个空格的行总长度
        for (int i = 0; i < words.length; i++) {
            //如果加上当前单词不会超过长度
            if (rowLen+words[i].length() <= maxWidth){
                rowList.add(words[i]);
                rowLen+=words[i].length()+1;
            }else {//当前行已经满了可以组装了

                i--;//重新回溯当前单词

                res.add(toRow(rowList, rowLen, maxWidth));

                rowLen=0;
                rowList.clear();
            }
            if (i==words.length-1){//最后一行左对齐
                StringBuilder row=new StringBuilder();
                for (int j = 0; j < rowList.size()-1; j++) {
                    row.append(rowList.get(j)).append(' ');
                }
                row.append(rowList.get(rowList.size()-1));
                addBlock(row,maxWidth-row.length());
                res.add(row.toString());
            }
        }
        return res;
    }

    /**
     * 将找好的当前行的单词组装为文本对齐的一行
     * @param rowList 当前行的单词集合
     * @param rowLen 每个单词中间只有一个空格的总长度
     * @param maxWidth 单行最大字符数
     * @return 对齐后的行
     */
    public static String toRow(List<String> rowList,int rowLen,int maxWidth){
        StringBuilder row=new StringBuilder(rowList.get(0));
        int size=rowList.size();
        if (size==1) {//如果当前行只有一个单词，左对齐
            return addBlock(row,maxWidth-rowList.get(0).length()).toString();
        }
        //平均每个单词之间至少要添加的空格
        int avg = (maxWidth-rowLen+1)/(rowList.size()-1)+1;
        //多出来的空格要从左到右分配
        int carry = (maxWidth-rowLen+1)%(rowList.size()-1);
        int i=1;
        while (i<size){
            if (carry-->0) row.append(' ');
            addBlock(row, avg);
            row.append(rowList.get(i++));
        }
        return row.toString();
    }

    /**
     * 在字符串右边添加空格
     * @param sb 被添加空格字符串
     * @param count 要添加的空格数量
     * @return 添加空格后的字符串
     */
    public static StringBuilder addBlock(StringBuilder sb,int count){
        while (count-->0){
            sb.append(" ");
        }
        return sb;
    }
}
