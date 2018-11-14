package saludocupacional;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.util.Date;

public class ModeloHO extends AbstractTableModel {
    /** Lista con los datos. Cada elemento de la lista es una instancia de
       * Persona */
      private LinkedList datos = new LinkedList();
      //Ppaljframe objcentrocosto;
      /** Lista de suscriptores. El JTable ser� un suscriptor de este modelo de
       * datos */
      private LinkedList listeners = new LinkedList();
    /**
     * eliminarelemento
     */
    //public ModeloCaja(){
  //  }
    public int getColumnCount() {
         // Devuelve el n�mero de columnas del modelo, que coincide con el
         // n�mero de datos que tenemos de cada persona.
         return 8;
     }
     public int getRowCount() {
        // Devuelve el n�mero de personas en el modelo, es decir, el n�mero
        // de filas en la tabla.
        return datos.size();
        //return 8;

    }
    // LEE DATOS DEL MODELO
  public Object getValueAt(int rowIndex, int columnIndex) {
      CBaseHO aux;
        // Se obtiene la persona de la fila indicada
      aux = (CBaseHO)(datos.get(rowIndex));


   switch (columnIndex)
      {
          case 0:
                 return  aux.dameCempresacaja();
          case 1://
                 return aux.dameCfechainicaja();

          case 2:
                 return aux.dameCfechafincaja() ;
          case 3:
                 return aux.dameCtiempo();
          case 4:
                 return aux.dameCcargocaja();
          case 5:
                 return aux.dameCfactriesgocaja();
          case 6:
                 return aux.dameCActualempresa();
          case 7:
                 return aux.dameCtiempoexpocaja();
          default:
                 return null;
      }
  }
  public void borraentrada (int fila)
  {   // Se borra la fila
      datos.remove(fila);



      // Y se avisa a los suscriptores, creando un TableModelEvent...
      TableModelEvent evento = new TableModelEvent (this, fila, fila,
          TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);

      // ... y pas�ndoselo a los suscriptores
      avisaSuscriptores (evento);
  }
  // A�ADE FILAS AL MODELO
  public void anhadeentrada (CBaseHO nuevaentrada)
   {
       datos.add (nuevaentrada);

   // Avisa a los suscriptores creando un TableModelEvent...
      TableModelEvent evento;
       evento = new TableModelEvent (this, this.getRowCount()-1,
           this.getRowCount()-1, TableModelEvent.ALL_COLUMNS,
           TableModelEvent.INSERT);

       // ... y avisando a los suscriptores
       avisaSuscriptores (evento);
   }

   public void addTableModelListener(TableModelListener l) {


        // A�ade el sus  criptor a la lista de suscriptores
        listeners.add (l);
    }
    // DEVUELVE EL TIPO DE DATOS DE CADA COLUMNA DEL MODELO
     public Class getColumnClass(int columnIndex) {
         // Devuelve la clase que hay en cada columna.
         switch (columnIndex)
         {
             case 0:
                 // La columna cero contiene el nombre de la persona, que es
                 // un String
                 return String.class;
             case 1:// La columna uno contiene el apellido de la persona, que es
                    // un String
                 return String.class;
             case 2:
                 // La columna dos contine la edad de la persona, que es un
                 // Integer (no vale int, debe ser una clase)
                 return String.class;
             case 3:
                 // La columna dos contine la edad de la persona, que es un
                 // Integer (no vale int, debe ser una clase)
                 return String.class;
             case 4:
                 // La columna dos contine la edad de la persona, que es un
                 // Integer (no vale int, debe ser una clase)
                 return String.class;

             case 5:
                 // La columna dos contine la edad de la persona, que es un
                 // Integer (no vale int, debe ser una clase)
                 return String.class;

             case 6:
                 // La columna dos contine la edad de la persona, que es un
                 // Integer (no vale int, debe ser una clase)
                  return Boolean.class;
              case 7:
                 // La columna dos contine la edad de la persona, que es un
                 // Integer (no vale int, debe ser una clase)
                  return String.class;
               default:
                 // Devuelve una clase Object por defecto.
                 return Object.class;
         }
     }
     // SE CONFIGURA LOSA NOMBRES DE LAS COLUMNAS DEL MODELO DE DATOS
    public String getColumnName(int columnIndex)
     {
         // Devuelve el nombre de cada columna. Este texto aparecer� en la
         // cabecera de la tabla.
         switch (columnIndex)
         {
             case 0:
                 return "EMPRESA";
             case 1:
                 return "FECHA INICIO";
             case 2:
                 return "FECHA FIN";
             case 3:
                 return "TIEMPO";
             case 4:
                 return "CARGO";
             case 5:
                 return "FACTORES RIESGO";
             case 6:
                 return "EMPRESA ACTUAL";
             case 7:
                 return "TIEMPO EXPOSICION";

             default:
                 return null;
         }
     }
     public boolean isCellEditable(int rowIndex, int columnIndex) {
         if (columnIndex==1 ||columnIndex==4 ||columnIndex==5 ||columnIndex==3 ||columnIndex==6 ||columnIndex==7){
         return false;
     }
     else
         return true;

       }

