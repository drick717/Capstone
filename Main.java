import java.lang.Math;
import java.util.*;
import java.lang.reflect.Array;



public class Main
{
  static int numPlayers, player =
    1, a, i, j, k, score, total, ones, twos, threes, fours, fives, sixes;
  static int[] Dice = { 0, 0, 0, 0, 0, 0, 0, 0};
  static int savedDice[] = { 0, 0, 0, 0, 0, 0};
  static int savedDiceTemp[] = { 0, 0, 0, 0, 0, 0};
  static int playerScore[] = {0, 0};
  static int keptDice;
  static int numRolls;
  static boolean farkle = true;
  static char reroll;
  static ArrayList<String> names = new ArrayList<String>();
  static String name;
  public static void Scoring()
  {
    // resetting number counters to 0
    score = 0;
    ones = 0;
    twos = 0;
    threes = 0;
    fours = 0;
    fives = 0;
    sixes = 0;
    // Counting the number of each dice in a roll
    for (int z = 0; z < 6; z++)
      {
	if (Dice[z] == 1)
	  {
	    ones++;
	  }
	if (Dice[z] == 2)
	  {
	    twos++;
	  }
	if (Dice[z] == 3)
	  {
	    threes++;
	  }
	if (Dice[z] == 4)
	  {
	    fours++;
	  }
	if (Dice[z] == 5)
	  {
	    fives++;
	  }
	if (Dice[z] == 6)
	  {
	    sixes++;
	  }
      }
    //Scoring 1's
    if (ones == 3)
      {
	score = score + 1000;
      }
    if (ones < 3)
      {
	score = score + ones * 100;
      }
    if (ones > 3 && ones < 6)
      {
	score = score + ((ones - 3) * 100) + 1000;
      }
    if (ones == 6)
      {
	score = score + 2000;
      }

    // Scoring 2's
    if (twos == 3)
      {
	score = score + 200;
      }
    if (twos == 6)
      {
	score = score + 400;
      }

    // Scoring 3's
    if (threes == 3)
      {
	score = score + 300;
      }
    if (threes == 6)
      {
	score = score + 600;
      }

    // Scoring 4's
    if (fours == 3)
      {
	score = score + 400;
      }
    if (fours == 6)
      {
	score = score + 800;
      }

    //Scoring 5's
    if (fives == 3)
      {
	score = score + 500;
      }
    if (fives < 3)
      {
	score = score + fives * 50;
      }
    if (fives > 3 && fives < 6)
      {
	score = score + ((fives - 3) * 50) + 500;
      }
    if (fives == 6)
      {
	score = score + 1000;
      }

    // Scoring 6's
    if (sixes == 3)
      {
	score = score + 600;
      }
    if (sixes == 6)
      {
	score = score + 1200;
      }
    System.out.println ();
    System.out.print (score);
  }

  // Dice rolling function   
  public static void DiceRoll ()
  {
    int min = 1;
    int max = 6;

    for (j = 0; j < 6; j++)
      {
	int b = (int) (Math.random () * (max - min + 1) + min);
	Dice[j] = b;
	System.out.print (Dice[j] + "   ");
      }
  }

  public static void Farkle ()
  {
    // sorting dice to make checking for 3 of a kind easier 
    Collections.reverse(Arrays.asList(Dice));
    
    if ((Dice[0] == Dice[1] && Dice[1] == Dice[2]) ||
	(Dice[1] == Dice[2] && Dice[2] == Dice[3]) ||
	(Dice[2] == Dice[3] && Dice[3] == Dice[4]) ||
	(Dice[3] == Dice[4] && Dice[4] == Dice[5]) &&
	Dice[0] != 0 && Dice[1] != 0 && Dice[2] != 0 &&
	Dice[3] != 0 && Dice[4] != 0 && Dice[5] != 0 &&
	Dice[0] != 1 && Dice[1] != 1 && Dice[2] != 1 &&
	Dice[3] != 1 && Dice[4] != 1 && Dice[5] != 1 &&
	Dice[0] != 5 && Dice[1] != 5 && Dice[2] != 5 &&
	Dice[3] != 5 && Dice[4] != 5 && Dice[5] != 5)
      {

	farkle = false;
      }

    for (j = 0; j <= 5; j++)
      {
	if (Dice[j] == 1 || Dice[j] == 5)
	  {
	    farkle = false;

	  }
      }
   
  }

