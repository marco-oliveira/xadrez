package com.xadrez.engine.tabuleiro;

import com.google.common.collect.ImmutableMap;
import com.xadrez.engine.pecas.Peca;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marco Antônio on 08/03/2018
 */
public abstract class Casa {

    protected final int cordenadasDaCasa;

    //construtor privado
    private Casa(int cordenadasDaCasa){
        this.cordenadasDaCasa = cordenadasDaCasa;
    }

    private static final Map<Integer, CasaVazia> CASAS_VAZIAS = criaTodasCasasPossiveis();

    public abstract boolean isCasaOcupada();

    public abstract Peca getPeca();


    //cria um tabuleiro com as casas vazias
    private static Map<Integer, CasaVazia> criaTodasCasasPossiveis(){
        final Map<Integer, CasaVazia> casasVaziasMap = new HashMap<>();

        for (int i = 0; i < 64; i++){
            casasVaziasMap.put(i, new CasaVazia(i));
        }

        //retorna um tabuleiro imutavel - <<Biblioteca guava do google>>
        return ImmutableMap.copyOf(casasVaziasMap);

    }

    //fábrica para criar uma casa vazia ou com peça
    public static Casa criaCasa(final int cordenadasDaCasa, final Peca peca){
        return peca != null ? new CasaOcupada(cordenadasDaCasa, peca) : CASAS_VAZIAS.get(cordenadasDaCasa);
    }


    //classe interna para casa vazia no tabuleiro
    static class CasaVazia extends Casa{

        private CasaVazia(int cordenadasDaCasa) {
            super(cordenadasDaCasa);
        }

        @Override
        public boolean isCasaOcupada() {
            return false;
        }

        @Override
        public Peca getPeca() {
            return null;
        }
    }


    //classe interna para casa ocupada por uma peça no tabuleiro
    static class CasaOcupada extends Casa{

        private final Peca pecaNaCasa;

        private CasaOcupada(int cordenadasDaCasa, Peca pecaNaCasa) {
            super(cordenadasDaCasa);
            this.pecaNaCasa = pecaNaCasa;
        }

        @Override
        public boolean isCasaOcupada() {
            return true;
        }

        @Override
        public Peca getPeca() {
            return this.pecaNaCasa;
        }
    }
}
