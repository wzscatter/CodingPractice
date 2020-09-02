package LeetCode_Mid.BinarySearch;

public class M_6_ZIGZAGT {
    public String convert(String str, int n) {
        char[] c = str.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[n];
        for(int i = 0;i<sb.length;i++) {
            sb[i] = new StringBuffer();
        }
        int i = 0;
        while (i<len) {
            for(int j = 0;j<n&&i<len;j++) {
                sb[j].append(c[i++]);
            }
            for(int j=len-2;j>=1&&i<len;j--) {
                sb[j].append(c[i++]);
            }
        }
        for(int j =1;j<len;j++) {
            sb[0].append(sb[j]);
        }
        return sb[0].toString();

    }
}
