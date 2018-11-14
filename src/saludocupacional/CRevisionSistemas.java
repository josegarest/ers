package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class CRevisionSistemas extends JInternalFrame {

    Object objppalrs;
    Object obotactualizarEF;
    ValidarComponentes validEF = new ValidarComponentes();
    String cad1;
    String cad2;
    public Statement TSentenciaconsultaEF;
    public ResultSet RconsultaEF;
    public ConexionSql Cconsql = new ConexionSql();
    String numingredicEF;
    int swedicingrEF;
    int swgte;
    Object objetoexamfisico = new Object();
    int swval;
    //CRevisionSistemas objCRS;
    Object objCRS = new Object();
    Object JDPIngresoobjRS = new Object();
    String nombrrs = new String();
    String numhcrs = new String();
    Object framehoOBJ = new Object();
    Object frameEnfProfOBJ = new Object();
    Object frameAcciTrabajoOBJ = new Object();
    Object frameAntecFamOBJ = new Object();
    Object frameAntecPersonalOBJ = new Object();
    Object frameGinecologiaOBJ = new Object();
    Object frameInmunizOBJ = new Object();
    Object frameOtrosAntecOBJ = new Object();
    Object frameRSOBJ = new Object();
    Object frameOAOBJ = new Object();
    Object objRS;
    Object objApersonal;
    Object objmotenfe;
    Object objetoingreso;
    Object objetoAntfamiliar;
    Object objetoOtrosAntc;
    Object objetoEfisico;
    int swgteRS;
    public String nombredetalleRS;
    public Object framedetRS = new Object();
    public JDesktopPane JDPrs = new JDesktopPane();
    Object objAFamiliar;
    //DECLARACION DE SW
    public static int swdolorprecordial;
    public static int swdlipotimia;
    public static int swpalpitaciones;
    public static int swsincope;
    public static int swdisnea;
    public static int swdescamacion;
    public static int swdolorabdominal;
    public static int swepigastraigia;
    public static int swestrenimiento;
    public static int swdiarrea;
    public static int swsangrado;
    public static int sweritema;
    public static int swhiperhidrosis;
    public static int swbrote;
    public static int swsequedad;
    public static int swprurito;
    public static int swdispepsia;
    public static int swdisminucioncalibre;
    public static int swdisuria;
    public static int swhematuria;
    public static int swtransciclomestrual;
    public static int swnicturia;
    public static int swpolaquiuria;
    public static int swtenesmovesical;
    public static int swcefalea;
    public static int swalteracionmemoria;
    public static int swealteraciosensibilidad;
    public static int swalteracionmotora;
    public static int swvertigo;
    public static int swardorprurito;
    public static int swcansancio;
    public static int swvisionborrosa;
    public static int swlagrimeo;
    public static int swojorojo;
    public static int swtos;
    public static int swdolortoraxico;
    public static int swexpectoracion;
    public static int swdisfonia;
    public static int swepistaxis;
    public static int swhipoacusia;
    public static int swobstruccionnasal;
    public static int swrinorrea;
    public static int swtinitus;
    public static int swartralgias;
    public static int swtendinitis;
    public static int swlimitacionfuncional;
    public static int swparestesias;
    public static int swcervicalgias;
    public static int swdorsalgia;
    public static int swlumbalgia;
    public static int swincapacitante;
    public static int swcoronaria;
    public static int swarritmia;
    public static int swHA;
    //DECLARACION DE COMPONENTES
    JPanel JPRevisionSistemas = new JPanel();
    JButton JBAtrasRS = new JButton();
    JButton JBSguteRV = new JButton();
    JButton JBcancelarRS = new JButton();
    JLabel JLBNumhcRS = new JLabel();
    JLabel JLBNhc2RS = new JLabel();
    JPanel JPCardiovascularRS = new JPanel();
    JLabel JLBCardiovascular = new JLabel();
    JRadioButton JRDolorPrecordial = new JRadioButton();
    JButton JBDolorPrecordial = new JButton();
    JRadioButton JRLipotimia = new JRadioButton();
    JButton JBLipotimia = new JButton();
    JRadioButton JRPalpitaciones = new JRadioButton();
    JButton JBPalpitaciones = new JButton();
    JRadioButton JRSincope = new JRadioButton();
    JButton JBSincope = new JButton();
    JRadioButton JRDisnea = new JRadioButton();
    JButton JBDisnea = new JButton();
    JPanel JPDermatologico = new JPanel();
    JLabel JLBDermatologico = new JLabel();
    JRadioButton JRBrote = new JRadioButton();
    JRadioButton JREritema = new JRadioButton();
    JRadioButton JRDescamacion = new JRadioButton();
    JRadioButton JRSequedad = new JRadioButton();
    JRadioButton JRHiperhidrosis = new JRadioButton();
    JButton JBDescamacion = new JButton();
    JButton JBEritema = new JButton();
    JButton JBHiperhidrosis = new JButton();
    JButton jButton1 = new JButton();
    JButton JBBrote = new JButton();
    JButton JBSequedad = new JButton();
    JRadioButton JRPrurito = new JRadioButton();
    JButton JBPrurito = new JButton();
    JPanel JPDigestivo = new JPanel();
    JLabel JLDigestivo = new JLabel();
    JRadioButton JREstrenimiento = new JRadioButton();
    JRadioButton JRSangrado = new JRadioButton();
    JRadioButton JREpigastraigia = new JRadioButton();
    JRadioButton JRDiarrea = new JRadioButton();
    JRadioButton JRDispepsia = new JRadioButton();
    JRadioButton JRDolorAbdominal = new JRadioButton();
    JButton JBDispepsia = new JButton();
    JButton JBDolorAbdominal = new JButton();
    JButton JBEpigastraigia = new JButton();
    JButton JBEstrenimiento = new JButton();
    JButton JBDiarrea = new JButton();
    JButton JBSangrado = new JButton();
    JPanel JPGenitoUrinario = new JPanel();
    JRadioButton JRNicturia = new JRadioButton();
    JLabel JLBGenitourinario = new JLabel();
    JRadioButton JRTrantCicloMestr = new JRadioButton();
    JRadioButton JRHematuria = new JRadioButton();
    JRadioButton JRDisuria = new JRadioButton();
    JRadioButton JRDisminucionCalibre = new JRadioButton();
    JRadioButton JRPolaquiuria = new JRadioButton();
    JButton JBDisminucionCalibre = new JButton();
    JButton JBDisuria = new JButton();
    JButton JBHematuria = new JButton();
    JButton JBTranstCicloMestrual = new JButton();
    JButton JBNicturia = new JButton();
    JButton JBPalaquiuria = new JButton();
    JRadioButton JRTenesmoVesical = new JRadioButton();
    JButton JBTenesmoVesical = new JButton();
    JPanel JPNeurologico = new JPanel();
    JLabel JLBNeurologico = new JLabel();
    JRadioButton JRAlteracionMotora = new JRadioButton();
    JRadioButton JRAlteracionSensib = new JRadioButton();
    JRadioButton JRVertigo = new JRadioButton();
    JRadioButton JRCefalea = new JRadioButton();
    JRadioButton JRAlteracionMemoria = new JRadioButton();
    JButton JBCefalea = new JButton();
    JButton JBAlteracionMemoria = new JButton();
    JButton JBAlteracionSensibilidad = new JButton();
    JButton JBAlteracionMotora = new JButton();
    JButton JBVertigo = new JButton();
    JPanel JPOcular = new JPanel();
    JLabel JLBOcular = new JLabel();
    JRadioButton JRLagrimeo = new JRadioButton();
    JRadioButton JROjoRojo = new JRadioButton();
    JRadioButton JRVisionBorrosa = new JRadioButton();
    JRadioButton JRArdorprurito = new JRadioButton();
    JRadioButton JRCansancio = new JRadioButton();
    JButton JBArdor = new JButton();
    JButton JBCansancio = new JButton();
    JButton JBVisionBorrosa = new JButton();
    JButton JBLagrimeo = new JButton();
    JButton JBOjoRojo = new JButton();
    JPanel JPRespiratorio = new JPanel();
    JRadioButton JRExpectoracion = new JRadioButton();
    JRadioButton JRDolorToraxico = new JRadioButton();
    JRadioButton JRTos = new JRadioButton();
    JButton JBTos = new JButton();
    JButton JBDolorToraxico = new JButton();
    JButton JBExpectoracion = new JButton();
    JPanel JPOsteomuscular = new JPanel();
    JTabbedPane JTOsteomuscular = new JTabbedPane();
    JPanel JPTOsteomuscular = new JPanel();
    JPanel JPTOsteomuscular2 = new JPanel();
    JRadioButton JRCervicalgia = new JRadioButton();
    JButton JBCervicalgia = new JButton();
    JRadioButton JRDorsalgia = new JRadioButton();
    JButton JBDorsalgia = new JButton();
    JRadioButton JRLumbalgia = new JRadioButton();
    JButton JBLumbalgia = new JButton();
    JRadioButton JRIncapacitante = new JRadioButton();
    JButton JBIncapacitante = new JButton();
    JCheckBox JCHCentral = new JCheckBox();
    JCheckBox JCHLeve = new JCheckBox();
    JCheckBox JCHSevera = new JCheckBox();
    JCheckBox JCHPeriferica = new JCheckBox();
    JCheckBox JCHModerada = new JCheckBox();
    JRadioButton JRArtralgias = new JRadioButton();
    JButton JBArtralgias = new JButton();
    JRadioButton JRTendinitis = new JRadioButton();
    JButton JBTendinitis = new JButton();
    JRadioButton JRLimitacionFuncional = new JRadioButton();
    JButton JBLimitacionFuncional = new JButton();
    JRadioButton JRParentestesias = new JRadioButton();
    JButton JBParestesias = new JButton();
    JTabbedPane JTRespiratorioORL = new JTabbedPane();
    JPanel JPorl = new JPanel();
    JRadioButton JRDisfonia = new JRadioButton();
    JButton JBDisfonia = new JButton();
    JRadioButton JREpistaxis = new JRadioButton();
    JButton JBEpistaxis = new JButton();
    JRadioButton JRHipoacusia = new JRadioButton();
    JButton JBHipoacusia = new JButton();
    JRadioButton JRObstruccionNasal = new JRadioButton();
    JButton JBObstruccionNasal = new JButton();
    JRadioButton JRRinorrea = new JRadioButton();
    JButton JBRinorrea = new JButton();
    JRadioButton JRTinitus = new JRadioButton();
    JButton JBTinitus = new JButton();
    JFormattedTextField JFTDolorPrecordial = new JFormattedTextField();
    JFormattedTextField JFTLipotimia = new JFormattedTextField();
    JFormattedTextField JFTPalpit = new JFormattedTextField();
    JFormattedTextField JFTSincope = new JFormattedTextField();
    JFormattedTextField jFormattedTextField2 = new JFormattedTextField();
    JFormattedTextField JFTdescam = new JFormattedTextField();
    JFormattedTextField JFTEritema = new JFormattedTextField();
    JFormattedTextField JFTHiperhidrosis = new JFormattedTextField();
    JFormattedTextField JFTBrote = new JFormattedTextField();
    JFormattedTextField JFTSequedad = new JFormattedTextField();
    JFormattedTextField JFTprurito = new JFormattedTextField();
    JFormattedTextField JFTDispepsia = new JFormattedTextField();
    JFormattedTextField JFTDolorAbd = new JFormattedTextField();
    JFormattedTextField JFTEpigastr = new JFormattedTextField();
    JFormattedTextField JFTEstrenimiento = new JFormattedTextField();
    JFormattedTextField JFTDiarrea = new JFormattedTextField();
    JFormattedTextField JFTSangrado = new JFormattedTextField();
    JFormattedTextField JFTDisminucionCalibre = new JFormattedTextField();
    JFormattedTextField JFTDisuria = new JFormattedTextField();
    JFormattedTextField JFTHematuria = new JFormattedTextField();
    JFormattedTextField JFTtranstCicloMestr = new JFormattedTextField();
    JFormattedTextField JFTNicturia = new JFormattedTextField();
    JFormattedTextField JFTPalquiuria = new JFormattedTextField();
    JFormattedTextField JFTTenesmovesical = new JFormattedTextField();
    JFormattedTextField JFTCefalea = new JFormattedTextField();
    JFormattedTextField JFTAlteracionMemoria = new JFormattedTextField();
    JFormattedTextField JFTAlteracionSencib = new JFormattedTextField();
    JFormattedTextField JFTAlteracMotora = new JFormattedTextField();
    JFormattedTextField JFTVertigo = new JFormattedTextField();
    JFormattedTextField JFTArdorPrurito = new JFormattedTextField();
    JFormattedTextField JFTCansancio = new JFormattedTextField();
    JFormattedTextField JFTVisionBorrosa = new JFormattedTextField();
    JFormattedTextField JFTLagrimeo = new JFormattedTextField();
    JFormattedTextField JFTOjoRojo = new JFormattedTextField();
    JFormattedTextField JFTTos = new JFormattedTextField();
    JFormattedTextField JFTDolorToraxico = new JFormattedTextField();
    JFormattedTextField JFTExpectoracion = new JFormattedTextField();
    JFormattedTextField JFTDisfonia = new JFormattedTextField();
    JFormattedTextField JFTEpistaxis = new JFormattedTextField();
    JFormattedTextField JFTHipoacusia = new JFormattedTextField();
    JFormattedTextField JFTObstruccionNasal = new JFormattedTextField();
    JFormattedTextField JFTRinorrea = new JFormattedTextField();
    JFormattedTextField JFTTinitus = new JFormattedTextField();
    JFormattedTextField JFTArtralgias = new JFormattedTextField();
    JFormattedTextField JFTTendinitis = new JFormattedTextField();
    JFormattedTextField JFTLimitacionFunc = new JFormattedTextField();
    JFormattedTextField JFTParestesias = new JFormattedTextField();
    JFormattedTextField JFTCervicalgia = new JFormattedTextField();
    JFormattedTextField JFTDorsalgia = new JFormattedTextField();
    JFormattedTextField JFTLumbalgia = new JFormattedTextField();
    JFormattedTextField JFTIncapacitante = new JFormattedTextField();
    JPanel JPAltura = new JPanel();
    JRadioButton JRCoronaria = new JRadioButton();
    JFormattedTextField JFTCoronaria = new JFormattedTextField();
    JButton JBcoronaria = new JButton();
    JButton JBArritmia = new JButton();
    JButton JBHa = new JButton();
    JRadioButton JRArritmia = new JRadioButton();
    JFormattedTextField JFTArritmia = new JFormattedTextField();
    JRadioButton JRHa = new JRadioButton();
    JFormattedTextField JFTha = new JFormattedTextField();

    public CRevisionSistemas(Object obotactualizarOA, String numingredicRS, int swedicingrRS, String Nombrepacrs, COtrosAnt frameoa, String varnHC, JDesktopPane JDPIngreso, CIngreso frameingreso, CHistoriaOcup framehistocup, CEnfermedadProf frameenfermedadprof, CHistoriaAcciTrab frameaccitrabajo, CAntecedentesFamiliar frameantecendnetesfam, CAntecedentesPersonales frameantecpersonal, CAGineco frameginecologia, CInmuniz frameinmunuz, Object objppaloa) {
        try {
            jbInit();
            frameRSOBJ = frameingreso;
            framehoOBJ = framehistocup;
            frameEnfProfOBJ = frameenfermedadprof;
            frameAcciTrabajoOBJ = frameaccitrabajo;
            frameAntecFamOBJ = frameantecendnetesfam;
            frameAntecPersonalOBJ = frameantecpersonal;
            frameGinecologiaOBJ = frameginecologia;
            frameInmunizOBJ = frameinmunuz;
            //frameOtrosAntecOBJ=frameotrosantecedentes;
            frameOAOBJ = frameoa;
            JLBNumhcRS.setText(Nombrepacrs);
            JLBNhc2RS.setText(varnHC);
            JDPIngresoobjRS = JDPIngreso;
            nombrrs = Nombrepacrs;
            numhcrs = varnHC;
            swgte = 0;
            swedicingrEF = swedicingrRS;
            numingredicEF = numingredicRS;
            obotactualizarEF = obotactualizarOA;
            objppalrs = objppaloa;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        JPRevisionSistemas.setBackground(new Color(122, 150, 223));
        JPRevisionSistemas.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPRevisionSistemas.setBorder(BorderFactory.createRaisedBevelBorder());
        JPRevisionSistemas.setBounds(new Rectangle(-1, 2, 1000, 559));
        JPRevisionSistemas.setLayout(null);
        //INICIALIZACION DE LOS PANELES
        this.setClosable(true);
        this.setIconifiable(true);
        this.setMaximizable(true);
        this.setResizable(true);
        this.setVisible(true);
        JBAtrasRS.setBounds(new Rectangle(139, 521, 112, 36));
        JBAtrasRS.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBAtrasRS.setMnemonic('R');
        JBAtrasRS.setText("Atras");
        JBAtrasRS.addActionListener(new CRevisionSistemas_JBAtrasRS_actionAdapter(this));
        JBAtrasRS.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN3.GIF")));
        JBAtrasRS.setSelectedIcon(null);
        JBSguteRV.setBounds(new Rectangle(434, 519, 133, 36));
        JBSguteRV.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBSguteRV.setToolTipText("");
        JBSguteRV.setMnemonic('S');
        JBSguteRV.setText("SIGUIENTE");
        JBSguteRV.addActionListener(new CRevisionSistemas_JBSguteRV_actionAdapter(this));
        JBSguteRV.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN3.GIF")));
        JBSguteRV.setSelectedIcon(null);
        JBcancelarRS.setBounds(new Rectangle(749, 522, 131, 36));
        JBcancelarRS.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBcancelarRS.setToolTipText("");
        JBcancelarRS.setMnemonic('S');
        JBcancelarRS.setText("CANCELAR");
        JBcancelarRS.addActionListener(new CRevisionSistemas_JBcancelarRS_actionAdapter(this));
        JBcancelarRS.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN3.GIF")));
        JBcancelarRS.setSelectedIcon(null);
        JLBNumhcRS.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNumhcRS.setForeground(Color.red);
        JLBNumhcRS.setToolTipText("");
        JLBNumhcRS.setBounds(new Rectangle(7, 0, 510, 34));
        JLBNhc2RS.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNhc2RS.setForeground(Color.red);
        JLBNhc2RS.setToolTipText("");
        JLBNhc2RS.setBounds(new Rectangle(786, 0, 191, 34));
        JPCardiovascularRS.setBackground(Color.white);
        JPCardiovascularRS.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPCardiovascularRS.setBorder(BorderFactory.createRaisedBevelBorder());
        JPCardiovascularRS.setBounds(new Rectangle(8, 31, 223, 257));
        JPCardiovascularRS.setLayout(null);
        JLBCardiovascular.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBCardiovascular.setForeground(Color.red);
        JLBCardiovascular.setToolTipText("");
        JLBCardiovascular.setText("CARDIOVASCULAR");
        JLBCardiovascular.setBounds(new Rectangle(7, 0, 108, 28));
        JRDolorPrecordial.setBackground(Color.white);
        JRDolorPrecordial.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRDolorPrecordial.setToolTipText("");
        JRDolorPrecordial.setText("Dolor Precordial");
        JRDolorPrecordial.setBounds(new Rectangle(1, 17, 121, 26));
        JRDolorPrecordial.addActionListener(new CRevisionSistemas_JRDolorPrecordial_actionAdapter(this));
        JBDolorPrecordial.setBounds(new Rectangle(160, 14, 57, 29));
        JBDolorPrecordial.setBorder(BorderFactory.createLineBorder(Color.black));
        JBDolorPrecordial.setActionCommand("JBDiabet");
        JBDolorPrecordial.setText("jButton1");
        JBDolorPrecordial.addActionListener(new CRevisionSistemas_JBDolorPrecordial_actionAdapter(this));
        JBDolorPrecordial.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDolorPrecordial.setSelectedIcon(null);
        JRLipotimia.setBackground(Color.white);
        JRLipotimia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRLipotimia.setToolTipText("");
        JRLipotimia.setText("Lipotimia");
        JRLipotimia.setBounds(new Rectangle(1, 48, 121, 26));
        JRLipotimia.addActionListener(new CRevisionSistemas_JRLipotimia_actionAdapter(this));
        JBLipotimia.setBounds(new Rectangle(160, 46, 57, 29));
        JBLipotimia.setEnabled(false);
        JBLipotimia.setBorder(BorderFactory.createLineBorder(Color.black));
        JBLipotimia.setActionCommand("JBDiabet");
        JBLipotimia.setText("jButton1");
        JBLipotimia.addActionListener(new CRevisionSistemas_JBLipotimia_actionAdapter(this));
        JBLipotimia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBLipotimia.setSelectedIcon(null);
        JRPalpitaciones.setBackground(Color.white);
        JRPalpitaciones.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRPalpitaciones.setToolTipText("");
        JRPalpitaciones.setText("Palpitaciones");
        JRPalpitaciones.setBounds(new Rectangle(1, 80, 121, 26));
        JRPalpitaciones.addActionListener(new CRevisionSistemas_JRPalpitaciones_actionAdapter(this));
        JBPalpitaciones.setBounds(new Rectangle(160, 79, 57, 29));
        JBPalpitaciones.setEnabled(false);
        JBPalpitaciones.setBorder(BorderFactory.createLineBorder(Color.black));
        JBPalpitaciones.setActionCommand("JBDiabet");
        JBPalpitaciones.setText("jButton1");
        JBPalpitaciones.addActionListener(new CRevisionSistemas_JBPalpitaciones_actionAdapter(this));
        JBPalpitaciones.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBPalpitaciones.setSelectedIcon(null);
        JRSincope.setBackground(Color.white);
        JRSincope.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRSincope.setToolTipText("");
        JRSincope.setText("Sincope");
        JRSincope.setBounds(new Rectangle(1, 112, 121, 26));
        JRSincope.addActionListener(new CRevisionSistemas_JRSincope_actionAdapter(this));
        JBSincope.setBounds(new Rectangle(160, 112, 57, 29));
        JBSincope.setEnabled(false);
        JBSincope.setBorder(BorderFactory.createLineBorder(Color.black));
        JBSincope.setActionCommand("JBDiabet");
        JBSincope.setText("jButton1");
        JBSincope.addActionListener(new CRevisionSistemas_JBSincope_actionAdapter(this));
        JBSincope.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBSincope.setSelectedIcon(null);
        JRDisnea.setBackground(Color.white);
        JRDisnea.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRDisnea.setToolTipText("");
        JRDisnea.setText("Disnea");
        JRDisnea.setBounds(new Rectangle(1, 145, 121, 26));
        JRDisnea.addActionListener(new CRevisionSistemas_JRDisnea_actionAdapter(this));
        JBDisnea.setBounds(new Rectangle(160, 145, 57, 29));
        JBDisnea.setEnabled(false);
        JBDisnea.setBorder(BorderFactory.createLineBorder(Color.black));
        JBDisnea.setActionCommand("JBDiabet");
        JBDisnea.setText("jButton1");
        JBDisnea.addActionListener(new CRevisionSistemas_JBDisnea_actionAdapter(this));
        JBDisnea.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDisnea.setSelectedIcon(null);
        JPDermatologico.setBackground(Color.white);
        JPDermatologico.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPDermatologico.setBorder(BorderFactory.createRaisedBevelBorder());
        JPDermatologico.setBounds(new Rectangle(261, 30, 223, 256));
        JPDermatologico.setLayout(null);
        JLBDermatologico.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBDermatologico.setForeground(Color.red);
        JLBDermatologico.setToolTipText("");
        JLBDermatologico.setText("DERMATOLOGICO");
        JLBDermatologico.setBounds(new Rectangle(4, 7, 101, 14));
        JRBrote.setBackground(Color.white);
        JRBrote.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRBrote.setToolTipText("");
        JRBrote.setText("Brote");
        JRBrote.setBounds(new Rectangle(1, 113, 113, 23));
        JRBrote.addActionListener(new CRevisionSistemas_JRBrote_actionAdapter(this));
        JREritema.setBackground(Color.white);
        JREritema.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JREritema.setToolTipText("");
        JREritema.setText("Eritema");
        JREritema.setBounds(new Rectangle(1, 52, 77, 23));
        JREritema.addActionListener(new CRevisionSistemas_JREritema_actionAdapter(this));
        JRDescamacion.setBackground(Color.white);
        JRDescamacion.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRDescamacion.setToolTipText("");
        JRDescamacion.setText("Descamacion");
        JRDescamacion.setBounds(new Rectangle(1, 23, 99, 23));
        JRDescamacion.addActionListener(new CRevisionSistemas_JRDescamacion_actionAdapter(this));
        JRSequedad.setBackground(Color.white);
        JRSequedad.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRSequedad.setToolTipText("");
        JRSequedad.setText("Sequedad");
        JRSequedad.setBounds(new Rectangle(2, 149, 80, 23));
        JRSequedad.addActionListener(new CRevisionSistemas_JRSequedad_actionAdapter(this));
        JRHiperhidrosis.setBackground(Color.white);
        JRHiperhidrosis.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRHiperhidrosis.setToolTipText("");
        JRHiperhidrosis.setText("Hiperhidrosis");
        JRHiperhidrosis.setBounds(new Rectangle(1, 81, 111, 23));
        JRHiperhidrosis.addActionListener(new CRevisionSistemas_JRHiperhidrosis_actionAdapter(this));
        JBDescamacion.setBounds(new Rectangle(160, 17, 57, 29));
        JBDescamacion.setEnabled(false);
        JBDescamacion.setBorder(BorderFactory.createLineBorder(Color.black));
        JBDescamacion.setActionCommand("JBDiabet");
        JBDescamacion.setText("jButton1");
        JBDescamacion.addActionListener(new CRevisionSistemas_JBDescamacion_actionAdapter(this));
        JBDescamacion.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDescamacion.setSelectedIcon(null);
        JBEritema.setBounds(new Rectangle(159, 50, 57, 29));
        JBEritema.setEnabled(false);
        JBEritema.setBorder(BorderFactory.createLineBorder(Color.black));
        JBEritema.setActionCommand("JBDiabet");
        JBEritema.setText("jButton1");
        JBEritema.addActionListener(new CRevisionSistemas_JBEritema_actionAdapter(this));
        JBEritema.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBEritema.setSelectedIcon(null);
        JBHiperhidrosis.setBounds(new Rectangle(159, 82, 57, 29));
        JBHiperhidrosis.setEnabled(false);
        JBHiperhidrosis.setBorder(BorderFactory.createLineBorder(Color.black));
        JBHiperhidrosis.setActionCommand("JBDiabet");
        JBHiperhidrosis.setText("jButton1");
        JBHiperhidrosis.addActionListener(new CRevisionSistemas_JBHiperhidrosis_actionAdapter(this));
        JBHiperhidrosis.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBHiperhidrosis.setSelectedIcon(null);
        jButton1.setBounds(new Rectangle(159, 50, 57, 29));
        jButton1.setBorder(BorderFactory.createLineBorder(Color.black));
        jButton1.setActionCommand("JBDiabet");
        jButton1.setText("jButton1");
        JBBrote.setBounds(new Rectangle(159, 114, 57, 29));
        JBBrote.setEnabled(false);
        JBBrote.setBorder(BorderFactory.createLineBorder(Color.black));
        JBBrote.setActionCommand("JBDiabet");
        JBBrote.setText("jButton1");
        JBBrote.addActionListener(new CRevisionSistemas_JBBrote_actionAdapter(this));
        JBBrote.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBBrote.setSelectedIcon(null);
        JBSequedad.setBounds(new Rectangle(159, 147, 57, 29));
        JBSequedad.setEnabled(false);
        JBSequedad.setBorder(BorderFactory.createLineBorder(Color.black));
        JBSequedad.setActionCommand("JBDiabet");
        JBSequedad.setText("jButton1");
        JBSequedad.addActionListener(new CRevisionSistemas_JBSequedad_actionAdapter(this));
        JBSequedad.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBSequedad.setSelectedIcon(null);
        JRPrurito.setBackground(Color.white);
        JRPrurito.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRPrurito.setToolTipText("");
        JRPrurito.setText("Prurito");
        JRPrurito.setBounds(new Rectangle(2, 182, 80, 23));
        JRPrurito.addActionListener(new CRevisionSistemas_JRPrurito_actionAdapter(this));
        JBPrurito.setBounds(new Rectangle(159, 180, 57, 29));
        JBPrurito.setEnabled(false);
        JBPrurito.setBorder(BorderFactory.createLineBorder(Color.black));
        JBPrurito.setActionCommand("JBDiabet");
        JBPrurito.setText("jButton1");
        JBPrurito.addActionListener(new CRevisionSistemas_JBPrurito_actionAdapter(this));
        JBPrurito.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBPrurito.setSelectedIcon(null);
        JPDigestivo.setBackground(Color.white);
        JPDigestivo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPDigestivo.setBorder(BorderFactory.createRaisedBevelBorder());
        JPDigestivo.setBounds(new Rectangle(515, 29, 223, 255));
        JPDigestivo.setLayout(null);
        JLDigestivo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLDigestivo.setForeground(Color.red);
        JLDigestivo.setToolTipText("");
        JLDigestivo.setText("DIGESTIVO");
        JLDigestivo.setBounds(new Rectangle(3, 6, 95, 14));
        JREstrenimiento.setBackground(Color.white);
        JREstrenimiento.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JREstrenimiento.setToolTipText("");
        JREstrenimiento.setText("Estreñimiento");
        JREstrenimiento.setBounds(new Rectangle(0, 113, 133, 23));
        JREstrenimiento.addActionListener(new CRevisionSistemas_JREstrenimiento_actionAdapter(this));
        JRSangrado.setBackground(Color.white);
        JRSangrado.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRSangrado.setToolTipText("");
        JRSangrado.setText("Sangrado");
        JRSangrado.setBounds(new Rectangle(0, 182, 100, 23));
        JRSangrado.addActionListener(new CRevisionSistemas_JRSangrado_actionAdapter(this));
        JREpigastraigia.setBackground(Color.white);
        JREpigastraigia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JREpigastraigia.setToolTipText("");
        JREpigastraigia.setText("Epigastraigia/Pirosis");
        JREpigastraigia.setBounds(new Rectangle(-1, 86, 143, 23));
        JREpigastraigia.addActionListener(new CRevisionSistemas_JREpigastraigia_actionAdapter(this));
        JRDiarrea.setBackground(Color.white);
        JRDiarrea.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRDiarrea.setToolTipText("");
        JRDiarrea.setText("Diarrea");
        JRDiarrea.setBounds(new Rectangle(0, 145, 73, 23));
        JRDiarrea.addActionListener(new CRevisionSistemas_JRDiarrea_actionAdapter(this));
        JRDispepsia.setBackground(Color.white);
        JRDispepsia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRDispepsia.setToolTipText("");
        JRDispepsia.setText("Dispepsia");
        JRDispepsia.setBounds(new Rectangle(-1, 22, 81, 23));
        JRDispepsia.addActionListener(new CRevisionSistemas_JRDispepsia_actionAdapter(this));
        JRDolorAbdominal.setBackground(Color.white);
        JRDolorAbdominal.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRDolorAbdominal.setToolTipText("");
        JRDolorAbdominal.setText("Dolor Abdominal");
        JRDolorAbdominal.setBounds(new Rectangle(-1, 54, 128, 23));
        JRDolorAbdominal.addActionListener(new CRevisionSistemas_JRDolorAbdominal_actionAdapter(this));
        JBDispepsia.setBounds(new Rectangle(160, 18, 57, 29));
        JBDispepsia.setEnabled(false);
        JBDispepsia.setBorder(BorderFactory.createLineBorder(Color.black));
        JBDispepsia.setActionCommand("JBDiabet");
        JBDispepsia.setText("jButton1");
        JBDispepsia.addActionListener(new CRevisionSistemas_JBDispepsia_actionAdapter(this));
        JBDispepsia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDispepsia.setSelectedIcon(null);
        JBDolorAbdominal.setBounds(new Rectangle(159, 50, 57, 29));
        JBDolorAbdominal.setEnabled(false);
        JBDolorAbdominal.setBorder(BorderFactory.createLineBorder(Color.black));
        JBDolorAbdominal.setActionCommand("JBDiabet");
        JBDolorAbdominal.setText("jButton1");
        JBDolorAbdominal.addActionListener(new CRevisionSistemas_JBDolorAbdominal_actionAdapter(this));
        JBDolorAbdominal.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDolorAbdominal.setSelectedIcon(null);
        JBEpigastraigia.setBounds(new Rectangle(159, 81, 57, 29));
        JBEpigastraigia.setEnabled(false);
        JBEpigastraigia.setBorder(BorderFactory.createLineBorder(Color.black));
        JBEpigastraigia.setActionCommand("JBDiabet");
        JBEpigastraigia.setText("jButton1");
        JBEpigastraigia.addActionListener(new CRevisionSistemas_JBEpigastraigia_actionAdapter(this));
        JBEpigastraigia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBEpigastraigia.setSelectedIcon(null);
        JBEstrenimiento.setBounds(new Rectangle(158, 113, 57, 29));
        JBEstrenimiento.setEnabled(false);
        JBEstrenimiento.setBorder(BorderFactory.createLineBorder(Color.black));
        JBEstrenimiento.setActionCommand("JBDiabet");
        JBEstrenimiento.setText("jButton1");
        JBEstrenimiento.addActionListener(new CRevisionSistemas_JBEstrenimiento_actionAdapter(this));
        JBEstrenimiento.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBEstrenimiento.setSelectedIcon(null);
        JBDiarrea.setBounds(new Rectangle(158, 146, 57, 29));
        JBDiarrea.setEnabled(false);
        JBDiarrea.setBorder(BorderFactory.createLineBorder(Color.black));
        JBDiarrea.setActionCommand("JBDiabet");
        JBDiarrea.setText("jButton1");
        JBDiarrea.addActionListener(new CRevisionSistemas_JBDiarrea_actionAdapter(this));
        JBDiarrea.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDiarrea.setSelectedIcon(null);
        JBSangrado.setBounds(new Rectangle(158, 178, 57, 29));
        JBSangrado.setEnabled(false);
        JBSangrado.setBorder(BorderFactory.createLineBorder(Color.black));
        JBSangrado.setActionCommand("JBDiabet");
        JBSangrado.setText("jButton1");
        JBSangrado.addActionListener(new CRevisionSistemas_JBSangrado_actionAdapter(this));
        JBSangrado.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBSangrado.setSelectedIcon(null);
        JPGenitoUrinario.setBackground(Color.white);
        JPGenitoUrinario.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPGenitoUrinario.setBorder(BorderFactory.createRaisedBevelBorder());
        JPGenitoUrinario.setBounds(new Rectangle(765, 28, 223, 256));
        JPGenitoUrinario.setLayout(null);
        JRNicturia.setBackground(Color.white);
        JRNicturia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRNicturia.setToolTipText("");
        JRNicturia.setText("Nicturia");
        JRNicturia.setBounds(new Rectangle(0, 156, 79, 23));
        JRNicturia.addActionListener(new CRevisionSistemas_JRNicturia_actionAdapter(this));
        JLBGenitourinario.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBGenitourinario.setForeground(Color.red);
        JLBGenitourinario.setToolTipText("");
        JLBGenitourinario.setText("GENITO URINARIO");
        JLBGenitourinario.setBounds(new Rectangle(2, 7, 108, 14));
        JRTrantCicloMestr.setBackground(Color.white);
        JRTrantCicloMestr.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRTrantCicloMestr.setToolTipText("");
        JRTrantCicloMestr.setText("Transt Ciclo Mestrual");
        JRTrantCicloMestr.setBounds(new Rectangle(0, 122, 154, 23));
        JRTrantCicloMestr.addActionListener(new CRevisionSistemas_JRTrantCicloMestr_actionAdapter(this));
        JRHematuria.setBackground(Color.white);
        JRHematuria.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRHematuria.setToolTipText("");
        JRHematuria.setText("Hematuria");
        JRHematuria.setBounds(new Rectangle(0, 86, 103, 23));
        JRHematuria.addActionListener(new CRevisionSistemas_JRHematuria_actionAdapter(this));
        JRDisuria.setBackground(Color.white);
        JRDisuria.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRDisuria.setToolTipText("");
        JRDisuria.setText("Disuria");
        JRDisuria.setBounds(new Rectangle(-1, 58, 110, 23));
        JRDisuria.addActionListener(new CRevisionSistemas_JRDisuria_actionAdapter(this));
        JRDisminucionCalibre.setBackground(Color.white);
        JRDisminucionCalibre.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRDisminucionCalibre.setToolTipText("");
        JRDisminucionCalibre.setText("Disminucion Calibre");
        JRDisminucionCalibre.setBounds(new Rectangle(-1, 24, 139, 23));
        JRDisminucionCalibre.addActionListener(new CRevisionSistemas_JRDisminucionCalibre_actionAdapter(this));
        JRPolaquiuria.setBackground(Color.white);
        JRPolaquiuria.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRPolaquiuria.setToolTipText("");
        JRPolaquiuria.setText("Polaquiuria");
        JRPolaquiuria.setBounds(new Rectangle(0, 188, 91, 23));
        JRPolaquiuria.addActionListener(new CRevisionSistemas_JRPolaquiuria_actionAdapter(this));
        JBDisminucionCalibre.setBounds(new Rectangle(160, 20, 57, 29));
        JBDisminucionCalibre.setEnabled(false);
        JBDisminucionCalibre.setBorder(BorderFactory.createLineBorder(Color.black));
        JBDisminucionCalibre.setActionCommand("JBDiabet");
        JBDisminucionCalibre.setText("jButton1");
        JBDisminucionCalibre.addActionListener(new CRevisionSistemas_JBDisminucionCalibre_actionAdapter(this));
        JBDisminucionCalibre.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDisminucionCalibre.setSelectedIcon(null);
        JBDisuria.setBounds(new Rectangle(160, 54, 57, 29));
        JBDisuria.setEnabled(false);
        JBDisuria.setBorder(BorderFactory.createLineBorder(Color.black));
        JBDisuria.setActionCommand("JBDiabet");
        JBDisuria.setText("jButton1");
        JBDisuria.addActionListener(new CRevisionSistemas_JBDisuria_actionAdapter(this));
        JBDisuria.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDisuria.setSelectedIcon(null);
        JBHematuria.setBounds(new Rectangle(159, 88, 57, 29));
        JBHematuria.setEnabled(false);
        JBHematuria.setBorder(BorderFactory.createLineBorder(Color.black));
        JBHematuria.setActionCommand("JBDiabet");
        JBHematuria.setText("jButton1");
        JBHematuria.addActionListener(new CRevisionSistemas_JBHematuria_actionAdapter(this));
        JBHematuria.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBHematuria.setSelectedIcon(null);
        JBTranstCicloMestrual.setBounds(new Rectangle(158, 121, 57, 29));
        JBTranstCicloMestrual.setEnabled(false);
        JBTranstCicloMestrual.setBorder(BorderFactory.createLineBorder(Color.black));
        JBTranstCicloMestrual.setActionCommand("JBDiabet");
        JBTranstCicloMestrual.setText("jButton1");
        JBTranstCicloMestrual.addActionListener(new CRevisionSistemas_JBTranstCicloMestrual_actionAdapter(this));
        JBTranstCicloMestrual.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBTranstCicloMestrual.setSelectedIcon(null);
        JBNicturia.setBounds(new Rectangle(158, 154, 57, 29));
        JBNicturia.setEnabled(false);
        JBNicturia.setBorder(BorderFactory.createLineBorder(Color.black));
        JBNicturia.setActionCommand("JBDiabet");
        JBNicturia.setText("jButton1");
        JBNicturia.addActionListener(new CRevisionSistemas_JBNicturia_actionAdapter(this));
        JBNicturia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBNicturia.setSelectedIcon(null);
        JBPalaquiuria.setBounds(new Rectangle(158, 188, 57, 29));
        JBPalaquiuria.setEnabled(false);
        JBPalaquiuria.setBorder(BorderFactory.createLineBorder(Color.black));
        JBPalaquiuria.setActionCommand("JBDiabet");
        JBPalaquiuria.setText("jButton1");
        JBPalaquiuria.addActionListener(new CRevisionSistemas_JBPalaquiuria_actionAdapter(this));
        JBPalaquiuria.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBPalaquiuria.setSelectedIcon(null);
        JRTenesmoVesical.setBackground(Color.white);
        JRTenesmoVesical.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRTenesmoVesical.setToolTipText("");
        JRTenesmoVesical.setText("Tenesmo Vesical");
        JRTenesmoVesical.setBounds(new Rectangle(0, 223, 140, 23));
        JRTenesmoVesical.addActionListener(new CRevisionSistemas_JRTenesmoVesical_actionAdapter(this));
        JBTenesmoVesical.setBounds(new Rectangle(158, 221, 57, 29));
        JBTenesmoVesical.setEnabled(false);
        JBTenesmoVesical.setBorder(BorderFactory.createLineBorder(Color.black));
        JBTenesmoVesical.setActionCommand("JBDiabet");
        JBTenesmoVesical.setText("jButton1");
        JBTenesmoVesical.addActionListener(new CRevisionSistemas_JBTenesmoVesical_actionAdapter(this));
        JBTenesmoVesical.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBTenesmoVesical.setSelectedIcon(null);
        JPNeurologico.setBackground(Color.white);
        JPNeurologico.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPNeurologico.setBorder(BorderFactory.createRaisedBevelBorder());
        JPNeurologico.setBounds(new Rectangle(8, 293, 223, 226));
        JPNeurologico.setLayout(null);
        JLBNeurologico.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBNeurologico.setForeground(Color.red);
        JLBNeurologico.setToolTipText("");
        JLBNeurologico.setText("NEUROLOGICO");
        JLBNeurologico.setBounds(new Rectangle(1, 6, 101, 14));
        JRAlteracionMotora.setBackground(Color.white);
        JRAlteracionMotora.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRAlteracionMotora.setToolTipText("");
        JRAlteracionMotora.setText("Alteracion Motora");
        JRAlteracionMotora.setBounds(new Rectangle(0, 107, 125, 23));
        JRAlteracionMotora.addActionListener(new CRevisionSistemas_JRAlteracionMotora_actionAdapter(this));
        JRAlteracionSensib.setBackground(Color.white);
        JRAlteracionSensib.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRAlteracionSensib.setToolTipText("");
        JRAlteracionSensib.setText("Alteracion Sensibilidad");
        JRAlteracionSensib.setBounds(new Rectangle(1, 77, 156, 23));
        JRAlteracionSensib.addActionListener(new CRevisionSistemas_JRAlteracionSensib_actionAdapter(this));
        JRVertigo.setBackground(Color.white);
        JRVertigo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRVertigo.setToolTipText("");
        JRVertigo.setText("Vertigo");
        JRVertigo.setBounds(new Rectangle(1, 137, 99, 23));
        JRVertigo.addActionListener(new CRevisionSistemas_JRVertigo_actionAdapter(this));
        JRCefalea.setBackground(Color.white);
        JRCefalea.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRCefalea.setToolTipText("");
        JRCefalea.setText("Cefalea");
        JRCefalea.setBounds(new Rectangle(2, 18, 76, 23));
        JRCefalea.addActionListener(new CRevisionSistemas_JRCefalea_actionAdapter(this));
        JRAlteracionMemoria.setBackground(Color.white);
        JRAlteracionMemoria.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRAlteracionMemoria.setToolTipText("");
        JRAlteracionMemoria.setText("Alteracion Memoria");
        JRAlteracionMemoria.setBounds(new Rectangle(1, 47, 140, 23));
        JRAlteracionMemoria.addActionListener(new CRevisionSistemas_JRAlteracionMemoria_actionAdapter(this));
        JBCefalea.setBounds(new Rectangle(161, 15, 57, 29));
        JBCefalea.setEnabled(false);
        JBCefalea.setBorder(BorderFactory.createLineBorder(Color.black));
        JBCefalea.setActionCommand("JBDiabet");
        JBCefalea.setText("jButton1");
        JBCefalea.addActionListener(new CRevisionSistemas_JBCefalea_actionAdapter(this));
        JBCefalea.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBCefalea.setSelectedIcon(null);
        JBAlteracionMemoria.setBounds(new Rectangle(161, 45, 57, 29));
        JBAlteracionMemoria.setEnabled(false);
        JBAlteracionMemoria.setBorder(BorderFactory.createLineBorder(Color.black));
        JBAlteracionMemoria.setActionCommand("JBDiabet");
        JBAlteracionMemoria.setText("jButton1");
        JBAlteracionMemoria.addActionListener(new CRevisionSistemas_JBAlteracionMemoria_actionAdapter(this));
        JBAlteracionMemoria.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBAlteracionMemoria.setSelectedIcon(null);
        JBAlteracionSensibilidad.setBounds(new Rectangle(160, 76, 57, 29));
        JBAlteracionSensibilidad.setEnabled(false);
        JBAlteracionSensibilidad.setBorder(BorderFactory.createLineBorder(Color.black));
        JBAlteracionSensibilidad.setActionCommand("JBDiabet");
        JBAlteracionSensibilidad.setText("jButton1");
        JBAlteracionSensibilidad.addActionListener(new CRevisionSistemas_JBAlteracionSensibilidad_actionAdapter(this));
        JBAlteracionSensibilidad.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBAlteracionSensibilidad.setSelectedIcon(null);
        JBAlteracionMotora.setBounds(new Rectangle(160, 107, 57, 29));
        JBAlteracionMotora.setEnabled(false);
        JBAlteracionMotora.setBorder(BorderFactory.createLineBorder(Color.black));
        JBAlteracionMotora.setActionCommand("JBDiabet");
        JBAlteracionMotora.setText("jButton1");
        JBAlteracionMotora.addActionListener(new CRevisionSistemas_JBAlteracionMotora_actionAdapter(this));
        JBAlteracionMotora.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBAlteracionMotora.setSelectedIcon(null);
        JBVertigo.setBounds(new Rectangle(160, 139, 57, 29));
        JBVertigo.setEnabled(false);
        JBVertigo.setBorder(BorderFactory.createLineBorder(Color.black));
        JBVertigo.setActionCommand("JBDiabet");
        JBVertigo.setText("jButton1");
        JBVertigo.addActionListener(new CRevisionSistemas_JBVertigo_actionAdapter(this));
        JBVertigo.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBVertigo.setSelectedIcon(null);
        JPOcular.setBackground(Color.white);
        JPOcular.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPOcular.setBorder(BorderFactory.createRaisedBevelBorder());
        JPOcular.setBounds(new Rectangle(261, 291, 223, 226));
        JPOcular.setLayout(null);
        JLBOcular.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBOcular.setForeground(Color.red);
        JLBOcular.setToolTipText("");
        JLBOcular.setText("OCULAR");
        JLBOcular.setBounds(new Rectangle(3, 2, 77, 14));
        JRLagrimeo.setBackground(Color.white);
        JRLagrimeo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRLagrimeo.setToolTipText("");
        JRLagrimeo.setText("Lagrimeo");
        JRLagrimeo.setBounds(new Rectangle(3, 104, 103, 23));
        JRLagrimeo.addActionListener(new CRevisionSistemas_JRLagrimeo_actionAdapter(this));
        JROjoRojo.setBackground(Color.white);
        JROjoRojo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JROjoRojo.setToolTipText("");
        JROjoRojo.setText("Ojo Rojo");
        JROjoRojo.setBounds(new Rectangle(3, 135, 133, 23));
        JROjoRojo.addActionListener(new CRevisionSistemas_JROjoRojo_actionAdapter(this));
        JRVisionBorrosa.setBackground(Color.white);
        JRVisionBorrosa.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRVisionBorrosa.setToolTipText("");
        JRVisionBorrosa.setText("Vision Borrosa");
        JRVisionBorrosa.setBounds(new Rectangle(2, 74, 128, 23));
        JRVisionBorrosa.addActionListener(new CRevisionSistemas_JRVisionBorrosa_actionAdapter(this));
        JRArdorprurito.setBackground(Color.white);
        JRArdorprurito.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRArdorprurito.setToolTipText("");
        JRArdorprurito.setText("Ardor/Prurito");
        JRArdorprurito.setBounds(new Rectangle(0, 18, 123, 23));
        JRArdorprurito.addActionListener(new CRevisionSistemas_JRArdorprurito_actionAdapter(this));
        JRCansancio.setBackground(Color.white);
        JRCansancio.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRCansancio.setToolTipText("");
        JRCansancio.setText("Cansancio");
        JRCansancio.setBounds(new Rectangle(0, 47, 95, 23));
        JRCansancio.addActionListener(new CRevisionSistemas_JRCansancio_actionAdapter(this));
        JBArdor.setBounds(new Rectangle(162, 8, 57, 29));
        JBArdor.setEnabled(false);
        JBArdor.setBorder(BorderFactory.createLineBorder(Color.black));
        JBArdor.setActionCommand("JBDiabet");
        JBArdor.setText("jButton1");
        JBArdor.addActionListener(new CRevisionSistemas_JBArdor_actionAdapter(this));
        JBArdor.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBArdor.setSelectedIcon(null);
        JBCansancio.setBounds(new Rectangle(162, 40, 57, 29));
        JBCansancio.setEnabled(false);
        JBCansancio.setBorder(BorderFactory.createLineBorder(Color.black));
        JBCansancio.setActionCommand("JBDiabet");
        JBCansancio.setText("jButton1");
        JBCansancio.addActionListener(new CRevisionSistemas_JBCansancio_actionAdapter(this));
        JBCansancio.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBCansancio.setSelectedIcon(null);
        JBVisionBorrosa.setBounds(new Rectangle(162, 71, 57, 29));
        JBVisionBorrosa.setEnabled(false);
        JBVisionBorrosa.setBorder(BorderFactory.createLineBorder(Color.black));
        JBVisionBorrosa.setActionCommand("JBDiabet");
        JBVisionBorrosa.setText("jButton1");
        JBVisionBorrosa.addActionListener(new CRevisionSistemas_JBVisionBorrosa_actionAdapter(this));
        JBVisionBorrosa.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBVisionBorrosa.setSelectedIcon(null);
        JBLagrimeo.setBounds(new Rectangle(162, 102, 57, 29));
        JBLagrimeo.setEnabled(false);
        JBLagrimeo.setBorder(BorderFactory.createLineBorder(Color.black));
        JBLagrimeo.setActionCommand("JBDiabet");
        JBLagrimeo.setText("jButton1");
        JBLagrimeo.addActionListener(new CRevisionSistemas_JBLagrimeo_actionAdapter(this));
        JBLagrimeo.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBLagrimeo.setSelectedIcon(null);
        JBOjoRojo.setBounds(new Rectangle(162, 134, 57, 29));
        JBOjoRojo.setEnabled(false);
        JBOjoRojo.setBorder(BorderFactory.createLineBorder(Color.black));
        JBOjoRojo.setActionCommand("JBDiabet");
        JBOjoRojo.setText("jButton1");
        JBOjoRojo.addActionListener(new CRevisionSistemas_JBOjoRojo_actionAdapter(this));
        JBOjoRojo.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBOjoRojo.setSelectedIcon(null);
        JPRespiratorio.setBackground(Color.white);
        JPRespiratorio.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPRespiratorio.setBorder(BorderFactory.createRaisedBevelBorder());
        JPRespiratorio.setLayout(null);
        JRExpectoracion.setBackground(Color.white);
        JRExpectoracion.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRExpectoracion.setToolTipText("");
        JRExpectoracion.setText("Expectoracion");
        JRExpectoracion.setBounds(new Rectangle(2, 86, 107, 23));
        JRExpectoracion.addActionListener(new CRevisionSistemas_JRExpectoracion_actionAdapter(this));
        JRDolorToraxico.setBackground(Color.white);
        JRDolorToraxico.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRDolorToraxico.setToolTipText("");
        JRDolorToraxico.setText("Dolor Toraxico");
        JRDolorToraxico.setBounds(new Rectangle(1, 50, 130, 23));
        JRDolorToraxico.addActionListener(new CRevisionSistemas_JRDolorToraxico_actionAdapter(this));
        JRTos.setBackground(Color.white);
        JRTos.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRTos.setToolTipText("");
        JRTos.setText("Tos");
        JRTos.setBounds(new Rectangle(2, 20, 71, 23));
        JRTos.addActionListener(new CRevisionSistemas_JRTos_actionAdapter(this));
        JBTos.setBounds(new Rectangle(157, 17, 57, 29));
        JBTos.setEnabled(false);
        JBTos.setBorder(BorderFactory.createLineBorder(Color.black));
        JBTos.setActionCommand("JBDiabet");
        JBTos.setText("jButton1");
        JBTos.addActionListener(new CRevisionSistemas_JBTos_actionAdapter(this));
        JBTos.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBTos.setSelectedIcon(null);
        JBDolorToraxico.setBounds(new Rectangle(156, 48, 57, 29));
        JBDolorToraxico.setEnabled(false);
        JBDolorToraxico.setBorder(BorderFactory.createLineBorder(Color.black));
        JBDolorToraxico.setActionCommand("JBDiabet");
        JBDolorToraxico.setText("jButton1");
        JBDolorToraxico.addActionListener(new CRevisionSistemas_JBDolorToraxico_actionAdapter(this));
        JBDolorToraxico.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDolorToraxico.setSelectedIcon(null);
        JBExpectoracion.setBounds(new Rectangle(155, 80, 57, 29));
        JBExpectoracion.setEnabled(false);
        JBExpectoracion.setBorder(BorderFactory.createLineBorder(Color.black));
        JBExpectoracion.setActionCommand("JBDiabet");
        JBExpectoracion.setText("jButton1");
        JBExpectoracion.addActionListener(new CRevisionSistemas_JBExpectoracion_actionAdapter(this));
        JBExpectoracion.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBExpectoracion.setSelectedIcon(null);
        JPOsteomuscular.setBackground(Color.white);
        JPOsteomuscular.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPOsteomuscular.setBorder(BorderFactory.createRaisedBevelBorder());
        JPOsteomuscular.setBounds(new Rectangle(764, 291, 223, 226));
        JPOsteomuscular.setLayout(null);
        JTOsteomuscular.setBackground(Color.white);
        JTOsteomuscular.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTOsteomuscular.setForeground(Color.red);
        JTOsteomuscular.setBorder(null);
        JTOsteomuscular.setBounds(new Rectangle(2, 1, 219, 221));
        JPTOsteomuscular.setBackground(Color.white);
        JPTOsteomuscular.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPTOsteomuscular.setLayout(null);
        JPTOsteomuscular2.setBackground(Color.white);
        JPTOsteomuscular2.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPTOsteomuscular2.setLayout(null);
        JRCervicalgia.setBackground(Color.white);
        JRCervicalgia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRCervicalgia.setToolTipText("");
        JRCervicalgia.setText("Cervicalgia");
        JRCervicalgia.setBounds(new Rectangle(0, 6, 91, 23));
        JRCervicalgia.addActionListener(new CRevisionSistemas_JRCervicalgia_actionAdapter(this));
        JBCervicalgia.setBounds(new Rectangle(153, 4, 57, 29));
        JBCervicalgia.setBorder(BorderFactory.createLineBorder(Color.black));
        JBCervicalgia.setActionCommand("JBDiabet");
        JBCervicalgia.setText("jButton1");
        JBCervicalgia.addActionListener(new CRevisionSistemas_JBCervicalgia_actionAdapter(this));
        JBCervicalgia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBCervicalgia.setSelectedIcon(null);
        JRDorsalgia.setBackground(Color.white);
        JRDorsalgia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRDorsalgia.setToolTipText("");
        JRDorsalgia.setText("Dorsalgia");
        JRDorsalgia.setBounds(new Rectangle(2, 38, 91, 23));
        JRDorsalgia.addActionListener(new CRevisionSistemas_JRDorsalgia_actionAdapter(this));
        JBDorsalgia.setBounds(new Rectangle(152, 36, 57, 29));
        JBDorsalgia.setBorder(BorderFactory.createLineBorder(Color.black));
        JBDorsalgia.setActionCommand("JBDiabet");
        JBDorsalgia.setText("jButton1");
        JBDorsalgia.addActionListener(new CRevisionSistemas_JBDorsalgia_actionAdapter(this));
        JBDorsalgia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDorsalgia.setSelectedIcon(null);
        JRLumbalgia.setBackground(Color.white);
        JRLumbalgia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRLumbalgia.setToolTipText("");
        JRLumbalgia.setText("Lumbalgia");
        JRLumbalgia.setBounds(new Rectangle(2, 70, 91, 23));
        JRLumbalgia.addActionListener(new CRevisionSistemas_JRLumbalgia_actionAdapter(this));
        JBLumbalgia.setBounds(new Rectangle(152, 67, 57, 29));
        JBLumbalgia.setBorder(BorderFactory.createLineBorder(Color.black));
        JBLumbalgia.setActionCommand("JBDiabet");
        JBLumbalgia.setText("jButton1");
        JBLumbalgia.addActionListener(new CRevisionSistemas_JBLumbalgia_actionAdapter(this));
        JBLumbalgia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBLumbalgia.setSelectedIcon(null);
        JRIncapacitante.setBackground(Color.white);
        JRIncapacitante.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRIncapacitante.setToolTipText("");
        JRIncapacitante.setText("Incapacitante");
        JRIncapacitante.setBounds(new Rectangle(2, 98, 116, 23));
        JRIncapacitante.addActionListener(new CRevisionSistemas_JRIncapacitante_actionAdapter(this));
        JBIncapacitante.setBounds(new Rectangle(151, 99, 57, 29));
        JBIncapacitante.setBorder(BorderFactory.createLineBorder(Color.black));
        JBIncapacitante.setActionCommand("JBDiabet");
        JBIncapacitante.setText("jButton1");
        JBIncapacitante.addActionListener(new CRevisionSistemas_JBIncapacitante_actionAdapter(this));
        JBIncapacitante.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBIncapacitante.setSelectedIcon(null);
        JCHCentral.setBackground(Color.white);
        JCHCentral.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 10));
        JCHCentral.setToolTipText("");
        JCHCentral.setText("Central");
        JCHCentral.setBounds(new Rectangle(3, 126, 70, 25));
        JCHLeve.setBackground(Color.white);
        JCHLeve.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 10));
        JCHLeve.setToolTipText("");
        JCHLeve.setText("Leve");
        JCHLeve.setBounds(new Rectangle(3, 146, 70, 25));
        JCHSevera.setBackground(Color.white);
        JCHSevera.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 10));
        JCHSevera.setToolTipText("");
        JCHSevera.setText("Severa");
        JCHSevera.setBounds(new Rectangle(3, 167, 70, 25));
        JCHPeriferica.setBackground(Color.white);
        JCHPeriferica.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 10));
        JCHPeriferica.setToolTipText("");
        JCHPeriferica.setText("Periferica");
        JCHPeriferica.setBounds(new Rectangle(100, 126, 70, 25));
        JCHModerada.setBackground(Color.white);
        JCHModerada.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 10));
        JCHModerada.setToolTipText("");
        JCHModerada.setText("Moderada");
        JCHModerada.setBounds(new Rectangle(100, 147, 70, 25));
        JRArtralgias.setBackground(Color.white);
        JRArtralgias.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRArtralgias.setToolTipText("");
        JRArtralgias.setText("Artralgias");
        JRArtralgias.setBounds(new Rectangle(0, 12, 91, 23));
        JRArtralgias.addActionListener(new CRevisionSistemas_JRArtralgias_actionAdapter(this));
        JBArtralgias.setBounds(new Rectangle(153, 7, 57, 29));
        JBArtralgias.setEnabled(false);
        JBArtralgias.setBorder(BorderFactory.createLineBorder(Color.black));
        JBArtralgias.setActionCommand("JBDiabet");
        JBArtralgias.setText("jButton1");
        JBArtralgias.addActionListener(new CRevisionSistemas_JBArtralgias_actionAdapter(this));
        JBArtralgias.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBArtralgias.setSelectedIcon(null);
        JRTendinitis.setBackground(Color.white);
        JRTendinitis.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRTendinitis.setToolTipText("");
        JRTendinitis.setText("Tendinitis");
        JRTendinitis.setBounds(new Rectangle(-1, 45, 91, 23));
        JRTendinitis.addActionListener(new CRevisionSistemas_JRTendinitis_actionAdapter(this));
        JBTendinitis.setBounds(new Rectangle(153, 39, 57, 29));
        JBTendinitis.setEnabled(false);
        JBTendinitis.setBorder(BorderFactory.createLineBorder(Color.black));
        JBTendinitis.setActionCommand("JBDiabet");
        JBTendinitis.setText("jButton1");
        JBTendinitis.addActionListener(new CRevisionSistemas_JBTendinitis_actionAdapter(this));
        JBTendinitis.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBTendinitis.setSelectedIcon(null);
        JRLimitacionFuncional.setBackground(Color.white);
        JRLimitacionFuncional.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRLimitacionFuncional.setToolTipText("");
        JRLimitacionFuncional.setText("Limitacion Funcional");
        JRLimitacionFuncional.setBounds(new Rectangle(0, 75, 140, 23));
        JRLimitacionFuncional.addActionListener(new CRevisionSistemas_JRLimitacionFuncional_actionAdapter(this));
        JBLimitacionFuncional.setBounds(new Rectangle(153, 71, 57, 29));
        JBLimitacionFuncional.setEnabled(false);
        JBLimitacionFuncional.setBorder(BorderFactory.createLineBorder(Color.black));
        JBLimitacionFuncional.setActionCommand("JBDiabet");
        JBLimitacionFuncional.setText("jButton1");
        JBLimitacionFuncional.addActionListener(new CRevisionSistemas_JBLimitacionFuncional_actionAdapter(this));
        JBLimitacionFuncional.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBLimitacionFuncional.setSelectedIcon(null);
        JRParentestesias.setBackground(Color.white);
        JRParentestesias.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRParentestesias.setToolTipText("");
        JRParentestesias.setText("Parestesias/Disestesias");
        JRParentestesias.setBounds(new Rectangle(-1, 107, 162, 23));
        JRParentestesias.addActionListener(new CRevisionSistemas_JRParentestesias_actionAdapter(this));
        JBParestesias.setBounds(new Rectangle(153, 103, 57, 29));
        JBParestesias.setEnabled(false);
        JBParestesias.setBorder(BorderFactory.createLineBorder(Color.black));
        JBParestesias.setActionCommand("JBDiabet");
        JBParestesias.setText("jButton1");
        JBParestesias.addActionListener(new CRevisionSistemas_JBParestesias_actionAdapter(this));
        JBParestesias.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBParestesias.setSelectedIcon(null);
        JTRespiratorioORL.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTRespiratorioORL.setForeground(Color.red);
        JTRespiratorioORL.setBounds(new Rectangle(513, 289, 226, 226));
        JPorl.setBackground(Color.white);
        JPorl.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPorl.setLayout(null);
        JRDisfonia.setBackground(Color.white);
        JRDisfonia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRDisfonia.setToolTipText("");
        JRDisfonia.setText("Disfonia");
        JRDisfonia.setBounds(new Rectangle(0, 4, 79, 23));
        JRDisfonia.addActionListener(new CRevisionSistemas_JRDisfonia_actionAdapter(this));
        JBDisfonia.setBounds(new Rectangle(158, 1, 57, 29));
        JBDisfonia.setBorder(BorderFactory.createLineBorder(Color.black));
        JBDisfonia.setActionCommand("JBDiabet");
        JBDisfonia.setText("jButton1");
        JBDisfonia.addActionListener(new CRevisionSistemas_JBDisfonia_actionAdapter(this));
        JBDisfonia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDisfonia.setSelectedIcon(null);
        JREpistaxis.setBackground(Color.white);
        JREpistaxis.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JREpistaxis.setToolTipText("");
        JREpistaxis.setText("Epistaxis");
        JREpistaxis.setBounds(new Rectangle(1, 36, 79, 23));
        JREpistaxis.addActionListener(new CRevisionSistemas_JREpistaxis_actionAdapter(this));
        JBEpistaxis.setBounds(new Rectangle(157, 34, 57, 29));
        JBEpistaxis.setBorder(BorderFactory.createLineBorder(Color.black));
        JBEpistaxis.setActionCommand("JBDiabet");
        JBEpistaxis.setText("jButton1");
        JBEpistaxis.addActionListener(new CRevisionSistemas_JBEpistaxis_actionAdapter(this));
        JBEpistaxis.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBEpistaxis.setSelectedIcon(null);
        JRHipoacusia.setBackground(Color.white);
        JRHipoacusia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRHipoacusia.setToolTipText("");
        JRHipoacusia.setText("Hipoacusia Subjetiva");
        JRHipoacusia.setBounds(new Rectangle(1, 69, 147, 23));
        JRHipoacusia.addActionListener(new CRevisionSistemas_JRHipoacusia_actionAdapter(this));
        JBHipoacusia.setBounds(new Rectangle(157, 66, 57, 29));
        JBHipoacusia.setBorder(BorderFactory.createLineBorder(Color.black));
        JBHipoacusia.setActionCommand("JBDiabet");
        JBHipoacusia.setText("jButton1");
        JBHipoacusia.addActionListener(new CRevisionSistemas_JBHipoacusia_actionAdapter(this));
        JBHipoacusia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBHipoacusia.setSelectedIcon(null);
        JRObstruccionNasal.setBackground(Color.white);
        JRObstruccionNasal.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRObstruccionNasal.setToolTipText("");
        JRObstruccionNasal.setText("Obstruccion Nasal");
        JRObstruccionNasal.setBounds(new Rectangle(1, 101, 141, 23));
        JRObstruccionNasal.addActionListener(new CRevisionSistemas_JRObstruccionNasal_actionAdapter(this));
        JBObstruccionNasal.setBounds(new Rectangle(157, 98, 57, 29));
        JBObstruccionNasal.setBorder(BorderFactory.createLineBorder(Color.black));
        JBObstruccionNasal.setActionCommand("JBDiabet");
        JBObstruccionNasal.setText("jButton1");
        JBObstruccionNasal.addActionListener(new CRevisionSistemas_JBObstruccionNasal_actionAdapter(this));
        JBObstruccionNasal.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBObstruccionNasal.setSelectedIcon(null);
        JRRinorrea.setBackground(Color.white);
        JRRinorrea.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRRinorrea.setToolTipText("");
        JRRinorrea.setText("Rinorrea");
        JRRinorrea.setBounds(new Rectangle(0, 132, 122, 23));
        JRRinorrea.addActionListener(new CRevisionSistemas_JRRinorrea_actionAdapter(this));
        JBRinorrea.setBounds(new Rectangle(156, 131, 57, 29));
        JBRinorrea.setBorder(BorderFactory.createLineBorder(Color.black));
        JBRinorrea.setActionCommand("JBDiabet");
        JBRinorrea.setText("jButton1");
        JBRinorrea.addActionListener(new CRevisionSistemas_JBRinorrea_actionAdapter(this));
        JBRinorrea.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBRinorrea.setSelectedIcon(null);
        JRTinitus.setBackground(Color.white);
        JRTinitus.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JRTinitus.setToolTipText("");
        JRTinitus.setText("Tinitus");
        JRTinitus.setBounds(new Rectangle(3, 164, 85, 23));
        JRTinitus.addActionListener(new CRevisionSistemas_JRTinitus_actionAdapter(this));
        JBTinitus.setBounds(new Rectangle(155, 164, 57, 29));
        JBTinitus.setBorder(BorderFactory.createLineBorder(Color.black));
        JBTinitus.setActionCommand("JBDiabet");
        JBTinitus.setText("jButton1");
        JBTinitus.addActionListener(new CRevisionSistemas_JBTinitus_actionAdapter(this));
        JBTinitus.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBTinitus.setSelectedIcon(null);
        JFTDolorPrecordial.setBounds(new Rectangle(119, 22, 33, 16));
        JFTLipotimia.setToolTipText("");
        JFTLipotimia.setBounds(new Rectangle(121, 51, 33, 16));
        JFTPalpit.setToolTipText("");
        JFTPalpit.setBounds(new Rectangle(121, 85, 33, 16));
        JFTSincope.setToolTipText("");
        JFTSincope.setBounds(new Rectangle(121, 119, 33, 16));
        jFormattedTextField2.setToolTipText("");
        jFormattedTextField2.setBounds(new Rectangle(123, 155, 33, 16));
        JFTdescam.setToolTipText("");
        JFTdescam.setBounds(new Rectangle(114, 27, 33, 16));
        JFTEritema.setToolTipText("");
        JFTEritema.setBounds(new Rectangle(113, 56, 33, 16));
        JFTHiperhidrosis.setToolTipText("");
        JFTHiperhidrosis.setBounds(new Rectangle(114, 90, 33, 16));
        JFTBrote.setToolTipText("");
        JFTBrote.setBounds(new Rectangle(114, 123, 33, 16));
        JFTSequedad.setToolTipText("");
        JFTSequedad.setBounds(new Rectangle(118, 156, 33, 16));
        JFTprurito.setToolTipText("");
        JFTprurito.setBounds(new Rectangle(117, 188, 33, 22));
        JFTDispepsia.setToolTipText("");
        JFTDispepsia.setBounds(new Rectangle(122, 23, 33, 16));
        JFTDolorAbd.setToolTipText("");
        JFTDolorAbd.setBounds(new Rectangle(124, 59, 33, 16));
        JFTEpigastr.setToolTipText("");
        JFTEpigastr.setBounds(new Rectangle(136, 91, 21, 16));
        JFTEstrenimiento.setToolTipText("");
        JFTEstrenimiento.setBounds(new Rectangle(133, 121, 21, 16));
        JFTDiarrea.setToolTipText("");
        JFTDiarrea.setBounds(new Rectangle(134, 155, 21, 16));
        JFTSangrado.setToolTipText("");
        JFTSangrado.setBounds(new Rectangle(132, 184, 21, 16));
        JFTDisminucionCalibre.setToolTipText("");
        JFTDisminucionCalibre.setBounds(new Rectangle(137, 29, 17, 16));
        JFTDisuria.setToolTipText("");
        JFTDisuria.setBounds(new Rectangle(122, 58, 33, 18));
        JFTHematuria.setToolTipText("");
        JFTHematuria.setBounds(new Rectangle(123, 93, 33, 16));
        JFTtranstCicloMestr.setToolTipText("");
        JFTtranstCicloMestr.setBounds(new Rectangle(143, 125, 11, 21));
        JFTtranstCicloMestr.addActionListener(new CRevisionSistemas_JFTtranstCicloMestr_actionAdapter(this));
        JFTNicturia.setToolTipText("");
        JFTNicturia.setBounds(new Rectangle(134, 162, 21, 16));
        JFTPalquiuria.setToolTipText("");
        JFTPalquiuria.setBounds(new Rectangle(131, 196, 21, 16));
        JFTTenesmovesical.setToolTipText("");
        JFTTenesmovesical.setBounds(new Rectangle(133, 227, 21, 16));
        JFTCefalea.setToolTipText("");
        JFTCefalea.setBounds(new Rectangle(119, 22, 33, 16));
        JFTAlteracionMemoria.setToolTipText("");
        JFTAlteracionMemoria.setBounds(new Rectangle(140, 49, 14, 16));
        JFTAlteracionSencib.setToolTipText("");
        JFTAlteracionSencib.setBounds(new Rectangle(144, 82, 14, 16));
        JFTAlteracMotora.setToolTipText("");
        JFTAlteracMotora.setBounds(new Rectangle(136, 112, 15, 16));
        JFTVertigo.setToolTipText("");
        JFTVertigo.setBounds(new Rectangle(136, 145, 16, 16));
        JFTArdorPrurito.setToolTipText("");
        JFTArdorPrurito.setBounds(new Rectangle(123, 18, 33, 16));
        JFTCansancio.setToolTipText("");
        JFTCansancio.setBounds(new Rectangle(122, 49, 33, 16));
        JFTVisionBorrosa.setToolTipText("");
        JFTVisionBorrosa.setBounds(new Rectangle(140, 80, 18, 16));
        JFTLagrimeo.setToolTipText("");
        JFTLagrimeo.setBounds(new Rectangle(141, 110, 15, 16));
        JFTOjoRojo.setToolTipText("");
        JFTOjoRojo.setBounds(new Rectangle(144, 142, 15, 16));
        JFTTos.setToolTipText("");
        JFTTos.setBounds(new Rectangle(138, 27, 15, 16));
        JFTDolorToraxico.setToolTipText("");
        JFTDolorToraxico.setBounds(new Rectangle(137, 55, 15, 16));
        JFTExpectoracion.setToolTipText("");
        JFTExpectoracion.setBounds(new Rectangle(135, 87, 15, 16));
        JFTDisfonia.setToolTipText("");
        JFTDisfonia.setBounds(new Rectangle(139, 9, 15, 16));
        JFTEpistaxis.setToolTipText("");
        JFTEpistaxis.setBounds(new Rectangle(138, 41, 15, 16));
        JFTHipoacusia.setToolTipText("");
        JFTHipoacusia.setBounds(new Rectangle(138, 72, 15, 16));
        JFTObstruccionNasal.setToolTipText("");
        JFTObstruccionNasal.setBounds(new Rectangle(137, 106, 15, 16));
        JFTRinorrea.setToolTipText("");
        JFTRinorrea.setBounds(new Rectangle(137, 138, 15, 16));
        JFTTinitus.setToolTipText("");
        JFTTinitus.setBounds(new Rectangle(133, 169, 15, 16));
        JFTArtralgias.setToolTipText("");
        JFTArtralgias.setBounds(new Rectangle(134, 17, 15, 16));
        JFTTendinitis.setToolTipText("");
        JFTTendinitis.setBounds(new Rectangle(134, 46, 15, 16));
        JFTLimitacionFunc.setToolTipText("");
        JFTLimitacionFunc.setBounds(new Rectangle(136, 79, 15, 16));
        JFTParestesias.setToolTipText("");
        JFTParestesias.setBounds(new Rectangle(129, 130, 15, 16));
        JFTCervicalgia.setToolTipText("");
        JFTCervicalgia.setBounds(new Rectangle(130, 11, 15, 16));
        JFTDorsalgia.setToolTipText("");
        JFTDorsalgia.setBounds(new Rectangle(132, 47, 15, 16));
        JFTLumbalgia.setToolTipText("");
        JFTLumbalgia.setBounds(new Rectangle(131, 75, 15, 16));
        JFTIncapacitante.setToolTipText("");
        JFTIncapacitante.setBounds(new Rectangle(132, 107, 15, 16));
        JPAltura.setBackground(Color.white);
        JPAltura.setBounds(new Rectangle(30, 27, 10, 10));
        JPAltura.setLayout(null);
        JRCoronaria.setBackground(Color.white);
        JRCoronaria.setFont(new java.awt.Font("Arial", Font.PLAIN, 9));
        JRCoronaria.setToolTipText("");
        JRCoronaria.setText("Enfermedad Coronaria - Pre infarto");
        JRCoronaria.setBounds(new Rectangle(1, 1, 173, 23));
        JRCoronaria.addActionListener(new CRevisionSistemas_JRCoronaria_actionAdapter(this));
        JFTCoronaria.setToolTipText("");
        JFTCoronaria.setBounds(new Rectangle(180, 5, 33, 16));
        JBcoronaria.setBounds(new Rectangle(156, 27, 57, 29));
        JBcoronaria.setEnabled(false);
        JBcoronaria.setBorder(BorderFactory.createLineBorder(Color.black));
        JBcoronaria.setToolTipText("");
        JBcoronaria.setActionCommand("JBDiabet");
        JBcoronaria.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBcoronaria.addActionListener(new CRevisionSistemas_JBcoronaria_actionAdapter(this));
        JBArritmia.setBounds(new Rectangle(155, 90, 57, 29));
        JBArritmia.setEnabled(false);
        JBArritmia.setBorder(BorderFactory.createLineBorder(Color.black));
        JBArritmia.setToolTipText("");
        JBArritmia.setActionCommand("JBDiabet");
        JBArritmia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBArritmia.addActionListener(new CRevisionSistemas_JBArritmia_actionAdapter(this));
        JBHa.setBounds(new Rectangle(156, 159, 57, 29));
        JBHa.setEnabled(false);
        JBHa.setBorder(BorderFactory.createLineBorder(Color.black));
        JBHa.setActionCommand("JBDiabet");
        JBHa.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBHa.addActionListener(new CRevisionSistemas_JBHa_actionAdapter(this));
        JRArritmia.setBackground(Color.white);
        JRArritmia.setFont(new java.awt.Font("Arial", Font.PLAIN, 9));
        JRArritmia.setToolTipText("");
        JRArritmia.setText("Arritmia Cardiaca - Taquicardias");
        JRArritmia.setBounds(new Rectangle(0, 54, 163, 23));
        JRArritmia.addActionListener(new CRevisionSistemas_JRArritmia_actionAdapter(this));
        JFTArritmia.setToolTipText("");
        JFTArritmia.setBounds(new Rectangle(180, 62, 33, 16));
        JRHa.setBackground(Color.white);
        JRHa.setFont(new java.awt.Font("Arial", Font.PLAIN, 9));
        JRHa.setToolTipText("");
        JRHa.setText("H.A. Severa");
        JRHa.setBounds(new Rectangle(-1, 119, 106, 23));
        JRHa.addActionListener(new CRevisionSistemas_JRHa_actionAdapter(this));
        JFTha.setToolTipText("");
        JFTha.setBounds(new Rectangle(177, 131, 33, 16));
        this.getContentPane().add(JPRevisionSistemas);
        JPDermatologico.add(JLBDermatologico);
        JPDermatologico.add(JRDescamacion);
        JPDermatologico.add(JBDescamacion);
        JPDermatologico.add(JREritema);
        JPDermatologico.add(JRHiperhidrosis);
        JPDermatologico.add(JBEritema);
        JPDermatologico.add(jButton1);
        JPDermatologico.add(JBHiperhidrosis);
        JPDermatologico.add(JRBrote);
        JPDermatologico.add(JBBrote);
        JPDermatologico.add(JRSequedad);
        JPDermatologico.add(JRPrurito);
        JPDermatologico.add(JBPrurito);
        JPDermatologico.add(JBSequedad);
        JPDermatologico.add(JFTdescam);
        JPDermatologico.add(JFTEritema);
        JPDermatologico.add(JFTHiperhidrosis);
        JPDermatologico.add(JFTBrote);
        JPDermatologico.add(JFTprurito);
        JPDermatologico.add(JFTSequedad);
        JPRevisionSistemas.add(JPDigestivo);
        JPCardiovascularRS.add(JLBCardiovascular);
        JPCardiovascularRS.add(JRDolorPrecordial);
        JPCardiovascularRS.add(JBDolorPrecordial);
        JPCardiovascularRS.add(JRLipotimia);
        JPCardiovascularRS.add(JBLipotimia);
        JPCardiovascularRS.add(JRPalpitaciones);
        JPCardiovascularRS.add(JBPalpitaciones);
        JPCardiovascularRS.add(JBDisnea);
        JPCardiovascularRS.add(JBSincope);
        JPCardiovascularRS.add(JRDisnea);
        JPCardiovascularRS.add(JRSincope);
        JPCardiovascularRS.add(JFTDolorPrecordial);
        JPCardiovascularRS.add(JFTLipotimia);
        JPCardiovascularRS.add(JFTSincope);
        JPCardiovascularRS.add(jFormattedTextField2);
        JPCardiovascularRS.add(JFTPalpit);
        JPRevisionSistemas.add(JPDermatologico);
        JPDigestivo.add(JRDispepsia);
        JPDigestivo.add(JLDigestivo);
        JPDigestivo.add(JBDispepsia);
        JPDigestivo.add(JBDolorAbdominal);
        JPDigestivo.add(JBEpigastraigia);
        JPDigestivo.add(JRDolorAbdominal);
        JPDigestivo.add(JREstrenimiento);
        JPDigestivo.add(JREpigastraigia);
        JPDigestivo.add(JBEstrenimiento);
        JPDigestivo.add(JRDiarrea);
        JPDigestivo.add(JRSangrado);
        JPDigestivo.add(JBDiarrea);
        JPDigestivo.add(JBSangrado);
        JPDigestivo.add(JFTDispepsia);
        JPDigestivo.add(JFTDolorAbd);
        JPDigestivo.add(JFTEpigastr);
        JPDigestivo.add(JFTEstrenimiento);
        JPDigestivo.add(JFTDiarrea);
        JPDigestivo.add(JFTSangrado);
        JPGenitoUrinario.add(JLBGenitourinario);
        JPGenitoUrinario.add(JRDisminucionCalibre);
        JPGenitoUrinario.add(JRDisuria);
        JPGenitoUrinario.add(JRHematuria);
        JPGenitoUrinario.add(JBDisuria);
        JPGenitoUrinario.add(JBHematuria);
        JPGenitoUrinario.add(JBDisminucionCalibre);
        JPGenitoUrinario.add(JRTrantCicloMestr);
        JPGenitoUrinario.add(JBTranstCicloMestrual);
        JPGenitoUrinario.add(JBNicturia);
        JPGenitoUrinario.add(JRPolaquiuria);
        JPGenitoUrinario.add(JRNicturia);
        JPGenitoUrinario.add(JBPalaquiuria);
        JPGenitoUrinario.add(JBTenesmoVesical);
        JPGenitoUrinario.add(JRTenesmoVesical);
        JPGenitoUrinario.add(JFTDisminucionCalibre);
        JPGenitoUrinario.add(JFTDisuria);
        JPGenitoUrinario.add(JFTHematuria);
        JPGenitoUrinario.add(JFTtranstCicloMestr);
        JPGenitoUrinario.add(JFTNicturia);
        JPGenitoUrinario.add(JFTTenesmovesical);
        JPGenitoUrinario.add(JFTPalquiuria);
        JPRevisionSistemas.add(JPCardiovascularRS);
        JPNeurologico.add(JLBNeurologico);
        JPNeurologico.add(JRCefalea);
        JPNeurologico.add(JBCefalea);
        JPNeurologico.add(JRAlteracionMemoria);
        JPNeurologico.add(JBAlteracionMemoria);
        JPNeurologico.add(JRAlteracionSensib);
        JPNeurologico.add(JRAlteracionMotora);
        JPNeurologico.add(JRVertigo);
        JPNeurologico.add(JBAlteracionSensibilidad);
        JPNeurologico.add(JBAlteracionMotora);
        JPNeurologico.add(JBVertigo);
        JPNeurologico.add(JFTCefalea);
        JPNeurologico.add(JFTAlteracionMemoria);
        JPNeurologico.add(JFTAlteracionSencib);
        JPNeurologico.add(JFTAlteracMotora);
        JPNeurologico.add(JFTVertigo);
        JPRevisionSistemas.add(JBSguteRV);
        JPRevisionSistemas.add(JPGenitoUrinario);
        JPRevisionSistemas.add(JBAtrasRS);
        JPOcular.add(JLBOcular);
        JPOcular.add(JRArdorprurito);
        JPOcular.add(JRCansancio);
        JPOcular.add(JBArdor);
        JPOcular.add(JRVisionBorrosa);
        JPOcular.add(JBCansancio);
        JPOcular.add(JRLagrimeo);
        JPOcular.add(JBVisionBorrosa);
        JPOcular.add(JROjoRojo);
        JPOcular.add(JBLagrimeo);
        JPOcular.add(JBOjoRojo);
        JPOcular.add(JFTArdorPrurito);
        JPOcular.add(JFTCansancio);
        JPOcular.add(JFTVisionBorrosa);
        JPOcular.add(JFTLagrimeo);
        JPOcular.add(JFTOjoRojo);
        JPRevisionSistemas.add(JPNeurologico);
        JPRespiratorio.add(JRTos);
        JPRespiratorio.add(JRDolorToraxico);
        JPRespiratorio.add(JRExpectoracion);
        JPRespiratorio.add(JBTos);
        JPRespiratorio.add(JBExpectoracion);
        JPRespiratorio.add(JBDolorToraxico);
        JPRespiratorio.add(JFTDolorToraxico);
        JPRespiratorio.add(JFTTos);
        JPRespiratorio.add(JFTExpectoracion);
        JPRevisionSistemas.add(JPOcular);
        JPRevisionSistemas.add(JBcancelarRS);
        JPRevisionSistemas.add(JPOsteomuscular);
        JPOsteomuscular.add(JTOsteomuscular);
        JTOsteomuscular.add(JPTOsteomuscular2, "OSTEOMUSCULAR");
        JPTOsteomuscular2.add(JRArtralgias);
        JPTOsteomuscular2.add(JBArtralgias);
        JPTOsteomuscular2.add(JBTendinitis);
        JPTOsteomuscular2.add(JBLimitacionFuncional);
        JPTOsteomuscular2.add(JBParestesias);
        JPTOsteomuscular2.add(JRParentestesias);
        JPTOsteomuscular2.add(JRLimitacionFuncional);
        JPTOsteomuscular2.add(JRTendinitis);
        JPTOsteomuscular2.add(JFTArtralgias);
        JPTOsteomuscular2.add(JFTTendinitis);
        JPTOsteomuscular2.add(JFTParestesias);
        JPTOsteomuscular2.add(JFTLimitacionFunc);
        JPTOsteomuscular.add(JRCervicalgia);
        JPTOsteomuscular.add(JBCervicalgia);
        JPTOsteomuscular.add(JRDorsalgia);
        JPTOsteomuscular.add(JBDorsalgia);
        JPTOsteomuscular.add(JRLumbalgia);
        JPTOsteomuscular.add(JRIncapacitante);
        JPTOsteomuscular.add(JBLumbalgia);
        JPTOsteomuscular.add(JBIncapacitante);
        JPTOsteomuscular.add(JCHCentral);
        JPTOsteomuscular.add(JCHSevera);
        JPTOsteomuscular.add(JCHLeve);
        JPTOsteomuscular.add(JCHPeriferica);
        JPTOsteomuscular.add(JCHModerada);
        JPTOsteomuscular.add(JFTCervicalgia);
        JPTOsteomuscular.add(JFTDorsalgia);
        JPTOsteomuscular.add(JFTIncapacitante);
        JPTOsteomuscular.add(JFTLumbalgia);
        JPRevisionSistemas.add(JTRespiratorioORL);
        JTRespiratorioORL.add(JPRespiratorio, "RESPIRATORIO");
        JTOsteomuscular.add(JPTOsteomuscular, "C.VERTEBRAL");
        JTRespiratorioORL.add(JPorl, "ORL");
        JPorl.add(JRDisfonia);
        JPorl.add(JREpistaxis);
        JPorl.add(JRHipoacusia);
        JPorl.add(JBDisfonia);
        JPorl.add(JBEpistaxis);
        JPorl.add(JBHipoacusia);
        JPorl.add(JRObstruccionNasal);
        JPorl.add(JRRinorrea);
        JPorl.add(JRTinitus);
        JPorl.add(JBRinorrea);
        JPorl.add(JBTinitus);
        JPorl.add(JFTDisfonia);
        JPorl.add(JFTEpistaxis);
        JPorl.add(JFTHipoacusia);
        JPorl.add(JFTObstruccionNasal);
        JPorl.add(JFTTinitus);
        JPorl.add(JFTRinorrea);
        JPorl.add(JBObstruccionNasal);
        JPRevisionSistemas.add(JLBNumhcRS);
        JPRevisionSistemas.add(JLBNhc2RS);
        JTRespiratorioORL.add(JPAltura, "ALTURA");
        JPAltura.add(JRCoronaria);
        JPAltura.add(JFTCoronaria);
        JPAltura.add(JBcoronaria);
        JPAltura.add(JBArritmia);
        JPAltura.add(JRHa);
        JPAltura.add(JRArritmia);
        JPAltura.add(JFTArritmia);
        JPAltura.add(JBHa);
        JPAltura.add(JFTha);
    }

    /**
     * deshabilitar
     */
    public void deshabilitar() {
        JBDolorPrecordial.setEnabled(false);
        JBLipotimia.setEnabled(false);
        JBPalpitaciones.setEnabled(false);
        JBSincope.setEnabled(false);
        JBDisnea.setEnabled(false);
        JBDescamacion.setEnabled(false);
        JBEritema.setEnabled(false);
        JBHiperhidrosis.setEnabled(false);
        JBBrote.setEnabled(false);
        JBSequedad.setEnabled(false);
        JBPrurito.setEnabled(false);
        JBDispepsia.setEnabled(false);
        JBDolorAbdominal.setEnabled(false);
        JBEpigastraigia.setEnabled(false);
        JBEstrenimiento.setEnabled(false);
        JBDiarrea.setEnabled(false);
        JBSangrado.setEnabled(false);
        JBDisminucionCalibre.setEnabled(false);
        JBDisuria.setEnabled(false);
        JBHematuria.setEnabled(false);
        JBTranstCicloMestrual.setEnabled(false);
        JBNicturia.setEnabled(false);
        JBPalaquiuria.setEnabled(false);
        JBCefalea.setEnabled(false);
        JBAlteracionMemoria.setEnabled(false);
        JBAlteracionSensibilidad.setEnabled(false);
        JBAlteracionMotora.setEnabled(false);
        JBVertigo.setEnabled(false);
        JBArdor.setEnabled(false);
        JBCansancio.setEnabled(false);
        JBVisionBorrosa.setEnabled(false);
        JBLagrimeo.setEnabled(false);
        JBOjoRojo.setEnabled(false);
        JBTos.setEnabled(false);
        JBDolorToraxico.setEnabled(false);
        JBExpectoracion.setEnabled(false);
        JBCervicalgia.setEnabled(false);
        JBDorsalgia.setEnabled(false);
        JBLumbalgia.setEnabled(false);
        JBIncapacitante.setEnabled(false);
        JBArtralgias.setEnabled(false);
        JBTendinitis.setEnabled(false);
        JBLimitacionFuncional.setEnabled(false);
        JBParestesias.setEnabled(false);
        JBDisfonia.setEnabled(false);
        JBEpistaxis.setEnabled(false);
        JBHipoacusia.setEnabled(false);
        JBObstruccionNasal.setEnabled(false);
        JBRinorrea.setEnabled(false);
        JBTinitus.setEnabled(false);
        JBTenesmoVesical.setEnabled(false);
    }

    public void JFTtranstCicloMestr_actionPerformed(ActionEvent e) {
        nombredetalleRS = "TRANSTORNOS CICLO MESTRUAL";
        abrirformulariodetalleRS(JFTtranstCicloMestr);
        swtransciclomestrual = 1;
    }

    /**
     * controlbotonrs
     */
    public void controlbotonrs(JRadioButton JRparametro, JTextField JTFpar, JButton JBvar) {
        if (JRparametro.isSelected() == true) {
            JRparametro.setSelected(true);
            JBvar.setEnabled(true);
        } else {
            JRparametro.setSelected(false);
            JTFpar.setText(" ");
            JBvar.setEnabled(false);

        }

    }

    /**
     * ocultarJFT
     */
    public void ocultarJFT() {
        JFTDolorPrecordial.setVisible(false);
        JFTLipotimia.setVisible(false);
        JFTPalpit.setVisible(false);
        JFTSincope.setVisible(false);
        jFormattedTextField2.setVisible(false);
        JFTdescam.setVisible(false);
        JFTEritema.setVisible(false);
        JFTHiperhidrosis.setVisible(false);
        JFTBrote.setVisible(false);
        JFTSequedad.setVisible(false);
        JFTprurito.setVisible(false);
        JFTDispepsia.setVisible(false);
        JFTDolorAbd.setVisible(false);
        JFTEpigastr.setVisible(false);
        JFTEstrenimiento.setVisible(false);
        JFTDiarrea.setVisible(false);
        JFTSangrado.setVisible(false);
        JFTDisminucionCalibre.setVisible(false);
        JFTDisuria.setVisible(false);
        JFTHematuria.setVisible(false);
        JFTtranstCicloMestr.setVisible(false);
        JFTNicturia.setVisible(false);
        JFTPalquiuria.setVisible(false);
        JFTTenesmovesical.setVisible(false);
        JFTCefalea.setVisible(false);
        JFTAlteracionMemoria.setVisible(false);
        JFTAlteracionSencib.setVisible(false);
        JFTAlteracMotora.setVisible(false);
        JFTVertigo.setVisible(false);
        JFTArdorPrurito.setVisible(false);
        JFTCansancio.setVisible(false);
        JFTVisionBorrosa.setVisible(false);
        JFTLagrimeo.setVisible(false);
        JFTOjoRojo.setVisible(false);
        JFTTos.setVisible(false);
        JFTDolorToraxico.setVisible(false);
        JFTExpectoracion.setVisible(false);
        JFTDisfonia.setVisible(false);
        JFTEpistaxis.setVisible(false);
        JFTHipoacusia.setVisible(false);
        JFTObstruccionNasal.setVisible(false);
        JFTRinorrea.setVisible(false);
        JFTTinitus.setVisible(false);
        JFTArtralgias.setVisible(false);
        JFTTendinitis.setVisible(false);
        JFTLimitacionFunc.setVisible(false);
        JFTParestesias.setVisible(false);
        JFTCervicalgia.setVisible(false);
        JFTDorsalgia.setVisible(false);
        JFTLumbalgia.setVisible(false);
        JFTIncapacitante.setVisible(false);

    }

    public void JRDolorPrecordial_actionPerformed(ActionEvent e) {
        controlbotonrs(JRDolorPrecordial, JFTDolorPrecordial, JBDolorPrecordial);
    }

    public void JRLipotimia_actionPerformed(ActionEvent e) {
        controlbotonrs(JRLipotimia, JFTLipotimia, JBLipotimia);
    }

    public void JRPalpitaciones_actionPerformed(ActionEvent e) {
        controlbotonrs(JRPalpitaciones, JFTPalpit, JBPalpitaciones);
    }

    public void JRSincope_actionPerformed(ActionEvent e) {
        controlbotonrs(JRSincope, JFTSincope, JBSincope);
    }

    public void JRDisnea_actionPerformed(ActionEvent e) {
        controlbotonrs(JRDisnea, jFormattedTextField2, JBDisnea);
    }

    public void JRDescamacion_actionPerformed(ActionEvent e) {
        controlbotonrs(JRDescamacion, JFTdescam, JBDescamacion);
    }

    public void JREritema_actionPerformed(ActionEvent e) {
        controlbotonrs(JREritema, JFTEritema, JBEritema);
    }

    public void JRHiperhidrosis_actionPerformed(ActionEvent e) {
        controlbotonrs(JRHiperhidrosis, JFTHiperhidrosis, JBHiperhidrosis);
    }

    public void JRBrote_actionPerformed(ActionEvent e) {
        controlbotonrs(JRBrote, JFTBrote, JBBrote);
    }

    public void JRSequedad_actionPerformed(ActionEvent e) {
        controlbotonrs(JRSequedad, JFTSequedad, JBSequedad);
    }

    public void JRPrurito_actionPerformed(ActionEvent e) {
        controlbotonrs(JRPrurito, JFTprurito, JBPrurito);
    }

    public void JRDispepsia_actionPerformed(ActionEvent e) {
        controlbotonrs(JRDispepsia, JFTDispepsia, JBDispepsia);
    }

    public void JRDolorAbdominal_actionPerformed(ActionEvent e) {
        controlbotonrs(JRDolorAbdominal, JFTDolorAbd, JBDolorAbdominal);
    }

    public void JREpigastraigia_actionPerformed(ActionEvent e) {
        controlbotonrs(JREpigastraigia, JFTEpigastr, JBEpigastraigia);
    }

    public void JREstrenimiento_actionPerformed(ActionEvent e) {
        controlbotonrs(JREstrenimiento, JFTEstrenimiento, JBEstrenimiento);
    }

    public void JRDiarrea_actionPerformed(ActionEvent e) {
        controlbotonrs(JRDiarrea, JFTDiarrea, JBDiarrea);
    }

    public void JRSangrado_actionPerformed(ActionEvent e) {
        controlbotonrs(JRSangrado, JFTSangrado, JBSangrado);
    }

    public void JRDisminucionCalibre_actionPerformed(ActionEvent e) {
        controlbotonrs(JRDisminucionCalibre, JFTDisminucionCalibre, JBDisminucionCalibre);
    }

    public void JRDisuria_actionPerformed(ActionEvent e) {
        controlbotonrs(JRDisuria, JFTDisuria, JBDisuria);
    }

    public void JRHematuria_actionPerformed(ActionEvent e) {
        controlbotonrs(JRHematuria, JFTHematuria, JBHematuria);
    }

    public void JRTrantCicloMestr_actionPerformed(ActionEvent e) {
        controlbotonrs(JRTrantCicloMestr, JFTtranstCicloMestr, JBTranstCicloMestrual);
    }

    public void JRNicturia_actionPerformed(ActionEvent e) {
        controlbotonrs(JRNicturia, JFTNicturia, JBNicturia);
    }

    public void JRPolaquiuria_actionPerformed(ActionEvent e) {
        controlbotonrs(JRPolaquiuria, JFTPalquiuria, JBPalaquiuria);
    }

    public void JRTenesmoVesical_actionPerformed(ActionEvent e) {
        controlbotonrs(JRTenesmoVesical, JFTTenesmovesical, JBTenesmoVesical);
    }

    public void JRCefalea_actionPerformed(ActionEvent e) {
        controlbotonrs(JRCefalea, JFTCefalea, JBCefalea);
    }

    public void JRAlteracionMemoria_actionPerformed(ActionEvent e) {
        controlbotonrs(JRAlteracionMemoria, JFTAlteracionMemoria, JBAlteracionMemoria);
    }

    public void JRAlteracionSensib_actionPerformed(ActionEvent e) {
        controlbotonrs(JRAlteracionSensib, JFTAlteracionSencib, JBAlteracionSensibilidad);
    }

    public void JRAlteracionMotora_actionPerformed(ActionEvent e) {
        controlbotonrs(JRAlteracionMotora, JFTAlteracMotora, JBAlteracionMotora);
    }

    public void JRVertigo_actionPerformed(ActionEvent e) {
        controlbotonrs(JRVertigo, JFTVertigo, JBVertigo);
    }

    public void JRArdorprurito_actionPerformed(ActionEvent e) {
        controlbotonrs(JRArdorprurito, JFTArdorPrurito, JBArdor);
    }

    public void JRCansancio_actionPerformed(ActionEvent e) {
        controlbotonrs(JRCansancio, JFTCansancio, JBCansancio);
    }

    public void JRVisionBorrosa_actionPerformed(ActionEvent e) {
        controlbotonrs(JRVisionBorrosa, JFTVisionBorrosa, JBVisionBorrosa);
    }

    public void JRLagrimeo_actionPerformed(ActionEvent e) {
        controlbotonrs(JRLagrimeo, JFTLagrimeo, JBLagrimeo);
    }

    public void JROjoRojo_actionPerformed(ActionEvent e) {
        controlbotonrs(JROjoRojo, JFTOjoRojo, JBOjoRojo);
    }

    public void JRTos_actionPerformed(ActionEvent e) {
        controlbotonrs(JRTos, JFTTos, JBTos);
    }

    public void JRDolorToraxico_actionPerformed(ActionEvent e) {
        controlbotonrs(JRDolorToraxico, JFTDolorToraxico, JBDolorToraxico);
    }

    public void JRExpectoracion_actionPerformed(ActionEvent e) {
        controlbotonrs(JRExpectoracion, JFTExpectoracion, JBExpectoracion);
    }

    public void JRDisfonia_actionPerformed(ActionEvent e) {
        controlbotonrs(JRDisfonia, JFTDisfonia, JBDisfonia);
    }

    public void JREpistaxis_actionPerformed(ActionEvent e) {
        controlbotonrs(JREpistaxis, JFTEpistaxis, JBEpistaxis);
    }

    public void JRHipoacusia_actionPerformed(ActionEvent e) {
        controlbotonrs(JRHipoacusia, JFTHipoacusia, JBHipoacusia);
    }

    public void JRObstruccionNasal_actionPerformed(ActionEvent e) {
        controlbotonrs(JRObstruccionNasal, JFTObstruccionNasal, JBObstruccionNasal);
    }

    public void JRRinorrea_actionPerformed(ActionEvent e) {
        controlbotonrs(JRRinorrea, JFTRinorrea, JBRinorrea);
    }

    public void JRTinitus_actionPerformed(ActionEvent e) {
        controlbotonrs(JRTinitus, JFTTinitus, JBTinitus);
    }

    public void JRArtralgias_actionPerformed(ActionEvent e) {
        controlbotonrs(JRArtralgias, JFTArtralgias, JBArtralgias);
    }

    public void JRTendinitis_actionPerformed(ActionEvent e) {
        controlbotonrs(JRTendinitis, JFTTendinitis, JBTendinitis);
    }

    public void JRLimitacionFuncional_actionPerformed(ActionEvent e) {
        controlbotonrs(JRLimitacionFuncional, JFTLimitacionFunc, JBLimitacionFuncional);
    }

    public void JRParentestesias_actionPerformed(ActionEvent e) {
        controlbotonrs(JRParentestesias, JFTParestesias, JBParestesias);
    }

    public void JRCervicalgia_actionPerformed(ActionEvent e) {
        controlbotonrs(JRCervicalgia, JFTCervicalgia, JBCervicalgia);
    }

    public void JRDorsalgia_actionPerformed(ActionEvent e) {
        controlbotonrs(JRDorsalgia, JFTDorsalgia, JBDorsalgia);
    }

    public void JRLumbalgia_actionPerformed(ActionEvent e) {
        controlbotonrs(JRLumbalgia, JFTLumbalgia, JBLumbalgia);
    }

    public void JRIncapacitante_actionPerformed(ActionEvent e) {
        controlbotonrs(JRIncapacitante, JFTIncapacitante, JBIncapacitante);
    }

    /**
     * declaracionSW
     */
    public void declaracionSW() {
        swdolorprecordial = 1;
        swdlipotimia = 1;
        swpalpitaciones = 1;
        swsincope = 1;
        swdisnea = 1;
        swdescamacion = 1;
        swdolorabdominal = 1;
        swepigastraigia = 1;
        swestrenimiento = 1;
        swdiarrea = 1;
        swsangrado = 1;
        sweritema = 1;
        swhiperhidrosis = 1;
        swbrote = 1;
        swsequedad = 1;
        swprurito = 1;
        swdispepsia = 1;
        swdisminucioncalibre = 1;
        swdisuria = 1;
        swhematuria = 1;
        swtransciclomestrual = 1;
        swnicturia = 1;
        swpolaquiuria = 1;
        swtenesmovesical = 1;
        swcefalea = 1;
        swalteracionmemoria = 1;
        swealteraciosensibilidad = 1;
        swalteracionmotora = 1;
        swvertigo = 1;
        swardorprurito = 1;
        swcansancio = 1;
        swvisionborrosa = 1;
        swlagrimeo = 1;
        swojorojo = 1;
        swtos = 1;
        swdolortoraxico = 1;
        swexpectoracion = 1;
        swdisfonia = 1;
        swepistaxis = 1;
        swhipoacusia = 1;
        swobstruccionnasal = 1;
        swrinorrea = 1;
        swtinitus = 1;
        swartralgias = 1;
        swtendinitis = 1;
        swlimitacionfuncional = 1;
        swparestesias = 1;
        swcervicalgias = 1;
        swdorsalgia = 1;
        swlumbalgia = 1;
        swincapacitante = 1;

    }

    /**
     * abrirformulariodetalleRS
     */
    public void abrirformulariodetalleRS(JFormattedTextField JFTvar) {
        JDesktopPane JDPIngresoRS = new JDesktopPane();
        JDPIngresoRS = (JDesktopPane) JDPIngresoobjRS;
        CRevisionSistemas framerevsistemas;
        framerevsistemas = (CRevisionSistemas) objCRS;
        framerevsistemas.setVisible(false);
        CDetallesAP framedetallRS = new CDetallesAP(framerevsistemas);
        framedetRS = framedetallRS;
        procesoeditorRS(JFTvar);
        framedetallRS.setBounds(0, 2, 550, 600);
        framedetallRS.setTitle("DETALLES REVISION POR SISTEMAS");
        JDPIngresoRS.add(framedetallRS, new Integer(1));
        framedetallRS.setLocation(234, 55);
        framedetallRS.show();
        framedetallRS.setVisible(true);
        framedetallRS.JEDPdetAP.requestFocus();
    }

    /**
     * inicioventanaRS
     */
    public void inicioventanaRS(CRevisionSistemas framerevsistemas) {
        objCRS = framerevsistemas;
    }

    public void procesoeditorRS(JFormattedTextField JFTvar) {
        CDetallesAP CdetRS;
        CdetRS = (CDetallesAP) framedetRS;
        CdetRS.JEDPdetAP.setText(JFTvar.getText());
    }

    public void JBDolorPrecordial_actionPerformed(ActionEvent e) {
        nombredetalleRS = "DOLOR PRECORDIAL";
        abrirformulariodetalleRS(JFTDolorPrecordial);
        swdolorprecordial = 1;
    }

    public void JBLipotimia_actionPerformed(ActionEvent e) {
        nombredetalleRS = "LIPOTIMIA";
        abrirformulariodetalleRS(JFTLipotimia);
        swdlipotimia = 1;
    }

    public void JBPalpitaciones_actionPerformed(ActionEvent e) {
        nombredetalleRS = "PALPITACIONES";
        abrirformulariodetalleRS(JFTPalpit);
        swpalpitaciones = 1;
    }

    public void JBSincope_actionPerformed(ActionEvent e) {
        nombredetalleRS = "SINCOPE";
        abrirformulariodetalleRS(JFTSincope);
        swsincope = 1;
    }

    public void JBDisnea_actionPerformed(ActionEvent e) {
        nombredetalleRS = "DISNEA";
        abrirformulariodetalleRS(jFormattedTextField2);
        swdisnea = 1;
    }

    public void JBDescamacion_actionPerformed(ActionEvent e) {
        nombredetalleRS = "DESCAMACION";
        abrirformulariodetalleRS(JFTdescam);
        swdescamacion = 1;
    }

    public void JBEritema_actionPerformed(ActionEvent e) {
        nombredetalleRS = "ERITEMA";
        abrirformulariodetalleRS(JFTEritema);
        sweritema = 1;
    }

    public void JBHiperhidrosis_actionPerformed(ActionEvent e) {
        nombredetalleRS = "HIPERHIDROSIS";
        abrirformulariodetalleRS(JFTHiperhidrosis);
        swhiperhidrosis = 1;
    }

    public void JBBrote_actionPerformed(ActionEvent e) {
        nombredetalleRS = "BROTE";
        abrirformulariodetalleRS(JFTBrote);
        swbrote = 1;
    }

    public void JBSequedad_actionPerformed(ActionEvent e) {
        nombredetalleRS = "SEQUEDAD";
        abrirformulariodetalleRS(JFTSequedad);
        swsequedad = 1;
    }

    public void JBPrurito_actionPerformed(ActionEvent e) {
        nombredetalleRS = "PRURITO";
        abrirformulariodetalleRS(JFTprurito);
        swprurito = 1;
    }

    public void JBDispepsia_actionPerformed(ActionEvent e) {
        nombredetalleRS = "DISPEPSIA";
        abrirformulariodetalleRS(JFTDispepsia);
        swdispepsia = 1;
    }

    public void JBDolorAbdominal_actionPerformed(ActionEvent e) {
        nombredetalleRS = "DOLOR ABDOMINAL";
        abrirformulariodetalleRS(JFTDolorAbd);
        swdolorabdominal = 1;
    }

    public void JBEpigastraigia_actionPerformed(ActionEvent e) {
        nombredetalleRS = "EPIGASTRAIGIA/PIROSIS";
        abrirformulariodetalleRS(JFTEpigastr);
        swepigastraigia = 1;
    }

    public void JBEstrenimiento_actionPerformed(ActionEvent e) {
        nombredetalleRS = "ESTREÑIMIENTO";
        abrirformulariodetalleRS(JFTEstrenimiento);
        swestrenimiento = 1;
    }

    public void JBDiarrea_actionPerformed(ActionEvent e) {
        nombredetalleRS = "DIARREA";
        abrirformulariodetalleRS(JFTDiarrea);
        swdiarrea = 1;
    }

    public void JBSangrado_actionPerformed(ActionEvent e) {
        nombredetalleRS = "SANGRADO";
        abrirformulariodetalleRS(JFTSangrado);
        swsangrado = 1;
    }

    public void JBDisminucionCalibre_actionPerformed(ActionEvent e) {
        nombredetalleRS = "DISMINUCION CALIBRE";
        abrirformulariodetalleRS(JFTDisminucionCalibre);
        swdisminucioncalibre = 1;
    }

    public void JBDisuria_actionPerformed(ActionEvent e) {
        nombredetalleRS = "DISURIA";
        abrirformulariodetalleRS(JFTDisuria);
        swdisuria = 1;
    }

    public void JBHematuria_actionPerformed(ActionEvent e) {
        nombredetalleRS = "HEMATURIA";
        abrirformulariodetalleRS(JFTHematuria);
        swhematuria = 1;
    }

    public void JBTranstCicloMestrual_actionPerformed(ActionEvent e) {
        nombredetalleRS = "TRANSTORNOS CICLO MESTRUAL";
        abrirformulariodetalleRS(JFTtranstCicloMestr);
        swtransciclomestrual = 1;
    }

    public void JBNicturia_actionPerformed(ActionEvent e) {
        nombredetalleRS = "NICTURIA";
        abrirformulariodetalleRS(JFTNicturia);
        swnicturia = 1;
    }

    public void JBPalaquiuria_actionPerformed(ActionEvent e) {
        nombredetalleRS = "POLAQUIURIA";
        abrirformulariodetalleRS(JFTPalquiuria);
        swpolaquiuria = 1;
    }

    public void JBTenesmoVesical_actionPerformed(ActionEvent e) {
        nombredetalleRS = "TENESMO VESICAL";
        abrirformulariodetalleRS(JFTTenesmovesical);
        swtenesmovesical = 1;
    }

    public void JBCefalea_actionPerformed(ActionEvent e) {
        nombredetalleRS = "CEFALEA";
        abrirformulariodetalleRS(JFTCefalea);
        swcefalea = 1;
    }

    public void JBAlteracionMemoria_actionPerformed(ActionEvent e) {
        nombredetalleRS = "ALTERACION MEMORIA";
        abrirformulariodetalleRS(JFTAlteracionMemoria);
        swalteracionmemoria = 1;
    }

    public void JBAlteracionSensibilidad_actionPerformed(ActionEvent e) {
        nombredetalleRS = "ALTERACION SENSIBILIDAD";
        abrirformulariodetalleRS(JFTAlteracionSencib);
        swealteraciosensibilidad = 1;
    }

    public void JBAlteracionMotora_actionPerformed(ActionEvent e) {
        nombredetalleRS = "ALTERACION MOTORA";
        abrirformulariodetalleRS(JFTAlteracMotora);
        swalteracionmotora = 1;
    }

    public void JBVertigo_actionPerformed(ActionEvent e) {
        nombredetalleRS = "VERTIGO";
        abrirformulariodetalleRS(JFTVertigo);
        swvertigo = 1;
    }

    public void JBArdor_actionPerformed(ActionEvent e) {
        nombredetalleRS = "ARDOR/PRURITO";
        abrirformulariodetalleRS(JFTArdorPrurito);
        swardorprurito = 1;
    }

    public void JBCansancio_actionPerformed(ActionEvent e) {
        nombredetalleRS = "CANSANCIO";
        abrirformulariodetalleRS(JFTCansancio);
        swcansancio = 1;
    }

    public void JBVisionBorrosa_actionPerformed(ActionEvent e) {
        nombredetalleRS = "VISION BORROSA";
        abrirformulariodetalleRS(JFTVisionBorrosa);
        swvisionborrosa = 1;
    }

    public void JBLagrimeo_actionPerformed(ActionEvent e) {
        nombredetalleRS = "LAGRIMEO";
        abrirformulariodetalleRS(JFTLagrimeo);
        swlagrimeo = 1;
    }

    public void JBOjoRojo_actionPerformed(ActionEvent e) {
        nombredetalleRS = "OJO ROJO";
        abrirformulariodetalleRS(JFTOjoRojo);
        swojorojo = 1;
    }

    public void JBTos_actionPerformed(ActionEvent e) {
        nombredetalleRS = "TOS";
        abrirformulariodetalleRS(JFTTos);
        swtos = 1;
    }

    public void JBDolorToraxico_actionPerformed(ActionEvent e) {
        nombredetalleRS = "DOLOR TORAXICO";
        abrirformulariodetalleRS(JFTDolorToraxico);
        swdolortoraxico = 1;
    }

    public void JBExpectoracion_actionPerformed(ActionEvent e) {
        nombredetalleRS = "EXPECTORACION";
        abrirformulariodetalleRS(JFTExpectoracion);
        swexpectoracion = 1;
    }

    public void JBDisfonia_actionPerformed(ActionEvent e) {
        nombredetalleRS = "DISFONIA";
        abrirformulariodetalleRS(JFTDisfonia);
        swdisfonia = 1;
    }

    public void JBEpistaxis_actionPerformed(ActionEvent e) {
        nombredetalleRS = "EPISTAXIS";
        abrirformulariodetalleRS(JFTEpistaxis);
        swepistaxis = 1;
    }

    public void JBHipoacusia_actionPerformed(ActionEvent e) {
        nombredetalleRS = "HIPOACUSIA SUBJETIVA";
        abrirformulariodetalleRS(JFTHipoacusia);
        swhipoacusia = 1;
    }

    public void JBObstruccionNasal_actionPerformed(ActionEvent e) {
        nombredetalleRS = "OBSTRUCCION NASAL";
        abrirformulariodetalleRS(JFTObstruccionNasal);
        swobstruccionnasal = 1;
    }

    public void JBRinorrea_actionPerformed(ActionEvent e) {
        nombredetalleRS = "RINORREA";
        abrirformulariodetalleRS(JFTRinorrea);
        swrinorrea = 1;
    }

    public void JBTinitus_actionPerformed(ActionEvent e) {
        nombredetalleRS = "TINITUS";
        abrirformulariodetalleRS(JFTTinitus);
        swtinitus = 1;
    }

    public void JBArtralgias_actionPerformed(ActionEvent e) {
        nombredetalleRS = "ARTRALGIAS";
        abrirformulariodetalleRS(JFTArtralgias);
        swartralgias = 1;
    }

    public void JBTendinitis_actionPerformed(ActionEvent e) {
        nombredetalleRS = "TENDINITIS";
        abrirformulariodetalleRS(JFTTendinitis);
        swtendinitis = 1;
    }

    public void JBLimitacionFuncional_actionPerformed(ActionEvent e) {
        nombredetalleRS = "LIMITACION FUNCIONAL";
        abrirformulariodetalleRS(JFTLimitacionFunc);
        swlimitacionfuncional = 1;
    }

    public void JBParestesias_actionPerformed(ActionEvent e) {
        nombredetalleRS = "PARESTESIAS/DISESTESIAS";
        abrirformulariodetalleRS(JFTParestesias);
        swparestesias = 1;
    }

    public void JBCervicalgia_actionPerformed(ActionEvent e) {
        nombredetalleRS = "CERVICALGIAS";
        abrirformulariodetalleRS(JFTCervicalgia);
        swcervicalgias = 1;
    }

    public void JBDorsalgia_actionPerformed(ActionEvent e) {
        nombredetalleRS = "DORSALGIAS";
        abrirformulariodetalleRS(JFTDorsalgia);
        swdorsalgia = 1;
    }

    public void JBLumbalgia_actionPerformed(ActionEvent e) {
        nombredetalleRS = "LUMBALGIAS";
        abrirformulariodetalleRS(JFTLumbalgia);
        swlumbalgia = 1;
    }

    public void JBIncapacitante_actionPerformed(ActionEvent e) {
        nombredetalleRS = "INCAPACITANTE";
        abrirformulariodetalleRS(JFTIncapacitante);
        swincapacitante = 1;
    }

    public void JBAtrasRS_actionPerformed(ActionEvent e) {
        CRevisionSistemas framerevsistemas;
        COtrosAnt frameRSAtras;
        frameRSAtras = (COtrosAnt) frameOAOBJ;
        frameRSAtras.setVisible(true);
        framerevsistemas = (CRevisionSistemas) objCRS;
        framerevsistemas.setVisible(false);

    }

    public void JBSguteRV_actionPerformed(ActionEvent e) {
        validarnulosEF();

    }

    public void JBcancelarRS_actionPerformed(ActionEvent e) {

    }

    /**
     * validarnulosEF
     */
    public void validarnulosEF() {
        swval = 0;
        CIngreso frameingreso;
        CHistoriaOcup framehistocup;
        CEnfermedadProf frameenfermedadprof;
        CHistoriaAcciTrab frameaccitrabajo;
        CAntecedentesFamiliar frameantecendnetesfam;
        CAntecedentesPersonales frameantecpersonal;
        CAGineco frameginecologia;
        CInmuniz frameinmunuz;
        COtrosAnt frameotrosantecedentes;
        frameingreso = (CIngreso) frameRSOBJ;
        CRevisionSistemas framers;
        framers = (CRevisionSistemas) objCRS;
        framers.setVisible(false);
        JDesktopPane JDPIngresoEP = new JDesktopPane();
        JDPIngresoEP = (JDesktopPane) JDPIngresoobjRS;
        framehistocup = (CHistoriaOcup) framehoOBJ;
        frameenfermedadprof = (CEnfermedadProf) frameEnfProfOBJ;
        frameaccitrabajo = (CHistoriaAcciTrab) frameAcciTrabajoOBJ;
        frameantecendnetesfam = (CAntecedentesFamiliar) frameAntecFamOBJ;
        frameantecpersonal = (CAntecedentesPersonales) frameAntecPersonalOBJ;
        frameginecologia = (CAGineco) frameGinecologiaOBJ;
        frameinmunuz = (CInmuniz) frameInmunizOBJ;
        frameotrosantecedentes = (COtrosAnt) frameOAOBJ;
        if (swgte == 0) {
            CExamenFisico frameEF = new CExamenFisico(obotactualizarEF, numingredicEF, swedicingrEF, nombrrs, framers, numhcrs, JDPIngresoEP, frameingreso, framehistocup, frameenfermedadprof, frameaccitrabajo, frameantecendnetesfam, frameantecpersonal, frameginecologia, frameinmunuz, frameotrosantecedentes, objppalrs);
            frameEF.setBounds(0, 2, 1010, 600);
            frameEF.setTitle("EXAMEN FISICO");
            JDPIngresoEP.add(frameEF, new Integer(1));
            frameEF.setLocation(5, 55);
            frameEF.show();
            frameEF.setVisible(true);
            frameEF.inicioventanaEF(frameEF);
            swgte = 1;
            objetoexamfisico = frameEF;
            if (swedicingrEF == 1) {
                String cadsqledicEF, idestadogeneral, sqlEF;
                Connection con2 = Cconsql.getConnection();
                cadsqledicEF = "SELECT ingreso.id_ingreso, examen_fisico.estadogen_EF, examen_fisico.tasignovital_EF, examen_fisico.fcsignovita_EF, examen_fisico.frsignovital_EF, examen_fisico.pesosignovital_EF, examen_fisico.tallasignovita_EF, examen_fisico.imcsignovital_EF, examen_fisico.rangosignovital, examen_fisico.cab_EF, examen_fisico.textcab_EF, examen_fisico.cara_EF, examen_fisico.textcara_EF, examen_fisico.ojos_EF, examen_fisico.textojos_EF, examen_fisico.oidos_EF, examen_fisico.textoidos_EF, examen_fisico.nariz_EF, examen_fisico.textnariz_EF, examen_fisico.boca_EF, examen_fisico.textboca_EF, examen_fisico.dentadura_EF, examen_fisico.textdentadura_EF, examen_fisico.cuello_EF, examen_fisico.textcuello_EF, examen_fisico.torax_EF, examen_fisico.texttorax_EF, examen_fisico.cardiaco_EF, examen_fisico.textcardiaco_EF, examen_fisico.pulmon_EF, examen_fisico.textpulmon_EF, examen_fisico.mamas_EF, examen_fisico.textmamas_EF, examen_fisico.abdomen_EF, examen_fisico.textabdomen_EF, examen_fisico.genitales_EF, examen_fisico.textgenitales_EF, examen_fisico.msup_EF, examen_fisico.textmsup_EF, examen_fisico.minf_EF, examen_fisico.textminf_EF, examen_fisico.pies_EF, examen_fisico.textpies_EF, examen_fisico.columna_EF, examen_fisico.textcolumna_EF, examen_fisico.neurolog_EF, examen_fisico.textneurolog_EF, examen_fisico.piel_EF, examen_fisico.textpies_EF, examen_fisico.idlateral_EF FROM ingreso INNER JOIN examen_fisico ON ingreso.id_ingreso = examen_fisico.idingreso_EF WHERE ingreso.id_ingreso=" + numingredicEF;

                try {
                    TSentenciaconsultaEF = con2.createStatement();
                    RconsultaEF = TSentenciaconsultaEF.executeQuery(cadsqledicEF);
                    while (RconsultaEF.next()) {
                        idestadogeneral = RconsultaEF.getString(2);
                        sqlEF = "select *from estado_general where estado_general.id_ag=" + "'" + idestadogeneral + "'";
                        idestadogeneral = validEF.buscarcadena(sqlEF, 2);
                        Object EFobj = idestadogeneral;
                        frameEF.JCBEstadoGeneral.setSelectedItem(EFobj);
                        frameEF.JFTTaEF.setText(RconsultaEF.getString(3));
                        frameEF.JFTfcEF.setText(RconsultaEF.getString(4));
                        frameEF.JFTfrEF.setText(RconsultaEF.getString(5));
                        frameEF.JFTPesoEF.setText(RconsultaEF.getString(6));
                        frameEF.JFTBtallaEF.setText(RconsultaEF.getString(7));
                        frameEF.JFTimcEF.setText(RconsultaEF.getString(8));
                        frameEF.JFTrangoEF.setText(RconsultaEF.getString(9));
                        llenarradio(frameEF.JRsiCab, RconsultaEF.getBoolean(10), frameEF.JRnoCab);
                        frameEF.JTFCabeza.setText(RconsultaEF.getString(11));
                        llenarradio(frameEF.JRsiCaraEF, RconsultaEF.getBoolean(12), frameEF.JRnoCara);
                        frameEF.JTFcaraEF.setText(RconsultaEF.getString(13));
                        llenarradio(frameEF.JRsiOjosEF, RconsultaEF.getBoolean(14), frameEF.JRnoOjosEF);
                        frameEF.JTFojosEF.setText(RconsultaEF.getString(15));
                        llenarradio(frameEF.JRsiOidosEF, RconsultaEF.getBoolean(16), frameEF.JRnoOidos);
                        frameEF.JTFoidosEF.setText(RconsultaEF.getString(17));
                        llenarradio(frameEF.JRBsiNarizEF, RconsultaEF.getBoolean(18), frameEF.JRBnoNariz);
                        frameEF.JTFnarizEF.setText(RconsultaEF.getString(19));
                        llenarradio(frameEF.JRsiBocaEF, RconsultaEF.getBoolean(20), frameEF.JRBnoBocaEF);
                        frameEF.JTFbocaEF.setText(RconsultaEF.getString(21));
                        llenarradio(frameEF.JRsiDentEF, RconsultaEF.getBoolean(22), frameEF.JRBnoDentEF);
                        frameEF.JTFDentEF.setText(RconsultaEF.getString(23));
                        llenarradio(frameEF.JRBsiCuelloEF, RconsultaEF.getBoolean(24), frameEF.JRBnoCuelloEF);
                        frameEF.JTFcuelloEF.setText(RconsultaEF.getString(25));
                        llenarradio(frameEF.JRsiToraxEF, RconsultaEF.getBoolean(26), frameEF.JRBnoToraxEF);
                        frameEF.JTFtoraxEF.setText(RconsultaEF.getString(27));
                        llenarradio(frameEF.JRBsicardiacoEF, RconsultaEF.getBoolean(28), frameEF.JRBnoCardiacoEF);
                        frameEF.JTFCardiacoEF.setText(RconsultaEF.getString(29));
                        llenarradio(frameEF.JRBsiPulmonEF, RconsultaEF.getBoolean(30), frameEF.JRBnoPulmonEF);
                        frameEF.JTFPulmonEF.setText(RconsultaEF.getString(31));
                        llenarradio(frameEF.JRsimamasEF, RconsultaEF.getBoolean(32), frameEF.JRBnomamasEF);
                        frameEF.JTFMamasEF.setText(RconsultaEF.getString(33));
                        llenarradio(frameEF.JRBsiAbdomenEF, RconsultaEF.getBoolean(34), frameEF.JRBnoAbdomenEF);
                        frameEF.JTFAbdomenEF.setText(RconsultaEF.getString(35));
                        llenarradio(frameEF.JRsiGenitalesEF, RconsultaEF.getBoolean(36), frameEF.JRBnoGenitalesEF);
                        frameEF.JTFGenitalesEF.setText(RconsultaEF.getString(37));
                        llenarradio(frameEF.JRBsiMsupEF, RconsultaEF.getBoolean(38), frameEF.JRBnoMsupEF);
                        frameEF.JTFMsup.setText(RconsultaEF.getString(39));
                        llenarradio(frameEF.JRBsiMinfEF, RconsultaEF.getBoolean(40), frameEF.JRnoMinfEF);
                        frameEF.JTFMinfEF.setText(RconsultaEF.getString(41));
                        llenarradio(frameEF.JRsiPiesEF, RconsultaEF.getBoolean(42), frameEF.JRBnoPiesEF);
                        frameEF.JTFPiesEF.setText(RconsultaEF.getString(43));
                        llenarradio(frameEF.JRBsiColEF, RconsultaEF.getBoolean(44), frameEF.JRBnoColEF);
                        frameEF.JTFColEF.setText(RconsultaEF.getString(45));
                        llenarradio(frameEF.JRBNeurEF, RconsultaEF.getBoolean(46), frameEF.JRBnoNeurl);
                        frameEF.JTFNeurlogEF.setText(RconsultaEF.getString(47));
                        llenarradio(frameEF.JRBsiPiel, RconsultaEF.getBoolean(48), frameEF.JRBnoPielEF);
                        frameEF.JTFPielEF.setText(RconsultaEF.getString(49));
                        idestadogeneral = RconsultaEF.getString(50);
                        sqlEF = "select *from lateral where lateral.id_lateral=" + "'" + idestadogeneral + "'";
                        idestadogeneral = validEF.buscarcadena(sqlEF, 2);
                        EFobj = idestadogeneral;
                        frameEF.JCBLateral.setSelectedItem(EFobj);
                        activarboton(frameEF.JBCab);
                        activarboton(frameEF.JBCaraEF);
                        activarboton(frameEF.JBOjosEF);
                        activarboton(frameEF.JBOidosEF);
                        activarboton(frameEF.JBnarizEF);
                        activarboton(frameEF.JBbocaEF);
                        activarboton(frameEF.JBDentEF);
                        activarboton(frameEF.JBCuelloEF);
                        activarboton(frameEF.JBToraxEF);
                        activarboton(frameEF.JBCardiacoEF);
                        activarboton(frameEF.JBPulmonEF);
                        activarboton(frameEF.JBmamasEF);
                        activarboton(frameEF.JBAbdomenEF);
                        activarboton(frameEF.JBGenitalesEF);
                        activarboton(frameEF.JBMsupEF);
                        activarboton(frameEF.JBMinfEF);
                        activarboton(frameEF.JBPiesEF);
                        activarboton(frameEF.JBColEF);
                        activarboton(frameEF.JBNeurologEF);
                        activarboton(frameEF.JBTPielEF);
                    }
                } catch (SQLException e1) {
                    e1.getMessage();
                    cad2 = "NO SE PUDO EJECUTAR LA CONSULTA";
                    cad1 = "PROBLEMAS CON LOS DATOS DE EXAMEN FISICO EN EDICION";
                    validEF.mensajeconfirmacion(cad1, cad2);
                }//cierra el catch
                Cconsql.CerrarConexion();

            }
        } else {
            CExamenFisico frameEF;
            frameEF = (CExamenFisico) objetoexamfisico;
            // ObjectCingreso.setVisible(false);
            frameEF.setVisible(true);
        }

    }

    public void JRCoronaria_actionPerformed(ActionEvent e) {
        controlbotonrs(JRCoronaria, JFTCoronaria, JBcoronaria);
    }

    public void JRArritmia_actionPerformed(ActionEvent e) {
        controlbotonrs(JRArritmia, JFTArritmia, JBArritmia);
    }

    public void JRHa_actionPerformed(ActionEvent e) {
        controlbotonrs(JRHa, JFTha, JBHa);
    }

    public void JBcoronaria_actionPerformed(ActionEvent e) {
        nombredetalleRS = "ENFERMEDADES CORONARIAS - PRE INFARTO";
        abrirformulariodetalleRS(JFTCoronaria);
        swcoronaria = 1;
    }

    public void JBArritmia_actionPerformed(ActionEvent e) {
        nombredetalleRS = "ARRITMIA CARDIACA-TAQUICARDIA";
        abrirformulariodetalleRS(JFTArritmia);
        swarritmia = 1;
    }

    public void JBHa_actionPerformed(ActionEvent e) {
        nombredetalleRS = "HIPERTENSION ARTERIAL SEVERA";
        abrirformulariodetalleRS(JFTha);
        swHA = 1;
    }

    /**
     * llenarradio
     */
    public void llenarradio(JRadioButton jrvarsi, boolean varbool, JRadioButton jrvarno) {
        if (varbool == true) {
            jrvarsi.setSelected(false);
            jrvarno.setSelected(true);
        } else {
            jrvarsi.setSelected(true);
            jrvarno.setSelected(false);
        }
    }

    /**
     * activarboton
     */
    public void activarboton(JButton JVvar) {
        JVvar.setEnabled(true);
    }

    public CRevisionSistemas() {

    }
}//fin de la clase

