package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class CInmuniz extends JInternalFrame {
    Object objppaliz;
    Object obotactualizarIZ;
    public Statement TSentenciaconsultaOA;
    public ResultSet RconsultaOA;
    public ConexionSql Cconsql= new ConexionSql();
    ValidarComponentes validOA=new ValidarComponentes();
    String cad1;
    String cad2;
    String numingredicOA;
    int swedicingrOA;
    Object  objetootrosantece= new Object();
    int swgte;
    int swval;
    Object JDPIngresoobjIN=new Object();
    String nombrin= new String();
    String numhcin= new String();
    Object frameINOBJ= new Object();
    Object frameagOBJ= new Object();
     Object framehoOBJ= new Object();
     Object frameEnfProfOBJ=new Object();
     Object frameAcciTrabajoOBJ=new Object();
     Object frameAntecFamOBJ=new Object();
     Object frameAntecPersonalOBJ=new Object();
     Object frameGinecologiaOBJ=new Object();
    public String nombredetalle="";
    public static int swepilepc=1;
    CInmuniz objCIN;
    //DECLARACION DE PANELES
    JTabbedPane JTBAntFam = new JTabbedPane();
    JPanel JPAntecedentesFamiliar = new JPanel();
    JPanel JPAntFam = new JPanel();
    //DECLARACION DE OBJETOS VISUALES
    JButton JBAtrasAF = new JButton();
    JButton JBCancelarAF = new JButton();
    JButton JBSgteAF = new JButton();
    JLabel JLBNumhcAF = new JLabel();
    JLabel JLBVacuna = new JLabel();
    JLabel JLBFechaVac = new JLabel();
    JCheckBox JCHTetano = new JCheckBox();
    JTextField JTFFechaVac = new JTextField();
    JCheckBox JCHfa = new JCheckBox();
    JTextField JTFFechafa = new JTextField();
    JCheckBox JCHHepat = new JCheckBox();
    JTextField JTFFechaHep = new JTextField();
    JCheckBox JCHOtraVac = new JCheckBox();
    JTextField JTFFechaOtrVac = new JTextField();
    JLabel JLBNombrPacIN = new JLabel();
    JTextField JTFOtrosIN = new JTextField();
    //
    public CInmuniz(Object obotactualizarGO,String numingredicIZ,int swedicingrIZ,String Nombrepacag,CAGineco frameag,String varnHC,JDesktopPane JDPIngreso,CIngreso frameingreso,CHistoriaOcup framehistocup,CEnfermedadProf frameenfermedadprof,CHistoriaAcciTrab frameaccitrabajo,CAntecedentesFamiliar frameantecendnetesfam,CAntecedentesPersonales frameantecpersonal,Object objppalgo) {

       try {
            jbInit();
            frameINOBJ=frameingreso;
            frameagOBJ=frameag;
            framehoOBJ=framehistocup;
            frameEnfProfOBJ=frameenfermedadprof;
            frameAcciTrabajoOBJ=frameaccitrabajo;
            frameAntecFamOBJ=frameantecendnetesfam;
            frameAntecPersonalOBJ=frameantecpersonal;
            //frameGinecologiaOBJ=frameginecologia;
            JLBNombrPacIN.setText(Nombrepacag);
            JLBNumhcAF.setText(varnHC);
            JDPIngresoobjIN=JDPIngreso;
            nombrin=Nombrepacag;
            numhcin=varnHC;
            swgte=0;
            swedicingrOA=swedicingrIZ;
            numingredicOA=numingredicIZ;
            obotactualizarIZ=obotactualizarGO;
            objppaliz=objppalgo;
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
        JBAtrasAF.addActionListener(new CInmuniz_JBAtrasAF_actionAdapter(this));
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
        JBSgteAF.addActionListener(new CInmuniz_JBSgteAF_actionAdapter(this));
        //JBSgteAF.addActionListener(ne              CAntecedentesPersonales_JBSgteAP_actionAdapter(this));
       JBSgteAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN4.GIF")));
       JBSgteAF.setSelectedIcon(null);
       JLBNumhcAF.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
       JLBNumhcAF.setForeground(Color.red);
       JLBNumhcAF.setToolTipText("");
       JLBNumhcAF.setText("");
       JLBNumhcAF.setBounds(new Rectangle(469, 17, 158, 24));
        JLBVacuna.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        JLBVacuna.setForeground(Color.red);
        JLBVacuna.setToolTipText("");
        JLBVacuna.setText("VACUNA");
        JLBVacuna.setBounds(new Rectangle(148, 22, 91, 32));
        JLBFechaVac.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        JLBFechaVac.setForeground(Color.red);
        JLBFechaVac.setToolTipText("");
        JLBFechaVac.setText("FECHA");
        JLBFechaVac.setBounds(new Rectangle(631, 22, 61, 32));
        JCHTetano.setBackground(SystemColor.textHighlight);
        JCHTetano.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHTetano.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHTetano.setToolTipText("");
        JCHTetano.setText("TETANO");
        JCHTetano.setBounds(new Rectangle(107, 64, 148, 23));
        JCHTetano.addActionListener(new CInmuniz_JCHTetano_actionAdapter(this));
        JTFFechaVac.setBackground(Color.white);
        JTFFechaVac.setEnabled(false);
        JTFFechaVac.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFFechaVac.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFFechaVac.setToolTipText("");
        JTFFechaVac.setText("");
        JTFFechaVac.setBounds(new Rectangle(606, 70, 106, 22));
        JCHfa.setBackground(SystemColor.textHighlight);
        JCHfa.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHfa.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHfa.setToolTipText("");
        JCHfa.setText("FIEBRE AMARILLA");
        JCHfa.setBounds(new Rectangle(107, 151, 148, 23));
        JCHfa.addActionListener(new CInmuniz_JCHfa_actionAdapter(this));
        JTFFechafa.setBackground(Color.white);
        JTFFechafa.setEnabled(false);
        JTFFechafa.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFFechafa.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFFechafa.setToolTipText("");
        JTFFechafa.setBounds(new Rectangle(607, 149, 105, 22));
        JCHHepat.setBackground(SystemColor.textHighlight);
        JCHHepat.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHHepat.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHHepat.setToolTipText("");
        JCHHepat.setText("HEPATITIS");
        JCHHepat.setBounds(new Rectangle(108, 239, 148, 23));
        JCHHepat.addActionListener(new CInmuniz_JCHHepat_actionAdapter(this));
        JTFFechaHep.setBackground(Color.white);
        JTFFechaHep.setEnabled(false);
        JTFFechaHep.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFFechaHep.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFFechaHep.setToolTipText("");
        JTFFechaHep.setText("");
        JTFFechaHep.setBounds(new Rectangle(608, 237, 105, 22));
        JCHOtraVac.setBackground(SystemColor.textHighlight);
        JCHOtraVac.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHOtraVac.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHOtraVac.setToolTipText("");
        JCHOtraVac.setText("OTRAS");
        JCHOtraVac.setBounds(new Rectangle(109, 322, 148, 23));
        JCHOtraVac.addActionListener(new CInmuniz_JCHOtraVac_actionAdapter(this));
        JTFFechaOtrVac.setBackground(Color.white);
        JTFFechaOtrVac.setEnabled(false);
        JTFFechaOtrVac.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFFechaOtrVac.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFFechaOtrVac.setToolTipText("");
        JTFFechaOtrVac.setBounds(new Rectangle(608, 304, 108, 22));
        JLBNombrPacIN.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNombrPacIN.setForeground(Color.red);
        JLBNombrPacIN.setToolTipText("");
        JLBNombrPacIN.setBounds(new Rectangle(8, 19, 389, 24));
        JTFOtrosIN.setBackground(Color.white);
        JTFOtrosIN.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFOtrosIN.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFOtrosIN.setToolTipText("");
        JTFOtrosIN.setBounds(new Rectangle(749, 305, 213, 22));
        this.getContentPane().add(JPAntecedentesFamiliar);
       //Adicionamos al JPAntecedentesFamiliar
       JPAntecedentesFamiliar.add(JBAtrasAF);
       JPAntecedentesFamiliar.add(JBCancelarAF);
       JPAntecedentesFamiliar.add(JBSgteAF); //JPAntecedentesFamiliar.add(JLBnhcAP);
       //JPAntecedentesFamiliar.add(JLBNumhcAP);
       JPAntecedentesFamiliar.add(JTBAntFam);
        JPAntecedentesFamiliar.add(JLBNumhcAF);
        JPAntecedentesFamiliar.add(JLBNombrPacIN);
        JTBAntFam.add(JPAntFam, "INMUNIZACIONES");
        JPAntFam.add(JLBVacuna);
        JPAntFam.add(JCHTetano);
        JPAntFam.add(JTFFechaVac);
        JPAntFam.add(JCHOtraVac);
        JPAntFam.add(JTFFechafa);
        JPAntFam.add(JCHHepat);
        JPAntFam.add(JCHfa);
        JPAntFam.add(JTFFechaHep);
        JPAntFam.add(JLBFechaVac);
        JPAntFam.add(JTFFechaOtrVac);
        JPAntFam.add(JTFOtrosIN);
    }


    public void inicioventanaIN(CInmuniz frameIN) {
        objCIN=frameIN;
    }

    public void JBAtrasAF_actionPerformed(ActionEvent e) {
         CAGineco frameAGAtras;
         frameAGAtras=(CAGineco)frameagOBJ;
         frameAGAtras.setVisible(true);
         objCIN.setVisible(false);
    }

    public void JBSgteAF_actionPerformed(ActionEvent e) {
           validarnulosOA();
    }

    /**
     * validarnulosOA
     */
    public void validarnulosOA() {
        swval=0;
        CIngreso frameingreso;
        CHistoriaOcup framehistocup;
        CEnfermedadProf frameenfermedadprof;
        CHistoriaAcciTrab frameaccitrabajo;
        CAntecedentesFamiliar frameantecendnetesfam;
        CAntecedentesPersonales frameantecpersonal;
        CAGineco frameginecologia;
        CInmuniz framein;
        frameingreso=(CIngreso)frameINOBJ;
        framein=(CInmuniz)objCIN;
        framein.setVisible(false);
        JDesktopPane JDPIngresoEP=new JDesktopPane();
        JDPIngresoEP=(JDesktopPane)JDPIngresoobjIN;
        framehistocup=(CHistoriaOcup)framehoOBJ;
        frameenfermedadprof=(CEnfermedadProf)frameEnfProfOBJ;
        frameaccitrabajo=(CHistoriaAcciTrab)frameAcciTrabajoOBJ;
        frameantecendnetesfam=(CAntecedentesFamiliar)frameAntecFamOBJ;
        frameantecpersonal=(CAntecedentesPersonales)frameAntecPersonalOBJ;
        frameginecologia=(CAGineco)frameagOBJ;
        if(swgte==0){
            COtrosAnt frameOA = new COtrosAnt(obotactualizarIZ,numingredicOA,swedicingrOA,nombrin,framein,numhcin,JDPIngresoEP,frameingreso,framehistocup,frameenfermedadprof,frameaccitrabajo,frameantecendnetesfam,frameantecpersonal,frameginecologia,objppaliz);
            frameOA.setBounds(0, 2, 1010, 600);
            frameOA.setTitle("OTROS ANTECEDENTES");
            JDPIngresoEP.add(frameOA, new Integer(1));
            frameOA.setLocation(5, 55);
            frameOA.show();
            frameOA.setVisible(true);
            frameOA.inicioventanaOA(frameOA);
            swgte=1;
            objetootrosantece=frameOA;
            if(swedicingrOA==1){
                String cadsqledicOA;
                Connection con2=Cconsql.getConnection();
                cadsqledicOA="SELECT ingreso.id_ingreso, otrosantecedentes.tabaco_otrosdat, otrosantecedentes.frecuenciatab_otrosdat, otrosantecedentes.anostab_otrosdat, otrosantecedentes.licor_otrosdat, otrosantecedentes.frecuencialicor_otrosdat, otrosantecedentes.anoslicor_otrosdat, otrosantecedentes.deportre_otrosdat, otrosantecedentes.frecuenciadeporte_otrosdat, otrosantecedentes.anosdeporte_otrosdat, otrosantecedentes.otros_otrosdat, otrosantecedentes.frecuenciaotros_otrosdat, otrosantecedentes.anosotros_otrosdat,otrosantecedentes.psicoadicti_otrosdat, otrosantecedentes.frecuenciapsicoadicti_otrosdat, otrosantecedentes.anospsicoadicti_otrosdat FROM ingreso INNER JOIN otrosantecedentes ON ingreso.id_ingreso = otrosantecedentes.idingreso_otrosdat WHERE ingreso.id_ingreso="+numingredicOA;
                try{
                    TSentenciaconsultaOA = con2.createStatement();
                    RconsultaOA = TSentenciaconsultaOA.executeQuery(cadsqledicOA);
                    while (RconsultaOA.next()) {
                        frameOA.JCHTabaco.setSelected(RconsultaOA.getBoolean(2));
                        frameOA.JTFTabaquismo.setText(RconsultaOA.getString(3));
                        frameOA.JTFAnos.setText(RconsultaOA.getString(4));
                        frameOA.JCHLicor.setSelected(RconsultaOA.getBoolean(5));
                        frameOA.JTFIngestaLicor.setText(RconsultaOA.getString(6));
                        frameOA.JTFAnosLicor.setText(RconsultaOA.getString(7));
                        frameOA.JCHPractDep.setSelected(RconsultaOA.getBoolean(8));
                        frameOA.JTFPractDeport.setText(RconsultaOA.getString(9));
                        frameOA.JTFAnosPD.setText(RconsultaOA.getString(10));
                        frameOA.JCHOtros.setSelected(RconsultaOA.getBoolean(11));
                        frameOA.JTFOtr.setText(RconsultaOA.getString(12));
                        frameOA.JTFOtrosAnos.setText(RconsultaOA.getString(13));
                        frameOA.JTFTabaquismo.setEnabled(true);
                        frameOA.JTFAnos.setEnabled(true);
                        frameOA.JTFIngestaLicor.setEnabled(true);
                        frameOA.JTFAnosLicor.setEnabled(true);
                        frameOA.JTFPractDeport.setEnabled(true);
                        frameOA.JTFAnosPD.setEnabled(true);
                        frameOA.JTFOtr.setEnabled(true);
                        frameOA.JTFOtrosAnos.setEnabled(true);
                        frameOA.JCHSust.setSelected(RconsultaOA.getBoolean(14));
                        frameOA.JTFFrecAditc.setText(RconsultaOA.getString(15));
                        frameOA.JTFAnAdicc.setText(RconsultaOA.getString(16));
                    }//fin del while
                }//fin del try
                catch(SQLException e1){
                  e1.getMessage();
                  cad2="NO SE PUDO EJECUTAR LA CONSULTA";
                  cad1="PROBLEMAS CON LOS DATOS DE OTROS ANTECEDENTES EN EDICION";
                  validOA.mensajeconfirmacion(cad1,cad2);
                }//cierra el catch
                Cconsql.CerrarConexion();
            }
        }
        else{
            COtrosAnt frameOA;
            frameOA=(COtrosAnt)objetootrosantece;
           // ObjectCingreso.setVisible(false);
            frameOA.setVisible(true);
       }


    }

    public void JCHTetano_actionPerformed(ActionEvent e) {
         controltextfield(JCHTetano,JTFFechaVac);
         JTFFechaVac.requestFocus();
    }

    /**
     * controltextfield
     */
    public void controltextfield(JCheckBox JCHparametro,JTextField JTFpar) {
        if(JCHparametro.isSelected()==true){
            JCHparametro.setSelected(true);
            JTFpar.setEnabled(true);

        }
        else{
            JCHparametro.setSelected(false);
            JTFpar.setText(" ");
           // JBvar.setEnabled(false);

        }

    }

    public void JCHfa_actionPerformed(ActionEvent e) {
         controltextfield(JCHfa,JTFFechafa);
         JTFFechafa.requestFocus();
    }

    public void JCHHepat_actionPerformed(ActionEvent e) {
          controltextfield(JCHHepat,JTFFechaHep);
          JTFFechaHep.requestFocus();
    }

    public void JCHOtraVac_actionPerformed(ActionEvent e) {
      controltextfield(JCHOtraVac,JTFFechaOtrVac);
      JTFFechaOtrVac.requestFocus();
    }

    public CInmuniz() {
    }

    //


}//FIN CLASE


class CInmuniz_JCHOtraVac_actionAdapter implements ActionListener {
    private CInmuniz adaptee;
    CInmuniz_JCHOtraVac_actionAdapter(CInmuniz adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHOtraVac_actionPerformed(e);
    }
}


class CInmuniz_JCHHepat_actionAdapter implements ActionListener {
    private CInmuniz adaptee;
    CInmuniz_JCHHepat_actionAdapter(CInmuniz adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHHepat_actionPerformed(e);
    }
}


class CInmuniz_JCHfa_actionAdapter implements ActionListener {
    private CInmuniz adaptee;
    CInmuniz_JCHfa_actionAdapter(CInmuniz adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHfa_actionPerformed(e);
    }
}


class CInmuniz_JCHTetano_actionAdapter implements ActionListener {
    private CInmuniz adaptee;
    CInmuniz_JCHTetano_actionAdapter(CInmuniz adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHTetano_actionPerformed(e);
    }
}


class CInmuniz_JBSgteAF_actionAdapter implements ActionListener {
    private CInmuniz adaptee;
    CInmuniz_JBSgteAF_actionAdapter(CInmuniz adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSgteAF_actionPerformed(e);
    }
}


class CInmuniz_JBAtrasAF_actionAdapter implements ActionListener {
    private CInmuniz adaptee;
    CInmuniz_JBAtrasAF_actionAdapter(CInmuniz adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasAF_actionPerformed(e);
    }
}

