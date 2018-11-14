package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.awt.Rectangle;

public class CExamenFisico extends JInternalFrame {
    Object objppalef;
    Object obotactualizarEF;
    String cad1;
    String cad2;
    public Statement TSentenciaconsultaPC;
    public ResultSet RconsultaPC;
    public ConexionSql Cconsql= new ConexionSql();
    int swedicingrPC;
    String numingredicPC;
    Object  objetoaxamparaclin= new Object();
    public  Object framedetantperso=new Object();
    int swval=0;
    Object JDPIngresoobjEF=new Object();
    String nombref= new String();
    String numhcef= new String();
    Object frameingresoOBJ= new Object();
    Object framehoOBJ= new Object();
    Object frameEnfProfOBJ=new Object();
    Object frameAcciTrabajoOBJ=new Object();
    Object frameAntecFamOBJ=new Object();
    Object frameAntecPersonalOBJ=new Object();
    Object frameGinecologiaOBJ=new Object();
    Object frameInmunizOBJ=new Object();
    Object frameOtrosAntecOBJ=new Object();
    Object frameRevisionSistemasOBJ=new Object();
    Object frameEFOBJ= new Object();
    int swgte;
    public static int swabdomen=0;
    public static int swboca=0;
    public static int swcabeza=0;
    public static int swcara=0;
    public static int swcardiaco=0;
    public static int swcol=0;
    public static int swcuello=0;
    public static int swdentadura=0;
    public static int swgenitales=0;
    public static int swmamas=0;
    public static int swminf=0;
    public static int swmsup=0;
    public static int swnariz=0;
    public static int swneurologico=0;
    public static int swoidos=0;
    public static int swojos=0;
    public static int swpies=0;
    public static int swpulmon=0;
    public static int swtorax=0;
    public static int swpiel=0;
    ValidarComponentes objllencomboEFr=new ValidarComponentes();
    CExamenFisico objEF;
    Object  framevarDg;
    Object OGotrosantec;
    Object OGmotef;
    Object OGantpersEF;
    Object OGingrEF;
    Object ORsistemas;
    public String nombreefisico="";
    //public  CDetallesAP framedetantperso;
    public JDesktopPane JDPExFisObj = new JDesktopPane();
    JPanel JPExamenFisico = new JPanel();
    JLabel JLBNombPacEF = new JLabel();
    JLabel JLBHcEF = new JLabel();
    JLabel JLBnumhcEF = new JLabel();
    JButton JBAtrasEF = new JButton();
    JButton JBSgute = new JButton();
    JButton JBCancelarEF = new JButton();
    JComboBox JCBEstadoGeneral = new JComboBox();
    JLabel JLBEstadoGeneral = new JLabel();
    JTabbedPane JTBExFis = new JTabbedPane();
    JPanel JPExFis = new JPanel();
    JLabel JLBTaEF = new JLabel();
    JFormattedTextField JFTTaEF = new JFormattedTextField();
    JLabel JLBfcEF = new JLabel();
    JFormattedTextField JFTfcEF = new JFormattedTextField();
    JLabel JLBfxm1EF = new JLabel();
    JLabel JLBfrEF = new JLabel();
    JFormattedTextField JFTfrEF = new JFormattedTextField(new String());
    JLabel JLBfxm2EF = new JLabel();
    JLabel JLBPesoEF = new JLabel();
    JFormattedTextField JFTPesoEF = new JFormattedTextField();
    JLabel JLBkgEF = new JLabel();
    JLabel JLBTallaEF = new JLabel();
    JFormattedTextField JFTBtallaEF = new JFormattedTextField();
    JLabel JLBmtsEF = new JLabel();
    JLabel JLBImc = new JLabel();
    JFormattedTextField JFTimcEF=JFTimcEF=new JFormattedTextField();;
    JLabel JLBmkgEF = new JLabel();
    JLabel JLBRangoEF = new JLabel();
    JFormattedTextField JFTrangoEF = new JFormattedTextField();
    JLabel JLBNormal1 = new JLabel();
    JRadioButton JRsiCab = new JRadioButton();
    JLabel JLBCabeza = new JLabel();
    JRadioButton JRnoCab = new JRadioButton();
    JTextField JTFCabeza = new JTextField();
    JButton JBCab = new JButton();
    JLabel JLBAgrandar1 = new JLabel();
    JLabel JLCaraEF = new JLabel();
    JRadioButton JRsiCaraEF = new JRadioButton();
    JRadioButton JRnoCara = new JRadioButton();
    JTextField JTFcaraEF = new JTextField();
    JButton JBCaraEF = new JButton();
    JLabel JLBOjos = new JLabel();
    JRadioButton JRsiOjosEF = new JRadioButton();
    JRadioButton JRnoOjosEF = new JRadioButton();
    JTextField JTFojosEF = new JTextField();
    JButton JBOjosEF = new JButton();
    JLabel JLBOidosEF = new JLabel();
    JRadioButton JRsiOidosEF = new JRadioButton();
    JRadioButton JRnoOidos = new JRadioButton();
    JTextField JTFoidosEF = new JTextField();
    JButton JBOidosEF = new JButton();
    JLabel JLBnormal2 = new JLabel();
    JLabel JLBAgrandar2 = new JLabel();
    JLabel JLBNarizEF = new JLabel();
    JRadioButton JRBsiNarizEF = new JRadioButton();
    JRadioButton JRBnoNariz = new JRadioButton();
    JTextField JTFnarizEF = new JTextField();
    JButton JBnarizEF = new JButton();
    JLabel JLBBocaEF = new JLabel();
    JRadioButton JRsiBocaEF = new JRadioButton();
    JRadioButton JRBnoBocaEF = new JRadioButton();
    JTextField JTFbocaEF = new JTextField();
    JButton JBbocaEF = new JButton();
    JLabel JLBDentEF = new JLabel();
    JRadioButton JRsiDentEF = new JRadioButton();
    JRadioButton JRBnoDentEF = new JRadioButton();
    JTextField JTFDentEF = new JTextField();
    JButton JBDentEF = new JButton();
    JLabel JLBCuelloEF = new JLabel();
    JRadioButton JRBsiCuelloEF = new JRadioButton();
    JRadioButton JRBnoCuelloEF = new JRadioButton();
    JTextField JTFcuelloEF = new JTextField();
    JButton JBCuelloEF = new JButton();
    JLabel JLBToraxEF = new JLabel();
    JRadioButton JRsiToraxEF = new JRadioButton();
    JRadioButton JRBnoToraxEF = new JRadioButton();
    JTextField JTFtoraxEF = new JTextField();
    JButton JBToraxEF = new JButton();
    JLabel JLBCardiacoEF = new JLabel();
    JRadioButton JRBsicardiacoEF = new JRadioButton();
    JRadioButton JRBnoCardiacoEF = new JRadioButton();
    JTextField JTFCardiacoEF = new JTextField();
    JButton JBCardiacoEF = new JButton();
    JLabel JLBPulmonEF = new JLabel();
    JRadioButton JRBsiPulmonEF = new JRadioButton();
    JRadioButton JRBnoPulmonEF = new JRadioButton();
    JTextField JTFPulmonEF = new JTextField();
    JButton JBPulmonEF = new JButton();
    JLabel JLBMamasEF = new JLabel();
    JRadioButton JRsimamasEF = new JRadioButton();
    JRadioButton JRBnomamasEF = new JRadioButton();
    JTextField JTFMamasEF = new JTextField();
    JButton JBmamasEF = new JButton();
    JLabel JLBAdomenEF = new JLabel();
    JRadioButton JRBsiAbdomenEF = new JRadioButton();
    JRadioButton JRBnoAbdomenEF = new JRadioButton();
    JTextField JTFAbdomenEF = new JTextField();
    JButton JBAbdomenEF = new JButton();
    JLabel JLBGenitalesEF = new JLabel();
    JRadioButton JRsiGenitalesEF = new JRadioButton();
    JRadioButton JRBnoGenitalesEF = new JRadioButton();
    JTextField JTFGenitalesEF = new JTextField();
    JButton JBGenitalesEF = new JButton();
    JLabel JLBMiembrosSEF = new JLabel();
    JRadioButton JRBsiMsupEF = new JRadioButton();
    JRadioButton JRBnoMsupEF = new JRadioButton();
    JTextField JTFMsup = new JTextField();
    JButton JBMsupEF = new JButton();
    JLabel JLBMinfEF = new JLabel();
    JRadioButton JRBsiMinfEF = new JRadioButton();
    JRadioButton JRnoMinfEF = new JRadioButton();
    JTextField JTFMinfEF = new JTextField();
    JButton JBMinfEF = new JButton();
    JLabel JLBPiesEF = new JLabel();
    JLabel JLBNormal2 = new JLabel();
    JLabel JLBAgrandar3 = new JLabel();
    JRadioButton JRsiPiesEF = new JRadioButton();
    JRadioButton JRBnoPiesEF = new JRadioButton();
    JTextField JTFPiesEF = new JTextField();
    JButton JBPiesEF = new JButton();
    JLabel JLBColumnaEF = new JLabel();
    JRadioButton JRBsiColEF = new JRadioButton();
    JRadioButton JRBnoColEF = new JRadioButton();
    JTextField JTFColEF = new JTextField();
    JButton JBColEF = new JButton();
    JLabel JLBNeurologicoEF = new JLabel();
    JRadioButton JRBNeurEF = new JRadioButton();
    JRadioButton JRBnoNeurl = new JRadioButton();
    JTextField JTFNeurlogEF = new JTextField();
    JButton JBNeurologEF = new JButton();
    JLabel JLBPielEF = new JLabel();
    JRadioButton JRBsiPiel = new JRadioButton();
    JRadioButton JRBnoPielEF = new JRadioButton();
    JTextField JTFPielEF = new JTextField();
    JButton JBTPielEF = new JButton();
    CAntecedentesFamiliar varobjAF;
    JLabel JLBLateralidad = new JLabel();
    JComboBox JCBLateral = new JComboBox();
    public CExamenFisico(Object obotactualizarRS,String numingredicEF,int swedicingrEF,String Nombrepacef,CRevisionSistemas framers,String varnHC,JDesktopPane JDPIngreso,CIngreso frameingreso,CHistoriaOcup framehistocup,CEnfermedadProf frameenfermedadprof,CHistoriaAcciTrab frameaccitrabajo,CAntecedentesFamiliar frameantecendnetesfam,CAntecedentesPersonales frameantecpersonal,CAGineco frameginecologia,CInmuniz frameinmunuz,COtrosAnt frameotrosantecedentes,Object objppalrs) {
      try {
           jbInit();
           frameingresoOBJ=frameingreso;
           framehoOBJ=framehistocup;
           frameEnfProfOBJ=frameenfermedadprof;
           frameAcciTrabajoOBJ=frameaccitrabajo;
           frameAntecFamOBJ=frameantecendnetesfam;
           frameAntecPersonalOBJ=frameantecpersonal;
           frameGinecologiaOBJ=frameginecologia;
           frameInmunizOBJ=frameinmunuz;
           frameOtrosAntecOBJ=frameotrosantecedentes;
           frameRevisionSistemasOBJ=framers;
           frameEFOBJ=framers;
           JLBNombPacEF.setText(Nombrepacef);
           JLBHcEF.setText(varnHC);
           JDPIngresoobjEF=JDPIngreso;
           nombref=Nombrepacef;
           numhcef=varnHC;
           swgte=0;
           swedicingrPC=swedicingrEF;
           numingredicPC=numingredicEF;
           obotactualizarEF=obotactualizarRS;
           objppalef=objppalrs;
      }
      catch (Exception ex) {
          ex.printStackTrace();
      }
   }


