package saludocupacional;

public class CBaseHO {
    private String Cempresa;
    private String Cfechaini;
    private String Cfechafin;
    private String Ctiempo;
    private String Ccargo;
    private String Cfactriesgo;
    private Boolean CActualempresa;
    private String Ctiempoexpo;
    public CBaseHO() {
    }
    public CBaseHO(String Cempresa,String Cfechaini,String Cfechafin,String Ctiempo,String Ccargo,String Cfactriesgo,Boolean CActualempresa,String Ctiempoexpo)
    {
       this.Cempresa=Cempresa;
       this.Cfechaini=Cfechaini;
       this.Cfechafin=Cfechafin;
       this.Ctiempo=Ctiempo;
       this.Ccargo=Ccargo;
       this.Cfactriesgo=Cfactriesgo;
       this.CActualempresa=CActualempresa;
       this.Ctiempoexpo=Ctiempoexpo;
    }
    //METODOS PARA DAR
    public String dameCempresacaja() {//System.out.println("consueloooooo"+Cempresa);
        return Cempresa; }
    public String dameCfechainicaja() { return Cfechaini; }
    public String dameCfechafincaja() { return Cfechafin; }
    public String dameCtiempo() { return Ctiempo; }
    public String dameCcargocaja() { return Ccargo; }
    public String dameCfactriesgocaja() { return Cfactriesgo; }
    public Boolean dameCActualempresa() { return CActualempresa; }
    public String dameCtiempoexpocaja() { return Ctiempoexpo; }

   // METODOS PARA PONER
    public void tomaCempresacajacaja(String Cempresa) { this.Cempresa=Cempresa; }
    public void tomaCfechainicaja(String Cfechaini) { this.Cfechaini=Cfechaini; }
    public void tomaCfechafincaja(String Cfechafin) { this.Cfechafin=Cfechafin; }
    public void tomaCtiempo(String Ctiempo) { this.Ctiempo=Ctiempo; }
    public void tomaCcargocaja(String Ccargo) { this.Ccargo=Ccargo; }
    public void tomaCfactriesgocaja(String Cfactriesgo) {  this.Cfactriesgo=Cfactriesgo; }
    public void tomaCActualempresa(Boolean CActualempresa) { this.CActualempresa=CActualempresa; }
    public void tomaCtiempoexpocaja(String Ctiempoexpo) { this.Ctiempoexpo=Ctiempoexpo; }

}
