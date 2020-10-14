import java.util.*;
public class Main {
    static List<int[]> opLists = new ArrayList<>();
    static List<Integer> opList = new ArrayList<>();
    static int[] op = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int n;


    static void permutation(int[] list, int n , int r, int depth) {
        if(depth == r) {
            int[] clone = new int[n];
            for(int i = 0 ; i < n ; i++ ) {
                clone[i] = list[i];
            }
            opLists.add(clone);
            return;
        }

        for(int i = depth ; i < n ; i++){
            swap(list, depth , i);
            permutation(list,  n, r , depth + 1);
            swap(list, depth , i);
        }
    }

    static void swap(int[] list ,int i , int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
        return;
    }

    static void calculate(List<int[]> opLists, int[] nums ) {
        int size = opLists.size();
        int sum;
        int[] curArr;
        for (int j = 0; j < size; j++) {
            curArr = opLists.get(j);

            sum = nums[0];
            for (int i = 0; i < curArr.length; i++) {
                switch (curArr[i]) {
                    case 0:
                        sum += nums[i + 1];
                        break;
                    case 1:
                        sum -= nums[i + 1];
                        break;
                    case 2:
                        sum *= nums[i + 1];
                        break;
                    case 3:
                        sum /= nums[i + 1];
                        break;
                }
            }
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n 개수
        n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0 ; i < n ; i++ ) {
            nums[i] = sc.nextInt();
        }

        // + - * %  각각 갯수 n-1씩
        int opSum=0;
        for(int i =0 ; i < 4 ; i++ ) {
            op[i] = sc.nextInt();
        }
        for(int i = 0 ; i < 4 ; i++ ) {
            int currOp = op[i];
            for(int j=0; j <currOp ; j++ ) {
                opList.add(i); // 0 1 2 3 넣음
            }
        }
        int[] list = new int[opList.size()];
        for(int i = 0; i < opList.size() ; i++ ) {
            list[i] = opList.get(i);
        }

        permutation(list, n-1 , n-1, 0);
        calculate(opLists, nums );
        System.out.println(max);
        System.out.println(min);

    }


}