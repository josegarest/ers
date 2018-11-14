package saludocupacional;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.*;
import javax.swing.event.*;
import java.util.LinkedList;

public class CModeloReimprimir extends AbstractTableModel {

    public CModeloReimprimir() {
    }

    //
    public int getColumnCount() {
        // Devuelve el numero de columnas del modelo, que coincide con el
        // numero de datos que tenemos de cada persona.
        return 9;
    }
    //

    public int getRowCount() {
        // Devuelve el numero de personas en el modelo, es decir, el numero
        // de filas en la tabla.
        return datos.size();
        //return 8;
    }
    //

    public Object getValueAt(int rowIndex, int columnIndex) {
        CBaseReimprimir aux;

        // Se obtiene la persona de la fila indicada
        aux = (CBaseReimprimir) (datos.get(rowIndex));
        switch (columnIndex) {
            case 0:
                return aux.damenumident();
            case 1:
                return aux.dameprimapell();
            case 2:
                return aux.damesdoapell();
            case 3:
                return aux.dameprimnombr();
            case 4:
                return aux.damesgdonombr();
            case 5:
                return aux.damenombrempresa();
            case 6:
                return aux.dametipoexamen();
            case 7:
                return aux.damefechaultexamen();
            case 8:
                return aux.damenumingreso();
            default:
                return null;
        }
    }
    //

    public void anhadereimprimir(CBaseReimprimir nuevoreimprimir) {
        datos.add(nuevoreimprimir);
        TableModelEvent evento;
        evento = new TableModelEvent(this, this.getRowCount() - 1,
                this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS,
                TableModelEvent.INSERT);
        // ... y avisando a los suscriptores
        avisaSuscriptores(evento);
    }
//

    public void addTableModelListener(TableModelListener l) {

        // Añade el sus  criptor a la lista de suscriptores
        listeners.add(l);
    }

    //
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
            case 2:// La columna uno contiene el apellido de la persona, que es
                // un String
                return String.class;
            case 3:// La columna uno contiene el apellido de la persona, que es
                // un String
                return String.class;
            case 4:// La columna uno contiene el apellido de la persona, que es
                // un String
                return String.class;
            case 5:// La columna uno contiene el apellido de la persona, que es
                // un String
                return String.class;
            case 6:// La columna uno contiene el apellido de la persona, que es
                // un String
                return String.class;
            case 7:// La columna uno contiene el apellido de la persona, que es
                // un String
                return String.class;
            case 8:// La columna uno contiene el apellido de la persona, que es
                // un String
                return String.class;

            default:
                // Devuelve una clase Object por defecto.
                return Object.class;
        }
    }
    //

    public String getColumnName(int columnIndex) {
        // Devuelve el nombre de cada columna. Este texto aparecera en la
        // cabecera de la tabla.
        switch (columnIndex) {
            case 0:
                return "IDENTIFICACION";
            case 1:
                return "1erAPELLIDO";
            case 2:
                return "2doAPELLIDO";
            case 3:
                return "1erNOMBRE";
            case 4:
                return "2doNOMBRE";
            case 5:
                return "EMPRESA";
            case 6:
                return "TIPO DE EXAMEN";
            case 7:
                return "FECHA EXAMEN";
            case 8:
                return "NUM INGRESO";

            default:
                return null;
        }
    }
    //

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
//

    public void setValueAt(Object Value, int rowIndex, int columnIndex) {
        CBaseReimprimir aux;
        // Se obtiene la persona de la fila indicada
        aux = (CBaseReimprimir) (datos.get(rowIndex));
        switch (columnIndex) {
            case 0:
                aux.tomanumident((String) Value);
                break;
            case 1:
                aux.tomaprimapell((String) Value);
                break;
            case 2:
                aux.tomasdoapell((String) Value);
                break;
            case 3:
                aux.tomaprimnombr((String) Value);
                break;
            case 4:
                aux.tomasgdonombr((String) Value);
                break;
            case 5:
                aux.tomanombrempresa((String) Value);
                break;
            case 6:
                aux.tomatipoexamen((String) Value);
                break;
            case 7:
                aux.tomafechaultexamen((String) Value);
                break;
            case 8:
                aux.tomanumingreso((String) Value);
                break;

        }
    }
    //

    public void borrareimpr(int fila) {
        // Se borra la fila
        datos.remove(fila);
        // Y se avisa a los suscriptores, creando un TableModelEvent...
        TableModelEvent evento = new TableModelEvent(this, fila, fila, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        // ... y pasandoselo a los suscriptores
        avisaSuscriptores(evento);
    }

    public void removeTableModelListener(TableModelListener l) {
        // Elimina los suscriptores.

        listeners.remove(l);
    }

    private void avisaSuscriptores(TableModelEvent evento) {
        int i;
        // Bucle para todos los suscriptores en la lista, se llama al metodo
        // tableChanged() de los mismos, pasandole el evento.
        for (i = 0; i < listeners.size(); i++) {
            ((TableModelListener) listeners.get(i)).tableChanged(evento);
        }
    }
    //
    private LinkedList datos = new LinkedList();

    /**
     * Lista de suscriptores. El JTable sera un suscriptor de este modelo de
     * datos
     */
    private LinkedList listeners = new LinkedList();

}

//}//fin de la clase