class CRevisionSistemas_JBHa_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBHa_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBHa_actionPerformed(e);
    }
}

class CRevisionSistemas_JBArritmia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBArritmia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBArritmia_actionPerformed(e);
    }
}

class CRevisionSistemas_JBcoronaria_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBcoronaria_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBcoronaria_actionPerformed(e);
    }
}

class CRevisionSistemas_JRHa_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRHa_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRHa_actionPerformed(e);
    }
}

class CRevisionSistemas_JRArritmia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRArritmia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRArritmia_actionPerformed(e);
    }
}

class CRevisionSistemas_JRCoronaria_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRCoronaria_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRCoronaria_actionPerformed(e);
    }
}

class CRevisionSistemas_JBcancelarRS_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBcancelarRS_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBcancelarRS_actionPerformed(e);
    }
}

class CRevisionSistemas_JBAtrasRS_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBAtrasRS_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasRS_actionPerformed(e);
    }
}

class CRevisionSistemas_JBSguteRV_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBSguteRV_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSguteRV_actionPerformed(e);
    }
}

class CRevisionSistemas_JBIncapacitante_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBIncapacitante_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBIncapacitante_actionPerformed(e);
    }
}

class CRevisionSistemas_JBLumbalgia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBLumbalgia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBLumbalgia_actionPerformed(e);
    }
}

