package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Font;

public class CAGineco extends JInternalFrame {

    Object objppalgo;
    Object obotactualizarGO;
    ValidarComponentes validIZ = new ValidarComponentes();
    String cad1;
    String cad2;
    public Statement TSentenciaconsultaIZ;
    public ResultSet RconsultaIZ;
    public ConexionSql Cconsql = new ConexionSql();
    String numingredicIZ;
    int swedicingrIZ;
    Object objetoinmune = new Object();
    int swgte;
    int swval;
    Object JDPIngresoobjAG = new Object();
    String nombrag = new String();
    String numhcag = new String();
    Object frameGOOBJ = new Object();
    Object frameapOBJ = new Object();
    Object framehoOBJ = new Object();
    Object frameEnfProfOBJ = new Object();
    Object frameAcciTrabajoOBJ = new Object();
    Object frameAntecFamOBJ = new Object();
    Object frameAntecPersonalOBJ = new Object();
    public String nombredetalle = "";
    ValidarComponentes valmenarq = new ValidarComponentes();
    //public static int swepilepc=1;
    CAGineco objCAG;
    //DECLARACION DE PANELES
    JTabbedPane JTBAntFam = new JTabbedPane();
    JPanel JPAntecedentesFamiliar = new JPanel();
    JPanel JPAntFam = new JPanel();
    //DECLARACION DE OBJETOS VISUALES
    JButton JBAtrasAF = new JButton();
    JButton JBCancelarAF = new JButton();
    JButton JBSgteAF = new JButton();
    JLabel JLBNumhcAG = new JLabel();
    JLabel JLBFechMen = new JLabel();
    JLabel JLBCiclos = new JLabel();
    JTextField JTFCiclos = new JTextField();
    JLabel JLBFechUltMestr = new JLabel();
    JFormattedTextField JFTFechUltMestr = new JFormattedTextField();
    JCheckBox JCHGravid = new JCheckBox();
    JCheckBox JCHCesarea = new JCheckBox();
    JLabel JLPBParidad = new JLabel();
    JTextField JTFParidad = new JTextField();
    JCheckBox JCHAborto = new JCheckBox();
    JCheckBox JCHPlanifica = new JCheckBox();
    JCheckBox jCheckBox1 = new JCheckBox();
    JLabel JLBCual = new JLabel();
    JLabel JLBFechCit = new JLabel();
    JFormattedTextField JFTFechUltCit = new JFormattedTextField();
    JLabel JLBResultado = new JLabel();
    JLabel JLBNombrAG = new JLabel(); //

    JComboBox JCMenarquia = new JComboBox();
    JComboBox JCPlanifica = new JComboBox();
    JComboBox JCResultado = new JComboBox();
    JFormattedTextField JFTTiempoPlan = new JFormattedTextField();
    JLabel JLBTiempo = new JLabel();

