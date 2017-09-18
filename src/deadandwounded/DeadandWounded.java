/* DEAD AND WOUNDED
A number game. The computer creates a random 4 digit number.
TODO: Generate 4 digit random number -- DONE!
      Add check to check user's guess for dead and wounded soldiers -- DONE!
      Add check to make sure user doesn't repeat numbers
      Check that user doesn't exceed four numbers (optional)
      Check that user doesn't enter in any non-numeric chaaracters*/
package deadandwounded;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class DeadandWounded {
    static int wounded = 0; //number wounded. Static because number wounded doesn't change throughout the game
    static int dead = 0; //number dead. Static because of the same reason.
    static int compNumber[] = new int[4]; //Computer's 4-digit randomly generated number
    static String guess; //Static. Every time the guess is changed, we want all the one guess variable in the game to be changed.
    static int keepGuessing = 1; //1 = Yes, keep guessing. 0 = No
    
    public static void createRandomNumber () { 
        int randomNumber;
        for (int i = 0; i < compNumber.length; i++) {/*Generate the random 4 digit number*/
            randomNumber = (int)(Math.random() * 10); //Generate random number
            System.out.print("Random number: " + randomNumber + ".  Array = " + Arrays.toString(compNumber) + "     ");
            compNumber[i] = randomNumber;
            for (int j = 0; j < i; j++) {
                if (randomNumber == compNumber[j]) {    i--;   break;  } //Check that number is not already in array.
                
                else {  compNumber[i] = randomNumber;   }   
            }
        }
        System.out.println("Final array: " + Arrays.toString(compNumber));      
    }       
    public static void getUserInput() {         //Get user input
        System.out.print("Guess my four digit number!: ");
        Scanner userinput = new Scanner(System.in);
        guess = userinput.next();
        keepGuessing = 0;
        
        for (int i =0; i < compNumber.length; i++) {//Check to make sure user hasn't repeated any digits. Start from i = 0. Nest for-loop
            Character fig = guess.charAt(i);
            String figure = fig.toString();
            int digit = Integer.parseInt(figure);
            
            for (int j = 0; j < compNumber.length; j++) { //check all numbers and make sure nothing is repeated. Nested for-loop. 
                if (j == i) { /*j++;*/}
                
                else {
                    fig = guess.charAt(j);
                    figure = fig.toString();
                    int digit2 = Integer.parseInt(figure);
                    
                    if (digit == digit2) {
                        System.out.println("You've repeated a digit," + digit);
                        keepGuessing = 1;
                        i = compNumber.length;
                        break;     }
                }
            }
        }
    System.out.println("END"); }
    public static void compareUserGuess() {     //Time to start comparing the user's guess        
        keepGuessing = 1;
        wounded = 0;
        dead = 0;
        for (int k = 0; k < compNumber.length; k++) { //k is counter for user input
            Character fig = guess.charAt(k);
            String figure = fig.toString();

            int digit = Integer.parseInt(figure);
            if ( digit == compNumber[k]) { //Does k in user input match k number in pcnum array?
                System.out.println("+1 dead! : " + digit);
                dead+=1;    }
            else {
                for (int m = 0; m < compNumber.length; m++) {
                    if (digit == compNumber[m]) {
                        wounded+=1;
                        break;  }
                }
            }
        }
        System.out.println(wounded + " wounded, " + dead + " dead.");
        if (dead == 4) {    System.out.println("You won!"); keepGuessing = 0; }
    }
      public static void main(String[] args) {
        createRandomNumber(); 
        System.out.println(keepGuessing); 
        while (keepGuessing == 1) { 
            getUserInput(); 
            if (keepGuessing == 0) {compareUserGuess();}
        }
    }  
}
