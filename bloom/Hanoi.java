/*
 * The Towers of Hanoi
There is an old legend about a monastery, which contains three poles. One of them filled with 64 gold disks. The disks are of different sizes, and they are put on top of each other, according to their size, i.e. each disk on the pole is a little smaller than the one beneath it. The monks have to move this stack from one of the three poles to another one. But one rule has to be applied: a large disk can never be placed on top of a smaller one. 

The rules of the game are very simple, but the solution is not so obvious. The game "Towers of Hanoi" uses three poles. A number of disks is stacked in decreasing order from the bottom to the top of one pole, i.e. the largest disk at the bottom and the smallest one on top. The disks build a conical tower. 

The aim of the game is to move the tower of disks from one pole to another pole. 

The following rules have to be obeyed:
Only one disk may be moved at a time.
Only the most upper disk from one of the pole can be moved in a single move
It can be put on another pole, if this rod is empty or if the most upper disk of this pole is larger than the one which is moved.
 */
package bloom;

/*
 * Intuition: First, we move the top n-1 disks from pole 1 to pole 2 using pole 3 as auxiliary. Then, we move the nth disk from pole 1 to pole 3. Finally, we move the n-1 disks from pole 2 to pole 3 using pole 1 as auxiliary. 
 */
public class Hanoi{
    public void hanoiFunction(int n, char from, char to, char aux){
        // here the above function will be recursively called
        // base case
        if(n == 1){
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        // let's call the hanoiFunction once again to move top n - 1 disks from pole 1 to pole 2 using 3 as auxiliary
        hanoiFunction(n - 1, from , aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        // move n - 1 disks from pole 2 to pole 3 using 1 as auxiliary
        hanoiFunction(n - 1, aux , to, from);
    }
    
    public static void main(String[] args){
        Hanoi hanoi = new Hanoi();
        int n = Integer.parseInt(args[0]);
        hanoi.hanoiFunction(n, '1', '2', '3');
    }
}
