/*
 * Project 4 UMSL CMPSCI2261 7/18/2021
 * Author: Illia Arzamastsev
 * 
Princess Perly has been kidnapped by the magical Hydra! The kingdom is in chaos. Now only PyPy — the bravest Knight of the country — can save the day!

Hydra is a powerful magical creature with H heads and T tails. Hydra can breathe fire from each of its heads, and can shoot poison from each of its tails. The only way to kill Hydra is to cut off all H heads and all T tails. Please note that a Hydra with 0 heads and T > 0 tails is still alive — in which case it is called a ‘Headless Hydra’.

Knight PyPy is indeed brave, but the Knight is still a novice when it comes to fighting magical creatures. Knight PyPy only know 4 moves:

With the first move, Knight PyPy can cut off exactly one of Hydra’s heads.
With the second move, Knight PyPy can cut off exactly one of Hydra’s tails.
With the third move, Knight PyPy can cut off exactly two of Hydra’s heads.
With the fourth move, Knight PyPy can cut off exactly two of Hydra’s tails.
Please remember that even though Hydra is a magical creature, the number of its heads and tails can never be negative. Thus PyPy cannot use a move when there are not enough heads or tails; e.g. PyPy cannot use the first move on a Headless Hydra.

However, Hydra is not so easy to kill. Immediately after PyPy’s move,
If PyPy cuts off exactly one head, a new head grows immediately.
If PyPy cuts off exactly one tail, two new tails grow immediately.
If PyPy cuts off exactly two tails, a new head grows immediately.
If PyPy cuts off exactly two heads, nothing happens.
Note that if after PyPy’s move Hydra has 0 heads and 0 tails, new heads and tails can still grow, in which case the Hydra is still alive.
Knight PyPy wants to kill Hydra as soon as possible, so that he can save Princess Perly. What is the minimum number of moves that PyPy needs to use to kill Hydra?

Input
Prompt for how many heads and how many tails to start the Hydra.

Output
For each hydra, allow the user to select which of the 4 moves PyPy can do.  Keep track of the number of Hydra heads and tails and update the user after each attack.  Keep allowing the user to attack until the Hydra is dead, or the user gives up.  Allow for an option which will display S, where S is:

If it is impossible to kill Hydra, S=−1,
Otherwise, S is the minimum number of moves to kill Hydra.
Explanation of example

In this test case, Hydra has 3 heads and 3 tails initially. Following is a possible strategy for PyPy, with 9 moves:

Use the fourth move. Hydra now has 4 heads and 1 tail.
Use the third move. Hydra now has 2 heads and 1 tail.
Use the third move. Hydra now has 0 heads and 1 tail.
Use the second move. Hydra now has 0 heads and 2 tails.
Use the second move. Hydra now has 0 heads and 3 tails.
Use the second move. Hydra now has 0 heads and 4 tails.
Use the fourth move. Hydra now has 1 head and 2 tails.
Use the fourth move. Hydra now has 2 heads and 0 tails.
Use the third move. Hydra now has 0 heads and 0 tails. Because PyPy cuts of exactly 2 heads, no new head nor tail grow, and Hydra is dead.
Thus PyPy can kill Hydra with 9 moves. This is also the minimum number of moves for this test case.
*/
import java.util.*;

public class GameHydraPyPy {
	static int S;//moves
	static int head;//Hydra's head count
	static int tail;//Hydra's tail count
	
	public static void main(String agrs[]) {
        Scanner scanner =new Scanner(System.in);
        int move;//move option
        
        //print the rules of the game
        System.out.println("Game HydraPyPy");
        
        
        System.out.println("With the first move, Knight PyPy can cut off exactly one of Hydra’s heads.");
        System.out.println("With the second move, Knight PyPy can cut off exactly one of Hydra’s tails.");
        System.out.println("With the third move, Knight PyPy can cut off exactly two of Hydra’s heads.");
        System.out.println("With the fourth move, Knight PyPy can cut off exactly two of Hydra’s tails.");
        
        System.out.println("Please remember that even though Hydra is a magical creature, the number of its heads and tails can never be negative.");
        
        System.out.println("If PyPy cuts off exactly one head, a new head grows immediately.");
        System.out.println("If PyPy cuts off exactly one tail, two new tails grow immediately.");
        System.out.println("If PyPy cuts off exactly two tails, a new head grows immediately.");
        System.out.println("If PyPy cuts off exactly two heads, nothing happens.");
        
        System.out.println("How many heads of Hydra?");
        head = scanner.nextInt();//scan head number
        
        System.out.println("How many tails of Hydra?");
        tail = scanner.nextInt();//scan tail number
        
        
        while (head > 0 || tail > 0) {
        	System.out.println("Press 1, cut Hydra's one head");
        	System.out.println("Press 2, cut Hydra's one tail");
        	System.out.println("Press 3, cut Hydra's two heads");
        	System.out.println("Press 4, cut Hydra's tow tails");
        	System.out.println("Press 5, quit");
        	System.out.println("Select move choice: ");
        	
        	move = scanner.nextInt();//scan move choice
        	System.out.println("");
        	
        	if (move > 0 && move < 6) {
        		if (move == 5) {//quit
        			S = -1;
        			break;
        		} else if (move == 1) {//first move
        			if (head > 0) {
        				S++;//increment steps
        			} else {
        				System.out.println("Can not be done. No Hydra head left");
        			}
        			} else if (move == 2) {//second move
        				if (tail > 0) {
        					S++;
        					tail++;
        				} else {
            				System.out.println("Can not be done. No Hydra tail left");
        				}
        			} else if (move == 3) {//third move
        				if (head >= 2) {
        					S++;
        					head = head - 2;//cut two heads
        				} else {
            				System.out.println("Can not be done.");
        				}
        			} else {//fourth
        				if (tail > 1) {
        					S++;
        					tail = tail - 2;//cut two tails
        					head++;
        				} else {
        					System.out.println("Can not be done. No hydra head left");
        				}
        			} 
        		} else {
        			System.out.println("Invalid move.");
        		} 
        	System.out.println("Hydra Head: " + head + ", Tail: " + tail);
        }
        if (S == -1) {
        	System.out.println("It is impossible to kill Hydra.");
        } else {
        	System.out.println("Hydra killed in " + S + "moves");
        }
	}
}
