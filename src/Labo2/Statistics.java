package Labo2;

public class Statistics {

    public static int elemCount(float[] tab) {
        return tab.length;
    }

    public static float average(float[] tab) {
        float sum = 0;
        for(float floatTab: tab) {
            sum += floatTab;
        }
        return sum / (tab.length);
    }

    public static float max(float[] tab) {
        float max = tab[0];
        for(float floatTab: tab) {
            if(floatTab > max) {
                max = floatTab;
            }
        }
        return max;
    }

    public static float min(float[] tab) {
        float min = tab[0];
        for(float floatTab: tab) {
            if(floatTab < min) {
                min = floatTab;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        float[] tab = new float[args.length-1];
        int choice = 0;

        for(int i = 0; i < args.length; i++) {
            if(i == 0) {
                choice = Integer.parseInt(args[i]);
            }
            else {
                tab[i-1] = Float.parseFloat(args[i]);
            }
        }

        switch(choice) {
            case 1:
                System.out.println(elemCount(tab));
                break;
            case 2:
                System.out.println(average(tab));
                break;
            case 3:
                System.out.println(max(tab) + ", " + min(tab));
                break;
            default:
                System.out.println("Invalid operation " + choice);
                break;
        }
    }
}