package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.swing.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

//import com.borland.jbuilder.xml.database.template.*;
public class CResOcupacional extends JInternalFrame {
    public Statement TSentenciaGuardarSO;
    public ConexionSql Cconsql= new ConexionSql();
    ValidarComponentes valres=new ValidarComponentes();
    String nombrero= new String();
    String numhcro= new String();
    Object JDPIngresoobjRO=new Object();
    Object frameHOingrOBJ= new Object();
    Object frameEPingrOBJ= new Object();
    Object frameROingrOBJ= new Object();
    Object frameROOBJ= new Object();
    Object frameAcciTrabajoOBJ=new Object();
    Object frameAntecFamOBJ=new Object();
    Object frameAntecPersonalOBJ=new Object();
    Object frameGinecologiaOBJ=new Object();
    Object frameInmunizOBJ=new Object();
    Object frameOtrosAntecOBJ=new Object();
    Object frameExamenFisicoOBJ=new Object();
    Object frameRevisionSistemasOBJ=new Object();
    public String nombredetalle="";
    String cad1;
    String cad2;
    CResOcupacional objCRO;
    //DECLARACION DE PANELES
    JTabbedPane JTBAntFam = new JTabbedPane();
    JPanel JPAntecedentesFamiliar = new JPanel();
    JPanel JPAntFam = new JPanel();
    //DECLARACION DE OBJETOS VISUALES
    JButton JBAtrasAF = new JButton();
    JButton JBCancelarAF = new JButton();
    JButton JBSgteAF = new JButton();
    JLabel JLBNumhcRO = new JLabel();
    JRadioButton JRAptoCargo = new JRadioButton();
    JRadioButton JRTAptoRest = new JRadioButton();
    JLabel JLBMotiv = new JLabel();
    JTextField JTFMOtivo = new JTextField();
    JRadioButton JRBAplazado = new JRadioButton();
    JRadioButton JRBNoApto = new JRadioButton();
    JLabel JLBRec = new JLabel();
    JLabel JLBRecSo = new JLabel();
    JCheckBox JCHUso = new JCheckBox();
    JCheckBox JCHRemEps = new JCheckBox();
    JCheckBox JCHReasTareas = new JCheckBox();
    JCheckBox JCHIngrSve = new JCheckBox();
    JCheckBox JCHSconTr = new JCheckBox();
    JCheckBox JCHAFisica = new JCheckBox();
    JCheckBox JCHDejarFumar = new JCheckBox();
    JCheckBox JCHControlPeso = new JCheckBox();
    JCheckBox JCHReducConsAlcohol = new JCheckBox();
    JLabel JLBBomreRO = new JLabel();
    JScrollPane JSPrecom = new JScrollPane();
    JEditorPane JEDTrecom = new JEditorPane();
    //
    public CResOcupacional (String Nombrepacro,CExamPraclin frameep,String varnHC,JDesktopPane JDPIngreso,CIngreso frameingreso,CHistoriaOcup framehistocup,CEnfermedadProf frameenfermedadprof,CHistoriaAcciTrab frameaccitrabajo,CAntecedentesFamiliar frameantecendnetesfam,CAntecedentesPersonales frameantecpersonal,CAGineco frameginecologia,CInmuniz frameinmunuz,COtrosAnt frameotrosantecedentes,CExamenFisico frameexamfisico,CRevisionSistemas framerevisioonsistemas,Object objppalep) {
        Cframesaludocupacional frameso=new Cframesaludocupacional();
        frameROOBJ = frameep;
        frameROingrOBJ=frameingreso;
        frameHOingrOBJ=framehistocup;
        frameEPingrOBJ=frameenfermedadprof;
        frameAcciTrabajoOBJ=frameaccitrabajo;
        frameAntecFamOBJ=frameantecendnetesfam;
        frameAntecPersonalOBJ=frameantecpersonal;
        frameGinecologiaOBJ=frameginecologia;
        frameInmunizOBJ=frameinmunuz;
        frameOtrosAntecOBJ=frameotrosantecedentes;
        frameExamenFisicoOBJ=frameexamfisico;
        frameRevisionSistemasOBJ=framerevisioonsistemas;
        JLBBomreRO.setText(Nombrepacro);
        JLBNumhcRO.setText(varnHC);
        JDPIngresoobjRO = JDPIngreso;
        nombrero = Nombrepacro;
        numhcro = varnHC;
        frameso=(Cframesaludocupacional)objppalep;
        frameso.objframeinr=frameingreso;
        if(frameingreso.swedicioningr==1){
            frameso.objframeho=frameHOingrOBJ;
            frameso.objframeep=frameEPingrOBJ;
            frameso.objframeat=frameAcciTrabajoOBJ;
            frameso.objframeaf=frameantecendnetesfam;
            frameso.objframeap=frameAntecPersonalOBJ;
            frameso.objframego=frameginecologia;
            frameso.objframeiz=frameInmunizOBJ;
            frameso.objframeoa=frameotrosantecedentes;
            frameso.objframers=framerevisioonsistemas;
            frameso.objframeef=frameexamfisico;
            frameso.objframepc=frameep;
            frameso.objframefin=this;
        }

        try {
            jbInit();
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
        JBAtrasAF.addActionListener(new CResOcupacional_JBAtrasAF_actionAdapter(this));
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
        JBSgteAF.addActionListener(new CResOcupacional_JBSgteAF_actionAdapter(this));
        //JBSgteAF.addActionListener(ne              CAntecedentesPersonales_JBSgteAP_actionAdapter(this));
       JBSgteAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN4.GIF")));
       JBSgteAF.setSelectedIcon(null);
        JLBNumhcRO.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNumhcRO.setForeground(Color.red);
        JLBNumhcRO.setToolTipText("");
        JLBNumhcRO.setBounds(new Rectangle(477, 16, 158, 24));
        JRAptoCargo.setBackground(SystemColor.desktop);
        JRAptoCargo.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JRAptoCargo.setForeground(Color.red);
        JRAptoCargo.setToolTipText("");
        JRAptoCargo.setText("APTO PARA EL CARGO");
        JRAptoCargo.setBounds(new Rectangle(6, 12, 188, 23));
        JRAptoCargo.addActionListener(new
                                      CResOcupacional_JRAptoCargo_actionAdapter(this));
        JRTAptoRest.setBackground(SystemColor.desktop);
        JRTAptoRest.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JRTAptoRest.setForeground(Color.red);
        JRTAptoRest.setToolTipText("");
        JRTAptoRest.setText("APTO CON RESTRINCCIONES");
        JRTAptoRest.setBounds(new Rectangle(7, 47, 188, 23));
        JRTAptoRest.addActionListener(new
                                      CResOcupacional_JRTAptoRest_actionAdapter(this));
        JLBMotiv.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBMotiv.setForeground(Color.red);
        JLBMotiv.setToolTipText("");
        JLBMotiv.setText("MOTIVO");
        JLBMotiv.setBounds(new Rectangle(222, 50, 73, 20));
        JTFMOtivo.setBackground(Color.white);
        JTFMOtivo.setEnabled(false);
        JTFMOtivo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFMOtivo.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFMOtivo.setToolTipText("");
        JTFMOtivo.setBounds(new Rectangle(285, 49, 612, 22));
        JRBAplazado.setBackground(SystemColor.desktop);
        JRBAplazado.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JRBAplazado.setForeground(Color.red);
        JRBAplazado.setToolTipText("");
        JRBAplazado.setText("APLAZADO");
        JRBAplazado.setBounds(new Rectangle(7, 87, 188, 23));
        JRBAplazado.addActionListener(new
                                      CResOcupacional_JRBAplazado_actionAdapter(this));
        JRBNoApto.setBackground(SystemColor.desktop);
        JRBNoApto.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JRBNoApto.setForeground(Color.red);
        JRBNoApto.setToolTipText("");
        JRBNoApto.setText("NO APTO");
        JRBNoApto.setBounds(new Rectangle(8, 123, 188, 23));
        JRBNoApto.addActionListener(new CResOcupacional_JRBNoApto_actionAdapter(this));
        JLBRec.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBRec.setForeground(Color.red);
        JLBRec.setToolTipText("");
        JLBRec.setText("RECOMENDACIONES ESPECIFICAS");
        JLBRec.setBounds(new Rectangle(8, 187, 192, 20));
        JLBRecSo.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 12));
        JLBRecSo.setForeground(Color.red);
        JLBRecSo.setToolTipText("");
        JLBRecSo.setText("RECOMENDACIONES SALUD OCUPACIONAL");
        JLBRecSo.setBounds(new Rectangle(298, 265, 295, 20));
        JCHUso.setBackground(SystemColor.textHighlight);
        JCHUso.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JCHUso.setForeground(Color.red);
        JCHUso.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHUso.setToolTipText("");
        JCHUso.setText("USO DE EPP, CAPACITACION Y MEDIDAS PREVENTIVAS");
        JCHUso.setBounds(new Rectangle(8, 286, 378, 23));
        JCHRemEps.setBackground(SystemColor.textHighlight);
        JCHRemEps.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JCHRemEps.setForeground(Color.red);
        JCHRemEps.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHRemEps.setToolTipText("");
        JCHRemEps.setText("REMISIONES A EPS");
        JCHRemEps.setBounds(new Rectangle(8, 315, 378, 23));
        JCHReasTareas.setBackground(SystemColor.textHighlight);
        JCHReasTareas.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JCHReasTareas.setForeground(Color.red);
        JCHReasTareas.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHReasTareas.setToolTipText("");
        JCHReasTareas.setText("REASIGNACION DE TAREAS");
        JCHReasTareas.setBounds(new Rectangle(9, 342, 378, 23));
        JCHIngrSve.setBackground(SystemColor.textHighlight);
        JCHIngrSve.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JCHIngrSve.setForeground(Color.red);
        JCHIngrSve.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHIngrSve.setToolTipText("");
        JCHIngrSve.setText("INGRESO SVE");
        JCHIngrSve.setBounds(new Rectangle(8, 371, 378, 23));
        JCHSconTr.setBackground(SystemColor.textHighlight);
        JCHSconTr.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JCHSconTr.setForeground(Color.red);
        JCHSconTr.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHSconTr.setToolTipText("");
        JCHSconTr.setText("SEGUIR CON EL TRATAMIENTO");
        JCHSconTr.setBounds(new Rectangle(400, 287, 378, 23));
        JCHAFisica.setBackground(SystemColor.textHighlight);
        JCHAFisica.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JCHAFisica.setForeground(Color.red);
        JCHAFisica.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHAFisica.setToolTipText("");
        JCHAFisica.setText("ACTIVIDAD FISICA");
        JCHAFisica.setBounds(new Rectangle(399, 316, 378, 23));
        JCHDejarFumar.setBackground(SystemColor.textHighlight);
        JCHDejarFumar.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JCHDejarFumar.setForeground(Color.red);
        JCHDejarFumar.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHDejarFumar.setToolTipText("");
        JCHDejarFumar.setText("DEJAR DE FUMAR");
        JCHDejarFumar.setBounds(new Rectangle(399, 343, 378, 23));
        JCHControlPeso.setBackground(SystemColor.textHighlight);
        JCHControlPeso.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JCHControlPeso.setForeground(Color.red);
        JCHControlPeso.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHControlPeso.setToolTipText("");
        JCHControlPeso.setText("CONTROL DE PESO");
        JCHControlPeso.setBounds(new Rectangle(802, 288, 151, 23));
        JCHReducConsAlcohol.setBackground(SystemColor.textHighlight);
        JCHReducConsAlcohol.setFont(new java.awt.Font("Arial Black", Font.PLAIN,
                10));
        JCHReducConsAlcohol.setForeground(Color.red);
        JCHReducConsAlcohol.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHReducConsAlcohol.setToolTipText("");
        JCHReducConsAlcohol.setText("REDUCIR CONSUMO DE ALCOHOL");
        JCHReducConsAlcohol.setBounds(new Rectangle(399, 373, 378, 23));
        JLBBomreRO.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBBomreRO.setForeground(Color.red);
        JLBBomreRO.setToolTipText("");
        JLBBomreRO.setBounds(new Rectangle(6, 12, 548, 24));
        JSPrecom.getViewport().setBackground(Color.white);
        JSPrecom.setBounds(new Rectangle(232, 159, 544, 83));
        JEDTrecom.setFont(new java.awt.Font("Arial", Font.PLAIN, 10));
        JEDTrecom.setToolTipText("");
        this.getContentPane().add(JPAntecedentesFamiliar);
       //Adicionamos al JPAntecedentesFamiliar
       JPAntecedentesFamiliar.add(JBAtrasAF);
       JPAntecedentesFamiliar.add(JBCancelarAF);
       JPAntecedentesFamiliar.add(JBSgteAF); //JPAntecedentesFamiliar.add(JLBnhcAP);
       //JPAntecedentesFamiliar.add(JLBNumhcAP);
       JPAntecedentesFamiliar.add(JTBAntFam);
        JPAntecedentesFamiliar.add(JLBNumhcRO);
        JPAntecedentesFamiliar.add(JLBBomreRO);
        JPAntFam.add(JRAptoCargo);
        JPAntFam.add(JRTAptoRest);
        JPAntFam.add(JTFMOtivo);
        JPAntFam.add(JRBAplazado);
        JPAntFam.add(JRBNoApto);
        JPAntFam.add(JLBMotiv);
        JPAntFam.add(JLBRec);
        JPAntFam.add(JLBRecSo);
        JPAntFam.add(JCHUso);
        JPAntFam.add(JCHReasTareas);
        JPAntFam.add(JCHIngrSve);
        JPAntFam.add(JCHRemEps);
        JPAntFam.add(JCHSconTr);
        JPAntFam.add(JCHAFisica);
        JPAntFam.add(JCHDejarFumar);
        JPAntFam.add(JCHReducConsAlcohol);
        JPAntFam.add(JCHControlPeso);
        JPAntFam.add(JSPrecom);
        JSPrecom.getViewport().add(JEDTrecom);
        JTBAntFam.add(JPAntFam, "RESULTADOS EXAMEN SALUD OCUPACIONAL");
    }


    public void inicioventanaRO(CResOcupacional frameRO) {
       objCRO=frameRO;
    }

    public void JBAtrasAF_actionPerformed(ActionEvent e) {
        CExamPraclin frameROAtras;
        frameROAtras=(CExamPraclin)frameROOBJ;
        frameROAtras.setVisible(true);
        objCRO.setVisible(false);
    }

    public void JRAptoCargo_actionPerformed(ActionEvent e) {
         JRTAptoRest.setSelected(false);
         JRBAplazado.setSelected(false);
         JRBNoApto.setSelected(false);
    }

    public void JRTAptoRest_actionPerformed(ActionEvent e) {
        JRBAplazado.setSelected(false);
        JRBNoApto.setSelected(false);
        JRAptoCargo.setSelected(false);
        JTFMOtivo.setEnabled(true);
        JTFMOtivo.requestFocus();
    }

    public void JRBAplazado_actionPerformed(ActionEvent e) {
        JRBNoApto.setSelected(false);
        JRAptoCargo.setSelected(false);
        JRTAptoRest.setSelected(false);
        JTFMOtivo.setEnabled(true);
        JTFMOtivo.requestFocus();
    }

    public void JRBNoApto_actionPerformed(ActionEvent e) {
        JRAptoCargo.setSelected(false);
        JRTAptoRest.setSelected(false);
        JRBAplazado.setSelected(false);
        JTFMOtivo.setEnabled(true);
        JTFMOtivo.requestFocus();
    }

    public void JBSgteAF_actionPerformed(ActionEvent e) {
        if(JRAptoCargo.isSelected()==false && JRTAptoRest.isSelected()==false && JRBAplazado.isSelected()==false){
           valres.mensajeconfirmacion("NO TIENE MARCADO NINGUN RESULTADO","ERROR DIGITACION");
        }
        else{
            procesoguardar();
            if (valres.mensajeconfirmacion_si_no("IMPRIMIR CERTIFICADO")==1){
                  this.dispose();

            }
                 /* this.setVisible(false);
                  this.dispose();}*/
            else{
               procesoimprimir();
               this.dispose();


            }
        }//fin del else validacion



    }

    /**
     * procesoguardar
     */
    public void procesoguardar() {
        Connection con2=Cconsql.getConnection();
        int ihistoriaocup,iingrfactor,iingrelem,ienfprof,iaccitrabajo,iantecfamiliar,iantecpersonal,iginecologia,imunizacion,iotrosantec,irs,ief,iparacli,iresocup,iactingr,iactdatosusu;
        try{con2.setAutoCommit(false);
            iingrfactor=guardaringrfactor();
            iingrelem=guardaringrelem();
            System.out.println("ELEM:"+iingrelem);
            ihistoriaocup=guardarhistoriaocup();
            System.out.println("ho:"+ihistoriaocup);
            ienfprof=guardarenfprofesional();
            System.out.println("ep:"+ihistoriaocup);
            iaccitrabajo=guardaraccitrabajo();
            System.out.println("at:"+iaccitrabajo);
            iantecfamiliar=guardarantecfam();
            System.out.println("iantecfamiliar:"+iantecfamiliar);
            iantecpersonal=guardarantecpersonales();
            System.out.println("iantecpersonal:"+iantecpersonal);
            iginecologia=guardargineco();
            System.out.println("iginecologia:"+iginecologia);
            imunizacion=guardarinmuniz();
            System.out.println("imunizacion:"+imunizacion);
            iotrosantec=guardarotrosantec();
            System.out.println("iotrosantec:"+iotrosantec);
            irs=guardarrs();
            System.out.println("irs:"+irs);
            ief=guardaref();
            System.out.println("ief:"+ief);
            iparacli=guardarparacli();
            System.out.println("iparacli:"+iparacli);
            iresocup=guardarresocup();
            System.out.println("iresocup:"+iresocup);
            iactingr=actualizaringr();
            System.out.println("iactingr:"+iactingr);
            iactdatosusu=actualizardatosusu();
            if(iingrfactor==1 && iingrelem==1 && ihistoriaocup==1 && ienfprof==1 && iaccitrabajo==1  && iantecfamiliar==1 && iantecpersonal==1 && iginecologia==1 && imunizacion==1 && iotrosantec==1 && irs==1 && ief==1 && iparacli==1 && iresocup==1 && iactdatosusu==1 && iactingr==1){
                con2.commit();
                con2.setAutoCommit(true);
                valres.mensajeconfirmacion("LA FICHA CLINICA SE GRABO CON EXITO","FICHA CLINICA");
            }//cierra el if

        }//cierra el try
        catch (SQLException e1) {
            valres.mensajeconfirmacion("NO SE GRABO NINGUN DATO DEL PACIENTE luis",e1.getMessage());
                       //objvalidarGHC.mensajeconfirmacion("NO SE GRABO NINGUN DATO DEL PACIENTE","ERROR GRABAR USUARIO");
        }//cierra el catch


    }

    /**
     * guardarhistoriaocup
     */
    public int guardarhistoriaocup()throws SQLException {
        String cadsqlfactor,cadsqlelem,valorblanco;
        Connection con2=Cconsql.getConnection();
        CIngreso frameingreso;
        CHistoriaOcup framehistocup;
        frameingreso=(CIngreso)frameROingrOBJ;
        framehistocup=(CHistoriaOcup)frameHOingrOBJ;
        int varho=0,ifilho=0;
        String sqlho,fechainiblanco,fechafinblanco;
        valorblanco=(String)framehistocup.modeloho.getValueAt(0,0).toString();
        cadsqlfactor="select *from ingresofactorriesgo";
        cadsqlelem="select *from ingresoelemriesgo";
        if(framehistocup.JTabHO.getRowCount()>0){
            if(valorblanco.compareTo("")==0){
               fechainiblanco="0000-00-00";
               fechafinblanco="0000-00-00";
               sqlho="insert into historiaocupacional (idingreso_ho,nombempresa_ho,fechaini_ho,fechafin_ho,tiempoempresa_ho,cargo_ho,factorriesgo_ho,elemriesgo_ho,tiempoexposicion_ho,empresanueva_ho) values ('"+frameingreso.JFTNumIngr.getText()+"','"+framehistocup.modeloho.getValueAt(ifilho,0)+"','"+fechainiblanco+"','"+fechafinblanco+"','"+framehistocup.modeloho.getValueAt(ifilho,3)+"','"+framehistocup.modeloho.getValueAt(ifilho,4)+"','"+valres.buscarcadena(cadsqlfactor,1)+"','"+valres.buscarcadena(cadsqlelem,1)+"','"+framehistocup.modeloho.getValueAt(ifilho,7)+"',"+framehistocup.modeloho.getValueAt(ifilho,6)+")";
               varho=guardarblanco(sqlho,con2);
            }
            else{
                while(ifilho<framehistocup.JTabHO.getRowCount()-1){
                     sqlho="insert into historiaocupacional (idingreso_ho,nombempresa_ho,fechaini_ho,fechafin_ho,tiempoempresa_ho,cargo_ho,factorriesgo_ho,elemriesgo_ho,tiempoexposicion_ho,empresanueva_ho) values ('"+frameingreso.JFTNumIngr.getText()+"','"+framehistocup.modeloho.getValueAt(ifilho,0)+"','"+framehistocup.modeloho.getValueAt(ifilho,1)+"','"+framehistocup.modeloho.getValueAt(ifilho,2)+"','"+framehistocup.modeloho.getValueAt(ifilho,3)+"','"+framehistocup.modeloho.getValueAt(ifilho,4)+"','"+valres.buscarcadena(cadsqlfactor,1)+"','"+valres.buscarcadena(cadsqlelem,1)+"','"+framehistocup.modeloho.getValueAt(ifilho,7)+"',"+framehistocup.modeloho.getValueAt(ifilho,6)+")";
                     try{
                        TSentenciaGuardarSO=con2.createStatement();
                        varho=TSentenciaGuardarSO.executeUpdate(sqlho);
                     }//cierra el try
                    catch(SQLException e){
                      e.getMessage();
                      con2.rollback();
                      cad1="NO SE PUDO GRABAR LOS DE LA HISTORIA OCUPACIONAL";
                      cad2="TABLA HISTORIA OCUPACIONAL";
                      valres.mensajeconfirmacion(cad1,cad2);
                    }//cierra el catch
                  // Cconsql.CerrarConexion();
                   ifilho=ifilho+1;
               }//fin del while
            }//fin else blanco


        }//fin del if
        framehistocup.dispose();
        frameingreso.dispose();
        return varho;
    }

    /**
     * guardaringrfactor
     */
    public int guardaringrfactor() throws SQLException {
        CIngreso frameingreso;
        frameingreso=(CIngreso)frameROingrOBJ;
        Connection con2=Cconsql.getConnection();
        CHistoriaOcup framehistocup;
        int infact=0,ifilfactor=0;
        String sqlfactor,valorblanco;
        framehistocup=(CHistoriaOcup)frameHOingrOBJ;
        valorblanco=(String)framehistocup.modeloho.getValueAt(0,0).toString();
        if(framehistocup.JTabHO.getRowCount()>0){
            if(valorblanco.compareTo("")==0){
               sqlfactor="insert into ingresofactorriesgo (id_ingfr,vlrergon_ingfr,vlrfisico_ingfr,vlrquimico_ingfr,vlrfisicoquim_ingfr,vlrbiologico_ingfr,vlrpsicosocial_ingfr,vlrmecanico_ingfr,vlrelectrico_ingfr,vlrlocativo_ingfr) values('"+frameingreso.JFTNumIngr.getText()+"',"+framehistocup.fact[ifilfactor][0]+","+framehistocup.fact[ifilfactor][1]+","+framehistocup.fact[ifilfactor][2]+","+framehistocup.fact[ifilfactor][3]+","+framehistocup.fact[ifilfactor][4]+","+framehistocup.fact[ifilfactor][5]+","+framehistocup.fact[ifilfactor][6]+","+framehistocup.fact[ifilfactor][7]+","+framehistocup.fact[ifilfactor][8]+")";
               System.out.println("san fermin:"+sqlfactor);
               infact=guardarblanco(sqlfactor,con2);
            }
            else{
                while(ifilfactor<framehistocup.JTabHO.getRowCount()-1){
                    sqlfactor="insert into ingresofactorriesgo (id_ingfr,vlrergon_ingfr,vlrfisico_ingfr,vlrquimico_ingfr,vlrfisicoquim_ingfr,vlrbiologico_ingfr,vlrpsicosocial_ingfr,vlrmecanico_ingfr,vlrelectrico_ingfr,vlrlocativo_ingfr) values('"+frameingreso.JFTNumIngr.getText()+"',"+framehistocup.fact[ifilfactor][0]+","+framehistocup.fact[ifilfactor][1]+","+framehistocup.fact[ifilfactor][2]+","+framehistocup.fact[ifilfactor][3]+","+framehistocup.fact[ifilfactor][4]+","+framehistocup.fact[ifilfactor][5]+","+framehistocup.fact[ifilfactor][6]+","+framehistocup.fact[ifilfactor][7]+","+framehistocup.fact[ifilfactor][8]+")";
                     System.out.println("san fermin:"+sqlfactor);
                    try{
                      TSentenciaGuardarSO=con2.createStatement();
                      infact=TSentenciaGuardarSO.executeUpdate(sqlfactor);
                }//fin del try
                catch(SQLException e){
                   e.getMessage();
                   con2.rollback();
                   cad1="NO SE PUDO GRABAR LOS FACTORES DE RIESGO";
                   cad2="TABLA INGRESOFACTORRIESGO";
                   valres.mensajeconfirmacion(cad1,cad2);
                }
            // Cconsql.CerrarConexion();
             ifilfactor=ifilfactor+1;
            }//fin del while

            }//cierra el else del blanco

        }//fin del if
        frameingreso.dispose();
        framehistocup.dispose();
        return infact;
    }

    /**
     * guardaringrelem
     */
    public int guardaringrelem()throws SQLException {
        CIngreso frameingreso;
        frameingreso=(CIngreso)frameROingrOBJ;
        Connection con2=Cconsql.getConnection();
        CHistoriaOcup framehistocup;
        int inele=0,ifilele=0;
        String sqlelem,valorblanco;
        framehistocup=(CHistoriaOcup)frameHOingrOBJ;
        valorblanco=(String)framehistocup.modeloho.getValueAt(0,0).toString();
        if(framehistocup.JTabHO.getRowCount()>0){
            if(valorblanco.compareTo("")==0){
               sqlelem="insert into ingresoelemriesgo (id_elemriesg,diseno_elemriesg,sobreesf_elemriesg,posturas_elemriesg,posiciones_elemriesg,lev_elemriesg,repetitivoc_elemriesg,ruido_elemriesg,ilumdef_elemriesg,ilumexs_elemriesg,radion_elemriesg,radnoion_elemriesg,tempbaja_elemriesg,tempalta_elemriesg,vivrac_elemriesg,polvoorg_elemriesg,polvoinorg_elemriesg,humomet_elemriesg,humonomet_elemriesg,bacterias_elemriesg,parasitos_elemriesg,virus_elemriesg,hongos_elemriesg,pelos_elemriesg,plumas_elemriesg,polen_elemriesg,animvert_elemriesg,animinv_elemriesg,resanim_elemriesg,resveg_elemriesg,cuchillos_elemriesg,jeringas_elemriesg,bisturis_elemriesg,desindustr_elemriesg,basuras_elemriesg,inconpatibilidad_elemriesg,sustancias_elemriesg,quimicasreact_elemriesg,stress_elemriesg,atencion_elemriesg,peligro_elemriesg,rotativas_elemriesg,extensas_elemriesg,inestabi_elemriesg,manten1_elemriesg,guardas_elemriesg,manteni2_elemriesg,partes_elemriesg,falta_elemriesg,cargaest_elemriesg,altatension_elemriesg,bajatension_elemriesg,pisos_elemriesg,muros_elemriesg,techos_elemriesg,superficie_elemriesg,orden_elemriesg,marcacion_elemriesg,dotacion_elemriesg,extintores_elemriesg) values('"+frameingreso.JFTNumIngr.getText()+"',"+framehistocup.elem[ifilele][0]+","+framehistocup.elem[ifilele][1]+","+framehistocup.elem[ifilele][2]+","+framehistocup.elem[ifilele][3]+","+framehistocup.elem[ifilele][4]+","+framehistocup.elem[ifilele][5]+","+framehistocup.elem[ifilele][6]+","+framehistocup.elem[ifilele][7]+","+framehistocup.elem[ifilele][8]+","+framehistocup.elem[ifilele][9]+","+framehistocup.elem[ifilele][10]+","+framehistocup.elem[ifilele][11]+","+framehistocup.elem[ifilele][12]+","+framehistocup.elem[ifilele][13]+","+framehistocup.elem[ifilele][14]+","+framehistocup.elem[ifilele][15]+","+framehistocup.elem[ifilele][16]+","+framehistocup.elem[ifilele][17]+","+framehistocup.elem[ifilele][18]+","+framehistocup.elem[ifilele][19]+","+framehistocup.elem[ifilele][20]+","+framehistocup.elem[ifilele][21]+","+framehistocup.elem[ifilele][22]+","+framehistocup.elem[ifilele][23]+","+framehistocup.elem[ifilele][24]+","+framehistocup.elem[ifilele][25]+","+framehistocup.elem[ifilele][26]+","+framehistocup.elem[ifilele][27]+","+framehistocup.elem[ifilele][28]+","+framehistocup.elem[ifilele][29]+","+framehistocup.elem[ifilele][30]+","+framehistocup.elem[ifilele][31]+","+framehistocup.elem[ifilele][32]+","+framehistocup.elem[ifilele][33]+","+framehistocup.elem[ifilele][34]+","+framehistocup.elem[ifilele][35]+","+framehistocup.elem[ifilele][36]+","+framehistocup.elem[ifilele][37]+","+framehistocup.elem[ifilele][38]+","+framehistocup.elem[ifilele][39]+","+framehistocup.elem[ifilele][40]+","+framehistocup.elem[ifilele][41]+","+framehistocup.elem[ifilele][42]+","+framehistocup.elem[ifilele][43]+","+framehistocup.elem[ifilele][44]+","+framehistocup.elem[ifilele][45]+","+framehistocup.elem[ifilele][46]+","+framehistocup.elem[ifilele][47]+","+framehistocup.elem[ifilele][48]+","+framehistocup.elem[ifilele][49]+","+framehistocup.elem[ifilele][50]+","+framehistocup.elem[ifilele][51]+","+framehistocup.elem[ifilele][52]+","+framehistocup.elem[ifilele][53]+","+framehistocup.elem[ifilele][54]+","+framehistocup.elem[ifilele][55]+","+framehistocup.elem[ifilele][56]+","+framehistocup.elem[ifilele][57]+","+framehistocup.elem[ifilele][58]+")";
               System.out.println("SAN PANCRASIO:"+sqlelem);
               inele=guardarblanco(sqlelem,con2);
            }
            else{
                while(ifilele<framehistocup.JTabHO.getRowCount()-1){
                      sqlelem="insert into ingresoelemriesgo (id_elemriesg,diseno_elemriesg,sobreesf_elemriesg,posturas_elemriesg,posiciones_elemriesg,lev_elemriesg,repetitivoc_elemriesg,ruido_elemriesg,ilumdef_elemriesg,ilumexs_elemriesg,radion_elemriesg,radnoion_elemriesg,tempbaja_elemriesg,tempalta_elemriesg,vivrac_elemriesg,polvoorg_elemriesg,polvoinorg_elemriesg,humomet_elemriesg,humonomet_elemriesg,bacterias_elemriesg,parasitos_elemriesg,virus_elemriesg,hongos_elemriesg,pelos_elemriesg,plumas_elemriesg,polen_elemriesg,animvert_elemriesg,animinv_elemriesg,resanim_elemriesg,resveg_elemriesg,cuchillos_elemriesg,jeringas_elemriesg,bisturis_elemriesg,desindustr_elemriesg,basuras_elemriesg,inconpatibilidad_elemriesg,sustancias_elemriesg,quimicasreact_elemriesg,stress_elemriesg,atencion_elemriesg,peligro_elemriesg,rotativas_elemriesg,extensas_elemriesg,inestabi_elemriesg,manten1_elemriesg,guardas_elemriesg,manteni2_elemriesg,partes_elemriesg,falta_elemriesg,cargaest_elemriesg,altatension_elemriesg,bajatension_elemriesg,pisos_elemriesg,muros_elemriesg,techos_elemriesg,superficie_elemriesg,orden_elemriesg,marcacion_elemriesg,dotacion_elemriesg,extintores_elemriesg) values('"+frameingreso.JFTNumIngr.getText()+"',"+framehistocup.elem[ifilele][0]+","+framehistocup.elem[ifilele][1]+","+framehistocup.elem[ifilele][2]+","+framehistocup.elem[ifilele][3]+","+framehistocup.elem[ifilele][4]+","+framehistocup.elem[ifilele][5]+","+framehistocup.elem[ifilele][6]+","+framehistocup.elem[ifilele][7]+","+framehistocup.elem[ifilele][8]+","+framehistocup.elem[ifilele][9]+","+framehistocup.elem[ifilele][10]+","+framehistocup.elem[ifilele][11]+","+framehistocup.elem[ifilele][12]+","+framehistocup.elem[ifilele][13]+","+framehistocup.elem[ifilele][14]+","+framehistocup.elem[ifilele][15]+","+framehistocup.elem[ifilele][16]+","+framehistocup.elem[ifilele][17]+","+framehistocup.elem[ifilele][18]+","+framehistocup.elem[ifilele][19]+","+framehistocup.elem[ifilele][20]+","+framehistocup.elem[ifilele][21]+","+framehistocup.elem[ifilele][22]+","+framehistocup.elem[ifilele][23]+","+framehistocup.elem[ifilele][24]+","+framehistocup.elem[ifilele][25]+","+framehistocup.elem[ifilele][26]+","+framehistocup.elem[ifilele][27]+","+framehistocup.elem[ifilele][28]+","+framehistocup.elem[ifilele][29]+","+framehistocup.elem[ifilele][30]+","+framehistocup.elem[ifilele][31]+","+framehistocup.elem[ifilele][32]+","+framehistocup.elem[ifilele][33]+","+framehistocup.elem[ifilele][34]+","+framehistocup.elem[ifilele][35]+","+framehistocup.elem[ifilele][36]+","+framehistocup.elem[ifilele][37]+","+framehistocup.elem[ifilele][38]+","+framehistocup.elem[ifilele][39]+","+framehistocup.elem[ifilele][40]+","+framehistocup.elem[ifilele][41]+","+framehistocup.elem[ifilele][42]+","+framehistocup.elem[ifilele][43]+","+framehistocup.elem[ifilele][44]+","+framehistocup.elem[ifilele][45]+","+framehistocup.elem[ifilele][46]+","+framehistocup.elem[ifilele][47]+","+framehistocup.elem[ifilele][48]+","+framehistocup.elem[ifilele][49]+","+framehistocup.elem[ifilele][50]+","+framehistocup.elem[ifilele][51]+","+framehistocup.elem[ifilele][52]+","+framehistocup.elem[ifilele][53]+","+framehistocup.elem[ifilele][54]+","+framehistocup.elem[ifilele][55]+","+framehistocup.elem[ifilele][56]+","+framehistocup.elem[ifilele][57]+","+framehistocup.elem[ifilele][58]+")";
                      System.out.println("SAN PANCRASIO:"+sqlelem);
                      try{
                         TSentenciaGuardarSO=con2.createStatement();
                         inele=TSentenciaGuardarSO.executeUpdate(sqlelem);
                      }//fin del try
                      catch(SQLException e){
                          e.getMessage();
                          con2.rollback();
                          cad1="NO SE PUDO GRABAR LOS ELEMENTOS DE RIESGO";
                          cad2="TABLA INGRESOELEMRIESGO";
                          valres.mensajeconfirmacion(cad1,cad2);
                      }
                      // Cconsql.CerrarConexion();
                        ifilele=ifilele+1;
               }//fin del while

            }//fin else

        }//fin del if
        frameingreso.dispose();
        framehistocup.dispose();
        return inele;
    }

    /**
     * guardarenfprofesional
     */

    /**
     * guardarenfprofesional
     */
    public int guardarenfprofesional() throws SQLException{
        int intep=0,ifilho=0;
        String sqlep,valorblanco;
        Connection con2=Cconsql.getConnection();
        CIngreso frameingreso;
        CEnfermedadProf frameenfermedadprof;
        frameingreso=(CIngreso)frameROingrOBJ;
        frameenfermedadprof=(CEnfermedadProf)frameEPingrOBJ;
        valorblanco=(String)frameenfermedadprof.modeloep.getValueAt(0,0).toString();
        if(frameenfermedadprof.JTBenfPer.getRowCount()>0){
            if(valorblanco.compareTo("")==0){
                sqlep="insert into enfermedad_profesional (idingreso_EP,nombrempresa_EP,fecha_EP,diagnostico_EP,medico_EP) values ('"+frameingreso.JFTNumIngr.getText()+"','"+frameenfermedadprof.modeloep.getValueAt(ifilho,0)+"','"+frameenfermedadprof.modeloep.getValueAt(ifilho,1)+"','"+frameenfermedadprof.modeloep.getValueAt(ifilho,2)+"','"+frameenfermedadprof.modeloep.getValueAt(ifilho,3)+"'"+")";
                intep=guardarblanco(sqlep,con2);
            }
            else{
                while(ifilho<frameenfermedadprof.JTBenfPer.getRowCount()-1){
                 sqlep="insert into enfermedad_profesional (idingreso_EP,nombrempresa_EP,fecha_EP,diagnostico_EP,medico_EP) values ('"+frameingreso.JFTNumIngr.getText()+"','"+frameenfermedadprof.modeloep.getValueAt(ifilho,0)+"','"+frameenfermedadprof.modeloep.getValueAt(ifilho,1)+"','"+frameenfermedadprof.modeloep.getValueAt(ifilho,2)+"','"+frameenfermedadprof.modeloep.getValueAt(ifilho,3)+"'"+")";
                 try{
                     TSentenciaGuardarSO=con2.createStatement();
                     intep=TSentenciaGuardarSO.executeUpdate(sqlep);
                  }//cierra el try
                 catch(SQLException e){
                    e.getMessage();
                    con2.rollback();
                    cad1="NO SE PUDO GRABAR LOS DE LA ENFERMEDAD PROFESIONAL";
                    cad2="TABLA ENFERMEDAD PROFESIONAL";
                    valres.mensajeconfirmacion(cad1,cad2);
                 }//cierra el catch
                 Cconsql.CerrarConexion();
                  ifilho=ifilho+1;
             }//fin del while

            }//fin del else blanco

        }//fin del if
        frameenfermedadprof.dispose();
        frameingreso.dispose();
        return intep;
    }

    /**
     * guardaraccitrabajo
     */
    public int guardaraccitrabajo()throws SQLException {
        int varaccitrab=0,ifilat=0;
        String sqlat,valorblanco,fechainiblanco,fechafinblanco;;
        Connection con2=Cconsql.getConnection();
        CIngreso frameingreso;
        CHistoriaAcciTrab frameaccitrabajo;
        frameingreso=(CIngreso)frameROingrOBJ;
        frameaccitrabajo=(CHistoriaAcciTrab)frameAcciTrabajoOBJ;
        valorblanco=(String)frameaccitrabajo.modeloat.getValueAt(0,0).toString();
        if(frameaccitrabajo.JTBHAccTra.getRowCount()>0){
            if(valorblanco.compareTo("")==0){
               fechainiblanco="0001-01-01";
               fechafinblanco="0001-01-01";
               sqlat="insert into accidentes_trabajo (idingreso_accitrabajo,empresa_accitrabajo,fecha_accitrabajo,causa_accitrabajo,tipolesion_accitrabajo,parteafectada_accitrabajo,incapacidad_accitrabajo,secuelas_accitrabajo ) values ('"+frameingreso.JFTNumIngr.getText()+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,0)+"','"+ fechainiblanco+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,2)+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,3)+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,4)+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,5)+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,6)+"'"+")";;
               varaccitrab=guardarblanco(sqlat,con2);
            }
            else{
                while(ifilat<frameaccitrabajo.JTBHAccTra.getRowCount()-1){
                 sqlat="insert into accidentes_trabajo (idingreso_accitrabajo,empresa_accitrabajo,fecha_accitrabajo,causa_accitrabajo,tipolesion_accitrabajo,parteafectada_accitrabajo,incapacidad_accitrabajo,secuelas_accitrabajo ) values ('"+frameingreso.JFTNumIngr.getText()+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,0)+"','"+ frameaccitrabajo.modeloat.getValueAt(ifilat,1)+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,2)+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,3)+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,4)+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,5)+"','"+frameaccitrabajo.modeloat.getValueAt(ifilat,6)+"'"+")";;
                 try{
                    TSentenciaGuardarSO=con2.createStatement();
                    varaccitrab=TSentenciaGuardarSO.executeUpdate(sqlat);
                 }//cierra el try
                 catch(SQLException e){
                   e.getMessage();
                   con2.rollback();
                   cad1="NO SE PUDO GRABAR LOS DATOS DE ACCIDENTES DE TRABAJO";
                   cad2="TABLA ACCIDENTES DE TRABAJO";
                   valres.mensajeconfirmacion(cad1,cad2);
                 }//cierra el catch
                //Cconsql.CerrarConexion();
                 ifilat=ifilat+1;
            }// fin del while
            }//fin else

        }//fin del if
        frameaccitrabajo.dispose();
        return varaccitrab;
    }

    /**
     * guardarantecfam
     */
    public int guardarantecfam() throws SQLException {
        int varantfam=0;
        String sqlaf;
        Connection con2=Cconsql.getConnection();
        CIngreso frameingreso;
        CAntecedentesFamiliar frameantecfam;
        frameingreso=(CIngreso)frameROingrOBJ;
        frameantecfam=(CAntecedentesFamiliar)frameAntecFamOBJ;
        sqlaf="insert into antecedentes_familiar (idingreso_familiar,hipertension_familiar,texthipertension_familiar,diabetes_familiar,textdiabetes_familiar,cancer_familiar,textcancer_familiar,cardio_familiar,textcardio_familiar,epilepsia_familiar,textepilepsia_familiar,otros_familiar,textotros_familiar) values ('"+ frameingreso.JFTNumIngr.getText()+"',"+frameantecfam.JCHHta.isSelected()+",'"+frameantecfam.JTFHta.getText()+"',"+frameantecfam.JCHDiabet.isSelected()+",'"+frameantecfam.JTFDiab.getText()+"',"+frameantecfam.JCHCancer.isSelected()+",'"+frameantecfam.JTFCancer.getText()+"',"+frameantecfam.JCHCardiopatias.isSelected()+",'"+frameantecfam.JTFCardiopatias.getText()+"',"+frameantecfam.JCHEpilepsia.isSelected()+",'"+frameantecfam.JTFEpilepsia.getText()+"',"+frameantecfam.JCHOtros.isSelected()+",'"+frameantecfam.JTFOtros.getText()+"'"+")";
        try{
                    TSentenciaGuardarSO=con2.createStatement();
                    varantfam=TSentenciaGuardarSO.executeUpdate(sqlaf);
                 }//cierra el try
                catch(SQLException e){
                   e.getMessage();
                   con2.rollback();
                   cad1="NO SE PUDO GRABAR LOS DATOS DE LOS ANTECEDENTES FAMILIARES";
                   cad2="TABLA ANTECEDENTES FAMILIARES";
                   valres.mensajeconfirmacion(cad1,cad2);
                }//cierra el catch
                Cconsql.CerrarConexion();
                frameantecfam.dispose();
                return varantfam;
    }

    /**
     * guardarantecpersonales
     */
    public int guardarantecpersonales() throws SQLException {
        int varantpersonal=0;
        String sqlap;
        Connection con2=Cconsql.getConnection();
        CIngreso frameingreso;
        CAntecedentesPersonales frameantecpersonal;
        frameingreso=(CIngreso)frameROingrOBJ;
        frameantecpersonal=(CAntecedentesPersonales)frameAntecPersonalOBJ;
        sqlap="insert into antecedentespersonal_pacientes (idingreso_consap,diabetes_consap,obsdiabetes_consap,hiparterial_consap,obshiparterial_consap,coronario_consap,obscoronario_consap,dislipidemia_consap,obsdislipidemia_consap,asmabronq_consap,obsasmabronq_consap,psicopatia_consap,obspsicopatia_consap,alergia_consap,obsalergia_consap,tuberculosis_consap,obstuberculosis_consap,atipia_consap,obsatipia_consap,gota_consap,obsgota_consap,afeccbroncpulmon_consap,obsafeccbroncpulmon_consap,endocrinopatia_consap,obsendocrinopatia_consap,nefrologia_consap,obsnefrologia_consap,riopatia_consap,obsriopatia_consap,hemopatias_consap,obshemopatias_consap,ets_consap,obsets_consap,ulcgastroduod_consap,obsulcgastroduod_consap,colecistopatia_consap,obscolecistopatia_consap,hepatitis_consap,obshepatitis_consap,enfneurologicas_consap,obsenfneurologicas_consap,fiebresprolong_consap,obsfiebresprolong_consap,colageno_consap,obscolageno_consap,traumatismo_consap,obstraumatismo_consap,otros_consap,obsotros_consap) values ('"+ frameingreso.JFTNumIngr.getText()+"',"+frameantecpersonal.JCHDiabet.isSelected()+",'"+frameantecpersonal.JTFDiabet.getText()+"',"+frameantecpersonal.JCHHipArt.isSelected()+",'"+frameantecpersonal.JTFHiperArt.getText()+"',"+frameantecpersonal.JCHCoronario.isSelected()+",'"+frameantecpersonal.JFTCoronario.getText()+"',"+frameantecpersonal.JCHDislipedia.isSelected()+",'"+frameantecpersonal.JTFDislipidemia.getText()+"',"+frameantecpersonal.JCHAsmaBronq.isSelected()+",'"+frameantecpersonal.JTFAsmaBronquial.getText()+"',"+frameantecpersonal.JCHPsicopatia.isSelected()+",'"+frameantecpersonal.JTFPsicopatia.getText()+"',"+frameantecpersonal.JCHAlergiaAp.isSelected()+",'"+frameantecpersonal.JTFAlergiaAP.getText()+"',"+frameantecpersonal.JCHTuberculosisAP.isSelected()+",'"+frameantecpersonal.JTFTuberculosisAP.getText()+"',"+frameantecpersonal.JCHAtipiaAP.isSelected()+",'"+frameantecpersonal.JTFAtipiaAP.getText()+"',"+frameantecpersonal.JCHGotaAP.isSelected()+",'"+frameantecpersonal.JTFGotaAP.getText()+"',"+frameantecpersonal.JCHAffBroncoAP.isSelected()+",'"+frameantecpersonal.JTFAfccbroncpulm.getText()+"',"+frameantecpersonal.JCHEndocrinopatiasAP.isSelected()+",'"+frameantecpersonal.JTFEndocrinopatiasAP.getText()+"',"+frameantecpersonal.JCHNefrologiasAP.isSelected()+",'"+frameantecpersonal.JTNefrologiasAP.getText()+"',"+frameantecpersonal.JCHPatiasAP.isSelected()+",'"+frameantecpersonal.JTFPatiasAP.getText()+"',"+frameantecpersonal.JCHHemopatiasAP.isSelected()+",'"+frameantecpersonal.JTFHemopatias.getText()+"',"+frameantecpersonal.JCHEtsAP.isSelected()+",'"+frameantecpersonal.JTFETSap.getText()+"',"+frameantecpersonal.JCHUlceraGastr.isSelected()+",'"+frameantecpersonal.JTFUlcGastrDuodAP.getText()+"',"+frameantecpersonal.JCHColecistopatiaAP.isSelected()+",'"+frameantecpersonal.JTFColecistopatia.getText()+"',"+frameantecpersonal.JCHHepatitis.isSelected()+",'"+frameantecpersonal.JTFHepatitis.getText()+"',"+frameantecpersonal.JCHEnfNeurologicaEP.isSelected()+",'"+frameantecpersonal.JTFEnfNeurologAP.getText()+"',"+frameantecpersonal.JCHFiebresProAP.isSelected()+",'"+frameantecpersonal.JFTFiebresProlongAP.getText()+"',"+frameantecpersonal.JCHColagenopatias.isSelected()+",'"+frameantecpersonal.JFTColagenopatias.getText()+"',"+frameantecpersonal.JCHTraumatismo.isSelected()+",'"+frameantecpersonal.JTFTraumatismo.getText()+"',"+frameantecpersonal.JCHOtros.isSelected()+",'"+frameantecpersonal.JTFOtros.getText()+"'"+ ")";
        try{
             TSentenciaGuardarSO=con2.createStatement();
             varantpersonal=TSentenciaGuardarSO.executeUpdate(sqlap);
            }//cierra el try
        catch(SQLException e){
             e.getMessage();
             con2.rollback();
             cad1="NO SE PUDO GRABAR LOS DATOS DE LOS ANTECEDENTES PERSONALES";
             cad2="TABLA ANTECEDENTES PERSONALES";
             valres.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
         Cconsql.CerrarConexion();
         frameantecpersonal.dispose();
         frameingreso.dispose();
        return varantpersonal;
    }

    /**
     * guardargineco
     */
    public int guardargineco() throws SQLException {
        int vargineco=0,imen,iplan,ires;
        String sqlgineco,cadtipomen,cadtipoplan,cadtipores;
        Connection con2=Cconsql.getConnection();
        CIngreso frameingreso;
        CAGineco framegineco;
        frameingreso=(CIngreso)frameROingrOBJ;
        framegineco=(CAGineco)frameGinecologiaOBJ;
        String tipomen=valres.evaluarcombocadena(framegineco.JCMenarquia);
        cadtipomen="select *from menarquia where menarquia.rango_mquia="+"'"+tipomen+"'";
        imen=valres.evaluarcadenaentera(cadtipomen);
        String plan=valres.evaluarcombocadena(framegineco.JCPlanifica);
        cadtipoplan = "select *from planifica where planifica.nombre_planif="+"'"+plan+"'";
        iplan=valres.evaluarcadenaentera(cadtipoplan);
        String res=valres.evaluarcombocadena(framegineco.JCResultado);
        cadtipores = "select *from resultados_gineco where resultados_gineco.nombre_resgico="+"'"+res+"'";
        ires=valres.evaluarcadenaentera(cadtipores);
        sqlgineco="insert into ginecologia (idingreso_gineco,idmenarquia_gineco,ciclos_gineco,fechaultregla_gineco,gravidez_gineco,paridad_gineco,cesarea_gineco,aborto_gineco,planifica_gineco,idplanifica_gineco,fechaultcitologia_gineco,idresultadocitologia_gineco,tiempoplanifica_gineco) values ('"+ frameingreso.JFTNumIngr.getText()+"',"+imen + ",'" + framegineco.JTFCiclos.getText()+ "','" + framegineco.JFTFechUltMestr.getText() + "'," + framegineco.JCHGravid.isSelected() + ",'" + framegineco.JTFParidad.getText() + "'," + framegineco.JCHCesarea.isSelected() + "," + framegineco.JCHAborto.isSelected() + "," + framegineco.JCHPlanifica.isSelected() + "," + iplan + ",'" + framegineco.JFTFechUltCit.getText() + "'," + ires + ",'"+framegineco.JFTTiempoPlan.getText()+ "');";
        try{
             TSentenciaGuardarSO=con2.createStatement();
             vargineco=TSentenciaGuardarSO.executeUpdate(sqlgineco);
            }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR LOS DATOS DE GINECOLOGIA";
              cad2="TABLA GINECOLOGIA";
              valres.mensajeconfirmacion(cad1,cad2);
        }//cierra el catch
        Cconsql.CerrarConexion();
        framegineco.dispose();
        frameingreso.dispose();
        return vargineco;
    }

    /**
     * guardarinmuniz
     */
    public int guardarinmuniz() throws SQLException {
         int varinmuniz=0;
         String sqlinmun;
         Connection con2=Cconsql.getConnection();
         CIngreso frameingreso;
         CInmuniz frameinmune;
         frameingreso=(CIngreso)frameROingrOBJ;
         frameinmune=(CInmuniz)frameInmunizOBJ;
         sqlinmun="insert into inmunizaciones (idingreso_inmuniz,tetano_inmuniz,fechatet_inmuniz,fiebreamarilla_inmuniz,fechafiebre_inmuniz,hepatitis_inmuniz,fechahep_inmuniz,otras_inmuniz,fecha_inmuniz,cualotras_inmuniz)values ('" + frameingreso.JFTNumIngr.getText() + "'," + frameinmune.JCHTetano.isSelected() + ",'" + frameinmune.JTFFechaVac.getText() + "'," + frameinmune.JCHfa.isSelected() + ",'" + frameinmune.JTFFechafa.getText() + "'," + frameinmune.JCHHepat.isSelected() + ",'" + frameinmune.JTFFechaHep.getText() + "'," + frameinmune.JCHOtraVac.isSelected() + ",'" + frameinmune.JTFFechaOtrVac.getText() + "','" + frameinmune.JTFOtrosIN.getText() + "'" + ")";
         try{
             TSentenciaGuardarSO=con2.createStatement();
             varinmuniz=TSentenciaGuardarSO.executeUpdate(sqlinmun);
            }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR LOS DATOS DE INMUNIZACION";
              cad2="TABLA INMUNIZACION";
              valres.mensajeconfirmacion(cad1,cad2);
        }//cierra el catch
        Cconsql.CerrarConexion();
        frameingreso.dispose();
        frameinmune.dispose();
        return varinmuniz;
    }

    /**
     * guardarotrosantec
     */
    public int guardarotrosantec() throws SQLException {
        int varotrosantec=0;
        String sqloa;
        Connection con2=Cconsql.getConnection();
        CIngreso frameingreso;
        COtrosAnt frameoa;
        frameingreso=(CIngreso)frameROingrOBJ;
        frameoa=(COtrosAnt)frameOtrosAntecOBJ;
        sqloa="insert into otrosantecedentes (idingreso_otrosdat,tabaco_otrosdat,frecuenciatab_otrosdat,anostab_otrosdat,licor_otrosdat,frecuencialicor_otrosdat,anoslicor_otrosdat,deportre_otrosdat,frecuenciadeporte_otrosdat,anosdeporte_otrosdat,otros_otrosdat,frecuenciaotros_otrosdat,anosotros_otrosdat,psicoadicti_otrosdat,frecuenciapsicoadicti_otrosdat,anospsicoadicti_otrosdat)values ('" + frameingreso.JFTNumIngr.getText() + "'," + frameoa.JCHTabaco.isSelected() +",'"+ frameoa.JTFTabaquismo.getText()+ "','"+frameoa.JTFAnos.getText() + "'," + frameoa.JCHLicor.isSelected() + ",'" + frameoa.JTFIngestaLicor.getText() + "','" + frameoa.JTFAnosLicor.getText() + "'," + frameoa.JCHPractDep.isSelected() + ",'" + frameoa.JTFPractDeport.getText() + "','" + frameoa.JTFAnosPD.getText()+ "'," + frameoa.JCHOtros.isSelected()+",'"+ frameoa.JTFOtr.getText() + "','" + frameoa.JTFOtrosAnos.getText() + "'," + frameoa.JCHSust.isSelected()+",'"+ frameoa.JTFFrecAditc.getText()+ "','" + frameoa.JTFAnAdicc.getText()+ "')";
        try{
             TSentenciaGuardarSO=con2.createStatement();
             varotrosantec=TSentenciaGuardarSO.executeUpdate(sqloa);
            }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR LOS DATOS DE OTROS ANTECEDENTES";
              cad2="TABLA OTROS ANTECEDENTES";
              valres.mensajeconfirmacion(cad1,cad2);
        }//cierra el catch
        Cconsql.CerrarConexion();
        frameingreso.dispose();
        frameoa.dispose();
        return varotrosantec;
    }

    /**
     * guardarrs
     */
    public int guardarrs() throws SQLException {
        int varrs=0;
        String sqlrs;
        Connection con2=Cconsql.getConnection();
        CIngreso frameingreso;
        CRevisionSistemas framers;
        frameingreso=(CIngreso)frameROingrOBJ;
        framers=(CRevisionSistemas)frameRevisionSistemasOBJ;
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
        sqlrs="insert into subgrupo_revsistemas (idingreso_rss,iddoloprecordial_rss,obsdolorprecordial_rss,idlipotimia_rss,obslipotimia_rss,idpalpitaciones_rss,obspalpitaciones_rss,idsincope_rss,obssincope_rss,iddescamacion_rss,obsdescamacion_rss,ideritema_rss,obseritema_rss,idhipehidrosis_rss,obshiperhidrosis_rss,idbrote_rss,obsbrote_rss,idsequedad_rss,obssequedad_rss,idprurito_rss,obsprurito_rss,iddispepsia_rss,obsdispepsia_rss,iddolorabdominal_rss,obsdolorabdominal_rss,idepigastralgiapirosis_rss,obsepigastralgiapirosis_rss,idestrenimiento_rss,obsestre�imiento_rss,iddiarrea_rss,obsdiarrea_rss,idsangrado_rss,obssangrado_rss,iddisminucioncalibre_rss,obsdisminucioncalibre_rss,iddisuria_rss,obsdisuria_rss,idhematuria_rss,obshematuria_rss,idtranstciclomestrual_rss,obstranstciclomestrual_rss,idnicturia_rss,obsnicturia_rss,idpolaquiuria_rss,obspolaquiuria_rss,idtenesmovesical_rss,obstenesmovesical_rss,idcefalea_rss,obscefalea_rss,idalteracionmemoria_rss,obsalteracionmemoria_rss,idalteracionsensibilidad_rss,obsalteracionsensibilidad_rss,idalteracionmotora_rss,obsalteracionmotora_rss,idvertigo_rss,obsvertigo_rss,idardorprurito_rss,obsardorprurito_rss,idcansansio_rss,obscansansio_rss,idvisionborrosa_rss,obsvisionborrosa_rss,idlagrimeo_rss,obslagrimeo_rss,idojorojo_rss,obsojorojo_rss,iddisfonia_rss,obsdisfonia_rss,idepistaxis_rss,obsepistaxis_rss,idhipoacusiasubjetiva_rss,obshipoacusiasubjetiva_rss,idobstruccionnasal_rss,obsobstruccionnasal_rss,idrinorrea_rss,obsrinorrea_rss,idtinitus_rss,obstinitus_rss,idcervicalgia_rss,obscervicalgia_rss,iddorsalgia_rss,obsdorsalgia_rss,idlumbalgia_rss,obslumbalgia_rss,idincapacitante_rss,obsincapacitante_rss,idaltralgias_rss,obsaltralgias_rss,idtendinitis_rss,obstendinitis_rss,idlimitacionfuncional_rss,obslimitacionfuncional_rss,idparentesias_rss,obsparentesias_rss,idtos_rss,obstos_rss,iddolortoraxico_rss,obsdolortoraxico_rss,idexpectoracion_rss,obsexpectoracion_rss,iddisnea_rss,obsdisnea_rss,idcoronaria_rss,obscoronaria_rss,idarritmia_rss,obsarritmia_rss,ha_rss,obsha_rss) values ('"  +frameingreso.JFTNumIngr.getText()+"',"+DolorPrecordialbol  +",'"+framers.JFTDolorPrecordial.getText()+"',"+Lipotimiabol+",'"+framers.JFTLipotimia.getText()+"',"+Palpitacionesbol+",'"+framers.JFTPalpit.getText()+"',"+Sincopebol+",'"+framers.JFTSincope.getText()+"',"+Descamacionbol+",'"+framers.JFTdescam.getText()+"',"+Eritemabol+",'"+framers.JFTEritema.getText()+"',"+Hiperhidrosisbol+",'"+framers.JFTHiperhidrosis.getText()+"',"+Brotebol+",'"+framers.JFTBrote.getText()+"',"+Sequedadbol+",'"+framers.JFTSequedad.getText()+"',"+Pruritobol+",'"+framers.JFTprurito.getText()+"',"+Dispepsiabol+",'"+framers.JFTDispepsia.getText()+"',"+DolorAbdominalbol+",'"+framers.JFTDolorAbd.getText()+"',"+Epigastraigiabol+",'"+framers.JFTEpigastr.getText()+"',"+Estrenimientobol+",'"+framers.JFTEstrenimiento.getText()+"',"+Diarreabol+",'"+framers.JFTDiarrea.getText()+"',"+Sangradobol+",'"+framers.JFTSangrado.getText()+"',"+DisminucionCalibrebol+",'"+framers.JFTDisminucionCalibre.getText()+"',"+Disuriabol+",'"+framers.JFTDisuria.getText()+"',"+Hematuriabol+",'"+framers.JFTHematuria.getText()+"',"+TranstCicloMestrualbol+",'"+framers.JFTtranstCicloMestr.getText()+"',"+Nicturiabol+",'"+framers.JFTNicturia.getText()+"',"+Palaquiuriabol+",'"+framers.JFTPalquiuria.getText()+"',"+TenesmoVesical+",'"+framers.JFTTenesmovesical.getText()+"',"+Cefaleabol+",'"+framers.JFTCefalea.getText()+"',"+AlteracionMemoriabol+",'"+framers.JFTAlteracionMemoria.getText()+"',"+AlteracionSensibilidadbol+",'"+framers.JFTAlteracionSencib.getText()+"',"+AlteracionMotorabol+",'"+framers.JFTAlteracMotora.getText()+"',"+Vertigobol+",'"+framers.JFTVertigo.getText()+"',"+Ardorbol+",'"+framers.JFTArdorPrurito.getText()+"',"+Cansanciobol+",'"+framers.JFTCansancio.getText()+"',"+VisionBorrosabol+",'"+framers.JFTVisionBorrosa.getText()+"',"+Lagrimeobol+",'"+framers.JFTLagrimeo.getText()+"',"+OjoRojobol+",'"+framers.JFTOjoRojo.getText()+"',"+Disfoniabol+",'"+framers.JFTDisfonia.getText()+"',"+Epistaxisbol+",'"+framers.JFTEpistaxis.getText()+"',"+Hipoacusiabol+",'"+framers.JFTHipoacusia.getText()+"',"+ObstruccionNasalbol+",'"+framers.JFTObstruccionNasal.getText()+"',"+Rinorreabol+",'"+framers.JFTRinorrea.getText()+"',"+Tinitusbol+",'"+framers.JFTTinitus.getText()+"',"+Cervicalgiabol+",'"+framers.JFTCervicalgia.getText()+"',"+Dorsalgiabol+",'"+framers.JFTDorsalgia.getText()+"',"+Lumbalgiabol+",'"+framers.JFTLumbalgia.getText()+"',"+Incapacitantebol+",'"+framers.JFTIncapacitante.getText()+"',"+Artralgiasbol+",'"+framers.JFTArtralgias.getText()+"',"+Tendinitisbol+",'"+framers.JFTTendinitis.getText()+"',"+LimitacionFuncionalbol+",'"+framers.JFTLimitacionFunc.getText()+"',"+Parestesiasbol+",'"+framers.JFTParestesias.getText()+"',"+Tosbol+",'"+framers.JFTTos.getText()+"',"+DolorToraxicobol+",'"+framers.JFTDolorToraxico.getText()+"',"+Expectoracionbol+",'"+framers.JFTExpectoracion.getText()+"',"+Disneabol+",'"+framers.jFormattedTextField2.getText()+"'"+","+Coronaria+",'"+framers.JFTCoronaria.getText()+"',"+Arritmia+",'"+framers.JFTArritmia.getText()+"',"+Ha+",'"+framers.JFTha.getText()+"'"+ ")";

        try{
            TSentenciaGuardarSO=con2.createStatement();
            varrs=TSentenciaGuardarSO.executeUpdate(sqlrs);
        }//cierra el try
        catch(SQLException e){
              e.getMessage();
              con2.rollback();
              cad1="NO SE PUDO GRABAR LOS DATOS DE REVISION SISTEMAS";
              cad2="TABLA REVISION SISTEMAS";
              valres.mensajeconfirmacion(cad1,cad2);
        }//cierra el catch
       // Cconsql.CerrarConexion();
        frameingreso.dispose();
        framers.dispose();
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

    /**
     * guardaref
     */
    public int guardaref()throws SQLException {
        int varef=0,estadogeneralhc,ilat;
        String sqlef,cadtipolat;
        Connection con2=Cconsql.getConnection();
        CIngreso frameingreso;
        CExamenFisico frameef;
        frameingreso=(CIngreso)frameROingrOBJ;
        frameef=(CExamenFisico)frameExamenFisicoOBJ;
        boolean cabebol,carabol,ojosbol,oidosbol,narizbol,bocabol,dentadurabol,cuellobol,toraxbol,cardiacobol,pulmonarbol,mamasbol,abdomenbol,genitalbol,msupbol,minfbol,piesbol,columnabol,neurologobol,pielbol;
        String sqlcadEF,cadestadogeneral,sqlestadogeneral;
        cadestadogeneral=valres.evaluarcombocadena(frameef.JCBEstadoGeneral);
        sqlestadogeneral="select *from estado_general where estado_general.nombre_ag="+"'"+cadestadogeneral+"'";
        estadogeneralhc=valres.evaluarcadenaentera(sqlestadogeneral);
        String tipolat=valres.evaluarcombocadena(frameef.JCBLateral);
        cadtipolat="select *from lateral where lateral.nombre_lateral="+"'"+tipolat+"'";
        ilat=valres.evaluarcadenaentera(cadtipolat);
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
       sqlcadEF="insert into examen_fisico (idingreso_EF,estadogen_EF,tasignovital_EF,fcsignovita_EF,frsignovital_EF,pesosignovital_EF,tallasignovita_EF,imcsignovital_EF,rangosignovital,cab_EF,textcab_EF,cara_EF,textcara_EF,ojos_EF,textojos_EF,oidos_EF,textoidos_EF,nariz_EF,textnariz_EF,boca_EF,textboca_EF,dentadura_EF,textdentadura_EF,cuello_EF,textcuello_EF,torax_EF,texttorax_EF,cardiaco_EF,textcardiaco_EF,pulmon_EF,textpulmon_EF,mamas_EF,textmamas_EF,abdomen_EF,textabdomen_EF,genitales_EF,textgenitales_EF,msup_EF,textmsup_EF,minf_EF,textminf_EF,pies_EF,textpies_EF,columna_EF,textcolumna_EF,neurolog_EF,textneurolog_EF,piel_EF,textpiel_EF,idlateral_EF) values ('"  +frameingreso.JFTNumIngr.getText()+"',"+estadogeneralhc  +",'"+frameef.JFTTaEF.getText()+"','"+frameef.JFTfcEF.getText()+"','"+frameef.JFTfrEF.getText()+"','"+frameef.JFTPesoEF.getText()+"','"+frameef.JFTBtallaEF.getText()+"','"+frameef.JFTimcEF.getText()+"','"+frameef.JFTrangoEF.getText()+"',"+cabebol+",'"+frameef.JTFCabeza.getText()+"',"+carabol+",'"+frameef.JTFcaraEF.getText()+"',"+ojosbol+",'"+frameef.JTFojosEF.getText()+"',"+oidosbol+",'"+frameef.JTFoidosEF.getText()+"',"+narizbol+",'"+frameef.JTFnarizEF.getText()+"',"+bocabol+",'"+frameef.JTFbocaEF.getText()+"',"+dentadurabol+",'"+frameef.JTFDentEF.getText()+"',"+cuellobol+",'"+frameef.JTFcuelloEF.getText()+"',"+toraxbol+",'"+frameef.JTFtoraxEF.getText()+"',"+cardiacobol+",'"+frameef.JTFCardiacoEF.getText()+"',"+pulmonarbol+",'"+frameef.JTFPulmonEF.getText()+"',"+mamasbol+",'"+frameef.JTFMamasEF.getText()+"',"+abdomenbol+",'"+frameef.JTFAbdomenEF.getText()+"',"+genitalbol+",'"+frameef.JTFGenitalesEF.getText()+"',"+msupbol+",'"+frameef.JTFMsup.getText()+"',"+minfbol+",'"+frameef.JTFMinfEF.getText()+"',"+piesbol+",'"+frameef.JTFPiesEF.getText()+"',"+columnabol+",'"+frameef.JTFColEF.getText()+"',"+neurologobol+",'"+frameef.JTFNeurlogEF.getText()+"',"+pielbol+",'"+frameef.JTFPielEF.getText()+"',"+ilat+ ")";
       System.out.println("ief:"+sqlcadEF);
       try{
          TSentenciaGuardarSO=con2.createStatement();
          varef=TSentenciaGuardarSO.executeUpdate(sqlcadEF);
       }//cierra el try
       catch(SQLException e){
                       con2.rollback();
                       cad1="NO SE PUDO GRABAR LOS DATOS DE EXAMEN FISICO";
                       cad2="TABLA EXAMEN FISICO";
                       valres.mensajeconfirmacion(cad1,cad2);
                 }//cierra el catch
                 //Cconsql.CerrarConexion();
        frameef.dispose();
        frameingreso.dispose();
        return varef;
    }

    /**
     * guardarparacli
     */
    public int guardarparacli() throws SQLException {
        int varparacli=0;
        String sqlparaclin;
        Connection con2=Cconsql.getConnection();
        CIngreso frameingreso;
        CExamPraclin frameparacli;
        frameingreso=(CIngreso)frameROingrOBJ;
        frameparacli=(CExamPraclin)frameROOBJ;
        sqlparaclin="insert into paraclinicos (idingreso_examparacl,observacion_examparacl,visio_examparacl,audio_examparacl,espiro_examparacl,hematico_examparacl,alturas_examparacl,quimica_examparacl,diag1_examparacl,diag2_examparacl,diag3_examparacl,diag4_examparacl,electrocardiograma_examparacl,otros_examparacli,observacion_examppracli) values ('" + frameingreso.JFTNumIngr.getText()+"','"+ frameparacli.JTAExamPar.getText()+"'," + frameparacli.JCHVisiom.isSelected() + ","+frameparacli.JCHAudio.isSelected()+","+frameparacli.JCHEspirom.isSelected()+","+frameparacli.JCHhematico.isSelected()+","+frameparacli.JCHAlturas.isSelected()+","+frameparacli.JCHQuimica.isSelected()+",'"+frameparacli.JTFDiaguno.getText()+"','"+frameparacli.JTFDos.getText()+"','"+frameparacli.JTFTres.getText()+"','"+frameparacli.JTFCuatro.getText()+"',"+frameparacli.JCHElectro.isSelected()+","+frameparacli.JCHOtros.isSelected()+",'"+frameparacli.JTFOtros.getText()+"')";
        System.out.println("sqlparaclin:"+sqlparaclin);
        try{
          TSentenciaGuardarSO=con2.createStatement();
          varparacli=TSentenciaGuardarSO.executeUpdate(sqlparaclin);
       }//cierra el try
       catch(SQLException e){
             e.getMessage();
             con2.rollback();
                       cad1="NO SE PUDO GRABAR LOS DATOS DE EXAMEN PARACLINICOS";
                       cad2="TABLA EXAMEN PARACLINICOS";
                       valres.mensajeconfirmacion(cad1,cad2);
                 }//cierra el catch
               //  Cconsql.CerrarConexion();
         frameingreso.dispose();
         frameparacli.dispose();
        return varparacli;
    }

    /**
     * guardarresocup
     */
    public int guardarresocup() throws SQLException {
        int varresocup=0;
        String sqlresocup;
        Connection con2=Cconsql.getConnection();
        CIngreso frameingreso;
        frameingreso=(CIngreso)frameROingrOBJ;
        sqlresocup="insert into resocupacional (idingreso_resocup,aptocargo_resocup,aptorestr_resocup,aplazado_resocup,noapto_resocup,motivo_resocup,recomendaciones__resocup,uso_resocup,remision_resocup,reasignacion_resocup,ingreso_resocup,tratamiento_resocup,fisica_resocup,fumar_resocup,alcohol_resocup,peso_resocup) values ('"+ frameingreso.JFTNumIngr.getText()+"',"+JRAptoCargo.isSelected()+","+JRTAptoRest.isSelected()+","+JRBAplazado.isSelected()+","+JRBNoApto.isSelected()+",'"+JTFMOtivo.getText()+"','"+JEDTrecom.getText()+"',"+JCHUso.isSelected()+","+JCHRemEps.isSelected()+","+JCHReasTareas.isSelected()+","+JCHIngrSve.isSelected()+","+JCHSconTr.isSelected()+","+JCHAFisica.isSelected()+","+JCHDejarFumar.isSelected()+","+JCHReducConsAlcohol.isSelected()+","+JCHControlPeso.isSelected()+")";
        try{
          TSentenciaGuardarSO=con2.createStatement();
          varresocup=TSentenciaGuardarSO.executeUpdate(sqlresocup);
       }//cierra el try
       catch(SQLException e){
             e.getMessage();
             con2.rollback();
                       cad1="NO SE PUDO GRABAR LOS DATOS DE RESULTADOS OCUPACIONALES";
                       cad2="TABLA RESULTADOS OCUPACIONALES";
                       valres.mensajeconfirmacion(cad1,cad2);
                 }//cierra el catch
                 //Cconsql.CerrarConexion();
        frameingreso.dispose();
        return varresocup;
    }

    /**
     * procesoimprimir
     */
    public void procesoimprimir() {
        String cadmedico;
        CIngreso frameingreso;
        frameingreso=(CIngreso)frameROingrOBJ;
        String tipoexamen=valres.evaluarcombocadena(frameingreso.JCBTipoEx);
        //cadmedico=valres.evaluarcombocadena(frameingreso.JCBMedTrat);
        if(tipoexamen.compareTo("INGRESO")==0 || tipoexamen.compareTo("INGRESO OSTEOMUSCULAR")==0 || tipoexamen.compareTo("INGRESO POR ALTURA")==0 || tipoexamen.compareTo("REINGRESO")==0 ){
            try{
                imprimirexingreso();
            }
            catch(Exception j){
            }

        }
        else
            if(tipoexamen.compareTo("RETIRO")==0){
                imprimirretiro();
            }
            else
                if(tipoexamen.compareTo("PERIODICO")==0){
                   imprimirperiodico();
                }
      //frameingreso.JBnuevoIng.setEnabled(true);
      this.dispose();
     }

    /**
     * imprimirexingreso
     */
    public void imprimirexingreso() throws Exception {
        String rutingreso;
        rutingreso="C:\\SALUD_OCUPACIONAL\\reportes\\EXINGRESO.jasper";
        procesocomunimpr(rutingreso);

    }

    /**
     * retiro
     */
    public void imprimirretiro() {
        String rutaretiro;
        rutaretiro="C:\\SALUD_OCUPACIONAL\\reportes\\EXRETIRO.jasper";
        procesocomunimpr(rutaretiro);
    }

    /**
     * procesocomunimpr
     */
    public void procesocomunimpr(String ruta) {
        // String fotologo="/Imagenes/AG_CLICK.GIF";
        ///String fotologo="C:\\Documents and Settings\\Luis Felipe\\Escritorio/rosiris.jpg";
        //File file = new File("frameingreso.imagimpr");
        //FileInputStream fis = new FileInputStream(file);
        CExamPraclin frameparacli;
        frameparacli=(CExamPraclin)frameROOBJ;
        String rutaingr;
        int varmes;
        Calendar calendar = new GregorianCalendar();
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        CIngreso frameingreso;
        frameingreso=(CIngreso)frameROingrOBJ;
        InputStream fis = new ByteArrayInputStream(frameingreso.imagimpr);
        Connection con2=Cconsql.getConnection();
        String archivoreporte=ruta;
        String nombre,cargo,varapto="",varnoapto="",varaptolimitado="",varaplazado="",caddia="",cadmes="",cadano="";
        nombre=frameingreso.JFTSgdoNbre.getText();
        nombre=nombre.concat(" ");
        nombre=nombre.concat(frameingreso.JFTPrimerNbre.getText());
        nombre=nombre.concat(" ");
        nombre=nombre.concat(frameingreso.JFTPrimerApll.getText());
        nombre=nombre.concat(" ");
        nombre=nombre.concat(frameingreso.JFTSgdoApll.getText());
        cargo=valres.evaluarcombocadena(frameingreso.JCBCargo);
        caddia=caddia.valueOf(calendar.get(GregorianCalendar.DAY_OF_MONTH));
       varmes=calendar.get(Calendar.MONTH)+1;
        cadmes=valres.retornarnombremes(varmes);
        cadano=cadano.valueOf(calendar.get(Calendar.YEAR));
        if (JRAptoCargo.isSelected()==true)
            varapto="X";
        if (JRBNoApto.isSelected()==true)
            varnoapto="X";
        if (JRTAptoRest.isSelected()==true)
            varaptolimitado ="X";
        if (JRBAplazado.isSelected()==true)
            varaplazado  ="X";
        try{
             int var=0;
             Map parametro = new HashMap();
             parametro.put("usuario",nombre);
             parametro.put("cedula",frameingreso.JFTNDoc.getText());
             parametro.put("sexo",valres.evaluarcombocadena(frameingreso.JCBSexo));
             parametro.put("fechanac",frameingreso.JFTFechaNac.getText());
             parametro.put("edad",frameingreso.JFTEdad.getText());
             parametro.put("barrio",valres.evaluarcombocadena(frameingreso.JCBBarrio));
             parametro.put("dir",frameingreso.JFTDirResidencia.getText());
             parametro.put("telef",frameingreso.JFTTel.getText());
             parametro.put("empresa",valres.evaluarcombocadena(frameingreso.JCBEmpresa));
             parametro.put("actividad",valres.evaluarcombocadena(frameingreso.JCBTipoEmpr));
             parametro.put("examen",valres.evaluarcombocadena(frameingreso.JCBTipoEx));
             parametro.put("orden","");
             parametro.put("fechaatencion",frameingreso.JFTFechaExa.getText());
             parametro.put("fechasalid",frameingreso.JFTFechaExa.getText());
             parametro.put("hora_atencion",frameingreso.JFTHoraAtencion.getText());
             parametro.put("horasalida",valres.formatohora());
             parametro.put("cargo",cargo);
             parametro.put("ciudadinicio","CARTAGENA");
             parametro.put("espiro",selectcheckparaclini(frameparacli.JCHEspirom));
             parametro.put("visio",selectcheckparaclini(frameparacli.JCHVisiom));
             parametro.put("audio",selectcheckparaclini(frameparacli.JCHAudio));
             parametro.put("electro",selectcheckparaclini(frameparacli.JCHElectro));
             parametro.put("quimica",selectcheckparaclini(frameparacli.JCHQuimica));
             parametro.put("otroscheck",selectcheckparaclini(frameparacli.JCHOtros));
             parametro.put("otros",frameparacli.JTFOtros.getText());
             parametro.put("epp",selectcheckparaclini(JCHUso));
             parametro.put("eps",selectcheckparaclini(JCHRemEps));
             parametro.put("tarea",selectcheckparaclini(JCHReasTareas));
             parametro.put("tratamiento",selectcheckparaclini(JCHSconTr));
             parametro.put("fisica",selectcheckparaclini(JCHAFisica));
             parametro.put("fumar",selectcheckparaclini(JCHDejarFumar));
             parametro.put("peso",selectcheckparaclini(JCHControlPeso));
             parametro.put("svs",selectcheckparaclini(JCHIngrSve));
             parametro.put("alcohol",selectcheckparaclini(JCHReducConsAlcohol));
             parametro.put("concp1",varapto);
             parametro.put("concpt2",varnoapto);
             parametro.put("concpt3",varaptolimitado);
             parametro.put("concpt4",varaplazado);
             parametro.put("recom",JEDTrecom.getText());
             parametro.put("ciudadinicio","CARTAGENA");
             parametro.put("restrincciones",JTFMOtivo.getText());
             parametro.put("foto",fis);
             if(valres.evaluarcombocadena(frameingreso.JCBEmpresa).compareTo("PARTICULAR")==0 || valres.evaluarcombocadena(frameingreso.JCBEmpresa).compareTo("EXPLORASUR")==0 ){
                parametro.put("profesional",valres.evaluarcombocadena(frameingreso.JCBMedTrat));
                parametro.put("titulo1","Medico y Cirujano Especialista en Salud Ocupacional");
                parametro.put("titulo2","Universidad de Cartagena");
             }
             else{
                  parametro.put("profesional","");

             }

             parametro.put("rm","232/90");
             parametro.put("licencia","SO:0768 SSB");
             JasperPrint imprimir =  JasperFillManager.fillReport(archivoreporte,parametro,con2);
            // JasperPrintManager.printReport( imprimir, true);
             JasperViewer vista = new JasperViewer(imprimir, false);
             vista.setVisible(true);

        }
        catch (JRException j){
             cad1=j.getLocalizedMessage();
             cad2="PROBLEMAS AL IMPRIMIR EL REPORTE";
             valres.mensajeconfirmacion(cad1,cad2);
         }


    }

    /**
     * imprimirperiodico
     */
    public void imprimirperiodico() {
        String rutaperiodico;
        rutaperiodico="C:\\SALUD_OCUPACIONAL\\reportes\\PERIODICO.jasper";
        procesocomunimpr(rutaperiodico);
    }

    /**
     * guardarblanco
     */
    public int guardarblanco(String cadblanco,Connection con2) throws SQLException {
        int varho=0;
       // Connection con2=Cconsql.getConnection();
        try{
            TSentenciaGuardarSO=con2.createStatement();
            varho=TSentenciaGuardarSO.executeUpdate(cadblanco);

        }//cierra el try
        catch(SQLException e){
            System.out.println("ERROR:"+e.getMessage()); ;
            con2.rollback();
            cad1="NO SE PUDO GRABAR LOS BLANCOS DE LA HISTORIA OCUPACIONAL";
            cad2="TABLA HISTORIA OCUPACIONAL";
            valres.mensajeconfirmacion(cad1,cad2);
        }//cierra el catch
        return varho;
    }

    /**
     * actualizaringr
     */
    public int actualizaringr() throws SQLException {
        String cadtipexam,cadempresa,sqltipexam,sqlempresa,sqljornada,sqlcargo,cadtipempresa,sqltipempresa,cadjornada,cadcargo;
        int varactuiing=0,etipexamhc,emprhc,etipemprhc,etipjornhc,etipcargohc;
        CIngreso frameingreso;
        frameingreso=(CIngreso)frameROingrOBJ;
        Connection con2=Cconsql.getConnection();
        cadtipexam=valres.evaluarcombocadena(frameingreso.JCBTipoEx);
        sqltipexam="select *from tipo_examen where tipo_examen.nombre_TE="+"'"+cadtipexam+"'";
        etipexamhc=valres.evaluarcadenaentera(sqltipexam);
        cadempresa=valres.evaluarcombocadena(frameingreso.JCBEmpresa);
        sqlempresa="select *from empresa where empresa.nombre_empresa="+"'"+cadempresa+"'";
        emprhc=valres.evaluarcadenaentera(sqlempresa);
        cadtipempresa=valres.evaluarcombocadena(frameingreso.JCBTipoEmpr);
        sqltipempresa="select *from tipo_industria where tipo_industria.nombre_tindustria="+"'"+cadtipempresa+"'";
        etipemprhc=valres.evaluarcadenaentera(sqltipempresa);
        cadjornada=valres.evaluarcombocadena(frameingreso.JCBJornada);
        sqljornada="select *from jornada_trabajo where jornada_trabajo.nombrejornada_jtrabajo="+"'"+cadjornada+"'";
        etipjornhc=valres.evaluarcadenaentera(sqljornada);
        cadcargo=valres.evaluarcombocadena(frameingreso.JCBCargo);
        sqlcargo="select *from ocupacion where ocupacion.Nbre_Ocupacion="+"'"+cadcargo+"'";
        etipcargohc=valres.evaluarcadenaentera(sqlcargo);
        //String cadact="UPDATE ingreso SET ingreso.pendiente_ingreso =" + true  + " WHERE ingreso.id_ingreso='"+frameingreso.JFTNumIngr.getText()+"'";
        try{
           TSentenciaGuardarSO=con2.createStatement();
           //con2.setAutoCommit(false);
           String CadIngr="UPDATE ingreso SET ingreso.idtipoex_ingreso ="+etipexamhc+",ingreso.idempresa_ingreso ="+emprhc+",ingreso.idtipoindustria_ingreso ="+etipemprhc+",ingreso.idjornadatrabajo_ingreso ="+etipjornhc+",ingreso.cargoaspira_ingreso="+etipcargohc+",ingreso.descripcioncargo_ingreso ='"+frameingreso.JTADescrCargo.getText()+"',ingreso.elemguantes_ingreso="+frameingreso.JCHGuantes.isSelected()+",ingreso.elemrespi_ingreso ="+frameingreso.JCHProtcResp.isSelected()+",ingreso.elemauditiva_ingreso ="+frameingreso.JCHAuditiva.isSelected()+",ingreso.elemvisual_ingreso ="+frameingreso.JCHVisual.isSelected()+",ingreso.elemotros_ingreso ="+frameingreso.JCHOtros.isSelected()+",ingreso.descrotros_ingreso ='"+frameingreso.JFTOtros.getText()+"',ingreso.observacion_ingreso ='"+frameingreso.JTAObservacion.getText()+"',ingreso.pendiente_ingreso =" + true+ ",ingreso.horasalida_ingreso='"+valres.formatohora() + "' WHERE ingreso.id_ingreso='"+frameingreso.JFTNumIngr.getText()+"'";
           //System.out.println("INGRESOr:"+CadIngr);
           varactuiing=TSentenciaGuardarSO.executeUpdate("UPDATE ingreso SET ingreso.idtipoex_ingreso ="+etipexamhc+",ingreso.idempresa_ingreso ="+emprhc+",ingreso.idtipoindustria_ingreso ="+etipemprhc+",ingreso.idjornadatrabajo_ingreso ="+etipjornhc+",ingreso.cargoaspira_ingreso="+etipcargohc+",ingreso.descripcioncargo_ingreso ='"+frameingreso.JTADescrCargo.getText()+"',ingreso.elemguantes_ingreso="+frameingreso.JCHGuantes.isSelected()+",ingreso.elemrespi_ingreso ="+frameingreso.JCHProtcResp.isSelected()+",ingreso.elemauditiva_ingreso ="+frameingreso.JCHAuditiva.isSelected()+",ingreso.elemvisual_ingreso ="+frameingreso.JCHVisual.isSelected()+",ingreso.elemotros_ingreso ="+frameingreso.JCHOtros.isSelected()+",ingreso.descrotros_ingreso ='"+frameingreso.JFTOtros.getText()+"',ingreso.observacion_ingreso ='"+frameingreso.JTAObservacion.getText()+"',ingreso.pendiente_ingreso =" + true+ ",ingreso.horasalida_ingreso='"+valres.formatohora() + "' WHERE ingreso.id_ingreso='"+frameingreso.JFTNumIngr.getText()+"'");
           //frameingreso.JBguardarIng=(JButton)frameingreso.obotguardar;
           //frameingreso.JBguardarIng.setEnabled(false);
          // System.out.println("varactuiing:"+varactuiing);
       }
           catch (SQLException e) {
            con2.rollback();
            cad1="NO SE ACTUALIZO EL MOVIMIENTO EN LA TABLA INGRESO";
            cad2="ACTUALIZAR DATOS USUARIOS";
            valres.mensajeconfirmacion(cad1,cad2);
            //System.out.println("HAY PROBLEMAS EN ACTUALIZAR  LOS DATOS  DE SUMINISTROS CUANDO REALIZAMOS UNA ENTRADA POR INVENTARIO INICIAL");
           }
       Cconsql.CerrarConexion();
       frameingreso.dispose();
       return varactuiing;
    }

    /**
     * actualizardatosusu
     */
    public int actualizardatosusu()throws SQLException {
       CIngreso frameingreso;
       frameingreso=(CIngreso)frameROingrOBJ;
       Connection con2=Cconsql.getConnection();
       int vardatosusu=0;
       int ver=0,barriohc,ecivilhc,eescolaridadhc,eprofesionhc,emuninaturalhc,edptonaturalhc,emuniprochc,etipedadhc,edptoprochc;String fechanaccad,sqlprofesion,sqlescolaridad,cadprofesion,cadescolaridad,sqltipedad,cadtipedad,cadmuniproc,cadmuninatural,sqlmuninatural,caddptonatural,caddptoproc,sqldptonatural,sqlmuniproc,sqldptoproc,cadecivil,sqlecivil,cadsexo,sqlsexo,sexohc,cadeps,sqleps,epshc,cadips,sqlips,ipshc,cadzona,sqlzona,zonahc,cadbarrio,sqlbarrio;
       fechanaccad=valres.cambiarformatofecha(frameingreso.JFTFechaNac.getText());
       sqltipedad="select *from tipoedad where tipoedad.Nbre_tipoedad="+"'"+frameingreso.JFTTipoEdad.getText()+"'";
       etipedadhc=valres.evaluarcadenaentera(sqltipedad);
       cadmuninatural=valres.evaluarcombocadena(frameingreso.JCBMunNat);
       sqlmuninatural="select *from municipio where municipio.Nbre_Municipio="+"'"+cadmuninatural+"'";
       emuninaturalhc=valres.evaluarcadenaentera(sqlmuninatural);
       caddptonatural=valres.evaluarcombocadena(frameingreso.JCBDptoNat);
       sqldptonatural="select *from departamento where departamento.Nbre_Departamento="+"'"+caddptonatural+"'";
       edptonaturalhc=valres.evaluarcadenaentera(sqldptonatural);
       cadmuniproc=valres.evaluarcombocadena(frameingreso.JCBMunProc);
       sqlmuniproc="select *from municipio where municipio.Nbre_Municipio="+"'"+cadmuniproc+"'";
       emuniprochc=valres.evaluarcadenaentera(sqlmuniproc);
       caddptoproc=valres.evaluarcombocadena(frameingreso.JCBDptoProc);
       sqldptoproc="select *from departamento where departamento.Nbre_Departamento="+"'"+caddptoproc+"'";
       edptoprochc=valres.evaluarcadenaentera(sqldptoproc);
       cadsexo=valres.evaluarcombocadena(frameingreso.JCBSexo);
       sqlsexo="select *from sexo where sexo.Nbre_Sexo="+"'"+cadsexo+"'";
       sexohc=valres.buscarcadena(sqlsexo,1);
       cadecivil=valres.evaluarcombocadena(frameingreso.JCBEstadoCivil);
       sqlecivil="select *from estadocivil where estadocivil.Nbre_EstadoCivil="+"'"+cadecivil+"'";
       ecivilhc=valres.evaluarcadenaentera(sqlecivil);
       cadzona=valres.evaluarcombocadena(frameingreso.JCBZonRes);
       sqlzona="select *from zona where zona.nombre_zona="+"'"+cadzona+"'";
       zonahc=valres.buscarcadena(sqlzona,1);
       cadbarrio=valres.evaluarcombocadena(frameingreso.JCBBarrio);
       sqlbarrio="select *from barrio where barrio.Nbre_Barrio="+"'"+cadbarrio+"'";
       barriohc=valres.evaluarcadenaentera(sqlbarrio);
       cadeps=valres.evaluarcombocadena(frameingreso.JCBEps);
       sqleps="select *from eps where eps.nombre_eps="+"'"+cadeps+"'";
       epshc=valres.buscarcadena(sqleps,1);
       cadips=valres.evaluarcombocadena(frameingreso.JCBIps);
       sqlips="select *from ips where ips.nombre_ips="+"'"+cadips+"'";
       ipshc=valres.buscarcadena(sqlips,1);
       cadescolaridad=valres.evaluarcombocadena(frameingreso.JCBEscolaridad);
       sqlescolaridad="select *from escolaridad where escolaridad.nombre_es="+"'"+cadescolaridad+"'";
       eescolaridadhc=valres.evaluarcadenaentera(sqlescolaridad);
       cadprofesion=valres.evaluarcombocadena(frameingreso.JCBProfesion);
       sqlprofesion="select *from profesionales where profesionales.nombre_pro="+"'"+cadprofesion+"'";
       eprofesionhc=valres.evaluarcadenaentera(sqlprofesion);
       String cadprueb="UPDATE datosusuarios SET datosusuarios.PrimerApellido_du='"+frameingreso.JFTPrimerApll.getText()+"',"+"datosusuarios.SegundoApellido_du='"+frameingreso.JFTSgdoApll.getText()+"',"+"datosusuarios.PrimerNombre_du='"+frameingreso.JFTSgdoNbre.getText()+"',"+"datosusuarios.SegundoNombre_du='"+frameingreso.JFTPrimerNbre.getText()+"',"+"datosusuarios.FechadeNacimiento_du='"+fechanaccad+"',datosusuarios.idtipoedad_du="+etipedadhc+",datosusuarios.edad_du='"+frameingreso.JFTEdad.getText()+"',datosusuarios.IdSexo_du='"+sexohc+"',datosusuarios.IdEstadoCivi_du ="+ecivilhc+",datosusuarios.NumHijos_du ='"+frameingreso.JFTNHijos.getText()+"'," +"datosusuarios.IdMunicipionatural="+emuninaturalhc+",datosusuarios.IdDepartamentonatural_du="+edptonaturalhc+",datosusuarios.IdMunicipioprocedente_du="+emuniprochc+",datosusuarios.IdDepartamentoprocedente_du="+edptoprochc+",datosusuarios.idtipoescolaridad_du="+eescolaridadhc+",datosusuarios.profesion_du="+eprofesionhc+",datosusuarios.ideps_du="+epshc+",datosusuarios.idips_du="+ipshc+",datosusuarios.idzonares_du="+zonahc+",datosusuarios.Barrio_du="+barriohc+",datosusuarios.DireccionResidencia_du='"+frameingreso.JFTDirResidencia.getText()+"',"+"datosusuarios.TelefonoCelular_du='"+frameingreso.JFTTel.getText()+"' WHERE datosusuarios.NoHC_du='"+frameingreso.JFTNDoc.getText()+"'";
      // String cadprueb="UPDATE datosusuarios SET datosusuarios.FechadeNacimiento_du=?,"+"datosusuarios.idtipoedad_du=?,"+"datosusuarios.edad_du=?,"+"datosusuarios.IdSexo_du=?,"+"datosusuarios.IdEstadoCivi_du =?,"+"datosusuarios.NumHijos_du =?," +"datosusuarios.IdMunicipionatural=?,"+"datosusuarios.IdDepartamentonatural_du=?,"+"datosusuarios.IdMunicipioprocedente_du=?,"+"datosusuarios.IdDepartamentoprocedente_du=?,"+"datosusuarios.idtipoescolaridad_du=?,"+"datosusuarios.profesion_du=?,"+",datosusuarios.ideps_du=?,"+"datosusuarios.idips_du=?,"+"datosusuarios.idzonares_du=?,"+"datosusuarios.Barrio_du=?,"+"datosusuarios.DireccionResidencia_du=?,"+"datosusuarios.foto_du=?,"+" WHERE datosusuarios.NoHC_du='"+frameingreso.JFTNDoc.getText()+"'";
       System.out.println("DATOS USU:" + cadprueb);
       try{/*procesograbarimagenres(frameingreso.JBFoto.getIcon());
            PreparedStatement pst = con2.prepareStatement(cadprueb);
            pst.setString(1, fechanaccad);
            pst.setInt(2, etipedadhc);
            pst.setString(3, frameingreso.JFTEdad.getText());
            pst.setString(4, sexohc);
            pst.setInt(5, ecivilhc);
            pst.setString(6, frameingreso.JFTNHijos.getText());
            pst.setInt(7, emuninaturalhc);
            pst.setInt(8, edptonaturalhc);
            pst.setInt(9, emuniprochc);
            pst.setInt(10, edptoprochc);
            pst.setInt(11, eescolaridadhc);
            pst.setInt(12, eprofesionhc);
            pst.setString(13, epshc);
            pst.setString(14, ipshc);
            pst.setString(15, ipshc);
            pst.setString(16, zonahc);
            pst.setInt(17, barriohc);
            pst.setString(18, zonahc);
            pst.setString(19, frameingreso.JFTDirResidencia.getText());
            pst.setString(20, zonahc);
            pst.setBinaryStream(21, fis, (int) file1.length());*/
            TSentenciaGuardarSO=con2.createStatement();
            vardatosusu=TSentenciaGuardarSO.executeUpdate(cadprueb);
        }
            catch (SQLException e) {
             System.out.println("HAY PROBLEMAS:"+e.getMessage());
             con2.rollback();
             cad1="NO SE ACTUALIZO EL MOVIMIENTOEN LA TABLA datosusuarios";
             cad2="ACTUALIZAR DATOS USUARIOS";
             valres.mensajeconfirmacion(cad1,cad2);
          }
        Cconsql.CerrarConexion();
        frameingreso.dispose();
       return vardatosusu;
    }

    /**
     * selectcheck
     */
    public String selectcheckparaclini(JCheckBox varcheck) {
        if(varcheck.isSelected()==true)
            return "X";
        else
            return "";
    }

    public CResOcupacional() {
    }

    /**
     * procesograbarimagenres
     */


    //


}//FIN CLASE


