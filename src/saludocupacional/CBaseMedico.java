package saludocupacional;

public class CBaseMedico {
    private String Cidentificacion;
    private String Cprimerapellido;
    private String Csegundoapellido;
    private String Cprimernombre;
    private String Csgdonombre;
    private String Cempresa;
    private String Ctipoexamen;
    private String Cfecha;
    private boolean Cpendiente;
    private String Cnumingreso;
    public CBaseMedico() {
    }
    public CBaseMedico(String Cidentificacion,String Cprimerapellido,String Csegundoapellido,String Cprimernombre,String Csgdonombre,String Cempresa,String Ctipoexamen,String Cfecha,String Cnumingreso,boolean Cpendiente)
    {
       this.Cidentificacion=Cidentificacion;
       this.Cprimerapellido=Cprimerapellido;
       this.Csegundoapellido=Csegundoapellido;
       this.Cprimernombre=Cprimernombre;
       this.Csgdonombre=Csgdonombre;
       this.Cempresa=Cempresa;
       this.Ctipoexamen=Ctipoexamen;
       this.Cfecha=Cfecha;
       this.Cpendiente=Cpendiente;
       this.Cnumingreso=Cnumingreso;
    }
    //METODOS PARA DAR
    public String dameCidentificacion() {//System.out.println("consueloooooo"+Cempresa);
        return Cidentificacion; }
    public String dameCprimerapellido() { return Cprimerapellido; }
    public String dameCsegundoapellido() { return Csegundoapellido; }
    public String dameCprimernombre() { return Cprimernombre; }
    public String dameCsgdonombre() { return Csgdonombre; }
    public String dameCempresa() { return Cempresa; }
    public String dameCtipoexamen() { return Ctipoexamen; }
    public String dameCfecha() { return Cfecha; }
    public boolean dameCpendiente() { return Cpendiente; }
    public String dameCnumingreso() { return Cnumingreso; }
    // METODOS PARA PONER
    public void tomaCidentificacion(String Cidentificacion) { this.Cidentificacion=Cidentificacion; }
    public void tomaCprimerapellido(String Cprimerapellido) { this.Cprimerapellido=Cprimerapellido; }
    public void tomaCsegundoapellido(String Csegundoapellido) { this.Csegundoapellido=Csegundoapellido; }
    public void tomaCprimernombre(String Cprimernombre) { this.Cprimernombre=Cprimernombre; }
    public void tomaCsgdonombre(String Csgdonombre) { this.Csgdonombre=Csgdonombre; }
    public void tomaCempresa(String Cempresa) {  this.Cempresa=Cempresa; }
    public void tomaCtipoexamen(String Ctipoexamen) { this.Ctipoexamen=Ctipoexamen; }
    public void tomaCfecha(String Cfecha) { this.Cfecha=Cfecha; }
    public void tomaCpendiente(boolean Cpendiente) { this.Cpendiente=Cpendiente; }
    public void tomaCnumingreso(String Cnumingreso) { this.Cnumingreso=Cnumingreso; }

}
