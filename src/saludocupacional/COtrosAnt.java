package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.Font;

public class COtrosAnt extends JInternalFrame {
    Object objppaloa;
    Object obotactualizarOA;
    ValidarComponentes validRS=new ValidarComponentes();
    public Statement TSentenciaconsultaRS;
    public ResultSet RconsultaRS;
    public ConexionSql Cconsql= new ConexionSql();
    String cad1;
    String cad2;
    String numingredicRS;
    int swedicingrRS;
    Object  objetorevisionsistmas= new Object();
    int swgte;
    int swval;
    Object frameOAOBJ= new Object();
    Object framehoOBJ= new Object();
    Object frameEnfProfOBJ=new Object();
    Object frameAcciTrabajoOBJ=new Object();
    Object frameAntecFamOBJ=new Object();
    Object frameAntecPersonalOBJ=new Object();
    Object frameGinecologiaOBJ=new Object();
    Object JDPIngresoobjOA=new Object();
    Object frameinOBJ= new Object();
    String nombroa= new String();
    String numhcoa= new String();
    public String nombredetalle="";
    public static int swepilepc=1;
    COtrosAnt objCOA;
    //DECLARACION DE PANELES
    JTabbedPane JTBAntFam = new JTabbedPane();
    JPanel JPAntecedentesFamiliar = new JPanel();
    JPanel JPAntFam = new JPanel();
    //DECLARACION DE OBJETOS VISUALES
    JButton JBAtrasAF = new JButton();
    JButton JBCancelarAF = new JButton();
    JButton JBSgteAF = new JButton();
    JLabel JLBNumhcOA = new JLabel();
    JCheckBox JCHTabaco = new JCheckBox();
    JTextField JTFTabaquismo = new JTextField();
    JCheckBox JCHLicor = new JCheckBox();
    JCheckBox JCHPractDep = new JCheckBox();
    JCheckBox JCHOtros = new JCheckBox();
    JLabel JLBFrecuencia = new JLabel();
    JLabel JLBHabito = new JLabel();
    JLabel JLBAnos = new JLabel();
    JTextField JTFAnos = new JTextField();
    JTextField JTFIngestaLicor = new JTextField();
    JTextField JTFAnosLicor = new JTextField();
    JTextField JTFPractDeport = new JTextField();
    JTextField JTFAnosPD = new JTextField();
    JTextField JTFOtr = new JTextField();
    JTextField JTFOtrosAnos = new JTextField();
    JLabel JLBNombrOA = new JLabel();
    JCheckBox JCHSust = new JCheckBox();
    JTextField JTFFrecAditc = new JTextField();
    JTextField JTFAnAdicc = new JTextField();
    //
    public COtrosAnt(Object obotactualizarIZ,String numingredicOA,int swedicingrOA,String Nombrepacoa,CInmuniz framein,String varnHC,JDesktopPane JDPIngreso,CIngreso frameingreso,CHistoriaOcup framehistocup,CEnfermedadProf frameenfermedadprof,CHistoriaAcciTrab frameaccitrabajo,CAntecedentesFamiliar frameantecendnetesfam,CAntecedentesPersonales frameantecpersonal,CAGineco frameginecologia,Object objppaliz) {
        frameOAOBJ=frameingreso;
        frameinOBJ=framein;
       framehoOBJ=framehistocup;
       frameEnfProfOBJ=frameenfermedadprof;
       frameAcciTrabajoOBJ=frameaccitrabajo;
       frameAntecFamOBJ=frameantecendnetesfam;
       frameAntecPersonalOBJ=frameantecpersonal;
       frameGinecologiaOBJ=frameginecologia;
       JLBNombrOA.setText(Nombrepacoa);
       JLBNumhcOA.setText(varnHC);
       JDPIngresoobjOA=JDPIngreso;
       nombroa=Nombrepacoa;
       numhcoa=varnHC;
       swgte=0;
       swedicingrRS=swedicingrOA;
       numingredicRS=numingredicOA;
       obotactualizarOA=obotactualizarIZ;
       objppaloa=objppaliz;
       try {
            jbInit();
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
        JTFTabaquismo.setBackground(Color.white);
        JTFTabaquismo.setEnabled(false);
        JTFTabaquismo.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFTabaquismo.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFTabaquismo.setToolTipText("");
        JCHTabaco.setBackground(SystemColor.textHighlight);
        JCHTabaco.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHTabaco.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHTabaco.setToolTipText("");
        JCHTabaco.setText("TABACO");
        JCHTabaco.setBounds(new Rectangle(20, 65, 148, 23));
        JCHTabaco.addActionListener(new COtrosAnt_JCHTabaco_actionAdapter(this));
        // JCHDiabet.addActionListener(new     CAntecedentesPersonales_JCHDiabet_actionAdapter(this));
        JTFTabaquismo.setBounds(new Rectangle(370, 66, 315, 22));
       ////INICIALIZACION DE LOS PANELES
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
        JBAtrasAF.addActionListener(new COtrosAnt_JBAtrasAF_actionAdapter(this));
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
        JBSgteAF.addActionListener(new COtrosAnt_JBSgteAF_actionAdapter(this));
        //JBSgteAF.addActionListener(ne              CAntecedentesPersonales_JBSgteAP_actionAdapter(this));
       JBSgteAF.setIcon(new ImageIcon(new java.net.URL("file:///C:/SALUD_OCUPACIONAL/Imagenes/AG_BTTN4.GIF")));
       JBSgteAF.setSelectedIcon(null);
        JLBNumhcOA.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNumhcOA.setForeground(Color.red);
        JLBNumhcOA.setToolTipText("");
        JLBNumhcOA.setText("HISTORIA CLINICA N#");
        JLBNumhcOA.setBounds(new Rectangle(555, 18, 158, 24));
        JCHLicor.setBackground(SystemColor.textHighlight);
        JCHLicor.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHLicor.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHLicor.setToolTipText("");
        JCHLicor.setText("INGESTA LICOR");
        JCHLicor.setBounds(new Rectangle(19, 117, 151, 23));
        JCHLicor.addActionListener(new COtrosAnt_JCHLicor_actionAdapter(this));
        JCHPractDep.setBackground(SystemColor.textHighlight);
        JCHPractDep.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHPractDep.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHPractDep.setToolTipText("");
        JCHPractDep.setText("PRACTICA DEPORTIVA");
        JCHPractDep.setBounds(new Rectangle(19, 179, 150, 23));
        JCHPractDep.addActionListener(new COtrosAnt_JCHPractDep_actionAdapter(this));
        JCHOtros.setBackground(SystemColor.textHighlight);
        JCHOtros.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHOtros.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHOtros.setToolTipText("");
        JCHOtros.setText("ACT. EXTRALABORAL");
        JCHOtros.setBounds(new Rectangle(20, 247, 149, 23));
        JCHOtros.addActionListener(new COtrosAnt_JCHOtros_actionAdapter(this));
        JLBFrecuencia.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        JLBFrecuencia.setForeground(Color.red);
        JLBFrecuencia.setToolTipText("");
        JLBFrecuencia.setText("FRECUENCIA");
        JLBFrecuencia.setBounds(new Rectangle(490, 17, 91, 32));
        JLBHabito.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        JLBHabito.setForeground(Color.red);
        JLBHabito.setToolTipText("");
        JLBHabito.setText("HABITO");
        JLBHabito.setBounds(new Rectangle(40, 21, 91, 32));
        JLBAnos.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        JLBAnos.setForeground(Color.red);
        JLBAnos.setToolTipText("");
        JLBAnos.setText("A�OS");
        JLBAnos.setBounds(new Rectangle(840, 21, 43, 32));
        JTFAnos.setBackground(Color.white);
        JTFAnos.setEnabled(false);
        JTFAnos.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFAnos.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFAnos.setToolTipText("");
        JTFAnos.setBounds(new Rectangle(827, 66, 92, 22));
        JTFIngestaLicor.setBackground(Color.white);
        JTFIngestaLicor.setEnabled(false);
        JTFIngestaLicor.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFIngestaLicor.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFIngestaLicor.setToolTipText("");
        JTFIngestaLicor.setText("");
        JTFIngestaLicor.setBounds(new Rectangle(371, 117, 315, 22));
        JTFAnosLicor.setBackground(Color.white);
        JTFAnosLicor.setEnabled(false);
        JTFAnosLicor.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFAnosLicor.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFAnosLicor.setToolTipText("");
        JTFAnosLicor.setText("");
        JTFAnosLicor.setBounds(new Rectangle(824, 118, 92, 22));
        JTFPractDeport.setBackground(Color.white);
        JTFPractDeport.setEnabled(false);
        JTFPractDeport.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFPractDeport.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFPractDeport.setToolTipText("");
        JTFPractDeport.setBounds(new Rectangle(370, 175, 315, 22));
        JTFAnosPD.setBackground(Color.white);
        JTFAnosPD.setEnabled(false);
        JTFAnosPD.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFAnosPD.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFAnosPD.setToolTipText("");
        JTFAnosPD.setBounds(new Rectangle(825, 175, 92, 22));
        JTFOtr.setBackground(Color.white);
        JTFOtr.setEnabled(false);
        JTFOtr.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFOtr.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFOtr.setToolTipText("");
        JTFOtr.setText("");
        JTFOtr.setBounds(new Rectangle(371, 243, 315, 22));
        JTFOtrosAnos.setBackground(Color.white);
        JTFOtrosAnos.setEnabled(false);
        JTFOtrosAnos.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFOtrosAnos.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFOtrosAnos.setToolTipText("");
        JTFOtrosAnos.setText("");
        JTFOtrosAnos.setBounds(new Rectangle(825, 241, 92, 22));
        JLBNombrOA.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBNombrOA.setForeground(Color.red);
        JLBNombrOA.setToolTipText("");
        JLBNombrOA.setBounds(new Rectangle(8, 20, 499, 24));
        JCHSust.setBackground(SystemColor.textHighlight);
        JCHSust.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JCHSust.setBorder(BorderFactory.createRaisedBevelBorder());
        JCHSust.setToolTipText("");
        JCHSust.setText("C.S.S.ADICTIVA");
        JCHSust.setBounds(new Rectangle(19, 317, 149, 23));
        JTFFrecAditc.setBackground(Color.white);
        JTFFrecAditc.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFFrecAditc.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFFrecAditc.setToolTipText("");
        JTFFrecAditc.setBounds(new Rectangle(375, 318, 315, 22));
        JTFAnAdicc.setBackground(Color.white);
        JTFAnAdicc.setFont(new java.awt.Font("Arial", Font.BOLD, 11));
        JTFAnAdicc.setBorder(BorderFactory.createRaisedBevelBorder());
        JTFAnAdicc.setToolTipText("");
        JTFAnAdicc.setBounds(new Rectangle(829, 316, 92, 22));
        this.getContentPane().add(JPAntecedentesFamiliar);
       //Adicionamos al JPAntecedentesFamiliar
       JPAntecedentesFamiliar.add(JBAtrasAF);
       JPAntecedentesFamiliar.add(JBCancelarAF);
       JPAntecedentesFamiliar.add(JBSgteAF); //JPAntecedentesFamiliar.add(JLBnhcAP);
       //JPAntecedentesFamiliar.add(JLBNumhcAP);
       JPAntecedentesFamiliar.add(JTBAntFam);
        JTBAntFam.add(JPAntFam, "HABITOS");
        JPAntecedentesFamiliar.add(JLBNumhcOA);
        JPAntecedentesFamiliar.add(JLBNombrOA);
        JPAntFam.add(JLBAnos);
        JPAntFam.add(JLBHabito);
        JPAntFam.add(JCHTabaco);
        JPAntFam.add(JLBFrecuencia);
        JPAntFam.add(JTFTabaquismo);
        JPAntFam.add(JTFAnos);
        JPAntFam.add(JCHOtros);
        JPAntFam.add(JCHLicor);
        JPAntFam.add(JCHPractDep);
        JPAntFam.add(JCHSust);
        JPAntFam.add(JTFAnosLicor);
        JPAntFam.add(JTFIngestaLicor);
        JPAntFam.add(JTFPractDeport);
        JPAntFam.add(JTFAnosPD);
        JPAntFam.add(JTFFrecAditc);
        JPAntFam.add(JTFAnAdicc);
        JPAntFam.add(JTFOtrosAnos);
        JPAntFam.add(JTFOtr);
    }


    public void inicioventanaOA(COtrosAnt frameOA) {
        objCOA=frameOA;
    }

//
    public void JBEpilepsia_actionPerformed(ActionEvent e) {
              if(JTFTabaquismo.getText().compareTo("")==0){
                 nombredetalle="EPILEPSIA";
                 //abrirformulariodetalles(JTFEpilepsia);swepilepc=1;
              }
             // else{

             //     nombredetalle="DIABETES";
               //   abrirformulariodetalles();
              //}
    }

    public void JBAtrasAF_actionPerformed(ActionEvent e) {
        CInmuniz frameOAAtras;
        frameOAAtras=(CInmuniz)frameinOBJ;
        frameOAAtras.setVisible(true);
        objCOA.setVisible(false);
    }

    public void JBSgteAF_actionPerformed(ActionEvent e) {
            validarnulosRS();
    }

    /**
     * validarnulosRS
     */
    public void validarnulosRS() {
        swval=0;
        CIngreso frameingreso;
        CHistoriaOcup framehistocup;
        CEnfermedadProf frameenfermedadprof;
        CHistoriaAcciTrab frameaccitrabajo;
        CAntecedentesFamiliar frameantecendnetesfam;
        CAntecedentesPersonales frameantecpersonal;
        CAGineco frameginecologia;
        CInmuniz frameinmunuz;
        frameingreso=(CIngreso)frameOAOBJ;
        COtrosAnt frameoa;
        frameoa=(COtrosAnt)objCOA;
        frameoa.setVisible(false);
        JDesktopPane JDPIngresoEP=new JDesktopPane();
        JDPIngresoEP=(JDesktopPane)JDPIngresoobjOA;
        framehistocup=(CHistoriaOcup)framehoOBJ;
        frameenfermedadprof=(CEnfermedadProf)frameEnfProfOBJ;
        frameaccitrabajo=(CHistoriaAcciTrab)frameAcciTrabajoOBJ;
        frameantecendnetesfam=(CAntecedentesFamiliar)frameAntecFamOBJ;
        frameantecpersonal=(CAntecedentesPersonales)frameAntecPersonalOBJ;
        frameginecologia=(CAGineco)frameGinecologiaOBJ;
        frameinmunuz=(CInmuniz)frameinOBJ;
        if(swgte==0){
            CRevisionSistemas frameRS= new CRevisionSistemas(obotactualizarOA,numingredicRS,swedicingrRS,nombroa,frameoa,numhcoa,JDPIngresoEP,frameingreso,framehistocup,frameenfermedadprof,frameaccitrabajo,frameantecendnetesfam,frameantecpersonal,frameginecologia,frameinmunuz,objppaloa);
            frameRS.setBounds(0, 2, 1010, 600);
            frameRS.setTitle("REVISION SISTEMAS (ENFASIS EN ALTURA)");
            JDPIngresoEP.add(frameRS, new Integer(1));
            frameRS.setLocation(5, 55);
            frameRS.show();
            frameRS.setVisible(true);
            frameRS.inicioventanaRS(frameRS);
            swgte=1;
            objetorevisionsistmas=frameRS;
            if(swedicingrRS==1){
                String cadsqledicRS;
                Connection con2=Cconsql.getConnection();
                cadsqledicRS="SELECT ingreso.id_ingreso, subgrupo_revsistemas.iddoloprecordial_rss, subgrupo_revsistemas.obsdolorprecordial_rss, subgrupo_revsistemas.idlipotimia_rss, subgrupo_revsistemas.obslipotimia_rss, subgrupo_revsistemas.idpalpitaciones_rss, subgrupo_revsistemas.obspalpitaciones_rss, subgrupo_revsistemas.idsincope_rss, subgrupo_revsistemas.obssincope_rss, subgrupo_revsistemas.iddescamacion_rss, subgrupo_revsistemas.obsdescamacion_rss, subgrupo_revsistemas.ideritema_rss, subgrupo_revsistemas.obseritema_rss, subgrupo_revsistemas.idhipehidrosis_rss, subgrupo_revsistemas.obshiperhidrosis_rss, subgrupo_revsistemas.idbrote_rss, subgrupo_revsistemas.obsbrote_rss, subgrupo_revsistemas.idsequedad_rss, subgrupo_revsistemas.obssequedad_rss, subgrupo_revsistemas.idprurito_rss, subgrupo_revsistemas.obsprurito_rss, subgrupo_revsistemas.iddispepsia_rss, subgrupo_revsistemas.obsdispepsia_rss, subgrupo_revsistemas.iddolorabdominal_rss, subgrupo_revsistemas.obsdolorabdominal_rss, subgrupo_revsistemas.idepigastralgiapirosis_rss, subgrupo_revsistemas.obsepigastralgiapirosis_rss, subgrupo_revsistemas.idestrenimiento_rss, subgrupo_revsistemas.obsestre�imiento_rss, subgrupo_revsistemas.iddiarrea_rss, subgrupo_revsistemas.obsdiarrea_rss, subgrupo_revsistemas.idsangrado_rss, subgrupo_revsistemas.obssangrado_rss, subgrupo_revsistemas.iddisminucioncalibre_rss, subgrupo_revsistemas.obsdisminucioncalibre_rss, subgrupo_revsistemas.iddisuria_rss, subgrupo_revsistemas.obsdisuria_rss, subgrupo_revsistemas.idhematuria_rss, subgrupo_revsistemas.obshematuria_rss, subgrupo_revsistemas.idtranstciclomestrual_rss, subgrupo_revsistemas.obstranstciclomestrual_rss, subgrupo_revsistemas.idnicturia_rss, subgrupo_revsistemas.obsnicturia_rss, subgrupo_revsistemas.idpolaquiuria_rss, subgrupo_revsistemas.obspolaquiuria_rss, subgrupo_revsistemas.idtenesmovesical_rss, subgrupo_revsistemas.obstenesmovesical_rss, subgrupo_revsistemas.idcefalea_rss, subgrupo_revsistemas.obscefalea_rss, subgrupo_revsistemas.idalteracionmemoria_rss, subgrupo_revsistemas.obsalteracionmotora_rss, subgrupo_revsistemas.idalteracionsue�o_rss, subgrupo_revsistemas.obsalteracionsue�o_rss, subgrupo_revsistemas.idvertigo_rss, subgrupo_revsistemas.obsvertigo_rss, subgrupo_revsistemas.idardorprurito_rss, subgrupo_revsistemas.obsardorprurito_rss, subgrupo_revsistemas.idcansansio_rss, subgrupo_revsistemas.obscansansio_rss, subgrupo_revsistemas.idvisionborrosa_rss, subgrupo_revsistemas.obsvisionborrosa_rss, subgrupo_revsistemas.idlagrimeo_rss, subgrupo_revsistemas.obslagrimeo_rss, subgrupo_revsistemas.idojorojo_rss, subgrupo_revsistemas.obsojorojo_rss, subgrupo_revsistemas.iddisfonia_rss, subgrupo_revsistemas.obsdisfonia_rss, subgrupo_revsistemas.idepistaxis_rss, subgrupo_revsistemas.obsepistaxis_rss, subgrupo_revsistemas.idhipoacusiasubjetiva_rss, subgrupo_revsistemas.obshipoacusiasubjetiva_rss, subgrupo_revsistemas.idobstruccionnasal_rss, subgrupo_revsistemas.obsobstruccionnasal_rss, subgrupo_revsistemas.idrinorrea_rss, subgrupo_revsistemas.obsrinorrea_rss, subgrupo_revsistemas.idtinitus_rss, subgrupo_revsistemas.obstinitus_rss, subgrupo_revsistemas.idcervicalgia_rss, subgrupo_revsistemas.obscervicalgia_rss, subgrupo_revsistemas.iddorsalgia_rss, subgrupo_revsistemas.obsdorsalgia_rss, subgrupo_revsistemas.idlumbalgia_rss, subgrupo_revsistemas.obslumbalgia_rss, subgrupo_revsistemas.idincapacitante_rss, subgrupo_revsistemas.obsincapacitante_rss, subgrupo_revsistemas.idaltralgias_rss, subgrupo_revsistemas.obsaltralgias_rss, subgrupo_revsistemas.idtendinitis_rss, subgrupo_revsistemas.obstendinitis_rss, subgrupo_revsistemas.idlimitacionfuncional_rss, subgrupo_revsistemas.obslimitacionfuncional_rss, subgrupo_revsistemas.idparentesias_rss, subgrupo_revsistemas.obsparentesias_rss, subgrupo_revsistemas.idtos_rss, subgrupo_revsistemas.obstos_rss, subgrupo_revsistemas.iddolortoraxico_rss, subgrupo_revsistemas.obsdolortoraxico_rss, subgrupo_revsistemas.idexpectoracion_rss, subgrupo_revsistemas.obsexpectoracion_rss, subgrupo_revsistemas.iddisnea_rss, subgrupo_revsistemas.obsdisnea_rss, subgrupo_revsistemas.idcoronaria_rss, subgrupo_revsistemas.obscoronaria_rss, subgrupo_revsistemas.idarritmia_rss, subgrupo_revsistemas.obsarritmia_rss, subgrupo_revsistemas.ha_rss, subgrupo_revsistemas.obsha_rss FROM ingreso INNER JOIN subgrupo_revsistemas ON ingreso.id_ingreso = subgrupo_revsistemas.idingreso_rss WHERE ingreso.id_ingreso="+numingredicRS;
                try{
                   TSentenciaconsultaRS = con2.createStatement();
                   RconsultaRS = TSentenciaconsultaRS.executeQuery(cadsqledicRS);
                   while (RconsultaRS.next()) {
                       frameRS.JRDolorPrecordial.setSelected(RconsultaRS.getBoolean(2));
                       frameRS.JFTDolorPrecordial.setText(RconsultaRS.getString(3));
                       frameRS.JRLipotimia.setSelected(RconsultaRS.getBoolean(4));
                       frameRS.JFTLipotimia.setText(RconsultaRS.getString(5));
                       frameRS.JRPalpitaciones.setSelected(RconsultaRS.getBoolean(6));
                       frameRS.JFTPalpit.setText(RconsultaRS.getString(7));
                       frameRS.JRSincope.setSelected(RconsultaRS.getBoolean(8));
                       frameRS.JFTSincope.setText(RconsultaRS.getString(9));
                       frameRS.JRDescamacion.setSelected(RconsultaRS.getBoolean(10));
                       frameRS.JFTdescam.setText(RconsultaRS.getString(11));
                       frameRS.JREritema.setSelected(RconsultaRS.getBoolean(12));
                       frameRS.JFTEritema.setText(RconsultaRS.getString(13));
                       frameRS.JRHiperhidrosis.setSelected(RconsultaRS.getBoolean(14));
                       frameRS.JFTHiperhidrosis.setText(RconsultaRS.getString(15));
                       frameRS.JRBrote.setText(RconsultaRS.getString(16));
                       frameRS.JFTBrote.setText(RconsultaRS.getString(17));
                       frameRS.JRSequedad.setSelected(RconsultaRS.getBoolean(18));
                       frameRS.JFTSequedad.setText(RconsultaRS.getString(19));
                       frameRS.JRPrurito.setSelected(RconsultaRS.getBoolean(20));
                       frameRS.JFTprurito.setText(RconsultaRS.getString(21));
                       frameRS.JRDispepsia.setSelected(RconsultaRS.getBoolean(22));
                       frameRS.JFTDispepsia.setText(RconsultaRS.getString(23));
                       frameRS.JRDolorAbdominal.setSelected(RconsultaRS.getBoolean(24));
                       frameRS.JFTDolorAbd.setText(RconsultaRS.getString(25));
                       frameRS.JREpigastraigia.setSelected(RconsultaRS.getBoolean(26));
                       frameRS.JFTEpigastr.setText(RconsultaRS.getString(27));
                       frameRS.JREstrenimiento.setSelected(RconsultaRS.getBoolean(28));
                       frameRS.JFTEstrenimiento.setText(RconsultaRS.getString(29));
                       frameRS.JRDiarrea.setSelected(RconsultaRS.getBoolean(30));
                       frameRS.JFTDiarrea.setText(RconsultaRS.getString(31));
                       frameRS.JRSangrado.setSelected(RconsultaRS.getBoolean(32));
                       frameRS.JFTSangrado.setText(RconsultaRS.getString(33));
                       frameRS.JRDisminucionCalibre.setSelected(RconsultaRS.getBoolean(34));
                       frameRS.JFTDisminucionCalibre.setText(RconsultaRS.getString(35));
                       frameRS.JRDisuria.setSelected(RconsultaRS.getBoolean(36));
                       frameRS.JFTDisuria.setText(RconsultaRS.getString(37));
                       frameRS.JRHematuria.setSelected(RconsultaRS.getBoolean(38));
                       frameRS.JFTHematuria.setText(RconsultaRS.getString(39));
                       frameRS.JRTrantCicloMestr.setSelected(RconsultaRS.getBoolean(40));
                       frameRS.JFTtranstCicloMestr.setText(RconsultaRS.getString(41));
                       frameRS.JRNicturia.setSelected(RconsultaRS.getBoolean(42));
                       frameRS.JFTNicturia.setText(RconsultaRS.getString(43));
                       frameRS.JRPolaquiuria.setSelected(RconsultaRS.getBoolean(44));
                       frameRS.JFTPalquiuria.setText(RconsultaRS.getString(45));
                       frameRS.JRTenesmoVesical.setSelected(RconsultaRS.getBoolean(46));
                       frameRS.JFTTenesmovesical.setText(RconsultaRS.getString(47));
                       frameRS.JRCefalea.setSelected(RconsultaRS.getBoolean(48));
                       frameRS.JFTCefalea.setText(RconsultaRS.getString(49));
                       frameRS.JRAlteracionMemoria.setSelected(RconsultaRS.getBoolean(50));
                       frameRS.JFTAlteracionMemoria.setText(RconsultaRS.getString(51));
                       frameRS.JRAlteracionSensib.setSelected(RconsultaRS.getBoolean(52));
                       frameRS.JFTAlteracionSencib.setText(RconsultaRS.getString(53));
                       frameRS.JRVertigo.setSelected(RconsultaRS.getBoolean(54));
                       frameRS.JFTVertigo.setText(RconsultaRS.getString(55));
                       frameRS.JRArdorprurito.setSelected(RconsultaRS.getBoolean(56));
                       frameRS.JFTArdorPrurito.setText(RconsultaRS.getString(57));
                       frameRS.JRCansancio.setSelected(RconsultaRS.getBoolean(58));
                       frameRS.JFTCansancio.setText(RconsultaRS.getString(59));
                       frameRS.JRVisionBorrosa.setSelected(RconsultaRS.getBoolean(60));
                       frameRS.JFTVisionBorrosa.setText(RconsultaRS.getString(61));
                       frameRS.JRLagrimeo.setSelected(RconsultaRS.getBoolean(62));
                       frameRS.JFTLagrimeo.setText(RconsultaRS.getString(63));
                       frameRS.JROjoRojo.setSelected(RconsultaRS.getBoolean(64));
                       frameRS.JFTOjoRojo.setText(RconsultaRS.getString(65));
                       frameRS.JRDisfonia.setSelected(RconsultaRS.getBoolean(66));
                       frameRS.JFTDisfonia.setText(RconsultaRS.getString(67));
                       frameRS.JREpistaxis.setSelected(RconsultaRS.getBoolean(68));
                       frameRS.JFTEpistaxis.setText(RconsultaRS.getString(69));
                       frameRS.JRHipoacusia.setSelected(RconsultaRS.getBoolean(70));
                       frameRS.JFTHipoacusia.setText(RconsultaRS.getString(71));
                       frameRS.JRObstruccionNasal.setSelected(RconsultaRS.getBoolean(72));
                       frameRS.JFTObstruccionNasal.setText(RconsultaRS.getString(73));
                       frameRS.JRRinorrea.setSelected(RconsultaRS.getBoolean(74));
                       frameRS.JFTRinorrea.setText(RconsultaRS.getString(75));
                       frameRS.JRTinitus.setSelected(RconsultaRS.getBoolean(76));
                       frameRS.JFTTinitus.setText(RconsultaRS.getString(77));
                       frameRS.JRCervicalgia.setSelected(RconsultaRS.getBoolean(78));
                       frameRS.JFTCervicalgia.setText(RconsultaRS.getString(79));
                       frameRS.JRDorsalgia.setSelected(RconsultaRS.getBoolean(80));
                       frameRS.JFTDorsalgia.setText(RconsultaRS.getString(81));
                       frameRS.JRLumbalgia.setSelected(RconsultaRS.getBoolean(82));
                       frameRS.JFTLumbalgia.setText(RconsultaRS.getString(83));
                       frameRS.JRIncapacitante.setSelected(RconsultaRS.getBoolean(84));
                       frameRS.JFTIncapacitante.setText(RconsultaRS.getString(85));
                       frameRS.JRArtralgias.setSelected(RconsultaRS.getBoolean(86));
                       frameRS.JFTArtralgias.setText(RconsultaRS.getString(87));
                       frameRS.JRTendinitis.setSelected(RconsultaRS.getBoolean(88));
                       frameRS.JFTTendinitis.setText(RconsultaRS.getString(89));
                       frameRS.JRLimitacionFuncional.setSelected(RconsultaRS.getBoolean(90));
                       frameRS.JFTLimitacionFunc.setText(RconsultaRS.getString(91));
                       frameRS.JRParentestesias.setSelected(RconsultaRS.getBoolean(92));
                       frameRS.JFTParestesias.setText(RconsultaRS.getString(93));
                       frameRS.JRTos.setSelected(RconsultaRS.getBoolean(94));
                       frameRS.JFTTos.setText(RconsultaRS.getString(95));
                       frameRS.JRDolorToraxico.setSelected(RconsultaRS.getBoolean(96));
                       frameRS.JFTDolorToraxico.setText(RconsultaRS.getString(97));
                       frameRS.JRExpectoracion.setSelected(RconsultaRS.getBoolean(98));
                       frameRS.JFTExpectoracion.setText(RconsultaRS.getString(99));
                       frameRS.JRDisnea.setSelected(RconsultaRS.getBoolean(100));
                       frameRS.jFormattedTextField2.setText(RconsultaRS.getString(101));
                       frameRS.JRCoronaria.setSelected(RconsultaRS.getBoolean(102));
                       frameRS.JFTCoronaria.setText(RconsultaRS.getString(103));
                       frameRS.JRArritmia.setSelected(RconsultaRS.getBoolean(104));
                       frameRS.JFTArritmia.setText(RconsultaRS.getString(105));
                       frameRS.JRHa.setSelected(RconsultaRS.getBoolean(106));
                       frameRS.JFTha.setText(RconsultaRS.getString(107));
                       activarbotonRS(frameRS.JBDolorPrecordial);
                       activarbotonRS(frameRS.JBLipotimia);
                       activarbotonRS(frameRS.JBPalpitaciones);
                       activarbotonRS(frameRS.JBSincope);
                       activarbotonRS(frameRS.JBDescamacion);
                       activarbotonRS(frameRS.JBEritema);
                       activarbotonRS(frameRS.JBHiperhidrosis);
                       activarbotonRS(frameRS.JBBrote);
                       activarbotonRS(frameRS.JBSequedad);
                       activarbotonRS(frameRS.JBPrurito);
                       activarbotonRS(frameRS.JBDispepsia);
                       activarbotonRS(frameRS.JBDolorAbdominal);
                       activarbotonRS(frameRS.JBEpigastraigia);
                       activarbotonRS(frameRS.JBEstrenimiento);
                       activarbotonRS(frameRS.JBDiarrea);
                       activarbotonRS(frameRS.JBSangrado);
                       activarbotonRS(frameRS.JBDisminucionCalibre);
                       activarbotonRS(frameRS.JBDisuria);
                       activarbotonRS(frameRS.JBHematuria);
                       activarbotonRS(frameRS.JBTranstCicloMestrual);
                       activarbotonRS(frameRS.JBNicturia);
                       activarbotonRS(frameRS.JBPalaquiuria);
                       activarbotonRS(frameRS.JBTenesmoVesical);
                       activarbotonRS(frameRS.JBCefalea);
                       activarbotonRS(frameRS.JBAlteracionMemoria);
                       activarbotonRS(frameRS.JBAlteracionMotora);
                       activarbotonRS(frameRS.JBAlteracionSensibilidad);
                       activarbotonRS(frameRS.JBVertigo);
                       activarbotonRS(frameRS.JBArdor);
                       activarbotonRS(frameRS.JBCansancio);
                       activarbotonRS(frameRS.JBVisionBorrosa);
                       activarbotonRS(frameRS.JBLagrimeo);
                       activarbotonRS(frameRS.JBOjoRojo);
                       activarbotonRS(frameRS.JBDisfonia);
                       activarbotonRS(frameRS.JBEpistaxis);
                       activarbotonRS(frameRS.JBHipoacusia);
                       activarbotonRS(frameRS.JBObstruccionNasal);
                       activarbotonRS(frameRS.JBRinorrea);
                       activarbotonRS(frameRS.JBTinitus);
                       activarbotonRS(frameRS.JBCervicalgia);
                       activarbotonRS(frameRS.JBDorsalgia);
                       activarbotonRS(frameRS.JBLumbalgia);
                       activarbotonRS(frameRS.JBIncapacitante);
                       activarbotonRS(frameRS.JBArtralgias);
                       activarbotonRS(frameRS.JBTendinitis);
                       activarbotonRS(frameRS.JBLimitacionFuncional);
                       activarbotonRS(frameRS.JBParestesias);
                       activarbotonRS(frameRS.JBTos);
                       activarbotonRS(frameRS.JBDolorToraxico);
                       activarbotonRS(frameRS.JBExpectoracion);
                       activarbotonRS(frameRS.JBDisnea);
                       activarbotonRS(frameRS.JBcoronaria);
                       activarbotonRS(frameRS.JBArritmia);
                       activarbotonRS(frameRS.JBHa);
                   }
                }//fin del try
                catch(SQLException e1){
                  e1.getMessage();
                  cad2="NO SE PUDO EJECUTAR LA CONSULTA";
                  cad1="PROBLEMAS CON LOS DATOS DE REVISION SISTEMAS EN EDICION";
                  validRS.mensajeconfirmacion(cad1,cad2);
                }//cierra el catch
                Cconsql.CerrarConexion();

            }

        }
        else{
            CRevisionSistemas frameRS;
            frameRS=(CRevisionSistemas)objetorevisionsistmas;
           // ObjectCingreso.setVisible(false);
            frameRS.setVisible(true);
       }


    }

    public void JCHTabaco_actionPerformed(ActionEvent e) {
          controltextfieldOA(JCHTabaco,JTFTabaquismo,JTFAnos);
          JTFTabaquismo.requestFocus();
          JTFTabaquismo.setEnabled(true);
    }

    /**
     * controltextfieldO
     */
    public void controltextfieldOA(JCheckBox JCHparametro,JTextField JTFpar,JTextField JTFfechOA) {
        if(JCHparametro.isSelected()==true){
             JCHparametro.setSelected(true);
             //JTFpar.setEnabled(true);
             JTFpar.setEnabled(true);
             JTFfechOA.setEnabled(true);

         }
         else{
             JCHparametro.setSelected(false);
             JTFpar.setText(" ");
             JTFfechOA.setText(" ");
            // JBvar.setEnabled(false);

         }

    }

    public void JCHLicor_actionPerformed(ActionEvent e) {
           controltextfieldOA(JCHLicor,JTFIngestaLicor,JTFAnosLicor);
           JTFIngestaLicor.requestFocus();
           JTFIngestaLicor.setEnabled(true);
    }

    public void JCHPractDep_actionPerformed(ActionEvent e) {
           controltextfieldOA(JCHPractDep,JTFPractDeport,JTFAnosPD);
           JTFPractDeport.requestFocus();
           JTFPractDeport.setEnabled(true);
    }

    public void JCHOtros_actionPerformed(ActionEvent e) {
           controltextfieldOA(JCHOtros,JTFOtr,JTFOtrosAnos);
           JTFOtr.requestFocus();
           JTFOtr.setEnabled(true);
    }

    /**
     * activarbotonRS
     */
    public void activarbotonRS(JButton JVvar) {
        JVvar.setEnabled(true);
    }

    public COtrosAnt() {
    }


}//FIN CLASE


class COtrosAnt_JCHOtros_actionAdapter implements ActionListener {
    private COtrosAnt adaptee;
    COtrosAnt_JCHOtros_actionAdapter(COtrosAnt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHOtros_actionPerformed(e);
    }
}


class COtrosAnt_JCHPractDep_actionAdapter implements ActionListener {
    private COtrosAnt adaptee;
    COtrosAnt_JCHPractDep_actionAdapter(COtrosAnt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHPractDep_actionPerformed(e);
    }
}


class COtrosAnt_JCHLicor_actionAdapter implements ActionListener {
    private COtrosAnt adaptee;
    COtrosAnt_JCHLicor_actionAdapter(COtrosAnt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHLicor_actionPerformed(e);
    }
}


class COtrosAnt_JCHTabaco_actionAdapter implements ActionListener {
    private COtrosAnt adaptee;
    COtrosAnt_JCHTabaco_actionAdapter(COtrosAnt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCHTabaco_actionPerformed(e);
    }
}


class COtrosAnt_JBSgteAF_actionAdapter implements ActionListener {
    private COtrosAnt adaptee;
    COtrosAnt_JBSgteAF_actionAdapter(COtrosAnt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBSgteAF_actionPerformed(e);
    }
}


class COtrosAnt_JBAtrasAF_actionAdapter implements ActionListener {
    private COtrosAnt adaptee;
    COtrosAnt_JBAtrasAF_actionAdapter(COtrosAnt adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAtrasAF_actionPerformed(e);
    }
}


//CLASESE ANEXAS
class CHistoriaOcup_JBEpilepsia_actionAdapter implements ActionListener {
    private COtrosAnt adaptee;
    CHistoriaOcup_JBEpilepsia_actionAdapter(COtrosAnt
            adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBEpilepsia_actionPerformed(e);
    }
}


