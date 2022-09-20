package Labo2;

public class ArrayToolbox {

    /**
     * Sum one arrays containing digits.
     * In the arrays, each element is a single digit.
     * The rightmost digit is the unit one.
     * @param tab array
     * @return The sum of the numbers
     */
    private static int oneTabSum(int[] tab){
        int val = 0;
        int j = 0;
        for(int i = tab.length-1; i >= 0; i--) {
            val += Math.pow(10, i) * tab[j];
            j++;
        }
        return val;
    }

    /**
     * Sum two arrays containing digits.
     * In the arrays, each element is a single digit.
     * The rightmost digit is the unit one.
     * @param tab1 First array
     * @param tab2 Second array
     * @return The sum of the two numbers
     */
    public static int sum(int[] tab1, int[] tab2) {
        int val1 = oneTabSum(tab1);
        int val2 = oneTabSum(tab2);
        return val1 + val2;
    }

    public static void main(String[] args) {
        int [] tab1 = { 3, 2, 8 };
        int [] tab2 = { 4, 7, 1};
        int res1 = sum(tab1, tab2);
        System.out.println(res1);

        int [] tab3 = { 2, 4};
        int [] tab4 = { 5, 2, 9};
        int res2 = sum(tab3, tab4);
        System.out.println(res2);

        int [] tab5 = { 1, 5, 0};
        int [] tab6 = { 3, 4};
        int res3 = sum(tab5, tab6);
        System.out.print(res3);
    }
}
