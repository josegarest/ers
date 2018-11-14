package saludocupacional;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import javax.swing.*;
//import javax.microedition.xml.rpc.Type;
import javax.swing.text.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
//public interface Document;
public class ValidarComponentes {
    //DECLARACION DE OTRAS VARIABLES

    ConexionSql  conexup;
    // dDECLARACION DE PANELES QUE SE UTILIZAN EN ALGUNOS METODOS
    public static int swguardarsumini=0;
   // public static JIFConfigSuministro framesuministro2;
   // public static JIFEntradas framecrearentrada2;
    public static int filasuministr=999;
    //public static ModeloEntradas modeloentradaobj=new ModeloEntradas();
    public static String nombrsuminist="";
    public static String codbarrsum="";
    public static String presentsum="";
    public static int swfechavalida=0;
    //Ppaljframe objPpalvalidar;
    public  static JInternalFrame objentrada2;
    JOptionPane jOptionPanevalidar = new JOptionPane();
    // DECLARACION DE LAS VARIABLES PARA EL METODO DEL FORMATOFECHA()
    DecimalFormat formatonumero = new DecimalFormat("$###,###.##");
    DecimalFormat formatonumero2 = new DecimalFormat("###,###.##");
    DateFormat formato;
    String sFecha;
    Date hoy=new Date();
    //DECLARACION DE LOS MIEMBROS DEL METODO PARA LLENAR COMBOS
    ConexionSql Conxcelda= new ConexionSql();
    public Statement Tcombooperador;
    public Statement Tverificacodigo;
    public ResultSet Rcombooperador;
    public ResultSet Rverificacodigo;
    String cad1,cad2;
    Object[] Obceldanombreoperador;
    public String [] Obceldanombreoperadordoble;
    public static String[] matlote=new String[50];
    JOptionPane JDValidar = new  JOptionPane();
    public void validarletras(KeyEvent val,Component Objframe) {
       char c = val.getKeyChar();
       if (Character.isLetter(c)!=true ) {
          //getToolkit().beep();
          val.consume();
          String mensaje= "OK";
          Object[] option = {mensaje};
          if  ((c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_DELETE) )
              val.consume();
          else{
             int n= JDValidar.showOptionDialog(Objframe,"SOLO SE ACEPTAN LETRAS ", " " + "",JDValidar.YES_NO_OPTION, JDValidar.QUESTION_MESSAGE,null,option,mensaje);
        }
       }

   }
   public void validarletrasdigitos(KeyEvent val,Component Objframe) {
      char c = val.getKeyChar();
                   if (Character.isLetterOrDigit(c)!=true && Character.isSpaceChar(c)!=true) {
                        //if (Character.isSpaceChar(c)==!true) {
                        //getToolkit().beep();
                           val.consume();
                           String mensaje= "OK";
                           Object[] option = {mensaje};
                           if  ((c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_DELETE) )
                                 val.consume();
                          else{
                              int n= JDValidar.showOptionDialog(Objframe,"SOLO SE ACEPTAN LETRAS Y DIGITOS", " " + "",JDValidar.YES_NO_OPTION, JDValidar.QUESTION_MESSAGE,null,option,mensaje);
                          }
                    }



  }

    public ValidarComponentes() {
    }

    /**
     * formatodoble
     */
    public String formatodoble(String cadenaform) {
        String rcadformato=" ";
        if(cadenaform==null)
            cadenaform="0";
        Double dcadformato=new Double(cadenaform);
        cadenaform=formatonumero2.format(dcadformato);
        rcadformato=cadenaform;
        return rcadformato;

    }

