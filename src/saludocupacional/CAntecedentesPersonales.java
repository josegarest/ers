package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class CAntecedentesPersonales extends JInternalFrame {

    Object objppalap;
    Object obotactualizarGO;
    String cad1;
    String cad2;
    public Statement TSentenciaconsultaGO;
    public ResultSet RconsultaGO;
    public ConexionSql Cconsql = new ConexionSql();
    ValidarComponentes validGO = new ValidarComponentes();
    String numingredicGO;
    int swedicingrGO;
    Object objetoginecoobs = new Object();
    Object framedetantperso = new Object();
    int swval;
    String nombrap = new String();
    String numhcap = new String();
    Object JDPIngresoobjAP = new Object();
    Object frameAPOBJ = new Object();
    Object frameafOBJ = new Object();
    Object framehoOBJ = new Object();
    Object frameEnfProfOBJ = new Object();
    Object frameAcciTrabajoOBJ = new Object();
    Object frameAntecFamOBJ = new Object();
    Object frameAntecPersonalOBJ = new Object();
    //DECLARACION DE VARIABLES
    int swgte = 0;
    public static int swdiabet = 1;
    public static int swhipart = 1;
    public static int swcoronaria = 1;
    public static int swdislipedia = 1;
    public static int swasmabronq = 1;
    public static int swpsicopatia = 1;
    public static int swalergia = 1;
    public static int swtuberculosis = 1;
    public static int swatipia = 1;
    public static int swgota = 1;
    public static int swatccbroncpulm = 1;
    public static int swendocrinopatias = 1;
    public static int swnefrologias = 1;
    public static int swpatias = 1;
    public static int swhemopatias = 1;
    public static int swets = 1;
    public static int swgastroduod = 1;
    public static int swcolecistopatia = 1;
    public static int swhepatitis = 1;
    public static int swenfneurologicas = 1;
    public static int swfiebresprolongadas = 1;
    public static int swcolageno = 1;
    public static int swtraumat = 1;
    public static int swotros = 1;
    /// public  CDetallesAP framedetantperso;
    public JDesktopPane JDPAntPersObj = new JDesktopPane();
    CAntecedentesPersonales objCAP;
    public String nombredetalle = "";
    // CMotivoEnfermedad objvarME;
    Object framevarOAnt;
    Object OGingrAP;
    //DECLARACION DE COMPONENTES VISUALES
    JPanel JPAntecedentesPersonales = new JPanel();
    JLabel JLBNhcAP = new JLabel();
    JButton JBAtrasAC = new JButton();
    JButton JBSgteAP = new JButton();
    JButton JBCancelarAP = new JButton();
    JLabel JLBNumhcAP = new JLabel();
    JLabel JLBnhcAP = new JLabel();
    JTabbedPane JTBAntPers = new JTabbedPane();
    JPanel JPAntPers = new JPanel();
    JCheckBox JCHDiabet = new JCheckBox();
    JTextField JTFDiabet = new JTextField();
    JButton JBDiabet = new JButton();
    JLabel JLBAgrandar = new JLabel();
    JCheckBox JCHHipArt = new JCheckBox();
    JTextField JTFHiperArt = new JTextField();
    JButton JBHipArt = new JButton();
    JCheckBox JCHCoronario = new JCheckBox();
    JTextField JFTCoronario = new JTextField();
    JButton JBCoronario = new JButton();
    JCheckBox JCHDislipedia = new JCheckBox();
    JTextField JTFDislipidemia = new JTextField();
    JButton JBDislipidemia = new JButton();
    JCheckBox JCHAsmaBronq = new JCheckBox();
    JTextField JTFAsmaBronquial = new JTextField();
    JButton JBAsmaBronquial = new JButton();
    JCheckBox JCHPsicopatia = new JCheckBox();
    JTextField JTFPsicopatia = new JTextField();
    JButton JBPsicopatia = new JButton();
    JCheckBox JCHAlergiaAp = new JCheckBox();
    JTextField JTFAlergiaAP = new JTextField();
    JButton JBAlergias = new JButton();
    JCheckBox JCHTuberculosisAP = new JCheckBox();
    JTextField JTFTuberculosisAP = new JTextField();
    JButton JBTuberculosisAP = new JButton();
    JCheckBox JCHAtipiaAP = new JCheckBox();
    JTextField JTFAtipiaAP = new JTextField();
    JButton JBAtipia = new JButton();
    JCheckBox JCHGotaAP = new JCheckBox();
    JTextField JTFGotaAP = new JTextField();
    JButton JBGota = new JButton();
    JCheckBox jCheckBox1 = new JCheckBox();
    JCheckBox JCHEndocrinopatiasAP = new JCheckBox();
    JTextField JTFEndocrinopatiasAP = new JTextField();
    JButton JBendocrinopatias = new JButton();
    JCheckBox JCHNefrologiasAP = new JCheckBox();
    JTextField JTNefrologiasAP = new JTextField();
    JButton JBNefrologiasAP = new JButton();
    JCheckBox JCHPatiasAP = new JCheckBox();
    JTextField JTFPatiasAP = new JTextField();
    JButton JBPatia = new JButton();
    JCheckBox JCHHemopatiasAP = new JCheckBox();
    JTextField JTFHemopatias = new JTextField();
    JButton JBHemopatiasAP = new JButton();
    JCheckBox JCHEtsAP = new JCheckBox();
    JTextField JTFETSap = new JTextField();
    JButton JBEts = new JButton();
    JCheckBox JCHUlceraGastr = new JCheckBox();
    JTextField JTFUlcGastrDuodAP = new JTextField();
    JButton JBUlcGastr = new JButton();
    JCheckBox JCHColecistopatiaAP = new JCheckBox();
    JTextField JTFColecistopatia = new JTextField();
    JButton JBColecistopatia = new JButton();
    JCheckBox JCHHepatitis = new JCheckBox();
    JTextField JTFHepatitis = new JTextField();
    JButton JBHepatis = new JButton();
    JCheckBox JCHEnfNeurologicaEP = new JCheckBox();
    JTextField JTFEnfNeurologAP = new JTextField();
    JButton JBEnfNeurologicas = new JButton();
    JCheckBox JCHFiebresProAP = new JCheckBox();
    JTextField JFTFiebresProlongAP = new JTextField();
    JButton JBFiebresProlongAP = new JButton();
    JCheckBox JCHAffBroncoAP = new JCheckBox();
    JTextField JTFAfccbroncpulm = new JTextField();
    JButton JBAfccBroncPulm = new JButton();
    JLabel JLBAgrd = new JLabel();
    JCheckBox JCHColagenopatias = new JCheckBox();
    JTextField JFTColagenopatias = new JTextField();
    JButton JBColagenopatias = new JButton();
    JLabel JLBNombpacAP = new JLabel();
    JTextField JTFTraumatismo = new JTextField();
    JCheckBox JCHTraumatismo = new JCheckBox();
    JButton JBtraumatism = new JButton();
    JCheckBox JCHOtros = new JCheckBox();
    JButton JBOtros = new JButton();
    JTextField JTFOtros = new JTextField();

    public CAntecedentesPersonales(Object obotactualizarAF, String numingredicAP, int swedicingrAP, String Nombrepacap, CAntecedentesFamiliar frameaf, String varnHC, JDesktopPane JDPIngreso, CIngreso frameingreso, CHistoriaOcup framehistocup, CEnfermedadProf frameenfermedadprof, CHistoriaAcciTrab frameaccitrabajo, Object objppalaf) {

        try {
            jbInit();
            frameAPOBJ = frameingreso;
            frameafOBJ = frameaf;
            framehoOBJ = framehistocup;
            frameEnfProfOBJ = frameenfermedadprof;
            frameAcciTrabajoOBJ = frameaccitrabajo;
            //frameAntecFamOBJ=frameantecendnetesfam;
            JLBNombpacAP.setText(Nombrepacap);
            JLBnhcAP.setText(varnHC);
            JDPIngresoobjAP = JDPIngreso;
            nombrap = Nombrepacap;
            numhcap = varnHC;
            swgte = 0;
            swedicingrGO = swedicingrAP;
            numingredicGO = numingredicAP;
            obotactualizarGO = obotactualizarAF;
            objppalap = objppalaf;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        //DESACTIVAMOS LOS CUADROS DE TEXTO
        JTFDiabet.setEditable(false);
        JTFHiperArt.setEditable(false);
        JFTCoronario.setEditable(false);
        JTFDislipidemia.setEditable(false);
        JTFAsmaBronquial.setEditable(false);
        JTFPsicopatia.setEditable(false);
        JTFAlergiaAP.setEditable(false);
        JTFTuberculosisAP.setEditable(false);
        JTFAtipiaAP.setEditable(false);
        JTFGotaAP.setEditable(false);
        JTFEndocrinopatiasAP.setEditable(false);
        JTNefrologiasAP.setEditable(false);
        JTFPatiasAP.setEditable(false);
        JTFHemopatias.setEditable(false);
        JTFETSap.setEditable(false);
        JTFUlcGastrDuodAP.setEditable(false);
        JTFColecistopatia.setEditable(false);
        JTFHepatitis.setEditable(false);
        JTFEnfNeurologAP.setEditable(false);
        JFTFiebresProlongAP.setEditable(false);
        JTFAfccbroncpulm.setEditable(false);
        JFTColagenopatias.setEditable(false);
        //DEACTIVAMOS LOS BOTONES
        JBDiabet.setEnabled(false);
        JBAfccBroncPulm.setEnabled(false);
        JBAlergias.setEnabled(false);
        JBAsmaBronquial.setEnabled(false);
        JBAtipia.setEnabled(false);
        JBColagenopatias.setEnabled(false);
        JBColecistopatia.setEnabled(false);
        JBCoronario.setEnabled(false);
        JBDislipidemia.setEnabled(false);
        JBendocrinopatias.setEnabled(false);
        JBEnfNeurologicas.setEnabled(false);
        JBEts.setEnabled(false);
        JBFiebresProlongAP.setEnabled(false);
        JBGota.setEnabled(false);
        JBHemopatiasAP.setEnabled(false);
        JBHepatis.setEnabled(false);
        JBHipArt.setEnabled(false);
        JBNefrologiasAP.setEnabled(false);
        JBPatia.setEnabled(false);
        JBPsicopatia.setEnabled(false);
        JBTuberculosisAP.setEnabled(false);
        JBUlcGastr.setEnabled(false);

        //INICIALIZACION DE LOS PANELES
        this.setClosable(true);
        this.setIconifiable(true);
        this.setMaximizable(true);
        this.setResizable(true);
        this.getContentPane().setBackground(UIManager.getColor(
                "InternalFrame.inactiveTitleForeground"));
        this.setVisible(true);

        this.getContentPane().setLayout(null);
        JPAntecedentesPersonales.setBackground(new Color(122, 150, 223));
        JPAntecedentesPersonales.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JPAntecedentesPersonales.setBorder(BorderFactory.createRaisedBevelBorder());
        JPAntecedentesPersonales.setBounds(new Rectangle(6, 3, 991, 557));
        JPAntecedentesPersonales.setLayout(null);
        JLBNhcAP.setBackground(Color.black);
        JLBNhcAP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNhcAP.setForeground(Color.red);
        JLBNhcAP.setToolTipText("");
        JLBNhcAP.setBounds(new Rectangle(10, 4, 376, 35));
        JBAtrasAC.setBounds(new Rectangle(139, 516, 112, 36));
        JBAtrasAC.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBAtrasAC.setMnemonic('R');
        JBAtrasAC.setText("Atras");
        JBAtrasAC.addActionListener(new CAntecedentesPersonales_JBAtrasAC_actionAdapter(this));
        JBAtrasAC.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN3.GIF")));
        JBAtrasAC.setSelectedIcon(null);
        JBSgteAP.setBounds(new Rectangle(434, 517, 133, 36));
        JBSgteAP.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBSgteAP.setToolTipText("");
        JBSgteAP.setMnemonic('S');
        JBSgteAP.setText("SIGUIENTE");
        JBSgteAP.addActionListener(new CAntecedentesPersonales_JBSgteAP_actionAdapter(this));
        JBSgteAP.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/MG19.GIF")));
        JBSgteAP.setSelectedIcon(null);
        JBCancelarAP.setBounds(new Rectangle(749, 518, 131, 36));
        JBCancelarAP.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBCancelarAP.setToolTipText("");
        JBCancelarAP.setMnemonic('S');
        JBCancelarAP.setText("CANCELAR");
        JBCancelarAP.addActionListener(new CAntecedentesPersonales_JBCancelarAP_actionAdapter(this));
        JBCancelarAP.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN4.GIF")));
        JBCancelarAP.setSelectedIcon(null);
        JLBNumhcAP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNumhcAP.setForeground(Color.red);
        JLBNumhcAP.setToolTipText("");
        JLBNumhcAP.setBounds(new Rectangle(440, 10, 158, 24));
        JLBnhcAP.setBackground(Color.red);
        JLBnhcAP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBnhcAP.setForeground(Color.red);
        JLBnhcAP.setToolTipText("");
        JLBnhcAP.setBounds(new Rectangle(461, 9, 111, 31));
        JTBAntPers.setBackground(new Color(49, 106, 197));
        JTBAntPers.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JTBAntPers.setForeground(Color.red);
        JTBAntPers.setBorder(BorderFactory.createRaisedBevelBorder());
        JTBAntPers.setBounds(new Rectangle(5, 72, 982, 432));
        JPAntPers.setBackground(new Color(146, 154, 255));
        JPAntPers.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JPAntPers.setLayout(null);
        JCHDiabet.setBackground(SystemColor.textHighlight);
        JCHDiabet.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHDiabet.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHDiabet.setToolTipText("");
        JCHDiabet.setText("DIABETES");
        JCHDiabet.setBounds(new Rectangle(105, 3, 121, 23));
        JCHDiabet.addActionListener(new CAntecedentesPersonales_JCHDiabet_actionAdapter(this));
        JTFDiabet.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFDiabet.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFDiabet.setToolTipText("");
        JTFDiabet.setBounds(new Rectangle(240, 4, 92, 22));
        JBDiabet.setBounds(new Rectangle(345, 1, 57, 29));
        JBDiabet.setActionCommand("JBDiabet");
        JBDiabet.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDiabet.setSelectedIcon(null);
        JBDiabet.addActionListener(new CAntecedentesPersonales_JBDiabet_actionAdapter(this));
        JLBAgrandar.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBAgrandar.setForeground(Color.blue);
        JLBAgrandar.setText("Agrandar");
        JLBAgrandar.setBounds(new Rectangle(416, 0, 69, 21));
        JCHHipArt.setBackground(SystemColor.textHighlight);
        JCHHipArt.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHHipArt.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHHipArt.setToolTipText("");
        JCHHipArt.setActionCommand("Hipert. Arterial");
        JCHHipArt.setText("HIPER. ARTERIAL");
        JCHHipArt.setBounds(new Rectangle(104, 29, 122, 23));
        JCHHipArt.addActionListener(new CAntecedentesPersonales_JCHHipArt_actionAdapter(this));
        JTFHiperArt.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFHiperArt.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFHiperArt.setToolTipText("");
        JTFHiperArt.setBounds(new Rectangle(240, 30, 92, 22));
        JBHipArt.setBounds(new Rectangle(344, 33, 57, 29));
        JBHipArt.setToolTipText("");
        JBHipArt.setActionCommand("");
        JBHipArt.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBHipArt.setSelectedIcon(null);
        JBHipArt.addActionListener(new CAntecedentesPersonales_JBHipArt_actionAdapter(this));
        JCHCoronario.setBackground(SystemColor.textHighlight);
        JCHCoronario.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHCoronario.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHCoronario.setToolTipText("");
        JCHCoronario.setActionCommand("Hipert. Arterial");
        JCHCoronario.setText("CARDIO/CORONARIO");
        JCHCoronario.setBounds(new Rectangle(104, 93, 122, 23));
        JCHCoronario.addActionListener(new CAntecedentesPersonales_JCHCoronario_actionAdapter(this));
        JFTCoronario.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JFTCoronario.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTCoronario.setToolTipText("");
        JFTCoronario.setBounds(new Rectangle(240, 95, 92, 22));
        JBCoronario.setBounds(new Rectangle(345, 93, 57, 29));
        JBCoronario.setToolTipText("");
        JBCoronario.setActionCommand("");
        JBCoronario.setText("");
        JBCoronario.addActionListener(new CAntecedentesPersonales_JBCoronario_actionAdapter(this));
        JBCoronario.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBCoronario.setSelectedIcon(null);
        JCHDislipedia.setBackground(SystemColor.textHighlight);
        JCHDislipedia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHDislipedia.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHDislipedia.setToolTipText("");
        JCHDislipedia.setActionCommand("Hipert. Arterial");
        JCHDislipedia.setText("DISLIPIDEMIA");
        JCHDislipedia.setBounds(new Rectangle(104, 128, 122, 23));
        JCHDislipedia.addActionListener(new CAntecedentesPersonales_JCHDislipedia_actionAdapter(this));
        JTFDislipidemia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFDislipidemia.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFDislipidemia.setToolTipText("");
        JTFDislipidemia.setBounds(new Rectangle(240, 130, 92, 22));
        JBDislipidemia.setBounds(new Rectangle(344, 127, 57, 29));
        JBDislipidemia.setToolTipText("");
        JBDislipidemia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDislipidemia.setSelectedIcon(null);
        JBDislipidemia.addActionListener(new CAntecedentesPersonales_JBDislipidemia_actionAdapter(this));
        JCHAsmaBronq.setBackground(SystemColor.textHighlight);
        JCHAsmaBronq.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHAsmaBronq.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHAsmaBronq.setToolTipText("");
        JCHAsmaBronq.setActionCommand("Hipert. Arterial");
        JCHAsmaBronq.setText("ASMA BRONQUIAL");
        JCHAsmaBronq.setBounds(new Rectangle(104, 164, 122, 23));
        JCHAsmaBronq.addActionListener(new CAntecedentesPersonales_JCHAsmaBronq_actionAdapter(this));
        JTFAsmaBronquial.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFAsmaBronquial.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFAsmaBronquial.setToolTipText("");
        JTFAsmaBronquial.setBounds(new Rectangle(240, 166, 92, 22));
        JBAsmaBronquial.setBounds(new Rectangle(344, 161, 57, 29));
        JBAsmaBronquial.setToolTipText("");
        JBAsmaBronquial.setText("");
        JBAsmaBronquial.addActionListener(new CAntecedentesPersonales_JBAsmaBronquial_actionAdapter(this));
        JBAsmaBronquial.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBAsmaBronquial.setSelectedIcon(null);
        JCHPsicopatia.setBackground(SystemColor.textHighlight);
        JCHPsicopatia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHPsicopatia.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHPsicopatia.setToolTipText("");
        JCHPsicopatia.setActionCommand("Hipert. Arterial");
        JCHPsicopatia.setText("PSICOPATIA");
        JCHPsicopatia.setBounds(new Rectangle(104, 201, 122, 23));
        JCHPsicopatia.addActionListener(new CAntecedentesPersonales_JCHPsicopatia_actionAdapter(this));
        JTFPsicopatia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFPsicopatia.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFPsicopatia.setToolTipText("");
        JTFPsicopatia.setBounds(new Rectangle(239, 202, 92, 22));
        JBPsicopatia.setBounds(new Rectangle(343, 195, 57, 29));
        JBPsicopatia.setToolTipText("");
        JBPsicopatia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBPsicopatia.setSelectedIcon(null);
        JBPsicopatia.addActionListener(new CAntecedentesPersonales_JBPsicopatia_actionAdapter(this));
        JCHAlergiaAp.setBackground(SystemColor.textHighlight);
        JCHAlergiaAp.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHAlergiaAp.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHAlergiaAp.setToolTipText("");
        JCHAlergiaAp.setActionCommand("Hipert. Arterial");
        JCHAlergiaAp.setText("ALERGIA");
        JCHAlergiaAp.setBounds(new Rectangle(104, 240, 122, 23));
        JCHAlergiaAp.addActionListener(new CAntecedentesPersonales_JCHAlergiaAp_actionAdapter(this));
        JTFAlergiaAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFAlergiaAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFAlergiaAP.setToolTipText("");
        JTFAlergiaAP.setBounds(new Rectangle(239, 241, 92, 22));
        JBAlergias.setBounds(new Rectangle(343, 233, 57, 29));
        JBAlergias.setToolTipText("");
        JBAlergias.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBAlergias.setSelectedIcon(null);
        JBAlergias.addActionListener(new CAntecedentesPersonales_JBAlergias_actionAdapter(this));
        JCHTuberculosisAP.setBackground(SystemColor.textHighlight);
        JCHTuberculosisAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHTuberculosisAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHTuberculosisAP.setToolTipText("");
        JCHTuberculosisAP.setActionCommand("Hipert. Arterial");
        JCHTuberculosisAP.setText("NEOFORMACIONES");
        JCHTuberculosisAP.setBounds(new Rectangle(104, 274, 122, 23));
        JCHTuberculosisAP.addActionListener(new CAntecedentesPersonales_JCHTuberculosisAP_actionAdapter(this));
        JTFTuberculosisAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFTuberculosisAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFTuberculosisAP.setToolTipText("");
        JTFTuberculosisAP.setBounds(new Rectangle(239, 273, 92, 22));
        JBTuberculosisAP.setBounds(new Rectangle(343, 266, 57, 29));
        JBTuberculosisAP.setToolTipText("");
        JBTuberculosisAP.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBTuberculosisAP.setSelectedIcon(null);
        JBTuberculosisAP.addActionListener(new CAntecedentesPersonales_JBTuberculosisAP_actionAdapter(this));
        JCHAtipiaAP.setBackground(SystemColor.textHighlight);
        JCHAtipiaAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHAtipiaAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHAtipiaAP.setToolTipText("");
        JCHAtipiaAP.setActionCommand("Hipert. Arterial");
        JCHAtipiaAP.setText("OBESIDAD/S.PESO");
        JCHAtipiaAP.setBounds(new Rectangle(104, 305, 122, 23));
        JCHAtipiaAP.addActionListener(new CAntecedentesPersonales_JCHAtipiaAP_actionAdapter(this));
        JTFAtipiaAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFAtipiaAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFAtipiaAP.setToolTipText("");
        JTFAtipiaAP.setBounds(new Rectangle(239, 304, 92, 22));
        JBAtipia.setBounds(new Rectangle(343, 298, 57, 29));
        JBAtipia.setToolTipText("");
        JBAtipia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBAtipia.setSelectedIcon(null);
        JBAtipia.addActionListener(new CAntecedentesPersonales_JBAtipia_actionAdapter(this));
        JCHGotaAP.setBackground(SystemColor.textHighlight);
        JCHGotaAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHGotaAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHGotaAP.setToolTipText("");
        JCHGotaAP.setActionCommand("Hipert. Arterial");
        JCHGotaAP.setText("GOTA");
        JCHGotaAP.setBounds(new Rectangle(104, 336, 122, 23));
        JCHGotaAP.addActionListener(new CAntecedentesPersonales_JCHGotaAP_actionAdapter(this));
        JTFGotaAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFGotaAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFGotaAP.setToolTipText("");
        JTFGotaAP.setBounds(new Rectangle(239, 338, 92, 22));
        JBGota.setBounds(new Rectangle(343, 331, 57, 29));
        JBGota.setToolTipText("");
        JBGota.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBGota.setSelectedIcon(null);
        JBGota.addActionListener(new CAntecedentesPersonales_JBGota_actionAdapter(this));
        jCheckBox1.setText("jCheckBox1");
        jCheckBox1.setBounds(new Rectangle(9, 32, 121, 23));
        JCHEndocrinopatiasAP.setBackground(SystemColor.textHighlight);
        JCHEndocrinopatiasAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHEndocrinopatiasAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHEndocrinopatiasAP.setToolTipText("");
        JCHEndocrinopatiasAP.setText("ENDOCRINOPATIAS");
        JCHEndocrinopatiasAP.setBounds(new Rectangle(552, 2, 128, 23));
        JCHEndocrinopatiasAP.addActionListener(new CAntecedentesPersonales_JCHEndocrinopatiasAP_actionAdapter(this));
        JTFEndocrinopatiasAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFEndocrinopatiasAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFEndocrinopatiasAP.setToolTipText("");
        JTFEndocrinopatiasAP.setBounds(new Rectangle(700, 4, 92, 22));
        JBendocrinopatias.setBounds(new Rectangle(813, 3, 57, 29));
        JBendocrinopatias.setActionCommand("JBDiabet");
        JBendocrinopatias.setText("");
        JBendocrinopatias.addActionListener(new CAntecedentesPersonales_JBendocrinopatias_actionAdapter(this));
        JBendocrinopatias.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBendocrinopatias.setSelectedIcon(null);
        JCHNefrologiasAP.setBackground(SystemColor.textHighlight);
        JCHNefrologiasAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHNefrologiasAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHNefrologiasAP.setToolTipText("");
        JCHNefrologiasAP.setText("NEFROLOGIAS");
        JCHNefrologiasAP.setBounds(new Rectangle(552, 33, 128, 23));
        JCHNefrologiasAP.addActionListener(new CAntecedentesPersonales_JCHNefrologiasAP_actionAdapter(this));
        JTNefrologiasAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTNefrologiasAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTNefrologiasAP.setToolTipText("");
        JTNefrologiasAP.setBounds(new Rectangle(700, 34, 92, 22));
        JBNefrologiasAP.setBounds(new Rectangle(813, 34, 57, 29));
        JBNefrologiasAP.setActionCommand("JBDiabet");
        JBNefrologiasAP.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBNefrologiasAP.setSelectedIcon(null);
        JBNefrologiasAP.addActionListener(new CAntecedentesPersonales_JBNefrologiasAP_actionAdapter(this));
        JCHPatiasAP.setBackground(SystemColor.textHighlight);
        JCHPatiasAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHPatiasAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHPatiasAP.setToolTipText("");
        JCHPatiasAP.setText("QUIRURGICOS");
        JCHPatiasAP.setBounds(new Rectangle(552, 65, 128, 23));
        JCHPatiasAP.addActionListener(new CAntecedentesPersonales_JCHPatiasAP_actionAdapter(this));
        JTFPatiasAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFPatiasAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFPatiasAP.setToolTipText("");
        JTFPatiasAP.setBounds(new Rectangle(700, 67, 92, 22));
        JBPatia.setBounds(new Rectangle(813, 66, 57, 29));
        JBPatia.setToolTipText("");
        JBPatia.setActionCommand("JBDiabet");
        JBPatia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBPatia.setSelectedIcon(null);
        JBPatia.addActionListener(new CAntecedentesPersonales_JBPatia_actionAdapter(this));
        JCHHemopatiasAP.setBackground(SystemColor.textHighlight);
        JCHHemopatiasAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHHemopatiasAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHHemopatiasAP.setToolTipText("");
        JCHHemopatiasAP.setText("HEMOPATIAS");
        JCHHemopatiasAP.setBounds(new Rectangle(553, 97, 128, 23));
        JCHHemopatiasAP.addActionListener(new CAntecedentesPersonales_JCHHemopatiasAP_actionAdapter(this));
        JTFHemopatias.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFHemopatias.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFHemopatias.setToolTipText("");
        JTFHemopatias.setBounds(new Rectangle(700, 99, 92, 22));
        JBHemopatiasAP.setBounds(new Rectangle(813, 99, 57, 29));
        JBHemopatiasAP.setToolTipText("");
        JBHemopatiasAP.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBHemopatiasAP.setSelectedIcon(null);
        JBHemopatiasAP.addActionListener(new CAntecedentesPersonales_JBHemopatiasAP_actionAdapter(this));
        JBHemopatiasAP.setActionCommand("JBDiabet");
        JCHEtsAP.setBackground(SystemColor.textHighlight);
        JCHEtsAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHEtsAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHEtsAP.setToolTipText("");
        JCHEtsAP.setText("E.T.S.");
        JCHEtsAP.setBounds(new Rectangle(553, 131, 128, 23));
        JCHEtsAP.addActionListener(new CAntecedentesPersonales_JCHEtsAP_actionAdapter(this));
        JTFETSap.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFETSap.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFETSap.setToolTipText("");
        JTFETSap.setBounds(new Rectangle(699, 131, 92, 22));
        JBEts.setBounds(new Rectangle(813, 132, 57, 29));
        JBEts.setToolTipText("");
        JBEts.setActionCommand("JBDiabet");
        JBEts.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBEts.setSelectedIcon(null);
        JBEts.addActionListener(new CAntecedentesPersonales_JBEts_actionAdapter(this));
        JCHUlceraGastr.setBackground(SystemColor.textHighlight);
        JCHUlceraGastr.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHUlceraGastr.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHUlceraGastr.setToolTipText("");
        JCHUlceraGastr.setText("A.GASTDUODENAL");
        JCHUlceraGastr.setBounds(new Rectangle(553, 163, 128, 23));
        JCHUlceraGastr.addActionListener(new CAntecedentesPersonales_JCHUlceraGastr_actionAdapter(this));
        JTFUlcGastrDuodAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFUlcGastrDuodAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFUlcGastrDuodAP.setToolTipText("");
        JTFUlcGastrDuodAP.setBounds(new Rectangle(698, 163, 92, 22));
        JBUlcGastr.setBounds(new Rectangle(812, 165, 57, 29));
        JBUlcGastr.setToolTipText("");
        JBUlcGastr.setActionCommand("JBDiabet");
        JBUlcGastr.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBUlcGastr.setSelectedIcon(null);
        JBUlcGastr.addActionListener(new CAntecedentesPersonales_JBUlcGastr_actionAdapter(this));
        JCHColecistopatiaAP.setBackground(SystemColor.textHighlight);
        JCHColecistopatiaAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHColecistopatiaAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHColecistopatiaAP.setToolTipText("");
        JCHColecistopatiaAP.setText("COLECISTOPATIA");
        JCHColecistopatiaAP.setBounds(new Rectangle(553, 195, 128, 23));
        JCHColecistopatiaAP.addActionListener(new CAntecedentesPersonales_JCHColecistopatiaAP_actionAdapter(this));
        JTFColecistopatia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFColecistopatia.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFColecistopatia.setToolTipText("");
        JTFColecistopatia.setBounds(new Rectangle(699, 197, 92, 22));
        JBColecistopatia.setBounds(new Rectangle(813, 197, 57, 29));
        JBColecistopatia.setToolTipText("");
        JBColecistopatia.setActionCommand("JBDiabet");
        JBColecistopatia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBColecistopatia.setSelectedIcon(null);
        JBColecistopatia.addActionListener(new CAntecedentesPersonales_JBColecistopatia_actionAdapter(this));
        JCHHepatitis.setBackground(SystemColor.textHighlight);
        JCHHepatitis.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHHepatitis.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHHepatitis.setToolTipText("");
        JCHHepatitis.setText("HEPATITIS");
        JCHHepatitis.setBounds(new Rectangle(552, 231, 128, 23));
        JCHHepatitis.addActionListener(new CAntecedentesPersonales_JCHHepatitis_actionAdapter(this));
        JTFHepatitis.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFHepatitis.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFHepatitis.setToolTipText("");
        JTFHepatitis.setBounds(new Rectangle(700, 232, 92, 22));
        JBHepatis.setBounds(new Rectangle(814, 230, 57, 29));
        JBHepatis.setToolTipText("");
        JBHepatis.setActionCommand("JBDiabet");
        JBHepatis.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBHepatis.setSelectedIcon(null);
        JBHepatis.addActionListener(new CAntecedentesPersonales_JBHepatis_actionAdapter(this));
        JCHEnfNeurologicaEP.setBackground(SystemColor.textHighlight);
        JCHEnfNeurologicaEP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHEnfNeurologicaEP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHEnfNeurologicaEP.setToolTipText("");
        JCHEnfNeurologicaEP.setText("ENF.NEUROLOGICAS");
        JCHEnfNeurologicaEP.setBounds(new Rectangle(552, 263, 128, 23));
        JCHEnfNeurologicaEP.addActionListener(new CAntecedentesPersonales_JCHEnfNeurologicaEP_actionAdapter(this));
        JTFEnfNeurologAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFEnfNeurologAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFEnfNeurologAP.setToolTipText("");
        JTFEnfNeurologAP.setBounds(new Rectangle(700, 266, 92, 22));
        JBEnfNeurologicas.setBounds(new Rectangle(813, 267, 57, 29));
        JBEnfNeurologicas.setToolTipText("");
        JBEnfNeurologicas.setActionCommand("JBDiabet");
        JBEnfNeurologicas.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBEnfNeurologicas.setSelectedIcon(null);
        JBEnfNeurologicas.addActionListener(new CAntecedentesPersonales_JBEnfNeurologicas_actionAdapter(this));
        JCHFiebresProAP.setBackground(SystemColor.textHighlight);
        JCHFiebresProAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHFiebresProAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHFiebresProAP.setToolTipText("");
        JCHFiebresProAP.setText("T. O-MUSCULARES");
        JCHFiebresProAP.setBounds(new Rectangle(552, 305, 128, 23));
        JCHFiebresProAP.addActionListener(new CAntecedentesPersonales_JCHFiebresProAP_actionAdapter(this));
        JFTFiebresProlongAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JFTFiebresProlongAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTFiebresProlongAP.setToolTipText("");
        JFTFiebresProlongAP.setBounds(new Rectangle(700, 305, 92, 22));
        JBFiebresProlongAP.setBounds(new Rectangle(813, 301, 57, 29));
        JBFiebresProlongAP.setToolTipText("");
        JBFiebresProlongAP.setActionCommand("JBDiabet");
        JBFiebresProlongAP.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBFiebresProlongAP.setSelectedIcon(null);
        JBFiebresProlongAP.addActionListener(new CAntecedentesPersonales_JBFiebresProlongAP_actionAdapter(this));
        JCHAffBroncoAP.setBackground(SystemColor.textHighlight);
        JCHAffBroncoAP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHAffBroncoAP.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHAffBroncoAP.setToolTipText("");
        JCHAffBroncoAP.setActionCommand("Hipert. Arterial");
        JCHAffBroncoAP.setText("AF.BRONCOPULM");
        JCHAffBroncoAP.setBounds(new Rectangle(104, 370, 122, 23));
        JCHAffBroncoAP.addActionListener(new CAntecedentesPersonales_JCHAffBroncoAP_actionAdapter(this));
        JTFAfccbroncpulm.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFAfccbroncpulm.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFAfccbroncpulm.setToolTipText("");
        JTFAfccbroncpulm.setBounds(new Rectangle(239, 370, 92, 22));
        JBAfccBroncPulm.setBounds(new Rectangle(343, 366, 57, 29));
        JBAfccBroncPulm.setToolTipText("");
        JBAfccBroncPulm.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBAfccBroncPulm.setSelectedIcon(null);
        JBAfccBroncPulm.addActionListener(new CAntecedentesPersonales_JBAfccBroncPulm_actionAdapter(this));
        JLBAgrd.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBAgrd.setForeground(Color.blue);
        JLBAgrd.setText("Agrandar");
        JLBAgrd.setBounds(new Rectangle(887, 0, 69, 21));
        JCHColagenopatias.setBackground(SystemColor.textHighlight);
        JCHColagenopatias.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHColagenopatias.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHColagenopatias.setToolTipText("");
        JCHColagenopatias.setText("T. TEJ CONECTIVO");
        JCHColagenopatias.setBounds(new Rectangle(552, 336, 128, 23));
        JCHColagenopatias.addActionListener(new CAntecedentesPersonales_JCHColagenopatias_actionAdapter(this));
        JFTColagenopatias.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JFTColagenopatias.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTColagenopatias.setToolTipText("");
        JFTColagenopatias.setBounds(new Rectangle(701, 336, 92, 22));
        JBColagenopatias.setBounds(new Rectangle(814, 332, 57, 29));
        JBColagenopatias.setToolTipText("");
        JBColagenopatias.setActionCommand("JBDiabet");
        JBColagenopatias.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBColagenopatias.setSelectedIcon(null);
        JBColagenopatias.addActionListener(new CAntecedentesPersonales_JBColagenopatias_actionAdapter(this));
        JTFTraumatismo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFTraumatismo.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFTraumatismo.setToolTipText("");
        JTFTraumatismo.setEditable(false);
        JTFTraumatismo.setBounds(new Rectangle(240, 65, 92, 22));
        JCHTraumatismo.setBackground(SystemColor.textHighlight);
        JCHTraumatismo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHTraumatismo.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHTraumatismo.setToolTipText("");
        JCHTraumatismo.setActionCommand("Hipert. Arterial");
        JCHTraumatismo.setText("TRAUMATISMO");
        JCHTraumatismo.setBounds(new Rectangle(104, 64, 122, 23));
        JCHTraumatismo.addActionListener(new CAntecedentesPersonales_JCHTraumatismo_actionAdapter(this));
        JBtraumatism.setBounds(new Rectangle(345, 67, 57, 22));
        JBtraumatism.setEnabled(false);
        JBtraumatism.setToolTipText("");
        JBtraumatism.setActionCommand("");
        JBtraumatism.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBtraumatism.addActionListener(new CAntecedentesPersonales_JBtraumatism_actionAdapter(this));
        JCHOtros.setBackground(SystemColor.textHighlight);
        JCHOtros.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHOtros.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHOtros.setToolTipText("");
        JCHOtros.setText("OTROS");
        JCHOtros.setBounds(new Rectangle(552, 363, 128, 23));
        JCHOtros.addActionListener(new CAntecedentesPersonales_JCHOtros_actionAdapter(this));
        JBOtros.setBounds(new Rectangle(814, 366, 57, 29));
        JBOtros.setEnabled(false);
        JBOtros.setToolTipText("");
        JBOtros.setActionCommand("JBDiabet");
        JBOtros.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBOtros.addActionListener(new CAntecedentesPersonales_JBOtros_actionAdapter(this));
        JTFOtros.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFOtros.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFOtros.setToolTipText("");
        JTFOtros.setEditable(false);
        JTFOtros.setBounds(new Rectangle(700, 364, 92, 22));
        this.getContentPane().add(JPAntecedentesPersonales);
        JPAntecedentesPersonales.add(JLBNhcAP);
        JPAntecedentesPersonales.add(JLBnhcAP);
        JPAntecedentesPersonales.add(JTBAntPers);
        JPAntecedentesPersonales.add(JLBNombpacAP);
        JPAntecedentesPersonales.add(JLBNumhcAP);
        JPAntecedentesPersonales.add(JBCancelarAP);
        JPAntecedentesPersonales.add(JBAtrasAC);
        JPAntecedentesPersonales.add(JBSgteAP);
        JPAntPers.add(JLBAgrandar);
        JPAntPers.add(JTFDiabet);
        JPAntPers.add(JBDiabet);
        JPAntPers.add(JCHDiabet);
        JPAntPers.add(JTFAfccbroncpulm);
        JPAntPers.add(JBAfccBroncPulm);
        JPAntPers.add(JCHAffBroncoAP);
        JPAntPers.add(JBGota);
        JPAntPers.add(JBAtipia);
        JPAntPers.add(JCHAtipiaAP);
        JPAntPers.add(JTFAtipiaAP);
        JPAntPers.add(JBTuberculosisAP);
        JPAntPers.add(JBAlergias);
        JPAntPers.add(JCHGotaAP);
        JPAntPers.add(JTFGotaAP);
        JPAntPers.add(JCHTuberculosisAP);
        JPAntPers.add(JTFTuberculosisAP);
        JPAntPers.add(JTFAlergiaAP);
        JPAntPers.add(JCHAlergiaAp);
        JPAntPers.add(JTFPsicopatia);
        JPAntPers.add(JCHPsicopatia);
        JPAntPers.add(JBPsicopatia);
        JPAntPers.add(JTFAsmaBronquial);
        JPAntPers.add(JCHAsmaBronq);
        JPAntPers.add(JBAsmaBronquial);
        JPAntPers.add(JCHDislipedia);
        JPAntPers.add(JTFDislipidemia);
        JPAntPers.add(JBDislipidemia);
        JPAntPers.add(JCHCoronario);
        JPAntPers.add(JFTCoronario);
        JPAntPers.add(JTFHiperArt);
        JPAntPers.add(JCHHipArt);
        JPAntPers.add(JCHTraumatismo);
        JPAntPers.add(JTFTraumatismo);
        JPAntPers.add(JBCoronario);
        JPAntPers.add(JBHipArt);
        JPAntPers.add(JBtraumatism);
        JPAntPers.add(JLBAgrd);
        JPAntPers.add(JTFEndocrinopatiasAP);
        JPAntPers.add(JBendocrinopatias);
        JPAntPers.add(JCHEndocrinopatiasAP);
        JPAntPers.add(JTNefrologiasAP);
        JPAntPers.add(JBNefrologiasAP);
        JPAntPers.add(JCHNefrologiasAP);
        JPAntPers.add(JTFPatiasAP);
        JPAntPers.add(JCHPatiasAP);
        JPAntPers.add(JBPatia);
        JPAntPers.add(JTFHemopatias);
        JPAntPers.add(JBEts);
        JPAntPers.add(JTFETSap);
        JPAntPers.add(JBUlcGastr);
        JPAntPers.add(JTFUlcGastrDuodAP);
        JPAntPers.add(JBColecistopatia);
        JPAntPers.add(JBHemopatiasAP);
        JPAntPers.add(JBHepatis);
        JPAntPers.add(JCHHemopatiasAP);
        JPAntPers.add(JCHEtsAP);
        JPAntPers.add(JCHUlceraGastr);
        JPAntPers.add(JCHColecistopatiaAP);
        JPAntPers.add(JCHHepatitis);
        JPAntPers.add(JBFiebresProlongAP);
        JPAntPers.add(JCHEnfNeurologicaEP);
        JPAntPers.add(JCHFiebresProAP);
        JPAntPers.add(JCHColagenopatias);
        JPAntPers.add(JBColagenopatias);
        JPAntPers.add(JBOtros);
        JPAntPers.add(JBEnfNeurologicas);
        JPAntPers.add(JTFEnfNeurologAP);
        JPAntPers.add(JFTFiebresProlongAP);
        JPAntPers.add(JFTColagenopatias);
        JPAntPers.add(JTFOtros);
        JPAntPers.add(JTFColecistopatia);
        JPAntPers.add(JTFHepatitis);
        JPAntPers.add(JCHOtros);
        JTBAntPers.add(JPAntPers, "ANTECEDENTES PERSONALES");
        JLBNombpacAP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNombpacAP.setForeground(Color.red);
        JLBNombpacAP.setToolTipText("");
        JLBNombpacAP.setText("");
        JLBNombpacAP.setBounds(new Rectangle(4, 7, 297, 24));
    }

    /**
     * inicioventanaAP
     */
    public void inicioventanaAP(CAntecedentesPersonales frameAP) {
        objCAP = frameAP;
    }

    public void abrirformulariodetalles(JTextField JFTabrirform) {
        JDesktopPane JDPIngresoAP = new JDesktopPane();
        JDPIngresoAP = (JDesktopPane) JDPIngresoobjAP;
        objCAP.setVisible(false);
        CDetallesAP framedetallap = new CDetallesAP(objCAP);
        framedetantperso = framedetallap;
        procesoeditor(JFTabrirform);
        framedetallap.setBounds(0, 2, 550, 600);
        framedetallap.setTitle("DETALLES ANTECEDENTES PERSONALES");
        JDPIngresoAP.add(framedetallap, new Integer(1));
        framedetallap.setLocation(234, 55);
        framedetallap.show();
        framedetallap.setVisible(true);
        framedetallap.JEDPdetAP.requestFocus();
    }

    public void JCHAsmaBronq_actionPerformed(ActionEvent e) {
        controlbotones(JCHAsmaBronq, JTFAsmaBronquial, JBAsmaBronquial);
        //JBAsmaBronquial.setEnabled(true);
    }

    public void JBDiabet_actionPerformed(ActionEvent e) {
        // if(JTFDiabet.getText().compareTo("")==0){
        nombredetalle = "DIABETES";
        abrirformulariodetalles(JTFDiabet);
        swdiabet = 1;

    }

    public void JBHipArt_actionPerformed(ActionEvent e) {
        nombredetalle = "HIPERTENSION ARTERIAL";
        abrirformulariodetalles(JTFHiperArt);
        swhipart = 1;
    }

    public void JBCoronario_actionPerformed(ActionEvent e) {
        nombredetalle = "CORONARIOPATIA";
        abrirformulariodetalles(JFTCoronario);
        swcoronaria = 1;
    }

    public void JBDislipidemia_actionPerformed(ActionEvent e) {
        nombredetalle = "DISLIPIDEMIA";
        abrirformulariodetalles(JTFDislipidemia);
        swdislipedia = 1;
    }

    public void JBAsmaBronquial_actionPerformed(ActionEvent e) {
        nombredetalle = "ASMA BRONQUIAL";
        abrirformulariodetalles(JTFAsmaBronquial);
        swasmabronq = 1;
    }

    public void JBPsicopatia_actionPerformed(ActionEvent e) {
        nombredetalle = "PSICOPATIA";
        abrirformulariodetalles(JTFPsicopatia);
        swpsicopatia = 1;
    }

    public void JBAlergias_actionPerformed(ActionEvent e) {
        nombredetalle = "ALERGIAS";
        abrirformulariodetalles(JTFAlergiaAP);
        swalergia = 1;
    }

    public void JBTuberculosisAP_actionPerformed(ActionEvent e) {
        nombredetalle = "TUBERCULOSIS";
        abrirformulariodetalles(JTFTuberculosisAP);
        swtuberculosis = 1;
    }

    public void JBAtipia_actionPerformed(ActionEvent e) {
        nombredetalle = "ATIPIA";
        abrirformulariodetalles(JTFAtipiaAP);
        swatipia = 1;
    }

    public void JBGota_actionPerformed(ActionEvent e) {
        nombredetalle = "GOTA";
        abrirformulariodetalles(JTFGotaAP);
        swgota = 1;
    }

    public void JBAfccBroncPulm_actionPerformed(ActionEvent e) {
        nombredetalle = "AFECCION BRONCOPULMONAR";
        abrirformulariodetalles(JTFAfccbroncpulm);
        swatccbroncpulm = 1;
    }

    public void JBendocrinopatias_actionPerformed(ActionEvent e) {
        nombredetalle = "ENDOCRINOPATIAS";
        abrirformulariodetalles(JTFEndocrinopatiasAP);
        swendocrinopatias = 1;
    }

    public void JBNefrologiasAP_actionPerformed(ActionEvent e) {
        nombredetalle = "NEFROPATIAS";
        abrirformulariodetalles(JTNefrologiasAP);
        swnefrologias = 1;
    }

    public void JBPatia_actionPerformed(ActionEvent e) {
        nombredetalle = "QUIRURGICOS";
        abrirformulariodetalles(JTFPatiasAP);
        swpatias = 1;
    }

    public void JBHemopatiasAP_actionPerformed(ActionEvent e) {
        nombredetalle = "HEMOPATIAS";
        abrirformulariodetalles(JTFHemopatias);
        swhemopatias = 1;
    }

    public void JBEts_actionPerformed(ActionEvent e) {
        nombredetalle = "E.T.S.";
        abrirformulariodetalles(JTFETSap);
        swets = 1;
    }

    public void JBUlcGastr_actionPerformed(ActionEvent e) {
        nombredetalle = "ULCERA GASTRODUODENAL";
        abrirformulariodetalles(JTFUlcGastrDuodAP);
        swgastroduod = 1;
    }

    public void JBColecistopatia_actionPerformed(ActionEvent e) {
        nombredetalle = "COLECISTOPATIA";
        abrirformulariodetalles(JTFColecistopatia);
        swcolecistopatia = 1;
    }

    public void JBHepatis_actionPerformed(ActionEvent e) {
        nombredetalle = "HEPATITIS";
        abrirformulariodetalles(JTFHepatitis);
        swhepatitis = 1;
    }

    public void JBEnfNeurologicas_actionPerformed(ActionEvent e) {
        nombredetalle = "ENFERMEDADES NEUROLOGICAS";
        abrirformulariodetalles(JTFEnfNeurologAP);
        swenfneurologicas = 1;
    }

    public void JBFiebresProlongAP_actionPerformed(ActionEvent e) {
        nombredetalle = "FIEBRES PROLONGADAS";
        abrirformulariodetalles(JFTFiebresProlongAP);
        swfiebresprolongadas = 1;
    }

    public void JBColagenopatias_actionPerformed(ActionEvent e) {
        nombredetalle = "COLAGENOPATIAS";
        abrirformulariodetalles(JFTColagenopatias);
        swcolageno = 1;
    }

    public void procesoeditor(JTextField JFTvar) {
        CDetallesAP Cdetap;
        Cdetap = (CDetallesAP) framedetantperso;
        Cdetap.JEDPdetAP.setText(JFTvar.getText());
    }

    public void JCHDiabet_actionPerformed(ActionEvent e) {
        controlbotones(JCHDiabet, JTFDiabet, JBDiabet);
        // JBDiabet.setEnabled(true);
    }

    public void JCHHipArt_actionPerformed(ActionEvent e) {
        controlbotones(JCHHipArt, JTFHiperArt, JBHipArt);
        //JBHipArt.setEnabled(true);
    }

    public void JCHCoronario_actionPerformed(ActionEvent e) {
        controlbotones(JCHCoronario, JFTCoronario, JBCoronario);
        //JBCoronario.setEnabled(true);
    }

    public void JCHDislipedia_actionPerformed(ActionEvent e) {
        controlbotones(JCHDislipedia, JTFDislipidemia, JBDislipidemia);
        //JBDislipidemia.setEnabled(true);
    }

    public void JCHPsicopatia_actionPerformed(ActionEvent e) {
        controlbotones(JCHPsicopatia, JTFPsicopatia, JBPsicopatia);
        //JBPsicopatia.setEnabled(true);
    }

    public void JCHAlergiaAp_actionPerformed(ActionEvent e) {
        controlbotones(JCHAlergiaAp, JTFAlergiaAP, JBAlergias);
        //JBAlergias.setEnabled(true);
    }

    public void JCHTuberculosisAP_actionPerformed(ActionEvent e) {
        controlbotones(JCHTuberculosisAP, JTFTuberculosisAP, JBTuberculosisAP);
        //JBTuberculosisAP.setEnabled(true);
    }

    public void JCHAtipiaAP_actionPerformed(ActionEvent e) {
        controlbotones(JCHAtipiaAP, JTFAtipiaAP, JBAtipia);
        //JBAtipia.setEnabled(true);
    }

    public void JCHGotaAP_actionPerformed(ActionEvent e) {
        controlbotones(JCHGotaAP, JTFGotaAP, JBGota);
        //JBGota.setEnabled(true);
    }

    public void JCHEndocrinopatiasAP_actionPerformed(ActionEvent e) {
        controlbotones(JCHEndocrinopatiasAP, JTFEndocrinopatiasAP, JBendocrinopatias);
        //JBendocrinopatias.setEnabled(true);
    }

    public void JCHNefrologiasAP_actionPerformed(ActionEvent e) {
        controlbotones(JCHNefrologiasAP, JTNefrologiasAP, JBNefrologiasAP);
        //JBNefrologiasAP.setEnabled(true);
    }

    public void JCHPatiasAP_actionPerformed(ActionEvent e) {
        controlbotones(JCHPatiasAP, JTFPatiasAP, JBPatia);
        //JBPatia.setEnabled(true);
    }

    public void JCHHemopatiasAP_actionPerformed(ActionEvent e) {
        controlbotones(JCHHemopatiasAP, JTFHemopatias, JBHemopatiasAP);
        //JBHemopatiasAP.setEnabled(true);
    }

    public void JCHEtsAP_actionPerformed(ActionEvent e) {
        controlbotones(JCHEtsAP, JTFETSap, JBEts);
        //JBEts.setEnabled(true);
    }

    public void JCHUlceraGastr_actionPerformed(ActionEvent e) {
        controlbotones(JCHUlceraGastr, JTFUlcGastrDuodAP, JBUlcGastr);
        //JBEts.setEnabled(true);
    }

    public void JCHColecistopatiaAP_actionPerformed(ActionEvent e) {
        controlbotones(JCHColecistopatiaAP, JTFColecistopatia, JBColecistopatia);
        //JBColecistopatia.setEnabled(true);
    }

    public void JCHHepatitis_actionPerformed(ActionEvent e) {
        controlbotones(JCHHepatitis, JTFHepatitis, JBHepatis);
        //JBHepatis.setEnabled(true);
    }

    public void JCHEnfNeurologicaEP_actionPerformed(ActionEvent e) {
        controlbotones(JCHEnfNeurologicaEP, JTFEnfNeurologAP, JBEnfNeurologicas);
        //JBEnfNeurologicas.setEnabled(true);
    }

    public void JCHFiebresProAP_actionPerformed(ActionEvent e) {
        controlbotones(JCHFiebresProAP, JFTFiebresProlongAP, JBFiebresProlongAP);
        //JBEnfNeurologicas.setEnabled(true);
    }

    public void JCHColagenopatias_actionPerformed(ActionEvent e) {
        controlbotones(JCHColagenopatias, JFTColagenopatias, JBColagenopatias);
        //JBColagenopatias.setEnabled(true);
    }

    public void JBSgteAP_actionPerformed(ActionEvent e) {
        validarnulosGO();
    }

    public void JBAtrasAC_actionPerformed(ActionEvent e) {
        CAntecedentesFamiliar frameAFAtras;
        frameAFAtras = (CAntecedentesFamiliar) frameafOBJ;
        frameAFAtras.setVisible(true);
        objCAP.setVisible(false);
    }

    public void JBCancelarAP_actionPerformed(ActionEvent e) {
        // procesocancelarAP();
    }

    /**
     * validarnulosGO
     */
    public void validarnulosGO() {
        swval = 0;
        CIngreso frameingreso;
        frameingreso = (CIngreso) frameAPOBJ;
        CHistoriaOcup framehistocup;
        CEnfermedadProf frameenfermedadprof;
        CHistoriaAcciTrab frameaccitrabajo;
        CAntecedentesFamiliar frameantecendnetesfam;
        CAntecedentesPersonales frameap;
        frameap = (CAntecedentesPersonales) objCAP;
        frameap.setVisible(false);
        JDesktopPane JDPIngresoEP = new JDesktopPane();
        JDPIngresoEP = (JDesktopPane) JDPIngresoobjAP;
        framehistocup = (CHistoriaOcup) framehoOBJ;
        frameenfermedadprof = (CEnfermedadProf) frameEnfProfOBJ;
        frameaccitrabajo = (CHistoriaAcciTrab) frameAcciTrabajoOBJ;
        frameantecendnetesfam = (CAntecedentesFamiliar) frameafOBJ;
        if (swgte == 0) {
            CAGineco frameGO = new CAGineco(obotactualizarGO, numingredicGO, swedicingrGO, nombrap, frameap, numhcap, JDPIngresoEP, frameingreso, framehistocup, frameenfermedadprof, frameaccitrabajo, frameantecendnetesfam, objppalap);
            frameGO.setBounds(0, 2, 1010, 600);
            frameGO.setTitle("ANTECEDENTES GINECOOBSTETRICIOS");
            JDPIngresoEP.add(frameGO, new Integer(1));
            frameGO.setLocation(5, 55);
            frameGO.show();
            frameGO.setVisible(true);
            frameGO.inicioventanaAP(frameGO);
            swgte = 1;
            objetoginecoobs = frameGO;
            if (swedicingrGO == 1) {
                String cadsqledicGO, idmenarquia, sqlGO;
                Connection con2 = Cconsql.getConnection();
                cadsqledicGO = "SELECT ingreso.id_ingreso, ginecologia.idmenarquia_gineco, ginecologia.ciclos_gineco, ginecologia.fechaultregla_gineco, ginecologia.gravidez_gineco, ginecologia.paridad_gineco, ginecologia.cesarea_gineco, ginecologia.aborto_gineco, ginecologia.planifica_gineco, ginecologia.idplanifica_gineco, ginecologia.fechaultcitologia_gineco, ginecologia.idresultadocitologia_gineco, ginecologia.tiempoplanifica_gineco FROM ingreso INNER JOIN ginecologia ON ingreso.id_ingreso = ginecologia.idingreso_gineco WHERE ingreso.id_ingreso=" + numingredicGO;
                try {
                    TSentenciaconsultaGO = con2.createStatement();
                    RconsultaGO = TSentenciaconsultaGO.executeQuery(cadsqledicGO);
                    while (RconsultaGO.next()) {
                        idmenarquia = RconsultaGO.getString(2);
                        sqlGO = "select *from menarquia where menarquia.id_mquia=" + "'" + idmenarquia + "'";
                        idmenarquia = validGO.buscarcadena(sqlGO, 2);
                        Object GOobj = idmenarquia;
                        frameGO.JCMenarquia.setSelectedItem(GOobj);
                        frameGO.JTFCiclos.setText(RconsultaGO.getString(3));
                        frameGO.JFTFechUltMestr.setText(RconsultaGO.getString(4));
                        frameGO.JCHGravid.setSelected(RconsultaGO.getBoolean(5));
                        frameGO.JTFParidad.setText(RconsultaGO.getString(6));
                        frameGO.JCHCesarea.setSelected(RconsultaGO.getBoolean(7));
                        frameGO.JCHAborto.setSelected(RconsultaGO.getBoolean(8));
                        frameGO.JCHPlanifica.setSelected(RconsultaGO.getBoolean(9));
                        idmenarquia = RconsultaGO.getString(10);
                        sqlGO = "select *from planifica where planifica.id_planif=" + "'" + idmenarquia + "'";
                        idmenarquia = validGO.buscarcadena(sqlGO, 2);
                        GOobj = idmenarquia;
                        frameGO.JCPlanifica.setSelectedItem(GOobj);
                        frameGO.JCPlanifica.setEnabled(true);
                        frameGO.JFTFechUltCit.setText(RconsultaGO.getString(11));
                        idmenarquia = RconsultaGO.getString(12);
                        sqlGO = "select *from resultados_gineco where resultados_gineco.id_resgico=" + "'" + idmenarquia + "'";
                        idmenarquia = validGO.buscarcadena(sqlGO, 2);
                        GOobj = idmenarquia;
                        frameGO.JCResultado.setSelectedItem(GOobj);
                        frameGO.JFTTiempoPlan.setText(RconsultaGO.getString(13));
                    }
                }// fin del try
                catch (SQLException e1) {
                    e1.getMessage();
                    cad2 = "NO SE PUDO EJECUTAR LA CONSULTA";
                    cad1 = "PROBLEMAS CON LOS DATOS DE GINECO OBSTETRICIA EN EDICION";
                    validGO.mensajeconfirmacion(cad1, cad2);
                }//cierra el catch
                Cconsql.CerrarConexion();
            }//fin del if swedicingrGO
        }//fin del if swgte
        else {
            CAGineco frameGO;
            frameGO = (CAGineco) objetoginecoobs;
            // ObjectCingreso.setVisible(false);
            frameGO.setVisible(true);
        }

    }

    /**
     * procesocancelarAP
     */
    /*  public void procesocancelarAP() {
        objCAP.setVisible(false);
        objCAP.dispose();
        objvarME.procesocancelarME();
    }*/
    /**
     * controlbotones
     */
    public void controlbotones(JCheckBox JCHparametro, JTextField JTFpar, JButton JBvar) {
        if (JCHparametro.isSelected() == true) {
            JCHparametro.setSelected(true);
            JBvar.setEnabled(true);
        } else {
            JCHparametro.setSelected(false);
            JTFpar.setText(" ");
            JBvar.setEnabled(false);

        }

    }

    public void JCHTraumatismo_actionPerformed(ActionEvent e) {
        controlbotones(JCHTraumatismo, JTFTraumatismo, JBtraumatism);
    }

    public void JBtraumatism_actionPerformed(ActionEvent e) {
        nombredetalle = "TRAUMATISMO";
        abrirformulariodetalles(JTFTraumatismo);
        swtraumat = 1;
    }

    public void JCHOtros_actionPerformed(ActionEvent e) {
        controlbotones(JCHOtros, JTFOtros, JBOtros);
    }

    public void JBOtros_actionPerformed(ActionEvent e) {
        nombredetalle = "OTROS";
        abrirformulariodetalles(JTFOtros);
        swotros = 1;

    }

    public void JCHAffBroncoAP_actionPerformed(ActionEvent e) {
        controlbotones(JCHAffBroncoAP, JTFAfccbroncpulm, JBAfccBroncPulm);
    }

    public CAntecedentesPersonales() {

    }
}//fin clase

class CAntecedentesPersonales_JCHAffBroncoAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHAffBroncoAP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHAffBroncoAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBOtros_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBOtros_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBOtros_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHOtros_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHOtros_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHOtros_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBtraumatism_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBtraumatism_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBtraumatism_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHTraumatismo_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHTraumatismo_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHTraumatismo_actionPerformed(e);
    }
} //

