package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.text.*;

import com.toedter.calendar.*;

public class CHistoriaOcup extends JInternalFrame {

    Object objppalho;
    Object obotactualizarHO;
    public Statement TSentenciaconsultaEP;
    public ResultSet RconsultaEP;
    public ConexionSql Cconsql = new ConexionSql();
    String numingredicEP;
    int swedicingrho;
    String cad1;
    String cad2;
    Object objetoenfprofesional = new Object();
    int swgte;
    int[][] fact = new int[10][9];
    int[][] elem = new int[10][59];
    Object JDPIngresoobj = new Object();
    Object frameHOOBJ = new Object();
    Object framehoOBJ = new Object();
    int swval;
    String sFechaHO;
    Date fechainiHO = new Date();
    Date fechafinHO = new Date();
    ModeloHO modeloho = new ModeloHO();
    public String nombredetalle = "";
    //public static int swepilepc=1;
    CHistoriaOcup objCAF;
    public String Nombrepac = new String();
    public String varnhc = new String();
    JCalendar jCalendar1 = new JCalendar();
    JCalendar jCalendar2 = new JCalendar();
    ValidarComponentes validHO = new ValidarComponentes();
    int ifila = 0;
    //DECLARACION DE PANELES
    JTabbedPane JTBAntFam = new JTabbedPane();
    JPanel JPAntecedentesFamiliar = new JPanel();
    JPanel JPAntFam = new JPanel();
    //DECLARACION DE OBJETOS VISUALES
    JButton JBAtrasAF = new JButton();
    JButton JBCancelarAF = new JButton();
    JButton JBSgteAF = new JButton();
    JLabel JLBNumhcAF = new JLabel();
    JCheckBox jCheckBox1 = new JCheckBox();
    JLabel JLBEmpresaHO = new JLabel();
    JTextField JTFEmprHO = new JTextField();
    JLabel JLBFechaEmprHO = new JLabel();
    JLabel FechaFinEmprHO = new JLabel();
    JFormattedTextField JFTFechaEmprHO = JFTFechaEmprHO = new JFormattedTextField();
    JFormattedTextField JFTFechaFinEmrHO = new JFormattedTextField();
    JLabel JLBCargoHO = new JLabel();
    JTextField JTFCargoHO = new JTextField();
    JLabel JLBFactorRiesgoHO = new JLabel();
    JTextField JTFFactorRiesgoHO = new JTextField();
    JLabel JLBElemRiesgoHO = new JLabel();
    JTextField JTFElemRiesgHO = new JTextField();
    JLabel JLBTiempoExp = new JLabel();
    JTextField JTFTiempoExp = new JTextField();
    JScrollPane JSPHo = new JScrollPane();
    JTable JTabHO = new JTable(modeloho);
    JLabel JLBPac = new JLabel();
    JLabel JLBHistNum = new JLabel();
    JComboBox JCBFactorRiesg = new JComboBox();
    JComboBox JCBElemRiesgo = new JComboBox();
    JLabel JLBTiempo = new JLabel(); //JTable JTabHO = new JTable();

    JPanel JPFactorRiesgo = new JPanel();
    JCheckBox JCHErgonomicos = new JCheckBox();
    JCheckBox JCHFisicos = new JCheckBox();
    JCheckBox JCHQUIMICOS = new JCheckBox();
    JCheckBox JCHBIologicos = new JCheckBox();
    JCheckBox JCHFisicoQuimicos = new JCheckBox();
    JCheckBox JCHPsicosociales = new JCheckBox();
    JCheckBox JCHMecanicos = new JCheckBox();
    JCheckBox JCHElectricos = new JCheckBox();
    JCheckBox JCHLocativos = new JCheckBox();
    JPanel jPanel1 = new JPanel();
    JCheckBox JCHPlumas = new JCheckBox();
    JCheckBox JCHVibrac = new JCheckBox();
    JCheckBox JCHTempBaja = new JCheckBox();
    JCheckBox JCHTempAlta = new JCheckBox();
    JCheckBox JCHRuido = new JCheckBox();
    JCheckBox JCHRadNoIon = new JCheckBox();
    JCheckBox JCHRadiacIoniz = new JCheckBox();
    JCheckBox JCHIlumExcesiva = new JCheckBox();
    JCheckBox JCHIlumDef = new JCheckBox();
    JCheckBox JCHPelos = new JCheckBox();
    JCheckBox JCHHumoMet = new JCheckBox();
    JCheckBox JCHPolen = new JCheckBox();
    JCheckBox JCHAnimVerteb = new JCheckBox();
    JCheckBox JCHHumoNoMet = new JCheckBox();
    JCheckBox JCHPolvos = new JCheckBox();
    JCheckBox JCHMantCorr1 = new JCheckBox();
    JCheckBox JCHCargaEst = new JCheckBox();
    JCheckBox JCHDisenoPuest = new JCheckBox();
    JCheckBox JCHAltaTension = new JCheckBox();
    JCheckBox JCHMarcacion = new JCheckBox();
    JCheckBox JCHVirus = new JCheckBox();
    JCheckBox JCHBacterias = new JCheckBox();
    JCheckBox JCHHongos = new JCheckBox();
    JCheckBox JCHParasitos = new JCheckBox();
    JCheckBox JCHEPolvoInorg = new JCheckBox();
    JCheckBox JCHPolvoOrganico = new JCheckBox();
    JCheckBox JCHLevPeso = new JCheckBox();
    JCheckBox JCHInconpatib = new JCheckBox();
    JCheckBox JCHAnimInv = new JCheckBox();
    JCheckBox JCHSobreEsf = new JCheckBox();
    JCheckBox JCHPostForz = new JCheckBox();
    JCheckBox JCHOtros1 = new JCheckBox();
    JLabel JLBElemRiesgFisico = new JLabel();
    JCheckBox JCHManResAnim = new JCheckBox();
    JCheckBox JCHManResVeget = new JCheckBox();
    JCheckBox JCHCuchillos = new JCheckBox();
    JCheckBox JCHJeringas = new JCheckBox();
    JCheckBox JCHBisturis = new JCheckBox();
    JCheckBox JCHDesIndustr = new JCheckBox();
    JCheckBox JCHBasuras = new JCheckBox();
    JLabel JLBElemRiesgBiologicos = new JLabel();
    JLabel JLBRiesgQuimico = new JLabel();
    JCheckBox JCHPresSust = new JCheckBox();
    JCheckBox JCHReactivas = new JCheckBox();
    JCheckBox JCHStressLab = new JCheckBox();
    JLabel JLBRiesgFisicoQuim = new JLabel();
    JCheckBox JCHAtencionUsu = new JCheckBox();
    JCheckBox JCHPeligrosCargaLabor = new JCheckBox();
    JCheckBox JCHJorndRot = new JCheckBox();
    JCheckBox JCHJornadExtens = new JCheckBox();
    JCheckBox JCHInestLab = new JCheckBox();
    JLabel JLBRiesgPsicoSoc = new JLabel();
    JCheckBox JCHGuardasSeg = new JCheckBox();
    JCheckBox JCHMantCorr2 = new JCheckBox();
    JCheckBox JCHPartes = new JCheckBox();
    JCheckBox JCHFaltaHerr = new JCheckBox();
    JLabel JLBriesgMec = new JLabel();
    JCheckBox JCHBajaTension = new JCheckBox();
    JLabel JLBRiesgElectricos = new JLabel();
    JCheckBox JCHPisos = new JCheckBox();
    JCheckBox JCHMuros = new JCheckBox();
    JCheckBox JCHTechos = new JCheckBox();
    JCheckBox JCHSuperficie = new JCheckBox();
    JCheckBox JCHOrden = new JCheckBox();
    JCheckBox JCHMovRepetitivos = new JCheckBox();
    JCheckBox JCHdOTACION = new JCheckBox();
    JCheckBox JCHExtintores = new JCheckBox();
    JLabel JLBRiegLocativos = new JLabel();
    JPanel JPSeleccFact = new JPanel();
    JRadioButton jRadioButton1 = new JRadioButton();
    JRadioButton JRErgonomic = new JRadioButton();
    JRadioButton JRFisicos = new JRadioButton();
    JRadioButton JRQuimic = new JRadioButton();
    JRadioButton JRFisicoquim = new JRadioButton();
    JRadioButton JRBiologicos = new JRadioButton();
    JRadioButton JRPsicolog = new JRadioButton();
    JRadioButton JRMecanicos = new JRadioButton();
    JRadioButton JRElectricos = new JRadioButton();
    JRadioButton JRLocativos = new JRadioButton();
    JCheckBox JCHEmprActual = new JCheckBox();