    private void jbInit() throws Exception {
        this.setClosable(true);
        this.setVisible(true);
        this.setIconifiable(true);
        this.setMaximizable(true);
        this.setResizable(true);
        this.getContentPane().setLayout(null);
        this.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        //JFTimcEF=new JFormattedTextField(new Integer(0));
        JPExamenFisico.setBackground(new Color(122, 150, 233));
        JPExamenFisico.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JPExamenFisico.setBorder(BorderFactory.createRaisedBevelBorder());
        JPExamenFisico.setBounds(new Rectangle(3, 5, 994, 550));
        JPExamenFisico.setLayout(null);
        JLBNombPacEF.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNombPacEF.setForeground(Color.red);
        JLBNombPacEF.setToolTipText("");
        JLBNombPacEF.setBounds(new Rectangle(5, 6, 436, 45));
        JLBHcEF.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBHcEF.setForeground(Color.red);
        JLBHcEF.setToolTipText("");
        JLBHcEF.setBounds(new Rectangle(442, 17, 279, 24));
        JLBnumhcEF.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBnumhcEF.setForeground(Color.red);
        JLBnumhcEF.setBounds(new Rectangle(491, 16, 143, 25));
        JBAtrasEF.setBounds(new Rectangle(139, 502, 112, 36));
        JBAtrasEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBAtrasEF.setMnemonic('R');
        JBAtrasEF.setText("Atras");
        JBAtrasEF.addActionListener(new CExamenFisico_JBAtrasEF_actionAdapter(this));
        JBAtrasEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN3.GIF")));
        JBAtrasEF.setSelectedIcon(null);
        JBSgute.setBounds(new Rectangle(434, 502, 133, 36));
        JBSgute.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBSgute.setToolTipText("");
        JBSgute.setMnemonic('S');
        JBSgute.setText("SIGUIENTE");
        JBSgute.addActionListener(new CExamenFisico_JBSgute_actionAdapter(this));
        JBSgute.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN4.GIF")));
        JBSgute.setSelectedIcon(null);
        JBCancelarEF.setBounds(new Rectangle(749, 501, 131, 36));
        JBCancelarEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBCancelarEF.setToolTipText("");
        JBCancelarEF.setMnemonic('S');
        JBCancelarEF.setText("CANCELAR");
        JBCancelarEF.addActionListener(new
                                       CExamenFisico_JBCancelarEF_actionAdapter(this));
        JBCancelarEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/MG19.GIF")));
        JBCancelarEF.setSelectedIcon(null);
        JCBEstadoGeneral.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCBEstadoGeneral.setBorder(BorderFactory.createRaisedBevelBorder());
        JCBEstadoGeneral.setBounds(new Rectangle(7, 72, 144, 28));
        JLBEstadoGeneral.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBEstadoGeneral.setForeground(Color.darkGray);
        JLBEstadoGeneral.setToolTipText("");
        JLBEstadoGeneral.setText("ESTADO GENERAL");
        JLBEstadoGeneral.setBounds(new Rectangle(7, 35, 104, 39));
        JTBExFis.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JTBExFis.setForeground(Color.red);
        JTBExFis.setBorder(BorderFactory.createRaisedBevelBorder());
        JTBExFis.setBounds(new Rectangle(268, 65, 719, 123));
        JPExFis.setBackground(new Color(146, 154, 255));
        JPExFis.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JPExFis.setLayout(null);
        JLBTaEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBTaEF.setToolTipText("");
        JLBTaEF.setText("TA:");
        JLBTaEF.setBounds(new Rectangle(4, 14, 40, 23));
        JFTTaEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JFTTaEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTTaEF.setToolTipText("");
        JFTTaEF.setBounds(new Rectangle(5, 34, 58, 21));
        JLBfcEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBfcEF.setToolTipText("");
        JLBfcEF.setText("FC:");
        JLBfcEF.setBounds(new Rectangle(79, 14, 40, 23));
        JFTfcEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JFTfcEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTfcEF.setToolTipText("");
        JFTfcEF.setBounds(new Rectangle(79, 35, 58, 21));
        JFTfcEF.addKeyListener(new CExamenFisico_JFTfcEF_keyAdapter(this));
        JFTfcEF.addFocusListener(new CExamenFisico_JFTfcEF_focusAdapter(this));
        JFTfcEF.setVisible(true);
        JLBfxm1EF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBfxm1EF.setForeground(Color.red);
        JLBfxm1EF.setToolTipText("");
        JLBfxm1EF.setText("Por Min");
        JLBfxm1EF.setBounds(new Rectangle(143, 33, 48, 23));
        JLBfrEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBfrEF.setToolTipText("");
        JLBfrEF.setText("FR:");
        JLBfrEF.setBounds(new Rectangle(198, 14, 40, 23));
        JFTfrEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JFTfrEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTfrEF.setToolTipText("");
        JFTfrEF.setBounds(new Rectangle(198, 34, 58, 21));
        JFTfrEF.addKeyListener(new CExamenFisico_JFTfrEF_keyAdapter(this));
        JLBfxm2EF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBfxm2EF.setForeground(Color.red);
        JLBfxm2EF.setToolTipText("");
        JLBfxm2EF.setText("Por Min");
        JLBfxm2EF.setBounds(new Rectangle(261, 33, 48, 23));
        JLBPesoEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBPesoEF.setToolTipText("");
        JLBPesoEF.setText("PESO:");
        JLBPesoEF.setBounds(new Rectangle(314, 14, 40, 23));
        JFTPesoEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JFTPesoEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTPesoEF.setToolTipText("");
        JFTPesoEF.setBounds(new Rectangle(314, 34, 58, 21));
        JFTPesoEF.addKeyListener(new CExamenFisico_JFTPesoEF_keyAdapter(this));
        JLBkgEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBkgEF.setForeground(Color.red);
        JLBkgEF.setToolTipText("");
        JLBkgEF.setText("KG");
        JLBkgEF.setBounds(new Rectangle(377, 33, 27, 23));
        JLBTallaEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBTallaEF.setToolTipText("");
        JLBTallaEF.setText("TALLA:");
        JLBTallaEF.setBounds(new Rectangle(398, 14, 40, 23));
        JFTBtallaEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JFTBtallaEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTBtallaEF.setToolTipText("");
        JFTBtallaEF.setBounds(new Rectangle(400, 34, 58, 21));
        JFTBtallaEF.addKeyListener(new CExamenFisico_JFTBtallaEF_keyAdapter(this));
        JLBmtsEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBmtsEF.setForeground(Color.red);
        JLBmtsEF.setToolTipText("");
        JLBmtsEF.setText("MTS");
        JLBmtsEF.setBounds(new Rectangle(463, 33, 27, 23));
        JLBImc.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBImc.setToolTipText("");
        JLBImc.setText("IMC:");
        JLBImc.setBounds(new Rectangle(492, 14, 40, 23));
        JFTimcEF.setFont(new java.awt.Font("Arial", Font.BOLD, 13));
        JFTimcEF.setForeground(Color.red);
        JFTimcEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTimcEF.setToolTipText("");
        JFTimcEF.setBounds(new Rectangle(492, 34, 58, 21));
        JFTimcEF.addFocusListener(new CExamenFisico_JFTimcEF_focusAdapter(this));
        JLBmkgEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBmkgEF.setForeground(Color.red);
        JLBmkgEF.setToolTipText("");
        JLBmkgEF.setText("mts2 SC");
        JLBmkgEF.setBounds(new Rectangle(556, 33, 51, 23));
        JLBRangoEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBRangoEF.setToolTipText("");
        JLBRangoEF.setText("RANGO:");
        JLBRangoEF.setBounds(new Rectangle(623, 31, 56, 23));
        JFTrangoEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JFTrangoEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTrangoEF.setToolTipText("");
        JFTrangoEF.setBounds(new Rectangle(491, 60, 210, 25));
        JLBNormal1.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBNormal1.setForeground(Color.red);
        JLBNormal1.setToolTipText("");
        JLBNormal1.setText("NORMAL");
        JLBNormal1.setBounds(new Rectangle(90, 212, 55, 14));
        JRsiCab.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRsiCab.setOpaque(false);
        JRsiCab.setSelected(true);
        JRsiCab.setText("SI");
        JRsiCab.setBounds(new Rectangle(87, 233, 42, 23));
        JRsiCab.addActionListener(new CExamenFisico_JRsiCab_actionAdapter(this));
        JLBCabeza.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBCabeza.setToolTipText("");
        JLBCabeza.setText("CABEZA");
        JLBCabeza.setBounds(new Rectangle(4, 237, 50, 14));
        JRnoCab.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRnoCab.setOpaque(false);
        JRnoCab.setToolTipText("");
        JRnoCab.setText("NO");
        JRnoCab.setBounds(new Rectangle(132, 234, 42, 23));
        JRnoCab.addActionListener(new CExamenFisico_JRnoCab_actionAdapter(this));
        JTFCabeza.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFCabeza.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFCabeza.setBounds(new Rectangle(181, 232, 81, 25));
        JBCab.setBounds(new Rectangle(269, 231, 57, 25));
        JBCab.setEnabled(false);
        JBCab.setActionCommand("JBDiabet");
        JBCab.addActionListener(new CExamenFisico_JBCab_actionAdapter(this));
        JLBAgrandar1.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBAgrandar1.setForeground(Color.blue);
        JLBAgrandar1.setText("Agrandar");
        JLBAgrandar1.setBounds(new Rectangle(270, 209, 58, 21));
        JLCaraEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLCaraEF.setToolTipText("");
        JLCaraEF.setText("CARA");
        JLCaraEF.setBounds(new Rectangle(5, 263, 50, 14));
        JRsiCaraEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRsiCaraEF.setOpaque(false);
        JRsiCaraEF.setSelected(true);
        JRsiCaraEF.setText("SI");
        JRsiCaraEF.setBounds(new Rectangle(87, 260, 42, 23));
        JRsiCaraEF.addActionListener(new CExamenFisico_JRsiCaraEF_actionAdapter(this));
        JRnoCara.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRnoCara.setOpaque(false);
        JRnoCara.setToolTipText("");
        JRnoCara.setText("NO");
        JRnoCara.setBounds(new Rectangle(132, 260, 42, 23));
        JRnoCara.addActionListener(new CExamenFisico_JRnoCara_actionAdapter(this));
        JTFcaraEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFcaraEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFcaraEF.setToolTipText("");
        JTFcaraEF.setBounds(new Rectangle(181, 260, 81, 25));
        JBCaraEF.setBounds(new Rectangle(269, 261, 57, 25));
        JBCaraEF.setEnabled(false);
        JBCaraEF.setToolTipText("");
        JBCaraEF.setActionCommand("JBDiabet");
        JBCaraEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBCaraEF.setSelectedIcon(null);
        JBCaraEF.addActionListener(new CExamenFisico_JBCaraEF_actionAdapter(this));
        JLBOjos.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBOjos.setToolTipText("");
        JLBOjos.setText("OJOS");
        JLBOjos.setBounds(new Rectangle(5, 293, 50, 14));
        JRsiOjosEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRsiOjosEF.setOpaque(false);
        JRsiOjosEF.setSelected(true);
        JRsiOjosEF.setText("SI");
        JRsiOjosEF.setBounds(new Rectangle(87, 288, 42, 23));
        JRsiOjosEF.addActionListener(new CExamenFisico_JRsiOjosEF_actionAdapter(this));
        JRnoOjosEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRnoOjosEF.setOpaque(false);
        JRnoOjosEF.setToolTipText("");
        JRnoOjosEF.setText("NO");
        JRnoOjosEF.setBounds(new Rectangle(132, 288, 42, 23));
        JRnoOjosEF.addActionListener(new CExamenFisico_JRnoOjosEF_actionAdapter(this));
        JTFojosEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFojosEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFojosEF.setToolTipText("");
        JTFojosEF.setBounds(new Rectangle(181, 288, 81, 25));
        JBOjosEF.setBounds(new Rectangle(269, 290, 57, 25));
        JBOjosEF.setEnabled(false);
        JBOjosEF.setToolTipText("");
        JBOjosEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBOjosEF.setSelectedIcon(null);
        JBOjosEF.addActionListener(new CExamenFisico_JBOjosEF_actionAdapter(this));
        JBOjosEF.setActionCommand("JBDiabet");
        JLBOidosEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBOidosEF.setToolTipText("");
        JLBOidosEF.setText("OIDOS");
        JLBOidosEF.setBounds(new Rectangle(5, 318, 50, 14));
        JRsiOidosEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRsiOidosEF.setOpaque(false);
        JRsiOidosEF.setSelected(true);
        JRsiOidosEF.setText("SI");
        JRsiOidosEF.setBounds(new Rectangle(87, 316, 42, 23));
        JRsiOidosEF.addActionListener(new CExamenFisico_JRsiOidosEF_actionAdapter(this));
        JRnoOidos.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRnoOidos.setOpaque(false);
        JRnoOidos.setToolTipText("");
        JRnoOidos.setText("NO");
        JRnoOidos.setBounds(new Rectangle(132, 316, 42, 23));
        JRnoOidos.addActionListener(new CExamenFisico_JRnoOidos_actionAdapter(this));
        JTFoidosEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFoidosEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFoidosEF.setToolTipText("");
        JTFoidosEF.setBounds(new Rectangle(181, 317, 81, 25));
        JBOidosEF.setBounds(new Rectangle(269, 318, 57, 25));
        JBOidosEF.setEnabled(false);
        JBOidosEF.setToolTipText("");
        JBOidosEF.setActionCommand("JBDiabet");
        JBOidosEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBOidosEF.setSelectedIcon(null);
        JBOidosEF.addActionListener(new CExamenFisico_JBOidosEF_actionAdapter(this));
        JLBnormal2.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBnormal2.setForeground(Color.red);
        JLBnormal2.setToolTipText("");
        JLBnormal2.setText("NORMAL");
        JLBnormal2.setBounds(new Rectangle(433, 214, 55, 14));
        JLBAgrandar2.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBAgrandar2.setForeground(Color.blue);
        JLBAgrandar2.setText("Agrandar");
        JLBAgrandar2.setBounds(new Rectangle(610, 207, 58, 21));
        JLBNarizEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBNarizEF.setToolTipText("");
        JLBNarizEF.setText("NARIZ");
        JLBNarizEF.setBounds(new Rectangle(5, 348, 50, 14));
        JRBsiNarizEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBsiNarizEF.setOpaque(false);
        JRBsiNarizEF.setSelected(true);
        JRBsiNarizEF.setText("SI");
        JRBsiNarizEF.setBounds(new Rectangle(87, 344, 42, 23));
        JRBsiNarizEF.addActionListener(new CExamenFisico_JRBsiNarizEF_actionAdapter(this));
        JRBnoNariz.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoNariz.setOpaque(false);
        JRBnoNariz.setToolTipText("");
        JRBnoNariz.setText("NO");
        JRBnoNariz.setBounds(new Rectangle(132, 344, 42, 23));
        JRBnoNariz.addActionListener(new CExamenFisico_JRBnoNariz_actionAdapter(this));
        JTFnarizEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFnarizEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFnarizEF.setToolTipText("");
        JTFnarizEF.setBounds(new Rectangle(181, 346, 81, 25));
        JBnarizEF.setBounds(new Rectangle(269, 347, 57, 25));
        JBnarizEF.setEnabled(false);
        JBnarizEF.setToolTipText("");
        JBnarizEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBnarizEF.setSelectedIcon(null);
        JBnarizEF.addActionListener(new CExamenFisico_JBnarizEF_actionAdapter(this));
        JBnarizEF.setActionCommand("JBDiabet");
        JLBBocaEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBBocaEF.setToolTipText("");
        JLBBocaEF.setText("BOCA");
        JLBBocaEF.setBounds(new Rectangle(5, 375, 50, 14));
        JRsiBocaEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRsiBocaEF.setOpaque(false);
        JRsiBocaEF.setSelected(true);
        JRsiBocaEF.setText("SI");
        JRsiBocaEF.setBounds(new Rectangle(87, 371, 42, 23));
        JRsiBocaEF.addActionListener(new CExamenFisico_JRsiBocaEF_actionAdapter(this));
        JRBnoBocaEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoBocaEF.setOpaque(false);
        JRBnoBocaEF.setToolTipText("");
        JRBnoBocaEF.setText("NO");
        JRBnoBocaEF.setBounds(new Rectangle(132, 371, 42, 23));
        JRBnoBocaEF.addActionListener(new CExamenFisico_JRBnoBocaEF_actionAdapter(this));
        JTFbocaEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFbocaEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFbocaEF.setToolTipText("");
        JTFbocaEF.setBounds(new Rectangle(181, 374, 81, 25));
        JBbocaEF.setBounds(new Rectangle(269, 375, 57, 25));
        JBbocaEF.setEnabled(false);
        JBbocaEF.setToolTipText("");
        JBbocaEF.setActionCommand("JBDiabet");
        JBbocaEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBbocaEF.setSelectedIcon(null);
        JBbocaEF.addActionListener(new CExamenFisico_JBbocaEF_actionAdapter(this));
        JLBDentEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBDentEF.setToolTipText("");
        JLBDentEF.setText("DENTADURA");
        JLBDentEF.setBounds(new Rectangle(5, 404, 85, 14));
        JRsiDentEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRsiDentEF.setOpaque(false);
        JRsiDentEF.setSelected(true);
        JRsiDentEF.setText("SI");
        JRsiDentEF.setBounds(new Rectangle(87, 399, 42, 23));
        JRsiDentEF.addActionListener(new CExamenFisico_JRsiDentEF_actionAdapter(this));
        JRBnoDentEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoDentEF.setOpaque(false);
        JRBnoDentEF.setToolTipText("");
        JRBnoDentEF.setText("NO");
        JRBnoDentEF.setBounds(new Rectangle(132, 400, 42, 23));
        JRBnoDentEF.addActionListener(new CExamenFisico_JRBnoDentEF_actionAdapter(this));
        JTFDentEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFDentEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFDentEF.setToolTipText("");
        JTFDentEF.setBounds(new Rectangle(181, 402, 81, 25));
        JBDentEF.setBounds(new Rectangle(269, 404, 57, 25));
        JBDentEF.setEnabled(false);
        JBDentEF.setToolTipText("");
        JBDentEF.setActionCommand("JBDiabet");
        JBDentEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDentEF.setSelectedIcon(null);
        JBDentEF.addActionListener(new CExamenFisico_JBDentEF_actionAdapter(this));
        JLBCuelloEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBCuelloEF.setToolTipText("");
        JLBCuelloEF.setText("CUELLO");
        JLBCuelloEF.setBounds(new Rectangle(5, 432, 85, 14));
        JRBsiCuelloEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBsiCuelloEF.setOpaque(false);
        JRBsiCuelloEF.setSelected(true);
        JRBsiCuelloEF.setText("SI");
        JRBsiCuelloEF.setBounds(new Rectangle(87, 426, 42, 23));
        JRBsiCuelloEF.addActionListener(new CExamenFisico_JRBsiCuelloEF_actionAdapter(this));
        JRBnoCuelloEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoCuelloEF.setOpaque(false);
        JRBnoCuelloEF.setToolTipText("");
        JRBnoCuelloEF.setText("NO");
        JRBnoCuelloEF.setBounds(new Rectangle(132, 427, 42, 23));
        JRBnoCuelloEF.addActionListener(new CExamenFisico_JRBnoCuelloEF_actionAdapter(this));
        JTFcuelloEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFcuelloEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFcuelloEF.setToolTipText("");
        JTFcuelloEF.setBounds(new Rectangle(181, 430, 81, 25));
        JBCuelloEF.setBounds(new Rectangle(269, 433, 57, 25));
        JBCuelloEF.setEnabled(false);
        JBCuelloEF.setToolTipText("");
        JBCuelloEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBCuelloEF.setActionCommand("JBDiabet");
        JBCuelloEF.addActionListener(new CExamenFisico_JBCuelloEF_actionAdapter(this));
        JLBToraxEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBToraxEF.setToolTipText("");
        JLBToraxEF.setText("TORAX");
        JLBToraxEF.setBounds(new Rectangle(334, 237, 50, 14));
        JRsiToraxEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRsiToraxEF.setOpaque(false);
        JRsiToraxEF.setSelected(true);
        JRsiToraxEF.setText("SI");
        JRsiToraxEF.setBounds(new Rectangle(431, 233, 42, 23));
        JRsiToraxEF.addActionListener(new CExamenFisico_JRsiToraxEF_actionAdapter(this));
        JRBnoToraxEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoToraxEF.setOpaque(false);
        JRBnoToraxEF.setToolTipText("");
        JRBnoToraxEF.setText("NO");
        JRBnoToraxEF.setBounds(new Rectangle(477, 233, 42, 23));
        JRBnoToraxEF.addActionListener(new CExamenFisico_JRBnoToraxEF_actionAdapter(this));
        JTFtoraxEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFtoraxEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFtoraxEF.setToolTipText("");
        JTFtoraxEF.setBounds(new Rectangle(524, 232, 81, 25));
        JBToraxEF.setBounds(new Rectangle(610, 231, 57, 25));
        JBToraxEF.setEnabled(false);
        JBToraxEF.setToolTipText("");
        JBToraxEF.setActionCommand("JBDiabet");
        JBToraxEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBToraxEF.setSelectedIcon(null);
        JBToraxEF.addActionListener(new CExamenFisico_JBToraxEF_actionAdapter(this));
        JLBCardiacoEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBCardiacoEF.setToolTipText("");
        JLBCardiacoEF.setText("CARDIACO");
        JLBCardiacoEF.setBounds(new Rectangle(334, 264, 64, 14));
        JRBsicardiacoEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBsicardiacoEF.setOpaque(false);
        JRBsicardiacoEF.setSelected(true);
        JRBsicardiacoEF.setText("SI");
        JRBsicardiacoEF.setBounds(new Rectangle(431, 260, 42, 23));
        JRBsicardiacoEF.addActionListener(new CExamenFisico_JRBsicardiacoEF_actionAdapter(this));
        JRBnoCardiacoEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoCardiacoEF.setOpaque(false);
        JRBnoCardiacoEF.setToolTipText("");
        JRBnoCardiacoEF.setText("NO");
        JRBnoCardiacoEF.setBounds(new Rectangle(477, 261, 42, 23));
        JRBnoCardiacoEF.addActionListener(new CExamenFisico_JRBnoCardiacoEF_actionAdapter(this));
        JTFCardiacoEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFCardiacoEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFCardiacoEF.setToolTipText("");
        JTFCardiacoEF.setBounds(new Rectangle(524, 261, 81, 25));
        JBCardiacoEF.setBounds(new Rectangle(610, 261, 57, 25));
        JBCardiacoEF.setEnabled(false);
        JBCardiacoEF.setToolTipText("");
        JBCardiacoEF.setActionCommand("JBDiabet");
        JBCardiacoEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBCardiacoEF.setSelectedIcon(null);
        JBCardiacoEF.addActionListener(new CExamenFisico_JBCardiacoEF_actionAdapter(this));
        JLBPulmonEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBPulmonEF.setToolTipText("");
        JLBPulmonEF.setText("PULMONAR");
        JLBPulmonEF.setBounds(new Rectangle(334, 291, 66, 14));
        JRBsiPulmonEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBsiPulmonEF.setOpaque(false);
        JRBsiPulmonEF.setSelected(true);
        JRBsiPulmonEF.setText("SI");
        JRBsiPulmonEF.setBounds(new Rectangle(431, 288, 42, 23));
        JRBsiPulmonEF.addActionListener(new CExamenFisico_JRBsiPulmonEF_actionAdapter(this));
        JRBnoPulmonEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoPulmonEF.setOpaque(false);
        JRBnoPulmonEF.setToolTipText("");
        JRBnoPulmonEF.setText("NO");
        JRBnoPulmonEF.setBounds(new Rectangle(477, 289, 42, 23));
        JRBnoPulmonEF.addActionListener(new CExamenFisico_JRBnoPulmonEF_actionAdapter(this));
        JTFPulmonEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFPulmonEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFPulmonEF.setToolTipText("");
        JTFPulmonEF.setBounds(new Rectangle(524, 290, 81, 25));
        JBPulmonEF.setBounds(new Rectangle(610, 290, 57, 25));
        JBPulmonEF.setEnabled(false);
        JBPulmonEF.setToolTipText("");
        JBPulmonEF.setActionCommand("JBDiabet");
        JBPulmonEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBPulmonEF.setSelectedIcon(null);
        JBPulmonEF.addActionListener(new CExamenFisico_JBPulmonEF_actionAdapter(this));
        JLBMamasEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBMamasEF.setToolTipText("");
        JLBMamasEF.setText("MAMAS");
        JLBMamasEF.setBounds(new Rectangle(334, 319, 66, 14));
        JRsimamasEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRsimamasEF.setOpaque(false);
        JRsimamasEF.setSelected(true);
        JRsimamasEF.setText("SI");
        JRsimamasEF.setBounds(new Rectangle(431, 317, 42, 23));
        JRsimamasEF.addActionListener(new CExamenFisico_JRsimamasEF_actionAdapter(this));
        JRBnomamasEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnomamasEF.setOpaque(false);
        JRBnomamasEF.setToolTipText("");
        JRBnomamasEF.setText("NO");
        JRBnomamasEF.setBounds(new Rectangle(477, 318, 42, 23));
        JRBnomamasEF.addActionListener(new CExamenFisico_JRBnomamasEF_actionAdapter(this));
        JTFMamasEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFMamasEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFMamasEF.setToolTipText("");
        JTFMamasEF.setBounds(new Rectangle(524, 320, 81, 25));
        JBmamasEF.setBounds(new Rectangle(610, 321, 57, 25));
        JBmamasEF.setEnabled(false);
        JBmamasEF.setToolTipText("");
        JBmamasEF.setActionCommand("JBDiabet");
        JBmamasEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBmamasEF.setSelectedIcon(null);
        JBmamasEF.addActionListener(new CExamenFisico_JBmamasEF_actionAdapter(this));
        JLBAdomenEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBAdomenEF.setToolTipText("");
        JLBAdomenEF.setText("ABDOMEN");
        JLBAdomenEF.setBounds(new Rectangle(334, 350, 66, 14));
        JRBsiAbdomenEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBsiAbdomenEF.setOpaque(false);
        JRBsiAbdomenEF.setSelected(true);
        JRBsiAbdomenEF.setText("SI");
        JRBsiAbdomenEF.setBounds(new Rectangle(431, 347, 42, 23));
        JRBsiAbdomenEF.addActionListener(new CExamenFisico_JRBsiAbdomenEF_actionAdapter(this));
        JRBnoAbdomenEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoAbdomenEF.setOpaque(false);
        JRBnoAbdomenEF.setToolTipText("");
        JRBnoAbdomenEF.setText("NO");
        JRBnoAbdomenEF.setBounds(new Rectangle(477, 349, 42, 23));
        JRBnoAbdomenEF.addActionListener(new CExamenFisico_JRBnoAbdomenEF_actionAdapter(this));
        JTFAbdomenEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFAbdomenEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFAbdomenEF.setToolTipText("");
        JTFAbdomenEF.setBounds(new Rectangle(524, 349, 81, 25));
        JBAbdomenEF.setBounds(new Rectangle(610, 350, 57, 25));
        JBAbdomenEF.setEnabled(false);
        JBAbdomenEF.setToolTipText("");
        JBAbdomenEF.setActionCommand("JBDiabet");
        JBAbdomenEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBAbdomenEF.setSelectedIcon(null);
        JBAbdomenEF.addActionListener(new CExamenFisico_JBAbdomenEF_actionAdapter(this));
        JLBGenitalesEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBGenitalesEF.setToolTipText("");
        JLBGenitalesEF.setText("GENITALES");
        JLBGenitalesEF.setBounds(new Rectangle(334, 380, 66, 14));
        JRsiGenitalesEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRsiGenitalesEF.setOpaque(false);
        JRsiGenitalesEF.setSelected(true);
        JRsiGenitalesEF.setText("SI");
        JRsiGenitalesEF.setBounds(new Rectangle(431, 377, 42, 23));
        JRsiGenitalesEF.addActionListener(new CExamenFisico_JRsiGenitalesEF_actionAdapter(this));
        JRBnoGenitalesEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoGenitalesEF.setOpaque(false);
        JRBnoGenitalesEF.setToolTipText("");
        JRBnoGenitalesEF.setText("NO");
        JRBnoGenitalesEF.setBounds(new Rectangle(477, 379, 42, 23));
        JRBnoGenitalesEF.addActionListener(new CExamenFisico_JRBnoGenitalesEF_actionAdapter(this));
        JTFGenitalesEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFGenitalesEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFGenitalesEF.setToolTipText("");
        JTFGenitalesEF.setBounds(new Rectangle(524, 379, 81, 25));
        JBGenitalesEF.setBounds(new Rectangle(610, 379, 57, 25));
        JBGenitalesEF.setEnabled(false);
        JBGenitalesEF.setToolTipText("");
        JBGenitalesEF.setActionCommand("JBDiabet");
        JBGenitalesEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBGenitalesEF.setSelectedIcon(null);
        JBGenitalesEF.addActionListener(new CExamenFisico_JBGenitalesEF_actionAdapter(this));
        JLBMiembrosSEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBMiembrosSEF.setToolTipText("");
        JLBMiembrosSEF.setText("M. SUPERIORES");
        JLBMiembrosSEF.setBounds(new Rectangle(334, 411, 94, 14));
        JRBsiMsupEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBsiMsupEF.setOpaque(false);
        JRBsiMsupEF.setSelected(true);
        JRBsiMsupEF.setText("SI");
        JRBsiMsupEF.setBounds(new Rectangle(431, 407, 42, 23));
        JRBsiMsupEF.addActionListener(new CExamenFisico_JRBsiMsupEF_actionAdapter(this));
        JRBnoMsupEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoMsupEF.setOpaque(false);
        JRBnoMsupEF.setToolTipText("");
        JRBnoMsupEF.setText("NO");
        JRBnoMsupEF.setBounds(new Rectangle(477, 409, 42, 23));
        JRBnoMsupEF.addActionListener(new CExamenFisico_JRBnoMsupEF_actionAdapter(this));
        JTFMsup.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFMsup.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFMsup.setToolTipText("");
        JTFMsup.setBounds(new Rectangle(524, 410, 81, 25));
        JBMsupEF.setBounds(new Rectangle(610, 410, 57, 25));
        JBMsupEF.setEnabled(false);
        JBMsupEF.setToolTipText("");
        JBMsupEF.setActionCommand("JBDiabet");
        JBMsupEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBMsupEF.setSelectedIcon(null);
        JBMsupEF.addActionListener(new CExamenFisico_JBMsupEF_actionAdapter(this));
        JLBMinfEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBMinfEF.setToolTipText("");
        JLBMinfEF.setText("M.INFERIORES");
        JLBMinfEF.setBounds(new Rectangle(334, 439, 94, 14));
        JRBsiMinfEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBsiMinfEF.setOpaque(false);
        JRBsiMinfEF.setSelected(true);
        JRBsiMinfEF.setText("SI");
        JRBsiMinfEF.setBounds(new Rectangle(431, 435, 42, 23));
        JRBsiMinfEF.addActionListener(new CExamenFisico_JRBsiMinfEF_actionAdapter(this));
        JRnoMinfEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRnoMinfEF.setOpaque(false);
        JRnoMinfEF.setToolTipText("");
        JRnoMinfEF.setText("NO");
        JRnoMinfEF.setBounds(new Rectangle(477, 437, 42, 23));
        JRnoMinfEF.addActionListener(new CExamenFisico_JRnoMinfEF_actionAdapter(this));
        JTFMinfEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFMinfEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFMinfEF.setToolTipText("");
        JTFMinfEF.setBounds(new Rectangle(524, 439, 81, 25));
        JBMinfEF.setBounds(new Rectangle(610, 440, 57, 25));
        JBMinfEF.setEnabled(false);
        JBMinfEF.setToolTipText("");
        JBMinfEF.setActionCommand("JBDiabet");
        JBMinfEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBMinfEF.setSelectedIcon(null);
        JBMinfEF.addActionListener(new CExamenFisico_JBMinfEF_actionAdapter(this));
        JLBPiesEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBPiesEF.setToolTipText("");
        JLBPiesEF.setText("PIES");
        JLBPiesEF.setBounds(new Rectangle(670, 236, 50, 14));
        JLBNormal2.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBNormal2.setForeground(Color.red);
        JLBNormal2.setToolTipText("");
        JLBNormal2.setText("NORMAL");
        JLBNormal2.setBounds(new Rectangle(755, 210, 55, 14));
        JLBAgrandar3.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBAgrandar3.setForeground(Color.blue);
        JLBAgrandar3.setText("Agrandar");
        JLBAgrandar3.setBounds(new Rectangle(932, 204, 55, 21));
        JRsiPiesEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRsiPiesEF.setOpaque(false);
        JRsiPiesEF.setSelected(true);
        JRsiPiesEF.setText("SI");
        JRsiPiesEF.setBounds(new Rectangle(755, 233, 42, 23));
        JRsiPiesEF.addActionListener(new CExamenFisico_JRsiPiesEF_actionAdapter(this));
        JRBnoPiesEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoPiesEF.setOpaque(false);
        JRBnoPiesEF.setToolTipText("");
        JRBnoPiesEF.setText("NO");
        JRBnoPiesEF.setBounds(new Rectangle(800, 233, 42, 23));
        JRBnoPiesEF.addActionListener(new CExamenFisico_JRBnoPiesEF_actionAdapter(this));
        JTFPiesEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFPiesEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFPiesEF.setToolTipText("");
        JTFPiesEF.setBounds(new Rectangle(847, 232, 81, 25));
        JBPiesEF.setBounds(new Rectangle(932, 232, 57, 25));
        JBPiesEF.setEnabled(false);
        JBPiesEF.setToolTipText("");
        JBPiesEF.setActionCommand("JBDiabet");
        JBPiesEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBPiesEF.setSelectedIcon(null);
        JBPiesEF.addActionListener(new CExamenFisico_JBPiesEF_actionAdapter(this));
        JLBColumnaEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBColumnaEF.setToolTipText("");
        JLBColumnaEF.setText("COLUMNA");
        JLBColumnaEF.setBounds(new Rectangle(670, 266, 64, 14));
        JRBsiColEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBsiColEF.setOpaque(false);
        JRBsiColEF.setSelected(true);
        JRBsiColEF.setText("SI");
        JRBsiColEF.setBounds(new Rectangle(755, 263, 42, 23));
        JRBsiColEF.addActionListener(new CExamenFisico_JRBsiColEF_actionAdapter(this));
        JRBnoColEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoColEF.setOpaque(false);
        JRBnoColEF.setToolTipText("");
        JRBnoColEF.setText("NO");
        JRBnoColEF.setBounds(new Rectangle(801, 263, 42, 23));
        JRBnoColEF.addActionListener(new CExamenFisico_JRBnoColEF_actionAdapter(this));
        JTFColEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFColEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFColEF.setToolTipText("");
        JTFColEF.setBounds(new Rectangle(847, 262, 81, 25));
        JBColEF.setBounds(new Rectangle(932, 263, 57, 25));
        JBColEF.setEnabled(false);
        JBColEF.setToolTipText("");
        JBColEF.setActionCommand("JBDiabet");
        JBColEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBColEF.setSelectedIcon(null);
        JBColEF.addActionListener(new CExamenFisico_JBColEF_actionAdapter(this));
        JLBNeurologicoEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBNeurologicoEF.setToolTipText("");
        JLBNeurologicoEF.setText("NEUROLOGICO");
        JLBNeurologicoEF.setBounds(new Rectangle(670, 297, 88, 14));
        JRBNeurEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBNeurEF.setOpaque(false);
        JRBNeurEF.setSelected(true);
        JRBNeurEF.setText("SI");
        JRBNeurEF.setBounds(new Rectangle(755, 292, 42, 23));
        JRBNeurEF.addActionListener(new CExamenFisico_JRBNeurEF_actionAdapter(this));
        JRBnoNeurl.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoNeurl.setOpaque(false);
        JRBnoNeurl.setToolTipText("");
        JRBnoNeurl.setText("NO");
        JRBnoNeurl.setBounds(new Rectangle(801, 291, 42, 23));
        JRBnoNeurl.addActionListener(new CExamenFisico_JRBnoNeurl_actionAdapter(this));
        JTFNeurlogEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFNeurlogEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFNeurlogEF.setToolTipText("");
        JTFNeurlogEF.setBounds(new Rectangle(847, 292, 81, 25));
        JBNeurologEF.setBounds(new Rectangle(932, 293, 57, 25));
        JBNeurologEF.setEnabled(false);
        JBNeurologEF.setToolTipText("");
        JBNeurologEF.setActionCommand("JBDiabet");
        JBNeurologEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBNeurologEF.setSelectedIcon(null);
        JBNeurologEF.addActionListener(new CExamenFisico_JBNeurologEF_actionAdapter(this));
        JLBPielEF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JLBPielEF.setToolTipText("");
        JLBPielEF.setText("PIEL");
        JLBPielEF.setBounds(new Rectangle(670, 326, 75, 14));
        JRBsiPiel.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBsiPiel.setOpaque(false);
        JRBsiPiel.setSelected(true);
        JRBsiPiel.setText("SI");
        JRBsiPiel.setBounds(new Rectangle(755, 320, 42, 23));
        JRBsiPiel.addActionListener(new CExamenFisico_JRBsiPiel_actionAdapter(this));
        JRBnoPielEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBnoPielEF.setOpaque(false);
        JRBnoPielEF.setToolTipText("");
        JRBnoPielEF.setText("NO");
        JRBnoPielEF.setBounds(new Rectangle(801, 321, 42, 23));
        JRBnoPielEF.addActionListener(new CExamenFisico_JRBnoPielEF_actionAdapter(this));
        JTFPielEF.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFPielEF.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFPielEF.setToolTipText("");
        JTFPielEF.setBounds(new Rectangle(847, 322, 81, 25));
        JBTPielEF.setBounds(new Rectangle(932, 322, 57, 25));
        JBTPielEF.setEnabled(false);
        JBTPielEF.setToolTipText("");
        JBTPielEF.setActionCommand("JBDiabet");
        JBTPielEF.addActionListener(new CExamenFisico_JBTPielEF_actionAdapter(this));
        JBTPielEF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JLBLateralidad.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBLateralidad.setToolTipText("");
        JLBLateralidad.setText("LATERALIDAD");
        JLBLateralidad.setBounds(new Rectangle(6, 63, 82, 23));
        JCBLateral.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCBLateral.setBorder(BorderFactory.createRaisedBevelBorder());
        JCBLateral.setBounds(new Rectangle(84, 65, 86, 21));
        JPExamenFisico.add(JLBnumhcEF);
        JPExamenFisico.add(JBAtrasEF);
        JPExamenFisico.add(JBSgute);
        JPExamenFisico.add(JBCancelarEF);
        JPExamenFisico.add(JLBNombPacEF);
        JPExamenFisico.add(JTBExFis);
        JPExamenFisico.add(JCBEstadoGeneral);
        JPExamenFisico.add(JLBEstadoGeneral);
        JPExamenFisico.add(JLCaraEF);
        JPExamenFisico.add(JLBOjos);
        JPExamenFisico.add(JLBNormal1);
        JPExamenFisico.add(JLBOidosEF);
        JPExamenFisico.add(JLBNarizEF);
        JPExamenFisico.add(JLBBocaEF);
        JPExamenFisico.add(JBOidosEF);
        JPExamenFisico.add(JRBsiNarizEF);
        JPExamenFisico.add(JRBnoNariz);
        JPExamenFisico.add(JTFnarizEF);
        JPExamenFisico.add(JBnarizEF);
        JPExamenFisico.add(JRsiCaraEF);
        JPExamenFisico.add(JRnoCara);
        JPExamenFisico.add(JTFcaraEF);
        JPExamenFisico.add(JBCaraEF);
        JPExamenFisico.add(JRsiOjosEF);
        JPExamenFisico.add(JRnoOjosEF);
        JPExamenFisico.add(JTFojosEF);
        JPExamenFisico.add(JBOjosEF);
        JPExamenFisico.add(JRsiOidosEF);
        JPExamenFisico.add(JRnoOidos);
        JPExamenFisico.add(JTFoidosEF);
        JPExamenFisico.add(JRsiBocaEF);
        JPExamenFisico.add(JRBnoBocaEF);
        JPExamenFisico.add(JTFbocaEF);
        JPExamenFisico.add(JBbocaEF);
        JPExamenFisico.add(JLBAgrandar1);
        JPExamenFisico.add(JLBDentEF);
        JPExamenFisico.add(JRsiDentEF);
        JPExamenFisico.add(JRBsiCuelloEF);
        JPExamenFisico.add(JRBnoDentEF);
        JPExamenFisico.add(JRBnoCuelloEF);
        JPExamenFisico.add(JTFDentEF);
        JPExamenFisico.add(JTFcuelloEF);
        JPExamenFisico.add(JBDentEF);
        JPExamenFisico.add(JBCuelloEF);
        JPExamenFisico.add(JLBCabeza);
        JPExamenFisico.add(JRsiCab);
        JPExamenFisico.add(JRnoCab);
        JPExamenFisico.add(JTFCabeza);
        JPExamenFisico.add(JBCab);
        JPExamenFisico.add(JLBAdomenEF);
        JPExamenFisico.add(JLBMamasEF);
        JPExamenFisico.add(JLBPulmonEF);
        JPExamenFisico.add(JLBCardiacoEF);
        JPExamenFisico.add(JLBGenitalesEF);
        JPExamenFisico.add(JTFAbdomenEF);
        JPExamenFisico.add(JBAbdomenEF);
        JPExamenFisico.add(JBCardiacoEF);JPExamenFisico.add(JRBnoCardiacoEF);
        JPExamenFisico.add(JRBsicardiacoEF);
        JPExamenFisico.add(JRBsiPulmonEF);
        JPExamenFisico.add(JRBnoPulmonEF);
        JPExamenFisico.add(JTFPulmonEF);
        JPExamenFisico.add(JBPulmonEF);
        JPExamenFisico.add(JBmamasEF);
        JPExamenFisico.add(JTFMamasEF);
        JPExamenFisico.add(JRBnomamasEF);
        JPExamenFisico.add(JRsimamasEF);
        JPExamenFisico.add(JRBsiAbdomenEF);
        JPExamenFisico.add(JRBnoAbdomenEF);
        JPExamenFisico.add(JRsiGenitalesEF);
        JPExamenFisico.add(JRBnoGenitalesEF);
        JPExamenFisico.add(JTFGenitalesEF);
        JPExamenFisico.add(JBGenitalesEF);
        JPExamenFisico.add(JLBMiembrosSEF);
        JPExamenFisico.add(JLBMinfEF);
        JPExamenFisico.add(JRBsiMsupEF);
        JPExamenFisico.add(JRBsiMinfEF);
        JPExamenFisico.add(JRBnoMsupEF);
        JPExamenFisico.add(JRnoMinfEF);
        JPExamenFisico.add(JTFMsup);
        JPExamenFisico.add(JTFMinfEF);
        JPExamenFisico.add(JBMsupEF);
        JPExamenFisico.add(JBMinfEF);
        JPExamenFisico.add(JLBCuelloEF);
        JPExamenFisico.add(JLBToraxEF);
        JPExamenFisico.add(JLBnormal2);
        JPExamenFisico.add(JRsiToraxEF);
        JPExamenFisico.add(JRBnoToraxEF);
        JPExamenFisico.add(JTFtoraxEF);
        JPExamenFisico.add(JBToraxEF);
        JPExamenFisico.add(JLBAgrandar2);
        JPExamenFisico.add(JLBPiesEF);
        JPExamenFisico.add(JBPiesEF);
        JPExamenFisico.add(JTFPiesEF);
        JPExamenFisico.add(JRBnoPiesEF);
        JPExamenFisico.add(JRBsiColEF);
        JPExamenFisico.add(JRBnoColEF);
        JPExamenFisico.add(JLBColumnaEF);
        JPExamenFisico.add(JTFColEF);
        JPExamenFisico.add(JBColEF);
        JPExamenFisico.add(JLBNeurologicoEF);
        JPExamenFisico.add(JRBNeurEF);
        JPExamenFisico.add(JRBsiPiel);
        JPExamenFisico.add(JRsiPiesEF);
        JPExamenFisico.add(JRBnoNeurl);
        JPExamenFisico.add(JRBnoPielEF);
        JPExamenFisico.add(JTFPielEF);
        JPExamenFisico.add(JTFNeurlogEF);
        JPExamenFisico.add(JLBPielEF);
        JPExamenFisico.add(JLBAgrandar3);
        JPExamenFisico.add(JLBNormal2);
        JPExamenFisico.add(JBNeurologEF);
        JPExamenFisico.add(JBTPielEF);
        JPExamenFisico.add(JLBHcEF);
        JPExamenFisico.add(JTFCardiacoEF);
        JTBExFis.add(JPExFis, "SIGNOS VITALES");
        this.getContentPane().add(JPExamenFisico);
        JPExFis.add(JFTBtallaEF);
        JPExFis.add(JLBTallaEF);
        JPExFis.add(JLBkgEF);
        JPExFis.add(JFTPesoEF);
        JPExFis.add(JLBPesoEF);
        JPExFis.add(JLBfxm2EF);
        JPExFis.add(JFTfrEF);
        JPExFis.add(JLBfrEF);
        JPExFis.add(JLBfxm1EF);
        JPExFis.add(JLBfcEF);
        JPExFis.add(JFTTaEF);
        JPExFis.add(JLBmkgEF);
        JPExFis.add(JFTimcEF);
        JPExFis.add(JLBImc);
        JPExFis.add(JLBmtsEF);
        JPExFis.add(JLBRangoEF);
        JPExFis.add(JFTrangoEF);
        JPExFis.add(JLBTaEF);
        JPExFis.add(JLBLateralidad);
        JPExFis.add(JCBLateral);
        JPExFis.add(JFTfcEF);
        JBCab.setIcon(new ImageIcon(new java.net.URL("file:///c:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBCab.setSelectedIcon(null);
        llenarcomboeg();
        llenarcombolat();
      }

    /**
     * llenarcomboeg
     */
    public void llenarcomboeg() {
        String cadenaeg;
        cadenaeg="select *from estado_general ORDER BY estado_general.nombre_ag";
        objllencomboEFr.llenarcombos(cadenaeg,JCBEstadoGeneral,2);

    }

    public void JFTimcEF_focusGained(FocusEvent e) {
          double calcimc;double dif;int calcimcint;
          Double calcpeso=new Double(JFTPesoEF.getText());
          Double calctalla=new Double(JFTBtallaEF.getText());
          calcimc=calcpeso/(calctalla*calctalla);
          dif=calcimc-(int)calcimc;
          if(dif>0.5)
              calcimcint=(int)calcimc+1;
          else
              calcimcint=(int)calcimc;
          Integer Cimc=new Integer(calcimcint);
          String cadimc=Cimc.toString();
          JFTimcEF.setText(cadimc);
          JFTimcEF.setEditable(false);
          JFTrangoEF.setText(rango(calcimcint));
          JFTrangoEF.setEditable(false);
    }

    /**
     * rango
     */
    public String rango(int imc) {
        String resimc="";
        if(imc<=19)
           resimc="BAJO PESO";
        else
           if (imc<=25)
              resimc="NORMAL";
           else
             if (imc<=30)
                resimc="SOBREPESO";
             else
              if (imc<=35)
                resimc="OBESO LEVE";
              else
                if (imc<=40)
                   resimc="OBESO MODERADO";
                else
                  resimc="OBESO MORBIDO";
        return resimc;
    }

    /**
     * inicioradio
     */
    public void inicioradio() {
        JRsiCab.setSelected(true);
        JRsiCaraEF.setSelected(true);
        JRsiOjosEF.setSelected(true);
        JRsiOidosEF.setSelected(true);
        JRBsiNarizEF.setSelected(true);
        JRsiBocaEF.setSelected(true);
        JRsiDentEF.setSelected(true);
        JRBsiCuelloEF.setSelected(true);
        JRsiToraxEF.setSelected(true);
        JRBsicardiacoEF.setSelected(true);
        JRBsiPulmonEF.setSelected(true);
        JRsimamasEF.setSelected(true);
        JRBsiAbdomenEF.setSelected(true);
        JRsiGenitalesEF.setSelected(true);
        JRBsiMsupEF.setSelected(true);
        JRBsiMinfEF.setSelected(true);
        JRsiPiesEF.setSelected(true);
        JRBsiColEF.setSelected(true);
        JRBNeurEF.setSelected(true);
        JRBsiPiel.setSelected(true);
    }

    public void JRnoCab_actionPerformed(ActionEvent e) {
           JBCab.setEnabled(true);
           JRsiCab.setSelected(false);
    }

    public void JRnoCara_actionPerformed(ActionEvent e) {
         JBCaraEF.setEnabled(true);
         JRsiCaraEF.setSelected(false);
    }

    public void JRnoOjosEF_actionPerformed(ActionEvent e) {
         JBOjosEF.setEnabled(true);
         JRsiOjosEF.setSelected(false);
    }

    public void JRnoOidos_actionPerformed(ActionEvent e) {
          JBOidosEF.setEnabled(true);
          JRsiOidosEF.setSelected(false);
    }

    public void JRBnoNariz_actionPerformed(ActionEvent e) {
          JBnarizEF.setEnabled(true);
          JRBsiNarizEF.setSelected(false);
    }

    public void JRBnoBocaEF_actionPerformed(ActionEvent e) {
           JBbocaEF.setEnabled(true);
           JRsiBocaEF.setSelected(false);
    }

    public void JRBnoDentEF_actionPerformed(ActionEvent e) {
         JBDentEF.setEnabled(true);
         JRsiDentEF.setSelected(false);
    }

    public void JRBnoCuelloEF_actionPerformed(ActionEvent e) {
         JBCuelloEF.setEnabled(true);
         JRBsiCuelloEF.setSelected(false);
    }

    public void JRBnoToraxEF_actionPerformed(ActionEvent e) {
           JBToraxEF.setEnabled(true);
           JRsiToraxEF.setSelected(false);
    }

    public void JRBnoCardiacoEF_actionPerformed(ActionEvent e) {
          JBCardiacoEF.setEnabled(true);
          JRBsicardiacoEF.setSelected(false);
    }

    public void JRBnoPulmonEF_actionPerformed(ActionEvent e) {
           JBPulmonEF.setEnabled(true);
           JRBsiPulmonEF.setSelected(false);
    }

    public void JRBnomamasEF_actionPerformed(ActionEvent e) {
           JBmamasEF.setEnabled(true);
           JRsimamasEF.setSelected(false);
    }

    public void JRBnoAbdomenEF_actionPerformed(ActionEvent e) {
          JBAbdomenEF.setEnabled(true);
          JRBsiAbdomenEF.setSelected(false);
    }

    public void JRBnoGenitalesEF_actionPerformed(ActionEvent e) {
          JBGenitalesEF.setEnabled(true);
          JRsiGenitalesEF.setSelected(false);
          //JBGenitalesEF.setEnabled(false);
    }

    public void JRBnoMsupEF_actionPerformed(ActionEvent e) {
         JBMsupEF.setEnabled(true);
         JRBsiMsupEF.setSelected(false);
    }

    public void JRnoMinfEF_actionPerformed(ActionEvent e) {
         JBMinfEF.setEnabled(true);
         JRBsiMinfEF.setSelected(false);
    }

    public void JRBnoPiesEF_actionPerformed(ActionEvent e) {
         JBPiesEF.setEnabled(true);
         JRsiPiesEF.setSelected(false);
    }

    public void JRBnoColEF_actionPerformed(ActionEvent e) {
        JBColEF.setEnabled(true);
        JRBsiColEF.setSelected(false);
    }

    public void JRBnoNeurl_actionPerformed(ActionEvent e) {
        JBNeurologEF.setEnabled(true);
        JRBNeurEF.setSelected(false);
    }

    public void JRBnoPielEF_actionPerformed(ActionEvent e) {
        JBTPielEF.setEnabled(true);
        JRBsiPiel.setSelected(false);
    }

    public void JBCab_actionPerformed(ActionEvent e) {
          nombreefisico="CABEZA";swcabeza=1;
          abrirformulariodetEF(JTFCabeza);
    }

    /**
     * abrirformulariodetEF
     */
    public void abrirformulariodetEF(JTextField JFTabrirform) {
        JDesktopPane JDPIngresoEF=new JDesktopPane();
        JDPIngresoEF=(JDesktopPane)JDPIngresoobjEF;
        objEF.setVisible(false);
        CDetallesAP framedetallap= new  CDetallesAP(objEF);
        framedetantperso=framedetallap;procesoeditorEF(JFTabrirform);
        framedetallap.setBounds(0, 2, 550, 600);
        framedetallap.setTitle("DETALLES EXAMEN FISICO");
        JDPIngresoEF.add(framedetallap, new Integer(1));
        framedetallap.setLocation(234, 55);
        framedetallap.show();
        framedetallap.setVisible(true);
        framedetallap.JEDPdetAP.requestFocus();
    }

    /**
     * inicioventanaEF
     */
    public void inicioventanaEF(CExamenFisico frameEF) {
         objEF=frameEF;
    }

    /**
     * procesoeditorEF
     */
    public void procesoeditorEF(JTextField JFTvar) {
        CDetallesAP CDetEF;
        CDetEF=(CDetallesAP)framedetantperso;
        CDetEF.JEDPdetAP.setText(JFTvar.getText());
    }

    public void JBCaraEF_actionPerformed(ActionEvent e) {
        nombreefisico="CARA";swcara=1;
        abrirformulariodetEF(JTFcaraEF);
    }

    public void JBOjosEF_actionPerformed(ActionEvent e) {
        nombreefisico="OJOS";swojos=1;
        abrirformulariodetEF(JTFojosEF);
    }

    public void JBOidosEF_actionPerformed(ActionEvent e) {
        nombreefisico="OIDOS";swoidos=1;
        abrirformulariodetEF(JTFoidosEF);
     }

    public void JBnarizEF_actionPerformed(ActionEvent e) {
        nombreefisico="NARIZ";swnariz=1;
        abrirformulariodetEF(JTFnarizEF);
    }

    public void JBbocaEF_actionPerformed(ActionEvent e) {
        nombreefisico="BOCA";swboca=1;
        abrirformulariodetEF(JTFbocaEF);
    }

    public void JBDentEF_actionPerformed(ActionEvent e) {
        nombreefisico="DENTADURA";swdentadura=1;
        abrirformulariodetEF(JTFDentEF);
    }

    public void JBCuelloEF_actionPerformed(ActionEvent e) {
        nombreefisico="CUELLO";swcuello=1;
        abrirformulariodetEF(JTFcuelloEF);
    }

    public void JBToraxEF_actionPerformed(ActionEvent e) {
        nombreefisico="TORAX";swtorax=1;
        abrirformulariodetEF(JTFtoraxEF);
    }

    public void JBCardiacoEF_actionPerformed(ActionEvent e) {
        nombreefisico="CARDIACO";swcardiaco=1;
        abrirformulariodetEF(JTFCardiacoEF);
    }

    public void JBPulmonEF_actionPerformed(ActionEvent e) {
        nombreefisico="PULMONAR";swpulmon=1;
        abrirformulariodetEF(JTFPulmonEF);
    }

    public void JBmamasEF_actionPerformed(ActionEvent e) {
        nombreefisico="MAMAS";swmamas=1;
        abrirformulariodetEF(JTFMamasEF);
    }

    public void JBAbdomenEF_actionPerformed(ActionEvent e) {
        nombreefisico="ABDOMEN";swabdomen=1;
        abrirformulariodetEF(JTFAbdomenEF);
    }

    public void JBGenitalesEF_actionPerformed(ActionEvent e) {
        nombreefisico="GENITALES";swgenitales=1;
        abrirformulariodetEF(JTFGenitalesEF);
    }

    public void JBMsupEF_actionPerformed(ActionEvent e) {
        nombreefisico="MIEMBROS SUPERIORES";swmsup=1;
        abrirformulariodetEF(JTFMsup);
    }

    public void JBMinfEF_actionPerformed(ActionEvent e) {
        nombreefisico="MIEMBROS INFERIORES";swminf=1;
        abrirformulariodetEF(JTFMinfEF);
    }

    public void JBPiesEF_actionPerformed(ActionEvent e) {
        nombreefisico="PIES";swpies=1;
        abrirformulariodetEF(JTFPiesEF);
    }

    public void JBColEF_actionPerformed(ActionEvent e) {
        nombreefisico="COLUMNA";swcol=1;
        abrirformulariodetEF(JTFColEF);
    }

    public void JBNeurologEF_actionPerformed(ActionEvent e) {
        nombreefisico="NEUROLOGICO";swneurologico=1;
        abrirformulariodetEF(JTFNeurlogEF);swneurologico=1;
    }

    public void JBTPielEF_actionPerformed(ActionEvent e) {
        nombreefisico="PIEL";swpiel=1;
        abrirformulariodetEF(JTFPielEF);
    }

    public void JRsiCab_actionPerformed(ActionEvent e) {
        JRnoCab.setSelected(false);
        JTFCabeza.setText(" ");
        JBCab.setEnabled(false);
    }

    public void JRsiCaraEF_actionPerformed(ActionEvent e) {
           JRnoCara.setSelected(false);
           JTFcaraEF.setText(" ");
           JBCaraEF.setEnabled(false);
    }

    public void JRsiOjosEF_actionPerformed(ActionEvent e) {
          JRnoOjosEF.setSelected(false);
          JTFojosEF.setText(" ");
          JBOjosEF.setEnabled(false);
    }

    public void JRsiOidosEF_actionPerformed(ActionEvent e) {
           JRnoOidos.setSelected(false);
           JTFoidosEF.setText(" ");
           JBOidosEF.setEnabled(false);
    }

    public void JRBsiNarizEF_actionPerformed(ActionEvent e) {
          JRBnoNariz.setSelected(false);
          JTFnarizEF.setText(" ");
          JBnarizEF.setEnabled(false);
    }

    public void JRsiBocaEF_actionPerformed(ActionEvent e) {
         JRBnoBocaEF.setSelected(false);
         JTFbocaEF.setText(" ");
         JBbocaEF.setEnabled(false);
    }

    public void JRsiDentEF_actionPerformed(ActionEvent e) {
         JRBnoDentEF.setSelected(false);
         JTFDentEF.setText(" ");
         JBDentEF.setEnabled(false);
    }

    public void JRBsiCuelloEF_actionPerformed(ActionEvent e) {
         JRBnoCuelloEF.setSelected(false);
         JTFcuelloEF.setText(" ");
         JBCuelloEF.setEnabled(false);
    }

    public void JRsiToraxEF_actionPerformed(ActionEvent e) {
        JRBnoToraxEF.setSelected(false);
        JTFtoraxEF.setText(" ");
        JBToraxEF.setEnabled(false);
    }

    public void JRBsicardiacoEF_actionPerformed(ActionEvent e) {
          JRBnoCardiacoEF.setSelected(false);
          JTFCardiacoEF.setText(" ");
          JBCardiacoEF.setEnabled(false);
    }

    public void JRBsiPulmonEF_actionPerformed(ActionEvent e) {
         JRBnoPulmonEF.setSelected(false);
         JTFPulmonEF.setText(" ");
         JBPulmonEF.setEnabled(false);
    }

    public void JRsimamasEF_actionPerformed(ActionEvent e) {
        JRBnomamasEF.setSelected(false);
        JTFMamasEF.setText(" ");
        JBmamasEF.setEnabled(false);
    }

    public void JRBsiAbdomenEF_actionPerformed(ActionEvent e) {
        JRBnoAbdomenEF.setSelected(false);
        JTFAbdomenEF.setText(" ");
        JBAbdomenEF.setEnabled(false);
    }

    public void JRsiGenitalesEF_actionPerformed(ActionEvent e) {
       JRBnoGenitalesEF.setSelected(false);
       JTFGenitalesEF.setText(" ");
    }

    public void JRBsiMsupEF_actionPerformed(ActionEvent e) {
          JRBnoMsupEF.setSelected(false);
          JTFMsup.setText(" ");
          JBMsupEF.setEnabled(false);
    }

    public void JRBsiMinfEF_actionPerformed(ActionEvent e) {
         JRnoMinfEF.setSelected(false);
         JTFMinfEF.setText(" ");
         JBMinfEF.setEnabled(false);
    }

    public void JRsiPiesEF_actionPerformed(ActionEvent e) {
        JRBnoPiesEF.setSelected(false);
        JTFPiesEF.setText(" ");
        JBPiesEF.setEnabled(false);
    }

    public void JRBsiColEF_actionPerformed(ActionEvent e) {
        JRBnoColEF.setSelected(false);
        JTFColEF.setText(" ");
        JBColEF.setEnabled(false);
    }

    public void JRBNeurEF_actionPerformed(ActionEvent e) {
       JRBnoNeurl.setSelected(false);
       JTFNeurlogEF.setText(" ");
       JBNeurologEF.setEnabled(false);
    }

    public void JRBsiPiel_actionPerformed(ActionEvent e) {
        JRBnoPielEF.setSelected(false);
        JTFPielEF.setText(" ");
        JBTPielEF.setEnabled(false);
    }

    public void JBSgute_actionPerformed(ActionEvent e) {
           validarblancos();
           validarnulosEP();
    }

    public void JBAtrasEF_actionPerformed(ActionEvent e) {
        CRevisionSistemas frameEFAtras;
        frameEFAtras=(CRevisionSistemas)frameEFOBJ;
        frameEFAtras.setVisible(true);
        objEF.setVisible(false);

    }

    /**
     * procesocancelarEF
     */
    public void procesocancelarEF() {
       /*objEF.setVisible(false);
       objEF.dispose();
       varobjAF.procesocancelarAF();*/
    }

    public void JBCancelarEF_actionPerformed(ActionEvent e) {
         procesocancelarEF();
    }

    /**
     * method1
     */
    public void validarnulosEP() {
        //swval=0;
        CExamenFisico frameep;
        CIngreso frameingreso;
        CHistoriaOcup framehistocup;
        CEnfermedadProf frameenfermedadprof;
        CHistoriaAcciTrab frameaccitrabajo;
        CAntecedentesFamiliar frameantecendnetesfam;
        CAntecedentesPersonales frameantecpersonal;
        CAGineco frameginecologia;
        CInmuniz frameinmunuz;
        COtrosAnt frameotrosantecedentes;
        CRevisionSistemas framerevisioonsistemas;
        frameingreso=(CIngreso)frameingresoOBJ;
        //System.out.println("ramos:");
        frameep=(CExamenFisico)objEF;
        JDesktopPane JDPIngresoEP=new JDesktopPane();
        JDPIngresoEP=(JDesktopPane)JDPIngresoobjEF;
        framehistocup=(CHistoriaOcup)framehoOBJ;
        frameenfermedadprof=(CEnfermedadProf)frameEnfProfOBJ;
        frameaccitrabajo=(CHistoriaAcciTrab)frameAcciTrabajoOBJ;
        frameantecendnetesfam=(CAntecedentesFamiliar)frameAntecFamOBJ;
        frameantecpersonal=(CAntecedentesPersonales)frameAntecPersonalOBJ;
        framerevisioonsistemas=(CRevisionSistemas)frameRevisionSistemasOBJ;
        frameginecologia=(CAGineco)frameGinecologiaOBJ;
        frameinmunuz=(CInmuniz)frameInmunizOBJ;
        frameotrosantecedentes=(COtrosAnt)frameOtrosAntecOBJ;
       if(swgte==0){

            frameep.setVisible(false);
            CExamPraclin frameEP= new  CExamPraclin(obotactualizarEF,numingredicPC,swedicingrPC,nombref,frameep,numhcef,JDPIngresoEP,frameingreso,framehistocup,frameenfermedadprof,frameaccitrabajo,frameantecendnetesfam,frameantecpersonal,frameginecologia,frameinmunuz,frameotrosantecedentes,framerevisioonsistemas,objppalef);
            frameEP.setBounds(0, 2, 1010, 600);
            frameEP.setTitle("EXAMENES PARACLINICOS");
            JDPIngresoEP.add(frameEP, new Integer(1));
            frameEP.setLocation(5, 55);
            frameEP.show();
            frameEP.setVisible(true);
            frameEP.inicioventanaEP(frameEP);
            swgte=1;
            objetoaxamparaclin=frameEP;
            if(swedicingrPC==1){
                String cadsqledicPC,idestadogeneral,sqlPC;
                Connection con2=Cconsql.getConnection();
                cadsqledicPC="SELECT ingreso.id_ingreso, paraclinicos.observacion_examparacl, paraclinicos.visio_examparacl, paraclinicos.audio_examparacl, paraclinicos.espiro_examparacl, paraclinicos.hematico_examparacl, paraclinicos.alturas_examparacl, paraclinicos.quimica_examparacl, paraclinicos.diag1_examparacl, paraclinicos.diag2_examparacl, paraclinicos.diag3_examparacl, paraclinicos.diag4_examparacl, paraclinicos.electrocardiograma_examparacl, paraclinicos.otros_examparacli, paraclinicos.observacion_examppracli FROM ingreso INNER JOIN paraclinicos ON ingreso.id_ingreso = paraclinicos.idingreso_examparacl WHERE ingreso.id_ingreso="+numingredicPC;
                try{
                   TSentenciaconsultaPC = con2.createStatement();
                   RconsultaPC = TSentenciaconsultaPC.executeQuery(cadsqledicPC);
                   while (RconsultaPC.next()) {
                       frameEP.JTAExamPar.setText(RconsultaPC.getString(2));
                       frameEP.JCHVisiom.setSelected(RconsultaPC.getBoolean(3));
                       frameEP.JCHAudio.setSelected(RconsultaPC.getBoolean(4));
                       frameEP.JCHEspirom.setSelected(RconsultaPC.getBoolean(5));
                       frameEP.JCHhematico.setSelected(RconsultaPC.getBoolean(6));
                       frameEP.JCHAlturas.setSelected(RconsultaPC.getBoolean(7));
                       frameEP.JCHQuimica.setSelected(RconsultaPC.getBoolean(8));
                       frameEP.JTFDiaguno.setText(RconsultaPC.getString(9));
                       frameEP.JTFDos.setText(RconsultaPC.getString(10));
                       frameEP.JTFTres.setText(RconsultaPC.getString(11));
                       frameEP.JTFCuatro.setText(RconsultaPC.getString(12));
                       frameEP.JCHElectro.setSelected(RconsultaPC.getBoolean(13));
                       frameEP.JCHOtros.setSelected(RconsultaPC.getBoolean(14));
                       frameEP.JTFOtros.setText(RconsultaPC.getString(15));
                   }
                }
                catch(SQLException e1){
                  cad2="NO SE PUDO EJECUTAR LA CONSULTA";
                  cad1="PROBLEMAS CON LOS DATOS DE PARACLINICOS EN EDICION";
                  objllencomboEFr.mensajeconfirmacion(cad1,cad2);
                }//cierra el catch
                Cconsql.CerrarConexion();
             }

        }
        else{
            if(swval==0){
                frameep.setVisible(false);
            //swgte=0;
                System.out.println("matta:");
                CExamPraclin frameEP;
                frameEP=(CExamPraclin)objetoaxamparaclin;
          //ObjectCingreso.setVisible(false);
                frameEP.setVisible(true);
            }
            else{
              swval=0;swgte=0;
            }

        }


    }

    /**
     * llenarcombolat
     */
    public void llenarcombolat() {
        String cadenalat;
        cadenalat="select *from lateral ORDER BY lateral.nombre_lateral";
        objllencomboEFr.llenarcombos(cadenalat,JCBLateral,2);

    }

    public void JFTfcEF_focusLost(FocusEvent e) {
        if(JFTfcEF.getText().compareTo("")==0){
            objllencomboEFr.mensajeconfirmacion("EL CAMPO NO PUEDE ESTAR VACIO","ERROR DIGITACION");
            JFTfcEF.requestFocus();
            //System.out.println("matta:");
        }
    }

    public void JFTfcEF_keyReleased(KeyEvent e) {
        if (objllencomboEFr.validardigitosnuevo(e,JFTfcEF)==0){
             objllencomboEFr.mensajeconfirmacion("SOLO SE ACEPTAN DIGITOS","ERROR DIGITACION");
             //JTSuministros.setColumnSelectionInterval(JTSuministros.getSelectedRow(),2 );
          }//c

    }

    public void JFTfrEF_keyReleased(KeyEvent e) {
        if (objllencomboEFr.validardigitosnuevo(e,JFTfrEF)==0){
          objllencomboEFr.mensajeconfirmacion("SOLO SE ACEPTAN DIGITOS","ERROR DIGITACION");
          //JTSuministros.setColumnSelectionInterval(JTSuministros.getSelectedRow(),2 );
       }//c

    }

    public void JFTPesoEF_keyReleased(KeyEvent e) {
        if (objllencomboEFr.validardigitosnuevo(e,JFTPesoEF)==0){
            objllencomboEFr.mensajeconfirmacion("SOLO SE ACEPTAN DIGITOS","ERROR DIGITACION");
    //JTSuministros.setColumnSelectionInterval(JTSuministros.getSelectedRow(),2 );
         }//c
    }

    public void JFTBtallaEF_keyReleased(KeyEvent e) {
        if (objllencomboEFr.validardigitosnuevo(e,JFTBtallaEF)==0){
              objllencomboEFr.mensajeconfirmacion("SOLO SE ACEPTAN DIGITOS","ERROR DIGITACION");
      //JTSuministros.setColumnSelectionInterval(JTSuministros.getSelectedRow(),2 );
         }//c
    }

      public CExamenFisico() {

    }

    public void validarblancos() {
        if(JFTfcEF.getText().compareTo("")==0 || JFTTaEF.getText().compareTo("")==0  || JFTfcEF.getText().compareTo("")==0 || JFTfrEF.getText().compareTo("")==0  || JFTPesoEF.getText().compareTo("")==0  || JFTBtallaEF.getText().compareTo("")==0 || JFTimcEF.getText().compareTo("")==0 || JFTrangoEF.getText().compareTo("")==0){
            objllencomboEFr.mensajeconfirmacion("LOS SIGNOS VITALES TIENEN UN CAMPO VACIO","ERROR DIGITACION");
            swgte=1;swval=1;
        }

    }
}


class CExamenFisico_JFTBtallaEF_keyAdapter extends KeyAdapter {
    private CExamenFisico adaptee;
    CExamenFisico_JFTBtallaEF_keyAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JFTBtallaEF_keyReleased(e);
    }
}


class CExamenFisico_JFTPesoEF_keyAdapter extends KeyAdapter {
    private CExamenFisico adaptee;
    CExamenFisico_JFTPesoEF_keyAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JFTPesoEF_keyReleased(e);
    }
}


class CExamenFisico_JFTfrEF_keyAdapter extends KeyAdapter {
    private CExamenFisico adaptee;
    CExamenFisico_JFTfrEF_keyAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JFTfrEF_keyReleased(e);
    }
}


