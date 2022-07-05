package org.example;

import org.example.clases_inyecc.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejempo de inyeccion de código 1");
        ClaseA claseA = new ClaseA();
        System.out.println("La clase A me da el 10%: " +  claseA.DiezPorCiento());

        System.out.println("Ejempo de inyeccion de código 2");
        ClaseA_vsettter claseA_2 = new ClaseA_vsettter();
        ClaseB claseB_2 = new ClaseB();

        claseA_2.setClaseB(claseB_2);

        System.out.println("La clase A me da el 10%: " +  claseA_2.DiezPorCiento());

        System.out.println("Ejempo de inyeccion de código 3");
        ClaseA_vsettter claseA_3 = new ClaseA_vsettter();
        ClaseB_mejorada claseB_mejorada = new ClaseB_mejorada();
        ClaseB_mejorada_0 claseB_mejorada_0 = new ClaseB_mejorada_0();
        claseA_3.setClaseB(claseB_mejorada);

        System.out.println("3.- para uno La clase A me da el 10%: " +  claseA_3.DiezPorCiento());
        claseA_3.setClaseB(claseB_mejorada_0);
        System.out.println("3.- para la cero La clase A me da el 10%: " +  claseA_3.DiezPorCiento());

        System.out.println("Ejempo de inyeccion de código soy el director 4");
        ClaseB_mejorada claseB_mejorada_4 = new ClaseB_mejorada();
        ClaseA_constructor clase_director = new ClaseA_constructor( claseB_mejorada_4);

        ClaseB_mejorada_0 claseB_mejorada_0_4 = new ClaseB_mejorada_0();
        ClaseA_constructor clase_jp = new ClaseA_constructor( claseB_mejorada_0_4);

        System.out.println("3.- Director genera su informe para uno La clase A me da el 10%: " +
                clase_director.DiezPorCiento());
        System.out.println("3.- JP  para la cero La clase A me da el 10%: " +
                clase_jp.DiezPorCiento());


        System.out.println("Ejempo de inyeccion de código soy el director 5");
        ClaseA_constructor clase_director_5 = new ClaseA_constructor( new ClaseB_mejorada_unica("d"));
        ClaseA_constructor clase_jp_5 = new ClaseA_constructor( new ClaseB_mejorada_unica("j"));
        System.out.println("5.- Director genera su informe para uno La clase A me da el 10%: " +
                clase_director_5.DiezPorCiento());
        System.out.println("5.- JP  para la cero La clase A me da el 10%: " +
                clase_jp_5.DiezPorCiento());

        System.out.println("Línea escrita por Gemma");


        System.out.println("Linea añadida por JM" +
                clase_jp_5.DiezPorCiento());

    }
}