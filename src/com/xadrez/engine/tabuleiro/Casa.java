package com.xadrez.engine.tabuleiro;

import com.xadrez.engine.pecas.Peca;

/**
 * Created by Marco Antônio on 08/03/2018
 */
public abstract class Casa {

    protected int cordenadasDaCasa;

    public Casa(int cordenadasDaCasa){
        this.cordenadasDaCasa = cordenadasDaCasa;
    }

    public abstract boolean isCasaOcupada();

    public abstract Peca getPeca();


    //classe interna
    static class CasaVazia extends Casa{

        public CasaVazia(int cordenadasDaCasa) {
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


    //classe interna
    static class CasaOcupada extends Casa{

        private final Peca pecaNaCasa;

        public CasaOcupada(int cordenadasDaCasa, Peca pecaNaCasa) {
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
