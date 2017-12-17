
        
        
        
        
        
        
        
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
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import static java.time.Clock.system;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ABS
 */


public class generationDeNombrePremier extends javax.swing.JFrame {

    /**
     * Creates new form mainJfram
     */
    public generationDeNombrePremier() {
        initComponents();
                
        Rectangle rect=new Rectangle(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        // that, give the available screen space (width and height (without counting the task bar)) 
        setLocation((int)(rect.getWidth()-getWidth())/2, (int)(rect.getHeight()-getHeight())/2); //seting the location of the jFram to be centred
        //                                       ^                                      ^
        //                                 width of the jfram                  height of the jfram
     
        
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
              cpn=(JPanel) db;   // very important it work well even like this cool
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







Boolean timerOn ;


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class annimate4SquareWorker extends SwingWorker<Void, JPanel> {
            JPanel p1;  java.awt.Color clr1;
            JPanel p2;  java.awt.Color clr2;
            JPanel p3;  java.awt.Color clr3;
            JPanel p4;  java.awt.Color clr4;
            long timeIntervale; 
    
    public annimate4SquareWorker ( JPanel P1, JPanel P2, JPanel P3, JPanel P4,  long timeIntervaleMS)
    {
             p1=P1;
             p2=P2;
             p3=P3;
             p4=P4;
             
             clr1=p1.getBackground();
             clr2=p2.getBackground();
             clr3=p3.getBackground();
             clr4=p4.getBackground();
             
             timeIntervale = timeIntervaleMS;
    }
    
    @Override
       public Void doInBackground() throws InterruptedException {
      
      p1.setBackground(clr1);
      p2.setBackground(clr2); 
      p3.setBackground(clr3);
      p4.setBackground(clr4);
      
      while(!Thread.currentThread().isInterrupted()){
      //1
      p2.setBackground(clr1);
      p3.setBackground(clr2); 
      p4.setBackground(clr3);
      p1.setBackground(clr4);
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
            
  
     Thread.sleep(timeIntervale); 
  //2
      p3.setBackground(clr1);
      p4.setBackground(clr2); 
      p1.setBackground(clr3);
      p2.setBackground(clr4);    
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
       
     Thread.sleep(timeIntervale); 
      
     //3
      p4.setBackground(clr1);
      p1.setBackground(clr2); 
      p2.setBackground(clr3);
      p3.setBackground(clr4);    
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
        
     Thread.sleep(timeIntervale);
      
      //4
      p1.setBackground(clr1);
      p2.setBackground(clr2); 
      p3.setBackground(clr3);
      p4.setBackground(clr4);    
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
     
     Thread.sleep(timeIntervale);
      }
        
      return null;
       } 
       
       

     
       
        @Override
  protected void process(final List<JPanel> chunks) {
   
	for (int i=0;i<chunks.size();i++) {
            if(!this.isCancelled())
            { if(i%4==0)
              p1= chunks.get(i);
            else if(i%4==1)
              p2= chunks.get(i);
            else if(i%4==2)
              p3= chunks.get(i);
            else if(i%4==3)
              p4= chunks.get(i);
            }
            
    }
	
  }
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////
 



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class annimate4SquareWorker2 extends SwingWorker<Void, JPanel> {
            JPanel p1;  java.awt.Color clr1;
            JPanel p2;  java.awt.Color clr2;
            JPanel p3;  java.awt.Color clr3;
            JPanel p4;  java.awt.Color clr4;
            long timeIntervale; 
    
    public annimate4SquareWorker2 ( JPanel P1, JPanel P2, JPanel P3, JPanel P4,  long timeIntervaleMS)
    {
             p1=P1;
             p2=P2;
             p3=P3;
             p4=P4;
             
             clr1=p1.getBackground();
             clr2=p2.getBackground();
             clr3=p3.getBackground();
             clr4=p4.getBackground();
             
             timeIntervale = timeIntervaleMS;
    }
    
    @Override
       public Void doInBackground() throws InterruptedException {
        while(onWork2){
      p1.setBackground(clr1);
      p2.setBackground(clr2); 
      p3.setBackground(clr3);
      p4.setBackground(clr4);
      
      while(!this.isCancelled()){
      //1
      p2.setBackground(clr1);
      p3.setBackground(clr2); 
      p4.setBackground(clr3);
      p1.setBackground(clr4);
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
            
  
     Thread.sleep(timeIntervale); 
  //2
      p3.setBackground(clr1);
      p4.setBackground(clr2); 
      p1.setBackground(clr3);
      p2.setBackground(clr4);    
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
       
     Thread.sleep(timeIntervale); 
      
     //3
      p4.setBackground(clr1);
      p1.setBackground(clr2); 
      p2.setBackground(clr3);
      p3.setBackground(clr4);    
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
        
     Thread.sleep(timeIntervale);
      
      //4
      p1.setBackground(clr1);
      p2.setBackground(clr2); 
      p3.setBackground(clr3);
      p4.setBackground(clr4);    
      publish(p1);
       publish(p2);
        publish(p3);
         publish(p4);
     
     Thread.sleep(timeIntervale);
      }
        }
      return null;
       } 
       
       

     
       
        @Override
  protected void process(final List<JPanel> chunks) {
   
	for (int i=0;i<chunks.size();i++) {
            if(!this.isCancelled())
            { if(i%4==0)
              p1= chunks.get(i);
            else if(i%4==1)
              p2= chunks.get(i);
            else if(i%4==2)
              p3= chunks.get(i);
            else if(i%4==3)
              p4= chunks.get(i);
            }
            
    }
	
  }
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////
 









BigInteger modPowSM(BigInteger a, BigInteger b, BigInteger m) 
{
  String bBinaryStr = b.toString(2); // 2 pour dire en base 2
      BigInteger aPOWb= BigInteger.valueOf(1); //aPOWb = 1
      for(int i=0; i<bBinaryStr.length()&& !Thread.currentThread().isInterrupted();i++)   // pour i parcourant toute la chaine de la représentation binaire de b
      {
          if(bBinaryStr.charAt(i)=='1') // si le bit est 1 alors SM
          {
          aPOWb= aPOWb.multiply(aPOWb);  // squar
          aPOWb=aPOWb.mod(m); //  reduir aPOWb modulo m
           aPOWb= aPOWb.multiply(a); // multiply
            aPOWb=aPOWb.mod(m); //  reduir aPOWb modulo m
          }
          else  //sinon 0 et donc squar
          {
                aPOWb= aPOWb.multiply(aPOWb);
               aPOWb=aPOWb.mod(m); //  reduir aPOWb modulo m
          } 
      }
return aPOWb; // en sortie le BigInteger qui represente a^b
}


BigInteger powSM(BigInteger a, BigInteger b) 
{
  String bBinaryStr = b.toString(2); // 2 pour dire en base 2
      BigInteger aPOWb= BigInteger.valueOf(1); //aPOWb = 1
      for(int i=0; i<bBinaryStr.length()&& !Thread.currentThread().isInterrupted();i++)   // pour i parcourant toute la chaine de la représentation binaire de b
      {
          if(bBinaryStr.charAt(i)=='1') // si le bit est 1 alors SM
          {
          aPOWb= aPOWb.multiply(aPOWb);  // squar
           aPOWb= aPOWb.multiply(a); // multiply
          }
          else aPOWb= aPOWb.multiply(aPOWb);  //sinon 0 et donc squar
      }
return aPOWb; // en sortie le BigInteger qui represente a^b
}

/////////////////////////////////////////////////////////////////////



public boolean pseudoPrimTest(BigInteger nbr)
{
    if(modPowSM(BigInteger.valueOf(2), nbr.subtract(BigInteger.ONE) , nbr).equals(BigInteger.ONE)) 
// si 2^(nbr-1)=1 (mod nbr)
    return true; // nbr premier
    else return false; //sinon  composé
}




public BigInteger generatePrimPPTalea(int bitLenght)
{
    BigInteger generatedNum= randomBI(bitLenght);
    
   
    
 while(!pseudoPrimTest(generatedNum)&& !Thread.currentThread().isInterrupted())  // tanque non premier 
 { 
    generatedNum= randomBI(bitLenght); // generer un autre nombre pour le tester
    
    if(generatedNum.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) // s'il est pair
            generatedNum.add(BigInteger.ONE); // ajouter un pour le rend impair                           
 }
 
 return generatedNum;
}


public BigInteger generatePrimPPTnxt(int bitLenght)
{
    BigInteger generatedNum= randomBI(bitLenght);
    
    /* if(generatedNum.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) // s'il est pair
            generatedNum.add(BigInteger.ONE); // ajouter un pour le rend impair
     */
 while(!pseudoPrimTest(generatedNum)&& !Thread.currentThread().isInterrupted())  // tanque non premier 
 {
    generatedNum= generatedNum.add(BigInteger.valueOf(1)); // generatedNum = generatedNum + 2;
 }
 
 return generatedNum;
}







 //									                      Type1      Type2 // here same
// 												        ||			||
	 class generatePrimPPTalea_Worker  extends SwingWorker<BigInteger, Void> {
    int bitsLength;
    
    public generatePrimPPTalea_Worker (int BitsLenght) // !!!!! very important this is the bridge
    {
     bitsLength=BitsLenght;
    }
    
    @Override
       public BigInteger doInBackground() throws InterruptedException { // type 1
	 onWork =true; // work flag on // work have started	 
           jLabel30.setVisible(true);
         jLabel22.setVisible(true);
         jPanel18.setVisible(true);
                
           return generatePrimPPTalea(bitsLength);
       }

       @Override
       protected void done() {
           onWork=false;
           timerOn=false;
           
           timer1.updateDuration();
           timer1Str=timer1.strTimeUnivMS();
           jTextField2.setText(timer1Str);
                       workerAnnim1.cancel(true);

        
  
           
                                                                                                     
           jPanel18.setVisible(false);
           jLabel22.setVisible(false);
           jLabel30.setVisible(false);
            jLabel24.setVisible(false);
          
          
            
           try {
           if(bitsLength<100000)
           {
jTextArea1.setText(get().toString());
             jLabel46.setVisible(true);
           }
           else{
                FileWriter wf = new FileWriter("outGenPrimAlea.txt");
                    
                    wf.write(get().toString());
                    
                    wf.close();
                    
jTextArea1.setText("  resultat large\n  cliquer ici pour\n  le voir");
           jLabel47.setVisible(true);
           transitionAnnimSwingLabel worker = new transitionAnnimSwingLabel(
                   jLabel47,300,60,100-100,110,100,110);
   worker.execute();
           }
           
           } catch (InterruptedException | ExecutionException ignore) {
           } catch (IOException ex) {
            Logger.getLogger(generationDeNombrePremier.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
 
   }
   
   
   
         

//////////////////////////////////
//Miller Rabin test
/////////////////////////////////////

class pair2POWtU {
    private
    BigInteger t; // t telque 2^t.u
     BigInteger u;
     
  public
       pair2POWtU(BigInteger nbr) {
        t = BigInteger.ZERO;
        u=nbr;
            while(u.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)&& !Thread.currentThread().isInterrupted() ) //tant que  u mod 2 = 0 
            {
                u=u.divide(BigInteger.valueOf(2));
                t=t.add(BigInteger.ONE);
            }
            
        }
     
  BigInteger getT(){
      return t;
  }   
  
 BigInteger getU(){
      return u;
  }   
        
        
}

 

public boolean Temoin(BigInteger nbr, BigInteger base )
{
   pair2POWtU frm2PWtU = new  pair2POWtU(nbr.subtract(BigInteger.ONE));
   
    ///////////////
   BigInteger x = modPowSM(base,frm2PWtU.getU() ,nbr ); // base^u mod nbr
    ///////////////
   
   BigInteger i = BigInteger.ZERO;
   BigInteger xLast;
   
   while (i.compareTo(frm2PWtU.getT())<0&& !Thread.currentThread().isInterrupted()) //repeter t fois 
   {   xLast =x;
       x= modPowSM(x, BigInteger.valueOf(2), nbr);
       
        ///////////////
       if(x.equals(BigInteger.ONE)&& 
               !(xLast.equals(BigInteger.ONE)) && !(xLast.equals(nbr.subtract(BigInteger.ONE))))
                return true;
        ///////////////
       
       i=i.add(BigInteger.ONE);
   }
   
   
     ///////////////
       if(!(x.equals(BigInteger.ONE)))
       return true;
     ///////////////  
       
       return false;
           
   
}



///////////////////////////////////////////////////////
public  BigInteger randomBI(BigInteger maxNum) {
    Random rnd = new Random();
    int maxNumBitLength = maxNum.bitLength();
    BigInteger rndNum;
    do {
        rndNum = new BigInteger(maxNumBitLength, rnd);
    } while(rndNum.compareTo(maxNum) >= 0&& !Thread.currentThread().isInterrupted());
    return rndNum;
}

public  BigInteger randomBI(BigInteger minNum, BigInteger maxNum) {
    BigInteger diffr = maxNum.subtract(minNum);
    
    return randomBI(diffr).add(minNum) ;
}


public BigInteger randomBI(int bitLenght)
{
    return randomBI(powSM(BigInteger.valueOf(2), BigInteger.valueOf(bitLenght-1)),
            powSM(BigInteger.valueOf(2), BigInteger.valueOf(bitLenght)).subtract(BigInteger.ONE) );
    
}
///////////////////////////////////////////////////////////////





public boolean isPrimMR(BigInteger nbr, int s) // s est le nommbre de base à tester
{BigInteger base ;
 for (int i=1; i<=s&& !Thread.currentThread().isInterrupted(); i++)   
 {
     base = randomBI(BigInteger.ONE,nbr.subtract(BigInteger.ONE)); // base = random(1,nbr-1)
     if(Temoin(nbr, base))
         return false;
 }
       // si la fonction ne temoine pas à la composition dans aucune base alors nbr est premier (prob)
 return true; 
}
         /////////////////////////////////////////////////////////////////////////
         
         
         
         
         class generatePrimPPTnxt_Worker  extends SwingWorker<BigInteger, Void> {
  
    int bitsLength;
    
    public generatePrimPPTnxt_Worker (int BitsLenght) // !!!!! very important this is the bridge
    {
     bitsLength=BitsLenght;
   
    }
    
    @Override
       public BigInteger doInBackground() throws InterruptedException { // type 1
	  onWork2 =true; // work flag on // work have started	   
           jLabel26.setVisible(true);
         jLabel35.setVisible(true);
         jPanel21.setVisible(true);
              
	 
              
           return generatePrimPPTnxt(bitsLength);
       }

       @Override
       protected void done() {
          timer2.updateDuration();
          
          onWork2=false;
           timer2on=false;
           
          timer2Str=timer2.strTimeUnivMS();
          jTextField4.setText(timer2Str);
           
           workerAnnim2.cancel(true);
   
        
           
                  
           jPanel21.setVisible(false);
           jLabel26.setVisible(false);
           jLabel35.setVisible(false);
            jLabel36.setVisible(false);
           
           try {
           if(bitsLength<100000){
              jTextArea3.setText(get().toString());
           jLabel44.setVisible(true);
           }
           else
           {
                 FileWriter wf = new FileWriter("outGenPrimNxt.txt");
                    
                    wf.write(get().toString());
                    
                    wf.close();
                    
               jTextArea1.setText("  resultat large\n  cliquer ici pour\n  le voir");
           jLabel48.setVisible(true);
           transitionAnnimSwingLabel worker = new transitionAnnimSwingLabel(
                   jLabel48,300,60,370-100,110,370,110);
   worker.execute();
           }
           } catch (InterruptedException | ExecutionException ignore) {
           } catch (IOException ex) {
            Logger.getLogger(generationDeNombrePremier.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
 
   }
    
      
         
         
         
      public BigInteger generatePrimMRTalea(int bitLenght,int certitude)
{
    BigInteger generatedNum= randomBI(bitLenght);
    
   
    
 while(!isPrimMR(generatedNum,certitude)&& !Thread.currentThread().isInterrupted())  // tanque non premier 
 { 
    generatedNum= randomBI(bitLenght); // generer un autre nombre pour le tester
    
   // ajouter un pour le rend impair                           
 }
 
 return generatedNum;
}


public BigInteger generatePrimMRTnxt(int bitLenght,int certitude)
{
    BigInteger generatedNum= randomBI(bitLenght);
    
     if(generatedNum.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) // s'il est pair
            generatedNum.add(BigInteger.ONE); // ajouter un pour le rend impair
     
 while(!isPrimMR(generatedNum,certitude)&& !Thread.currentThread().isInterrupted())  // tanque non premier 
 {
    generatedNum= generatedNum.add(BigInteger.valueOf(2)); // generatedNum = generatedNum + 2;
 }
 
 return generatedNum;
}
   
  
          //									                      Type1      Type2 // here same
// 												        ||			||
	 class generatePrimMRTalea_Worker  extends SwingWorker<BigInteger, Void> {
    int bitsLength;
      int certitude;
      
    public generatePrimMRTalea_Worker (int BitsLenght, int Certitude) // !!!!! very important this is the bridge
    {
     bitsLength=BitsLenght;
    certitude =  Certitude;
    }
    
    @Override
       public BigInteger doInBackground() throws InterruptedException { // type 1
	 onWork3 =true; // work flag on // work have started	 
           jLabel27.setVisible(true);
         jLabel31.setVisible(true);
         
         jPanel29.setVisible(true);
            
                
           return generatePrimMRTalea( bitsLength, certitude);
       }

       @Override
       protected void done() {
           onWork3=false;
           timer3on=false;
           
           timer3.updateDuration();
           timer3Str=timer3.strTimeUnivMS();
           
           workerAnnim3.cancel(true);
           
           jTextField6.setText(timer3Str);
           
        
  
           
                                                                                                     
           jLabel27.setVisible(false);
         jLabel31.setVisible(false);
         jPanel29.setVisible(false);
           jLabel51.setVisible(true);
               jLabel41.setVisible(false);
           try {
           if(bitsLength<100000)
           {
jTextArea2.setText(get().toString());
            
           }
           else{
                FileWriter wf = new FileWriter("outGenPrimAlea.txt");
                    
                    wf.write(get().toString());
                    
                    wf.close();
                    
jTextArea2.setText("  resultat large\n  cliquer ici pour\n  le voir");
           jLabel50.setVisible(true);
           transitionAnnimSwingLabel worker = new transitionAnnimSwingLabel(
                   jLabel50,300,60,100-100,110,100,110);
   worker.execute();
           }
           
           } catch (InterruptedException | ExecutionException ignore) {
           } catch (IOException ex) {
            Logger.getLogger(generationDeNombrePremier.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
 
   }
   
         
         
         
      class generatePrimMRTnxt_Worker  extends SwingWorker<BigInteger, Void> {
    int bitsLength;
      int certitude;
      
    public generatePrimMRTnxt_Worker (int BitsLenght, int Certitude) // !!!!! very important this is the bridge
    {
     bitsLength=BitsLenght;
    certitude =  Certitude;
    }
    
    @Override
       public BigInteger doInBackground() throws InterruptedException { // type 1
	 onWork4 =true; // work flag on // work have started	 
           jLabel37.setVisible(true);
         jLabel28.setVisible(true);
         
         jPanel35.setVisible(true);
            
                
           return generatePrimMRTnxt(bitsLength, certitude);
       }

       @Override
       protected void done() {
           onWork4=false;
           timer4on=false;
           
           timer4.updateDuration();
           timer4Str=timer4.strTimeUnivMS();
           
           workerAnnim4.cancel(true);
           
           jTextField7.setText(timer4Str);
           
        
  
           
                                                                                                     
           jLabel37.setVisible(false);
         jLabel28.setVisible(false);
         jPanel35.setVisible(false);
           jLabel45.setVisible(true);
               jLabel38.setVisible(false);
           try {
           if(bitsLength<100000)
           {
jTextArea4.setText(get().toString());
            
           }
           else{
                FileWriter wf = new FileWriter("outGenPrimAlea.txt");
                    
                    wf.write(get().toString());
                    
                    wf.close();
                    
jTextArea4.setText("  resultat large\n  cliquer ici pour\n  le voir");
           jLabel49.setVisible(true);
           transitionAnnimSwingLabel worker = new transitionAnnimSwingLabel(
                   jLabel49,300,60,100-100,110,100,110);
   worker.execute();
           }
           
           } catch (InterruptedException | ExecutionException ignore) {
           } catch (IOException ex) {
            Logger.getLogger(generationDeNombrePremier.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
 
   }   
         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel16 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
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
        jPanel11 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crypto");
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));

        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(91, 37, 73));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        jPanel14.setBackground(new java.awt.Color(47, 34, 45));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("CRYPTO");
        jPanel14.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

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

        jPanel14.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 170, 10));

        jLabel9.setBackground(new java.awt.Color(0, 51, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tools 100x100 .png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });
        jPanel14.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 100, 109));

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
        jPanel14.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

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
        jPanel14.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jPanel9.setBackground(new java.awt.Color(43, 44, 52));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel14.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 890, 10));

        jPanel1.add(jPanel14);
        jPanel14.setBounds(0, 0, 943, 140);

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
                .addContainerGap(425, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel19);
        jPanel19.setBounds(0, 140, 70, 500);

        jPanel30.setBackground(new java.awt.Color(39, 30, 45));
        jPanel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel30MouseClicked(evt);
            }
        });
        jPanel30.setLayout(null);

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 5, new java.awt.Color(61, 57, 83)));

        jPanel5.setBackground(new java.awt.Color(51, 48, 66));
        jPanel5.setLayout(new java.awt.GridLayout(9, 1));

        jLabel6.setBackground(new java.awt.Color(60, 60, 84));
        jLabel6.setForeground(new java.awt.Color(130, 122, 122));
        jLabel6.setText("   Aller à Squar and multiply ( modulo Pratique )");
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

        jLabel8.setBackground(new java.awt.Color(60, 60, 84));
        jLabel8.setForeground(new java.awt.Color(130, 122, 122));
        jLabel8.setText("   Aller à Squar and multiply (pratique)");
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

        jLabel10.setBackground(new java.awt.Color(60, 60, 84));
        jLabel10.setForeground(new java.awt.Color(130, 122, 122));
        jLabel10.setText("   Aller à Squar and multiply ( etude )");
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

        jLabel11.setBackground(new java.awt.Color(60, 60, 84));
        jLabel11.setForeground(new java.awt.Color(130, 122, 122));
        jLabel11.setText("   Aller à Squar and multiply ( modulaire )");
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        jLabel11.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel11.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel11.setOpaque(true);
        jLabel11.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
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

        jLabel12.setBackground(new java.awt.Color(60, 60, 84));
        jLabel12.setForeground(new java.awt.Color(130, 122, 122));
        jLabel12.setText("   Aller à Squar and multiply ( modulaire )");
        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));
        jLabel12.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel12.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel12.setOpaque(true);
        jLabel12.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
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

        jLabel13.setBackground(new java.awt.Color(60, 60, 84));
        jLabel13.setForeground(new java.awt.Color(130, 122, 122));
        jLabel13.setText("   Aller à Squar and multiply ( modulaire )");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        jLabel13.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel13.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel13.setOpaque(true);
        jLabel13.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
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

        jLabel14.setBackground(new java.awt.Color(60, 60, 84));
        jLabel14.setForeground(new java.awt.Color(130, 122, 122));
        jLabel14.setText("   Aller à Squar and multiply ( modulaire )");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(59, 51, 68)));
        jLabel14.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel14.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel14.setOpaque(true);
        jLabel14.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
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

        jLabel16.setBackground(new java.awt.Color(60, 60, 84));
        jLabel16.setForeground(new java.awt.Color(130, 122, 122));
        jLabel16.setText("   Aller à Squar and multiply ( modulaire )");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        jLabel16.setMaximumSize(new java.awt.Dimension(522222, 50));
        jLabel16.setMinimumSize(new java.awt.Dimension(184, 50));
        jLabel16.setOpaque(true);
        jLabel16.setPreferredSize(new java.awt.Dimension(200, 50));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
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
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        jPanel30.add(jPanel10);
        jPanel10.setBounds(0, 0, 250, 500);
        jPanel10.setVisible(false);

        jPanel11.setBackground(new java.awt.Color(51, 31, 55));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(null);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(81, 72, 121));
        jLabel40.setText("<html><u>Generateur Pseudo Alea</u></html>");
        jPanel11.add(jLabel40);
        jLabel40.setBounds(30, 250, 250, 22);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(81, 72, 121));
        jLabel34.setText("<html><u>Generateur Pseudo Nxt </u></html>");
        jPanel11.add(jLabel34);
        jLabel34.setBounds(310, 250, 200, 22);

        jTextField7.setBackground(new java.awt.Color(51, 31, 55));
        jTextField7.setForeground(new java.awt.Color(132, 102, 145));
        jTextField7.setBorder(null);
        jTextField7.setFocusable(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField7);
        jTextField7.setBounds(310, 430, 170, 20);

        jLabel27.setForeground(new java.awt.Color(150, 49, 49));
        jLabel27.setText("Calcule en cours");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });
        jPanel11.add(jLabel27);
        jLabel27.setBounds(40, 280, 100, 20);
        jLabel27.setVisible(false);

        jLabel31.setBackground(new java.awt.Color(185, 68, 68));
        jLabel31.setForeground(new java.awt.Color(122, 29, 29));
        jLabel31.setText(" Annuler");
        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
        jLabel31.setOpaque(true);
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel31MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel31MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel31MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel31);
        jLabel31.setBounds(140, 280, 50, 20);
        jLabel31.setVisible(false);

        jLabel28.setForeground(new java.awt.Color(150, 49, 49));
        jLabel28.setText("Calcule en cours");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });
        jPanel11.add(jLabel28);
        jLabel28.setBounds(310, 280, 100, 20);
        jLabel28.setVisible(false);

        jLabel37.setBackground(new java.awt.Color(185, 68, 68));
        jLabel37.setForeground(new java.awt.Color(122, 29, 29));
        jLabel37.setText(" Annuler");
        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
        jLabel37.setOpaque(true);
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel37MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel37MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel37MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel37);
        jLabel37.setBounds(410, 280, 50, 20);
        jLabel37.setVisible(false);

        jLabel32.setForeground(new java.awt.Color(119, 55, 55));
        jLabel32.setText("Taille en bits");
        jPanel11.add(jLabel32);
        jLabel32.setBounds(470, 300, 80, 20);

        jLabel21.setForeground(new java.awt.Color(119, 55, 55));
        jLabel21.setText("Taille en bits");
        jPanel11.add(jLabel21);
        jLabel21.setBounds(200, 300, 90, 20);

        jTextField6.setBackground(new java.awt.Color(51, 31, 55));
        jTextField6.setForeground(new java.awt.Color(132, 102, 145));
        jTextField6.setBorder(null);
        jTextField6.setFocusable(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField6);
        jTextField6.setBounds(40, 430, 170, 20);

        jTextField10.setBackground(new java.awt.Color(40, 36, 52));
        jTextField10.setForeground(new java.awt.Color(89, 85, 113));
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("nbr bits");
        jTextField10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 54, 66)));
        jTextField10.setDragEnabled(true);
        jTextField10.setFocusable(false);
        jTextField10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField10FocusLost(evt);
            }
        });
        jTextField10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField10MouseExited(evt);
            }
        });
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField10KeyTyped(evt);
            }
        });
        jPanel11.add(jTextField10);
        jTextField10.setBounds(200, 320, 70, 20);

        jTextField5.setBackground(new java.awt.Color(40, 36, 52));
        jTextField5.setForeground(new java.awt.Color(89, 85, 113));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("nbr bits");
        jTextField5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 54, 66)));
        jTextField5.setDragEnabled(true);
        jTextField5.setFocusable(false);
        jTextField5.setMargin(new java.awt.Insets(2, 7, 2, 7));
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField5MouseExited(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel11.add(jTextField5);
        jTextField5.setBounds(470, 320, 70, 20);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file-icon_64x64.png"))); // NOI18N
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel49MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel49MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel49MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel49MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel49);
        jLabel49.setBounds(370, 310, 70, 80);
        jLabel49.setVisible(false);

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel45MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel45MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel45MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel45MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel45);
        jLabel45.setBounds(440, 380, 30, 30);
        jLabel45.setVisible(false);

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(47, 53, 82));
        jTextArea4.setColumns(20);
        jTextArea4.setForeground(new java.awt.Color(128, 114, 175));
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setWrapStyleWord(true);
        jTextArea4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 22, 39), 5));
        jTextArea4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea4.setDragEnabled(true);
        jTextArea4.setFocusable(false);
        jTextArea4.setSelectedTextColor(new java.awt.Color(181, 184, 199));
        jTextArea4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea4FocusLost(evt);
            }
        });
        jTextArea4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextArea4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextArea4MouseExited(evt);
            }
        });
        jTextArea4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea4KeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTextArea4);

        jPanel11.add(jScrollPane4);
        jScrollPane4.setBounds(310, 300, 150, 100);

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file-icon_64x64.png"))); // NOI18N
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
        jPanel11.add(jLabel50);
        jLabel50.setBounds(100, 310, 70, 80);
        jLabel50.setVisible(false);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
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
        jPanel11.add(jLabel51);
        jLabel51.setBounds(170, 380, 30, 30);
        jLabel51.setVisible(false);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(47, 53, 82));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(128, 114, 175));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 22, 39), 5));
        jTextArea2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea2.setDragEnabled(true);
        jTextArea2.setFocusable(false);
        jTextArea2.setSelectedTextColor(new java.awt.Color(181, 184, 199));
        jTextArea2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea2FocusLost(evt);
            }
        });
        jTextArea2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextArea2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextArea2MouseExited(evt);
            }
        });
        jTextArea2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea2KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        jPanel11.add(jScrollPane2);
        jScrollPane2.setBounds(40, 300, 150, 100);

        jLabel41.setForeground(new java.awt.Color(150, 49, 49));
        jLabel41.setText("entrer les donné d'abord!");
        jPanel11.add(jLabel41);
        jLabel41.setBounds(50, 390, 190, 30);
        jLabel41.setVisible(false);

        jLabel38.setForeground(new java.awt.Color(150, 49, 49));
        jLabel38.setText("entrer les donné d'abord!");
        jPanel11.add(jLabel38);
        jLabel38.setBounds(320, 390, 150, 30);
        jLabel38.setVisible(false);

        jLabel42.setBackground(new java.awt.Color(48, 43, 81));
        jLabel42.setForeground(new java.awt.Color(107, 101, 146));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Generer");
        jLabel42.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(36, 29, 54)));
        jLabel42.setOpaque(true);
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel42MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel42MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel42MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel42MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel42);
        jLabel42.setBounds(80, 410, 70, 20);

        jPanel29.setOpaque(false);
        jPanel29.setLayout(new java.awt.GridBagLayout());

        jPanel31.setBackground(new java.awt.Color(12, 12, 21));

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 8);
        jPanel29.add(jPanel31, gridBagConstraints);

        jPanel32.setBackground(new java.awt.Color(24, 19, 33));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel29.add(jPanel32, gridBagConstraints);

        jPanel33.setBackground(new java.awt.Color(30, 25, 42));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel29.add(jPanel33, gridBagConstraints);

        jPanel34.setBackground(new java.awt.Color(34, 28, 47));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 4, 0);
        jPanel29.add(jPanel34, gridBagConstraints);

        jPanel11.add(jPanel29);
        jPanel29.setBounds(160, 410, 100, 20);
        jPanel29.setVisible(false);

        jPanel35.setOpaque(false);
        jPanel35.setLayout(new java.awt.GridBagLayout());

        jPanel36.setBackground(new java.awt.Color(12, 12, 21));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 8);
        jPanel35.add(jPanel36, gridBagConstraints);

        jPanel37.setBackground(new java.awt.Color(24, 19, 33));

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel35.add(jPanel37, gridBagConstraints);

        jPanel38.setBackground(new java.awt.Color(30, 25, 42));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel35.add(jPanel38, gridBagConstraints);

        jPanel39.setBackground(new java.awt.Color(34, 28, 47));

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 4, 0);
        jPanel35.add(jPanel39, gridBagConstraints);

        jPanel11.add(jPanel35);
        jPanel35.setBounds(430, 410, 100, 20);
        jPanel35.setVisible(false);

        jLabel43.setBackground(new java.awt.Color(48, 43, 81));
        jLabel43.setForeground(new java.awt.Color(107, 101, 146));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Generer");
        jLabel43.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(36, 29, 54)));
        jLabel43.setOpaque(true);
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel43MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel43MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel43MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel43MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel43);
        jLabel43.setBounds(350, 410, 70, 20);

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file-icon_64x64.png"))); // NOI18N
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel48MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel48MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel48MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel48MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel48);
        jLabel48.setBounds(370, 110, 70, 80);
        jLabel48.setVisible(false);

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file-icon_64x64.png"))); // NOI18N
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel47MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel47MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel47MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel47MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel47);
        jLabel47.setBounds(100, 110, 70, 80);
        jLabel47.setVisible(false);

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel46MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel46MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel46MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel46MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel46);
        jLabel46.setBounds(170, 180, 30, 30);
        jLabel46.setVisible(false);

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel44MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel44MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel44MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel44MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel44);
        jLabel44.setBounds(440, 180, 30, 30);
        jLabel44.setVisible(false);

        jTextField9.setBackground(new java.awt.Color(40, 36, 52));
        jTextField9.setForeground(new java.awt.Color(89, 85, 113));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("Certitude");
        jTextField9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 54, 66)));
        jTextField9.setDragEnabled(true);
        jTextField9.setFocusable(false);
        jTextField9.setMargin(new java.awt.Insets(2, 7, 2, 7));
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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField9MouseExited(evt);
            }
        });
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });
        jPanel11.add(jTextField9);
        jTextField9.setBounds(200, 360, 70, 20);

        jLabel29.setForeground(new java.awt.Color(119, 55, 55));
        jLabel29.setText("Certitude");
        jPanel11.add(jLabel29);
        jLabel29.setBounds(200, 340, 80, 20);

        jPanel12.setBackground(new java.awt.Color(48, 40, 63));

        jLabel17.setForeground(new java.awt.Color(89, 84, 108));
        jLabel17.setText("L'algorithme");

        jLabel18.setForeground(new java.awt.Color(182, 88, 88));
        jLabel18.setText("Generation de nombre premier ");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel17)
                .addGap(3, 3, 3)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addComponent(jLabel18))
        );

        jPanel11.add(jPanel12);
        jPanel12.setBounds(0, 0, 570, 26);

        jLabel19.setForeground(new java.awt.Color(119, 55, 55));
        jLabel19.setText("Taille en bits");
        jPanel11.add(jLabel19);
        jLabel19.setBounds(200, 100, 90, 20);

        jPanel13.setBackground(new java.awt.Color(52, 40, 64));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel13);
        jPanel13.setBounds(0, 30, 10, 450);

        jPanel15.setBackground(new java.awt.Color(62, 46, 78));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel15);
        jPanel15.setBounds(560, 30, 10, 450);

        jPanel17.setBackground(new java.awt.Color(51, 40, 63));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel17);
        jPanel17.setBounds(10, 460, 550, 20);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(47, 53, 82));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(128, 114, 175));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 22, 39), 5));
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea1.setDragEnabled(true);
        jTextArea1.setFocusable(false);
        jTextArea1.setSelectedTextColor(new java.awt.Color(181, 184, 199));
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextArea1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextArea1MouseExited(evt);
            }
        });
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jPanel11.add(jScrollPane1);
        jScrollPane1.setBounds(40, 100, 150, 100);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(81, 72, 121));
        jLabel33.setText("<html><u>Generateur Pseudo Nxt </u></html>");
        jPanel11.add(jLabel33);
        jLabel33.setBounds(310, 50, 200, 22);

        jLabel20.setBackground(new java.awt.Color(48, 43, 81));
        jLabel20.setForeground(new java.awt.Color(107, 101, 146));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Generer");
        jLabel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(36, 29, 54)));
        jLabel20.setOpaque(true);
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel20MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel20);
        jLabel20.setBounds(80, 210, 70, 20);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(47, 53, 82));
        jTextArea3.setColumns(20);
        jTextArea3.setForeground(new java.awt.Color(128, 114, 175));
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 22, 39), 5));
        jTextArea3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea3.setDragEnabled(true);
        jTextArea3.setFocusable(false);
        jTextArea3.setSelectedTextColor(new java.awt.Color(181, 184, 199));
        jTextArea3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea3FocusLost(evt);
            }
        });
        jTextArea3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextArea3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextArea3MouseExited(evt);
            }
        });
        jTextArea3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea3KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea3);

        jPanel11.add(jScrollPane3);
        jScrollPane3.setBounds(310, 100, 150, 100);

        jLabel23.setBackground(new java.awt.Color(48, 43, 81));
        jLabel23.setForeground(new java.awt.Color(107, 101, 146));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Generer");
        jLabel23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(36, 29, 54)));
        jLabel23.setOpaque(true);
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel23MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel23MouseReleased(evt);
            }
        });
        jPanel11.add(jLabel23);
        jLabel23.setBounds(350, 210, 70, 20);

        jTextField3.setBackground(new java.awt.Color(40, 36, 52));
        jTextField3.setForeground(new java.awt.Color(89, 85, 113));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("nbr bits");
        jTextField3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 54, 66)));
        jTextField3.setDragEnabled(true);
        jTextField3.setFocusable(false);
        jTextField3.setMargin(new java.awt.Insets(2, 7, 2, 7));
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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField3MouseExited(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        jPanel11.add(jTextField3);
        jTextField3.setBounds(470, 120, 70, 20);

        jTextField2.setBackground(new java.awt.Color(51, 31, 55));
        jTextField2.setForeground(new java.awt.Color(132, 102, 145));
        jTextField2.setBorder(null);
        jTextField2.setFocusable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField2);
        jTextField2.setBounds(40, 230, 170, 20);

        jTextField4.setBackground(new java.awt.Color(51, 31, 55));
        jTextField4.setForeground(new java.awt.Color(132, 102, 145));
        jTextField4.setBorder(null);
        jTextField4.setFocusable(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel11.add(jTextField4);
        jTextField4.setBounds(310, 230, 170, 20);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.GridBagLayout());

        jPanel23.setBackground(new java.awt.Color(12, 12, 21));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 8);
        jPanel18.add(jPanel23, gridBagConstraints);

        jPanel20.setBackground(new java.awt.Color(24, 19, 33));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel18.add(jPanel20, gridBagConstraints);

        jPanel24.setBackground(new java.awt.Color(30, 25, 42));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel18.add(jPanel24, gridBagConstraints);

        jPanel25.setBackground(new java.awt.Color(34, 28, 47));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 4, 0);
        jPanel18.add(jPanel25, gridBagConstraints);

        jPanel11.add(jPanel18);
        jPanel18.setBounds(160, 210, 100, 20);
        jPanel18.setVisible(false);

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new java.awt.GridBagLayout());

        jPanel26.setBackground(new java.awt.Color(12, 12, 21));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 8);
        jPanel21.add(jPanel26, gridBagConstraints);

        jPanel22.setBackground(new java.awt.Color(24, 19, 33));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel21.add(jPanel22, gridBagConstraints);

        jPanel27.setBackground(new java.awt.Color(30, 25, 42));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 4, 0);
        jPanel21.add(jPanel27, gridBagConstraints);

        jPanel28.setBackground(new java.awt.Color(34, 28, 47));

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 4, 0);
        jPanel21.add(jPanel28, gridBagConstraints);

        jPanel11.add(jPanel21);
        jPanel21.setBounds(430, 210, 100, 20);
        jPanel21.setVisible(false);

        jLabel30.setBackground(new java.awt.Color(185, 68, 68));
        jLabel30.setForeground(new java.awt.Color(122, 29, 29));
        jLabel30.setText(" Annuler");
        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
        jLabel30.setOpaque(true);
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
        jPanel11.add(jLabel30);
        jLabel30.setBounds(140, 80, 50, 20);
        jLabel30.setVisible(false);

        jLabel22.setForeground(new java.awt.Color(150, 49, 49));
        jLabel22.setText("Calcule en cours");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });
        jPanel11.add(jLabel22);
        jLabel22.setBounds(40, 80, 110, 20);
        jLabel22.setVisible(false);

        jLabel26.setForeground(new java.awt.Color(150, 49, 49));
        jLabel26.setText("Calcule en cours");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
        });
        jPanel11.add(jLabel26);
        jLabel26.setBounds(310, 80, 110, 20);
        jLabel26.setVisible(false);

        jLabel35.setBackground(new java.awt.Color(185, 68, 68));
        jLabel35.setForeground(new java.awt.Color(122, 29, 29));
        jLabel35.setText(" Annuler");
        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
        jLabel35.setOpaque(true);
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
        jPanel11.add(jLabel35);
        jLabel35.setBounds(410, 80, 50, 20);
        jLabel35.setVisible(false);

        jLabel36.setForeground(new java.awt.Color(150, 49, 49));
        jLabel36.setText("entrer les donné d'abord!");
        jPanel11.add(jLabel36);
        jLabel36.setBounds(320, 190, 150, 30);
        jLabel36.setVisible(false);

        jLabel24.setForeground(new java.awt.Color(150, 49, 49));
        jLabel24.setText("entrer les donné d'abord!");
        jPanel11.add(jLabel24);
        jLabel24.setBounds(50, 190, 190, 30);
        jLabel24.setVisible(false);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(81, 72, 121));
        jLabel39.setText("<html><u>Generateur Pseudo Alea</u></html>");
        jPanel11.add(jLabel39);
        jLabel39.setBounds(30, 50, 250, 22);

        jTextField8.setBackground(new java.awt.Color(40, 36, 52));
        jTextField8.setForeground(new java.awt.Color(89, 85, 113));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("nbr bits");
        jTextField8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 54, 66)));
        jTextField8.setDragEnabled(true);
        jTextField8.setFocusable(false);
        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField8FocusLost(evt);
            }
        });
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField8MouseExited(evt);
            }
        });
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField8KeyTyped(evt);
            }
        });
        jPanel11.add(jTextField8);
        jTextField8.setBounds(200, 120, 70, 20);

        jLabel25.setForeground(new java.awt.Color(119, 55, 55));
        jLabel25.setText("Taille en bits");
        jPanel11.add(jLabel25);
        jLabel25.setBounds(470, 100, 70, 20);

        jTextField11.setBackground(new java.awt.Color(40, 36, 52));
        jTextField11.setForeground(new java.awt.Color(89, 85, 113));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("Certitude");
        jTextField11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(41, 54, 66)));
        jTextField11.setDragEnabled(true);
        jTextField11.setFocusable(false);
        jTextField11.setMargin(new java.awt.Insets(2, 7, 2, 7));
        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost(evt);
            }
        });
        jTextField11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField11MouseExited(evt);
            }
        });
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField11KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });
        jPanel11.add(jTextField11);
        jTextField11.setBounds(470, 360, 70, 20);

        jLabel52.setForeground(new java.awt.Color(119, 55, 55));
        jLabel52.setText("Certitude");
        jPanel11.add(jLabel52);
        jLabel52.setBounds(470, 340, 60, 20);

        jPanel30.add(jPanel11);
        jPanel11.setBounds(260, 10, 570, 480);

        jPanel1.add(jPanel30);
        jPanel30.setBounds(70, 140, 880, 500);

        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
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
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 40));

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
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 945, 5));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 255));
        jLabel2.setText("Crypto");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 14, -1, -1));

        jPanel7.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 641, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jLabel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusGained
    }//GEN-LAST:event_jLabel1FocusGained

    private void jLabel1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1FocusLost

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2FocusGained

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
jLabel1.setBackground(Color.yellow);
        jLabel1.setForeground(new java.awt.Color(255, 155, 5));  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
   jLabel1.setForeground(new java.awt.Color(102, 102, 255));    
