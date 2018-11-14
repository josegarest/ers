package saludocupacional;

import javax.swing.table.AbstractTableModel;
import java.util.LinkedList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.util.Date;

public class CModeloMedico extends AbstractTableModel {

    /**
     * Lista con los datos. Cada elemento de la lista es una instancia de
     * Persona
     */
    private LinkedList datos = new LinkedList();
    //Ppaljframe objcentrocosto;
    /**
     * Lista de suscriptores. El JTable sera un suscriptor de este modelo de
     * datos
     */
    private LinkedList listeners = new LinkedList();

    /**
     * eliminarelemento
     */
    //public ModeloCaja(){
    //  }
    public int getColumnCount() {
        // Devuelve el numero de columnas del modelo, que coincide con el
        // numero de datos que tenemos de cada persona.
        return 10;
    }

    public int getRowCount() {
        // Devuelve el numero de personas en el modelo, es decir, el numero
        // de filas en la tabla.
        return datos.size();
        //return 8;

    }

    // LEE DATOS DEL MODELO
    public Object getValueAt(int rowIndex, int columnIndex) {
        CBaseMedico aux;
        // Se obtiene la persona de la fila indicada
        aux = (CBaseMedico) (datos.get(rowIndex));
        switch (columnIndex) {
            case 0:
                return aux.dameCidentificacion();
            case 1://
                return aux.dameCprimerapellido();
            case 2:
                return aux.dameCsegundoapellido();
            case 3:
                return aux.dameCprimernombre();
            case 4:
                return aux.dameCsgdonombre();
            case 5:
                return aux.dameCempresa();
            case 6:
                return aux.dameCtipoexamen();

            case 7:
                return aux.dameCfecha();
            case 8:
                return aux.dameCnumingreso();
            case 9:
                return aux.dameCpendiente();
            default:
                return null;
        }
    }

    public void borraentrada(int fila) {   // Se borra la fila
        datos.remove(fila);

        // Y se avisa a los suscriptores, creando un TableModelEvent...
        TableModelEvent evento = new TableModelEvent(this, fila, fila,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);

        // ... y pasandoselo a los suscriptores
        avisaSuscriptores(evento);
    }
    // AñADE FILAS AL MODELO

    public void anhadeentrada(CBaseMedico nuevaentrada) {
        datos.add(nuevaentrada);

        // Avisa a los suscriptores creando un TableModelEvent...
        TableModelEvent evento;
        evento = new TableModelEvent(this, this.getRowCount() - 1,
                this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS,
                TableModelEvent.INSERT);

        // ... y avisando a los suscriptores
        avisaSuscriptores(evento);
    }

    public void addTableModelListener(TableModelListener l) {

        // Añade el sus  criptor a la lista de suscriptores
        listeners.add(l);
    }

    // DEVUELVE EL TIPO DE DATOS DE CADA COLUMNA DEL MODELO
    public Class getColumnClass(int columnIndex) {
        // Devuelve la clase que hay en cada columna.
        switch (columnIndex) {
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
                return String.class;
            case 7:
                // La columna dos contine la edad de la persona, que es un
                // Integer (no vale int, debe ser una clase)
                return String.class;
            case 8:
                // La columna dos contine la edad de la persona, que es un
                // Integer (no vale int, debe ser una clase)
                return String.class;
            case 9:
                // La columna dos contine la edad de la persona, que es un
                // Integer (no vale int, debe ser una clase)
                return Boolean.class;

            default:
                // Devuelve una clase Object por defecto.
                return Object.class;
        }
    }
    // SE CONFIGURA LOSA NOMBRES DE LAS COLUMNAS DEL MODELO DE DATOS

    public String getColumnName(int columnIndex) {
        // Devuelve el nombre de cada columna. Este texto aparecera en la
        // cabecera de la tabla.
        switch (columnIndex) {
            case 0:
                return "IDENTIFICACION";
            case 1:
                return "PRIMER APELL";
            case 2:
                return "SGDO APELL";
            case 3:
                return "PRIMER NBRE";
            case 4:
                return "SGDO NBRE";
            case 5:
                return "EMPRESA";
            case 6:
                return "TIPO EXAMEN";
            case 7:
                return "FECHA";
            case 8:
                return "NUM INGRESO";
            case 9:
                return "PENDIENTE";
            default:
                return null;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 1 || columnIndex == 4 || columnIndex == 5 || columnIndex == 3 || columnIndex == 6 || columnIndex == 7) {
            return false;
        } else {
            return true;
        }

    }

    public void removeTableModelListener(TableModelListener l) {
        // Elimina los suscriptores.

        listeners.remove(l);
    }

    /**
     * Sets the value in the cell at <code>columnIndex</code> and
     * <code>rowIndex</code> to <code>aValue</code>.
     *
     * @param	aValue	the new value
     * @param	rowIndex	the row whose value is to be changed
     * @param	columnIndex the column whose value is to be changed
     * @see #getValueAt
     * @see #isCellEditable
     *
     */
    public void setValueAt(Object Value, int rowIndex, int columnIndex) {
        CBaseMedico aux;
        /* Double Dvlrventa;double dvlrventa;
      Integer Icantidad;int intcantidad;*/
        // Se obtiene la persona de la fila indicada
        // System.out.println("hort"+(String)Value);
        aux = (CBaseMedico) (datos.get(rowIndex));
        switch (columnIndex) {
            case 0:
                aux.tomaCidentificacion((String) Value);
                break;
            case 1:
                aux.tomaCprimerapellido((String) Value);
                break;
            case 2:/*String IValue=(String)Value;
                Icantidad=new Integer(IValue);
                intcantidad=Icantidad.intValue();
                Object ocantidad=intcantidad;*/
                aux.tomaCsegundoapellido((String) Value);
                break;
            case 3:/*String SValue=(String)Value;
                   Dvlrventa=new Double(SValue);
                   dvlrventa=Dvlrventa.doubleValue();
                   Object vventa=dvlrventa;*/
                aux.tomaCprimernombre((String) Value);
                break;
            case 4:/*String SValue=(String)Value;
                Dvlrventa=new Double(SValue);
                dvlrventa=Dvlrventa.doubleValue();
                Object vventa=dvlrventa;*/
                aux.tomaCsgdonombre((String) Value);
                break;
            case 5:
                aux.tomaCempresa((String) Value);
                break;
            case 6:
                aux.tomaCtipoexamen((String) Value);
                break;
            case 7:
                aux.tomaCfecha((String) Value);
                break;
            case 8:
                aux.tomaCnumingreso((String) Value);
                break;
            case 9:
                aux.tomaCpendiente((Boolean) Value);
                break;
        }
        // Avisa a los suscriptores del cambio, creando un TableModelEvent ...
        TableModelEvent evento = new TableModelEvent(this, rowIndex, rowIndex,
                columnIndex);

        // ... y pasandoselo a los suscriptores.
        avisaSuscriptores(evento);
    }

    /**
     * Pasa a los suscriptores el evento.
     */
    private void avisaSuscriptores(TableModelEvent evento) {
        int i;

        // Bucle para todos los suscriptores en la lista, se llama al metodo
        // tableChanged() de los mismos, pasandole el evento.
        for (i = 0; i < listeners.size(); i++) {
            ((TableModelListener) listeners.get(i)).tableChanged(evento);
        }
    }

}//fin clase modelomedico
