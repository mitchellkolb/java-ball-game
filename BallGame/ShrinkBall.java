

/*
 * The shrinkball is just a basic ball where when its clicked its size is cut by a third then at 25% its size, its reset to its original size.
 * All I need to do is redefine the reset() with this new functionaility
 * 
 */


import java.awt.Color;
import java.util.Random;




public class ShrinkBall extends BasicBall 
{
    double startingRadius; //this is used to reset the ball after its 25% its original size

    public ShrinkBall(double r, Color c)
    {
        //I need to make sure that the basicBall is initialized first then do this stuff
        super(r, c);
        startingRadius = r;
    }

    //Redefine the reset() from basicball so that it now becomes shrinkball
    public int reset() {
        rx = 0.0;
        ry = 0.0;  	
        // TO DO: assign a random speed 
        // --- Because the values vx and vy are added to the rx and ry values above and those determine the ball speed Ill name them the same
        Random rand = new Random();
        vx = (rand.nextDouble() * 0.02 - 0.01);
        vy = (rand.nextDouble() * 0.02 - 0.01);


        //Shrinkball code
        radius = radius * 0.6;
        if (radius <= startingRadius / 4)
        {
            radius = startingRadius;
        }

        return 1;
    }
}
