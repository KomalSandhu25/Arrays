package arrays.binarySearch;

import java.util.Random;

/*
You are a product manager and currently leading a team to develop a new product. Since each version is developed based on the previous version, all the versions after a bad version are also bad. Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad. You are given an API bool isBadVersion(version) which will return whether version is bad.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.

 */
public class BadVersion {
    public static Boolean isBadVersion(int v){
        Random random = new Random();
        if(random.ints(0, 1).findFirst().getAsInt() > 0)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) % 2;
            if (isBadVersion(mid)) {
                right = mid;
            }
            else{
                    left = mid + 1;

                }
            }
        return left;
        }
    }
