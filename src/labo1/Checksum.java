package labo1;

public class Checksum {

    public static void main(String[] args) {
        int somme = 0;
        String input = args[0];
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            int nbr = Character.getNumericValue(ch);
            int y = i+1;

            somme += nbr * y;
        }
        System.out.println(somme % 10);
    }
}