    public CHistoriaOcup(Object obotactualizar, String numingredic, int swedicioningr, String cadpapell, String cadsapell, String cadpnombr, String cadsnombr, String NDoc, JDesktopPane JDPIngreso, CIngreso frameingreso, Object objppalig) {
        try {
            nombrepaciente(cadpapell, cadsapell, cadpnombr, cadsnombr);
            varnhc = "";
            varnhc = varnhc.concat(NDoc);
            jbInit();
            frameHOOBJ = frameingreso;
            JLBPac.setText(Nombrepac);
            JLBHistNum.setText(varnhc);
            anadirentradaHO();
            cerarfactor();
            cerarelem();
            //llenarfactorriesgo();
            // llenareleriesgo();
            JBAtrasAF.setEnabled(false);
            JDPIngresoobj = JDPIngreso;
            ocultarelemtodos();
            swgte = 0;
            swedicingrho = swedicioningr;
            numingredicEP = numingredic;
            obotactualizarHO = obotactualizar;
            objppalho = objppalig;
            //framehoOBJ=frameho;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * cerarelem
     */
    private void jbInit() throws Exception {
        //System.out.println("HISTORIA OCUPACIONAL:");
        //configurarformatofechaHO();
        this.setClosable(true);
        this.setIconifiable(true);
        this.setMaximizable(true);
        this.setResizable(true);
        this.getContentPane().setBackground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
        this.setVisible(true);
        this.getContentPane().setLayout(null);
        JTBAntFam.setBackground(new Color(49, 106, 197));
        JTBAntFam.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JTBAntFam.setForeground(Color.red);
        JTBAntFam.setBorder(BorderFactory.createRaisedBevelBorder());
        JTBAntFam.setBounds(new Rectangle(5, 72, 982, 432));
        JPAntecedentesFamiliar.setBackground(SystemColor.textHighlight);
        JPAntecedentesFamiliar.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JPAntecedentesFamiliar.setBorder(BorderFactory.createRaisedBevelBorder());
        JPAntecedentesFamiliar.setBounds(new Rectangle(6, 3, 991, 557));
        JPAntecedentesFamiliar.setLayout(null);
        JPAntFam.setBackground(new Color(146, 154, 255));
        JPAntFam.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JPAntFam.setLayout(null);
        //CARACTERISTICAS DE LOS COMPONENTES VISUALES
        JBAtrasAF.setBounds(new Rectangle(139, 509, 112, 36));
        JBAtrasAF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBAtrasAF.setMnemonic('R');
        JBAtrasAF.setText("Atras");
        JBAtrasAF.addActionListener(new CHistoriaOcup_JBAtrasAF_actionAdapter(this));
        //JBAtrasAC.addActionListener(new CAntecedentesPersonales_JBAtrasAC_actionAdapter(this));
        JBAtrasAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN3.GIF")));
        JBAtrasAF.setSelectedIcon(null);
        JBCancelarAF.setBounds(new Rectangle(749, 511, 131, 36));
        JBCancelarAF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBCancelarAF.setToolTipText("");
        JBCancelarAF.setMnemonic('S');
        JBCancelarAF.setText("CANCELAR");
        //JBCancelarAP.addActionListener(new CAntecedentesPersonales_JBCancelarAP_actionAdapter(this));
        JBCancelarAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/MG19.GIF")));
        JBCancelarAF.setSelectedIcon(null);
        JBSgteAF.setBounds(new Rectangle(434, 510, 133, 36));
        JBSgteAF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBSgteAF.setToolTipText("");
        JBSgteAF.setMnemonic('S');
        JBSgteAF.setText("SIGUIENTE");
        JBSgteAF.addActionListener(new CHistoriaOcup_JBSgteAF_actionAdapter(this));
        //JBSgteAF.addActionListener(ne              CAntecedentesPersonales_JBSgteAP_actionAdapter(this));
        JBSgteAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN4.GIF")));
        JBSgteAF.setSelectedIcon(null);
        JLBNumhcAF.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNumhcAF.setForeground(Color.red);
        JLBNumhcAF.setToolTipText("");
        JLBNumhcAF.setText("HISTORIA CLINICA N#");
        JLBNumhcAF.setBounds(new Rectangle(304, 12, 158, 24));
        jCheckBox1.setText("jCheckBox1");
        jCheckBox1.setBounds(new Rectangle(537, 134, 84, 23));
        JLBEmpresaHO.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBEmpresaHO.setForeground(Color.red);
        JLBEmpresaHO.setToolTipText("");
        JLBEmpresaHO.setText("EMPRESA");
        JLBEmpresaHO.setBounds(new Rectangle(9, 9, 59, 20));
        JLBEmpresaHO.setVisible(true);
        JTFEmprHO.setBackground(Color.white);
        JTFEmprHO.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFEmprHO.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFEmprHO.setToolTipText("");
        JTFEmprHO.setEditable(true);
        JTFEmprHO.setBounds(new Rectangle(72, 8, 372, 22));
        JTFEmprHO.addKeyListener(new CHistoriaOcup_JTFEmprHO_keyAdapter(this));
        JTFEmprHO.setVisible(true);
        JLBFechaEmprHO.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBFechaEmprHO.setForeground(Color.red);
        JLBFechaEmprHO.setToolTipText("");
        JLBFechaEmprHO.setText("FECHA INICIO");
        JLBFechaEmprHO.setBounds(new Rectangle(472, 9, 78, 20));
        FechaFinEmprHO.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        FechaFinEmprHO.setForeground(Color.red);
        FechaFinEmprHO.setToolTipText("");
        FechaFinEmprHO.setText("FECHA FIN");
        FechaFinEmprHO.setBounds(new Rectangle(750, 12, 72, 20));
        JFTFechaEmprHO.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTFechaEmprHO.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTFechaEmprHO.setToolTipText("");
        JFTFechaEmprHO.setText("");
        JFTFechaEmprHO.setBounds(new Rectangle(576, 10, 126, 21));
        JFTFechaEmprHO.addKeyListener(new CHistoriaOcup_JFTFechaEmprHO_keyAdapter(this));
        JFTFechaEmprHO.addFocusListener(new CHistoriaOcup_JFTFechaEmprHO_focusAdapter(this));
        JFTFechaFinEmrHO.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTFechaFinEmrHO.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTFechaFinEmrHO.setToolTipText("");
        JFTFechaFinEmrHO.setText("");
        JFTFechaFinEmrHO.setBounds(new Rectangle(833, 10, 126, 21));
        JFTFechaFinEmrHO.addKeyListener(new CHistoriaOcup_JFTFechaFinEmrHO_keyAdapter(this));
        JFTFechaFinEmrHO.addFocusListener(new CHistoriaOcup_JFTFechaFinEmrHO_focusAdapter(this));
        JLBCargoHO.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBCargoHO.setForeground(Color.red);
        JLBCargoHO.setToolTipText("");
        JLBCargoHO.setText("CARGO");
        JLBCargoHO.setBounds(new Rectangle(471, 49, 54, 20));
        JTFCargoHO.setBackground(Color.white);
        JTFCargoHO.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFCargoHO.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFCargoHO.setToolTipText("");
        JTFCargoHO.setEditable(true);
        JTFCargoHO.setText("");
        JTFCargoHO.setBounds(new Rectangle(574, 51, 382, 22));
        JTFCargoHO.addKeyListener(new CHistoriaOcup_JTFCargoHO_keyAdapter(this));
        JTFCargoHO.addActionListener(new CHistoriaOcup_JTFCargoHO_actionAdapter(this));
        JLBFactorRiesgoHO.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBFactorRiesgoHO.setForeground(Color.red);
        JLBFactorRiesgoHO.setToolTipText("");
        JLBFactorRiesgoHO.setText("FACTOR DE RIESGO");
        JLBFactorRiesgoHO.setBounds(new Rectangle(11, 72, 119, 20));
        JLBFactorRiesgoHO.setVisible(true);
        JTFFactorRiesgoHO.setBackground(Color.white);
        JTFFactorRiesgoHO.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFFactorRiesgoHO.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFFactorRiesgoHO.setToolTipText("");
        JTFFactorRiesgoHO.setEditable(true);
        JTFFactorRiesgoHO.setVisible(true);
        JTFFactorRiesgoHO.setBounds(new Rectangle(72, 50, 371, 22));
        JTFFactorRiesgoHO.addKeyListener(new CHistoriaOcup_JTFFactorRiesgoHO_keyAdapter(this));
        JLBElemRiesgoHO.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBElemRiesgoHO.setForeground(Color.red);
        JLBElemRiesgoHO.setToolTipText("");
        JLBElemRiesgoHO.setText("ELEMENTOS DE RIESGO ERGONOMICOS");
        JLBElemRiesgoHO.setBounds(new Rectangle(11, 128, 222, 20));
        JTFElemRiesgHO.setBackground(Color.white);
        JTFElemRiesgHO.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFElemRiesgHO.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFElemRiesgHO.setToolTipText("");
        JTFElemRiesgHO.setEditable(true);
        JTFElemRiesgHO.setText("");
        JTFElemRiesgHO.setBounds(new Rectangle(245, 50, 90, 22));
        JLBTiempoExp.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBTiempoExp.setForeground(Color.red);
        JLBTiempoExp.setToolTipText("");
        JLBTiempoExp.setText("TIEMPO DE EXPOSICION");
        JLBTiempoExp.setBounds(new Rectangle(510, 255, 143, 20));
        //JLBTiempoExp.setVisible(false);
        JTFTiempoExp.setBackground(Color.white);
        JTFTiempoExp.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFTiempoExp.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFTiempoExp.setToolTipText("");
        JTFTiempoExp.setEditable(true);
        JTFTiempoExp.setBounds(new Rectangle(667, 253, 285, 22));
        JTFTiempoExp.addKeyListener(new CHistoriaOcup_JTFTiempoExp_keyAdapter(this));
        //JTFTiempoExp.setVisible(false);
        JSPHo.getViewport().setBackground(Color.white);
        JSPHo.setBorder(BorderFactory.createRaisedBevelBorder());
        JSPHo.setBounds(new Rectangle(13, 279, 949, 115));
        JLBPac.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBPac.setForeground(Color.red);
        JLBPac.setToolTipText("");
        JLBPac.setText("HISTORIA CLINICA N#");
        JLBPac.setBounds(new Rectangle(4, 10, 357, 24));
        JLBHistNum.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBHistNum.setForeground(Color.red);
        JLBHistNum.setToolTipText("");
        JLBHistNum.setText("HISTORIA CLINICA N#");
        JLBHistNum.setBounds(new Rectangle(480, 12, 191, 24));
        jCalendar1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jCalendar1.setBackground(Color.red);
        jCalendar1.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        jCalendar1.setDecorationBackgroundColor(Color.white);
        jCalendar1.addMouseListener(new CHistoriaOcup_jCalendar1_mouseAdapter(this));
        jCalendar1.setBounds(new Rectangle(575, 10, 258, 84));
        jCalendar1.setVisible(false);//asta aqui
        jCalendar2.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jCalendar2.setBackground(Color.red);
        jCalendar2.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        jCalendar2.setDecorationBackgroundColor(Color.white);
        jCalendar2.addMouseListener(new CHistoriaOcup_jCalendar2_mouseAdapter(this));
        //jCalendar2.addMouseListener(new CHistoriaOcup_jCalendar1_mouseAdapter(this));
        jCalendar2.setBounds(new Rectangle(715, 12, 258, 84));
        jCalendar2.setVisible(false);
        JTabHO.addMouseListener(new CHistoriaOcup_JTabHO_mouseAdapter(this));
        JCBFactorRiesg.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCBFactorRiesg.setBorder(BorderFactory.createLoweredBevelBorder());
        JCBFactorRiesg.setBounds(new Rectangle(122, 29, 285, 21));
        JCBFactorRiesg.setVisible(false);
        JCBFactorRiesg.addKeyListener(new CHistoriaOcup_JCBFactorRiesg_keyAdapter(this));
        JCBElemRiesgo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCBElemRiesgo.setBorder(BorderFactory.createLoweredBevelBorder());
        JCBElemRiesgo.setBounds(new Rectangle(550, 29, 343, 21));
        JCBElemRiesgo.addKeyListener(new CHistoriaOcup_JCBElemRiesgo_keyAdapter(this));
        JCBElemRiesgo.setVisible(false);
        JLBTiempo.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBTiempo.setForeground(Color.red);
        JLBTiempo.setToolTipText("");
        JLBTiempo.setText("TIEMPO");
        JLBTiempo.setBounds(new Rectangle(12, 49, 54, 20));
        JLBTiempo.setVisible(true);
        JTabHO.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPFactorRiesgo.setBackground(SystemColor.inactiveCaption);
        JPFactorRiesgo.setBorder(BorderFactory.createRaisedBevelBorder());
        JPFactorRiesgo.setBounds(new Rectangle(11, 92, 944, 37));
        JPFactorRiesgo.setLayout(null);
        JPFactorRiesgo.setVisible(true);
        JCHErgonomicos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHErgonomicos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHErgonomicos.setToolTipText("");
        JCHErgonomicos.setText("ERGONOMICOS");
        JCHErgonomicos.setBounds(new Rectangle(4, 6, 96, 23));
        JCHErgonomicos.addActionListener(new CHistoriaOcup_JCHErgonomicos_actionAdapter(this));
        JCHFisicos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHFisicos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHFisicos.setToolTipText("");
        JCHFisicos.setText("FISICOS");
        JCHFisicos.setBounds(new Rectangle(115, 7, 68, 23));
        JCHFisicos.addActionListener(new CHistoriaOcup_JCHFisicos_actionAdapter(this));
        JCHQUIMICOS.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHQUIMICOS.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHQUIMICOS.setToolTipText("");
        JCHQUIMICOS.setText("QUIMICOS");
        JCHQUIMICOS.setBounds(new Rectangle(193, 7, 72, 23));
        JCHQUIMICOS.addActionListener(new CHistoriaOcup_JCHQUIMICOS_actionAdapter(this));
        JCHBIologicos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHBIologicos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHBIologicos.setToolTipText("");
        JCHBIologicos.setText("BIOLOGICOS");
        JCHBIologicos.setBounds(new Rectangle(277, 8, 89, 23));
        JCHBIologicos.addActionListener(new CHistoriaOcup_JCHBIologicos_actionAdapter(this));
        JCHFisicoQuimicos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHFisicoQuimicos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHFisicoQuimicos.setToolTipText("");
        JCHFisicoQuimicos.setText("FISICOQUIMICOS");
        JCHFisicoQuimicos.setBounds(new Rectangle(379, 8, 105, 23));
        JCHFisicoQuimicos.addActionListener(new CHistoriaOcup_JCHFisicoQuimicos_actionAdapter(this));
        JCHPsicosociales.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHPsicosociales.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHPsicosociales.setToolTipText("");
        JCHPsicosociales.setText("PSICOSOCIALES");
        JCHPsicosociales.setBounds(new Rectangle(501, 6, 105, 23));
        JCHPsicosociales.addActionListener(new CHistoriaOcup_JCHPsicosociales_actionAdapter(this));
        JCHMecanicos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHMecanicos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHMecanicos.setToolTipText("");
        JCHMecanicos.setText("MECANICOS");
        JCHMecanicos.setBounds(new Rectangle(625, 6, 80, 23));
        JCHMecanicos.addActionListener(new CHistoriaOcup_JCHMecanicos_actionAdapter(this));
        JCHElectricos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHElectricos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHElectricos.setToolTipText("");
        JCHElectricos.setText("ELECTRICOS");
        JCHElectricos.setBounds(new Rectangle(720, 6, 91, 23));
        JCHElectricos.addActionListener(new CHistoriaOcup_JCHElectricos_actionAdapter(this));
        JCHLocativos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHLocativos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHLocativos.setToolTipText("");
        JCHLocativos.setText("LOCATIVOS");
        JCHLocativos.setBounds(new Rectangle(823, 6, 114, 23));
        JCHLocativos.addActionListener(new CHistoriaOcup_JCHLocativos_actionAdapter(this));
        jPanel1.setBackground(SystemColor.inactiveCaption);
        jPanel1.setBorder(BorderFactory.createRaisedBevelBorder());
        jPanel1.setBounds(new Rectangle(10, 146, 944, 102));
        jPanel1.setLayout(null);
        JCHPlumas.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHPlumas.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHPlumas.setOpaque(false);
        JCHPlumas.setToolTipText("");
        JCHPlumas.setText("PLUMAS");
        JCHPlumas.setBounds(new Rectangle(229, 25, 118, 21));
        JCHVibrac.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHVibrac.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHVibrac.setOpaque(false);
        JCHVibrac.setToolTipText("");
        JCHVibrac.setText("VIBRACION");
        JCHVibrac.setBounds(new Rectangle(228, 71, 78, 21));
        JCHTempBaja.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHTempBaja.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHTempBaja.setOpaque(false);
        JCHTempBaja.setToolTipText("");
        JCHTempBaja.setText("TEMP BAJA");
        JCHTempBaja.setBounds(new Rectangle(228, 25, 77, 21));
        JCHTempAlta.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHTempAlta.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHTempAlta.setOpaque(false);
        JCHTempAlta.setToolTipText("");
        JCHTempAlta.setText("TEMP ALTA");
        JCHTempAlta.setBounds(new Rectangle(228, 48, 78, 21));
        JCHRuido.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHRuido.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHRuido.setOpaque(false);
        JCHRuido.setToolTipText("");
        JCHRuido.setText("RUIDO");
        JCHRuido.setBounds(new Rectangle(6, 4, 57, 21));
        JCHRadNoIon.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHRadNoIon.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHRadNoIon.setOpaque(false);
        JCHRadNoIon.setToolTipText("");
        JCHRadNoIon.setText("RADIACION NO ION");
        JCHRadNoIon.setBounds(new Rectangle(227, 3, 116, 21));
        JCHRadiacIoniz.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHRadiacIoniz.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHRadiacIoniz.setOpaque(false);
        JCHRadiacIoniz.setToolTipText("");
        JCHRadiacIoniz.setText("RADIACION ION");
        JCHRadiacIoniz.setBounds(new Rectangle(7, 75, 99, 21));
        JCHIlumExcesiva.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHIlumExcesiva.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHIlumExcesiva.setOpaque(false);
        JCHIlumExcesiva.setToolTipText("");
        JCHIlumExcesiva.setText("ILUM EXCESIVA");
        JCHIlumExcesiva.setBounds(new Rectangle(7, 51, 98, 21));
        JCHIlumDef.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHIlumDef.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHIlumDef.setOpaque(false);
        JCHIlumDef.setToolTipText("");
        JCHIlumDef.setText("ILUM DEFECT.");
        JCHIlumDef.setBounds(new Rectangle(6, 27, 92, 21));
        JCHPelos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHPelos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHPelos.setOpaque(false);
        JCHPelos.setToolTipText("");
        JCHPelos.setText("PELOS");
        JCHPelos.setBounds(new Rectangle(229, 3, 69, 21));
        JCHHumoMet.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHHumoMet.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHHumoMet.setOpaque(false);
        JCHHumoMet.setToolTipText("");
        JCHHumoMet.setText("HUMO METALICO");
        JCHHumoMet.setBounds(new Rectangle(8, 51, 109, 21));
        JCHPolen.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHPolen.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHPolen.setOpaque(false);
        JCHPolen.setToolTipText("");
        JCHPolen.setText("POLEN");
        JCHPolen.setBounds(new Rectangle(229, 48, 60, 21));
        JCHAnimVerteb.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHAnimVerteb.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHAnimVerteb.setOpaque(false);
        JCHAnimVerteb.setToolTipText("");
        JCHAnimVerteb.setText("ANIMALES VERTEBRADOS");
        JCHAnimVerteb.setBounds(new Rectangle(229, 71, 143, 21));
        JCHHumoNoMet.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHHumoNoMet.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHHumoNoMet.setOpaque(false);
        JCHHumoNoMet.setToolTipText("");
        JCHHumoNoMet.setText("HUMO NO METALICO");
        JCHHumoNoMet.setBounds(new Rectangle(8, 74, 127, 21));
        JCHPolvos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHPolvos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHPolvos.setOpaque(false);
        JCHPolvos.setToolTipText("");
        JCHPolvos.setText("POLVOS");
        JCHPolvos.setVisible(false);
        JCHPolvos.setBounds(new Rectangle(284, 29, 67, 21));
        JCHMantCorr1.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHMantCorr1.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHMantCorr1.setOpaque(false);
        JCHMantCorr1.setToolTipText("");
        JCHMantCorr1.setText("MANTENIMIENTO PREV/CORR MAQUINAS,EQUIPOS Y HERR");
        JCHMantCorr1.setBounds(new Rectangle(7, 4, 295, 21));
        JCHCargaEst.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHCargaEst.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHCargaEst.setOpaque(false);
        JCHCargaEst.setToolTipText("");
        JCHCargaEst.setText("CARGA ESTATICA");
        JCHCargaEst.setBounds(new Rectangle(7, 4, 104, 21));
        JCHDisenoPuest.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHDisenoPuest.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHDisenoPuest.setOpaque(false);
        JCHDisenoPuest.setToolTipText("");
        JCHDisenoPuest.setText("MAL DISEÑO DE PUESTOS DE TRABAJO");
        JCHDisenoPuest.setBounds(new Rectangle(6, 4, 205, 21));
        JCHAltaTension.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHAltaTension.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHAltaTension.setOpaque(false);
        JCHAltaTension.setToolTipText("");
        JCHAltaTension.setText("ALTA TENSION");
        JCHAltaTension.setBounds(new Rectangle(8, 27, 103, 21));
        JCHMarcacion.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHMarcacion.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHMarcacion.setOpaque(false);
        JCHMarcacion.setToolTipText("");
        JCHMarcacion.setText(
                "\tSEÑALIZACION Y DEMARCACION DEFICIENTE,INEXISTENTE INADECUADA     "
                + "    ");
        JCHMarcacion.setBounds(new Rectangle(486, 28, 360, 21));
        JCHVirus.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHVirus.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHVirus.setOpaque(false);
        JCHVirus.setToolTipText("");
        JCHVirus.setText("VIRUS");
        JCHVirus.setBounds(new Rectangle(8, 51, 60, 21));
        JCHBacterias.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHBacterias.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHBacterias.setOpaque(false);
        JCHBacterias.setToolTipText("");
        JCHBacterias.setText("BACTERIAS");
        JCHBacterias.setBounds(new Rectangle(8, 4, 82, 21));
        JCHHongos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHHongos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHHongos.setOpaque(false);
        JCHHongos.setToolTipText("");
        JCHHongos.setText("HONGOS");
        JCHHongos.setBounds(new Rectangle(8, 74, 70, 21));
        JCHParasitos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHParasitos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHParasitos.setOpaque(false);
        JCHParasitos.setToolTipText("");
        JCHParasitos.setText("PARASITOS");
        JCHParasitos.setBounds(new Rectangle(7, 27, 81, 21));
        JCHParasitos.addActionListener(new CHistoriaOcup_JCHParasitos_actionAdapter(this));
        JCHEPolvoInorg.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHEPolvoInorg.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHEPolvoInorg.setOpaque(false);
        JCHEPolvoInorg.setToolTipText("");
        JCHEPolvoInorg.setText("POLVO INORGANICO");
        JCHEPolvoInorg.setBounds(new Rectangle(7, 27, 132, 21));
        JCHPolvoOrganico.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHPolvoOrganico.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHPolvoOrganico.setOpaque(false);
        JCHPolvoOrganico.setToolTipText("");
        JCHPolvoOrganico.setText("POLVO ORGANICO");
        JCHPolvoOrganico.setBounds(new Rectangle(7, 4, 122, 21));
        JCHLevPeso.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHLevPeso.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHLevPeso.setOpaque(false);
        JCHLevPeso.setToolTipText("");
        JCHLevPeso.setText("LEVANTAMIENTO INADECUADO DE PESO");
        JCHLevPeso.setBounds(new Rectangle(228, 3, 212, 21));
        JCHInconpatib.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHInconpatib.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHInconpatib.setOpaque(false);
        JCHInconpatib.setToolTipText("");
        JCHInconpatib.setText(
                "n\tINCONPATIBILIDAD FISICO-QUIMICA EN EL ALMACENAMIENTO DE MATERIAS "
                + "PRIMAS");
        JCHInconpatib.setBounds(new Rectangle(6, 4, 417, 21));
        JCHAnimInv.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHAnimInv.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHAnimInv.setOpaque(false);
        JCHAnimInv.setToolTipText("");
        JCHAnimInv.setText("ANIMALES INVERTEBRADOS");
        JCHAnimInv.setBounds(new Rectangle(484, 4, 154, 21));
        JCHSobreEsf.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHSobreEsf.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHSobreEsf.setOpaque(false);
        JCHSobreEsf.setToolTipText("");
        JCHSobreEsf.setText("SOBREESFUERZO");
        JCHSobreEsf.setBounds(new Rectangle(6, 27, 123, 21));
        JCHPostForz.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHPostForz.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHPostForz.setOpaque(false);
        JCHPostForz.setToolTipText("");
        JCHPostForz.setText("POSTURAS  Y MOV INADECUADOS");
        JCHPostForz.setBounds(new Rectangle(6, 51, 178, 21));
        JCHOtros1.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHOtros1.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHOtros1.setOpaque(false);
        JCHOtros1.setToolTipText("");
        JCHOtros1.setText("POSICIONES INADECUADAS");
        JCHOtros1.setBounds(new Rectangle(7, 74, 170, 21));
        JLBElemRiesgFisico.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBElemRiesgFisico.setForeground(Color.red);
        JLBElemRiesgFisico.setToolTipText("");
        JLBElemRiesgFisico.setText("ELEMENTOS DE RIESGO FISICO");
        JLBElemRiesgFisico.setBounds(new Rectangle(11, 128, 357, 20));
        JCHManResAnim.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHManResAnim.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHManResAnim.setOpaque(false);
        JCHManResAnim.setToolTipText("");
        JCHManResAnim.setText("MANIPULACION RESIDUOS ANIMALES");
        JCHManResAnim.setBounds(new Rectangle(485, 28, 196, 21));
        JCHManResVeget.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHManResVeget.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHManResVeget.setOpaque(false);
        JCHManResVeget.setToolTipText("");
        JCHManResVeget.setText("MANIPULACION RESIDUOS VEGETALES");
        JCHManResVeget.setBounds(new Rectangle(485, 52, 209, 21));
        JCHCuchillos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHCuchillos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHCuchillos.setOpaque(false);
        JCHCuchillos.setToolTipText("");
        JCHCuchillos.setText("CUCHILLOS");
        JCHCuchillos.setBounds(new Rectangle(484, 77, 104, 21));
        JCHJeringas.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHJeringas.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHJeringas.setOpaque(false);
        JCHJeringas.setToolTipText("");
        JCHJeringas.setText("JERINGAS");
        JCHJeringas.setBounds(new Rectangle(750, 4, 104, 21));
        JCHBisturis.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHBisturis.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHBisturis.setOpaque(false);
        JCHBisturis.setToolTipText("");
        JCHBisturis.setText("BISTURIS");
        JCHBisturis.setBounds(new Rectangle(750, 28, 103, 21));
        JCHDesIndustr.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHDesIndustr.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHDesIndustr.setOpaque(false);
        JCHDesIndustr.setToolTipText("");
        JCHDesIndustr.setText("DESECHOS INDUSTRIALES");
        JCHDesIndustr.setBounds(new Rectangle(750, 52, 153, 21));
        JCHBasuras.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHBasuras.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHBasuras.setOpaque(false);
        JCHBasuras.setToolTipText("");
        JCHBasuras.setText("BASURAS Y DESECHOS");
        JCHBasuras.setBounds(new Rectangle(750, 78, 132, 21));
        JLBElemRiesgBiologicos.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBElemRiesgBiologicos.setForeground(Color.red);
        JLBElemRiesgBiologicos.setToolTipText("");
        JLBElemRiesgBiologicos.setText("ELEMENTOS DE RIESGO BIOLOGICOS");
        JLBElemRiesgBiologicos.setBounds(new Rectangle(11, 128, 222, 20));
        JLBRiesgQuimico.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBRiesgQuimico.setForeground(Color.red);
        JLBRiesgQuimico.setToolTipText("");
        JLBRiesgQuimico.setText("ELEMENTOS DE RIESGO QUIMICOS");
        JLBRiesgQuimico.setBounds(new Rectangle(11, 128, 357, 20));
        JCHPresSust.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHPresSust.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHPresSust.setOpaque(false);
        JCHPresSust.setToolTipText("");
        JCHPresSust.setText(
                "n\tPRESENCIA DE MATERIAS Y SUSTANCIAS COMBUSTIBLES ");
        JCHPresSust.setBounds(new Rectangle(8, 27, 293, 21));
        JCHReactivas.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHReactivas.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHReactivas.setOpaque(false);
        JCHReactivas.setToolTipText("");
        JCHReactivas.setText("n\tPRESENCIA DE SUSTANCIAS QUIMICAS REACTIVAS");
        JCHReactivas.setBounds(new Rectangle(8, 51, 261, 21));
        JCHStressLab.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHStressLab.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHStressLab.setOpaque(false);
        JCHStressLab.setToolTipText("");
        JCHStressLab.setText("STRESS LABORAL");
        JCHStressLab.setBounds(new Rectangle(5, 4, 116, 21));
        JLBRiesgFisicoQuim.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBRiesgFisicoQuim.setForeground(Color.red);
        JLBRiesgFisicoQuim.setToolTipText("");
        JLBRiesgFisicoQuim.setText("ELEMENTOS DE RIESGO FISICO-QUIMICOS");
        JLBRiesgFisicoQuim.setBounds(new Rectangle(11, 128, 357, 20));
        JCHAtencionUsu.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHAtencionUsu.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHAtencionUsu.setOpaque(false);
        JCHAtencionUsu.setToolTipText("");
        JCHAtencionUsu.setText("ATENCION USUARIOS");
        JCHAtencionUsu.setBounds(new Rectangle(8, 27, 129, 21));
        JCHPeligrosCargaLabor.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHPeligrosCargaLabor.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHPeligrosCargaLabor.setOpaque(false);
        JCHPeligrosCargaLabor.setToolTipText("");
        JCHPeligrosCargaLabor.setText("PELIGROS CARGA LABORAL");
        JCHPeligrosCargaLabor.setBounds(new Rectangle(7, 51, 160, 21));
        JCHJorndRot.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHJorndRot.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHJorndRot.setOpaque(false);
        JCHJorndRot.setToolTipText("");
        JCHJorndRot.setText("JORNADAS ROTATIVAS");
        JCHJorndRot.setBounds(new Rectangle(9, 74, 127, 21));
        JCHJornadExtens.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHJornadExtens.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHJornadExtens.setOpaque(false);
        JCHJornadExtens.setToolTipText("");
        JCHJornadExtens.setText("JORNADAS EXTENSAS");
        JCHJornadExtens.setBounds(new Rectangle(230, 3, 131, 21));
        JCHInestLab.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHInestLab.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHInestLab.setOpaque(false);
        JCHInestLab.setToolTipText("");
        JCHInestLab.setText("INESTABILIDAD LABORAL");
        JCHInestLab.setBounds(new Rectangle(230, 25, 144, 21));
        JLBRiesgPsicoSoc.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBRiesgPsicoSoc.setForeground(Color.red);
        JLBRiesgPsicoSoc.setToolTipText("");
        JLBRiesgPsicoSoc.setText("ELEMENTOS DE RIESGO PSICOSOCIALES");
        JLBRiesgPsicoSoc.setBounds(new Rectangle(11, 128, 357, 20));
        JCHGuardasSeg.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHGuardasSeg.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHGuardasSeg.setOpaque(false);
        JCHGuardasSeg.setToolTipText("");
        JCHGuardasSeg.setText(
                "CARENCIA GUARDAS SEGURIDAD MAQUINAS,EQUIPOS Y HERR");
        JCHGuardasSeg.setBounds(new Rectangle(8, 27, 315, 21));
        JCHMantCorr2.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHMantCorr2.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHMantCorr2.setOpaque(false);
        JCHMantCorr2.setToolTipText("");
        JCHMantCorr2.setText("MANTENIMIENTO CORR/PREV PUNTOS OPERACION");
        JCHMantCorr2.setBounds(new Rectangle(8, 51, 266, 21));
        JCHPartes.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHPartes.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHPartes.setOpaque(false);
        JCHPartes.setToolTipText("");
        JCHPartes.setText("PARTES MOVILES Y SALIENTES");
        JCHPartes.setBounds(new Rectangle(9, 75, 172, 21));
        JCHFaltaHerr.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHFaltaHerr.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHFaltaHerr.setOpaque(false);
        JCHFaltaHerr.setToolTipText("");
        JCHFaltaHerr.setText(
                "FALTA HERRAMIENTAS DE TRABAJO Y ELEMENTOS DE PROTECCION PERSONAL");
        JCHFaltaHerr.setBounds(new Rectangle(485, 4, 391, 21));
        JLBriesgMec.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBriesgMec.setForeground(Color.red);
        JLBriesgMec.setToolTipText("");
        JLBriesgMec.setText("ELEMENTOS DE RIESGO MECANICOS");
        JLBriesgMec.setBounds(new Rectangle(11, 128, 357, 20));
        JCHBajaTension.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHBajaTension.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHBajaTension.setOpaque(false);
        JCHBajaTension.setToolTipText("");
        JCHBajaTension.setText("BAJA TENSION");
        JCHBajaTension.setBounds(new Rectangle(8, 51, 103, 21));
        JLBRiesgElectricos.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBRiesgElectricos.setForeground(Color.red);
        JLBRiesgElectricos.setToolTipText("");
        JLBRiesgElectricos.setText("ELEMENTOS DE RIESGO ELECTRICOS");
        JLBRiesgElectricos.setBounds(new Rectangle(11, 128, 357, 20));
        JCHPisos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHPisos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHPisos.setOpaque(false);
        JCHPisos.setToolTipText("");
        JCHPisos.setText(
                "n\tPISOS, ESCALERAS, BARANDAS, PLATAFORMAS Y ANDAMIOS DEFECTUOSOS "
                + "O EN MAL ESTADO");
        JCHPisos.setBounds(new Rectangle(7, 4, 460, 21));
        JCHMuros.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHMuros.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHMuros.setOpaque(false);
        JCHMuros.setToolTipText("");
        JCHMuros.setText(
                "n\tMUROS, PUERTAS Y VENTANAS DEFECTUOSAS O EN MAL ESTADO");
        JCHMuros.setBounds(new Rectangle(8, 27, 331, 21));
        JCHTechos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHTechos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHTechos.setOpaque(false);
        JCHTechos.setToolTipText("");
        JCHTechos.setText("n\tTECHOS DEFECTUOSOS O EN MAL ESTADO");
        JCHTechos.setBounds(new Rectangle(9, 51, 266, 21));
        JCHSuperficie.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHSuperficie.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHSuperficie.setOpaque(false);
        JCHSuperficie.setToolTipText("");
        JCHSuperficie.setText(
                "n\tSUPERFICIE DEL PISO DESLIZANTE O EN MAL ESTADO");
        JCHSuperficie.setBounds(new Rectangle(9, 74, 281, 21));
        JCHOrden.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHOrden.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHOrden.setOpaque(false);
        JCHOrden.setToolTipText("");
        JCHOrden.setText("n\tFALTA DE ORDEN Y ASEO");
        JCHOrden.setBounds(new Rectangle(485, 4, 150, 21));
        JCHMovRepetitivos.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHMovRepetitivos.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHMovRepetitivos.setOpaque(false);
        JCHMovRepetitivos.setToolTipText("");
        JCHMovRepetitivos.setText("MOV REPETITIVO");
        JCHMovRepetitivos.setBounds(new Rectangle(229, 48, 103, 21));
        JCHdOTACION.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHdOTACION.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHdOTACION.setOpaque(false);
        JCHdOTACION.setToolTipText("");
        JCHdOTACION.setText("FALTA DE DOTACION");
        JCHdOTACION.setBounds(new Rectangle(486, 52, 124, 21));
        JCHExtintores.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHExtintores.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHExtintores.setOpaque(false);
        JCHExtintores.setToolTipText("");
        JCHExtintores.setText("\tUBICACIÓN INADECUADA DE EXTINTORES");
        JCHExtintores.setBounds(new Rectangle(485, 77, 229, 21));
        JLBRiegLocativos.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBRiegLocativos.setForeground(Color.red);
        JLBRiegLocativos.setToolTipText("");
        JLBRiegLocativos.setText("ELEMENTOS DE RIESGO LOCATIVOS");
        JLBRiegLocativos.setBounds(new Rectangle(11, 128, 357, 20));
        JPSeleccFact.setBackground(Color.orange);
        JPSeleccFact.setBorder(BorderFactory.createRaisedBevelBorder());
        JPSeleccFact.setBounds(new Rectangle(248, 78, 375, 119));
        JPSeleccFact.setLayout(null);
        JPSeleccFact.setVisible(false);
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.setBounds(new Rectangle(92, 71, 93, 23));
        JRErgonomic.setBackground(Color.red);
        JRErgonomic.setOpaque(false);
        JRErgonomic.setText("ERGONOMICOS");
        JRErgonomic.setBounds(new Rectangle(8, 4, 106, 23));
        JRErgonomic.addActionListener(new CHistoriaOcup_JRErgonomic_actionAdapter(this));
        JRFisicos.setOpaque(false);
        JRFisicos.setText("FISICOS");
        JRFisicos.setBounds(new Rectangle(8, 31, 106, 23));
        JRFisicos.addActionListener(new CHistoriaOcup_JRFisicos_actionAdapter(this));
        JRQuimic.setOpaque(false);
        JRQuimic.setText("QUIMICOS");
        JRQuimic.setBounds(new Rectangle(9, 58, 106, 23));
        JRQuimic.addActionListener(new CHistoriaOcup_JRQuimic_actionAdapter(this));
        JRFisicoquim.setOpaque(false);
        JRFisicoquim.setText("FISICOQUIMICOS");
        JRFisicoquim.setBounds(new Rectangle(9, 86, 118, 23));
        JRFisicoquim.addActionListener(new CHistoriaOcup_JRFisicoquim_actionAdapter(this));
        JRBiologicos.setOpaque(false);
        JRBiologicos.setText("BIOLOGICOS");
        JRBiologicos.setBounds(new Rectangle(157, 5, 106, 23));
        JRBiologicos.addActionListener(new CHistoriaOcup_JRBiologicos_actionAdapter(this));
        JRPsicolog.setOpaque(false);
        JRPsicolog.setToolTipText("");
        JRPsicolog.setText("PSICOSOCIALES");
        JRPsicolog.setBounds(new Rectangle(156, 34, 106, 23));
        JRPsicolog.addActionListener(new CHistoriaOcup_JRPsicolog_actionAdapter(this));
        JRMecanicos.setOpaque(false);
        JRMecanicos.setToolTipText("");
        JRMecanicos.setText("MECANICOS");
        JRMecanicos.setBounds(new Rectangle(156, 57, 106, 23));
        JRMecanicos.addActionListener(new CHistoriaOcup_JRMecanicos_actionAdapter(this));
        JRElectricos.setOpaque(false);
        JRElectricos.setToolTipText("");
        JRElectricos.setText("ELECTRICOS");
        JRElectricos.setBounds(new Rectangle(157, 88, 106, 23));
        JRElectricos.addActionListener(new CHistoriaOcup_JRElectricos_actionAdapter(this));
        JRLocativos.setOpaque(false);
        JRLocativos.setText("LOCATIVOS");
        JRLocativos.setBounds(new Rectangle(263, 8, 106, 23));
        JRLocativos.addActionListener(new CHistoriaOcup_JRLocativos_actionAdapter(this));
        JCHEmprActual.setBackground(UIManager.getColor(
                "ToolBar.dockingForeground"));
        JCHEmprActual.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHEmprActual.setToolTipText("");
        JCHEmprActual.setText("EMPRESA ACTUAL");
        JCHEmprActual.setBounds(new Rectangle(12, 252, 222, 23));
        this.getContentPane().add(JPAntecedentesFamiliar);
        //Adicionamos al JPAntecedentesFamiliar
        JPAntecedentesFamiliar.add(JBAtrasAF);
        JPAntecedentesFamiliar.add(JBCancelarAF);
        JPAntecedentesFamiliar.add(JBSgteAF); //JPAntecedentesFamiliar.add(JLBnhcAP);
        //JPAntecedentesFamiliar.add(JLBNumhcAP);
        JPAntecedentesFamiliar.add(JTBAntFam);
        JPAntecedentesFamiliar.add(JLBPac);
        JPAntecedentesFamiliar.add(JLBNumhcAF);
        JPAntecedentesFamiliar.add(JLBHistNum);
        JPAntecedentesFamiliar.add(jRadioButton1);
        JPAntFam.add(JPSeleccFact);
        JPSeleccFact.add(JRFisicos);
        JPSeleccFact.add(JRQuimic);
        JPSeleccFact.add(JRFisicoquim);
        JPSeleccFact.add(JRErgonomic);
        JPSeleccFact.add(JRMecanicos);
        JPSeleccFact.add(JRPsicolog);
        JPSeleccFact.add(JRElectricos);
        JPSeleccFact.add(JRLocativos);
        JPSeleccFact.add(JRBiologicos);
        JPAntFam.add(JFTFechaEmprHO);
        JPAntFam.add(JLBFechaEmprHO);
        JPAntFam.add(FechaFinEmprHO);
        JPAntFam.add(JSPHo);
        JPAntFam.add(jCalendar1);
        JPAntFam.add(jCalendar2);
        JPAntFam.add(JFTFechaFinEmrHO);
        JPAntFam.add(JLBEmpresaHO);
        JPAntFam.add(JTFEmprHO);
        JPAntFam.add(JLBCargoHO);
        JPAntFam.add(JTFCargoHO);
        JPAntFam.add(JTFElemRiesgHO);
        JPAntFam.add(JLBTiempo);
        JPAntFam.add(JTFFactorRiesgoHO);
        JPFactorRiesgo.add(JCHLocativos);
        JPFactorRiesgo.add(JCHElectricos);
        JPFactorRiesgo.add(JCHMecanicos);
        JPFactorRiesgo.add(JCHPsicosociales);
        JPFactorRiesgo.add(JCHFisicoQuimicos);
        JPFactorRiesgo.add(JCHBIologicos);
        JPFactorRiesgo.add(JCHQUIMICOS);
        JPFactorRiesgo.add(JCHFisicos);
        JPFactorRiesgo.add(JCHErgonomicos);
        JPAntFam.add(JLBFactorRiesgoHO);
        JPAntFam.add(JPFactorRiesgo);
        JPAntFam.add(JCBFactorRiesg);
        JPAntFam.add(JCBElemRiesgo);
        jPanel1.add(JCHPolvos);
        jPanel1.add(JCHDisenoPuest);
        jPanel1.add(JCHRuido);
        jPanel1.add(JCHIlumDef);
        jPanel1.add(JCHSobreEsf);
        jPanel1.add(JCHOtros1);
        jPanel1.add(JCHRadiacIoniz);
        jPanel1.add(JCHPolvoOrganico);
        jPanel1.add(JCHEPolvoInorg);
        jPanel1.add(JCHPostForz);
        jPanel1.add(JCHIlumExcesiva);
        jPanel1.add(JCHHumoMet);
        jPanel1.add(JCHLevPeso);
        jPanel1.add(JCHRadNoIon);
        jPanel1.add(JCHHumoNoMet);
        jPanel1.add(JCHTempAlta);
        jPanel1.add(JCHTempBaja);
        jPanel1.add(JCHVibrac);
        jPanel1.add(JCHBacterias);
        jPanel1.add(JCHParasitos);
        jPanel1.add(JCHVirus);
        jPanel1.add(JCHHongos);
        jPanel1.add(JCHPelos);
        jPanel1.add(JCHPlumas);
        jPanel1.add(JCHPolen);
        jPanel1.add(JCHAnimVerteb);
        jPanel1.add(JCHAnimInv);
        jPanel1.add(JCHManResAnim);
        jPanel1.add(JCHManResVeget);
        jPanel1.add(JCHCuchillos);
        jPanel1.add(JCHBisturis);
        jPanel1.add(JCHDesIndustr);
        jPanel1.add(JCHInconpatib);
        jPanel1.add(JCHPresSust);
        jPanel1.add(JCHReactivas);
        jPanel1.add(JCHStressLab);
        jPanel1.add(JCHAtencionUsu);
        jPanel1.add(JCHPeligrosCargaLabor);
        jPanel1.add(JCHJorndRot);
        jPanel1.add(JCHJornadExtens);
        jPanel1.add(JCHJeringas);
        jPanel1.add(JCHBasuras);
        jPanel1.add(JCHInestLab);
        jPanel1.add(JCHMantCorr1);
        jPanel1.add(JCHGuardasSeg);
        jPanel1.add(JCHMantCorr2);
        jPanel1.add(JCHPartes);
        jPanel1.add(JCHFaltaHerr);
        jPanel1.add(JCHCargaEst);
        jPanel1.add(JCHAltaTension);
        jPanel1.add(JCHBajaTension);
        jPanel1.add(JCHPisos);
        jPanel1.add(JCHMuros);
        jPanel1.add(JCHTechos);
        jPanel1.add(JCHSuperficie);
        jPanel1.add(JCHOrden);
        jPanel1.add(JCHMarcacion);
        jPanel1.add(JCHdOTACION);
        jPanel1.add(JCHExtintores);
        jPanel1.add(JCHMovRepetitivos);
        JPAntFam.add(JLBElemRiesgFisico);
        JPAntFam.add(JLBElemRiesgoHO);
        JPAntFam.add(jPanel1);
        JPAntFam.add(JLBElemRiesgBiologicos);
        JPAntFam.add(JLBRiesgQuimico);
        JPAntFam.add(JLBRiesgFisicoQuim);
        JPAntFam.add(JLBRiesgPsicoSoc);
        JPAntFam.add(JLBriesgMec);
        JPAntFam.add(JLBRiesgElectricos);
        JPAntFam.add(JLBRiegLocativos);
        JPAntFam.add(JTFTiempoExp);
        JPAntFam.add(JLBTiempoExp);
        JPAntFam.add(JCHEmprActual);
        JSPHo.getViewport().add(JTabHO);
        JTBAntFam.add(JPAntFam, "HISTORIA OCUPACIONAL");
        JTFElemRiesgHO.setVisible(false);
    }

    public void inicioventanaAP(CHistoriaOcup frameAP) {
        objCAF = frameAP;
    }

    public void nombrepaciente(String cadpapell, String cadsapell, String cadpnombr, String cadsnombr) {
        Nombrepac = "";
        Nombrepac = Nombrepac.concat(cadpapell);
        Nombrepac = Nombrepac.concat(" ");
        Nombrepac = Nombrepac.concat(cadsapell);
        Nombrepac = Nombrepac.concat(" ");
        Nombrepac = Nombrepac.concat(cadpnombr);
        Nombrepac = Nombrepac.concat(" ");
        Nombrepac = Nombrepac.concat(cadsnombr);
    }

    /**
     * configurarformatofechaHO
     */
    public void configurarformatofechaHO() {
        //CONFIGURAMOS EL EDITOR DE LA FECHA
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            MaskFormatter mascara1 = new MaskFormatter("##/##/####");
            JFTFechaEmprHO = new JFormattedTextField(mascara);
            JFTFechaFinEmrHO = new JFormattedTextField(mascara1);
            //JTFfechalote.setValue("  /  /    ");
        } catch (ParseException e) {
            System.out.println("problema en la mascara del valor unitario de ls entrada por inventario inicial");
        }

    }

    public void JFTFechaEmprHO_focusGained(FocusEvent e) {
        jCalendar1.setVisible(true);
        JFTFechaFinEmrHO.setVisible(false);
        FechaFinEmprHO.setVisible(false);
        JLBFechaEmprHO.setVisible(false);
        JFTFechaEmprHO.setVisible(false);
        JLBCargoHO.setVisible(false);
        JTFCargoHO.setVisible(false);
        JLBElemRiesgoHO.setVisible(false);
        JCBElemRiesgo.setVisible(false);
        JTFFactorRiesgoHO.setVisible(true);
        JFTFechaEmprHO.requestFocus();
    }

    public void jCalendar1_mouseReleased(MouseEvent e) {
        String patron = "dd/MM/yyyy";
        SimpleDateFormat formato2 = new SimpleDateFormat(patron);
        fechainiHO = jCalendar1.getDate();
        sFechaHO = formato2.format(fechainiHO);
        JFTFechaEmprHO.setText(sFechaHO);
        jCalendar1.setVisible(false);
        JFTFechaEmprHO.setVisible(true);
        JFTFechaFinEmrHO.setVisible(true);
        FechaFinEmprHO.setVisible(true);
        JLBCargoHO.setVisible(true);
        JTFCargoHO.setVisible(true);
        JTFFactorRiesgoHO.setVisible(true);
        JLBFechaEmprHO.setVisible(true);
        JLBElemRiesgoHO.setVisible(true);
        //JCBElemRiesgo.setVisible(true);
    }

    public void JFTFechaFinEmrHO_focusGained(FocusEvent e) {
        jCalendar2.setVisible(true);
        JFTFechaFinEmrHO.setVisible(false);
        FechaFinEmprHO.setVisible(false);
        JLBCargoHO.setVisible(false);
        JTFCargoHO.setVisible(false);
        JLBElemRiesgoHO.setVisible(false);
        //JCBElemRiesgo.setVisible(false);
    }

    public void jCalendar2_mouseReleased(MouseEvent e) {
        String patron = "dd/MM/yyyy";
        SimpleDateFormat formato2 = new SimpleDateFormat(patron);
        fechafinHO = jCalendar2.getDate();
        sFechaHO = formato2.format(fechafinHO);
        JFTFechaFinEmrHO.setText(sFechaHO);
        jCalendar2.setVisible(false);
        JFTFechaFinEmrHO.setVisible(true);
        FechaFinEmprHO.setVisible(true);
        JLBCargoHO.setVisible(true);
        JTFCargoHO.setVisible(true);
        JLBElemRiesgoHO.setVisible(true);
        //JCBElemRiesgo.setVisible(true);
        //calculartiempo();
    }

    /**
     * anadirentradaHO
     */
    public void anadirentradaHO() {
        CBaseHO dato = new CBaseHO("", "", "", "", "", "", false, "");
        modeloho.anhadeentrada(dato);
    }

    public void JTFTiempoExp_keyReleased(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_ENTER) {
            llenarmodeloHO(ifila, JTFEmprHO.getText(), validHO.cambiarformatofecha(JFTFechaEmprHO.getText()), validHO.cambiarformatofecha(JFTFechaFinEmrHO.getText()), JTFFactorRiesgoHO.getText(), JTFCargoHO.getText(), validHO.evaluarcombocadena(JCBFactorRiesg), JCHEmprActual.isSelected(), JTFTiempoExp.getText());
            bufferfr(ifila);
            bufferele(ifila);
            limpiarfr();
            limpiarele();
            ifila = ifila + 1;
            //bloqueofactor();
        } //if c
        else {
            procactualizarmodHO(e);
        }//fin del else
        ocultarelemtodos();
    }//fin metodo