class CExamenFisico_JFTfcEF_keyAdapter extends KeyAdapter {
    private CExamenFisico adaptee;
    CExamenFisico_JFTfcEF_keyAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JFTfcEF_keyReleased(e);
    }
}


class CExamenFisico_JFTfcEF_focusAdapter extends FocusAdapter {
    private CExamenFisico adaptee;
    CExamenFisico_JFTfcEF_focusAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void focusLost(FocusEvent e) {
        adaptee.JFTfcEF_focusLost(e);
    }
}


class CExamenFisico_JBCancelarEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBCancelarEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCancelarEF_actionPerformed(e);
    }
}


class CExamenFisico_JBAtrasEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBAtrasEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasEF_actionPerformed(e);
    }
}


class CExamenFisico_JBSgute_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBSgute_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSgute_actionPerformed(e);
    }
}


class CExamenFisico_JRBsiPiel_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBsiPiel_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBsiPiel_actionPerformed(e);
    }
}


class CExamenFisico_JRBNeurEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBNeurEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBNeurEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBsiColEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBsiColEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBsiColEF_actionPerformed(e);
    }
}


class CExamenFisico_JRsiPiesEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRsiPiesEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRsiPiesEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBsiMinfEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBsiMinfEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBsiMinfEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBsiMsupEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBsiMsupEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBsiMsupEF_actionPerformed(e);
    }
}


