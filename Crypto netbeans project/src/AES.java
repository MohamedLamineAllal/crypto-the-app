
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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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


public class AES extends javax.swing.JFrame {

    /**
     * Creates new form mainJfram
     */
    public AES() {
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
           int[] invmixColumn;
           
           invmixColumn = invMixColumn(new int[]{state[0][0],state[1][0],state[2][0],state[3][0]});
           for(int i = 0; i<4; i++){
             result[i][0] = invmixColumn[i];  
           }
           
           invmixColumn = invMixColumn(new int[]{state[0][1],state[1][1],state[2][1],state[3][1]});
           for(int i = 0; i<4; i++){
             result[i][1] = invmixColumn[i];  
           }
           
           invmixColumn = invMixColumn(new int[]{state[0][2],state[1][2],state[2][2],state[3][2]});
           for(int i = 0; i<4; i++){
             result[i][2] = invmixColumn[i];  
           }
           
           invmixColumn = invMixColumn(new int[]{state[0][3],state[1][3],state[2][3],state[3][3]});
           for(int i = 0; i<4; i++){
             result[i][3] = invmixColumn[i];  
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
     
     
     
     // key Shedule vector
    int[][] keyShedule128(int[] cle) // cle de 16 bytes
    { int[][] W_128 = new int[44][4]; // a vector of 44 words, each word of 4 bytes
  
    // en copie la cle dans les 4 1er mot du vect W
    System.arraycopy(cle,0 , W_128[0], 0, 4);
     System.arraycopy(cle,4 , W_128[1], 0, 4);
      System.arraycopy(cle,8 , W_128[2], 0, 4);
       System.arraycopy(cle,12 , W_128[3], 0, 4);
       
       int k =0;
    for(int i=4; i <44; i++){
        if(k == 4)
        {
            k=0;
        }
        
        if(k==0){ // cas  i mod 4 = 0
          System.arraycopy(wordXOR(fonctionG(W_128[i-1], Math.floorDiv(i, 4)), W_128[i-4]),0 ,  W_128[i], 0, 4); //W[i] = g(W[i-1])^W[i-4];
        }
        else{
           System.arraycopy(wordXOR( W_128[i-4],W_128[i-1]),0,W_128[i],0,4);
        }
        
        k++;
    }   
      return W_128;
            }
    
    
    
     int[][] keyShedule192(int[] cle) // cle de 24 bytes
    { int[][] W_192= new int[52][4]; // a vector of 52 words, each word of 4 bytes
  
    // en copie la cle dans les 6 1er mot du vect W
    System.arraycopy(cle,0 , W_192[0], 0, 4);
     System.arraycopy(cle,4 , W_192[1], 0, 4);
      System.arraycopy(cle,8 , W_192[2], 0, 4);
       System.arraycopy(cle,12 , W_192[3], 0, 4);
         System.arraycopy(cle,16 , W_192[4], 0, 4);
           System.arraycopy(cle,20 , W_192[5], 0, 4);
       
       int k =0;
    for(int i=6; i <52; i++){
        if(k == 6)
        {
            k=0;
        }
        
        if(k==0){ // cas  i mod 6 = 0
          System.arraycopy(wordXOR(fonctionG(W_192[i-1], Math.floorDiv(i, 6)), W_192[i-6]),0 ,  W_192[i], 0, 4); //W[i] = g(W[i-1])^W[i-6];
        }
        else{
           System.arraycopy(wordXOR( W_192[i-6],W_192[i-1]),0,W_192[i],0,4);
        }
        
        k++;
    }   
      return W_192;
            }
    
     
    
      public int[] fonctionH(int[] vect){
        return new int[]{Sbox[vect[0]],Sbox[vect[1]],Sbox[vect[2]],Sbox[vect[3]]};
     }
     
     
     
    int[][] keyShedule256(int[] cle) // cle de 24 bytes
    { 
        int[][] W_256= new int[60][4]; // a vector of 52 words, each word of 4 bytes
  
    // en copie la cle dans les 8 1ers mot du vect W
    System.arraycopy(cle,0 , W_256[0], 0, 4);
     System.arraycopy(cle,4 , W_256[1], 0, 4);
      System.arraycopy(cle,8 , W_256[2], 0, 4);
       System.arraycopy(cle,12 , W_256[3], 0, 4);
         System.arraycopy(cle,16 , W_256[4], 0, 4);
           System.arraycopy(cle,20 , W_256[5], 0, 4);
              System.arraycopy(cle,24 , W_256[6], 0, 4);
                 System.arraycopy(cle,28 , W_256[7], 0, 4);
       
       int k =0;
    for(int i=8; i <60; i++){
        if(k == 8)
        {
            k=0;
        }
        
        if(k==0){ // cas  i mod 8 = 0
          System.arraycopy(wordXOR(fonctionG(W_256[i-1], Math.floorDiv(i, 8)), W_256[i-8]),0 ,  W_256[i], 0, 4); //W[i] = g(W[i-1])^W[i-8];
        }
        else if(k==4){ // cas i mod 8 = 4
        System.arraycopy(wordXOR( fonctionH(W_256[i-1]),W_256[i-8]),0,W_256[i],0,4);  // W[i] = h(W[i-1])^W[i-8]   
        }
        else {
           System.arraycopy(wordXOR( W_256[i-8],W_256[i-1]),0,W_256[i],0,4);
        }
        
        k++;
    }   
      return W_256;
            }
    
    
    int[][] AES128_Chiffrement(int[][] state, int[] cle){
      // keys Shedule
        int[][] W = keyShedule128(cle);
       
        // addKey Layer befor round 1
       for(int i=0; i<4 ; i++){
           for(int j = 0; j<4; j++)
           {
             state[j][i] = W[i][j]^ state[j][i];   
           }
       }
      
       
       // first 9 rounds
       for(int k =1; k<=9; k++){
           state = AesSubtituteLayer(state);
           state = shiftRowLayer(state);
           state = mixColumnLayer(state);
           
// addKey layer
           int s = 4*k;
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+s][j]^ state[j][i];   
              }
            }
            
       }
       