jLabel1.setBackground(new java.awt.Color(204, 204, 204));   
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked
Dimension jl6Dimension1 = new Dimension();
Dimension jl9Dimension1 = new Dimension();
Dimension jl8Dimension1 = new Dimension();

Point jL6LocationInitial= new Point();
Point jL9LocationInitial= new Point();

Point jL8LocationInitial= new Point();


    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered

    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited

    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
jLabel9.setBackground(new java.awt.Color(103,255,181)) ;      



// TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MousePressed
int Xmouse;
int Ymouse;
    private void jLabel15MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseDragged
  int x=evt.getXOnScreen();
  int y=evt.getYOnScreen();
   
        setLocation(x-Xmouse, y-Ymouse);
  
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseDragged

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
Xmouse=evt.getX();
Ymouse=evt.getY();
//           ^>> get the position of the mouse on the jLabel (our container)
 

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked

        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64_4.png")));
jLabel4.updateUI();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64.png")));

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64_3.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home icon/32x32/home-xxl_32x32.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home icon/32x32/ddd_32x32.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Home icon/32x32/53529_32x32.png")));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
mainJfram fram = new mainJfram();
fram.setVisible(true);

this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
  outilsMenu fram = new outilsMenu();
fram.setVisible(true);

this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    boolean menuOpen=false;
    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
