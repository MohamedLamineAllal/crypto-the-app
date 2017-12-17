
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


public class outilsMenu extends javax.swing.JFrame {

    /**
     * Creates new form mainJfram
     */
    public outilsMenu() {
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
      
      
      
      
class scroleAnnimWorker extends SwingWorker<JScrollPane, JScrollPane> {
    JScrollPane  scrp;  
    int msTime;
    int imgPs;
    int start;
    int end;
    
    public scroleAnnimWorker (JScrollPane jsp,int MsTime, int ImgPs, int Start,int End)
    {
        scrp = jsp;
         msTime=MsTime;
         imgPs=ImgPs;
         start=Start;
         end=End;
    }
    
    @Override
       public JScrollPane doInBackground() throws InterruptedException {
       int nbrImages = imgPs*msTime /  1000;
          int intervaleTime = msTime/nbrImages;
          int  intervaleDistance = (end-start)/nbrImages;
          long startimer,endtimer;
          scrp.getVerticalScrollBar().setValue(start);
          for(int i=0;i<nbrImages-1;i++){
               scrp.getVerticalScrollBar().setValue(scrp.getVerticalScrollBar().getValue()+intervaleDistance); 
              
               ///////////////////////////////////////////////////// wait
               /*startimer = System.currentTimeMillis();
               endtimer = startimer;
               while(endtimer-startimer<intervaleTime)
                 endtimer = System.currentTimeMillis();*/
               Thread.sleep(intervaleTime);
               /////////////////////////////////////////////////////
               publish(scrp);
          }
        
              scrp.getVerticalScrollBar().setValue(end);
                 return scrp;
           
       }

       @Override
       protected void done() {
           try {
              jScrollPane1=get();
           } catch (InterruptedException | ExecutionException ignore) {
           }
       }
       
        @Override
  protected void process(final List<JScrollPane> chunks) {
   
	for (final JScrollPane  db : chunks) {
            if(!this.isCancelled())
            {
              jScrollPane1=db;
            }
            
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

        jPanel16 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
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

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(128, 66, 128)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel15.setBackground(new java.awt.Color(27, 29, 39));
        jPanel15.setFocusTraversalPolicyProvider(true);
        jPanel15.setInheritsPopupMenu(true);
        jPanel15.setMinimumSize(new java.awt.Dimension(604, 2000));
        jPanel15.setPreferredSize(new java.awt.Dimension(940, 2000));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(22, 21, 27));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(70, 48, 83));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Square and multiply");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setOpaque(true);
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

        jLabel6.setBackground(new java.awt.Color(70, 48, 83));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Square and multiply (modulo)");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel6.setOpaque(true);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 520, 70));

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(203, 203, 25));
        jLabel13.setText("<html><u>Exponentiaion et Exponentiation modulaire</u></html>");
        jPanel15.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jPanel10.setBackground(new java.awt.Color(35, 43, 47));
        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 5, new java.awt.Color(255, 102, 0)));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(41, 34, 46));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Algorithme Euclide (Etendu)");
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

        jLabel10.setBackground(new java.awt.Color(41, 34, 46));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Inverse modulaire");
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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, 70));

        jLabel14.setBackground(new java.awt.Color(204, 204, 204));
        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(203, 203, 25));
        jLabel14.setText("<html><u>Algorithme Euclide Etendu</u></html>");
        jPanel15.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, -1));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 2, 130));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 90, 2));

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(203, 203, 25));
        jLabel20.setText("<html><u>Outlils ss</u></html>");
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 580, -1, -1));

        jPanel13.setBackground(new java.awt.Color(19, 18, 21));

        jLabel11.setBackground(new java.awt.Color(70, 48, 83));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Testes de primalité ");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setOpaque(true);
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

        jLabel16.setBackground(new java.awt.Color(70, 48, 83));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Generateurs");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel16.setOpaque(true);
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel16MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel16MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, 70));

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(203, 203, 25));
        jLabel17.setText("<html><u>Génération de nombres premiers</u></html>");
        jPanel15.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        jPanel20.setBackground(new java.awt.Color(27, 25, 32));

        jLabel21.setBackground(new java.awt.Color(70, 48, 83));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Arithmetique polynomial ");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel21.setOpaque(true);
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel21MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel21MouseReleased(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(70, 48, 83));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("GF(2^m) et AES");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel22.setOpaque(true);
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel22MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel22MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 780, 520, 70));

        jLabel23.setBackground(new java.awt.Color(204, 204, 204));
        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(203, 203, 25));
        jLabel23.setText("<html><u>Arithmetique polynomiale et arithmetique de AES </u></html>");
        jPanel15.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 750, -1, -1));

        jLabel26.setBackground(new java.awt.Color(204, 204, 204));
        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(203, 203, 25));
        jLabel26.setText("<html><u>Fraction continue</u></html>");
        jPanel15.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 920, -1, -1));

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 320, 2, 150));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 60, 2));

        jPanel28.setBackground(new java.awt.Color(35, 43, 47));
        jPanel28.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 5, new java.awt.Color(255, 102, 0)));
        jPanel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel28MouseExited(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(41, 34, 46));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 153));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Convertisseur Dec Bin Hex");
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

        jLabel29.setBackground(new java.awt.Color(41, 34, 46));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 153, 153));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Convertisseur Bin Dec");
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

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 610, -1, 70));

        jPanel29.setBackground(new java.awt.Color(35, 43, 47));
        jPanel29.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 5, new java.awt.Color(255, 102, 0)));
        jPanel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel29MouseExited(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(41, 34, 46));
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 153, 153));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Fraction continue");
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

        jLabel31.setBackground(new java.awt.Color(41, 34, 46));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 153, 153));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 1, 1, new java.awt.Color(227, 34, 86)));
        jLabel31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel31.setOpaque(true);
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
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

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 950, -1, 70));

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 820, 62, 2));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 680, 2, 140));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 850, 2, 130));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 980, 90, 4));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 2, 130));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 640, 90, 2));

        jScrollPane1.setViewportView(jPanel15);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(2, 142, 900, 500);

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/undo-2_64x64.png"))); // NOI18N
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
        jPanel1.add(jLabel27);
        jLabel27.setBounds(904, 580, 40, 64);

        jPanel23.setBackground(new java.awt.Color(27, 29, 39));
        jPanel23.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(128, 66, 128)));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/undo-512_64x64.png"))); // NOI18N
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
        jLabel12.setVisible(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(380, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(54, 54, 54))
        );

        jPanel1.add(jPanel23);
        jPanel23.setBounds(880, 142, 61, 500);

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

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
  
        scaleSwingManual(jPanel5, 35, 20);
        downSwing(jPanel5, 20);         
        jLabel5.setBackground(new java.awt.Color(41, 35, 46));

