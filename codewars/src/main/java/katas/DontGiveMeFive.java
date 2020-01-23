package katas;

/**
 * In this kata you get the start number and the end number of a region and should return the count of all numbers
 * except numbers with a 5 in it. The start and the end number are both inclusive!
 *
 * Examples:
 *
 * 1,9 -> 1,2,3,4,6,7,8,9 -> Result 8
 * 4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17 -> Result 12
 * The result may contain fives. ;-)
 * The start number will always be smaller than the end number. Both numbers can be also negative!
 *
 * I'm very curious for your solutions and the way you solve it. Maybe someone of you will find an easy pure mathematics solution.
 *
 * Have fun coding it and please don't forget to vote and rank this kata! :-)
 *
 * I have also created other katas. Take a look if you enjoyed this kata!
 */
public class DontGiveMeFive {
    public static void main(String[] args) {
        System.out.println(dontGiveMeFive(1,9));
        System.out.println(dontGiveMeFive(-5,17));
        System.out.println(dontGiveMeFive(4,17));
        System.out.println(dontGiveMeFive(-4, 18));
    }

    public static int dontGiveMeFive(int start, int end)
    {
        int dif = Math.abs(end - start) + 1;
        System.out.println("dif: " + dif);
        System.out.println("dif / 5: " + dif / 5);
        System.out.println("start / 5: " + Math.abs(start / 5));
        return dif - ((dif / 5) - Math.abs(start / 5));
    }
}
