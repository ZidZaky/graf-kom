import java.awt.*;
import java.awt.geom.*;

/**
* An example for the use of a GeneralPath to draw a car.
*
* @author Frank Klawonn
* Last change 07.01.2005
*/
public class GeneralPathCar2 extends Frame
{
  //Constructor
  GeneralPathCar2()
  {
    //Enables the closing of the window.
    addWindowListener(new MyFinishWindow());
  }


  public void paint(Graphics g)
{
    Graphics2D g2d = (Graphics2D) g;

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    BasicStroke bs = new BasicStroke(3.0f);
    g2d.setStroke(bs);

    GeneralPath gp = new GeneralPath();

    gp.moveTo(60, 120);

    gp.lineTo(80, 120);

    g2d.setColor(Color.RED);
    g2d.fillOval(90 - 2, 140 - 2, 4, 4);
    g2d.setColor(Color.BLACK);
    g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
    g2d.drawLine(80, 120, 90, 140);
    g2d.setStroke(bs);
    gp.quadTo(90, 140, 100, 120);

    g2d.setColor(Color.RED);
    g2d.fillOval(170 - 2, 140 - 2, 4, 4);
    g2d.setColor(Color.BLACK);
    gp.lineTo(160, 120);
    
    g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
    g2d.drawLine(160, 120, 170, 140);
    g2d.setStroke(bs);

    gp.quadTo(170, 140, 180, 120);

    gp.lineTo(200, 120);

    g2d.setColor(Color.RED);
    g2d.fillOval(195 - 2, 100 - 2, 4, 4);
    g2d.fillOval(200 - 2, 80 - 2, 4, 4);
    g2d.setColor(Color.BLACK);

    g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
    g2d.drawLine(200, 120, 195, 100);
    g2d.drawLine(160, 80, 200, 80);
    g2d.setStroke(bs);

    gp.curveTo(195, 100, 200, 80, 160, 80);

    gp.lineTo(110, 80);

    gp.lineTo(90, 100);

    gp.lineTo(60, 100);

    gp.lineTo(60, 120);

    g2d.draw(gp);

    g2d.setStroke(new BasicStroke(1.0f));

    drawSimpleCoordinateSystem(200, 150, g2d);
}




  /**
  * Draws a coordinate system (according to the window coordinates).
  *
  * @param xmax     x-coordinate to which the x-axis should extend.
  * @param ymax     y-coordinate to which the y-axis should extend.
  * @param g2d      Graphics2D object for drawing.
  */
  public static void drawSimpleCoordinateSystem(int xmax, int ymax,
                                                Graphics2D g2d)
  {
    int xOffset = 30;
    int yOffset = 50;
    int step = 20;
    String s;
    //Remember the actual font.
    Font fo = g2d.getFont();
    //Use a small font.
    g2d.setFont(new Font("sansserif",Font.PLAIN,9));
    //x-axis.
    g2d.drawLine(xOffset,yOffset,xmax,yOffset);
    //Marks and labels for the x-axis.
    for (int i=xOffset+step; i<=xmax; i=i+step)
    {
      g2d.drawLine(i,yOffset-2,i,yOffset+2);
      g2d.drawString(String.valueOf(i),i-7,yOffset-7);
    }

    //y-axis.
    g2d.drawLine(xOffset,yOffset,xOffset,ymax);

    //Marks and labels for the y-axis.
    s="  "; //for indention of numbers < 100
    for (int i=yOffset+step; i<=ymax; i=i+step)
    {
      g2d.drawLine(xOffset-2,i,xOffset+2,i);
      if (i>99){s="";}
      g2d.drawString(s+String.valueOf(i),xOffset-25,i+5);
    }

    //Reset to the original font.
    g2d.setFont(fo);
  }


   public static void main(String[] argv)
  {
    GeneralPathCar2 f = new GeneralPathCar2();
    f.setTitle("GeneralPath example");
    f.setSize(250,200);
    f.setVisible(true);
  }
}

