

/******************************************************************************
 *  Compilation:  javac BallGame.java
 *  Execution:    java BallGame n
 *  Dependencies: BasicBall.java StdDraw.java
 *
 *  Creates a BasicBall and animates it
 *
 *  Part of the animation code is adapted from Computer Science:   An Interdisciplinary Approach Book
 *  
 *  Run the skeleton code with arguments : 1  basic  0.08
 *******************************************************************************/

 //Mitchell Kolb
 // CptS355 HW6

 
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
//import java.util.Arrays;




public class BallGame { 

    public static void main(String[] args) {
  
    	// number of bouncing balls
    	int numBalls = Integer.parseInt(args[0]);

        ////
        //System.out.println(args[0] + args[1] + args[2]);
        //ArrayList<String> testArray = new ArrayList<>(Arrays.asList("john", "chris", "bob", "jow"));
        //System.out.println(testArray.get(1) + testArray.size());
        ////

 

    	//ball types
    	String ballTypes[] = new String[numBalls];
    	//sizes of balls
    	double ballSizes[] = new double[numBalls];
    	
    	//retrieve ball types
    	int index =1;
    	for (int i=0; i<numBalls; i++) {
    		ballTypes[i] = args[index];
            ///System.out.println(ballTypes[i]);
    		index = index+2;
    	}
    	//retrieve ball sizes
    	index = 2;
    	for (int i=0; i<numBalls; i++) {
    		ballSizes[i] = Double.parseDouble(args[index]);
            //System.out.println(ballSizes[i]);
    		index = index+2;
    	}
        
        //This shows me how I can get the ball details 
        //System.out.println(ballTypes[1] + ballSizes[1]);
    	
        //TO DO: create a Player object and initialize the player game stats.  
    	//System.out.println("here");
        Player myPlayer = new Player();
        //myPlayer.score = 1;
        
    	
    	//number of active balls
    	int numBallsinGame = 0;
        StdDraw.enableDoubleBuffering();

        StdDraw.setCanvasSize(800, 800);
        // set boundary to box with coordinates between -1 and +1
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        // create colored balls 
        //TO DO: Create "numBalls" balls (of types given in "ballTypes" with sizes given in "ballSizes") and store them in an Arraylist
   		ArrayList<BasicBall> ballList = new ArrayList<>();
        for (int i = 0; i < numBalls; i++)
        {
            if (ballTypes[i].equals("basic"))
            {
                BasicBall ball = new BasicBall(ballSizes[i], Color.RED);
                ballList.add(ball);
            }
            else if (ballTypes[i].equals("shrink"))
            {
                ShrinkBall ball = new ShrinkBall(ballSizes[i], Color.ORANGE);
                ballList.add(ball);
            }
            else if (ballTypes[i].equals("bounce"))
            {
                BounceBall ball = new BounceBall(ballSizes[i], Color.GREEN);
                ballList.add(ball);
            }
            else if (ballTypes[i].equals("split"))
            {
                SplitBall ball = new SplitBall(ballSizes[i], Color.BLUE);
                ballList.add(ball);
            }
            else
            {
                System.out.println("Something went wrong in creating balls");
                BasicBall ball = new BasicBall(ballSizes[i], Color.RED);
                ballList.add(ball);
            }

   		    //TO DO: initialize the numBallsinGame
            numBallsinGame++;
        }
        
        
        //BasicBall ball = new BasicBall(ballSizes[0],Color.RED);
   		////TO DO: initialize the numBallsinGame
   		//numBallsinGame++;





        //BasicBall ball2 = new BasicBall(ballSizes[1],Color.BLUE);
        ////ball2.setVelocity(-0.02, 0.03);
   		//numBallsinGame++;




        
        // do the animation loop
        StdDraw.enableDoubleBuffering();
        while (numBallsinGame > 0) {

        	// TODO: move all balls
            //ball.move();
            //ball2.move();
            for(int i = 0; i < ballList.size(); i++)
            {
                ballList.get(i).move();
            }

            //Check if the mouse is clicked
            if (StdDraw.isMousePressed()) {
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                //TODO check whether a ball is hit. Check each ball
                for(int i = 0; i < ballList.size(); i++)
                {
                    if(ballList.get(i).isHit(x, y))
                    {
                        ballList.get(i).reset();

                        //TO DO: Update player statistics
                        //System.out.println("+points");
                        if (ballList.get(i) instanceof ShrinkBall)
                        {

                            myPlayer.score += 20;
                            myPlayer.hitsShrink += 1;
                            myPlayer.totalHits += 1;
                        }
                        else if(ballList.get(i) instanceof SplitBall)
                        {
                            //I need to put ofinstance basicball last becuase all ball are of type basic but they can be of other extneded types as well
                            myPlayer.score += 10;
                            myPlayer.hitsSplit += 1;
                            myPlayer.totalHits += 1;

                            //Im doing my spliting here by just adding another ball to the arraylist 
                            SplitBall ball = new SplitBall(ballList.get(i).getRadius(), Color.BLUE);
                            ballList.add(ball);
                            numBallsinGame++;
            
                        }
                        else if(ballList.get(i) instanceof BounceBall)
                        {
                            //I need to put ofinstance basicball last becuase all ball are of type basic but they can be of other extneded types as well
                            myPlayer.score += 15;
                            myPlayer.hitsBounce += 1;
                            myPlayer.totalHits += 1;
                        }
                        else if(ballList.get(i) instanceof BasicBall)
                        {
                            //I need to put ofinstance basicball last becuase all ball are of type basic but they can be of other extneded types as well
                            myPlayer.score += 25;
                            myPlayer.hitsBasic += 1;
                            myPlayer.totalHits += 1;
                        }
                        else
                        {
                            System.out.println("Something went wrong in updating player stats");
                            myPlayer.score += 25;
                            myPlayer.hitsBasic += 1;
                            myPlayer.totalHits += 1;

                        }

                    }
                }
                // if (ball.isHit(x,y)) {
                //     	ball.reset();
                //     	//TO DO: Update player statistics
                // }
                // if (ball2.isHit(x, y)){
                //         ball2.reset();
                // }
            }
                
            numBallsinGame = 0;
            // draw the n balls
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            
            //TO DO: check each ball and see if they are still visible. numBallsinGame should hold the number of visible balls in the game.  
            for (int i = 0; i < ballList.size(); i++)
            {
                if (ballList.get(i).isOut == false)
                {
                    ballList.get(i).draw();
                    numBallsinGame++;
                }
            }

            // if (ball.isOut == false) { 
            //     ball.draw();
            //     numBallsinGame++;
            // }

            // if (ball2.isOut == false) { 
            //     ball2.draw();
            //     numBallsinGame++;
            // }

            //Print the game progress
            StdDraw.setPenColor(StdDraw.YELLOW);
            Font font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            StdDraw.text(-0.60, 0.90, "Number of balls in game: "+ String.valueOf(numBallsinGame));
            //TO DO: print the rest of the player statistics
            StdDraw.text(-0.60, 0.85, "Number of Hits: "+ String.valueOf(myPlayer.totalHits));
            StdDraw.text(-0.60, 0.80, "Total Score: "+ String.valueOf(myPlayer.score));



            StdDraw.show();
            StdDraw.pause(20);
        }
        while (true) {
            StdDraw.setPenColor(StdDraw.RED);
            Font font = new Font("Arial", Font.BOLD, 60);
            StdDraw.setFont(font);
            StdDraw.text(0, 0.60, "GAME OVER");
            //TO DO: print the rest of the player statistics
            StdDraw.setPenColor(StdDraw.YELLOW);
            font = new Font("Arial", Font.BOLD, 20);
            StdDraw.setFont(font);
            StdDraw.text(0, 0.50, "Total Score: "+ String.valueOf(myPlayer.score));
            StdDraw.text(0, 0.45, "Basic Hits: "+ String.valueOf(myPlayer.hitsBasic));
            StdDraw.text(0, 0.40, "Shrink Hits: "+ String.valueOf(myPlayer.hitsShrink));
            StdDraw.text(0, 0.35, "Bounce Hits: "+ String.valueOf(myPlayer.hitsBounce));
            StdDraw.text(0, 0.30, "Split Hits: "+ String.valueOf(myPlayer.hitsSplit));




            StdDraw.show();
            StdDraw.pause(10);           
        }
        	
        
    }
}