class CRevisionSistemas_JBDorsalgia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBDorsalgia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDorsalgia_actionPerformed(e);
    }
}

class CRevisionSistemas_JBParestesias_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBParestesias_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBParestesias_actionPerformed(e);
    }
}

class CRevisionSistemas_JBLimitacionFuncional_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBLimitacionFuncional_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBLimitacionFuncional_actionPerformed(e);
    }
}

class CRevisionSistemas_JBTendinitis_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBTendinitis_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBTendinitis_actionPerformed(e);
    }
}

class CRevisionSistemas_JBArtralgias_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBArtralgias_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBArtralgias_actionPerformed(e);
    }
}

class CRevisionSistemas_JBRinorrea_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBRinorrea_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBRinorrea_actionPerformed(e);
    }
}

class CRevisionSistemas_JBTinitus_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBTinitus_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBTinitus_actionPerformed(e);
    }
}

class CRevisionSistemas_JBObstruccionNasal_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBObstruccionNasal_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBObstruccionNasal_actionPerformed(e);
    }
}

class CRevisionSistemas_JBHipoacusia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBHipoacusia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBHipoacusia_actionPerformed(e);
    }
}

class CRevisionSistemas_JBEpistaxis_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBEpistaxis_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBEpistaxis_actionPerformed(e);
    }
}

