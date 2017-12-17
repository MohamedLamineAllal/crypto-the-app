
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
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;
import java.util.Locale;
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


public class G2mAES extends javax.swing.JFrame {

    /**
     * Creates new form mainJfram
     */
    public G2mAES() {
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








    public int multiplyPoly2M(int poly1, int poly2) {
        int result = 0;
        String binaryFormOfPoly2 = Integer.toBinaryString(poly2);
        int length = binaryFormOfPoly2.length();
        for (int i = 0; i < length; i++) {
            if (binaryFormOfPoly2.charAt(i) == '1') {
                result = result ^ poly1 << (length - 1 - i); // Xor with shifted left of poly1
            }
        }
        return result;
    }

    int numOfBitslog2(int value) {
        return Integer.SIZE - Integer.numberOfLeadingZeros(value);
    }

    public int reductionGalois2M(int poly, int reductionPoly) {
        int polynomial = poly;
        int reductionPolyBitsNum = numOfBitslog2(reductionPoly);
        int bitDiff = numOfBitslog2(polynomial) - reductionPolyBitsNum;

        while (bitDiff >= 0) {
            if (bitDiff > 0) {
                polynomial = polynomial ^ (reductionPoly << bitDiff);
            } else {
                polynomial = polynomial ^ reductionPoly;
            }

            bitDiff = numOfBitslog2(polynomial) - reductionPolyBitsNum;
        }
        return polynomial;
    }

    public int multiplyGalois2M(int poly1, int poly2, int reductionPoly) {
        return reductionGalois2M(multiplyPoly2M(poly1, poly2), reductionPoly);
    }

    public int modGalois(int poly, int polyModulo) {
        int polynomial = poly;
        int reductionPolyBitsNum = numOfBitslog2(polyModulo);
        int bitDiff = numOfBitslog2(polynomial) - reductionPolyBitsNum;

        while (bitDiff >= 0) {
            if (bitDiff > 0) {
                polynomial = polynomial ^ (polyModulo << bitDiff);
            } else {
                polynomial = polynomial ^ polyModulo;
            }

            bitDiff = numOfBitslog2(polynomial) - reductionPolyBitsNum;
        }
        return polynomial;
    }

    public int[] modDivGalois(int poly, int polyModulo) {
        int[] modDiv = new int[2];
        modDiv[1] = poly; // mod
        modDiv[0] = 0; // div quotient
        int reductionPolyBitsNum = numOfBitslog2(polyModulo);
        int bitDiff = numOfBitslog2(modDiv[1]) - reductionPolyBitsNum;

        while (bitDiff >= 0) {
            if (bitDiff > 0) {
                modDiv[1] = modDiv[1] ^ (polyModulo << bitDiff);
                modDiv[0] = modDiv[0] ^ (1 << bitDiff);
            } else {
                modDiv[1] = modDiv[1] ^ polyModulo;
                modDiv[0] = modDiv[0] ^ (1);
            }
            bitDiff = numOfBitslog2(modDiv[1]) - reductionPolyBitsNum;
        }
        return modDiv;
    }

    public int divGalois(int poly1, int poly2) {
        return modDivGalois(poly1, poly2)[0];
    }

    int[] EuclideEtenduGalois(int polyA, int polyB) {
        int[] result = new int[3];
        if (polyB == 0) {
            result[0] = polyA; //gcd
            result[1] = 1;    //x
            result[2] = 0;   //y
            return result;
        } else {

            result = EuclideEtenduGalois(polyB, modGalois(polyA, polyB));
            int X = result[1];
            result[1] = result[2];
            result[2] = X ^ multiplyPoly2M(divGalois(polyA, polyB), result[1]);
            return result;
        }
    }

    public int inverseGalois(int poly, int polyReduction) {
        return modGalois(EuclideEtenduGalois(poly, polyReduction)[1], polyReduction);

    }

     public int inverseGaloisAES(int poly) {
  int[] invGlAES  = { 
0x00 , 0x01 , 0x8D , 0xF6 , 0xCB , 0x52 , 0x7B , 0xD1 , 0xE8 , 0x4F , 0x29 , 0xC0 , 0xB0 , 0xE1 , 0xE5 , 0xC7 , 
0x74 , 0xB4 , 0xAA , 0x4B , 0x99 , 0x2B , 0x60 , 0x5F , 0x58 , 0x3F , 0xFD , 0xCC , 0xFF , 0x40 , 0xEE , 0xB2 , 
0x3A , 0x6E , 0x5A , 0xF1 , 0x55 , 0x4D , 0xA8 , 0xC9 , 0xC1 , 0x0A , 0x98 , 0x15 , 0x30 , 0x44 , 0xA2 , 0xC2 , 
0x2C , 0x45 , 0x92 , 0x6C , 0xF3 , 0x39 , 0x66 , 0x42 , 0xF2 , 0x35 , 0x20 , 0x6F , 0x77 , 0xBB , 0x59 , 0x19 , 
0x1D , 0xFE , 0x37 , 0x67 , 0x2D , 0x31 , 0xF5 , 0x69 , 0xA7 , 0x64 , 0xAB , 0x13 , 0x54 , 0x25 , 0xE9 , 0x09 , 
0xED , 0x5C , 0x05 , 0xCA , 0x4C , 0x24 , 0x87 , 0xBF , 0x18 , 0x3E , 0x22 , 0xF0 , 0x51 , 0xEC , 0x61 , 0x17 , 
0x16 , 0x5E , 0xAF , 0xD3 , 0x49 , 0xA6 , 0x36 , 0x43 , 0xF4 , 0x47 , 0x91 , 0xDF , 0x33 , 0x93 , 0x21 , 0x3B , 
0x79 , 0xB7 , 0x97 , 0x85 , 0x10 , 0xB5 , 0xBA , 0x3C , 0xB6 , 0x70 , 0xD0 , 0x06 , 0xA1 , 0xFA , 0x81 , 0x82 , 
0x83 , 0x7E , 0x7F , 0x80 , 0x96 , 0x73 , 0xBE , 0x56 , 0x9B , 0x9E , 0x95 , 0xD9 , 0xF7 , 0x02 , 0xB9 , 0xA4 , 
0xDE , 0x6A , 0x32 , 0x6D , 0xD8 , 0x8A , 0x84 , 0x72 , 0x2A , 0x14 , 0x9F , 0x88 , 0xF9 , 0xDC , 0x89 , 0x9A , 
0xFB , 0x7C , 0x2E , 0xC3 , 0x8F , 0xB8 , 0x65 , 0x48 , 0x26 , 0xC8 , 0x12 , 0x4A , 0xCE , 0xE7 , 0xD2 , 0x62 , 
0x0C , 0xE0 , 0x1F , 0xEF , 0x11 , 0x75 , 0x78 , 0x71 , 0xA5 , 0x8E , 0x76 , 0x3D , 0xBD , 0xBC , 0x86 , 0x57 , 
0x0B , 0x28 , 0x2F , 0xA3 , 0xDA , 0xD4 , 0xE4 , 0x0F , 0xA9 , 0x27 , 0x53 , 0x04 , 0x1B , 0xFC , 0xAC , 0xE6 , 
0x7A , 0x07 , 0xAE , 0x63 , 0xC5 , 0xDB , 0xE2 , 0xEA , 0x94 , 0x8B , 0xC4 , 0xD5 , 0x9D , 0xF8 , 0x90 , 0x6B , 
0xB1 , 0x0D , 0xD6 , 0xEB , 0xC6 , 0x0E , 0xCF , 0xAD , 0x08 , 0x4E , 0xD7 , 0xE3 , 0x5D , 0x50 , 0x1E , 0xB3 , 
0x5B , 0x23 , 0x38 , 0x34 , 0x68 , 0x46 , 0x03 , 0x8C , 0xDD , 0x9C , 0x7D , 0xA0 , 0xCD , 0x1A , 0x41 , 0x1C };
      
return invGlAES[poly] ;
    }
    
    public String inverseTableGeneration(int polyIrreductibleReduction) {
        int numberOfElement = numOfBitslog2(polyIrreductibleReduction)-1;

        String result = "{ 0x00 , ";
        int inverse;
        int k =1;
        for (int element = 1; element < (int) Math.pow(2, numberOfElement) - 1; element++) {
         if(k==16){
             k=0;
           result = result + "\n";  
         }
          
            inverse = inverseGalois(element, polyIrreductibleReduction);
            if(inverse < 16)
            result = result + "0x0" + Integer.toHexString(inverse).toUpperCase(Locale.ROOT) + " , ";
            else 
            result = result + "0x" + Integer.toHexString(inverse).toUpperCase(Locale.ROOT) + " , ";
          
         k++;      
        }
        inverse = inverseGalois((int) Math.pow(2, numberOfElement) - 1, polyIrreductibleReduction);
        if(inverse < 16)
            result = result + "0x0" + Integer.toHexString(inverse).toUpperCase(Locale.ROOT)+" }" ;
            else 
            result = result + "0x" + Integer.toHexString(inverse).toUpperCase(Locale.ROOT)+" }";
               

        return result;

    }

    int[] MultiplyMatriceVect(int[][] matrice, int[] vect){
       int[] resultVect = new int[matrice.length]; // ça taille est le nombre de lignes de la  matrice
        for(int i = 0; i<matrice.length; i++){ // lignes matrices
          resultVect[i] = 0;
            for(int j = 0; j<vect.length; j++) // cologne matrice , vect
            {
             resultVect[i] = resultVect[i]+matrice[i][j]*vect[j];   
            }
        }
    return resultVect;
    }
    
    String intToHexStr0x(int num){
        String result="";
        if(num < 16)
            result = result + "0x0" + Integer.toHexString(num).toUpperCase(Locale.ROOT);
            else 
            result = result + "0x" + Integer.toHexString(num).toUpperCase(Locale.ROOT);
    return result;
    }
   
    int AES_SboxAffineTr(int poly){
      int[] matriceTrAffine = {
           0xF1 /*<=11110001<={1,0,0,0,1,1,1,1}*/,
           0xE3 /*<=11100011<={1,1,0,0,0,1,1,1}*/,
           0xC7 /*<=11000111<={1,1,1,0,0,0,1,1}*/,
           0x8F /*<=10001111<={1,1,1,1,0,0,0,1}*/,
           0x1F /*<=00011111<={1,1,1,1,1,0,0,0}*/,
           0x3E /*<=00111110<={0,1,1,1,1,1,0,0}*/,
           0x7C /*<=01111100<={0,0,1,1,1,1,1,0}*/,
           0xF8 /*<=11111000<={0,0,0,1,1,1,1,1}*/ 
       }; 
             
      // int vectTrAffine = 0x63 /*<=01100011<={1,1,0,0,0,1,1,0}*/;
       int result = 0;
       
       for(int i = 0; i<8; i++){
          if(Math.floorMod(Integer.bitCount(matriceTrAffine[i]&poly), 2)==1)  
           result = result^(1<<i) ;
       }
       
       result = result ^ 0x63 /*vectTrAffine*/;
       return result;
    }
    
    int Inv_AES_SboxAffineTr(int poly){
      int[] matriceTrAffine = {
           

           0xA4 /*<=10100100<={0,0,1,0,0,1,0,1}*/,
           0x49 /*<=01001001<={1,0,0,1,0,0,1,0}*/,
           0x92 /*<=10010010<={0,1,0,0,1,0,0,1}*/,
           0x25 /*<=00100101<={1,0,1,0,0,1,0,0}*/, 
           0x4A /*<=01001010<={0,1,0,1,0,0,1,0}*/,
           0x94 /*<=10010100<={0,0,1,0,1,0,0,1}*/,
           0x29 /*<=00101001<={1,0,0,1,0,1,0,0}*/,
           0x52 /*<=01010010<={0,1,0,0,1,0,1,0}*/
      }; 
             
      // int vectTrAffine = 0x05 /*<=00000101<={1,0,1,0,0,0,0,0}*/;
       int result = 0;
       
       for(int i = 0; i<8; i++){
          if(Math.floorMod(Integer.bitCount(matriceTrAffine[i]&poly), 2)==1)  
           result = result^(1<<i) ;
       }
       
       result = result ^ 0x05 /*vectTrAffine*/;
       return result;
    }
    
    
    /*
    int Aes_SboxAffineTr(int poly){
      int[] polyAff = new int[8];
      String polyStr = Integer.toBinaryString(poly);
      int lenghtStr = polyStr.length();
      for(int i =0; i<lenghtStr; i++)
      {
          if(polyStr.charAt(i)=='1')
              polyAff[i] = 1;
          else 
              polyAff[i]=0;
      }
      
      for(int i = lenghtStr ; i< 8 ;i++)
           polyAff[i]=0;
      
        int[][] matriceTrAffine = {
           {1,0,0,0,1,1,1,1},
           {1,1,0,0,0,1,1,1},
           {1,1,1,0,0,0,1,1},
           {1,1,1,1,0,0,0,1},
           {1,1,1,1,1,0,0,0},
            {0,1,1,1,1,1,0,0},
           {0,0,1,1,1,1,1,0},
          {0,0,0,1,1,1,1,1} 
       }; 
             
      int[] vectTrAffine ={1,1,0,0,0,1,1,0};
       int[] result = new int[8];
       
       for(int i = 0; i<8; i++){
           result[i]=0;
           for(int j = 0; j<8;j++)
          result[i] ^= matriceTrAffine[i][j] & polyAff[j];    
       }
       for(int i = 0; i<8; i++)
       result[i] ^= vectTrAffine[i];
       
       int resultInt =result[0];
       for(int i =1; i<8; i++){
          if(result[i]==1)
           resultInt ^= (1<<i);
       }
       return resultInt;
    }
   */ 
  public   int AesSbox(int poly){
     return AES_SboxAffineTr(inverseGalois(poly,283 ));
  }
  
  
  
   int[] Sbox   = 
  { 
0x63 , 0x7C , 0x77 , 0x7B , 0xF2 , 0x6B , 0x6F , 0xC5 , 0x30 , 0x01 , 0x67 , 0x2B , 0xFE , 0xD7 , 0xAB , 0x76 , 
0xCA , 0x82 , 0xC9 , 0x7D , 0xFA , 0x59 , 0x47 , 0xF0 , 0xAD , 0xD4 , 0xA2 , 0xAF , 0x9C , 0xA4 , 0x72 , 0xC0 , 
0xB7 , 0xFD , 0x93 , 0x26 , 0x36 , 0x3F , 0xF7 , 0xCC , 0x34 , 0xA5 , 0xE5 , 0xF1 , 0x71 , 0xD8 , 0x31 , 0x15 , 
0x04 , 0xC7 , 0x23 , 0xC3 , 0x18 , 0x96 , 0x05 , 0x9A , 0x07 , 0x12 , 0x80 , 0xE2 , 0xEB , 0x27 , 0xB2 , 0x75 , 
0x09 , 0x83 , 0x2C , 0x1A , 0x1B , 0x6E , 0x5A , 0xA0 , 0x52 , 0x3B , 0xD6 , 0xB3 , 0x29 , 0xE3 , 0x2F , 0x84 , 
0x53 , 0xD1 , 0x00 , 0xED , 0x20 , 0xFC , 0xB1 , 0x5B , 0x6A , 0xCB , 0xBE , 0x39 , 0x4A , 0x4C , 0x58 , 0xCF , 
0xD0 , 0xEF , 0xAA , 0xFB , 0x43 , 0x4D , 0x33 , 0x85 , 0x45 , 0xF9 , 0x02 , 0x7F , 0x50 , 0x3C , 0x9F , 0xA8 , 
0x51 , 0xA3 , 0x40 , 0x8F , 0x92 , 0x9D , 0x38 , 0xF5 , 0xBC , 0xB6 , 0xDA , 0x21 , 0x10 , 0xFF , 0xF3 , 0xD2 , 
0xCD , 0x0C , 0x13 , 0xEC , 0x5F , 0x97 , 0x44 , 0x17 , 0xC4 , 0xA7 , 0x7E , 0x3D , 0x64 , 0x5D , 0x19 , 0x73 , 
0x60 , 0x81 , 0x4F , 0xDC , 0x22 , 0x2A , 0x90 , 0x88 , 0x46 , 0xEE , 0xB8 , 0x14 , 0xDE , 0x5E , 0x0B , 0xDB , 
0xE0 , 0x32 , 0x3A , 0x0A , 0x49 , 0x06 , 0x24 , 0x5C , 0xC2 , 0xD3 , 0xAC , 0x62 , 0x91 , 0x95 , 0xE4 , 0x79 , 
0xE7 , 0xC8 , 0x37 , 0x6D , 0x8D , 0xD5 , 0x4E , 0xA9 , 0x6C , 0x56 , 0xF4 , 0xEA , 0x65 , 0x7A , 0xAE , 0x08 , 
0xBA , 0x78 , 0x25 , 0x2E , 0x1C , 0xA6 , 0xB4 , 0xC6 , 0xE8 , 0xDD , 0x74 , 0x1F , 0x4B , 0xBD , 0x8B , 0x8A , 
0x70 , 0x3E , 0xB5 , 0x66 , 0x48 , 0x03 , 0xF6 , 0x0E , 0x61 , 0x35 , 0x57 , 0xB9 , 0x86 , 0xC1 , 0x1D , 0x9E , 
0xE1 , 0xF8 , 0x98 , 0x11 , 0x69 , 0xD9 , 0x8E , 0x94 , 0x9B , 0x1E , 0x87 , 0xE9 , 0xCE , 0x55 , 0x28 , 0xDF , 
0x8C , 0xA1 , 0x89 , 0x0D , 0xBF , 0xE6 , 0x42 , 0x68 , 0x41 , 0x99 , 0x2D , 0x0F , 0xB0 , 0x54 , 0xBB , 0x16 };
 
  public   int AesSboxTbl(int poly){
        return Sbox[poly];
  }
  
  public   int invAesSbox(int poly){
     return inverseGalois(Inv_AES_SboxAffineTr(poly),283 );
  }
  
   int[] invSbox =   {
0x52 , 0x09 , 0x6A , 0xD5 , 0x30 , 0x36 , 0xA5 , 0x38 , 0xBF , 0x40 , 0xA3 , 0x9E , 0x81 , 0xF3 , 0xD7 , 0xFB , 
0x7C , 0xE3 , 0x39 , 0x82 , 0x9B , 0x2F , 0xFF , 0x87 , 0x34 , 0x8E , 0x43 , 0x44 , 0xC4 , 0xDE , 0xE9 , 0xCB , 
0x54 , 0x7B , 0x94 , 0x32 , 0xA6 , 0xC2 , 0x23 , 0x3D , 0xEE , 0x4C , 0x95 , 0x0B , 0x42 , 0xFA , 0xC3 , 0x4E , 
0x08 , 0x2E , 0xA1 , 0x66 , 0x28 , 0xD9 , 0x24 , 0xB2 , 0x76 , 0x5B , 0xA2 , 0x49 , 0x6D , 0x8B , 0xD1 , 0x25 , 
0x72 , 0xF8 , 0xF6 , 0x64 , 0x86 , 0x68 , 0x98 , 0x16 , 0xD4 , 0xA4 , 0x5C , 0xCC , 0x5D , 0x65 , 0xB6 , 0x92 , 
0x6C , 0x70 , 0x48 , 0x50 , 0xFD , 0xED , 0xB9 , 0xDA , 0x5E , 0x15 , 0x46 , 0x57 , 0xA7 , 0x8D , 0x9D , 0x84 , 
0x90 , 0xD8 , 0xAB , 0x00 , 0x8C , 0xBC , 0xD3 , 0x0A , 0xF7 , 0xE4 , 0x58 , 0x05 , 0xB8 , 0xB3 , 0x45 , 0x06 , 
0xD0 , 0x2C , 0x1E , 0x8F , 0xCA , 0x3F , 0x0F , 0x02 , 0xC1 , 0xAF , 0xBD , 0x03 , 0x01 , 0x13 , 0x8A , 0x6B , 
0x3A , 0x91 , 0x11 , 0x41 , 0x4F , 0x67 , 0xDC , 0xEA , 0x97 , 0xF2 , 0xCF , 0xCE , 0xF0 , 0xB4 , 0xE6 , 0x73 , 
0x96 , 0xAC , 0x74 , 0x22 , 0xE7 , 0xAD , 0x35 , 0x85 , 0xE2 , 0xF9 , 0x37 , 0xE8 , 0x1C , 0x75 , 0xDF , 0x6E , 
0x47 , 0xF1 , 0x1A , 0x71 , 0x1D , 0x29 , 0xC5 , 0x89 , 0x6F , 0xB7 , 0x62 , 0x0E , 0xAA , 0x18 , 0xBE , 0x1B , 
0xFC , 0x56 , 0x3E , 0x4B , 0xC6 , 0xD2 , 0x79 , 0x20 , 0x9A , 0xDB , 0xC0 , 0xFE , 0x78 , 0xCD , 0x5A , 0xF4 , 
0x1F , 0xDD , 0xA8 , 0x33 , 0x88 , 0x07 , 0xC7 , 0x31 , 0xB1 , 0x12 , 0x10 , 0x59 , 0x27 , 0x80 , 0xEC , 0x5F , 
0x60 , 0x51 , 0x7F , 0xA9 , 0x19 , 0xB5 , 0x4A , 0x0D , 0x2D , 0xE5 , 0x7A , 0x9F , 0x93 , 0xC9 , 0x9C , 0xEF , 
0xA0 , 0xE0 , 0x3B , 0x4D , 0xAE , 0x2A , 0xF5 , 0xB0 , 0xC8 , 0xEB , 0xBB , 0x3C , 0x83 , 0x53 , 0x99 , 0x61 , 
0x17 , 0x2B , 0x04 , 0x7E , 0xBA , 0x77 , 0xD6 , 0x26 , 0xE1 , 0x69 , 0x14 , 0x63 , 0x55 , 0x21 , 0x0C , 0x7D };

  public   int invAesSboxTbl(int poly){
   
  return invSbox[poly];
  }
  
    public String AesSboxTableGeneration() {
        String result ="{ ";
        int sBoxElement;
       int k=0;
        for (int element = 0; element < 255 ; element++) {
         if(k==16){
             k=0;
           result = result + "\n";  
         }
          
            
            sBoxElement = AesSbox(element); //283 = 100011011 = pi(x) AES irreductible polynomial
            if(sBoxElement < 16)
            result = result + "0x0" + Integer.toHexString(sBoxElement).toUpperCase(Locale.ROOT) + " , ";
            else 
            result = result + "0x" + Integer.toHexString(sBoxElement).toUpperCase(Locale.ROOT) + " , ";
   k++;
        }
         sBoxElement = AesSbox(255);
        if(sBoxElement < 16)
            result = result + "0x0" + Integer.toHexString(sBoxElement).toUpperCase(Locale.ROOT)+" }" ;
            else 
            result = result + "0x" + Integer.toHexString(sBoxElement).toUpperCase(Locale.ROOT)+" }";
               

        return result;

    }
   
    public String invAesSboxTableGeneration() {
        String result ="{ ";
        int sBoxElement;
        int k=0;
        for (int element = 0; element < 255 ; element++) {
                       
      if(k==16){
             k=0;
           result = result + "\n";  
         }
          
            
            sBoxElement = invAesSbox(element); //283 = 100011011 = pi(x) AES irreductible polynomial
            if(sBoxElement < 16)
            result = result + "0x0" + Integer.toHexString(sBoxElement).toUpperCase(Locale.ROOT) + " , ";
            else 
            result = result + "0x" + Integer.toHexString(sBoxElement).toUpperCase(Locale.ROOT) + " , ";
            
            k++;
        }
         sBoxElement = invAesSbox(255);
        if(sBoxElement < 16)
            result = result + "0x0" + Integer.toHexString(sBoxElement).toUpperCase(Locale.ROOT)+" }" ;
            else 
            result = result + "0x" + Integer.toHexString(sBoxElement).toUpperCase(Locale.ROOT)+" }";
               

        return result;

    }
    
    
   public int[][] AesSubtituteLayer(int[][] state) 
   {
       int[][] result = new int[4][4];
       for(int i = 0; i <4;i++){
           for(int j = 0;j<4 ; j++){
               result[i][j] =Sbox[state[i][j]] ; // sBox should be globale
           }
       }
       return result;
   }
    
  public int[][] invAesSubtituteLayer(int[][] state) 
   {
       int[][] result = new int[4][4];
       for(int i = 0; i <4;i++){
           for(int j = 0;j<4 ; j++){
               result[i][j] =invSbox[state[i][j]] ; // invSBox should be globale
           }
       }
       return result;
   }  
    
   public int[][]  shiftRowLayer(int[][] state){
       int[][] result = new int[4][4];
       //row 1
        System.arraycopy(state[0], 0, result[0], 0, 4);
       
        //row2 (1 shift)
        System.arraycopy(state[1], 1, result[1], 0, 3);
       result[1][3] = state[1][0 ];
     
       //row3  (2 shifts)
       System.arraycopy(state[2], 2, result[2], 0, 2);
       System.arraycopy(state[2], 0, result[2], 2, 2);
        
       //row4  (3 shifts)
       System.arraycopy(state[3], 0, result[3], 1, 3);
       result[3][0] = state[3][3];
       
      return result; 
   }
   
      public int[][]  invShiftRowLayer(int[][] state){
       int[][] result = new int[4][4];
       //row 1
        System.arraycopy(state[0], 0, result[0], 0, 4);
       
        //row2 (1 shift)
        System.arraycopy(state[1], 0, result[1], 1, 3);
       result[1][0] = state[1][3 ];
     
       //row3  (2 shifts)
       System.arraycopy(state[2], 0, result[2], 2, 2);
       System.arraycopy(state[2],2, result[2], 0, 2);
        
       //row4  (3 shifts)
       System.arraycopy(state[3], 1, result[3], 0, 3);
       result[3][3] = state[3][0];
       
      return result; 
   }
      
      int[] mixColumn(int[] column){
          int[] result = new int[4];
         result[0]= reductionGalois2M(column[0]<<1,  0x11B) ^ reductionGalois2M((column[1]<<1)^column[1], 0x11B)^column[2]^column[3];
      
          result[1]=column[0]^ reductionGalois2M(column[1]<<1, 0x11B) ^ reductionGalois2M((column[2]<<1)^column[2], 0x11B)^column[3];
     
          result[2]=column[0]^column[1]^ reductionGalois2M(column[2]<<1, 0x11B) ^ reductionGalois2M((column[3]<<1)^column[3], 0x11B);
      
          result[3]=reductionGalois2M((column[0]<<1)^column[0], 0x11B)^column[1]^column[2]^ reductionGalois2M(column[3]<<1, 0x11B);
          
          /* 
          result[0]= multiplyGalois2M(column[0], 0x02, 0x11B) ^ multiplyGalois2M(column[1], 0x03, 0x11B)^column[2]^column[3];
      
          result[1]=column[0]^ multiplyGalois2M(column[1], 0x02, 0x11B) ^ multiplyGalois2M(column[2], 0x03, 0x11B)^column[3];
     
          result[2]=column[0]^column[1]^ multiplyGalois2M(column[2], 0x02, 0x11B) ^ multiplyGalois2M(column[3], 0x03, 0x11B);
      
          result[2]=multiplyGalois2M(column[0], 0x03, 0x11B)^column[1]^column[2]^ multiplyGalois2M(column[3], 0x02, 0x11B);
          */
          
          return result;
      }
      
      int[] invMixColumn(int[] column){
          int[] result = new int[4];
          
          
          result[0]= multiplyGalois2M(column[0], 0x0E, 0x11B) ^ multiplyGalois2M(column[1], 0x0B, 0x11B)^multiplyGalois2M(column[2], 0x0D, 0x11B)^multiplyGalois2M(column[3], 0x09, 0x11B);
      
          result[1]=multiplyGalois2M(column[0], 0x09, 0x11B)^ multiplyGalois2M(column[1], 0x0E, 0x11B) ^ multiplyGalois2M(column[2], 0x0B, 0x11B)^multiplyGalois2M(column[3], 0x0D, 0x11B);
     
          result[2]=multiplyGalois2M(column[0], 0x0D, 0x11B)^multiplyGalois2M(column[1], 0x09, 0x11B)^ multiplyGalois2M(column[2], 0x0E, 0x11B) ^ multiplyGalois2M(column[3], 0x0B, 0x11B);
      
          result[3]=multiplyGalois2M(column[0], 0x0B, 0x11B)^multiplyGalois2M(column[1], 0x0D, 0x11B)^multiplyGalois2M(column[2], 0x09, 0x11B)^ multiplyGalois2M(column[3], 0x0E, 0x11B);
          
          
          return result;
      }
      
      
       int[][] mixColumnLayer(int[][] state){
           int[][]  result = new int[4][4];
           int[] mixColumn;
           
           mixColumn = mixColumn(new int[]{state[0][0],state[1][0],state[2][0],state[3][0]});
           for(int i = 0; i<4; i++){
             result[i][0] = mixColumn[i];  
           }
           
           mixColumn = mixColumn(new int[]{state[0][1],state[1][1],state[2][1],state[3][1]});
           for(int i = 0; i<4; i++){
             result[i][1] = mixColumn[i];  
           }
           
           mixColumn = mixColumn(new int[]{state[0][2],state[1][2],state[2][2],state[3][2]});
           for(int i = 0; i<4; i++){
             result[i][2] = mixColumn[i];  
           }
           
           mixColumn = mixColumn(new int[]{state[0][3],state[1][3],state[2][3],state[3][3]});
           for(int i = 0; i<4; i++){
             result[i][3] = mixColumn[i];  
           }
           
          return result; 
       }
       
       int[][] invMixColumnLayer(int[][] state){
           int[][]  result = new int[4][4];
           int[] mixColumn;
           
           mixColumn = mixColumn(new int[]{state[0][0],state[1][0],state[2][0],state[3][0]});
           for(int i = 0; i<4; i++){
             result[i][0] = mixColumn[i];  
           }
           
           mixColumn = mixColumn(new int[]{state[0][1],state[1][1],state[2][1],state[3][1]});
           for(int i = 0; i<4; i++){
             result[i][1] = mixColumn[i];  
           }
           
           mixColumn = mixColumn(new int[]{state[0][2],state[1][2],state[2][2],state[3][2]});
           for(int i = 0; i<4; i++){
             result[i][2] = mixColumn[i];  
           }
           
           mixColumn = mixColumn(new int[]{state[0][3],state[1][3],state[2][3],state[3][3]});
           for(int i = 0; i<4; i++){
             result[i][3] = mixColumn[i];  
           }
           
          return result; 
       }
       
       
       //////////////////////
       int[] RC = {0x01,0x02,0x04,0x08,0x10,0x20,0x40,0x80,0x1B,0x36};
     public int[] fonctionG(int[] vect, int index){
         int[] result ={vect[1],vect[2],vect[3],vect[0]};
         
         result[0] = Sbox[result[0]]^RC[index-1];
         result[1] = Sbox[result[1]];
         result[2] = Sbox[result[2]];
         result[3] = Sbox[result[3]];
         
         return result;
     }
     ///////////////////////////////
     
     
     public int[] wordXOR(int[] word1, int[] word2){
        return new int[]{(word1[0]^word2[0]),(word1[1]^word2[1]),(word1[2]^word2[2]),(word1[3]^word2[3])};
     } 
     


      class Polynome{
       private
               
           int[] poly; 
           int degree;  
        
        public
        
          Polynome(int[]Poly, int Degree){
              poly =Poly;
              degree=Degree;
          }       
          public Polynome(String str) {
          degree= str.length()-1;
         
          poly= new int[degree+1];
          
           for(int i = 0;i<=degree;i++)
          poly[i]=Integer.parseInt(String.valueOf(str.charAt(degree-i)));
        }
        
        public Polynome(int[] pl) {
          degree= pl.length-1;
         
          poly= pl;
          
             }
        
       public  int[] getPoly(){
            return poly;
        }
                
     public    int degree(){
            return degree;
        }

     public int getCoeficientAt(int i)
     {
         return poly[i];
     }
     
     public void setCoeficientAt(int i, int val )
     {
         poly[i] = val;
         
     }
     
     private int isNextPositive(int[] array , int startFrom )
     {
         
         for(int i = startFrom+1; i<array.length; i++)
         {if(array[i]>0)
                 return 1;
         if(array[i]<0)
             return -1;
             
             }
         return 0;
     }
     
     

     
     
     
     
         @Override
      public  String toString(){
            String str= new String("");
            int i;
            if(degree == 0)
                return String.valueOf(poly[0]);
            else{
            
            for( i  =0; i<degree; i++)
            {   if(i==0){
                if(poly[0]!=0){
                str=str+poly[0];
                if(isNextPositive(poly, i)==1)
                    str=str+" + ";
                else if(isNextPositive(poly, 0)==-1)
                    str=str+" - ";
                }
                else {
                    if(isNextPositive(poly, 0)==-1)
                    str=str+" - ";
            }
            }
               
            
            else{
                if(poly[i]==1||poly[i]==-1){
                str=str+"x^"+i;
                if(isNextPositive(poly, i)==1)
                    str=str+" + ";
                else if(isNextPositive(poly, i)==-1)
                    str=str+" - ";
                }
                else if(poly[i]==0)
               ;
                else {
                str=str+String.valueOf(Math.abs(poly[i]))+".x^"+i;
                if(isNextPositive(poly, i)==1)
                    str=str+" + ";
                else if(isNextPositive(poly, i)==-1)
                    str=str+" - ";
                     }
            }
            }
           if(poly[i]==1||poly[i]==-1)
                str=str+"x^"+i;
                else if(poly[i]==0)
               ;
                else 
                str=str+String.valueOf(Math.abs(poly[i]))+".x^"+i;
            }
            return str;
        }
        
       public  String toStringV2(){
            String str= new String("");
            int i;
            for( i  =degree; i>=0; i++)
            {   if(i==0&&poly[0]!=0)
                  str=str+poly[0];
                else if(i==1){
                if(poly[0]==0)
                str=str+String.valueOf(poly[i])+".x^"+i;
                else
                 str=str+String.valueOf(poly[i])+".x^"+i+" + ";
            }
                
            else{
                if(poly[i]==1)
                str=str+"x^"+i+" + ";
                else if(poly[i]==0)
               ;
                else 
                str=str+String.valueOf(poly[i])+".x^"+i+" + ";
                }
            }
           if(poly[i]==1)
                str=str+"x^"+i;
                else if(poly[i]==0)
               ;
                else 
                str=str+String.valueOf(poly[i])+".x^"+i;
            
            return str;
        }

 private Polynome correctTable(){
     int lastIndex = 0;
     for(int i=0;i<=degree;i++)
     if(poly[i]!=0)
         lastIndex = i;
     
     int[] polyCorrect =new int[lastIndex+1]; 
     
     for(int i = 0; i<=lastIndex; i++)
         polyCorrect[i]=poly[i];
     
     degree = lastIndex;
     poly = polyCorrect;
     
   
     
     return this; 
 }      
         
            Polynome add(Polynome pl){
             int minDeg =Math.min(pl.degree, degree);
             int maxDeg = Math.max(pl.degree, degree); 
                     
             int[] resultPoly = new int[maxDeg+1];
             for(int i =0; i<= minDeg ;i++)
             {
                 resultPoly[i]=pl.getPoly()[i]+poly[i];
             }
             
             if(minDeg == degree)
             {
                 for (int i=minDeg+1; i<=maxDeg;i++){
                     resultPoly[i]= pl.getPoly()[i];
                 }
             }           
             
             else{
                       for (int i=minDeg+1; i<=maxDeg;i++){
                        resultPoly[i]= poly[i];
                        }
                 }
             return new Polynome(resultPoly, maxDeg).correctTable();
         }
         
         public Polynome multiply(Polynome pl){
            int degPlResult = degree+ pl.degree();
             int minDeg =Math.min(pl.degree, degree);
             int maxDeg = Math.max(pl.degree, degree); 
             
             int[] resultPoly = new int[degPlResult+1]; 
              
             if(degree==minDeg){
             for(int i =0; i<=degPlResult ; i++){
              resultPoly[i]=0;
                 for(int j =0;j<=Math.min(i, minDeg);j++){
                 if(i-j<=maxDeg)
                     resultPoly[i]=resultPoly[i]+poly[j]*pl.getPoly()[i-j];
                 }
                 
             }
             
             }else{
                   for(int i =0; i<=degPlResult ; i++){
              resultPoly[i]=0;
                 for(int j =0;j<=Math.min(i, minDeg);j++){
                 if(i-j<=maxDeg)
                     resultPoly[i]=resultPoly[i]+pl.getPoly()[j]*poly[i-j];
                 }             
             }   
                     }
                 return new Polynome(resultPoly, degPlResult).correctTable();
             }
        
         public Polynome substract(Polynome pl){
           int minDeg =Math.min(pl.degree, degree);
             int maxDeg = Math.max(pl.degree, degree); 
                     
             int[] resultPoly = new int[maxDeg+1];
             
             for(int i =0; i<= minDeg ;i++)
             {
                 resultPoly[i]=poly[i]-pl.getPoly()[i];
             }
             
             if(minDeg == degree)
             {
                 for (int i=minDeg+1; i<=maxDeg;i++){
                     resultPoly[i]= -pl.getPoly()[i];
                 }
             }           
             
             else{
                       for (int i=minDeg+1; i<=maxDeg;i++){
                        resultPoly[i]= poly[i];
                        }
                 }
             return new Polynome(resultPoly, maxDeg).correctTable();  
         }
         
         
         public Polynome mod(Polynome pl)
         {   
             Polynome A = this;
             Polynome quotient;
             int[] q;
             int diffDegree;
                 
               while(A.degree() >= pl.degree()){
                     if(A.degree()==pl.degree()){
                int[] coef = {A.getCoeficientAt(A.degree())} ;
                
                    return A.substract(pl.multiply(new Polynome(coef))).correctTable();
                     
                     }
                     else{
             diffDegree= A.degree()-pl.degree();
               
                     q=new int[diffDegree+1];
              
                     for(int i = 0;i<diffDegree;i++)
                    q[i]=0;
                
                q[diffDegree]=A.getCoeficientAt(A.degree());
                
                 quotient = new Polynome(q);
                 
                 A=A.substract(pl.multiply(quotient)).correctTable();
                     }                 
             }
               return A.correctTable();
            }
             
             
             
         
         
         
         
         
          public Polynome[] divideCouple(Polynome pl)
         {   
             if(degree<pl.degree())
             {   int[] zero = {0};
                 Polynome[] result = {new Polynome(zero), this };
             
                 return result;
                     
                     } 
             else{
             Polynome A = this;
             int diffDegree=degree-pl.degree();
             int[] quot = new int[diffDegree+1];
             for(int i=0; i<= diffDegree;i++)
                 quot[i]=0;
             Polynome quotient = new Polynome(quot);
             Polynome qut;
             int[] q;
             
                 
               while(A.degree() >= pl.degree()){
                     if(A.degree()==pl.degree()){
                int[] coef = {A.getCoeficientAt(A.degree())} ;
                quotient.setCoeficientAt(0,coef[0]);
                Polynome[] result = {quotient,A.substract(pl.multiply(new Polynome(coef))).correctTable()};
                    return result ;
                     
                     }
                     else{
             diffDegree= A.degree()-pl.degree();
               
                     q=new int[diffDegree+1];
              
                     for(int i = 0;i<diffDegree;i++)
                    q[i]=0;
                
                q[diffDegree]=A.getCoeficientAt(A.degree());
                quotient.setCoeficientAt(diffDegree,A.getCoeficientAt(A.degree()));
                 qut = new Polynome(q);
                 
                 A=A.substract(pl.multiply(qut)).correctTable();
                 
                     }                 
             }
               
               Polynome[] result = {quotient,A.correctTable()};
               return result;
           
         
         }
         }
          
          
          
          
          
          
          
          
          
          
          
          
          Polynome reduceCoeficient(int modulo){
              for(int i = 0; i<=degree ; i++)
                  poly[i] = Math.floorMod(poly[i],modulo);
              
              this.correctTable();
              return this;
          }
          
          
          
          Polynome addMod(Polynome pl,int modulo){
            this.reduceCoeficient(modulo);
            pl.reduceCoeficient(modulo);
           
            this.correctTable();
            pl.correctTable();
            
              int minDeg =Math.min(pl.degree, degree);
             int maxDeg = Math.max(pl.degree, degree); 
                     
             int[] resultPoly = new int[maxDeg+1];
             for(int i =0; i<= minDeg ;i++)
             {
                 resultPoly[i]=Math.floorMod(pl.getPoly()[i]+poly[i], modulo);
             }
             
             if(minDeg == degree)
             {
                 for (int i=minDeg+1; i<=maxDeg;i++){
                     resultPoly[i]=Math.floorMod(pl.getPoly()[i], modulo) ;
                 }
             }           
             
             else{
                       for (int i=minDeg+1; i<=maxDeg;i++){
                        resultPoly[i]=Math.floorMod(poly[i], modulo) ;
                        }
                 }
             return new Polynome(resultPoly, maxDeg).correctTable();
         }
         
         public Polynome multiplyModulo(Polynome pl, int modulo){
           
              this.reduceCoeficient(modulo);
            pl.reduceCoeficient(modulo);
           
            this.correctTable();
            pl.correctTable();
             
             int degPlResult = degree+ pl.degree();
             int minDeg =Math.min(pl.degree, degree);
             int maxDeg = Math.max(pl.degree, degree); 
             
             int[] resultPoly = new int[degPlResult+1]; 
              
             if(degree==minDeg){
             for(int i =0; i<=degPlResult ; i++){
              resultPoly[i]=0;
                 for(int j =0;j<=Math.min(i, minDeg);j++){
                 if(i-j<=maxDeg)
                     resultPoly[i]=Math.floorMod(resultPoly[i]+poly[j]*pl.getPoly()[i-j], modulo);
                 }
                 
             }
             
             }else{
                   for(int i =0; i<=degPlResult ; i++){
              resultPoly[i]=0;
                 for(int j =0;j<=Math.min(i, minDeg);j++){
                 if(i-j<=maxDeg)
                     resultPoly[i]=Math.floorMod(resultPoly[i]+pl.getPoly()[j]*poly[i-j], modulo);
                 }             
             }   
                     }
                 return new Polynome(resultPoly, degPlResult).correctTable();
             }
        
         public Polynome substractModulo(Polynome pl, int modulo){
           
           
              this.reduceCoeficient(modulo);
            pl.reduceCoeficient(modulo);
           
            this.correctTable();
            pl.correctTable();  
             
             int minDeg =Math.min(pl.degree, degree);
             int maxDeg = Math.max(pl.degree, degree); 
                     
             int[] resultPoly = new int[maxDeg+1];
             
             for(int i =0; i<= minDeg ;i++)
             {
                 resultPoly[i]=Math.floorMod(poly[i]-pl.getPoly()[i], modulo);
             }
             
             if(minDeg == degree)
             {
                 for (int i=minDeg+1; i<=maxDeg;i++){
                     resultPoly[i]=Math.floorMod(-pl.getPoly()[i], modulo) ;
                 }
             }           
             
             else{
                       for (int i=minDeg+1; i<=maxDeg;i++){
                        resultPoly[i]=Math.floorMod(poly[i], modulo) ;
                        }
                 }
             return new Polynome(resultPoly, maxDeg).correctTable();  
         }
         
         
         public Polynome modModulo(Polynome pl, int modulo)
         {   
              this.reduceCoeficient(modulo);
            pl.reduceCoeficient(modulo);
           
            this.correctTable();
            pl.correctTable();  
            
            
             Polynome A = this;
             Polynome quotient;
             int[] q;
             int diffDegree;
                 
               while(A.degree() >= pl.degree()){
                     if(A.degree() == pl.degree()){
                int[] coef = {A.getCoeficientAt(A.degree())} ;
                
                    return A.substract(pl.multiply(new Polynome(coef))).reduceCoeficient(modulo).correctTable();
                     
                     }
                     else{
             diffDegree= A.degree()-pl.degree();
               
                     q=new int[diffDegree+1];
              
                     for(int i = 0;i<diffDegree;i++)
                    q[i]=0;
                
                q[diffDegree]=A.getCoeficientAt(A.degree());
                
                 quotient = new Polynome(q);
                 
                 A=A.substract(pl.multiply(quotient)).reduceCoeficient(modulo).correctTable();
                     }                 
             }
               return A.reduceCoeficient(modulo).correctTable();
            }
             
             
             
         
         
         
         
         
          public Polynome[] divideCoupleModulo(Polynome pl, int modulo)
         {   
             this.reduceCoeficient(modulo);
            pl.reduceCoeficient(modulo);
           
            this.correctTable();
            pl.correctTable();  
             
             if(degree<pl.degree())
             {   int[] zero = {0};
                 Polynome[] result = {new Polynome(zero), this };
             
                 return result;
                     
                     } 
             else{
             Polynome A = this;
             int diffDegree=degree-pl.degree();
             int[] quot = new int[diffDegree+1];
             for(int i=0; i<= diffDegree;i++)
                 quot[i]=0;
             Polynome quotient = new Polynome(quot);
             Polynome qut;
             int[] q;
             
                 
               while(A.degree() >= pl.degree()){
                     if(A.degree()==pl.degree()){
                int[] coef = {A.getCoeficientAt(A.degree())} ;
                quotient.setCoeficientAt(0,coef[0]);
                Polynome[] result = {quotient.reduceCoeficient(modulo).correctTable(),A.substract(pl.multiply(new Polynome(coef))).reduceCoeficient(modulo).correctTable()};
                    return result ;
                     
                     }
                     else{
             diffDegree= A.degree()-pl.degree();
               
                     q=new int[diffDegree+1];
              
                     for(int i = 0;i<diffDegree;i++)
                    q[i]=0;
                
                q[diffDegree]=A.getCoeficientAt(A.degree());
                quotient.setCoeficientAt(diffDegree,A.getCoeficientAt(A.degree()));
                 qut = new Polynome(q);
                 
                 A=A.substract(pl.multiply(qut)).reduceCoeficient(modulo).correctTable();
                 
                     }                 
             }
               
               Polynome[] result = {quotient.reduceCoeficient(modulo).correctTable(),A.correctTable().reduceCoeficient(modulo).correctTable()};
               return result;
           
         
         }
         }
          
     }
    
          public Polynome format2Polynome(String str){
       int lengthPoly = 0; boolean jForNext = true;
         for(int i = 0; i<str.length();i++)
         {
          if(str.charAt(i)==' '&& i>0 && str.charAt(i-1)!=' ')
                  
              lengthPoly++;
         }
         if(str.charAt(str.length()-1)!=' ')
             lengthPoly++;
         
         int[] pl = new  int[lengthPoly];
         int i=0; int j=0; int k=0;
         for(j=1;j<str.length();j++){
         
             if(str.charAt(j)!=' ' && str.charAt(j-1)==' ')
            i=j;
             if(str.charAt(j)==' '&& str.charAt(j-1)!=' ')
             {
                 pl[k]=Integer.parseInt(str.substring(i, j));
                 k++;
                
             }
         }
         
         if(str.charAt(j-1)!=' ')
           pl[k]=Integer.parseInt(str.substring(i, j));  
         
         return new Polynome(pl);
     }
    
    
          int[] mixColumnsVectorFromString(String vectStr){
              int startIndex = 0;
              int k = 0;
              int[] vect = new int[4];
              int i =1; // very important to put to 1
              for( ; i< vectStr.length() && k<4; i++){
                  if(vectStr.charAt(i)==' ' && vectStr.charAt(i-1)!=' '){
                      vect[k]= Integer.parseInt(vectStr.substring(startIndex, i), 2);
                      k++;
                  } 
                  else if(vectStr.charAt(i)!=' ' && vectStr.charAt(i-1)==' ')
                  {
                      startIndex = i;
                  }
              }
              
              if(k==3&& vectStr.charAt(i-1)!=' '){
                  vect[k]= Integer.parseInt(vectStr.substring(startIndex),2);
              }
              return vect;
          }

          String VectorToString(int[] vect, int radix){
          String result = "" ;
              for(int i =0; i<vect.length; i++){
                  result = result + Integer.toString(vect[i], radix);
              }
              
              return result;
          }
          
           String VectorToString(int[] vect){
          String result = "" ;
              for(int i =0; i<vect.length; i++){
                  result = result + Integer.toString(vect[i])+" ";
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
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField2 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
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
        jLabel6.setText("   Aller à Squar and multiply ( Pratique )");
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
        jLabel8.setText("   Aller à Squar and multiply ( modulaire pratique )");
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
        jLabel10.setText("   Aller à Squar and multiply ( modulaire etude )");
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

        jLabel12.setBackground(new java.awt.Color(32, 32, 47));
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

        jLabel13.setBackground(new java.awt.Color(32, 32, 47));
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

        jLabel14.setBackground(new java.awt.Color(32, 32, 47));
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

        jLabel16.setBackground(new java.awt.Color(32, 32, 47));
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
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 135, Short.MAX_VALUE))
        );

