/* DEAD AND WOUNDED
A number game. The computer creates a random 4 digit number.
 */
package deadandwounded;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Adesuwa
 */
public class DeadandWounded {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /*Create variables*/
        int numwounded = 0;
        int numdead = 0;
        int compNumber[] = new int[4];
        int randomNumber;
        
        /*Generate the random 4 digit number*/
        for (int i = 0; i < compNumber.length; i++) {
            randomNumber = (int)(Math.random() * 10); //Generate random number
            System.out.println("i: " + i );
            System.out.println("Random number: " + randomNumber + ".  Array = " + Arrays.toString(compNumber));
            compNumber[i] = randomNumber;
            for (int j = 0; j < i; j++) {
                if (randomNumber == compNumber[j]) { //Check that number is not already in array.
                    i--;
                    System.out.println("Random number " + randomNumber + " already exists as item " + j + " in the array.");
                    break;
                }
                else {
                    compNumber[i] = randomNumber;
                    System.out.println("Therefore, compNumber[" + i + "] = " + randomNumber);
                }
            }
        }
        System.out.println("Final array: " + Arrays.toString(compNumber));
        
        //Get user input
        System.out.print("Guess my four digit number!: ");
        Scanner userinput = new Scanner(System.in);
        int guess = userinput.nextInt();
        
        System.out.println(guess);
        
        //Time to start comparing the user's guess
        
        for (int k = 0; k < compNumber.length; k ++) { //k is counter for input
            
        }
    }
    
}