class CResOcupacional_JBSgteAF_actionAdapter implements ActionListener {
    private CResOcupacional adaptee;
    CResOcupacional_JBSgteAF_actionAdapter(CResOcupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSgteAF_actionPerformed(e);
    }
}


class CResOcupacional_JRBNoApto_actionAdapter implements ActionListener {
    private CResOcupacional adaptee;
    CResOcupacional_JRBNoApto_actionAdapter(CResOcupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBNoApto_actionPerformed(e);
    }
}


class CResOcupacional_JRTAptoRest_actionAdapter implements ActionListener {
    private CResOcupacional adaptee;
    CResOcupacional_JRTAptoRest_actionAdapter(CResOcupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRTAptoRest_actionPerformed(e);
    }
}


class CResOcupacional_JRBAplazado_actionAdapter implements ActionListener {
    private CResOcupacional adaptee;
    CResOcupacional_JRBAplazado_actionAdapter(CResOcupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRBAplazado_actionPerformed(e);
    }
}


class CResOcupacional_JRAptoCargo_actionAdapter implements ActionListener {
    private CResOcupacional adaptee;
    CResOcupacional_JRAptoCargo_actionAdapter(CResOcupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JRAptoCargo_actionPerformed(e);
    }
}


class CResOcupacional_JBAtrasAF_actionAdapter implements ActionListener {
    private CResOcupacional adaptee;
    CResOcupacional_JBAtrasAF_actionAdapter(CResOcupacional adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasAF_actionPerformed(e);
    }
}

