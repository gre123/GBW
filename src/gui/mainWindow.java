

package gui;

import boids.boidsFabric;
import boids.mainBoids;
import math.vector2d;
import simulation.symulacja;
import simulation.threadSym;
import trunk.src.boids.obstaclesFabric;

/**
 *@author Bylina, Gajda, Wszołek
 */
public class mainWindow extends javax.swing.JFrame {
public panel ptr=null;
public boidsFabric fabric=null;
public obstaclesFabric obsfabric = null;
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
        jLabel1 = new javax.swing.JLabel();
        textLeaderNum = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        cobRozklad = new javax.swing.JComboBox();
        textNumObs = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
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
        sldAvoidCof = new javax.swing.JSlider();
        lblAvoid = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        sterLead = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        combLeadMove = new javax.swing.JComboBox();
        btnGlobAim = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        btnSterMysza = new javax.swing.JToggleButton();
        jLabel21 = new javax.swing.JLabel();
        combpredMove = new javax.swing.JComboBox();
        wygladPanel = new javax.swing.JPanel();
        btnWpływLeader = new javax.swing.JToggleButton();
        btnVelWart = new javax.swing.JToggleButton();
        btnAccelWart = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Symulacja stada - Bylina,Gajda,Wszołek 2013");
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1300, 760));
        setMinimumSize(new java.awt.Dimension(1140, 640));
        setName("mainWin"); // NOI18N
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

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

        jLabel1.setText("Ilość liderów:");

        jLabel6.setText("Rozkład:");

        cobRozklad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Losowy", "Równomierny", "Gaussa" }));

        textNumObs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel20.setText("Ilość przeszkód:");

        javax.swing.GroupLayout editFlockLayout = new javax.swing.GroupLayout(editFlock);
        editFlock.setLayout(editFlockLayout);
        editFlockLayout.setHorizontalGroup(
            editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editFlockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cobRozklad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addComponent(jLabel16)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumSwarm)
                            .addComponent(textLeaderNum)
                            .addComponent(textNumPred, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textNumObs, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        editFlockLayout.setVerticalGroup(
            editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editFlockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textLeaderNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(textNumPred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumSwarm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cobRozklad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(textNumObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 435, Short.MAX_VALUE)
                .addComponent(btnGenStado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Edycja stada", editFlock);

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

        lblAli.setText("0");

        lblSep.setText("0");

        lblCoh.setText("0");
        lblCoh.setToolTipText("");

        lblLead.setText("0");

        lblNeigh.setText("0");

        lblAngle.setText("0");

        lblRand.setText("0");

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

        sldAvoidCof.setMaximum(3000);
        sldAvoidCof.setToolTipText("");
        sldAvoidCof.setValue(0);
        sldAvoidCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAvoidCofStateChanged(evt);
            }
        });

        lblAvoid.setText("0");

        jLabel19.setText("Obstacle avoidance:");
        jLabel19.setToolTipText("Dążenie do zachowania bezpiecznej odległości od siebie");

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
                        .addContainerGap())
                    .addComponent(sldAvoidCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(setPanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAvoid))))
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
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCoh)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblAvoid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAvoidCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Symulacja", setPanel);
        setPanel.getAccessibleContext().setAccessibleName("");

        jLabel17.setText("Liderzy:");

        combLeadMove.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Koło", "Ósemka", "Kwadrat" }));
        combLeadMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combLeadMoveActionPerformed(evt);
            }
        });

        btnGlobAim.setText("reset");
        btnGlobAim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGlobAimActionPerformed(evt);
            }
        });

        jLabel18.setText("Global aim:");

        btnSterMysza.setSelected(true);
        btnSterMysza.setText("Steruj myszą\n");

        jLabel21.setText("Drapieżnik:");

        combpredMove.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "gonic_koszyki" }));
        combpredMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combpredMoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sterLeadLayout = new javax.swing.GroupLayout(sterLead);
        sterLead.setLayout(sterLeadLayout);
        sterLeadLayout.setHorizontalGroup(
            sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sterLeadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combLeadMove, 0, 160, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sterLeadLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGlobAim))
                    .addComponent(btnSterMysza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sterLeadLayout.createSequentialGroup()
                        .addGroup(sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel21))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(combpredMove, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        sterLeadLayout.setVerticalGroup(
            sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sterLeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combLeadMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGlobAim)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSterMysza, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combpredMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(522, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sterowanie", sterLead);

        btnWpływLeader.setText("wpływ lidera");

        btnVelWart.setText("wartość prędkości");

        btnAccelWart.setText("wartość przyspieszenia");

        javax.swing.GroupLayout wygladPanelLayout = new javax.swing.GroupLayout(wygladPanel);
        wygladPanel.setLayout(wygladPanelLayout);
        wygladPanelLayout.setHorizontalGroup(
            wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wygladPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAccelWart, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(btnVelWart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWpływLeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        wygladPanelLayout.setVerticalGroup(
            wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wygladPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnWpływLeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVelWart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAccelWart)
                .addContainerGap(618, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Wygląd", wygladPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sldAnimSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFPS, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 775, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldAnimSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtFPS)))
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Symulacja");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void setFPS(int fps){
        double dFPS=(double)fps/100d;
        txtFPS.setText(Double.toString(dFPS));
    }
    public  int getNumOfLeaders(){
     return (int)this.textLeaderNum.getValue();
    }
    public  int getNumOfPredators(){
     return (int)this.textNumPred.getValue();
    }
    public  int getNumOfObs(){
     return (int)this.textNumObs.getValue();
    }
    public  int getRozklad(){
     return (int)this.cobRozklad.getSelectedIndex();
    }
    public  boolean czyWplywLeader(){
     if (this.btnWpływLeader.isSelected()){return true;}
     return false;
    }
    public  boolean czyVelWart(){
     if (this.btnVelWart.isSelected()){return true;}
     return false;
    }
    public  boolean czyAccelWart(){
     if (this.btnAccelWart.isSelected()){return true;}
     return false;
    }
    public  int getLeaderTypeMovement(){
     return (int)this.combLeadMove.getSelectedIndex();
    }
    private void setAllLbl(){
         lblAli.setText(Double.toString(sldAliCof.getValue()/(double)1000));
         lblSep.setText(Double.toString(sldSepCof.getValue()/(double)1000));
         lblAvoid.setText(Double.toString(sldAvoidCof.getValue()/(double)1000));
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
    
       obsfabric = new obstaclesFabric();
       mainBoids.obs = obsfabric.createObs((int)textNumObs.getValue());// dorobić pole na ilośc przeszkód i wartość tutaj
       if (ptr!=null){this.remove(ptr);}
       //ptr=new panel(mainBoids.boids,mainBoids.prey);
       ptr=new panel(mainBoids.boids,mainBoids.obs);
       this.add(ptr);  
        ptr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });
        ptr.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelMouseMoved(evt);
            }
        });

