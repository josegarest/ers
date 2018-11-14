package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.Date;

import javax.swing.*;

import com.toedter.calendar.*;

public class CHistoriaAcciTrab extends JInternalFrame {
    Object objppalat;
    Object obotactualizarAT;
    public Statement TSentenciaconsultaAF;
    public ResultSet RconsultaAF;
    public ConexionSql Cconsql= new ConexionSql();
    int swedicingrAF;
    String numingredicAF;
    String cad1;
    String cad2;
    Object  objetoantcenfam= new Object();
    int swgte;
    String sFechaAT;
    Date fechainiAT=new Date();
    JCalendar jCalendar1 = new JCalendar();
    ValidarComponentes validAT=new ValidarComponentes();
    int ifila=0;
    ModeloHistAccTrab modeloat=new ModeloHistAccTrab();
    String nombrat= new String();
    String numhcat= new String();
    Object JDPIngresoobjAF=new Object();
    int swval;
    Object frameATOBJ= new Object();
    Object frameepOBJ= new Object();
    Object framehoOBJ= new Object();
    Object frameEnfProfOBJ=new Object();
    //ModeloHO modeloho=new ModeloHO();
    public String nombredetalle="";
    public static int swepilepc=1;
    CHistoriaAcciTrab objCAF;
    //DECLARACION DE PANELES
    JTabbedPane JTBAntFam = new JTabbedPane();
    JPanel JPAntecedentesFamiliar = new JPanel();
    JPanel JPAntFam = new JPanel();
    //DECLARACION DE OBJETOS VISUALES
    JButton JBAtrasAF = new JButton();
    JButton JBCancelarAF = new JButton();
    JButton JBSgteAF = new JButton();
    JLabel JLBNumhcAT = new JLabel();
    JCheckBox jCheckBox1 = new JCheckBox();
    JLabel JLBEmprHAT = new JLabel();
    JTextField JTFAccTrab = new JTextField();
    JLabel JLBFechHAT = new JLabel();
    JFormattedTextField JFTFechHAT = new JFormattedTextField();
    JLabel JLBCausa = new JLabel();
    JTextField JTFCausaHAT = new JTextField();
    JLabel JLBTipLesion = new JLabel();
    JTextField JTFTipLesion = new JTextField();
    JLabel JLBParteAfect = new JLabel();
    JTextField JTFPartAfectHAT = new JTextField();
    JLabel JLBIncapac = new JLabel();
    JTextField JTFIncap = new JTextField();
    JLabel JLBSecuelasHAT = new JLabel();
    JTextField JTFSecuelasHAT = new JTextField();
    JScrollPane JSPHaccTra = new JScrollPane();
    JTable JTBHAccTra = new JTable(modeloat);
    JLabel JLBNombrPacAT = new JLabel();
    //
    public CHistoriaAcciTrab(Object obotactualizarEP,String numingredicAT,int swedicingrEP,String Nombrepacep,CEnfermedadProf frameat,String varnHC,JDesktopPane JDPIngreso,CIngreso frameingreso,CHistoriaOcup framehistocup,Object objppalep) {
       frameATOBJ= frameingreso;
       frameepOBJ=frameat;
       framehoOBJ=framehistocup;
       //frameEnfProfOBJ=frameenfermedadprof;
       swgte=0;
       try {
            jbInit();
            JLBNombrPacAT.setText(Nombrepacep);
            JLBNumhcAT.setText(varnHC);
            JDPIngresoobjAF=JDPIngreso;
            nombrat=Nombrepacep;
            numhcat=varnHC;
            anadirentradaAT();
            swedicingrAF=swedicingrEP;
            numingredicAF=numingredicAT;
            obotactualizarAT=obotactualizarEP;
            objppalat=objppalep;
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
       JPAntecedentesFamiliar.setBounds(new Rectangle( -16, 3, 991, 557));
       JPAntecedentesFamiliar.setLayout(null);
       JPAntFam.setBackground(new Color(146, 154, 255));
       JPAntFam.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
       JPAntFam.setLayout(null);

       //CARACTERISTICAS DE LOS COMPONENTES VISUALES
       JBAtrasAF.setBounds(new Rectangle(139, 509, 112, 36));
       JBAtrasAF.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
       JBAtrasAF.setMnemonic('R');
       JBAtrasAF.setText("Atras");
        JBAtrasAF.addActionListener(new
                                    CHistoriaAcciTrab_JBAtrasAF_actionAdapter(this));
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
        JBSgteAF.addActionListener(new CHistoriaAcciTrab_JBSgteAF_actionAdapter(this));
        //JBSgteAF.addActionListener(ne              CAntecedentesPersonales_JBSgteAP_actionAdapter(this));
       JBSgteAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN4.GIF")));
       JBSgteAF.setSelectedIcon(null);
        JLBNumhcAT.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNumhcAT.setForeground(Color.red);
        JLBNumhcAT.setToolTipText("");
        JLBNumhcAT.setText("");
        JLBNumhcAT.setBounds(new Rectangle(528, 18, 158, 24));
        jCheckBox1.setText("jCheckBox1");
        jCheckBox1.setBounds(new Rectangle(537, 134, 84, 23));
        JLBEmprHAT.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBEmprHAT.setForeground(Color.red);
        JLBEmprHAT.setToolTipText("");
        JLBEmprHAT.setText("EMPRESA");
        JLBEmprHAT.setBounds(new Rectangle(10, 9, 59, 20));
        JTFAccTrab.setBackground(Color.white);
        JTFAccTrab.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFAccTrab.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFAccTrab.setToolTipText("");
        JTFAccTrab.setText("");
        JTFAccTrab.setBounds(new Rectangle(95, 9, 372, 22));
        JTFAccTrab.addKeyListener(new CHistoriaAcciTrab_JTFAccTrab_keyAdapter(this));
        JLBFechHAT.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBFechHAT.setForeground(Color.red);
        JLBFechHAT.setToolTipText("");
        JLBFechHAT.setText("FECHA ");
        JLBFechHAT.setBounds(new Rectangle(641, 11, 52, 20));
        JFTFechHAT.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTFechHAT.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTFechHAT.setToolTipText("");
        JFTFechHAT.setBounds(new Rectangle(751, 15, 126, 21));
        JFTFechHAT.addKeyListener(new CHistoriaAcciTrab_JFTFechHAT_keyAdapter(this));
        JFTFechHAT.addFocusListener(new
                                    CHistoriaAcciTrab_JFTFechHAT_focusAdapter(this));
        JLBCausa.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBCausa.setForeground(Color.red);
        JLBCausa.setToolTipText("");
        JLBCausa.setText("CAUSA");
        JLBCausa.setBounds(new Rectangle(11, 49, 54, 20));
        JTFCausaHAT.setBackground(Color.white);
        JTFCausaHAT.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFCausaHAT.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFCausaHAT.setToolTipText("");
        JTFCausaHAT.setBounds(new Rectangle(95, 48, 202, 22));
        JTFCausaHAT.addKeyListener(new CHistoriaAcciTrab_JTFCausaHAT_keyAdapter(this));
        JLBTipLesion.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBTipLesion.setForeground(Color.red);
        JLBTipLesion.setToolTipText("");
        JLBTipLesion.setText("TIPO DE LESION");
        JLBTipLesion.setBounds(new Rectangle(321, 50, 95, 20));
        JTFTipLesion.setBackground(Color.white);
        JTFTipLesion.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFTipLesion.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFTipLesion.setToolTipText("");
        JTFTipLesion.setText("");
        JTFTipLesion.setBounds(new Rectangle(420, 46, 202, 22));
        JTFTipLesion.addKeyListener(new
                                    CHistoriaAcciTrab_JTFTipLesion_keyAdapter(this));
        JLBParteAfect.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBParteAfect.setForeground(Color.red);
        JLBParteAfect.setToolTipText("");
        JLBParteAfect.setText("PARTE AFECTADA");
        JLBParteAfect.setBounds(new Rectangle(638, 51, 105, 20));
        JTFPartAfectHAT.setBackground(Color.white);
        JTFPartAfectHAT.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFPartAfectHAT.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFPartAfectHAT.setToolTipText("");
        JTFPartAfectHAT.setBounds(new Rectangle(751, 50, 202, 22));
        JTFPartAfectHAT.addKeyListener(new
                CHistoriaAcciTrab_JTFPartAfectHAT_keyAdapter(this));
        JLBIncapac.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBIncapac.setForeground(Color.red);
        JLBIncapac.setToolTipText("");
        JLBIncapac.setText("INCAPACIDAD");
        JLBIncapac.setBounds(new Rectangle(11, 88, 88, 20));
        JTFIncap.setBackground(Color.white);
        JTFIncap.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFIncap.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFIncap.setToolTipText("");
        JTFIncap.setText("");
        JTFIncap.setBounds(new Rectangle(96, 88, 202, 22));
        JTFIncap.addKeyListener(new CHistoriaAcciTrab_JTFIncap_keyAdapter(this));
        JLBSecuelasHAT.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 10));
        JLBSecuelasHAT.setForeground(Color.red);
        JLBSecuelasHAT.setToolTipText("");
        JLBSecuelasHAT.setText("SECUELAS");
        JLBSecuelasHAT.setBounds(new Rectangle(322, 89, 78, 20));
        JTFSecuelasHAT.setBackground(Color.white);
        JTFSecuelasHAT.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFSecuelasHAT.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFSecuelasHAT.setToolTipText("");
        JTFSecuelasHAT.setBounds(new Rectangle(420, 90, 202, 22));
        JTFSecuelasHAT.addKeyListener(new
                CHistoriaAcciTrab_JTFSecuelasHAT_keyAdapter(this));
        JSPHaccTra.getViewport().setBackground(Color.white);
        JSPHaccTra.setBorder(BorderFactory.createRaisedBevelBorder());
        JSPHaccTra.setBounds(new Rectangle(12, 133, 951, 261));
        JLBNombrPacAT.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNombrPacAT.setForeground(Color.red);
        JLBNombrPacAT.setToolTipText("");
        JLBNombrPacAT.setText("");
        JLBNombrPacAT.setBounds(new Rectangle(19, 16, 478, 24));
        jCalendar1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jCalendar1.setBackground(Color.red);
        jCalendar1.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        jCalendar1.setDecorationBackgroundColor(Color.white);
        jCalendar1.addMouseListener(new
                                    CHistoriaAcciTrab_jCalendar1_mouseAdapter(this));
        // jCalendar1.addMouseListener(new CEnfermedadProf_jCalendar1_mouseAdapter(this));
        //jCalendar1.addMouseListener(new CHistoriaOcup_jCalendar1_mouseAdapter(this));
        jCalendar1.setBounds(new Rectangle(641, 16, 258, 84));
        jCalendar1.setVisible(false);//asta aqui
        JTBHAccTra.addMouseListener(new
                                    CHistoriaAcciTrab_JTBHAccTra_mouseAdapter(this));
        JTBHAccTra.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JPAntecedentesFamiliar.add(JBAtrasAF);
        JPAntecedentesFamiliar.add(JBCancelarAF);
        JPAntecedentesFamiliar.add(JBSgteAF); //JPAntecedentesFamiliar.add(JLBnhcAP);
       //JPAntecedentesFamiliar.add(JLBNumhcAP);
        JPAntecedentesFamiliar.add(JTBAntFam);
        JPAntecedentesFamiliar.add(JLBNumhcAT);
        JPAntecedentesFamiliar.add(JLBNombrPacAT);
        JTBAntFam.add(JPAntFam, "HISTORIA DE ACCIDENTES DE TRABAJO");
        JPAntFam.add(JLBEmprHAT);
        JPAntFam.add(JLBCausa);
        JPAntFam.add(JLBIncapac);
        JPAntFam.add(JTFIncap);
        JPAntFam.add(JTFAccTrab);
        JPAntFam.add(JTFCausaHAT);
        JPAntFam.add(JLBTipLesion);
        JPAntFam.add(JTFPartAfectHAT);
        JPAntFam.add(JLBParteAfect);
        JPAntFam.add(JFTFechHAT);
        JPAntFam.add(JLBSecuelasHAT);
        JPAntFam.add(JLBFechHAT);
        JPAntFam.add(JTFSecuelasHAT);
        JPAntFam.add(JTFTipLesion);
        JPAntFam.add(JSPHaccTra);
        JPAntFam.add(jCalendar1);
        JSPHaccTra.getViewport().add(JTBHAccTra);
        this.getContentPane().add(JPAntecedentesFamiliar);
    }


    public void inicioventanaAP(CHistoriaAcciTrab frameAT) {
        objCAF=frameAT;
    }

    public void JBAtrasAF_actionPerformed(ActionEvent e) {
           CEnfermedadProf frameEPAtras;
           frameEPAtras=(CEnfermedadProf)frameepOBJ;
           frameEPAtras.setVisible(true);
           objCAF.setVisible(false);
    }

    public void JBSgteAF_actionPerformed(ActionEvent e) {
           validarblancos();
          // validarnulosAF();
    }

    /**
     * validarnulosAF
     */
    public void validarnulosAF() {
        swval=0;
        CIngreso frameingreso;
        CHistoriaAcciTrab frameaf;
        CHistoriaOcup framehistocup;
        CEnfermedadProf frameenfermedadprof;
        frameingreso=(CIngreso)frameATOBJ;
        frameaf=(CHistoriaAcciTrab)objCAF;
        frameaf.setVisible(false);
        JDesktopPane JDPIngresoEP=new JDesktopPane();
        JDPIngresoEP=(JDesktopPane)JDPIngresoobjAF;
        framehistocup=(CHistoriaOcup)framehoOBJ;
        frameenfermedadprof=(CEnfermedadProf)frameepOBJ;
        if(swgte==0){
            CAntecedentesFamiliar frameAF = new CAntecedentesFamiliar(obotactualizarAT,numingredicAF,swedicingrAF,nombrat,frameaf,numhcat,JDPIngresoEP,frameingreso,framehistocup,frameenfermedadprof,objppalat);
            frameAF.setBounds(0, 2, 1010, 600);
            frameAF.setTitle("ANTECEDENTES FAMILIARES");
            JDPIngresoEP.add(frameAF, new Integer(1));
            frameAF.setLocation(5, 55);
            frameAF.show();
            frameAF.setVisible(true);
            frameAF.inicioventanaAP(frameAF);
            swgte=1;
            objetoantcenfam=frameAF;
            if(swedicingrAF==1){
                String cadsqledicAF;;//int ifila=0;
                Connection con2=Cconsql.getConnection();
                cadsqledicAF="SELECT ingreso.id_ingreso, antecedentes_familiar.hipertension_familiar, antecedentes_familiar.texthipertension_familiar, antecedentes_familiar.diabetes_familiar, antecedentes_familiar.textdiabetes_familiar, antecedentes_familiar.cancer_familiar, antecedentes_familiar.textcancer_familiar, antecedentes_familiar.cardio_familiar, antecedentes_familiar.textcardio_familiar, antecedentes_familiar.epilepsia_familiar,antecedentes_familiar.textepilepsia_familiar, antecedentes_familiar.otros_familiar, antecedentes_familiar.textotros_familiar FROM ingreso INNER JOIN antecedentes_familiar ON ingreso.id_ingreso = antecedentes_familiar.idingreso_familiar WHERE ingreso.id_ingreso="+numingredicAF;
                try{
                    TSentenciaconsultaAF=con2.createStatement();
                    RconsultaAF=TSentenciaconsultaAF.executeQuery(cadsqledicAF);
                    while(RconsultaAF.next()){
                         frameAF.JCHHta.setSelected(RconsultaAF.getBoolean(2));
                         frameAF.JTFHta.setText(RconsultaAF.getString(3));
                         frameAF.JCHDiabet.setSelected(RconsultaAF.getBoolean(4));
                         frameAF.JTFDiab.setText(RconsultaAF.getString(5));
                         frameAF.JCHCancer.setSelected(RconsultaAF.getBoolean(6));
                         frameAF.JTFCancer.setText(RconsultaAF.getString(7));
                         frameAF.JCHCardiopatias.setSelected(RconsultaAF.getBoolean(8));
                         frameAF.JTFCardiopatias.setText(RconsultaAF.getString(9));
                         frameAF.JCHEpilepsia.setSelected(RconsultaAF.getBoolean(10));
                         frameAF.JTFEpilepsia.setText(RconsultaAF.getString(11));
                         frameAF.JCHOtros.setSelected(RconsultaAF.getBoolean(12));
                         frameAF.JTFOtros.setText(RconsultaAF.getString(13));
                         activarbotonAF(frameAF.JBHta);
                         activarbotonAF(frameAF.JBEpilepsia);
                         activarbotonAF(frameAF.JBCardiopatias);
                         activarbotonAF(frameAF.JBOtros);
                         activarbotonAF(frameAF.JBCancer);
                         activarbotonAF(frameAF.JBOtros);
                     }
                }
                     catch(SQLException e1){
                           e1.getMessage();
                           cad1="NO SE PUDO EJECUTAR LA CONSULTA";
                           cad2="PROBLEMAS CON LOS DATOS DE ANTECEDENTES FAMILIARES EN EDICION";
                           validAT.mensajeconfirmacion(cad1,cad2);
                     }//cierra el catch


            }

        }
        else{
            CAntecedentesFamiliar frameAF ;
            frameAF=(CAntecedentesFamiliar)objetoantcenfam;
           // ObjectCingreso.setVisible(false);
            frameAF.setVisible(true);

        }


    }

    /**
     * anadirentradaAT
     */
    public void anadirentradaAT() {
        CBaseHistAT dato = new CBaseHistAT ("","","","","","","");
        modeloat.anhadeentrada(dato);
    }

    public void JTFSecuelasHAT_keyReleased(KeyEvent e) {
        int c = e.getKeyCode();
      if (c == KeyEvent.VK_ENTER) {
          llenarmodeloAT(ifila,JTFAccTrab.getText(), validAT.cambiarformatofecha(JFTFechHAT.getText()),JTFCausaHAT.getText(),JTFTipLesion.getText(),JTFPartAfectHAT.getText(),JTFIncap.getText(),JTFSecuelasHAT.getText());
          ifila=ifila+1;
      } //if c
      else{
           procactualizarmodAT(e);
      }//fin del else

    }

    /**
     * procactualizarmodAT
     */
    public void procactualizarmodAT(KeyEvent e) {
        int c = e.getKeyCode();
       if (c == KeyEvent.VK_F3) {
          actualizarmodeloAT(JTFAccTrab.getText(),JFTFechHAT.getText(),JTFCausaHAT.getText(),JTFTipLesion.getText(),JTFPartAfectHAT.getText(),JTFIncap.getText(),JTFSecuelasHAT.getText());
          //ifila=ifila+1;
      } //if c

    }

    /**
     * llenarmodeloAT
     */
    public void llenarmodeloAT(int ifila2,String nombremprAT,String fechaemprAT,String causaAT,String tiplesionAT,String parteafectadaAT,String incapacidadAT,String secuelaAT) {
        modeloat.setValueAt(nombremprAT,ifila2,0);
        modeloat.setValueAt(fechaemprAT,ifila2,1);
        modeloat.setValueAt(causaAT,ifila2,2);
        modeloat.setValueAt(tiplesionAT,ifila2,3);
        modeloat.setValueAt(parteafectadaAT,ifila2,4);
        modeloat.setValueAt(incapacidadAT,ifila2,5);
        modeloat.setValueAt(secuelaAT,ifila2,6);
        anadirentradaAT();
        limpiardatosAT();
    }

    /**
     * limpiardatosAT
     */
    public void limpiardatosAT() {
        JTFAccTrab.setText("");
        JFTFechHAT.setText("");
        JTFCausaHAT.setText("");
        //configurarformatofechaHO();
        JTFTipLesion.setText("");
        JTFPartAfectHAT.setText("");
        JFTFechHAT.setText("");
        JTFIncap.setText("");
        //configurarformatofechaHO();
        JTFSecuelasHAT.setText("");
        JTFAccTrab.requestFocus();
    }

    public void JFTFechHAT_focusGained(FocusEvent e) {
         jCalendar1.setVisible(true);
         JFTFechHAT.setVisible(false);
         JLBFechHAT.setVisible(false);
         JLBParteAfect.setVisible(false);
         JTFPartAfectHAT.setVisible(false);

    }

    public void jCalendar1_mouseReleased(MouseEvent e) {
        String patron="dd/MM/yyyy";
        SimpleDateFormat formato2=new SimpleDateFormat(patron);
        fechainiAT=jCalendar1.getDate();
        sFechaAT=formato2.format(fechainiAT);
        JFTFechHAT.setText(sFechaAT);
        jCalendar1.setVisible(false);
        JFTFechHAT.setVisible(true);
        JLBFechHAT.setVisible(true);
        JLBParteAfect.setVisible(true);
        JTFPartAfectHAT.setVisible(true);
    }

    /**
     * actualizarmodeloAT
     */
    public void actualizarmodeloAT(String nombremprAT,String fechaemprAT,String causaAT,String tiplesionAT,String parteafectadaAT,String incapacidadAT,String secuelaAT) {
        modeloat.setValueAt(nombremprAT,JTBHAccTra.getSelectedRow(),0);
        modeloat.setValueAt(fechaemprAT,JTBHAccTra.getSelectedRow(),1);
        modeloat.setValueAt(causaAT,JTBHAccTra.getSelectedRow(),2);
        modeloat.setValueAt(tiplesionAT,JTBHAccTra.getSelectedRow(),3);
        modeloat.setValueAt(parteafectadaAT,JTBHAccTra.getSelectedRow(),4);
        modeloat.setValueAt(incapacidadAT,JTBHAccTra.getSelectedRow(),5);
        modeloat.setValueAt(secuelaAT,JTBHAccTra.getSelectedRow(),6);
        limpiardatosAT();
    }

    public void JTFAccTrab_keyReleased(KeyEvent e) {
        procactualizarmodAT(e);
    }

    public void JFTFechHAT_keyReleased(KeyEvent e) {
        procactualizarmodAT(e);
    }

    public void JTFPartAfectHAT_keyReleased(KeyEvent e) {
      procactualizarmodAT(e);
    }

    public void JTFTipLesion_keyReleased(KeyEvent e) {
     procactualizarmodAT(e);
    }

    public void JTFCausaHAT_keyReleased(KeyEvent e) {
     procactualizarmodAT(e);
    }

    public void JTFIncap_keyReleased(KeyEvent e) {
      procactualizarmodAT(e);
    }

    public void JTBHAccTra_mouseReleased(MouseEvent e) {
         Object vartabHO;String SvartabHO="";
         vartabHO=modeloat.getValueAt(JTBHAccTra.getSelectedRow(),0);
         JTFAccTrab.setText(SvartabHO.valueOf(vartabHO));
         vartabHO=modeloat.getValueAt(JTBHAccTra.getSelectedRow(),1);
         SvartabHO=SvartabHO.valueOf(vartabHO);
         //SvartabHO=validHO.cambiarformatofechaotro(SvartabHO);
         JFTFechHAT.setText(SvartabHO);
         vartabHO=modeloat.getValueAt(JTBHAccTra.getSelectedRow(),2);
         //SvartabHO=validHO.cambiarformatofechaotro(SvartabHO);
         SvartabHO=SvartabHO.valueOf(vartabHO);
         JTFCausaHAT.setText(SvartabHO);
         vartabHO=modeloat.getValueAt(JTBHAccTra.getSelectedRow(),3);
         JTFTipLesion.setText(SvartabHO.valueOf(vartabHO));
         vartabHO=modeloat.getValueAt(JTBHAccTra.getSelectedRow(),4);
         JTFPartAfectHAT.setText(SvartabHO.valueOf(vartabHO));
         vartabHO=modeloat.getValueAt(JTBHAccTra.getSelectedRow(),5);
         JTFIncap.setText(SvartabHO.valueOf(vartabHO));
         vartabHO=modeloat.getValueAt(JTBHAccTra.getSelectedRow(),6);
         JTFSecuelasHAT.setText(SvartabHO.valueOf(vartabHO));

    }

    /**
     * validarblancos
     */
    public void validarblancos() {
        if(JTFAccTrab.getText().compareTo("")!=0 && JFTFechHAT.getText().compareTo("")!=0 && JTFCausaHAT.getText().compareTo("")!=0 && JTFTipLesion.getText().compareTo("")!=0 && JTFPartAfectHAT.getText().compareTo("")!=0 && JTFIncap.getText().compareTo("")!=0 && JTFSecuelasHAT.getText().compareTo("")!=0){
                cad1="FAVOR PULSAR ENTER DESPUES DE LAS SECUELAS";
                cad2="EL ITEM NO HA BAJADO";
                validAT.mensajeconfirmacion(cad1,cad2);
        }
        else
          validarnulosAF();

    }

    /**
     * activarbotonAF
     */
    public void activarbotonAF(JButton JVvar) {
        JVvar.setEnabled(true);
    }

    public CHistoriaAcciTrab() {
    }

    //


}//FIN CLASE


