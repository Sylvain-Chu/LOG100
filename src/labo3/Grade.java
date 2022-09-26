package labo3;

public class Grade {

    private String department;
    private int courseNum;
    private float percent = 0f;
    private char letter = 'E';
    private static int counter;

    public String getDepartment() {
        return department;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public float getPercent() {
        return percent;
    }

    public char getLetter() {
        return letter;
    }

    public Grade() {
    }

    public Grade(String department, int courseNum) {
        this.department = department;
        this.courseNum = courseNum;
        counter++;

    }

    public Grade(String department, int courseNum, float percent) {
        this.department = department;
        this.courseNum = courseNum;
        this.percent = percent;
        this.letter = this.getLetterByPercent(percent);
        counter++;

    }

    public Grade(String department, int courseNum, char letter) {
        this.department = department;
        this.courseNum = courseNum;
        this.letter = letter;
        this.percent = this.getPercentByLetter(letter);
        counter++;

    }

    private char getLetterByPercent(float percent) {
        if (percent <= 100 && percent >= 75) {
            return 'A';
        } else if (percent < 75 && percent >= 66) {
            return 'B';
        } else if (percent < 66 && percent >= 57) {
            return 'C';
        } else if (percent < 57 && percent >= 50) {
            return 'D';
        } else {
            return 'E';
        }
    }

    private float getPercentByLetter(char letter) {
        float percent = 0f;
        switch (letter) {
            case 'A':
                percent = 87.5f;
                break;
            case 'B':
                percent = 70.5f;
                break;
            case 'C':
                percent = 61.5f;
                break;
            case 'D':
                percent = 53.5f;
                break;
            case 'E':
                percent = 25f;
                break;
        }
        return percent;
    }

    public static int getInstanceCount(){
        return counter;
    }

    public String convertToString() {
        return this.getDepartment() + this.getCourseNum() +
                " " + this.getLetter() +
                " " + this.getPercent();
    }

    public static void main(String[] args) {
        Grade g1 = new Grade("LOG", 100, 'A');
        Grade g2 = new Grade("GTI", 121, 68.5f);
        Grade g3 = new Grade("LOG", 121);
        Grade g4 = new Grade("LOG", 320, 'B');
        Grade g5 = new Grade("MAT", 144, 57f);
        Grade g6 = new Grade("MAT", 210, 'E');
        Grade g7 = new Grade("MAT", 350, 74.99f);

        System.out.println(g1.convertToString());
        System.out.println(g2.convertToString());
        System.out.println(g3.convertToString());
        System.out.println(g4.convertToString());
        System.out.println(g5.convertToString());
        System.out.println(g6.convertToString());
        System.out.println(g7.convertToString());
    }

}
