package Test18;

public class Q3 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String s = "My-Name-Is-Ewha";

        sb.append(s.charAt(0));
        for(int i = 1 ; i < s.length()-1 ; i++ ) {
            if(s.charAt(i) == '-') {
                sb.append(s.charAt(i+1));
            }
        }

        System.out.println(sb.toString());
    }
}
