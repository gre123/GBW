package gui;

import boids.boidsFabric;
import boids.foodFabric;
import boids.mainBoids;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JFileChooser;
import javax.swing.event.ChangeEvent;
import math.Boidcounter;
import math.vector2d;
import simulation.statistic;
import simulation.symulacja;
import simulation.threadSym;
import boids.Obstacle;
import boids.obstaclesFabric;

/**
 *@author Bylina, Gajda, Wszołek
 */
public class mainWindow extends javax.swing.JFrame {
public panel ptr=null;
public boidsFabric fabric=null;
public obstaclesFabric obsfabric = null;
public foodFabric ffabric = null;
public int probki=0;
//---------------------
private final MouseListener mlcount =new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {panelMouseClickedCount(evt);}
};
//----------------------------
private final MouseListener mlster;
private final MouseListener mlld=new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {panelMouseClickedLD(evt);}
};
private final MouseListener mlobs=new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {panelMouseClickedOBS(evt);}
};

public savingStats sS;
public String fSource;
public boolean savingStats;

    public mainWindow() {
        savingStats=false;
        this.mlster = new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {panelMouseClicked(evt);}
        };
    
        initComponents(); 
        this.setIconImage(this.getToolkit().getImage("src\\trunk\\src\\fish_big.png"));
        setAllLbl();
    }

    /**

     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statsChooser = new javax.swing.JFileChooser();
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
        jLabel25 = new javax.swing.JLabel();
        textNumFood = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        sldPerHunger = new javax.swing.JSlider();
        lblHunger = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        sldTimeFood = new javax.swing.JSlider();
        lblTimeFood = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        sldMass = new javax.swing.JSlider();
        jLabel45 = new javax.swing.JLabel();
        lblMass = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        sldSkala = new javax.swing.JSlider();
        lblSkala = new javax.swing.JLabel();
        sldMinDistSep = new javax.swing.JSlider();
        lblMinDistSep = new javax.swing.JLabel();
        statPanel = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lblNumBoids = new javax.swing.JLabel();
        lblNumPred = new javax.swing.JLabel();
        lblNumLeaders = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lblAvgNumNeight = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lblHaveLeaderPer = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lblAvgSpeed = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        lblOdstAvgSpeed = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        lblNumCols = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lblAvgDist = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        lblBoidsColide = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        lblPerformance = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        lblMinPerf = new javax.swing.JLabel();
        lblMaxPerf = new javax.swing.JLabel();
        rectSize = new javax.swing.JSlider();
        recSizeLbl = new javax.swing.JLabel();
        boidCount = new javax.swing.JToggleButton();
        rectSize1 = new javax.swing.JSlider();
        recSizeLbl1 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        boidCntLbl = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        saveStatsBtn = new javax.swing.JToggleButton();
        jLabel53 = new javax.swing.JLabel();
        lblOdstAvgSpeedLokal = new javax.swing.JLabel();
        radConstTime = new javax.swing.JRadioButton();
        jLabel54 = new javax.swing.JLabel();
        lblProbki = new javax.swing.JLabel();
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
        btnLoadSettings = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        cmbThreads = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        spnBucketX = new javax.swing.JSpinner();
        spnBucketY = new javax.swing.JSpinner();
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
        jLabel47 = new javax.swing.JLabel();
        sldFreqEat = new javax.swing.JSlider();
        lblFreqEat = new javax.swing.JLabel();
        sldRatio = new javax.swing.JSlider();
        lblRatio = new javax.swing.JLabel();
        ratRatio = new javax.swing.JRadioButton();
        wygladPanel = new javax.swing.JPanel();
        btnWpływLeader = new javax.swing.JToggleButton();
        btnVelWart = new javax.swing.JToggleButton();
        btnPred = new javax.swing.JToggleButton();
        jLabel29 = new javax.swing.JLabel();
        spnBoidRadius = new javax.swing.JSpinner();
        jLabel30 = new javax.swing.JLabel();
        spnLeaderRadius = new javax.swing.JSpinner();
        spnPredatorRadius = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        spnObstacleRadius = new javax.swing.JSpinner();
        jLabel33 = new javax.swing.JLabel();
        btnSeparacWygl = new javax.swing.JToggleButton();
        btnPolaryzation = new javax.swing.JToggleButton();
        btnPolaryzationLokal = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spnHeight = new javax.swing.JSpinner();
        spnWidth = new javax.swing.JSpinner();
        btnSrodkuj = new javax.swing.JToggleButton();
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
        btnSterMysza1 = new javax.swing.JToggleButton();
        btnSterMysza3 = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel55 = new javax.swing.JLabel();
        chStrategyCof = new javax.swing.JSlider();
        chStrLabel = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Symulacja stada - Bylina,Gajda,Wszołek 2013");
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1140, 640));
        setName("mainWin"); // NOI18N
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(199, 512));

        jLabel16.setText("Ilość drapieżników:");

        btnGenStado.setText("Generuj stado");
        btnGenStado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenStadoActionPerformed(evt);
            }
        });

        jLabel7.setText("Liczebność:");

        sldMaxSpeed.setMaximum(3000);
        sldMaxSpeed.setMinimum(1);
        sldMaxSpeed.setToolTipText("");
        sldMaxSpeed.setValue(1800);
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

        sldMaxAccel.setMaximum(3000);
        sldMaxAccel.setSnapToTicks(true);
        sldMaxAccel.setToolTipText("");
        sldMaxAccel.setValue(3000);
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

        sldMass.setMaximum(50);
        sldMass.setMinimum(1);
        sldMass.setToolTipText("");
        sldMass.setValue(4);
        sldMass.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldMassStateChanged(evt);
            }
        });

        jLabel45.setText("Masa osobnika:");

        lblMass.setText("0");

        jLabel46.setText("Skala:");

        sldSkala.setMaximum(40);
        sldSkala.setMinimum(1);
        sldSkala.setToolTipText("");
        sldSkala.setValue(20);
        sldSkala.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldSkalaStateChanged(evt);
            }
        });

        lblSkala.setText("0");

        sldMinDistSep.setMaximum(10);
        sldMinDistSep.setToolTipText("2");
        sldMinDistSep.setValue(2);
        sldMinDistSep.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldMinDistSepStateChanged(evt);
            }
        });

        lblMinDistSep.setText("0");

        javax.swing.GroupLayout editFlockLayout = new javax.swing.GroupLayout(editFlock);
        editFlock.setLayout(editFlockLayout);
        editFlockLayout.setHorizontalGroup(
            editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editFlockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldMinDistSep, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldSkala, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldMass, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTimeFood))
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMinDistSep))
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cobRozklad, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMass))
                    .addGroup(editFlockLayout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSkala)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(textNumPred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNumFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(textNumObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cobRozklad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblMaxSpeed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldMaxSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblMaxAccel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldMaxAccel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblHunger))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldPerHunger, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(lblTimeFood))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldTimeFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lblMinDistSep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldMinDistSep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(lblMass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldMass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editFlockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(lblSkala))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldSkala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel39.setText("Procent widzących lidera(%):");

        lblHaveLeaderPer.setText("0");

        jLabel40.setText("Śr. wektor prędkości:");

        lblAvgSpeed.setText("0");

        jLabel42.setText("Odstępstwo od średniej(%):");

        lblOdstAvgSpeed.setText("0");

        jLabel43.setText("Ilość nowych kolizji:");

        lblNumCols.setText("0");

        jLabel41.setText("Śr. odl. osobników:");

        lblAvgDist.setText("0");

        jLabel48.setText("Ilość kolizji boidów:");

        lblBoidsColide.setText("0");

        jLabel50.setText("Średnia wydajność:");

        lblPerformance.setText("0");

        jLabel49.setText("Max wydajność:");

        jLabel51.setText("Min wydajność:");

        lblMinPerf.setText("0");

        lblMaxPerf.setText("0");

        rectSize.setValue(0);
        rectSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rectSizeStateChanged(evt);
            }
        });

        recSizeLbl.setText("0");

        boidCount.setText("Policz boidy");
        boidCount.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boidCountItemStateChanged(evt);
            }
        });
        boidCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boidCountActionPerformed(evt);
            }
        });

        rectSize1.setValue(0);
        rectSize1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rectSize1StateChanged(evt);
            }
        });

        recSizeLbl1.setText("0");

        jLabel52.setText("Boidy w ramce :");

        boidCntLbl.setText("0");

        saveStatsBtn.setText("Zapisz do pliku");
        saveStatsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveStatsBtnActionPerformed(evt);
            }
        });

        jLabel53.setText("Odst. od średniej lokalnie(%):");

        lblOdstAvgSpeedLokal.setText("0");

        radConstTime.setText("stały czas");

        jLabel54.setText("Zapisane próbki:");

        lblProbki.setText("0");

        javax.swing.GroupLayout statPanelLayout = new javax.swing.GroupLayout(statPanel);
        statPanel.setLayout(statPanelLayout);
        statPanelLayout.setHorizontalGroup(
            statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statPanelLayout.createSequentialGroup()
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, statPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(statPanelLayout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBoidsColide))
                            .addGroup(statPanelLayout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAvgDist))
                            .addGroup(statPanelLayout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblNumCols))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statPanelLayout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblOdstAvgSpeed))
                            .addGroup(statPanelLayout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAvgSpeed))
                            .addGroup(statPanelLayout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblHaveLeaderPer))
                            .addGroup(statPanelLayout.createSequentialGroup()
                                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel37))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNumBoids)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblNumLeaders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNumPred))
                                    .addComponent(lblAvgNumNeight)))
                            .addGroup(statPanelLayout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblOdstAvgSpeedLokal))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, statPanelLayout.createSequentialGroup()
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMaxPerf))
                    .addGroup(statPanelLayout.createSequentialGroup()
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMinPerf))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, statPanelLayout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPerformance)))
                .addGap(2, 2, 2))
            .addGroup(statPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statPanelLayout.createSequentialGroup()
                        .addComponent(rectSize, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recSizeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(statPanelLayout.createSequentialGroup()
                        .addComponent(rectSize1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recSizeLbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(statPanelLayout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblProbki))
                    .addComponent(saveStatsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(statPanelLayout.createSequentialGroup()
                        .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(statPanelLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addGap(18, 18, 18)
                                .addComponent(boidCntLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boidCount, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radConstTime))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(lblHaveLeaderPer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(lblAvgSpeed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(lblOdstAvgSpeed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(lblOdstAvgSpeedLokal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(lblNumCols))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(lblAvgDist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(lblBoidsColide))
                .addGap(31, 31, 31)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(boidCount)
                .addGap(18, 18, 18)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rectSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recSizeLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rectSize1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recSizeLbl1))
                .addGap(18, 18, 18)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(boidCntLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(lblMinPerf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(lblMaxPerf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(lblPerformance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(radConstTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveStatsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(lblProbki)))
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
        sldAliCof.setValue(455);
        sldAliCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAliCofStateChanged(evt);
            }
        });

        sldSepCof.setMaximum(3000);
        sldSepCof.setToolTipText("");
        sldSepCof.setValue(790);
        sldSepCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldSepCofStateChanged(evt);
            }
        });

        sldCohCof.setMaximum(3000);
        sldCohCof.setToolTipText("");
        sldCohCof.setValue(218);
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
        sldAngle.setToolTipText("");
        sldAngle.setValue(2363);
        sldAngle.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldAngleStateChanged(evt);
            }
        });

        sldRandCof.setMaximum(1000);
        sldRandCof.setToolTipText("");
        sldRandCof.setValue(100);
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

        btnLoadSettings.setText("Wczytaj nastawy");
        btnLoadSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadSettingsActionPerformed(evt);
            }
        });

        jLabel56.setText("Liczba wątków:");

        cmbThreads.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel57.setText("Koszyki w poziomie:");

        jLabel58.setText("Koszyki w pionie:");

        spnBucketX.setValue(21);

        spnBucketY.setValue(12);

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
                    .addComponent(sldNumNeight, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(sldReactionTime, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(lblTimeReaction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnLoadSettings, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setPanelPodLayout.createSequentialGroup()
                                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel57))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spnBucketX)
                                    .addComponent(spnBucketY)
                                    .addComponent(cmbThreads, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        setPanelPodLayout.setVerticalGroup(
            setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setPanelPodLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblAli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAliCof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblSep))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldSepCof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCoh)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldCohCof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lblRand))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldRandCof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblNeigh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldNeigh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblAngle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAngle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblMaxNeight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldNumNeight, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(lblTimeReaction))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldReactionTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(spnBucketX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(spnBucketY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(setPanelPodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(cmbThreads, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoadSettings)
                .addContainerGap())
        );

        Symulacja.addTab("Podstawowe", setPanelPod);
        setPanelPod.getAccessibleContext().setAccessibleName("");

        jLabel5.setText("Follow leader:");
        jLabel5.setToolTipText("Podążenie za liderem");

        lblLead.setText("0");

        sldLeadCof.setMaximum(3000);
        sldLeadCof.setValue(0);
        sldLeadCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldLeadCofStateChanged(evt);
            }
        });

        jLabel15.setText("Escape predator:");

        lblPred.setText("0");
        lblPred.setText(Double.toString(sldPredCof.getValue()/(double)100));

        sldPredCof.setMaximum(3000);
        sldPredCof.setToolTipText("");
        sldPredCof.setValue(1000);
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

        jLabel47.setText("Częstość zjadania:");

        sldFreqEat.setToolTipText("");
        sldFreqEat.setValue(10);
        sldFreqEat.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldFreqEatStateChanged(evt);
            }
        });

        lblFreqEat.setText("0");
        lblPred.setText(Double.toString(sldPredCof.getValue()/(double)100));

        sldRatio.setValue(35);
        sldRatio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldRatioStateChanged(evt);
            }
        });

        lblRatio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRatio.setText("0");

        ratRatio.setSelected(true);
        ratRatio.setText("Ocena sąsiedztwa:");
        ratRatio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ratRatioStateChanged(evt);
            }
        });

        javax.swing.GroupLayout setPanelAdvLayout = new javax.swing.GroupLayout(setPanelAdv);
        setPanelAdv.setLayout(setPanelAdvLayout);
        setPanelAdvLayout.setHorizontalGroup(
            setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setPanelAdvLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldRatio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                    .addGroup(setPanelAdvLayout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFreqEat))
                    .addComponent(sldFreqEat, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setPanelAdvLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                                .addComponent(sldAvoidRec, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, setPanelAdvLayout.createSequentialGroup()
                        .addComponent(ratRatio)
                        .addGap(18, 18, 18)
                        .addComponent(lblRatio, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
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
                .addComponent(sldLeadCof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPred)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldPredCof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFreqEat)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldFreqEat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lblAvoid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAvoidCof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblAvoidMode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAvoidMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lblAvoidRec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldAvoidRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e)
                    .addComponent(lblForagingDistance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldForDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(setPanelAdvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRatio)
                    .addComponent(ratRatio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldRatio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        Symulacja.addTab("Zaawansowane", setPanelAdv);

        jTabbedPane1.addTab("Symulacja", Symulacja);

        btnWpływLeader.setText("wpływ lidera");

        btnVelWart.setText("wartość prędkości");

        btnPred.setText("Przeciwnik");

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

        btnSeparacWygl.setText("Separacja");

        btnPolaryzation.setText("Polaryzacja predkości");

        btnPolaryzationLokal.setText("Polaryzacja predkości lokalnie");

        jLabel8.setText("Szerokość panelu:");

        jLabel9.setText("Wysokość panelu:");

        spnHeight.setValue(710);

        spnWidth.setValue(1130);

        btnSrodkuj.setText("Środkuj widok");

        javax.swing.GroupLayout wygladPanelLayout = new javax.swing.GroupLayout(wygladPanel);
        wygladPanel.setLayout(wygladPanelLayout);
        wygladPanelLayout.setHorizontalGroup(
            wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wygladPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wygladPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, wygladPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spnWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPred, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
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
                        .addComponent(spnObstacleRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSeparacWygl, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(btnPolaryzation, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(btnPolaryzationLokal, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(btnSrodkuj, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
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
                .addComponent(btnPred)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeparacWygl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPolaryzation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPolaryzationLokal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSrodkuj)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addGroup(wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(wygladPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(spnHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Wygląd", wygladPanel);

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

        btnSterMysza.setText("Steruj myszą\n");
        btnSterMysza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnSterMyszaItemStateChanged(evt);
            }
        });

        jLabel21.setText("Drapieżnik:");

        combpredMove.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "gonic_koszyki", "gonic_najblizszego", "gonic_grupe", "mix_grupa_najblizszy" }));
        combpredMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combpredMoveActionPerformed(evt);
            }
        });

        jLabel22.setText("Zwykłe - ucieczka :");

        combpredEscape.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "stada_bez kryt", "stada+sam_niezależ" }));
        combpredEscape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combpredEscapeActionPerformed(evt);
            }
        });

        btnSterMysza1.setText("Przeszkoda");
        btnSterMysza1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnSterMysza1ItemStateChanged(evt);
            }
        });
        btnSterMysza1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSterMysza1ActionPerformed(evt);
            }
        });

        btnSterMysza3.setText("Lider/Drapieżnik");
        btnSterMysza3.setToolTipText("Lewym i prawym klawiszem myszy");
        btnSterMysza3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnSterMysza3ItemStateChanged(evt);
            }
        });
        btnSterMysza3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSterMysza3ActionPerformed(evt);
            }
        });

        jLabel44.setText("Dodawanie elementów:");

        jLabel55.setText("Zmiana strategii w odl :");

        chStrategyCof.setMaximum(40);
        chStrategyCof.setToolTipText("");
        chStrategyCof.setValue(6);
        chStrategyCof.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chStrategyCofStateChanged(evt);
            }
        });

        chStrLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        chStrLabel.setText("6");

        javax.swing.GroupLayout sterLeadLayout = new javax.swing.GroupLayout(sterLead);
        sterLead.setLayout(sterLeadLayout);
        sterLeadLayout.setHorizontalGroup(
            sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2)
            .addGroup(sterLeadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combpredEscape, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sterLeadLayout.createSequentialGroup()
                        .addGroup(sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chStrategyCof, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(combLeadMove, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sterLeadLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGlobAim))
                            .addComponent(btnSterMysza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSterMysza1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combpredMove, 0, 170, Short.MAX_VALUE)
                            .addComponent(btnSterMysza3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(sterLeadLayout.createSequentialGroup()
                                .addGroup(sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel22))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(sterLeadLayout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chStrLabel)))
                        .addContainerGap())))
        );
        sterLeadLayout.setVerticalGroup(
            sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sterLeadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combLeadMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGlobAim)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSterMysza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combpredMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(sterLeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chStrLabel)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chStrategyCof, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combpredEscape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSterMysza1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSterMysza3)
                .addContainerGap(299, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sterowanie", sterLead);

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
                .addContainerGap(1137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Symulacja");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void setFPS(int fps){
        double dFPS=(double)fps/100d;
//        txtFPS.setText(Double.toString(dFPS));
    }
    public boolean areWeSaving()
    {
        return saveStatsBtn.isSelected()&&savingStats && fSource!=null;
    }
    
    public int getBucketX()
    {
        return (int)spnBucketX.getValue();
    }
    public int getBucketY()
    {
        return (int)spnBucketY.getValue();
    }
    public int ileWatkow()
    {
        return cmbThreads.getSelectedIndex()+1;
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
    public  boolean czyConstCzas(){
     if (this.radConstTime.isSelected()){return true;}
     return false;
    }
    
    public  boolean czyWplywLeader(){
     if (this.btnWpływLeader.isSelected()){return true;}
     return false;
    }
    
    public  boolean czySeparacja(){
     if (this.btnSeparacWygl.isSelected()){return true;}
     return false;
    }
    public  boolean czyVelWart(){
     if (this.btnVelWart.isSelected()){return true;}
     return false;
    }
    public  boolean czyPred(){
     if (this.btnPred.isSelected()){return true;}
     return false;
    }
    public  boolean czyPolarizationWyglad(){
     if (this.btnPolaryzation.isSelected()){return true;}
     return false;
    }
    public  boolean czyPolarizationLokalWyglad(){
     if (this.btnPolaryzationLokal.isSelected()){return true;}
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
    public int getChangeStrategy()
    {
        return chStrategyCof.getValue();
    }
    public int getBoidSize()
    {
        return (int )this.spnBoidRadius.getValue();
    }
    public int getLeaderSize()
    {
        return (int )this.spnLeaderRadius.getValue();
    }
     public boolean czySrodkuj()
    {
        return btnSrodkuj.isSelected();
    }
    public int getRectSizeX()
    {
        return rectSize.getValue();
    }
    public int getRectSizeY()
    {
        return rectSize1.getValue();
    }
    public int getEscapePred()
    {
        return sldPredCof.getValue();
    }
    public int getPredatorSize()
    {
        return (int )this.spnPredatorRadius.getValue();
    }
    public int getObstacleSize()
    {
        return (int )this.spnObstacleRadius.getValue();
    }
    public double getMinmalSeparate()
    {
        return this.sldMinDistSep.getValue()/10d;
    }
    public double getRatio()
    {
        return this.sldRatio.getValue()/(double)100;
    }
    public boolean czyDynamicRatio()
    {
        return ratRatio.isSelected();
    }
   /** public String getFSource()
    {
        return FSource;
    }**/
    public int getForagingDistance()
    {
        return (int)sldForDist.getValue();
    }
    public int getEscapeStrategy()
    {
        return combpredEscape.getSelectedIndex();
    }
    public int getFreqEat(){
    return  sldFreqEat.getValue();
    }
    public void incAndSetProbki(){
    lblProbki.setText(Integer.toString(++probki));
    }
    public void setHeveLeader(double per){
        this.lblHaveLeaderPer.setText(Double.toString(per));
    }
    //-----------------------------------------
    public  int getLeaderTypeMovement(){
     return (int)this.combLeadMove.getSelectedIndex();
    }
    public void loadSettings()
    {
        sldAliCof.setValue((int)(0.455*1000)); /** Alignment**/
        sldSepCof.setValue((int)(0.79*1000));  /** Separate**/
        sldCohCof.setValue((int)(0.218*1000)); /** Cohesion**/
//        sldRandCof.setValue();
//        sldNeigh.setValue();
//        sldAngle.setValue();
//        sldNumNeight.setValue();
//        sldReactionTime.setValue();
//        sldLeadCof.setValue();
//        sldPredCof.setValue();
//        sldFreqEat.setValue();
//        sldAvoidCof.setValue();
//        sldAvoidMode.setValue();
//        sldAvoidRec.setValue();
//        sldForDist.setValue();
                                                        
    }
    public void setNumOfThings(int b,int l, int p){
    this.lblNumBoids.setText(Integer.toString(b));
    this.lblNumLeaders.setText(Integer.toString(l));
    this.lblNumPred.setText(Integer.toString(p));
    }
    public void setAvgNumNeight(double ann){
    this.lblAvgNumNeight.setText(String.format("%.2f", ann));
    }
    public void setNumCollisions(int param){
    this.lblBoidsColide.setText(Integer.toString(param));
    }
    public void setPerformace(double param){
    this.lblPerformance.setText(String.format("%.2f", param));
    }
    public void setAvgSpeed(double avgsX,double avgsY){     
    this.lblAvgSpeed.setText("("+String.format("%.1f", avgsX)+";"+String.format("%.1f", avgsY)+")");
    }
    public void setAvgSpeedOdst(double avgODS){     
    this.lblOdstAvgSpeed.setText(String.format("%.1f", avgODS));
    }
    public void setAvgSpeedOdstLokal(double avgODS){     
    this.lblOdstAvgSpeedLokal.setText(String.format("%.1f", avgODS));
    }
    public void setAvgDist(double avgDist){     
    this.lblAvgDist.setText(String.format("%.1f", avgDist));
    }
    public void setNumOfColision(int _cols){     
        this.lblNumCols.setText(Integer.toString(_cols));
    }
    public void setMinPerf(double _minPerf){     
        this.lblMinPerf.setText(String.format("%.1f",_minPerf));
    }
    public void setMaxPerf(double _maxPerf){     
        this.lblMaxPerf.setText(String.format("%.1f",_maxPerf));
        
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
         lblMaxAccel.setText(Double.toString(sldMaxAccel.getValue()/(double)10)+" m/s^2");
         lblMaxSpeed.setText(Double.toString(sldMaxSpeed.getValue()/(double)100)+" m/s");
         lblMaxNeight.setText(Double.toString(sldNumNeight.getValue()));
         lblTimeReaction.setText(Double.toString(sldReactionTime.getValue())+"ms");
         lblMass.setText(Double.toString(sldMass.getValue()/50d)+"kg");
         lblSkala.setText("1 metr-"+Double.toString(sldSkala.getValue()/2d)+"px");
         lblMinDistSep.setText(Double.toString(sldMinDistSep.getValue()/10d));
         lblFreqEat.setText(Integer.toString(sldFreqEat.getValue())+"%");
         lblRatio.setText(Double.toString(sldRatio.getValue()/(double)100));
        
    }
    private void btnGenStadoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnGenStadoActionPerformed
       mainBoids.panelSizeX=(int)spnWidth.getValue();
       mainBoids.panelSizeY=(int)spnHeight.getValue();
       
        fabric= new boidsFabric();
       fabric.setBoidsParametrs(sldMaxSpeed.getValue()/100d,sldMaxAccel.getValue()/10d,sldMass.getValue()/50d,sldSkala.getValue()/2d);

       mainBoids.boids=fabric.createBoids(Integer.parseInt(this.txtNumSwarm.getText()),(int)this.textNumPred.getValue(),(double)this.sldPerHunger.getValue()/100);
    
       obsfabric = new obstaclesFabric();
       mainBoids.obs = obsfabric.createObs((int)textNumObs.getValue(),this.getObstacleSize());// dorobić pole na ilośc przeszkód i wartość tutaj
       ffabric=new foodFabric();
       mainBoids.food=ffabric.createFood((int)textNumFood.getValue());
       mainBoids.stat=new statistic(Integer.parseInt(this.txtNumSwarm.getText()),(int)this.textNumPred.getValue(),(int)this.textLeaderNum.getValue());
       if (ptr!=null){this.remove(ptr);}
       //ptr=new panel(mainBoids.boids,mainBoids.prey);
       btnSterMysza.setSelected(false);
       btnSterMysza1.setSelected(false);
       btnSterMysza3.setSelected(false);
       ptr=new panel(mainBoids.boids,mainBoids.obs,mainBoids.food);
       this.add(ptr);  