        jPanel30.add(jPanel10);
        jPanel10.setBounds(-260, 0, 250, 660);
        jPanel10.setVisible(false);

        jPanel14.setBackground(new java.awt.Color(19, 19, 24));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
        });
        jPanel14.setLayout(null);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea3FocusLost(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea3);

        jPanel14.add(jScrollPane3);
        jScrollPane3.setBounds(180, 160, 166, 60);

        jButton20.setBackground(new java.awt.Color(0, 0, 0));
        jButton20.setForeground(new java.awt.Color(153, 153, 153));
        jButton20.setText("nbr bits = 1");
        jButton20.setAlignmentY(0.0F);
        jButton20.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton20.setFocusable(false);
        jButton20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton20.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(0, 0, 0));
        jButton21.setForeground(new java.awt.Color(153, 153, 153));
        jButton21.setText("nbr bits du nbr");
        jButton21.setAlignmentY(0.0F);
        jButton21.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton21.setFocusable(false);
        jButton21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton21.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.add(jPanel17);
        jPanel17.setBounds(90, 160, 90, 60);

        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
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
        jPanel14.add(jTextField8);
        jTextField8.setBounds(90, 70, 90, 22);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(176, 48, 48));
        jLabel24.setText("nbr Bits");
        jPanel14.add(jLabel24);
        jLabel24.setBounds(20, 10, 70, 14);

        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("hex");
        jPanel14.add(jLabel25);
        jLabel25.setBounds(62, 130, 30, 14);

        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
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
        jPanel14.add(jTextField11);
        jTextField11.setBounds(90, 130, 90, 22);

        jTextField12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField12FocusLost(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });
        jPanel14.add(jTextField12);
        jTextField12.setBounds(90, 100, 90, 22);

        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Poly");
        jPanel14.add(jLabel26);
        jLabel26.setBounds(120, 50, 40, 14);

        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("bin");
        jPanel14.add(jLabel27);
        jLabel27.setBounds(60, 70, 30, 14);

        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("dec");
        jPanel14.add(jLabel28);
        jLabel28.setBounds(60, 100, 30, 14);

        jPanel30.add(jPanel14);
        jPanel14.setBounds(470, 360, 380, 280);
        jPanel14.setBackground(new java.awt.Color(19, 19, 24,150));

        jPanel11.setBackground(new java.awt.Color(19, 19, 24));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(null);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea2FocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        jPanel11.add(jScrollPane2);
        jScrollPane2.setBounds(200, 70, 166, 130);

        jButton14.setBackground(new java.awt.Color(0, 0, 0));
        jButton14.setForeground(new java.awt.Color(153, 153, 153));
        jButton14.setText("Inverse");
        jButton14.setAlignmentY(0.0F);
        jButton14.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton14.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton14.setFocusPainted(false);
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton14.setRequestFocusEnabled(false);
        jButton14.setVerifyInputWhenFocusTarget(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 0, 0));
        jButton15.setForeground(new java.awt.Color(153, 153, 153));
        jButton15.setText("sbx Affine trsf");
        jButton15.setAlignmentY(0.0F);
        jButton15.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton15.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton15.setFocusPainted(false);
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton15.setRequestFocusEnabled(false);
        jButton15.setVerifyInputWhenFocusTarget(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 0, 0));
        jButton16.setForeground(new java.awt.Color(153, 153, 153));
        jButton16.setText("inv Affine trsf");
        jButton16.setAlignmentY(0.0F);
        jButton16.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton16.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton16.setFocusPainted(false);
        jButton16.setFocusable(false);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton16.setRequestFocusEnabled(false);
        jButton16.setVerifyInputWhenFocusTarget(false);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel13);
        jPanel13.setBounds(20, 70, 90, 90);

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setForeground(new java.awt.Color(153, 153, 153));
        jButton6.setText("AES Sbox");
        jButton6.setAlignmentY(0.0F);
        jButton6.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton6.setFocusPainted(false);
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton6.setRequestFocusEnabled(false);
        jButton6.setVerifyInputWhenFocusTarget(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setForeground(new java.awt.Color(153, 153, 153));
        jButton7.setText("AES invSbox");
        jButton7.setAlignmentY(0.0F);
        jButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton7.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton7.setFocusPainted(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton7.setRequestFocusEnabled(false);
        jButton7.setVerifyInputWhenFocusTarget(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setForeground(new java.awt.Color(153, 153, 153));
        jButton8.setText("AES MixColumn");
        jButton8.setAlignmentY(0.0F);
        jButton8.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton8.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton8.setFocusPainted(false);
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton8.setRequestFocusEnabled(false);
        jButton8.setVerifyInputWhenFocusTarget(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 0, 0));
        jButton13.setForeground(new java.awt.Color(153, 153, 153));
        jButton13.setText("invMixColumn");
        jButton13.setAlignmentY(0.0F);
        jButton13.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton13.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton13.setFocusPainted(false);
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton13.setRequestFocusEnabled(false);
        jButton13.setVerifyInputWhenFocusTarget(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel12);
        jPanel12.setBounds(110, 70, 90, 120);

        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel11.add(jTextField6);
        jTextField6.setBounds(110, 40, 90, 22);

        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });
        jPanel11.add(jTextField7);
        jTextField7.setBounds(210, 40, 150, 22);

        jLabel18.setForeground(new java.awt.Color(128, 127, 127));
        jLabel18.setText("vect cologne");
        jPanel11.add(jLabel18);
        jLabel18.setBounds(230, 20, 90, 14);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(176, 48, 48));
        jLabel20.setText("AES tools");
        jPanel11.add(jLabel20);
        jLabel20.setBounds(20, 10, 70, 14);

        jLabel19.setForeground(new java.awt.Color(128, 127, 127));
        jLabel19.setText("Poly");
        jPanel11.add(jLabel19);
        jLabel19.setBounds(130, 20, 40, 14);

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setForeground(new java.awt.Color(153, 153, 153));
        jButton10.setText("generer table invSbox");
        jButton10.setAlignmentY(0.0F);
        jButton10.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton10);
        jButton10.setBounds(200, 240, 170, 30);

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setForeground(new java.awt.Color(153, 153, 153));
        jButton9.setText("generer table Sbox");
        jButton9.setAlignmentY(0.0F);
        jButton9.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton9);
        jButton9.setBounds(200, 210, 170, 30);

        jPanel30.add(jPanel11);
        jPanel11.setBounds(80, 360, 380, 280);
        jPanel11.setBackground(new java.awt.Color(19, 19, 24,150));

        jPanel8.setBackground(new java.awt.Color(19, 19, 24));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(null);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jPanel8.add(jScrollPane1);
        jScrollPane1.setBounds(195, 94, 240, 180);
        jScrollPane1.getAccessibleContext().setAccessibleName("");

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
        jPanel8.add(jTextField2);
        jTextField2.setBounds(170, 40, 124, 22);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Addition (XOR)");
        jButton1.setAlignmentY(0.0F);
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(153, 153, 153));
        jButton2.setText("Mutliplication");
        jButton2.setAlignmentY(0.0F);
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new java.awt.Color(153, 153, 153));
        jButton4.setText("reduction (mod)");
        jButton4.setAlignmentY(0.0F);
        jButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton4.setFocusPainted(false);
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(153, 153, 153));
        jButton3.setText("multiplication ds GF(2^m)");
        jButton3.setAlignmentY(0.0F);
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton3.setFocusPainted(false);
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(153, 153, 153));
        jButton5.setText("Div mod");
        jButton5.setAlignmentY(0.0F);
        jButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton5.setFocusPainted(false);
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setForeground(new java.awt.Color(153, 153, 153));
        jButton11.setText("Inverse");
        jButton11.setAlignmentY(0.0F);
        jButton11.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton11.setFocusPainted(false);
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 0, 0));
        jButton12.setForeground(new java.awt.Color(153, 153, 153));
        jButton12.setText("generer table d'inverses");
        jButton12.setAlignmentY(0.0F);
        jButton12.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton12.setFocusPainted(false);
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel9);
        jPanel9.setBounds(35, 94, 160, 210);
        jPanel9.getAccessibleContext().setAccessibleName("");

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel8.add(jTextField1);
        jTextField1.setBounds(40, 40, 124, 22);

        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jPanel8.add(jTextField3);
        jTextField3.setBounds(40, 67, 390, 22);

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Poly 1");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(60, 20, 40, 14);

        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Poly reduction");
        jPanel8.add(jLabel23);
        jLabel23.setBounds(350, 20, 90, 14);

        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Poly 2");
        jPanel8.add(jLabel17);
        jLabel17.setBounds(190, 20, 40, 14);

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
        jPanel8.add(jTextField10);
        jTextField10.setBounds(340, 40, 90, 22);

        jButton26.setBackground(new java.awt.Color(0, 0, 0));
        jButton26.setForeground(new java.awt.Color(153, 153, 153));
        jButton26.setText("Euclide Etendu");
        jButton26.setAlignmentY(0.0F);
        jButton26.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 5, 5, new java.awt.Color(0, 51, 51)));
        jButton26.setFocusPainted(false);
        jButton26.setFocusable(false);
        jButton26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton26.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton26);
        jButton26.setBounds(195, 274, 150, 30);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(176, 48, 48));
        jLabel29.setText("Poly et GF(2^m)");
        jPanel8.add(jLabel29);
        jLabel29.setBounds(10, 0, 120, 14);

        jPanel30.add(jPanel8);
        jPanel8.setBounds(40, 20, 470, 330);
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
        jLabel4.setBounds(790, 170, 80, 64);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background/1368507.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel30.add(jLabel2);
        jLabel2.setBounds(0, 2, 870, 690);

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
        jLabel22.setForeground(new java.awt.Color(112, 78, 78));
        jLabel22.setText("GF(2^m) et AES");
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
        outilsMenu fram = new outilsMenu();
        fram.setVisible(true);

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
        SquareAndMultiplayModuloEtude fram = new SquareAndMultiplayModuloEtude();
        fram.setVisible(true);
        this.dispose();  // TODO add your handling code here:
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

