import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class code56 {
    public static void main(String[] args) {
        //以数组 intervals 表示若干个区间的集合，
        // 其中单个区间为 intervals[i] = [starti, endi] 。
        // 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。


       // int[][] ints={{0,2},{1,2}};
        //int[][] ints={{1,4},{0,4}};
       // int[][] ints={{1,3},{2,6},{8,10},{15,18}};//[[1,3],[2,6],[8,10],[15,18]]
        int[][] ints={{2,3},{4,5},{6,7},{1,10}};//[[2,3],[4,5],[6,7],[8,9],[1,10]]
        System.out.println(Arrays.deepToString(merge(ints)));
    }
    public int[][] merge1(int[][] intervals) {
        if (intervals.length == 0) {//排0
            return new int[0][2];
        }
        Arrays.sort(intervals, (interval1, interval2)-> interval1[0] - interval2[0]);//排序
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> tempList=new ArrayList<>();
        Arrays.stream(intervals).sorted((o1, o2)-> o1[0]-o2[0]).forEach(tempList::add);//排序换集合
        List<int[]> list=new ArrayList<>();
        boolean vis=false;
        for (int i = 0; i < tempList.size(); i++) {
            if (i==tempList.size()-1&&vis)break;
            if (i==tempList.size()-1&&!vis) {
                list.add(tempList.get(i));
                break;
            }
            int[] ints;
            //本次融合
            if ((tempList.get(i)[1]>=tempList.get(i+1)[0]          //左区间的右边大于右区间的左边
                    &&tempList.get(i)[0]<=tempList.get(i+1)[1])    //左区间的左边小于右区间的右边
                    ){
                ints= new int[]{Math.min(tempList.get(i)[0],tempList.get(i+1)[0]),Math.max(tempList.get(i)[1],tempList.get(i+1)[1])};
                tempList.set(i+1,ints);
                if (vis)list.remove(list.size()-1);
                list.add(ints);
                vis=true;
            }else if (vis){//上次融合,这次不能融合
                vis=false;
            }else {//上次没融合,这次也不能融合
                list.add(tempList.get(i));
                vis=false;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
