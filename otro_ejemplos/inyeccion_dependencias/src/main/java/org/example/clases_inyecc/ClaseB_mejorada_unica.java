package org.example.clases_inyecc;

public class ClaseB_mejorada_unica extends  ClaseB{
    public ClaseB_mejorada_unica(String tipo) {
        if ( tipo == "d") {
            this.setNum(34.55);
        } else{
            this.setNum(556.55);
        }
    }
}
