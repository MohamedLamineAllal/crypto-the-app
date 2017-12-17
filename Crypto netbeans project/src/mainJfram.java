
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import static java.time.Clock.system;
import java.util.List;
import java.util.concurrent.ExecutionException;
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


public class mainJfram extends javax.swing.JFrame {

    /**
     * Creates new form mainJfram
     */
    public mainJfram() {
        initComponents();
                
        Rectangle rect=new Rectangle(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        // that, give the available screen space (width and height (without counting the task bar)) 
        setLocation((int)(rect.getWidth()-getWidth())/2, (int)(rect.getHeight()-getHeight())/2); //seting the location of the jFram to be centred
        //                                       ^                                      ^
        //                                 width of the jfram                  height of the jfram
     
        
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
              jScrollPane1.updateUI();
              jScrollPane1.repaint();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
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

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(91, 37, 73));
        jPanel1.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 255));
        jLabel3.setText("Une Fenetre sur");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("et la cryptanalyse");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" la cryptographie ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jLabel6.setBackground(new java.awt.Color(0, 51, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Red Hammer Attack 8 128x128 .png"))); // NOI18N
        jLabel6.setText("Attaques");
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
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 102));
        jLabel7.setText("CRYPTO");

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel8.setBackground(new java.awt.Color(0, 51, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock-unlock-icon.png"))); // NOI18N
        jLabel8.setText("Cryptosystemes");
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

        jLabel9.setBackground(new java.awt.Color(0, 51, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tools 100x100 .png"))); // NOI18N
        jLabel9.setText("Outils");
        jLabel9.setOpaque(true);
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

        jPanel9.setBackground(new java.awt.Color(112, 103, 163));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 838, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel11.setBackground(new java.awt.Color(68, 35, 70));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 204, 255));
        jLabel11.setText("           Cryptosystemes Modernes");
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
        });

        jLabel12.setBackground(new java.awt.Color(102, 102, 102));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("           Cryptosystemes Classiques");
        jLabel12.setOpaque(true);
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
        });

        jPanel10.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 848, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jPanel13.setOpaque(false);
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel13.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 20, -1, -1));

        jPanel14.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 100, 180, -1));

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 102, 102));
        jLabel13.setText("CRYPTO");
        jPanel13.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(138, 138, 251));
        jLabel10.setText("Crypptosystemes");
        jPanel13.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        jPanel19.setBackground(new java.awt.Color(29, 31, 48));

        jPanel20.setBackground(new java.awt.Color(23, 24, 39));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64.png"))); // NOI18N
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
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel16)
                .addContainerGap(906, Short.MAX_VALUE))
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel7))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered

        jLabel8.setBackground(new java.awt.Color(103,77,181));  

jLabel9.setBackground(new java.awt.Color(40, 51, 51));  
jLabel9.setForeground(new java.awt.Color(40, 75, 75));
jLabel6.setBackground(new java.awt.Color(40, 51, 51));  
jLabel6.setForeground(new java.awt.Color(40, 75, 75));
///////
double widthDifference=50, hightDifference=25;
 
        jl6Dimension1=jLabel6.getSize();
        
        Dimension jl6Dimension2 = new Dimension();
        jl6Dimension2.setSize(jl6Dimension1.getWidth()-widthDifference, jl6Dimension1.getHeight()-hightDifference-20); //+20% 
        
   double jL6_X =jLabel6.getX();
   double jL6_Y = jLabel6.getY();
        Point jL6LocationTemporel= new Point();
        jL6LocationInitial=jLabel6.getLocation();
   jL6LocationTemporel.setLocation(jL6_X+widthDifference, jL6_Y);
jLabel6.setSize(jl6Dimension2);
jLabel6.setLocation(jL6LocationTemporel);

/////////////
 
        jl9Dimension1=jLabel9.getSize();
        
        Dimension jl9Dimension2 = new Dimension();
        jl9Dimension2.setSize(jl9Dimension1.getWidth()-widthDifference-20, jl9Dimension1.getHeight()-hightDifference-40); //+20% 
        
   double jL9_X =jLabel9.getX();
   double jL9_Y = jLabel9.getY();
        Point jL9LocationTemporel= new Point();
        jL9LocationInitial=jLabel9.getLocation();
    jL9LocationTemporel.setLocation(jL9_X, jL9_Y+hightDifference);
jLabel9.setSize(jl9Dimension2);
jLabel9.setLocation(jL9LocationTemporel);

////////////
        
        jl8Dimension1=jLabel8.getSize();
        
        Dimension jl8Dimension2 = new Dimension();
        jl8Dimension2.setSize(jl8Dimension1.getWidth()+widthDifference, jl8Dimension1.getHeight()+hightDifference); //+20% 
        