    /**
     * bufferfr
     */
    public void bufferfr(int ifila) {
        //int k;
        //for(k=0;k<9;k++)
        fact[ifila][0] = procchexkbox(JCHErgonomicos);
        fact[ifila][1] = procchexkbox(JCHFisicos);
        fact[ifila][2] = procchexkbox(JCHQUIMICOS);
        fact[ifila][3] = procchexkbox(JCHBIologicos);
        fact[ifila][4] = procchexkbox(JCHFisicoQuimicos);
        fact[ifila][5] = procchexkbox(JCHPsicosociales);
        fact[ifila][6] = procchexkbox(JCHMecanicos);
        fact[ifila][7] = procchexkbox(JCHElectricos);
        fact[ifila][8] = procchexkbox(JCHLocativos);
    }

    /**
     * llenarmodeloHO
     */
    public void llenarmodeloHO(int ifila, String nombremprHO, String FechIniHO, String FechFinHO, String TiempoEmprHO, String CargoHO, String RiesgoHO, Boolean EmpresaActualHO, String TiempoHO) {
        modeloho.setValueAt(nombremprHO, ifila, 0);
        modeloho.setValueAt(FechIniHO, ifila, 1);
        modeloho.setValueAt(FechFinHO, ifila, 2);
        modeloho.setValueAt(TiempoEmprHO, ifila, 3);
        modeloho.setValueAt(CargoHO, ifila, 4);
        modeloho.setValueAt(RiesgoHO, ifila, 5);
        modeloho.setValueAt(EmpresaActualHO, ifila, 6);
        modeloho.setValueAt(TiempoHO, ifila, 7);
        anadirentradaHO();
        limpiardatos();
        // indicecombos();
    }