     // round 10    //////////////////////////////////////
      state = AesSubtituteLayer(state);
           state = shiftRowLayer(state);
           // pas de mixColumnLayer
           
// addKey layer
          
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+10*4][j]^ state[j][i];   
              }
            } 
     ////////////////////////////////////////////////       
     
            return state;
    }
    
     int[][] AES192_Chiffrement(int[][] state, int[] cle){
      // keys Shedule
        int W[][] = keyShedule192(cle);
       
        // addKey Layer befor round 1
       for(int i=0; i<4 ; i++){
           for(int j = 0; j<4; j++)
           {
             state[j][i] = W[i][j]^ state[j][i];   
           }
       }
      
       
       // first 11 rounds
       for(int k =1; k<=11; k++){
           state = AesSubtituteLayer(state);
           state = shiftRowLayer(state);
           state = mixColumnLayer(state);
           
// addKey layer
           int s = 4*k;
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+s][j]^ state[j][i];   
              }
            }
            
       }
       
     // round 12    //////////////////////////////////////
      state = AesSubtituteLayer(state);
           state = shiftRowLayer(state);
           // pas de mixColumnLayer
           
// addKey layer
          
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+12*4][j]^ state[j][i];   
              }
            } 
     ////////////////////////////////////////////////       
     
            return state;
    }
     
     
        int[][] AES256_Chiffrement(int[][] state, int[] cle){
      // keys Shedule
        int W[][] = keyShedule256(cle);
       
        // addKey Layer befor round 1
       for(int i=0; i<4 ; i++){
           for(int j = 0; j<4; j++)
           {
             state[j][i] = W[i][j]^ state[j][i];   
           }
       }
      
       
       // first 13 rounds
       for(int k =1; k<=13; k++){
           state = AesSubtituteLayer(state);
           state = shiftRowLayer(state);
           state = mixColumnLayer(state);
           
// addKey layer
           int s = 4*k;
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+s][j]^ state[j][i];   
              }
            }
            
       }
       
     // round 14    //////////////////////////////////////
      state = AesSubtituteLayer(state);
           state = shiftRowLayer(state);
           // pas de mixColumnLayer
           