if(!menuOpen){
        jPanel10.setVisible(true);

transitionAnnimSwing worker = new transitionAnnimSwing(jPanel10,200,60,-jPanel10.getWidth(),0,0,0);
worker.execute();
menuOpen = true;
}
else{
  transitionAnnimSwing worker = new transitionAnnimSwing(jPanel10,200,60,0,0,-jPanel10.getWidth(),0);
worker.execute();  
menuOpen = false;
}

        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered

jLabel6.setBackground(new java.awt.Color(49, 49, 83));

jLabel6.setForeground(new java.awt.Color(96, 94, 124));

jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));


/*jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(127, 93, 167)));*/

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
jLabel6.setBackground(new java.awt.Color(60, 60, 84));

jLabel6.setForeground(new java.awt.Color(130, 122, 122));
jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
jLabel8.setBackground(new java.awt.Color(60, 60, 84));

jLabel8.setForeground(new java.awt.Color(130, 122, 122)); 

jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered

jLabel8.setBackground(new java.awt.Color(49, 49, 83));

jLabel8.setForeground(new java.awt.Color(96, 94, 124));  

jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered

jLabel10.setBackground(new java.awt.Color(49, 49, 83));

jLabel10.setForeground(new java.awt.Color(96, 94, 124));  
jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
jLabel10.setBackground(new java.awt.Color(60, 60, 84));

