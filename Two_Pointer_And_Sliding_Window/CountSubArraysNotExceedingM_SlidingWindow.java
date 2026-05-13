public class CountSubArraysNotExceedingM_SlidingWindow {
    
        /**
         * Counts the number of subarrays of size k with a sum not exceeding m.
         *
         * @param arr The input array.
         * @param k   The size of the subarrays.
         * @param m   The maximum allowed sum for a subarray.
         * @return The number of subarrays that meet the criteria.
         */
        public int countSubarrays(int[] arr, int k, int m) {
            int count = 0;
            int windowSum = 0;
            int windowStart = 0;
    
            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                windowSum += arr[windowEnd];
    
                if (windowEnd - windowStart + 1 == k) {
                    if (windowSum <= m) {
                        count++;
                    }
                    windowSum -= arr[windowStart];
                    windowStart++;
                }
            }
            return count;
        }
    }