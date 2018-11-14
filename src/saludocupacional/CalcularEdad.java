package saludocupacional;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.lang.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 * <p>
 * Title: Programa de Facturacion (Proyecto Humana Salud)</p>
 *
 * <p>
 * Description: Facturacion</p>
 *
 * <p>
 * Copyright: Copyright (c) 2007</p>
 *
 * <p>
 * Company: Soluciones Tecnologicas e Integrales</p>
 *
 * @author Soluciones Tecnologicas e Integrales
 * @version 1.0
 */
public class CalcularEdad {
    // Formatos fecha1= new Formatos();

    Date hoy = new Date();
    String patron = "dd-MM-yyyy";
    SimpleDateFormat formatof = new SimpleDateFormat(patron);
    String dato = formatof.format(new Date());
    DateFormat formato = DateFormat.getDateInstance();

    public CalcularEdad() {

    }

    public double fechaentera(String fecha) {
        /* Formatos fecha1= new Formatos();
        Date hoy = new Date();
        String patron = "dd-MM-yyyy";
        SimpleDateFormat formatof = new SimpleDateFormat(patron);
        String dato=formatof.format(new Date());
        System.out.println(dato);
        DateFormat formato = DateFormat.getDateInstance();*/

        int y1 = Integer.parseInt(fecha.substring(6, 10));
        int m1 = Integer.parseInt(fecha.substring(3, 5));
        int d1 = Integer.parseInt(fecha.substring(0, 2));
        Calendar calen = new GregorianCalendar();
//       GregorianCalendar fechaAnterior = new GregorianCalendar(y1, m1, d1);
// Objeto con la fecha actual
        //      GregorianCalendar fechaActual = new GregorianCalendar();

        int y2 = Integer.parseInt(dato.substring(6, 10));
        int m2 = Integer.parseInt(dato.substring(3, 5));
        int d2 = Integer.parseInt(dato.substring(0, 2));
        double n = 0;

        n = (((y2 - y1) * 360) + ((m2 - m1) * 30) + (d2 - d1));
        if (n >= 360) {
            n = (n / 360);
        } else {
            n = ((n / 360) * 12);
            if (n < 1) {
                n = (n * 30);
            }
        }
        return n;
    }

    public String fechatexto(String fecha) {
        int y1 = Integer.parseInt(fecha.substring(6, 10));
        int m1 = Integer.parseInt(fecha.substring(3, 5));
        int d1 = Integer.parseInt(fecha.substring(0, 2));
        //  GregorianCalendar fechaAnterior = new GregorianCalendar(y1, m1, d1);
        // Objeto con la fecha actual
        // GregorianCalendar fechaActual = new GregorianCalendar();
        int y2 = Integer.parseInt(dato.substring(6, 10));
        int m2 = Integer.parseInt(dato.substring(3, 5));
        int d2 = Integer.parseInt(dato.substring(0, 2));

        double n = 0;
        String rt;

        n = (((y2 - y1) * 360) + ((m2 - m1) * 30) + (d2 - d1));
        if (n >= 360) {
            n = (n / 360);
            rt = "Años";
        } else {
            n = ((n / 360) * 12);
            rt = "Meses";
            if (n < 1) {
                n = (n * 30);
                rt = "Dias";
            }
        }
        return rt;
    }

    public int fechaint(String fecha) {
        int y1 = Integer.parseInt(fecha.substring(6, 10));
        int m1 = Integer.parseInt(fecha.substring(3, 5));
        int d1 = Integer.parseInt(fecha.substring(0, 2));
        //  GregorianCalendar fechaAnterior = new GregorianCalendar(y1, m1, d1);
        // Objeto con la fecha actual
        // GregorianCalendar fechaActual = new GregorianCalendar();
        int y2 = Integer.parseInt(dato.substring(6, 10));
        int m2 = Integer.parseInt(dato.substring(3, 5));
        int d2 = Integer.parseInt(dato.substring(0, 2));

        double n = 0;
        int rt;

        n = (((y2 - y1) * 360) + ((m2 - m1) * 30) + (d2 - d1));
        if (n >= 360) {
            n = (n / 360);
            rt = 0;
        } else {
            n = ((n / 360) * 12);
            rt = 1;
            if (n < 1) {
                n = (n * 30);
                rt = 2;
            }
        }
        return rt;
    }
}
