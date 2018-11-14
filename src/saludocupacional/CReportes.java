package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;

import com.toedter.calendar.*;
import java.sql.Connection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
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
public class CReportes extends JInternalFrame {
    String cad1;
    String cad2;
    ValidarComponentes valreporte=new ValidarComponentes();
    public ConexionSql Cconsql= new ConexionSql();
   String nombreporte,sqlrep,nombrempresa;
   public int numrep;
   JPanel JPReportes = new JPanel();
   JLabel JLBEmpresa = new JLabel();
   JComboBox JCEmpresa = new JComboBox();
   JLabel JLBTIpExam = new JLabel();
   JComboBox JCBNombrRep = new JComboBox();
   JLabel JLBFechaIni = new JLabel();
   JFormattedTextField JFTFechaIni = new JFormattedTextField();
   JLabel JLBFechaFin = new JLabel();
   JFormattedTextField JFTFechaFin = new JFormattedTextField();
   JCalendar jCalendar1 = new JCalendar();
   JCalendar jCalendar2 = new JCalendar();
   Date fecharepdate=new Date();
   String sFecharep;
   JButton JBAceptar = new JButton();
   ValidarComponentes valreportes=new ValidarComponentes();
   public CReportes(int nr) {
        try {
            jbInit();
            System.out.println("NALGONA:"+nr);
            numrep=nr;
            llenaremprentrada();
            llenareportes();
         }
       catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setClosable(true);
        this.setIconifiable(true);
        this.setMaximizable(true);
        this.setResizable(true);
        this.getContentPane().setBackground(UIManager.getColor("InternalFrame.inactiveTitleForeground"));
        this.setVisible(true);
        this.getContentPane().setBackground(Color.white);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.getContentPane().setLayout(null);
        JPReportes.setBackground(new Color(0, 139, 146));
        JPReportes.setBorder(BorderFactory.createRaisedBevelBorder());
        JPReportes.setBounds(new Rectangle(3, 3, 612, 428));
        JPReportes.setLayout(null);
        JLBEmpresa.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBEmpresa.setForeground(Color.white);
        JLBEmpresa.setText("EMPRESA");
        JLBEmpresa.setBounds(new Rectangle(8, 18, 87, 33));
        JCEmpresa.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 14));
        JCEmpresa.setBorder(BorderFactory.createRaisedBevelBorder());
        JCEmpresa.setBounds(new Rectangle(189, 16, 408, 24));
        JLBTIpExam.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBTIpExam.setForeground(Color.white);
        JLBTIpExam.setToolTipText("");
        JLBTIpExam.setText("NOMBRE DEL REPORTE");
        JLBTIpExam.setBounds(new Rectangle(8, 84, 172, 33));
        JCBNombrRep.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 14));
        JCBNombrRep.setBorder(BorderFactory.createRaisedBevelBorder());
        JCBNombrRep.setBounds(new Rectangle(190, 90, 408, 24));
        JCBNombrRep.addActionListener(new CReportes_JCBNombrRep_actionAdapter(this));
        JLBFechaIni.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBFechaIni.setForeground(Color.white);
        JLBFechaIni.setToolTipText("");
        JLBFechaIni.setText("FECHA INICIAL");
        JLBFechaIni.setBounds(new Rectangle(9, 166, 162, 33));
        JFTFechaIni.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTFechaIni.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTFechaIni.setToolTipText("");
        JFTFechaIni.setBounds(new Rectangle(189, 167, 173, 26));
        JFTFechaIni.addFocusListener(new CReportes_JFTFechaIni_focusAdapter(this));
        JLBFechaFin.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        JLBFechaFin.setForeground(Color.white);
        JLBFechaFin.setToolTipText("");
        JLBFechaFin.setText("FECHA FINAL");
        JLBFechaFin.setBounds(new Rectangle(6, 278, 125, 33));
        JFTFechaFin.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTFechaFin.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTFechaFin.setToolTipText("");
        JFTFechaFin.setBounds(new Rectangle(185, 282, 173, 26));
        JFTFechaFin.addFocusListener(new CReportes_JFTFechaFin_focusAdapter(this));
        JBAceptar.setBackground(Color.white);
        JBAceptar.setBounds(new Rectangle(485, 356, 114, 34));
        JBAceptar.setFont(new java.awt.Font("Arial Black", Font.BOLD, 12));
        JBAceptar.setBorder(BorderFactory.createRaisedBevelBorder());
        JBAceptar.setText("ACEPTAR");
        JBAceptar.addActionListener(new CReportes_JBAceptar_actionAdapter(this));
        this.getContentPane().add(JPReportes);
        jCalendar1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jCalendar1.setBackground(Color.red);
        jCalendar1.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        jCalendar1.setDecorationBackgroundColor(Color.white);
        jCalendar1.setBounds(new Rectangle(190, 167, 258, 84));
        jCalendar1.addFocusListener(new CReportes_jCalendar1_focusAdapter(this));
        jCalendar1.addMouseListener(new CReportes_jCalendar1_mouseAdapter(this));
        //jCalendar2
        jCalendar2.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        jCalendar2.setBackground(Color.red);
        jCalendar2.setFont(new java.awt.Font("Arial Black", Font.PLAIN, 11));
        jCalendar2.setDecorationBackgroundColor(Color.white);
        jCalendar2.setBounds(new Rectangle(187, 282, 258, 84));
        jCalendar2.addFocusListener(new CReportes_jCalendar2_focusAdapter(this));
        jCalendar2.addMouseListener(new CReportes_jCalendar2_mouseAdapter(this));
        JPReportes.add(JCEmpresa);
        JPReportes.add(JCBNombrRep);
        JPReportes.add(JLBTIpExam);
        JPReportes.add(JLBEmpresa);
        JPReportes.add(JLBFechaIni);
        JPReportes.add(JFTFechaIni);
        JPReportes.add(jCalendar1);
        JPReportes.add(JLBFechaFin);
        JPReportes.add(JFTFechaFin);
        JPReportes.add(jCalendar2);
        JPReportes.add(JBAceptar);
        jCalendar1.setVisible(false);
        jCalendar2.setVisible(false);

        //
       }

    /**
     * llenareportes
     */
    public void llenareportes() {
        String cadenarep;
        cadenarep="select *from reportes where tiporeporte_reporte="+numrep+" ORDER BY reportes.nombre_reporte";
       // System.out.println("san fermin:"+cadenarep);
        valreportes.llenarcombos(cadenarep,JCBNombrRep,2);
    }

    //
       public void jCalendar1_focusLost(FocusEvent focusEvent) {

       }
      //
      public void jCalendar1_mouseReleased(MouseEvent e) {
          String patron="dd/MM/yyyy";
          SimpleDateFormat formato2=new SimpleDateFormat(patron);
          fecharepdate=jCalendar1.getDate();
          sFecharep=formato2.format(fecharepdate);
          JFTFechaIni.setText(sFecharep);
          jCalendar1.setVisible(false);
          JFTFechaIni.setVisible(true);
      }
  //
  public void jCalendar2_mouseReleased(MouseEvent e) {
         // System.out.println("san sebastian:");
          String patron="dd/MM/yyyy";
          SimpleDateFormat formato2=new SimpleDateFormat(patron);
          fecharepdate=jCalendar2.getDate();
          sFecharep=formato2.format(fecharepdate);
          JFTFechaFin.setText(sFecharep);
          jCalendar2.setVisible(false);
          JFTFechaFin.setVisible(true);
      }

  public void jCalendar2_focusLost(FocusEvent focusEvent) {

      }

    public void JFTFechaIni_focusGained(FocusEvent e) {
         jCalendar1.setVisible(true);
         JFTFechaIni.setVisible(false);
    }

    public void JFTFechaFin_focusGained(FocusEvent e) {
        jCalendar2.setVisible(true);
        JFTFechaFin.setVisible(false);
    }

    /**
     * llenaremprentrada
     */
    public void llenaremprentrada() {
        String cadenaempr;
        cadenaempr="select *from empresa ORDER BY empresa.nombre_empresa";
        valreportes.llenarcombos(cadenaempr,JCEmpresa,2);

    }

    public void JBAceptar_actionPerformed(ActionEvent e) {
        String fechaini,fechafin;
        nombreporte=valreporte.evaluarcombocadena(JCBNombrRep);
        sqlrep="select *from reportes where reportes.nombre_reporte="+"'"+nombreporte+"'";
        nombreporte=valreporte.buscarcadena(sqlrep,4);
        String rutaretiro;
        rutaretiro="C:\\SALUD_OCUPACIONAL\\reportes\\";
        rutaretiro=rutaretiro.concat(nombreporte);
        nombrempresa=valreporte.evaluarcombocadena(JCEmpresa);
        sqlrep="select *from empresa where empresa.nombre_empresa="+"'"+nombrempresa+"'";
        nombrempresa=valreporte.buscarcadena(sqlrep,2);
        fechaini=valreporte.cambiarformatofecha(JFTFechaIni.getText());
        fechafin=valreporte.cambiarformatofecha(JFTFechaFin.getText());
        procesocomunimpr(rutaretiro,nombrempresa,fechaini,fechafin);
    }

    public void JCBNombrRep_actionPerformed(ActionEvent e) {

    }

    /**
     * procesocomunimpr
     */
    public void procesocomunimpr(String rutaretiro,String empresa,String fechaini,String fechafin) {
       Connection con2=Cconsql.getConnection();
       String archivoreporte=rutaretiro;
       try{
             int var=0;
             Map parametro = new HashMap();
             parametro.put("empresa",empresa);
             parametro.put("fechaini",fechaini);
             parametro.put("fechafin",fechafin);
             JasperPrint imprimir =  JasperFillManager.fillReport(archivoreporte,parametro,con2);
            // JasperPrintManager.printReport( imprimir, true);
             JasperViewer vista = new JasperViewer(imprimir, false);
             vista.setVisible(true);


         }
          catch (JRException j){
               cad1=j.getLocalizedMessage();
               cad2="PROBLEMAS AL IMPRIMIR EL REPORTE";
               valreporte.mensajeconfirmacion(cad1,cad2);
           }

    }
}//fin clase


