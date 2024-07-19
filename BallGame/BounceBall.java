

/*
 * Bounce ball is a basicball but it can hit the wall 3 times in the time the ball exists
 * The only functions I need to redefine is the move() and draw()
 * move() needs to check ifs its out of bounds then redirect velocity and increase bounce count and then at 3 bounces make it go away
 * draw() currently does a check for isOut so that needs to be taken away
 *  
 */


import java.awt.Color;

public class BounceBall extends BasicBall
{
    
    protected int numBounces;
    protected int maxBounces;


    public BounceBall(double r, Color c)
    {
        //I need to make sure that the basicBall is initialized first then do this stuff
        super(r, c);
        numBounces = 0;
        maxBounces = 3;
    }

    // move the ball one step
    public void move() 
    {
        rx = rx + vx;
        ry = ry + vy;

        if (((Math.abs(rx) > 1.0) || (Math.abs(ry) > 1.0)) && numBounces == maxBounces) 
        {
            isOut = true;
            //System.out.println("1");
            //System.out.println("Bounces 39   " + numBounces + "  " + maxBounces);

        }
        if ((Math.abs(rx) > 1.0) && (Math.abs(ry) < 1.0) && numBounces < maxBounces)
        {
            //System.out.println("Before: " + vx);
            vx = -vx;//Reverse direction from wall
            numBounces += 1;
            //System.out.println("After:   " + vx);
            //System.out.println("Bounces if   " + numBounces + "  " + maxBounces);

        }
        if ((Math.abs(rx) < 1.0) && (Math.abs(ry) > 1.0) && numBounces < maxBounces)
        {
            vy = -vy;//Reverse direction from wall
            numBounces += 1;
            //System.out.println("Top/Bottom");
        }


        // if ((Math.abs(rx) > 1.0) || (Math.abs(ry) > 1.0)) 
        // {
        //     if (numBounces == maxBounces)
        //     {
        //         isOut = true;
        //     }
        // }
        // else if ((Math.abs(rx) > 1.0) && (Math.abs(ry) < 1.0))
        // {
        //    if (numBounces < maxBounces)
        //    {
        //         vx = -vx;//Reverse direction from wall
        //         numBounces += 1;
        //    }
        // }
        // else if ((Math.abs(rx) < 1.0) && (Math.abs(ry) > 1.0))
        // {
        //    if (numBounces < maxBounces)
        //    {
        //         vy = -vy;//Reverse direction from wall
        //         numBounces += 1;
        //    }
        // }   
    }

    // draw the ball
    public void draw() { 
        if ((Math.abs(rx) <= 1.0) && (Math.abs(ry) <= 1.0)) {
            StdDraw.setPenColor(color);
            StdDraw.filledCircle(rx, ry, radius);
        }
    }




}
