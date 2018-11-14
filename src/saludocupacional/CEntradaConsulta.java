package saludocupacional;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import java.awt.Font;
import java.util.Map;
import java.util.HashMap;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import javax.swing.ImageIcon;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JRException;

public class CEntradaConsulta extends JInternalFrame {

    Object objppalec;
    Object objdesktop;
    Object objguardar;
    Object objnuevo;
    Object objmodificar;
    Object objactualizar;
    Object objborrar;
    CIngreso frameIngresoUsuario;
    int swedicionconsulta;
    ImageIcon m;
    byte[] imagimpr;
    ValidarComponentes objvalidarEC = new ValidarComponentes();
    String cad1;
    String cad2;
    Object vlorident;
    ConexionSql Conxentrada = new ConexionSql();
    public Statement Tentradaconsulta;
    public ResultSet Rentrada;
    JPanel JPEntradaConsulta = new JPanel();
    JRadioButton JRCodBarras = new JRadioButton();
    JRadioButton JRNombreProd = new JRadioButton();
    JFormattedTextField JFTCodBarrasConsulta = new JFormattedTextField();
    JFormattedTextField JFTSuminNombre = new JFormattedTextField();
    JScrollPane JSPConsultaSum = new JScrollPane();
    CModeloReimprimir modeloreimprimir = new CModeloReimprimir();
    JTable JTConsultaEntradaSuministro = new JTable(modeloreimprimir);