class CReportes_JCBNombrRep_actionAdapter implements ActionListener {
    private CReportes adaptee;
    CReportes_JCBNombrRep_actionAdapter(CReportes adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JCBNombrRep_actionPerformed(e);
    }
}


class CReportes_JBAceptar_actionAdapter implements ActionListener {
    private CReportes adaptee;
    CReportes_JBAceptar_actionAdapter(CReportes adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JBAceptar_actionPerformed(e);
    }
}


class CReportes_JFTFechaIni_focusAdapter extends FocusAdapter {
    private CReportes adaptee;
    CReportes_JFTFechaIni_focusAdapter(CReportes adaptee) {
        this.adaptee = adaptee;
    }

    public void focusGained(FocusEvent e) {
        adaptee.JFTFechaIni_focusGained(e);
    }
} //jCalendar1_focusAdapter


class CReportes_JFTFechaFin_focusAdapter extends FocusAdapter {
    private CReportes adaptee;
    CReportes_JFTFechaFin_focusAdapter(CReportes adaptee) {
        this.adaptee = adaptee;
    }

    public void focusGained(FocusEvent e) {
        adaptee.JFTFechaFin_focusGained(e);
    }
}


class CReportes_jCalendar1_focusAdapter extends FocusAdapter {
       private CReportes adaptee;
       CReportes_jCalendar1_focusAdapter(CReportes adaptee) {
           this.adaptee = adaptee;
       }

