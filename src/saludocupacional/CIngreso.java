package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import com.toedter.calendar.*;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.lang.InterruptedException.*;
public class CIngreso extends JInternalFrame {
    Object objppalig;
    String numingredic;
    int swedicioningr;
    static int swimagen=0;
    ImageIcon m ;
    byte[] imagimpr;
    private JFileChooser fc;
    Object ingresoobject;
    String cad1;
    String cad2;
    CIngreso ObjectCingreso;
    public Statement TSentenciaconsultahc;
    public ResultSet Rconsultahc;
    public ConexionSql Cconsql= new ConexionSql();
    Connection con2=Cconsql.getConnection();
    JCalendar jCalendar1 = new JCalendar();
    Date fechanacdate=new Date();
    String sFecha;
    JButton JBguardarIng;
    JButton JBnuevoIng;
    JButton JBmodificarIng;
    JButton JBactualizarIng;
    JButton JBborrarIng;
    Object obotguardar;
    Object obotnuevo;
    Object obotmodificar;
    Object obotactualizar;
    Object obotborrar;
    //DECLARACION DE OBJETOS VISUALES
    JPanel JPIngreso = new JPanel();
    JTabbedPane JTIngreso = new JTabbedPane();
    JPanel JPDatosDemograficos = new JPanel();
    JPanel JPInfEmpAct = new JPanel();
    JPanel JPFoto = new JPanel();
    //etiquetas
    JLabel JLBNHistoria = new JLabel();
    JLabel JLBTipoDoc = new JLabel();
    JLabel JLBNDocumento = new JLabel();
    JLabel JLBPrimerApell = new JLabel();
    JLabel JLBSegundoApll = new JLabel();
    JLabel JLBPrimerNombre = new JLabel();
    JLabel JLBSgdoNbre = new JLabel();
    JLabel JLBFechaNac = new JLabel();
    JLabel JLBEdad = new JLabel();
    JLabel JLBTipoEdad = new JLabel();
    JLabel JLBSexo = new JLabel();
    JLabel JLBECivil = new JLabel();
    JLabel JLBFoto = new JLabel();
    JLabel JLBNumHijos = new JLabel();
    JLabel JLBNatural = new JLabel();
    JLabel JLBMuniNat = new JLabel();
    JLabel JLBDptoNat = new JLabel();
    JLabel JLBProcedente = new JLabel();
    JLabel JLBMunProc = new JLabel();
    JLabel JLBDptoProc = new JLabel();
    JLabel JLBDirResidencia = new JLabel();
    JLabel JLBZonResi = new JLabel();
    JLabel JLBarrio = new JLabel();
    JLabel JLBEstrato = new JLabel();
    JLabel JLBDirPaciente = new JLabel();
    JLabel JLBTel = new JLabel();
    JLabel JLBFormacionAcad = new JLabel();
    JLabel JLBEscolaridad = new JLabel();
    JLabel JLBProfesion = new JLabel();
    JLabel JLBOcupacion = new JLabel();
    //cuadros de texto
    JFormattedTextField JFTNhistoria = new JFormattedTextField();
    JFormattedTextField JFTNDoc = new JFormattedTextField();
    JFormattedTextField JFTPrimerApll = new JFormattedTextField();
    JFormattedTextField JFTSgdoApll = new JFormattedTextField();
    JFormattedTextField JFTPrimerNbre = new JFormattedTextField();
    JFormattedTextField JFTSgdoNbre = new JFormattedTextField();
    JFormattedTextField JFTFechaNac;
    JFormattedTextField JFTEdad = new JFormattedTextField();
    JFormattedTextField JFTTipoEdad = new JFormattedTextField();
    JFormattedTextField JFTNHijos = new JFormattedTextField();
    JFormattedTextField JFTTel = new JFormattedTextField();
    JFormattedTextField JFTDirResidencia = new JFormattedTextField();
    JFormattedTextField JFTEstrato = new JFormattedTextField();
    //combos
    JComboBox JCBTipoDocumento = new JComboBox();
    JComboBox JCBSexo = new JComboBox();
    JComboBox JCBEstadoCivil = new JComboBox();
    JComboBox JCBMunNat = new JComboBox();
    JComboBox JCBDptoNat = new JComboBox();
    JComboBox JCBMunProc = new JComboBox();
    JComboBox JCBDptoProc = new JComboBox();
    JComboBox JCBProfesion = new JComboBox();
    JComboBox JCBOcupacion = new JComboBox();
    JComboBox JCBEscolaridad = new JComboBox();
    JComboBox JCBBarrio = new JComboBox();
    JComboBox JCBZonRes = new JComboBox();
    //botones
    JButton JBAgregar = new JButton();
    JButton JBELiminar = new JButton();
    JButton JBCambiar = new JButton();
    JLabel JLBeps_ips = new JLabel();
    JLabel JLBEps = new JLabel();
    JComboBox JCBEps = new JComboBox();
    JLabel JLBIps = new JLabel();
    JComboBox JCBIps = new JComboBox();
    JLabel JLBNumIngr = new JLabel();
    JFormattedTextField JFTNumIngr = new JFormattedTextField();
    JLabel JLBMedTrat = new JLabel();
    JComboBox JCBMedTrat = new JComboBox();
    JLabel JLBInfEx = new JLabel();
    JLabel JLBTipoExa = new JLabel();
    JComboBox JCBTipoEx = new JComboBox();
    JLabel JLBCiudadExa = new JLabel();
    JFormattedTextField JFTCiudadEx = new JFormattedTextField();
    JLabel JLBFechaExamen = new JLabel();
    JFormattedTextField JFTFechaExa = new JFormattedTextField();
    JLabel JLBInfActual = new JLabel();
    JLabel JLBEmpresa = new JLabel();
    JComboBox JCBEmpresa = new JComboBox();
    JLabel JLBJornada = new JLabel();
    JComboBox JCBJornada = new JComboBox();
    JLabel JLBCargo = new JLabel();
    JComboBox JCBCargo = new JComboBox();
    JLabel JLBDescrCargo = new JLabel();
    JLabel JLBTipoEmpr = new JLabel();
    JComboBox JCBTipoEmpr = new JComboBox();
    JLabel JLBElem = new JLabel();
    JCheckBox JCHGuantes = new JCheckBox();
    JCheckBox JCHProtcResp = new JCheckBox();
    JCheckBox JCHAuditiva = new JCheckBox();
    JCheckBox JCHVisual = new JCheckBox();
    JCheckBox JCHOtros = new JCheckBox();
    JFormattedTextField JFTOtros = new JFormattedTextField();
    JLabel JLBOtros = new JLabel();
    //DECLARACION DE OBJETOS DE validar
    ValidarComponentes objllencomboIngr=new ValidarComponentes();
    JLabel JLBObservacion = new JLabel();
    JTextPane JTAObservacion = new JTextPane();
    JTextPane JTADescrCargo = new JTextPane();
    JFormattedTextField JFTBarrio = new JFormattedTextField();
    JFormattedTextField JFTProfesion = new JFormattedTextField();
    JFormattedTextField JFTOcup = new JFormattedTextField();
    JFormattedTextField JFTEps = new JFormattedTextField();
    JFormattedTextField JFTIps = new JFormattedTextField();
    JFormattedTextField JFTCargoAspira = new JFormattedTextField();
    JFormattedTextField JFTHoraAtencion = new JFormattedTextField();
    JButton JBFoto = new JButton();
    JFormattedTextField JFTEmpresa = new JFormattedTextField();
    JFormattedTextField JFTTipEmpr = new JFormattedTextField();
    public CIngreso(String sident,int swedicionconsulta,JButton JBGuardar,JButton JBNuevo,JButton JBModificar,JButton JBActualizar,JButton JBBorrar,JDesktopPane JDPIngreso,Object objppalec) {
        try {
            jbInit();
            llenarnumingreso();
            obotguardar=JBGuardar;
            obotnuevo=JBNuevo;
            obotmodificar=JBModificar;
            obotactualizar=JBActualizar;
            obotborrar=JBBorrar;
            ingresoobject=JDPIngreso;
            JBFoto.setEnabled(false);
            JFTEmpresa.setVisible(false);
            swedicioningr=swedicionconsulta;
            numingredic=sident;
            objppalig=objppalec;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public CIngreso(JDesktopPane JDPIngreso){
        try {
            jbInit();
            ingresoobject=JDPIngreso;
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    private void jbInit() throws Exception {
        configurarformatofecha();
        this.setClosable(true);
        this.setIconifiable(true);
        this.setMaximizable(true);
        this.setResizable(true);
        this.getContentPane().setBackground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
        this.setVisible(true);
        this.addKeyListener(new CIngreso_this_keyAdapter(this));
        this.getContentPane().setLayout(null);
        JPIngreso.setBackground(SystemColor.inactiveCaption);
        JPIngreso.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPIngreso.setBorder(BorderFactory.createRaisedBevelBorder());
        JPIngreso.setBounds(new Rectangle(1, 4, 997, 553));
        JPIngreso.addKeyListener(new CIngreso_JPIngreso_keyAdapter(this));
        JPIngreso.setLayout(null);
        JTIngreso.setBounds(new Rectangle(4, 2, 988, 546));
        JTIngreso.addKeyListener(new CIngreso_JTIngreso_keyAdapter(this));
        JTIngreso.setBackground(UIManager.getColor("TextField.selectionBackground"));
        JTIngreso.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JTIngreso.setForeground(Color.RED);
        JTIngreso.setBorder(BorderFactory.createRaisedBevelBorder());
        JPDatosDemograficos.setBackground(new Color(146, 154, 255));
        JPDatosDemograficos.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JPDatosDemograficos.setBorder(BorderFactory.createRaisedBevelBorder());
        JPDatosDemograficos.setLayout(null);
        JPInfEmpAct.setBackground(new Color(146, 154, 255));
        JPInfEmpAct.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JPInfEmpAct.setBorder(BorderFactory.createRaisedBevelBorder());
        JPInfEmpAct.setLayout(null);
        JPFoto.setBorder(BorderFactory.createLoweredBevelBorder());
        JPFoto.setBounds(new Rectangle(812, 35, 106, 120));
        JPFoto.setLayout(null);
        JFTNhistoria.setForeground(Color.red);
        JFTNhistoria.setEditable(false);
        jCalendar1.addMouseListener(new CIngreso_jCalendar1_mouseAdapter(this));
        jCalendar1.addFocusListener(new CIngreso_jCalendar1_focusAdapter(this));
        JCBBarrio.addFocusListener(new CIngreso_JCBBarrio_focusAdapter(this));
        JFTEstrato.setEditable(false);
        JFTCiudadEx.setEditable(false);
        JFTFechaExa.setEditable(false);
        JCHOtros.addActionListener(new CIngreso_JCHOtros_actionAdapter(this));
        JFTOtros.setEditable(false);
        JFTNumIngr.setEditable(false);
        JFTNumIngr.addFocusListener(new CIngreso_JFTNumIngr_focusAdapter(this));
        JLBObservacion.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBObservacion.setToolTipText("");
        JLBObservacion.setText("OBSERVACION");
        JLBObservacion.setBounds(new Rectangle(326, 312, 87, 20));
        JTAObservacion.setToolTipText("");
        JTAObservacion.setBounds(new Rectangle(324, 337, 226, 115));
        JTADescrCargo.setToolTipText("");
        JTADescrCargo.setBounds(new Rectangle(646, 260, 287, 193));
        JFTBarrio.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTBarrio.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTBarrio.setToolTipText("");
        JFTBarrio.setBounds(new Rectangle(113, 299, 157, 21));
        JFTBarrio.setVisible(false);
        JFTProfesion.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTProfesion.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTProfesion.setToolTipText("");
        JFTProfesion.setBounds(new Rectangle(283, 376, 240, 21));
        JFTProfesion.setVisible(false);
        JFTOcup.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTOcup.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTOcup.setToolTipText("");
        JFTOcup.setBounds(new Rectangle(556, 382, 416, 19));
        JFTOcup.setVisible(false);
        JFTEps.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTEps.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTEps.setToolTipText("");
        JFTEps.setBounds(new Rectangle(13, 454, 322, 21));
        JFTEps.setVisible(false);
        JFTIps.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTIps.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTIps.setToolTipText("");
        JFTIps.setBounds(new Rectangle(347, 453, 623, 21));
        JFTIps.setVisible(false);
        JFTCargoAspira.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTCargoAspira.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTCargoAspira.setToolTipText("");
        JFTCargoAspira.setBounds(new Rectangle(11, 258, 541, 21));
        JFTCargoAspira.setVisible(false);
        JCBBarrio.addKeyListener(new CIngreso_JCBBarrio_keyAdapter(this));
        JCBProfesion.addKeyListener(new CIngreso_JCBProfesion_keyAdapter(this));
        JCBOcupacion.addActionListener(new CIngreso_JCBOcupacion_actionAdapter(this));
        JCBOcupacion.addKeyListener(new CIngreso_JCBOcupacion_keyAdapter(this));
        JCBEps.addKeyListener(new CIngreso_JCBEps_keyAdapter(this));
        JCBIps.addKeyListener(new CIngreso_JCBIps_keyAdapter(this));
        JCBCargo.addKeyListener(new CIngreso_JCBCargo_keyAdapter(this));
        JLBOcupacion.setEnabled(false);
        JCBOcupacion.setEnabled(false);
        JFTNHijos.addKeyListener(new CIngreso_JFTNHijos_keyAdapter(this));
        JFTHoraAtencion.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTHoraAtencion.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTHoraAtencion.setToolTipText("");
        JFTHoraAtencion.setEditable(false);
        JFTHoraAtencion.setBounds(new Rectangle(843, 104, 101, 21));
        JBAgregar.addActionListener(new CIngreso_JBAgregar_actionAdapter(this));
        JBFoto.setBackground(Color.white);
        JBFoto.setBounds(new Rectangle(1, 1, 106, 118));
        JFTEmpresa.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTEmpresa.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTEmpresa.setToolTipText("");
        JFTEmpresa.setBounds(new Rectangle(7, 183, 545, 21));
        JCBEmpresa.addKeyListener(new CIngreso_JCBEmpresa_keyAdapter(this));
        JFTTipEmpr.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTTipEmpr.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTTipEmpr.setToolTipText("");
        JFTTipEmpr.setBounds(new Rectangle(648, 183, 160, 21));
        JCBTipoEmpr.addKeyListener(new CIngreso_JCBTipoEmpr_keyAdapter(this));
        this.getContentPane().add(JPIngreso);
        JPIngreso.add(JTIngreso);
        JTIngreso.add(JPDatosDemograficos, "DATOS DEMOGRAFICOS");
        JTIngreso.add(JPInfEmpAct, "INFORMACION DEL EMPLEO ACTUAL");
        JLBNHistoria.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBNHistoria.setText("N� HISTORIA");
        JLBNHistoria.setBounds(new Rectangle(7, 5, 82, 20));
        JFTNhistoria.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTNhistoria.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTNhistoria.setToolTipText("");
        JFTNhistoria.setBounds(new Rectangle(7, 27, 126, 21));
        JLBTipoDoc.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBTipoDoc.setToolTipText("");
        JLBTipoDoc.setText("TIPO DOCUMENTO");
        JLBTipoDoc.setBounds(new Rectangle(155, 5, 106, 20));
        JCBTipoDocumento.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBTipoDocumento.setBounds(new Rectangle(158, 26, 158, 22));
        JLBNDocumento.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBNDocumento.setToolTipText("");
        JLBNDocumento.setText("N� DOCUMENTO");
        JLBNDocumento.setBounds(new Rectangle(334, 4, 106, 20));
        JLBPrimerApell.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBPrimerApell.setToolTipText("");
        JLBPrimerApell.setText("PRIMER APELLIDO");
        JLBPrimerApell.setBounds(new Rectangle(8, 53, 120, 20));
        JLBPrimerNombre.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBPrimerNombre.setToolTipText("");
        JLBPrimerNombre.setText("PRIMER NOMBRE");
        JLBPrimerNombre.setBounds(new Rectangle(335, 51, 118, 20));
        JLBFoto.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBFoto.setToolTipText("");
        JLBFoto.setText("FOTO");
        JLBFoto.setBounds(new Rectangle(795, 2, 106, 20));
        JFTNDoc.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTNDoc.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTNDoc.setToolTipText("");
        JFTNDoc.setBounds(new Rectangle(335, 27, 139, 21));
        JFTNDoc.addFocusListener(new CIngreso_JFTNDoc_focusAdapter(this));
        JLBPrimerApell.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBPrimerApell.setToolTipText("");
        JLBPrimerApell.setText("PRIMER APELLIDO");
        JLBPrimerApell.setBounds(new Rectangle(8, 54, 120, 20));
        JLBSegundoApll.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBSegundoApll.setToolTipText("");
        JLBSegundoApll.setText("SEGUNDO APELLIDO");
        JLBSegundoApll.setBounds(new Rectangle(158, 52, 118, 20));
        JLBSgdoNbre.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBSgdoNbre.setToolTipText("");
        JLBSgdoNbre.setText("SEGUNDO NOMBRE");
        JLBSgdoNbre.setBounds(new Rectangle(516, 48, 118, 20));
        JLBFechaNac.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBFechaNac.setToolTipText("");
        JLBFechaNac.setText("FECHA NACIMIENTO");
        JLBFechaNac.setBounds(new Rectangle(9, 106, 120, 20));
        JLBEdad.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBEdad.setToolTipText("");
        JLBEdad.setText("EDAD");
        JLBEdad.setBounds(new Rectangle(159, 104, 52, 20));
        JLBTipoEdad.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBTipoEdad.setToolTipText("");
        JLBTipoEdad.setText("TIPO EDAD");
        JLBTipoEdad.setBounds(new Rectangle(214, 103, 102, 20));
        JLBSexo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBSexo.setToolTipText("");
        JLBSexo.setText("SEXO");
        JLBSexo.setBounds(new Rectangle(336, 105, 38, 20));
        JLBECivil.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBECivil.setToolTipText("");
        JLBECivil.setText("ESTADO CIVIL");
        JLBECivil.setBounds(new Rectangle(443, 102, 88, 20));
        JLBNumHijos.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBNumHijos.setToolTipText("");
        JLBNumHijos.setText("N� HIJOS");
        JLBNumHijos.setBounds(new Rectangle(600, 102, 52, 20));
        JLBNatural.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNatural.setForeground(Color.red);
        JLBNatural.setToolTipText("");
        JLBNatural.setText("NATURAL");
        JLBNatural.setBounds(new Rectangle(12, 175, 73, 20));
        JLBMuniNat.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBMuniNat.setToolTipText("");
        JLBMuniNat.setText("MUNICIPIO NATURAL");
        JLBMuniNat.setBounds(new Rectangle(11, 196, 115, 20));
        JLBDptoNat.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBDptoNat.setToolTipText("");
        JLBDptoNat.setText("DPTO NATURAL");
        JLBDptoNat.setBounds(new Rectangle(202, 195, 97, 20));
        JLBProcedente.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBProcedente.setForeground(Color.red);
        JLBProcedente.setToolTipText("");
        JLBProcedente.setText("PROCEDENTE");
        JLBProcedente.setBounds(new Rectangle(518, 176, 95, 20));
        JLBMunProc.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBMunProc.setToolTipText("");
        JLBMunProc.setText("MUNICIPIO PROCEDENTE");
        JLBMunProc.setBounds(new Rectangle(520, 199, 130, 20));
        JLBDptoProc.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBDptoProc.setToolTipText("");
        JLBDptoProc.setText("DPTO PROCEDENTE");
        JLBDptoProc.setBounds(new Rectangle(743, 200, 130, 20));
        JLBNumIngr.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBNumIngr.setToolTipText("");
        JLBNumIngr.setText("N� INGRESO");
        JLBNumIngr.setBounds(new Rectangle(517, 1, 106, 20));
        JLBarrio.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBarrio.setToolTipText("");
        JLBarrio.setText("BARRIO");
        JLBarrio.setBounds(new Rectangle(112, 274, 42, 20));
        JLBEstrato.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBEstrato.setToolTipText("");
        JLBEstrato.setText("ESTRATO");
        JLBEstrato.setBounds(new Rectangle(282, 277, 54, 20));
        JLBDirPaciente.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBDirPaciente.setToolTipText("");
        JLBDirPaciente.setText("DIRECCION");
        JLBDirPaciente.setBounds(new Rectangle(342, 277, 64, 20));
        JLBTel.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBTel.setToolTipText("");
        JLBTel.setText("TELEFONO");
        JLBTel.setBounds(new Rectangle(744, 269, 64, 20));
        JLBFormacionAcad.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBFormacionAcad.setForeground(Color.red);
        JLBFormacionAcad.setToolTipText("");
        JLBFormacionAcad.setText("FORMACION ACADEMICA");
        JLBFormacionAcad.setBounds(new Rectangle(8, 334, 183, 20));
        JLBEscolaridad.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBEscolaridad.setToolTipText("");
        JLBEscolaridad.setText("ESCOLARIDAD");
        JLBEscolaridad.setBounds(new Rectangle(8, 355, 83, 20));
        JLBProfesion.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBProfesion.setToolTipText("");
        JLBProfesion.setText("PROFESION");
        JLBProfesion.setBounds(new Rectangle(283, 357, 83, 20));
        JLBIps.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBIps.setToolTipText("");
        JLBIps.setText("IPS");
        JLBIps.setBounds(new Rectangle(346, 427, 83, 20));
        JLBOcupacion.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBOcupacion.setToolTipText("");
        JLBOcupacion.setText("OCUPACION");
        JLBOcupacion.setBounds(new Rectangle(555, 356, 83, 20));
        JLBeps_ips.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBeps_ips.setForeground(Color.red);
        JLBeps_ips.setToolTipText("");
        JLBeps_ips.setText("EPS E IPS");
        JLBeps_ips.setBounds(new Rectangle(12, 409, 117, 20));
        JLBEps.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBEps.setToolTipText("");
        JLBEps.setText("EPS");
        JLBEps.setBounds(new Rectangle(13, 429, 83, 20));
        JLBMedTrat.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBMedTrat.setToolTipText("");
        JLBMedTrat.setText("MEDICO TRATANTE");
        JLBMedTrat.setBounds(new Rectangle(8, 41, 112, 20));
        JLBInfEx.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBInfEx.setForeground(Color.red);
        JLBInfEx.setToolTipText("");
        JLBInfEx.setText("INFORMACION DEL EXAMEN");
        JLBInfEx.setBounds(new Rectangle(6, 12, 214, 20));
        JLBTipoExa.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBTipoExa.setToolTipText("");
        JLBTipoExa.setText("TIPO DE EXAMEN");
        JLBTipoExa.setBounds(new Rectangle(396, 43, 112, 20));
        JLBCiudadExa.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBCiudadExa.setToolTipText("");
        JLBCiudadExa.setText("CIUDAD DEL EXAMEN");
        JLBCiudadExa.setBounds(new Rectangle(645, 39, 112, 20));
        JLBFechaExamen.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBFechaExamen.setToolTipText("");
        JLBFechaExamen.setText("FECHA DEL EXAMEN");
        JLBFechaExamen.setBounds(new Rectangle(834, 40, 112, 20));
        JLBInfActual.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBInfActual.setForeground(Color.red);
        JLBInfActual.setToolTipText("");
        JLBInfActual.setText("INFORMACION DEL EMPLEO ACTUAL");
        JLBInfActual.setBounds(new Rectangle(7, 126, 263, 20));
        JLBEmpresa.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBEmpresa.setToolTipText("");
        JLBEmpresa.setText("EMPRESA");
        JLBEmpresa.setBounds(new Rectangle(10, 156, 120, 20));
        JLBJornada.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBJornada.setToolTipText("");
        JLBJornada.setText("JORNADA");
        JLBJornada.setBounds(new Rectangle(833, 152, 69, 20));
        JLBCargo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBCargo.setToolTipText("");
        JLBCargo.setText("CARGO AL QUE ASPIRA");
        JLBCargo.setBounds(new Rectangle(10, 227, 124, 20));
        JLBDescrCargo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBDescrCargo.setToolTipText("");
        JLBDescrCargo.setText("DESCRIPCION DEL CARGO");
        JLBDescrCargo.setBounds(new Rectangle(648, 228, 151, 20));
        JLBTipoEmpr.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBTipoEmpr.setToolTipText("");
        JLBTipoEmpr.setText("TIPO DE EMPRESA");
        JLBTipoEmpr.setBounds(new Rectangle(647, 152, 108, 20));
        JLBElem.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBElem.setForeground(Color.red);
        JLBElem.setToolTipText("");
        JLBElem.setText("ELEMENTOS DE PROTECCION PERSONAL");
        JLBElem.setBounds(new Rectangle(10, 311, 291, 20));
        JLBDirResidencia.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBDirResidencia.setForeground(Color.red);
        JLBDirResidencia.setToolTipText("");
        JLBDirResidencia.setText("DIRECCION DE RESIDENCIA");
        JLBDirResidencia.setBounds(new Rectangle(12, 252, 191, 20));
        JLBZonResi.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBZonResi.setToolTipText("");
        JLBZonResi.setText("ZONA");
        JLBZonResi.setBounds(new Rectangle(12, 276, 42, 20));
        JLBOtros.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JLBOtros.setToolTipText("");
        JLBOtros.setText("OTROS");
        JLBOtros.setBounds(new Rectangle(253, 447, 120, 20));

        JFTPrimerNbre.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTPrimerNbre.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTPrimerNbre.setToolTipText("");
        JFTPrimerNbre.setCaretColor(SystemColor.textText);
        JFTPrimerNbre.setSelectedTextColor(UIManager.getColor("ComboBox.selectionBackground"));
        JFTPrimerNbre.setSelectionColor(Color.white);
        JFTPrimerNbre.setBounds(new Rectangle(516, 75, 139, 21));
        JFTPrimerApll.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTPrimerApll.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTPrimerApll.setToolTipText("");
        JFTPrimerApll.setBounds(new Rectangle(8, 77, 126, 21));
        JFTPrimerApll.addActionListener(new CIngreso_JFTPrimerApll_actionAdapter(this));
        JFTSgdoApll.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTSgdoApll.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTSgdoApll.setToolTipText("");
        JFTSgdoApll.setBounds(new Rectangle(158, 76, 139, 21));
        JFTSgdoApll.addActionListener(new CIngreso_JFTSgdoApll_actionAdapter(this));
        JFTPrimerNbre.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTPrimerNbre.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTPrimerNbre.setToolTipText("");
        JFTPrimerNbre.setCaretColor(SystemColor.textText);
        JFTPrimerNbre.setSelectedTextColor(UIManager.getColor("ComboBox.selectionBackground"));
        JFTPrimerNbre.setSelectionColor(Color.white);
        JFTPrimerNbre.setBounds(new Rectangle(516, 75, 139, 21));
        JFTSgdoNbre.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTSgdoNbre.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTSgdoNbre.setToolTipText("");
        JFTSgdoNbre.setBounds(new Rectangle(335, 75, 139, 21));
        JFTFechaNac.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTFechaNac.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTFechaNac.setToolTipText("");
        JFTFechaNac.setBounds(new Rectangle(10, 133, 126, 21));
        JFTFechaNac.addFocusListener(new CIngreso_JFTFechaNac_focusAdapter(this));
        JFTEdad.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTEdad.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTEdad.setToolTipText("");
        JFTEdad.setBounds(new Rectangle(160, 135, 29, 21));
        JFTTipoEdad.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTTipoEdad.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTTipoEdad.setToolTipText("");
        JFTTipoEdad.setBounds(new Rectangle(214, 137, 101, 21));
        JFTNHijos.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTNHijos.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTNHijos.setToolTipText("");
        JFTNHijos.setBounds(new Rectangle(597, 131, 58, 21));
        JFTEstrato.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTEstrato.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTEstrato.setToolTipText("");
        JFTEstrato.setBounds(new Rectangle(294, 299, 29, 21));
        JFTDirResidencia.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTDirResidencia.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTDirResidencia.setToolTipText("");
        JFTDirResidencia.setBounds(new Rectangle(343, 298, 334, 21));
        JFTTel.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTTel.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTTel.setToolTipText("");
        JFTTel.setBounds(new Rectangle(744, 299, 231, 21));
        JFTNumIngr.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTNumIngr.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTNumIngr.setToolTipText("");
        JFTNumIngr.setBounds(new Rectangle(516, 26, 139, 21));
        //JFTNumIngr.setColumns(5);
        JFTCiudadEx.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTCiudadEx.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTCiudadEx.setToolTipText("");
        JFTCiudadEx.setBounds(new Rectangle(646, 66, 126, 21));
        JFTCiudadEx.setText("CARTAGENA");
        JFTFechaExa.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTFechaExa.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTFechaExa.setToolTipText("");
        JFTFechaExa.setBounds(new Rectangle(840, 66, 101, 21));
        JFTOtros.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTOtros.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTOtros.setToolTipText("");
        JFTOtros.setBounds(new Rectangle(253, 473, 298, 21));
        jCalendar1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jCalendar1.setBackground(Color.red);
        jCalendar1.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        jCalendar1.setDecorationBackgroundColor(Color.white);
        jCalendar1.setBounds(new Rectangle(9, 133, 258, 84));
        //jCalendar1.addKeyListener(new CUsuarios_jCalendar1_keyAdapter(this));
        //jCalendar1.addMouseListener(new CUsuarios_jCalendar1_mouseAdapter(this));
        jCalendar1.setVisible(false);
        JCBSexo.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBSexo.setBounds(new Rectangle(335, 133, 85, 22));
        JCBEstadoCivil.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBEstadoCivil.setBounds(new Rectangle(443, 129, 113, 22));
        JCBIps.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBIps.setBounds(new Rectangle(345, 451, 625, 22));
        JCBMunNat.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBMunNat.setBounds(new Rectangle(10, 217, 158, 22));
        JCBDptoNat.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBDptoNat.setBounds(new Rectangle(202, 216, 158, 22));
        JCBMunProc.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBMunProc.setBounds(new Rectangle(520, 222, 158, 22));
        JCBDptoProc.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBDptoProc.setBounds(new Rectangle(743, 220, 158, 22));
        JCBZonRes.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBZonRes.setBounds(new Rectangle(10, 298, 85, 22));
        JCBBarrio.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBBarrio.setBounds(new Rectangle(112, 297, 158, 22));
        JCBEscolaridad.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBEscolaridad.setBounds(new Rectangle(6, 377, 158, 22));
        JCBProfesion.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBProfesion.setBounds(new Rectangle(283, 377, 240, 22));
        JCBOcupacion.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBOcupacion.setBounds(new Rectangle(555, 377, 418, 22));
        JCBEps.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBEps.setBounds(new Rectangle(11, 451, 324, 22));
        JCBMedTrat.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBMedTrat.setBounds(new Rectangle(7, 65, 240, 22));
        JCBTipoEx.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBTipoEx.setBounds(new Rectangle(397, 66, 158, 22));
        JCBEmpresa.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBEmpresa.setBounds(new Rectangle(7, 181, 546, 22));
        JCBJornada.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBJornada.setBounds(new Rectangle(832, 182, 101, 22));
        JCBCargo.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBCargo.setBounds(new Rectangle(11, 257, 542, 22));
        JCBTipoEmpr.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JCBTipoEmpr.setBounds(new Rectangle(647, 182, 159, 22));

        JBAgregar.setBounds(new Rectangle(742, 178, 78, 24));
        JBAgregar.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JBAgregar.setBorder(null);
        JBAgregar.setMnemonic('A');
        JBAgregar.setText("Agregar");
        JBELiminar.setVisible(false);
        JBELiminar.setBounds(new Rectangle(821, 179, 78, 24));
        JBELiminar.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JBELiminar.setBorder(null);
        JBELiminar.setToolTipText("");
        JBELiminar.setMnemonic('E');
        JBELiminar.setText("Eliminar");
        JBCambiar.setVisible(false);
        JBCambiar.setBounds(new Rectangle(900, 179, 78, 24));
        JBCambiar.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JBCambiar.setBorder(null);
        JBCambiar.setToolTipText("");
        JBCambiar.setMnemonic('C');
        JBCambiar.setText("Cambiar");
        JCHGuantes.setBackground(SystemColor.activeCaption);
        JCHGuantes.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHGuantes.setText("GUANTES");
        JCHGuantes.setBounds(new Rectangle(11, 341, 180, 23));
        JCHProtcResp.setBackground(SystemColor.activeCaption);
        JCHProtcResp.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHProtcResp.setText("PROTECCION RESPIRATORIA");
        JCHProtcResp.setBounds(new Rectangle(11, 374, 182, 23));
        JCHAuditiva.setBackground(SystemColor.activeCaption);
        JCHAuditiva.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHAuditiva.setText("AUDITIVA");
        JCHAuditiva.setBounds(new Rectangle(11, 407, 181, 23));
        JCHVisual.setBackground(SystemColor.activeCaption);
        JCHVisual.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHVisual.setToolTipText("");
        JCHVisual.setText("VISUAL");
        JCHVisual.setBounds(new Rectangle(11, 439, 181, 23));
        JCHOtros.setBackground(SystemColor.activeCaption);
        JCHOtros.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHOtros.setToolTipText("");
        JCHOtros.setText("OTROS");
        JCHOtros.setBounds(new Rectangle(14, 471, 176, 23));

        //adiccionar al panel JPDatosDemograficos
        JPDatosDemograficos.add(JLBNHistoria);
        JPDatosDemograficos.add(JFTNhistoria);
        JPDatosDemograficos.add(JLBTipoDoc);
        JPDatosDemograficos.add(JLBFoto);
        JPDatosDemograficos.add(JBAgregar);
        JPDatosDemograficos.add(JBELiminar);
        JPDatosDemograficos.add(JBCambiar);
        JPDatosDemograficos.add(JCBTipoDocumento);
        JPDatosDemograficos.add(JFTSgdoNbre);
        JPDatosDemograficos.add(JLBPrimerNombre);
        JPDatosDemograficos.add(JLBSgdoNbre);
        JPDatosDemograficos.add(JFTPrimerApll);
        JPDatosDemograficos.add(JFTSgdoApll);
        JPDatosDemograficos.add(JLBSegundoApll);
        JPDatosDemograficos.add(JFTNHijos);
        JPDatosDemograficos.add(JLBFechaNac);
        JPDatosDemograficos.add(JFTFechaNac);
        JPDatosDemograficos.add(JFTEdad);
        JPDatosDemograficos.add(JLBEdad);
        JPDatosDemograficos.add(JLBTipoEdad);
        JPDatosDemograficos.add(JLBSexo);
        JPDatosDemograficos.add(JCBSexo);
        JPDatosDemograficos.add(JLBECivil);
        JPDatosDemograficos.add(JCBEstadoCivil);
        JPDatosDemograficos.add(JLBNumHijos);
        JPDatosDemograficos.add(JCBMunProc);
        JPDatosDemograficos.add(JLBDptoProc);
        JPDatosDemograficos.add(JCBDptoProc);
        JPDatosDemograficos.add(JLBNatural);
        JPDatosDemograficos.add(JLBMuniNat);
        JPDatosDemograficos.add(JCBMunNat);
        JPDatosDemograficos.add(JLBDptoNat);
        JPDatosDemograficos.add(JCBDptoNat);
        JPDatosDemograficos.add(JLBProcedente);
        JPDatosDemograficos.add(JLBMunProc);
        JPDatosDemograficos.add(JCBBarrio);
        JPDatosDemograficos.add(JLBZonResi);
        JPDatosDemograficos.add(JFTEstrato);
        JPDatosDemograficos.add(JLBTel);
        JPDatosDemograficos.add(JLBDirPaciente);
        JPDatosDemograficos.add(JFTTel);
        JPDatosDemograficos.add(JFTDirResidencia);
        JPDatosDemograficos.add(JCBZonRes);
        JPDatosDemograficos.add(JLBarrio);
        JPDatosDemograficos.add(JLBEstrato);
        JPDatosDemograficos.add(JLBDirResidencia);
        JPDatosDemograficos.add(JCBProfesion);
        JPDatosDemograficos.add(JLBProfesion);
        JPDatosDemograficos.add(JLBOcupacion);
        JPDatosDemograficos.add(JCBOcupacion);
        JPDatosDemograficos.add(JLBeps_ips);
        JPDatosDemograficos.add(JLBFormacionAcad);
        JPDatosDemograficos.add(JLBEscolaridad);
        JPDatosDemograficos.add(JCBEscolaridad);
        JPDatosDemograficos.add(JLBEps);
        JPDatosDemograficos.add(JLBIps);
        JPDatosDemograficos.add(JCBEps);
        JPDatosDemograficos.add(JCBIps);
        JPDatosDemograficos.add(JFTPrimerNbre);
        JPDatosDemograficos.add(JLBNumIngr);
        JPDatosDemograficos.add(JLBNDocumento);
        JPDatosDemograficos.add(JFTNDoc);
        JPDatosDemograficos.add(JFTNumIngr);
        JPDatosDemograficos.add(JLBPrimerApell);
        JPDatosDemograficos.add(jCalendar1);
        JPDatosDemograficos.add(JFTBarrio);
        JPDatosDemograficos.add(JFTProfesion);
        JPDatosDemograficos.add(JFTOcup);
        JPDatosDemograficos.add(JFTTipoEdad);
        JPDatosDemograficos.add(JFTIps);
        JPDatosDemograficos.add(JFTEps);
        JPDatosDemograficos.add(JPFoto);
        JPFoto.add(JBFoto);
        JPDatosDemograficos.add(JFTNhistoria);
        JPDatosDemograficos.add(JLBEdad);
        JPDatosDemograficos.add(JPFoto);JPInfEmpAct.add(JLBInfEx);
        JPInfEmpAct.add(JLBMedTrat);
        JPInfEmpAct.add(JCBMedTrat);
        JPInfEmpAct.add(JLBTipoExa);
        JPInfEmpAct.add(JCBTipoEx);
        JPInfEmpAct.add(JLBCiudadExa);
        JPInfEmpAct.add(JFTCiudadEx);
        JPInfEmpAct.add(JLBFechaExamen);
        JPInfEmpAct.add(JLBElem);
        JPInfEmpAct.add(JCHGuantes);
        JPInfEmpAct.add(JCHProtcResp);
        JPInfEmpAct.add(JCHAuditiva);
        JPInfEmpAct.add(JCHVisual);
        JPInfEmpAct.add(JCHOtros);
        JPInfEmpAct.add(JLBOtros);
        JPInfEmpAct.add(JLBTipoEmpr);
        JPInfEmpAct.add(JLBJornada);
        JPInfEmpAct.add(JCBJornada);
        JPInfEmpAct.add(JLBCargo);
        JPInfEmpAct.add(JCBCargo);
        JPInfEmpAct.add(JLBInfActual);
        JPInfEmpAct.add(JLBEmpresa);
        JPInfEmpAct.add(JCBEmpresa);
        JPInfEmpAct.add(JCBTipoEmpr);
        JPInfEmpAct.add(JLBDescrCargo);
        JPInfEmpAct.add(JLBObservacion);
        JPInfEmpAct.add(JTADescrCargo);
        JPInfEmpAct.add(JTAObservacion);
        JPInfEmpAct.add(JFTCargoAspira);
        JPInfEmpAct.add(JFTHoraAtencion);
        JPInfEmpAct.add(JFTFechaExa);
        JPInfEmpAct.add(JFTEmpresa);
        JPInfEmpAct.add(JFTOtros);
        JPInfEmpAct.add(JFTTipEmpr);
        llenarcombotd();
        llenarcombosex();
        llenarcomboec();
        llenardptonat();
        llenarmcpionat();
        llenardptoproc();
        llenarmcpioproc();
        llenarzona();
        llenarbarrio();
        llenarescolar();
        llenarprofesion();
        llenarocupacion();
        llenareps();
        llenarips();
        llenarmed();
        llenarte();
        llenarempre();
        llenartipempr();
        llenarjornada();
        llenarcargo();
        iniciofechaexam();
        JFTHoraAtencion.setVisible(false);
    }

    /**
     * llenarcargo
     */
    public void llenarcargo() {
        String cadenaocup;
        cadenaocup="select *from ocupacion ORDER BY ocupacion.Nbre_Ocupacion";
        objllencomboIngr.llenarcombos(cadenaocup,JCBCargo,2);
    }

    /**
     * llenardptoproc
     */
    public void llenardptoproc() {
        String cadenadpto;
        cadenadpto="select *from departamento ORDER BY departamento.Nbre_Departamento ";
        objllencomboIngr.llenarcombos(cadenadpto,JCBDptoProc,2);

    }

    //
    public void JFTNDoc_focusLost(FocusEvent e) {
        //FrameHistoriasClinicas frameboton=null;
          int resulthc; String cadenasqlhc,sqlconsultaingr;
          cadenasqlhc="select *from datosusuarios where NoHC_du="+"'"+JFTNDoc.getText() +"'";
          resulthc=objllencomboIngr.verificarcodigocadena(cadenasqlhc);
          if(resulthc!=0)
          {  //JBSigute.setEnabled(false);
             cad1="ESTE PACIENTE YA EXISTE EN LA BASE DE DATOS";
             cad2="DATOS USUARIO";
             objllencomboIngr.mensajeconfirmacion(cad1,cad2);
             JBguardarIng=new JButton();
             JBnuevoIng=new JButton();
             JBmodificarIng=new JButton();
             JBactualizarIng=new JButton();
             JBborrarIng=new JButton();
             JBguardarIng=(JButton)obotguardar;
             JBguardarIng.setEnabled(false);
             JBnuevoIng=(JButton)obotnuevo;
             JBnuevoIng.setEnabled(false);
             JBmodificarIng=(JButton)obotmodificar;
             JBmodificarIng.setEnabled(false);
             JBborrarIng=(JButton)obotborrar;
             JBborrarIng.setEnabled(false);
             JBactualizarIng=(JButton)obotactualizar;
             JBactualizarIng.setEnabled(true);
             JBFoto.setEnabled(true);
             
             sqlconsultaingr="SELECT datosusuarios.NoHC_du, datosusuarios.Documento_du, datosusuarios.PrimerApellido_du, datosusuarios.SegundoApellido_du, datosusuarios.PrimerNombre_du, datosusuarios.SegundoNombre_du, datosusuarios.FechadeNacimiento_du, datosusuarios.idtipoedad_du, datosusuarios.edad_du, datosusuarios.IdSexo_du, datosusuarios.IdEstadoCivi_du, datosusuarios.NumHijos_du, datosusuarios.IdMunicipionatural, datosusuarios.IdDepartamentonatural_du, datosusuarios.IdMunicipioprocedente_du, datosusuarios.IdDepartamentoprocedente_du, datosusuarios.idzonares_du, datosusuarios.DireccionResidencia_du, datosusuarios.Barrio_du,datosusuarios.idtipoescolaridad_du, datosusuarios.profesion_du, datosusuarios.TelefonoCelular_du, datosusuarios.idocupacion_du, datosusuarios.ideps_du, datosusuarios.idips_du, ingreso.idtipoex_ingreso, ingreso.fechaexa_ingreso, ingreso.idciudadexam_ingreso, ingreso.idempresa_ingreso, ingreso.idtipoindustria_ingreso, ingreso.idjornadatrabajo_ingreso, ingreso.idmedico_ingreso, ingreso.cargoaspira_ingreso, ingreso.descripcioncargo_ingreso, ingreso.elemguantes_ingreso, ingreso.elemrespi_ingreso, ingreso.elemauditiva_ingreso, ingreso.elemvisual_ingreso, ingreso.elemotros_ingreso, ingreso.descrotros_ingreso,ingreso.observacion_ingreso,ingreso.horaentrada_ingreso,datosusuarios.foto_du FROM datosusuarios INNER JOIN ingreso ON datosusuarios.NoHC_du = ingreso.NoHC_ingreso WHERE datosusuarios.NoHC_du="+"'"+JFTNDoc.getText() +"'";
             try{
                 TSentenciaconsultahc=con2.createStatement();
                 Rconsultahc=TSentenciaconsultahc.executeQuery(sqlconsultaingr);
                 llenarpanelingreso(Rconsultahc);
                 bloquearingr();
             }//cierra el try
             catch(SQLException e1){
                e1.getMessage();
                cad1="NO SE PUDO EJECUTAR LA CONSULTA";
                cad2="PROBLEMAS CON LOS DATOS DEL USUARIO E INGRESO";
                objllencomboIngr.mensajeconfirmacion(cad1,cad2);
             }//cierra el catch
          }
          else
             JFTNhistoria.setText(JFTNDoc.getText());

    }
//fin de JFTNDoc_focusLost(FocusEvent e)
    public void JFTPrimerApll_actionPerformed(ActionEvent e) {

    }//fin de JFTPrimerApll_actionPerformed(ActionEvent e)
    public void JFTSgdoApll_actionPerformed(ActionEvent e) {

    }//fin de JFTSgdoApll_actionPerformed(ActionEvent e)
     public void JFTFechaNac_focusLost(FocusEvent e) {

     }//fin de JFTFechaNac_focusLost

    /**
     * configurarformatofecha
     */
    public void configurarformatofecha() {
        //CONFIGURAMOS EL EDITOR DE LA FECHA
          try{
               MaskFormatter mascara= new MaskFormatter("##/##/####");
               JFTFechaNac=new JFormattedTextField(mascara);
              //JTFfechalote.setValue("  /  /    ");
             }
            catch (ParseException e){
                System.out.println("problema en la mascara del valor unitario de ls entrada por inventario inicial");
            }
    }

    /**
     * llenarcombotd
     */
    public void llenarcombotd() {
        String cadenatd;
        cadenatd="select *from tipodocumento ORDER BY tipodocumento.Nbre_TipoDocumento";
        objllencomboIngr.llenarcombos(cadenatd,JCBTipoDocumento,2);
        JCBTipoDocumento.setSelectedIndex(2);
    }

    /**
     * llenarcombosex
     */
    public void llenarcombosex() {
        String cadenasex;
        cadenasex="select *from sexo ORDER BY sexo.Nbre_Sexo";
        objllencomboIngr.llenarcombos(cadenasex,JCBSexo,2);
    }

    /**
     * llenarcomboec
     */
    public void llenarcomboec() {
        String cadenaec;
        cadenaec="select *from estadocivil ORDER BY estadocivil.Nbre_EstadoCivil";
        objllencomboIngr.llenarcombos(cadenaec,JCBEstadoCivil,2);
    }

    /**
     * llenardptonat
     */
    public void llenardptonat() {
        String cadenadpto;
        cadenadpto="select *from departamento ORDER BY departamento.Nbre_Departamento ";
        objllencomboIngr.llenarcombos(cadenadpto,JCBDptoNat,2);
    }

    /**
     * llenarmcpionat
     */
    public void llenarmcpionat() {
        String cadenadmcpio;
        cadenadmcpio="select *from municipio ORDER BY municipio.Nbre_Municipio";
        objllencomboIngr.llenarcombos(cadenadmcpio,JCBMunNat,2);

    }

    /**
     * llenarmcpioproc
     */
    public void llenarmcpioproc() {
        String cadenadmcpio;
        cadenadmcpio="select *from municipio ORDER BY municipio.Nbre_Municipio";
        objllencomboIngr.llenarcombos(cadenadmcpio,JCBMunProc,2);
    }

    /**
     * llenarzona
     */
    public void llenarzona() {
        String cadenadmcpio;
        cadenadmcpio="select *from zona ORDER BY zona.nombre_zona";
        objllencomboIngr.llenarcombos(cadenadmcpio,JCBZonRes,2);

    }

    /**
     * llenarbarrio
     */
    public void llenarbarrio() {
        String cadenabarrio;
        cadenabarrio="select *from barrio ORDER BY barrio.Nbre_Barrio";
        objllencomboIngr.llenarcombos(cadenabarrio,JCBBarrio,3);
    }

    /**
     * llenarescolar
     */
    public void llenarescolar() {
        String cadenaescolar;
        cadenaescolar="select *from escolaridad ORDER BY escolaridad.nombre_es";
        objllencomboIngr.llenarcombos(cadenaescolar,JCBEscolaridad,2);
    }

    /**
     * llenarprofesion
     */
    public void llenarprofesion() {
        String cadenaprof;
        cadenaprof="select *from profesionales ORDER BY profesionales.nombre_pro";
        objllencomboIngr.llenarcombos(cadenaprof,JCBProfesion,2);

    }

    /**
     * llenarprofesion
     */
    public void llenarocupacion() {
        String cadenaocup;
        cadenaocup="select *from ocupacion ORDER BY ocupacion.Nbre_Ocupacion";
        objllencomboIngr.llenarcombos(cadenaocup,JCBOcupacion,2);
    }

    /**
     * llenarocupacion
     */
    public void llenareps() {
        String cadenaeps;
        cadenaeps="select *from eps ORDER BY eps.nombre_eps";
        objllencomboIngr.llenarcombos(cadenaeps,JCBEps,2);

    }

    /**
     * llenarips
     */
    public void llenarips() {
        String cadenaips;
        cadenaips="select *from ips ORDER BY ips.nombre_ips";
        objllencomboIngr.llenarcombos(cadenaips,JCBIps,2);
    }

    /**
     * llenarmed
     */
    public void llenarmed() {
        String cadenamed;
        cadenamed="select *from medicos_tratantes ORDER BY medicos_tratantes.nombre_medtrat";
        objllencomboIngr.llenarcombos(cadenamed,JCBMedTrat,2);

    }

    /**
     * llenarte
     */
    public void llenarte() {
        String cadenate;
        cadenate="select *from tipo_examen ORDER BY tipo_examen.nombre_TE";
        objllencomboIngr.llenarcombos(cadenate,JCBTipoEx,2);
    }

    /**
     * llenarempre
     */
    public void llenarempre() {
        String cadenaempr;
        cadenaempr="select *from empresa ORDER BY empresa.nombre_empresa";
        objllencomboIngr.llenarcombos(cadenaempr,JCBEmpresa,2);

    }

    /**
     * llenartipempr
     */
    public void llenartipempr() {
        String cadenatipempr;
        cadenatipempr="select *from tipo_industria ORDER BY tipo_industria.nombre_tindustria";
        objllencomboIngr.llenarcombos(cadenatipempr,JCBTipoEmpr,2);
    }

    /**
     * llenarjornada
     */
    public void llenarjornada() {
        String cadenajor;
        cadenajor="select *from jornada_trabajo ORDER BY jornada_trabajo.nombrejornada_jtrabajo";
        objllencomboIngr.llenarcombos(cadenajor,JCBJornada,2);

    }

    public void JFTFechaNac_focusGained(FocusEvent e) {
        jCalendar1.setVisible(true);
        JFTFechaNac.setVisible(false);
        this.JLBEdad.setVisible(false);
        this.JFTEdad.setVisible(false);
        this.JLBNatural.setVisible(false);
        this.JLBMuniNat.setVisible(false);
        this.JCBMunNat.setVisible(false);
        this.JLBTipoEdad.setVisible(false);
        this.JFTTipoEdad.setVisible(false);
        this.JLBDptoNat.setVisible(false);
        this.JCBDptoNat.setVisible(false);
     }

    public void jCalendar1_mouseReleased(MouseEvent e) {
         //String patron="yyyy-MM-dd";
         String patron="dd/MM/yyyy";
         SimpleDateFormat formato2=new SimpleDateFormat(patron);
         fechanacdate=jCalendar1.getDate();
         sFecha=formato2.format(fechanacdate);
         JFTFechaNac.setText(sFecha);
         jCalendar1.setVisible(false);
         JFTFechaNac.setVisible(true);
         this.JLBEdad.setVisible(true);
         this.JFTEdad.setVisible(true);
         this.JLBNatural.setVisible(true);
         this.JLBMuniNat.setVisible(true);
         this.JCBMunNat.setVisible(true);
         this.JLBTipoEdad.setVisible(true);
         this.JFTTipoEdad.setVisible(true);
         this.JLBDptoNat.setVisible(true);
         this.JCBDptoNat.setVisible(true);
         calcularedad();

    }

    public void jCalendar1_mouseClicked(MouseEvent mouseEvent) {

    }

    public void jCalendar1_mousePressed(MouseEvent mouseEvent) {

    }

    public void jCalendar1_focusLost(FocusEvent focusEvent) {

    }

    /**
     * calcularedad
     */
    public void calcularedad() {
         CalcularEdad objedad=new CalcularEdad();
          double varedad;int varedad2;String tipoedad;
          objllencomboIngr.validarfecha(JFTFechaNac.getText());
          if(objllencomboIngr.swfechavalida==1){
                      //HAY QUE VOLVER A COLOCAR EL FOCO EN LA FECHA DE NAC
                      objllencomboIngr.swfechavalida=0;
          }
          varedad=objedad.fechaentera(JFTFechaNac.getText());
          varedad2=(int)varedad;
          Integer objintedad=new Integer(varedad2);
          String sedad=new String() ;
          sedad=objintedad.toString();
          JFTEdad.setText(sedad);
          JFTEdad.setEditable(false);
          tipoedad=objedad.fechatexto(JFTFechaNac.getText());
          JFTTipoEdad.setText(tipoedad);
          JFTTipoEdad.setEditable(false);

    }

    public void JCBBarrio_focusLost(FocusEvent focusEvent) {
           JFTEstrato.setText("0");
           JFTDirResidencia.requestFocus();
    }

    /**
     * iniciofechaexam
     */
    public void iniciofechaexam() {
        JFTFechaExa.setText(objllencomboIngr.formatofecha());
    }

    public void JCHOtros_actionPerformed(ActionEvent e) {
             JFTOtros.setEditable(true);
             JFTOtros.requestFocus();
    }

    /**
     * llenarnumingreso
     */
    public void llenarnumingreso() {
        String cadsqlnumingreso;int tamconsulta;
         cadsqlnumingreso="select *from ingreso";
         try{
           TSentenciaconsultahc=con2.createStatement();
           Rconsultahc=TSentenciaconsultahc.executeQuery(cadsqlnumingreso);
           Rconsultahc.last();
           tamconsulta=Rconsultahc.getInt(1)+1;
           cadsqlnumingreso=cadsqlnumingreso.valueOf(tamconsulta);
           JFTNumIngr.setText(cadsqlnumingreso);


           }
         catch (Exception ex) {
               objllencomboIngr.mensajeconfirmacion("PROBLEMA BUSCAR NUMERO INGRESO","ERROR GRABAR INGRESO");

         }
       }

    public void JFTNumIngr_focusLost(FocusEvent e) {

    }//fin de JFTNumIngr_focusLost

    /**
     * llenarpanelingreso
     */
    public void llenarpanelingreso(ResultSet Rconsultahc) {
        int codmncpio,codbarr,codmncpioproc;
       String ccingresotipo,cadccsql,cadzona,cadbarrio,cadescolar,sqloesc,fechacad,ultimafecha,cadmedtrat,sqlbarrio,sqlzona,sqlmedtrat,cadmedenv,sqlmedenv,cadeps,sqleps,cadtipoedad,cadempresa,sqlempresa,tipoedadsql,cadsexo,sqlsexo,cadec,sqlec,cadmunic,sqlmunicip,caddpto,sqldpto,cadbarr,sqlbarr,cadocup,sqlocup;
       try{
           Rconsultahc.last();
           JFTNhistoria.setText(Rconsultahc.getString(1));
           JFTNDoc.setText(Rconsultahc.getString(1));
           ccingresotipo=Rconsultahc.getString(2);
           cadccsql="select *from tipodocumento where tipodocumento.Id_TipoDocumento="+"'"+ccingresotipo+"'";
           ccingresotipo= objllencomboIngr.buscarcadena(cadccsql,2);
           Object tipodoc=ccingresotipo;
           JCBTipoDocumento.setSelectedItem(ccingresotipo);
           JFTPrimerApll.setText(Rconsultahc.getString(3));
           JFTSgdoApll.setText(Rconsultahc.getString(4));
           JFTPrimerNbre.setText(Rconsultahc.getString(6));
           JFTSgdoNbre.setText(Rconsultahc.getString(5));
           fechacad=objllencomboIngr.cambiarformatofechaotro(Rconsultahc.getString(7));
           JFTFechaNac.setText(fechacad);
           JFTEdad.setText(Rconsultahc.getString(9));
           cadtipoedad=Rconsultahc.getString(8);
           tipoedadsql="select *from tipoedad where tipoedad.Id_tipoedad="+"'"+cadtipoedad+"'";
           cadtipoedad=objllencomboIngr.buscarcadena(tipoedadsql,2);
           JFTTipoEdad.setText(cadtipoedad);
           cadsexo=Rconsultahc.getString(10);
           sqlsexo="select *from sexo where sexo.Id_Sexo="+"'"+cadsexo+"'";
           cadsexo=objllencomboIngr.buscarcadena(sqlsexo,2);
           Object sexobj=cadsexo;
           JCBSexo.setSelectedItem(sexobj);
           cadec=Rconsultahc.getString(11);
           sqlec="select *from estadocivil where estadocivil.Id_EstadoCivil="+"'"+cadec+"'";
           cadec=objllencomboIngr.buscarcadena(sqlec,2);
           Object ecobj=cadec;
           JCBEstadoCivil.setSelectedItem(ecobj);
           JFTNHijos.setText(Rconsultahc.getString(12));
           codmncpio=Rconsultahc.getInt(13);
           sqlmunicip="select *from municipio where municipio.Id_Municipio="+codmncpio;
           cadmunic=objllencomboIngr.buscarcadena(sqlmunicip,2);
           Object munobj=cadmunic;
           JCBMunNat.setSelectedItem(munobj);
           caddpto=Rconsultahc.getString(14);
           sqldpto="select *from departamento where departamento.Id_Departamento="+"'"+caddpto+"'";
           caddpto=objllencomboIngr.buscarcadena(sqldpto,2);
           Object dptoobj=caddpto;
           JCBDptoNat.setSelectedItem(dptoobj);
           codmncpioproc=Rconsultahc.getInt(15);
           sqlmunicip="select *from municipio where municipio.Id_Municipio="+codmncpioproc;
           cadmunic=objllencomboIngr.buscarcadena(sqlmunicip,2);
           munobj=cadmunic;
           JCBMunProc.setSelectedItem(munobj);
           caddpto=Rconsultahc.getString(16);
           sqldpto="select *from departamento where departamento.Id_Departamento="+"'"+caddpto+"'";
           caddpto=objllencomboIngr.buscarcadena(sqldpto,2);
           dptoobj=caddpto;
           JCBDptoProc.setSelectedItem(dptoobj);
           cadzona=Rconsultahc.getString(17);
           sqlzona="select *from zona where zona.id_zona="+"'"+cadzona+"'";
           cadzona=objllencomboIngr.buscarcadena(sqlzona,2);
           Object zonaobj=cadzona;
           JCBZonRes.setSelectedItem(zonaobj);
           cadbarrio=Rconsultahc.getString(19);
           sqlbarrio="select *from barrio where barrio.Id_Barrio="+"'"+cadbarrio+"'";
           cadbarrio=objllencomboIngr.buscarcadena(sqlbarrio,3);
           Object barrioobj=cadbarrio;
           JCBBarrio.setSelectedItem(barrioobj);
           JFTEstrato.setText(objllencomboIngr.buscarcadena(sqlbarrio,4));
           JFTDirResidencia.setText(Rconsultahc.getString(18));
           JFTTel.setText(Rconsultahc.getString(22));
           cadocup=Rconsultahc.getString(23);
           sqlocup="select *from ocupacion where ocupacion.Id_Ocupacion="+"'"+cadocup+"'";
           cadocup=objllencomboIngr.buscarcadena(sqlocup,2);
           Object ocupobj=cadocup;
           JCBOcupacion.setSelectedItem(ocupobj);
           cadescolar=Rconsultahc.getString(20);
           sqloesc="select *from escolaridad where escolaridad.idescolaridad_es="+"'"+cadescolar+"'";
           cadescolar=objllencomboIngr.buscarcadena(sqloesc,2);
           Object escobj=cadescolar;
           JCBEscolaridad.setSelectedItem(escobj);
           cadescolar=Rconsultahc.getString(21);
           sqloesc="select *from profesionales where profesionales.idpro_pro="+"'"+cadescolar+"'";
           cadescolar=objllencomboIngr.buscarcadena(sqloesc,2);
           escobj=cadescolar;
           JCBProfesion.setSelectedItem(escobj);
           cadeps=Rconsultahc.getString(24);
           sqleps="select *from eps where eps.id_eps="+"'"+cadeps+"'";
           cadeps=objllencomboIngr.buscarcadena(sqleps,2);
           Object epsobj=cadeps;
           JCBEps.setSelectedItem(epsobj);
           cadeps=Rconsultahc.getString(25);
           sqleps="select *from ips where ips.id_ips="+"'"+cadeps+"'";
           cadeps=objllencomboIngr.buscarcadena(sqleps,2);
           epsobj=cadeps;
           JCBIps.setSelectedItem(epsobj);
           cadmedtrat=Rconsultahc.getString(32);
           sqlmedtrat="select *from medicos_tratantes where medicos_tratantes.id_medtrat="+"'"+cadmedtrat+"'";
           cadmedtrat=objllencomboIngr.buscarcadena(sqlmedtrat,2);
           Object mtobj=cadmedtrat;
           JCBMedTrat.setSelectedItem(mtobj);
           cadmedenv=Rconsultahc.getString(26);
           sqlmedenv="select *from tipo_examen where tipo_examen.idtipo_TE="+"'"+cadmedenv+"'";
           cadmedenv=objllencomboIngr.buscarcadena(sqlmedenv,2);
           Object meobj=cadmedenv;
           JCBTipoEx.setSelectedItem(meobj);
           cadempresa=Rconsultahc.getString(29);
           sqlempresa="select *from empresa where empresa.id_empresa="+"'"+cadempresa+"'";
           cadempresa=objllencomboIngr.buscarcadena(sqlempresa,2);
           Object emprobj=cadempresa;
           JCBEmpresa.setSelectedItem(emprobj);
           cadempresa=Rconsultahc.getString(30);
           sqlempresa="select *from tipo_industria where tipo_industria.id_tindustria="+"'"+cadempresa+"'";
           cadempresa=objllencomboIngr.buscarcadena(sqlempresa,2);
           emprobj=cadempresa;
           JCBTipoEmpr.setSelectedItem(emprobj);
           cadempresa=Rconsultahc.getString(31);
           sqlempresa="select *from jornada_trabajo where jornada_trabajo.idjornada_jtrabajo="+"'"+cadempresa+"'";
           cadempresa=objllencomboIngr.buscarcadena(sqlempresa,2);
           emprobj=cadempresa;
           JCBJornada.setSelectedItem(emprobj);
           cadocup=Rconsultahc.getString(33);
           sqlocup="select *from ocupacion where ocupacion.Id_Ocupacion="+"'"+cadocup+"'";
           cadocup=objllencomboIngr.buscarcadena(sqlocup,2);
           ocupobj=cadocup;
           JCBCargo.setSelectedItem(ocupobj);
           JCHGuantes.setSelected(Rconsultahc.getBoolean(35));
           JCHProtcResp.setSelected(Rconsultahc.getBoolean(36));
           JCHAuditiva.setSelected(Rconsultahc.getBoolean(37));
           JCHVisual.setSelected(Rconsultahc.getBoolean(38));
           JCHOtros.setSelected(Rconsultahc.getBoolean(39));
           JFTOtros.setText(Rconsultahc.getString(40));
           JTAObservacion.setText(Rconsultahc.getString(41));
           JTADescrCargo.setText(Rconsultahc.getString(34));
           JFTHoraAtencion.setText(Rconsultahc.getString(42));
           //JBFoto.setIcon(new ImageIcon(new java.net.URL(Rconsultahc.getString(43))));
           JBFoto.setIcon(leerimagen(Rconsultahc.getBytes(43)));
          // if(JBFoto.getIcon()==null)
               //System.out.println("tURKIA");
           JFTCargoAspira.setVisible(false);
           JFTEmpresa.setVisible(false);
           JFTTipEmpr.setVisible(false);
        }
       catch (Exception ex) {
             ex.printStackTrace();
             swimagen=1;
             System.out.println("problema en la consulta"+swimagen);
         }

    }//fin llenarpanelingreso

    /**
     * bloquearingr
     */
    public void bloquearingr() {
        JCBTipoDocumento.setEnabled(true);
        JFTNDoc.setEditable(true);
        JFTNDoc.setEnabled(true);
        JFTPrimerApll.setEditable(true);
        JFTSgdoApll.setEditable(true);
        JFTSgdoNbre.setEditable(true);
        JFTPrimerNbre.setEditable(true);
        JFTFechaNac.setEditable(true);
        JFTFechaNac.setEnabled(true);
        JFTEdad.setEditable(true);
        JFTTipoEdad.setEditable(true);
        JCBSexo.setEnabled(true);
        JCBEstadoCivil.setEnabled(true);
        JCBMunNat.setEnabled(true);
        JCBDptoNat.setEnabled(true);
        JCBMunProc.setEnabled(true);
        JCBDptoProc.setEnabled(true);
        //JCBZonRes.setEnabled(false);
        //JCBBarrio.setEnabled(false);
        JFTEstrato.setEditable(false);
        //JFTDirResidencia.setEditable(false);
        //JFTTel.setEditable(false);
        JCBEscolaridad.setEnabled(true);
        JCBProfesion.setEnabled(true);
        JCBOcupacion.setEnabled(true);
      }

    public void JCBBarrio_keyReleased(KeyEvent e) {
            procesocrear(e,JFTBarrio,JCBBarrio);
    }

    /**
     * procesocrear
     */
    public void procesocrear(KeyEvent e,JFormattedTextField jftvar,JComboBox jcbvar) {
        int c = e.getKeyCode();
       if (c == KeyEvent.VK_ESCAPE) {
           jftvar.setVisible(true);
           jcbvar.setSelectedItem("");
           jcbvar.setVisible(false);
       }
    }

    public void JCBProfesion_keyReleased(KeyEvent e) {
           procesocrear(e,JFTProfesion,JCBProfesion);
    }

    public void JCBOcupacion_actionPerformed(ActionEvent e) {

    }

    public void JCBOcupacion_keyReleased(KeyEvent e) {
         procesocrear(e,JFTOcup,JCBOcupacion);
    }

    public void JCBEps_keyReleased(KeyEvent e) {
        procesocrear(e,JFTEps,JCBEps);
    }

    public void JCBIps_keyReleased(KeyEvent e) {
         procesocrear(e,JFTIps,JCBIps);
    }

    public void JCBCargo_keyReleased(KeyEvent e) {
          procesocrear(e,JFTCargoAspira,JCBCargo);
    }

    public void JTIngreso_keyReleased(KeyEvent e) {
       JDesktopPane JDPIngreso;
       JDPIngreso=(JDesktopPane)ingresoobject;
       int c = e.getKeyCode();
       if (c == KeyEvent.VK_ADD) {
                 this.setVisible(false);
                 CHistoriaOcup frameho=new CHistoriaOcup(obotactualizar,numingredic,swedicioningr,JFTPrimerApll.getText(),JFTSgdoApll.getText(),JFTPrimerNbre.getText(),JFTSgdoNbre.getText(),JFTNDoc.getText(),JDPIngreso,this,objppalig);
                 frameho.setBounds(0, 2, 1010, 600);
                 frameho.setTitle("HISTORIA OCUPACIONAL");
                 JDPIngreso.add(frameho, new Integer(1));
                 frameho.setLocation(5, 55);
                 frameho.show();
                 frameho.JBAtrasAF.setEnabled(true);
        //frameho.inicioventanamotenf(framemotivo);
                 frameho.setVisible(true);
                 frameho.inilizarventanaHO(frameho);
                 if(swedicioningr==1){
                     String cadsqledicHO;int ifila=0;
                     cadsqledicHO="SELECT ingreso.id_ingreso, historiaocupacional.nombempresa_ho, historiaocupacional.fechaini_ho, historiaocupacional.fechafin_ho, historiaocupacional.tiempoempresa_ho, historiaocupacional.cargo_ho, historiaocupacional.factorriesgo_ho, historiaocupacional.elemriesgo_ho, historiaocupacional.tiempoexposicion_ho, historiaocupacional.empresanueva_ho FROM ingreso INNER JOIN historiaocupacional ON ingreso.id_ingreso = historiaocupacional.idingreso_ho WHERE ingreso.id_ingreso="+numingredic;
                     try{
                            TSentenciaconsultahc=con2.createStatement();
                            Rconsultahc=TSentenciaconsultahc.executeQuery(cadsqledicHO);
                            while(Rconsultahc.next()){
                                if(Rconsultahc.getString(2).compareTo("")!=0){
                                  frameho.llenarmodeloHO(ifila,Rconsultahc.getString(2),Rconsultahc.getString(3),Rconsultahc.getString(4),Rconsultahc.getString(5),Rconsultahc.getString(6),Rconsultahc.getString(7),Rconsultahc.getBoolean(10),Rconsultahc.getString(9));
                                  ifila=ifila+1;}
                            }
                     }
                     catch(SQLException e1){

                           cad2="NO SE PUDO EJECUTAR LA CONSULTA";
                           cad1="PROBLEMAS CON LOS DATOS DE HISTORIA OCUPACIONAL EN EDICION";
                           objllencomboIngr.mensajeconfirmacion(cad1,cad2);
                     }//cierra el catch

                    }//fin del if
       }
    }

    public void JFTNHijos_keyReleased(KeyEvent e) {
       //JPDatosDemograficos.requestFocus();

    }

    public void this_keyReleased(KeyEvent e) {

    }

    public void JPIngreso_keyReleased(KeyEvent e) {
          /*  int c = e.getKeyCode();
          if (c == KeyEvent.VK_ADD) {
              JDesktopPane JDPIngreso;
              JDPIngreso=(JDesktopPane)ingresoobject;
              this.setVisible(false);
                    CHistoriaOcup frameho=new CHistoriaOcup(JFTPrimerApll.getText(),JFTSgdoApll.getText(),JFTPrimerNbre.getText(),JFTSgdoNbre.getText(),JFTNDoc.getText(),JDPIngreso,this);
                    frameho.setBounds(0, 2, 1010, 600);
                    frameho.setTitle("HISTORIA OCUPACIONAL");
                    JDPIngreso.add(frameho, new Integer(1));
                    frameho.setLocation(5, 55);
                    frameho.show();
           //frameho.inicioventanamotenf(framemotivo);
                    frameho.setVisible(true);
                    frameho.inilizarventanaHO(frameho);

          }*/

    }

    public void JBAgregar_actionPerformed(ActionEvent e) {
        JBFoto.setEnabled(true);
         fc = new JFileChooser("C:\\SALUD_OCUPACIONAL\\Imagenes\\CAMARA\\Capture");
         //fc = new JFileChooser("C:\\Documents and Settings\\LILIAN\\Mis documentos\\WebCam Media\\Capture");
         int returnVal = fc.showDialog(CIngreso.this,"Ok");
         if (returnVal == JFileChooser.APPROVE_OPTION) {
             File directorio=fc.getSelectedFile();
             String cadenaruta=directorio.toString();
             //Image imagen = Toolkit.getDefaultToolkit().getImage ("file:///C:/SALUD_OCUPACIONAL/Imagenes/rosiris.jpg");
             //JBCancelarAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/MG19.
             try{
                 colocarfoto(cadenaruta);
                 swimagen=1;
                 //System.out.println("yaneth:"+cadenaruta);
             }
             catch (Exception ex) {
                   ex.printStackTrace();
             }


         }
    }

    /**
     * colocarfoto
     */
    public void colocarfoto(String cadenaruta) throws Exception {
        JBFoto.setIcon(new ImageIcon(new java.net.URL("file:///"+cadenaruta)));
    }

    /**
     * leerimagen
     */
    public ImageIcon leerimagen(byte[] i) throws SQLException {
     // ImageIcon m = new ImageIcon();
      imagimpr=i;
      m = new ImageIcon(i);

     // System.out.println("rosiris:"+m);
      return m;
    }

    public void JCBEmpresa_keyReleased(KeyEvent e) {
       procesocrear(e,JFTEmpresa,JCBEmpresa);
    }

    public void JCBTipoEmpr_keyReleased(KeyEvent e) {
      procesocrear(e,JFTTipEmpr,JCBTipoEmpr);
    }
}//.FIN DE LA CLASE


class CIngreso_JCBTipoEmpr_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_JCBTipoEmpr_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JCBTipoEmpr_keyReleased(e);
    }
}


class CIngreso_JCBEmpresa_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_JCBEmpresa_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JCBEmpresa_keyReleased(e);
    }
}