class CRevisionSistemas_JBExpectoracion_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBExpectoracion_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBExpectoracion_actionPerformed(e);
    }
}

class CRevisionSistemas_JBDolorToraxico_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBDolorToraxico_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDolorToraxico_actionPerformed(e);
    }
}

class CRevisionSistemas_JBTos_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBTos_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBTos_actionPerformed(e);
    }
}

class CRevisionSistemas_JBOjoRojo_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBOjoRojo_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBOjoRojo_actionPerformed(e);
    }
}

class CRevisionSistemas_JBLagrimeo_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBLagrimeo_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBLagrimeo_actionPerformed(e);
    }
}

class CRevisionSistemas_JBVisionBorrosa_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBVisionBorrosa_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBVisionBorrosa_actionPerformed(e);
    }
}

class CRevisionSistemas_JBCansancio_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBCansancio_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCansancio_actionPerformed(e);
    }
}

class CRevisionSistemas_JBArdor_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBArdor_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBArdor_actionPerformed(e);
    }
}

class CRevisionSistemas_JBVertigo_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBVertigo_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBVertigo_actionPerformed(e);
    }
}

class CRevisionSistemas_JBAlteracionMotora_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBAlteracionMotora_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAlteracionMotora_actionPerformed(e);
    }
}

class CRevisionSistemas_JBAlteracionSensibilidad_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBAlteracionSensibilidad_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAlteracionSensibilidad_actionPerformed(e);
    }
}