       public void focusLost(FocusEvent focusEvent) {
           adaptee.jCalendar1_focusLost(focusEvent);
       }
}
//jCalendar1_mouseReleased
   class CReportes_jCalendar1_mouseAdapter extends MouseAdapter {
       private CReportes adaptee;
       CReportes_jCalendar1_mouseAdapter(CReportes adaptee) {
           this.adaptee = adaptee;
       }

       public void mouseReleased(MouseEvent e) {
           adaptee.jCalendar1_mouseReleased(e);
    }
   }
  //jCalendar2_focusAdapter
  class CReportes_jCalendar2_focusAdapter extends FocusAdapter {
      private CReportes adaptee;
      CReportes_jCalendar2_focusAdapter(CReportes adaptee) {
          this.adaptee = adaptee;
      }

      public void focusLost(FocusEvent focusEvent) {
          adaptee.jCalendar2_focusLost(focusEvent);
      }
}
  //jCalendar2_mouseReleased
     class CReportes_jCalendar2_mouseAdapter extends MouseAdapter {
         private CReportes adaptee;
         CReportes_jCalendar2_mouseAdapter(CReportes adaptee) {
             this.adaptee = adaptee;
         }

         public void mouseReleased(MouseEvent e) {
             adaptee.jCalendar2_mouseReleased(e);
      }
   }