class CExamenFisico_JRsiGenitalesEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRsiGenitalesEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRsiGenitalesEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBsiAbdomenEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBsiAbdomenEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBsiAbdomenEF_actionPerformed(e);
    }
}


class CExamenFisico_JRsimamasEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRsimamasEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRsimamasEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBsiPulmonEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBsiPulmonEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBsiPulmonEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBsicardiacoEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBsicardiacoEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBsicardiacoEF_actionPerformed(e);
    }
}


class CExamenFisico_JRsiToraxEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRsiToraxEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRsiToraxEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBsiCuelloEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBsiCuelloEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBsiCuelloEF_actionPerformed(e);
    }
}


class CExamenFisico_JRsiDentEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRsiDentEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRsiDentEF_actionPerformed(e);
    }
}


class CExamenFisico_JRsiBocaEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRsiBocaEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRsiBocaEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBsiNarizEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBsiNarizEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBsiNarizEF_actionPerformed(e);
    }
}


class CExamenFisico_JRsiOidosEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRsiOidosEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRsiOidosEF_actionPerformed(e);
    }
}


class CExamenFisico_JRsiOjosEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRsiOjosEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRsiOjosEF_actionPerformed(e);
    }
}


class CExamenFisico_JRsiCaraEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRsiCaraEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRsiCaraEF_actionPerformed(e);
    }
}