class CRevisionSistemas_JBCefalea_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBCefalea_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCefalea_actionPerformed(e);
    }
}

class CRevisionSistemas_JBAlteracionMemoria_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBAlteracionMemoria_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAlteracionMemoria_actionPerformed(e);
    }
}

class CRevisionSistemas_JBTenesmoVesical_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBTenesmoVesical_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBTenesmoVesical_actionPerformed(e);
    }
}

class CRevisionSistemas_JBPalaquiuria_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBPalaquiuria_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBPalaquiuria_actionPerformed(e);
    }
}

class CRevisionSistemas_JBNicturia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBNicturia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBNicturia_actionPerformed(e);
    }
}

class CRevisionSistemas_JBTranstCicloMestrual_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBTranstCicloMestrual_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBTranstCicloMestrual_actionPerformed(e);
    }
}

class CRevisionSistemas_JBHematuria_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBHematuria_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBHematuria_actionPerformed(e);
    }
}

class CRevisionSistemas_JBDisuria_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBDisuria_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDisuria_actionPerformed(e);
    }
}

class CRevisionSistemas_JBDisminucionCalibre_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBDisminucionCalibre_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDisminucionCalibre_actionPerformed(e);
    }
}

class CRevisionSistemas_JBSangrado_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBSangrado_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSangrado_actionPerformed(e);
    }
}

