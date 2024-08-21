import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(bf.readLine());
        for(int tc = 0; tc < t; tc++) {
            String str = bf.readLine();
            int k = Integer.parseInt(bf.readLine()); 
            //입력 끝
 
            if(k == 1) { //k가 1일때
                sb.append("1 1").append("\n");
                continue;
            }
 
            int[] alpha = new int[26];//알파벳 별 개수를 저장한다. 
            for(int j = 0; j < str.length(); j++) {
                alpha[str.charAt(j) - 'a']++;
            }
 
            int min = Integer.MAX_VALUE;
            int max = -1;
            for(int j = 0; j < str.length(); j++) {
                if(alpha[str.charAt(j) - 'a'] < k) continue;
 
                int count = 1;
                for(int l = j + 1; l < str.length(); l++) {
                    if(str.charAt(j) == str.charAt(l)) count++;
                    if(count == k) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if(min == Integer.MAX_VALUE || max == -1) sb.append("-1").append("\n");
            else sb.append(min + " " + max+"\n");
        }
        System.out.print(sb);
	}
}