class CIngreso_JBAgregar_actionAdapter implements ActionListener {
    private CIngreso adaptee;
    CIngreso_JBAgregar_actionAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAgregar_actionPerformed(e);
    }
}


class CIngreso_JFTNHijos_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_JFTNHijos_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JFTNHijos_keyReleased(e);
    }
}


class CIngreso_this_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_this_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.this_keyReleased(e);
    }
}


class CIngreso_JPIngreso_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_JPIngreso_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JPIngreso_keyReleased(e);
    }
}


class CIngreso_JTIngreso_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_JTIngreso_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTIngreso_keyReleased(e);
    }
}


class CIngreso_JCBCargo_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_JCBCargo_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JCBCargo_keyReleased(e);
    }
}


class CIngreso_JCBIps_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_JCBIps_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JCBIps_keyReleased(e);
    }
}


class CIngreso_JCBEps_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_JCBEps_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JCBEps_keyReleased(e);
    }
}


class CIngreso_JCBOcupacion_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_JCBOcupacion_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JCBOcupacion_keyReleased(e);
    }
}


class CIngreso_JCBOcupacion_actionAdapter implements ActionListener {
    private CIngreso adaptee;
    CIngreso_JCBOcupacion_actionAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCBOcupacion_actionPerformed(e);
    }
}


