/* DEAD AND WOUNDED
A number game. The computer creates a random 4 digit number.
TODO: Add check to make sure user doesn't repeat numbers
      Check that user doesn't exceed four numbers (optional)
      Check that user doesn't enter in any non-numeric chaaracters*/
package deadandwounded;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class DeadandWounded {
    static int wounded = 0; //number wounded
    static int dead = 0; //number dead
    static int compNumber[] = new int[4]; //Computer's 4-digit randomly generated number
    static String guess; 
    
    public void createRandomNumber () { 
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
                    break;  }
                else {
                    compNumber[i] = randomNumber;
                    System.out.println("Therefore, compNumber[" + i + "] = " + randomNumber);   }   
            }
        }
    }       
    public static void main(String[] args) {
        System.out.println("Final array: " + Arrays.toString(compNumber));        

    }
    public static void compareUserGuess() {          //Time to start comparing the user's guess
                //Get user input
        System.out.print("Guess my four digit number!: ");
        Scanner userinput = new Scanner(System.in);
        guess = userinput.next() ;
        
        System.out.println(guess); 
        
        for (int k = 0; k < compNumber.length; k++) { //k is counter for user input
            Character fig = guess.charAt(k);
            String figure = fig.toString();
            
            System.out.println(fig);
            int digit = Integer.parseInt(figure);
            if ( digit == compNumber[k]) { //Does k in user input match k number in pcnum array?
                System.out.println("+1 dead! : " + digit);
                dead+=1;            
            }
            else {
                for (int m = 0; m < compNumber.length; m++) {
                    if (digit == compNumber[m]) {
                        System.out.println("Wounded at number " + m + " position. " + compNumber[m]);
                        wounded+=1;
                        break;  
                    }
                }
            }
        }
        System.out.println(wounded + " wounded, " + dead + " dead.");
    }
    
}
