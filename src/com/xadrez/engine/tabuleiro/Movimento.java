package com.xadrez.engine.tabuleiro;

import com.xadrez.engine.pecas.Peca;

/**
 * Created by Marco Antônio on 09/03/2018
 */
public abstract class Movimento {

    private final Tabuleiro tabuleiro;
    private final Peca pecaMovida;
    private final int cordenadaDestino;

    private Movimento(Tabuleiro tabuleiro, Peca pecaMovida, int cordenadaDestino) {
        this.tabuleiro = tabuleiro;
        this.pecaMovida = pecaMovida;
        this.cordenadaDestino = cordenadaDestino;
    }

    public static final class MovimentoPrincipal extends Movimento{

        public MovimentoPrincipal(Tabuleiro tabuleiro, Peca pecaMovida, int cordenadaDestino) {
            super(tabuleiro, pecaMovida, cordenadaDestino);
        }
    }

    public static final class MovimentoAtaque extends Movimento{

        private final Peca pecaAtacada;
        public MovimentoAtaque(Tabuleiro tabuleiro, Peca pecaMovida, int cordenadaDestino, Peca pecaAtacada) {
            super(tabuleiro, pecaMovida, cordenadaDestino);
            this.pecaAtacada = pecaAtacada;
        }
    }
}