class CIngreso_JCBProfesion_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_JCBProfesion_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JCBProfesion_keyReleased(e);
    }
}


class CIngreso_JFTNumIngr_focusAdapter extends FocusAdapter {
    private CIngreso adaptee;
    CIngreso_JFTNumIngr_focusAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void focusLost(FocusEvent e) {
        adaptee.JFTNumIngr_focusLost(e);
    }
}


class CIngreso_JCHOtros_actionAdapter implements ActionListener {
    private CIngreso adaptee;
    CIngreso_JCHOtros_actionAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHOtros_actionPerformed(e);
    }
}


class CIngreso_JCBBarrio_focusAdapter extends FocusAdapter {
    private CIngreso adaptee;
    CIngreso_JCBBarrio_focusAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void focusLost(FocusEvent focusEvent) {
        adaptee.JCBBarrio_focusLost(focusEvent);
    }
}


class CIngreso_JCBBarrio_keyAdapter extends KeyAdapter {
    private CIngreso adaptee;
    CIngreso_JCBBarrio_keyAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JCBBarrio_keyReleased(e);
    }
}


class CIngreso_jCalendar1_mouseAdapter extends MouseAdapter {
    private CIngreso adaptee;
    CIngreso_jCalendar1_mouseAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.jCalendar1_mouseReleased(e);
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        adaptee.jCalendar1_mouseClicked(mouseEvent);
    }

    public void mousePressed(MouseEvent mouseEvent) {
        adaptee.jCalendar1_mousePressed(mouseEvent);
    }
}


