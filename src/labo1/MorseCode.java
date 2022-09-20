package labo1;

public class MorseCode {

    public static void main(String[] args) {
        String input = args[0];
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);

            switch (ch) {
                case 'E' -> str.append(". ");
                case 'O' -> str.append("- - - ");
                case 'S' -> str.append(". . . ");
                case 'T' -> str.append("- ");
                case 'W' -> str.append(". - - ");
                default -> str.append("?");
            }
        }

        System.out.println(str);
    }
}
