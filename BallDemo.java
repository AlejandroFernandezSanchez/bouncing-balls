import java.awt.Color;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line
        
        Scanner reader = new Scanner(System.in);
        System.out.println("Cuantas bolas quieres?");
        String inputLine = reader.nextLine();
        int numberOfBalls = Integer.parseInt(inputLine);
        
        myCanvas.setVisible(true);
       
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        
        // crate and show the balls
        Random rand = new Random();

        ArrayList<BouncingBall> balls = new ArrayList<>();
        for (int i = 0; i <numberOfBalls; i++)
        {
            Color color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)); 
            balls.add(new BouncingBall(rand.nextInt(300), rand.nextInt(400), rand.nextInt(50), color, ground, myCanvas));
        }
        
        for (BouncingBall ball: balls)
        {
            ball.draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
             for (BouncingBall ball: balls)
            {
                ball.move();
            }
            // stop once ball has travelled a certain distance on x axis ---------- || ball2.getXPosition() >= 550
            if(balls.get(1).getXPosition() >= 550 ) {
                finished = true;
            }
        }
    }
    
    public void bounce(int amount)
    {
        int ground = 400;   // position of the ground line        
        myCanvas.setVisible(true);       
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);        
        // crate and show the balls 
        
        Random rand = new Random();        
        ArrayList<BouncingBall> balls = new ArrayList<>();
        Color color;
        
        for (int i = 0; i <amount; i++)
        {
            color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); 
            balls.add(new BouncingBall(rand.nextInt(300), rand.nextInt(400), rand.nextInt(50), color, ground, myCanvas));
            balls.get(i).draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
             for (BouncingBall ball: balls)
            {
                ball.move();
                 if(ball.getXPosition() >= 550 ) 
                {
                    finished = true;
                }
            }               
        }
    }
    
    public void boxBounce(int amount)
    {
        int ground = 400;   // position of the ground line        
        myCanvas.setVisible(true);       
        // draw the rectangle
        myCanvas.drawLine(200, 300, 300, 300);
        myCanvas.drawLine(300, 300, 300, 250); 
        myCanvas.drawLine(300, 250, 200, 250); 
        myCanvas.drawLine(200, 250, 200, 300); 
        // create and show the balls 
        
        Random rand = new Random();        
        ArrayList<BoxBall> balls = new ArrayList<>();
        Color color;
        
        for (int i = 0; i <amount; i++)
        {
            color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); 
            balls.add(new BoxBall(200+rand.nextInt(100), 250+rand.nextInt(50), 5+rand.nextInt(10), color, ground, myCanvas));
            balls.get(i).draw();
        }
        
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
             for (BoxBall ball: balls)
            {
                ball.moveInBox(200, 300, 300, 250);
                 if(ball.getXPosition() >= 550 ) 
                {
                    finished = true;
                }
            }               
        }
    }
}