//       ptr.addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyTyped(java.awt.event.KeyEvent evt) {
//                panelKeyTyped(evt);
//            }
//        });
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
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);

        }
    }//GEN-LAST:event_sldLeadCofStateChanged

    private void sldCohCofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldCohCofStateChanged
        lblCoh.setText(Double.toString(sldCohCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldCohCofStateChanged

    private void sldSepCofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSepCofStateChanged
        lblSep.setText(Double.toString(sldSepCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldSepCofStateChanged

    private void sldAliCofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldAliCofStateChanged
        lblAli.setText(Double.toString(sldAliCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldAliCofStateChanged

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if(mainBoids.simul==null || mainBoids.simul.continueSimulation==false){

            this.startButton.setText("Zatrzymaj symulację");
            //mainBoids.simul= new symulacja(mainBoids.boids,mainBoids.prey);
            mainBoids.simul= new symulacja(mainBoids.boids,mainBoids.obs);
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
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

    private void btnGlobAimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGlobAimActionPerformed
      ptr.aimX=-1;
      ptr.aimY=-1;
      mainBoids.simul.globalAim=new vector2d(-1,-1);
      
    }//GEN-LAST:event_btnGlobAimActionPerformed

    private void sldAvoidCofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldAvoidCofStateChanged
        lblAvoid.setText(Double.toString(sldAvoidCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldAvoidCofStateChanged

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void combpredMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combpredMoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combpredMoveActionPerformed

    private void combLeadMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combLeadMoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combLeadMoveActionPerformed

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {                                     
      ptr.aimX=evt.getX();
      ptr.aimY=evt.getY();
      mainBoids.simul.globalAim=new vector2d(evt.getX(),evt.getY());
    } 
    private void panelMouseMoved(java.awt.event.MouseEvent evt) {
        if(ptr.aimX>0 && ptr.aimY>0 && btnSterMysza.isSelected()){
        ptr.aimX=evt.getX();
      ptr.aimY=evt.getY();
      mainBoids.simul.globalAim=new vector2d(evt.getX(),evt.getY());
        }
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
    private javax.swing.JToggleButton btnAccelWart;
    private javax.swing.JButton btnGenStado;
    private javax.swing.JButton btnGlobAim;
    private javax.swing.JToggleButton btnSterMysza;
    private javax.swing.JToggleButton btnVelWart;
    private javax.swing.JToggleButton btnWpływLeader;
    private javax.swing.JComboBox cobRozklad;
    private javax.swing.JComboBox combLeadMove;
    private javax.swing.JComboBox combpredMove;
    private javax.swing.JPanel editFlock;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAli;
    private javax.swing.JLabel lblAngle;
    private javax.swing.JLabel lblAvoid;
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
    private javax.swing.JSlider sldAvoidCof;
    private javax.swing.JSlider sldCohCof;
    private javax.swing.JSlider sldLeadCof;
    private javax.swing.JSlider sldMaxAccel;
    private javax.swing.JSlider sldMaxSpeed;
    private javax.swing.JSlider sldNeigh;
    private javax.swing.JSlider sldPredCof;
    private javax.swing.JSlider sldRandCof;
    private javax.swing.JSlider sldSepCof;
    private javax.swing.JButton startButton;
    private javax.swing.JPanel sterLead;
    private javax.swing.JSpinner textLeaderNum;
    private javax.swing.JSpinner textNumObs;
    private javax.swing.JSpinner textNumPred;
    private javax.swing.JLabel txtFPS;
    private javax.swing.JFormattedTextField txtNumSwarm;
    private javax.swing.JPanel wygladPanel;
    // End of variables declaration//GEN-END:variables
}
