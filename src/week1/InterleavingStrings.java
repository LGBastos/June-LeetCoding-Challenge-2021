package week1;

public class InterleavingStrings {
    public static void main(String[] args) {
        String s1 = "wwaaww", s2 = "wwq", s3 = "wwaawwq";
        System.out.println((isInterleave(s1, s2, s3) || isInterleave(s2, s1, s3)));
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        boolean dp[] = new boolean[s2.length() + 1];
        if(s3.length()!=(s1.length()+s2.length())) return false;
        for(int i = 0 ; i<s1.length()){
            for (int j = 0; j < s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j]=true;
                }else if(i==0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }

            }
        }
        return dp[s2.length()];
    }

    public static boolean check(String s1, String s2, String s3) {
        boolean b;
        if(s3.charAt(0)==s2.charAt(0)){
            s3=s3.substring(1);

            s2=s2.substring(1);
            System.out.println(s2);
           b =  isInterleave(s1,s2,s3);
        }else if(s3.charAt(0)==s1.charAt(0)){
            s3=s3.substring(1);
            s1=s1.substring(1);
            b = isInterleave(s1,s2,s3);
        }else{
            return false;
        }
        return b;
    }
}
