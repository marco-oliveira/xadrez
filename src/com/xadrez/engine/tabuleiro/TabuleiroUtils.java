package com.xadrez.engine.tabuleiro;

/**
 * Created by Marco Antônio on 12/03/2018
 */
public class TabuleiroUtils {

    public static final boolean[] PRIMEIRA_COLUNA = getColuna(0);
    public static final boolean[] SEGUNDA_COLUNA = getColuna(1);
    public static final boolean[] SETIMA_COLUNA = getColuna(6);
    public static final boolean[] OITAVA_COLUNA = getColuna(7);

    public static final int NUMERO_CASAS = 64;
    public static final int NUMERO_CASAS_POR_LINHA = 8;

    private TabuleiroUtils(){
        throw new RuntimeException("A classe TabuleiroUtils não pode ser instanciada!");
    }

    //método para montar cada coluna de acordo com o indice
    private static boolean[] getColuna(int indiceInicialColuna) {
        final boolean[] coluna = new boolean[NUMERO_CASAS];
        do {
            coluna[indiceInicialColuna] = true;
            indiceInicialColuna += NUMERO_CASAS_POR_LINHA;
        } while (indiceInicialColuna < NUMERO_CASAS);

        return coluna;
    }

    public static boolean isCordenadaValida(int cordenada) {
        return cordenada >= 0 && cordenada < NUMERO_CASAS;
    }
}