jLabel5.setForeground(new java.awt.Color(125, 112, 139));
 scaleSwingManual(jLabel5, 30, 10);
 


 
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited

scaleSwingManual(jPanel5, -35, -20);
downSwing(jPanel5, -20);  
        jLabel5.setBackground(new java.awt.Color(70, 48, 83));

jLabel5.setForeground(new java.awt.Color(153, 153, 153));

 scaleSwingManual(jLabel5, -30, -10);
 

  
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
   scaleSwingManual(jPanel5, 35, 20);
        downSwing(jPanel5, 20);         
     
        jLabel6.setBackground(new java.awt.Color(41, 35, 46));

jLabel6.setForeground(new java.awt.Color(125, 112, 139)); 

 scaleSwingManual(jLabel6, 30, 10);
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
   scaleSwingManual(jPanel5, -35, -20);
downSwing(jPanel5, -20);  
        
        jLabel6.setBackground(new java.awt.Color(70, 48, 83));

jLabel6.setForeground(new java.awt.Color(153, 153, 153));

 scaleSwingManual(jLabel6, -30, -10);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
jLabel6.setBackground(new java.awt.Color(255, 255, 51));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseReleased
     jLabel6.setBackground(new java.awt.Color(41, 35, 46));
       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseReleased

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
jLabel5.setBackground(new java.awt.Color(255, 255, 51));           // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseReleased
         jLabel5.setBackground(new java.awt.Color(41, 35, 46));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseReleased

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
      scaleSwingManual(jPanel10, 35, 20);
        downSwing(jPanel10, 20);  
     
        jLabel10.setBackground(new java.awt.Color(41, 35, 46));

jLabel10.setForeground(new java.awt.Color(125, 112, 139)); 

 scaleSwingManual(jLabel10, 30, 10);    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        scaleSwingManual(jPanel10, -35, -20);
        downSwing(jPanel10, -20);  
        
     jLabel10.setBackground(new java.awt.Color(41, 34, 46));

jLabel10.setForeground(new java.awt.Color(153, 153, 153));

 scaleSwingManual(jLabel10, -30, -10);
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
      scaleSwingManual(jPanel10, -35, -20);
        downSwing(jPanel10, -20);  
        
     jLabel8.setBackground(new java.awt.Color(41, 34, 46));

jLabel8.setForeground(new java.awt.Color(153, 153, 153));

 scaleSwingManual(jLabel8, -30, -10);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
 scaleSwingManual(jPanel10, 35, 20);
        downSwing(jPanel10, 20);  
     
        jLabel8.setBackground(new java.awt.Color(41, 35, 46));

jLabel8.setForeground(new java.awt.Color(125, 112, 139)); 

 scaleSwingManual(jLabel8, 30, 10);      
        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
   
        jLabel11.setBackground(new java.awt.Color(41, 35, 46));
