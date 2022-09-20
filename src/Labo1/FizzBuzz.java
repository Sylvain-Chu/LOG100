package Labo1;

public class FizzBuzz {

    public static final void main(String[] args) {
        String input = args[0];
        int nbr = Integer.parseInt(input);

        String str = "";

        for (int i = 1; i <= nbr; i++){

            if(i != 1){
                str += ",";
            }

            if(i % 3 == 0 && i % 5 == 0) {
                str += "FizzBuzz";
            }
            else if(i % 5 == 0) {
                str += "Buzz";
            }
            else if(i % 3 == 0) {
                str += "Fizz";
            }
            else {
                str += i;
            }

        }
        System.out.println(str);
    }
}