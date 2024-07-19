
/*

    Mitchell Kolb HW6 



 * This is my player class that will store these values
 * 
 * During play
 *      player score 
 *      number of hits in total
 * 
 * 
 * At the end screen
 *      player score
 *      amount of times each type of ball is hit in the game
 */


 public class Player {

    int score;
    int totalHits;
    int hitsBasic;
    int hitsShrink;
    int hitsBounce;
    int hitsSplit;

    // Constructor to set default values to zero
    public Player() {
        score = 0;
        totalHits = 0;
        hitsBasic = 0;
        hitsShrink = 0;
        hitsBounce = 0;
        hitsSplit = 0;
    }
    //I could make this all private then use getters and setters but since I will only ever have 1 instance of this in use. THis works well enough





 }
