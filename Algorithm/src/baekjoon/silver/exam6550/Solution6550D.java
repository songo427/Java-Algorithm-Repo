    package baekjoon.silver.exam6550;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    /**
     * 6550. 부분 문자열
     * 이다은
     */
    public class Solution6550D {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                String s = st.nextToken();
                String t = st.nextToken();
                if (isSubstring(s, t)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

            }
        }

        static boolean isSubstring(String sub, String text) {
            int idx = 0;
            char[] textCharArray = text.toCharArray();
            for (char c : sub.toCharArray()) {
                while (true) {
                    if (idx == textCharArray.length) {
                        return false;
                    }
                    if (textCharArray[idx] == c) {
                        idx++;
                        break;
                    }

                    idx++;
                }
            }

            return true;
        }
    }