    public void validardigitos(KeyEvent val,Component Objframe) {
        char c = val.getKeyChar();
                     if (Character.isDigit(c)==false) {
                            //getToolkit().beep();
                            val.consume();
                            String mensaje= "OK";
                            Object[] option = {mensaje};
                            if  ((c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_DELETE) )
                                 val.consume();
                            else{
                                int n= JDValidar.showOptionDialog(Objframe,"SOLO SE ACEPTAN  DIGITOS", " " + "",JDValidar.YES_NO_OPTION, JDValidar.QUESTION_MESSAGE,null,option,mensaje);
                             }

                                                 }


    }
    public int validardigitosnuevo(KeyEvent e,JFormattedTextField rr) {e.consume();
        int i=0;
        if(rr.getText().compareTo("")==0){
           System.out.println("matta:"+e.getKeyCode());
           i=1;
        }
        else{
           int val = e.getKeyCode();
         //if (Character.isDigit(val)==true || Character.isSpaceChar(val)==true) {
           if  (val == KeyEvent.VK_0 || val ==KeyEvent.VK_1 || val ==KeyEvent.VK_2 || val ==KeyEvent.VK_3 || val ==KeyEvent.VK_4 || val ==KeyEvent.VK_5 || val ==KeyEvent.VK_6 || val ==KeyEvent.VK_7 || val ==KeyEvent.VK_8 || val ==KeyEvent.VK_9 || val ==KeyEvent.VK_NUMPAD0 || val ==KeyEvent.VK_NUMPAD1 || val ==KeyEvent.VK_NUMPAD2 || val ==KeyEvent.VK_NUMPAD3 || val ==KeyEvent.VK_NUMPAD4 || val ==KeyEvent.VK_NUMPAD5 || val ==KeyEvent.VK_NUMPAD6 || val ==KeyEvent.VK_NUMPAD7 || val ==KeyEvent.VK_NUMPAD8 || val ==KeyEvent.VK_NUMPAD9 || val ==KeyEvent.VK_BACK_SPACE || val ==KeyEvent.VK_DELETE || val ==46 || val ==110){
             i=1;
           }
           else
              rr.setText("");
       }
    return i;
    }

    /**
     * quitarpuntoscadena
     *
     * @return String
     */
    public String quitarpuntoscadena(String cadena) {
          StringBuffer cadenabuff2 = new StringBuffer(cadena);
         cadenabuff2=cadenabuff2.deleteCharAt(0);
         cadena=cadenabuff2.toString();
        int pos;
        pos=buscarcaracter(cadena,'.');
        while (pos!=-1){
            StringBuffer cadenabuff = new StringBuffer(cadena);
            cadenabuff=cadenabuff.deleteCharAt(pos);
            cadena=cadenabuff.toString();
            pos=buscarcaracter(cadena,'.');
        }

     return  cadena;
    }

    /**
     * buscarcaracter
     *
     * @return int
     */
    public int buscarcaracter(String cadena,char car) {
        int poscadena=-1;
        poscadena=cadena.indexOf(car);
        return poscadena;
    }

    /**
     * llenarcombos
     */
    public void llenarcombos(String cadena,JComboBox JCBOperador,int numcolumna) {
        try{
            Connection con2=Conxcelda.getConnection();
            Tcombooperador=con2.createStatement();
            Rcombooperador=Tcombooperador.executeQuery(cadena);
            int n=0;
          while (Rcombooperador.next()){
            n=n+1;
            Obceldanombreoperador= new Object[n];
            Obceldanombreoperador[0]=Rcombooperador.getString(numcolumna);
            JCBOperador.addItem(Obceldanombreoperador[0]);
          }

        }
        catch (Exception ex) {
             ex.printStackTrace();System.out.println("problema en la consulta de llenar combos del modulo de todos los pedidos");
         }
      //  Conxcelda.CerrarConexion();

    }

    /**
     * formatofecha
     */
    public String formatofecha() {
        String patron="yyyy-MM-dd";
        SimpleDateFormat formato2=new SimpleDateFormat(patron);
        formato= DateFormat.getDateInstance();
        sFecha=formato.format(hoy);
        sFecha=formato2.format(hoy);
        return sFecha;

    }

