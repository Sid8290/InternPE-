import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[]args) {
        Random random = new Random();
        Scanner sc = new Scanner (System.in);
        
        int number = random.nextInt(100)+1;
        int guess;
        int attempts = 0;
        
        System.out.println("Guess a number between 1 and 100");
        
        do{
            guess = sc.nextInt();
            attempts++;
            
            if(guess<number) {
                System.out.println("Too Low!");
            }
            else if (guess>number) {
                System.out.println("Too High!");
            }
            else {
                System.out.println("Congratulations!");
                System.out.println("Attempts : "+ attempts);
            }
        } while(guess!=number);
        sc.close();
    }
}