    public CEntradaConsulta(int swedicion, JDesktopPane JDPIngreso, JButton JBGuardar, JButton JBNuevo, JButton JBModificar, JButton JBActualizar, JButton JBBorrar, Object objframeppal) {
        try {
            swedicionconsulta = swedicion;
            objdesktop = JDPIngreso;
            objguardar = JBGuardar;
            objnuevo = JBNuevo;
            objmodificar = JBModificar;
            objactualizar = JBActualizar;
            objborrar = JBBorrar;
            objppalec = objframeppal;
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setClosable(true);
        this.setIconifiable(true);
        this.setMaximizable(true);
        this.setResizable(true);
        this.setVisible(true);
        this.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(SystemColor.menu);
        this.setForeground(Color.red);
        JPEntradaConsulta.setBackground(new Color(227, 234, 0));
        JPEntradaConsulta.setBounds(new Rectangle(2, 3, 1053, 888));
        JPEntradaConsulta.setLayout(null);
        JRCodBarras.setBackground(new Color(0, 255, 154));
        JRCodBarras.setFont(new java.awt.Font("Arial Rounded MT Bold",
                Font.BOLD, 14));
        JRCodBarras.setBorder(BorderFactory.createRaisedBevelBorder());
        JRCodBarras.setText("N# IDENTIFICACION");
        JRCodBarras.setBounds(new Rectangle(2, 7, 198, 29));
        JRNombreProd.setBackground(new Color(0, 255, 154));
        JRNombreProd.setFont(new java.awt.Font("Arial Rounded MT Bold",
                Font.BOLD, 14));
        JRNombreProd.setBorder(BorderFactory.createRaisedBevelBorder());
        JRNombreProd.setToolTipText("");
        JRNombreProd.setText("PRIMER APELLIDO");
        JRNombreProd.setBounds(new Rectangle(3, 44, 196, 29));
        JFTCodBarrasConsulta.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTCodBarrasConsulta.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTCodBarrasConsulta.setToolTipText("");
        JFTCodBarrasConsulta.setBounds(new Rectangle(218, 7, 184, 30));
        JFTCodBarrasConsulta.addKeyListener(new CEntradaConsulta_JFTCodBarrasConsulta_keyAdapter(this));
        JFTSuminNombre.setFont(new java.awt.Font("Arial", Font.BOLD, 12));
        JFTSuminNombre.setBorder(BorderFactory.createRaisedBevelBorder());
        JFTSuminNombre.setToolTipText("");
        JFTSuminNombre.setBounds(new Rectangle(218, 46, 184, 30));
        JFTSuminNombre.addKeyListener(new CEntradaConsulta_JFTSuminNombre_keyAdapter(this));
        JFTSuminNombre.addActionListener(new CEntradaConsulta_JFTSuminNombre_actionAdapter(this));
        JSPConsultaSum.getViewport().setBackground(new Color(176, 255, 0));
        JSPConsultaSum.setFont(new java.awt.Font("Arial Narrow", Font.BOLD, 12));
        JSPConsultaSum.setBorder(BorderFactory.createRaisedBevelBorder());
        JSPConsultaSum.setBounds(new Rectangle(2, 94, 1046, 547));
        JTConsultaEntradaSuministro.setFont(new java.awt.Font(
                "Arial Unicode MS", Font.BOLD, 12));
        JTConsultaEntradaSuministro.addKeyListener(new CEntradaConsulta_JTConsultaEntradaSuministro_keyAdapter(this));
        JTConsultaEntradaSuministro.addMouseListener(new CEntradaConsulta_JTConsultaEntradaSuministro_mouseAdapter(this));
        this.getContentPane().add(JPEntradaConsulta);
        JPEntradaConsulta.add(JRCodBarras);
        JPEntradaConsulta.add(JRNombreProd);
        JPEntradaConsulta.add(JFTSuminNombre);
        JPEntradaConsulta.add(JFTCodBarrasConsulta);
        JPEntradaConsulta.add(JSPConsultaSum);
        JSPConsultaSum.getViewport().add(JTConsultaEntradaSuministro);
    }

    public void JFTSuminNombre_actionPerformed(ActionEvent e) {

    }

    public void JFTSuminNombre_keyReleased(KeyEvent e) {
        borrarmodeloentradaconsulta();
        ResultSet Rvarconsulta;
        int j = 0;
        Rvarconsulta = consultaapell(JFTSuminNombre.getText());
        procesocomunconsultaentrada(Rvarconsulta, j);

    }

    /**
     * consultaapell
     */
    public ResultSet consultaapell(String primapell) {
        String cadenaentrada;
        Rentrada = null;
        cadenaentrada = "SELECT datosusuarios.NoHC_du, datosusuarios.PrimerApellido_du, datosusuarios.SegundoApellido_du, datosusuarios.PrimerNombre_du, datosusuarios.SegundoNombre_du, empresa.nombre_empresa, tipo_examen.nombre_TE, ingreso.fechaexa_ingreso,ingreso.id_ingreso "
                + "FROM tipo_examen "
                + "INNER JOIN (empresa INNER JOIN (datosusuarios INNER JOIN ingreso ON datosusuarios.NoHC_du = ingreso.NoHC_ingreso) ON empresa.id_empresa = ingreso.idempresa_ingreso) ON tipo_examen.idtipo_TE = ingreso.idtipoex_ingreso WHERE (((datosusuarios.PrimerApellido_du) REGEXP " + "'^" + primapell + "'and ingreso.anulado_ingreso=" + 0 + ")) ORDER BY datosusuarios.PrimerApellido_du;";
        Connection con2 = Conxentrada.getConnection();
        try {
            Tentradaconsulta = con2.createStatement();
            Rentrada = Tentradaconsulta.executeQuery(cadenaentrada);
        } catch (Exception ex) {
            System.out.println("PROBLEMA EN LA CONSULTA DE LA ENTRADA CONSULTA:");
            ex.printStackTrace();
        }
        return Rentrada;

    }

    /**
     * procesocomunconsultaentrada
     */
    public void procesocomunconsultaentrada(ResultSet Rvarconsulta, int j) {
        CBaseReimprimir dato = new CBaseReimprimir();
        try {
            while (Rvarconsulta.next()) {
                dato.tomanumident(Rvarconsulta.getString(1));
                dato.tomaprimapell(Rvarconsulta.getString(2));
                dato.tomasdoapell(Rvarconsulta.getString(3));
                dato.tomaprimnombr(Rvarconsulta.getString(4));
                dato.tomasgdonombr(Rvarconsulta.getString(5));
                dato.tomanombrempresa(Rvarconsulta.getString(6));
                dato.tomatipoexamen(Rvarconsulta.getString(7));
                dato.tomafechaultexamen(Rvarconsulta.getString(8));
                dato.tomanumingreso(Rvarconsulta.getString(9));
                modeloreimprimir.anhadereimprimir(new CBaseReimprimir(dato.damenumident(), dato.dameprimapell(), dato.damesdoapell(), dato.dameprimnombr(), dato.damesgdonombr(), dato.damenombrempresa(), dato.dametipoexamen(), dato.damefechaultexamen(), dato.damenumingreso()));
                j = j + 1;
                JTConsultaEntradaSuministro.repaint();
            }//CIERRA EL WHILE
        }//CIERRA EL TRY
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void JFTCodBarrasConsulta_keyReleased(KeyEvent e) {
        borrarmodeloentradaconsulta();
        ResultSet Rvarconsulta;
        int j = 0;
        Rvarconsulta = consultaident(JFTCodBarrasConsulta.getText());
        procesocomunconsultaentrada(Rvarconsulta, j);
    }

    /**
     * borrarmodeloentradaconsulta
     */
    public void borrarmodeloentradaconsulta() {
        int filaconsulta = 0, limite = JTConsultaEntradaSuministro.getRowCount();
        if (JTConsultaEntradaSuministro.getRowCount() > 0) {
            while (filaconsulta < limite) {
                modeloreimprimir.borrareimpr(0);
                filaconsulta = filaconsulta + 1;
            }
            JTConsultaEntradaSuministro.repaint();
        }

    }

    /**
     * consultaident
     */
    public ResultSet consultaident(String identif) {
        String cadenaentrada;
        Rentrada = null;
        cadenaentrada = "SELECT datosusuarios.NoHC_du, datosusuarios.PrimerApellido_du, datosusuarios.SegundoApellido_du, datosusuarios.PrimerNombre_du, datosusuarios.SegundoNombre_du, empresa.nombre_empresa, tipo_examen.nombre_TE, ingreso.fechaexa_ingreso,ingreso.id_ingreso FROM tipo_examen INNER JOIN (empresa INNER JOIN (datosusuarios INNER JOIN ingreso ON datosusuarios.NoHC_du = ingreso.NoHC_ingreso) ON empresa.id_empresa = ingreso.idempresa_ingreso) ON tipo_examen.idtipo_TE = ingreso.idtipoex_ingreso WHERE (((datosusuarios.NoHC_du) REGEXP " + "'^" + identif + "'and ingreso.anulado_ingreso=" + 0 + ")) ORDER BY datosusuarios.NoHC_du;";
        Connection con2 = Conxentrada.getConnection();
        try {
            Tentradaconsulta = con2.createStatement();
            Rentrada = Tentradaconsulta.executeQuery(cadenaentrada);
        } catch (Exception ex) {
            cad1 = "REVISE LA CONFIABILIDAD DE LOS DATOS GUARDADOS";
            cad2 = "ERROR CONSULTA INGRESO";
            objvalidarEC.mensajeconfirmacion(cad1, cad2);
        }
        return Rentrada;

    }

    public void JTConsultaEntradaSuministro_mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            if (swedicionconsulta == 0) {
                String sident, cadenaentrada;
                vlorident = modeloreimprimir.getValueAt(JTConsultaEntradaSuministro.getSelectedRow(), 8);
                sident = (String) vlorident;
                cadenaentrada = "SELECT datosusuarios.NoHC_du, datosusuarios.PrimerApellido_du, datosusuarios.SegundoApellido_du, datosusuarios.PrimerNombre_du, datosusuarios.SegundoNombre_du, datosusuarios.IdSexo_du, datosusuarios.FechadeNacimiento_du, datosusuarios.edad_du, barrio.Nbre_Barrio, datosusuarios.DireccionResidencia_du, datosusuarios.TelefonoCelular_du, empresa.nombre_empresa, tipo_industria.nombre_tindustria, tipo_examen.nombre_TE, ingreso.fechaexa_ingreso, ingreso.horaentrada_ingreso, ingreso.horasalida_ingreso, ocupacion.Nbre_Ocupacion, paraclinicos.espiro_examparacl, paraclinicos.visio_examparacl, paraclinicos.audio_examparacl, paraclinicos.hematico_examparacl, paraclinicos.otros_examparacli, paraclinicos.quimica_examparacl, paraclinicos.electrocardiograma_examparacl, paraclinicos.observacion_examppracli, resocupacional.aptocargo_resocup, resocupacional.aptorestr_resocup, resocupacional.aplazado_resocup, resocupacional.noapto_resocup, resocupacional.motivo_resocup, resocupacional.recomendaciones__resocup, resocupacional.uso_resocup, resocupacional.remision_resocup, resocupacional.reasignacion_resocup, resocupacional.ingreso_resocup, resocupacional.tratamiento_resocup, resocupacional.fisica_resocup, resocupacional.fumar_resocup, resocupacional.alcohol_resocup, resocupacional.peso_resocup, datosusuarios.foto_du, ingreso.id_ingreso FROM tipo_industria INNER JOIN (tipo_examen INNER JOIN (((ocupacion INNER JOIN (empresa INNER JOIN ((barrio INNER JOIN datosusuarios ON barrio.Id_Barrio = datosusuarios.Barrio_du) INNER JOIN ingreso ON datosusuarios.NoHC_du = ingreso.NoHC_ingreso) ON empresa.id_empresa = ingreso.idempresa_ingreso) ON ocupacion.Id_Ocupacion = ingreso.cargoaspira_ingreso) INNER JOIN paraclinicos ON ingreso.id_ingreso = paraclinicos.idingreso_examparacl) INNER JOIN resocupacional ON ingreso.id_ingreso = resocupacional.idingreso_resocup) ON tipo_examen.idtipo_TE = ingreso.idtipoex_ingreso) ON tipo_industria.id_tindustria = ingreso.idtipoindustria_ingreso WHERE (((ingreso.id_ingreso)='" + sident + "'))";
                Connection con2 = Conxentrada.getConnection();
                try {
                    Tentradaconsulta = con2.createStatement();
                    Rentrada = Tentradaconsulta.executeQuery(cadenaentrada);
                    llenarreporte(Rentrada);
                }//fin del try
                catch (Exception ex) {
                    cad1 = "REVISE LA CONFIABILIDAD DE LOS DATOS GUARDADOS";
                    cad2 = "ERROR DATOS USUARIOS";
                    objvalidarEC.mensajeconfirmacion(cad1, cad2);
                }//fin del catch
            }//fin del if
            else if (swedicionconsulta == 1) {
                String sident, cadenaentrada;
                vlorident = modeloreimprimir.getValueAt(JTConsultaEntradaSuministro.getSelectedRow(), 8);
                sident = (String) vlorident;
                cadenaentrada = "SELECT datosusuarios.NoHC_du, datosusuarios.Documento_du, datosusuarios.PrimerApellido_du, datosusuarios.SegundoApellido_du, datosusuarios.PrimerNombre_du, datosusuarios.SegundoNombre_du, datosusuarios.FechadeNacimiento_du, datosusuarios.idtipoedad_du, datosusuarios.edad_du, datosusuarios.IdSexo_du, datosusuarios.IdEstadoCivi_du, datosusuarios.NumHijos_du, datosusuarios.IdMunicipionatural, datosusuarios.IdDepartamentonatural_du, datosusuarios.IdMunicipioprocedente_du, datosusuarios.IdDepartamentoprocedente_du, datosusuarios.idzonares_du, datosusuarios.DireccionResidencia_du, datosusuarios.Barrio_du,datosusuarios.idtipoescolaridad_du, datosusuarios.profesion_du, datosusuarios.TelefonoCelular_du, datosusuarios.idocupacion_du, datosusuarios.ideps_du, datosusuarios.idips_du, ingreso.idtipoex_ingreso, ingreso.fechaexa_ingreso, ingreso.idciudadexam_ingreso, ingreso.idempresa_ingreso, ingreso.idtipoindustria_ingreso, ingreso.idjornadatrabajo_ingreso, ingreso.idmedico_ingreso, ingreso.cargoaspira_ingreso, ingreso.descripcioncargo_ingreso, ingreso.elemguantes_ingreso, ingreso.elemrespi_ingreso, ingreso.elemauditiva_ingreso, ingreso.elemvisual_ingreso, ingreso.elemotros_ingreso, ingreso.descrotros_ingreso,ingreso.observacion_ingreso,ingreso.horaentrada_ingreso,datosusuarios.foto_du FROM datosusuarios INNER JOIN ingreso ON datosusuarios.NoHC_du = ingreso.NoHC_ingreso WHERE ingreso.id_ingreso=" + "'" + sident + "'";
                this.dispose();
                JDesktopPane JDPIngreso = new JDesktopPane();
                JDPIngreso = (JDesktopPane) objdesktop;
                JButton JBGuardar = new JButton();
                JBGuardar = (JButton) objguardar;
                JButton JBBorrar = new JButton();
                JBBorrar = (JButton) objborrar;
                JButton JBNuevo = new JButton();
                JBNuevo = (JButton) objnuevo;
                JButton JBModificar = new JButton();
                JBModificar = (JButton) objmodificar;
                JButton JBActualizar = new JButton();
                JBActualizar = (JButton) objactualizar;
                frameIngresoUsuario = new CIngreso(sident, swedicionconsulta, JBGuardar, JBNuevo, JBModificar, JBActualizar, JBBorrar, JDPIngreso, objppalec);
                frameIngresoUsuario.setBounds(0, 2, 1010, 600);
                frameIngresoUsuario.setTitle("INGRESO");
                JDPIngreso.add(frameIngresoUsuario, new Integer(1));
                frameIngresoUsuario.setLocation(5, 55);
                frameIngresoUsuario.show();
                frameIngresoUsuario.setVisible(true);
                JBNuevo.setEnabled(false);
                JBModificar.setEnabled(false);
                JBActualizar.setEnabled(false);
                JBBorrar.setEnabled(false);
                JBGuardar.setEnabled(false);
                Connection con2 = Conxentrada.getConnection();
                try {
                    Tentradaconsulta = con2.createStatement();
                    Rentrada = Tentradaconsulta.executeQuery(cadenaentrada);
                    frameIngresoUsuario.llenarpanelingreso(Rentrada);
                    frameIngresoUsuario.bloquearingr();
                    frameIngresoUsuario.JBFoto.setEnabled(true);
                    //frameIngresoUsuario.
                }//cierra el try
                catch (SQLException e1) {
                    e1.getMessage();
                    cad1 = "NO SE PUDO EJECUTAR LA CONSULTA";
                    cad2 = "PROBLEMAS CON LOS DATOS DEL USUARIO E INGRESO DE EDICION";
                    objvalidarEC.mensajeconfirmacion(cad1, cad2);
                }//cierra el catch
            }//FIN DEL IF swedicionconsulta==1
            else {
                String rutahocupacion;
                Integer pingr;
                int intpingr = 0;
                String sident, cadenaentrada, usuario, cedula, sexo, edad, ecivil, mnatural, dptonatural, barrio, dir, telef, pescolaridad;
                String pprofesion, empresa, examen, fechaatencion, actividad, ciudadinicio, pdescripcioncargo, cargo, pguantes = "", pprotccresp = "", paudio = "", pvisual = "", otros = "", potros;
                vlorident = modeloreimprimir.getValueAt(JTConsultaEntradaSuministro.getSelectedRow(), 8);
                sident = (String) vlorident;
                pingr = new Integer(sident);
                intpingr = pingr.intValue();
                this.dispose();
                cadenaentrada = "SELECT datosusuarios.NoHC_du, datosusuarios.PrimerApellido_du, datosusuarios.SegundoApellido_du, datosusuarios.PrimerNombre_du, datosusuarios.SegundoNombre_du, datosusuarios.edad_du, sexo.Nbre_Sexo, estadocivil.Nbre_EstadoCivil, datosusuarios.IdMunicipionatural, municipio.Nbre_Municipio, datosusuarios.IdDepartamentonatural_du, departamento.Nbre_Departamento, barrio.Nbre_Barrio, datosusuarios.DireccionResidencia_du, datosusuarios.TelefonoCelular_du, escolaridad.nombre_es, profesionales.nombre_pro, ingreso.id_ingreso, tipo_examen.nombre_TE, ingreso.fechaexa_ingreso, empresa.nombre_empresa, ingreso.descripcioncargo_ingreso, ocupacion.Nbre_Ocupacion, jornada_trabajo.nombrejornada_jtrabajo, ingreso.elemguantes_ingreso, ingreso.elemrespi_ingreso, ingreso.elemauditiva_ingreso, ingreso.elemvisual_ingreso, ingreso.elemotros_ingreso, ingreso.descrotros_ingreso, datosusuarios.foto_du,tipo_industria.nombre_tindustria FROM (jornada_trabajo INNER JOIN (ocupacion INNER JOIN (medicos_tratantes INNER JOIN (tipo_examen INNER JOIN (profesionales INNER JOIN (escolaridad INNER JOIN (barrio INNER JOIN (municipio INNER JOIN (departamento INNER JOIN (sexo INNER JOIN (estadocivil INNER JOIN (empresa INNER JOIN (datosusuarios INNER JOIN ingreso ON datosusuarios.NoHC_du = ingreso.NoHC_ingreso) ON empresa.id_empresa = ingreso.idempresa_ingreso) ON estadocivil.Id_EstadoCivil = datosusuarios.IdEstadoCivi_du) ON sexo.Id_Sexo = datosusuarios.IdSexo_du) ON departamento.Id_Departamento = datosusuarios.IdDepartamentonatural_du) ON municipio.Id_Municipio = datosusuarios.IdMunicipionatural) ON barrio.Id_Barrio = datosusuarios.Barrio_du) ON escolaridad.idescolaridad_es = datosusuarios.idtipoescolaridad_du) ON profesionales.idpro_pro = datosusuarios.profesion_du) ON tipo_examen.idtipo_TE = ingreso.idtipoex_ingreso) ON medicos_tratantes.id_medtrat = ingreso.idmedico_ingreso) ON ocupacion.Id_Ocupacion = ingreso.cargoaspira_ingreso) ON jornada_trabajo.idjornada_jtrabajo = ingreso.idjornadatrabajo_ingreso) INNER JOIN tipo_industria ON ingreso.idtipoindustria_ingreso = tipo_industria.id_tindustria WHERE ingreso.id_ingreso='" + sident + "'";
                Connection con2 = Conxentrada.getConnection();
                rutahocupacion = "C:\\SALUD_OCUPACIONAL\\reportes\\";
                rutahocupacion = rutahocupacion.concat("H-OCUPACIONAL.jasper");
                try {
                    Tentradaconsulta = con2.createStatement();
                    Rentrada = Tentradaconsulta.executeQuery(cadenaentrada);
                    Rentrada.next();
                    usuario = Rentrada.getString(4);
                    usuario = usuario.concat(" ");
                    usuario = usuario.concat(Rentrada.getString(5));
                    usuario = usuario.concat(" ");
                    usuario = usuario.concat(Rentrada.getString(2));
                    usuario = usuario.concat(" ");
                    usuario = usuario.concat(Rentrada.getString(3));
                    cedula = Rentrada.getString(1);
                    sexo = Rentrada.getString(7);
                    edad = Rentrada.getString(6);
                    ecivil = Rentrada.getString(8);
                    mnatural = Rentrada.getString(10);
                    dptonatural = Rentrada.getString(12);
                    barrio = Rentrada.getString(13);
                    dir = Rentrada.getString(14);
                    telef = Rentrada.getString(15);
                    pescolaridad = Rentrada.getString(16);
                    pprofesion = Rentrada.getString(17);
                    examen = Rentrada.getString(19);
                    fechaatencion = Rentrada.getString(20);
                    empresa = Rentrada.getString(21);
                    actividad = Rentrada.getString(32);
                    ciudadinicio = "CARTAGENA";
                    cargo = Rentrada.getString(23);
                    pdescripcioncargo = Rentrada.getString(22);
                    if (Rentrada.getInt(25) == 1) {
                        pguantes = "X";
                    }
                    if (Rentrada.getInt(26) == 1) {
                        pprotccresp = "X";
                    }
                    if (Rentrada.getInt(27) == 1) {
                        paudio = "X";
                    }
                    if (Rentrada.getInt(28) == 1) {
                        pvisual = "X";
                    }
                    if (Rentrada.getInt(29) == 1) {
                        otros = "X";
                    }
                    potros = Rentrada.getString(30);
                    InputStream fis = new ByteArrayInputStream(Rentrada.getBytes(31));
                    //frameIngresoUsuario.
                    try {
                        Map parametro = new HashMap();
                        parametro.put("usuario", usuario);
                        parametro.put("cedula", cedula);
                        parametro.put("sexo", sexo);
                        parametro.put("edad", edad);
                        parametro.put("ecivil", ecivil);
                        parametro.put("mnatural", mnatural);
                        parametro.put("dptonatural", dptonatural);
                        parametro.put("barrio", dptonatural);
                        parametro.put("dir", dir);
                        parametro.put("telef", telef);
                        parametro.put("pescolaridad", pescolaridad);
                        parametro.put("pprofesion", pprofesion);
                        parametro.put("empresa", empresa);
                        parametro.put("actividad", actividad);
                        parametro.put("examen", examen);
                        parametro.put("fechaatencion", fechaatencion);
                        parametro.put("ciudadinicio", ciudadinicio);
                        parametro.put("actividad", actividad);
                        parametro.put("pguantes", pguantes);
                        parametro.put("pprotccresp", pprotccresp);
                        parametro.put("paudio", paudio);
                        parametro.put("pvisual", pvisual);
                        parametro.put("otros", otros);
                        parametro.put("potros", potros);
                        parametro.put("foto", fis);
                        parametro.put("pingr", intpingr);

                        JasperPrint imprimir = JasperFillManager.fillReport(rutahocupacion, parametro, con2);
                        // JasperPrintManager.printReport( imprimir, true);
                        JasperViewer vista = new JasperViewer(imprimir, false);
                        vista.setVisible(true);
                        // Boolean vlrergon_ingfr=new Boolean(true);
                        // String pergon=new String("Z");
                        //pergon= vlrergon_ingfr.equals(new Boolean(true)) ? "X" : "Y";

                    }//cierra try reporte
                    catch (JRException j) {
                        System.out.println("YERLIS impr:" + j.getMessage());
                        cad1 = j.getLocalizedMessage();
                        cad2 = "PROBLEMAS AL IMPRIMIR EL REPORTE HISTORIA CLINICA OCUPACIONAL";
                        objvalidarEC.mensajeconfirmacion(cad1, cad2);
                    }//CIERRA CATCH DE IMPRIMIR

                }//cierra el try sql
                catch (SQLException e1) {
                    e1.getMessage();
                    cad1 = "NO SE PUDO EJECUTAR LA CONSULTA";
                    cad2 = "PROBLEMAS CONSULTA HISTORIA CLINICA OCUPACIONAL";
                    objvalidarEC.mensajeconfirmacion(cad1, cad2);
                }//cierra el catch
            } //fin del else swedicionconsulta==1//FIN DEL ELSE DE EDICION

        }//fin del if dobleclick

    }