    /**
     * evaluarcomboentero
     */
    public String evaluarcombocadena(JComboBox JCcadena) {
        String rcadena;int resultadoentero;
        rcadena=(String)JCcadena.getSelectedItem();
        System.out.println("turkia:"+rcadena);
        return rcadena;
    }
    // ESTE METODO LE CAMBIA EL FORMATO A LAS FECHAS
    public String cambiarformatofecha(String cadenafecha)  {
       cadenafecha=cadenafecha.replace('/','-');
       String cad1;String cad2; String cad3;StringBuffer cadtemporal=new StringBuffer(cadenafecha);
       cad1=cadenafecha.substring(0,2);
       cad2=cadenafecha.substring(3,5);
       cad3=cadenafecha.substring(6,10);
       cadtemporal=cadtemporal.replace(0,3,cad3);
       cadtemporal=cadtemporal.replace(4,5,"-");
       cadtemporal=cadtemporal.replace(5,6,cad2);
       cadtemporal=cadtemporal.replace(8,10,cad1);
       cadtemporal=cadtemporal.replace(10,14,"   ");
       return cadtemporal.toString();
   }

    /**
     * eliminarblanconfinal
     */
    // ESTE METODO DEVUELVE UN NUMERO ENTERO DESPUES DE RECIBIR UNA CADENA ENTERA CON ESPACIOS EN BLANCO AL FINAL
    public int eliminarblancosfinal(String gcantidad,int longitud) {
        int k,varcantidad;Integer icantidad;
        StringBuffer cadcantidad=new StringBuffer(gcantidad);
        k=cadcantidad.indexOf(" ");
        cadcantidad=cadcantidad.delete(k,longitud);
        gcantidad=cadcantidad.toString();
        icantidad=new Integer(gcantidad);
        varcantidad=icantidad;
        return varcantidad;
    }

    /**
     * llenarcombosenteros
     */
    public void llenarcombosenteros(String cadena,JComboBox JCBOperador,int numcolumna) {
        try{
            Connection con2=Conxcelda.getConnection();
            Tcombooperador=con2.createStatement();
            Rcombooperador=Tcombooperador.executeQuery(cadena);
            int n=0;
          while (Rcombooperador.next()){
            n=n+1;
            Obceldanombreoperador= new Object[n];
            Obceldanombreoperador[0]=Rcombooperador.getInt(numcolumna);
            JCBOperador.addItem(Obceldanombreoperador[0]);
          }

        }
        catch (Exception ex) {
             ex.printStackTrace();System.out.println("problema en la consulta de llenar combos enteros del modulo de todos los pedidos");
         }
        Conxcelda.CerrarConexion();

    }

    /**
     * evaluarcombocadena(JComboBox JCcadena)
     *
     * @return int
     */
    public int evaluarcomboentero(JComboBox JCcadena)  {
        Integer resultadoentero;
        resultadoentero=(Integer)JCcadena.getSelectedItem();
        return resultadoentero.intValue();
    }

    /**
     * verificarcodigo
     */
    public int verificarcodigocadena(String cadenasql) {
           int rcodigo=0;
           Connection con2=Conxcelda.getConnection();
           try{
               Tverificacodigo=con2.createStatement();
               Rverificacodigo=Tverificacodigo.executeQuery(cadenasql);
               Rverificacodigo.next();
               rcodigo=Rverificacodigo.getRow();
           }
           catch (Exception ex) {
                cad1="NO SE PUDO ENCONTRAR EL PARAMETRO";
                cad2="PROBLEMAS CONSULTA SUMINISTRO CC";
                mensajeconfirmacion(cad1,cad2);
                ex.printStackTrace();//System.out.println("problema en la verificacion del codigo en la tabla");
           }
           Conxcelda.CerrarConexion();
           return rcodigo;
    }