    /**
     * limpiardatos
     */
    public void limpiardatos() {
        JTFEmprHO.setText("");
        JFTFechaEmprHO.setText("");
        JFTFechaFinEmrHO.setText("");
        //configurarformatofechaHO();
        JTFCargoHO.setText("");
        JTFFactorRiesgoHO.setText("");
        JTFFactorRiesgoHO.setText("");
        JCHEmprActual.setSelected(false);
        JTFTiempoExp.setText("");
        JTFEmprHO.requestFocus();
    }

    public void JTabHO_mouseReleased(MouseEvent e) {
        Object vartabHO;
        String SvartabHO = "";
        vartabHO = modeloho.getValueAt(JTabHO.getSelectedRow(), 0);
        JTFEmprHO.setText(SvartabHO.valueOf(vartabHO));
        vartabHO = modeloho.getValueAt(JTabHO.getSelectedRow(), 1);
        SvartabHO = SvartabHO.valueOf(vartabHO);
        //SvartabHO=validHO.cambiarformatofechaotro(SvartabHO);
        JFTFechaEmprHO.setText(SvartabHO);
        vartabHO = modeloho.getValueAt(JTabHO.getSelectedRow(), 2);
        //SvartabHO=validHO.cambiarformatofechaotro(SvartabHO);
        SvartabHO = SvartabHO.valueOf(vartabHO);
        JFTFechaFinEmrHO.setText(SvartabHO);
        vartabHO = modeloho.getValueAt(JTabHO.getSelectedRow(), 3);
        JTFFactorRiesgoHO.setText(SvartabHO.valueOf(vartabHO));
        vartabHO = modeloho.getValueAt(JTabHO.getSelectedRow(), 4);
        JTFCargoHO.setText(SvartabHO.valueOf(vartabHO));
        vartabHO = modeloho.getValueAt(JTabHO.getSelectedRow(), 5);
        JCBFactorRiesg.setSelectedItem(vartabHO);
        //JTFFactorRiesgoHO.setText(SvartabHO.valueOf(vartabHO));
        vartabHO = modeloho.getValueAt(JTabHO.getSelectedRow(), 6);
        JCBElemRiesgo.setSelectedItem(vartabHO);
        //JTFElemRiesgHO.setText(SvartabHO.valueOf(vartabHO));
        vartabHO = modeloho.getValueAt(JTabHO.getSelectedRow(), 7);
        JTFTiempoExp.setText(SvartabHO.valueOf(vartabHO));
        llenareleriesgo();
        ocultarelemtodos();
        llenarseleccfact();
        JPSeleccFact.setVisible(true);
        //llenarfactorriesgo();

    }

