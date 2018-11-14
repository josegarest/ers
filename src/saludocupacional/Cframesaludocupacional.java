package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

import javax.swing.*;
import java.awt.Font;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2013</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Cframesaludocupacional extends JFrame{
    int swframemedico;
    Object objframemedico= new Object();
    static Object objframeinr= new Object();
    static Object objframeho= new Object();
    static Object objframeep= new Object();
    static Object objframeat= new Object();
    static Object objframeaf= new Object();
    static Object objframeap=new Object();;
    Object objframego= new Object();
    Object objframeiz= new Object();
    Object objframeoa= new Object();
    Object objframers= new Object();
    Object objframeef= new Object();
    Object objframepc= new Object();
    Object objframefin= new Object();
    int swedicion=0;
    ImageIcon m ;
    byte[] imagimpr;
    File file1;
    FileInputStream fis;
    int varbarrio;
    int swingreso;
    int varprofesion;
    int vareps;
    int varempr;
    int vartipempr;
    boolean packFrame = false;
    private JDesktopPane JDPIngreso = new JDesktopPane();
    JOptionPane JDGuardar = new  JOptionPane();
    ValidarComponentes objvalidarGHC=new ValidarComponentes();
    public ConexionSql Cconsql= new ConexionSql();
    public Statement TSentenciaGuardarhc;
    public ResultSet Rverificacodigo;
    String cad1;
    String cad2;
    int swval,swvalfoto;
    //DECLARACION DE OBJETOS VISUALES
       JMenuBar JMSaludocupacional = new JMenuBar();
       JMenu JMProceso = new JMenu();
       JMenu JMConsultas = new JMenu();
       JMenu JMReportes = new JMenu();
       JMenu JMConfiguracion = new JMenu();
       JMenu JMAyuda = new JMenu();
       JMenuItem JMIngreso = new JMenuItem();
       JMenuItem JMUsuario = new JMenuItem();
       JMenuItem jMenu1 = new JMenuItem();
       JMenuItem JMRetiroRep = new JMenuItem();
       JMenuItem JMPeriodico = new JMenuItem();
       JButton JBGuardar = new JButton();
       JButton JBBorrar = new JButton();
       JButton JBNuevo= new JButton();
       JButton JBModificar = new JButton();
       JButton JBActualizar = new JButton();
       JButton JBBuscar = new JButton();
       JPanel JPEstado = new JPanel();
       JPanel JPBotones = new JPanel();
    //DECLARACION DE LA VENTANA DEL INGRESO
       CIngreso frameIngresoUsuario ;
    javax.swing.JMenuItem JMINmuniz = new JMenuItem();
    javax.swing.JMenuItem JMHabit = new JMenuItem();
    javax.swing.JMenuItem JMPatologias = new JMenuItem();
    javax.swing.JMenuItem JMParaclinicos = new JMenuItem();
    javax.swing.JMenu jMenu2 = new JMenu();
    javax.swing.JMenuItem JMImc = new JMenuItem();
    javax.swing.JMenuItem JMLateralidad = new JMenuItem();
    javax.swing.JMenuItem JMTratamiento = new JMenuItem();
    javax.swing.JMenuItem JMReimprimir = new JMenuItem();
    javax.swing.JMenuItem JMEdicion = new JMenuItem();
    JMenu jMenu3 = new JMenu();
    JMenuItem JMEdad = new JMenuItem();
    JMenuItem JMSEXO = new JMenuItem();
    JMenuItem JMECIVIL = new JMenuItem();
    JMenuItem JMEscolaridad = new JMenuItem();
    JMenuItem JMReingreso = new JMenuItem();
    JMenuItem JMIngrOsteomus = new JMenuItem();
    JMenuItem JMIngrAlt = new JMenuItem();
    JMenuItem JMEnfProf = new JMenuItem();
    JMenuItem JMAccTrabajo = new JMenuItem();
    JMenuItem JMRelacion = new JMenuItem(); // javax.swing.JMenuItem JMAptoRestr = new JMenuItem();

    JMenuItem JMHistClinica = new JMenuItem(); // javax.swing.JMenuItem JMAplazado = new JMenuItem();

    JMenuItem JMFactRiesg = new JMenuItem();
    JMenuItem JMAntecFam = new JMenuItem();
    JMenuItem JMCargo = new JMenuItem();
    JMenuItem JMHistoriaOcupacional = new JMenuItem();
    JMenuItem JMGinecologia = new JMenuItem();
    public Cframesaludocupacional() {
        try {
           setDefaultCloseOperation(EXIT_ON_CLOSE);
           jbInit();
           varbarrio=0;
           varprofesion=0;
           vareps=0;
           swingreso=0;
           swframemedico=0;
        }
        catch (Exception exception) {
           exception.printStackTrace();
       }

      }

   //JBINIT
   private void jbInit() throws Exception {
        this.getContentPane().setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
        this.setContentPane(JDPIngreso);
        JDPIngreso.setLayout(null);
       // jMenu2.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        //jMenu2.setText("APTOS");
        jMenu1.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        jMenu1.setText("INGRESO");
        jMenu1.addActionListener(new Cframesaludocupacional_jMenu1_actionAdapter(this));
        JMRetiroRep.addMouseListener(new Cframesaludocupacional_JMRetiroRep_mouseAdapter(this)); //JMIngApto.setBackground(Color.black);
        JMRetiroRep.addActionListener(new Cframesaludocupacional_JMRetiroRep_actionAdapter(this)); //JMIngApto.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMPeriodico.addActionListener(new Cframesaludocupacional_JMPeriodico_actionAdapter(this)); //JMIngApto.setIcon(null);
        JMINmuniz.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMINmuniz.setOpaque(false);
        JMINmuniz.setText("INMUNIZACIONES");
        JMINmuniz.addActionListener(new
                Cframesaludocupacional_JMINmuniz_actionAdapter(this));
        JMHabit.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMHabit.setToolTipText("");
        JMHabit.setText("HABITOS");
        JMHabit.addActionListener(new
                                  Cframesaludocupacional_JMHabit_actionAdapter(this));
        JMPatologias.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMPatologias.setText("PATOLOGIAS");
        JMPatologias.addActionListener(new
                Cframesaludocupacional_JMPatologias_actionAdapter(this));
        JMParaclinicos.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMParaclinicos.setToolTipText("");
        JMParaclinicos.setText("PARACLINICOS");
        JMParaclinicos.addActionListener(new
                Cframesaludocupacional_JMParaclinicos_actionAdapter(this));
        jMenu2.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        jMenu2.setToolTipText("");
        jMenu2.setText("EXAMEN FISICO");
        JMImc.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMImc.setText("IMC");
        JMImc.addActionListener(new Cframesaludocupacional_JMImc_actionAdapter(this));
        JMLateralidad.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMLateralidad.setText("LATERALIDAD");
        JMLateralidad.addActionListener(new
                Cframesaludocupacional_JMLateralidad_actionAdapter(this));
        JMTratamiento.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMTratamiento.setText("TRATAMIENTO");
        JMTratamiento.addActionListener(new
                Cframesaludocupacional_JMTratamiento_actionAdapter(this));
        JMReimprimir.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMReimprimir.setText("REIMPRIMIR");
        JMReimprimir.addActionListener(new
                Cframesaludocupacional_JMReimprimir_actionAdapter(this));
        JMEdicion.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMEdicion.setText("EDICION");
        JMEdicion.addActionListener(new
                Cframesaludocupacional_JMEdicion_actionAdapter(this));
        jMenu3.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        jMenu3.setText("DEMOGRAFICOS");
        JMEdad.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMEdad.setToolTipText("");
        JMEdad.setText("EDAD");
        JMEdad.addActionListener(new
                                 Cframesaludocupacional_JMEdad_actionAdapter(this));
        JMSEXO.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMSEXO.setToolTipText("");
        JMSEXO.setText("SEXO");
        JMSEXO.addActionListener(new
                                 Cframesaludocupacional_JMSEXO_actionAdapter(this));
        JMECIVIL.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMECIVIL.setToolTipText("");
        JMECIVIL.setText("E.CIVIL");
        JMECIVIL.addActionListener(new
                Cframesaludocupacional_JMECIVIL_actionAdapter(this));
        JMEscolaridad.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMEscolaridad.setToolTipText("");
        JMEscolaridad.setText("ESCOLARIDAD");
        JMEscolaridad.addActionListener(new
                Cframesaludocupacional_JMEscolaridad_actionAdapter(this));
        JBBorrar.addMouseListener(new
                                  Cframesaludocupacional_JBBorrar_mouseAdapter(this));
        JMReingreso.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMReingreso.setToolTipText("");
        JMReingreso.setText("REINGRESO");
        JMReingreso.addActionListener(new
                Cframesaludocupacional_JMReingreso_actionAdapter(this));
        JMIngrOsteomus.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMIngrOsteomus.setText("INGRESO OSTEOMUSCULAR");
        JMIngrOsteomus.addActionListener(new
                Cframesaludocupacional_JMIngrOsteomus_actionAdapter(this));
        JMIngrAlt.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMIngrAlt.setText("INGRESO CON ENFASIS EN ALTURA");
        JMIngrAlt.addActionListener(new
                Cframesaludocupacional_JMIngrAlt_actionAdapter(this));
        JMEnfProf.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMEnfProf.setText("ENFERMEDAD PROFESIONAL");
        JMEnfProf.addActionListener(new
                Cframesaludocupacional_JMEnfProf_actionAdapter(this));
        JMAccTrabajo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMAccTrabajo.setText("ACCIDENTES DE TRABAJO");
        JMAccTrabajo.addActionListener(new
                Cframesaludocupacional_JMAccTrabajo_actionAdapter(this));
        JMRelacion.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMRelacion.setToolTipText("");
        JMRelacion.setText("RELACION PACIENTES");
        JMRelacion.addActionListener(new
                Cframesaludocupacional_JMRelacion_actionAdapter(this));
        JMHistClinica.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMHistClinica.setText("HISTORIA CLINICA OCUPACIONAL");
        JMHistClinica.addActionListener(new
                Cframesaludocupacional_JMHistClinica_actionAdapter(this));
        JMFactRiesg.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 11));
        JMFactRiesg.setText("ANTECEDENTES PERSONALES");
        JMFactRiesg.addActionListener(new
                Cframesaludocupacional_JMFactRiesg_actionAdapter(this));
        JMAntecFam.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 11));
        JMAntecFam.setText("ANTECEDENTES FAMILIARES");
        JMAntecFam.addActionListener(new
                Cframesaludocupacional_JMAntecFam_actionAdapter(this));
        JMCargo.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 11));
        JMCargo.setToolTipText("");
        JMCargo.setText("CARGO");
        JMCargo.addActionListener(new
                                  Cframesaludocupacional_JMCargo_actionAdapter(this));
        JMHistoriaOcupacional.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMHistoriaOcupacional.setToolTipText("");
        JMHistoriaOcupacional.setText("HISTORIA OCUPACIONAL");
        JMHistoriaOcupacional.addActionListener(new
                Cframesaludocupacional_JMHistoriaOcupacional_actionAdapter(this));
        JMGinecologia.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMGinecologia.setText("GINECOLOGIA");
        JMGinecologia.addActionListener(new
                Cframesaludocupacional_JMGinecologia_actionAdapter(this));
        JDPIngreso.add(JPBotones);
        JDPIngreso.add(JPEstado);
        JDPIngreso.setFont(new java.awt.Font("Arial Black",Font.BOLD | Font.ITALIC, 12));
        JDPIngreso.setForeground(SystemColor.inactiveCaptionText);
        JDPIngreso.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        //TODO LO RELACIONADO CON EL MENU PRINCIPAL
        this.setJMenuBar(JMSaludocupacional);
        setSize(new Dimension(1025, 760));
        setTitle("SALUD OCUPACIONAL");
        JMSaludocupacional.setBackground(new Color(212, 207, 255));
        JMSaludocupacional.setFont(new java.awt.Font("Arial", Font.BOLD, 10));
        JMSaludocupacional.setBorder(BorderFactory.createRaisedBevelBorder());
        JMSaludocupacional.setMargin(new Insets(2, 2, 2, 2));
        //JMPROCESO
        JMProceso.setBackground(new Color(212, 207, 255));
        JMProceso.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JMProceso.setMnemonic('P');
        JMProceso.setText("Admisiones");
        //JMCONSULTAS
        JMConsultas.setBackground(new Color(212, 207, 255));
        JMConsultas.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JMConsultas.setMnemonic('C');
        JMConsultas.setText("Consultas");
        //JMREPORTES
        JMReportes.setBackground(new Color(212, 207, 255));
        JMReportes.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JMReportes.setMnemonic('R');
        JMReportes.setText("Reportes");
        //JMCONFIGURACION
        JMConfiguracion.setBackground(new Color(212, 207, 255));
        JMConfiguracion.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JMConfiguracion.setMnemonic('U');
        JMConfiguracion.setText("Configuracion");
        //JMAyuda
        JMAyuda.setBackground(new Color(212, 207, 255));
        JMAyuda.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JMAyuda.setMnemonic('Y');
        JMAyuda.setText("Ayuda");
        //JPESTADO
        JPEstado.setBackground(new Color(146, 168, 255));
        JPEstado.setBorder(BorderFactory.createLineBorder(Color.black));
        JPEstado.setToolTipText("Barra de Estado");
        JPEstado.setBounds(new Rectangle(0, 653, 1020, 28));
        JPEstado.setLayout(null);
        //JPBotones
        JPBotones.setBorder(BorderFactory.createRaisedBevelBorder());
        JPBotones.setBounds(new Rectangle(1, 0, 1022, 59));
        JPBotones.setLayout(null);
        //JMSaludocupacional
        JMSaludocupacional.add(JMProceso);
        JMSaludocupacional.add(JMConsultas);
        JMConsultas.addSeparator();
        JMConsultas.add(JMEdicion);
        JMSaludocupacional.add(JMReportes);
        JMSaludocupacional.add(JMConfiguracion);
        JMSaludocupacional.add(JMAyuda);
        //
        //JBNUEVO
        JBNuevo.setBackground(Color.black);
        JBNuevo.setBounds(new Rectangle(1, 2, 52, 54));
        JBNuevo.setBorder(null);
        JBNuevo.setToolTipText("Nuevo Registro");
        JBNuevo.setIcon(new ImageIcon(new java.net.URL("file:///c:/SALUD_OCUPACIONAL/Imagenes/Nuevo-.jpg")));
        JBNuevo.setSelectedIcon(null);
        JBNuevo.addActionListener(new Cframesaludocupacional_JBNuevo_actionAdapter(this));
        //JBGuardar
        JBGuardar.setBackground(Color.black);
        JBGuardar.setBounds(new Rectangle(52, 2, 52, 54));
        JBGuardar.setBorder(null);
        JBGuardar.setToolTipText("Guardar Un Registro");
        JBGuardar.setIcon(new ImageIcon(new java.net.URL("file:///c:/SALUD_OCUPACIONAL/Imagenes/Guardar.jpg")));
        JBGuardar.setSelectedIcon(null);
        JBGuardar.addActionListener(new Cframesaludocupacional_JBGuardar_actionAdapter(this));
        //JBBorrar
        JBBorrar.setBackground(Color.black);
        JBBorrar.setBounds(new Rectangle(103, 2, 52, 54));
        JBBorrar.setBorder(null);
        JBBorrar.setToolTipText("Borrar Un Registro");
        JBBorrar.setIcon(new ImageIcon(new java.net.URL("file:///c:/SALUD_OCUPACIONAL/Imagenes/Eliminar.jpg")));
        JBBorrar.setSelectedIcon(null);
        JBBorrar.addActionListener(new Cframesaludocupacional_JBBorrar_actionAdapter(this));
        //JBModificar
        JBModificar.setBackground(Color.black);
        JBModificar.setBounds(new Rectangle(154, 2, 52, 54));
        JBModificar.setBorder(null);
        JBModificar.setToolTipText("Editar Un Registro");
        JBModificar.setIcon(new ImageIcon(new java.net.URL("file:///c:/SALUD_OCUPACIONAL/Imagenes/Modificar7.jpg")));
        JBModificar.setSelectedIcon(null);
        JBModificar.addActionListener(new Cframesaludocupacional_JBModificar_actionAdapter(this));
        //JBActualizar
        JBActualizar.setBackground(Color.black);
        JBActualizar.setBounds(new Rectangle(205, 2, 52, 54));
        JBActualizar.setBorder(null);
        JBActualizar.setToolTipText("Actualizar Un Registro");
        JBActualizar.setIcon(new ImageIcon(new java.net.URL("file:///c:/SALUD_OCUPACIONAL/Imagenes/ChangeStore-.jpg")));
        JBActualizar.setSelectedIcon(null);
        JBActualizar.addActionListener(new Cframesaludocupacional_JBActualizar_actionAdapter(this));
        //JMIngreso
        JMIngreso.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMIngreso.setMnemonic('G');
        JMIngreso.setText("INGRESO");
        JMIngreso.addActionListener(new Cframesaludocupacional_JMIngreso_actionAdapter(this));
        //JMUsuario
        JMUsuario.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMUsuario.setMnemonic('U');
        JMUsuario.setText("MEDICO");
        JMUsuario.addActionListener(new Cframesaludocupacional_JMUsuario_actionAdapter(this)); //JMRetiroRep
        JMRetiroRep.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMRetiroRep.setMnemonic('S');
        JMRetiroRep.setText("RETIRO"); //JMPeriodico
        JMPeriodico.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JMPeriodico.setMnemonic('S');
        JMPeriodico.setText("PERIODICO"); //ADICCIONAR A LA BARRA DE HERRAMIENTAS
        JPBotones.add(JBNuevo);
        JPBotones.add(JBGuardar);
        JPBotones.add(JBBorrar);
        JPBotones.add(JBModificar);
        JPBotones.add(JBActualizar);
        //ADICCIONAR A LOS MENUS
        JMProceso.add(JMIngreso);
        JMProceso.add(JMUsuario);
        JMReportes.add(jMenu1);
        JMReportes.add(JMRetiroRep);
        JMReportes.add(JMPeriodico);
        JMReportes.add(JMReingreso);
        JMReportes.add(JMIngrOsteomus);
        JMReportes.add(JMIngrAlt);
        JMReportes.addSeparator();
        JMReportes.add(jMenu3);
        JMReportes.add(JMHistoriaOcupacional);
        JMReportes.add(JMAntecFam);
        JMReportes.add(JMFactRiesg);
        JMReportes.add(JMAccTrabajo);
        JMReportes.add(JMEnfProf);
        JMReportes.add(JMGinecologia);
        JMReportes.add(JMINmuniz);
        JMReportes.add(JMHabit);
        JMReportes.add(JMParaclinicos);
        JMReportes.add(JMPatologias); //jMenu1.add(JMIngApto);
        JMReportes.add(jMenu2); //jMenu1.add(JMAptoRestr);
        JMReportes.add(JMTratamiento);
        JMReportes.addSeparator();
        JMReportes.add(JMReimprimir);
        JMReportes.add(JMRelacion);
        JMReportes.add(JMHistClinica);
        jMenu2.add(JMImc); //jMenu1.add(JMAplazado);
        jMenu2.add(JMLateralidad);
        jMenu3.add(JMEdad);
        jMenu3.add(JMSEXO);
        jMenu3.add(JMECIVIL);
        jMenu3.add(JMEscolaridad);
        jMenu3.add(JMCargo);
        InputStream is = null;
        JBActualizar.setEnabled(false);
        JBGuardar.setEnabled(false);
        JBBorrar.setEnabled(false);
        JBModificar.setEnabled(false);
    }
   //MAIN
    public static void main(String[] args) {
        try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             // UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
             // UIManager.setLookAndFeel(new com.sun.java.swing.plaf.motif.MotifLookAndFeel());
             // UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
         } catch (Exception e) {
         }
         Cframesaludocupacional ppaljframe = new  Cframesaludocupacional();
         //Objframeppal=ppaljframe;