    /**
     * confirmarcodigo
     */
    /*public void confirmarcodigo(JIFEntradas framecrearentradas,JDesktopPane JDPpanelpal,ModeloEntradas modeloentrada) {
        String mensaje = "SI";
        String mensaje1 = "NO";
        Object[] option = {mensaje, mensaje1};
        JOptionPane JDNuevo = new  JOptionPane();
        //framecrearentrada2=new JIFEntradas();
        framecrearentrada2=framecrearentradas;

        int n = JDNuevo.showOptionDialog(framecrearentradas,"ESTE CODIGO NO EXISTE EN LA BASE DE DATOS.DESEA CREAR UNO NUEVO?","NUEVO " + "SUMINISTRO",JDNuevo.YES_NO_OPTION,JDNuevo.QUESTION_MESSAGE, null,option, mensaje1);
        if(n==0){
            objPpalvalidar.Objframeppal.consultasnuevosuministro();
            framesuministro2 = new JIFConfigSuministro(objPpalvalidar.Objframeppal.RSSuministro,objPpalvalidar.Objframeppal.RSPresentacion,objPpalvalidar.Objframeppal.RSGenerico,objPpalvalidar.Objframeppal.RSSLaboratorio,objPpalvalidar.Objframeppal.RSTipoProducto,framesuministro2,0);
            framesuministro2.setBounds(0, 2, 580, 550);
            framesuministro2.setTitle("Suministro");
            JDPpanelpal.add(framesuministro2, new Integer(1));
            framesuministro2.setLocation(210, 95);
            objentrada2= JDPpanelpal.getSelectedFrame();
            objentrada2.setVisible(false);
            framesuministro2.show();
            framesuministro2.setVisible(true);
            objPpalvalidar.Objframeppal.titulo="Suministro";
            swguardarsumini=1;
            modeloentradaobj=modeloentrada;
            habilitarnuevosuministro(framesuministro2);
            framecrearentradas.swvalidar=1;
            //objPpalvalidar.Objframeppal.JBNuevo.setEnabled(true);
            objPpalvalidar.Objframeppal.JBGuardar.setEnabled(true);
            //objPpalvalidar.Objframeppal.titulo= "Suministro";

        }
        else
            framecrearentradas.swvalidar=0;
    }*/

    /**
     * habilitarnuevosuministro
     */
   /* public void habilitarnuevosuministro(JIFConfigSuministro temporalsuministro) {
        temporalsuministro.JTFCodigoBarras.setText("");
        temporalsuministro.JTFNombreSuministro.setText("");
        temporalsuministro.JTFIva.setText("0");
        temporalsuministro.JTFFactorConversion.setText("");
        temporalsuministro.JTFCodigoBarras.setEnabled(true);
        temporalsuministro.JTFNombreSuministro.setEnabled(true);
        temporalsuministro.JTFIva.setEnabled(true);
        temporalsuministro.JTFFactorConversion.setEnabled(true);
        temporalsuministro.JTFFactorConversion.setText("0");
        temporalsuministro.JCBGenerico.setEnabled(true);
        temporalsuministro.JCBLaboratorio.setEnabled(true);
        temporalsuministro.JCBPresentacion.setEnabled(true);
        temporalsuministro.JCBTipoProducto.setEnabled(true);
        temporalsuministro.JCHBPos.setEnabled(true);

    }*/

    /**
     * confirmarcodigomodelo
     */
    /*public int confirmarcodigomodelo(ModeloEntradas modeloentradaconfirmar,String valcodbarras) {
        int numfilvalidar=modeloentradaconfirmar.getRowCount();int swbuscar=0,pos=0;int rbuscar=0;
        numfilvalidar=numfilvalidar-1;
        int ifilamod;String cad1,cad2;
        if(numfilvalidar>=1){
           for(ifilamod=0;ifilamod<numfilvalidar-1;ifilamod++)
              {String varbarcod=(String)modeloentradaconfirmar.getValueAt(ifilamod,1);
               if(varbarcod.compareTo(valcodbarras)==0)
                   swbuscar=1;pos=ifilamod;
           }

           if(swbuscar==1)
           {
               cad1="ESTE CODIGO DE BARRAS YA EXISTE EN LA CUADRICULA DE ENTRADA";
               cad2="VALIDANDO CODIGO DE BARRAS EN LA CUADRICULA";
               mensajeconfirmacion(cad1,cad2);pos=pos+1;
               modeloentradaconfirmar.setValueAt("",pos,1);
               rbuscar=1;
           }
        }

        return rbuscar;
     }*/