class CHistoriaAcciTrab_JTBHAccTra_mouseAdapter extends MouseAdapter {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_JTBHAccTra_mouseAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.JTBHAccTra_mouseReleased(e);
    }
}


class CHistoriaAcciTrab_JTFIncap_keyAdapter extends KeyAdapter {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_JTFIncap_keyAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFIncap_keyReleased(e);
    }
}


class CHistoriaAcciTrab_JTFCausaHAT_keyAdapter extends KeyAdapter {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_JTFCausaHAT_keyAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFCausaHAT_keyReleased(e);
    }
}


class CHistoriaAcciTrab_JTFTipLesion_keyAdapter extends KeyAdapter {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_JTFTipLesion_keyAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFTipLesion_keyReleased(e);
    }
}


class CHistoriaAcciTrab_JFTFechHAT_keyAdapter extends KeyAdapter {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_JFTFechHAT_keyAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JFTFechHAT_keyReleased(e);
    }
}


class CHistoriaAcciTrab_JTFAccTrab_keyAdapter extends KeyAdapter {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_JTFAccTrab_keyAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFAccTrab_keyReleased(e);
    }
}


class CHistoriaAcciTrab_jCalendar1_mouseAdapter extends MouseAdapter {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_jCalendar1_mouseAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.jCalendar1_mouseReleased(e);
    }
}


class CHistoriaAcciTrab_JFTFechHAT_focusAdapter extends FocusAdapter {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_JFTFechHAT_focusAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void focusGained(FocusEvent e) {
        adaptee.JFTFechHAT_focusGained(e);
    }
}


class CHistoriaAcciTrab_JTFPartAfectHAT_keyAdapter extends KeyAdapter {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_JTFPartAfectHAT_keyAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFPartAfectHAT_keyReleased(e);
    }
}


class CHistoriaAcciTrab_JTFSecuelasHAT_keyAdapter extends KeyAdapter {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_JTFSecuelasHAT_keyAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JTFSecuelasHAT_keyReleased(e);
    }
}


class CHistoriaAcciTrab_JBSgteAF_actionAdapter implements ActionListener {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_JBSgteAF_actionAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSgteAF_actionPerformed(e);
    }
}


class CHistoriaAcciTrab_JBAtrasAF_actionAdapter implements ActionListener {
    private CHistoriaAcciTrab adaptee;
    CHistoriaAcciTrab_JBAtrasAF_actionAdapter(CHistoriaAcciTrab adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasAF_actionPerformed(e);
    }
}