    /**
     * llenarfactorriesgo
     */
    public void llenarfactorriesgo(JCheckBox JChvar, int numcol) {
        /*String cadenafr;
        cadenafr="select *from factor_riesgo ORDER BY factor_riesgo.Nombre_FR";
        validHO.llenarcombos(cadenafr,JCBFactorRiesg,2);(boolean)fact[JTabHO.getSelectedRow()][0]*/
        JChvar.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][numcol]));
        /* JCHFisicos.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][1]));
        JCHQUIMICOS.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][2]));
        JCHBIologicos.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][3]));
        JCHFisicoQuimicos.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][4]));
        JCHPsicosociales.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][5]));
        JCHMecanicos.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][6]));*/
        //JCHMecanicos.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][7]));
        /*  JCHElectricos.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][7]));
        JCHLocativos.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][8]));*/
    }

    /**
     * llenareleriesgo
     */
    public void llenareleriesgo() {
        /*String cadenaer;
        cadenaer="select *from elemento_riesgo ORDER BY elemento_riesgo.nombre_ElemRiesgo";
        validHO.llenarcombos(cadenaer,JCBElemRiesgo,2);*/
        JCHDisenoPuest.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][0]));//0//
        JCHSobreEsf.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][1]));//1//
        JCHPostForz.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][2]));//2//
        JCHOtros1.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][3]));//3//
        JCHLevPeso.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][4]));//4//
        JCHMovRepetitivos.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][5]));//5//
        JCHRuido.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][6]));//6//
        JCHIlumDef.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][7]));//7//
        JCHIlumExcesiva.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][8]));//8//
        JCHRadiacIoniz.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][9]));//9//
        JCHRadNoIon.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][10]));//10//
        JCHTempBaja.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][11]));//11//
        JCHTempAlta.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][12]));//12//
        JCHVibrac.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][13]));//13//
        JCHPolvoOrganico.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][14]));//14//
        JCHEPolvoInorg.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][15]));//15//
        JCHHumoMet.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][16]));//16//
        JCHHumoNoMet.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][17]));//17//
        JCHBacterias.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][18]));//18//
        JCHParasitos.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][19]));//19//
        JCHVirus.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][20]));//20//
        JCHHongos.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][21]));//21//
        JCHPelos.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][22]));//22//
        JCHPlumas.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][23]));//23//
        JCHPolen.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][24]));//24//
        JCHAnimVerteb.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][25]));//25//
        JCHAnimInv.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][26]));//26//
        JCHManResAnim.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][27]));//27//
        JCHManResVeget.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][28]));//28//
        JCHCuchillos.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][29]));//29//
        JCHJeringas.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][30]));//30//
        JCHBisturis.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][31]));//31//
        JCHDesIndustr.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][32]));//32//
        JCHBasuras.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][33]));//33//
        JCHInconpatib.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][34]));//34//
        JCHPresSust.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][35]));//35//
        JCHReactivas.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][36]));//36//
        JCHStressLab.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][37]));//37//
        JCHAtencionUsu.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][38]));//38//
        JCHPeligrosCargaLabor.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][39]));//39//
        JCHJorndRot.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][40]));//40//
        JCHJornadExtens.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][41]));//41//
        JCHInestLab.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][42]));//42//
        JCHMantCorr1.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][43]));//43//
        JCHGuardasSeg.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][44]));//44//
        JCHMantCorr2.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][45]));//45//
        JCHPartes.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][46]));//46//
        JCHFaltaHerr.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][47]));//47//
        JCHCargaEst.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][48]));//48//
        JCHAltaTension.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][49]));//49//
        JCHBajaTension.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][50]));//50//
        JCHPisos.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][51]));//51//
        JCHMuros.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][52]));//52//
        JCHTechos.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][53]));//53//
        JCHSuperficie.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][54]));//54//
        JCHOrden.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][55]));//55//
        JCHMarcacion.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][56]));//56//
        JCHdOTACION.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][57]));//57//
        JCHExtintores.setSelected(procllenatfr(elem[JTabHO.getSelectedRow()][58]));//58//
    }

    public void JBSgteAF_actionPerformed(ActionEvent e) {
        validarbajar();
        // validarnulos();
    }

    /**
     * validarnulos
     */
    public void validarnulos() {
        CIngreso frameingreso;
        CHistoriaOcup frameho;
        frameho = (CHistoriaOcup) framehoOBJ;
        frameho.setVisible(false);
        JDesktopPane JDPIngresoHO = new JDesktopPane();
        frameingreso = (CIngreso) frameHOOBJ;
        JDPIngresoHO = (JDesktopPane) JDPIngresoobj;
        if (swgte == 0) {
            CEnfermedadProf frameep = new CEnfermedadProf(obotactualizarHO, numingredicEP, swedicingrho, Nombrepac, frameho, varnhc, JDPIngresoHO, frameingreso, objppalho);
            frameep.setBounds(0, 2, 1010, 600);
            frameep.setTitle("ENFERMEDAD PROFESIONAL");
            JDPIngresoHO.add(frameep, new Integer(1));
            frameep.setLocation(5, 55);
            frameep.show();
            frameep.setVisible(true);
            frameep.inicializarventanaEP(frameep);
            swgte = 1;
            objetoenfprofesional = frameep;
            if (swedicingrho == 1) {
                String cadsqledicEP;;
                int ifila = 0;
                Connection con2 = Cconsql.getConnection();
                cadsqledicEP = "SELECT ingreso.id_ingreso, enfermedad_profesional.nombrempresa_EP, enfermedad_profesional.fecha_EP, enfermedad_profesional.diagnostico_EP, enfermedad_profesional.medico_EP FROM ingreso INNER JOIN enfermedad_profesional ON ingreso.id_ingreso = enfermedad_profesional.idingreso_EP WHERE ingreso.id_ingreso=" + numingredicEP;
                try {
                    TSentenciaconsultaEP = con2.createStatement();
                    RconsultaEP = TSentenciaconsultaEP.executeQuery(cadsqledicEP);
                    while (RconsultaEP.next()) {
                        if (RconsultaEP.getString(2).compareTo("") != 0) {
                            frameep.llenarmodeloEP(ifila, RconsultaEP.getString(2), RconsultaEP.getString(3), RconsultaEP.getString(4), RconsultaEP.getString(5));
                            ifila = ifila + 1;
                        }
                    }
                } catch (SQLException e1) {
                    e1.getMessage();
                    cad1 = "NO SE PUDO EJECUTAR LA CONSULTA";
                    cad2 = "PROBLEMAS CON LOS DATOS DE ENFERMEDAD PROFESIONAL EN EDICION";
                    validHO.mensajeconfirmacion(cad1, cad2);
                }//cierra el catch

            }
            //frameep.edp
        } else {
            CEnfermedadProf frameep;
            frameep = (CEnfermedadProf) objetoenfprofesional;
            // ObjectCingreso.setVisible(false);
            frameep.setVisible(true);
        }
        Cconsql.CerrarConexion();
    }

    /**
     * cerrarventanaHO
     */
    public void inilizarventanaHO(CHistoriaOcup frameho) {
        framehoOBJ = frameho;
    }

    /**
     * indicecombos
     */
    public void indicecombos() {
        JCBFactorRiesg.setSelectedIndex(0);
        JCBElemRiesgo.setSelectedIndex(0);
    }

    public void JTFCargoHO_actionPerformed(ActionEvent e) {

    }

    public void JTFCargoHO_keyReleased(KeyEvent e) {
        procactualizarmodHO(e);

    }

    /**
     * actualizarmodeloHO
     */
    public void actualizarmodeloHO(String nombremprHO, String FechIniHO, String FechFinHO, String TiempoEmprHO, String CargoHO, String RiesgoHO, String ElemRiesgoHO, String TiempoHO) {
        modeloho.setValueAt(nombremprHO, JTabHO.getSelectedRow(), 0);
        modeloho.setValueAt(FechIniHO, JTabHO.getSelectedRow(), 1);
        modeloho.setValueAt(FechFinHO, JTabHO.getSelectedRow(), 2);
        modeloho.setValueAt(TiempoEmprHO, JTabHO.getSelectedRow(), 3);
        modeloho.setValueAt(CargoHO, JTabHO.getSelectedRow(), 4);
        modeloho.setValueAt(RiesgoHO, JTabHO.getSelectedRow(), 5);
        modeloho.setValueAt(ElemRiesgoHO, JTabHO.getSelectedRow(), 6);
        modeloho.setValueAt(TiempoHO, JTabHO.getSelectedRow(), 7);
        limpiardatos();
        //indicecombos();
    }

    public void JTFEmprHO_keyReleased(KeyEvent e) {
        procactualizarmodHO(e);
    }

    /**
     * procactualizarmodHO
     */
    public void procactualizarmodHO(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_F3) {
            actualizarmodeloHO(JTFEmprHO.getText(), JFTFechaEmprHO.getText(), JFTFechaFinEmrHO.getText(), JTFFactorRiesgoHO.getText(), JTFCargoHO.getText(), validHO.evaluarcombocadena(JCBFactorRiesg), validHO.evaluarcombocadena(JCBElemRiesgo), JTFTiempoExp.getText());
            bufferfr(JTabHO.getSelectedRow());
            bufferele(JTabHO.getSelectedRow());
            limpiarfr();
            limpiarele();

            //ifila=ifila+1;
        } //if c

    }

    public void JFTFechaEmprHO_keyReleased(KeyEvent e) {
        procactualizarmodHO(e);
    }

    public void JFTFechaFinEmrHO_keyReleased(KeyEvent e) {
        procactualizarmodHO(e);
    }

    public void JTFFactorRiesgoHO_keyReleased(KeyEvent e) {
        procactualizarmodHO(e);
    }

    public void JCBFactorRiesg_keyReleased(KeyEvent e) {
        procactualizarmodHO(e);
    }

    public void JCBElemRiesgo_keyReleased(KeyEvent e) {
        procactualizarmodHO(e);
    }

    /**
     * cerarfactor
     */
    public void cerarfactor() {
        int fil, col;
        for (fil = 0; fil < 10; fil++) {
            for (col = 0; col < 9; col++) {
                fact[fil][col] = 0;
            }
        }
    }

    /**
     * cerarelem
     */
    public void cerarelem() {
        int fil, col;
        for (fil = 0; fil < 10; fil++) {
            for (col = 0; col < 59; col++) {
                elem[fil][col] = 0;
            }
        }

    }

    /**
     * procchexkbox
     */
    public int procchexkbox(JCheckBox varJCheckBox) {
        int var = 0;
        if (varJCheckBox.isSelected() == true) {
            var = 1;
        }
        return var;
    }

    /**
     * bufferele
     */
    public void bufferele(int ifila) {

        //
        elem[ifila][0] = procchexkbox(JCHDisenoPuest);//0
        elem[ifila][1] = procchexkbox(JCHSobreEsf);//1
        elem[ifila][2] = procchexkbox(JCHPostForz);//2
        elem[ifila][3] = procchexkbox(JCHOtros1);//3
        elem[ifila][4] = procchexkbox(JCHLevPeso);//4
        elem[ifila][5] = procchexkbox(JCHMovRepetitivos);//5
        elem[ifila][6] = procchexkbox(JCHRuido);//6
        elem[ifila][7] = procchexkbox(JCHIlumDef);//7
        elem[ifila][8] = procchexkbox(JCHIlumExcesiva);//8
        elem[ifila][9] = procchexkbox(JCHRadiacIoniz);//9
        elem[ifila][10] = procchexkbox(JCHRadNoIon);//10
        elem[ifila][11] = procchexkbox(JCHTempBaja);//11
        elem[ifila][12] = procchexkbox(JCHTempAlta);//12
        elem[ifila][13] = procchexkbox(JCHVibrac);//13
        elem[ifila][14] = procchexkbox(JCHPolvoOrganico);//14
        elem[ifila][15] = procchexkbox(JCHEPolvoInorg);//15
        elem[ifila][16] = procchexkbox(JCHHumoMet);//16
        elem[ifila][17] = procchexkbox(JCHHumoNoMet);//17
        elem[ifila][18] = procchexkbox(JCHBacterias);//18
        elem[ifila][19] = procchexkbox(JCHParasitos);//19
        elem[ifila][20] = procchexkbox(JCHVirus);//20
        elem[ifila][21] = procchexkbox(JCHHongos);//21
        elem[ifila][22] = procchexkbox(JCHPelos);//22
        elem[ifila][23] = procchexkbox(JCHPlumas);//23
        elem[ifila][24] = procchexkbox(JCHPolen);//24
        elem[ifila][25] = procchexkbox(JCHAnimVerteb);//25
        elem[ifila][26] = procchexkbox(JCHAnimInv);//26
        elem[ifila][27] = procchexkbox(JCHManResAnim);//27
        elem[ifila][28] = procchexkbox(JCHManResVeget);//28
        elem[ifila][29] = procchexkbox(JCHCuchillos);//29
        elem[ifila][30] = procchexkbox(JCHJeringas);//30
        elem[ifila][31] = procchexkbox(JCHBisturis);//31
        elem[ifila][32] = procchexkbox(JCHDesIndustr);//32
        elem[ifila][33] = procchexkbox(JCHBasuras);//33
        elem[ifila][34] = procchexkbox(JCHInconpatib);//34
        elem[ifila][35] = procchexkbox(JCHPresSust);//35
        elem[ifila][36] = procchexkbox(JCHReactivas);//36
        elem[ifila][37] = procchexkbox(JCHStressLab);//37
        elem[ifila][38] = procchexkbox(JCHAtencionUsu);//38
        elem[ifila][39] = procchexkbox(JCHPeligrosCargaLabor);//39
        elem[ifila][40] = procchexkbox(JCHJorndRot);//40
        elem[ifila][41] = procchexkbox(JCHJornadExtens);//41
        elem[ifila][42] = procchexkbox(JCHInestLab);//42
        elem[ifila][43] = procchexkbox(JCHMantCorr1);//43
        elem[ifila][44] = procchexkbox(JCHGuardasSeg);//44
        elem[ifila][45] = procchexkbox(JCHMantCorr2);//45
        elem[ifila][46] = procchexkbox(JCHPartes);//46
        elem[ifila][47] = procchexkbox(JCHFaltaHerr);//47
        elem[ifila][48] = procchexkbox(JCHCargaEst);//48
        elem[ifila][49] = procchexkbox(JCHAltaTension);//49
        elem[ifila][50] = procchexkbox(JCHBajaTension);//50
        elem[ifila][51] = procchexkbox(JCHPisos);//51
        elem[ifila][52] = procchexkbox(JCHMuros);//52
        elem[ifila][53] = procchexkbox(JCHTechos);//53
        elem[ifila][54] = procchexkbox(JCHSuperficie);//54
        elem[ifila][55] = procchexkbox(JCHOrden);//55
        elem[ifila][56] = procchexkbox(JCHMarcacion);//56
        elem[ifila][57] = procchexkbox(JCHdOTACION);//57
        elem[ifila][58] = procchexkbox(JCHExtintores);//58

    }

    /**
     * limpiarfr
     */
    public void limpiarfr() {
        JCHErgonomicos.setSelected(false);
        JCHFisicos.setSelected(false);
        JCHQUIMICOS.setSelected(false);
        JCHBIologicos.setSelected(false);
        JCHFisicoQuimicos.setSelected(false);
        JCHPsicosociales.setSelected(false);
        JCHMecanicos.setSelected(false);
        JCHMecanicos.setSelected(false);
        JCHElectricos.setSelected(false);
        JCHLocativos.setSelected(false);
    }

    /**
     * limpiarele
     */
    public void limpiarele() {
        JCHDisenoPuest.setSelected(false);// 0
        JCHSobreEsf.setSelected(false);//1
        JCHPostForz.setSelected(false);//2
        JCHOtros1.setSelected(false);//3
        JCHLevPeso.setSelected(false);//4
        JCHMovRepetitivos.setSelected(false);//5
        JCHRuido.setSelected(false);//6
        JCHIlumDef.setSelected(false);//7
        JCHIlumExcesiva.setSelected(false);//8
        JCHRadiacIoniz.setSelected(false);//9
        JCHRadNoIon.setSelected(false);//10
        JCHTempBaja.setSelected(false);//11
        JCHTempAlta.setSelected(false);//12
        JCHVibrac.setSelected(false);//13
        JCHPolvoOrganico.setSelected(false);//14
        JCHEPolvoInorg.setSelected(false);//15
        JCHHumoMet.setSelected(false);//16
        JCHHumoNoMet.setSelected(false);//17
        JCHBacterias.setSelected(false);//18
        JCHParasitos.setSelected(false);//19
        JCHVirus.setSelected(false);//20
        JCHHongos.setSelected(false);//21
        JCHPelos.setSelected(false);//22
        JCHPlumas.setSelected(false);//23
        JCHPolen.setSelected(false);//24
        JCHAnimVerteb.setSelected(false);//25
        JCHAnimInv.setSelected(false);//26
        JCHManResAnim.setSelected(false);//27
        JCHManResVeget.setSelected(false);//28
        JCHCuchillos.setSelected(false);//29
        JCHJeringas.setSelected(false);//30
        JCHBisturis.setSelected(false);//31
        JCHDesIndustr.setSelected(false);//32
        JCHInconpatib.setSelected(false);//33
        JCHPresSust.setSelected(false);//34
        JCHReactivas.setSelected(false);//35
        JCHStressLab.setSelected(false);//36
        JCHAtencionUsu.setSelected(false);//37
        JCHPeligrosCargaLabor.setSelected(false);//38
        JCHJorndRot.setSelected(false);//39
        JCHJornadExtens.setSelected(false);//40
        JCHInestLab.setSelected(false);//41
        JCHGuardasSeg.setSelected(false);//42
        JCHMantCorr2.setSelected(false);//43
        JCHMantCorr1.setSelected(false);//44
        JCHPartes.setSelected(false);//45
        JCHFaltaHerr.setSelected(false);//46
        JCHCargaEst.setSelected(false);//47
        JCHAltaTension.setSelected(false);//48
        JCHBajaTension.setSelected(false);//49
        JCHPisos.setSelected(false);//50
        JCHMuros.setSelected(false);//51
        JCHTechos.setSelected(false);//52
        JCHSuperficie.setSelected(false);//53
        JCHOrden.setSelected(false);//54
        JCHMarcacion.setSelected(false);//55
        JCHdOTACION.setSelected(false);//56
        JCHExtintores.setSelected(false);//57
        JCHBasuras.setSelected(false);//57

    }

    /**
     * procllenatfr
     */
    public boolean procllenatfr(int numfr) {
        boolean varfr = false;
        if (numfr == 1) {
            varfr = true;
        }
        return varfr;
    }

    public void JCHParasitos_actionPerformed(ActionEvent e) {

    }

    /**
     * ocultarelemtodos
     */
    public void ocultarelemtodos() {
        JCHDisenoPuest.setVisible(false);
        JCHSobreEsf.setVisible(false);
        JCHPostForz.setVisible(false);
        JCHOtros1.setVisible(false);
        JCHLevPeso.setVisible(false);
        JCHMantCorr1.setVisible(false);
        JCHEPolvoInorg.setVisible(false);
        JCHHumoNoMet.setVisible(false);
        JCHBacterias.setVisible(false);
        JCHParasitos.setVisible(false);
        JCHTempAlta.setVisible(false);
        JCHCargaEst.setVisible(false);
        JCHPolvoOrganico.setVisible(false);
        JCHIlumDef.setVisible(false);
        JCHHongos.setVisible(false);
        JCHAnimVerteb.setVisible(false);
        JCHInconpatib.setVisible(false);
        JCHIlumExcesiva.setVisible(false);
        JCHRadiacIoniz.setVisible(false);
        JCHVibrac.setVisible(false);
        JCHVirus.setVisible(false);
        JCHAltaTension.setVisible(false);
        JCHAnimInv.setVisible(false);
        JCHRuido.setVisible(false);
        JCHPlumas.setVisible(false);
        JCHMarcacion.setVisible(false);
        JCHRadNoIon.setVisible(false);
        JCHHumoMet.setVisible(false);
        JCHPelos.setVisible(false);
        JCHPolen.setVisible(false);
        JCHTempBaja.setVisible(false);
        JCHAnimInv.setVisible(false);
        JCHManResAnim.setVisible(false);
        JCHManResVeget.setVisible(false);
        JCHCuchillos.setVisible(false);
        JCHJeringas.setVisible(false);
        JCHBisturis.setVisible(false);
        JCHDesIndustr.setVisible(false);
        JCHBasuras.setVisible(false);
        JCHReactivas.setVisible(false);
        JCHInconpatib.setVisible(false);
        JCHPresSust.setVisible(false);
        JCHInestLab.setVisible(false);
        JCHStressLab.setVisible(false);
        JCHAtencionUsu.setVisible(false);
        JCHJorndRot.setVisible(false);
        JCHJornadExtens.setVisible(false);
        JCHPeligrosCargaLabor.setVisible(false);
        JLBriesgMec.setVisible(false);
        JCHFaltaHerr.setVisible(false);
        JCHPartes.setVisible(false);
        JCHMantCorr2.setVisible(false);
        JCHGuardasSeg.setVisible(false);
        JCHMantCorr1.setVisible(false);
        JCHBajaTension.setVisible(false);
        JCHAltaTension.setVisible(false);
        JCHCargaEst.setVisible(false);
        JCHExtintores.setVisible(false);
        JCHdOTACION.setVisible(false);
        JCHMarcacion.setVisible(false);
        JCHOrden.setVisible(false);
        JCHSuperficie.setVisible(false);
        JCHTechos.setVisible(false);
        JCHMuros.setVisible(false);
        JCHPisos.setVisible(false);
        JCHMovRepetitivos.setVisible(false);
        //
        JLBElemRiesgoHO.setVisible(false);
        JLBElemRiesgBiologicos.setVisible(false);
        JLBElemRiesgFisico.setVisible(false);
        JLBRiesgQuimico.setVisible(false);
        JLBRiesgFisicoQuim.setVisible(false);
        JLBRiesgPsicoSoc.setVisible(false);
        JLBriesgMec.setVisible(false);
        JLBRiesgElectricos.setVisible(false);
        JLBRiegLocativos.setVisible(false);
    }

    public void JCHErgonomicos_actionPerformed(ActionEvent e) {
        procergonomic();
    }

    public void JCHFisicos_actionPerformed(ActionEvent e) {
        procesofisico();
    }

    public void JCHQUIMICOS_actionPerformed(ActionEvent e) {
        procesoquimico();
    }

    public void JCHBIologicos_actionPerformed(ActionEvent e) {
        procesobiologico();
    }

    public void JCHFisicoQuimicos_actionPerformed(ActionEvent e) {
        procesofisicoquimico();
    }

    public void JCHPsicosociales_actionPerformed(ActionEvent e) {
        procesopsico();
    }

    public void JCHMecanicos_actionPerformed(ActionEvent e) {
        procesomecanico();
    }

    public void JCHElectricos_actionPerformed(ActionEvent e) {
        procesoelectrico();
    }

    public void JCHLocativos_actionPerformed(ActionEvent e) {
        procesolocativo();
    }

    public void JRErgonomic_actionPerformed(ActionEvent e) {
        procradio(JRErgonomic, JRFisicos, JRQuimic, JRFisicoquim, JRBiologicos, JRPsicolog, JRMecanicos, JRElectricos, JRLocativos);
        llenarfactorriesgo(JCHErgonomicos, 0);
        //llenareleriesgo();
        JPSeleccFact.setVisible(false);
        procergonomic();
    }

    /**
     * procradio
     */
    public void procradio(JRadioButton jr1, JRadioButton jr2, JRadioButton jr3, JRadioButton jr4, JRadioButton jr5, JRadioButton jr6, JRadioButton jr7, JRadioButton jr8, JRadioButton jr9) {
        jr1.setSelected(true);
        jr2.setSelected(false);
        jr3.setSelected(false);
        jr4.setSelected(false);
        jr5.setSelected(false);
        jr6.setSelected(false);
        jr7.setSelected(false);
        jr8.setSelected(false);
        jr9.setSelected(false);
    }

    /**
     * procergonomic
     */
    public void procergonomic() {
        ocultarelemtodos();
        JLBElemRiesgoHO.setVisible(true);
        JCHDisenoPuest.setVisible(true);
        JCHSobreEsf.setVisible(true);
        JCHPostForz.setVisible(true);
        JCHOtros1.setVisible(true);
        JCHLevPeso.setVisible(true);
        JCHMovRepetitivos.setVisible(true);
        JCHErgonomicos.setEnabled(true);
    }

    /**
     * bloqueofactor
     */
    public void bloqueofactor() {
        JCHErgonomicos.setEnabled(false);
        JCHFisicos.setEnabled(false);
        JCHQUIMICOS.setEnabled(false);
        JCHBIologicos.setEnabled(false);
        JCHFisicoQuimicos.setEnabled(false);
        JCHPsicosociales.setEnabled(false);
        JCHMecanicos.setEnabled(false);
        //JCHMecanicos.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][7]));
        JCHElectricos.setEnabled(false);
        JCHLocativos.setEnabled(false);
    }

    public void JRFisicos_actionPerformed(ActionEvent e) {
        procradio(JRFisicos, JRErgonomic, JRQuimic, JRFisicoquim, JRBiologicos, JRPsicolog, JRMecanicos, JRElectricos, JRLocativos);
        llenarfactorriesgo(JCHFisicos, 1);
        //llenareleriesgo();
        JPSeleccFact.setVisible(false);
        procesofisico();

    }

    /**
     * procesofisico
     */
    public void procesofisico() {
        ocultarelemtodos();
        JLBElemRiesgFisico.setVisible(true);
        JCHVibrac.setVisible(true);
        JCHRuido.setVisible(true);
        JCHIlumDef.setVisible(true);
        JCHTempAlta.setVisible(true);
        JCHRadNoIon.setVisible(true);
        JCHTempBaja.setVisible(true);
        JCHRadiacIoniz.setVisible(true);
        JCHIlumExcesiva.setVisible(true);
        JCHFisicos.setEnabled(true);
    }

    public void JRQuimic_actionPerformed(ActionEvent e) {
        procradio(JRQuimic, JRFisicos, JRErgonomic, JRFisicoquim, JRBiologicos, JRPsicolog, JRMecanicos, JRElectricos, JRLocativos);
        llenarfactorriesgo(JCHQUIMICOS, 2);
        //llenareleriesgo();
        JPSeleccFact.setVisible(false);
        procesoquimico();
    }

    /**
     * procesoquimico
     */
    public void procesoquimico() {
        ocultarelemtodos();
        JLBRiesgQuimico.setVisible(true);
        JCHHumoMet.setVisible(true);
        JCHPolvoOrganico.setVisible(true);
        JCHHumoNoMet.setVisible(true);
        JCHEPolvoInorg.setVisible(true);
        JCHQUIMICOS.setEnabled(true);
    }

    public void JRFisicoquim_actionPerformed(ActionEvent e) {
        procradio(JRFisicoquim, JRQuimic, JRFisicos, JRErgonomic, JRBiologicos, JRPsicolog, JRMecanicos, JRElectricos, JRLocativos);
        llenarfactorriesgo(JCHFisicoQuimicos, 3);
        //llenareleriesgo();
        JPSeleccFact.setVisible(false);
        procesofisicoquimico();
    }

    /**
     * procesofisicoquimico
     */
    public void procesofisicoquimico() {
        ocultarelemtodos();
        JLBRiesgFisicoQuim.setVisible(true);
        JCHReactivas.setVisible(true);
        JCHInconpatib.setVisible(true);
        JCHPresSust.setVisible(true);
        JCHFisicoQuimicos.setEnabled(true);
    }

    public void JRBiologicos_actionPerformed(ActionEvent e) {
        procradio(JRBiologicos, JRFisicoquim, JRQuimic, JRFisicos, JRErgonomic, JRPsicolog, JRMecanicos, JRElectricos, JRLocativos);
        llenarfactorriesgo(JCHBIologicos, 4);
        //llenareleriesgo();
        JPSeleccFact.setVisible(false);
        procesobiologico();
    }

    /**
     * procesobiologico
     */
    public void procesobiologico() {
        ocultarelemtodos();
        JLBElemRiesgBiologicos.setVisible(true);
        JCHHongos.setVisible(true);
        JCHVirus.setVisible(true);
        JCHBacterias.setVisible(true);
        JCHAnimVerteb.setVisible(true);
        JCHAnimInv.setVisible(true);
        JCHPelos.setVisible(true);
        JCHPolen.setVisible(true);
        JCHPlumas.setVisible(true);
        JCHParasitos.setVisible(true);
        JCHManResAnim.setVisible(true);
        JCHManResVeget.setVisible(true);
        JCHCuchillos.setVisible(true);
        JCHJeringas.setVisible(true);
        JCHBisturis.setVisible(true);
        JCHDesIndustr.setVisible(true);
        JCHBasuras.setVisible(true);
        JCHBIologicos.setEnabled(true);

    }

    public void JRPsicolog_actionPerformed(ActionEvent e) {
        procradio(JRPsicolog, JRBiologicos, JRFisicoquim, JRQuimic, JRFisicos, JRErgonomic, JRMecanicos, JRElectricos, JRLocativos);
        llenarfactorriesgo(JCHPsicosociales, 5);
        //llenareleriesgo();
        JPSeleccFact.setVisible(false);
        procesopsico();
    }

    /**
     * procesopsico
     */
    public void procesopsico() {
        ocultarelemtodos();
        JLBRiesgPsicoSoc.setVisible(true);
        JCHInestLab.setVisible(true);
        JCHStressLab.setVisible(true);
        JCHAtencionUsu.setVisible(true);
        JCHJorndRot.setVisible(true);
        JCHJornadExtens.setVisible(true);
        JCHPeligrosCargaLabor.setVisible(true);
        JCHPsicosociales.setEnabled(true);
    }

    public void JRMecanicos_actionPerformed(ActionEvent e) {
        procradio(JRMecanicos, JRPsicolog, JRBiologicos, JRFisicoquim, JRQuimic, JRFisicos, JRErgonomic, JRElectricos, JRLocativos);
        llenarfactorriesgo(JCHMecanicos, 6);
        //llenareleriesgo();
        JPSeleccFact.setVisible(false);
        procesomecanico();
    }

    /**
     * procesomecanico
     */
    public void procesomecanico() {
        ocultarelemtodos();
        JLBriesgMec.setVisible(true);
        JCHMantCorr1.setVisible(true);
        JCHGuardasSeg.setVisible(true);
        JCHMantCorr2.setVisible(true);
        JCHPartes.setVisible(true);
        JCHFaltaHerr.setVisible(true);
        //JCHPeligrosCargaLabor.setVisible(true);
        JCHMecanicos.setEnabled(true);
    }

    public void JRElectricos_actionPerformed(ActionEvent e) {
        procradio(JRElectricos, JRMecanicos, JRPsicolog, JRBiologicos, JRFisicoquim, JRQuimic, JRFisicos, JRErgonomic, JRLocativos);
        llenarfactorriesgo(JCHElectricos, 7);
        //llenareleriesgo();
        JPSeleccFact.setVisible(false);
        procesoelectrico();
    }

    /**
     * procesoelectrico
     */
    public void procesoelectrico() {
        ocultarelemtodos();
        JLBRiesgElectricos.setVisible(true);
        JCHBajaTension.setVisible(true);
        JCHAltaTension.setVisible(true);
        JCHCargaEst.setVisible(true);
        JCHElectricos.setEnabled(true);
    }

    public void JRLocativos_actionPerformed(ActionEvent e) {
        procradio(JRLocativos, JRElectricos, JRMecanicos, JRPsicolog, JRBiologicos, JRFisicoquim, JRQuimic, JRFisicos, JRErgonomic);
        llenarfactorriesgo(JCHLocativos, 8);
        //llenareleriesgo();
        JPSeleccFact.setVisible(false);
        procesolocativo();
    }

    /**
     * procesolocativo
     */
    public void procesolocativo() {
        ocultarelemtodos();
        JLBRiegLocativos.setVisible(true);
        JCHExtintores.setVisible(true);
        JCHdOTACION.setVisible(true);
        JCHMarcacion.setVisible(true);
        JCHOrden.setVisible(true);
        JCHSuperficie.setVisible(true);
        JCHTechos.setVisible(true);
        JCHMuros.setVisible(true);
        JCHPisos.setVisible(true);
        JCHLocativos.setEnabled(true);
    }

    /**
     * llenarseleccfact
     */
    public void llenarseleccfact() {
        procradio(JRErgonomic, 0);
        procradio(JRFisicos, 1);
        procradio(JRQuimic, 2);
        procradio(JRFisicoquim, 3);
        procradio(JRBiologicos, 4);
        procradio(JRPsicolog, 5);
        procradio(JRMecanicos, 6);
        procradio(JRElectricos, 7);
        procradio(JRLocativos, 8);
        /*
        JRErgonomic.setSelected(llenarfactorriesgo(JCHErgonomicos,0));
        JRFisicos.setSelected(procbooleano(JCHFisicos));
        JRQuimic.setSelected(procbooleano(JCHQUIMICOS));
        JRFisicoquim.setSelected(procbooleano(JCHFisicoQuimicos));
        JRBiologicos.setSelected(procbooleano(JCHBIologicos));
        JRMecanicos.setSelected(procbooleano(JCHMecanicos));
        JRPsicolog.setSelected(procbooleano(JCHPsicosociales));
        JRElectricos.setSelected(procbooleano(JCHElectricos));
        JRLocativos.setSelected(procbooleano(JCHLocativos));*/
    }

    /**
     * procbooleano
     */
    public void procradio(JRadioButton JRvar, int numcol) {
        JRvar.setSelected(procllenatfr(fact[JTabHO.getSelectedRow()][numcol]));
    }

    /**
     * validarbajar
     */
    public void validarbajar() {
        if (JTFEmprHO.getText().compareTo("") != 0 && JFTFechaEmprHO.getText().compareTo("") != 0 && JFTFechaFinEmrHO.getText().compareTo("") != 0 && JTFFactorRiesgoHO.getText().compareTo("") != 0 && JTFCargoHO.getText().compareTo("") != 0 && JTFTiempoExp.getText().compareTo("") != 0) {
            cad1 = "FAVOR PULSAR ENTER DESPUES DEL CARGO";
            cad2 = "EL ITEM NO HA BAJADO";
            validHO.mensajeconfirmacion(cad1, cad2);
        } else {
            validarnulos();
        }
    }

    public void JBAtrasAF_actionPerformed(ActionEvent e) {
        CIngreso frameIngresoUsuario;
        frameIngresoUsuario = (CIngreso) frameHOOBJ;
        frameIngresoUsuario.setVisible(true);
        CHistoriaOcup frameho;
        frameho = (CHistoriaOcup) framehoOBJ;
        frameho.setVisible(false);
    }

    /**
     * CHistoriaOcup
     */
    public CHistoriaOcup() {
    }

    /**
     * llenarelemriesgo
     */
}//FIN CLASE

