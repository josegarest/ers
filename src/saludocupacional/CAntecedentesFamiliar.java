package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class CAntecedentesFamiliar extends JInternalFrame {

    Object objppalaf;
    Object obotactualizarAF;
    String cad1;
    String cad2;
    ValidarComponentes validAF = new ValidarComponentes();
    public Statement TSentenciaconsultaAP;
    public ResultSet RconsultaAP;
    public ConexionSql Cconsql = new ConexionSql();
    String numingredicAP;
    int swedicingrAP;
    int swgte;
    Object objetoantcenpersonales = new Object();
    public Object framedetantfam = new Object();
    public int swepilepsia = 1;
    public int swcardiopat = 1;
    public int swcancer = 1;
    public int swotros = 1;
    public int swhta = 1;
    public int swdiab = 1;
    int swval;
    Object frameatOBJ = new Object();
    Object frameAFOBJ = new Object();
    Object frameafOBJ = new Object();
    Object frameEnfProfOBJ = new Object();
    Object JDPIngresoobjAF = new Object();
    String nombraf = new String();
    String numhcaf = new String();
    public String nombredetalle = "";
    public static int swepilepc = 1;
    CAntecedentesFamiliar objCAF;
    //DECLARACION DE PANELES
    JTabbedPane JTBAntFam = new JTabbedPane();
    JPanel JPAntecedentesFamiliar = new JPanel();
    JPanel JPAntFam = new JPanel();
    //DECLARACION DE OBJETOS VISUALES
    JButton JBAtrasAF = new JButton();
    JButton JBCancelarAF = new JButton();
    JButton JBSgteAF = new JButton();
    JLabel JLBNumhcAF = new JLabel();
    JButton JBEpilepsia = new JButton();
    JCheckBox JCHEpilepsia = new JCheckBox();
    JTextField JTFEpilepsia = new JTextField();
    JCheckBox JCHCardiopatias = new JCheckBox();
    JTextField JTFCardiopatias = new JTextField();
    JButton JBCardiopatias = new JButton();
    JCheckBox JCHCancer = new JCheckBox();
    JTextField JTFCancer = new JTextField();
    JButton JBCancer = new JButton();
    JCheckBox JCHOtros = new JCheckBox();
    JTextField JTFOtros = new JTextField();
    JButton JBOtros = new JButton();
    JLabel JLBNombpacAF = new JLabel();
    JCheckBox JCHHta = new JCheckBox();
    JTextField JTFHta = new JTextField(); //
    JButton JBHta = new JButton();
    JCheckBox JCHDiabet = new JCheckBox();
    JTextField JTFDiab = new JTextField();
    JButton JBDiabet = new JButton();

    public CAntecedentesFamiliar(Object obotactualizarAT, String numingredicAF, int swedicingrAF, String Nombrepacaf, CHistoriaAcciTrab frameat, String varnHC, JDesktopPane JDPIngreso, CIngreso frameingreso, CHistoriaOcup framehistocup, CEnfermedadProf frameenfermedadprof, Object objppalat) {
        try {
            jbInit();
            frameAFOBJ = (CIngreso) frameingreso;
            frameatOBJ = frameat;
            frameafOBJ = framehistocup;
            frameEnfProfOBJ = frameenfermedadprof;
            JLBNombpacAF.setText(Nombrepacaf);
            JLBNumhcAF.setText(varnHC);
            JDPIngresoobjAF = JDPIngreso;
            nombraf = Nombrepacaf;
            numhcaf = varnHC;
            swgte = 0;
            swedicingrAP = swedicingrAF;
            numingredicAP = numingredicAF;
            obotactualizarAF = obotactualizarAT;
            objppalaf = objppalat;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //
    private void jbInit() throws Exception {
        //this
        this.setClosable(true);
        this.setIconifiable(true);
        this.setMaximizable(true);
        this.setResizable(true);
        this.getContentPane().setBackground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
        this.setVisible(true);
        this.getContentPane().setLayout(null);
        //DESACTIVACION
        JTFEpilepsia.setEditable(false);
        JTFEpilepsia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFEpilepsia.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFEpilepsia.setToolTipText("");
        JCHEpilepsia.setBackground(SystemColor.textHighlight);
        JCHEpilepsia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHEpilepsia.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHEpilepsia.setToolTipText("");
        JCHEpilepsia.setText("EPILEPSIA");
        JCHEpilepsia.setBounds(new Rectangle(306, 263, 121, 23));
        JCHEpilepsia.addActionListener(new CAntecedentesFamiliar_JCHEpilepsia_actionAdapter(this));
        // JCHDiabet.addActionListener(new     CAntecedentesPersonales_JCHDiabet_actionAdapter(this));
        JTFEpilepsia.setBounds(new Rectangle(447, 264, 92, 22));
        JTFEpilepsia.addActionListener(new CAntecedentesFamiliar_JTFEpilepsia_actionAdapter(this));
        ////INICIALIZACION DE LOS PANELES
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
        JPAntFam.setToolTipText("");
        JPAntFam.setLayout(null);
        //CARACTERISTICAS DE LOS COMPONENTES VISUALES
        JBAtrasAF.setBounds(new Rectangle(139, 509, 112, 36));
        JBAtrasAF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JBAtrasAF.setMnemonic('R');
        JBAtrasAF.setText("Atras");
        JBAtrasAF.addActionListener(new CAntecedentesFamiliar_JBAtrasAF_actionAdapter(this));
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
        JBSgteAF.addActionListener(new CAntecedentesFamiliar_JBSgteAF_actionAdapter(this));
        //JBSgteAF.addActionListener(ne              CAntecedentesPersonales_JBSgteAP_actionAdapter(this));
        JBSgteAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN4.GIF")));
        JBSgteAF.setSelectedIcon(null);
        JLBNumhcAF.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNumhcAF.setForeground(Color.red);
        JLBNumhcAF.setToolTipText("");
        JLBNumhcAF.setText("");
        JLBNumhcAF.setBounds(new Rectangle(308, 7, 158, 24));
        JCHCardiopatias.setBackground(SystemColor.textHighlight);
        JCHCardiopatias.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHCardiopatias.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHCardiopatias.setToolTipText("");
        JCHCardiopatias.setText("CARDIOPATIAS");
        JCHCardiopatias.setBounds(new Rectangle(307, 208, 121, 23));
        JCHCardiopatias.addActionListener(new CAntecedentesFamiliar_JCHCardiopatias_actionAdapter(this));
        JTFCardiopatias.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFCardiopatias.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFCardiopatias.setToolTipText("");
        JTFCardiopatias.setEditable(false);
        JTFCardiopatias.setText("");
        JTFCardiopatias.setBounds(new Rectangle(445, 210, 92, 22));

        JCHCancer.setBackground(SystemColor.textHighlight);
        JCHCancer.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHCancer.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHCancer.setToolTipText("");
        JCHCancer.setText("CANCER");
        JCHCancer.setBounds(new Rectangle(305, 156, 121, 23));
        JCHCancer.addActionListener(new CAntecedentesFamiliar_JCHCancer_actionAdapter(this));
        JTFCancer.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFCancer.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFCancer.setToolTipText("");
        JTFCancer.setEditable(false);
        JTFCancer.setBounds(new Rectangle(445, 159, 92, 22));

        JCHOtros.setBackground(SystemColor.textHighlight);
        JCHOtros.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHOtros.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHOtros.setToolTipText("");
        JCHOtros.setText("OTROS");
        JCHOtros.setBounds(new Rectangle(306, 321, 121, 23));
        JCHOtros.addActionListener(new CAntecedentesFamiliar_JCHOtros_actionAdapter(this));
        JTFOtros.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFOtros.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFOtros.setToolTipText("");
        JTFOtros.setEditable(false);
        JTFOtros.setText("");
        JTFOtros.setBounds(new Rectangle(446, 322, 92, 22));
        JLBNombpacAF.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNombpacAF.setForeground(Color.red);
        JLBNombpacAF.setToolTipText("");
        JLBNombpacAF.setText("");
        JLBNombpacAF.setBounds(new Rectangle(4, 7, 397, 24));
        //JBEpilepsia
        JBEpilepsia.setEnabled(false);
        JBEpilepsia.setBounds(new Rectangle(555, 258, 57, 29));
        JBEpilepsia.setActionCommand("JBEpilepsia");
        JBEpilepsia.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBEpilepsia.setSelectedIcon(null);
        JBEpilepsia.addActionListener(new CAntecedentesFamiliar_JBEpilepsia_actionAdapter(this));
        //JBCardiopatias
        JBCardiopatias.setEnabled(false);
        JBCardiopatias.setBounds(new Rectangle(552, 208, 57, 29));
        JBCardiopatias.setActionCommand("JBCardiopatias");
        JBCardiopatias.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBCardiopatias.setSelectedIcon(null);
        JBCardiopatias.addActionListener(new CAntecedentesFamiliar_JBCardiopatias_actionAdapter(this));
        //JBCancer
        JBCancer.setEnabled(false);
        JBCancer.setBounds(new Rectangle(552, 151, 57, 29));
        JBCancer.setActionCommand("JBCancer");
        JBCancer.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBCancer.setToolTipText("");
        JBCancer.setSelectedIcon(null);
        JBCancer.addActionListener(new CAntecedentesFamiliar_JBCancer_actionAdapter(this));
        //JBOtros
        JBOtros.setBounds(new Rectangle(556, 317, 57, 29));
        JBOtros.setEnabled(false);
        JBOtros.setToolTipText("");
        JBOtros.setActionCommand("JBOtros");
        JBOtros.addActionListener(new CAntecedentesFamiliar_JBOtros_actionAdapter(this));
        JBOtros.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JCHHta.setBackground(SystemColor.textHighlight);
        JCHHta.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHHta.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHHta.setToolTipText("");
        JCHHta.setText("HIPERTENSION");
        JCHHta.setBounds(new Rectangle(304, 46, 121, 23));
        JCHHta.addActionListener(new CAntecedentesFamiliar_JCHHta_actionAdapter(this));
        JTFHta.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFHta.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFHta.setToolTipText("");
        JTFHta.setEditable(true);
        JTFHta.setBounds(new Rectangle(442, 50, 92, 22));
        JBHta.setBounds(new Rectangle(549, 49, 57, 29));
        JBHta.setEnabled(false);
        JBHta.setActionCommand("JBHTA");
        JBHta.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBHta.addActionListener(new CAntecedentesFamiliar_JBHta_actionAdapter(this));
        JCHDiabet.setBackground(SystemColor.textHighlight);
        JCHDiabet.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHDiabet.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHDiabet.setToolTipText("");
        JCHDiabet.setActionCommand("DIABETES");
        JCHDiabet.setText("DIABETES");
        JCHDiabet.setBounds(new Rectangle(305, 104, 121, 23));
        JCHDiabet.addActionListener(new CAntecedentesFamiliar_JCHDiabet_actionAdapter(this));
        JTFDiab.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFDiab.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFDiab.setToolTipText("");
        JTFDiab.setEditable(true);
        JTFDiab.setBounds(new Rectangle(445, 105, 92, 22));
        JBDiabet.setBounds(new Rectangle(552, 103, 57, 29));
        JBDiabet.setEnabled(false);
        JBDiabet.setActionCommand("JBDiabet");
        JBDiabet.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_CLICK.GIF")));
        JBDiabet.addActionListener(new CAntecedentesFamiliar_JBDiabet_actionAdapter(this));
        this.getContentPane().add(JPAntecedentesFamiliar);
        //Adicionamos al JPAntecedentesFamiliar
        JPAntecedentesFamiliar.add(JBAtrasAF);
        JPAntecedentesFamiliar.add(JBCancelarAF);
        JPAntecedentesFamiliar.add(JBSgteAF); //JPAntecedentesFamiliar.add(JLBnhcAP);
        //JPAntecedentesFamiliar.add(JLBNumhcAP);
        JPAntecedentesFamiliar.add(JTBAntFam);
        JPAntecedentesFamiliar.add(JLBNumhcAF);
        JPAntecedentesFamiliar.add(JLBNombpacAF);
        JPAntFam.add(JTFCancer);
        JPAntFam.add(JTFHta);
        JPAntFam.add(JCHHta);
        JPAntFam.add(JBHta);
        JPAntFam.add(JCHDiabet);
        JPAntFam.add(JTFDiab);
        JPAntFam.add(JBDiabet);
        JPAntFam.add(JCHCancer);
        JPAntFam.add(JBCancer);
        JPAntFam.add(JBCardiopatias);
        JPAntFam.add(JTFCardiopatias);
        JPAntFam.add(JCHCardiopatias);
        JPAntFam.add(JCHEpilepsia);
        JPAntFam.add(JTFEpilepsia);
        JPAntFam.add(JBEpilepsia);
        JPAntFam.add(JBOtros);
        JPAntFam.add(JTFOtros);
        JPAntFam.add(JCHOtros);
        JTBAntFam.add(JPAntFam, "ANTECEDENTES FAMILIARES");
    }

    public void inicioventanaAP(CAntecedentesFamiliar frameAP) {
        objCAF = frameAP;
    }

//
    public void JBEpilepsia_actionPerformed(ActionEvent e) {
        nombredetalle = "EPILEPSIA";
        abrirformulariodetalles(JTFEpilepsia);
        swepilepsia = 1;
    }

    public void JBAtrasAF_actionPerformed(ActionEvent e) {
        CHistoriaAcciTrab frameAFAtras;
        frameAFAtras = (CHistoriaAcciTrab) frameatOBJ;
        frameAFAtras.setVisible(true);
        objCAF.setVisible(false);
    }

    public void JBSgteAF_actionPerformed(ActionEvent e) {
        validarnulosAP();
    }

    /**
     * validarnulosAP
     */
    public void validarnulosAP() {
        swval = 0;
        CIngreso frameingreso;
        CHistoriaOcup framehistocup;
        CEnfermedadProf frameenfermedadprof;
        CHistoriaAcciTrab frameaccitrabajo;
        CAntecedentesFamiliar frameaf;
        frameingreso = (CIngreso) frameAFOBJ;
        frameaf = (CAntecedentesFamiliar) objCAF;
        frameaf.setVisible(false);
        JDesktopPane JDPIngresoEP = new JDesktopPane();
        JDPIngresoEP = (JDesktopPane) JDPIngresoobjAF;
        framehistocup = (CHistoriaOcup) frameafOBJ;
        frameenfermedadprof = (CEnfermedadProf) frameEnfProfOBJ;
        frameaccitrabajo = (CHistoriaAcciTrab) frameatOBJ;
        if (swgte == 0) {
            CAntecedentesPersonales frameAP = new CAntecedentesPersonales(obotactualizarAF, numingredicAP, swedicingrAP, nombraf, frameaf, numhcaf, JDPIngresoEP, frameingreso, framehistocup, frameenfermedadprof, frameaccitrabajo, objppalaf);
            frameAP.setBounds(0, 2, 1010, 600);
            frameAP.setTitle("ANTECEDENTES PERSONALES");
            JDPIngresoEP.add(frameAP, new Integer(1));
            frameAP.setLocation(5, 55);
            frameAP.show();
            frameAP.setVisible(true);
            frameAP.inicioventanaAP(frameAP);
            swgte = 1;
            objetoantcenpersonales = frameAP;
            if (swedicingrAP == 1) {
                String cadsqledicAP;
                Connection con2 = Cconsql.getConnection();
                cadsqledicAP = "SELECT ingreso.id_ingreso, antecedentespersonal_pacientes.diabetes_consap, antecedentespersonal_pacientes.obsdiabetes_consap, antecedentespersonal_pacientes.hiparterial_consap, antecedentespersonal_pacientes.obshiparterial_consap, antecedentespersonal_pacientes.coronario_consap, antecedentespersonal_pacientes.obscoronario_consap, antecedentespersonal_pacientes.dislipidemia_consap, antecedentespersonal_pacientes.obsdislipidemia_consap, antecedentespersonal_pacientes.asmabronq_consap, antecedentespersonal_pacientes.obsasmabronq_consap, antecedentespersonal_pacientes.psicopatia_consap, antecedentespersonal_pacientes.obspsicopatia_consap, antecedentespersonal_pacientes.alergia_consap, antecedentespersonal_pacientes.obsalergia_consap, antecedentespersonal_pacientes.tuberculosis_consap, antecedentespersonal_pacientes.obstuberculosis_consap, antecedentespersonal_pacientes.atipia_consap, antecedentespersonal_pacientes.obsatipia_consap, antecedentespersonal_pacientes.gota_consap, antecedentespersonal_pacientes.obsgota_consap, antecedentespersonal_pacientes.afeccbroncpulmon_consap, antecedentespersonal_pacientes.obsafeccbroncpulmon_consap, antecedentespersonal_pacientes.endocrinopatia_consap, antecedentespersonal_pacientes.obsendocrinopatia_consap, antecedentespersonal_pacientes.nefrologia_consap, antecedentespersonal_pacientes.obsnefrologia_consap, antecedentespersonal_pacientes.riopatia_consap, antecedentespersonal_pacientes.obsriopatia_consap, antecedentespersonal_pacientes.hemopatias_consap, antecedentespersonal_pacientes.obshemopatias_consap, antecedentespersonal_pacientes.ets_consap, antecedentespersonal_pacientes.obsets_consap, antecedentespersonal_pacientes.ulcgastroduod_consap, antecedentespersonal_pacientes.obsulcgastroduod_consap, antecedentespersonal_pacientes.colecistopatia_consap, antecedentespersonal_pacientes.obscolecistopatia_consap, antecedentespersonal_pacientes.hepatitis_consap, antecedentespersonal_pacientes.obshepatitis_consap, antecedentespersonal_pacientes.enfneurologicas_consap, antecedentespersonal_pacientes.obsenfneurologicas_consap, antecedentespersonal_pacientes.fiebresprolong_consap, antecedentespersonal_pacientes.obsfiebresprolong_consap, antecedentespersonal_pacientes.colageno_consap, antecedentespersonal_pacientes.obscolageno_consap, antecedentespersonal_pacientes.traumatismo_consap, antecedentespersonal_pacientes.obstraumatismo_consap, antecedentespersonal_pacientes.otros_consap, antecedentespersonal_pacientes.obsotros_consap "
                        + "FROM ingreso "
                        + "INNER JOIN antecedentespersonal_pacientes ON ingreso.id_ingreso = antecedentespersonal_pacientes.idingreso_consap WHERE ingreso.id_ingreso=" + numingredicAP;
                try {
                    TSentenciaconsultaAP = con2.createStatement();
                    RconsultaAP = TSentenciaconsultaAP.executeQuery(cadsqledicAP);
                    while (RconsultaAP.next()) {
                        frameAP.JCHDiabet.setSelected(RconsultaAP.getBoolean(2));
                        frameAP.JTFDiabet.setText(RconsultaAP.getString(3));
                        frameAP.JCHHipArt.setSelected(RconsultaAP.getBoolean(4));
                        frameAP.JTFHiperArt.setText(RconsultaAP.getString(5));
                        frameAP.JCHCoronario.setSelected(RconsultaAP.getBoolean(6));
                        frameAP.JFTCoronario.setText(RconsultaAP.getString(7));
                        frameAP.JCHDislipedia.setSelected(RconsultaAP.getBoolean(8));
                        frameAP.JTFDislipidemia.setText(RconsultaAP.getString(9));
                        frameAP.JCHAsmaBronq.setSelected(RconsultaAP.getBoolean(10));
                        frameAP.JTFAsmaBronquial.setText(RconsultaAP.getString(11));
                        frameAP.JCHPsicopatia.setSelected(RconsultaAP.getBoolean(12));
                        frameAP.JTFPsicopatia.setText(RconsultaAP.getString(13));
                        frameAP.JCHAlergiaAp.setSelected(RconsultaAP.getBoolean(14));
                        //frameAP.JTFAlergiaAP.setText(RconsultaAP.getString(15));
                        //frameAP.JCHAlergiaAp.setSelected(RconsultaAP.getBoolean(16));
                        frameAP.JTFAlergiaAP.setText(RconsultaAP.getString(15));
                        frameAP.JCHTuberculosisAP.setSelected(RconsultaAP.getBoolean(16));
                        frameAP.JTFTuberculosisAP.setText(RconsultaAP.getString(17));
                        frameAP.JCHAtipiaAP.setSelected(RconsultaAP.getBoolean(18));
                        frameAP.JTFAtipiaAP.setText(RconsultaAP.getString(19));
                        frameAP.JCHGotaAP.setSelected(RconsultaAP.getBoolean(20));
                        frameAP.JTFGotaAP.setText(RconsultaAP.getString(21));
                        frameAP.JCHAffBroncoAP.setSelected(RconsultaAP.getBoolean(22));
                        frameAP.JTFAfccbroncpulm.setText(RconsultaAP.getString(23));
                        frameAP.JCHEndocrinopatiasAP.setSelected(RconsultaAP.getBoolean(24));
                        frameAP.JTFEndocrinopatiasAP.setText(RconsultaAP.getString(25));
                        frameAP.JCHNefrologiasAP.setSelected(RconsultaAP.getBoolean(26));
                        frameAP.JTNefrologiasAP.setText(RconsultaAP.getString(27));
                        frameAP.JCHPatiasAP.setSelected(RconsultaAP.getBoolean(28));
                        frameAP.JTFPatiasAP.setText(RconsultaAP.getString(29));
                        frameAP.JCHHemopatiasAP.setSelected(RconsultaAP.getBoolean(30));
                        frameAP.JTFHemopatias.setText(RconsultaAP.getString(31));
                        frameAP.JCHEtsAP.setSelected(RconsultaAP.getBoolean(32));
                        frameAP.JTFETSap.setText(RconsultaAP.getString(33));
                        frameAP.JCHUlceraGastr.setSelected(RconsultaAP.getBoolean(34));
                        frameAP.JTFUlcGastrDuodAP.setText(RconsultaAP.getString(35));
                        frameAP.JCHColagenopatias.setSelected(RconsultaAP.getBoolean(36));
                        frameAP.JTFColecistopatia.setText(RconsultaAP.getString(37));
                        frameAP.JCHHepatitis.setSelected(RconsultaAP.getBoolean(38));
                        frameAP.JTFHepatitis.setText(RconsultaAP.getString(39));
                        frameAP.JCHEnfNeurologicaEP.setSelected(RconsultaAP.getBoolean(40));
                        frameAP.JTFEnfNeurologAP.setText(RconsultaAP.getString(41));
                        frameAP.JCHFiebresProAP.setSelected(RconsultaAP.getBoolean(42));
                        frameAP.JFTFiebresProlongAP.setText(RconsultaAP.getString(43));
                        frameAP.JCHColagenopatias.setSelected(RconsultaAP.getBoolean(44));
                        frameAP.JFTColagenopatias.setText(RconsultaAP.getString(45));
                        frameAP.JCHTraumatismo.setSelected(RconsultaAP.getBoolean(46));
                        frameAP.JTFTraumatismo.setText(RconsultaAP.getString(47));
                        frameAP.JCHOtros.setSelected(RconsultaAP.getBoolean(48));
                        frameAP.JTFOtros.setText(RconsultaAP.getString(49));
                        activarbotonAP(frameAP.JBDiabet);
                        activarbotonAP(frameAP.JBAfccBroncPulm);
                        activarbotonAP(frameAP.JBAlergias);
                        activarbotonAP(frameAP.JBAsmaBronquial);
                        activarbotonAP(frameAP.JBAtipia);
                        activarbotonAP(frameAP.JBColagenopatias);
                        activarbotonAP(frameAP.JBColecistopatia);
                        activarbotonAP(frameAP.JBCoronario);
                        activarbotonAP(frameAP.JBDislipidemia);
                        activarbotonAP(frameAP.JBendocrinopatias);
                        activarbotonAP(frameAP.JBEnfNeurologicas);
                        activarbotonAP(frameAP.JBEts);
                        activarbotonAP(frameAP.JBFiebresProlongAP);
                        activarbotonAP(frameAP.JBGota);
                        activarbotonAP(frameAP.JBHemopatiasAP);
                        activarbotonAP(frameAP.JBHepatis);
                        activarbotonAP(frameAP.JBHipArt);
                        activarbotonAP(frameAP.JBNefrologiasAP);
                        activarbotonAP(frameAP.JBOtros);
                        activarbotonAP(frameAP.JBPatia);
                        activarbotonAP(frameAP.JBPsicopatia);
                        activarbotonAP(frameAP.JBtraumatism);
                        activarbotonAP(frameAP.JBTuberculosisAP);
                        activarbotonAP(frameAP.JBUlcGastr);

                    }//fin del while
                }//fin del try
                catch (SQLException e1) {
                    e1.getMessage();
                    cad2 = "NO SE PUDO EJECUTAR LA CONSULTA";
                    cad1 = "PROBLEMAS CON LOS DATOS DE ANTECEDENTES PERSONALES EN EDICION";
                    validAF.mensajeconfirmacion(cad1, cad2);
                }//cierra el catch
                Cconsql.CerrarConexion();
            }//fin del if swedicingrAP

        }//fin del if sgte
        else {
            CAntecedentesPersonales frameAP;
            frameAP = (CAntecedentesPersonales) objetoantcenpersonales;
            // ObjectCingreso.setVisible(false);
            frameAP.setVisible(true);

        }

    }

    public void JCHEpilepsia_actionPerformed(ActionEvent e) {
        controlbotones(JCHEpilepsia, JTFEpilepsia, JBEpilepsia);
    }

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

    public void JCHCardiopatias_actionPerformed(ActionEvent e) {
        controlbotones(JCHCardiopatias, JTFCardiopatias, JBCardiopatias);
    }

    public void JCHCancer_actionPerformed(ActionEvent e) {
        controlbotones(JCHCancer, JTFCancer, JBCancer);
    }

    public void JCHOtros_actionPerformed(ActionEvent e) {
        controlbotones(JCHOtros, JTFOtros, JBOtros);
    }

    /**
     * abrirformulariodetalles
     */
    public void abrirformulariodetalles(JTextField JFTabrirform) {
        JDesktopPane JDPIngresoAF = new JDesktopPane();
        JDPIngresoAF = (JDesktopPane) JDPIngresoobjAF;
        objCAF.setVisible(false);
        CDetallesAP framedetallaf = new CDetallesAP(objCAF);
        framedetantfam = framedetallaf;
        procesoeditor(JFTabrirform);
        framedetallaf.setBounds(0, 2, 550, 600);
        framedetallaf.setTitle("DETALLES ANTECEDENTES FAMILIARES");
        JDPIngresoAF.add(framedetallaf, new Integer(1));
        framedetallaf.setLocation(234, 55);
        framedetallaf.show();
        framedetallaf.setVisible(true);
        framedetallaf.JEDPdetAP.requestFocus();
    }

    public void JBCardiopatias_actionPerformed(ActionEvent e) {
        nombredetalle = "CARDIOPATIAS";
        abrirformulariodetalles(JTFCardiopatias);
        swcardiopat = 1;
    }

    public void JBCancer_actionPerformed(ActionEvent e) {
        nombredetalle = "CANCER";
        abrirformulariodetalles(JTFCancer);
        swcancer = 1;
    }

    public void JBOtros_actionPerformed(ActionEvent e) {
        nombredetalle = "OTROS";
        abrirformulariodetalles(JTFOtros);
        swotros = 1;
    }

    /**
     * procesoeditor
     */
    public void procesoeditor(JTextField JFTvar) {
        CDetallesAP CDetAP;
        CDetAP = (CDetallesAP) framedetantfam;
        CDetAP.JEDPdetAP.setText(JFTvar.getText());
    }

    public void JTFEpilepsia_actionPerformed(ActionEvent e) {

    }

    public void JBHta_actionPerformed(ActionEvent e) {
        nombredetalle = "HIPERTENSION";
        abrirformulariodetalles(JTFHta);
        swhta = 1;
    }

    public void JBDiabet_actionPerformed(ActionEvent e) {
        nombredetalle = "DIABETES";
        abrirformulariodetalles(JTFDiab);
        swdiab = 1;
    }

    public void JCHHta_actionPerformed(ActionEvent e) {
        controlbotones(JCHHta, JTFHta, JBHta);
    }

    public void JCHDiabet_actionPerformed(ActionEvent e) {
        controlbotones(JCHDiabet, JTFDiab, JBDiabet);
    }

    /**
     * activarbotonAP
     */
    public void activarbotonAP(JButton JVvar) {
        JVvar.setEnabled(true);
    }

    public CAntecedentesFamiliar() {

    }

}//FIN CLASE

class CAntecedentesFamiliar_JCHDiabet_actionAdapter implements ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JCHDiabet_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHDiabet_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JCHHta_actionAdapter implements ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JCHHta_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHHta_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JBDiabet_actionAdapter implements ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JBDiabet_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBDiabet_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JBHta_actionAdapter implements ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JBHta_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBHta_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JTFEpilepsia_actionAdapter implements
        ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JTFEpilepsia_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JTFEpilepsia_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JBOtros_actionAdapter implements ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JBOtros_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBOtros_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JBCancer_actionAdapter implements ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JBCancer_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCancer_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JBCardiopatias_actionAdapter implements
        ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JBCardiopatias_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBCardiopatias_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JCHOtros_actionAdapter implements ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JCHOtros_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHOtros_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JCHCancer_actionAdapter implements ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JCHCancer_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHCancer_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JCHCardiopatias_actionAdapter implements
        ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JCHCardiopatias_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHCardiopatias_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JCHEpilepsia_actionAdapter implements
        ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JCHEpilepsia_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHEpilepsia_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JBSgteAF_actionAdapter implements ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JBSgteAF_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSgteAF_actionPerformed(e);
    }
}

class CAntecedentesFamiliar_JBAtrasAF_actionAdapter implements ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JBAtrasAF_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasAF_actionPerformed(e);
    }
}

//CLASESE ANEXAS
class CAntecedentesFamiliar_JBEpilepsia_actionAdapter implements ActionListener {

    private CAntecedentesFamiliar adaptee;

    CAntecedentesFamiliar_JBEpilepsia_actionAdapter(CAntecedentesFamiliar adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBEpilepsia_actionPerformed(e);
    }
}