//        ptr.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                panelMouseClicked(evt);
//            }
//        });
//        ptr.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
//            public void mouseMoved(java.awt.event.MouseEvent evt) {
//                panelMouseMoved(evt);
//            }
//        });

//       ptr.addKeyListener(new java.awt.event.KeyAdapter() {
//            public void keyTyped(java.awt.event.KeyEvent evt) {
//                panelKeyTyped(evt);
//            }
//        });
       ptr.repaint();
       this.btnStart.setText("Rozpocznij symulację");
       if (mainBoids.simul!=null)mainBoids.simul.continueSimulation=false;
       this.btnStart.setEnabled(true);
    }//GEN-LAST:event_btnGenStadoActionPerformed

    private void txtNumSwarmPropertyChange(PropertyChangeEvent evt) {//GEN-FIRST:event_txtNumSwarmPropertyChange
        
    }//GEN-LAST:event_txtNumSwarmPropertyChange

    private void sldMaxSpeedStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldMaxSpeedStateChanged
       lblMaxSpeed.setText(Double.toString(sldMaxSpeed.getValue()/(double)100)+"m/s");
    }//GEN-LAST:event_sldMaxSpeedStateChanged

    private void sldMaxAccelStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldMaxAccelStateChanged
       lblMaxAccel.setText(Double.toString(sldMaxAccel.getValue()/(double)10)+"m/s^2");
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
              mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldLeadCofStateChanged

    private void sldCohCofStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldCohCofStateChanged
        lblCoh.setText(Double.toString(sldCohCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldCohCofStateChanged

    private void sldSepCofStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldSepCofStateChanged
        lblSep.setText(Double.toString(sldSepCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldSepCofStateChanged

    private void sldAliCofStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldAliCofStateChanged
        lblAli.setText(Double.toString(sldAliCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldAliCofStateChanged

    private void btnStartActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if(mainBoids.simul==null || mainBoids.simul.continueSimulation==false){
            this.btnStart.setText("Zatrzymaj symulację");
            mainBoids.simul= new symulacja(mainBoids.boids,mainBoids.obs,mainBoids.food);
             mainBoids.simul.setSkala(sldSkala.getValue()/2d);
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
            mainBoids.simul.setNeightParametrs(sldAngle.getValue()/(double)1000,sldNeigh.getValue()/(double)10);
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

    private void sldAvoidCofStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldAvoidCofStateChanged
        lblAvoid.setText(Double.toString(sldAvoidCof.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldAvoidCofStateChanged

    private void formKeyTyped(KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    private void sldAvoidModeStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldAvoidModeStateChanged
        lblAvoidMode.setText(Double.toString(sldAvoidMode.getValue()/(double)1000));
        if (mainBoids.simul!=null){
            mainBoids.simul.setParametrs(sldAliCof.getValue()/(double)1000,sldSepCof.getValue()/(double)1000, sldCohCof.getValue()/(double)1000, sldLeadCof.getValue()/(double)1000,sldPredCof.getValue()/(double)1000, sldAvoidCof.getValue()/(double)1000,sldAvoidMode.getValue()/(double)1000);
        }
    }//GEN-LAST:event_sldAvoidModeStateChanged

    private void sldAvoidRecStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldAvoidRecStateChanged
        lblAvoidRec.setText(Integer.toString(sldAvoidRec.getValue()));
        if (mainBoids.simul!=null){
            mainBoids.simul.setAvoidRec(sldAvoidRec.getValue());
        }
    }//GEN-LAST:event_sldAvoidRecStateChanged

    private void sldForDistStateChanged(ChangeEvent evt) {//GEN-FIRST:event_sldForDistStateChanged
        lblForagingDistance.setText(Integer.toString(sldForDist.getValue()));
    }//GEN-LAST:event_sldForDistStateChanged

    private void sldNumNeightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldNumNeightStateChanged
        this.lblMaxNeight.setText(Integer.toString(sldNumNeight.getValue()));
    }//GEN-LAST:event_sldNumNeightStateChanged

    private void sldPerHungerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldPerHungerStateChanged
        this.lblHunger.setText(Integer.toString(sldPerHunger.getValue())+"%");
    }//GEN-LAST:event_sldPerHungerStateChanged

    private void sldTimeFoodStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldTimeFoodStateChanged
         this.lblTimeFood.setText(Integer.toString(sldTimeFood.getValue()));
    }//GEN-LAST:event_sldTimeFoodStateChanged

    private void sldReactionTimeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldReactionTimeStateChanged
       mainBoids.simul.setReationTime(sldReactionTime.getValue());
        if (sldReactionTime.getValue()!=0){
        this.lblTimeReaction.setText(Integer.toString(sldReactionTime.getValue())+"ms");
       }else{this.lblTimeReaction.setText("MAX");}
    }//GEN-LAST:event_sldReactionTimeStateChanged

    private void sldMassStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldMassStateChanged
        this.lblMass.setText(Double.toString(sldMass.getValue()/50d)+"kg");
    }//GEN-LAST:event_sldMassStateChanged

    private void sldSkalaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldSkalaStateChanged
        if ( mainBoids.simul!=null){
         mainBoids.simul.setSkala(sldSkala.getValue()/2d);
        }
        this.lblSkala.setText("1 metr-"+Double.toString(sldSkala.getValue()/2d)+"px");
    }//GEN-LAST:event_sldSkalaStateChanged

    private void sldMinDistSepStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldMinDistSepStateChanged
      this.lblMinDistSep.setText(Double.toString(sldMinDistSep.getValue()/10d));
    }//GEN-LAST:event_sldMinDistSepStateChanged

    private void sldFreqEatStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldFreqEatStateChanged
       this.lblFreqEat.setText(Integer.toString(sldFreqEat.getValue())+"%");
    }//GEN-LAST:event_sldFreqEatStateChanged

    private void rectSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rectSizeStateChanged
        recSizeLbl.setText(Double.toString(rectSize.getValue()));
    }//GEN-LAST:event_rectSizeStateChanged

    private void boidCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boidCountActionPerformed
       if (boidCount.isSelected()) {
                //boidCount.setSelected(false); 
                if (ptr != null)ptr.addMouseListener(mlcount);
            }
            else{
                if (ptr != null)ptr.removeMouseListener(mlcount);
            }
    }//GEN-LAST:event_boidCountActionPerformed

    private void rectSize1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rectSize1StateChanged
         recSizeLbl1.setText(Double.toString(rectSize1.getValue()));
    }//GEN-LAST:event_rectSize1StateChanged

    private void boidCountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boidCountItemStateChanged

    }//GEN-LAST:event_boidCountItemStateChanged

    private void btnLoadSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadSettingsActionPerformed
        loadSettings();
    }//GEN-LAST:event_btnLoadSettingsActionPerformed

    private void saveStatsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveStatsBtnActionPerformed
     if(saveStatsBtn.isSelected()){
    probki=0;        
    //sS=new savingStats();
        //sS.setVisible(true);
       //  statsChooser.setVisible(true);
         if(statsChooser.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
         {
             mainBoids.mainWin.fSource=statsChooser.getSelectedFile().getAbsolutePath();
             mainBoids.mainWin.savingStats=true;
         }   
         else {mainBoids.mainWin.savingStats=false; mainBoids.mainWin.fSource=null;}

     }else{mainBoids.mainWin.fSource=null;}

    }//GEN-LAST:event_saveStatsBtnActionPerformed

    private void btnSterMysza3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSterMysza3ActionPerformed

    }//GEN-LAST:event_btnSterMysza3ActionPerformed

    private void btnSterMysza3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnSterMysza3ItemStateChanged
        if (btnSterMysza3.isSelected()) {
            btnSterMysza1.setSelected(false); //może jeszcze trzeba wywołać linijki ze zmiany stanu
            if (ptr != null)ptr.addMouseListener(mlld);
        }
        else{
            if (ptr != null)ptr.removeMouseListener(mlld);
        }
    }//GEN-LAST:event_btnSterMysza3ItemStateChanged

    private void btnSterMysza1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSterMysza1ActionPerformed

    }//GEN-LAST:event_btnSterMysza1ActionPerformed

    private void btnSterMysza1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnSterMysza1ItemStateChanged
        if (btnSterMysza1.isSelected()) {
            btnSterMysza3.setSelected(false);
            if (ptr != null)ptr.addMouseListener(mlobs);
        }
        else{
            if (ptr != null)ptr.removeMouseListener(mlobs);
        }
    }//GEN-LAST:event_btnSterMysza1ItemStateChanged

    private void combpredEscapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combpredEscapeActionPerformed

    }//GEN-LAST:event_combpredEscapeActionPerformed

    private void combpredMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combpredMoveActionPerformed

    }//GEN-LAST:event_combpredMoveActionPerformed

    private void btnSterMyszaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnSterMyszaItemStateChanged
        if (ptr != null) {
            if (btnSterMysza.isSelected()) {
                ptr.addMouseListener(mlster);
                ptr.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                    public void mouseMoved(java.awt.event.MouseEvent evt) {
                        panelMouseMoved(evt);
                    }
                });

            } else {
                ptr.aimX = -1;    //w tych 3 linijkach się coś dubluje chyba, te funkcje są pomieszane jakieś
                ptr.aimY = -1;
                if (mainBoids.simul!=null)mainBoids.simul.globalAim = new vector2d(-1, -1);
                ptr.removeMouseListener(mlster);
                ptr.removeMouseMotionListener(ptr.getMouseMotionListeners()[0]);
            }
        }
    }//GEN-LAST:event_btnSterMyszaItemStateChanged

    private void btnGlobAimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGlobAimActionPerformed
        ptr.aimX=-1;
        ptr.aimY=-1;
        mainBoids.simul.globalAim=new vector2d(-1,-1);

    }//GEN-LAST:event_btnGlobAimActionPerformed

    private void combLeadMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combLeadMoveActionPerformed

    }//GEN-LAST:event_combLeadMoveActionPerformed

    private void chStrategyCofStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chStrategyCofStateChanged
        chStrLabel.setText(Double.toString(chStrategyCof.getValue()));
    }//GEN-LAST:event_chStrategyCofStateChanged

    private void sldRatioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldRatioStateChanged
        lblRatio.setText(Double.toString(sldRatio.getValue()/(double)100));
    }//GEN-LAST:event_sldRatioStateChanged

    private void ratRatioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ratRatioStateChanged
        if (this.ratRatio.isSelected()){
            sldRatio.setEnabled(true);
        }else{
            sldRatio.setEnabled(false);
        }
    }//GEN-LAST:event_ratRatioStateChanged

    private void panelMouseClickedOBS(java.awt.event.MouseEvent evt) {
      Obstacle przeszkoda=new Obstacle(evt.getX(),evt.getY(),getObstacleSize());
      ptr.obs.add(przeszkoda);
      ptr.repaint();
      if (mainBoids.simul!=null){mainBoids.simul.pom.add(przeszkoda);}
      //else{mainBoids.obs.add(przeszkoda);}
    }
    
    private void panelMouseClickedCount(java.awt.event.MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
        {
            boidCntLbl.setText(Integer.toString(Boidcounter.count(e.getX(),e.getY(),getRectSizeX()*10,getRectSizeY()*10,mainBoids.boids)));
            ptr.drRec(e.getX(),e.getY(),getRectSizeX()*10,getRectSizeY()*10);
            repaint();
        }
    }
    private void panelMouseClickedLD(java.awt.event.MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            fabric.crateLeader(e.getX(), e.getY());
        } else {
            fabric.cratePredator(e.getX(), e.getY());
        }
        ptr.repaint();
    }
    private void panelMouseClicked(java.awt.event.MouseEvent evt) {                                     
      ptr.aimX=evt.getX();
      ptr.aimY=evt.getY();
      if(mainBoids.simul!=null)mainBoids.simul.globalAim=new vector2d(evt.getX(),evt.getY());
    } 
    private void panelMouseMoved(java.awt.event.MouseEvent evt) {
      ptr.aimX=evt.getX();
      ptr.aimY=evt.getY();
      if(mainBoids.simul!=null)mainBoids.simul.globalAim=new vector2d(evt.getX(),evt.getY());
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
    private javax.swing.JLabel boidCntLbl;
    private javax.swing.JToggleButton boidCount;
    private javax.swing.JButton btnGenStado;
    private javax.swing.JButton btnGlobAim;
    private javax.swing.JButton btnLoadSettings;
    private javax.swing.JToggleButton btnPolaryzation;
    private javax.swing.JToggleButton btnPolaryzationLokal;
    private javax.swing.JToggleButton btnPred;
    private javax.swing.JToggleButton btnSeparacWygl;
    private javax.swing.JToggleButton btnSrodkuj;
    private javax.swing.JButton btnStart;
    private javax.swing.JToggleButton btnSterMysza;
    private javax.swing.JToggleButton btnSterMysza1;
    private javax.swing.JToggleButton btnSterMysza3;
    private javax.swing.JToggleButton btnVelWart;
    private javax.swing.JToggleButton btnWpływLeader;
    private javax.swing.JLabel chStrLabel;
    private javax.swing.JSlider chStrategyCof;
    private javax.swing.JComboBox cmbThreads;
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
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAli;
    private javax.swing.JLabel lblAngle;
    public javax.swing.JLabel lblAvgDist;
    public javax.swing.JLabel lblAvgNumNeight;
    public javax.swing.JLabel lblAvgSpeed;
    private javax.swing.JLabel lblAvoid;
    private javax.swing.JLabel lblAvoidMode;
    private javax.swing.JLabel lblAvoidRec;
    public javax.swing.JLabel lblBoidsColide;
    private javax.swing.JLabel lblCoh;
    private javax.swing.JLabel lblForagingDistance;
    private javax.swing.JLabel lblFreqEat;
    public javax.swing.JLabel lblHaveLeaderPer;
    private javax.swing.JLabel lblHunger;
    private javax.swing.JLabel lblLead;
    private javax.swing.JLabel lblMass;
    private javax.swing.JLabel lblMaxAccel;
    private javax.swing.JLabel lblMaxNeight;
    private javax.swing.JLabel lblMaxPerf;
    private javax.swing.JLabel lblMaxSpeed;
    private javax.swing.JLabel lblMinDistSep;
    private javax.swing.JLabel lblMinPerf;
    private javax.swing.JLabel lblNeigh;
    private javax.swing.JLabel lblNumBoids;
    public javax.swing.JLabel lblNumCols;
    private javax.swing.JLabel lblNumLeaders;
    private javax.swing.JLabel lblNumPred;
    public javax.swing.JLabel lblOdstAvgSpeed;
    public javax.swing.JLabel lblOdstAvgSpeedLokal;
    private javax.swing.JLabel lblPerformance;
    private javax.swing.JLabel lblPred;
    private javax.swing.JLabel lblProbki;
    private javax.swing.JLabel lblRand;
    private javax.swing.JLabel lblRatio;
    private javax.swing.JLabel lblSep;
    private javax.swing.JLabel lblSkala;
    private javax.swing.JLabel lblTimeFood;
    private javax.swing.JLabel lblTimeReaction;
    private javax.swing.JRadioButton radConstTime;
    private javax.swing.JRadioButton ratRatio;
    private javax.swing.JLabel recSizeLbl;
    private javax.swing.JLabel recSizeLbl1;
    private javax.swing.JSlider rectSize;
    private javax.swing.JSlider rectSize1;
    private javax.swing.JToggleButton saveStatsBtn;
    private javax.swing.JPanel setPanelAdv;
    private javax.swing.JPanel setPanelPod;
    private javax.swing.JSlider sldAliCof;
    private javax.swing.JSlider sldAngle;
    private javax.swing.JSlider sldAvoidCof;
    private javax.swing.JSlider sldAvoidMode;
    private javax.swing.JSlider sldAvoidRec;
    private javax.swing.JSlider sldCohCof;
    private javax.swing.JSlider sldForDist;
    private javax.swing.JSlider sldFreqEat;
    private javax.swing.JSlider sldLeadCof;
    private javax.swing.JSlider sldMass;
    private javax.swing.JSlider sldMaxAccel;
    private javax.swing.JSlider sldMaxSpeed;
    private javax.swing.JSlider sldMinDistSep;
    private javax.swing.JSlider sldNeigh;
    private javax.swing.JSlider sldNumNeight;
    private javax.swing.JSlider sldPerHunger;
    private javax.swing.JSlider sldPredCof;
    private javax.swing.JSlider sldRandCof;
    private javax.swing.JSlider sldRatio;
    private javax.swing.JSlider sldReactionTime;
    private javax.swing.JSlider sldSepCof;
    private javax.swing.JSlider sldSkala;
    private javax.swing.JSlider sldTimeFood;
    private javax.swing.JSpinner spnBoidRadius;
    private javax.swing.JSpinner spnBucketX;
    private javax.swing.JSpinner spnBucketY;
    private javax.swing.JSpinner spnHeight;
    private javax.swing.JSpinner spnLeaderRadius;
    private javax.swing.JSpinner spnObstacleRadius;
    private javax.swing.JSpinner spnPredatorRadius;
    private javax.swing.JSpinner spnWidth;
    private javax.swing.JPanel statPanel;
    private javax.swing.JFileChooser statsChooser;
    private javax.swing.JPanel sterLead;
    private javax.swing.JSpinner textLeaderNum;
    private javax.swing.JSpinner textNumFood;
    private javax.swing.JSpinner textNumObs;
    private javax.swing.JSpinner textNumPred;
    private javax.swing.JFormattedTextField txtNumSwarm;
    private javax.swing.JPanel wygladPanel;
    // End of variables declaration//GEN-END:variables
}
