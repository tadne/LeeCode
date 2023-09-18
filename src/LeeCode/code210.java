package LeeCode;

import java.util.*;

public class code210 {
    public static void main(String[] args) {
        //现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
        // 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
        //
        //例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
        //返回你为了学完所有课程所安排的学习顺序。
        // 可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。

        int[][] arr= {{1, 0},{2, 0},{3, 1},{3, 2}};
                //     0                1233
                //   1   2              0012
                //     3
       // int[][] arr= {{1, 2},{2, 3},{3, 1}};
       // int[][] arr= {};
        int num=4;
//        System.out.println(Arrays.toString(findOrder(num, arr)));
    }






//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/course-schedule-ii/solutions/249149/ke-cheng-biao-ii-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //有向图的深度优先搜索
    // 存储有向图
    List<List<Integer>> edges;
    // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    int[] visited;
    // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
    int[] result;
    // 判断有向图中是否有环
    boolean valid = true;
    // 栈下标
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //存储有向图
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        // 每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        // 如果没有环，那么就有拓扑排序
        return result;
    }

    public void dfs(int u) {
        // 将节点标记为「搜索中」
        visited[u] = 1;
        // 搜索其相邻节点
        // 只要发现有环，立刻停止搜索
        for (int v: edges.get(u)) {
            // 如果「未搜索」那么搜索相邻节点
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) return;
            }
            // 如果「搜索中」说明找到了环
            else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        // 将节点标记为「已完成」
        visited[u] = 2;
        // 将节点入栈
        result[index--] = u;
    }




    //成功模拟了树结构的搜索,但是遇到环就会出错,且没有处理不可能完成课程的情况
    public static int[] findOrder1(int numCourses, int[][] prerequisites) {
        int[] firstGroup = findFirstGroup(numCourses, prerequisites);
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = map.get(prerequisites[i][1]);
            if (list==null){
                list=new ArrayList<>();
                list.add(prerequisites[i][0]);
            }else {
                list.add(prerequisites[i][0]);
            }
            map.put(prerequisites[i][1],list);
        }
        int[] res = findOrder(numCourses, prerequisites, firstGroup, map);
        int[] ans=new int[numCourses];
        System.arraycopy(res,0,ans,0,numCourses);
        return ans;
    }
    //根据树的第一层向下遍历
    public static int[] findOrder(int numCourses, int[][] prerequisites,int[] res,Map<Integer,List<Integer>> map){
        if (res[numCourses+1]==numCourses) return res;
        int end=res[numCourses+1];
        int start=res[numCourses];
        HashSet<Integer> set=new HashSet();
        for (int i = start; i < end; i++) {
            List<Integer> list = map.get(res[i]);
            for (int j = 0; j < list.size(); j++) {
                set.add(list.get(j));
            }
        }
        int idx=end;
        for (Integer o : set) {
            res[idx]=o;
            idx++;
        }
        res[numCourses]=end;
        res[numCourses+1]=idx;
        findOrder(numCourses,prerequisites,res,map);
        return res;
    }
    //获取树的第一层,作为根
    public static int[] findFirstGroup(int numCourses, int[][] prerequisites){
        Set<Integer> set=new HashSet<>();
        Set<Integer> set1=new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            set.add(prerequisite[0]);
            set1.add(prerequisite[1]);
        }
        set.forEach(s->{
            if (set1.contains(s)) set1.remove(s);
        });
        int[] res=new int[numCourses+2];
        Arrays.fill(res, -1);
        int idx=0;
        for (Integer integer : set1) {
            res[idx]=integer;
            idx++;
        }
        res[numCourses]=0;
        res[numCourses+1]=idx;
        return res;
    }


}
