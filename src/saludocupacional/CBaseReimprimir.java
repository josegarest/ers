package saludocupacional;

public class CBaseReimprimir {
 String numident;
 String primapell;
 String sdoapell;
 String primnombr;
 String sgdonombr;
 String nombrempresa;
 String tipoexamen;
 String fechaultexamen;
 String numingreso;
 public CBaseReimprimir(String numident,String primapell,String sdoapell,String primnombr,String sgdonombr,String nombrempresa,String tipoexamen,String fechaultexamen,String numingreso) {
        this.numident=numident;
        this.primapell=primapell;
        this.sdoapell=sdoapell;
        this.primnombr=primnombr;
        this.sgdonombr=sgdonombr;
        this.nombrempresa=nombrempresa;
        this.tipoexamen=tipoexamen;
        this.fechaultexamen=fechaultexamen;
        this.numingreso=numingreso;
    }
 public CBaseReimprimir(){
    }
 //FUNCION DAME
 public String damenumident() { return numident; }
 public String dameprimapell() { return primapell; }
 public String damesdoapell() { return sdoapell; }
 public String dameprimnombr() { return primnombr; }
 public String damesgdonombr() { return sgdonombr; }
 public String damenombrempresa() { return nombrempresa; }
 public String dametipoexamen() { return tipoexamen; }
 public String damefechaultexamen() { return fechaultexamen; }
 public String damenumingreso() { return numingreso; }
 //FUNCION PON
 public void tomanumident(String numident) { this.numident=numident; }
 public void tomaprimapell(String primapell) { this.primapell=primapell; }
 public void tomasdoapell(String sdoapell) { this.sdoapell=sdoapell; }
 public void tomaprimnombr(String primnombr) { this.primnombr=primnombr; }
 public void tomasgdonombr(String sgdonombr) { this.sgdonombr=sgdonombr; }
 public void tomanombrempresa(String nombrempresa) { this.nombrempresa=nombrempresa; }
 public void tomatipoexamen(String tipoexamen) { this.tipoexamen=tipoexamen; }
 public void tomafechaultexamen(String fechaultexamen) { this.fechaultexamen=fechaultexamen; }
 public void tomanumingreso(String numingreso) { this.numingreso=numingreso; }

}
