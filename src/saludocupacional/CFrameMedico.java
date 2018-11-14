package saludocupacional;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyEvent;

public class CFrameMedico extends JInternalFrame {
    Object objjdpmedico;
    ValidarComponentes varframemedico=new ValidarComponentes();
    String cad1;
    String cad2,numingrmedico;
    public Statement TSentenciamedico;
    public ConexionSql Cconsql= new ConexionSql();
    CModeloMedico modelomedico= new CModeloMedico();
    JScrollPane JSPMedico = new JScrollPane();
    JTable JTMedico = new JTable(modelomedico);
    public CFrameMedico(JDesktopPane JDPIngreso) {
        try {
            jbInit();
            anadirentradamedico();
            objjdpmedico=JDPIngreso;
            procesomedico();
        } catch (Exception ex) {
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
      //  this.getContentPane().setLayout(null);
        this.getContentPane().setLayout(null);
        JSPMedico.getViewport().setBackground(Color.white);
        JSPMedico.setBorder(BorderFactory.createRaisedBevelBorder());
        JSPMedico.setBounds(new Rectangle(1, 3, 999, 557));
        JTMedico.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        JTMedico.addMouseListener(new CFrameMedico_JTMedico_mouseAdapter(this));
        this.getContentPane().add(JSPMedico);
        JSPMedico.getViewport().add(JTMedico);
    }

    /**
     * anadirentradamedico
     */
    public void anadirentradamedico() {
        CBaseMedico dato = new CBaseMedico ("","","","","","","","","",false);
        modelomedico.anhadeentrada(dato);
    }

    /**
     * procesomedico
     */
    public void procesomedico() {
        Connection con2=Cconsql.getConnection();
        ResultSet Rconsulta;
        String cadmedicosql;
        cadmedicosql="SELECT datosusuarios.NoHC_du, datosusuarios.PrimerApellido_du, datosusuarios.SegundoApellido_du, datosusuarios.PrimerNombre_du, datosusuarios.SegundoNombre_du, empresa.nombre_empresa, tipo_examen.nombre_TE, ingreso.fechaexa_ingreso, ingreso.id_ingreso, ingreso.pendiente_ingreso,datosusuarios.foto_du FROM tipo_examen INNER JOIN (empresa INNER JOIN (datosusuarios INNER JOIN ingreso ON datosusuarios.NoHC_du = ingreso.NoHC_ingreso) ON empresa.id_empresa = ingreso.idempresa_ingreso) ON tipo_examen.idtipo_TE = ingreso.idtipoex_ingreso WHERE (((ingreso.pendiente_ingreso)="+false+"));";
        try{
           TSentenciamedico=con2.createStatement();
           Rconsulta=TSentenciamedico.executeQuery(cadmedicosql);
           llenarmodelomedico(Rconsulta);
           //ultima=ultima+1;
        }//cierra el try
        catch(SQLException e){
              e.getMessage();
              cad1="NO SE PUDO RECUPERAR EL ULTIMO REGISTRO";
              cad2="PROBLEMAS CON LOS DATOS DE USUARIO";
              varframemedico.mensajeconfirmacion(cad1,cad2);
         }//cierra el catch
        Cconsql.CerrarConexion();
    }

    /**
     * llenarmodelomedico
     */
    public void llenarmodelomedico(ResultSet Rconsulta) {
        int ifila=0;
        try{
            while(Rconsulta.next()){
                modelomedico.setValueAt(Rconsulta.getString(1),ifila,0);
                modelomedico.setValueAt(Rconsulta.getString(2),ifila,1);
                modelomedico.setValueAt(Rconsulta.getString(3),ifila,2);
                modelomedico.setValueAt(Rconsulta.getString(4),ifila,3);
                modelomedico.setValueAt(Rconsulta.getString(5),ifila,4);
                modelomedico.setValueAt(Rconsulta.getString(6),ifila,5);
                modelomedico.setValueAt(Rconsulta.getString(7),ifila,6);
                modelomedico.setValueAt(Rconsulta.getString(8),ifila,7);
                modelomedico.setValueAt(Rconsulta.getString(9),ifila,8);
                modelomedico.setValueAt(Rconsulta.getBoolean(10),ifila,9);
                ifila=ifila+1;
                anadirentradamedico();
            }
        }//cierra el try
       catch(SQLException e){
             cad1="NO SE HA LLENADO EL MODELO MEDICO";
             cad2="ERROR MODELO MEDICO";
             varframemedico.mensajeconfirmacion(cad1,cad2);
       }//cierra el catch
    }

    public void JTMedico_mouseReleased(MouseEvent e) {
        if (e.getClickCount()==2){
            numingrmedico=(String)modelomedico.getValueAt(JTMedico.getSelectedRow(),8);
            Connection con2=Cconsql.getConnection();
            ResultSet Rconsulta;
            String cadenamedicosql;
            cadenamedicosql="SELECT datosusuarios.NoHC_du, datosusuarios.Documento_du, datosusuarios.PrimerApellido_du, datosusuarios.SegundoApellido_du, datosusuarios.PrimerNombre_du, datosusuarios.SegundoNombre_du, datosusuarios.FechadeNacimiento_du, datosusuarios.idtipoedad_du, datosusuarios.edad_du, datosusuarios.IdSexo_du, datosusuarios.IdEstadoCivi_du, datosusuarios.NumHijos_du, datosusuarios.IdMunicipionatural, datosusuarios.IdDepartamentonatural_du, datosusuarios.IdMunicipioprocedente_du, datosusuarios.IdDepartamentoprocedente_du, datosusuarios.idzonares_du, datosusuarios.DireccionResidencia_du, datosusuarios.Barrio_du,datosusuarios.idtipoescolaridad_du, datosusuarios.profesion_du, datosusuarios.TelefonoCelular_du, datosusuarios.idocupacion_du, datosusuarios.ideps_du, datosusuarios.idips_du, ingreso.idtipoex_ingreso, ingreso.fechaexa_ingreso, ingreso.idciudadexam_ingreso, ingreso.idempresa_ingreso, ingreso.idtipoindustria_ingreso, ingreso.idjornadatrabajo_ingreso, ingreso.idmedico_ingreso, ingreso.cargoaspira_ingreso, ingreso.descripcioncargo_ingreso, ingreso.elemguantes_ingreso, ingreso.elemrespi_ingreso, ingreso.elemauditiva_ingreso, ingreso.elemvisual_ingreso, ingreso.elemotros_ingreso, ingreso.descrotros_ingreso,ingreso.observacion_ingreso,ingreso.horaentrada_ingreso,datosusuarios.foto_du FROM datosusuarios INNER JOIN ingreso ON datosusuarios.NoHC_du = ingreso.NoHC_ingreso WHERE datosusuarios.NoHC_du="+"'"+(String)modelomedico.getValueAt(JTMedico.getSelectedRow(),0) +"'";
        //cadenamedicosql="select *from datosusuarios where NoHC_du="+"'"+modelomedico.getValueAt(JTMedico.getSelectedRow(),0) +"'";
            try{
               TSentenciamedico=con2.createStatement();
               Rconsulta=TSentenciamedico.executeQuery(cadenamedicosql);
               llenarpanelingresomedico(Rconsulta);
             /*bloquearingr();
             /*frameboton=(FrameHistoriasClinicas)frameboton.objppal;
             frameboton.JBModificar.setEnabled(true);
             frameboton.JBActualizar.setEnabled(true);*/
             //JBModificar
           }//cierra el try
           catch(SQLException e1){
             e1.getMessage();
             cad1="NO SE PUDO EJECUTAR LA CONSULTA";
             cad2="ERROR CONSULTA MEDICO";
             varframemedico.mensajeconfirmacion(cad1,cad2);
           }//cierra el catch

        }
        else{

        }

   }

    /**
     * llenarpanelingresomedico
     */
    public void llenarpanelingresomedico(ResultSet Rconsulta) {
        CIngreso frameIngresoUsuario ;
        JDesktopPane JDPIngreso;
        JDPIngreso=(JDesktopPane)objjdpmedico;
        frameIngresoUsuario= new  CIngreso(JDPIngreso);
        frameIngresoUsuario.setBounds(0, 2, 1010, 600);
        frameIngresoUsuario.setTitle("INGRESO");
        JDPIngreso.add(frameIngresoUsuario, new Integer(1));
        frameIngresoUsuario.setLocation(5, 55);
        frameIngresoUsuario.show();
        //frameIngresoUsuario.inicioventana(frameIngresoUsuario);
        frameIngresoUsuario.setVisible(true);
        frameIngresoUsuario.llenarpanelingreso(Rconsulta);
        frameIngresoUsuario.JFTNumIngr.setText(numingrmedico); //frameIngresoUsuario.obotguardar
//        frameIngresoUsuario.JBguardarIng.setEnabled(false);
        this.dispose();
    }
    public void JTMedico_keyTyped(KeyEvent e) {

    }

}


class CFrameMedico_JTMedico_mouseAdapter extends MouseAdapter {
    private CFrameMedico adaptee;
    CFrameMedico_JTMedico_mouseAdapter(CFrameMedico adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseReleased(MouseEvent e) {
        adaptee.JTMedico_mouseReleased(e);
    }
}