    /**
     * llenarreporte
     */
    public void llenarreporte(ResultSet Rvarconsulta) {
        try {
            while (Rvarconsulta.next()) {
                if (Rvarconsulta.getString(14).compareTo("INGRESO") == 0 || Rvarconsulta.getString(14).compareTo("INGRESO OSTEOMUSCULAR") == 0 || Rvarconsulta.getString(14).compareTo("INGRESO CON ENFASIS EN ALTURA") == 0 || Rvarconsulta.getString(14).compareTo("REINGRESO") == 0) {
                    imprimirexingreso(Rvarconsulta);
                } else {
                    if (Rvarconsulta.getString(14).compareTo("RETIRO") == 0) {
                        imprimirretiro(Rvarconsulta);
                    } else {
                        if (Rvarconsulta.getString(14).compareTo("PERIODICO") == 0) {
                            imprimirperiodico(Rvarconsulta);
                        }
                    }
                }
            }//CIERRA EL WHILE
        }//CIERRA EL TRY
        catch (Exception ex) {
            cad1 = "ALGUN DATO DEL REPORTE NO ESTA CORRECTO";
            cad2 = "ERROR REPORTES";
            objvalidarEC.mensajeconfirmacion(cad1, cad2);
        }
    }

    /**
     * imprimirexingreso
     */
    public void imprimirexingreso(ResultSet Rvarconsulta) {
        String rutingreso;
        rutingreso = "C:\\SALUD_OCUPACIONAL\\reportes\\EXINGRESO.jasper";
        procesocomunimpr(rutingreso, Rvarconsulta);

    }