// addKey layer
          
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+14*4][j]^ state[j][i];   
              }
            } 
     ////////////////////////////////////////////////       
     
            return state;
    }
   
        
        
        
        
    int[][] AES128_Dechiffrement(int[][] state, int[] cle){
      // keys Shedule
        int[][] W = keyShedule128(cle);
       
         // round 1    //////////////////////////////////////
        
        // addKey layer
          
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+10*4][j]^ state[j][i];   
              }
            } 
        
            // pas de mixColumnLayer
           state = invShiftRowLayer(state);
           state = invAesSubtituteLayer(state);
          
           

     //////////////////////////////////////////////// 
      
       
       // last 9 rounds
       for(int k =9; k>=1; k--){
          
           // addKey layer
           int s = 4*k;
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+s][j]^ state[j][i];   
              }
            }
           
           
           state = invMixColumnLayer(state);
           state = invShiftRowLayer(state);
           state = invAesSubtituteLayer(state);

            
       }
       
                   
           
  // addKey Layer afrer last round 
       for(int i=0; i<4 ; i++){
           for(int j = 0; j<4; j++)
           {
             state[j][i] = W[i][j]^ state[j][i];   
           }
       }           
            
            return state;
    }    
    
    
    
    
    int[][] AES192_Dechiffrement(int[][] state, int[] cle){
      // keys Shedule
        int W[][] = keyShedule192(cle);
       
         // round 1    //////////////////////////////////////
        
        // addKey layer
          
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+12*4][j]^ state[j][i];   
              }
            } 
        
            // pas de mixColumnLayer
           state = invShiftRowLayer(state);
           state = invAesSubtituteLayer(state);
          
           

     //////////////////////////////////////////////// 
      
       
       // last 11 rounds
       for(int k =11; k>=1; k--){
          
           // addKey layer
           int s = 4*k;
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+s][j]^ state[j][i];   
              }
            }
           
           
           state = invMixColumnLayer(state);
           state = invShiftRowLayer(state);
           state = invAesSubtituteLayer(state);

            
       }
       
                   
           
  // addKey Layer afrer last round 
       for(int i=0; i<4 ; i++){
           for(int j = 0; j<4; j++)
           {
             state[j][i] = W[i][j]^ state[j][i];   
           }
       }           
            
            return state;
    } 
    
    
    
    
    int[][] AES256_Dechiffrement(int[][] state, int[] cle){
      // keys Shedule
        int W[][] = keyShedule256(cle);
       
         // round 1    //////////////////////////////////////
        
        // addKey layer
          
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+14*4][j]^ state[j][i];   
              }
            } 
        
            // pas de mixColumnLayer
           state = invShiftRowLayer(state);
           state = invAesSubtituteLayer(state);
          
           

     //////////////////////////////////////////////// 
      
       
       // last 13 rounds
       for(int k =13; k>=1; k--){
          
           // addKey layer
           int s = 4*k;
            for(int i=0; i<4 ; i++){
              for(int j = 0; j<4; j++)
              {
               state[j][i] = W[i+s][j]^ state[j][i];   
              }
            }
           
           
           state = invMixColumnLayer(state);
           state = invShiftRowLayer(state);
           state = invAesSubtituteLayer(state);

            
       }
       
                   
           
  // addKey Layer afrer last round 
       for(int i=0; i<4 ; i++){
           for(int j = 0; j<4; j++)
           {
             state[j][i] = W[i][j]^ state[j][i];   
           }
       }           
            
            return state;
    } 
    
    
    
    
    public String AES128_ECB(String claire, int[] cle ){
        String chiffre ="";
        
        int claireLenght = claire.length();
 
        for(int i = 0; i < 16 - Math.floorMod(claireLenght, 16)+1; i++ )
        claire = claire + " ";
        
          int l = 0;    
         for(int k=0; k<Math.floorDiv(claireLenght,16);k++ ){
          int[][] state = new int[4][4];
          
          for(int i = 0; i<4; i++ ){
              for(int j=0;j<4;j++){
                  state[j][i] =  (int) claire.charAt(l);
                  l++;
              }
         } 
          
          state = AES128_Chiffrement(state, cle);
          
          for(int i=0; i<4;i++){
              for(int j = 0; j<4; j++){
                  chiffre = chiffre + Integer.toHexString(state[j][i])+ " ";
              }
          }
      }
        
         int[][] state =  new int[4][4];
         int i =0;
         int j=0;
         for(; i<4 && l <claireLenght;i++){
            for(; j<4 && l<claireLenght; j++){
                state[j][i] = (int) claire.charAt(l);
                l++;
            }
        } 
         
        
          for(; i<4 ;i++){
            for(; j<4 ; j++){
                state[j][i] =  ' ' ;
            }
        } 
         
         
         state = AES128_Chiffrement(state, cle);
         
          for(int c=0; c<4;c++){
              for(int p = 0; p<4; p++){
                  chiffre = chiffre + Integer.toHexString(state[p][c])+ " ";
              }
      }
          
          return chiffre;
         
    }
   
     public String AES128_ECB_decrypte(String chiffre, int[] cle ){
        String claire ="";
        
        int chiffreLength = chiffre.length();
          
        int[][] state = new int[4][4];
        
        
        int l=0,m=0; // two index to go through the in construction state
        
        int st = 0;
       for(int i =1; i<chiffreLength; i++)
       {
           if(chiffre.charAt(i)==' ' && chiffre.charAt(i-1)!=' '){
              state[l][m] = Integer.valueOf(chiffre.substring(st, i), 16);
              l++;
              if(l==4)
              {
                  l=0;
                  m++;
              }
              
              if(m==4){
                  state = AES128_Dechiffrement(state, cle);
                  m=0;
                  
                  for(int k=0;k<4; k++ ){
                      for(int p = 0; p< 4; p++){
                          claire = claire + String.valueOf((char)state[p][k]);
                      }
                  }
              }
            
              
           } else if(chiffre.charAt(i)!=' ' && chiffre.charAt(i-1)==' '){
               st = i;
           }
       }
             
          return claire;
         
    }
     
    
     
     
     
     
     
     public String AES192_ECB(String claire, int[] cle ){
        String chiffre ="";
        
        int claireLenght = claire.length();
          
 
       
          int l = 0;    
         for(int k=0; k<Math.floorDiv(claireLenght,16);k++ ){
          int[][] state = new int[4][4];
          
          for(int i = 0; i<4; i++ ){
              for(int j=0;j<4;j++){
                  state[j][i] =  (int) claire.charAt(l);
                  l++;
              }
         } 
          
          state = AES192_Chiffrement(state, cle);
          
          for(int i=0; i<4;i++){
              for(int j = 0; j<4; j++){
                  chiffre = chiffre + Integer.toHexString(state[j][i])+ " ";
              }
          }
      }
        
         int[][] state =  new int[4][4];
         int i =0;
         int j=0;
         for(; i<4 && l <claireLenght;i++){
            for(; j<4 && l<claireLenght; j++){
                state[j][i] = (int) claire.charAt(l);
                l++;
            }
        } 
         
         if(l==claireLenght){
          for(; i<4 ;i++){
            for(; j<4 ; j++){
                state[j][i] = 0 ;
            }
        } 
         }
         
         state = AES192_Chiffrement(state, cle);
         
          for(int c=0; c<4;c++){
              for(int p = 0; p<4; p++){
                  chiffre = chiffre + Integer.toHexString(state[p][c])+ " ";
              }
          }
          
          return chiffre;
         
    }
   
     public String AES192_ECB_decrypte(String chiffre, int[] cle ){
        String claire ="";
        
        int chiffreLength = chiffre.length();
          
        int[][] state = new int[4][4];
        
        
        int l=0,m=0; // two index to go through the in construction state
        
        int st = 0;
       for(int i =1; i<chiffreLength; i++)
       {
           if(chiffre.charAt(i)==' ' && chiffre.charAt(i-1)!=' '){
              state[l][m] = Integer.valueOf(chiffre.substring(st, i), 16);
              l++;
              if(l==4)
              {
                  l=0;
                  m++;
              }
              
              if(m==4){
                  state = AES192_Dechiffrement(state, cle);
                  m=0;
                  
                  for(int k=0;k<4; k++ ){
                      for(int p = 0; p< 4; p++){
                          claire = claire + String.valueOf((char)state[p][k]);
                      }
                  }
              }
            
              
           } else if(chiffre.charAt(i)!=' ' && chiffre.charAt(i-1)==' '){
               st = i;
           }
       }
             
          return claire;
         
    }
     
     
     
     
     
     
     
     
     
      public String AES256_ECB(String claire, int[] cle ){
        String chiffre ="";
        
        int claireLenght = claire.length();
          
 
       
          int l = 0;    
         for(int k=0; k<Math.floorDiv(claireLenght,16);k++ ){
          int[][] state = new int[4][4];
          
          for(int i = 0; i<4; i++ ){
              for(int j=0;j<4;j++){
                  state[j][i] =  (int) claire.charAt(l);
                  l++;
              }
         } 
          
          state = AES256_Chiffrement(state, cle);
          
          for(int i=0; i<4;i++){
              for(int j = 0; j<4; j++){
                  chiffre = chiffre + Integer.toHexString(state[j][i])+ " ";
              }
          }
      }
        
         int[][] state =  new int[4][4];
         int i =0;
         int j=0;
         for(; i<4 && l <claireLenght;i++){
            for(; j<4 && l<claireLenght; j++){
                state[j][i] = (int) claire.charAt(l);
                l++;
            }
        } 
         
         if(l==claireLenght){
          for(; i<4 ;i++){
            for(; j<4 ; j++){
                state[j][i] = 0 ;
            }
        } 
         }
         
         state = AES256_Chiffrement(state, cle);
         
          for(int c=0; c<4;c++){
              for(int p = 0; p<4; p++){
                  chiffre = chiffre + Integer.toHexString(state[p][c])+ " ";
              }
          }
          
          return chiffre;
         
    }
   
     public String AES256_ECB_decrypte(String chiffre, int[] cle ){
        String claire ="";
        
        int chiffreLength = chiffre.length();
          
        int[][] state = new int[4][4];
        
        
        int l=0,m=0; // two index to go through the in construction state
        
        int st = 0;
       for(int i =1; i<chiffreLength; i++)
       {
           if(chiffre.charAt(i)==' ' && chiffre.charAt(i-1)!=' '){
              state[l][m] = Integer.valueOf(chiffre.substring(st, i), 16);
              l++;
              if(l==4)
              {
                  l=0;
                  m++;
              }
              
              if(m==4){
                  state = AES256_Dechiffrement(state, cle);
                  m=0;
                  
                  for(int k=0;k<4; k++ ){
                      for(int p = 0; p< 4; p++){
                          claire = claire + String.valueOf((char)state[p][k]);
                      }
                  }
              }
            
              
           } else if(chiffre.charAt(i)!=' ' && chiffre.charAt(i-1)==' '){
               st = i;
           }
       }
             
          return claire;
         
    }
     

     
     
         public String getHashHex(String password, int bytesLength){
      
        StringBuffer hexString = new StringBuffer();
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            
            byte byteData[] = md.digest();
            
            
            //convert the byte to hex format method 2
            
            for (int i=0;i<byteData.length && i<bytesLength;i++) {
                String hex=Integer.toHexString(0xff & byteData[i]);
                if(hex.length()==1) hexString.append('0');
                hexString.append(hex);
                
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           return hexString.toString();
    }
         
         
    
          public String getHashBits(String password, int bytesLength){
      
        StringBuffer bitsString = new StringBuffer();
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            
            byte byteData[] = md.digest();
            
            
            //convert the byte to hex format method 2
            
            for (int i=0;i<byteData.length && i<bytesLength;i++) {
                String bin=Integer.toBinaryString(0xff & byteData[i]);
               for(int l=0; l<8-bin.length();l++){
                   bitsString.append("0");
               }
                bitsString.append(bin);        
            }
            return bitsString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           return bitsString.toString();
    }
          
          
    public int[] getKeyHash(String password, int bytesLength) throws NoSuchAlgorithmException{
      
        int[] hashKey = new int[bytesLength];
        
        
        
        
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            
            byte byteData[] = md.digest();
            
            
            //convert the byte to hex format method 2
            
            for (int i=0; i<hashKey.length && i< byteData.length; i++) {
               hashKey[i] = 0xff & byteData[i];
                              
            }
            
       
        
           return hashKey;
    }

    

public int[] AesStringToIntKEY(String cle){
    int cleLenght = cle.length();
    int bytesNumber = Math.floorDiv(cleLenght, 8);
    int[] key = new int[bytesNumber];
    int i;
    for( i = 0; i<bytesNumber-1; i++){
        key[i]=Integer.parseInt(cle.substring(i*8, i*8+8),2) ;
    }
     key[i]=Integer.parseInt(cle.substring(i*8),2) ;      
     
     return key;
}


public String keyToString(int[] cle){
   String key = "";
    for(int i = 0; i<cle.length; i++)
    {   String byteStr = Integer.toBinaryString(cle[i]);
        for(int j = 0; j < 8-byteStr.length();j++)
            key = key + "0";
        key=key + byteStr;
    }
    return key;
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
        jButton6 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField8 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField7 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
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
        jLabel6.setText("          Arithmetique polynomial ");
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
        jLabel8.setText("          GF(2^m) et AES");
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
        jLabel10.setText("          ..........................................");
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
        jLabel11.setText("          ..........................................");
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
        jLabel12.setText("          ..........................................");
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
        jLabel13.setText("          ..........................................");
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
        jLabel14.setText("          ..........................................");
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
        jLabel16.setText("          ..........................................");
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
        jLabel29.setBounds(70, 230, 30, 30);
        jLabel29.setVisible(false);

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

        jPanel9.add(jScrollPane3);
        jScrollPane3.setBounds(110, 180, 610, 100);

        jTextArea4.setColumns(20);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setWrapStyleWord(true);
        jTextArea4.addFocusListener(new java.awt.event.FocusAdapter() {
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
        jScrollPane4.setBounds(110, 70, 610, 100);

        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
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
        jTextField2.setBounds(120, 40, 124, 22);

        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Mot de passe : ");
        jPanel9.add(jLabel18);
        jLabel18.setBounds(40, 40, 100, 14);

        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Texte chiffré");
        jPanel9.add(jLabel19);
        jLabel19.setBounds(30, 90, 70, 14);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(184, 46, 46));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Dechiffrement");
        jPanel9.add(jLabel24);
        jLabel24.setBounds(10, 10, 100, 20);
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
        jButton2.setBounds(10, 180, 90, 30);

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
        jTextField4.setBounds(110, 280, 490, 13);
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
        jButton4.setBounds(20, 210, 70, 15);
        jButton4.setVisible(false);

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setForeground(new java.awt.Color(153, 153, 153));
        jButton6.setText("Dériver la clé secrete ");
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
        jPanel9.add(jButton6);
        jButton6.setBounds(260, 30, 130, 35);

        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Clé secrète :");
        jPanel9.add(jLabel21);
        jLabel21.setBounds(420, 40, 80, 14);

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });
        jPanel9.add(jTextField6);
        jTextField6.setBounds(490, 40, 160, 22);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AES 128 bits", "AES 192 bits", "AES 256 bits" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel9.add(jComboBox2);
        jComboBox2.setBounds(120, 15, 90, 20);

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(25, 25, 25));
        jTextField8.setForeground(new java.awt.Color(204, 204, 204));
        jTextField8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(25, 25, 25)));
        jPanel9.add(jTextField8);
        jTextField8.setBounds(490, 13, 40, 22);

        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("bits");
        jPanel9.add(jLabel26);
        jLabel26.setBounds(540, 20, 30, 14);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(211, 49, 49));
        jLabel32.setText("!!!!!");
        jPanel9.add(jLabel32);
        jLabel32.setBounds(653, 40, 50, 20);
        jLabel32.setVisible(false);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_32x32.png"))); // NOI18N
        jLabel30.setText("jLabel27");
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
        jPanel9.add(jLabel30);
        jLabel30.setBounds(70, 120, 40, 40);

        jPanel30.add(jPanel9);
        jPanel9.setBounds(30, 340, 750, 310);
        jPanel9.setBackground(new java.awt.Color(19, 19, 24,150));

        jPanel8.setBackground(new java.awt.Color(19, 19, 24));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(184, 46, 46));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Chiffrement");
        jPanel8.add(jLabel23);
        jLabel23.setBounds(10, 10, 100, 20);
        jLabel23.setVisible(true);

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
        jLabel28.setBounds(70, 240, 30, 30);
        jLabel28.setVisible(false);

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

        jPanel8.add(jScrollPane2);
        jScrollPane2.setBounds(110, 180, 610, 100);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
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
        jScrollPane1.setBounds(110, 70, 610, 100);
        jScrollPane1.getAccessibleContext().setAccessibleName("");

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
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
        jTextField1.setBounds(120, 40, 124, 22);

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("bits");
        jPanel8.add(jLabel9);
        jLabel9.setBounds(540, 20, 30, 14);

        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Texte Claire");
        jPanel8.add(jLabel17);
        jLabel17.setBounds(30, 90, 70, 14);

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(153, 153, 153));
        jButton5.setText("Dériver la clé secrete ");
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
        jPanel8.add(jButton5);
        jButton5.setBounds(260, 35, 130, 30);

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
        jButton1.setBounds(10, 180, 90, 30);

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setForeground(new java.awt.Color(118, 35, 35));
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3);
        jButton3.setBounds(20, 210, 70, 15);
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
        jTextField3.setBounds(110, 280, 490, 14);
        //jTextField3.setBackground(new Color(0,0,0,0));

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel8.add(jTextField5);
        jTextField5.setBounds(490, 40, 160, 22);

        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Mot de passe : ");
        jPanel8.add(jLabel20);
        jLabel20.setBounds(40, 40, 90, 14);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AES 128 bits", "AES 192 bits", "AES 256 bits" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel8.add(jComboBox1);
        jComboBox1.setBounds(120, 15, 90, 20);

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(25, 25, 25));
        jTextField7.setForeground(new java.awt.Color(204, 204, 204));
        jTextField7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(25, 25, 25)));
        jPanel8.add(jTextField7);
        jTextField7.setBounds(490, 13, 40, 22);

        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Clé secrète :");
        jPanel8.add(jLabel25);
        jLabel25.setBounds(420, 40, 80, 14);

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(211, 49, 49));
        jLabel31.setText("!!!!!");
        jPanel8.add(jLabel31);
        jLabel31.setBounds(653, 40, 50, 20);
        jLabel31.setVisible(false);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_32x32.png"))); // NOI18N
        jLabel27.setText("jLabel27");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel27MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel27MouseReleased(evt);
            }
        });
        jPanel8.add(jLabel27);
        jLabel27.setBounds(70, 120, 40, 40);

        jPanel30.add(jPanel8);
        jPanel8.setBounds(30, 20, 750, 310);
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
        jLabel4.setBounds(790, 490, 64, 64);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background/43445277_l.jpg"))); // NOI18N
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
        jLabel22.setForeground(new java.awt.Color(99, 92, 126));
        jLabel22.setText("Cryptosystème AES");
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
      G2mAES fram = new G2mAES();  
      fram.setVisible(true);
      this.dispose(); 
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
       PolyArithm fram = new PolyArithm();  
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
jTextField3.setVisible(false);
jTextField4.setVisible(false);
jButton2.setVisible(false);

