package saludocupacional;

public class CBaseHEP {
    private String CempresaHEP;
    private String CfechaJEP;
    private String CDiagHEP;
    private String CpersonaHEP;
    public CBaseHEP() {
    }
    public CBaseHEP(String CempresaHEP,String CfechaJEP,String CDiagHEP,String CpersonaHEP)
    {
       this.CempresaHEP=CempresaHEP;
       this.CfechaJEP=CfechaJEP;
       this.CDiagHEP=CDiagHEP;
       this.CpersonaHEP=CpersonaHEP;
     }
    //METODOS PARA DAR
    public String dameCempresaHEPcaja() {//System.out.println("consueloooooo"+CempresaHEP);
        return CempresaHEP; }
    public String dameCfechaJEPcaja() { return CfechaJEP; }
    public String dameCDiagHEPcaja() { return CDiagHEP; }
    public String dameCpersonaHEPcaja() { return CpersonaHEP; }


   // METODOS PARA PONER
    public void tomaCempresaHEPcajacaja(String CempresaHEP) { this.CempresaHEP=CempresaHEP; }
    public void tomaCfechaJEPcaja(String CfechaJEP) { this.CfechaJEP=CfechaJEP; }
     public void tomaCDiagHEPcaja(String CDiagHEP) { this.CDiagHEP=CDiagHEP; }
    public void tomaCpersonaHEPcaja(String CpersonaHEP) { this.CpersonaHEP=CpersonaHEP; }

}