jLabel10.setForeground(new java.awt.Color(130, 122, 122));     
jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
jLabel11.setBackground(new java.awt.Color(49, 49, 83));

jLabel11.setForeground(new java.awt.Color(96, 94, 124));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
jLabel11.setBackground(new java.awt.Color(60, 60, 84));

jLabel11.setForeground(new java.awt.Color(130, 122, 122));    
jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
jLabel12.setBackground(new java.awt.Color(49, 49, 83));

jLabel12.setForeground(new java.awt.Color(96, 94, 124));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
jLabel12.setBackground(new java.awt.Color(60, 60, 84));

jLabel12.setForeground(new java.awt.Color(130, 122, 122));
jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
jLabel13.setBackground(new java.awt.Color(49, 49, 83));

jLabel13.setForeground(new java.awt.Color(96, 94, 124)); 
jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
jLabel13.setBackground(new java.awt.Color(60, 60, 84));

jLabel13.setForeground(new java.awt.Color(130, 122, 122));    
jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        jLabel14.setBackground(new java.awt.Color(49, 49, 83));

jLabel14.setForeground(new java.awt.Color(96, 94, 124));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
jLabel14.setBackground(new java.awt.Color(60, 60, 84));

jLabel14.setForeground(new java.awt.Color(130, 122, 122)); 

jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
jLabel16.setBackground(new java.awt.Color(49, 49, 83));

jLabel16.setForeground(new java.awt.Color(96, 94, 124));
jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
jLabel16.setBackground(new java.awt.Color(60, 60, 84));

jLabel16.setForeground(new java.awt.Color(130, 122, 122));   
jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64_6.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseReleased
jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu_ icon/64x64/256-256-43252f44e69ebdd2e8bb5370ba120db4-grid_64x64_2.png"))); // NOI18N
         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseReleased

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
jTextField3.setFocusable(false);  

        
// TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel30MouseClicked
jTextField3.setFocusable(false);  
       // TODO add your handling code here:
    }//GEN-LAST:event_jPanel30MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        jTextField3.setFocusable(false);
            // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jLabel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseReleased
jLabel6.setBackground(new java.awt.Color(49, 49, 83));

jLabel6.setForeground(new java.awt.Color(96, 94, 124));

jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseReleased

    private void jLabel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseReleased
jLabel8.setBackground(new java.awt.Color(49, 49, 83));

jLabel8.setForeground(new java.awt.Color(96, 94, 124));  

jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseReleased

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
jLabel10.setBackground(new java.awt.Color(49, 49, 83));

jLabel10.setForeground(new java.awt.Color(96, 94, 124));  
jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseReleased

    private void jLabel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseReleased
jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
jLabel11.setBackground(new java.awt.Color(49, 49, 83));

jLabel11.setForeground(new java.awt.Color(96, 94, 124));           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseReleased

    private void jLabel12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseReleased
jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
jLabel12.setBackground(new java.awt.Color(49, 49, 83));

jLabel12.setForeground(new java.awt.Color(96, 94, 124));            // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseReleased

    private void jLabel13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseReleased
jLabel13.setBackground(new java.awt.Color(49, 49, 83));

jLabel13.setForeground(new java.awt.Color(96, 94, 124)); 
jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseReleased

    private void jLabel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseReleased
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        jLabel14.setBackground(new java.awt.Color(49, 49, 83));

        jLabel14.setForeground(new java.awt.Color(96, 94, 124));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseReleased

    private void jLabel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseReleased
        jLabel16.setBackground(new java.awt.Color(49, 49, 83));

        jLabel16.setForeground(new java.awt.Color(96, 94, 124));
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseReleased

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        jLabel6.setBackground(new java.awt.Color(49, 49, 43));

        jLabel6.setForeground(new java.awt.Color(96, 94, 100));

        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        jLabel8.setBackground(new java.awt.Color(49, 49, 43));

        jLabel8.setForeground(new java.awt.Color(96, 94, 100));

        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        jLabel10.setBackground(new java.awt.Color(49, 49, 43));

        jLabel10.setForeground(new java.awt.Color(96, 94, 100));

        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
        jLabel11.setBackground(new java.awt.Color(49, 49, 43));

        jLabel11.setForeground(new java.awt.Color(96, 94, 100));

        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MousePressed

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
        jLabel12.setBackground(new java.awt.Color(49, 49, 43));

        jLabel12.setForeground(new java.awt.Color(96, 94, 100));

        jLabel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 40, 60)));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
