import java.util.Random;
import java.util.Scanner;

public class DecodeLabs_Java_P1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int score = 0;             
        char playAgain;              

        do {   
            
            int target = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;    
            boolean isCorrect = false;

            System.out.println("\nNew Round Begins! Choose a number between 1-100(10 attempts only).");

            while (!isCorrect && attempts < maxAttempts) {
                System.out.print("Guess: ");
                
                try {
                    int guess = scanner.nextInt();
                    attempts++;   
                    if (guess == target) {
                        System.out.println("Correct! " + " You guessed the number in "+ attempts + " attempts.");
                        score += (maxAttempts - attempts + 1);  
                        isCorrect = true;
                    } else if (guess > target) {
                        System.out.println("Too High!");
                    } else {
                        System.out.println("Too Low!");
                    }
                } catch (Exception e) {
                    System.out.println("Write number only!");
                    scanner.nextLine();
                }
            }

            if (!isCorrect) {
                System.out.println("Number was right! " + target);
            }

            System.out.println("Current Score: " + score);
            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');  

        System.out.println("Final Score: " + score + " — Thanks for playing bud!");
        scanner.close();
    }
}