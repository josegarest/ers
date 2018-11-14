package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;

import javax.swing.*;

import com.toedter.calendar.*;

public class CEnfermedadProf extends JInternalFrame {
    Object objppalep;
    Object obotactualizarEP;
    public Statement TSentenciaconsultaAT;
    public ResultSet RconsultaAT;
    public ConexionSql Cconsql= new ConexionSql();
    String numingredicAT;
    int swedicingrEP;
    String cad1;
    String cad2;
    Object  objetoaccidente= new Object();
    int swgte;
    String sFechaEP;
    Date fechainiEP=new Date();
    JCalendar jCalendar1 = new JCalendar();
    ValidarComponentes validEP=new ValidarComponentes();
    int ifila=0;
    ModeloHEP modeloep=new ModeloHEP();
    String nombrep= new String();
    String numhcep= new String();
    int swval;
    Object JDPIngresoobjEP=new Object();
    Object framehoOBJ= new Object();
    Object frameEnfProfOBJ=new Object();
    Object frameepOBJ=new Object();
    Object frameingresoOBJ=new Object();
    public String nombredetalle="";
    public static int swepilepc=1;
    CEnfermedadProf objCAF;
    //DECLARACION DE PANELES
    JTabbedPane JTBAntFam = new JTabbedPane();
    JPanel JPAntecedentesFamiliar = new JPanel();
    JPanel JPAntFam = new JPanel();
    //DECLARACION DE OBJETOS VISUALES
    JButton JBAtrasAF = new JButton();
    JButton JBCancelarAF = new JButton();
    JButton JBSgteAF = new JButton();
    JLabel JLBNumhcAF = new JLabel();
    JLabel JLBEmpresa = new JLabel();
    JTextField JTFEmprHEP = new JTextField();
    JLabel JLBFechHEP = new JLabel();
    JFormattedTextField JFTFechHEP = new JFormattedTextField();
    JLabel JLBDiagHEP = new JLabel();
    JTextField JTFDiagHEP = new JTextField();
    JLabel JLBPersna = new JLabel();
    JTextField JTFPersHEP = new JTextField();
    JScrollPane JSPHEP = new JScrollPane();
    JTable JTBenfPer = new JTable(modeloep);
    JLabel JLBNombrPacEP = new JLabel();
    //CONSTRUCTOR
    public CEnfermedadProf(Object obotactualizarHO,String numingredicEP,int swedicingrho,String Nombrepacep,CHistoriaOcup frameho,String varnHC,JDesktopPane JDPIngreso,CIngreso frameingreso,Object objppalho) {
       frameingresoOBJ=frameingreso;
       framehoOBJ=frameho;
       //frameEnfProfOBJ
       nombrep=Nombrepacep;
       numhcep=varnHC;
       swgte=0;
       try {
            jbInit();
            JLBNombrPacEP.setText(Nombrepacep);
            JLBNumhcAF.setText(varnHC);
            JDPIngresoobjEP=JDPIngreso;
            anadirentradaEP();
       }
       catch (Exception ex) {
           ex.printStackTrace();
       }
       swedicingrEP=swedicingrho;
       numingredicAT=numingredicEP;
       obotactualizarEP=obotactualizarHO;
       objppalep=objppalho;
    }

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
        JBAtrasAF.addActionListener(new CEnfermedadProf_JBAtrasAF_actionAdapter(this));
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
        JBSgteAF.addActionListener(new CEnfermedadProf_JBSgteAF_actionAdapter(this));
        //JBSgteAF.addActionListener(ne              CAntecedentesPersonales_JBSgteAP_actionAdapter(this));
       JBSgteAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN4.GIF")));
       JBSgteAF.setSelectedIcon(null);
       JLBNumhcAF.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
       JLBNumhcAF.setForeground(Color.red);
       JLBNumhcAF.setToolTipText("");
       JLBNumhcAF.setText("");
       JLBNumhcAF.setBounds(new Rectangle(486, 11, 158, 24));
        JLBEmpresa.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBEmpresa.setForeground(Color.red);
        JLBEmpresa.setToolTipText("");
        JLBEmpresa.setText("EMPRESA");
        JLBEmpresa.setBounds(new Rectangle(5, 10, 59, 20));
        JTFEmprHEP.setBackground(Color.white);
        JTFEmprHEP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFEmprHEP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFEmprHEP.setToolTipText("");
        JTFEmprHEP.setText("");
        JTFEmprHEP.setBounds(new Rectangle(98, 11, 372, 22));
        JTFEmprHEP.addKeyListener(new CEnfermedadProf_JTFEmprHEP_keyAdapter(this));
        JLBFechHEP.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBFechHEP.setForeground(Color.red);
        JLBFechHEP.setToolTipText("");
        JLBFechHEP.setText("FECHA ");
        JLBFechHEP.setBounds(new Rectangle(577, 17, 52, 20));
        JFTFechHEP.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTFechHEP.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTFechHEP.setToolTipText("");
        JFTFechHEP.setText("");
        JFTFechHEP.setBounds(new Rectangle(757, 14, 126, 21));
        JFTFechHEP.addKeyListener(new CEnfermedadProf_JFTFechHEP_keyAdapter(this));
        JFTFechHEP.addFocusListener(new CEnfermedadProf_JFTFechHEP_focusAdapter(this));
        JLBDiagHEP.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBDiagHEP.setForeground(Color.red);
        JLBDiagHEP.setToolTipText("");
        JLBDiagHEP.setText("DIAGNOSTICO");
        JLBDiagHEP.setBounds(new Rectangle(5, 50, 87, 20));
        JTFDiagHEP.setBackground(Color.white);
        JTFDiagHEP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFDiagHEP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFDiagHEP.setToolTipText("");
        JTFDiagHEP.setText("");
        JTFDiagHEP.setBounds(new Rectangle(98, 49, 372, 22));
        JTFDiagHEP.addKeyListener(new CEnfermedadProf_JTFDiagHEP_keyAdapter(this));
        JLBPersna.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBPersna.setForeground(Color.red);
        JLBPersna.setToolTipText("");
        JLBPersna.setText("PERSONA QUE REALIZO Dx");
        JLBPersna.setBounds(new Rectangle(575, 51, 153, 20));
        JTFPersHEP.setBackground(Color.white);
        JTFPersHEP.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFPersHEP.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFPersHEP.setToolTipText("");
        JTFPersHEP.setBounds(new Rectangle(757, 50, 202, 22));
        JTFPersHEP.addKeyListener(new CEnfermedadProf_JTFPersHEP_keyAdapter(this));
        JSPHEP.getViewport().setBackground(Color.white);
        JSPHEP.setBorder(BorderFactory.createRaisedBevelBorder());
        JSPHEP.setBounds(new Rectangle(4, 97, 965, 297));
        JLBNombrPacEP.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNombrPacEP.setForeground(Color.red);
        JLBNombrPacEP.setToolTipText("");
        JLBNombrPacEP.setText("");
        JLBNombrPacEP.setBounds(new Rectangle(8, 12, 503, 24));
        jCalendar1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jCalendar1.setBackground(Color.red);
        jCalendar1.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        jCalendar1.setDecorationBackgroundColor(Color.white);
        jCalendar1.addMouseListener(new CEnfermedadProf_jCalendar1_mouseAdapter(this));
        //jCalendar1.addMouseListener(new CHistoriaOcup_jCalendar1_mouseAdapter(this));
        jCalendar1.setBounds(new Rectangle(641, 16, 258, 84));
        jCalendar1.setVisible(false);//asta aqui
        JTBenfPer.addMouseListener(new CEnfermedadProf_JTBenfPer_mouseAdapter(this));
        JTBenfPer.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        this.getContentPane().add(JPAntecedentesFamiliar);
       //Adicionamos al JPAntecedentesFamiliar
       JPAntecedentesFamiliar.add(JBAtrasAF);
       JPAntecedentesFamiliar.add(JBCancelarAF);
       JPAntecedentesFamiliar.add(JBSgteAF); //JPAntecedentesFamiliar.add(JLBnhcAP);
       //JPAntecedentesFamiliar.add(JLBNumhcAP);
       JPAntecedentesFamiliar.add(JTBAntFam);
        JPAntecedentesFamiliar.add(JLBNumhcAF);
        JPAntecedentesFamiliar.add(JLBNombrPacEP);
        JTBAntFam.add(JPAntFam, "HISTORIA DE ENFERMEDAD PROFESIONAL");
        JPAntFam.add(JLBEmpresa);
        JPAntFam.add(JLBDiagHEP);
        JPAntFam.add(JTFDiagHEP);
        JPAntFam.add(JTFEmprHEP);
        JPAntFam.add(JLBPersna);
        JPAntFam.add(JLBFechHEP);
        JPAntFam.add(JSPHEP);
        JPAntFam.add(JTFPersHEP);
        JPAntFam.add(JFTFechHEP);
        JPAntFam.add(jCalendar1);
        JSPHEP.getViewport().add(JTBenfPer);}