    /**
     * imprimirretiro
     */
    public void imprimirretiro(ResultSet Rvarconsulta) {
        String rutaretiro;
        rutaretiro = "C:\\SALUD_OCUPACIONAL\\reportes\\EXRETIRO.jasper";
        procesocomunimpr(rutaretiro, Rvarconsulta);

    }

    /**
     * imprimirperiodico
     */
    public void imprimirperiodico(ResultSet Rvarconsulta) {
        String rutaperiodico;
        rutaperiodico = "C:\\SALUD_OCUPACIONAL\\reportes\\PERIODICO.jasper";
        procesocomunimpr(rutaperiodico, Rvarconsulta);

    }

    /**
     * procesocomunimpr
     */
    public void procesocomunimpr(String ruta, ResultSet Rvarconsulta) {
        String archivoreporte = ruta;
        String varepp = "", varalcohol = "", varfumar = "", varsvs = "", varpeso = "", vareps = "", vartarea = "", vartratamiento = "", varfisica = "", varespiro = "", varvisio = "", varaudio = "", varelectro = "", varquimica = "", varotroscheck = "", nombre, cargo, varapto = "", varnoapto = "", varaptolimitado = "", varaplazado = "", caddia = "", cadmes = "", cadano = "";
        Connection con3 = Conxentrada.getConnection();
        try {
            //InputStream fis = new ByteArrayInputStream(leerimagen(Rvarconsulta.getBytes(42)));
            InputStream fis = new ByteArrayInputStream(Rvarconsulta.getBytes(42));
            nombre = Rvarconsulta.getString(4);
            nombre = nombre.concat(" ");
            nombre = nombre.concat(Rvarconsulta.getString(5));
            nombre = nombre.concat(" ");
            nombre = nombre.concat(Rvarconsulta.getString(2));
            nombre = nombre.concat(" ");
            nombre = nombre.concat(Rvarconsulta.getString(3));
            cargo = Rvarconsulta.getString(18);
            if (Rvarconsulta.getInt(27) == 1) {
                varapto = "X";
            }
            if (Rvarconsulta.getInt(30) == 1) {
                varnoapto = "X";
            }
            if (Rvarconsulta.getInt(28) == 1) {
                varaptolimitado = "X";
            }
            if (Rvarconsulta.getInt(29) == 1) {
                varaplazado = "X";
            }
            if (Rvarconsulta.getInt(19) == 1) {
                varespiro = "X";
            }
            if (Rvarconsulta.getInt(20) == 1) {
                varvisio = "X";
            }
            if (Rvarconsulta.getInt(21) == 1) {
                varaudio = "X";
            }

            if (Rvarconsulta.getInt(25) == 1) {
                varelectro = "X";
            }
            if (Rvarconsulta.getInt(24) == 1) {
                varquimica = "X";
            }
            if (Rvarconsulta.getInt(23) == 1) {
                varotroscheck = "X";
            }
            if (Rvarconsulta.getInt(33) == 1) {
                varepp = "X";
            }
            if (Rvarconsulta.getInt(34) == 1) {
                vareps = "X";
            }
            if (Rvarconsulta.getInt(35) == 1) {
                vartarea = "X";
            }
            if (Rvarconsulta.getInt(37) == 1) {
                vartratamiento = "X";
            }
            if (Rvarconsulta.getInt(38) == 1) {
                varfisica = "X";
            }
            if (Rvarconsulta.getInt(39) == 1) {
                varfumar = "X";
            }
            if (Rvarconsulta.getInt(41) == 1) {
                varpeso = "X";
            }
            if (Rvarconsulta.getInt(36) == 1) {
                varsvs = "X";
            }
            if (Rvarconsulta.getInt(40) == 1) {
                varalcohol = "X";
            }
            int var = 0;
            Map parametro = new HashMap();
            parametro.put("usuario", nombre);
            parametro.put("cedula", Rvarconsulta.getString(1));
            parametro.put("sexo", Rvarconsulta.getString(6));
            parametro.put("fechanac", Rvarconsulta.getString(7));
            parametro.put("edad", Rvarconsulta.getString(8));
            parametro.put("barrio", Rvarconsulta.getString(9));
            parametro.put("dir", Rvarconsulta.getString(10));
            parametro.put("telef", Rvarconsulta.getString(11));
            parametro.put("empresa", Rvarconsulta.getString(12));
            parametro.put("actividad", Rvarconsulta.getString(13));
            parametro.put("examen", Rvarconsulta.getString(14));
            parametro.put("orden", "");
            parametro.put("fechaatencion", Rvarconsulta.getString(15));
            parametro.put("fechasalid", Rvarconsulta.getString(15));
            parametro.put("hora_atencion", Rvarconsulta.getString(16));
            parametro.put("horasalida", Rvarconsulta.getString(17));
            parametro.put("cargo", cargo);
            parametro.put("ciudadinicio", "CARTAGENA");
            parametro.put("espiro", varespiro);
            parametro.put("visio", varvisio);
            parametro.put("audio", varaudio);
            parametro.put("electro", varelectro);
            parametro.put("quimica", varquimica);
            parametro.put("otroscheck", varotroscheck);
            parametro.put("otros", Rvarconsulta.getString(26));
            parametro.put("epp", varepp);
            parametro.put("eps", vareps);
            parametro.put("tarea", vartarea);
            parametro.put("tratamiento", vartratamiento);
            parametro.put("fisica", varfisica);
            parametro.put("fumar", varfumar);
            parametro.put("peso", varpeso);
            parametro.put("svs", varsvs);
            parametro.put("alcohol", varalcohol);
            parametro.put("concp1", varapto);
            parametro.put("concpt2", varnoapto);
            parametro.put("concpt3", varaptolimitado);
            parametro.put("concpt4", varaplazado);
            parametro.put("recom", Rvarconsulta.getString(32));
            parametro.put("ciudadinicio", "CARTAGENA");
            parametro.put("restrincciones", Rvarconsulta.getString(31));
            parametro.put("foto", fis);
            if (Rvarconsulta.getString(12).compareTo("PARTICULAR") == 0 || Rvarconsulta.getString(12).compareTo("EXPLORASUR") == 0) {
                parametro.put("profesional", "REYNALDO VASQUEZ VIANA");
                parametro.put("titulo1", "Medico y Cirujano Especialista en Salud Ocupacional");
                parametro.put("titulo2", "Universidad de Cartagena");
            } else {
                parametro.put("profesional", "");
                System.out.println("MONICA ");
            }
            parametro.put("rm", "232/90");
            parametro.put("licencia", "SO:0768 SSB");
            JasperPrint imprimir = JasperFillManager.fillReport(archivoreporte, parametro, con3);
            // JasperPrintManager.printReport( imprimir, true);
            JasperViewer vista = new JasperViewer(imprimir, false);
            vista.setVisible(true);
            // System.out.println("ceci impr");

        }//fin del try
        catch (Exception ex) {
            System.out.println("CONSUELO impr: " + ex.getMessage());
            cad1 = "ALGUN DATO DEL REPORTE NO ESTA CORRECTO";
            cad2 = "ERROR LLENADO REPORTES";
            objvalidarEC.mensajeconfirmacion(cad1, cad2);
        }

        Conxentrada.CerrarConexion();
    }

