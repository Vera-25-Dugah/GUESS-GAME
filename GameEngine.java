import java.util.Scanner;
public class GameEngine {

    private int minRange;
    private int maxRange;
    private int maxAttempts;
    private int secretNumber;
    private int attemptUsed;
    private int attemptsLeft;
    private int level;
    private boolean validChoice;
    private boolean validGuess;
    private String difficulty;
    private boolean won;

    Scanner input = new Scanner(System.in);

    DisplayManager display = new DisplayManager();

    //public GameEngine(){
    //        display = new DisplayManager();
    //
    //    }

    //START METHOD
    public void start(){
        display.showWelcomeAndRules();
        boolean playAgain = true;
        while(playAgain){
            difficultySelect();
            setUpGame();
            runGameLoop();
            playAgain = continueGame();
        }
        System.out.println("GOODBYE LOVE");
    }

    //SET UP GAME PARAMETERS
    public void setUpGame(){
        minRange = 0;
        maxRange = 0;
        maxAttempts = 0;
        difficulty = "";

        switch (level) {
            case 1:
                difficulty = "Easy";
                minRange = 1;
                maxRange = 10;
                maxAttempts = 6;
                break;
            case 2:
                difficulty = "Medium";
                minRange = 1;
                maxRange = 50;
                maxAttempts = 4;
                break;
            case 3:
                difficulty = "Hard";
                minRange = 1;
                maxRange = 100;
                maxAttempts = 3;
                break;
            default:
                System.out.println("Invalid Difficulty Selected");
        }
        display.showLevelConstraints(difficulty, minRange, maxRange, maxAttempts);
    }

    public void runGameLoop(){
        //STARTING GAME ENGINE
        attemptUsed = 0;
        won = false;

        //SECRET NUMBER GENERATION
        secretNumber = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;

        int guess = 0;
        while (true) {
            if (attemptUsed >= maxAttempts) {
                display.showGameOver(secretNumber);
                break;
            }

            guess = getValidGuess();
            attemptUsed++;

            //CHECK WIN || LOSE
            if (guess == secretNumber) {
                won = true;
                System.out.println("CONGRATULATIONS!!!...you guessed correctly WINNER");
                break;
            }

            if (guess > secretNumber) {
                System.out.println("TOO HIGH");
            } else {
                System.out.println("TOO LOW");
            }

            attemptsLeft = maxAttempts - attemptUsed;
            System.out.println("Attempts left: " + attemptsLeft);
        }

    }

    public boolean continueGame(){
        System.out.println("Would you like to play again? (yes/no):");
        String response = input.next().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

    //DIFFICULTY SELECTION AND VALIDATION METHOD
    public void difficultySelect(){
        validChoice = false;
        level = -1;

        while (!validChoice) {
           display.showSelectDifficulty();

            level = input.hasNextInt() ? input.nextInt() : -1;

            if (level < 1 || level > 3) {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                input.next(); //DISCARDS LEFTOVER INPUT FROM SCANNER
            }
            else {
                validChoice = true;
            }
        }
    }

    //GUESS INPUT AND VALIDATION
    public int getValidGuess(){
        validGuess = false;
        int guess = 0;
        while (!validGuess) {
            System.out.println(" Please enter your guess number");

            //VALIDATE GUESS AS A NUMBER

            if (!input.hasNextInt()) {
                System.out.println("Invalid input please enter a number");
                input.next(); //DISCARDS INPUT
                continue;

            }

            //VALIDATE GUESS AS IN RANGE
            guess = input.nextInt();

            if (guess < minRange || guess > maxRange) {
                System.out.println("Out of range. Please enter a number between " + minRange + "-" + maxRange);
                continue;

            }
            validGuess = true;

    }
        return guess;
    }

}