  public static void main (String[]args)
  {
    
   
   
   
   
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the number of players: (min. 2)  ");  
    int numPlayers = in.nextInt(); 
    
    while (numPlayers < 2){
            
        System.out.println("Enter the number of players: (min. 2)  ");  
        numPlayers = in.nextInt();  
            
    }
    
 
  
  
    
    for (int p = 1; p < numPlayers + 1; ++p){
        System.out.println("What is player " + p + "'s name? ");  
        name = in.next();
        names.add(name);  
    }
    
    
    do {
        // FIXME: insert player names from player class instead of from names arrayList
        for (int y = 0; y < numPlayers; y++) {
            // should pull name from player class but can't pull correctly from the array within the class
            System.out.println(names.get(y) + "'s turn.");
            
            a = 0;
            // calling function to roll dice
            DiceRoll();
            
            // variable a is a counter that once reached ends a players turn
            while (a < 2) {
                System.out.println();;
                // FIXME: not working for rerolls-- check for farkle before continuing
                Farkle();

                if (farkle == false) {
                    
                    // asking the player if they want to roll to better their score
                    
                    System.out.print("Would you like to roll again? ");
                    reroll = in.next().charAt(0);
                    
                    if (reroll == 'y' || reroll == 'Y') {
                        // sorting dice to make checking for 3 of a kind easier 
                        Arrays.sort(Dice);
                        
                        
                        
                        // loop to check for 1's and 5's and store them in a separate array
                        for (int r = 0; r < 6; r++) {
                            if (Dice[r] == 1 || Dice[r] == 5) {
                                savedDice[r] = Dice[r];
                            }
                            // checking for 3 of a kind's to store
                            else if (Dice[r] == Dice[r + 1] && Dice[r + 1] == Dice[r + 2]) {
                                savedDice[r] = Dice[r];
                                savedDice[r + 1] = Dice[r+1];
                                savedDice[r + 2] = Dice[r+2];
                            }
                            // non-scoring dice are converted to 0's to prevent them affecting subsequent rolls
                            else if (savedDice[r] == 0); 
                            // main Dice array is set equal to the savedDice to reroll with the same rolling function 
                            Dice[r] = savedDice[r];
                            savedDiceTemp[r] = savedDice[r];
                        }
                        System.out.print("Saved dice: ");
                        for (int s = 0; s < 6; s++){
                            System.out.print(savedDice[s] + "   ");
                            
                        }
                        System.out.println();
                        // calling the rolling and farle check functions to reroll
                        DiceRoll();
                        Farkle();
                        // increasing the turn counter
                        a++;

                    }
                    // ending turn if the players elects not to reroll
                    else if (reroll == 'n' || reroll == 'N') {
                        a = 2;

                    }
                    
                }
                // ending turn upon farkle
                if (farkle == true){
                    System.out.println("Farkle. Your turn is over");
                    a = 2;

                }
            }
            

    
    
    
    Scoring ();
    // updating the players score in an array
           
           
           //FIXME: dice not saved or scored correctly
           playerScore[y] = playerScore[y] + score;
            // resets for both dice arrays to make all entries 0 so that they will be rolled
           
           for (int m = 0; m < 6; m++){
           
                Array.set(Dice, m, 0);
                Array.set(savedDice, m, 0);
           }
            
            // displaying player's score at end of turn 
            total = playerScore[y];
            System.out.println("Score: " + playerScore[y]);
            
        }
    } while (total < 10000);  //FIXME: need extra turn after win-con hit
  }
}
