package org.example.clases_inyecc;

public class ClaseA_constructor {
    ClaseB claseB;

    public ClaseA_constructor(ClaseB clase_injectada_c) {
        this.claseB = clase_injectada_c;
    }

    public void setClaseB(ClaseB clase_injectada){
        claseB = clase_injectada;
    }

    public double DiezPorCiento(){
        return claseB.DameValor()*0.1d;
    }
}
