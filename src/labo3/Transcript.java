package labo3;

import java.util.ArrayList;

public class Transcript {

    public static String getReport(Grade[] grades) {
        ArrayList<Float> tab = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (Grade g : grades) {
            tab.add(g.getPercent());
            str.append(g.convertToString()).append("\n");
        }
        str.append("Mean = ").append(String.valueOf(average(tab))).append(" ");
        return str.toString();
    }

    public static String getReport(Grade[] grades, String department) {
        ArrayList<Float> tab = new ArrayList<>();

        StringBuilder str = new StringBuilder();

        for (Grade g : grades) {
            if (g.getDepartment() != department){
                continue;
            }
            tab.add(g.getPercent());
            str.append(g.convertToString()).append("\n");
        }

        str.append("Mean = ").append(String.valueOf(average(tab))).append(" ");
        return str.toString();
    }

    public static float average(ArrayList<Float> tab) {
        float sum = 0;
        for(float floatTab: tab) {
            sum += floatTab;
        }
        return sum / (tab.size());
    }

    public static void main(String[] args) {
        Grade g1 = new Grade("LOG", 100, 'A');
        Grade g2 = new Grade("GTI", 121, 68.5f);
        Grade g3 = new Grade("LOG", 121);
        Grade g4 = new Grade("LOG", 320, 'B');
        Grade g5 = new Grade("MAT", 144, 57f);
        Grade g6 = new Grade("MAT", 210, 'E');
        Grade g7 = new Grade("MAT", 350, 74.99f);

        Grade[] grades = {g1, g2, g3, g4, g5, g6, g7};

        System.out.println(getReport(grades));
        System.out.println(getReport(grades, "LOG"));
        System.out.println(getReport(grades, "MAT"));
        System.out.println(Grade.getInstanceCount());
    }
}
