package arrays.atmostOccurence;

public class SubarrayWithOddNum {
        static int  atMost(int []A, int goal) {
            int i = 0, j = 0, N = A.length, sum = 0, ans = 0;
            for (; j < N; ++j) {
                if(A[j]%2 != 0)
                    sum ++;
                while (i <= j && sum > goal) {
                    if(A[i]%2 != 0) {
                        sum--;

                    }
                    i++;

                }
                ans += j - i;
            }
            return ans;
        }
        public static int numSubarraysWithSum(int []A, int goal) {
            int a  = atMost(A, goal);
            int b = atMost(A, goal - 1);
            return  a-b;
        }
        public static void main(String[] args) {
            System.out.println(numSubarraysWithSum(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
        }

}