class CIngreso_jCalendar1_focusAdapter extends FocusAdapter {
    private CIngreso adaptee;
    CIngreso_jCalendar1_focusAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void focusLost(FocusEvent focusEvent) {
        adaptee.jCalendar1_focusLost(focusEvent);
    }
}


//CIngreso_JFTNDoc_focusAdapter(this)
class CIngreso_JFTNDoc_focusAdapter extends FocusAdapter {
    private CIngreso adaptee;
    CIngreso_JFTNDoc_focusAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void focusLost(FocusEvent e) {
        adaptee.JFTNDoc_focusLost(e);
    }
}//fin de la clase CIngreso_JFTNDoc_focusAdapter
//CIngreso_JFTPrimerApll_actionAdapter(this)
class CIngreso_JFTPrimerApll_actionAdapter implements ActionListener {
    private CIngreso adaptee;
    CIngreso_JFTPrimerApll_actionAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JFTPrimerApll_actionPerformed(e);
    }
}//fin de la clase CIngreso_JFTPrimerApll_actionAdapter
//CIngreso_JFTSgdoApll_actionAdapter implements ActionListener
class CIngreso_JFTSgdoApll_actionAdapter implements ActionListener {
    private CIngreso adaptee;
    CIngreso_JFTSgdoApll_actionAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JFTSgdoApll_actionPerformed(e);
    }
}//fin de de la clase CIngreso_JFTSgdoApll_actionAdapter
//CIngreso_JFTFechaNac_focusAdapter
class CIngreso_JFTFechaNac_focusAdapter extends FocusAdapter {
    private CIngreso adaptee;
    CIngreso_JFTFechaNac_focusAdapter(CIngreso adaptee) {
        this.adaptee = adaptee;
    }

    public void focusLost(FocusEvent e) {
        adaptee.JFTFechaNac_focusLost(e);
    }

    public void focusGained(FocusEvent e) {
        adaptee.JFTFechaNac_focusGained(e);
    }

}