//      ppaljframe.getMaximumSize();
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         Dimension desktopSize = ppaljframe.getSize();
         if (desktopSize.height > screenSize.height)
             desktopSize.height = screenSize.height;
         if (desktopSize.width > screenSize.width)
             desktopSize.width = screenSize.width;
         ppaljframe.setLocation((screenSize.width - desktopSize.width) / 2,(screenSize.height - desktopSize.height) / 2);
         ppaljframe.setVisible(true);
         //objppal= ppaljframe;

    }//fin del void main
    //Metodo JBNuevo_actionPerformed
    public void JBNuevo_actionPerformed(ActionEvent e) {
        frameIngresoUsuario= new  CIngreso("1",swedicion,JBGuardar,JBNuevo,JBModificar,JBActualizar,JBBorrar,JDPIngreso,null);
        frameIngresoUsuario.setBounds(0, 2, 1010, 600);
        frameIngresoUsuario.setTitle("INGRESO");
        JDPIngreso.add(frameIngresoUsuario, new Integer(1));
        frameIngresoUsuario.setLocation(5, 55);
        frameIngresoUsuario.show();
        //frameIngresoUsuario.inicioventana(frameIngresoUsuario);
        frameIngresoUsuario.setVisible(true);
        JBNuevo.setEnabled(false);
        JBModificar.setEnabled(false);
        JBActualizar.setEnabled(false);
        JBBorrar.setEnabled(false);
    }//fin de JBNuevo
    public void JBGuardar_actionPerformed(ActionEvent e) {
            int gvdatosusuarios,gvingreso;
            String titulo="FICHA CLINICA";
            String mensaje = "SI";
            String mensaje1 = "NO";
            Object[] option = {mensaje, mensaje1};
            Connection con2=Cconsql.getConnection();
            validarnulos(frameIngresoUsuario);
           // System.out.println("lili:"+swval);
            validarfoto(frameIngresoUsuario);
          //  System.out.println("NI�O:"+swval);
            if(swval==0 && swvalfoto==0){
                int n = JDGuardar.showOptionDialog(this,"ESTA SEGURO DE GUARDAR?","GUARDAR " + titulo,JDGuardar.YES_NO_OPTION,JDGuardar.QUESTION_MESSAGE, null,option, mensaje);
             if (n == 0) {
                 try {
                      con2.setAutoCommit(false);
                      gvdatosusuarios=guardardatosusuarios(frameIngresoUsuario);
                      gvingreso=guardaringreso(frameIngresoUsuario);
                      if(gvdatosusuarios==1 && gvingreso==1){
                          con2.commit();
                          con2.setAutoCommit(true);
                          objvalidarGHC.mensajeconfirmacion("LA FICHA CLINICA SE GRABO CON EXITO","FICHA CLINICA");
                          JBGuardar.setEnabled(false);
                      }
                 }//cierra el try
                 catch (SQLException e1) {
                       objvalidarGHC.mensajeconfirmacion("NO SE GRABO NINGUN DATO DEL PACIENTE","ERROR GRABAR USUARIO");
                   }//cierra el catch
             }//fin del if
             Cconsql.CerrarConexion();
             if(swingreso==0){
                 frameIngresoUsuario.setVisible(false);
                 abrirhistoriaocupacional(frameIngresoUsuario);
             }
             else{//frameIngresoUsuario.setVisible(false);
                 frameIngresoUsuario.dispose();
                 swingreso=0;
                 //System.out.println("RICARDO:"+frameIngresoUsuario.JFTNDoc.getText());
             }
            }//FIN DEL SW

    }// fin de JBGuardar
    public void JBBorrar_actionPerformed(ActionEvent e) {

    }// fin de JBBorrar
    public void JBModificar_actionPerformed(ActionEvent e) {

    }// fin de JBModificar
    public void JBActualizar_actionPerformed(ActionEvent e) {
           int aadatosusuarios,gaingreso,aho,aep,aat,aaf,aap,aog,aiz,aoa,ars,aef,apc,afin;
           String titulo="FICHA CLINICA";
           String mensaje = "SI";
           String mensaje1 = "NO";
           Object[] option = {mensaje, mensaje1};
           Connection con2=Cconsql.getConnection();
           if(swedicion==1){
                CIngreso frameIngresoUsuario=new CIngreso(null);
                CHistoriaOcup framehistocup=new CHistoriaOcup();
                CEnfermedadProf frameenfermedadprof= new CEnfermedadProf();
                CHistoriaAcciTrab frameaccitrabajo=new CHistoriaAcciTrab();
                CAntecedentesFamiliar frameantecendnetesfam=new CAntecedentesFamiliar();
                CAntecedentesPersonales frameantecpersonal=new CAntecedentesPersonales();
                CAGineco frameginecologia=new CAGineco();
                CInmuniz frameinmunuz=new CInmuniz();
                COtrosAnt frameotrosantecedentes=new COtrosAnt();
                CRevisionSistemas framerevisioonsistemas=new CRevisionSistemas();
                CExamenFisico frameexamfisico=new CExamenFisico();
                CExamPraclin frameep=new CExamPraclin();
                CResOcupacional framefin= new CResOcupacional();
                frameIngresoUsuario=(CIngreso)objframeinr;
                framehistocup=(CHistoriaOcup)objframeho;
                frameenfermedadprof=(CEnfermedadProf)objframeep;
                frameaccitrabajo=(CHistoriaAcciTrab)objframeat;
                frameantecendnetesfam=(CAntecedentesFamiliar)objframeaf;
                frameantecpersonal=(CAntecedentesPersonales)objframeap;
                frameginecologia=(CAGineco)objframego;
                frameinmunuz=(CInmuniz)objframeiz;
                frameotrosantecedentes=(COtrosAnt)objframeoa;
                framerevisioonsistemas=(CRevisionSistemas)objframers;
                frameexamfisico=(CExamenFisico)objframeef;
                frameep=(CExamPraclin)objframepc;
                framefin=(CResOcupacional)objframefin;
                int n = JDGuardar.showOptionDialog(this,"ESTA SEGURO DE ACTUALIZAR?","ACTUALIZAR " + titulo,JDGuardar.YES_NO_OPTION,JDGuardar.QUESTION_MESSAGE, null,option, mensaje);
                if (n == 0) {
                    try {
                      con2.setAutoCommit(false);
                      aadatosusuarios=actualizardatosusuarios(frameIngresoUsuario);
                      gaingreso=actualizaringreso(frameIngresoUsuario);
                      aho=actualizarho(framehistocup);
                      aep=actualizarep(frameenfermedadprof);
                      aat=actualizarat(frameaccitrabajo);
                      aaf=actualizaraf(frameantecendnetesfam);
                      aap=actualizarap(frameantecpersonal);
                      aog=actualizarog(frameginecologia);
                      aiz=actualizariz(frameinmunuz);
                      aoa=actualizaroa(frameotrosantecedentes);
                      ars=actualizarrs(framerevisioonsistemas);
                      aef=actualizaref(frameexamfisico);
                      apc=actualizarpc(frameep);
                      afin=actualizarfin(framefin,frameep.numingredicFIN);
                      System.out.println("dvr:"+aho);
                      if(aadatosusuarios==1 && gaingreso==1 && aho==1 && aep==1 && aat==1 && aaf==1 && aap==1 && aog==1 && aiz==1 && aoa==1 && ars==1 && aef==1 && apc==1 && afin==1){
                          con2.commit();
                          con2.setAutoCommit(true);
                          objvalidarGHC.mensajeconfirmacion("LA FICHA CLINICA SE ACTUALIZO CON EXITO","FICHA CLINICA");
                      }

                    }//fin del try
                    catch (SQLException e1) {

                      objvalidarGHC.mensajeconfirmacion("NO SE ACTUALIZO NINGUN DATO DEL PACIENTE EDICION","ERROR ACTUALIZAR USUARIO");
                    }//cierra el catch

                }//FIN if n==0
                Cconsql.CerrarConexion();
                JBActualizar.setEnabled(false);
                frameIngresoUsuario.dispose();
                framehistocup.dispose();
                frameenfermedadprof.dispose();
                frameaccitrabajo.dispose();
                frameantecendnetesfam.dispose();
                frameantecpersonal.dispose();
                frameginecologia.dispose();
                frameinmunuz.dispose();
                frameotrosantecedentes.dispose();
                framerevisioonsistemas.dispose();
                framerevisioonsistemas.dispose();
                frameexamfisico.dispose();
                frameep.dispose();
                framefin.dispose();
           }//fin del if swedicion==1
           else{
                validarnulos(frameIngresoUsuario);
                validarfoto(frameIngresoUsuario);
                if(swval==0){
                    int n = JDGuardar.showOptionDialog(this,"ESTA SEGURO DE ACTUALIZAR?","ACTUALIZAR " + titulo,JDGuardar.YES_NO_OPTION,JDGuardar.QUESTION_MESSAGE, null,option, mensaje);
                    if (n == 0) {
                     try {
                        con2.setAutoCommit(false);
                        aadatosusuarios=actualizardatosusuarios(frameIngresoUsuario);
                        gaingreso=guardaringreso(frameIngresoUsuario);
                        System.out.println("PICON:");
                        if(aadatosusuarios==1 && gaingreso==1){
                          con2.commit();
                          con2.setAutoCommit(true);
                          objvalidarGHC.mensajeconfirmacion("LA FICHA CLINICA SE ACTUALIZO CON EXITO","FICHA CLINICA");
                         }
                      }//fin del try
                      catch (SQLException e1) {
                         objvalidarGHC.mensajeconfirmacion("NO SE ACTUALIZO NINGUN DATO DEL PACIENTE","ERROR ACTUALIZAR USUARIO");
                       }//cierra el catch
                      }//FIN if n==0
                    Cconsql.CerrarConexion();
                    JBActualizar.setEnabled(false);
                    frameIngresoUsuario.dispose();
                }//if(swval==0)
             }//fin del else swedicion


   }
   public void JMIngreso_actionPerformed(ActionEvent e) {
       frameIngresoUsuario= new  CIngreso("1",swedicion,JBGuardar,JBNuevo,JBModificar,JBActualizar,JBBorrar,JDPIngreso,null);
       frameIngresoUsuario.setBounds(0, 2, 1010, 600);
       frameIngresoUsuario.setTitle("INGRESO");
       JDPIngreso.add(frameIngresoUsuario, new Integer(1));
       frameIngresoUsuario.setLocation(5, 55);
       frameIngresoUsuario.show();
   //frameIngresoUsuario.inicioventana(frameIngresoUsuario);
       frameIngresoUsuario.setVisible(true);
       JBNuevo.setEnabled(false);
       JBModificar.setEnabled(false);
       JBActualizar.setEnabled(false);
       JBBorrar.setEnabled(false);
       JBGuardar.setEnabled(true);
       swingreso=1;
   }// fin de JMAdmon
   public void JMUsuario_actionPerformed(ActionEvent e) {
       CFrameMedico framemedico=new CFrameMedico(JDPIngreso);
       framemedico.setBounds(0, 2, 1010, 600);
       framemedico.setTitle("CLIENTE MEDICO");
      //JDPpanelpal.add(framecrearentrada, new Integer(1));
       JDPIngreso.add(framemedico, new Integer(1));
       framemedico.setLocation(5, 55);;
       framemedico.show();
       JBBorrar.setEnabled(true);
       swframemedico=1;
       objframemedico=framemedico;
   }// fin de JMUsuario

    /**
     * guardardatosusuarios
     */
    public int guardardatosusuarios(CIngreso gingresoPM)throws SQLException {
        Connection con2=Cconsql.getConnection();
        int vardatosusuarios=0;
        int varbarrio=0;
        int tipedadhc,estadocivhc,barriohc,ocupacionhc;
        String carsexohc,cadestadocivil,cadmunicipionat,municipionathc,municipioprochc,cadmunicipioproc,cadescolaridad,cadprofesion,cadeps,cadips,dptonathc,zonahc,dptoprochc,escolarhc,profesionhc,epshc,ipshc,caddptonat,caddptoproc,cadzona,cadbarrio,cadocupacion;
        String edadtipocad,cadsexosql,sqlestadocivil,sqlmunicipionat,sqlmunicipioproc,sqldptonat,sqldptoproc,sqlzona,sqlbarrio,sqlocupacion,sqlescolar,sqlprofesion,sqleps,sqlips;
        profesionhc="";
        String cadtipoedad;
        String fechanaccad;
        String cadsexo;
        String cadsqlhc;
        String tipodoccad=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBTipoDocumento);
        String cadtipodoc="select *from tipodocumento where tipodocumento.Nbre_TipoDocumento="+"'"+tipodoccad+"'";
        String doctipo=objvalidarGHC.buscarcadena(cadtipodoc,1);
        fechanaccad=objvalidarGHC.cambiarformatofecha(gingresoPM.JFTFechaNac.getText());
        edadtipocad=gingresoPM.JFTTipoEdad.getText();
        cadtipoedad="select *from tipoedad where tipoedad.Nbre_tipoedad="+"'"+edadtipocad+"'";
        tipedadhc=objvalidarGHC.evaluarcadenaentera(cadtipoedad);
        cadsexo=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBSexo);
        cadsexosql="select *from sexo where sexo.Nbre_Sexo="+"'"+cadsexo+"'";
        carsexohc=objvalidarGHC.buscarcadena(cadsexosql,1);
        cadestadocivil=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBEstadoCivil);
        sqlestadocivil="select *from estadocivil where estadocivil.Nbre_EstadoCivil="+"'"+cadestadocivil+"'";
        estadocivhc=objvalidarGHC.evaluarcadenaentera(sqlestadocivil);
        cadmunicipionat=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBMunNat);
        sqlmunicipionat="select *from municipio where municipio.Nbre_Municipio="+"'"+cadmunicipionat+"'";
        municipionathc=objvalidarGHC.buscarcadena(sqlmunicipionat,1);
        caddptonat=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBDptoNat);
        sqldptonat="select *from departamento where departamento.Nbre_Departamento="+"'"+caddptonat+"'";
        dptonathc=objvalidarGHC.buscarcadena(sqldptonat,1);
        cadmunicipioproc=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBMunProc);
        sqlmunicipioproc="select *from municipio where municipio.Nbre_Municipio="+"'"+cadmunicipioproc+"'";
        municipioprochc=objvalidarGHC.buscarcadena(sqlmunicipioproc,1);
        caddptoproc=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBDptoProc);
        sqldptoproc="select *from departamento where departamento.Nbre_Departamento="+"'"+caddptoproc+"'";
        dptoprochc=objvalidarGHC.buscarcadena(sqldptoproc,1);
        cadzona=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBZonRes);
        sqlzona="select *from zona where zona.nombre_zona="+"'"+cadzona+"'";
        zonahc=objvalidarGHC.buscarcadena(sqlzona,1);
        if(objvalidarGHC.validarcombonulo(gingresoPM.JCBBarrio) ==0){
            cadbarrio=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBBarrio);
            sqlbarrio="select *from barrio where barrio.Nbre_Barrio="+"'"+cadbarrio+"'";
            barriohc=objvalidarGHC.evaluarcadenaentera(sqlbarrio);
        }
        else{guardarbarrio(gingresoPM.JFTBarrio.getText());
            sqlbarrio="select *from barrio where barrio.Nbre_Barrio="+"'"+gingresoPM.JFTBarrio.getText()+"'";
            barriohc=objvalidarGHC.evaluarcadenaentera(sqlbarrio);

        }
        cadescolaridad=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBEscolaridad);
        sqlescolar="select *from escolaridad where escolaridad.nombre_es="+"'"+cadescolaridad+"'";
        escolarhc=objvalidarGHC.buscarcadena(sqlescolar,1);
        if(objvalidarGHC.validarcombonulo(gingresoPM.JCBProfesion) ==0) { //&& gingresoPM.JFTProfesion.getText().compareTo("")==1)
            cadprofesion=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBProfesion);
            sqlprofesion="select *from profesionales where profesionales.nombre_pro="+"'"+cadprofesion+"'";
            profesionhc=objvalidarGHC.buscarcadena(sqlprofesion,1);
        }
        else{if(gingresoPM.JFTProfesion.getText().compareTo("")!=0){
                    guardarprofesion(gingresoPM.JFTProfesion.getText());
                    sqlprofesion="select *from profesionales where profesionales.nombre_pro="+"'"+gingresoPM.JFTProfesion.getText()+"'";
                    System.out.println("PROFESION:"+sqlprofesion);
                    profesionhc=objvalidarGHC.buscarcadena(sqlprofesion,1);
             }//fin del if
            // else
        }//FIN ELSE
        if(objvalidarGHC.validarcombonulo(gingresoPM.JCBOcupacion) ==1) {
            cadocupacion=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBOcupacion);
            sqlocupacion="select *from ocupacion where ocupacion.Nbre_Ocupacion="+"'"+cadocupacion+"'";
            ocupacionhc=objvalidarGHC.evaluarcadenaentera(sqlocupacion);
        }
        else{guardarocupacion(gingresoPM.JFTOcup.getText());
            sqlocupacion="select *from ocupacion where ocupacion.Nbre_Ocupacion="+"'"+gingresoPM.JFTOcup.getText()+"'";
            //System.out.println("OCUPACION:"+sqlocupacion);
            ocupacionhc=objvalidarGHC.evaluarcadenaentera(sqlocupacion);
        }
        if(objvalidarGHC.validarcombonulo(gingresoPM.JCBEps) ==0) {
            cadeps=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBEps);
            sqleps="select *from eps where eps.nombre_eps="+"'"+cadeps+"'";
            epshc=objvalidarGHC.buscarcadena(sqleps,1);
        }
        else{guardareps(gingresoPM.JFTEps.getText());
            sqleps="select *from eps where eps.nombre_eps="+"'"+gingresoPM.JFTEps.getText()+"'";
            //System.out.println("EPS:"+sqleps);
            epshc=objvalidarGHC.buscarcadena(sqleps,1);
        }
        if(objvalidarGHC.validarcombonulo(gingresoPM.JCBIps) ==0) {
            cadips=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBIps);
            sqlips="select *from ips where ips.nombre_ips="+"'"+cadips+"'";
            ipshc=objvalidarGHC.buscarcadena(sqlips,1);
        }
        else{guardarips(gingresoPM.JFTIps.getText());
            sqlips="select *from ips where ips.nombre_ips="+"'"+gingresoPM.JFTIps.getText()+"'";
            ipshc=objvalidarGHC.buscarcadena(sqlips,1);
        }
        // Icon sicin=gingresoPM.JBFoto.getIcon();

        try{
           procesograbarimagen(gingresoPM.JBFoto.getIcon());
           //cadsqlhc="insert into datosusuarios (NoHC_du,IdDocumentodeIdentificaci�n_du,Documento_du,PrimerApellido_du,SegundoApellido_du,PrimerNombre_du,SegundoNombre_du,FechadeNacimiento_du,idtipoedad_du,edad_du,IdSexo_du,IdEstadoCivi_du,NumHijos_du,IdMunicipionatural,IdDepartamentonatural_du,IdMunicipioprocedente_du,IdDepartamentoprocedente_du,idzonares_du,DireccionResidencia_du,Barrio_du,idtipoescolaridad_du,profesion_du,TelefonoCelular_du,idocupacion_du,ideps_du,idips_du,foto_du) values ("  + "'"+gingresoPM.JFTNhistoria.getText()+"'"+",'"+gingresoPM.JFTNDoc.getText() + "'" +",'"+doctipo+"'"+",'"+gingresoPM.JFTPrimerApll.getText()+"'"+",'"+gingresoPM.JFTSgdoApll.getText()+"'"+",'"+gingresoPM.JFTSgdoNbre.getText()+"','"+gingresoPM.JFTPrimerNbre.getText()+"'"+",'"+fechanaccad+"'" + "," + tipedadhc +  "," + gingresoPM.JFTEdad.getText() + ",'"+carsexohc+"'," +estadocivhc+",'"+gingresoPM.JFTNHijos.getText()+"',"+municipionathc+"," +dptonathc+","+municipioprochc+","+dptoprochc+","+zonahc+",'"+gingresoPM.JFTDirResidencia.getText()+"'"+","+barriohc+","+escolarhc+","+profesionhc+",'"+gingresoPM.JFTTel.getText()+"',"+ocupacionhc+","+epshc+","+ipshc+","+fis+ ")";
           //cadsqlhc="insert into datosusuarios  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           cadsqlhc="insert into datosusuarios (NoHC_du,IdDocumentodeIdentificaci�n_du,Documento_du,PrimerApellido_du,SegundoApellido_du,PrimerNombre_du,SegundoNombre_du,FechadeNacimiento_du,idtipoedad_du,edad_du,IdSexo_du,IdEstadoCivi_du,NumHijos_du,IdMunicipionatural,IdDepartamentonatural_du,IdMunicipioprocedente_du,IdDepartamentoprocedente_du,idzonares_du,DireccionResidencia_du,Barrio_du,idtipoescolaridad_du,profesion_du,TelefonoCelular_du,idocupacion_du,ideps_du,idips_du,foto_du)  values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           //TSentenciaGuardarhc=con2.createStatement();
           PreparedStatement stmt = con2.prepareStatement(cadsqlhc);
           stmt.setString(1,gingresoPM.JFTNhistoria.getText());
           stmt.setString(2,gingresoPM.JFTNDoc.getText());
           stmt.setString(3,doctipo);
           stmt.setString(4,gingresoPM.JFTPrimerApll.getText());
           stmt.setString(5,gingresoPM.JFTSgdoApll.getText());
           stmt.setString(6,gingresoPM.JFTSgdoNbre.getText());
           stmt.setString(7,gingresoPM.JFTPrimerNbre.getText());
           stmt.setString(8,fechanaccad);
           stmt.setInt(9,tipedadhc);
           stmt.setString(10,gingresoPM.JFTEdad.getText());
           stmt.setString(11,carsexohc);
           stmt.setInt(12,estadocivhc);
           stmt.setString(13,gingresoPM.JFTNHijos.getText());
           stmt.setString(14,municipionathc);
           stmt.setString(15,dptonathc);
           stmt.setString(16,municipioprochc);
           stmt.setString(17,dptoprochc);
           stmt.setString(18,zonahc);
           stmt.setString(19,gingresoPM.JFTDirResidencia.getText());
           stmt.setInt(20,barriohc);
           stmt.setString(21,escolarhc);
           stmt.setString(22,profesionhc);
           stmt.setString(23,gingresoPM.JFTTel.getText());
           stmt.setInt(24,ocupacionhc);
           stmt.setString(25,epshc);
           stmt.setString(26,ipshc);
           stmt.setBinaryStream(27, fis, (int) file1.length());
           vardatosusuarios = stmt.executeUpdate();
           //vardatosusuarios=TSentenciaGuardarhc.executeUpdate(cadsqlhc);
        }//cierra el try
        catch(SQLException e){
              //e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR LOS DATOS DE USUARIO";
              cad2="TABLA DATOS DE USUARIO";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
         Cconsql.CerrarConexion();
         //gingresoPM.dispose();
         //System.out.println("ALCALDE:"+gingresoPM.JFTNDoc.getText());
         //gingresoPM.setVisible(true);
         return vardatosusuarios;
    }

    /**
     * guardarocupacion
     */
    public void guardarocupacion(String cadocupacion) throws SQLException {
        Connection con2=Cconsql.getConnection();
        String cadocupql;
        cadocupql="insert into ocupacion (Nbre_Ocupacion) values ('"+cadocupacion + "'" + ")";
        try{
            //Connection con2=Cconsql.getConnection();
           TSentenciaGuardarhc=con2.createStatement();
           varbarrio=TSentenciaGuardarhc.executeUpdate(cadocupql);
        }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR LA OCUPACION";
              cad2="TABLA OCUPACION";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch

    }

    /**
     * guardaringreso
     *
     * @return int
     */
    public int guardaringreso(CIngreso gingresoPM)throws SQLException {
       Connection con2=Cconsql.getConnection();
       int vardatoingreso=0;
       String empresahc,tipexhc,medtratantehc,municipioexchc,empresatipohc,jorhc,cargohc,idNDocpaciente;
       String sqlcadingreso,sqlempresa,sqltipex,sqlcadmedtratante,sqlmunicipioex,sqltipoempresa,sqljor,sqlcargo;
       String cadempresa,cadtipex,cadmedtratante,cadmunicipioex,cadtipoempresa,cadjorn,cadcargo,caddescrcargo;
       cargohc="";empresahc="";empresatipohc="";
       idNDocpaciente=gingresoPM.JFTNDoc.getText();
       cadtipex=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBTipoEx);
       sqltipex="select *from tipo_examen where tipo_examen.nombre_TE="+"'"+cadtipex+"'";
       tipexhc=objvalidarGHC.buscarcadena(sqltipex,1);
       cadmunicipioex=gingresoPM.JFTCiudadEx.getText();
       sqlmunicipioex="select *from municipio where municipio.Nbre_Municipio="+"'"+cadmunicipioex+"'";
       municipioexchc=objvalidarGHC.buscarcadena(sqlmunicipioex,1);
       //cadempresa=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBEmpresa);
       //sqlempresa="select *from empresa where empresa.nombre_empresa="+"'"+cadempresa+"'";
       //empresahc=objvalidarGHC.buscarcadena(sqlempresa,1);
      // cadtipoempresa=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBTipoEmpr);
      // sqltipoempresa="select *from tipo_industria where tipo_industria.nombre_tindustria="+"'"+cadtipoempresa+"'";
      // empresatipohc=objvalidarGHC.buscarcadena(sqltipoempresa,1);
       cadjorn=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBJornada);
       sqljor="select *from jornada_trabajo where jornada_trabajo.nombrejornada_jtrabajo="+"'"+cadjorn+"'";
       jorhc=objvalidarGHC.buscarcadena(sqljor,1);
       cadmedtratante=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBMedTrat);
       sqlcadmedtratante="select *from medicos_tratantes where medicos_tratantes.nombre_medtrat="+"'"+cadmedtratante+"'";
       medtratantehc=objvalidarGHC.buscarcadena(sqlcadmedtratante,1);
       if(objvalidarGHC.validarcombonulo(gingresoPM.JCBCargo) ==0 ) {
           cadcargo=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBCargo);
           sqlcargo="select *from ocupacion where ocupacion.Nbre_Ocupacion="+"'"+cadcargo+"'";
           cargohc=objvalidarGHC.buscarcadena(sqlcargo,1);
       }
       else{if(gingresoPM.JFTCargoAspira.getText().compareTo("")!=0){
                // System.out.println("san luz:");
                 guardarocupacion(gingresoPM.JFTCargoAspira.getText());
                 sqlcargo="select *from ocupacion where ocupacion.Nbre_Ocupacion="+"'"+gingresoPM.JFTCargoAspira.getText()+"'";
                 cargohc=objvalidarGHC.buscarcadena(sqlcargo,1);
             }//fin del if
       }//FIN DEL ELSE PROBLEMA
       caddescrcargo=gingresoPM.JTADescrCargo.getText();
       if(objvalidarGHC.validarcombonulo(gingresoPM.JCBEmpresa) ==0) {
             cadempresa=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBEmpresa);
             sqlempresa="select *from empresa where empresa.nombre_empresa="+"'"+cadempresa+"'";
             empresahc=objvalidarGHC.buscarcadena(sqlempresa,1);
       }
       else{
           if(gingresoPM.JFTEmpresa.getText().compareTo("")!=0){
                guardarempresa(gingresoPM.JFTEmpresa.getText());
                sqlempresa="select *from empresa where empresa.nombre_empresa="+"'"+gingresoPM.JFTEmpresa.getText()+"'";
                empresahc=objvalidarGHC.buscarcadena(sqlempresa,1);
             }
       }//fin else
       //
       if(objvalidarGHC.validarcombonulo(gingresoPM.JCBTipoEmpr) ==0) {
           cadtipoempresa=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBTipoEmpr);
           sqltipoempresa="select *from tipo_industria where tipo_industria.nombre_tindustria="+"'"+cadtipoempresa+"'";
          empresatipohc=objvalidarGHC.buscarcadena(sqltipoempresa,1);

       }
       else{if(gingresoPM.JFTTipEmpr.getText().compareTo("")!=0){
               guardartipoempr(gingresoPM.JFTTipEmpr.getText());
               sqltipoempresa="select *from tipo_industria where tipo_industria.nombre_tindustria="+"'"+gingresoPM.JFTTipEmpr.getText()+"'";
               System.out.println("DAMARIS:"+sqltipoempresa);
               empresatipohc=objvalidarGHC.buscarcadena(sqltipoempresa,1);
           }
       }

       //
       sqlcadingreso="insert into ingreso (NoHC_ingreso,idtipoex_ingreso,fechaexa_ingreso,idciudadexam_ingreso,idempresa_ingreso,idtipoindustria_ingreso,idjornadatrabajo_ingreso,idmedico_ingreso,cargoaspira_ingreso,descripcioncargo_ingreso,elemguantes_ingreso,elemrespi_ingreso,elemauditiva_ingreso,elemvisual_ingreso,elemotros_ingreso,descrotros_ingreso,observacion_ingreso,pendiente_ingreso,horaentrada_ingreso) values ("+"'"  +idNDocpaciente+"',"+tipexhc+",'"+gingresoPM.JFTFechaExa.getText() + "',"+municipioexchc +","+empresahc+","+empresatipohc+","+jorhc+","+medtratantehc+","+cargohc+",'"+caddescrcargo+"',"+gingresoPM.JCHGuantes.isSelected()+","+gingresoPM.JCHProtcResp.isSelected()+","+gingresoPM.JCHAuditiva.isSelected()+","+gingresoPM.JCHVisual.isSelected()+","+gingresoPM.JCHOtros.isSelected()+",'"+gingresoPM.JFTOtros.getText()+"','"+gingresoPM.JTAObservacion.getText()+ "',"+0+",'"+objvalidarGHC.formatohora()+"')";
       try{
           TSentenciaGuardarhc=con2.createStatement();
           vardatoingreso=TSentenciaGuardarhc.executeUpdate(sqlcadingreso);
      }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR EL INGRESO";
              cad2="PROBLEMAS CON EL INGRESO";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
       Cconsql.CerrarConexion();
       gingresoPM.JFTHoraAtencion.setText(objvalidarGHC.formatohora());
       return vardatoingreso;

    }

    /**
     * buscaridpaciente
     *
     * @return int
     */
    public int buscaridpaciente(String ndoc) {
        Connection con2=Cconsql.getConnection();
        ResultSet Rconsulta;
        int ultima=0;
        String cadDU;
        cadDU="select *from datosusuarios  where IdDocumentodeIdentificaci�n_du="+"'"+ndoc+"'";
        try{
           TSentenciaGuardarhc=con2.createStatement();
           Rconsulta=TSentenciaGuardarhc.executeQuery(cadDU);
           Rconsulta.next();
           ultima=Rconsulta.getInt(1);
           //ultima=ultima+1;
        }//cierra el try
        catch(SQLException e){
              e.getMessage();
              cad1="NO SE PUDO RECUPERAR EL ULTIMO REGISTRO";
              cad2="PROBLEMAS CON LOS DATOS DE USUARIO";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
        Cconsql.CerrarConexion();
        return ultima;
    }

    /**
     * validarnulos
     */
    public void validarnulos(CIngreso gingresoPM) {
        if (objvalidarGHC.validarvisualTextField(gingresoPM.JFTNDoc) == 1) {
            objvalidarGHC.mensajeconfirmacion(
                    "EL N� DOCUMENTO NO PUEDE ESTAR VACIO", "N� DOCUMENTO");
            swval = 1;
        } else {
            swval = 0;
            if (objvalidarGHC.validarvisualTextField(gingresoPM.JFTPrimerApll) == 1) {
                objvalidarGHC.mensajeconfirmacion(
                        "PRIMER APELLIDO NO PUEDE ESTAR VACIO",
                        "EL PRIMER APELLIDO");
                swval = 1;
            } else { //9999999999999999999999999
                swval = 0;
                if (objvalidarGHC.validarvisualTextField(gingresoPM.JFTSgdoApll) ==
                    1) {
                    objvalidarGHC.mensajeconfirmacion(
                            "EL SEGUNDO APELLIDO NO PUEDE ESTAR VACIO",
                            "SEGUNDO APELLIDO");
                    swval = 1;
                } else { //cierra el if del segundo apellido, 999999999999999999999999
                    swval = 0;
                    if (objvalidarGHC.validarvisualTextField(gingresoPM.JFTSgdoNbre) ==
                        1) {
                        objvalidarGHC.mensajeconfirmacion(
                                "EL PRIMER NOMBRE NO PUEDE ESTAR VACIO",
                                "PRIMER NOMBRE");
                        swval = 1;
                    } else { //99999999999999999999999
                        swval = 0;
                        if (objvalidarGHC.validarvisualTextField(gingresoPM.
                                JFTFechaNac) == 1) {
                            objvalidarGHC.mensajeconfirmacion(
                                    "LA FECHA DE NACIMIENTO NO PUEDE ESTAR VACIO",
                                    "FECHA DE NACIMIENTO");
                            swval = 1;
                        } else { //cierra el if de la fecha de nacimiento JFTNHijos, 9999999999999999999999
                            swval = 0;
                            if (objvalidarGHC.validarvisualTextField(gingresoPM.
                                    JFTNHijos) == 1) {
                                objvalidarGHC.mensajeconfirmacion(
                                        "EL NUMERO DE HIJOS NO PUEDE ESTAR VACIO",
                                        "FECHA DE NACIMIENTO");
                                swval = 1;
                            } else { //cierra el if de la n� hIJOS , 999999999999999999999
                                swval = 0;
                                if (objvalidarGHC.validarvisualTextField(gingresoPM.
                                        JFTDirResidencia) == 1) {
                                    objvalidarGHC.mensajeconfirmacion(
                                            "LA DIRECCION NO PUEDE ESTAR VACIO",
                                            "DIRECCION DE RESIDENCIA");
                                    swval = 1;
                                } else { //cierra el if de la direccion, //99999999999999999999
                                    swval = 0;
                                    if (objvalidarGHC.validarvisualTextField(
                                            gingresoPM.JFTTel) == 1) {
                                        objvalidarGHC.mensajeconfirmacion(
                                                "EL TELEFONO NO PUEDE ESTAR VACIO",
                                                "TELEFONO");
                                        swval = 1;
                                    } else { //cierra el if del telefono, 9999999999999999999
                                        swval = 0;
                                        if (objvalidarGHC.validarcombonulo(
                                                gingresoPM.JCBTipoDocumento) == 1) {
                                            objvalidarGHC.mensajeconfirmacion(
                                                    "EL TIPO DOCUMENTO NO PUEDE ESTAR VACIO",
                                                    "TIPO DE DOCUMENTO");
                                            swval = 1;
                                        } else { //cierra el if del tipo de documento, 999999999999999999
                                            swval = 0;
                                            if (objvalidarGHC.validarcombonulo(
                                                    gingresoPM.JCBSexo) == 1) {
                                                objvalidarGHC.mensajeconfirmacion(
                                                        "EL SEXO NO PUEDE ESTAR VACIO",
                                                        "SEXO");
                                                swval = 1;
                                            } else { //cierra el if del sexo, 9999999999999999
                                                swval = 0;
                                                if (objvalidarGHC.validarcombonulo(
                                                        gingresoPM.JCBEstadoCivil) ==
                                                    1) {
                                                    objvalidarGHC.
                                                            mensajeconfirmacion(
                                                            "EL ESTADO CIVIL NO PUEDE ESTAR VACIO",
                                                            "ESTADO CIVIL");
                                                    swval = 1;
                                                } else { //cierra el if del estado civil, 9999999999999999
                                                    swval = 0;
                                                    if (objvalidarGHC.
                                                            validarcombonulo(gingresoPM.JCBMunNat) == 1) {
                                                        objvalidarGHC.
                                                                mensajeconfirmacion(
                                                                "EL MUNICIPIO NATURAL NO PUEDE ESTAR VACIO",
                                                                "MUNICIPIO NATURAL");
                                                        swval = 1;
                                                    } else { //cierra el if del MUNICIPIO NATURAL, 999999999999999
                                                        swval = 0;
                                                        if (objvalidarGHC.
                                                                validarcombonulo(
                                                                gingresoPM.
                                                                JCBDptoNat) == 1) {
                                                            objvalidarGHC.
                                                                    mensajeconfirmacion(
                                                                    "EL DPTO NATURAL NO PUEDE ESTAR VACIO",
                                                                    "DPTO NATURAL");
                                                            swval = 1;
                                                        } else { //cierra el if del DPTO NATURAL, 99999999999999
                                                            swval = 0;
                                                            if (objvalidarGHC.
                                                                    validarcombonulo(
                                                                    gingresoPM.
                                                                    JCBMunProc) ==
                                                                    1) {
                                                                objvalidarGHC.
                                                                        mensajeconfirmacion(
                                                                        "EL MUNICIPIO PROCEDENTE NO PUEDE ESTAR VACIO",
                                                                        "MUNICIPIO PROCEDENTE");
                                                                swval = 1;
                                                            } //cierra el if del MUNICIPIO PROCEDENTE

                                                            else { //9999999999999
                                                                swval = 0;
                                                                if (objvalidarGHC.
                                                                        validarcombonulo(
                                                                        gingresoPM.
                                                                        JCBDptoProc) ==
                                                                        1) {
                                                                    objvalidarGHC.
                                                                            mensajeconfirmacion(
                                                                            "EL DPTO PROCEDENTE NO PUEDE ESTAR VACIO",
                                                                            "DPTO PROCEDENTE");
                                                                    swval = 1;
                                                                } else { //cierra el if del DPTO PROCEDENTE, 999999999999
                                                                    swval = 0;
                                                                    if (
                                                                            objvalidarGHC.
                                                                            validarcombonulo(
                                                                            gingresoPM.
                                                                            JCBZonRes) ==
                                                                            1) {
                                                                        objvalidarGHC.
                                                                                mensajeconfirmacion(
                                                                                "LA ZONA NO PUEDE ESTAR VACIO",
                                                                                "ZONA");
                                                                        swval = 1;
                                                                    } else { //cierra el if del ZONA, 99999999999
                                                                        swval = 0;
                                                                        if (objvalidarGHC.validarcombonulo(gingresoPM.JCBBarrio) ==1  && gingresoPM.JFTBarrio.getText().compareTo("")==0) {
                                                                            objvalidarGHC.mensajeconfirmacion("EL BARRIO NO PUEDE ESTAR VACIO","BARRIO");
                                                                            swval =1;
                                                                        } else { //cierra el if del BARRIO, 9999999999
                                                                            swval =
                                                                                    0;
                                                                            if (
                                                                                    objvalidarGHC.
                                                                                    validarcombonulo(
                                                                                    gingresoPM.
                                                                                    JCBEscolaridad) ==
                                                                                    1) {
                                                                                objvalidarGHC.
                                                                                        mensajeconfirmacion(
                                                                                        "LA ESCOLARIDAD NO PUEDE ESTAR VACIO",
                                                                                        "ESCOLARIDAD");
                                                                                swval =
                                                                                        1;
                                                                            } else { //cierra el if del ESCOLARIDAD, 999999999
                                                                                swval =0;
                                                                                if (objvalidarGHC.validarcombonulo(gingresoPM.JCBProfesion) ==1 && gingresoPM.JFTProfesion.getText().compareTo("")==0) {
                                                                                    objvalidarGHC.mensajeconfirmacion("LA PROFESION NO PUEDE ESTAR VACIO","PROFESION");
                                                                                    swval = 1;
                                                                                } else { //cierra el if del PROFESION, 99999999
                                                                                    swval =
                                                                                            0;
                                                                                    if (objvalidarGHC.validarcombonulo(gingresoPM.JCBOcupacion) ==0 && gingresoPM.JFTOcup.getText().compareTo("")==0) {
                                                                                        objvalidarGHC.
                                                                                                mensajeconfirmacion(
                                                                                                "LA OCUPACION NO PUEDE ESTAR VACIO",
                                                                                                "OCUPACION");
                                                                                        swval =
                                                                                                1;
                                                                                    } else { //cierra el if del OCUPACION, 9999999
                                                                                        swval =
                                                                                                0;
                                                                                        if (
                                                                                                objvalidarGHC.
                                                                                                validarcombonulo(
                                                                                                gingresoPM.
                                                                                                JCBMedTrat) ==
                                                                                                1) {
                                                                                            objvalidarGHC.
                                                                                                    mensajeconfirmacion(
                                                                                                    "EL MEDICO NO PUEDE ESTAR VACIO",
                                                                                                    "MEDICO");
                                                                                            swval =
                                                                                                    1;
                                                                                        } else { //cierra el if del MEDICO, 999999
                                                                                            swval =0;
                                                                                            if (objvalidarGHC.validarcombonulo(gingresoPM.JCBTipoEx) ==1) {
                                                                                                          objvalidarGHC.mensajeconfirmacion("EL TIPO EXAMEN NO PUEDE ESTAR VACIO","TIPO EXAMEN");
                                                                                                          swval =1;
                                                                                            } else { //cierra el if del TIPO EXAMEN, 99999
                                                                                                   swval =0;
                                                                                                   if (objvalidarGHC.validarcombonulo(gingresoPM.JCBEmpresa) ==1 && gingresoPM.JFTEmpresa.getText().compareTo("")==0)  {
                                                                                                    objvalidarGHC.mensajeconfirmacion("LA EMPRESA NO PUEDE ESTAR VACIO","EMPRESA");
                                                                                                    swval =1;
                                                                                                   } else { //cierra el if del EMPRESA, 9999
                                                                                                          swval =0;
                                                                                                    if (objvalidarGHC.validarcombonulo(gingresoPM.JCBTipoEmpr) ==1 && gingresoPM.JFTTipEmpr.getText().compareTo("")==0) {
                                                                                                        objvalidarGHC.mensajeconfirmacion("EL TIPO DE EMPRESA NO PUEDE ESTAR VACIO","TIPO EMPRESA");
                                                                                                        swval =1;
                                                                                                    } else { //cierra el if del TIPO EMPRESA, 999
                                                                                                        swval =0;
                                                                                                        if (
                                                                                                                objvalidarGHC.
                                                                                                                validarcombonulo(
                                                                                                                gingresoPM.
                                                                                                                JCBJornada) ==
                                                                                                                1) {
                                                                                                            objvalidarGHC.
                                                                                                                    mensajeconfirmacion(
                                                                                                                    "LA JORNADA NO PUEDE ESTAR VACIO",
                                                                                                                    "JORNADA");
                                                                                                            swval =
                                                                                                                    1;
                                                                                                        } else { //cierra el if del JORNADA, 99
                                                                                                            swval =
                                                                                                                    0;
                                                                                                            if (objvalidarGHC.validarcombonulo(gingresoPM.JCBCargo) ==1 && gingresoPM.JFTCargoAspira.getText().compareTo("")==0) {
                                                                                                                objvalidarGHC.mensajeconfirmacion("EL CARGO NO PUEDE ESTAR VACIO","CARGO");
                                                                                                                swval =1;
                                                                                                            } else { //cierra el if del CARGO, 9
                                                                                                                swval =
                                                                                                                        0;
                                                                                                                if (objvalidarGHC.validararea(gingresoPM.JTADescrCargo) == 1) {
                                                                                                                    objvalidarGHC.
                                                                                                                            mensajeconfirmacion(
                                                                                                                            "LA DESCRIPCION DEL CARGO NO PUEDE ESTAR VACIO",
                                                                                                                            "DESCRIPCION DEL CARGO");
                                                                                                                    swval =
                                                                                                                            1;
                                                                                                                } //cierra el if del DESCRIPCION DEL CARGO
                                                                                                            } //9
                                                                                                        } //99
                                                                                                    } //999
                                                                                                } //9999
                                                                                            } //99999
                                                                                        } //999999
                                                                                    } //9999999
                                                                                } //99999999
                                                                            } //999999999
                                                                        } //9999999999
                                                                    } //99999999999
                                                                } //999999999999
                                                            } //9999999999999
                                                        } //99999999999999
                                                    } //999999999999999
                                                } //999999999999999
                                            } //99999999999999999
                                        } //9999999999999999999
                                    } //9999999999999999999
                                } //99999999999999999999
                            } //999999999999999999999
                        } //9999999999999999999999
                    } //99999999999999999999999
                } //999999999999999999999999
            } //9999999999999999999999999

        } //99999999999999999999999999

}//FIN validarnulos

    /**
     * actualizardatosusuarios
     */
    public int actualizardatosusuarios(CIngreso gingresoPM)throws SQLException {
        String cadactualizar;
        Connection con2=Cconsql.getConnection();
        int ver=0,barriohc;String cadeps,sqleps,epshc,cadips,sqlips,ipshc,cadzona,sqlzona,zonahc,cadbarrio,sqlbarrio;
        cadzona=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBZonRes);
        sqlzona="select *from zona where zona.nombre_zona="+"'"+cadzona+"'";
        zonahc=objvalidarGHC.buscarcadena(sqlzona,1);
        cadbarrio=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBBarrio);
        sqlbarrio="select *from barrio where barrio.Nbre_Barrio="+"'"+cadbarrio+"'";
        barriohc=objvalidarGHC.evaluarcadenaentera(sqlbarrio);
        cadeps=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBEps);
        sqleps="select *from eps where eps.nombre_eps="+"'"+cadeps+"'";
        epshc=objvalidarGHC.buscarcadena(sqleps,1);
        cadips=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBIps);
        sqlips="select *from ips where ips.nombre_ips="+"'"+cadips+"'";
        ipshc=objvalidarGHC.buscarcadena(sqlips,1);
        try{
           if(gingresoPM.swimagen==1){
                cadactualizar="UPDATE datosusuarios SET datosusuarios.NumHijos_du =?," +"datosusuarios.ideps_du=?,"+"datosusuarios.idips_du=?,"+"datosusuarios.idzonares_du=?,"+"datosusuarios.Barrio_du=?,"+"datosusuarios.DireccionResidencia_du=?,"+"datosusuarios.TelefonoCelular_du=?,"+"datosusuarios.foto_du=?,"+"datosusuarios.PrimerApellido_du=?,"+"datosusuarios.SegundoApellido_du=?,"+"datosusuarios.PrimerNombre_du=?,"+"datosusuarios.SegundoNombre_du=?"+" WHERE datosusuarios.NoHC_du='"+gingresoPM.JFTNDoc.getText()+"'";
                PreparedStatement pst = con2.prepareStatement(cadactualizar);
                pst.setString(1, gingresoPM.JFTNHijos.getText());
                pst.setString(2, epshc);
                pst.setString(3, ipshc);
                pst.setString(4, zonahc);
                pst.setInt(5, barriohc);
                pst.setString(6, gingresoPM.JFTDirResidencia.getText());
                pst.setString(7, gingresoPM.JFTTel.getText());
                procesograbarimagen(gingresoPM.JBFoto.getIcon());
                pst.setBinaryStream(8, fis, (int) file1.length());
                pst.setString(9, gingresoPM.JFTPrimerApll.getText());
                pst.setString(10,gingresoPM.JFTSgdoApll.getText());
                pst.setString(11, gingresoPM.JFTSgdoNbre.getText());
                pst.setString(12, gingresoPM.JFTPrimerNbre.getText());
                System.out.println("carolina");
                ver = pst.executeUpdate();
                gingresoPM.swimagen=0;
            }
            else{ cadactualizar="UPDATE datosusuarios SET datosusuarios.NumHijos_du =?," +"datosusuarios.ideps_du=?,"+"datosusuarios.idips_du=?,"+"datosusuarios.idzonares_du=?,"+"datosusuarios.Barrio_du=?,"+"datosusuarios.DireccionResidencia_du=?,"+"datosusuarios.TelefonoCelular_du=?,"+"datosusuarios.PrimerApellido_du=?,"+"datosusuarios.SegundoApellido_du=?,"+"datosusuarios.PrimerNombre_du=?,"+"datosusuarios.SegundoNombre_du=?"+" WHERE datosusuarios.NoHC_du='"+gingresoPM.JFTNDoc.getText()+"'";
                 PreparedStatement pst = con2.prepareStatement(cadactualizar);
                 pst.setString(1, gingresoPM.JFTNHijos.getText());
                 pst.setString(2, epshc);
                 pst.setString(3, ipshc);
                 pst.setString(4, zonahc);
                 pst.setInt(5, barriohc);
                 pst.setString(6, gingresoPM.JFTDirResidencia.getText());
                 pst.setString(7, gingresoPM.JFTTel.getText());
                 pst.setString(8, gingresoPM.JFTPrimerApll.getText());
                 pst.setString(9,gingresoPM.JFTSgdoApll.getText());
                 pst.setString(10, gingresoPM.JFTSgdoNbre.getText());
                 pst.setString(11, gingresoPM.JFTPrimerNbre.getText());
                 ver = pst.executeUpdate();
                 //ver=TSentenciaGuardarhc.executeUpdate("UPDATE datosusuarios SET datosusuarios.NumHijos_du ='"+gingresoPM.JFTNHijos.getText()+"'," +"datosusuarios.ideps_du="+epshc+",datosusuarios.idips_du="+ipshc+",datosusuarios.idzonares_du="+zonahc+",datosusuarios.Barrio_du="+barriohc+",datosusuarios.DireccionResidencia_du='"+gingresoPM.JFTDirResidencia.getText()+"',"+"datosusuarios.TelefonoCelular_du='"+gingresoPM.JFTTel.getText()+"' WHERE datosusuarios.NoHC_du='"+gingresoPM.JFTNDoc.getText()+"'");
            }//fin del else
          }//fin del try
            catch (SQLException e) {
             System.out.println("xaver:" + e.getMessage());
             cad1="NO SE ACTUALIZO EL MOVIMIENTOEN LA TABLA datosusuarios";
             cad2="ACTUALIZAR DATOS USUARIOS";
             objvalidarGHC.mensajeconfirmacion(cad1,cad2);

            }
        Cconsql.CerrarConexion();
        return ver;
    }

    /**
     * abrirhistoriaocupacional
     */
    public void abrirhistoriaocupacional(CIngreso frameingreso) {
        CHistoriaOcup frameho=new CHistoriaOcup(null,"0",0,frameIngresoUsuario.JFTPrimerApll.getText(),frameIngresoUsuario.JFTSgdoApll.getText(),frameIngresoUsuario.JFTPrimerNbre.getText(),frameIngresoUsuario.JFTSgdoNbre.getText(),frameIngresoUsuario.JFTNDoc.getText(),JDPIngreso,frameingreso,null);
        frameho.setBounds(0, 2, 1010, 600);
        frameho.setTitle("HISTORIA OCUPACIONAL");
        JDPIngreso.add(frameho, new Integer(1));
        frameho.setLocation(5, 55);
        frameho.show();
        //frameho.inicioventanamotenf(framemotivo);
        frameho.setVisible(true);
        frameho.inilizarventanaHO(frameho);
    }

    /**
     * guardarbarrio
     */
    public void guardarbarrio(String cadbarrio) throws SQLException {
        Connection con2=Cconsql.getConnection();
        String cadbarriosql;
        cadbarriosql="insert into barrio (Zona_Barrio,Nbre_Barrio,idestrato) values ("  + 1+",'"+cadbarrio + "'" +","+0+ ")";
        try{
            //Connection con2=Cconsql.getConnection();
           TSentenciaGuardarhc=con2.createStatement();
           varbarrio=TSentenciaGuardarhc.executeUpdate(cadbarriosql);
        }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR EL BARRIO";
              cad2="TABLA BARRIOS";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
       //Cconsql.CerrarConexion();
    }

    /**
     * guardarprofesion
     */
    public void guardarprofesion( String nombrprofesion) throws SQLException {
        Connection con2=Cconsql.getConnection();
        String cademprql;
        cademprql="insert into profesionales (nombre_pro) values ('"+nombrprofesion + "'" + ")";
        try{
            //Connection con2=Cconsql.getConnection();
           TSentenciaGuardarhc=con2.createStatement();
           varprofesion=TSentenciaGuardarhc.executeUpdate(cademprql);
        }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR LA PROFESION";
              cad2="TABLA PROFESION";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
       // Cconsql.CerrarConexion();
    }

    /**
     * guardareps
     */
    public void guardareps(String cadeps) throws SQLException {
        Connection con2=Cconsql.getConnection();
        String cadepsql;
        cadepsql="insert into eps (nombre_eps) values ('"+cadeps + "'" + ")";
        try{
            //Connection con2=Cconsql.getConnection();
           TSentenciaGuardarhc=con2.createStatement();
           vareps=TSentenciaGuardarhc.executeUpdate(cadepsql);
        }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR LA EPS";
              cad2="TABLA EPS";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
        //Cconsql.CerrarConexion();
    }

    /**
     * guardarips
     */
    public void guardarips(String cadips)throws SQLException {
        Connection con2=Cconsql.getConnection();
        String cadipsql;
        cadipsql="insert into ips (nombre_ips) values ('"+cadips + "'" + ")";
        try{
            //Connection con2=Cconsql.getConnection();
           TSentenciaGuardarhc=con2.createStatement();
           vareps=TSentenciaGuardarhc.executeUpdate(cadipsql);
        }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR LA IPS";
              cad2="TABLA IPS";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
       // Cconsql.CerrarConexion();

    }

    /**
     * procesograbarimagen
     */
    public  void procesograbarimagen(Icon sicin) throws SQLException{
       //Icon sicin=gingresoPM.JBFoto.getIcon();
       try{
          String cadicon=sicin.toString();
          File file = new File(cadicon);
          String archiimagen=file.getName();
          //cadicon="C:\\Documents and Settings\\LILIAN\\Mis documentos\\WebCam Media\\Capture/";
          cadicon="C:\\SALUD_OCUPACIONAL\\Imagenes\\CAMARA\\Capture/";
         //cadicon= "C:\\Documents and Settings\\Luis Felipe\\Escritorio/";
         cadicon=cadicon.concat(archiimagen);
          file1 = new File(cadicon);
          System.out.println("INGRESO FOTO "+cadicon);
          fis = new FileInputStream(file1);
          //is = (InputStream) fis;
       }
       catch(Exception e){
           System.out.println("err FOTO "+e.getMessage());
       }

    }

    /**
     * validarfoto
     */
    public void validarfoto(CIngreso gingresoPM) {
        swvalfoto = 0;
        if(gingresoPM.JBFoto.isEnabled()==false){
            objvalidarGHC.mensajeconfirmacion("LA FOTO NO PUEDE ESTAR VACIO", "FOTO");
            swvalfoto = 1;
        }
    }

    /**
     * existimagen
     */
    public String existimagen(CIngreso gingresoPM) {
        String cadimagen,varimag="";
        Connection con2=Cconsql.getConnection();
        cadimagen="select NoHC_du,foto_du from datosusuarios where NoHC_du='"+gingresoPM.JFTNDoc.getText()+"'";
        try{
            TSentenciaGuardarhc=con2.createStatement();
            Rverificacodigo=TSentenciaGuardarhc.executeQuery(cadimagen);
            Rverificacodigo.next();
            varimag=Rverificacodigo.getString(2);
        }
       catch (Exception ex) {
        objvalidarGHC.mensajeconfirmacion("PROBLEMA CHINA","ERROR GRABAR INGRESO");
       }
      return(varimag);
    }

    /**
     * guardarempresa
     */
    public void guardarempresa(String nempresa) throws SQLException {
        Connection con2=Cconsql.getConnection();
        String cadempr;
        cadempr="insert into empresa (nombre_empresa) values ('"+nempresa + "'" + ")";
        try{
            //Connection con2=Cconsql.getConnection();
           TSentenciaGuardarhc=con2.createStatement();
           varempr=TSentenciaGuardarhc.executeUpdate(cadempr);
        }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR LA EMPRESA";
              cad2="TABLA EMPRESA";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch

    }

    /**
     * guardartipoempr
     */
    public void guardartipoempr(String ntipempr) throws SQLException {
        Connection con2=Cconsql.getConnection();
        String cadtipempr;
        cadtipempr="insert into tipo_industria (nombre_tindustria) values ('"+ntipempr + "'" + ")";
        try{
            //Connection con2=Cconsql.getConnection();
           TSentenciaGuardarhc=con2.createStatement();
           vartipempr=TSentenciaGuardarhc.executeUpdate(cadtipempr);
       }//cierra el try
        catch(SQLException e){
              //e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR LA TIPO INDUSTRIA";
              cad2="TABLA TIPO INDUSTRIA";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch

    }
    //JMIngresoRep
    public void JMIngresoRep_actionPerformed(ActionEvent e) {

    }
    //JMRetiroRep
     public void JMRetiroRep_actionPerformed(ActionEvent e) {
       //System.out.println("PICON:");
       CReportes framereporte=new CReportes(2);
       framereporte.setBounds(0,2,620,465);
       framereporte.setTitle("REPORTES RETIRO");
      //JDPpanelpal.add(framecrearentrada, new Integer(1));
       JDPIngreso.add(framereporte, new Integer(1));
       framereporte.setLocation(200, 100);
       framereporte.show();

     }
    //JMPeriodico
    public void JMPeriodico_actionPerformed(ActionEvent e) {
        CReportes framereporte=new CReportes(3);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES PERIODICO");
       //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();

     }

    public void JMIngApto_actionPerformed(java.awt.event.ActionEvent e) {
        //String rutaretiro;
        //rutaretiro="C:\\SALUD_OCUPACIONAL\\reportes\\INGR-APTO.jasper";
    }

    public void jMenu1_actionPerformed(java.awt.event.ActionEvent e) {
        CReportes framereporte=new CReportes(1);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES INGRESO");
       //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();
    }

    public void JMRetiroRep_mouseReleased(java.awt.event.MouseEvent e) {

    }
    public ImageIcon leerimagen(byte[] i) throws SQLException {
     // ImageIcon m = new ImageIcon();
      imagimpr=i;
      m = new ImageIcon(i);
      return m;
    }

    public void JMINmuniz_actionPerformed(java.awt.event.ActionEvent e) {
        CReportes framereporte=new CReportes(4);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES INMUNIZACION");
     //JDPpanelpal.add(framecrearentrada, new Integer(1));
       JDPIngreso.add(framereporte, new Integer(1));
       framereporte.setLocation(200, 100);
       framereporte.show();
    }

    public void JMHabit_actionPerformed(java.awt.event.ActionEvent e) {
        CReportes framereporte=new CReportes(5);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES HABITOS");
      //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();
    }

    public void JMParaclinicos_actionPerformed(java.awt.event.ActionEvent e) {
        CReportes framereporte=new CReportes(7);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES PATOLOGIAS");
      //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();

    }

    public void JMPatologias_actionPerformed(java.awt.event.ActionEvent e) {
        CReportes framereporte=new CReportes(6);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES PARACLINICOS");
    //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();
    }

    public void JMImc_actionPerformed(java.awt.event.ActionEvent e) {
        CReportes framereporte=new CReportes(8);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES EXAMEN FISICO");
  //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();
    }

    public void JMLateralidad_actionPerformed(java.awt.event.ActionEvent e) {
        CReportes framereporte=new CReportes(8);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES EXAMEN FISICO");
    //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();
    }

    public void JMTratamiento_actionPerformed(java.awt.event.ActionEvent e) {
        CReportes framereporte=new CReportes(9);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES TRATAMIENTO");
    //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();

    }

    public void JMReimprimir_actionPerformed(java.awt.event.ActionEvent e) {
        swedicion=0;
        CEntradaConsulta framecrearentrada=new CEntradaConsulta(swedicion,JDPIngreso,JBGuardar,JBNuevo,JBModificar,JBActualizar,JBBorrar,null);
  // framecrearentrada = new JIFEntradas(JBGuardar,JBEliminar,JBModificar,swsalida,framecrearentrada, JDPpanelpal );
       framecrearentrada.setBounds(0, 1, 1020, 620);
       framecrearentrada.setTitle("REIMPRIMIR ULTIMO CERTIFICADO");
   //titulo=titulo1;
      JDPIngreso.add(framecrearentrada, new Integer(1));
      framecrearentrada.setLocation(5, 55);
      framecrearentrada.show();
    }

    public void JMEdicion_actionPerformed(java.awt.event.ActionEvent e) {
        swedicion=1;
        CEntradaConsulta framecrearentrada=new CEntradaConsulta(swedicion,JDPIngreso,JBGuardar,JBNuevo,JBModificar,JBActualizar,JBBorrar,this);
 // framecrearentrada = new JIFEntradas(JBGuardar,JBEliminar,JBModificar,swsalida,framecrearentrada, JDPpanelpal );
        framecrearentrada.setBounds(0, 1, 1020, 620);
        framecrearentrada.setTitle("EDITAR UN REGISTRO");
  //titulo=titulo1;
        JDPIngreso.add(framecrearentrada, new Integer(1));
        framecrearentrada.setLocation(5, 55);
        framecrearentrada.show();
     //JBGuardar.setEnabled(true);

    }

    /**
     * actualizaringreso
     */
    public int actualizaringreso(CIngreso gingresoPM)throws SQLException {
       Connection con2=Cconsql.getConnection();
       int vardatoingreso=0;
       String empresahc,tipexhc,medtratantehc,municipioexchc,empresatipohc,jorhc,cargohc,idNDocpaciente;
       String sqlcadingreso,sqlempresa,sqltipex,sqlcadmedtratante,sqlmunicipioex,sqltipoempresa,sqljor,sqlcargo;
       String cadempresa,cadtipex,cadmedtratante,cadmunicipioex,cadtipoempresa,cadjorn,cadcargo,caddescrcargo;
       cargohc="";empresahc="";empresatipohc="";
       idNDocpaciente=gingresoPM.JFTNDoc.getText();
       cadtipex=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBTipoEx);
       sqltipex="select *from tipo_examen where tipo_examen.nombre_TE="+"'"+cadtipex+"'";
       tipexhc=objvalidarGHC.buscarcadena(sqltipex,1);
       cadmunicipioex=gingresoPM.JFTCiudadEx.getText();
       sqlmunicipioex="select *from municipio where municipio.Nbre_Municipio="+"'"+cadmunicipioex+"'";
       municipioexchc=objvalidarGHC.buscarcadena(sqlmunicipioex,1);
       //cadempresa=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBEmpresa);
       //sqlempresa="select *from empresa where empresa.nombre_empresa="+"'"+cadempresa+"'";
       //empresahc=objvalidarGHC.buscarcadena(sqlempresa,1);
      // cadtipoempresa=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBTipoEmpr);
      // sqltipoempresa="select *from tipo_industria where tipo_industria.nombre_tindustria="+"'"+cadtipoempresa+"'";
      // empresatipohc=objvalidarGHC.buscarcadena(sqltipoempresa,1);
       cadjorn=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBJornada);
       sqljor="select *from jornada_trabajo where jornada_trabajo.nombrejornada_jtrabajo="+"'"+cadjorn+"'";
       jorhc=objvalidarGHC.buscarcadena(sqljor,1);
       cadmedtratante=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBMedTrat);
       sqlcadmedtratante="select *from medicos_tratantes where medicos_tratantes.nombre_medtrat="+"'"+cadmedtratante+"'";
       medtratantehc=objvalidarGHC.buscarcadena(sqlcadmedtratante,1);
       if(objvalidarGHC.validarcombonulo(gingresoPM.JCBCargo) ==0 ) {
           cadcargo=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBCargo);
           sqlcargo="select *from ocupacion where ocupacion.Nbre_Ocupacion="+"'"+cadcargo+"'";
           cargohc=objvalidarGHC.buscarcadena(sqlcargo,1);
       }
       else{if(gingresoPM.JFTCargoAspira.getText().compareTo("")!=0){
                // System.out.println("san luz:");
                 guardarocupacion(gingresoPM.JFTCargoAspira.getText());
                 sqlcargo="select *from ocupacion where ocupacion.Nbre_Ocupacion="+"'"+gingresoPM.JFTCargoAspira.getText()+"'";
                 cargohc=objvalidarGHC.buscarcadena(sqlcargo,1);
             }//fin del if
       }//FIN DEL ELSE PROBLEMA
       caddescrcargo=gingresoPM.JTADescrCargo.getText();
       if(objvalidarGHC.validarcombonulo(gingresoPM.JCBEmpresa) ==0) {
             cadempresa=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBEmpresa);
             sqlempresa="select *from empresa where empresa.nombre_empresa="+"'"+cadempresa+"'";
             empresahc=objvalidarGHC.buscarcadena(sqlempresa,1);
       }
       else{
           if(gingresoPM.JFTEmpresa.getText().compareTo("")!=0){
                guardarempresa(gingresoPM.JFTEmpresa.getText());
                sqlempresa="select *from empresa where empresa.nombre_empresa="+"'"+gingresoPM.JFTEmpresa.getText()+"'";
                empresahc=objvalidarGHC.buscarcadena(sqlempresa,1);
             }
       }//fin else
       //
       if(objvalidarGHC.validarcombonulo(gingresoPM.JCBTipoEmpr) ==0) {
           cadtipoempresa=objvalidarGHC.evaluarcombocadena(gingresoPM.JCBTipoEmpr);
           sqltipoempresa="select *from tipo_industria where tipo_industria.nombre_tindustria="+"'"+cadtipoempresa+"'";
          empresatipohc=objvalidarGHC.buscarcadena(sqltipoempresa,1);

       }
       else{if(gingresoPM.JFTTipEmpr.getText().compareTo("")!=0){
               guardartipoempr(gingresoPM.JFTTipEmpr.getText());
               sqltipoempresa="select *from tipo_industria where tipo_industria.nombre_tindustria="+"'"+gingresoPM.JFTTipEmpr.getText()+"'";
               empresatipohc=objvalidarGHC.buscarcadena(sqltipoempresa,1);
           }
       }

       //
       sqlcadingreso="UPDATE ingreso SET ingreso.NoHC_ingreso='"  +idNDocpaciente+"',ingreso.idtipoex_ingreso="+tipexhc+",ingreso.idciudadexam_ingreso="+municipioexchc+",ingreso.idempresa_ingreso="+empresahc+",ingreso.idtipoindustria_ingreso="+empresatipohc+",ingreso.idjornadatrabajo_ingreso="+jorhc+",ingreso.idmedico_ingreso="+medtratantehc+",ingreso.cargoaspira_ingreso="+cargohc+",ingreso.descripcioncargo_ingreso='"+caddescrcargo+"',ingreso.elemguantes_ingreso="+gingresoPM.JCHGuantes.isSelected()+",ingreso.elemrespi_ingreso="+gingresoPM.JCHProtcResp.isSelected()+",ingreso.elemauditiva_ingreso="+gingresoPM.JCHAuditiva.isSelected()+",ingreso.elemvisual_ingreso="+gingresoPM.JCHVisual.isSelected()+",ingreso.elemotros_ingreso="+gingresoPM.JCHOtros.isSelected()+",ingreso.descrotros_ingreso='"+gingresoPM.JFTOtros.getText()+"',ingreso.observacion_ingreso='"+gingresoPM.JTAObservacion.getText()+"',ingreso.pendiente_ingreso="+1+",ingreso.horaentrada_ingreso='"+objvalidarGHC.formatohora()+"' where ingreso.id_ingreso='"+gingresoPM.numingredic+"'";
       try{  System.out.println("ceci impr"+sqlcadingreso);
           TSentenciaGuardarhc=con2.createStatement();
           vardatoingreso=TSentenciaGuardarhc.executeUpdate(sqlcadingreso);
      }//cierra el try
        catch(SQLException e){
              con2.rollback();
              cad1="NO SE PUDO ACTUALIZAR EL INGRESO";
              cad2="PROBLEMAS CON EL INGRESO";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
       Cconsql.CerrarConexion();
       gingresoPM.JFTHoraAtencion.setText(objvalidarGHC.formatohora());
       return vardatoingreso;

    }

    /**
     * actualizarho
     */
    public int actualizarho(CHistoriaOcup framehistocup)throws SQLException {
        Connection con2=Cconsql.getConnection();
        TSentenciaGuardarhc=con2.createStatement();
        int varho=0,ifilho=0;String sqlho;
        if(framehistocup.JTabHO.getRowCount()>1){
            while(ifilho<framehistocup.JTabHO.getRowCount()-1){
              sqlho="UPDATE historiaocupacional SET historiaocupacional.nombempresa_ho='"+framehistocup.modeloho.getValueAt(ifilho,0)+"',historiaocupacional.fechaini_ho='"+framehistocup.modeloho.getValueAt(ifilho,1)+"',historiaocupacional.fechafin_ho='"+framehistocup.modeloho.getValueAt(ifilho,2)+"',historiaocupacional.tiempoempresa_ho='"+framehistocup.modeloho.getValueAt(ifilho,3)+"',historiaocupacional.cargo_ho='"+framehistocup.modeloho.getValueAt(ifilho,4)+"',historiaocupacional.factorriesgo_ho='"+1+"',historiaocupacional.elemriesgo_ho='"+1+"',historiaocupacional.tiempoexposicion_ho='"+framehistocup.modeloho.getValueAt(ifilho,7)+"',historiaocupacional.empresanueva_ho="+framehistocup.modeloho.getValueAt(ifilho,6)+" where historiaocupacional.idingreso_ho='"+framehistocup.numingredicEP+"'";
              try{
               varho=TSentenciaGuardarhc.executeUpdate(sqlho);

              }//cierra el try
              catch(SQLException e){
                  System.out.println("DAMARIS:"+e.getMessage());
                  con2.rollback();
                  cad1="NO SE PUDO ACTUALIZAR LA HISTORIA OCUPACIONAL";
                  cad2="TABLA HISTORIA OCUPACIONAL";
                  objvalidarGHC.mensajeconfirmacion(cad1,cad2);
              }//cierra el catch
                Cconsql.CerrarConexion();
                ifilho=ifilho+1;
              }//fin del while

        }
        else{
            System.out.println("USUARIO NALGONA:");
            varho=1;
        }
        return varho;
    }

    public int actualizarep(CEnfermedadProf frameenfermedadprof)throws SQLException {
        Connection con2=Cconsql.getConnection();
        TSentenciaGuardarhc=con2.createStatement();
        int varep=0,ifilep=0;String sqlep;
        if(frameenfermedadprof.JTBenfPer.getRowCount()>1){
            while(ifilep<frameenfermedadprof.JTBenfPer.getRowCount()-1){
               sqlep="UPDATE enfermedad_profesional SET enfermedad_profesional.nombrempresa_EP='"+frameenfermedadprof.modeloep.getValueAt(ifilep,0)+"',enfermedad_profesional.fecha_EP='"+frameenfermedadprof.modeloep.getValueAt(ifilep,1)+"',enfermedad_profesional.diagnostico_EP='"+frameenfermedadprof.modeloep.getValueAt(ifilep,2)+"',enfermedad_profesional.medico_EP='"+frameenfermedadprof.modeloep.getValueAt(ifilep,3)+"'where enfermedad_profesional.idingreso_EP='"+frameenfermedadprof.numingredicAT+"'";
            try{
                varep=TSentenciaGuardarhc.executeUpdate(sqlep);

               }//cierra el try
               catch(SQLException e){
                   e.getMessage();
                   con2.rollback();
                   cad1="NO SE PUDO ACTUALIZAR LA ENFERMEDAD PROFESIONAL";
                   cad2="TABLA ENFERMEDAD PROFESIONAL";
                   objvalidarGHC.mensajeconfirmacion(cad1,cad2);
               }//cierra el catch
                   // Cconsql.CerrarConexion();
                 ifilep=ifilep+1;
               }//fin del while

        }
        else{
            //System.out.println("USUARIO NALGONA:");
            varep=1;
        }
        return varep;
    }

    public int actualizarat(CHistoriaAcciTrab frameaccitrabajo) throws SQLException {
        Connection con2=Cconsql.getConnection();
        int varat=0,ifilat=0;String sqlat;
        if(frameaccitrabajo.JTBHAccTra.getRowCount()>1){
            while(ifilat<frameaccitrabajo.JTBHAccTra.getRowCount()-1){
               sqlat="UPDATE accidentes_trabajo SET accidentes_trabajo.empresa_accitrabajo='"+frameaccitrabajo.modeloat.getValueAt(ifilat,0)+"',accidentes_trabajo.fecha_accitrabajo='"+frameaccitrabajo.modeloat.getValueAt(ifilat,1)+"',accidentes_trabajo.causa_accitrabajo='"+frameaccitrabajo.modeloat.getValueAt(ifilat,2)+"',accidentes_trabajo.tipolesion_accitrabajo='"+frameaccitrabajo.modeloat.getValueAt(ifilat,3)+"',accidentes_trabajo.parteafectada_accitrabajo='"+frameaccitrabajo.modeloat.getValueAt(ifilat,4)+"',accidentes_trabajo.incapacidad_accitrabajo='"+frameaccitrabajo.modeloat.getValueAt(ifilat,5)+"',accidentes_trabajo.secuelas_accitrabajo='"+frameaccitrabajo.modeloat.getValueAt(ifilat,6)+"'where accidentes_trabajo.idingreso_accitrabajo='"+frameaccitrabajo.numingredicAF+"'";
            try{
                varat=TSentenciaGuardarhc.executeUpdate(sqlat);

               }//cierra el try
               catch(SQLException e){
                   e.getMessage();
                   con2.rollback();
                   cad1="NO SE PUDO ACTUALIZAR ACCIDENTES DE TRABAJO";
                   cad2="TABLA ACCIDENTES DE TRABAJO";
                   objvalidarGHC.mensajeconfirmacion(cad1,cad2);
               }//cierra el catch
                   // Cconsql.CerrarConexion();
                 ifilat=ifilat+1;
               }//fin del while
        }
        else{

           varat=1;
       }
        return varat;
    }

    public int actualizaraf(CAntecedentesFamiliar frameantecendnetesfam) throws SQLException{
        int varantfam=0;
        String sqlaf;
        Connection con2=Cconsql.getConnection();
        TSentenciaGuardarhc=con2.createStatement();
        sqlaf="UPDATE antecedentes_familiar SET antecedentes_familiar.hipertension_familiar="+frameantecendnetesfam.JCHHta.isSelected()+",antecedentes_familiar.texthipertension_familiar='"+frameantecendnetesfam.JTFHta.getText()+"',antecedentes_familiar.diabetes_familiar="+frameantecendnetesfam.JCHDiabet.isSelected()+",antecedentes_familiar.textdiabetes_familiar='"+frameantecendnetesfam.JTFDiab.getText()+"',antecedentes_familiar.cancer_familiar="+frameantecendnetesfam.JCHCancer.isSelected()+",antecedentes_familiar.textcancer_familiar='"+frameantecendnetesfam.JTFCancer.getText()+"',antecedentes_familiar.cardio_familiar="+frameantecendnetesfam.JCHCardiopatias.isSelected()+",antecedentes_familiar.textcardio_familiar='"+frameantecendnetesfam.JTFCardiopatias.getText()+"',antecedentes_familiar.epilepsia_familiar="+frameantecendnetesfam.JCHEpilepsia.isSelected()+",antecedentes_familiar.textepilepsia_familiar='"+frameantecendnetesfam.JTFEpilepsia.getText()+"',antecedentes_familiar.otros_familiar="+frameantecendnetesfam.JCHOtros.isSelected()+",antecedentes_familiar.textotros_familiar='"+frameantecendnetesfam.JTFOtros.getText()+"'where antecedentes_familiar.idingreso_familiar='"+frameantecendnetesfam.numingredicAP+"'";
        try{ if(frameantecendnetesfam.JCHHta.isSelected()||frameantecendnetesfam.JCHDiabet.isSelected()||frameantecendnetesfam.JCHCancer.isSelected()||frameantecendnetesfam.JCHCardiopatias.isSelected()||frameantecendnetesfam.JCHEpilepsia.isSelected()||frameantecendnetesfam.JCHOtros.isSelected()){
                varantfam=TSentenciaGuardarhc.executeUpdate(sqlaf);
             }
             else
                 varantfam=1;
         }//cierra el try
         catch(SQLException e){
              System.out.println("TETAS:"+e.getMessage());
              con2.rollback();
              cad2="NO SE PUDO ACTUALIZAR LOS DATOS DE LOS ANTECEDENTES FAMILIARES";
              cad1="TABLA ANTECEDENTES FAMILIARES";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
          }//cierra el catch
        //Cconsql.CerrarConexion();
        return varantfam;

    }

    public int actualizarap(CAntecedentesPersonales frameantecpersonal)throws SQLException {
        int varantpersonal=0;
        String sqlap;
        Connection con2=Cconsql.getConnection();
        sqlap="UPDATE antecedentespersonal_pacientes SET antecedentespersonal_pacientes.diabetes_consap="+frameantecpersonal.JCHDiabet.isSelected()+",antecedentespersonal_pacientes.obsdiabetes_consap='"+frameantecpersonal.JTFDiabet.getText()+"',antecedentespersonal_pacientes.hiparterial_consap="+frameantecpersonal.JCHHipArt.isSelected()+",antecedentespersonal_pacientes.obshiparterial_consap='"+frameantecpersonal.JTFHiperArt.getText()+"',antecedentespersonal_pacientes.coronario_consap="+frameantecpersonal.JCHCoronario.isSelected()+",antecedentespersonal_pacientes.obscoronario_consap='"+frameantecpersonal.JFTCoronario.getText()+"',antecedentespersonal_pacientes.dislipidemia_consap="+frameantecpersonal.JCHDislipedia.isSelected()+",antecedentespersonal_pacientes.obsdislipidemia_consap='"+frameantecpersonal.JTFDislipidemia.getText()+"',antecedentespersonal_pacientes.asmabronq_consap="+frameantecpersonal.JCHAsmaBronq.isSelected()+",antecedentespersonal_pacientes.obsasmabronq_consap='"+frameantecpersonal.JTFAsmaBronquial.getText()+"',antecedentespersonal_pacientes.psicopatia_consap="+frameantecpersonal.JCHPsicopatia.isSelected()+",antecedentespersonal_pacientes.obspsicopatia_consap='"+frameantecpersonal.JTFPsicopatia.getText()+"',antecedentespersonal_pacientes.alergia_consap="+frameantecpersonal.JCHAlergiaAp.isSelected()+",antecedentespersonal_pacientes.obsalergia_consap='"+frameantecpersonal.JTFAlergiaAP.getText()+"',antecedentespersonal_pacientes.tuberculosis_consap="+frameantecpersonal.JCHTuberculosisAP.isSelected()+",antecedentespersonal_pacientes.obstuberculosis_consap='"+frameantecpersonal.JTFTuberculosisAP.getText()+"',antecedentespersonal_pacientes.atipia_consap="+frameantecpersonal.JCHAtipiaAP.isSelected()+",antecedentespersonal_pacientes.obsatipia_consap='"+frameantecpersonal.JTFAtipiaAP.getText()+"',antecedentespersonal_pacientes.gota_consap="+frameantecpersonal.JCHGotaAP.isSelected()+",antecedentespersonal_pacientes.obsgota_consap='"+frameantecpersonal.JTFGotaAP.getText()+"',antecedentespersonal_pacientes.afeccbroncpulmon_consap="+frameantecpersonal.JCHAffBroncoAP.isSelected()+",antecedentespersonal_pacientes.obsafeccbroncpulmon_consap='"+frameantecpersonal.JTFAfccbroncpulm.getText()+"',antecedentespersonal_pacientes.endocrinopatia_consap="+frameantecpersonal.JCHEndocrinopatiasAP.isSelected()+",antecedentespersonal_pacientes.obsendocrinopatia_consap='"+frameantecpersonal.JTFEndocrinopatiasAP.getText()+"',antecedentespersonal_pacientes.nefrologia_consap="+frameantecpersonal.JCHNefrologiasAP.isSelected()+",antecedentespersonal_pacientes.obsnefrologia_consap='"+frameantecpersonal.JTNefrologiasAP.getText()+"',antecedentespersonal_pacientes.riopatia_consap="+frameantecpersonal.JCHPatiasAP.isSelected()+",antecedentespersonal_pacientes.obsriopatia_consap='"+frameantecpersonal.JTFPatiasAP.getText()+"',antecedentespersonal_pacientes.hemopatias_consap="+frameantecpersonal.JCHHemopatiasAP.isSelected()+",antecedentespersonal_pacientes.obshemopatias_consap='"+frameantecpersonal.JTFHemopatias.getText()+"',antecedentespersonal_pacientes.ets_consap="+frameantecpersonal.JCHEtsAP.isSelected()+",antecedentespersonal_pacientes.obsets_consap='"+frameantecpersonal.JTFETSap.getText()+"',antecedentespersonal_pacientes.ulcgastroduod_consap="+frameantecpersonal.JCHUlceraGastr.isSelected()+",antecedentespersonal_pacientes.obsulcgastroduod_consap='"+frameantecpersonal.JTFUlcGastrDuodAP.getText()+"',antecedentespersonal_pacientes.colecistopatia_consap="+frameantecpersonal.JCHColecistopatiaAP.isSelected()+",antecedentespersonal_pacientes.obscolecistopatia_consap='"+frameantecpersonal.JTFColecistopatia.getText()+"',antecedentespersonal_pacientes.hepatitis_consap="+frameantecpersonal.JCHHepatitis.isSelected()+",antecedentespersonal_pacientes.obshepatitis_consap='"+frameantecpersonal.JTFHepatitis.getText()+"',antecedentespersonal_pacientes.enfneurologicas_consap="+frameantecpersonal.JCHEnfNeurologicaEP.isSelected()+",antecedentespersonal_pacientes.obsenfneurologicas_consap='"+frameantecpersonal.JTFEnfNeurologAP.getText()+"',antecedentespersonal_pacientes.fiebresprolong_consap="+frameantecpersonal.JCHFiebresProAP.isSelected()+",antecedentespersonal_pacientes.obsfiebresprolong_consap='"+frameantecpersonal.JFTFiebresProlongAP.getText()+"',antecedentespersonal_pacientes.colageno_consap="+frameantecpersonal.JCHColagenopatias.isSelected()+",antecedentespersonal_pacientes.obscolageno_consap='"+frameantecpersonal.JFTColagenopatias.getText()+"',antecedentespersonal_pacientes.traumatismo_consap="+frameantecpersonal.JCHTraumatismo.isSelected()+",antecedentespersonal_pacientes.obstraumatismo_consap='"+frameantecpersonal.JTFTraumatismo.getText()+"',antecedentespersonal_pacientes.otros_consap="+frameantecpersonal.JCHOtros.isSelected()+",antecedentespersonal_pacientes.obsotros_consap='"+frameantecpersonal.JTFOtros.getText()+"' where antecedentespersonal_pacientes.idingreso_consap='"+frameantecpersonal.numingredicGO+"'";;
        try{
            if(frameantecpersonal.JCHAffBroncoAP.isSelected()||frameantecpersonal.JCHAlergiaAp.isSelected()||frameantecpersonal.JCHAsmaBronq.isSelected()||frameantecpersonal.JCHAtipiaAP.isSelected()||frameantecpersonal.JCHColagenopatias.isSelected()||frameantecpersonal.JCHColecistopatiaAP.isSelected()||frameantecpersonal.JCHCoronario.isSelected()||frameantecpersonal.JCHDiabet.isSelected()||frameantecpersonal.JCHDislipedia.isSelected()||frameantecpersonal.JCHEndocrinopatiasAP.isSelected()||frameantecpersonal.JCHEnfNeurologicaEP.isSelected()||frameantecpersonal.JCHEtsAP.isSelected()||frameantecpersonal.JCHFiebresProAP.isSelected()||frameantecpersonal.JCHGotaAP.isSelected()||frameantecpersonal.JCHHemopatiasAP.isSelected()||frameantecpersonal.JCHHepatitis.isSelected()||frameantecpersonal.JCHHipArt.isSelected()||frameantecpersonal.JCHNefrologiasAP.isSelected()||frameantecpersonal.JCHOtros.isSelected()||frameantecpersonal.JCHPatiasAP.isSelected()||frameantecpersonal.JCHPsicopatia.isSelected()||frameantecpersonal.JCHTraumatismo.isSelected()||frameantecpersonal.JCHTuberculosisAP.isSelected()||frameantecpersonal.JCHUlceraGastr.isSelected()){
               varantpersonal=TSentenciaGuardarhc.executeUpdate(sqlap);
            }
            else
             varantpersonal=1;
        }//cierra el try
        catch(SQLException e){
             e.getMessage();
             con2.rollback();
             cad2="NO SE PUDO ACTUALIZAR LOS DATOS DE LOS ANTECEDENTES PERSONALES";
             cad1="TABLA ANTECEDENTES PERSONALES";
             objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
         Cconsql.CerrarConexion();

        return varantpersonal;


    }

    public int actualizarog(CAGineco frameginecologia)throws SQLException  {
        int vargineco=0,imen,iplan,ires;
        String sqlgineco,cadtipomen,cadtipoplan,cadtipores;
        Connection con2=Cconsql.getConnection();
        TSentenciaGuardarhc=con2.createStatement();
        String tipomen=objvalidarGHC.evaluarcombocadena(frameginecologia.JCMenarquia);
        cadtipomen="select *from menarquia where menarquia.rango_mquia="+"'"+tipomen+"'";
        imen=objvalidarGHC.evaluarcadenaentera(cadtipomen);
        String plan=objvalidarGHC.evaluarcombocadena(frameginecologia.JCPlanifica);
        cadtipoplan = "select *from planifica where planifica.nombre_planif="+"'"+plan+"'";
        iplan=objvalidarGHC.evaluarcadenaentera(cadtipoplan);
        String res=objvalidarGHC.evaluarcombocadena(frameginecologia.JCResultado);
        cadtipores = "select *from resultados_gineco where resultados_gineco.nombre_resgico="+"'"+res+"'";
        ires=objvalidarGHC.evaluarcadenaentera(cadtipores);
        sqlgineco="UPDATE  ginecologia SET ginecologia.idmenarquia_gineco="+imen + ",ginecologia.ciclos_gineco='"+frameginecologia.JTFCiclos.getText()+ "',ginecologia.fechaultregla_gineco='"+frameginecologia.JFTFechUltMestr.getText() + "',ginecologia.gravidez_gineco="+ frameginecologia.JCHGravid.isSelected() + ",ginecologia.paridad_gineco='"+ frameginecologia.JTFParidad.getText() + "',ginecologia.cesarea_gineco="+ frameginecologia.JCHCesarea.isSelected() + ",ginecologia.aborto_gineco="+frameginecologia.JCHAborto.isSelected() + ",ginecologia.planifica_gineco="+frameginecologia.JCHPlanifica.isSelected() +",ginecologia.idplanifica_gineco="+iplan + ",ginecologia.fechaultcitologia_gineco='" +frameginecologia.JFTFechUltCit.getText() + "',ginecologia.idresultadocitologia_gineco="+ires+ ",ginecologia.tiempoplanifica_gineco='"+frameginecologia.JFTTiempoPlan.getText() + "' where ginecologia.idingreso_gineco='"+frameginecologia.numingredicIZ+"'";
        try{
             if(imen!=1){
                 vargineco=TSentenciaGuardarhc.executeUpdate(sqlgineco);
             }
             else
                 vargineco=1;
            }//cierra el try
        catch(SQLException e){
              con2.rollback();
              cad2="NO SE PUDO ACTUALIZAR LOS DATOS DE GINECOLOGIA";
              cad1="TABLA GINECOLOGIA";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
        }//cierra el catch
        Cconsql.CerrarConexion();
        return vargineco;
    }

    public int actualizariz(CInmuniz frameinmunuz)throws SQLException {
         int varinmuniz=0;
         String sqlinmun;System.out.println("USUARIO NALGONA:"+frameinmunuz.JCHfa.isSelected());
         Connection con2=Cconsql.getConnection();
         TSentenciaGuardarhc=con2.createStatement();
         sqlinmun="UPDATE inmunizaciones SET tetano_inmuniz="+frameinmunuz.JCHTetano.isSelected() + ",fechatet_inmuniz='"+frameinmunuz.JLBFechaVac.getText() + "',fiebreamarilla_inmuniz="+frameinmunuz.JCHfa.isSelected() + ",fechafiebre_inmuniz='"+frameinmunuz.JTFFechafa.getText() + "',hepatitis_inmuniz="+frameinmunuz.JCHHepat.isSelected() + ",fechahep_inmuniz='"+frameinmunuz.JTFFechaHep.getText() + "',otras_inmuniz="+frameinmunuz.JCHOtraVac.isSelected() + ",fecha_inmuniz='"+frameinmunuz.JTFFechaOtrVac.getText() + "',cualotras_inmuniz='" +frameinmunuz.JTFOtrosIN.getText()+"' where inmunizaciones.idingreso_inmuniz='"+frameinmunuz.numingredicOA+"'";
         try{
             if (frameinmunuz.JCHfa.isSelected() ||frameinmunuz.JCHHepat.isSelected()||frameinmunuz.JCHOtraVac.isSelected()||frameinmunuz.JCHTetano.isSelected())
             {
               varinmuniz = TSentenciaGuardarhc.executeUpdate(sqlinmun);
             }
             else{
               varinmuniz = 1;
             }
         }
         catch(SQLException e){
              System.out.println("lorents:"+e.getMessage());
              con2.rollback();
              cad2="NO SE PUDO ACTUALIZAR LOS DATOS DE INMUNIZACION";
              cad1="TABLA INMUNIZACION";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
        }//cierra el catch
        Cconsql.CerrarConexion();

        return varinmuniz;
    }

    public int actualizaroa(COtrosAnt frameotrosantecedentes)throws SQLException {
        int varotrosantec=0;
        String sqloa;
        Connection con2=Cconsql.getConnection();
        TSentenciaGuardarhc=con2.createStatement();
        sqloa="UPDATE otrosantecedentes SET tabaco_otrosdat="+frameotrosantecedentes.JCHTabaco.isSelected() +",frecuenciatab_otrosdat='"+frameotrosantecedentes.JTFTabaquismo.getText()+ "',anostab_otrosdat='"+frameotrosantecedentes.JTFAnos.getText() + "',licor_otrosdat="+ frameotrosantecedentes.JCHLicor.isSelected()+ ",frecuencialicor_otrosdat='"+frameotrosantecedentes.JTFIngestaLicor.getText() + "',anoslicor_otrosdat='"+frameotrosantecedentes.JTFAnosLicor.getText()+"',deportre_otrosdat="+frameotrosantecedentes.JCHPractDep.isSelected()+",frecuenciadeporte_otrosdat='"+frameotrosantecedentes.JTFPractDeport.getText() + "',anosdeporte_otrosdat='"+frameotrosantecedentes.JTFAnosPD.getText()+ "',otros_otrosdat="+frameotrosantecedentes.JCHOtros.isSelected()+",frecuenciaotros_otrosdat='"+frameotrosantecedentes.JTFOtr.getText() + "',anosotros_otrosdat='"+ frameotrosantecedentes.JTFOtrosAnos.getText()+ "',psicoadicti_otrosdat=" +frameotrosantecedentes.JCHSust.isSelected()+",frecuenciapsicoadicti_otrosdat='"+frameotrosantecedentes.JTFFrecAditc.getText()+ "',anospsicoadicti_otrosdat='"+ frameotrosantecedentes.JTFAnAdicc.getText()+ "' where otrosantecedentes.idingreso_otrosdat='"+frameotrosantecedentes.numingredicRS+"'";
        try{if (frameotrosantecedentes.JCHLicor.isSelected()||frameotrosantecedentes.JCHOtros.isSelected()||frameotrosantecedentes.JCHPractDep.isSelected()||frameotrosantecedentes.JCHTabaco.isSelected()){
             varotrosantec=TSentenciaGuardarhc.executeUpdate(sqloa);
            }
            else
             varotrosantec=1;
        }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad2="NO SE PUDO ACTUALIZAR LOS DATOS DE OTROS ANTECEDENTES";
              cad1="TABLA OTROS ANTECEDENTES";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
        }//cierra el catch
        Cconsql.CerrarConexion();
        return varotrosantec;
    }

    public int actualizarrs(CRevisionSistemas framers)throws SQLException {
         System.out.println("sara impr:");
        int varrs=0;
        String sqlrs;
        Connection con2=Cconsql.getConnection();
        TSentenciaGuardarhc=con2.createStatement();
        boolean DolorPrecordialbol,Lipotimiabol,Palpitacionesbol,Sincopebol,Disneabol,Descamacionbol,Eritemabol,Hiperhidrosisbol,Brotebol,Sequedadbol,Pruritobol,Dispepsiabol,DolorAbdominalbol,Epigastraigiabol,Estrenimientobol,Diarreabol,Sangradobol,DisminucionCalibrebol,Disuriabol,Hematuriabol,TranstCicloMestrualbol;
        boolean Nicturiabol,Palaquiuriabol,Cefaleabol,AlteracionMemoriabol,AlteracionSensibilidadbol,AlteracionMotorabol,Vertigobol;
        boolean Ardorbol,Cansanciobol,VisionBorrosabol,Lagrimeobol,OjoRojobol,Tosbol,DolorToraxicobol,Expectoracionbol;
        boolean Cervicalgiabol,Dorsalgiabol,Lumbalgiabol,Incapacitantebol,Artralgiasbol,Tendinitisbol,LimitacionFuncionalbol;
        boolean Parestesiasbol,Disfoniabol,Epistaxisbol,Hipoacusiabol,ObstruccionNasalbol,Rinorreabol,Tinitusbol;
        boolean TenesmoVesical,Coronaria,Arritmia,Ha;
        DolorPrecordialbol=estadoradio(framers.JRDolorPrecordial);
        Lipotimiabol=estadoradio(framers.JRLipotimia);
        Palpitacionesbol=estadoradio(framers.JRPalpitaciones);
        Sincopebol=estadoradio(framers.JRSincope);
        Disneabol=estadoradio(framers.JRDisnea);
        Descamacionbol=estadoradio(framers.JRDescamacion);
        Eritemabol=estadoradio(framers.JREritema);
        Hiperhidrosisbol=estadoradio(framers.JRHiperhidrosis);
        Brotebol=estadoradio(framers.JRBrote);
        Sequedadbol=estadoradio(framers.JRSequedad);
        Pruritobol=estadoradio(framers.JRPrurito);
        Dispepsiabol=estadoradio(framers.JRDispepsia);
        DolorAbdominalbol=estadoradio(framers.JRDolorAbdominal);
        Epigastraigiabol=estadoradio(framers.JREpigastraigia);
        Estrenimientobol=estadoradio(framers.JREstrenimiento);
        Diarreabol=estadoradio(framers.JRDiarrea);
        Sangradobol=estadoradio(framers.JRSangrado);
        DisminucionCalibrebol=estadoradio(framers.JRDisminucionCalibre);
        Disuriabol=estadoradio(framers.JRDisuria);
        Hematuriabol=estadoradio(framers.JRHematuria);
        TranstCicloMestrualbol=estadoradio(framers.JRTrantCicloMestr);
        Nicturiabol=estadoradio(framers.JRNicturia);
        Palaquiuriabol=estadoradio(framers.JRPolaquiuria);
        Cefaleabol=estadoradio(framers.JRCefalea);
        AlteracionMemoriabol=estadoradio(framers.JRAlteracionMemoria);
        AlteracionSensibilidadbol=estadoradio(framers.JRAlteracionSensib);
        AlteracionMotorabol=estadoradio(framers.JRAlteracionMotora);
        Vertigobol=estadoradio(framers.JRVertigo);
        Ardorbol=estadoradio(framers.JRArdorprurito);
        Cansanciobol=estadoradio(framers.JRCansancio);
        VisionBorrosabol=estadoradio(framers.JRVisionBorrosa);
        Lagrimeobol=estadoradio(framers.JRLagrimeo);
        OjoRojobol=estadoradio(framers.JROjoRojo);
        Tosbol=estadoradio(framers.JRTos);
        DolorToraxicobol=estadoradio(framers.JRDolorToraxico);
        Expectoracionbol=estadoradio(framers.JRExpectoracion);
        Cervicalgiabol=estadoradio(framers.JRCervicalgia);
        Dorsalgiabol=estadoradio(framers.JRDorsalgia);
        Lumbalgiabol=estadoradio(framers.JRLumbalgia);
        Incapacitantebol=estadoradio(framers.JRIncapacitante);
        Artralgiasbol=estadoradio(framers.JRArtralgias);
        Tendinitisbol=estadoradio(framers.JRTendinitis);
        LimitacionFuncionalbol=estadoradio(framers.JRLimitacionFuncional);
        Parestesiasbol=estadoradio(framers.JRParentestesias);
        Disfoniabol=estadoradio(framers.JRDisfonia);
        Epistaxisbol=estadoradio(framers.JREpistaxis);
        Hipoacusiabol=estadoradio(framers.JRHipoacusia);
        ObstruccionNasalbol=estadoradio(framers.JRObstruccionNasal);
        Rinorreabol=estadoradio(framers.JRRinorrea);
        Tinitusbol=estadoradio(framers.JRTinitus);
        TenesmoVesical=estadoradio(framers.JRTenesmoVesical);
        Coronaria=estadoradio(framers.JRCoronaria);
        Arritmia=estadoradio(framers.JRArritmia);
        Ha=estadoradio(framers.JRHa);
        sqlrs="UPDATE subgrupo_revsistemas SET iddoloprecordial_rss="+DolorPrecordialbol  +",obsdolorprecordial_rss='"+framers.JFTDolorPrecordial.getText()+"',idlipotimia_rss="+Lipotimiabol+",obslipotimia_rss='"+framers.JFTLipotimia.getText()+"',idpalpitaciones_rss="+Palpitacionesbol+",obspalpitaciones_rss='"+framers.JFTPalpit.getText()+"',idsincope_rss="+Sincopebol+",obssincope_rss='"+framers.JFTSincope.getText()+"',iddescamacion_rss="+Descamacionbol+",obsdescamacion_rss='"+framers.JFTdescam.getText()+"',ideritema_rss="+Eritemabol+",obseritema_rss='"+framers.JFTEritema.getText()+"',idhipehidrosis_rss="+Hiperhidrosisbol+",obshiperhidrosis_rss='"+framers.JFTHiperhidrosis.getText()+"',idbrote_rss="+Brotebol+",obsbrote_rss='"+framers.JFTBrote.getText()+"',idsequedad_rss="+Sequedadbol+",obssequedad_rss='"+framers.JFTSequedad.getText()+"',idprurito_rss="+Pruritobol+",obsprurito_rss='"+framers.JFTprurito.getText()+"',iddispepsia_rss="+Dispepsiabol+",obsdispepsia_rss='"+framers.JFTDispepsia.getText()+"',iddolorabdominal_rss="+DolorAbdominalbol+",obsdolorabdominal_rss='"+framers.JFTDolorAbd.getText()+"',idepigastralgiapirosis_rss="+Epigastraigiabol+",obsepigastralgiapirosis_rss='"+framers.JFTEpigastr.getText()+"',idestrenimiento_rss="+Estrenimientobol+",obsestre�imiento_rss='"+framers.JFTEstrenimiento.getText()+"',iddiarrea_rss="+Diarreabol+",obsdiarrea_rss='"+framers.JFTDiarrea.getText()+"',idsangrado_rss="+Sangradobol+",obssangrado_rss='"+framers.JFTSangrado.getText()+"',iddisminucioncalibre_rss="+DisminucionCalibrebol+",obsdisminucioncalibre_rss='"+framers.JFTDisminucionCalibre.getText()+"',iddisuria_rss="+Disuriabol+",obsdisuria_rss='"+framers.JFTDisuria.getText()+"',idhematuria_rss="+Hematuriabol+",obshematuria_rss='"+framers.JFTHematuria.getText()+"',idtranstciclomestrual_rss="+TranstCicloMestrualbol+",obstranstciclomestrual_rss='"+framers.JFTtranstCicloMestr.getText()+"',idnicturia_rss="+Nicturiabol+",obsnicturia_rss='"+framers.JFTNicturia.getText()+"',idpolaquiuria_rss="+Palaquiuriabol+",obspolaquiuria_rss='"+framers.JFTPalquiuria.getText()+"',idtenesmovesical_rss="+TenesmoVesical+",obstenesmovesical_rss='"+framers.JFTTenesmovesical.getText()+"',idcefalea_rss="+Cefaleabol+",obscefalea_rss='"+framers.JFTCefalea.getText()+"',idalteracionmemoria_rss="+AlteracionMemoriabol+",obsalteracionmemoria_rss='"+framers.JFTAlteracionMemoria.getText()+"',idalteracionsensibilidad_rss="+AlteracionSensibilidadbol+",obsalteracionsensibilidad_rss='"+framers.JFTAlteracionSencib.getText()+"',idalteracionmotora_rss="+AlteracionMotorabol+",obsalteracionmotora_rss='"+framers.JFTAlteracMotora.getText()+"',idvertigo_rss="+Vertigobol+",obsvertigo_rss='"+framers.JFTVertigo.getText()+"',idardorprurito_rss="+Ardorbol+",obsardorprurito_rss='"+framers.JFTArdorPrurito.getText()+"',idcansansio_rss="+Cansanciobol+",obscansansio_rss='"+framers.JFTCansancio.getText()+"',idvisionborrosa_rss="+VisionBorrosabol+",obsvisionborrosa_rss='"+framers.JFTVisionBorrosa.getText()+"',idlagrimeo_rss="+Lagrimeobol+",obslagrimeo_rss='"+framers.JFTLagrimeo.getText()+"',idojorojo_rss="+OjoRojobol+",obsojorojo_rss='"+framers.JFTOjoRojo.getText()+"',iddisfonia_rss="+Disfoniabol+",obsdisfonia_rss='"+framers.JFTDisfonia.getText()+"',idepistaxis_rss="+Epistaxisbol+",obsepistaxis_rss='"+framers.JFTEpistaxis.getText()+"',idhipoacusiasubjetiva_rss="+Hipoacusiabol+",obshipoacusiasubjetiva_rss='"+framers.JFTHipoacusia.getText()+"',idobstruccionnasal_rss="+ObstruccionNasalbol+",obsobstruccionnasal_rss='"+framers.JFTObstruccionNasal.getText()+"',idrinorrea_rss="+Rinorreabol+",obsrinorrea_rss='"+framers.JFTRinorrea.getText()+"',idtinitus_rss="+Tinitusbol+",obstinitus_rss='"+framers.JFTTinitus.getText()+"',idcervicalgia_rss="+Cervicalgiabol+",obscervicalgia_rss='"+framers.JFTCervicalgia.getText()+"',iddorsalgia_rss="+Dorsalgiabol+",obsdorsalgia_rss='"+framers.JFTDorsalgia.getText()+"',idlumbalgia_rss="+Lumbalgiabol+",obslumbalgia_rss='"+framers.JFTLumbalgia.getText()+"',idincapacitante_rss="+Incapacitantebol+",obsincapacitante_rss='"+framers.JFTIncapacitante.getText()+"',idaltralgias_rss="+Artralgiasbol+",obsaltralgias_rss='"+framers.JFTArtralgias.getText()+"',idtendinitis_rss="+Tendinitisbol+",obstendinitis_rss='"+framers.JFTTendinitis.getText()+"',idlimitacionfuncional_rss="+LimitacionFuncionalbol+",obslimitacionfuncional_rss='"+framers.JFTLimitacionFunc.getText()+"',idparentesias_rss="+Parestesiasbol+",obsparentesias_rss='"+framers.JFTParestesias.getText()+"',idtos_rss="+Tosbol+",obstos_rss='"+framers.JFTTos.getText()+"',iddolortoraxico_rss="+DolorToraxicobol+",obsdolortoraxico_rss='"+framers.JFTDolorToraxico.getText()+"',idexpectoracion_rss="+Expectoracionbol+",obsexpectoracion_rss='"+framers.JFTExpectoracion.getText()+"',iddisnea_rss="+Disneabol+",obsdisnea_rss='"+framers.jFormattedTextField2.getText()+"'"+",idcoronaria_rss="+Coronaria+",obscoronaria_rss='"+framers.JFTCoronaria.getText()+"',idarritmia_rss="+Arritmia+",obsarritmia_rss='"+framers.JFTArritmia.getText()+"',ha_rss="+Ha+",obsha_rss='"+framers.JFTha.getText()+"' where subgrupo_revsistemas.idingreso_rss='"+framers.numingredicEF+"'";
        System.out.println("CONSUELO impr:"+sqlrs);
        try{if(framers.JRAlteracionMemoria.isSelected()||framers.JRAlteracionMotora.isSelected()||framers.JRAlteracionSensib.isSelected()||framers.JRArdorprurito.isSelected()||framers.JRArritmia.isSelected()||framers.JRArtralgias.isSelected()||framers.JRBrote.isSelected()||framers.JRCansancio.isSelected()||framers.JRCefalea.isSelected()||framers.JRCervicalgia.isSelected()||framers.JRCoronaria.isSelected()||framers.JRDescamacion.isSelected()||framers.JRDiarrea.isSelected()||framers.JRDisfonia.isSelected()||framers.JRDisminucionCalibre.isSelected()||framers.JRDisnea.isSelected()||framers.JRDispepsia.isSelected()||framers.JRDisuria.isSelected()||framers.JRDolorAbdominal.isSelected()||framers.JRDolorPrecordial.isSelected()||framers.JRDolorToraxico.isSelected()||framers.JRDorsalgia.isSelected()||framers.JREpigastraigia.isSelected()||framers.JREpistaxis.isSelected()||framers.JREpistaxis.isSelected()||framers.JREritema.isSelected()||framers.JREstrenimiento.isSelected()||framers.JRExpectoracion.isSelected()||framers.JRHa.isSelected()||framers.JRHematuria.isSelected()||framers.JRHiperhidrosis.isSelected()||framers.JRHipoacusia.isSelected()||framers.JRIncapacitante.isSelected()||framers.JRLagrimeo.isSelected()||framers.JRLimitacionFuncional.isSelected()||framers.JRLipotimia.isSelected()||framers.JRLumbalgia.isSelected()||framers.JRNicturia.isSelected()||framers.JRObstruccionNasal.isSelected()||framers.JROjoRojo.isSelected()||framers.JRPalpitaciones.isSelected()||framers.JRParentestesias.isSelected()||framers.JRPolaquiuria.isSelected()||framers.JRPrurito.isSelected()||framers.JRRinorrea.isSelected()||framers.JRSangrado.isSelected()||framers.JRSequedad.isSelected()||framers.JRSincope.isSelected()||framers.JRSincope.isSelected()||framers.JRTendinitis.isSelected()||framers.JRTenesmoVesical.isSelected()||framers.JRTinitus.isSelected()||framers.JRTos.isSelected()||framers.JRTrantCicloMestr.isSelected()||framers.JRVertigo.isSelected()||framers.JRVisionBorrosa.isSelected())
               varrs=TSentenciaGuardarhc.executeUpdate(sqlrs);
            else
                varrs=1;
        }//cierra el try
        catch(SQLException e){
              System.out.println("CONSUELO impr:"+ e.getMessage());
             // e.getMessage();
              con2.rollback();
              cad2="NO SE PUDO ACTUALIZAR LOS DATOS DE REVISION SISTEMAS";
              cad1="TABLA REVISION SISTEMAS";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
        }//cierra el catch
        Cconsql.CerrarConexion();
        return varrs;
    }

    public boolean estadoradio(JRadioButton JRBno) {
        boolean varestado=false;
       if(JRBno.isSelected()==true)
            varestado=true;
       else
           varestado=false;
       return varestado;

    }

    public int actualizaref(CExamenFisico frameef) throws SQLException {
        int varef=0,estadogeneralhc,ilat;
        String sqlef,cadtipolat;
        Connection con2=Cconsql.getConnection();
        TSentenciaGuardarhc=con2.createStatement();
        boolean cabebol,carabol,ojosbol,oidosbol,narizbol,bocabol,dentadurabol,cuellobol,toraxbol,cardiacobol,pulmonarbol,mamasbol,abdomenbol,genitalbol,msupbol,minfbol,piesbol,columnabol,neurologobol,pielbol;
        String sqlcadEF,cadestadogeneral,sqlestadogeneral;
        cadestadogeneral=objvalidarGHC.evaluarcombocadena(frameef.JCBEstadoGeneral);
        sqlestadogeneral="select *from estado_general where estado_general.nombre_ag="+"'"+cadestadogeneral+"'";
        estadogeneralhc=objvalidarGHC.evaluarcadenaentera(sqlestadogeneral);
        String tipolat=objvalidarGHC.evaluarcombocadena(frameef.JCBLateral);
        cadtipolat="select *from lateral where lateral.nombre_lateral="+"'"+tipolat+"'";
        ilat=objvalidarGHC.evaluarcadenaentera(cadtipolat);
       //SE ANALIZA TODOS LOS RADIO
       cabebol=estadoradio(frameef.JRnoCab);
       carabol=estadoradio(frameef.JRnoCara);
       ojosbol=estadoradio(frameef.JRnoOjosEF);
       oidosbol=estadoradio(frameef.JRnoOidos);
       narizbol=estadoradio(frameef.JRBnoNariz);
       bocabol=estadoradio(frameef.JRBnoBocaEF);
       dentadurabol=estadoradio(frameef.JRBnoDentEF);
       cuellobol=estadoradio(frameef.JRBnoCuelloEF);
       toraxbol=estadoradio(frameef.JRBnoToraxEF);
       cardiacobol=estadoradio(frameef.JRBnoCardiacoEF);
       pulmonarbol=estadoradio(frameef.JRBnoPulmonEF);
       mamasbol=estadoradio(frameef.JRBnomamasEF);
       abdomenbol=estadoradio(frameef.JRBnoAbdomenEF);
       genitalbol=estadoradio(frameef.JRBnoGenitalesEF);
       msupbol=estadoradio(frameef.JRBnoMsupEF);
       minfbol=estadoradio(frameef.JRnoMinfEF);
       pielbol=estadoradio(frameef.JRBnoPielEF);
       columnabol=estadoradio(frameef.JRBnoColEF);
       neurologobol=estadoradio(frameef.JRBnoNeurl);
       piesbol=estadoradio(frameef.JRBnoPielEF);
       sqlcadEF="UPDATE examen_fisico  SET  estadogen_EF="+estadogeneralhc  +",tasignovital_EF='"+frameef.JFTTaEF.getText()+"',fcsignovita_EF='"+frameef.JFTfcEF.getText()+"',frsignovital_EF='"+frameef.JFTfrEF.getText()+"',pesosignovital_EF='"+frameef.JFTPesoEF.getText()+"',tallasignovita_EF='"+frameef.JFTBtallaEF.getText()+"',imcsignovital_EF='"+frameef.JFTimcEF.getText()+"',rangosignovital='"+frameef.JFTrangoEF.getText()+"',cab_EF="+cabebol+",textcab_EF='"+frameef.JTFCabeza.getText()+"',cara_EF="+carabol+",textcara_EF='"+frameef.JTFcaraEF.getText()+"',ojos_EF="+ojosbol+",textojos_EF='"+frameef.JTFojosEF.getText()+"',oidos_EF="+oidosbol+",textoidos_EF='"+frameef.JTFoidosEF.getText()+"',nariz_EF="+narizbol+",textnariz_EF='"+frameef.JTFnarizEF.getText()+"',boca_EF="+bocabol+",textboca_EF='"+frameef.JTFbocaEF.getText()+"',dentadura_EF="+dentadurabol+",textdentadura_EF='"+frameef.JTFDentEF.getText()+"',cuello_EF="+cuellobol+",textcuello_EF='"+frameef.JTFcuelloEF.getText()+"',torax_EF="+toraxbol+",texttorax_EF='"+frameef.JTFtoraxEF.getText()+"',cardiaco_EF="+cardiacobol+",textcardiaco_EF='"+frameef.JTFCardiacoEF.getText()+"',pulmon_EF="+pulmonarbol+",textpulmon_EF='"+frameef.JTFPulmonEF.getText()+"',mamas_EF="+mamasbol+",textmamas_EF='"+frameef.JTFMamasEF.getText()+"',abdomen_EF="+abdomenbol+",textabdomen_EF='"+frameef.JTFAbdomenEF.getText()+"',genitales_EF="+genitalbol+",textgenitales_EF='"+frameef.JTFGenitalesEF.getText()+"',msup_EF="+msupbol+",textmsup_EF='"+frameef.JTFMsup.getText()+"',minf_EF="+minfbol+",textminf_EF='"+frameef.JTFMinfEF.getText()+"',pies_EF="+piesbol+",textpies_EF='"+frameef.JTFPiesEF.getText()+"',columna_EF="+columnabol+",textcolumna_EF='"+frameef.JTFColEF.getText()+"',neurolog_EF="+neurologobol+",textneurolog_EF='"+frameef.JTFNeurlogEF.getText()+"',piel_EF="+pielbol+",textpiel_EF='"+frameef.JTFPielEF.getText()+"',idlateral_EF="+ilat+" where examen_fisico.idingreso_EF='"+frameef.numingredicPC+"'";
       //System.out.println("sqlcadEF:"+sqlcadEF);
       try{
          varef=TSentenciaGuardarhc.executeUpdate(sqlcadEF);

       }//cierra el try
       catch(SQLException e){
                       con2.rollback();
                       cad2="NO SE PUDO ACTUALIZAR LOS DATOS DE EXAMEN FISICO";
                       cad1="TABLA EXAMEN FISICO";
                       objvalidarGHC.mensajeconfirmacion(cad1,cad2);
                 }//cierra el catch

                 Cconsql.CerrarConexion();

        return varef;

    }

    public int actualizarpc(CExamPraclin frameparacli) throws SQLException{
        int varparacli=0;
        String sqlparaclin;
        Connection con2=Cconsql.getConnection();
        TSentenciaGuardarhc=con2.createStatement();
        sqlparaclin="UPDATE paraclinicos SET observacion_examparacl='"+frameparacli.JTAExamPar.getText()+"',visio_examparacl=" + frameparacli.JCHVisiom.isSelected() + ",audio_examparacl="+frameparacli.JCHAudio.isSelected()+",espiro_examparacl="+frameparacli.JCHEspirom.isSelected()+",hematico_examparacl="+frameparacli.JCHhematico.isSelected()+",alturas_examparacl="+frameparacli.JCHAlturas.isSelected()+",quimica_examparacl="+frameparacli.JCHQuimica.isSelected()+",diag1_examparacl='"+frameparacli.JTFDiaguno.getText()+"',diag2_examparacl='"+frameparacli.JTFDos.getText()+"',diag3_examparacl='"+frameparacli.JTFTres.getText()+"',diag4_examparacl='"+frameparacli.JTFCuatro.getText()+"',electrocardiograma_examparacl="+frameparacli.JCHElectro.isSelected()+",otros_examparacli="+frameparacli.JCHOtros.isSelected()+",observacion_examppracli='"+frameparacli.JTFOtros.getText()+"' where paraclinicos.idingreso_examparacl='"+frameparacli.numingredicFIN+"'";
        System.out.println("sqlparaclin:"+sqlparaclin);
        try{if(frameparacli.JCHAlturas.isSelected()||frameparacli.JCHAudio.isSelected()||frameparacli.jCheckBox1.isSelected()||frameparacli.JCHElectro.isSelected()||frameparacli.JCHEspirom.isSelected()||frameparacli.JCHhematico.isSelected()||frameparacli.JCHOtros.isSelected()||frameparacli.JCHQuimica.isSelected()||frameparacli.JCHVisiom.isSelected())
              varparacli=TSentenciaGuardarhc.executeUpdate(sqlparaclin);
            else
               varparacli=1;
        }//cierra el try
        catch(SQLException e){
             System.out.println("toros="+e.getMessage());
             e.getMessage();
             con2.rollback();
             cad1="NO SE PUDO ACTUALIZAR LOS DATOS DE EXAMEN PARACLINICOS";
             cad2="TABLA EXAMEN PARACLINICOS";
             objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
        Cconsql.CerrarConexion();
        return varparacli;
    }

    public int actualizarfin(CResOcupacional framefin,String numingrfin)throws SQLException {
        int varresocup=0;
        String sqlresocup;
        Connection con2=Cconsql.getConnection();
        TSentenciaGuardarhc=con2.createStatement();
        sqlresocup="UPDATE resocupacional SET aptocargo_resocup="+framefin.JRAptoCargo.isSelected()+",aptorestr_resocup="+framefin.JRTAptoRest.isSelected()+",aplazado_resocup="+framefin.JRBAplazado.isSelected()+",noapto_resocup="+framefin.JRBNoApto.isSelected()+",motivo_resocup='"+framefin.JTFMOtivo.getText()+"',recomendaciones__resocup='"+framefin.JEDTrecom.getText()+"',uso_resocup="+framefin.JCHUso.isSelected()+",remision_resocup="+framefin.JCHRemEps.isSelected()+",reasignacion_resocup="+framefin.JCHReasTareas.isSelected()+",ingreso_resocup="+framefin.JCHIngrSve.isSelected()+",tratamiento_resocup="+framefin.JCHSconTr.isSelected()+",fisica_resocup="+framefin.JCHAFisica.isSelected()+",fumar_resocup="+framefin.JCHDejarFumar.isSelected()+",alcohol_resocup="+framefin.JCHReducConsAlcohol.isSelected()+",peso_resocup="+ framefin.JCHControlPeso.isSelected()+" where resocupacional.idingreso_resocup='"+numingrfin+"'";
        try{
          //TSentenciaGuardarhc=con2.createStatement();
          varresocup=TSentenciaGuardarhc.executeUpdate(sqlresocup);
       }//cierra el try
       catch(SQLException e){
             e.getMessage();
             con2.rollback();
                       cad2="NO SE PUDO ACTUALIZAR LOS DATOS DE RESULTADOS OCUPACIONALES";
                       cad1="TABLA RESULTADOS OCUPACIONALES";
                       objvalidarGHC.mensajeconfirmacion(cad1,cad2);
                 }//cierra el catch
                 Cconsql.CerrarConexion();
        return varresocup;
     }

    public void JMEdad_actionPerformed(ActionEvent e) {
        CReportes framereporte=new CReportes(10);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES DEMOGRAFICOS ");
      //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();
    }

    public void JMSEXO_actionPerformed(ActionEvent e) {
        CReportes framereporte=new CReportes(10);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES DEMOGRAFICOS");
       //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();

    }

    public void JMECIVIL_actionPerformed(ActionEvent e) {
         CReportes framereporte=new CReportes(10);
         framereporte.setBounds(0,2,620,465);
         framereporte.setTitle("REPORTES DEMOGRAFICOS");
        //JDPpanelpal.add(framecrearentrada, new Integer(1));
         JDPIngreso.add(framereporte, new Integer(1));
         framereporte.setLocation(200, 100);
         framereporte.show();

    }

    public void JMEscolaridad_actionPerformed(ActionEvent e) {
        CReportes framereporte=new CReportes(10);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES DEMOGRAFICOS");
       //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();

    }

    public void JBBorrar_mouseClicked(MouseEvent e) {
        String numingresoborr;int iborr=0;
        String titulo="ANULAR INGRESO MEDICO";
        String mensaje = "SI";
        String mensaje1 = "NO";
        Object[] option = {mensaje, mensaje1};
        CFrameMedico framemedico=new CFrameMedico(JDPIngreso);
        framemedico=(CFrameMedico)objframemedico;;
           if(swframemedico==1){
               int n = JDGuardar.showOptionDialog(this,"ESTA SEGURO DE BORRAR?","BORRAR " + titulo,JDGuardar.YES_NO_OPTION,JDGuardar.QUESTION_MESSAGE, null,option, mensaje);
                if (n == 0) {
                    numingresoborr=(String)framemedico.modelomedico.getValueAt(framemedico.JTMedico.getSelectedRow(),8);
                    iborr=actualizarmedicoingr(numingresoborr);
                    if(iborr==1){
                        objvalidarGHC.mensajeconfirmacion("ANULACION EXITOSA ","INGRESO MEDICO");
                        framemedico.modelomedico.borraentrada(framemedico.JTMedico.getSelectedRow());
                        framemedico.dispose();
                        JBBorrar.setEnabled(false);
                    }
                    else
                        objvalidarGHC.mensajeconfirmacion("PROBLEMAS ANULACION","ERR ANULACION");
                }

           }
    }

    public int actualizarmedicoingr(String numingresoborr) {
        String sqlcadmedico;int vardatomedico=0;
        Connection con2=Cconsql.getConnection();
        sqlcadmedico="UPDATE ingreso SET ingreso.anulado_ingreso="+1+",ingreso.pendiente_ingreso="+1+" where ingreso.id_ingreso='"+numingresoborr+"'";
        //System.out.println("NALGATORIO:"+sqlcadmedico);
        try{
           TSentenciaGuardarhc=con2.createStatement();
           vardatomedico=TSentenciaGuardarhc.executeUpdate(sqlcadmedico);
        }//cierra el try
        catch(SQLException e){
              cad1="NO SE PUDO ACTUALIZAR EL INGRESO MEDICO";
              cad2="PROBLEMAS CON EL INGRESO";
              objvalidarGHC.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
        Cconsql.CerrarConexion();
        return vardatomedico;
    }

    public void JMReingreso_actionPerformed(ActionEvent e) {
        //System.out.println("PICON:");
         CReportes framereporte=new CReportes(11);
         framereporte.setBounds(0,2,620,465);
         framereporte.setTitle("REPORTES REINGRESO");
        //JDPpanelpal.add(framecrearentrada, new Integer(1));
         JDPIngreso.add(framereporte, new Integer(1));
         framereporte.setLocation(200, 100);
         framereporte.show();

    }

    public void JMIngrOsteomus_actionPerformed(ActionEvent e) {
        //System.out.println("PICON:");
        CReportes framereporte=new CReportes(12);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES OSTEOMUSCULAR");
       //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();

    }

    public void JMIngrAlt_actionPerformed(ActionEvent e) {
        //System.out.println("PICON:");
      CReportes framereporte=new CReportes(13);
      framereporte.setBounds(0,2,620,465);
      framereporte.setTitle("REPORTES ALTURAS");
     //JDPpanelpal.add(framecrearentrada, new Integer(1));
      JDPIngreso.add(framereporte, new Integer(1));
      framereporte.setLocation(200, 100);
      framereporte.show();

    }

    public void JMEnfProf_actionPerformed(ActionEvent e) {
        CReportes framereporte=new CReportes(14);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES ENFERMEDAD PROFESIONAL");
   //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();
    }

    public void JMAccTrabajo_actionPerformed(ActionEvent e) {
        CReportes framereporte=new CReportes(15);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES ACCIDENTES DE TRABAJO");
   //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();

    }

    public void jMenu5_actionPerformed(ActionEvent e) {

    }

    public void JMFactorRiesg_actionPerformed(ActionEvent e) {
         CReportes framereporte=new CReportes(16);
         framereporte.setBounds(0,2,620,465);
         framereporte.setTitle("REPORTES FACTORES DE RIESGO");
//JDPpanelpal.add(framecrearentrada, new Integer(1));
         JDPIngreso.add(framereporte, new Integer(1));
         framereporte.setLocation(200, 100);
         framereporte.show();

    }

    public void JMRelacion_actionPerformed(ActionEvent e) {
        CReportes framereporte=new CReportes(17);
         framereporte.setBounds(0,2,620,465);
         framereporte.setTitle("REPORTES RELACION PACIENTES");
//JDPpanelpal.add(framecrearentrada, new Integer(1));
         JDPIngreso.add(framereporte, new Integer(1));
          framereporte.setLocation(200, 100);
          framereporte.show();
    }

    public void JMHistClinica_actionPerformed(ActionEvent e) {
        swedicion=2;
        CEntradaConsulta framecrearentrada=new CEntradaConsulta(swedicion,JDPIngreso,JBGuardar,JBNuevo,JBModificar,JBActualizar,JBBorrar,null);
// framecrearentrada = new JIFEntradas(JBGuardar,JBEliminar,JBModificar,swsalida,framecrearentrada, JDPpanelpal );
        framecrearentrada.setBounds(0, 1, 1020, 620);
        framecrearentrada.setTitle("IMPRIMIR HISTORIA CLINICA OCUPACIONAL");
//titulo=titulo1;
        JDPIngreso.add(framecrearentrada, new Integer(1));
        framecrearentrada.setLocation(5, 55);
        framecrearentrada.show();
    }

    public void JMFactRiesg_actionPerformed(ActionEvent e) {
         CReportes framereporte=new CReportes(18);
         framereporte.setBounds(0,2,620,465);
         framereporte.setTitle("REPORTES ANTECEDENTES PERSONALES");
       //JDPpanelpal.add(framecrearentrada, new Integer(1));
         JDPIngreso.add(framereporte, new Integer(1));
         framereporte.setLocation(200, 100);
         framereporte.show();

    }

    public void JMAntecFam_actionPerformed(ActionEvent e) {
       CReportes framereporte=new CReportes(19);
       framereporte.setBounds(0,2,620,465);
       framereporte.setTitle("REPORTES ANTECEDENTES FAMILIARES");
     //JDPpanelpal.add(framecrearentrada, new Integer(1));
       JDPIngreso.add(framereporte, new Integer(1));
       framereporte.setLocation(200, 100);
       framereporte.show();

    }

    public void JMCargo_actionPerformed(ActionEvent e) {
        CReportes framereporte=new CReportes(10);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES DEMOGRAFICOS ");
      //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();

    }

    public void jMenu4_actionPerformed(ActionEvent e) {

    }

    public void JMHistoriaOcupacional_actionPerformed(ActionEvent e) {
        CReportes framereporte=new CReportes(20);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("HISTORIA OCUPACIONAL");
 //JDPpanelpal.add(framecrearentrada, new Integer(1));
       JDPIngreso.add(framereporte, new Integer(1));
       framereporte.setLocation(200, 100);
       framereporte.show();
    }

    public void JMGineco_actionPerformed(ActionEvent e) {


    }

    public void JMGinecologia_actionPerformed(ActionEvent e) {
        CReportes framereporte=new CReportes(21);
        framereporte.setBounds(0,2,620,465);
        framereporte.setTitle("REPORTES GINECO");
      //JDPpanelpal.add(framecrearentrada, new Integer(1));
        JDPIngreso.add(framereporte, new Integer(1));
        framereporte.setLocation(200, 100);
        framereporte.show();

    }
}// fin de la clase


class Cframesaludocupacional_JMGinecologia_actionAdapter implements
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMGinecologia_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMGinecologia_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMGineco_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMGineco_actionAdapter(Cframesaludocupacional
                                                  adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMGineco_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMHistoriaOcupacional_actionAdapter implements
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMHistoriaOcupacional_actionAdapter(
            Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMHistoriaOcupacional_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMAntecFam_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMAntecFam_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMAntecFam_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMHistClinica_actionAdapter implements
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMHistClinica_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMHistClinica_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMRelacion_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMRelacion_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMRelacion_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMFactorRiesg_actionAdapter implements
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMFactorRiesg_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMFactorRiesg_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMAccTrabajo_actionAdapter implements
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMAccTrabajo_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMAccTrabajo_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMEnfProf_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMEnfProf_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMEnfProf_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMIngrAlt_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMIngrAlt_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMIngrAlt_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMIngrOsteomus_actionAdapter implements
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMIngrOsteomus_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMIngrOsteomus_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMReingreso_actionAdapter implements
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMReingreso_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMReingreso_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMEscolaridad_actionAdapter implements
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMEscolaridad_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMEscolaridad_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMECIVIL_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMECIVIL_actionAdapter(Cframesaludocupacional
                                                  adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMECIVIL_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMSEXO_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMSEXO_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMSEXO_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMEdad_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMEdad_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMEdad_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMCargo_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMCargo_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMCargo_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMEdicion_actionAdapter implements java.awt.event.
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMEdicion_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.JMEdicion_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMReimprimir_actionAdapter implements java.awt.
        event.ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMReimprimir_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.JMReimprimir_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMImc_actionAdapter implements java.awt.event.
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMImc_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.JMImc_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMLateralidad_actionAdapter implements java.awt.
        event.ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMLateralidad_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.JMLateralidad_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMTratamiento_actionAdapter implements java.awt.
        event.ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMTratamiento_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.JMTratamiento_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMPatologias_actionAdapter implements java.awt.
        event.ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMPatologias_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.JMPatologias_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMParaclinicos_actionAdapter implements java.awt.
        event.ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMParaclinicos_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.JMParaclinicos_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMFactRiesg_actionAdapter implements
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMFactRiesg_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMFactRiesg_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMINmuniz_actionAdapter implements java.awt.event.
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMINmuniz_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.JMINmuniz_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMHabit_actionAdapter implements java.awt.event.
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMHabit_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.JMHabit_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMPeriodico_actionAdapter implements java.awt.
        event.ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMPeriodico_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.JMPeriodico_actionPerformed(e);
    }
}


class Cframesaludocupacional_jMenu1_actionAdapter implements java.awt.event.
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_jMenu1_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.jMenu1_actionPerformed(e);
    }
}


