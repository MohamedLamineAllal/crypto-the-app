
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import static java.time.Clock.system;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.util.Random;
import javax.swing.JComponent;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ABS
 */


public class RSA extends javax.swing.JFrame {

    /**
     * Creates new form mainJfram
     */
    public RSA() {
        initComponents();
                
        Rectangle rect=new Rectangle(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        // that, give the available screen space (width and height (without counting the task bar)) 
        setLocation((int)(rect.getWidth()-getWidth())/2, (int)(rect.getHeight()-getHeight())/2); //seting the location of the jFram to be centred
        //                                       ^                                      ^
        //                                 width of the jfram                  height of the jfram
        
 
  Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            public void eventDispatched(AWTEvent event) {
                if(event instanceof MouseEvent){
                    MouseEvent evt = (MouseEvent)event;
                    if(evt.getID() == MouseEvent.MOUSE_CLICKED){
                      jPanel16.repaint();
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);
  
    }

    
        
        
        
        
        
        
        
        
        
        
        
        
    
    class Timing{
        private
              long start;
              long end;
              long duration;
              
              
        /*long nanoSeconds;      
        long miliSeconds;      
        long second;
        long minutes;
        long hours;
        long days;
        long years; // a year is 365 days 
  */
        public
          
                /*   void formate()
                {long elapsedTime=duration;
                nanoSeconds =  ((elapsedTime)%((long)1e6)); // 1e6 est 10^6   1ms = 10^6 ns
               
                elapsedTime = (long) (elapsedTime/1e6); // le temps restant en milisecond en enlevant la valeur donner à nanoSeconds 

                miliSeconds = ((elapsedTime)%((long)1e3)); // 1s= 1000 ms
                
                elapsedTime = (long) (elapsedTime/1e3); // le reste en s
                
                second = ((elapsedTime)%60); // 1mn= 60s
                
                elapsedTime = (long) (elapsedTime/60); // le reste en mn
                
                minutes = ((elapsedTime)%60); // 1h= 60mn
                
                elapsedTime = (long) (elapsedTime/60); // le reste en h
                
                hours = ((elapsedTime)%24); // 1d= 24h
                
                elapsedTime = (long) (elapsedTime/24); // le reste en d
                
                days = ((elapsedTime)%365); // 1y= 365d
                
                elapsedTime = (long) (elapsedTime/365); // le reste en y
                
                years = elapsedTime; // reste le nombre d'années
                
                }
                */
                        
            /////////////////////////////////////////////////////////F1 format 1: <<y:d:h:mn:s:ms:ns>     
                long getF1ns()
                {
               return  duration%((long)1e6);
                }
                 long getF1ms()
                {
               return  (long)(duration/((long)1e6)) % (long)1e3;
                }      
                 long getF1s()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 % 60;
                }     
                 long getF1mn()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 %60;
                }    
                  long getF1h()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 /60%24;
                }    
                  long getF1d()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 /60/24%365;
                } 
                 long getF1y()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 /60/24/365;
                }  
                 
                 /////////////////////////////////////////////////////////F2 format 2: <<d:h:mn:s:ms:ns>>
                 long getF2ns()
                {
               return  duration%((long)1e6);
                }
                 long getF2ms()
                {
               return  (long)(duration/((long)1e6)) % (long)1e3;
                }      
                 long getF2s()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 % 60;
                }     
                 long getF2mn()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 %60;
                }    
                         long getF2h()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 /60%24;
                }    
                  long getF2d()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60 /60/24;
                } 
                  
                  
                  
              /////////////////////////////////////////////////////////F3 format 3: <<h:mn:s:ms:ns>>   
                       long getF3ns()
                {
               return  duration%((long)1e6);
                }
                 long getF3ms()
                {
               return  (long)((duration/((long)1e6)) % (long)1e3);
                }      
                 long getF3s()
                {
               return  ((long)((duration/((long)1e6))/ (long)1e3) % 60);
                }     
                 long getF3mn()
                {
               return  ((long)((duration/((long)1e6))/ (long)1e3 / 60) %60);
                }    
                         long getF3h()
                {
               return  (long)((duration/((long)1e6))/ (long)1e3 / 60 /60);
                } 
                  
                    
                         
                         
              /////////////////////////////////////////////////////////F4 format 4: <<mn:s:ms:ns>>    
                          long getF4ns()
                {
               return  duration%((long)1e6);
                }
                 long getF4ms()
                {
               return  (long)(duration/((long)1e6)) % (long)1e3;
                }      
                 long getF4s()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 % 60;
                }     
                 long getF4mn()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3 / 60;
                }     
                  
                   
                 
                     /////////////////////////////////////////////////////////F5 format 5: <<s:ms:ns>>    
                          long getF5ns()
                {
               return  duration%((long)1e6);
                }
                 long getF5ms()
                {
               return  (long)(duration/((long)1e6)) % (long)1e3;
                }      
                 long getF5s()
                {
               return  (long)(duration/((long)1e6))/ (long)1e3;
                } 
                 
                 
                     
                 
                 
                    /////////////////////////////////////////////////////////F6 format 6: <<ms:ns>>    
                          long getF6ns()
                {
               return  duration%((long)1e6);
                }
                 long getF6ms()
                {
               return  (long)(duration/((long)1e6));
                }      
                 
                 /////////////////////////////////////////////////////////////
                 long getInNano()
                 {
                     return duration;
                 }
                
                 long getStart()
                 {
                     return start;
                 }
                 
                 long getEnd()
                 {
                     return end;
                 }
                 
                String strF3Duration()
                {long h,mn,s,ms,ns;
                h=getF3h();mn=getF3mn();s=getF3s();ms=getF3ms();ns=getF3ns();
                   
                return  String.valueOf(getF3h())+"h : "+ String.valueOf(getF3mn())+"mn : "+ String.valueOf(getF3s())+"s : "+ String.valueOf(getF3ms())+"ms : "+ String.valueOf(getF3ns())+"ns";
                }
                 
                 String strF32Duration()
                {
                return  String.valueOf(getF3h())+"h : "+ String.valueOf(getF3mn())+"mn";
                }
                 
                 
                 
                 
                 
                 
                 
                 String strTimeUnivNS()
                 {
                     if(getF1y()!=0)
                         return String.valueOf(getF1y())+" year(s) : "+ String.valueOf(getF1d())+" day(s) : "+ String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                     else if(getF1d()!=0)
                          return  String.valueOf(getF1d())+" day(s) : "+ String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                     else if(getF1h()!=0)
                          return   String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                      else if(getF1mn()!=0)
                          return   String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                     else if(getF1s()!=0)
                          return   String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                      else if(getF1ms()!=0)
                          return    String.valueOf(getF1ms())+" ms : "+ String.valueOf(getF1ns())+" ns";
                       
                      else return String.valueOf(getF1ns())+" ns";       
                 
                 }
                 
                  String strTimeUnivMS()
                 {
                     if(getF1y()!=0)
                         return String.valueOf(getF1y())+" year(s) : "+ String.valueOf(getF1d())+" day(s) : "+ String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms";
                     else if(getF1d()!=0)
                          return  String.valueOf(getF1d())+" day(s) : "+ String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms";
                     else if(getF1h()!=0)
                          return   String.valueOf(getF1h())+" h : "+ String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms";
                      else if(getF1mn()!=0)
                          return   String.valueOf(getF1mn())+" mn : "+ String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms";
                     else if(getF1s()!=0)
                          return   String.valueOf(getF1s())+" s : "+ String.valueOf(getF1ms())+" ms";
                      else if(getF1ms()!=0)
                          return    String.valueOf(getF1ms())+" ms";
                       
                      else return String.valueOf(getF1ns())+" ns";       
                 
                 }
                 
                //////////////////////////////////////////////// 
                Timing(){
                start= System.nanoTime();
                   } // starting the counter
               
                ////////////////////////////////////                
                void updateDuration()
                {
                end=System.nanoTime();
                duration= end-start;
                }
         
                ////////////////////////////////////////
    } 
    
    
    
    
    
    
    
    
    
 
    
 
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////
      public  JComponent scaleSwingManual(JComponent cp,int widthAdd,int heightAdd){ //we calculate scaleCoeficient of the width and add to the width
        int width = cp.getWidth() , height=cp.getHeight(), newWidth, newheight,newX,newY;
        
        newWidth=(int) (width+widthAdd);
          newheight=(int) (height+heightAdd);
          
          newX=cp.getX()-(newWidth-width)/2;
          newY=cp.getY()-(newheight-height)/2;
          
        cp.setBounds(newX, newY, newWidth, newheight);
        return cp;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////  
      public JComponent downSwing(JComponent cp,int spaceMove)// move down a component
      {
          cp.setLocation(cp.getX(),cp.getY()+spaceMove);
          return cp;
      }
     ////////////////////////////////////////////////////
       public JComponent rightSwing(JComponent cp,int spaceMove)// move right a component
      {
          cp.setLocation(cp.getX()+spaceMove,cp.getY());
          return cp;
      }
     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
       public JLabel sccaleFontSwing(JLabel jlb,int intAddToSize)
       {
           jlb.setFont(new Font(jlb.getFont().getFamily(),jlb.getFont().getStyle(),jlb.getFont().getSize()+intAddToSize)); 
           return jlb;
       }
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
       
      public JComponent concatinateComponentsHoriz(JComponent cp1, JComponent cp2,int mode) 
       {
           if(mode==1) // mode 1 simple horizantal concatination
           {
           cp2.setLocation(cp1.getX()+cp1.getWidth(), cp1.getY() );
          
           }
           else if(mode==2){ // simple + changing the height to fit the other component
            cp2.setBounds(cp1.getX()+cp1.getWidth(), cp1.getY(),cp2.getWidth(),cp1.getHeight() );    
           }
            return cp2;
       }
      
      /////////////////////////////////////////////////////
      
             
      public JComponent concatinateComponentsVerti(JComponent cp1, JComponent cp2,int mode) 
       {
           if(mode==1) // mode 1 simple horizantal concatination
           {
           cp2.setLocation(cp1.getX(), cp1.getY()+cp1.getHeight() );
          
           }
           else if(mode==2){ // simple + changing the height to fit the other component
            cp2.setBounds(cp1.getX()+cp1.getWidth(), cp1.getY(),cp2.getWidth(),cp1.getHeight() );    
           }
            return cp2;
       }
      
      
      
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      
      public JScrollPane scrollAnnimationV(JScrollPane scrp,int msTime, int imgPs, int start,int end) throws InterruptedException
      {
          int nbrImages = imgPs*msTime /  1000;
          int intervaleTime = msTime/nbrImages;
          int  intervaleDistance = (end-start)/nbrImages;
          long startimer,endtimer;
          scrp.getVerticalScrollBar().setValue(start);
          for(int i=0;i<nbrImages-1;i++){
               scrp.getVerticalScrollBar().setValue(scrp.getVerticalScrollBar().getValue()+intervaleDistance); 
              
               ///////////////////////////////////////////////////// wait
               startimer = System.currentTimeMillis();
               endtimer = startimer;
               while(endtimer-startimer<intervaleTime)
                 endtimer = System.currentTimeMillis();
               /////////////////////////////////////////////////////
          }
        
              scrp.getVerticalScrollBar().setValue(end);
                 return scrp;
      }
   ////////////////////////////////////////////////////   
      public JScrollPane scrollAnnimationH(JScrollPane scrp,int msTime, int imgPs, int start,int end) throws InterruptedException
      {
          int nbrImages = imgPs*msTime /  1000;
          int intervaleTime = msTime/nbrImages;
          int  intervaleDistance = (end-start)/nbrImages;
          
          scrp.getVerticalScrollBar().setValue(start);
          for(int i=0;i<nbrImages-1;i++){
               scrp.getHorizontalScrollBar().setValue(scrp.getHorizontalScrollBar().getValue()+intervaleDistance); 
               Thread.sleep(intervaleTime);
          }
        
              scrp.getHorizontalScrollBar().setValue(end);
          return scrp;
      }
      
      
      
      
class transitionAnnimSwing extends SwingWorker<JComponent, JComponent> {
    JComponent  cpn;  
    int msTime;
    int imgPs;
    int startX;
     int startY;
    int endX;
     int endY;
    
    public transitionAnnimSwing (JComponent cp,int MsTime, int ImgPs, int StartX,int StartY,int EndX,int EndY)
    {
        cpn = cp;
         msTime=MsTime;
         imgPs=ImgPs;
         startX=StartX;
         startY=StartY;
         endX=EndX;
         endY=EndY;
    }
    
    @Override
       public JComponent doInBackground() throws InterruptedException {
       int nbrImages = imgPs*msTime /  1000;
          int intervaleTime = msTime/nbrImages;
          int  intervaleDistanceX = (endX-startX)/nbrImages;
         int newX;
          cpn.setLocation(startX,startY);
          
          for(int i=0;i<nbrImages-1;i++){
              newX=cpn.getX()+intervaleDistanceX;
              cpn.setLocation(newX,(endY-startY)/(endX-startX)*(newX-startX)+startY );
              
               Thread.sleep(intervaleTime);
               /////////////////////////////////////////////////////
               publish(cpn);
          }
        
             cpn.setLocation(endX,endY);
                 return cpn;
           
       }

       @Override
       protected void done() {
       
           try {
              cpn=(JPanel) get();       //  // very important it work well even like this cool !!!!!!!!!!! also we can put the object we want to apply to 
           } catch (InterruptedException | ExecutionException ignore) {
           }
             
           
       }
       
        @Override
  protected void process(final List<JComponent> chunks) {
   
	for (final JComponent  db : chunks) {
            if(!this.isCancelled())
            {
              cpn=(JPanel) db;
db.updateUI();
// very important it work well even like this cool
            }
            
    }
	
  }
   }

///////////////////////////////////////////:


class transitionAnnimSwingLabel extends SwingWorker<JLabel, JLabel> {
    JLabel  cpn;  
    int msTime;
    int imgPs;
    int startX;
     int startY;
    int endX;
     int endY;
    
    public transitionAnnimSwingLabel (JLabel cp,int MsTime, int ImgPs, int StartX,int StartY,int EndX,int EndY)
    {
        cpn = cp;
         msTime=MsTime;
         imgPs=ImgPs;
         startX=StartX;
         startY=StartY;
         endX=EndX;
         endY=EndY;
    }
    
    @Override
       public JLabel doInBackground() throws InterruptedException {
       int nbrImages = imgPs*msTime /  1000;
          int intervaleTime = msTime/nbrImages;
          int  intervaleDistanceX = (endX-startX)/nbrImages;
         int newX;
          cpn.setLocation(startX,startY);
          
          for(int i=0;i<nbrImages-1;i++){
              newX=cpn.getX()+intervaleDistanceX;
              cpn.setLocation(newX,(endY-startY)/(endX-startX)*(newX-startX)+startY );
              
               Thread.sleep(intervaleTime);
               /////////////////////////////////////////////////////
               publish(cpn);
          }
        
             cpn.setLocation(endX,endY);
                 return cpn;
           
       }

       @Override
       protected void done() {
           try {
              cpn= get();       //  // very important it work well even like this cool !!!!!!!!!!! also we can put the object we want to apply to 
           } catch (InterruptedException | ExecutionException ignore) {
           }
       }
       
        @Override
  protected void process(final List<JLabel> chunks) {
   
	for (final JLabel  db : chunks) {
            if(!this.isCancelled())
            {
              cpn=db;   // very important it work well even like this cool
            }
            
    }
	
  }
   }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////









     
     
     
     
    public BigInteger chiffrementRSA(BigInteger numToCrypt, BigInteger exposantPublic, BigInteger module)
{
	return numToCrypt.modPow(exposantPublic, module);
	
}
 
       public String chiffrementRSA(String claire, BigInteger exposantPublic, BigInteger module)
{
String chiffre = "";
for(int i = 0; i< claire.length(); i++){
    chiffre = chiffre + chiffrementRSA(module.subtract(BigInteger.valueOf((int) claire.charAt(i))), exposantPublic, module).toString()+" "; // x ===> N-x , y = rsa(N-x);  
} 

return chiffre;    
	
}
  
  
    public BigInteger restesChinois(List<BigInteger> a ,List<BigInteger> n,BigInteger N)
    {
        int sizeA= a.size(); 
        BigInteger x=BigInteger.ZERO; BigInteger c_i; 
        for(int i = 0; i<sizeA; i++)
        {
            c_i = N.divide(n.get(i)).multiply(N.divide(n.get(i)).modInverse(N));
            x=x.add(c_i.multiply(a.get(i)));
        }
        return x;
    }
    
    public BigInteger restesChinois(BigInteger a_1,BigInteger a_2, BigInteger p ,BigInteger q,BigInteger N)
    {
                  
         return N.divide(p).multiply(N.divide(p).modInverse(N)).multiply(a_1).add(
               N.divide(q).multiply(N.divide(q).modInverse(N)).multiply(a_2)  );    
    }
    
        public BigInteger dechiffrementRSA(BigInteger numToDeCrypt, BigInteger exposantPrive, BigInteger module)
{
    
   	return numToDeCrypt.modPow(exposantPrive, module);
	
}
  
        public String dechiffrementRSA(String chiffre, BigInteger exposantPrive, BigInteger module)
{
String claire = "";

int j = 0;
int chiffreLength = chiffre.length();

for(int i = 1; i<chiffreLength ; i++){
    if(chiffre.charAt(i)!=' ' && chiffre.charAt(i-1)==' ')
        j = i;
    else if((chiffre.charAt(i)==' ' && chiffre.charAt(i-1)!=' ')){
     claire = claire + String.valueOf((char) dechiffrementRSA(new BigInteger(chiffre.substring(j, i)), exposantPrive, module).subtract(module).negate().intValue()) ; // y=rsa(N-x) ===> rsa-1(y)= N-x ====> -x =====> x  
} 
    else if((chiffre.charAt(i)!=' '&& i == chiffreLength-1))
     claire = claire + String.valueOf((char) dechiffrementRSA(new BigInteger(chiffre.substring(j)), exposantPrive, module).subtract(module).negate().intValue()) ;
    
}
return claire;    
	
}
   
        public BigInteger dechiffrementRSA_CRT(BigInteger chiffre, BigInteger p, BigInteger q,BigInteger d_p, BigInteger d_q, BigInteger qInv )
        {BigInteger x_1 =chiffre.modPow(d_p,p);
          BigInteger x_2 =chiffre.modPow(d_q,q); 
          
         return x_1.subtract(x_2).multiply(qInv).mod(p).multiply(q).add(x_2);
        }
     
      public String dechiffrementRSA_CRT(String chiffre, BigInteger p, BigInteger q,BigInteger d_p, BigInteger d_q, BigInteger qInv)
{
String claire = "";
int j = 0;
int chiffreLength = chiffre.length();
for(int i = 1; i<chiffreLength ; i++){
    if(chiffre.charAt(i)!=' ' && chiffre.charAt(i-1)==' ')
        j = i;
    else if((chiffre.charAt(i)==' ' && chiffre.charAt(i-1)!=' ')){
    claire = claire + (char) dechiffrementRSA_CRT(new BigInteger(chiffre.substring(j, i)), p,q,d_p,d_q,qInv).subtract(p.multiply(q)).negate().intValue(); // y=rsa(N-x) ===> rsa-1(y)= N-x ====> -x =====> x  
}
       else if((chiffre.charAt(i)!=' '&& i == chiffreLength-1))
           claire = claire + (char) dechiffrementRSA_CRT(new BigInteger(chiffre.substring(j)), p,q,d_p,d_q,qInv).subtract(p.multiply(q)).negate().intValue(); // y=rsa(N-x) ===> rsa-1(y)= N-x ====> -x =====> x  

    
}
return claire;    
	
}
      
      
    BigInteger generatePrim(int bitsLenght, int certitude)
    {
        Random rdm = new Random();
        return new BigInteger(bitsLenght, certitude, rdm);
    } 

    

BigInteger generatePrimeWith(int bitsLenght, BigInteger num) {
    Random rdm = new Random();
    BigInteger result = new BigInteger(bitsLenght,rdm);
   while( ! result.gcd(num).equals(BigInteger.ONE) )
   {
       result = new BigInteger(bitsLenght,rdm);
   }
   
   return result;
}   






/**
 *  A wrapper Container for holding components that use a background Color
 *  containing an alpha value with some transparency.
 *
 *  A Component that uses a transparent background should really have its
 *  opaque property set to false so that the area it occupies is first painted
 *  by its opaque ancestor (to make sure no painting artifacts exist). However,
 *  if the property is set to false, then most Swing components will not paint
 *  the background at all, so you lose the transparent background Color.
 *
 *  This components attempts to get around this problem by doing the
 *  background painting on behalf of its contained Component, using the
 *  background Color of the Component.
 */
public class AlphaContainer extends JComponent
{
	private JComponent component;

	public AlphaContainer(JComponent component)
	{
		this.component = component;
		setLayout( new BorderLayout() );
		setOpaque( false );
		component.setOpaque( false );
		add( component );
	}

	/**
	 *  Paint the background using the background Color of the
	 *  contained component
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor( component.getBackground() );
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}




 public String getClipboardContents() {
    String result = "";
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    //odd: the Object param of getContents is not currently used
    Transferable contents = clipboard.getContents(null);
    boolean hasTransferableText =
      (contents != null) &&
      contents.isDataFlavorSupported(DataFlavor.stringFlavor)
    ;
    if (hasTransferableText) {
      try {
        result = (String)contents.getTransferData(DataFlavor.stringFlavor);
      }
      catch (UnsupportedFlavorException | IOException ex){
        System.out.println(ex);
        ex.printStackTrace();
      }
    }
    return result;
  }




          
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel16 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jTextField17 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jTextField18 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jTextField19 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField11 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jTextField13 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jTextField14 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField23 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField5 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crypto");
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });

        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(91, 37, 73));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        jPanel19.setBackground(new java.awt.Color(28, 24, 34));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(51, 42, 56)));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel5MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(585, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel19);
        jPanel19.setBounds(0, 30, 70, 660);

        jPanel30.setBackground(new java.awt.Color(39, 30, 45));
        jPanel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel30MouseClicked(evt);
            }
        });
        jPanel30.setLayout(null);

        jPanel10.setBackground(new java.awt.Color(27, 26, 33));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 5, new java.awt.Color(61, 57, 83)));

        jPanel5.setBackground(new java.awt.Color(29, 28, 34));
        jPanel5.setLayout(new java.awt.GridLayout(9, 1));

        jLabel6.setBackground(new java.awt.Color(32, 32, 47));
        jLabel6.setForeground(new java.awt.Color(130, 122, 122));
        jLabel6.setText("          Square and multiply");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        jLabel6.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel6.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel6.setOpaque(true);
        jLabel6.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel6MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel6);

        jLabel8.setBackground(new java.awt.Color(32, 32, 47));
        jLabel8.setForeground(new java.awt.Color(130, 122, 122));
        jLabel8.setText("          Square and multiply (modulo)");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));
        jLabel8.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel8.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel8.setOpaque(true);
        jLabel8.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel8MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel8);

        jLabel10.setBackground(new java.awt.Color(32, 32, 47));
        jLabel10.setForeground(new java.awt.Color(130, 122, 122));
        jLabel10.setText("          Algorithme Euclide (Etendu)");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));
        jLabel10.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel10.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel10.setOpaque(true);
        jLabel10.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel10MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel10);

        jLabel11.setBackground(new java.awt.Color(32, 32, 47));
        jLabel11.setForeground(new java.awt.Color(130, 122, 122));
        jLabel11.setText("           Inverse modulaire");
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        jLabel11.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel11.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel11.setOpaque(true);
        jLabel11.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel11MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel11);

        jLabel12.setBackground(new java.awt.Color(32, 32, 47));
        jLabel12.setForeground(new java.awt.Color(130, 122, 122));
        jLabel12.setText("           Testes de primalité ");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));
        jLabel12.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel12.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel12.setOpaque(true);
        jLabel12.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel12MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel12);

        jLabel13.setBackground(new java.awt.Color(32, 32, 47));
        jLabel13.setForeground(new java.awt.Color(130, 122, 122));
        jLabel13.setText("           Generateurs");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        jLabel13.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel13.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel13.setOpaque(true);
        jLabel13.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel13MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel13);

        jLabel14.setBackground(new java.awt.Color(32, 32, 47));
        jLabel14.setForeground(new java.awt.Color(130, 122, 122));
        jLabel14.setText("           Convertisseur Dec Bin Hex");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));
        jLabel14.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel14.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel14.setOpaque(true);
        jLabel14.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel14MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel14);

        jLabel16.setBackground(new java.awt.Color(32, 32, 47));
        jLabel16.setForeground(new java.awt.Color(130, 122, 122));
        jLabel16.setText("           Convertisseur Bin Dec");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        jLabel16.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel16.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel16.setOpaque(true);
        jLabel16.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel16MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel16);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 135, Short.MAX_VALUE))
        );

        jPanel30.add(jPanel10);
        jPanel10.setBounds(-260, 0, 250, 660);
        jPanel10.setVisible(false);

        jPanel15.setBackground(new java.awt.Color(19, 19, 24));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });
        jPanel15.setLayout(null);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel30MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel30MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel30MouseReleased(evt);
            }
        });
        jPanel15.add(jLabel30);
        jLabel30.setBounds(70, 220, 30, 30);
        jLabel30.setVisible(false);

        jTextArea5.setEditable(false);
        jTextArea5.setColumns(20);
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(5);
        jTextArea5.setWrapStyleWord(true);
        jTextArea5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea5FocusLost(evt);
            }
        });
        jScrollPane5.setViewportView(jTextArea5);

        jPanel15.add(jScrollPane5);
        jScrollPane5.setBounds(110, 170, 260, 100);

        jTextArea6.setColumns(20);
        jTextArea6.setLineWrap(true);
        jTextArea6.setRows(5);
        jTextArea6.setWrapStyleWord(true);
        jTextArea6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea6FocusLost(evt);
            }
        });
        jTextArea6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea6KeyTyped(evt);
            }
        });
        jScrollPane6.setViewportView(jTextArea6);

        jPanel15.add(jScrollPane6);
        jScrollPane6.setBounds(110, 60, 260, 100);

        jTextField17.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField17FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField17FocusLost(evt);
            }
        });
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField17KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField17KeyTyped(evt);
            }
        });
        jPanel15.add(jTextField17);
        jTextField17.setBounds(60, 30, 60, 22);

        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("Clé privé:");
        jPanel15.add(jLabel40);
        jLabel40.setBounds(10, 30, 60, 14);

        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("Texte chiffré");
        jPanel15.add(jLabel41);
        jLabel41.setBounds(30, 80, 70, 14);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(184, 46, 46));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Dechiffrement RSA-CRT");
        jPanel15.add(jLabel42);
        jLabel42.setBounds(0, 0, 180, 20);
        jLabel23.setVisible(false);

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setForeground(new java.awt.Color(153, 153, 153));
        jButton11.setText("Dechiffrer");
        jButton11.setAlignmentY(0.0F);
        jButton11.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton11);
        jButton11.setBounds(10, 170, 90, 30);

        jTextField18.setBackground(new java.awt.Color(39, 38, 41));
        jTextField18.setForeground(new java.awt.Color(51, 153, 255));
        jTextField18.setBorder(null);
        jTextField18.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField18FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField18FocusLost(evt);
            }
        });
        jTextField18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField18MouseEntered(evt);
            }
        });
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        jPanel15.add(jTextField18);
        jTextField18.setBounds(110, 270, 270, 13);
        //jTextField4.setBackground(new Color(0,0,0,0));

        jButton12.setBackground(new java.awt.Color(255, 0, 0));
        jButton12.setForeground(new java.awt.Color(118, 35, 35));
        jButton12.setText("Cancel");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton12);
        jButton12.setBounds(20, 200, 70, 15);
        jButton12.setVisible(false);

        jTextField19.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField19FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField19FocusLost(evt);
            }
        });
        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField19KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField19KeyTyped(evt);
            }
        });
        jPanel15.add(jTextField19);
        jTextField19.setBounds(130, 30, 50, 22);

        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("p");
        jPanel15.add(jLabel43);
        jLabel43.setBounds(70, 17, 20, 14);

        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setText("q");
        jPanel15.add(jLabel44);
        jLabel44.setBounds(140, 17, 20, 14);

        jTextField20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField20FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField20FocusLost(evt);
            }
        });
        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField20KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField20KeyTyped(evt);
            }
        });
        jPanel15.add(jTextField20);
        jTextField20.setBounds(260, 30, 50, 22);

        jTextField21.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField21FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField21FocusLost(evt);
            }
        });
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField21KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField21KeyTyped(evt);
            }
        });
        jPanel15.add(jTextField21);
        jTextField21.setBounds(190, 30, 60, 22);

        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setText("d_p");
        jPanel15.add(jLabel45);
        jLabel45.setBounds(200, 17, 30, 14);

        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setText("d_q");
        jPanel15.add(jLabel46);
        jLabel46.setBounds(270, 17, 30, 14);

        jTextField22.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField22FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField22FocusLost(evt);
            }
        });
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField22KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField22KeyTyped(evt);
            }
        });
        jPanel15.add(jTextField22);
        jTextField22.setBounds(320, 30, 50, 22);

        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setText("q_INV");
        jPanel15.add(jLabel47);
        jLabel47.setBounds(330, 17, 50, 14);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_32x32.png"))); // NOI18N
        jLabel51.setText("jLabel27");
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel51MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel51MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel51MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel51MouseReleased(evt);
            }
        });
        jPanel15.add(jLabel51);
        jLabel51.setBounds(70, 120, 40, 40);

        jPanel30.add(jPanel15);
        jPanel15.setBounds(420, 340, 390, 300);
        jPanel15.setBackground(new java.awt.Color(19, 19, 24,150));

        jPanel11.setBackground(new java.awt.Color(19, 19, 24));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(null);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(184, 46, 46));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Préparation de clés");
        jPanel11.add(jLabel32);
        jLabel32.setBounds(0, 0, 150, 20);
        jLabel23.setVisible(false);

        jPanel13.setBackground(new java.awt.Color(33, 32, 34));
        jPanel13.setLayout(null);

        jTextField8.setEditable(false);
        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField8FocusLost(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel13.add(jTextField8);
        jTextField8.setBounds(10, 70, 124, 22);

        jTextField7.setEditable(false);
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel13.add(jTextField7);
        jTextField7.setBounds(140, 70, 124, 22);

        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("q");
        jPanel13.add(jLabel27);
        jLabel27.setBounds(180, 50, 20, 14);

        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setText("p");
        jPanel13.add(jLabel34);
        jLabel34.setBounds(50, 50, 20, 14);

        jTextField10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField10FocusLost(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });
        jPanel13.add(jTextField10);
        jTextField10.setBounds(90, 13, 40, 22);

        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("nbr bits");
        jPanel13.add(jLabel31);
        jLabel31.setBounds(92, 0, 50, 14);

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setForeground(new java.awt.Color(153, 153, 153));
        jButton7.setText("Generer q");
        jButton7.setAlignmentY(0.0F);
        jButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton7);
        jButton7.setBounds(140, 10, 80, 30);

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setForeground(new java.awt.Color(153, 153, 153));
        jButton8.setText("Generer p");
        jButton8.setAlignmentY(0.0F);
        jButton8.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton8);
        jButton8.setBounds(10, 10, 80, 30);

        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });
        jPanel13.add(jTextField11);
        jTextField11.setBounds(220, 13, 40, 22);

        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("nbr bits");
        jPanel13.add(jLabel33);
        jLabel33.setBounds(222, 0, 50, 14);

        jTextField9.setBackground(new java.awt.Color(39, 38, 41));
        jTextField9.setForeground(new java.awt.Color(51, 153, 255));
        jTextField9.setBorder(null);
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField9FocusLost(evt);
            }
        });
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField9MouseEntered(evt);
            }
        });
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jPanel13.add(jTextField9);
        jTextField9.setBounds(140, 40, 140, 14);
        //jTextField3.setBackground(new Color(0,0,0,0));

        jTextField12.setBackground(new java.awt.Color(39, 38, 41));
        jTextField12.setForeground(new java.awt.Color(51, 153, 255));
        jTextField12.setBorder(null);
        jTextField12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField12FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField12FocusLost(evt);
            }
        });
        jTextField12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField12MouseEntered(evt);
            }
        });
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel13.add(jTextField12);
        jTextField12.setBounds(0, 40, 140, 14);
        //jTextField3.setBackground(new Color(0,0,0,0));

        jButton9.setBackground(new java.awt.Color(255, 0, 0));
        jButton9.setForeground(new java.awt.Color(118, 35, 35));
        jButton9.setText("Cancel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton9);
        jButton9.setBounds(140, 0, 70, 15);
        jButton9.setVisible(false);

        jButton10.setBackground(new java.awt.Color(255, 0, 0));
        jButton10.setForeground(new java.awt.Color(118, 35, 35));
        jButton10.setText("Cancel");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton10);
        jButton10.setBounds(15, 0, 70, 15);
        jButton10.setVisible(false);

        jPanel11.add(jPanel13);
        jPanel13.setBounds(50, 30, 275, 100);
        //jPanel13.setBackground(new java.awt.Color(19, 19, 24,150));

        jTextField13.setEditable(false);
        jTextField13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField13ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField13);
        jTextField13.setBounds(90, 140, 230, 22);

        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("bits");
        jPanel11.add(jLabel36);
        jLabel36.setBounds(210, 170, 30, 14);

        jPanel14.setBackground(new java.awt.Color(33, 32, 37));
        jPanel14.setLayout(null);

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(153, 153, 153));
        jButton5.setText("Calculer d");
        jButton5.setAlignmentY(0.0F);
        jButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton5);
        jButton5.setBounds(192, 45, 70, 30);

        jTextField14.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField14FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField14FocusLost(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField14KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });
        jPanel14.add(jTextField14);
        jTextField14.setBounds(220, 13, 40, 22);

        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("nbr bits");
        jPanel14.add(jLabel37);
        jLabel37.setBounds(220, 0, 50, 14);

        jTextField15.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField15FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField15FocusLost(evt);
            }
        });
        jPanel14.add(jTextField15);
        jTextField15.setBounds(30, 13, 120, 22);

        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setText("e = ");
        jPanel14.add(jLabel38);
        jLabel38.setBounds(10, 13, 30, 20);

        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("d = ");
        jPanel14.add(jLabel39);
        jLabel39.setBounds(10, 50, 30, 20);

        jTextField16.setEditable(false);
        jTextField16.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField16FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField16FocusLost(evt);
            }
        });
        jPanel14.add(jTextField16);
        jTextField16.setBounds(30, 50, 160, 22);

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setForeground(new java.awt.Color(153, 153, 153));
        jButton6.setText("generer e");
        jButton6.setAlignmentY(0.0F);
        jButton6.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton6);
        jButton6.setBounds(150, 10, 70, 30);

        jPanel11.add(jPanel14);
        jPanel14.setBounds(50, 190, 270, 90);

        jTextField23.setEditable(false);
        jTextField23.setBackground(new java.awt.Color(37, 36, 36));
        jTextField23.setForeground(new java.awt.Color(255, 255, 255));
        jTextField23.setBorder(null);
        jTextField23.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField23FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField23FocusLost(evt);
            }
        });
        jPanel11.add(jTextField23);
        jTextField23.setBounds(140, 166, 65, 20);

        jLabel48.setForeground(new java.awt.Color(102, 102, 102));
        jLabel48.setText("N =");
        jPanel11.add(jLabel48);
        jLabel48.setBounds(60, 140, 30, 14);

        jLabel49.setForeground(new java.awt.Color(102, 102, 102));
        jLabel49.setText("N est de ");
        jPanel11.add(jLabel49);
        jLabel49.setBounds(90, 170, 60, 14);

        jPanel30.add(jPanel11);
        jPanel11.setBounds(20, 20, 360, 300);
        jPanel11.setBackground(new java.awt.Color(19, 19, 24,150));

        jPanel9.setBackground(new java.awt.Color(19, 19, 24));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(null);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel29MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel29MouseReleased(evt);
            }
        });
        jPanel9.add(jLabel29);
        jLabel29.setBounds(70, 220, 30, 30);
        jLabel29.setVisible(false);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea3FocusLost(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea3);

        jPanel9.add(jScrollPane3);
        jScrollPane3.setBounds(110, 170, 260, 100);

        jTextArea4.setColumns(20);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setWrapStyleWord(true);
        jTextArea4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea4FocusLost(evt);
            }
        });
        jTextArea4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea4KeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(jTextArea4);

        jPanel9.add(jScrollPane4);
        jScrollPane4.setBounds(110, 60, 260, 100);

        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel9.add(jTextField2);
        jTextField2.setBounds(110, 30, 124, 22);

        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Clé privé:");
        jPanel9.add(jLabel18);
        jLabel18.setBounds(50, 30, 60, 14);

        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Texte chiffré");
        jPanel9.add(jLabel19);
        jLabel19.setBounds(30, 80, 70, 14);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(184, 46, 46));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Dechiffrement");
        jPanel9.add(jLabel24);
        jLabel24.setBounds(0, 0, 120, 20);
        jLabel23.setVisible(false);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(153, 153, 153));
        jButton2.setText("Dechiffrer");
        jButton2.setAlignmentY(0.0F);
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton2);
        jButton2.setBounds(10, 170, 90, 30);

        jTextField4.setBackground(new java.awt.Color(39, 38, 41));
        jTextField4.setForeground(new java.awt.Color(51, 153, 255));
        jTextField4.setBorder(null);
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField4MouseEntered(evt);
            }
        });
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel9.add(jTextField4);
        jTextField4.setBounds(110, 270, 270, 13);
        //jTextField4.setBackground(new Color(0,0,0,0));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setForeground(new java.awt.Color(118, 35, 35));
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton4);
        jButton4.setBounds(20, 200, 70, 15);
        jButton4.setVisible(false);

        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel9.add(jTextField6);
        jTextField6.setBounds(240, 30, 124, 22);

        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("N");
        jPanel9.add(jLabel25);
        jLabel25.setBounds(150, 14, 20, 14);

        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("d");
        jPanel9.add(jLabel26);
        jLabel26.setBounds(280, 14, 20, 14);

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_32x32.png"))); // NOI18N
        jLabel50.setText("jLabel27");
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel50MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel50MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel50MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel50MouseReleased(evt);
            }
        });
        jPanel9.add(jLabel50);
        jLabel50.setBounds(70, 120, 40, 40);

        jPanel30.add(jPanel9);
        jPanel9.setBounds(20, 340, 390, 300);
        jPanel9.setBackground(new java.awt.Color(19, 19, 24,150));

        jPanel8.setBackground(new java.awt.Color(19, 19, 24));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(null);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel28MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel28MouseReleased(evt);
            }
        });
        jPanel8.add(jLabel28);
        jLabel28.setBounds(70, 230, 30, 30);
        jLabel28.setVisible(false);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea2FocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        jPanel8.add(jScrollPane2);
        jScrollPane2.setBounds(110, 170, 280, 100);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(110, 60, 280, 100);
        jScrollPane1.getAccessibleContext().setAccessibleName("");

        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel8.add(jTextField5);
        jTextField5.setBounds(240, 30, 124, 22);

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel8.add(jTextField1);
        jTextField1.setBounds(110, 30, 124, 22);

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("e");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(280, 14, 20, 14);

        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Texte Claire");
        jPanel8.add(jLabel17);
        jLabel17.setBounds(30, 80, 70, 14);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(184, 46, 46));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Chiffrement");
        jPanel8.add(jLabel23);
        jLabel23.setBounds(0, 0, 120, 20);
        jLabel23.setVisible(true);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Chiffrer");
        jButton1.setAlignmentY(0.0F);
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1);
        jButton1.setBounds(10, 170, 90, 30);

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setForeground(new java.awt.Color(118, 35, 35));
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3);
        jButton3.setBounds(20, 200, 70, 15);
        jButton3.setVisible(false);

        jTextField3.setBackground(new java.awt.Color(39, 38, 41));
        jTextField3.setForeground(new java.awt.Color(51, 153, 255));
        jTextField3.setBorder(null);
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField3MouseEntered(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel8.add(jTextField3);
        jTextField3.setBounds(110, 270, 290, 14);
        //jTextField3.setBackground(new Color(0,0,0,0));

        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Clé publique:");
        jPanel8.add(jLabel20);
        jLabel20.setBounds(40, 30, 80, 14);

        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("N");
        jPanel8.add(jLabel21);
        jLabel21.setBounds(150, 14, 20, 14);

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_32x32.png"))); // NOI18N
        jLabel35.setText("jLabel27");
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel35MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel35MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel35MouseReleased(evt);
            }
        });
        jPanel8.add(jLabel35);
        jLabel35.setBounds(70, 120, 40, 40);

        jPanel30.add(jPanel8);
        jPanel8.setBounds(390, 20, 410, 300);
        jPanel8.setBackground(new java.awt.Color(19, 19, 24,150));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel30.add(jLabel4);
        jLabel4.setBounds(805, 280, 64, 64);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background/privacy-security-lock-ss-1920.jpg"))); // NOI18N
        jPanel30.add(jLabel2);
        jLabel2.setBounds(-380, -70, 1340, 1060);

        jPanel1.add(jPanel30);
        jPanel30.setBounds(70, 30, 880, 660);

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(70, 0, 170, 10);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText(" X");
        jLabel1.setOpaque(true);
        jLabel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jLabel1FocusLost(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(914, 11, 21, -1));

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel15MouseDragged(evt);
            }
        });
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 800, 40));

        jPanel3.setBackground(new java.awt.Color(47, 31, 47));
        jPanel3.setMaximumSize(new java.awt.Dimension(4, 32767));
        jPanel3.setMinimumSize(new java.awt.Dimension(4, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(4, 37));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 945, 4));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 945, 0));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("CRYPTO");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home icon/32x32/ddd_32x32.png"))); // NOI18N
        jLabel3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel3.setDoubleBuffered(true);
        jLabel3.setFocusable(false);
        jLabel3.setInheritsPopupMenu(false);
        jLabel3.setRequestFocusEnabled(false);
        jLabel3.setVerifyInputWhenFocusTarget(false);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 2, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(101, 93, 128));
        jLabel22.setText("Cryptosystème RSA");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 12, -1, -1));

        jPanel7.setBackground(new java.awt.Color(22, 21, 27));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 943, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 659, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
      
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MouseClicked
           // TODO add your handling code here:
    }//GEN-LAST:event_jPanel30MouseClicked

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64_3.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64.png")));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64_4.png")));
        jLabel4.updateUI();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        menuModernCrypto fram = new menuModernCrypto();
        fram.setVisible(true);
        fram.setLocation(this.getLocation());
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseReleased
        jLabel16.setBackground(new java.awt.Color(49, 49, 83));

        jLabel16.setForeground(new java.awt.Color(96, 94, 124));
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseReleased

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
       
jLabel16.setBackground(new java.awt.Color(32, 32, 47));

jLabel16.setForeground(new java.awt.Color(130, 122, 122));

jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));

    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        jLabel16.setBackground(new java.awt.Color(49, 49, 83));

        jLabel16.setForeground(new java.awt.Color(96, 94, 124));
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseReleased
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        jLabel14.setBackground(new java.awt.Color(49, 49, 83));

        jLabel14.setForeground(new java.awt.Color(96, 94, 124));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseReleased

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
       
jLabel14.setBackground(new java.awt.Color(32, 32, 47));

jLabel14.setForeground(new java.awt.Color(130, 122, 122));

jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));

    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        jLabel14.setBackground(new java.awt.Color(49, 49, 83));

        jLabel14.setForeground(new java.awt.Color(96, 94, 124));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseReleased
        jLabel13.setBackground(new java.awt.Color(49, 49, 83));

        jLabel13.setForeground(new java.awt.Color(96, 94, 124));
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseReleased

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
       
jLabel13.setBackground(new java.awt.Color(32, 32, 47));

jLabel13.setForeground(new java.awt.Color(130, 122, 122));

jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));

    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        jLabel13.setBackground(new java.awt.Color(49, 49, 83));

        jLabel13.setForeground(new java.awt.Color(96, 94, 124));
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseReleased
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        jLabel12.setBackground(new java.awt.Color(49, 49, 83));

        jLabel12.setForeground(new java.awt.Color(96, 94, 124));            // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseReleased

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        jLabel12.setBackground(new java.awt.Color(49, 49, 43));

        jLabel12.setForeground(new java.awt.Color(96, 94, 100));

        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
       
jLabel12.setBackground(new java.awt.Color(32, 32, 47));

jLabel12.setForeground(new java.awt.Color(130, 122, 122));

jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));

    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        jLabel12.setBackground(new java.awt.Color(49, 49, 83));

        jLabel12.setForeground(new java.awt.Color(96, 94, 124));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseReleased
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        jLabel11.setBackground(new java.awt.Color(49, 49, 83));

        jLabel11.setForeground(new java.awt.Color(96, 94, 124));           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseReleased

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        jLabel11.setBackground(new java.awt.Color(49, 49, 43));

        jLabel11.setForeground(new java.awt.Color(96, 94, 100));

        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MousePressed

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
       
jLabel11.setBackground(new java.awt.Color(32, 32, 47));

jLabel11.setForeground(new java.awt.Color(130, 122, 122));

jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));

    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        jLabel11.setBackground(new java.awt.Color(49, 49, 83));

        jLabel11.setForeground(new java.awt.Color(96, 94, 124));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
        jLabel10.setBackground(new java.awt.Color(49, 49, 83));

        jLabel10.setForeground(new java.awt.Color(96, 94, 124));
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseReleased

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        jLabel10.setBackground(new java.awt.Color(49, 49, 43));

        jLabel10.setForeground(new java.awt.Color(96, 94, 100));

        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
       
jLabel10.setBackground(new java.awt.Color(32, 32, 47));

jLabel10.setForeground(new java.awt.Color(130, 122, 122));

jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));

    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered

        jLabel10.setBackground(new java.awt.Color(49, 49, 83));

        jLabel10.setForeground(new java.awt.Color(96, 94, 124));
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        EuclideEtendue fram = new EuclideEtendue ();
      fram.setVisible(true);
      fram.setLocation(this.getLocation());
      this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseReleased
        jLabel8.setBackground(new java.awt.Color(49, 49, 83));

        jLabel8.setForeground(new java.awt.Color(96, 94, 124));

        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseReleased

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        jLabel8.setBackground(new java.awt.Color(49, 49, 43));

        jLabel8.setForeground(new java.awt.Color(96, 94, 100));

        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
     jLabel8.setBackground(new java.awt.Color(32, 32, 47));

jLabel8.setForeground(new java.awt.Color(130, 122, 122));

jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));
 // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered

        jLabel8.setBackground(new java.awt.Color(49, 49, 83));

        jLabel8.setForeground(new java.awt.Color(96, 94, 124));

        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
           SquareAndMultiplayModuloEtude fram = new SquareAndMultiplayModuloEtude();
         fram.setVisible(true);
         fram.setLocation(this.getLocation());
         this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseReleased
        jLabel6.setBackground(new java.awt.Color(49, 49, 83));

        jLabel6.setForeground(new java.awt.Color(96, 94, 124));

        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseReleased

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        jLabel6.setBackground(new java.awt.Color(49, 49, 43));

        jLabel6.setForeground(new java.awt.Color(96, 94, 100));

        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
      jLabel6.setBackground(new java.awt.Color(32, 32, 47));

jLabel6.setForeground(new java.awt.Color(130, 122, 122));


jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered

        jLabel6.setBackground(new java.awt.Color(49, 49, 83));

        jLabel6.setForeground(new java.awt.Color(96, 94, 124));

        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));

        /*jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(127, 93, 167)));*/

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
     SquareAndMultiplay fram = new SquareAndMultiplay();
     fram.setVisible(true);
     this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseReleased
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseReleased

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64_6.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
      if(!menuOpen){
            jPanel10.setVisible(true);
jTextField23.setVisible(false);
jTextField13.setVisible(false);
jPanel13.setVisible(false);
jPanel14.setVisible(false);
jTextField2.setVisible(false);

jButton2.setVisible(false);


jTextArea4.setVisible(false);

jTextArea3.setVisible(false);





            transitionAnnimSwing worker = new transitionAnnimSwing(jPanel10,200,30,-jPanel10.getWidth(),0,0,0);
            worker.execute();
            menuOpen = true;
        }
        else{
            transitionAnnimSwing worker = new transitionAnnimSwing(jPanel10,200,30,0,0,-jPanel10.getWidth(),0);
            worker.execute();
            
                 jPanel10.setVisible(true);
jTextField23.setVisible(true);
jTextField13.setVisible(true);
jPanel13.setVisible(true);
jPanel14.setVisible(true);
jTextField2.setVisible(true);

jButton2.setVisible(true);


jTextArea4.setVisible(true);

jTextArea3.setVisible(true);

            menuOpen = false;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2FocusGained

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home icon/32x32/53529_32x32.png")));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home icon/32x32/ddd_32x32.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home icon/32x32/home-xxl_32x32.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        mainJfram fram = new mainJfram();
        fram.setVisible(true);

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
      jLabel1.setBackground(new java.awt.Color(102, 102, 102));
jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setBackground(Color.yellow);
        jLabel1.setForeground(new java.awt.Color(255, 155, 5));  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1FocusLost

    private void jLabel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusGained

    }//GEN-LAST:event_jLabel1FocusGained

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        Xmouse=evt.getX();
        Ymouse=evt.getY();
        //           ^>> get the position of the mouse on the jLabel (our container)

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel15MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();

        setLocation(x-Xmouse-140, y-Ymouse);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseDragged

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
this.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jTextArea1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusLost
   this.repaint();      // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1FocusLost

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
       this.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
    this.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_formPropertyChange

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
   this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
      // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}



// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyTyped
Timing timer1; String timer1Str;   // timer 
boolean timer1on ; // timer flag on/of
  boolean onWork = false; // flage explaining that the worker stay work (on work the action can't applied twice )
   SwingWorker<String, Void> mainWorker;
   RSA thisFram = this;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 if(!onWork){
	 BigInteger N = new BigInteger(jTextField1.getText());
         BigInteger e = new BigInteger(jTextField5.getText());
         
jButton3.setVisible(true);
 jLabel28.setVisible(false);
jTextArea2.setText("");

 mainWorker = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() throws InterruptedException {
        timer1on = true;
        onWork = true;
        timer1 = new Timing();
        String result = chiffrementRSA(jTextArea1.getText(), e,N);
        timer1.updateDuration();
        timer1Str = timer1.strTimeUnivMS();
            return result  ;             
        }
         
         @Override
                    public void done()  {
                        
                        timer1on = false;
                        onWork = false;
                        jButton3.setVisible(false);
                        jLabel28.setVisible(true);
                        
            try {
                jTextArea2.setText(get());
            } catch (InterruptedException ex) {
                Logger.getLogger(chifrCesar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(chifrCesar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        jTextField3.setText(timer1Str);
                       thisFram.repaint();
                    }
         };

                   
mainWorker.execute();
             
              

                //////////////////////////////////////////////////////
                SwingWorker<Void, String> worker3
                = new SwingWorker<Void, String>() {

                    @Override
                    public Void doInBackground() throws InterruptedException {
                        Timing tm = new Timing();

                        while(timer1on) // flag to share between threads
                        {
                            Thread.sleep(50);

                            tm.updateDuration();
                            publish(tm.strTimeUnivMS());
                           // thisFram.repaint();
                        }
                        return null; // of type type1
                    }

                    @Override
                    public void done() {
                      
                        jTextField3.setText(timer1Str);
                    thisFram.repaint();
                    }

                    @Override
                    protected void process(final List<String> chunks) {

                        for (final String db : chunks) {
                            if(!this.isCancelled())
                            {
                                
                                jTextField3.setText(db);
                              
                            }

                        }
                    }

                };
                ///////////////////////////////////////////////////////////////////////////////
                worker3.execute();    // !!!!!!!!!!!!!!!!!!!!!!   important
            
                
                

this.repaint();

// do in the code to launch the worker
	 }else {
	 // showing message or something
	 }
        
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextArea2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea2FocusLost
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea2FocusLost

    private void jTextArea3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea3FocusLost
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3FocusLost

    private void jTextArea4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea4FocusLost
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4FocusLost

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped
Timing timer2;   String timer2Str;  // timer 
boolean timer2on ; // timer flag on/of
  boolean onWork2 = false; // flage explaining that the worker stay work (on work the action can't applied twice )

  SwingWorker<String, Void> mainWorker2;

   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if(!onWork2){
	 BigInteger N = new BigInteger(jTextField2.getText()) ;
         BigInteger d = new BigInteger(jTextField6.getText()) ;
         
jButton4.setVisible(true);
  jLabel29.setVisible(false);
jTextArea3.setText("");
  
 mainWorker2 = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() throws InterruptedException {
        timer2on = true;
        onWork2 = true;
        timer2 = new Timing();
        String result = dechiffrementRSA(jTextArea4.getText(), d, N);
        timer2.updateDuration();
        timer2Str = timer2.strTimeUnivMS();
            return result  ;             
        }
         
         @Override
                    public void done()  {
                        
                        timer2on = false;
                        onWork2 = false;
                        jButton4.setVisible(false);
                        jLabel29.setVisible(true);
                        
            try {
                jTextArea3.setText(get());
            } catch (InterruptedException ex) {
                Logger.getLogger(chifrCesar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(chifrCesar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        jTextField4.setText(timer2Str);
                       thisFram.repaint();
                    }
         };

                   
mainWorker2.execute();
             
              

                //////////////////////////////////////////////////////
                SwingWorker<Void, String> worker3
                = new SwingWorker<Void, String>() {

                    @Override
                    public Void doInBackground() throws InterruptedException {
                        Timing tm = new Timing();

                        while(timer2on) // flag to share between threads
                        {
                            Thread.sleep(50);

                            tm.updateDuration();
                            publish(tm.strTimeUnivMS());
                           // thisFram.repaint();
                        }
                        return null; // of type type1
                    }

                    @Override
                    public void done() {
                      
                        jTextField4.setText(timer2Str);
                    thisFram.repaint();
                    }

                    @Override
                    protected void process(final List<String> chunks) {

                        for (final String db : chunks) {
                            if(!this.isCancelled())
                            {
                                
                                jTextField4.setText(db);
                              
                            }

                        }
                    }

                };
                ///////////////////////////////////////////////////////////////////////////////
                worker3.execute();    // !!!!!!!!!!!!!!!!!!!!!!   important
            
                
                

this.repaint();

// do in the code to launch the worker
	 }else {
	 // showing message or something
	 }
        

      // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped


       // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
      // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1KeyReleased

    private void jTextArea4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea4KeyTyped
  // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4KeyTyped

    private void jTextArea4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea4KeyReleased
            // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4KeyReleased

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(jTextArea2.getText());
        clipboard.setContents(strSel, null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
      this.repaint();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
       this.repaint();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseExited

    private void jLabel28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MousePressed
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_2.png"))); // NOI18N
       this.repaint();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MousePressed

    private void jLabel28MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseReleased
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
      this.repaint();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseReleased

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
mainWorker.cancel(true);
timer1on = false;
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseEntered
 this.repaint();       // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3MouseEntered

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
 this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
 this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained
 this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4FocusGained

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
 this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseEntered
 this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4MouseEntered

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(jTextArea3.getText());
        clipboard.setContents(strSel, null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        this.repaint();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseExited

    private void jLabel29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MousePressed
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_2.png"))); // NOI18N
         this.repaint();// TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MousePressed

    private void jLabel29MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseReleased
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        this.repaint(); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
mainWorker2.cancel(true);
timer2on = false;        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusLost

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusLost
this.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusLost

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
BigInteger M = new BigInteger(jTextField8.getText()).subtract(BigInteger.ONE).multiply(new BigInteger(jTextField7.getText()).subtract(BigInteger.ONE));
BigInteger d =  new BigInteger(jTextField15.getText()).modInverse(M);   

jTextField16.setText(d.toString());
jTextField6.setText(d.toString());

jTextField5.setText(jTextField15.getText());

jTextField21.setText(d.mod(new BigInteger(jTextField8.getText()).subtract(BigInteger.ONE)).toString());
jTextField20.setText(d.mod(new BigInteger(jTextField7.getText()).subtract(BigInteger.ONE)).toString());

jTextField22.setText(new BigInteger(jTextField7.getText()).modInverse(new BigInteger(jTextField8.getText())).toString());

// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9FocusGained

    private void jTextField9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9FocusLost

    private void jTextField9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9MouseEntered

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

Timing timer7;   String timer7Str;  // timer 
boolean timer7on ; // timer flag on/of
  boolean onWork7 = false; // flage explaining that the worker stay work (on work the action can't applied twice )

  SwingWorker<String, Void> mainWorker7;
    
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
if(!onWork7){
	 int nbrBits = Integer.parseInt(jTextField11.getText());

jButton9.setVisible(true);
 
jTextField7.setText("");
  
 mainWorker7 = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() throws InterruptedException {
        timer7on = true;
        onWork7 = true;
        timer7 = new Timing();
        String result = ""+ generatePrim(nbrBits, 50);
        timer7.updateDuration();
        timer7Str = timer7.strTimeUnivMS();
            return result  ;             
        }
         
         @Override
                    public void done()  {
                        
                        timer7on = false;
                        onWork7 = false;
                        jButton9.setVisible(false);
                       
                        
            try {
                jTextField7.setText(get());
            } catch (InterruptedException ex) {
                Logger.getLogger(chifrCesar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(chifrCesar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(! jTextField8.getText().equals("")){
                String N_Str =new BigInteger(jTextField8.getText()).multiply(new BigInteger(jTextField7.getText())).toString();
                
                jTextField13.setText(N_Str);
                jTextField1.setText(N_Str);
                jTextField2.setText(N_Str);               

                
                jTextField17.setText(jTextField8.getText());// p 
                jTextField19.setText(jTextField7.getText());// q
                
  jTextField23.setText(""+new BigInteger(N_Str).bitLength());
            }
                        jTextField9.setText(timer7Str);
                       thisFram.repaint();
                    }
         };

                   
mainWorker7.execute();
             
              

                //////////////////////////////////////////////////////
                SwingWorker<Void, String> worker3
                = new SwingWorker<Void, String>() {

                    @Override
                    public Void doInBackground() throws InterruptedException {
                        Timing tm = new Timing();

                        while(timer7on) // flag to share between threads
                        {
                            Thread.sleep(50);

                            tm.updateDuration();
                            publish(tm.strTimeUnivMS());
                           // thisFram.repaint();
                        }
                        return null; // of type type1
                    }

                    @Override
                    public void done() {
                      
                        jTextField9.setText(timer7Str);
                    thisFram.repaint();
                    }

                    @Override
                    protected void process(final List<String> chunks) {

                        for (final String db : chunks) {
                            if(!this.isCancelled())
                            {
                                
                                jTextField9.setText(db);
                              
                            }

                        }
                    }

                };
                ///////////////////////////////////////////////////////////////////////////////
                worker3.execute();    // !!!!!!!!!!!!!!!!!!!!!!   important
            
                
                

this.repaint();

// do in the code to launch the worker
	 }else {
	 // showing message or something
	 }
                      // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusLost
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10FocusLost

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
                        
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}

    
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyTyped
Timing timer8;   String timer8Str;  // timer 
boolean timer8on ; // timer flag on/of
  boolean onWork8 = false; // flage explaining that the worker stay work (on work the action can't applied twice )

  SwingWorker<String, Void> mainWorker8;

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
if(!onWork8){
	 int nbrBits = Integer.parseInt(jTextField10.getText());

jButton10.setVisible(true);
 
jTextField8.setText("");
  
 mainWorker8 = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() throws InterruptedException {
        timer8on = true;
        onWork8 = true;
        timer8 = new Timing();
        String result = ""+ generatePrim(nbrBits, 50);
        timer8.updateDuration();
        timer8Str = timer8.strTimeUnivMS();
            return result  ;             
        }
         
         @Override
                    public void done()  {
                        
                        timer8on = false;
                        onWork8 = false;
                        jButton10.setVisible(false);
                       
                        
            try {
                jTextField8.setText(get());
            } catch (InterruptedException ex) {
                Logger.getLogger(chifrCesar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(chifrCesar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
               if(! jTextField7.getText().equals("")){
                String N_Str =new BigInteger(jTextField8.getText()).multiply(new BigInteger(jTextField7.getText())).toString();
                
                jTextField13.setText(N_Str);
                jTextField1.setText(N_Str);
                jTextField2.setText(N_Str);               

                jTextField17.setText(jTextField8.getText());// p 
                jTextField19.setText(jTextField7.getText());// q

                jTextField23.setText(""+new BigInteger(N_Str).bitLength());
            }
                        jTextField12.setText(timer8Str);
                       thisFram.repaint();
                    }
         };

                   
mainWorker8.execute();
             
              

                //////////////////////////////////////////////////////
                SwingWorker<Void, String> worker3
                = new SwingWorker<Void, String>() {

                    @Override
                    public Void doInBackground() throws InterruptedException {
                        Timing tm = new Timing();

                        while(timer8on) // flag to share between threads
                        {
                            Thread.sleep(50);

                            tm.updateDuration();
                            publish(tm.strTimeUnivMS());
                           // thisFram.repaint();
                        }
                        return null; // of type type1
                    }

                    @Override
                    public void done() {
                      
                        jTextField12.setText(timer8Str);
                    thisFram.repaint();
                    }

                    @Override
                    protected void process(final List<String> chunks) {

                        for (final String db : chunks) {
                            if(!this.isCancelled())
                            {
                                
                                jTextField12.setText(db);
                              
                            }

                        }
                    }

                };
                ///////////////////////////////////////////////////////////////////////////////
                worker3.execute();    // !!!!!!!!!!!!!!!!!!!!!!   important
            
                
                

this.repaint();

// do in the code to launch the worker
	 }else {
	 // showing message or something
	 }
              
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusLost

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12FocusGained

    private void jTextField12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12FocusLost

    private void jTextField12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12MouseEntered

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField13ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
mainWorker7.cancel(true);
timer7on = false;             // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
mainWorker8.cancel(true);   
timer8on =false;
// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextField14FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField14FocusLost
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14FocusLost

    private void jTextField14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14KeyReleased

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}             // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14KeyTyped

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseExited

    private void jLabel30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MousePressed

    private void jLabel30MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseReleased

    private void jTextArea5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea5FocusLost
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea5FocusLost

    private void jTextArea6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea6FocusLost
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea6FocusLost

    private void jTextArea6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea6KeyReleased

    private void jTextArea6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea6KeyTyped

    private void jTextField17FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField17FocusLost
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17FocusLost

    private void jTextField17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17KeyReleased

    private void jTextField17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyTyped
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17KeyTyped
Timing timer11;   String timer11Str;  // timer 
boolean timer11on ; // timer flag on/of
  boolean onWork11 = false; // flage explaining that the worker stay work (on work the action can't applied twice )

  SwingWorker<String, Void> mainWorker11;
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
if(!onWork11){
	 BigInteger p = new BigInteger(jTextField17.getText()) ;
         BigInteger q = new BigInteger(jTextField19.getText()) ;
         BigInteger d_p = new BigInteger(jTextField21.getText()) ;
         BigInteger d_q = new BigInteger(jTextField20.getText()) ;
         BigInteger qINV = new BigInteger(jTextField22.getText()) ;
         
jButton12.setVisible(true);
  jLabel30.setVisible(false);
jTextArea5.setText("");
  
 mainWorker11 = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() throws InterruptedException {
        timer11on = true;
        onWork11 = true;
        timer11 = new Timing();
        String result = dechiffrementRSA_CRT(jTextArea6.getText(),p,q,d_p,d_q,qINV);
        timer11.updateDuration();
        timer11Str = timer11.strTimeUnivMS();
            return result  ;             
        }
         
         @Override
                    public void done()  {
                        
                        timer11on = false;
                        onWork11 = false;
                        jButton12.setVisible(false);
                        jLabel30.setVisible(true);
                        
            try {
                jTextArea5.setText(get());
            } catch (InterruptedException ex) {
                Logger.getLogger(chifrCesar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(chifrCesar.class.getName()).log(Level.SEVERE, null, ex);
            }
                        jTextField18.setText(timer11Str);
                       thisFram.repaint();
                    }
         };

                   
mainWorker11.execute();
             
              

                //////////////////////////////////////////////////////
                SwingWorker<Void, String> worker3
                = new SwingWorker<Void, String>() {

                    @Override
                    public Void doInBackground() throws InterruptedException {
                        Timing tm = new Timing();

                        while(timer11on) // flag to share between threads
                        {
                            Thread.sleep(50);

                            tm.updateDuration();
                            publish(tm.strTimeUnivMS());
                           // thisFram.repaint();
                        }
                        return null; // of type type1
                    }

                    @Override
                    public void done() {
                      
                        jTextField18.setText(timer11Str);
                    thisFram.repaint();
                    }

                    @Override
                    protected void process(final List<String> chunks) {

                        for (final String db : chunks) {
                            if(!this.isCancelled())
                            {
                                
                                jTextField18.setText(db);
                              
                            }

                        }
                    }

                };
                ///////////////////////////////////////////////////////////////////////////////
                worker3.execute();    // !!!!!!!!!!!!!!!!!!!!!!   important
            
                
                

this.repaint();

// do in the code to launch the worker
	 }else {
	 // showing message or something
	 }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField18FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField18FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18FocusGained

    private void jTextField18FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField18FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18FocusLost

    private void jTextField18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField18MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18MouseEntered

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
mainWorker11.cancel(true);
timer11on = false;          // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField19FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField19FocusLost
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19FocusLost

    private void jTextField19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19KeyReleased

    private void jTextField19KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyTyped
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19KeyTyped

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jTextField20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField20FocusLost
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20FocusLost

    private void jTextField20KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20KeyReleased

    private void jTextField20KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyTyped
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20KeyTyped

    private void jTextField21FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField21FocusLost
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21FocusLost

    private void jTextField21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21KeyReleased

    private void jTextField21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyTyped
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21KeyTyped

    private void jTextField22FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField22FocusLost
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22FocusLost

    private void jTextField22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22KeyReleased

    private void jTextField22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyTyped
char c = evt.getKeyChar();

if(!( Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22KeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
BigInteger M = new BigInteger(jTextField8.getText()).subtract(BigInteger.ONE).multiply(new BigInteger(jTextField7.getText()).subtract(BigInteger.ONE));
   int bitsLength = Integer.parseInt(jTextField14.getText());  
   
if(bitsLength<M.bitLength()){
       BigInteger  e = generatePrimeWith(bitsLength, M );
       while(e.compareTo(M)>=0)
           e = generatePrimeWith(bitsLength, M  );
jTextField15.setText(e.toString());
}     
// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusGained

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusGained

    private void jTextField10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10FocusGained

    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusGained

    private void jTextField23FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField23FocusLost
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23FocusLost

    private void jTextField23FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField23FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23FocusGained

    private void jTextField15FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField15FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15FocusGained

    private void jTextField15FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField15FocusLost
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15FocusLost

    private void jTextField14FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField14FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14FocusGained

    private void jTextField16FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField16FocusLost
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16FocusLost

    private void jTextField16FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField16FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16FocusGained

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5FocusGained

    private void jTextArea1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1FocusGained

    private void jTextArea2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea2FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea2FocusGained

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained
this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusGained

    private void jTextArea4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea4FocusGained
this.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4FocusGained

    private void jTextArea3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea3FocusGained
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3FocusGained

    private void jTextField17FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField17FocusGained
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17FocusGained

    private void jTextField19FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField19FocusGained
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField19FocusGained

    private void jTextField21FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField21FocusGained
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21FocusGained

    private void jTextField20FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField20FocusGained
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20FocusGained

    private void jTextField22FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField22FocusGained
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22FocusGained

    private void jTextArea6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea6FocusGained
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea6FocusGained

    private void jTextArea5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea5FocusGained
this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea5FocusGained

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        jTextArea1.setText(getClipboardContents());        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_2_32x32.png"))); // NOI18N
        this.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseEntered

    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_32x32.png"))); // NOI18N
        this.repaint();      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseExited

    private void jLabel35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MousePressed
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_3_32x32.png"))); // NOI18N
        this.repaint();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MousePressed

    private void jLabel35MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseReleased
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_2_32x32.png")));
        this.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseReleased

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        jTextArea4.setText(getClipboardContents());        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel50MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseEntered
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_2_32x32.png"))); // NOI18N
        this.repaint();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseEntered

    private void jLabel50MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseExited
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_32x32.png"))); // NOI18N
        this.repaint();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseExited

    private void jLabel50MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MousePressed
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_3_32x32.png"))); // NOI18N
        this.repaint();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MousePressed

    private void jLabel50MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseReleased
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_2_32x32.png")));
        this.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseReleased

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        jTextArea6.setText(getClipboardContents());        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jLabel51MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseEntered
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_2_32x32.png"))); // NOI18N
        this.repaint();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MouseEntered

    private void jLabel51MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseExited
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_32x32.png"))); // NOI18N
        this.repaint();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MouseExited

    private void jLabel51MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MousePressed
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_3_32x32.png"))); // NOI18N
        this.repaint();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MousePressed

    private void jLabel51MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseReleased
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_2_32x32.png")));
        this.repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MouseReleased

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
      InverseModulaire fram = new InverseModulaire();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
 testDePrimality fram = new testDePrimality();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
 generationDeNombrePremier fram = new generationDeNombrePremier();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
  decBinaireConvesion1 fram = new decBinaireConvesion1();
 fram.setVisible(true);
 fram.setLocation(this.getLocation());
 this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        decBinaireConvesion fram = new decBinaireConvesion();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    

    
    
    
    Dimension jl6Dimension1 = new Dimension();
Dimension jl9Dimension1 = new Dimension();
Dimension jl8Dimension1 = new Dimension();

Point jL6LocationInitial= new Point();
Point jL9LocationInitial= new Point();

Point jL8LocationInitial= new Point();

int Xmouse;
int Ymouse;
    boolean menuOpen=false;boolean setToLooseFocusByClick= false;


  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainJfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainJfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainJfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainJfram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainJfram().setVisible(true);
            }
        });
        
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