       public void removeTableModelListener(TableModelListener l) {
        // Elimina los suscriptores.

        listeners.remove(l);
    }
    /** Sets the value in the cell at <code>columnIndex</code> and
    * <code>rowIndex</code> to <code>aValue</code>.
    *
    * @param	aValue		 the new value
    * @param	rowIndex	 the row whose value is to be changed
    * @param	columnIndex 	 the column whose value is to be changed
    * @see #getValueAt
    * @see #isCellEditable
    *
    */
   public void setValueAt(Object Value, int rowIndex, int columnIndex)
   {
       CBaseHO aux;
       Double Dvlrventa;double dvlrventa;
       Integer Icantidad;int intcantidad;
       // Se obtiene la persona de la fila indicada
      // System.out.println("hort"+(String)Value);
       aux = (CBaseHO)(datos.get(rowIndex));

       switch(columnIndex){

          case 0:
                 aux.tomaCempresacajacaja ((String)Value);
                 break;
          case 1:
                 aux.tomaCfechainicaja((String)Value);
                  break;
          case 2:/*String IValue=(String)Value;
                 Icantidad=new Integer(IValue);
                 intcantidad=Icantidad.intValue();
                 Object ocantidad=intcantidad;*/
                 aux.tomaCfechafincaja((String)Value);
                  break;
          case 3:/*String SValue=(String)Value;
                    Dvlrventa=new Double(SValue);
                    dvlrventa=Dvlrventa.doubleValue();
                    Object vventa=dvlrventa;*/
                    aux.tomaCtiempo((String)Value);
                    break;

          case 4:/*String SValue=(String)Value;
                 Dvlrventa=new Double(SValue);
                 dvlrventa=Dvlrventa.doubleValue();
                 Object vventa=dvlrventa;*/
                 aux.tomaCcargocaja((String)Value);
                 break;
          case 5:
                  aux.tomaCfactriesgocaja((String)Value);
                  break;
          case 6:
                  aux.tomaCActualempresa((Boolean)Value);
                  break;
          case 7:
                  aux.tomaCtiempoexpocaja((String)Value);
                  break;

           }
           // Avisa a los suscriptores del cambio, creando un TableModelEvent ...
      TableModelEvent evento = new TableModelEvent (this, rowIndex, rowIndex,
          columnIndex);

      // ... y pas�ndoselo a los suscriptores.
      avisaSuscriptores (evento);

   }
   /**
    * Pasa a los suscriptores el evento.
    */
   private void avisaSuscriptores (TableModelEvent evento)
   {
       int i;

       // Bucle para todos los suscriptores en la lista, se llama al metodo
       // tableChanged() de los mismos, pas�ndole el evento.
       for (i=0; i<listeners.size(); i++)
           ((TableModelListener)listeners.get(i)).tableChanged(evento);
   }


}
