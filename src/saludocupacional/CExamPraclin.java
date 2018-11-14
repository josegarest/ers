package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.awt.Font;
import java.awt.Rectangle;

public class CExamPraclin extends JInternalFrame {
    Object objppalep;
    Object obotactualizarEP;
    ValidarComponentes validfin=new ValidarComponentes();
    String cad1;
    String cad2;
    public Statement TSentenciaconsultaFIN;
    public ResultSet RconsultaFIN;
    public ConexionSql Cconsql= new ConexionSql();
    String numingredicFIN;
    int swedicingrFIN;
    Object  objetoresocup= new Object();
    int swgte;
    int swval;
    String nombrep= new String();
    String numhcep= new String();
    Object JDPIngresoobjEP=new Object();
    Object frameEPOBJ= new Object();
    Object frameEnfProfOBJ= new Object();
    Object frameAcciTrabajoOBJ=new Object();
    Object frameAntecFamOBJ=new Object();
    Object frameAntecPersonalOBJ=new Object();
    Object frameGinecologiaOBJ=new Object();
    Object frameInmunizOBJ=new Object();
    Object frameOtrosAntecOBJ=new Object();
    Object frameRevisionSistemasOBJ=new Object();
    Object frameobjingreso= new Object();
    Object frameobjho= new Object();
    public String nombredetalle="";
    public static int swepilepc=1;
    CExamPraclin objCAF;
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
    JLabel JLBDiagnostico = new JLabel();
    //JTextArea JTAExamPar1 = new JTextArea();
    JTextPane JTAExamPar = new JTextPane();
    JLabel JLBUno = new JLabel();
    JTextField JTFDiaguno = new JTextField();
    JLabel JLBDos = new JLabel();
    JLabel JLBTres = new JLabel();
    JTextField JTFDos = new JTextField();
    JTextField JTFTres = new JTextField();
    JLabel JLBCuatro = new JLabel();
    JTextField JTFCuatro = new JTextField();
    JLabel JLBNombEP = new JLabel();
    JCheckBox JCHVisiom = new JCheckBox();
    JLabel JLBTituloPar = new JLabel();
    JCheckBox JCHAudio = new JCheckBox();
    JCheckBox JCHEspirom = new JCheckBox();
    JCheckBox JCHhematico = new JCheckBox();
    JCheckBox JCHAlturas = new JCheckBox();
    JCheckBox JCHQuimica = new JCheckBox();
    JCheckBox JCHElectro = new JCheckBox();
    JCheckBox JCHOtros = new JCheckBox();
    JEditorPane JTFOtros = new JEditorPane();
    //
    public CExamPraclin (Object obotactualizarEF,String numingredicPC,int swedicingrPC,String Nombrepacep,CExamenFisico frameef,String varnHC,JDesktopPane JDPIngreso,CIngreso frameingreso,CHistoriaOcup framehistocup,CEnfermedadProf frameenfermedadprof,CHistoriaAcciTrab frameaccitrabajo,CAntecedentesFamiliar frameantecendnetesfam,CAntecedentesPersonales frameantecpersonal,CAGineco frameginecologia,CInmuniz frameinmunuz,COtrosAnt frameotrosantecedentes,CRevisionSistemas framerevisioonsistemas,Object objppalef) {
      frameobjingreso=frameingreso;
      frameobjho=framehistocup;
      frameEPOBJ=frameef;
      frameEnfProfOBJ=frameenfermedadprof;
      frameAcciTrabajoOBJ=frameaccitrabajo;
      frameAntecFamOBJ=frameantecendnetesfam;
      frameAntecPersonalOBJ=frameantecpersonal;
      frameGinecologiaOBJ=frameginecologia;
      frameInmunizOBJ=frameinmunuz;
      frameOtrosAntecOBJ=frameotrosantecedentes;
      frameRevisionSistemasOBJ=framerevisioonsistemas;
      JLBNombEP.setText(Nombrepacep);
      JLBNumhcAF.setText(varnHC);
      JDPIngresoobjEP=JDPIngreso;
      nombrep=Nombrepacep;
      numhcep=varnHC;
      swedicingrFIN=swedicingrPC;
      numingredicFIN=numingredicPC;
      obotactualizarEP=obotactualizarEF;
      objppalep=objppalef;
      try {
           jbInit();
           swgte=0;
      }
      catch (Exception ex) {
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
       JPAntecedentesFamiliar.setFont(new java.awt.Font("Arial", Font.BOLD,14));
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
        JBAtrasAF.addActionListener(new CExamPraclin_JBAtrasAF_actionAdapter(this));
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
        JBSgteAF.addActionListener(new CExamPraclin_JBSgteAF_actionAdapter(this));
        //JBSgteAF.addActionListener(ne              CAntecedentesPersonales_JBSgteAP_actionAdapter(this));
       JBSgteAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN4.GIF")));
       JBSgteAF.setSelectedIcon(null);
       JLBNumhcAF.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
       JLBNumhcAF.setForeground(Color.red);
       JLBNumhcAF.setToolTipText("");
       JLBNumhcAF.setText("");
       JLBNumhcAF.setBounds(new Rectangle(604, 21, 158, 24));
        jCheckBox1.setText("jCheckBox1");
        jCheckBox1.setBounds(new Rectangle(537, 134, 84, 23));
        JLBDiagnostico.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        JLBDiagnostico.setForeground(Color.red);
        JLBDiagnostico.setToolTipText("");
        JLBDiagnostico.setText("DIAGNOSTICO");
        JLBDiagnostico.setBounds(new Rectangle(26, 195, 102, 20));
        JTAExamPar.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTAExamPar.setBorder(BorderFactory.createRaisedBevelBorder());
        JTAExamPar.setToolTipText("");
        JTAExamPar.setCaretColor(Color.black);
        JTAExamPar.setBounds(new Rectangle(23, 22, 561, 167));
        JTAExamPar.requestFocus();
        JLBUno.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 12));
        JLBUno.setForeground(Color.red);
        JLBUno.setToolTipText("");
        JLBUno.setText("1");
        JLBUno.setBounds(new Rectangle(23, 239, 15, 20));
        JTFDiaguno.setBackground(Color.white);
        JTFDiaguno.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFDiaguno.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFDiaguno.setToolTipText("");
        JTFDiaguno.setText("");
        JTFDiaguno.setBounds(new Rectangle(42, 237, 903, 22));
        JLBDos.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 12));
        JLBDos.setForeground(Color.red);
        JLBDos.setToolTipText("");
        JLBDos.setText("2");
        JLBDos.setBounds(new Rectangle(24, 279, 15, 20));
        JLBTres.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 12));
        JLBTres.setForeground(Color.red);
        JLBTres.setToolTipText("");
        JLBTres.setText("3");
        JLBTres.setBounds(new Rectangle(23, 320, 15, 20));
        JTFDos.setBackground(Color.white);
        JTFDos.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFDos.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFDos.setToolTipText("");
        JTFDos.setBounds(new Rectangle(42, 280, 903, 22));
        JTFTres.setBackground(Color.white);
        JTFTres.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFTres.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFTres.setToolTipText("");
        JTFTres.setText("");
        JTFTres.setBounds(new Rectangle(43, 320, 903, 22));
        JLBCuatro.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 12));
        JLBCuatro.setForeground(Color.red);
        JLBCuatro.setToolTipText("");
        JLBCuatro.setText("4");
        JLBCuatro.setBounds(new Rectangle(24, 359, 15, 20));
        JTFCuatro.setBackground(Color.white);
        JTFCuatro.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFCuatro.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFCuatro.setToolTipText("");
        JTFCuatro.setBounds(new Rectangle(43, 359, 903, 22));
        JLBNombEP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNombEP.setForeground(Color.red);
        JLBNombEP.setToolTipText("");
        JLBNombEP.setBounds(new Rectangle(8, 26, 416, 24));
        JCHVisiom.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHVisiom.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHVisiom.setOpaque(false);
        JCHVisiom.setToolTipText("");
        JCHVisiom.setText("VISIOMETRIA");
        JCHVisiom.setBounds(new Rectangle(601, 44, 105, 23));
        JLBTituloPar.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        JLBTituloPar.setForeground(Color.red);
        JLBTituloPar.setToolTipText("");
        JLBTituloPar.setText("EXAMENES PARACLINICOS REALIZADOS");
        JLBTituloPar.setBounds(new Rectangle(600, 19, 259, 20));
        JCHAudio.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHAudio.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHAudio.setOpaque(false);
        JCHAudio.setToolTipText("");
        JCHAudio.setText("AUDIOMETRIA");
        JCHAudio.setBounds(new Rectangle(601, 70, 105, 23));
        JCHEspirom.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHEspirom.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHEspirom.setOpaque(false);
        JCHEspirom.setToolTipText("");
        JCHEspirom.setText("ESPIROMETRIA");
        JCHEspirom.setBounds(new Rectangle(601, 96, 105, 23));
        JCHhematico.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHhematico.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHhematico.setOpaque(false);
        JCHhematico.setToolTipText("");
        JCHhematico.setText("CUADRO HEMATICO");
        JCHhematico.setBounds(new Rectangle(758, 44, 115, 23));
        JCHAlturas.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHAlturas.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHAlturas.setOpaque(false);
        JCHAlturas.setToolTipText("");
        JCHAlturas.setText("PRUEBA DE TRABAJOS EN ALTURA");
        JCHAlturas.setBounds(new Rectangle(758, 71, 190, 23));
        JCHQuimica.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHQuimica.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHQuimica.setOpaque(false);
        JCHQuimica.setToolTipText("");
        JCHQuimica.setText("QUIMICA SANGUINEA");
        JCHQuimica.setBounds(new Rectangle(759, 96, 190, 23));
        JCHElectro.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHElectro.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHElectro.setOpaque(false);
        JCHElectro.setToolTipText("");
        JCHElectro.setText("ELECTROCARDIOGRAMA");
        JCHElectro.setBounds(new Rectangle(601, 126, 146, 23));
        JCHOtros.setBackground(UIManager.getColor(
                "InternalFrame.activeTitleGradient"));
        JCHOtros.setFont(new java.awt.Font("Arial", Font.BOLD, 9));
        JCHOtros.setOpaque(false);
        JCHOtros.setToolTipText("");
        JCHOtros.setText("OTROS");
        JCHOtros.setBounds(new Rectangle(601, 154, 65, 23));
        JCHOtros.addActionListener(new CExamPraclin_JCHOtros_actionAdapter(this));
        JTFOtros.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFOtros.setToolTipText("");
        JTFOtros.setBounds(new Rectangle(664, 156, 306, 77));
        this.getContentPane().add(JPAntecedentesFamiliar);
       //Adicionamos al JPAntecedentesFamiliar
       JPAntecedentesFamiliar.add(JBAtrasAF);
       JPAntecedentesFamiliar.add(JBCancelarAF);
       JPAntecedentesFamiliar.add(JBSgteAF); //JPAntecedentesFamiliar.add(JLBnhcAP);
       //JPAntecedentesFamiliar.add(JLBNumhcAP);
       JPAntecedentesFamiliar.add(JTBAntFam);
        JPAntecedentesFamiliar.add(JLBNumhcAF);
        JPAntecedentesFamiliar.add(JLBNombEP);
        JTBAntFam.add(JPAntFam, "EXAMENES PARACLINICOS");
        JPAntFam.add(JTAExamPar);
        JPAntFam.add(JLBUno);
        JPAntFam.add(JTFDos);
        JPAntFam.add(JLBDos);
        JPAntFam.add(JLBTres);
        JPAntFam.add(JLBCuatro);
        JPAntFam.add(JTFTres);
        JPAntFam.add(JTFCuatro);
        JPAntFam.add(JLBDiagnostico);
        JPAntFam.add(JLBTituloPar);
        JPAntFam.add(JCHVisiom);
        JPAntFam.add(JCHhematico);
        JPAntFam.add(JCHAudio);
        JPAntFam.add(JCHEspirom);
        JPAntFam.add(JCHQuimica);
        JPAntFam.add(JCHElectro);
        JPAntFam.add(JCHOtros);
        JPAntFam.add(JTFDiaguno);
        JPAntFam.add(JCHAlturas);
        JPAntFam.add(JTFOtros);
    }


    public void inicioventanaEP(CExamPraclin frameEP) {
        objCAF=frameEP;
    }

    public void JBAtrasAF_actionPerformed(ActionEvent e) {
        CExamenFisico frameEFAtras;
        frameEFAtras=(CExamenFisico)frameEPOBJ;
        frameEFAtras.setVisible(true);
        objCAF.setVisible(false);
        JButton JBActualizar = new JButton();
        JBActualizar=(JButton)obotactualizarEP;
        //JBActualizar.setEnabled(false);
    }

    public void JBSgteAF_actionPerformed(ActionEvent e) {
            validarnulosRO();
    }

    /**
     * validarnulosRO
     */
    public void validarnulosRO() {
        swval=0;
        CIngreso frameingreso;
        CHistoriaOcup framehistocup;
        CEnfermedadProf frameenfermedadprof;
        CHistoriaAcciTrab frameaccitrabajo;
        CAntecedentesFamiliar frameantecendnetesfam;
        CAntecedentesPersonales frameantecpersonal;
        CAGineco frameginecologia;
        CInmuniz frameinmunuz;
        COtrosAnt frameotrosantecedentes;
        CExamenFisico frameexamfisico;
        CRevisionSistemas framerevisioonsistemas;
        CExamPraclin frameeparacli;
        frameingreso =(CIngreso)frameobjingreso;
        framehistocup=(CHistoriaOcup)frameobjho;
        frameenfermedadprof=(CEnfermedadProf)frameEnfProfOBJ;
        frameaccitrabajo=(CHistoriaAcciTrab)frameAcciTrabajoOBJ;
        frameantecendnetesfam=(CAntecedentesFamiliar)frameAntecFamOBJ;
        frameantecpersonal=(CAntecedentesPersonales)frameAntecPersonalOBJ;
        frameginecologia=(CAGineco)frameGinecologiaOBJ;
        frameinmunuz=(CInmuniz)frameInmunizOBJ;
        frameotrosantecedentes=(COtrosAnt)frameOtrosAntecOBJ;
        frameexamfisico=(CExamenFisico)frameEPOBJ;
        framerevisioonsistemas=(CRevisionSistemas)frameRevisionSistemasOBJ;
        frameeparacli=(CExamPraclin)objCAF;
        frameeparacli.setVisible(false);
        JDesktopPane JDPIngresoEP=new JDesktopPane();
        JDPIngresoEP=(JDesktopPane)JDPIngresoobjEP;
        if(swgte==0){
            CResOcupacional frameRO = new CResOcupacional(nombrep,frameeparacli,numhcep,JDPIngresoEP,frameingreso,framehistocup,frameenfermedadprof,frameaccitrabajo,frameantecendnetesfam,frameantecpersonal,frameginecologia,frameinmunuz,frameotrosantecedentes,frameexamfisico,framerevisioonsistemas,objppalep);
            frameRO.setBounds(0, 2, 1010, 600);
            frameRO.setTitle("RESULTADO FINAL SALUD OCUPACIONAL");
            JDPIngresoEP.add(frameRO, new Integer(1));
            frameRO.setLocation(5, 55);
            frameRO.show();
            frameRO.setVisible(true);
            frameRO.inicioventanaRO(frameRO);
            swgte=1;
            objetoresocup=frameRO;
            if(swedicingrFIN==1){
                //JDPIngresoEP.setSelectedFrame(frameingreso);
                String cadsqledicFIN;
                Connection con2=Cconsql.getConnection();
                cadsqledicFIN="SELECT ingreso.id_ingreso, resocupacional.aptocargo_resocup, resocupacional.aptorestr_resocup, resocupacional.aplazado_resocup, resocupacional.noapto_resocup, resocupacional.motivo_resocup, resocupacional.recomendaciones__resocup, resocupacional.uso_resocup, resocupacional.remision_resocup, resocupacional.reasignacion_resocup, resocupacional.ingreso_resocup, resocupacional.tratamiento_resocup, resocupacional.fisica_resocup, resocupacional.fumar_resocup, resocupacional.alcohol_resocup, resocupacional.peso_resocup FROM ingreso INNER JOIN resocupacional ON ingreso.id_ingreso = resocupacional.idingreso_resocup WHERE ingreso.id_ingreso="+numingredicFIN;
                try{
                   TSentenciaconsultaFIN = con2.createStatement();
                   RconsultaFIN = TSentenciaconsultaFIN.executeQuery(cadsqledicFIN);
                   while (RconsultaFIN.next()) {
                       frameRO.JRAptoCargo.setSelected(RconsultaFIN.getBoolean(2));
                       frameRO.JRTAptoRest.setSelected(RconsultaFIN.getBoolean(3));
                       frameRO.JRBAplazado.setSelected(RconsultaFIN.getBoolean(4));
                       frameRO.JRBNoApto.setSelected(RconsultaFIN.getBoolean(5));
                       frameRO.JTFMOtivo.setText(RconsultaFIN.getString(6));
                       frameRO.JEDTrecom.setText(RconsultaFIN.getString(7));
                       frameRO.JCHUso.setSelected(RconsultaFIN.getBoolean(8));
                       frameRO.JCHRemEps.setSelected(RconsultaFIN.getBoolean(9));
                       frameRO.JCHReasTareas.setSelected(RconsultaFIN.getBoolean(10));
                       frameRO.JCHIngrSve.setSelected(RconsultaFIN.getBoolean(11));
                       frameRO.JCHSconTr.setSelected(RconsultaFIN.getBoolean(12));
                       frameRO.JCHAFisica.setSelected(RconsultaFIN.getBoolean(13));
                       frameRO.JCHDejarFumar.setSelected(RconsultaFIN.getBoolean(14));
                       frameRO.JCHReducConsAlcohol.setSelected(RconsultaFIN.getBoolean(15));
                       frameRO.JCHControlPeso.setSelected(RconsultaFIN.getBoolean(16));
                    }
                }
                catch(SQLException e1){
                  e1.getMessage();
                  cad2="NO SE PUDO EJECUTAR LA CONSULTA";
                  cad1="PROBLEMAS CON LOS DATOS DE RES OCUPACIONAL EN EDICION";
                  validfin.mensajeconfirmacion(cad1,cad2);
                }//cierra el catch
                Cconsql.CerrarConexion();
                Cframesaludocupacional frameso= new Cframesaludocupacional();
                JButton JBActualizar = new JButton();
                JBActualizar=(JButton)obotactualizarEP;
                frameRO.JBSgteAF.setEnabled(false);
                JBActualizar.setEnabled(true);
                frameso=(Cframesaludocupacional)objppalep;
            }

        }
        else{
            CResOcupacional frameRO;
            frameRO=(CResOcupacional)objetoresocup;
          // ObjectCingreso.setVisible(false);
           frameRO.setVisible(true);
      }

    }

    public void JCHOtros_actionPerformed(ActionEvent e) {
        JTFOtros.requestFocus();
    }

    public CExamPraclin() {
    }

    //


}//FIN CLASE


class CExamPraclin_JCHOtros_actionAdapter implements ActionListener {
    private CExamPraclin adaptee;
    CExamPraclin_JCHOtros_actionAdapter(CExamPraclin adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHOtros_actionPerformed(e);
    }
}


class CExamPraclin_JBSgteAF_actionAdapter implements ActionListener {
    private CExamPraclin adaptee;
    CExamPraclin_JBSgteAF_actionAdapter(CExamPraclin adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSgteAF_actionPerformed(e);
    }
}


class CExamPraclin_JBAtrasAF_actionAdapter implements ActionListener {
    private CExamPraclin adaptee;
    CExamPraclin_JBAtrasAF_actionAdapter(CExamPraclin adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasAF_actionPerformed(e);
    }
}

