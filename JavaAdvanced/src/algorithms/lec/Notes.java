package algorithms.lec;

public class Notes {

    /**
     * рекурсия се ползва, когато имаме неизвестен брой повторения/цикли. МОже да се ползва и търсене в широчина.
     * За разлика от for цикъла, който се използва, когато имаме известен брой повторения.
     * Пример за ползване на рекурсия: jason file, обхождане на обект, в който има друг обект, в който има друг обект...
     * по някакви полета на обектите
     *
     * Рекурсията винаги първо дълбае до дъното на структурата и после започва да се връща нагоре.
     * топ ботом апроуч
     * боттом топ апроуч
     * събстринго апроуч - от средата започва
     *
     * дълбае, докато не срещне даденото условие и започва да се връща нагоре
     *
     */

    public static void main(String[] args) {

        for (int i = 0; i < 11; ++i) {
            System.out.print(i + " ");
        }

        //the same as with recursion method
        printNumbers(0);

        System.out.println("---------------------");

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sumArray(arr, 0));
    }

    public static void printNumbers(int i) { //началната стойност на i
        if (i >= 11) {  // условието за спиране на рекурсията
            return;
        }
        System.out.print(i + ", ");
        printNumbers(++i);// увелличението на i
        System.out.print(i + " "); //This row will be hit after the recursion is done and returns
    }

    public static int sumArray(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        return arr[index] + sumArray(arr, index + 1);
    }
}
