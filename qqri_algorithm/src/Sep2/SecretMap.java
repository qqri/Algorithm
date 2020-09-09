package Sep2;

public class SecretMap {
    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        for(String str : solution(5 , arr1 , arr2)) {
            System.out.println(str);
        }
    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        //1
        String[] answer = new String[n];
        String[] biArr1 = new String[n];
        String[] biArr2 = new String[n];

        for(int i = 0 ; i < n ; i++ ) {
            biArr1[i] = Integer.toBinaryString(arr1[i]);
            biArr2[i] = Integer.toBinaryString(arr2[i]);
            while (biArr1[i].length() < n) {
                biArr1[i] =  "0"+biArr1[i];
            }
            while (biArr2[i].length() < n) {
                biArr2[i] =  "0"+biArr2[i];
            }
        }

        for(int i=0 ; i < n; i++) {
            StringBuilder sb = new StringBuilder("");
            String str1 = biArr1[i];
            String str2 = biArr2[i];
            System.out.println("str1 : " + str1);
            System.out.println("str2 : " + str2);
            for(int j=0 ; j < n ; j++) {
                if(str1.charAt(j) == '1' || str2.charAt(j) == '1') {
                    sb.append("#");
                }
                else sb.append(" ");
            }
            answer[i] = new String(sb);
        }



        return answer;
    }
}
