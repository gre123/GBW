/*
 */

package gui;

import boids.boid;
import boids.boidsFabric;
import boids.mainBoids;
import java.util.ArrayList;
import simulation.symulacja;
import simulation.threadSym;

/**
 *@author Bylina, Gajda, Wszołek
 */
public class mainWindow extends javax.swing.JFrame {
public panel ptr=null;
public boidsFabric fabric=null;
double[] tabFPS = new double[10];
      int tabIter=0;
    public mainWindow() {
        initComponents(); 
        setAllLbl();
    }

    /**

     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        sldAnimSpeed = new javax.swing.JSlider();
        jLabel9 = new javax.swing.JLabel();
        txtFPS = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        setPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sldAliCof = new javax.swing.JSlider();
        sldSepCof = new javax.swing.JSlider();
        sldCohCof = new javax.swing.JSlider();
        sldLeadCof = new javax.swing.JSlider();
        sldNeigh = new javax.swing.JSlider();
        sldAngle = new javax.swing.JSlider();
        sldRandCof = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblAli = new javax.swing.JLabel();
        lblSep = new javax.swing.JLabel();
        lblCoh = new javax.swing.JLabel();
        lblLead = new javax.swing.JLabel();
        lblNeigh = new javax.swing.JLabel();
        lblAngle = new javax.swing.JLabel();
        lblRand = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sldPredCof = new javax.swing.JSlider();
        lblPred = new javax.swing.JLabel();
        editFlock = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        textNumPred = new javax.swing.JSpinner();
        btnGenStado = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        sldMaxSpeed = new javax.swing.JSlider();
        txtNumSwarm = new javax.swing.JFormattedTextField();
        sldMaxAccel = new javax.swing.JSlider();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblMaxAccel = new javax.swing.JLabel();
        lblMaxSpeed = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Symulacja stada - Bylina,Gajda,Wszołek 2013");
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1300, 760));
        setMinimumSize(new java.awt.Dimension(1140, 640));
        setName("mainWin"); // NOI18N

        jLabel8.setText("Szybkość animacji:");

        sldAnimSpeed.setMaximum(50);
        sldAnimSpeed.setMinimum(1);
        sldAnimSpeed.setPaintLabels(true);
        sldAnimSpeed.setValue(30);
        sldAnimSpeed.setMaximumSize(new java.awt.Dimension(32767, 20));
        sldAnimSpeed.setPreferredSize(new java.awt.Dimension(200, 20));
        sldAnimSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAnimSpeedStateChanged(evt);
            }
        });

        jLabel9.setText("Klatki na sekundę:");

        txtFPS.setText("0");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTabbedPane1.setName("settings"); // NOI18N

        setPanel.setToolTipText("panel ustawien symulacji");
        setPanel.setName("setPanel"); // NOI18N

        startButton.setText("Rozpocznij symulacje");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Aligmnet:");
        jLabel2.setToolTipText("Dążenie do prędkości tej co grupa");

        jLabel3.setText("Separate:");
        jLabel3.setToolTipText("Dążenie do zachowania bezpiecznej odległości od siebie");

        sldAliCof.setMaximum(3000);
        sldAliCof.setToolTipText("");
        sldAliCof.setValue(800);
        sldAliCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAliCofStateChanged(evt);
            }
        });

        sldSepCof.setMaximum(3000);
        sldSepCof.setToolTipText("");
        sldSepCof.setValue(1200);
        sldSepCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldSepCofStateChanged(evt);
            }
        });

        sldCohCof.setMaximum(3000);
        sldCohCof.setToolTipText("");
        sldCohCof.setValue(500);
        sldCohCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldCohCofStateChanged(evt);
            }
        });

        sldLeadCof.setMaximum(3000);
        sldLeadCof.setValue(1000);
        sldLeadCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldLeadCofStateChanged(evt);
            }
        });

        sldNeigh.setMaximum(3000);
        sldNeigh.setValue(400);
        sldNeigh.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldNeighStateChanged(evt);
            }
        });

        sldAngle.setMaximum(3150);
        sldAngle.setValue(1000);
        sldAngle.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAngleStateChanged(evt);
            }
        });

        sldRandCof.setMaximum(3000);
        sldRandCof.setValue(500);
        sldRandCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldRandCofStateChanged(evt);
            }
        });

        jLabel4.setText("Cohesion:");
        jLabel4.setToolTipText("Dążenie do bycia w środku grupy");

        jLabel5.setText("Follow leader:");
        jLabel5.setToolTipText("Podążenie za liderem");

        jLabel12.setText("Sąsiedztwo:");
        jLabel12.setToolTipText("wielkość sąsiedztwa");

        jLabel13.setText("Kąt widzenia:");

        jLabel14.setText("Losowe Ruchy:");

        lblAli.setText("jLabel15");

        lblSep.setText("jLabel15");

        lblCoh.setText("0");
        lblCoh.setToolTipText("");

        lblLead.setText("jLabel17");

        lblNeigh.setText("jLabel18");

        lblAngle.setText("jLabel19");

        lblRand.setText("jLabel20");

        jLabel15.setText("Escape predator:");

        sldPredCof.setMaximum(3000);
        sldPredCof.setValue(500);
        sldPredCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldPredCofStateChanged(evt);
            }
        });

        lblPred.setText("jLabel16");
        lblPred.setText(Double.toString(sldPredCof.getValue()/(double)100));

        javax.swing.GroupLayout setPanelLayout = new javax.swing.GroupLayout(setPanel);
        setPanel.setLayout(setPanelLayout);
        setPanelLayout.setHorizontalGroup(
            setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldAliCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldSepCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldCohCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldLeadCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldNeigh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldAngle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldRandCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldPredCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(setPanelLayout.createSequentialGroup()
                        .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAli))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSep))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCoh))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLead))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNeigh))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAngle))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRand))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPred)))
                        .addContainerGap())))
        );
        setPanelLayout.setVerticalGroup(
            setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblAli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAliCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblSep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldSepCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblCoh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldCohCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblLead))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sldLeadCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblNeigh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldNeigh, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblAngle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAngle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblRand))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldRandCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPred)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldPredCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Współczynniki", setPanel);
        setPanel.getAccessibleContext().setAccessibleName("");

        jLabel16.setText("Ilość drapieżników:");

        btnGenStado.setText("Generuj stado");
        btnGenStado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenStadoActionPerformed(evt);
            }
        });

        jLabel7.setText("Liczebność:");

        sldMaxSpeed.setMaximum(3000);
        sldMaxSpeed.setValue(500);
        sldMaxSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldMaxSpeedStateChanged(evt);
            }
        });

        txtNumSwarm.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtNumSwarm.setText("1000");
        txtNumSwarm.setToolTipText("");
        txtNumSwarm.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNumSwarmPropertyChange(evt);
            }
        });

        sldMaxAccel.setMaximum(200);
        sldMaxAccel.setToolTipText("");
        sldMaxAccel.setValue(40);
        sldMaxAccel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldMaxAccelStateChanged(evt);
            }
        });

        jLabel10.setText("Max prędkość:");

        jLabel11.setText("Max przyspiesznie:");

        lblMaxAccel.setText("0");

        lblMaxSpeed.setText("0");

        javax.swing.GroupLayout editFlockLayout = new javax.swing.GroupLayout(editFlock);
        editFlock.setLayout(editFlockLayout);
        editFlockLayout.setHorizontalGroup(
            editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editFlockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenStado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(sldMaxSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldMaxAccel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMaxSpeed))
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMaxAccel))
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel16))
                        .addGap(10, 10, 10)
                        .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNumPred)
                            .addComponent(txtNumSwarm))))
                .addContainerGap())
        );
        editFlockLayout.setVerticalGroup(
            editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editFlockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(textNumPred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumSwarm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblMaxSpeed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldMaxSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblMaxAccel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldMaxAccel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 556, Short.MAX_VALUE)
                .addComponent(btnGenStado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Edycja stada", editFlock);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sldAnimSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFPS, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 775, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldAnimSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtFPS)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void setFPS(int fps){
        double dFPS=(double)fps/100d;
        txtFPS.setText(Double.toString(dFPS));
    }
    private void setAllLbl(){
         lblAli.setText(Double.toString(sldAliCof.getValue()/(double)1000));
         lblSep.setText(Double.toString(sldSepCof.getValue()/(double)1000));
         lblCoh.setText(Double.toString(sldCohCof.getValue()/(double)1000));
         lblLead.setText(Double.toString(sldLeadCof.getValue()/(double)1000));
         lblRand.setText(Double.toString(sldRandCof.getValue()/(double)1000));
         lblAngle.setText(Double.toString((int)((sldAngle.getValue()/(double)1000)*360/3.15)));
         lblNeigh.setText(Double.toString(sldNeigh.getValue()/(double)10));
         lblMaxAccel.setText(Double.toString(sldMaxAccel.getValue()/(double)10));
         lblMaxSpeed.setText(Double.toString(sldMaxSpeed.getValue()/(double)100));
    }
    private void sldAnimSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldAnimSpeedStateChanged
       if ( mainBoids.simul!=null){
        mainBoids.simul.changeAnimSpeed(this.sldAnimSpeed.getValue());
       }
    }//GEN-LAST:event_sldAnimSpeedStateChanged

    private void btnGenStadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenStadoActionPerformed
       fabric= new boidsFabric();
       fabric.setBoidsParametrs(sldMaxSpeed.getValue()/100d,sldMaxAccel.getValue()/10d);
       mainBoids.boids=fabric.createBoids(Integer.parseInt(this.txtNumSwarm.getText()),(int)this.textNumPred.getValue());
       mainBoids.prey=new ArrayList<boid>();
       if (ptr!=null){this.remove(ptr);}
       ptr=new panel(mainBoids.boids,mainBoids.prey);
       this.add(ptr);  
        ptr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });
       ptr.repaint();
    }//GEN-LAST:event_btnGenStadoActionPerformed

    private void txtNumSwarmPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNumSwarmPropertyChange
        
    }//GEN-LAST:event_txtNumSwarmPropertyChange

    private void sldMaxSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldMaxSpeedStateChanged
       lblMaxSpeed.setText(Double.toString(sldMaxSpeed.getValue()/(double)100));
    }//GEN-LAST:event_sldMaxSpeedStateChanged

    private void sldMaxAccelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldMaxAccelStateChanged
       lblMaxAccel.setText(Double.toString(sldMaxAccel.getValue()/(double)10));
    }//GEN-LAST:event_sldMaxAccelStateChanged

    private void sldPredCofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldPredCofStateChanged
        //------------------------------------------------------------------------
        //Uaktualnianie wartości z suwaczka odnosnie ucieczki
        lblPred.setText(Double.toString(sldPredCof.getValue()/(double)100));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
        //--------------------------------------------------------------------------
        // TODO add your handling code here:
    }//GEN-LAST:event_sldPredCofStateChanged

    private void sldRandCofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldRandCofStateChanged
        lblRand.setText(Double.toString(sldRandCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setRandCof(sldRandCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldRandCofStateChanged

    private void sldAngleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldAngleStateChanged
        lblAngle.setText(Double.toString((int)((sldAngle.getValue()/(double)1000)*360/3.15)));
        if (mainBoids.simul!=null){
            mainBoids.simul.setNeightParametrs(sldAngle.getValue()/(double)1000,sldNeigh.getValue()/(double)10);
        }
    }//GEN-LAST:event_sldAngleStateChanged

    private void sldNeighStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldNeighStateChanged
        lblNeigh.setText(Double.toString(sldNeigh.getValue()/(double)10));
        if (mainBoids.simul!=null){
            mainBoids.simul.setNeightParametrs(sldAngle.getValue()/(double)1000,sldNeigh.getValue()/(double)10);
        }
    }//GEN-LAST:event_sldNeighStateChanged

    private void sldLeadCofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldLeadCofStateChanged
        lblLead.setText(Double.toString(sldLeadCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldLeadCofStateChanged

    private void sldCohCofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldCohCofStateChanged
        lblCoh.setText(Double.toString(sldCohCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldCohCofStateChanged

    private void sldSepCofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSepCofStateChanged
        lblSep.setText(Double.toString(sldSepCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldSepCofStateChanged

    private void sldAliCofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldAliCofStateChanged
        lblAli.setText(Double.toString(sldAliCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldAliCofStateChanged

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if(mainBoids.simul==null || mainBoids.simul.continueSimulation==false){

            this.startButton.setText("Zatrzymaj symulację");
            mainBoids.simul= new symulacja(mainBoids.boids,mainBoids.prey);
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
            mainBoids.simul.setNeightParametrs(sldAngle.getValue()/(double)1000,sldNeigh.getValue()/(double)10);
            mainBoids.simul.setAnimSpeed(sldAnimSpeed.getValue());
            mainBoids.simul.setRandCof(sldRandCof.getValue()/(double)1000);

            Runnable runner = new threadSym(mainBoids.simul);
            Thread thread = new Thread(runner);
            thread.start();
        }else{
            this.startButton.setText("Rozpocznij symulację");
            mainBoids.simul.continueSimulation=false;
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {                                     
      int cordX=evt.getX();
      int cordY=evt.getY();
    } 
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
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               mainWindow win= new mainWindow();   
               win.setVisible(true);
               
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenStado;
    private javax.swing.JPanel editFlock;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAli;
    private javax.swing.JLabel lblAngle;
    private javax.swing.JLabel lblCoh;
    private javax.swing.JLabel lblLead;
    private javax.swing.JLabel lblMaxAccel;
    private javax.swing.JLabel lblMaxSpeed;
    private javax.swing.JLabel lblNeigh;
    private javax.swing.JLabel lblPred;
    private javax.swing.JLabel lblRand;
    private javax.swing.JLabel lblSep;
    private javax.swing.JPanel setPanel;
    private javax.swing.JSlider sldAliCof;
    private javax.swing.JSlider sldAngle;
    private javax.swing.JSlider sldAnimSpeed;
    private javax.swing.JSlider sldCohCof;
    private javax.swing.JSlider sldLeadCof;
    private javax.swing.JSlider sldMaxAccel;
    private javax.swing.JSlider sldMaxSpeed;
    private javax.swing.JSlider sldNeigh;
    private javax.swing.JSlider sldPredCof;
    private javax.swing.JSlider sldRandCof;
    private javax.swing.JSlider sldSepCof;
    private javax.swing.JButton startButton;
    private javax.swing.JSpinner textNumPred;
    private javax.swing.JLabel txtFPS;
    private javax.swing.JFormattedTextField txtNumSwarm;
    // End of variables declaration//GEN-END:variables
}