class CHistoriaOcup_JBAtrasAF_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JBAtrasAF_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasAF_actionPerformed(e);
    }
}

class CHistoriaOcup_JRLocativos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JRLocativos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRLocativos_actionPerformed(e);
    }
}

class CHistoriaOcup_JRElectricos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JRElectricos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRElectricos_actionPerformed(e);
    }
}

class CHistoriaOcup_JRMecanicos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JRMecanicos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRMecanicos_actionPerformed(e);
    }
}

class CHistoriaOcup_JRPsicolog_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JRPsicolog_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRPsicolog_actionPerformed(e);
    }
}

class CHistoriaOcup_JRBiologicos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JRBiologicos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBiologicos_actionPerformed(e);
    }
}

class CHistoriaOcup_JRFisicoquim_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JRFisicoquim_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRFisicoquim_actionPerformed(e);
    }
}

class CHistoriaOcup_JRQuimic_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JRQuimic_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRQuimic_actionPerformed(e);
    }
}

class CHistoriaOcup_JRFisicos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JRFisicos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRFisicos_actionPerformed(e);
    }
}

class CHistoriaOcup_JRErgonomic_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JRErgonomic_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRErgonomic_actionPerformed(e);
    }
}

class CHistoriaOcup_JCHLocativos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCHLocativos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHLocativos_actionPerformed(e);
    }
}

