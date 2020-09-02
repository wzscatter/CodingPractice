package LeetCode_Mid.DFS;

public class vipM_1109_FlightBooking {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for(int i = 0;i< bookings.length;i++) {
            for(int j = bookings[i][0]-1;j<=bookings[i][1]-1;j++) {
                result[j]+=bookings[i][2];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] test = {{1,2,10},{2,3,20},{2,5,25}};
        vipM_1109_FlightBooking tst = new vipM_1109_FlightBooking();
        int[] ans = tst.corpFlightBookings(test,5);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