class CExamenFisico_JRsiCab_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRsiCab_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRsiCab_actionPerformed(e);
    }
}


class CExamenFisico_JBTPielEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBTPielEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBTPielEF_actionPerformed(e);
    }
}


class CExamenFisico_JBNeurologEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBNeurologEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBNeurologEF_actionPerformed(e);
    }
}


class CExamenFisico_JBColEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBColEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBColEF_actionPerformed(e);
    }
}


class CExamenFisico_JBPiesEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBPiesEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBPiesEF_actionPerformed(e);
    }
}


class CExamenFisico_JBMinfEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBMinfEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBMinfEF_actionPerformed(e);
    }
}


class CExamenFisico_JBMsupEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBMsupEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBMsupEF_actionPerformed(e);
    }
}


class CExamenFisico_JBGenitalesEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBGenitalesEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBGenitalesEF_actionPerformed(e);
    }
}


class CExamenFisico_JBAbdomenEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBAbdomenEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAbdomenEF_actionPerformed(e);
    }
}


class CExamenFisico_JBmamasEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBmamasEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBmamasEF_actionPerformed(e);
    }
}


class CExamenFisico_JBPulmonEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBPulmonEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBPulmonEF_actionPerformed(e);
    }
}


class CExamenFisico_JBCardiacoEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBCardiacoEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCardiacoEF_actionPerformed(e);
    }
}


