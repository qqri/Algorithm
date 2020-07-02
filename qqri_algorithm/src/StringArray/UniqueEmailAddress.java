package StringArray;
import java.io.IOException;
import java.util.*;

public class UniqueEmailAddress {
    public static void main(String[] args) throws NumberFormatException, IOException {
        UniqueEmailAddress u = new UniqueEmailAddress();

        String[] emails = {"test.email+james@coding.com", "test.e.mail+toto.jane@coding.com", "testemail+tom@cod.ing.com"};

        Set<String> set = new HashSet<>(); //중복이면 안되는 거니까 set으로 받는다.

        for(String email : emails) {
            String localName = u.makeLocalName(email);
            String domainName = u.makeDomainName(email);
            email = localName + "@" + domainName;
            set.add(email);
        }

        System.out.println(set.size());

       // 2번방법
       // System.out.println(u.solve1(input));

    }
    public String makeDomainName(String email){
        return email.substring( email.indexOf('@') ); //@ 이후의 문자들만 저장됨.
    }

    public String makeLocalName(String email) {
        //. 이면 안넘기고 , + 혹은 @ 이전까지만 받는다.
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < email.length() ; i++ ){
            if(email.charAt(i) == '.') continue;
            if(email.charAt(i) == '+' || email.charAt(i) == '@') break;

            //sb.append(String.valueOf(email.charAt(i)));
            sb.append(email.charAt(i));
        }
        return sb.toString();
    }
    public int solve1(String[] input){

        List<String> emails = new ArrayList<>();
        String current = "";

        for(int i = 0 ; i < input.length ; i++) {
            current = input[i];
            int start =0;
            int end =0;

            for(int j=0 ; j < current.length() ; j++) {
                char ch = current.charAt(j);

                if( ch == '@') {
                    end = j;
                    break;
                } else if(ch != '+') {
                    continue;
                } else if(ch == '+') start = j;


            }

            current =current.substring(0,start).replace(".","") + current.substring(end,current.length());

            if(!emails.contains(current)) emails.add(current);

        }

        return emails.size();
    }
}



