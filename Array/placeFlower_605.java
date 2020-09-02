package LeetCode_Mid.Array;

public class placeFlower_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean pre = false;
        int count = 0;
        for (int i = 0; i < flowerbed.length;  i++) {

            if((flowerbed[i]==0)&&(i==0||flowerbed[i-1]==0)&&(i==flowerbed.length-1||flowerbed[i+1]==0)) {
                count+=1;
                i+=1;
            }

        }
        return count>=n;
    }

    public static void main(String[] args) {
        placeFlower_605 a = new placeFlower_605();
        int[] array = {1,0,0,0,1};
        int[] array1 = {0,0,1,0,1,0,0,0,1,0,0,1,0,0};
        System.out.println(a.canPlaceFlowers(array1,3));
    }
}