class CExamenFisico_JBToraxEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBToraxEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBToraxEF_actionPerformed(e);
    }
}


class CExamenFisico_JBCuelloEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBCuelloEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCuelloEF_actionPerformed(e);
    }
}


class CExamenFisico_JBDentEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBDentEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDentEF_actionPerformed(e);
    }
}


class CExamenFisico_JBbocaEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBbocaEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBbocaEF_actionPerformed(e);
    }
}


class CExamenFisico_JBnarizEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBnarizEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBnarizEF_actionPerformed(e);
    }
}


class CExamenFisico_JBOidosEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBOidosEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBOidosEF_actionPerformed(e);
    }
}


class CExamenFisico_JBOjosEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBOjosEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBOjosEF_actionPerformed(e);
    }
}


class CExamenFisico_JBCaraEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBCaraEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCaraEF_actionPerformed(e);
    }
}


class CExamenFisico_JBCab_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JBCab_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCab_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoPielEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoPielEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoPielEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoNeurl_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoNeurl_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoNeurl_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoColEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoColEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoColEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoPiesEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoPiesEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoPiesEF_actionPerformed(e);
    }
}


class CExamenFisico_JRnoMinfEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRnoMinfEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRnoMinfEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoMsupEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoMsupEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoMsupEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoGenitalesEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoGenitalesEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoGenitalesEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoAbdomenEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoAbdomenEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoAbdomenEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnomamasEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnomamasEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnomamasEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoPulmonEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoPulmonEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoPulmonEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoCardiacoEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoCardiacoEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoCardiacoEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoToraxEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoToraxEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoToraxEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoCuelloEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoCuelloEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoCuelloEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoDentEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoDentEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoDentEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoBocaEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoBocaEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoBocaEF_actionPerformed(e);
    }
}


class CExamenFisico_JRBnoNariz_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRBnoNariz_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBnoNariz_actionPerformed(e);
    }
}


class CExamenFisico_JRnoOidos_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRnoOidos_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRnoOidos_actionPerformed(e);
    }
}


class CExamenFisico_JRnoOjosEF_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRnoOjosEF_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRnoOjosEF_actionPerformed(e);
    }
}


class CExamenFisico_JRnoCara_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRnoCara_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRnoCara_actionPerformed(e);
    }
}


class CExamenFisico_JRnoCab_actionAdapter implements ActionListener {
    private CExamenFisico adaptee;
    CExamenFisico_JRnoCab_actionAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRnoCab_actionPerformed(e);
    }
}


class CExamenFisico_JFTimcEF_focusAdapter extends FocusAdapter {
    private CExamenFisico adaptee;
    CExamenFisico_JFTimcEF_focusAdapter(CExamenFisico adaptee) {
        this.adaptee = adaptee;
    }

    public void focusGained(FocusEvent e) {
        adaptee.JFTimcEF_focusGained(e);
    }
}

