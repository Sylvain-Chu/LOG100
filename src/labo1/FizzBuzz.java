package labo1;

public class FizzBuzz {

    public static void main(String[] args) {
        String input = args[0];
        int nbr = Integer.parseInt(input);

        StringBuilder str = new StringBuilder();

        for (int i = 1; i <= nbr; i++){

            if(i != 1){
                str.append(",");
            }

            if(i % 3 == 0 && i % 5 == 0) {
                str.append("FizzBuzz");
            }
            else if(i % 5 == 0) {
                str.append("Buzz");
            }
            else if(i % 3 == 0) {
                str.append("Fizz");
            }
            else {
                str.append(i);
            }

        }
        System.out.println(str);
    }
}