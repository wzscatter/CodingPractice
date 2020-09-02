package LeetCode_Mid.BinarySearch;

public class E_3676 {
    public boolean isPerfectSquare(int num) {
        int bean = 10;
        while (bean*bean<num) {
            bean = bean*10;
        }
        int left = 0;
        int right = bean;
        int mid ;
        while (left<=right) {
            mid = (left+right)/2;
            if(num>mid*mid) {
                left = mid+1;
            }
            else if(num<mid*mid) {
                right = mid -1;
            }
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        E_3676 test = new E_3676();
        System.out.println(test.isPerfectSquare(35));
    }
}
