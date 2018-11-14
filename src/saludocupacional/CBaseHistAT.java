package saludocupacional;

public class CBaseHistAT {
    private String Cempresa;
    private String Cfecha;
    private String Ctipolesion;
    private String Ccausa;
    private String Cparteafectada;
    private String Cincapacidad;
    private String Csecuela;
    public CBaseHistAT() {
    }
    public CBaseHistAT(String Cempresa,String Cfecha,String Ctipolesion,String Ccausa,String Cparteafectada,String Cincapacidad,String Csecuela)
    {
       this.Cempresa=Cempresa;
       this.Cfecha=Cfecha;
       this.Ctipolesion=Ctipolesion;
       this.Ccausa=Ccausa;
       this.Cparteafectada=Cparteafectada;
       this.Cincapacidad=Cincapacidad;
       this.Csecuela=Csecuela;
    }
    //METODOS PARA DAR
    public String dameCempresacaja() {//System.out.println("consueloooooo"+Cempresa);
        return Cempresa; }
    public String dameCfechacaja() { return Cfecha; }
    public String dameCtipolesioncaja() { return Ctipolesion; }
    public String dameCcausacaja() { return Ccausa; }
    public String dameCparteafectadacaja() { return Cparteafectada; }
    public String dameCincapacidadcaja() { return Cincapacidad; }
    public String dameCsecuelacaja() { return Csecuela; }

   // METODOS PARA PONER
    public void tomaCempresacajacaja(String Cempresa) { this.Cempresa=Cempresa; }
    public void tomaCfechacaja(String Cfecha) { this.Cfecha=Cfecha; }
    public void tomaCtipolesioncaja(String Ctipolesion) { this.Ctipolesion=Ctipolesion; }
    public void tomaCcausacaja(String Ccausa) { this.Ccausa=Ccausa; }
    public void tomaCparteafectadacaja(String Cparteafectada) {  this.Cparteafectada=Cparteafectada; }
    public void tomaCincapacidadcaja(String Cincapacidad) { this.Cincapacidad=Cincapacidad; }
    public void tomaCsecuelacaja(String Csecuela) { this.Csecuela=Csecuela; }

}
