public class SmallestDistinctWindow {  
    
        public static int findSubString(String str) {
            int n = str.length();
    
    
            // Step 1: Count total number of distinct characters in the string
            boolean[] visited = new boolean[26];
            int distinct = 0;
    
            for (int i = 0; i < n; i++) {
                if (visited[str.charAt(i) - 'a'] == false) {
                    visited[str.charAt(i) - 'a'] = true;
                    distinct++;
                }
            }
    
    
            // Step 2. store the visited of characters
            // in the current window
            int[] cur = new int[26];
            int cnt = 0;
    
            int ans = n;
            int start = 0;
            for (int i = 0; i < n; i++) {
                cur[str.charAt(i) - 'a']++;
    
                if (cur[str.charAt(i) - 'a'] == 1) {
                    cnt++;
                }

                while (cnt == distinct) {                    
                    ans = Math.min(ans, i - start + 1);
                    cur[str.charAt(start) - 'a']--;
                    if (cur[str.charAt(start) - 'a'] == 0) {
                        cnt--;
                    }
                    start++;
                }
            }
            return ans;
        }
    
        public static void main(String[] args) {
            String str = "aabcbcdbca";
            System.out.print(findSubString(str));
        }
    }