class Cframesaludocupacional_JMIngApto_actionAdapter implements java.awt.event.
        ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMIngApto_actionAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        adaptee.JMIngApto_actionPerformed(e);
    }
}


//Cframesaludocupacional_JBNuevo_actionAdapter
class Cframesaludocupacional_JBNuevo_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JBNuevo_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBNuevo_actionPerformed(e);
    }
}//fin de la clase Cframesaludocupacional
//Cframesaludocupacional_JBGuardar_actionAdapter
class Cframesaludocupacional_JBGuardar_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JBGuardar_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBGuardar_actionPerformed(e);
    }
}
//Cframesaludocupacional_JBBorrar_actionAdapter
class Cframesaludocupacional_JBBorrar_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JBBorrar_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBBorrar_actionPerformed(e);
    }
}


class Cframesaludocupacional_JBBorrar_mouseAdapter extends MouseAdapter {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JBBorrar_mouseAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
        adaptee.JBBorrar_mouseClicked(e);
    }
}


//Cframesaludocupacional_JBModificar_actionAdapter
class Cframesaludocupacional_JBModificar_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JBModificar_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBModificar_actionPerformed(e);
    }
}
//Cframesaludocupacional_JBActualizar_actionAdapter
class Cframesaludocupacional_JBActualizar_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JBActualizar_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBActualizar_actionPerformed(e);
    }
}
//Cframesaludocupacional_JMAdmon_actionAdapter
class Cframesaludocupacional_JMIngreso_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMIngreso_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMIngreso_actionPerformed(e);
    }
}
//Cframesaludocupacional_JMUsuario_actionAdapter
class Cframesaludocupacional_JMUsuario_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMUsuario_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMUsuario_actionPerformed(e);
    }
}
//JMIngresoRep
class Cframesaludocupacional_JMIngresoRep_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMIngresoRep_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMIngresoRep_actionPerformed(e);
    }
}
//JMRetiroRep
class Cframesaludocupacional_JMRetiroRep_actionAdapter implements ActionListener {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMRetiroRep_actionAdapter(Cframesaludocupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JMRetiroRep_actionPerformed(e);
    }
}
//
class Cframesaludocupacional_JMRetiroRep_mouseAdapter extends java.awt.event.
        MouseAdapter {
    private Cframesaludocupacional adaptee;
    Cframesaludocupacional_JMRetiroRep_mouseAdapter(Cframesaludocupacional
            adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseReleased(java.awt.event.MouseEvent e) {
        adaptee.JMRetiroRep_mouseReleased(e);
    }
}