jLabel8.setSize(jl8Dimension2);

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited

jLabel8.setBackground(new java.awt.Color(0, 51, 51)); 
jLabel8.setForeground(Color.white);

jLabel6.setBackground(new java.awt.Color(0, 51, 51)); 
jLabel6.setForeground(new java.awt.Color(255,51,0));
jLabel9.setBackground(new java.awt.Color(0, 51, 51)); 
jLabel9.setForeground(new java.awt.Color(255,255,0));

jLabel6.setSize(jl6Dimension1);
jLabel6.setLocation(jL6LocationInitial);

jLabel9.setSize(jl9Dimension1);
jLabel9.setLocation(jL9LocationInitial);

jLabel8.setSize(jl8Dimension1);

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseExited


Point jL8LocationInitial= new Point();


    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered

       jLabel6.setBackground(new java.awt.Color(255,255,255));  //103,77,181

jLabel9.setBackground(new java.awt.Color(40, 51, 51));  
jLabel9.setForeground(new java.awt.Color(40, 75, 75));
jLabel8.setBackground(new java.awt.Color(40, 51, 51));  
jLabel8.setForeground(new java.awt.Color(40, 75, 75));
///////
double widthDifference=50, hightDifference=25;
 
        jl8Dimension1=jLabel8.getSize();
        
        Dimension jl8Dimension2 = new Dimension();
        jl8Dimension2.setSize(jl8Dimension1.getWidth()-widthDifference, jl8Dimension1.getHeight()-hightDifference-20); //+20% 
        
   double jL8_X =jLabel8.getX();
   double jL8_Y = jLabel8.getY();
        Point jL8LocationTemporel= new Point();
        jL8LocationInitial=jLabel8.getLocation();
   jL8LocationTemporel.setLocation(jL8_X+widthDifference, jL8_Y);
jLabel8.setSize(jl8Dimension2);
jLabel8.setLocation(jL8LocationTemporel);

/////////////
 
        jl9Dimension1=jLabel9.getSize();
        
        Dimension jl9Dimension2 = new Dimension();
        jl9Dimension2.setSize(jl9Dimension1.getWidth()-widthDifference-20, jl9Dimension1.getHeight()-hightDifference-40); //+20% 
        
   double jL9_X =jLabel9.getX();
   double jL9_Y = jLabel9.getY();
        Point jL9LocationTemporel= new Point();
        jL9LocationInitial=jLabel9.getLocation();
    jL9LocationTemporel.setLocation(jL9_X, jL9_Y+hightDifference);
jLabel9.setSize(jl9Dimension2);
jLabel9.setLocation(jL9LocationTemporel);

////////////
        
        jl6Dimension1=jLabel6.getSize();
        
        Dimension jl6Dimension2 = new Dimension();
        jl6Dimension2.setSize(jl6Dimension1.getWidth()+widthDifference, jl6Dimension1.getHeight()+hightDifference); //+20% 
        
jLabel6.setSize(jl6Dimension2);
 
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
jLabel6.setBackground(new java.awt.Color(0, 51, 51)); 
jLabel6.setForeground(new java.awt.Color(255,51,0));

jLabel8.setBackground(new java.awt.Color(0, 51, 51)); 
jLabel8.setForeground(Color.white);
jLabel9.setBackground(new java.awt.Color(0, 51, 51)); 
jLabel9.setForeground(new java.awt.Color(255,255,0));

jLabel8.setSize(jl8Dimension1);
jLabel8.setLocation(jL8LocationInitial);

jLabel9.setSize(jl9Dimension1);
jLabel9.setLocation(jL9LocationInitial);