jLabel8.setText("   Aller à Squar and multiply ( Pratique )");

jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(55, 48, 63)));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered

        jLabel8.setBackground(new java.awt.Color(49, 49, 83));

        jLabel8.setForeground(new java.awt.Color(96, 94, 124));

        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 5, new java.awt.Color(55, 48, 63)));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        SquareAndMultiplayModuloEfficace fram = new SquareAndMultiplayModuloEfficace();
        fram.setVisible(true);
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
        SquareAndMultiplayEfficace fram = new SquareAndMultiplayEfficace();
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
   jTextField1.setVisible(false);
    jTextField2.setVisible(false);
    jTextField6.setVisible(false);
     jPanel9.setVisible(false);
     jPanel13.setVisible(false);
     jPanel12.setVisible(false);
     
            transitionAnnimSwing worker = new transitionAnnimSwing(jPanel10,200,60,-jPanel10.getWidth(),0,0,0);
            worker.execute();
         
            menuOpen = true;
        }
        else{
            transitionAnnimSwing worker = new transitionAnnimSwing(jPanel10,200,60,0,0,-jPanel10.getWidth(),0);
            worker.execute();
             
   jTextField1.setVisible(true);
   jTextField2.setVisible(true);
   jTextField6.setVisible(true);
        jPanel9.setVisible(true);
     jPanel13.setVisible(true);
     jPanel12.setVisible(true);
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

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
      this.repaint();      // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
   this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextArea2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea2FocusLost
    this.repaint();     // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea2FocusLost

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
    this.repaint();     // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6FocusLost

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
   this.repaint();      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
 int poly1 = Integer.parseInt(jTextField1.getText(), 2);
 
   int reductionPoly = Integer.parseInt(jTextField10.getText(), 2);
int result =inverseGalois(poly1, reductionPoly);
        jTextArea1.setText(Integer.toBinaryString(result)+"\n\n -------------------------------\n"+
                new Polynome(Integer.toBinaryString(result)).toString());          // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        try {
            String table = inverseTableGeneration(Integer.parseInt(jTextField10.getText(), 2));
            
            
            FileWriter fw;
            
            fw = new FileWriter("inverseTable.txt");
            fw.write(table);
            fw.close();
            
            
            
            
            Desktop.getDesktop().open(new File("inverseTable.txt"));
            
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(G2mAES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       String table = AesSboxTableGeneration() ;
        try {
            
            
            
            FileWriter fw;
            
            fw = new FileWriter("AesSBox.txt");
            fw.write(table);
            fw.close();
            
            
            
            
            Desktop.getDesktop().open(new File("AesSBox.txt"));
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(G2mAES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
 int[] vect = mixColumnsVectorFromString(jTextField7.getText());

        int[] resultVect = invMixColumn(vect);
        jTextArea2.setText("( "+Integer.toBinaryString(resultVect[0])+" , "+
            Integer.toBinaryString(resultVect[1])+" , "+ 
            Integer.toBinaryString(resultVect[2])+" , "+
            Integer.toBinaryString(resultVect[3])+" )");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
        this.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextArea3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea3FocusLost
     this.repaint();     // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3FocusLost

    private void jTextField8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusLost
 this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8FocusLost

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
  int poly1 = Integer.parseInt(jTextField1.getText(), 2);
        int poly2 = Integer.parseInt(jTextField2.getText(), 2);

        int[] euclide = EuclideEtenduGalois(poly1, poly2);

        jTextArea1.setText("d = " + Integer.toBinaryString(euclide[0])
                + "\n x = " + Integer.toBinaryString(euclide[1])
                + "\n y = " + Integer.toBinaryString(euclide[2])+
                "\n\n -------------------------------\n"+
               "d = " +  new Polynome(Integer.toBinaryString(euclide[0])).toString()+ 
                "\n x = " + new Polynome(Integer.toBinaryString(euclide[1])).toString()
                + "\n y = "+new Polynome(Integer.toBinaryString(euclide[2])).toString());          // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
     this.repaint();     // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusLost

    private void jTextField12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusLost
 this.repaint();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   int poly1 = Integer.parseInt(jTextField1.getText(), 2);
        int poly2 = Integer.parseInt(jTextField2.getText(), 2);
int result =poly1 ^ poly2;
        jTextArea1.setText(Integer.toBinaryString(result)+"\n\n -------------------------------\n"+
                new Polynome(Integer.toBinaryString(result)).toString());        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
if(jTextField1.getText().equals(""))
    jTextField3.setText("");
else
        jTextField3.setText(new Polynome(jTextField1.getText()).toString());   



      


// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
  if(jTextField2.getText().equals(""))
    jTextField3.setText("");
else
        jTextField3.setText(new Polynome(jTextField2.getText()).toString());            // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
    if(jTextField10.getText().equals(""))
    jTextField3.setText("");
else
        jTextField3.setText(new Polynome(jTextField10.getText()).toString());      // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
     if(jTextField1.getText().equals(""))
    jTextField3.setText("");
else
        jTextField3.setText(new Polynome(jTextField1.getText()).toString());    // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
if(jTextField2.getText().equals(""))
    jTextField3.setText("");
else
        jTextField3.setText(new Polynome(jTextField2.getText()).toString());          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusGained
if(jTextField10.getText().equals(""))
    jTextField3.setText("");
else
        jTextField3.setText(new Polynome(jTextField10.getText()).toString());          // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10FocusGained

    private void jTextField10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusLost
    this.repaint();       // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10FocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
int poly1 = Integer.parseInt(jTextField1.getText(), 2);
        int poly2 = Integer.parseInt(jTextField2.getText(), 2);
int result = multiplyPoly2M(poly1, poly2);
        jTextArea1.setText(Integer.toBinaryString(result)+"\n\n -------------------------------\n"+
                new Polynome(Integer.toBinaryString(result)).toString());           // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
int poly1 = Integer.parseInt(jTextField1.getText(), 2);
        int reductionPoly = Integer.parseInt(jTextField10.getText(), 2);
int result =reductionGalois2M(poly1, reductionPoly);
        jTextArea1.setText(Integer.toBinaryString(result)+"\n\n -------------------------------\n"+
                new Polynome(Integer.toBinaryString(result)).toString());           // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  int poly1 = Integer.parseInt(jTextField1.getText(), 2);
   int poly2 = Integer.parseInt(jTextField2.getText(), 2);
   int reductionPoly = Integer.parseInt(jTextField10.getText(), 2);
int result =multiplyGalois2M(poly1, poly2, reductionPoly);
        jTextArea1.setText(Integer.toBinaryString(result)+"\n\n -------------------------------\n"+
                new Polynome(Integer.toBinaryString(result)).toString());       // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    int poly1 = Integer.parseInt(jTextField1.getText(), 2);
   int poly2 = Integer.parseInt(jTextField2.getText(), 2);
  
 int[] modDiv = modDivGalois(poly1, poly2);
       
        
        jTextArea1.setText("Div = " + Integer.toBinaryString(modDiv[0])
                + "\n Mod = " + Integer.toBinaryString(modDiv[1])+
                "\n\n -------------------------------\n"+
               "Div = " + new Polynome(Integer.toBinaryString(modDiv[0])).toString()
                + "\n Mod = " + new Polynome(Integer.toBinaryString(modDiv[1])).toString());
                      // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
 int poly = Integer.parseInt(jTextField6.getText(), 2);
      
int result = AesSbox(poly);
        jTextArea2.setText(Integer.toBinaryString(result)+"\n\n -------------------------------\n"+
                new Polynome(Integer.toBinaryString(result)).toString()); 
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int poly = Integer.parseInt(jTextField6.getText(), 2);

        int result = invAesSbox(poly);

        jTextArea2.setText(Integer.toBinaryString(result)+"\n\n -------------------------------\n"+
            new Polynome(Integer.toBinaryString(result)).toString());         // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int[] vect = mixColumnsVectorFromString(jTextField7.getText());
   
        int[] resultVect = mixColumn(vect);
        jTextArea2.setText("( "+Integer.toBinaryString(resultVect[0])+" , "+
            Integer.toBinaryString(resultVect[1])+" , "+ 
            Integer.toBinaryString(resultVect[2])+" , "+
            Integer.toBinaryString(resultVect[3])+" )");

// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        int poly = Integer.parseInt(jTextField6.getText(), 2);

        int result = AES_SboxAffineTr(poly);
        jTextArea2.setText(Integer.toBinaryString(result)+"\n\n -------------------------------\n"+
            new Polynome(Integer.toBinaryString(result)).toString());         // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
      int poly = Integer.parseInt(jTextField6.getText(), 2);

        int result = Inv_AES_SboxAffineTr(poly);
        jTextArea2.setText(Integer.toBinaryString(result)+"\n\n -------------------------------\n"+
            new Polynome(Integer.toBinaryString(result)).toString());     // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
     int poly = Integer.parseInt(jTextField6.getText(), 2);

        int result = invAesSbox(poly);
        jTextArea2.setText(Integer.toBinaryString(result)+"\n\n -------------------------------\n"+
            new Polynome(Integer.toBinaryString(result)).toString());    // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
           String table = invAesSboxTableGeneration() ;
        try {
              
            
            FileWriter fw;
            
            fw = new FileWriter("invAesSBox.txt");
            fw.write(table);
            fw.close();
            
            
            
            
            Desktop.getDesktop().open(new File("invAesSBox.txt"));
            
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(G2mAES.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
if(jTextField8.getText().equals(""))
{jTextField12.setText("");
jTextField11.setText("");
}

else{
int bin = Integer.parseInt(jTextField8.getText(),2);

jTextField12.setText(Integer.toString(bin));
String hexStr = Integer.toHexString(bin);
if(hexStr.length()==1)
    hexStr = "0"+hexStr;

jTextField11.setText(hexStr.toUpperCase());

}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
if(jTextField12.getText().equals(""))
{jTextField8.setText("");
jTextField11.setText("");
}

else{
int dec = Integer.parseInt(jTextField12.getText());

jTextField8.setText(Integer.toBinaryString(dec));
String hexStr = Integer.toHexString(dec);
if(hexStr.length()==1)
    hexStr = "0"+hexStr;

jTextField11.setText(hexStr.toUpperCase());

}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
if(jTextField11.getText().equals(""))
{jTextField12.setText("");
jTextField8.setText("");
}

else{
int hex = Integer.parseInt(jTextField11.getText(),16);

jTextField12.setText(Integer.toString(hex));
jTextField8.setText(Integer.toBinaryString(hex));

}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
 int bin = Integer.parseInt(jTextField8.getText(), 2);
        jTextArea3.setText(String.valueOf(Integer.bitCount(bin))+"\n  (bit égale à 1)");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
   int bin = Integer.parseInt(jTextField8.getText(), 2);
        jTextArea3.setText(String.valueOf(numOfBitslog2(bin))+"\n  (bits fective)");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed





// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
char c = evt.getKeyChar();

if(!((c>='0' && c<='1' ) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // Character.isDigit(c)
{
    getToolkit().beep();
    evt.consume();
   
}

    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
char c = evt.getKeyChar();

if(!((c>='0' && c<='1' ) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // Character.isDigit(c)
{
    getToolkit().beep();
    evt.consume();
   
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyTyped
char c = evt.getKeyChar();

if(!((c>='0' && c<='1' ) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // Character.isDigit(c)
{
    getToolkit().beep();
    evt.consume();
   
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
  char c = evt.getKeyChar();

if(!((c>='0' && c<='1' ) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // Character.isDigit(c)
{
    getToolkit().beep();
    evt.consume();
   
}      // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
char c = evt.getKeyChar();

if(!((c>='0' && c<='1' ) || c==' ' || (c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // Character.isDigit(c)
{
    getToolkit().beep();
    evt.consume();
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyTyped
char c = evt.getKeyChar();

if(!((c>='0' && c<='1' ) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // Character.isDigit(c)
{
    getToolkit().beep();
    evt.consume();
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyTyped

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
char c = evt.getKeyChar();

if(!(Character.isDigit(c) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // 
{
    getToolkit().beep();
    evt.consume();
   
}        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
char c = evt.getKeyChar();

if(!((c>='0' && c<='9' ) || (c>='A' && c<='F' ) || (c>='a' && c<='f' ) || (c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // Character.isDigit(c)
{
    getToolkit().beep();
    evt.consume();
   
}            // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyTyped

   
    
    
    Dimension jl6Dimension1 = new Dimension();
Dimension jl9Dimension1 = new Dimension();
Dimension jl8Dimension1 = new Dimension();

Point jL6LocationInitial= new Point();
Point jL9LocationInitial= new Point();

Point jL8LocationInitial= new Point();

int Xmouse;
int Ymouse;
    boolean menuOpen=false;boolean setToLooseFocusByClick= false;
Timing timer1; String timer1Str;    boolean onWork = false;

  
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
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton26;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}