jLabel11.setForeground(new java.awt.Color(125, 112, 139));

 
        jLabel11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 5, new java.awt.Color(204, 153, 0)));
 
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
         jLabel11.setBackground(new java.awt.Color(70, 48, 83));

jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setBorder(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MousePressed
jLabel11.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MousePressed

    private void jLabel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseReleased
 jLabel11.setBackground(new java.awt.Color(41, 35, 46));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseReleased

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered

        jLabel16.setBackground(new java.awt.Color(41, 35, 46));
jLabel16.setForeground(new java.awt.Color(125, 112, 139));

 
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 5, new java.awt.Color(204, 153, 0)));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
    jLabel16.setBackground(new java.awt.Color(70, 48, 83));

jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setBorder(null);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MousePressed
jLabel16.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MousePressed

    private void jLabel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseReleased
 jLabel16.setBackground(new java.awt.Color(41, 35, 46));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseReleased

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
  scaleSwingManual(jPanel20, 35, 20);
        downSwing(jPanel20, 20);         
        jLabel21.setBackground(new java.awt.Color(41, 35, 46));

jLabel21.setForeground(new java.awt.Color(125, 112, 139));
 scaleSwingManual(jLabel21, 30, 10);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
scaleSwingManual(jPanel20, -35, -20);
downSwing(jPanel20, -20);  
        jLabel21.setBackground(new java.awt.Color(70, 48, 83));

jLabel21.setForeground(new java.awt.Color(153, 153, 153));

 scaleSwingManual(jLabel21, -30, -10);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MousePressed
jLabel21.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MousePressed

    private void jLabel21MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseReleased
jLabel21.setBackground(new java.awt.Color(41, 35, 46));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseReleased

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
  scaleSwingManual(jPanel20, 35, 20);
        downSwing(jPanel20, 20);         
        jLabel22.setBackground(new java.awt.Color(41, 35, 46));

jLabel22.setForeground(new java.awt.Color(125, 112, 139));
 scaleSwingManual(jLabel22, 30, 10);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
scaleSwingManual(jPanel20, -35, -20);
downSwing(jPanel20, -20);  
        jLabel22.setBackground(new java.awt.Color(70, 48, 83));

jLabel22.setForeground(new java.awt.Color(153, 153, 153));

 scaleSwingManual(jLabel22, -30, -10);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MousePressed
jLabel22.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MousePressed

    private void jLabel22MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseReleased
 jLabel22.setBackground(new java.awt.Color(41, 35, 46));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseReleased

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
  mainJfram fram = new mainJfram();
fram.setVisible(true);

this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
  scaleSwingManual(jPanel5, 35, 20);
        downSwing(jPanel5, 20);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
scaleSwingManual(jPanel5, -35, -20);
downSwing(jPanel5, -20);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
 scaleSwingManual(jPanel10, 35, 20);
        downSwing(jPanel10, 20);          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
 scaleSwingManual(jPanel10, -35, -20);
        downSwing(jPanel10, -20);          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseExited
int statOfScroll = 1;
    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
 
        
        
        if(statOfScroll==2){
            scroleAnnimWorker worker = new scroleAnnimWorker(jScrollPane1, 600, 30, 370, 0) ;
            worker.execute();
    
jLabel12.setVisible(false);

  statOfScroll=1;
}
else if(statOfScroll==3) {
  
    scroleAnnimWorker worker = new scroleAnnimWorker(jScrollPane1, 600, 30, 740, 370) ;
    worker.execute();
    
    //370+370
 jLabel27.setVisible(true);

 statOfScroll=2;
}

  this.repaint();
    this.revalidate();


// TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
    if(statOfScroll==1){
     
        scroleAnnimWorker worker = new scroleAnnimWorker(jScrollPane1, 600, 30, 0, 370) ;
    worker.execute();
   
 jLabel12.setVisible(true);

  statOfScroll=2;
    }
else if(statOfScroll==2) {
    scroleAnnimWorker worker = new scroleAnnimWorker(jScrollPane1, 600, 30, 370, 740) ;
    worker.execute();
    
    
 jLabel27.setVisible(false);
  statOfScroll=3;
}
    this.repaint();
    this.revalidate();
    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
  scaleSwingManual(jPanel28, 35, 20);
        downSwing(jPanel28, 20);         
        jLabel28.setBackground(new java.awt.Color(41, 35, 46));

jLabel28.setForeground(new java.awt.Color(125, 112, 139));
 scaleSwingManual(jLabel28, 30, 10);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
scaleSwingManual(jPanel28, -35, -20);
downSwing(jPanel28, -20);  
       jLabel28.setBackground(new java.awt.Color(41, 34, 46));

jLabel28.setForeground(new java.awt.Color(153, 153, 153));
 scaleSwingManual(jLabel28, -30, -10);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseExited

    private void jLabel28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MousePressed
