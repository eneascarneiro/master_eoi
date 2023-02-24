package org.example.clases_inyecc;

public class ClaseA_vsettter {
    ClaseB claseB;
    public void setClaseB(ClaseB clase_injectada){
        claseB = clase_injectada;
    }
    public double DiezPorCiento(){
        return claseB.DameValor()*0.1d;
    }
}
