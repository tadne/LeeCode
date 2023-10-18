package WrittenExamination.得物;

public class code1 {
    public static void main(String[] args) {
        String s="111111111";
        System.out.println(getMaxLine(s));
        //给一个01字符串，要求找到不含“110”的最长子串的长度
    }
    public static int getMaxLine(String s){
        int n=s.length();
        if (n<3) return n;
        int max=0;
        int l=0,r=2;
        int start=0,end=n-1;
        while (r<n){
            if (s.substring(l,r+1).equals("110")){
                max=Math.max(max,l+2-start);
                start=l+1;
            }
            l++;r++;
        }
        return max==0?n:max;
    }
}
