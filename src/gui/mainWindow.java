

package gui;

import boids.boidsFabric;
import boids.foodFabric;
import boids.mainBoids;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeEvent;
import math.vector2d;
import simulation.statistic;
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
public foodFabric ffabric = null;
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
        sterLead = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        combLeadMove = new javax.swing.JComboBox();
        btnGlobAim = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        btnSterMysza = new javax.swing.JToggleButton();
        jLabel21 = new javax.swing.JLabel();
        combpredMove = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        combpredEscape = new javax.swing.JComboBox();
        wygladPanel = new javax.swing.JPanel();
        btnWpływLeader = new javax.swing.JToggleButton();
        btnVelWart = new javax.swing.JToggleButton();
        btnAccelWart = new javax.swing.JToggleButton();
        jLabel29 = new javax.swing.JLabel();
        spnBoidRadius = new javax.swing.JSpinner();
        jLabel30 = new javax.swing.JLabel();
        spnLeaderRadius = new javax.swing.JSpinner();
        spnPredatorRadius = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        spnObstacleRadius = new javax.swing.JSpinner();
        jLabel33 = new javax.swing.JLabel();
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
        jLabel25 = new javax.swing.JLabel();
        textNumFood = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        sldPerHunger = new javax.swing.JSlider();
        lblHunger = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        sldTimeFood = new javax.swing.JSlider();
        lblTimeFood = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        spnMinDist = new javax.swing.JSpinner();
        statPanel = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblNumBoids = new javax.swing.JLabel();
        lblNumPred = new javax.swing.JLabel();
        lblNumLeaders = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lblAvgNumNeight = new javax.swing.JLabel();
        Symulacja = new javax.swing.JTabbedPane();
        setPanelPod = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sldAliCof = new javax.swing.JSlider();
        sldSepCof = new javax.swing.JSlider();
        sldCohCof = new javax.swing.JSlider();
        sldNeigh = new javax.swing.JSlider();
        sldAngle = new javax.swing.JSlider();
        sldRandCof = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblAli = new javax.swing.JLabel();
        lblSep = new javax.swing.JLabel();
        lblCoh = new javax.swing.JLabel();
        lblNeigh = new javax.swing.JLabel();
        lblAngle = new javax.swing.JLabel();
        lblRand = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        sldNumNeight = new javax.swing.JSlider();
        lblMaxNeight = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        sldReactionTime = new javax.swing.JSlider();
        lblTimeReaction = new javax.swing.JLabel();
        setPanelAdv = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblLead = new javax.swing.JLabel();
        sldLeadCof = new javax.swing.JSlider();
        jLabel15 = new javax.swing.JLabel();
        lblPred = new javax.swing.JLabel();
        sldPredCof = new javax.swing.JSlider();
        jLabel19 = new javax.swing.JLabel();
        sldAvoidCof = new javax.swing.JSlider();
        lblAvoid = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblAvoidMode = new javax.swing.JLabel();
        sldAvoidMode = new javax.swing.JSlider();
        jLabel24 = new javax.swing.JLabel();
        lblAvoidRec = new javax.swing.JLabel();
        sldAvoidRec = new javax.swing.JSlider();
        e = new javax.swing.JLabel();
        lblForagingDistance = new javax.swing.JLabel();
        sldForDist = new javax.swing.JSlider();
        btnStart = new javax.swing.JButton();

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

        sldAnimSpeed.setMaximum(54);
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
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(199, 512));

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

        combpredMove.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "gonic_koszyki", "gonic_najblizszego", "gonic_grupe", "mix_grupa_najblizszy" }));
        combpredMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combpredMoveActionPerformed(evt);
            }
        });

        jLabel22.setText("Zwykłe - ucieczka :");

        combpredEscape.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "stada+sam_doStada", "stada+sam_niezależ" }));
        combpredEscape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combpredEscapeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sterLeadLayout = new javax.swing.GroupLayout(sterLead);
        sterLead.setLayout(sterLeadLayout);
        sterLeadLayout.setHorizontalGroup(
            sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sterLeadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combLeadMove, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sterLeadLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGlobAim))
                    .addComponent(btnSterMysza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(combpredMove, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sterLeadLayout.createSequentialGroup()
                        .addGroup(sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(combpredEscape, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(combpredEscape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sterowanie", sterLead);

        btnWpływLeader.setText("wpływ lidera");

        btnVelWart.setText("wartość prędkości");

        btnAccelWart.setText("wartość przyspieszenia");

        jLabel29.setText("Wielkość boida:");

        spnBoidRadius.setOpaque(false);
        spnBoidRadius.setValue(2);

        jLabel30.setText("Wielkość lidera:");

        spnLeaderRadius.setOpaque(false);
        spnLeaderRadius.setValue(3);

        spnPredatorRadius.setOpaque(false);
        spnPredatorRadius.setValue(4);

        jLabel31.setText("Wielkość przeciwnika:");

        spnObstacleRadius.setOpaque(false);
        spnObstacleRadius.setValue(20);

        jLabel33.setText("Wielkość przeszkody:");

        javax.swing.GroupLayout wygladPanelLayout = new javax.swing.GroupLayout(wygladPanel);
        wygladPanel.setLayout(wygladPanelLayout);
        wygladPanelLayout.setHorizontalGroup(
            wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wygladPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAccelWart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVelWart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWpływLeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(wygladPanelLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnBoidRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(wygladPanelLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnLeaderRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(wygladPanelLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnPredatorRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(wygladPanelLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnObstacleRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
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
                .addGap(18, 18, 18)
                .addGroup(wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(spnBoidRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(spnLeaderRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(spnPredatorRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(spnObstacleRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Wygląd", wygladPanel);

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
        sldMaxAccel.setSnapToTicks(true);
        sldMaxAccel.setToolTipText("");
        sldMaxAccel.setValue(40);
        sldMaxAccel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldMaxAccelStateChanged(evt);
            }
        });

        jLabel10.setText("Max prędkość:");

        jLabel11.setText("Max przyspieszenie:");

        lblMaxAccel.setText("0");

        lblMaxSpeed.setText("0");

        jLabel1.setText("Ilość liderów:");

        jLabel6.setText("Rozkład:");

        cobRozklad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Losowy", "Równomierny", "Gaussa" }));

        textNumObs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel20.setText("Ilość przeszkód:");

        jLabel25.setText("Jedzenie :");

        jLabel27.setText("Głodnych :");

        sldPerHunger.setValue(0);
        sldPerHunger.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldPerHungerStateChanged(evt);
            }
        });

        lblHunger.setText("0");

        jLabel28.setText("Wytrzymałość jedzenia:");

        sldTimeFood.setMaximum(50000);
        sldTimeFood.setMinimum(5000);
        sldTimeFood.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldTimeFoodStateChanged(evt);
            }
        });

        lblTimeFood.setText("5000");

        jLabel32.setText("Min odległość:");

        spnMinDist.setValue(3);

        javax.swing.GroupLayout editFlockLayout = new javax.swing.GroupLayout(editFlock);
        editFlock.setLayout(editFlockLayout);
        editFlockLayout.setHorizontalGroup(
            editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editFlockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenStado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel25))
                        .addGap(24, 24, 24)
                        .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNumFood)
                            .addComponent(textNumObs)))
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
                    .addComponent(sldPerHunger, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHunger))
                    .addComponent(sldTimeFood, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editFlockLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cobRozklad, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTimeFood, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnMinDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        editFlockLayout.setVerticalGroup(
            editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editFlockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumSwarm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textLeaderNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(textNumPred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNumFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(textNumObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cobRozklad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblHunger))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldPerHunger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldTimeFood, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTimeFood)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(spnMinDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenStado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Stado", editFlock);

        statPanel.setMaximumSize(new java.awt.Dimension(182, 32767));

        jLabel35.setText("Ilość boidów:");

        jLabel36.setText("Ilość drapieżników:");

        jLabel37.setText("Ilość liderów:");

        lblNumBoids.setText("0");

        lblNumPred.setText("0");

        lblNumLeaders.setText("0");

        jLabel38.setText("Śr. ilość sąsiadów:");

        lblAvgNumNeight.setText("0");

        javax.swing.GroupLayout statPanelLayout = new javax.swing.GroupLayout(statPanel);
        statPanel.setLayout(statPanelLayout);
        statPanelLayout.setHorizontalGroup(
            statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumBoids)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblNumLeaders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNumPred))
                    .addComponent(lblAvgNumNeight))
                .addGap(2, 2, 2))
        );
        statPanelLayout.setVerticalGroup(
            statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lblNumBoids))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(lblNumPred))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lblNumLeaders))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAvgNumNeight)
                    .addComponent(jLabel38))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Statystyki", statPanel);

        setPanelPod.setToolTipText("panel ustawien symulacji");
        setPanelPod.setName("setPanelPod"); // NOI18N

        jLabel2.setText("Alignment:");
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

        sldNeigh.setMaximum(3000);
        sldNeigh.setToolTipText("");
        sldNeigh.setValue(700);
        sldNeigh.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldNeighStateChanged(evt);
            }
        });

        sldAngle.setMaximum(3150);
        sldAngle.setValue(2000);
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

        jLabel12.setText("Sąsiedztwo:");
        jLabel12.setToolTipText("wielkość sąsiedztwa");

        jLabel13.setText("Kąt widzenia:");

        jLabel14.setText("Losowe ruchy:");

        lblAli.setText("0");

        lblSep.setText("0");

        lblCoh.setText("0");
        lblCoh.setToolTipText("");

        lblNeigh.setText("0");

        lblAngle.setText("0");

        lblRand.setText("0");

        jLabel26.setText("Max liczba sąsiadów:");

        sldNumNeight.setMajorTickSpacing(1);
        sldNumNeight.setToolTipText("");
        sldNumNeight.setValue(7);
        sldNumNeight.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldNumNeightStateChanged(evt);
            }
        });

        lblMaxNeight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaxNeight.setText("0");

        jLabel34.setText("Czas reakcji:");

        sldReactionTime.setMaximum(150);
        sldReactionTime.setToolTipText("");
        sldReactionTime.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldReactionTimeStateChanged(evt);
            }
        });

        lblTimeReaction.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTimeReaction.setText("0");

        javax.swing.GroupLayout setPanelPodLayout = new javax.swing.GroupLayout(setPanelPod);
        setPanelPod.setLayout(setPanelPodLayout);
        setPanelPodLayout.setHorizontalGroup(
            setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setPanelPodLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldAliCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldSepCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldCohCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldRandCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldNeigh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldAngle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(setPanelPodLayout.createSequentialGroup()
                        .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(setPanelPodLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAli))
                            .addGroup(setPanelPodLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSep))
                            .addGroup(setPanelPodLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCoh))
                            .addGroup(setPanelPodLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(lblMaxNeight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(setPanelPodLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblRand))
                            .addGroup(setPanelPodLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNeigh))
                            .addGroup(setPanelPodLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAngle))
                            .addGroup(setPanelPodLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(lblTimeReaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(sldNumNeight, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldReactionTime, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        setPanelPodLayout.setVerticalGroup(
            setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setPanelPodLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblAli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAliCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblSep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldSepCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCoh)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldCohCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblRand))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldRandCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblNeigh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldNeigh, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblAngle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAngle, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblMaxNeight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldNumNeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(lblTimeReaction))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldReactionTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Symulacja.addTab("Podstawowe", setPanelPod);
        setPanelPod.getAccessibleContext().setAccessibleName("");

        jLabel5.setText("Follow leader:");
        jLabel5.setToolTipText("Podążenie za liderem");

        lblLead.setText("0");

        sldLeadCof.setMaximum(3000);
        sldLeadCof.setValue(1000);
        sldLeadCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldLeadCofStateChanged(evt);
            }
        });

        jLabel15.setText("Escape predator:");

        lblPred.setText("jLabel16");
        lblPred.setText(Double.toString(sldPredCof.getValue()/(double)100));

        sldPredCof.setMaximum(3000);
        sldPredCof.setValue(500);
        sldPredCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldPredCofStateChanged(evt);
            }
        });

        jLabel19.setText("Omijanie przeszkód:");
        jLabel19.setToolTipText("Sterowanie pozwalające na nie zderzanie się z przeszkodami");

        sldAvoidCof.setMaximum(3000);
        sldAvoidCof.setToolTipText("");
        sldAvoidCof.setValue(1500);
        sldAvoidCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAvoidCofStateChanged(evt);
            }
        });

        lblAvoid.setText("0");

        jLabel23.setText("Tryb omijania:");
        jLabel23.setToolTipText("0=przeciwnie do przeszkody, 1=lewo/prawo");

        lblAvoidMode.setText("0");
        lblAvoidMode.setToolTipText("0=przeciwnie do przeszkody, 1=lewo/prawo");

        sldAvoidMode.setMaximum(1000);
        sldAvoidMode.setToolTipText("0=przeciwnie do przeszkody, 1=lewo/prawo");
        sldAvoidMode.setValue(750);
        sldAvoidMode.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAvoidModeStateChanged(evt);
            }
        });

        jLabel24.setText("Długość prostokąta:");
        jLabel24.setToolTipText("Długość prostokąta przed boidem, w którym widzi on przeszkody");

        lblAvoidRec.setText("0");
        lblAvoidRec.setToolTipText("Długość prostokąta przed boidem, w którym widzi on przeszkody");

        sldAvoidRec.setToolTipText("Długość prostokąta przed boidem, w którym widzi on przeszkody");
        sldAvoidRec.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAvoidRecStateChanged(evt);
            }
        });

        e.setText("Wpływ jedzenia(odl) :");

        lblForagingDistance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblForagingDistance.setText("35");

        sldForDist.setValue(35);
        sldForDist.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldForDistStateChanged(evt);
            }
        });

        javax.swing.GroupLayout setPanelAdvLayout = new javax.swing.GroupLayout(setPanelAdv);
        setPanelAdv.setLayout(setPanelAdvLayout);
        setPanelAdvLayout.setHorizontalGroup(
            setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setPanelAdvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldLeadCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(setPanelAdvLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLead))
                    .addComponent(sldPredCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldAvoidCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(setPanelAdvLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAvoid))
                    .addGroup(setPanelAdvLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPred))
                    .addComponent(sldForDist, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(setPanelAdvLayout.createSequentialGroup()
                        .addComponent(e)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblForagingDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setPanelAdvLayout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setPanelAdvLayout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAvoidMode))
                                .addComponent(sldAvoidMode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setPanelAdvLayout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAvoidRec))
                                .addComponent(sldAvoidRec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        setPanelAdvLayout.setVerticalGroup(
            setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setPanelAdvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblLead))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldLeadCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPred)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldPredCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblAvoid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAvoidCof, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblAvoidMode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAvoidMode, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lblAvoidRec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAvoidRec, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e)
                    .addComponent(lblForagingDistance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldForDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Symulacja.addTab("Zaawansowane", setPanelAdv);

        jTabbedPane1.addTab("Symulacja", Symulacja);

        btnStart.setText("Rozpocznij symulację");
        btnStart.setEnabled(false);
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAnimSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFPS, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 615, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sldAnimSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtFPS))
                            .addComponent(jLabel8))))
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
    public int getTimeFood()
    {
        return (int)this.sldTimeFood.getValue();
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
    public  int getNumNeight(){
     return this.sldNumNeight.getValue();
    }
    //----------------------------------------
    public int getHuntStrategy()
    {
        return combpredMove.getSelectedIndex();
    }
    public int getBoidSize()
    {
        return (int )this.spnBoidRadius.getValue();
    }
    public int getLeaderSize()
    {
        return (int )this.spnLeaderRadius.getValue();
    }
    public int getPredatorSize()
    {
        return (int )this.spnPredatorRadius.getValue();
    }
    public int getObstacleSize()
    {
        return (int )this.spnObstacleRadius.getValue();
    }
    public int getMinmalSeparate()
    {
        return (int )this.spnMinDist.getValue();
    }
    public int getForagingDistance()
    {
        return (int)sldForDist.getValue();
    }
    public int getEscapeStrategy()
    {
        return combpredEscape.getSelectedIndex();
    }
    //-----------------------------------------1
    public  int getLeaderTypeMovement(){
     return (int)this.combLeadMove.getSelectedIndex();
    }
    public void setNumOfThings(int b,int l, int p){
    this.lblNumBoids.setText(Integer.toString(b));
    this.lblNumLeaders.setText(Integer.toString(l));
    this.lblNumPred.setText(Integer.toString(p));
    }
    public void setAvgNumNeight(double ann){
    this.lblAvgNumNeight.setText(String.format("%.2f", ann));
    }
    private void setAllLbl(){
         lblAli.setText(Double.toString(sldAliCof.getValue()/(double)1000));
         lblSep.setText(Double.toString(sldSepCof.getValue()/(double)1000));
         lblAvoid.setText(Double.toString(sldAvoidCof.getValue()/(double)1000));
         lblAvoidMode.setText(Double.toString(sldAvoidMode.getValue()/(double)1000));
         lblAvoidRec.setText(Integer.toString(sldAvoidRec.getValue()));
         lblCoh.setText(Double.toString(sldCohCof.getValue()/(double)1000));
         lblLead.setText(Double.toString(sldLeadCof.getValue()/(double)1000));
         lblRand.setText(Double.toString(sldRandCof.getValue()/(double)1000));
         lblAngle.setText(Double.toString((int)((sldAngle.getValue()/(double)1000)*360/3.15)));
         lblNeigh.setText(Double.toString(sldNeigh.getValue()/(double)10));
         lblMaxAccel.setText(Double.toString(sldMaxAccel.getValue()/(double)10));
         lblMaxSpeed.setText(Double.toString(sldMaxSpeed.getValue()/(double)100));
         lblMaxNeight.setText(Double.toString(sldNumNeight.getValue()));
         lblTimeReaction.setText(Double.toString(sldReactionTime.getValue())+"ms");
    }
    private void sldAnimSpeedStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldAnimSpeedStateChanged
       if ( mainBoids.simul!=null){
        mainBoids.simul.changeAnimSpeed(this.sldAnimSpeed.getValue());
       }
    }//GEN-LAST:event_sldAnimSpeedStateChanged

    private void btnGenStadoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnGenStadoActionPerformed
       fabric= new boidsFabric();
       fabric.setBoidsParametrs(sldMaxSpeed.getValue()/100d,sldMaxAccel.getValue()/10d);
       mainBoids.boids=fabric.createBoids(Integer.parseInt(this.txtNumSwarm.getText()),(int)this.textNumPred.getValue(),(double)this.sldPerHunger.getValue()/100);
    
       obsfabric = new obstaclesFabric();
       mainBoids.obs = obsfabric.createObs((int)textNumObs.getValue(),this.getObstacleSize());// dorobić pole na ilośc przeszkód i wartość tutaj
       ffabric=new foodFabric();
       mainBoids.food=ffabric.createFood((int)textNumFood.getValue());
       mainBoids.stat=new statistic(Integer.parseInt(this.txtNumSwarm.getText()),(int)this.textNumPred.getValue(),(int)this.textLeaderNum.getValue());
       if (ptr!=null){this.remove(ptr);}
       //ptr=new panel(mainBoids.boids,mainBoids.prey);
       ptr=new panel(mainBoids.boids,mainBoids.obs,mainBoids.food);
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
       this.btnStart.setEnabled(true);
    }//GEN-LAST:event_btnGenStadoActionPerformed

    private void txtNumSwarmPropertyChange(PropertyChangeEvent evt) {//GEN-FIRST:event_txtNumSwarmPropertyChange
        
    }//GEN-LAST:event_txtNumSwarmPropertyChange

    private void sldMaxSpeedStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldMaxSpeedStateChanged
       lblMaxSpeed.setText(Double.toString(sldMaxSpeed.getValue()/(double)100));
    }//GEN-LAST:event_sldMaxSpeedStateChanged

    private void sldMaxAccelStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldMaxAccelStateChanged
       lblMaxAccel.setText(Double.toString(sldMaxAccel.getValue()/(double)10));
    }//GEN-LAST:event_sldMaxAccelStateChanged

    private void sldPredCofStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldPredCofStateChanged
        //------------------------------------------------------------------------
        //Uaktualnianie wartości z suwaczka odnosnie ucieczki
        lblPred.setText(Double.toString(sldPredCof.getValue()/(double)100));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
        //--------------------------------------------------------------------------
        // TODO add your handling code here:
    }//GEN-LAST:event_sldPredCofStateChanged

    private void sldRandCofStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldRandCofStateChanged
        lblRand.setText(Double.toString(sldRandCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setRandCof(sldRandCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldRandCofStateChanged

    private void sldAngleStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldAngleStateChanged
        lblAngle.setText(Double.toString((int)((sldAngle.getValue()/(double)1000)*360/3.15)));
        if (mainBoids.simul!=null){
            mainBoids.simul.setNeightParametrs(sldAngle.getValue()/(double)1000,sldNeigh.getValue()/(double)10);
        }
    }//GEN-LAST:event_sldAngleStateChanged

    private void sldNeighStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldNeighStateChanged
        lblNeigh.setText(Double.toString(sldNeigh.getValue()/(double)10));
        if (mainBoids.simul!=null){
            mainBoids.simul.setNeightParametrs(sldAngle.getValue()/(double)1000,sldNeigh.getValue()/(double)10);
        }
    }//GEN-LAST:event_sldNeighStateChanged

    private void sldLeadCofStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldLeadCofStateChanged
        lblLead.setText(Double.toString(sldLeadCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);

        }
    }//GEN-LAST:event_sldLeadCofStateChanged

    private void sldCohCofStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldCohCofStateChanged
        lblCoh.setText(Double.toString(sldCohCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldCohCofStateChanged

    private void sldSepCofStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldSepCofStateChanged
        lblSep.setText(Double.toString(sldSepCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldSepCofStateChanged

    private void sldAliCofStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldAliCofStateChanged
        lblAli.setText(Double.toString(sldAliCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldAliCofStateChanged

    private void btnStartActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if(mainBoids.simul==null || mainBoids.simul.continueSimulation==false){

            this.btnStart.setText("Zatrzymaj symulację");
            //mainBoids.simul= new symulacja(mainBoids.boids,mainBoids.prey);
            mainBoids.simul= new symulacja(mainBoids.boids,mainBoids.obs,mainBoids.food);
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
            mainBoids.simul.setNeightParametrs(sldAngle.getValue()/(double)1000,sldNeigh.getValue()/(double)10);
            mainBoids.simul.setAnimSpeed(sldAnimSpeed.getValue());
            mainBoids.simul.setRandCof(sldRandCof.getValue()/(double)1000);
            mainBoids.simul.setAvoidRec(sldAvoidRec.getValue());

            Runnable runner = new threadSym(mainBoids.simul);
            Thread thread = new Thread(runner);
            thread.start();
        }else{
            this.btnStart.setText("Rozpocznij symulację");
            mainBoids.simul.continueSimulation=false;
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnGlobAimActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnGlobAimActionPerformed
      ptr.aimX=-1;
      ptr.aimY=-1;
      mainBoids.simul.globalAim=new vector2d(-1,-1);
      
    }//GEN-LAST:event_btnGlobAimActionPerformed

    private void sldAvoidCofStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldAvoidCofStateChanged
        lblAvoid.setText(Double.toString(sldAvoidCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldAvoidCofStateChanged

    private void formKeyTyped(KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void combpredMoveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_combpredMoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combpredMoveActionPerformed

    private void combLeadMoveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_combLeadMoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combLeadMoveActionPerformed

    private void combpredEscapeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_combpredEscapeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combpredEscapeActionPerformed

    private void sldAvoidModeStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldAvoidModeStateChanged
        lblAvoidMode.setText(Double.toString(sldAvoidMode.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000);
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldAvoidModeStateChanged

    private void sldAvoidRecStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldAvoidRecStateChanged
        lblAvoidRec.setText(Integer.toString(sldAvoidRec.getValue()));
        if (mainBoids.simul!=null){
            //mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
            mainBoids.simul.setAvoidRec(sldAvoidRec.getValue());
        }
    }//GEN-LAST:event_sldAvoidRecStateChanged

    private void sldForDistStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldForDistStateChanged
        lblForagingDistance.setText(Integer.toString(sldForDist.getValue()));
        // TODO add your handling code here:
    }//GEN-LAST:event_sldForDistStateChanged

    private void sldNumNeightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldNumNeightStateChanged
            this.lblMaxNeight.setText(Integer.toString(sldNumNeight.getValue()));
    }//GEN-LAST:event_sldNumNeightStateChanged

    private void sldPerHungerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldPerHungerStateChanged
            this.lblHunger.setText(Integer.toString(sldPerHunger.getValue())+"%");
        // TODO add your handling code here:
    }//GEN-LAST:event_sldPerHungerStateChanged

    private void sldTimeFoodStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldTimeFoodStateChanged
         this.lblTimeFood.setText(Integer.toString(sldTimeFood.getValue()));
        // TODO add your handling code here:
    }//GEN-LAST:event_sldTimeFoodStateChanged

    private void sldReactionTimeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldReactionTimeStateChanged
       mainBoids.simul.setReationTime(sldReactionTime.getValue());
        if (sldReactionTime.getValue()!=0){
        this.lblTimeReaction.setText(Integer.toString(sldReactionTime.getValue())+"ms");
       }else{this.lblTimeReaction.setText("MAX");}
    }//GEN-LAST:event_sldReactionTimeStateChanged

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
    private javax.swing.JTabbedPane Symulacja;
    private javax.swing.JToggleButton btnAccelWart;
    private javax.swing.JButton btnGenStado;
    private javax.swing.JButton btnGlobAim;
    private javax.swing.JButton btnStart;
    private javax.swing.JToggleButton btnSterMysza;
    private javax.swing.JToggleButton btnVelWart;
    private javax.swing.JToggleButton btnWpływLeader;
    private javax.swing.JComboBox cobRozklad;
    private javax.swing.JComboBox combLeadMove;
    private javax.swing.JComboBox combpredEscape;
    private javax.swing.JComboBox combpredMove;
    private javax.swing.JLabel e;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAli;
    private javax.swing.JLabel lblAngle;
    private javax.swing.JLabel lblAvgNumNeight;
    private javax.swing.JLabel lblAvoid;
    private javax.swing.JLabel lblAvoidMode;
    private javax.swing.JLabel lblAvoidRec;
    private javax.swing.JLabel lblCoh;
    private javax.swing.JLabel lblForagingDistance;
    private javax.swing.JLabel lblHunger;
    private javax.swing.JLabel lblLead;
    private javax.swing.JLabel lblMaxAccel;
    private javax.swing.JLabel lblMaxNeight;
    private javax.swing.JLabel lblMaxSpeed;
    private javax.swing.JLabel lblNeigh;
    private javax.swing.JLabel lblNumBoids;
    private javax.swing.JLabel lblNumLeaders;
    private javax.swing.JLabel lblNumPred;
    private javax.swing.JLabel lblPred;
    private javax.swing.JLabel lblRand;
    private javax.swing.JLabel lblSep;
    private javax.swing.JLabel lblTimeFood;
    private javax.swing.JLabel lblTimeReaction;
    private javax.swing.JPanel setPanelAdv;
    private javax.swing.JPanel setPanelPod;
    private javax.swing.JSlider sldAliCof;
    private javax.swing.JSlider sldAngle;
    private javax.swing.JSlider sldAnimSpeed;
    private javax.swing.JSlider sldAvoidCof;
    private javax.swing.JSlider sldAvoidMode;
    private javax.swing.JSlider sldAvoidRec;
    private javax.swing.JSlider sldCohCof;
    private javax.swing.JSlider sldForDist;
    private javax.swing.JSlider sldLeadCof;
    private javax.swing.JSlider sldMaxAccel;
    private javax.swing.JSlider sldMaxSpeed;
    private javax.swing.JSlider sldNeigh;
    private javax.swing.JSlider sldNumNeight;
    private javax.swing.JSlider sldPerHunger;
    private javax.swing.JSlider sldPredCof;
    private javax.swing.JSlider sldRandCof;
    private javax.swing.JSlider sldReactionTime;
    private javax.swing.JSlider sldSepCof;
    private javax.swing.JSlider sldTimeFood;
    private javax.swing.JSpinner spnBoidRadius;
    private javax.swing.JSpinner spnLeaderRadius;
    private javax.swing.JSpinner spnMinDist;
    private javax.swing.JSpinner spnObstacleRadius;
    private javax.swing.JSpinner spnPredatorRadius;
    private javax.swing.JPanel statPanel;
    private javax.swing.JPanel sterLead;
    private javax.swing.JSpinner textLeaderNum;
    private javax.swing.JSpinner textNumFood;
    private javax.swing.JSpinner textNumObs;
    private javax.swing.JSpinner textNumPred;
    private javax.swing.JLabel txtFPS;
    private javax.swing.JFormattedTextField txtNumSwarm;
    private javax.swing.JPanel wygladPanel;
    // End of variables declaration//GEN-END:variables
}