/*
    public void inicioventanaAP(CEnfermedadProf frameAP) {
        objCAF=frameAP;
    }*/

    public void JBAtrasAF_actionPerformed(ActionEvent e) {
        CHistoriaOcup frameho;
        frameho=(CHistoriaOcup)framehoOBJ;
        frameho.setVisible(true);
        objCAF.setVisible(false);
    }

    public void JBSgteAF_actionPerformed(ActionEvent e) {
           validarbajos();
    }

    /**
     * validarnulosEP
     */
    public void validarnulosEP() {
        //swval=0;
        CIngreso frameingreso;
        CHistoriaOcup framehistocup;
        CEnfermedadProf frameep;
        frameingreso=(CIngreso)frameingresoOBJ;
        frameep=(CEnfermedadProf)frameepOBJ;
        frameep.setVisible(false);
        JDesktopPane JDPIngresoEP=new JDesktopPane();
        JDPIngresoEP=(JDesktopPane)JDPIngresoobjEP;
        framehistocup=(CHistoriaOcup)framehoOBJ;
        if(swgte==0){
           // System.out.println("BACTRIOLOGIA:");
            CHistoriaAcciTrab frameAT = new CHistoriaAcciTrab(obotactualizarEP,numingredicAT,swedicingrEP,nombrep,frameep,numhcep,JDPIngresoEP,frameingreso,framehistocup,objppalep);
            frameAT.setBounds(0, 2, 1010, 600);
            frameAT.setTitle("HISTORIA DE ACCIDENTES DE TRABAJO");
            JDPIngresoEP.add(frameAT, new Integer(1));
            frameAT.setLocation(5, 55);
            frameAT.show();
            frameAT.setVisible(true);
            frameAT.inicioventanaAP(frameAT);
            swgte=1;
            objetoaccidente=frameAT;
            if(swedicingrEP==1){
                String cadsqledicAT;;int ifila=0;
                Connection con2=Cconsql.getConnection();
                cadsqledicAT="SELECT ingreso.id_ingreso, accidentes_trabajo.empresa_accitrabajo, accidentes_trabajo.fecha_accitrabajo, accidentes_trabajo.causa_accitrabajo, accidentes_trabajo.tipolesion_accitrabajo, accidentes_trabajo.parteafectada_accitrabajo, accidentes_trabajo.incapacidad_accitrabajo, accidentes_trabajo.secuelas_accitrabajo FROM ingreso INNER JOIN accidentes_trabajo ON ingreso.id_ingreso = accidentes_trabajo.idingreso_accitrabajo WHERE ingreso.id_ingreso="+numingredicAT;
                try{
                    TSentenciaconsultaAT=con2.createStatement();
                    RconsultaAT=TSentenciaconsultaAT.executeQuery(cadsqledicAT);
                    while(RconsultaAT.next()){
                         if(RconsultaAT.getString(2).compareTo("")!=0){
                             frameAT.llenarmodeloAT(ifila,RconsultaAT.getString(2),RconsultaAT.getString(3),RconsultaAT.getString(4),RconsultaAT.getString(5),RconsultaAT.getString(6),RconsultaAT.getString(7),RconsultaAT.getString(8));
                             ifila=ifila+1;
                         }
                   }
                }
                     catch(SQLException e1){
                           e1.getMessage();
                           cad1="NO SE PUDO EJECUTAR LA CONSULTA";
                           cad2="PROBLEMAS CON LOS DATOS DE ACCIDENTES DE TRABAJO EN EDICION";
                           validEP.mensajeconfirmacion(cad1,cad2);
                     }//cierra el catch
                    Cconsql.CerrarConexion();

            }//fin del swedicingrEP
        }//fin del if swgte
        else{
            CHistoriaAcciTrab frameAT;
            frameAT=(CHistoriaAcciTrab)objetoaccidente;
           // ObjectCingreso.setVisible(false);
            frameAT.setVisible(true);

        }
    }

    /**
     * inicializarventanaEP
     */
    public void inicializarventanaEP(CEnfermedadProf frameEP) {
        frameepOBJ=frameEP;
    }

    /**
     * anadirentradaEP
     */
    public void anadirentradaEP() {
        CBaseHEP dato = new CBaseHEP ("","","","");
        modeloep.anhadeentrada(dato);
    }

    public void JTFPersHEP_keyReleased(KeyEvent e) {
      int c = e.getKeyCode();
      if (c == KeyEvent.VK_ENTER) {
          llenarmodeloEP(ifila,JTFEmprHEP.getText(), validEP.cambiarformatofecha(JFTFechHEP.getText()),JTFDiagHEP.getText(),JTFPersHEP.getText());
          ifila=ifila+1;
      } //if c
      else{
           procactualizarmodEP(e);
      }//fin del else

    }

    /**
     * procactualizarmodEP
     */
    public void procactualizarmodEP(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_F3) {
           actualizarmodeloEP(JTFEmprHEP.getText(),JFTFechHEP.getText(),JTFDiagHEP.getText(),JTFPersHEP.getText());
           //ifila=ifila+1;
       } //if c

    }

    /**
     * llenarmodeloEP
     */
    public void llenarmodeloEP(int ifila,String nombremprEP,String fechaemprEP,String diagEP,String profEP) {
          modeloep.setValueAt(nombremprEP,ifila,0);
          modeloep.setValueAt(fechaemprEP,ifila,1);
          modeloep.setValueAt(diagEP,ifila,2);
          modeloep.setValueAt(profEP,ifila,3);
          anadirentradaEP();
          limpiardatosEP();

    }

    /**
     * limpiardatosEP
     */
    public void limpiardatosEP() {
        JTFEmprHEP.setText("");
        JFTFechHEP.setText("");
        JTFDiagHEP.setText("");
        //configurarformatofechaHO();
        JTFPersHEP.setText("");
        JTFEmprHEP.requestFocus();
    }

    /**
     * actualizarmodeloEP
     */
    public void actualizarmodeloEP(String nombremprEP,String fechaemprEP,String diagEP,String profEP) {
          modeloep.setValueAt(nombremprEP,JTBenfPer.getSelectedRow(),0);
          modeloep.setValueAt(fechaemprEP,JTBenfPer.getSelectedRow(),1);
          modeloep.setValueAt(diagEP,JTBenfPer.getSelectedRow(),2);
          modeloep.setValueAt(profEP,JTBenfPer.getSelectedRow(),3);
          limpiardatosEP();
    }

    public void JFTFechHEP_focusGained(FocusEvent e) {
          jCalendar1.setVisible(true);
          JFTFechHEP.setVisible(false);
          JLBFechHEP.setVisible(false);
          JLBPersna.setVisible(false);
          JTFPersHEP.setVisible(false);
    }

    public void jCalendar1_mouseReleased(MouseEvent e) {
        String patron="dd/MM/yyyy";
        SimpleDateFormat formato2=new SimpleDateFormat(patron);
        fechainiEP=jCalendar1.getDate();
        sFechaEP=formato2.format(fechainiEP);
        JFTFechHEP.setText(sFechaEP);
        jCalendar1.setVisible(false);
        JFTFechHEP.setVisible(true);
        JLBFechHEP.setVisible(true);
        JLBPersna.setVisible(true);
        JTFPersHEP.setVisible(true);

    }

    public void JTBenfPer_mouseReleased(MouseEvent e) {
      Object vartabHO;String SvartabHO="";
      vartabHO=modeloep.getValueAt(JTBenfPer.getSelectedRow(),0);
      JTFEmprHEP.setText(SvartabHO.valueOf(vartabHO));
      vartabHO=modeloep.getValueAt(JTBenfPer.getSelectedRow(),1);
      SvartabHO=SvartabHO.valueOf(vartabHO);
      //SvartabHO=validHO.cambiarformatofechaotro(SvartabHO);
      JFTFechHEP.setText(SvartabHO);
      vartabHO=modeloep.getValueAt(JTBenfPer.getSelectedRow(),2);
      //SvartabHO=validHO.cambiarformatofechaotro(SvartabHO);
      SvartabHO=SvartabHO.valueOf(vartabHO);
      //System.out.println("yaneth:"+SvartabHO);
      JTFDiagHEP.setText(SvartabHO);
      vartabHO=modeloep.getValueAt(JTBenfPer.getSelectedRow(),3);
      JTFPersHEP.setText(SvartabHO.valueOf(vartabHO));
    }

    public void JTFEmprHEP_keyReleased(KeyEvent e) {
         procactualizarmodEP(e);
    }

    public void JTFDiagHEP_keyReleased(KeyEvent e) {
        procactualizarmodEP(e);
    }

    public void JFTFechHEP_keyReleased(KeyEvent e) {
       procactualizarmodEP(e);
    }

    /**
     * validarbajos
     */
    public void validarbajos() {
        if(JTFEmprHEP.getText().compareTo("")!=0 && JFTFechHEP.getText().compareTo("")!=0 && JTFDiagHEP.getText().compareTo("")!=0 && JTFDiagHEP.getText().compareTo("")!=0){
                cad1="FAVOR PULSAR ENTER DESPUES DE LA PERSONA QUE REALIZO EL Rx";
                cad2="EL ITEM NO HA BAJADO";
                validEP.mensajeconfirmacion(cad1,cad2);
        }
        else
          validarnulosEP();

    }

    public CEnfermedadProf() {
    }

    //


}//FIN CLASE