jLabel28.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MousePressed

    private void jLabel28MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseReleased
  jLabel28.setBackground(new java.awt.Color(41, 35, 46));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseReleased

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
  scaleSwingManual(jPanel28, 35, 20);
        downSwing(jPanel28, 20);         
        jLabel29.setBackground(new java.awt.Color(41, 35, 46));

jLabel29.setForeground(new java.awt.Color(125, 112, 139));
 scaleSwingManual(jLabel29, 30, 10);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
scaleSwingManual(jPanel28, -35, -20);
downSwing(jPanel28, -20);  
      jLabel29.setBackground(new java.awt.Color(41, 34, 46));

jLabel29.setForeground(new java.awt.Color(153, 153, 153));

 scaleSwingManual(jLabel29, -30, -10);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseExited

    private void jLabel29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MousePressed
jLabel29.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MousePressed

    private void jLabel29MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseReleased
  jLabel29.setBackground(new java.awt.Color(41, 35, 46));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseReleased

    private void jPanel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseEntered
 scaleSwingManual(jPanel28, 35, 20);
        downSwing(jPanel28, 20);          // TODO add your handling code here:
    }//GEN-LAST:event_jPanel28MouseEntered

    private void jPanel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseExited
scaleSwingManual(jPanel28, -35, -20);
        downSwing(jPanel28, -20);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel28MouseExited

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
  scaleSwingManual(jPanel29, 35, 20);
        downSwing(jPanel29, 20);         
        jLabel30.setBackground(new java.awt.Color(41, 35, 46));

jLabel30.setForeground(new java.awt.Color(125, 112, 139));
 scaleSwingManual(jLabel30, 30, 10);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
scaleSwingManual(jPanel29, -35, -20);
downSwing(jPanel29, -20);  
       jLabel30.setBackground(new java.awt.Color(41, 34, 46));

jLabel30.setForeground(new java.awt.Color(153, 153, 153));

 scaleSwingManual(jLabel30, -30, -10);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseExited

    private void jLabel30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MousePressed
jLabel30.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MousePressed

    private void jLabel30MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseReleased
  jLabel30.setBackground(new java.awt.Color(41, 35, 46));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseReleased

    private void jLabel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseEntered
scaleSwingManual(jPanel29, 35, 20);
        downSwing(jPanel29, 20);         
        jLabel31.setBackground(new java.awt.Color(41, 35, 46));

jLabel31.setForeground(new java.awt.Color(125, 112, 139));
 scaleSwingManual(jLabel31, 30, 10);          // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseEntered

    private void jLabel31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseExited
scaleSwingManual(jPanel29, -35, -20);
downSwing(jPanel29, -20);  
       jLabel31.setBackground(new java.awt.Color(41, 34, 46));

jLabel31.setForeground(new java.awt.Color(153, 153, 153));

 scaleSwingManual(jLabel31, -30, -10);         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseExited

    private void jLabel31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MousePressed
jLabel31.setBackground(new java.awt.Color(255, 255, 51));         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MousePressed

    private void jLabel31MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseReleased
  jLabel31.setBackground(new java.awt.Color(41, 35, 46));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel31MouseReleased

    private void jPanel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseEntered
 scaleSwingManual(jPanel29, 35, 20);
        downSwing(jPanel29, 20);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MouseEntered

    private void jPanel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel29MouseExited
scaleSwingManual(jPanel29, -35, -20);
        downSwing(jPanel29, -20);           // TODO add your handling code here:
    }//GEN-LAST:event_jPanel29MouseExited

    private void jLabel12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MousePressed
jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/undo-512_64x64_3.png"))); // NOI18N

        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MousePressed

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/undo-512_64x64_2.png"))); // NOI18N


        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/undo-512_64x64.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseReleased
jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/undo-512_64x64_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseReleased

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/undo-2_64x64.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseExited

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/undo-2_64x64_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MousePressed
jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/undo-2_64x64_3.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MousePressed

    private void jLabel27MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseReleased
jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/undo-2_64x64_2.png"))); // NOI18N
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseReleased

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
SquareAndMultiplay fram = new SquareAndMultiplay();
fram.setVisible(true);
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
Euclide fram = new Euclide();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
     InverseModulaire fram = new InverseModulaire();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
decBinaireConvesion1 fram = new decBinaireConvesion1();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
testDePrimality fram = new testDePrimality();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
generationDeNombrePremier fram = new generationDeNombrePremier();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
PolyArithm fram = new PolyArithm();  
fram.setVisible(true);
this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
  G2mAES fram = new G2mAES();  
fram.setVisible(true);
this.dispose();     

    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    SquareAndMultiplayModuloEtude fram = new SquareAndMultiplayModuloEtude();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
decBinaireConvesion fram = new decBinaireConvesion();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
     FractionContinnue fram= new FractionContinnue();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

  
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
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
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