class CRevisionSistemas_JBEpigastraigia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBEpigastraigia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBEpigastraigia_actionPerformed(e);
    }
}

class CRevisionSistemas_JBEstrenimiento_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBEstrenimiento_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBEstrenimiento_actionPerformed(e);
    }
}

class CRevisionSistemas_JBDiarrea_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBDiarrea_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDiarrea_actionPerformed(e);
    }
}

class CRevisionSistemas_JBDolorAbdominal_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBDolorAbdominal_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDolorAbdominal_actionPerformed(e);
    }
}

class CRevisionSistemas_JBDispepsia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBDispepsia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDispepsia_actionPerformed(e);
    }
}

class CRevisionSistemas_JBPrurito_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBPrurito_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBPrurito_actionPerformed(e);
    }
}

class CRevisionSistemas_JBSequedad_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBSequedad_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSequedad_actionPerformed(e);
    }
}

class CRevisionSistemas_JBBrote_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBBrote_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBBrote_actionPerformed(e);
    }
}

class CRevisionSistemas_JBHiperhidrosis_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBHiperhidrosis_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBHiperhidrosis_actionPerformed(e);
    }
}

class CRevisionSistemas_JBEritema_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBEritema_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBEritema_actionPerformed(e);
    }
}

class CRevisionSistemas_JBDescamacion_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBDescamacion_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDescamacion_actionPerformed(e);
    }
}