class CHistoriaOcup_JCHElectricos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCHElectricos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHElectricos_actionPerformed(e);
    }
}

class CHistoriaOcup_JCHMecanicos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCHMecanicos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHMecanicos_actionPerformed(e);
    }
}

class CHistoriaOcup_JCHPsicosociales_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCHPsicosociales_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHPsicosociales_actionPerformed(e);
    }
}

class CHistoriaOcup_JCHFisicoQuimicos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCHFisicoQuimicos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHFisicoQuimicos_actionPerformed(e);
    }
}

class CHistoriaOcup_JCHBIologicos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCHBIologicos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHBIologicos_actionPerformed(e);
    }
}

class CHistoriaOcup_JCHQUIMICOS_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCHQUIMICOS_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHQUIMICOS_actionPerformed(e);
    }
}

class CHistoriaOcup_JCHFisicos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCHFisicos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHFisicos_actionPerformed(e);
    }
}

class CHistoriaOcup_JCHErgonomicos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCHErgonomicos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHErgonomicos_actionPerformed(e);
    }
}

class CHistoriaOcup_JCHParasitos_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCHParasitos_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHParasitos_actionPerformed(e);
    }
}

class CHistoriaOcup_JCBElemRiesgo_keyAdapter extends KeyAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCBElemRiesgo_keyAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JCBElemRiesgo_keyReleased(e);
    }
}

