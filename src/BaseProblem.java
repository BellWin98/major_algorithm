public class BaseProblem {
    public static void main(String[] args) {
        int n = 125;
        int answer = 0;
        String temp = "";
        while(n > 0){
            temp += Integer.toString(n % 3);
            n /= 3;
        }
        int len = temp.length() - 1;
        for (int i = 0; i < len; i++){
            answer += Integer.parseInt(String.valueOf(temp.charAt(i))) * (int) Math.pow(3, len);
            len--;
        }
        System.out.println(answer);
    }
}