class CRevisionSistemas_JBDisnea_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBDisnea_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDisnea_actionPerformed(e);
    }
}

class CRevisionSistemas_JBSincope_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBSincope_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSincope_actionPerformed(e);
    }
}

class CRevisionSistemas_JBPalpitaciones_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBPalpitaciones_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBPalpitaciones_actionPerformed(e);
    }
}

class CRevisionSistemas_JBDolorPrecordial_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBDolorPrecordial_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDolorPrecordial_actionPerformed(e);
    }
}

class CRevisionSistemas_JBLipotimia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBLipotimia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBLipotimia_actionPerformed(e);
    }
}

class CRevisionSistemas_JRIncapacitante_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRIncapacitante_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRIncapacitante_actionPerformed(e);
    }
}

class CRevisionSistemas_JRLumbalgia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRLumbalgia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRLumbalgia_actionPerformed(e);
    }
}

class CRevisionSistemas_JRDorsalgia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRDorsalgia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRDorsalgia_actionPerformed(e);
    }
}

class CRevisionSistemas_JRLimitacionFuncional_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRLimitacionFuncional_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRLimitacionFuncional_actionPerformed(e);
    }
}

class CRevisionSistemas_JRParentestesias_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRParentestesias_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRParentestesias_actionPerformed(e);
    }
}