jLabel6.setSize(jl6Dimension1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
jLabel9.setBackground(new java.awt.Color(10,155,255));  //103,77,181

jLabel8.setBackground(new java.awt.Color(40, 51, 51));  
jLabel8.setForeground(new java.awt.Color(40, 75, 75));
jLabel6.setBackground(new java.awt.Color(40, 51, 51));  
jLabel6.setForeground(new java.awt.Color(40, 75, 75));

///////
double widthDifference=25, hightDifference=50;
 
        jl6Dimension1=jLabel6.getSize();
        
        Dimension jl6Dimension2 = new Dimension();
        jl6Dimension2.setSize(jl6Dimension1.getWidth()-widthDifference, jl6Dimension1.getHeight()-hightDifference); //+20% 
        
        double jL6_X =jLabel6.getX();
   double jL6_Y = jLabel6.getY();
        Point jL6LocationTemporel= new Point();
        jL6LocationInitial=jLabel6.getLocation();
    jL6LocationTemporel.setLocation(jL6_X+widthDifference/2, jL6_Y);
           
jLabel6.setSize(jl6Dimension2);
jLabel6.setLocation(jL6LocationTemporel);

/////////////
 
        jl8Dimension1=jLabel8.getSize();
        
        Dimension jl8Dimension2 = new Dimension();
        jl8Dimension2.setSize(jl8Dimension1.getWidth()-widthDifference, jl8Dimension1.getHeight()-hightDifference); //+20% 
        double jL8_X =jLabel8.getX();
   double jL8_Y = jLabel8.getY();
        Point jL8LocationTemporel= new Point();
        jL8LocationInitial=jLabel8.getLocation();
    jL8LocationTemporel.setLocation(jL8_X+widthDifference/2, jL8_Y);
        
jLabel8.setSize(jl8Dimension2);
jLabel8.setLocation(jL8LocationTemporel);

////////////
        
        jl9Dimension1=jLabel9.getSize();
        
        Dimension jl9Dimension2 = new Dimension();
        jl9Dimension2.setSize(jl9Dimension1.getWidth()+widthDifference, jl9Dimension1.getHeight()+hightDifference); //+20% 
        
jLabel9.setSize(jl9Dimension2);

double jL9_X =jLabel9.getX();
   double jL9_Y = jLabel9.getY();
        Point jL9LocationTemporel= new Point();
        jL9LocationInitial=jLabel9.getLocation();
   jL9LocationTemporel.setLocation(jL9_X-widthDifference/2, jL9_Y-hightDifference);
  
   jLabel9.setLocation(jL9LocationTemporel);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseEntered

    
    
    
    
    
    
    
    
    
    
    
    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
jLabel6.setBackground(new java.awt.Color(0, 51, 51)); 
jLabel6.setForeground(new java.awt.Color(255,51,0));

jLabel8.setBackground(new java.awt.Color(0, 51, 51)); 
jLabel8.setForeground(Color.white);
jLabel9.setBackground(new java.awt.Color(0, 51, 51)); 
jLabel9.setForeground(new java.awt.Color(255,255,0));

jLabel8.setSize(jl8Dimension1);
jLabel8.setLocation(jL8LocationInitial);

jLabel9.setSize(jl9Dimension1);
jLabel9.setLocation(jL9LocationInitial);

jLabel6.setSize(jl6Dimension1);
jLabel6.setLocation(jL6LocationInitial);
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
jLabel8.setBackground(new java.awt.Color(255, 51, 51));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseReleased
jLabel8.setBackground(new java.awt.Color(103,77,181));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseReleased

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
jLabel6.setBackground(new java.awt.Color(103,77,181));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MousePressed

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
outilsMenu fram = new outilsMenu();
fram.setVisible(true);
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
jLabel9.setVisible(false);
scroleAnnimWorker worker = new scroleAnnimWorker(jScrollPane1,250 ,45 , 0 ,550 );
worker.execute();
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked
int jPnl17OrgWidth;
int jPnl17OrgHeight;
int jPnl12OrgWidth;
int jPnl12OrgHeight;
int jPnl10OrgWidth;
int jPnl10OrgHeight;
int jPnl11OrgWidth;
int jPnl11OrgHeight;
    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
jPnl17OrgWidth = jPanel17.getWidth();
jPnl17OrgHeight = jPanel17.getHeight();

jPnl12OrgWidth = jPanel12.getWidth();
jPnl12OrgHeight = jPanel12.getHeight();

jPnl10OrgWidth = jPanel10.getWidth();
jPnl10OrgHeight = jPanel10.getHeight();

jPnl11OrgWidth = jPanel11.getWidth();
jPnl11OrgHeight = jPanel11.getHeight();



        jLabel12.setSize(jLabel12.getWidth()+50, jLabel12.getHeight()+30); 
jLabel12.setLocation(jLabel12.getX()-25, jLabel12.getY()-15 );

  jLabel11.setSize(jLabel11.getWidth()-50, jLabel11.getHeight()-30); 
jLabel11.setLocation(jLabel11.getX()+25, jLabel11.getY()+15 );


jPanel17.setLocation(jPanel17.getX()-25,jPanel17.getY()-15 );
jPanel17.setSize(jLabel12.getWidth(), 10);

jPanel12.setLocation(jPanel12.getX()-25,jPanel12.getY()+15 );
jPanel12.setSize(jLabel12.getWidth(), 40);

jPanel11.setLocation(jPanel11.getX()+25,jPanel11.getY()+18 );
jPanel11.setSize(jLabel11.getWidth(), 5);

jPanel10.setLocation(jPanel10.getX()+25,jPanel10.getY()-15 );
jPanel10.setSize(jLabel11.getWidth(), 10);

jLabel12.setBackground(new java.awt.Color(193, 73, 73));
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited


jLabel12.setSize(jLabel12.getWidth()-50, jLabel12.getHeight()-30); 
jLabel12.setLocation(jLabel12.getX()+25, jLabel12.getY()+15 );

jLabel11.setSize(jLabel11.getWidth()+50, jLabel11.getHeight()+30); 
jLabel11.setLocation(jLabel11.getX()-25, jLabel11.getY()-15 );

jPanel17.setLocation(jPanel17.getX()+25,jPanel17.getY()+15 );
jPanel17.setSize(jPnl17OrgWidth, jPnl17OrgHeight);

jPanel12.setLocation(jPanel12.getX()+25,jPanel12.getY()-15 );
jPanel12.setSize(jPnl12OrgWidth, jPnl12OrgHeight);


jPanel11.setLocation(jPanel11.getX()-25,jPanel11.getY()-18 );
jPanel11.setSize(jPnl11OrgWidth, jPnl11OrgHeight);

jPanel10.setLocation(jPanel10.getX()-25,jPanel10.getY()+15 );
jPanel10.setSize(jPnl10OrgWidth, jPnl10OrgHeight);

jLabel12.setBackground(new java.awt.Color(102, 102, 102));

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
    menuModernCrypto fram = new menuModernCrypto();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered


jPnl17OrgWidth = jPanel17.getWidth();
jPnl17OrgHeight = jPanel17.getHeight();

jPnl12OrgWidth = jPanel12.getWidth();
jPnl12OrgHeight = jPanel12.getHeight();

jPnl10OrgWidth = jPanel10.getWidth();
jPnl10OrgHeight = jPanel10.getHeight();

jPnl11OrgWidth = jPanel11.getWidth();
jPnl11OrgHeight = jPanel11.getHeight();

        jLabel12.setSize(jLabel12.getWidth()-50, jLabel12.getHeight()-30); 
jLabel12.setLocation(jLabel12.getX()+25, jLabel12.getY()+15 );

  jLabel11.setSize(jLabel11.getWidth()+50, jLabel11.getHeight()+30); 
jLabel11.setLocation(jLabel11.getX()-25, jLabel11.getY()-15 );


jPanel17.setLocation(jPanel17.getX()+25,jPanel17.getY()+15 );
jPanel17.setSize(jLabel12.getWidth(), 5);

jPanel12.setLocation(jPanel12.getX()+25,jPanel12.getY()-15 );
jPanel12.setSize(jLabel12.getWidth(), 10);

jPanel11.setLocation(jPanel11.getX()-25,jPanel11.getY()-18 );
jPanel11.setSize(jLabel11.getWidth(), 10);

jPanel10.setLocation(jPanel10.getX()-25,jPanel10.getY()+15 );
jPanel10.setSize(jLabel11.getWidth(), 40);  


jLabel11.setBackground(new java.awt.Color(98, 59, 100));

// TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited

      
        
jLabel12.setSize(jLabel12.getWidth()+50, jLabel12.getHeight()+30); 
jLabel12.setLocation(jLabel12.getX()-25, jLabel12.getY()-15 );

jLabel11.setSize(jLabel11.getWidth()-50, jLabel11.getHeight()-30); 
jLabel11.setLocation(jLabel11.getX()+25, jLabel11.getY()+15 );

jPanel17.setLocation(jPanel17.getX()-25,jPanel17.getY()-15 );
jPanel17.setSize(jPnl17OrgWidth, jPnl17OrgHeight);

jPanel12.setLocation(jPanel12.getX()-25,jPanel12.getY()+15 );
jPanel12.setSize(jPnl12OrgWidth, jPnl12OrgHeight);


jPanel11.setLocation(jPanel11.getX()+25,jPanel11.getY()+18 );
jPanel11.setSize(jPnl11OrgWidth, jPnl11OrgHeight);

jPanel10.setLocation(jPanel10.getX()+25,jPanel10.getY()-15 );
jPanel10.setSize(jPnl10OrgWidth, jPnl10OrgHeight);

jLabel11.setBackground(new java.awt.Color(68, 35, 70));  
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseExited

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

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        mainJfram fram = new mainJfram();
        fram.setVisible(true);

        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64_4.png")));
        jLabel16.updateUI();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64.png")));

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MousePressed
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back button/64x64/back-128_64x64_3.png")));        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MousePressed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
menuClassicCrypto fram = new menuClassicCrypto();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
  menuAttacks fram = new menuAttacks();
fram.setVisible(true);
fram.setLocation(this.getLocation());
this.dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

  
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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
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
