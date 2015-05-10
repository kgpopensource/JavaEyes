//package Javaapplication1;

import java.awt.*;
import java.awt.event.*;

public class javaeyes extends Frame implements MouseMotionListener
{
GraphicsDevice gs;
public static double x,y,x_cord,y_cord,m1,m2,hx,hy,flag;
public Image buf;
public javaeyes()
{

        setSize(800,800);
        flag=1;
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
              dispose();
              System.exit(0);
            }
        });
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        gs = ge.getDefaultScreenDevice();
        addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent e)
            {
                 gs.setFullScreenWindow(null);
                 dispose();
                 System.exit(0);
            }
        });
        addMouseMotionListener(this);
        setVisible(true);

        try
        {
            gs.setFullScreenWindow(this);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
}
public void mouseMoved(MouseEvent e)
{
	javaeyes.x=(double)e.getX();
	javaeyes.y=(double)e.getY();
        repaint();
}
public void mouseDragged(MouseEvent e){}
public void calculate(int cx,int cy,int r)
{
  double radius=r,centerx=cx,centery=cy,a,b,c,d,k,slope,temp,krun;
  slope=(javaeyes.y-centery)/(javaeyes.x-centerx);
  temp=Math.pow(slope,2);
  a=1+temp;
  b=-(2*centerx*(temp+1));
  c=((temp+1)*centerx*centerx)-(radius*radius);
  k=Math.sqrt((b*b)-(4*a*c));
  krun=Math.sqrt(Math.pow(javaeyes.x-centerx,2)+Math.pow(javaeyes.y-centery, 2));
  krun=krun-radius;
    if(javaeyes.x>centerx)
    {
       javaeyes.x_cord=((-b+k)/(2*a));
    }
    else
    {
       javaeyes.x_cord=((-b-k)/(2*a));
    }
    javaeyes.y_cord=(slope*(javaeyes.x_cord-centerx)+centery);
    calculate1(krun);
}
public void calculate1(double krun)
{
    if(krun<0)
    {
    javaeyes.m1=(javaeyes.x)-10;
    javaeyes.m2=(javaeyes.y)-10;
    javaeyes.x_cord=javaeyes.x-50;
    javaeyes.y_cord=javaeyes.y-50;
    }
    else
    {
    javaeyes.m1=(javaeyes.x_cord-10);
    javaeyes.m2=(javaeyes.y_cord-10);
    javaeyes.x_cord=javaeyes.x_cord-50;
    javaeyes.y_cord=javaeyes.y_cord-50;
    }
}
public void update(Graphics g)
{
    paint(g);
}
public void paint(Graphics gg)
{
    buf=createImage(1920,1080);
    Graphics g=buf.getGraphics();
    g.setColor(Color.white);
    g.fillOval(300,300,199,199);
    g.fillOval(500,300,199,199);
    g.setColor(Color.BLACK);
    calculate(400,400,50);
    g.drawOval((int)javaeyes.x_cord,(int)javaeyes.y_cord ,100,100 );
    g.fillOval((int)javaeyes.m1,(int)javaeyes.m2 ,25,25 );
    calculate(600,400,50);
    g.drawOval((int)javaeyes.x_cord,(int)javaeyes.y_cord ,100,100 );
    g.fillOval((int)javaeyes.m1,(int)javaeyes.m2 ,25,25 );
    g.drawOval(300,300,200,200);
    g.drawOval(500,300,200,200);
    //g.drawOval(150,150,700,700);
    g.drawOval(480,520,50,140);
    g.fillArc(360, 630, 300, 120, 0, -180);
    gg.drawImage(buf, 0,0, this);
}
    public static void main(String[] args)
    {
        javaeyes g=new javaeyes();
    }
}// end of the program

//asd asd asda sdsd