    public CAGineco(Object obotactualizarAP, String numingredicGO, int swedicingrGO, String Nombrepacag, CAntecedentesPersonales frameap, String varnHC, JDesktopPane JDPIngreso, CIngreso frameingreso, CHistoriaOcup framehistocup, CEnfermedadProf frameenfermedadprof, CHistoriaAcciTrab frameaccitrabajo, CAntecedentesFamiliar frameantecendnetesfam, Object objppalap) {
        try {
            jbInit();
            frameGOOBJ = frameingreso;
            frameapOBJ = frameap;
            framehoOBJ = framehistocup;
            frameEnfProfOBJ = frameenfermedadprof;
            frameAcciTrabajoOBJ = frameaccitrabajo;
            frameAntecFamOBJ = frameantecendnetesfam;
            //frameAntecPersonalOBJ=frameantecpersonal;
            JLBNombrAG.setText(Nombrepacag);
            JLBNumhcAG.setText(varnHC);
            JDPIngresoobjAG = JDPIngreso;
            nombrag = Nombrepacag;
            numhcag = varnHC;
            llenarmenarquia();
            llenarplanific();
            llenarresultgineco();
            swgte = 0;
            swedicingrIZ = swedicingrGO;
            numingredicIZ = numingredicGO;
            obotactualizarGO = obotactualizarAP;
            objppalgo = objppalap;
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
        JBAtrasAF.addActionListener(new CAGineco_JBAtrasAF_actionAdapter(this));
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
        JBSgteAF.addActionListener(new CAGineco_JBSgteAF_actionAdapter(this));
        //JBSgteAF.addActionListener(ne              CAntecedentesPersonales_JBSgteAP_actionAdapter(this));
        JBSgteAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN4.GIF")));
        JBSgteAF.setSelectedIcon(null);
        JLBNumhcAG.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNumhcAG.setForeground(Color.red);
        JLBNumhcAG.setToolTipText("");
        JLBNumhcAG.setText("");
        JLBNumhcAG.setBounds(new Rectangle(547, 27, 158, 24));
        JLBFechMen.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBFechMen.setForeground(Color.red);
        JLBFechMen.setToolTipText("");
        JLBFechMen.setText("MENARQUIA");
        JLBFechMen.setBounds(new Rectangle(14, 108, 73, 20));
        JLBCiclos.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBCiclos.setForeground(Color.red);
        JLBCiclos.setToolTipText("");
        JLBCiclos.setText("CICLOS");
        JLBCiclos.setBounds(new Rectangle(135, 107, 48, 20));
        JTFCiclos.setBackground(Color.white);
        JTFCiclos.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFCiclos.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFCiclos.setToolTipText("");
        JTFCiclos.setText("NORMAL");
        JTFCiclos.setBounds(new Rectangle(114, 133, 92, 22));
        JLBFechUltMestr.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBFechUltMestr.setForeground(Color.red);
        JLBFechUltMestr.setToolTipText("");
        JLBFechUltMestr.setText("FECHA ULTIMA REGLA");
        JLBFechUltMestr.setBounds(new Rectangle(214, 106, 179, 20));
        JFTFechUltMestr.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTFechUltMestr.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTFechUltMestr.setToolTipText("");
        JFTFechUltMestr.setBounds(new Rectangle(217, 133, 121, 21));
        JCHGravid.setBackground(SystemColor.textHighlight);
        JCHGravid.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHGravid.setForeground(Color.red);
        JCHGravid.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHGravid.setToolTipText("");
        JCHGravid.setText("GRAVIDEZ");
        JCHGravid.setBounds(new Rectangle(353, 133, 84, 23));
        JCHCesarea.setBackground(SystemColor.textHighlight);
        JCHCesarea.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHCesarea.setForeground(Color.red);
        JCHCesarea.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHCesarea.setToolTipText("");
        JCHCesarea.setText("CESAREA");
        JCHCesarea.setBounds(new Rectangle(559, 132, 84, 23));
        JLPBParidad.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLPBParidad.setForeground(Color.red);
        JLPBParidad.setToolTipText("");
        JLPBParidad.setText("PARIDAD");
        JLPBParidad.setBounds(new Rectangle(473, 109, 57, 20));
        JTFParidad.setBackground(Color.white);
        JTFParidad.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFParidad.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFParidad.setToolTipText("");
        JTFParidad.setBounds(new Rectangle(454, 135, 92, 22));
        JCHAborto.setBackground(SystemColor.textHighlight);
        JCHAborto.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHAborto.setForeground(Color.red);
        JCHAborto.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHAborto.setToolTipText("");
        JCHAborto.setText("ABORTO");
        JCHAborto.setBounds(new Rectangle(658, 132, 84, 23));
        JCHPlanifica.setBackground(SystemColor.textHighlight);
        JCHPlanifica.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHPlanifica.setForeground(Color.red);
        JCHPlanifica.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHPlanifica.setToolTipText("");
        JCHPlanifica.setText("PLANIFICA");
        JCHPlanifica.setBounds(new Rectangle(755, 132, 84, 23));
        JCHPlanifica.addActionListener(new CAGineco_JCHPlanifica_actionAdapter(this));
        jCheckBox1.setText("jCheckBox1");
        jCheckBox1.setBounds(new Rectangle(537, 134, 84, 23));
        JLBCual.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBCual.setForeground(Color.red);
        JLBCual.setToolTipText("");
        JLBCual.setText("CUAL");
        JLBCual.setBounds(new Rectangle(850, 105, 57, 20));
        JLBFechCit.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBFechCit.setForeground(Color.red);
        JLBFechCit.setToolTipText("");
        JLBFechCit.setText("FECHA ULT CITOLOGIA");
        JLBFechCit.setBounds(new Rectangle(12, 226, 141, 20));
        JFTFechUltCit.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTFechUltCit.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTFechUltCit.setToolTipText("");
        JFTFechUltCit.setBounds(new Rectangle(14, 265, 124, 21));
        JLBResultado.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBResultado.setForeground(Color.red);
        JLBResultado.setToolTipText("");
        JLBResultado.setText("RESULTADO");
        JLBResultado.setBounds(new Rectangle(214, 226, 72, 20));
        JLBNombrAG.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNombrAG.setForeground(Color.red);
        JLBNombrAG.setToolTipText("");
        JLBNombrAG.setText("");
        JLBNombrAG.setBounds(new Rectangle(6, 18, 430, 24));
        JCMenarquia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCMenarquia.setBorder(BorderFactory.createRaisedBevelBorder());
        JCMenarquia.setBounds(new Rectangle(15, 130, 89, 24));
        JCPlanifica.setEnabled(false);
        JCPlanifica.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCPlanifica.setBorder(BorderFactory.createRaisedBevelBorder());
        JCPlanifica.setBounds(new Rectangle(850, 133, 117, 24));
        JCResultado.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCResultado.setBorder(BorderFactory.createRaisedBevelBorder());
        JCResultado.setBounds(new Rectangle(217, 260, 142, 24));
        JFTTiempoPlan.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTTiempoPlan.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTTiempoPlan.setToolTipText("");
        JFTTiempoPlan.setBounds(new Rectangle(848, 194, 121, 21));
        JLBTiempo.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBTiempo.setForeground(Color.red);
        JLBTiempo.setToolTipText("");
        JLBTiempo.setText("TIEMPO");
        JLBTiempo.setBounds(new Rectangle(850, 167, 57, 20));
        this.getContentPane().add(JPAntecedentesFamiliar);
        //Adicionamos al JPAntecedentesFamiliar
        JPAntecedentesFamiliar.add(JBAtrasAF);
        JPAntecedentesFamiliar.add(JBCancelarAF);
        JPAntecedentesFamiliar.add(JBSgteAF); //JPAntecedentesFamiliar.add(JLBnhcAP);
        //JPAntecedentesFamiliar.add(JLBNumhcAP);
        JPAntecedentesFamiliar.add(JTBAntFam);
        JPAntecedentesFamiliar.add(JLBNombrAG);
        JPAntecedentesFamiliar.add(JLBNumhcAG);
        JTBAntFam.add(JPAntFam, "ANTECEDENTES GINECOOBSTETRICIOS");
        JPAntFam.add(JLBCiclos);
        JPAntFam.add(JLBFechUltMestr);
        JPAntFam.add(JCHGravid);
        JPAntFam.add(JTFParidad);
        JPAntFam.add(JCHCesarea);
        JPAntFam.add(JCHAborto);
        JPAntFam.add(JCHPlanifica);
        JPAntFam.add(JTFCiclos);
        JPAntFam.add(JLPBParidad);
        JPAntFam.add(JLBResultado);
        JPAntFam.add(JLBFechMen);
        JPAntFam.add(JLBFechCit);
        JPAntFam.add(JFTFechUltCit);
        JPAntFam.add(JCPlanifica);
        JPAntFam.add(JCMenarquia);
        JPAntFam.add(JCResultado);
        JPAntFam.add(JFTFechUltMestr);
        JPAntFam.add(JFTTiempoPlan);
        JPAntFam.add(JLBTiempo);
        JPAntFam.add(JLBCual);
    }

    public void inicioventanaAP(CAGineco frameAG) {
        objCAG = frameAG;
    }

    public void JBAtrasAF_actionPerformed(ActionEvent e) {
        CAntecedentesPersonales frameAPAtras;
        frameAPAtras = (CAntecedentesPersonales) frameapOBJ;
        frameAPAtras.setVisible(true);
        objCAG.setVisible(false);

    }

    public void JBSgteAF_actionPerformed(ActionEvent e) {
        validarnulosIN();
    }

    /**
     * validarnulosIN
     */
    public void validarnulosIN() {
        swval = 0;
        CAGineco frameag;
        CIngreso frameingreso;
        CHistoriaOcup framehistocup;
        CEnfermedadProf frameenfermedadprof;
        CHistoriaAcciTrab frameaccitrabajo;
        CAntecedentesFamiliar frameantecendnetesfam;
        CAntecedentesPersonales frameantecpersonal;
        frameingreso = (CIngreso) frameGOOBJ;
        frameag = (CAGineco) objCAG;
        frameag.setVisible(false);
        JDesktopPane JDPIngresoEP = new JDesktopPane();
        JDPIngresoEP = (JDesktopPane) JDPIngresoobjAG;
        framehistocup = (CHistoriaOcup) framehoOBJ;
        frameenfermedadprof = (CEnfermedadProf) frameEnfProfOBJ;
        frameaccitrabajo = (CHistoriaAcciTrab) frameAcciTrabajoOBJ;
        frameantecendnetesfam = (CAntecedentesFamiliar) frameAntecFamOBJ;
        frameantecpersonal = (CAntecedentesPersonales) frameapOBJ;
        if (swgte == 0) {
            CInmuniz frameIN = new CInmuniz(obotactualizarGO, numingredicIZ, swedicingrIZ, nombrag, frameag, numhcag, JDPIngresoEP, frameingreso, framehistocup, frameenfermedadprof, frameaccitrabajo, frameantecendnetesfam, frameantecpersonal, objppalgo);
            frameIN.setBounds(0, 2, 1010, 600);
            frameIN.setTitle("INMUNIZACIONES");
            JDPIngresoEP.add(frameIN, new Integer(1));
            frameIN.setLocation(5, 55);
            frameIN.show();
            frameIN.setVisible(true);
            frameIN.inicioventanaIN(frameIN);
            swgte = 1;
            objetoinmune = frameIN;
            if (swedicingrIZ == 1) {
                String cadsqledicIZ;
                Connection con2 = Cconsql.getConnection();
                cadsqledicIZ = "SELECT ingreso.id_ingreso, inmunizaciones.tetano_inmuniz, inmunizaciones.fechatet_inmuniz, inmunizaciones.fiebreamarilla_inmuniz, inmunizaciones.fechafiebre_inmuniz, inmunizaciones.hepatitis_inmuniz, inmunizaciones.fechahep_inmuniz, inmunizaciones.otras_inmuniz, inmunizaciones.fecha_inmuniz, inmunizaciones.cualotras_inmuniz "
                        + " FROM ingreso INNER JOIN inmunizaciones ON ingreso.id_ingreso = inmunizaciones.idingreso_inmuniz WHERE ingreso.id_ingreso=" + numingredicIZ;
                try {
                    TSentenciaconsultaIZ = con2.createStatement();
                    RconsultaIZ = TSentenciaconsultaIZ.executeQuery(cadsqledicIZ);
                    while (RconsultaIZ.next()) {
                        frameIN.JCHTetano.setSelected(RconsultaIZ.getBoolean(2));
                        frameIN.JTFFechaVac.setText(RconsultaIZ.getString(3));
                        frameIN.JCHfa.setSelected(RconsultaIZ.getBoolean(4));
                        frameIN.JTFFechafa.setText(RconsultaIZ.getString(5));
                        frameIN.JCHHepat.setSelected(RconsultaIZ.getBoolean(6));
                        frameIN.JTFFechafa.setText(RconsultaIZ.getString(7));
                        frameIN.JCHOtraVac.setSelected(RconsultaIZ.getBoolean(8));
                        frameIN.JTFFechaOtrVac.setText(RconsultaIZ.getString(9));
                        frameIN.JTFOtrosIN.setText(RconsultaIZ.getString(10));
                    }
                }// fin del try
                catch (SQLException e1) {
                    e1.getMessage();
                    cad2 = "NO SE PUDO EJECUTAR LA CONSULTA";
                    cad1 = "PROBLEMAS CON LOS DATOS DE INMUNIZACIONES EN EDICION";
                    validIZ.mensajeconfirmacion(cad1, cad2);
                }//cierra el catch
                Cconsql.CerrarConexion();
            }//fin del if swedicingrIZ
        } else {
            CInmuniz frameIN;
            frameIN = (CInmuniz) objetoinmune;
            // ObjectCingreso.setVisible(false);
            frameIN.setVisible(true);
        }
    }

    /**
     * llenarmenarquia
     */
    public void llenarmenarquia() {
        String cadenamen;
        cadenamen = "select * from menarquia ORDER BY id_mquia desc";
        valmenarq.llenarcombos(cadenamen, JCMenarquia, 2);

    }

    /**
     * llenarplanific
     */
    public void llenarplanific() {
        String cadenaplan;
        cadenaplan = "select * from planifica ORDER BY planifica.nombre_planif";
        valmenarq.llenarcombos(cadenaplan, JCPlanifica, 2);

    }

    public void JCHPlanifica_actionPerformed(ActionEvent e) {
        JCPlanifica.setEnabled(true);
    }

    /**
     * llenarresultgineco
     */
    public void llenarresultgineco() {
        String cadenaresgin;
        cadenaresgin = "select *from resultados_gineco ORDER BY resultados_gineco.nombre_resgico";
        valmenarq.llenarcombos(cadenaresgin, JCResultado, 2);

    }

    public CAGineco() {
    }

    //
}//FIN CLASE

class CAGineco_JCHPlanifica_actionAdapter implements ActionListener {

    private CAGineco adaptee;

    CAGineco_JCHPlanifica_actionAdapter(CAGineco adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHPlanifica_actionPerformed(e);
    }
}

class CAGineco_JBSgteAF_actionAdapter implements ActionListener {

    private CAGineco adaptee;

    CAGineco_JBSgteAF_actionAdapter(CAGineco adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSgteAF_actionPerformed(e);
    }
}

class CAGineco_JBAtrasAF_actionAdapter implements ActionListener {

    private CAGineco adaptee;

    CAGineco_JBAtrasAF_actionAdapter(CAGineco adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasAF_actionPerformed(e);
    }
}
