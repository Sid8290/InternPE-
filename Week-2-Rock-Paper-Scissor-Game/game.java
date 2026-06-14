import java.util.Random;
import java.util.Scanner;

public class game {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};

        System.out.println("==============================");
        System.out.println("   ROCK PAPER SCISSORS GAME   ");
        System.out.println("==============================");

        while(true){
            System.out.println("\nchoose:");
            System.out.println("1. Rock:");
            System.out.println("2. Paper:");
            System.out.println("3. Scissor:");
            System.out.println("4. Exit:");

            int userChoice = sc.nextInt();

            if(userChoice == 4){
                System.out.println("Thanks for playing!");
                break;
            }
            if(userChoice < 1 || userChoice > 3){
                System.out.println("Invalid choice! Try again.");
                continue;
            }
            int computerChoice = random.nextInt(3) + 1;

            System.out.println("\n Your choice:" + choices[userChoice - 1]);
            System.out.println("Computer Choice:" + choices[computerChoice - 1]);

            if(userChoice == computerChoice){
                System.out.println("Result: It's a Draw");
            }
            else if((userChoice == 1 && computerChoice == 3)|| 
                    (userChoice == 2 && computerChoice == 1)||
                    (userChoice == 3 && computerChoice == 2)){
                        System.out.println("Result: You Win!");
                    }
            else{
                System.out.println("Result: Computer wins!");
            }
        }
        sc.close();
    }
}