    /**
     * mensajeconfirmacion
     */
    public void mensajeconfirmacion(String cad1,String cad2) {
        JOptionPane.showMessageDialog(jOptionPanevalidar,cad1 ,cad2, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * llenarcombodoble
     */
    public void llenarcombodoble(ResultSet Rvarentrada,JComboBox JCBOperador,int numcolumna,int numcolumna2,int numcolumna3,int numcolumna4,int longconsulta) {
        llenarblancos();int i;
        try{
         Connection con2=Conxcelda.getConnection();
        /* Tcombooperador=con2.createStatement();
         Rcombooperador=Tcombooperador.executeQuery(cadena);*/
         int n=0;
         for( i=1;i<=longconsulta;i++){
              Rvarentrada.absolute(i);
              Obceldanombreoperadordoble= new String[i];
              matlote[i-1]=Rvarentrada.getString(numcolumna);
              Obceldanombreoperadordoble[0]=Rvarentrada.getString(numcolumna2);
              //Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat("  ");
             // Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat(Rvarentrada.getString(numcolumna2));
              Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat(" ");
              Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat(Rvarentrada.getString(numcolumna3));
              Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat(" ");
              Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat(Rvarentrada.getString(numcolumna4));
              Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat(" ");
              Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat(Rvarentrada.getString(numcolumna));
              JCBOperador.addItem(Obceldanombreoperadordoble[0]);
            }

     }
     catch (Exception ex) {
          ex.printStackTrace();System.out.println("problema en la consulta de llenar combos del modulo de todos los pedidos");
      }
     Conxcelda.CerrarConexion();

    }

    /**
     * tamanoconsulta
     */
    public int tamanoconsulta(ResultSet Rvarentrada) {
           int tam=0,i=0;
           try{Rvarentrada.first();
               Connection con2 = Conxcelda.getConnection();
               while(Rvarentrada.next()){
                    tam=tam+1;
           }
           }
           catch (Exception ex) {
               ex.printStackTrace();//System.out.println("problema en la consulta de llenar combos del modulo de todos los pedidos");
               mensajeconfirmacion("ERROR","PROBLEMA EN CALCULAR EL TAMA�O DE LA CONSULTA") ;
           }
     Conxcelda.CerrarConexion();
     return(tam+1);
   }

    /**
     * evaluarcombocadenalote
     */
    public int evaluarcombocadenalote(JComboBox JCcadena) {
         int rcadena;int resultadoentero;
         rcadena=(int)JCcadena.getSelectedIndex();
         return rcadena;
    }

    /**
     * llenarblancos
     */
    public void llenarblancos() {
       int k;
       for(k=0;k<50;k++)
           matlote[k]=" ";
    }

    /**
     * formatodoble
     */
    public String formatodoblepesos(String cadenaform) {
        String rcadformato=" ";
        if(cadenaform==null)
            cadenaform="0";
        Double dcadformato=new Double(cadenaform);
        cadenaform=formatonumero.format(dcadformato);
        rcadformato=cadenaform;
        return rcadformato;
    }

    /**
     * validarfecha
     */
    public void validarfecha(String fechamodelo) {
           String caddia,cadmes,cadano;
           if(fechamodelo==null){
              mensajeconfirmacion("LA FECHA NO PUEDE ESTAR VACIA","ERROR FECHA");
              swfechavalida=1;
           }
           else{
               caddia=fechamodelo.substring(0,2);
               cadmes=fechamodelo.substring(3,5);
               cadano=fechamodelo.substring(6,10);
               if(caddia.compareTo("  ")==0 || cadmes.compareTo("  ")==0 ||cadano.compareTo("    ")==0)
               {
                 mensajeconfirmacion("EL DIA O EL MES O EL A�O NO PUEDEN ESTAR EN BLANCO","ERROR FECHA");
                 swfechavalida=1;
               } //CIERRA EL IF DEL DIA,MES,A�O NULL
               else{//System.out.println("yaneth"+caddia);
                    Integer idia=new Integer(caddia);
                    Integer imes=new Integer(cadmes);
                    Integer iano=new Integer(cadano);
                    if(idia<1 || idia>31 ){
                       mensajeconfirmacion("EL DIA DIGITADO NO ES VALIDO PARA EL MES","ERROR DIA");
                       swfechavalida=1;
                    }//CIERRA EL IF DEL DIA
                    else{
                        if(imes<1 || imes>12){
                          mensajeconfirmacion("EL MES DIGITADO NO ES VALIDO PARA EL MES","ERROR MES");
                          swfechavalida=1;
                        }//CIERRA EL IF DEL MES
                        else{
                            if(iano<1800 || iano>2100){
                              mensajeconfirmacion("EL A�O DIGITADO NO ES VALIDO PARA EL A�O","ERROR A�O");
                              swfechavalida=1;
                              }//CIERRA EL ELSE DEL A�O
                       }//CIERRA EL ELSE DEL MES
                     }//CIERRA EL ELSE DEL DIA
               }//CIERRA EL ELSE DEL DIA,MES,A�O NULL
           }//CIERRA EL ELSE DE LA FECHA
         }//CIERRA EL METODO

    /**
     * imprimirceroparametro
     */
    public void imprimirceroparametro(String narchivo) {
      try{
       conexup= new ConexionSql();
       Connection con=  conexup.getConnection();
       int var=0;
       Map parametro = new HashMap();
       JasperPrint imprimir =  JasperFillManager.fillReport(narchivo,parametro,con);
       JasperViewer vista = new JasperViewer(imprimir, false);
       vista.setVisible(true);
  }
  catch (Exception j){
       cad1="INCONVENIENTES PARA IMPRIMIR EL REPORTE";
       cad2="PROBLEMAS AL IMPRIMIR EL REPORTE";
       mensajeconfirmacion(cad1,cad2);
  }
  conexup.CerrarConexion();
    }

    /**
     * procesarmes
     */
    public int procesarmes(String nombmes) {
        int nummes;
        if(nombmes.compareTo("ENERO")==0)
            nummes=1;
        else
           if(nombmes.compareTo("FEBRERO")==0)
            nummes=2;
           else
              if(nombmes.compareTo("MARZO")==0)
                 nummes=3;
              else
                 if(nombmes.compareTo("ABRIL")==0)
                    nummes=4;
                 else
                    if(nombmes.compareTo("MAYO")==0)
                      nummes=5;
                    else
                       if(nombmes.compareTo("JUNIO")==0)
                          nummes=6;
                       else
                         if(nombmes.compareTo("JULIO")==0)
                            nummes=7;
                         else
                           if(nombmes.compareTo("AGOSTO")==0)
                              nummes=8;
                           else
                              if(nombmes.compareTo("SEPTIEMBRE")==0)
                                 nummes=9;
                              else
                                 if(nombmes.compareTo("OCTUBRE")==0)
                                     nummes=10;
                                 else
                                    if(nombmes.compareTo("NOVIEMBRE")==0)
                                       nummes=11;
                                    else
                                        nummes=12;
               return (nummes);
    }

    /**
     * validarvisualcomponente
     */
    public int validarvisualTextField(JFormattedTextField varcomponente) {
        int resultado=0;
        if(varcomponente.getText().compareTo("")==0)
           resultado=1;
        return resultado;
    }
    public int validararea(JTextPane varcomponente) {
       int resultado=0;
       if(varcomponente.getText().compareTo("")==0)
          resultado=1;
       return resultado;
   }


    /**
     * validarcombonulo
     */
    public int validarcombonulo(JComboBox varcombo) {
        int resultadocombo=0;
        if(varcombo.getSelectedIndex()==0)
           resultadocombo=1;
        return resultadocombo;

    }

    /**
     * validartextarea
     */
    public int validartextarea(JEditorPane JEPVisitaActual) {
        int resultadotextarea=0;
        if(JEPVisitaActual.getText().compareTo("")==0){
           resultadotextarea=1;
        }

        return resultadotextarea;
    }

    /**
     * buscarcadena
     */
    public String buscarcadena(String cadenasql,int i) {
        String rcodigo="";
           Connection con2=Conxcelda.getConnection();
           try{
               Tverificacodigo=con2.createStatement();
               Rverificacodigo=Tverificacodigo.executeQuery(cadenasql);
               Rverificacodigo.last();
               rcodigo=Rverificacodigo.getString(i);
           }
           catch (Exception ex) {
                cad1="NO SE PUDO ENCONTRAR EL PARAMETRO";
                cad2="PROBLEMAS CONSULTA HISTORIA CLINICA";
                mensajeconfirmacion(cad1,cad2);
                ex.printStackTrace();//System.out.println("problema en la verificacion del codigo en la tabla");
           }
           Conxcelda.CerrarConexion();
           return rcodigo;

    }

    /**
     * evaluarcadenaentera
     */
    public int evaluarcadenaentera(String cadenasql) {
        int rcodigo=0;
           Connection con2=Conxcelda.getConnection();
           try{
               Tverificacodigo=con2.createStatement();
               Rverificacodigo=Tverificacodigo.executeQuery(cadenasql);
               Rverificacodigo.next();
               rcodigo=Rverificacodigo.getInt(1);
           }
           catch (Exception ex) {
                cad1="NO SE PUDO ENCONTRAR EL PARAMETRO";
                cad2="PROBLEMAS CONSULTA SUMINISTRO CC";
                mensajeconfirmacion(cad1,cad2);
                ex.printStackTrace();//System.out.println("problema en la verificacion del codigo en la tabla");
           }
           Conxcelda.CerrarConexion();
           return rcodigo;

    }

    /**
     * cambiarformatofechaotro
     */
    public String cambiarformatofechaotro(String cadenafecha) {
       cadenafecha=cadenafecha.replace('-','/');
       String cad1;String cad2; String cad3;StringBuffer cadtemporal=new StringBuffer(cadenafecha);
       cad1=cadenafecha.substring(0,4);
       cad2=cadenafecha.substring(5,7);
       cad3=cadenafecha.substring(8,10);
       cadtemporal=cadtemporal.replace(0,1,cad3);
       cadtemporal=cadtemporal.replace(2,3,"/");
       cadtemporal=cadtemporal.replace(3,5,cad2);
       cadtemporal=cadtemporal.replace(6,9,cad1);
       cadtemporal=cadtemporal.replace(10,14,"   ");
       return cadtemporal.toString();

    }

    /**
     * llenareditor
     */
    public void llenareditor(ResultSet Rconsultavar,JEditorPane JEDVisitasAntvar)throws BadLocationException  {
           String varobservacion,varfecha;
           Document doc = (Document) JEDVisitasAntvar.getDocument();
           Element e = doc.getDefaultRootElement();
           AttributeSet attr = e.getAttributes().copyAttributes();
         try{
             try{
               while(Rconsultavar.next()){
                    varobservacion=Rconsultavar.getString(2);
                    varfecha=Rconsultavar.getString(3);
                    doc.insertString(doc.getLength(), varfecha, attr);
                    doc.insertString(doc.getLength(), ": ", attr);
                    doc.insertString(doc.getLength(),varobservacion , attr);
                    doc.insertString(doc.getLength(), "\n", attr);
               }
           }
           catch(SQLException e1){
             e1.getMessage();

        }//cierra el catch del sqlexception

         }
         catch(BadLocationException e2){
             e2.getMessage();

        }//cierra el catch del BadLocationException



    }

    /**
     * llenareditorcampo
     */
    public void llenareditorcampo(String cadobservacion,JEditorPane JEDVisitasAntvar) throws BadLocationException  {
        String varobservacionEF;
        Document doc = (Document) JEDVisitasAntvar.getDocument();
        Element e = doc.getDefaultRootElement();
        AttributeSet attr = e.getAttributes().copyAttributes();
        try{
            doc.insertString(doc.getLength(), cadobservacion, attr);
            doc.insertString(doc.getLength(), "\n", attr);
        }
        catch(BadLocationException e2){
             e2.getMessage();

        }//cierra el catch del BadLocationException

    }

    /**
     * descomponernombre
     */
    public int descomponernombre(String cadbuscar) {
        int pos=0;
        pos=buscarcaracter(cadbuscar,' ');
        return pos;
    }

    /**
     * formatofecha2
     */
    public String formatofecha2() {
        String sFecha2=" ";
        String patron="dd/MM/yyyy";
        SimpleDateFormat formato2=new SimpleDateFormat(patron);
        formato= DateFormat.getDateInstance();
        //sFecha2=formato.format(hoy);
        sFecha2=formato2.format(hoy);
        System.out.println("barr"+hoy);
        return sFecha2;
    }

    /**
     * llenarcombodoble2col
     */
    public void llenarcombodoble2col(ResultSet Rvarentrada,JComboBox JCBOperador,int numcolumna2,int numcolumna3,int longconsulta) {
        llenarblancos();int i;
       try{
        Connection con2=Conxcelda.getConnection();
       /* Tcombooperador=con2.createStatement();
        Rcombooperador=Tcombooperador.executeQuery(cadena);*/
        int n=0;
        for( i=1;i<=longconsulta;i++){
             Rvarentrada.absolute(i);
             Obceldanombreoperadordoble= new String[i];
             Obceldanombreoperadordoble[0]=Rvarentrada.getString(numcolumna2);
             //Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat("  ");
            // Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat(Rvarentrada.getString(numcolumna2));
             Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat("  ");
             Obceldanombreoperadordoble[0]=Obceldanombreoperadordoble[0].concat(Rvarentrada.getString(numcolumna3));
             JCBOperador.addItem(Obceldanombreoperadordoble[0]);
           }

    }
    catch (Exception ex) {
         ex.printStackTrace();System.out.println("problema en la consulta de llenar combos del modulo de todos los pedidos");
     }
    Conxcelda.CerrarConexion();

    }

    /**
     * buscarsubcadena
     */
    public String buscarsubcadena(String cadenfermedad,int longitud,String cadbuscar) {
           String retcad=" ",subcadini,cadoriginal=cadenfermedad;
           int posini,posfin,swbuscar=0;
           posini=buscarcaracter(cadenfermedad,' ');
           while (posini!=-1){
               subcadini=cadenfermedad.substring(0,posini);
               //System.out.println("errr"+subcadini);
               if(subcadini.compareTo(cadbuscar)==0){
                 swbuscar=1;
                 retcad=cadoriginal;
                 break;
               }
               else{
                  cadenfermedad=cadenfermedad.substring(posini+1,longitud);
                  longitud=cadenfermedad.length();
                  posini=buscarcaracter(cadenfermedad,' ');
              }
           }
          if(swbuscar==0){
              if(cadbuscar.compareTo(cadenfermedad)==0)
              retcad=cadoriginal;
          }
          return retcad;
    }

    /**
     * retornarnombremes
     *
     * @return String
     */
    public String retornarnombremes(int num) {
        String mes="";
        switch(num){
           case 1: mes="ENERO";
                     break;
           case 2: mes="FEBRERO";
                     break;
           case 3: mes="MARZO";
                     break;
           case 4: mes="ABRIL";
                      break;
           case 5: mes="MAYO";
                     break;
           case 6: mes="JUNIO";
                     break;
          case 7: mes="JULIO";
                     break;
          case 8: mes="AGOSTO";
                     break;
          case 9: mes="SEPTIEMBRE";
                     break;
          case 10: mes="OCTUBRE";
                     break;
          case 11 : mes="NOVIEMBRE";
                      break;
          case 12: mes="DICIEMBRE";
                     break;
         }
         return mes;
    }
    public int mensajeconfirmacion_si_no(String cadmess) {
        int seleccion = JOptionPane.showOptionDialog(jOptionPanevalidar,cadmess,"Selector de opciones",
                        JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,
                        new Object[] { "SI", "NO"},"opcion 1");


        return seleccion;
    }
    public String formatohora() {
         String patron="H:mm:ss";
         SimpleDateFormat formato2=new SimpleDateFormat(patron);
         formato= DateFormat.getTimeInstance();
         sFecha=formato.format(hoy);
         sFecha=formato2.format(hoy);
         return sFecha;
    }



    /**
     * verificarcodigocadenacar
     */


    /**
     * imprimirdosparametros
     */

}