class CRevisionSistemas_JRCervicalgia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRCervicalgia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRCervicalgia_actionPerformed(e);
    }
}

class CRevisionSistemas_JBCervicalgia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBCervicalgia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCervicalgia_actionPerformed(e);
    }
}

class CRevisionSistemas_JRTinitus_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRTinitus_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRTinitus_actionPerformed(e);
    }
}

class CRevisionSistemas_JRArtralgias_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRArtralgias_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRArtralgias_actionPerformed(e);
    }
}

class CRevisionSistemas_JRTendinitis_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRTendinitis_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRTendinitis_actionPerformed(e);
    }
}

class CRevisionSistemas_JRRinorrea_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRRinorrea_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRRinorrea_actionPerformed(e);
    }
}

class CRevisionSistemas_JRObstruccionNasal_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRObstruccionNasal_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRObstruccionNasal_actionPerformed(e);
    }
}

class CRevisionSistemas_JRHipoacusia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRHipoacusia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRHipoacusia_actionPerformed(e);
    }
}

class CRevisionSistemas_JRDisfonia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRDisfonia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRDisfonia_actionPerformed(e);
    }
}

class CRevisionSistemas_JBDisfonia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JBDisfonia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDisfonia_actionPerformed(e);
    }
}

class CRevisionSistemas_JREpistaxis_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JREpistaxis_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JREpistaxis_actionPerformed(e);
    }
}

class CRevisionSistemas_JRExpectoracion_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRExpectoracion_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRExpectoracion_actionPerformed(e);
    }
}

class CRevisionSistemas_JRTos_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRTos_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRTos_actionPerformed(e);
    }
}

class CRevisionSistemas_JRDolorToraxico_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRDolorToraxico_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRDolorToraxico_actionPerformed(e);
    }
}

class CRevisionSistemas_JROjoRojo_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JROjoRojo_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JROjoRojo_actionPerformed(e);
    }
}

class CRevisionSistemas_JRLagrimeo_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRLagrimeo_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRLagrimeo_actionPerformed(e);
    }
}

class CRevisionSistemas_JRVisionBorrosa_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRVisionBorrosa_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRVisionBorrosa_actionPerformed(e);
    }
}

class CRevisionSistemas_JRCansancio_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRCansancio_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRCansancio_actionPerformed(e);
    }
}

class CRevisionSistemas_JRArdorprurito_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRArdorprurito_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRArdorprurito_actionPerformed(e);
    }
}

class CRevisionSistemas_JRVertigo_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRVertigo_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRVertigo_actionPerformed(e);
    }
}

class CRevisionSistemas_JRAlteracionMotora_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRAlteracionMotora_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRAlteracionMotora_actionPerformed(e);
    }
}

class CRevisionSistemas_JRAlteracionSensib_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRAlteracionSensib_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRAlteracionSensib_actionPerformed(e);
    }
}

class CRevisionSistemas_JRAlteracionMemoria_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRAlteracionMemoria_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRAlteracionMemoria_actionPerformed(e);
    }
}

class CRevisionSistemas_JRCefalea_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRCefalea_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRCefalea_actionPerformed(e);
    }
}

class CRevisionSistemas_JRTenesmoVesical_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRTenesmoVesical_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRTenesmoVesical_actionPerformed(e);
    }
}

class CRevisionSistemas_JRPolaquiuria_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRPolaquiuria_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRPolaquiuria_actionPerformed(e);
    }
}

class CRevisionSistemas_JRNicturia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRNicturia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRNicturia_actionPerformed(e);
    }
}

class CRevisionSistemas_JRTrantCicloMestr_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRTrantCicloMestr_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRTrantCicloMestr_actionPerformed(e);
    }
}

class CRevisionSistemas_JRHematuria_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRHematuria_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRHematuria_actionPerformed(e);
    }
}

class CRevisionSistemas_JRDisuria_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRDisuria_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRDisuria_actionPerformed(e);
    }
}

class CRevisionSistemas_JRDisminucionCalibre_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRDisminucionCalibre_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRDisminucionCalibre_actionPerformed(e);
    }
}

class CRevisionSistemas_JRSangrado_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRSangrado_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRSangrado_actionPerformed(e);
    }
}

class CRevisionSistemas_JRDiarrea_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRDiarrea_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRDiarrea_actionPerformed(e);
    }
}

class CRevisionSistemas_JREstrenimiento_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JREstrenimiento_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JREstrenimiento_actionPerformed(e);
    }
}

class CRevisionSistemas_JREpigastraigia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JREpigastraigia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JREpigastraigia_actionPerformed(e);
    }
}

class CRevisionSistemas_JRDispepsia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRDispepsia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRDispepsia_actionPerformed(e);
    }
}

class CRevisionSistemas_JRDolorAbdominal_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRDolorAbdominal_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRDolorAbdominal_actionPerformed(e);
    }
}

class CRevisionSistemas_JRPrurito_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRPrurito_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRPrurito_actionPerformed(e);
    }
}

class CRevisionSistemas_JRSequedad_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRSequedad_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRSequedad_actionPerformed(e);
    }
}

class CRevisionSistemas_JRBrote_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRBrote_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBrote_actionPerformed(e);
    }
}

class CRevisionSistemas_JRHiperhidrosis_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRHiperhidrosis_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRHiperhidrosis_actionPerformed(e);
    }
}

class CRevisionSistemas_JREritema_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JREritema_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JREritema_actionPerformed(e);
    }
}

class CRevisionSistemas_JRDisnea_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRDisnea_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRDisnea_actionPerformed(e);
    }
}

class CRevisionSistemas_JRDescamacion_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRDescamacion_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRDescamacion_actionPerformed(e);
    }
}

class CRevisionSistemas_JRSincope_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRSincope_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRSincope_actionPerformed(e);
    }
}

class CRevisionSistemas_JRDolorPrecordial_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRDolorPrecordial_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRDolorPrecordial_actionPerformed(e);
    }
}

class CRevisionSistemas_JRLipotimia_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRLipotimia_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRLipotimia_actionPerformed(e);
    }
}

class CRevisionSistemas_JRPalpitaciones_actionAdapter implements ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JRPalpitaciones_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRPalpitaciones_actionPerformed(e);
    }
}

class CRevisionSistemas_JFTtranstCicloMestr_actionAdapter implements
        ActionListener {

    private CRevisionSistemas adaptee;

    CRevisionSistemas_JFTtranstCicloMestr_actionAdapter(CRevisionSistemas adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JFTtranstCicloMestr_actionPerformed(e);
    }
}