class CHistoriaOcup_JCBFactorRiesg_keyAdapter extends KeyAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JCBFactorRiesg_keyAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JCBFactorRiesg_keyReleased(e);
    }
}

class CHistoriaOcup_JTFCargoHO_keyAdapter extends KeyAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JTFCargoHO_keyAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFCargoHO_keyReleased(e);
    }
}

class CHistoriaOcup_JTFCargoHO_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JTFCargoHO_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JTFCargoHO_actionPerformed(e);
    }
}

class CHistoriaOcup_JTFEmprHO_keyAdapter extends KeyAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JTFEmprHO_keyAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFEmprHO_keyReleased(e);
    }
}

class CHistoriaOcup_JBSgteAF_actionAdapter implements ActionListener {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JBSgteAF_actionAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSgteAF_actionPerformed(e);
    }
}

class CHistoriaOcup_JTabHO_mouseAdapter extends MouseAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JTabHO_mouseAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.JTabHO_mouseReleased(e);
    }
}

class CHistoriaOcup_JTFTiempoExp_keyAdapter extends KeyAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JTFTiempoExp_keyAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFTiempoExp_keyReleased(e);
    }
}

class CHistoriaOcup_jCalendar2_mouseAdapter extends MouseAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_jCalendar2_mouseAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.jCalendar2_mouseReleased(e);
    }
}

class CHistoriaOcup_JFTFechaFinEmrHO_focusAdapter extends FocusAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JFTFechaFinEmrHO_focusAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void focusGained(FocusEvent e) {
        adaptee.JFTFechaFinEmrHO_focusGained(e);
    }
}

class CHistoriaOcup_JTFFactorRiesgoHO_keyAdapter extends KeyAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JTFFactorRiesgoHO_keyAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFFactorRiesgoHO_keyReleased(e);
    }
}

class CHistoriaOcup_JFTFechaFinEmrHO_keyAdapter extends KeyAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JFTFechaFinEmrHO_keyAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JFTFechaFinEmrHO_keyReleased(e);
    }
}

class CHistoriaOcup_jCalendar1_mouseAdapter extends MouseAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_jCalendar1_mouseAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.jCalendar1_mouseReleased(e);
    }
}

class CHistoriaOcup_JFTFechaEmprHO_focusAdapter extends FocusAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JFTFechaEmprHO_focusAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void focusGained(FocusEvent e) {
        adaptee.JFTFechaEmprHO_focusGained(e);
    }
}

class CHistoriaOcup_JFTFechaEmprHO_keyAdapter extends KeyAdapter {

    private CHistoriaOcup adaptee;

    CHistoriaOcup_JFTFechaEmprHO_keyAdapter(CHistoriaOcup adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JFTFechaEmprHO_keyReleased(e);
    }
}