class CEnfermedadProf_JTFDiagHEP_keyAdapter extends KeyAdapter {
    private CEnfermedadProf adaptee;
    CEnfermedadProf_JTFDiagHEP_keyAdapter(CEnfermedadProf adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFDiagHEP_keyReleased(e);
    }
}


class CEnfermedadProf_JTBenfPer_mouseAdapter extends MouseAdapter {
    private CEnfermedadProf adaptee;
    CEnfermedadProf_JTBenfPer_mouseAdapter(CEnfermedadProf adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.JTBenfPer_mouseReleased(e);
    }
}


class CEnfermedadProf_JTFEmprHEP_keyAdapter extends KeyAdapter {
    private CEnfermedadProf adaptee;
    CEnfermedadProf_JTFEmprHEP_keyAdapter(CEnfermedadProf adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFEmprHEP_keyReleased(e);
    }
}


class CEnfermedadProf_jCalendar1_mouseAdapter extends MouseAdapter {
    private CEnfermedadProf adaptee;
    CEnfermedadProf_jCalendar1_mouseAdapter(CEnfermedadProf adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.jCalendar1_mouseReleased(e);
    }
}


class CEnfermedadProf_JFTFechHEP_focusAdapter extends FocusAdapter {
    private CEnfermedadProf adaptee;
    CEnfermedadProf_JFTFechHEP_focusAdapter(CEnfermedadProf adaptee) {
        this.adaptee = adaptee;
    }

    public void focusGained(FocusEvent e) {
        adaptee.JFTFechHEP_focusGained(e);
    }
}


class CEnfermedadProf_JFTFechHEP_keyAdapter extends KeyAdapter {
    private CEnfermedadProf adaptee;
    CEnfermedadProf_JFTFechHEP_keyAdapter(CEnfermedadProf adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JFTFechHEP_keyReleased(e);
    }
}


class CEnfermedadProf_JTFPersHEP_keyAdapter extends KeyAdapter {
    private CEnfermedadProf adaptee;
    CEnfermedadProf_JTFPersHEP_keyAdapter(CEnfermedadProf adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFPersHEP_keyReleased(e);
    }
}


class CEnfermedadProf_JBSgteAF_actionAdapter implements ActionListener {
    private CEnfermedadProf adaptee;
    CEnfermedadProf_JBSgteAF_actionAdapter(CEnfermedadProf adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSgteAF_actionPerformed(e);
    }
}


class CEnfermedadProf_JBAtrasAF_actionAdapter implements ActionListener {
    private CEnfermedadProf adaptee;
    CEnfermedadProf_JBAtrasAF_actionAdapter(CEnfermedadProf adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasAF_actionPerformed(e);
    }
}