class CAntecedentesPersonales_JBCancelarAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBCancelarAP_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCancelarAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBAtrasAC_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBAtrasAC_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasAC_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBSgteAP_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBSgteAP_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSgteAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHColagenopatias_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHColagenopatias_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHColagenopatias_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHFiebresProAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHFiebresProAP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHFiebresProAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHEnfNeurologicaEP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHEnfNeurologicaEP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHEnfNeurologicaEP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHHepatitis_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHHepatitis_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHHepatitis_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHColecistopatiaAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHColecistopatiaAP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHColecistopatiaAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHUlceraGastr_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHUlceraGastr_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHUlceraGastr_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHEtsAP_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHEtsAP_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHEtsAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHHemopatiasAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHHemopatiasAP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHHemopatiasAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHPatiasAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHPatiasAP_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHPatiasAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHNefrologiasAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHNefrologiasAP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHNefrologiasAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHEndocrinopatiasAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHEndocrinopatiasAP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHEndocrinopatiasAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHGotaAP_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHGotaAP_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHGotaAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHAtipiaAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHAtipiaAP_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHAtipiaAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHTuberculosisAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHTuberculosisAP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHTuberculosisAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHAlergiaAp_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHAlergiaAp_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHAlergiaAp_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHPsicopatia_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHPsicopatia_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHPsicopatia_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHDislipedia_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHDislipedia_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHDislipedia_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHCoronario_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHCoronario_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHCoronario_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHDiabet_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHDiabet_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHDiabet_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHHipArt_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHHipArt_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHHipArt_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBColagenopatias_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBColagenopatias_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBColagenopatias_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBFiebresProlongAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBFiebresProlongAP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBFiebresProlongAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBEnfNeurologicas_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBEnfNeurologicas_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBEnfNeurologicas_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBHepatis_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBHepatis_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBHepatis_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBColecistopatia_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBColecistopatia_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBColecistopatia_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBUlcGastr_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBUlcGastr_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBUlcGastr_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBEts_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBEts_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBEts_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBHemopatiasAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBHemopatiasAP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBHemopatiasAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBPatia_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBPatia_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBPatia_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBNefrologiasAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBNefrologiasAP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBNefrologiasAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBendocrinopatias_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBendocrinopatias_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBendocrinopatias_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBAfccBroncPulm_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBAfccBroncPulm_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAfccBroncPulm_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBGota_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBGota_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBGota_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBAtipia_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBAtipia_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtipia_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBTuberculosisAP_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBTuberculosisAP_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBTuberculosisAP_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBAlergias_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBAlergias_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAlergias_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBPsicopatia_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBPsicopatia_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBPsicopatia_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBAsmaBronquial_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBAsmaBronquial_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAsmaBronquial_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBDislipidemia_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBDislipidemia_actionAdapter(
            CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDislipidemia_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBDiabet_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBDiabet_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDiabet_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBHipArt_actionAdapter implements ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBHipArt_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBHipArt_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JBCoronario_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JBCoronario_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCoronario_actionPerformed(e);
    }
}

class CAntecedentesPersonales_JCHAsmaBronq_actionAdapter implements
        ActionListener {

    private CAntecedentesPersonales adaptee;

    CAntecedentesPersonales_JCHAsmaBronq_actionAdapter(CAntecedentesPersonales adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHAsmaBronq_actionPerformed(e);
    }
}
