
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import static java.time.Clock.system;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
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


public class menuClassicCrypto extends javax.swing.JFrame {

    /**
     * Creates new form mainJfram
     */
    public menuClassicCrypto() {
        initComponents();
                
        Rectangle rect=new Rectangle(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        // that, give the available screen space (width and height (without counting the task bar)) 
        setLocation((int)(rect.getWidth()-getWidth())/2, (int)(rect.getHeight()-getHeight())/2); //seting the location of the jFram to be centred
        //                                       ^                                      ^
        //                                 width of the jfram                  height of the jfram
     
        
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
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
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

        jPanel1.setBackground(new java.awt.Color(91, 37, 73));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        jPanel14.setBackground(new java.awt.Color(47, 34, 45));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(0, 51, 51));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock-unlock-icon.png"))); // NOI18N
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel14MouseReleased(evt);
            }
        });
        jPanel14.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 8, -1, -1));

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
            .addGap(0, 940, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel14.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 940, 10));

        jPanel1.add(jPanel14);
        jPanel14.setBounds(0, 0, 943, 150);

        jPanel23.setBackground(new java.awt.Color(27, 29, 39));
        jPanel23.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(128, 66, 128)));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel23);
        jPanel23.setBounds(880, 142, 61, 500);

        jPanel19.setBackground(new java.awt.Color(22, 19, 37));
        jPanel19.setLayout(new java.awt.GridLayout(5, 1));

        jLabel8.setBackground(new java.awt.Color(41, 34, 46));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Chiffrement de Cesar");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 5, new java.awt.Color(0, 102, 102)));
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setOpaque(true);
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
        jLabel8.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jLabel8PropertyChange(evt);
            }
        });
        jPanel19.add(jLabel8);

        jLabel10.setBackground(new java.awt.Color(41, 34, 46));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Chiffrement Affine");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 1, 1, new java.awt.Color(0, 102, 102)));
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setOpaque(true);
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
        jPanel19.add(jLabel10);

        jLabel28.setBackground(new java.awt.Color(41, 34, 46));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 153));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Chiffrement de Playfaire");
        jLabel28.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 5, new java.awt.Color(162, 206, 95)));
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel28.setOpaque(true);
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
        jPanel19.add(jLabel28);

        jLabel29.setBackground(new java.awt.Color(41, 34, 46));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 153, 153));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Chiffrement de Hill");
        jLabel29.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 1, 1, new java.awt.Color(162, 206, 95)));
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel29.setOpaque(true);
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
        jPanel19.add(jLabel29);

        jLabel30.setBackground(new java.awt.Color(41, 34, 46));
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 153, 153));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Chiffrement de Vignère");
        jLabel30.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 5, new java.awt.Color(227, 34, 86)));
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        jPanel19.add(jLabel30);

        jPanel1.add(jPanel19);
        jPanel19.setBounds(320, 200, 300, 390);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/underConstruction/vecteur-grunge-en-construction-et-jaune-de-signe-28032934.jpg"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(640, 410, 260, 190);
        jLabel6.setVisible(false);

        jPanel24.setBackground(new java.awt.Color(27, 29, 39));
        jPanel24.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(68, 41, 68)));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel24);
        jPanel24.setBounds(0, 140, 61, 500);

        jLabel5.setBackground(new java.awt.Color(208, 52, 52));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(195, 67, 67));
        jLabel5.setText("Cryptosytèmes  Classiques");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(330, 170, 180, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/motif/182837.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(70, 250, 780, 330);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/motif/183133_1.png"))); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(100, 250, 770, 390);

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

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
   
        jLabel10.setBackground(new java.awt.Color(41, 35, 46));

jLabel10.setForeground(new java.awt.Color(125, 112, 139)); 

 scaleSwingManual(jLabel10, -30, -10); 
  
 if(jLabel6.isVisible()){ 
jLabel6.setVisible(false);
justHided =true;
}

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
      
     jLabel10.setBackground(new java.awt.Color(41, 34, 46));

jLabel10.setForeground(new java.awt.Color(153, 153, 153));

if(!justHided){
 scaleSwingManual(jLabel10, 30, 10);

        // TODO add your handling code here:
    }
justHided= false;
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
jLabel10.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MousePressed

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
   jLabel10.setBackground(new java.awt.Color(41, 35, 46));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseReleased

    private void jLabel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseReleased
   jLabel8.setBackground(new java.awt.Color(41, 35, 46));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseReleased

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
jLabel8.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
    
        
     jLabel8.setBackground(new java.awt.Color(41, 34, 46));

jLabel8.setForeground(new java.awt.Color(153, 153, 153));

if(!justHided){
 scaleSwingManual(jLabel8, 30, 10);
    } 
justHided= false;
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseExited
boolean justHided = false;
    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered

     
        jLabel8.setBackground(new java.awt.Color(41, 35, 46));

jLabel8.setForeground(new java.awt.Color(125, 112, 139)); 

 scaleSwingManual(jLabel8, -30, -10);  
 
      if(jLabel6.isVisible()){ 
jLabel6.setVisible(false);
justHided =true;
}
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

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
  cryptosystemMenu fram = new cryptosystemMenu();
fram.setVisible(true);
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked
int statOfScroll = 1;
    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        
        jLabel28.setBackground(new java.awt.Color(41, 35, 46));

jLabel28.setForeground(new java.awt.Color(125, 112, 139));
 scaleSwingManual(jLabel28, -30, -10);  
 
    if(jLabel6.isVisible()){ 
jLabel6.setVisible(false);
justHided =true;
} // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
 
       jLabel28.setBackground(new java.awt.Color(41, 34, 46));

jLabel28.setForeground(new java.awt.Color(153, 153, 153));

 if(!justHided){
 scaleSwingManual(jLabel28, 30, 10);  

        // TODO add your handling code here:
    }
 justHided= false;
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseExited

    private void jLabel28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MousePressed
jLabel28.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MousePressed

    private void jLabel28MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseReleased
  jLabel28.setBackground(new java.awt.Color(41, 35, 46));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseReleased

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
         
        jLabel29.setBackground(new java.awt.Color(41, 35, 46));

jLabel29.setForeground(new java.awt.Color(125, 112, 139));
 scaleSwingManual(jLabel29, -30, -10);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
 
      jLabel29.setBackground(new java.awt.Color(41, 34, 46));

jLabel29.setForeground(new java.awt.Color(153, 153, 153));

 scaleSwingManual(jLabel29, 30, 10);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseExited

    private void jLabel29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MousePressed
jLabel29.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MousePressed

    private void jLabel29MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseReleased
  jLabel29.setBackground(new java.awt.Color(41, 35, 46));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseReleased

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        
        jLabel30.setBackground(new java.awt.Color(41, 35, 46));

jLabel30.setForeground(new java.awt.Color(125, 112, 139));
 scaleSwingManual(jLabel30, -30, -10); 
 
    if(jLabel6.isVisible()){ 
jLabel6.setVisible(false);
justHided =true;
}
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
 
       jLabel30.setBackground(new java.awt.Color(41, 34, 46));

jLabel30.setForeground(new java.awt.Color(153, 153, 153));

 
 if(!justHided){
 scaleSwingManual(jLabel30, 30, 10);  

        // TODO add your handling code here:
    }// TODO add your handling code here:
 
 justHided= false;
    }//GEN-LAST:event_jLabel30MouseExited

    private void jLabel30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MousePressed
jLabel30.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MousePressed

    private void jLabel30MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseReleased
  jLabel30.setBackground(new java.awt.Color(41, 35, 46));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseReleased

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        chifrCesar fram = new chifrCesar();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
     chifrAffine fram = new chifrAffine();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
chifrPlayfaire fram = new chifrPlayfaire();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MousePressed

    private void jLabel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseReleased

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        chifrVignere fram = new chifrVignere();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();
                // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
jLabel6.setVisible(true);   
this.repaint();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel8PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel8PropertyChange
      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8PropertyChange

  
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
