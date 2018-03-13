package com.xadrez.engine.tabuleiro;

/**
 * Created by Marco Antônio on 12/03/2018
 */
public class TabuleiroUtils {

    public static final boolean[] PRIMEIRA_COLUNA = null;
    public static final boolean[] SEGUNDA_COLUNA = null;
    public static final boolean[] SETIMA_COLUNA = null;
    public static final boolean[] OITAVA_COLUNA = null;


    private TabuleiroUtils(){
        throw new RuntimeException("A classe TabuleiroUtils não pode ser instanciada!");
    }


    public static boolean isCordenadaValida(int cordenada) {
        return cordenada >= 0 && cordenada < 64;
    }
}