jTextArea1.setVisible(false);


jTextArea2.setVisible(false);


jTextArea3.setVisible(false);

     
jTextArea4.setVisible(false);


            transitionAnnimSwing worker = new transitionAnnimSwing(jPanel10,200,30,-jPanel10.getWidth(),0,0,0);
            worker.execute();
            menuOpen = true;
        }
        else{
            transitionAnnimSwing worker = new transitionAnnimSwing(jPanel10,200,30,0,0,-jPanel10.getWidth(),0);
            worker.execute();
            
          jTextField1.setVisible(true);
jTextField2.setVisible(true);
jTextField3.setVisible(true);
jTextField4.setVisible(true);
jButton2.setVisible(true);


jTextArea1.setVisible(true);


jTextArea2.setVisible(true);


jTextArea3.setVisible(true);

     
jTextArea4.setVisible(true);

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



// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyTyped
Timing timer1; String timer1Str;   // timer 
boolean timer1on ; // timer flag on/of
  boolean onWork = false; // flage explaining that the worker stay work (on work the action can't applied twice )
   SwingWorker<String, Void> mainWorker;
   AES thisFram = this;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 if(!onWork){
     boolean keyCorrect= true;
     
      if(jComboBox1.getSelectedIndex()==0){ // 128 bits
       if(!jTextField7.getText().equals("128"))
         keyCorrect = false;
        }
      
        else if(jComboBox1.getSelectedIndex()==1){ // 192 bits
         if(!jTextField7.getText().equals("192"))
         keyCorrect = false;
        }
               
        else if(jComboBox1.getSelectedIndex()==2){ // 256 bits
         if(!jTextField7.getText().equals("256"))
         keyCorrect = false;
        }
	 
        
               
        if(keyCorrect) {
            int[]  cle =AesStringToIntKEY(jTextField5.getText()) ;
            // System.out.println("key = << "+keyToString(cle)+" >>");
            jLabel31.setVisible(false);
       jButton3.setVisible(true);
 jLabel28.setVisible(false);
 thisFram.repaint();
jTextArea2.setText("");

 String str = jTextArea1.getText();
int claireLentgh = str.length();
for(int i=0; i< 16 - Math.floorMod(claireLentgh, 16); i++ )
str = str.concat(" ");
  // System.out.println("String = <<"+str+">>");
String claire = str;

 mainWorker = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() throws InterruptedException, NoSuchAlgorithmException {
        timer1on = true;
        onWork = true;
        timer1 = new Timing();
        String result="";
        if(jComboBox1.getSelectedIndex()==0){ // 128 bits
         result = AES128_ECB(claire ,cle /*getKeyHash(jTextField1.getText(), 16)*/);
        }
      
        else if(jComboBox1.getSelectedIndex()==1){ // 192 bits
         result = AES192_ECB(claire, cle /*getKeyHash(jTextField1.getText(), 24)*/);
        }
               
        else if(jComboBox1.getSelectedIndex()==2){ // 256 bits
         result = AES256_ECB(claire, cle /*getKeyHash(jTextField1.getText(), 32)*/);
        }
        
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
        } else{
        
         jLabel31.setVisible(true);
         thisFram.repaint();
        }
// do in the code to launch the worker
	 }else {
	 // showing message or something
	 }
        
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextArea2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea2FocusLost

    private void jTextArea3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea3FocusLost

    private void jTextArea4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea4FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea4FocusLost

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped

// TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped
Timing timer2;   String timer2Str;  // timer 
boolean timer2on ; // timer flag on/of
  boolean onWork2 = false; // flage explaining that the worker stay work (on work the action can't applied twice )

  SwingWorker<String, Void> mainWorker2;

   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if(!onWork2){
    boolean keyCorrect= true;
     
      if(jComboBox2.getSelectedIndex()==0){ // 128 bits
       if(!jTextField8.getText().equals("128"))
         keyCorrect = false;
        }
      
        else if(jComboBox2.getSelectedIndex()==1){ // 192 bits
         if(!jTextField8.getText().equals("192"))
         keyCorrect = false;
        }
               
        else if(jComboBox2.getSelectedIndex()==2){ // 256 bits
         if(!jTextField8.getText().equals("256"))
         keyCorrect = false;
        }
	 
        
               
        if(keyCorrect) {
   int[] cle =AesStringToIntKEY(jTextField6.getText()) ;
    jLabel32.setVisible(false);
    thisFram.repaint();
           
  
       
jButton4.setVisible(true);
  jLabel29.setVisible(false);
jTextArea3.setText("");
  
 mainWorker2 = new SwingWorker<String, Void>() {
        @Override
        public String doInBackground() throws InterruptedException, NoSuchAlgorithmException {
        timer2on = true;
        onWork2 = true;
        timer2 = new Timing();
        String result ="";
        if(jComboBox2.getSelectedIndex()==0){ // 128 bits
         result = AES128_ECB_decrypte(jTextArea4.getText(),  cle /*getKeyHash(jTextField2.getText(), 16)*/);
        }
        
        
        else if(jComboBox2.getSelectedIndex()==1){ // 192 bits
         result = AES192_ECB_decrypte(jTextArea4.getText(),cle /*getKeyHash(jTextField2.getText(), 24)*/);
        }
        
        
         
        else if(jComboBox2.getSelectedIndex()==2){ // 256 bits
         result = AES256_ECB_decrypte(jTextArea4.getText(),cle /*getKeyHash(jTextField2.getText(), 32)*/);
        }
       
        
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
        }else{
          jLabel32.setVisible(true);
         thisFram.repaint();
        }
        
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
if(jComboBox1.getSelectedIndex()==0)  {  //  128 bits 
  jTextField5.setText( getHashBits(jTextField1.getText(), 16));     // 16 BYTES = 128 BITS
  jTextField7.setText(""+jTextField5.getText().length());
  }
 else if(jComboBox1.getSelectedIndex()==1)  //  192 bits 
{ jTextField5.setText( getHashBits(jTextField1.getText(), 24));     
 jTextField7.setText(""+jTextField5.getText().length());     
  }
  
  
  else if(jComboBox1.getSelectedIndex()==2){ // 256 bits
   jTextField5.setText( getHashBits(jTextField1.getText(), 32));     
  jTextField7.setText(""+jTextField5.getText().length());
  }
  
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
if(jComboBox2.getSelectedIndex()==0)  {  //  128 bits 
  jTextField6.setText( getHashBits(jTextField2.getText(), 16));     
  jTextField8.setText(""+jTextField6.getText().length());
   }
   else if(jComboBox2.getSelectedIndex()==1)  //  192 bits 
  {
     jTextField6.setText( getHashBits(jTextField2.getText(), 24));     
 jTextField8.setText(""+jTextField6.getText().length());
   }
  
  
  else if(jComboBox2.getSelectedIndex()==2){ // 256 bits
   jTextField6.setText( getHashBits(jTextField2.getText(), 32));     
  jTextField8.setText(""+jTextField6.getText().length());
  }
          // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
                                 
char c = evt.getKeyChar();

if(!((c>='0' && c<='1' ) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // Character.isDigit(c)
{
    getToolkit().beep();
    evt.consume();
   
}

      
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
    char c = evt.getKeyChar();

if(!((c>='0' && c<='1' ) ||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))    // Character.isDigit(c)
{
    getToolkit().beep();
    evt.consume();
   
}
    // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
jTextField7.setText(""+jTextField5.getText().length());        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
jTextField8.setText(""+jTextField6.getText().length());           // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_2_32x32.png"))); // NOI18N
this.repaint();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_32x32.png"))); // NOI18N
  this.repaint();      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseExited

    private void jLabel27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MousePressed
jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_3_32x32.png"))); // NOI18N
    this.repaint();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MousePressed

    private void jLabel27MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseReleased
jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_2_32x32.png")));      
this.repaint();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseReleased

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
jTextArea1.setText(getClipboardContents());        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        jTextArea4.setText(getClipboardContents());        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_2_32x32.png"))); // NOI18N
    this.repaint();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_32x32.png"))); // NOI18N
      this.repaint();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseExited

    private void jLabel30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MousePressed
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_3_32x32.png"))); // NOI18N
      this.repaint();  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MousePressed

    private void jLabel30MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseReleased
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/past/paste-icon_60x60_2_32x32.png"))); 
this.repaint();        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    

    
    
    
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
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
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