SquareAndMultiplayModuloEfficace fram = new SquareAndMultiplayModuloEfficace();
fram.setVisible(true);
this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
SquareAndMultiplayEfficace fram = new SquareAndMultiplayEfficace();
fram.setVisible(true);
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
    SquareAndMultiplay fram = new SquareAndMultiplay();
fram.setVisible(true);
this.dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        jTextField3.setFocusable(false);
      
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
 
    }//GEN-LAST:event_jTextField8KeyPressed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseExited
        if(!jTextField8.isFocusOwner()){
            jTextField8.setBackground(new java.awt.Color(40, 36, 52));

            jTextField8.setForeground(new java.awt.Color(89, 85, 113));   }          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8MouseExited

    private void jTextField8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseEntered
        jTextField8.setFocusable(true);

        if(!jTextField8.isFocusOwner()){
            jTextField8.setBackground(new java.awt.Color(46, 41, 60));
            jTextField8.setForeground(new java.awt.Color(105, 101, 130));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8MouseEntered

    private void jTextField8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusLost
        jTextField8.setBackground(new java.awt.Color(40, 36, 52));

        jTextField8.setForeground(new java.awt.Color(89, 85, 113));
        if(jTextField8.getText().equals(""))
        jTextField8.setText("nbr bits");

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusLost

    private void jTextField8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusGained
        jTextField8.setBackground(new java.awt.Color(51, 46, 66));
        jTextField8.setForeground(new java.awt.Color(129, 126, 150));
        if(jTextField8.getText().equals("nbr bits"))
        jTextField8.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusGained

    private void jLabel35MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseReleased
        jLabel35.setBackground(new java.awt.Color(222, 85, 85));

        jLabel35.setForeground(new java.awt.Color(149, 35, 35));

        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseReleased

    private void jLabel35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MousePressed
        jLabel35.setBackground(new java.awt.Color(50, 41, 79));

        jLabel35.setForeground(new java.awt.Color(80, 80, 140));

        jLabel35.setText(" Annuler");

        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(32, 29, 51)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MousePressed

    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
        jLabel35.setBackground(new java.awt.Color(185, 68, 68));

        jLabel35.setForeground(new java.awt.Color(122, 29, 29));

        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
    }//GEN-LAST:event_jLabel35MouseExited

    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
        jLabel35.setBackground(new java.awt.Color(222, 85, 85));

        jLabel35.setForeground(new java.awt.Color(149, 35, 35));

        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseEntered

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        workerMain2.cancel(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseExited

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseExited

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel30MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseReleased
        jLabel30.setBackground(new java.awt.Color(222, 85, 85));

        jLabel30.setForeground(new java.awt.Color(149, 35, 35));

        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseReleased

    private void jLabel30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MousePressed
        jLabel30.setBackground(new java.awt.Color(50, 41, 79));

        jLabel30.setForeground(new java.awt.Color(80, 80, 140));

        jLabel30.setText(" Annuler");

        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(32, 29, 51)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MousePressed

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
        jLabel30.setBackground(new java.awt.Color(185, 68, 68));

        jLabel30.setForeground(new java.awt.Color(122, 29, 29));

        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
    }//GEN-LAST:event_jLabel30MouseExited

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        jLabel30.setBackground(new java.awt.Color(222, 85, 85));

        jLabel30.setForeground(new java.awt.Color(149, 35, 35));

        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        
        workerMain.cancel(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
    
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseExited
        if(!jTextField3.isFocusOwner()){
            jTextField3.setBackground(new java.awt.Color(40, 36, 52));

            jTextField3.setForeground(new java.awt.Color(89, 85, 113));   }

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3MouseExited

    private void jTextField3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseEntered
        jTextField3.setFocusable(true);
        if(!jTextField3.isFocusOwner()){
            jTextField3.setBackground(new java.awt.Color(46, 41, 60));
            jTextField3.setForeground(new java.awt.Color(105, 101, 130));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3MouseEntered

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        jTextField3.setBackground(new java.awt.Color(40, 36, 52));

        jTextField3.setForeground(new java.awt.Color(89, 85, 113));
        if(jTextField3.getText().equals(""))
        jTextField3.setText("nbr bits");
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        jTextField3.setBackground(new java.awt.Color(51, 46, 66));
        jTextField3.setForeground(new java.awt.Color(129, 126, 150));
        if(jTextField3.getText().equals("nbr bits"))
        jTextField3.setText("");
    }//GEN-LAST:event_jTextField3FocusGained

    private void jLabel23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseReleased
        jLabel23.setBackground(new java.awt.Color(65, 59, 105));

        jLabel23.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseReleased

    private void jLabel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MousePressed
        jLabel23.setBackground(new java.awt.Color(92, 96, 146));

        jLabel23.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MousePressed

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        jLabel23.setBackground(new java.awt.Color(48, 43, 81));

        jLabel23.setForeground(new java.awt.Color(107, 101, 146));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        jLabel23.setBackground(new java.awt.Color(65, 59, 105));

        jLabel23.setForeground(new java.awt.Color(133, 126, 176));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        if(!onWork2){
            if(!(jTextField3.getText().equals("nbr bits")||jTextField3.getText().equals(""))){ // if data are here
           jTextArea3.setText("");
                
            jLabel36.setVisible(false);
            jLabel44.setVisible(false);

         

            workerMain2 = new generatePrimPPTnxt_Worker(Integer.parseInt(jTextField3.getText())); // workerMain is gloabale a reference to allow cancaling forward
            workerMain2.execute();

            
            workerAnnim2 = new annimate4SquareWorker(jPanel28, jPanel27, jPanel22, jPanel26,250 );
            workerAnnim2.execute();
            
            // timer worker
            timer2=new Timing(); // start timer   // timer1 is globale

            //////////////////////////////////////////////////////
            SwingWorker<Void, String> worker3
            = new SwingWorker<Void, String>() {

                @Override
                public Void doInBackground() throws InterruptedException {
                    Timing tm = new Timing();
                    timer2on = true;
                    while(timer2on) // flag to share between threads
                    {
                        Thread.sleep(50);

                        tm.updateDuration();
                        publish(tm.strTimeUnivMS());
                    }
                    return null; // of type type1
                }

                @Override
                public void done() {
                    jTextField4.setText(timer2Str);
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
            worker3.execute();
        }else{
            jLabel36.setVisible(true);
            jLabel36.setText("Entrer les données d'abord !");
        }
        }else {
            jLabel36.setVisible(true);
            jLabel36.setText("attender le travail en cours !");
        }
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jTextArea3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea3KeyReleased
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3KeyReleased

    private void jTextArea3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea3KeyPressed
            // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3KeyPressed

    private void jTextArea3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea3MouseExited
        if(!jTextArea3.isFocusOwner()){
            jTextArea3.setBackground(new java.awt.Color(47, 53, 82));

            jTextArea3.setForeground(new java.awt.Color(128, 114, 175));

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3MouseExited

    private void jTextArea3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea3MouseEntered
        if(!jTextArea3.isFocusOwner()){
            jTextArea3.setBackground(new java.awt.Color(54, 60, 91));

            jTextArea3.setForeground(new java.awt.Color(128, 114, 175));
        }
        jTextArea3.setFocusable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3MouseEntered

    private void jTextArea3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea3FocusLost
        jTextArea3.setBackground(new java.awt.Color(47, 53, 82));

        jTextArea3.setForeground(new java.awt.Color(128, 114, 175));
     // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3FocusLost

    private void jTextArea3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea3FocusGained
        jTextArea3.setBackground(new java.awt.Color(54, 62, 103));

        jTextArea3.setForeground(new java.awt.Color(158, 148, 190));

      
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3FocusGained

    private void jLabel20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseReleased
        jLabel20.setBackground(new java.awt.Color(65, 59, 105));

        jLabel20.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseReleased

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
        jLabel20.setBackground(new java.awt.Color(92, 96, 146));

        jLabel20.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MousePressed

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        jLabel20.setBackground(new java.awt.Color(48, 43, 81));

        jLabel20.setForeground(new java.awt.Color(107, 101, 146));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        jLabel20.setBackground(new java.awt.Color(65, 59, 105));

        jLabel20.setForeground(new java.awt.Color(133, 126, 176));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        if(!onWork){
            if(!(jTextField8.getText().equals("nbr bits")||jTextField8.getText().equals(""))){ // if data are here
               jTextArea1.setText("");
                jLabel24.setVisible(false);
                jLabel46.setVisible(false);

                jTextField2.setVisible(true);

                workerMain = new generatePrimPPTalea_Worker(Integer.parseInt(jTextField8.getText())); // workerMain is gloabale a reference to allow cancaling forward
                workerMain.execute();

                
                      workerAnnim1 = new annimate4SquareWorker(jPanel25,jPanel24 , jPanel20, jPanel23, 250) ;
               workerAnnim1.execute();

                // timer worker
                timer1=new Timing(); // start timer   // timer1 is globale

                //////////////////////////////////////////////////////
                SwingWorker<Void, String> worker3
                = new SwingWorker<Void, String>() {

                    @Override
                    public Void doInBackground() throws InterruptedException {
                        Timing tm = new Timing();
                        timerOn = true;
                        while(timerOn) // flag to share between threads
                        {
                            Thread.sleep(50);

                            tm.updateDuration();
                            publish(tm.strTimeUnivMS());
                        }
                        return null; // of type type1
                    }

                    @Override
                    public void done() {
                        jTextField2.setText(timer1Str);
                    }

                    @Override
                    protected void process(final List<String> chunks) {

                        for (final String db : chunks) {
                            if(!this.isCancelled())
                            {
                                jTextField2.setText(db);
                            }

                        }
                    }

                };
                ///////////////////////////////////////////////////////////////////////////////
                worker3.execute();
            }else{
                jLabel24.setVisible(true);
                jLabel24.setText("Entrer les données d'abord !");
            }
        }else {
            jLabel24.setVisible(true);
            jLabel24.setText("attender le travail en cours !");
        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
       
    }//GEN-LAST:event_jTextArea1KeyReleased

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
     
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jTextArea1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseExited
        if(!jTextArea1.isFocusOwner()){
            jTextArea1.setBackground(new java.awt.Color(47, 53, 82));

            jTextArea1.setForeground(new java.awt.Color(128, 114, 175));

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1MouseExited

    private void jTextArea1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseEntered
        if(!jTextArea1.isFocusOwner()){
            jTextArea1.setBackground(new java.awt.Color(54, 60, 91));

            jTextArea1.setForeground(new java.awt.Color(128, 114, 175));
        }
        jTextArea1.setFocusable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1MouseEntered

    private void jTextArea1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusLost
        jTextArea1.setBackground(new java.awt.Color(47, 53, 82));

        jTextArea1.setForeground(new java.awt.Color(128, 114, 175));
       
    }//GEN-LAST:event_jTextArea1FocusLost

    private void jTextArea1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusGained
        jTextArea1.setBackground(new java.awt.Color(54, 62, 103));

        jTextArea1.setForeground(new java.awt.Color(158, 148, 190));

     
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1FocusGained

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
   
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
   
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseExited
        if(!jTextField9.isFocusOwner()){
            jTextField9.setBackground(new java.awt.Color(40, 36, 52));

            jTextField9.setForeground(new java.awt.Color(89, 85, 113));   }

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9MouseExited

    private void jTextField9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseEntered
        jTextField9.setFocusable(true);
        if(!jTextField9.isFocusOwner()){
            jTextField9.setBackground(new java.awt.Color(46, 41, 60));
            jTextField9.setForeground(new java.awt.Color(105, 101, 130));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9MouseEntered

    private void jTextField9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusLost
        jTextField9.setBackground(new java.awt.Color(40, 36, 52));

        jTextField9.setForeground(new java.awt.Color(89, 85, 113));
        if(jTextField9.getText().equals(""))
        jTextField9.setText("Certitude");
    }//GEN-LAST:event_jTextField9FocusLost

    private void jTextField9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusGained
        jTextField9.setBackground(new java.awt.Color(51, 46, 66));
        jTextField9.setForeground(new java.awt.Color(129, 126, 150));
        if(jTextField9.getText().equals("Certitude"))
        jTextField9.setText("");
    }//GEN-LAST:event_jTextField9FocusGained

    private void jLabel44MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseReleased
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44MouseReleased

    private void jLabel44MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MousePressed
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44MousePressed

    private void jLabel44MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseExited
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44MouseExited

    private void jLabel44MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseEntered
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44MouseEntered

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(jTextArea3.getText());
        clipboard.setContents(strSel, null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jLabel46MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseReleased
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseReleased

    private void jLabel46MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MousePressed
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MousePressed

    private void jLabel46MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseExited
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseExited

    private void jLabel46MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseEntered
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseEntered

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(jTextArea1.getText());
        clipboard.setContents(strSel, null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        File file = new File("outGenPrimAlea.txt");

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseClicked

    private void jLabel47MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseEntered
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_3_64x64.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseEntered

    private void jLabel47MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseExited
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_64x64.png")));
        // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseExited

    private void jLabel47MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MousePressed
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_2_64x64.png")));
        // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MousePressed

    private void jLabel47MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseReleased
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_3_64x64.png")));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel47MouseReleased

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        File file = new File("outGenPrimNxt.txt");

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel48MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseEntered
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_3_64x64.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel48MouseEntered

    private void jLabel48MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseExited
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_64x64.png")));
        // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel48MouseExited

    private void jLabel48MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MousePressed
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_2_64x64.png")));
        // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel48MousePressed

    private void jLabel48MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseReleased
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_3_64x64.png")));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel48MouseReleased

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseExited

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked

        workerMain3.cancel(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseEntered
        jLabel31.setBackground(new java.awt.Color(222, 85, 85));

        jLabel31.setForeground(new java.awt.Color(149, 35, 35));

        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseEntered

    private void jLabel31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseExited
        jLabel31.setBackground(new java.awt.Color(185, 68, 68));

        jLabel31.setForeground(new java.awt.Color(122, 29, 29));

        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
    }//GEN-LAST:event_jLabel31MouseExited

    private void jLabel31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MousePressed
        jLabel31.setBackground(new java.awt.Color(50, 41, 79));

        jLabel31.setForeground(new java.awt.Color(80, 80, 140));

        jLabel31.setText(" Annuler");

        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(32, 29, 51)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MousePressed

    private void jLabel31MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseReleased
        jLabel31.setBackground(new java.awt.Color(222, 85, 85));

        jLabel31.setForeground(new java.awt.Color(149, 35, 35));

        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseReleased

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseExited

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        workerMain4.cancel(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseEntered
        jLabel37.setBackground(new java.awt.Color(222, 85, 85));

        jLabel37.setForeground(new java.awt.Color(149, 35, 35));

        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel37MouseEntered

    private void jLabel37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseExited
        jLabel37.setBackground(new java.awt.Color(185, 68, 68));

        jLabel37.setForeground(new java.awt.Color(122, 29, 29));

        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(124, 36, 47)));
    }//GEN-LAST:event_jLabel37MouseExited

    private void jLabel37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MousePressed
        jLabel37.setBackground(new java.awt.Color(50, 41, 79));

        jLabel37.setForeground(new java.awt.Color(80, 80, 140));

        jLabel37.setText(" Annuler");

        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(32, 29, 51)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel37MousePressed

    private void jLabel37MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseReleased
        jLabel37.setBackground(new java.awt.Color(222, 85, 85));

        jLabel37.setForeground(new java.awt.Color(149, 35, 35));

        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(86, 53, 95)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel37MouseReleased

    private void jTextField10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusGained
        jTextField10.setBackground(new java.awt.Color(51, 46, 66));
        jTextField10.setForeground(new java.awt.Color(129, 126, 150));
        if(jTextField10.getText().equals("nbr bits"))
        jTextField10.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10FocusGained

    private void jTextField10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusLost
        jTextField10.setBackground(new java.awt.Color(40, 36, 52));

        jTextField10.setForeground(new java.awt.Color(89, 85, 113));
        if(jTextField10.getText().equals(""))
        jTextField10.setText("nbr bits");

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10FocusLost

    private void jTextField10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseEntered
        jTextField10.setFocusable(true);

        if(!jTextField10.isFocusOwner()){
            jTextField10.setBackground(new java.awt.Color(46, 41, 60));
            jTextField10.setForeground(new java.awt.Color(105, 101, 130));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10MouseEntered

    private void jTextField10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseExited
        if(!jTextField10.isFocusOwner()){
            jTextField10.setBackground(new java.awt.Color(40, 36, 52));

            jTextField10.setForeground(new java.awt.Color(89, 85, 113));   }          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10MouseExited

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
       
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
      
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
        jTextField5.setBackground(new java.awt.Color(51, 46, 66));
        jTextField5.setForeground(new java.awt.Color(129, 126, 150));
        if(jTextField5.getText().equals("nbr bits"))
        jTextField5.setText("");
    }//GEN-LAST:event_jTextField5FocusGained

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
        jTextField5.setBackground(new java.awt.Color(40, 36, 52));

        jTextField5.setForeground(new java.awt.Color(89, 85, 113));
        if(jTextField5.getText().equals(""))
        jTextField5.setText("nbr bits");
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseEntered
        jTextField5.setFocusable(true);
        if(!jTextField5.isFocusOwner()){
            jTextField5.setBackground(new java.awt.Color(46, 41, 60));
            jTextField5.setForeground(new java.awt.Color(105, 101, 130));
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5MouseEntered

    private void jTextField5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseExited
        if(!jTextField5.isFocusOwner()){
            jTextField5.setBackground(new java.awt.Color(40, 36, 52));

            jTextField5.setForeground(new java.awt.Color(89, 85, 113));   }

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5MouseExited

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
    
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
   
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        File file = new File("outGenPrimNxt.txt");

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel49MouseClicked

    private void jLabel49MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseEntered
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_3_64x64.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel49MouseEntered

    private void jLabel49MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseExited
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_64x64.png")));
        // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel49MouseExited

    private void jLabel49MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MousePressed
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_2_64x64.png")));
        // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel49MousePressed

    private void jLabel49MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseReleased
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_3_64x64.png")));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel49MouseReleased

    private void jTextArea4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea4FocusGained
        jTextArea3.setBackground(new java.awt.Color(54, 62, 103));

        jTextArea3.setForeground(new java.awt.Color(158, 148, 190));

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4FocusGained

    private void jTextArea4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea4FocusLost
        jTextArea3.setBackground(new java.awt.Color(47, 53, 82));

        jTextArea3.setForeground(new java.awt.Color(128, 114, 175));
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4FocusLost

    private void jTextArea4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea4MouseEntered
        if(!jTextArea4.isFocusOwner()){
            jTextArea4.setBackground(new java.awt.Color(54, 60, 91));

            jTextArea4.setForeground(new java.awt.Color(128, 114, 175));
        }
        jTextArea4.setFocusable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4MouseEntered

    private void jTextArea4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea4MouseExited
        if(!jTextArea4.isFocusOwner()){
            jTextArea4.setBackground(new java.awt.Color(47, 53, 82));

            jTextArea4.setForeground(new java.awt.Color(128, 114, 175));

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4MouseExited

    private void jTextArea4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea4KeyPressed
           // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4KeyPressed

    private void jTextArea4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea4KeyReleased
     
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4KeyReleased

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        File file = new File("outGenPrimAlea.txt");

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jLabel50MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseEntered
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_3_64x64.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseEntered

    private void jLabel50MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseExited
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_64x64.png")));
        // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseExited

    private void jLabel50MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MousePressed
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_2_64x64.png")));
        // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MousePressed

    private void jLabel50MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseReleased
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/File_icon/64x64/file_3_64x64.png")));   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseReleased

    private void jTextArea2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea2FocusGained
        jTextArea1.setBackground(new java.awt.Color(54, 62, 103));

        jTextArea1.setForeground(new java.awt.Color(158, 148, 190));

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea2FocusGained

    private void jTextArea2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea2FocusLost
        jTextArea1.setBackground(new java.awt.Color(47, 53, 82));

        jTextArea1.setForeground(new java.awt.Color(128, 114, 175));

    }//GEN-LAST:event_jTextArea2FocusLost

    private void jTextArea2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea2MouseEntered
        if(!jTextArea2.isFocusOwner()){
            jTextArea2.setBackground(new java.awt.Color(54, 60, 91));

            jTextArea2.setForeground(new java.awt.Color(128, 114, 175));
        }
        jTextArea2.setFocusable(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea2MouseEntered

    private void jTextArea2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea2MouseExited
        if(!jTextArea2.isFocusOwner()){
            jTextArea2.setBackground(new java.awt.Color(47, 53, 82));

            jTextArea2.setForeground(new java.awt.Color(128, 114, 175));

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea2MouseExited

    private void jTextArea2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea2KeyPressed
      
    }//GEN-LAST:event_jTextArea2KeyPressed

    private void jTextArea2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea2KeyReleased
     
    }//GEN-LAST:event_jTextArea2KeyReleased

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(jTextArea2.getText());
        clipboard.setContents(strSel, null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jLabel51MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseEntered
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MouseEntered

    private void jLabel51MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseExited
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MouseExited

    private void jLabel51MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MousePressed
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MousePressed

    private void jLabel51MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseReleased
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel51MouseReleased

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(jTextArea4.getText());
        clipboard.setContents(strSel, null);

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel45MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseEntered
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MouseEntered

    private void jLabel45MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseExited
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_3.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MouseExited

    private void jLabel45MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MousePressed
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MousePressed

    private void jLabel45MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseReleased
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/copy icon/32x32/copy-icon_32x32_4.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel45MouseReleased
Timing timer3; String timer3Str;   // timer 
    boolean timer3on ; // timer flag on/of
  boolean onWork3 = false; // flage explaining that the worker stay work (on work the action can't applied twice )
    generatePrimMRTalea_Worker workerMain3; // my worker reference 
    annimate4SquareWorker workerAnnim3 ; 
    
    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        if(!onWork3){
            if(!(jTextField10.getText().equals("nbr bits")||jTextField10.getText().equals("")||jTextField9.getText().equals("Certitude")||jTextField9.getText().equals(""))){ // if data are here
                jTextArea2.setText("");
                jLabel50.setVisible(false);
                jLabel51.setVisible(false);
                jLabel41.setVisible(false);

                workerMain3 = new generatePrimMRTalea_Worker(Integer.parseInt(jTextField10.getText()),Integer.parseInt(jTextField9.getText())); // workerMain is gloabale a reference to allow cancaling forward
                workerMain3.execute();

                 workerAnnim3 = new annimate4SquareWorker(jPanel34,jPanel33 , jPanel32, jPanel31, 250) ;
               workerAnnim3.execute();

                // timer worker
                timer3=new Timing(); // start timer   // timer1 is globale

                //////////////////////////////////////////////////////
                SwingWorker<Void, String> worker3
                = new SwingWorker<Void, String>() {

                    @Override
                    public Void doInBackground() throws InterruptedException {
                        Timing tm = new Timing();
                        timer3on = true;
                        while(timer3on) // flag to share between threads
                        {
                            Thread.sleep(50);

                            tm.updateDuration();
                            publish(tm.strTimeUnivMS());
                        }
                        return null; // of type type1
                    }

                    @Override
                    public void done() {
                        jTextField6.setText(timer3Str);
                    }

                    @Override
                    protected void process(final List<String> chunks) {

                        for (final String db : chunks) {
                            if(!this.isCancelled())
                            {
                                jTextField6.setText(db);
                            }

                        }
                    }

                };
                ///////////////////////////////////////////////////////////////////////////////
                worker3.execute();
            }else{
                jLabel41.setVisible(true);
                jLabel41.setText("Entrer les données d'abord !");
            }
        }else {
            jLabel41.setVisible(true);
            jLabel41.setText("attender le travail en cours !");
        }
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel42MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseEntered
        jLabel42.setBackground(new java.awt.Color(65, 59, 105));

        jLabel42.setForeground(new java.awt.Color(133, 126, 176));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel42MouseEntered

    private void jLabel42MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseExited
        jLabel42.setBackground(new java.awt.Color(48, 43, 81));

        jLabel42.setForeground(new java.awt.Color(107, 101, 146));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel42MouseExited

    private void jLabel42MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MousePressed
        jLabel42.setBackground(new java.awt.Color(92, 96, 146));

        jLabel42.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel42MousePressed

    private void jLabel42MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseReleased
        jLabel42.setBackground(new java.awt.Color(65, 59, 105));

        jLabel42.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel42MouseReleased

    
    Timing timer4; String timer4Str;   // timer 
    boolean timer4on ; // timer flag on/of
  boolean onWork4 = false; // flage explaining that the worker stay work (on work the action can't applied twice )
    generatePrimMRTnxt_Worker workerMain4; // my worker reference 
    annimate4SquareWorker workerAnnim4 ; 
    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        if(!onWork4){
             if(!(jTextField5.getText().equals("nbr bits")||jTextField5.getText().equals("")||jTextField11.getText().equals("Certitude")||jTextField11.getText().equals(""))){ // if data are here
                jTextArea4.setText("");
                jLabel49.setVisible(false);
                jLabel45.setVisible(false);
                jLabel38.setVisible(false);

                workerMain4 = new generatePrimMRTnxt_Worker(Integer.parseInt(jTextField5.getText()),Integer.parseInt(jTextField11.getText())); // workerMain is gloabale a reference to allow cancaling forward
                workerMain4.execute();

                 workerAnnim4 = new annimate4SquareWorker(jPanel39,jPanel38 , jPanel37, jPanel36, 250) ;
               workerAnnim4.execute();

                // timer worker
                timer4=new Timing(); // start timer   // timer1 is globale

                //////////////////////////////////////////////////////
                SwingWorker<Void, String> worker3
                = new SwingWorker<Void, String>() {

                    @Override
                    public Void doInBackground() throws InterruptedException {
                        Timing tm = new Timing();
                        timer4on = true;
                        while(timer4on) // flag to share between threads
                        {
                            Thread.sleep(50);

                            tm.updateDuration();
                            publish(tm.strTimeUnivMS());
                        }
                        return null; // of type type1
                    }

                    @Override
                    public void done() {
                        jTextField7.setText(timer4Str);
                    }

                    @Override
                    protected void process(final List<String> chunks) {

                        for (final String db : chunks) {
                            if(!this.isCancelled())
                            {
                                jTextField7.setText(db);
                            }

                        }
                    }

                };
                ///////////////////////////////////////////////////////////////////////////////
                worker3.execute();
            }else{
                jLabel38.setVisible(true);
                jLabel38.setText("Entrer les données d'abord !");
            }
        }else {
            jLabel38.setVisible(true);
            jLabel38.setText("attender le travail en cours !");
        }
    }//GEN-LAST:event_jLabel43MouseClicked

    private void jLabel43MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseEntered
        jLabel43.setBackground(new java.awt.Color(65, 59, 105));

        jLabel43.setForeground(new java.awt.Color(133, 126, 176));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MouseEntered

    private void jLabel43MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseExited
        jLabel43.setBackground(new java.awt.Color(48, 43, 81));

        jLabel43.setForeground(new java.awt.Color(107, 101, 146));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MouseExited

    private void jLabel43MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MousePressed
        jLabel43.setBackground(new java.awt.Color(92, 96, 146));

        jLabel43.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MousePressed

    private void jLabel43MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseReleased
        jLabel43.setBackground(new java.awt.Color(65, 59, 105));

        jLabel43.setForeground(new java.awt.Color(133, 126, 176));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel43MouseReleased

    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
 jTextField11.setBackground(new java.awt.Color(51, 46, 66));
        jTextField11.setForeground(new java.awt.Color(129, 126, 150));
        if(jTextField11.getText().equals("Certitude"))
        jTextField11.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusGained

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
 jTextField11.setBackground(new java.awt.Color(51, 46, 66));
        jTextField11.setForeground(new java.awt.Color(129, 126, 150));
        if(jTextField11.getText().equals(""))
        jTextField11.setText("Certitude");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusLost

    private void jTextField11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField11MouseEntered
  jTextField11.setFocusable(true);
        if(!jTextField11.isFocusOwner()){
            jTextField11.setBackground(new java.awt.Color(46, 41, 60));
            jTextField11.setForeground(new java.awt.Color(105, 101, 130));
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11MouseEntered

    private void jTextField11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField11MouseExited
 if(!jTextField11.isFocusOwner()){
            jTextField11.setBackground(new java.awt.Color(40, 36, 52));

            jTextField11.setForeground(new java.awt.Color(89, 85, 113));   }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11MouseExited

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyPressed

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
                                
char c = evt.getKeyChar();

if(!(Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}


    // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyTyped

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
                                
char c = evt.getKeyChar();

if(!(Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
                                
char c = evt.getKeyChar();

if(!(Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
                                
char c = evt.getKeyChar();

if(!(Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
                                
char c = evt.getKeyChar();

if(!(Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
                                
char c = evt.getKeyChar();

if(!(Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyTyped
Timing timer1; String timer1Str;   // timer 
boolean timer1on ; // timer flag on/of
  boolean onWork = false; // flage explaining that the worker stay work (on work the action can't applied twice )
    generatePrimPPTalea_Worker workerMain; // my worker reference 
    annimate4SquareWorker workerAnnim1 ; Timing timer2; String timer2Str;   // timer 
boolean timer2on ; // timer flag on/of
  boolean onWork2 = false; // flage explaining that the worker stay work (on work the action can't applied twice )
    generatePrimPPTnxt_Worker workerMain2; // my worker reference 
    annimate4SquareWorker workerAnnim2 ; 
    //boolean onWork4=false;
//genererNombreInterval_Worker workerMain4;Timing timer3; String timer3Str;   // timer 
//boolean timer3on ; // timer flag on/of
  //boolean onWork3 = false; // flage explaining that the worker stay work (on work the action can't applied twice )
   // form2PWtU_Worker workerMain3; // my worker reference 
    
  
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
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
