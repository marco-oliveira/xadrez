package com.xadrez.engine.pecas;

import com.xadrez.engine.Equipe;
import com.xadrez.engine.tabuleiro.Movimento;
import com.xadrez.engine.tabuleiro.Tabuleiro;

import java.util.List;

/**
 * Created by Marco Antônio on 09/03/2018
 */
public abstract class Peca {

    protected int posicaoDaPeca;

    protected Equipe equipeDaPeca;


    Peca(final int posicaoDaPeca, final Equipe equipeDaPeca){
        this.posicaoDaPeca = posicaoDaPeca;
        this.equipeDaPeca = equipeDaPeca;
    }

    public abstract List<Movimento> caluculoMovimentosLegais(final Tabuleiro tabuleiro);

    public Equipe getEquipeDaPeca() {
        return equipeDaPeca;
    }
}
