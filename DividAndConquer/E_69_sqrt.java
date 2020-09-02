package LeetCode_Mid.DividAndConquer;

public class E_69_sqrt {
    public int mySqrt(int x) {
        if(x<4) return x==0?0:1;
        int left = 2,right = x/2;
        int mid = (left+right)/2;
        while (left<=right) {
            mid = (left+right)/2;
            if(mid*mid==x||(mid*mid<x&&(mid+1)*(mid+1)>x)) {
                return mid;
            }
            else if(mid*mid>x) {
                right = mid-1;
            }
            else if(mid*mid<x&&(mid+1)*(mid+1)<x) {
                left = mid+1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        E_69_sqrt test = new E_69_sqrt();
        System.out.println(test.mySqrt(10000));
    }
}