    //
    public ImageIcon leerimagen(byte[] i) throws SQLException {
        // ImageIcon m = new ImageIcon();
        imagimpr = i;
        m = new ImageIcon(i);

        // System.out.println("rosiris:"+m);
        return m;
    }

    public void JTConsultaEntradaSuministro_keyTyped(KeyEvent e) {

    }

    public void JTConsultaEntradaSuministro_keyPressed(KeyEvent e) {

    }

}//fin clase

class CEntradaConsulta_JTConsultaEntradaSuministro_mouseAdapter extends
        MouseAdapter {

    private CEntradaConsulta adaptee;

    CEntradaConsulta_JTConsultaEntradaSuministro_mouseAdapter(CEntradaConsulta adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
        adaptee.JTConsultaEntradaSuministro_mouseClicked(e);
    }
}

class CEntradaConsulta_JTConsultaEntradaSuministro_keyAdapter extends
        KeyAdapter {

    private CEntradaConsulta adaptee;

    CEntradaConsulta_JTConsultaEntradaSuministro_keyAdapter(CEntradaConsulta adaptee) {
        this.adaptee = adaptee;
    }

    public void keyTyped(KeyEvent e) {
        adaptee.JTConsultaEntradaSuministro_keyTyped(e);
    }

    public void keyPressed(KeyEvent e) {
        adaptee.JTConsultaEntradaSuministro_keyPressed(e);
    }
}

class CEntradaConsulta_JFTCodBarrasConsulta_keyAdapter extends KeyAdapter {

    private CEntradaConsulta adaptee;

    CEntradaConsulta_JFTCodBarrasConsulta_keyAdapter(CEntradaConsulta adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JFTCodBarrasConsulta_keyReleased(e);
    }
}

class CEntradaConsulta_JFTSuminNombre_keyAdapter extends KeyAdapter {

    private CEntradaConsulta adaptee;

    CEntradaConsulta_JFTSuminNombre_keyAdapter(CEntradaConsulta adaptee) {
        this.adaptee = adaptee;
    }

    public void keyReleased(KeyEvent e) {
        adaptee.JFTSuminNombre_keyReleased(e);
    }
}

class CEntradaConsulta_JFTSuminNombre_actionAdapter implements ActionListener {

    private CEntradaConsulta adaptee;

    CEntradaConsulta_JFTSuminNombre_actionAdapter(CEntradaConsulta adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.JFTSuminNombre_actionPerformed(e);
    }
}
