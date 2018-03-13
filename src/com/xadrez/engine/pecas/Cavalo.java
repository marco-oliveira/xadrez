package com.xadrez.engine.pecas;

import com.google.common.collect.ImmutableList;
import com.xadrez.engine.Equipe;
import com.xadrez.engine.tabuleiro.Casa;
import com.xadrez.engine.tabuleiro.Movimento;
import com.xadrez.engine.tabuleiro.Movimento.MovimentoAtaque;
import com.xadrez.engine.tabuleiro.Movimento.MovimentoPrincipal;
import com.xadrez.engine.tabuleiro.Tabuleiro;
import com.xadrez.engine.tabuleiro.TabuleiroUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco Antônio on 11/03/2018
 */


/*  Movimentos legais do Cavalo

             +15  +17
             |     |
        +6 __|     |__+10
              \   /
               >0<
           __ /   \ __
       -10   |     |   -6
             |     |
            -17  -15    */



public class Cavalo extends Peca{

    private final static int [] CORDENADAS_CANDIDATAS = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Cavalo(final int posicaoDaPeca, final Equipe equipeDaPeca) {
        super(posicaoDaPeca, equipeDaPeca);
    }

    @Override
    public List<Movimento> caluculoMovimentosLegais(Tabuleiro tabuleiro) {

        final List<Movimento> movimentosLegais = new ArrayList<>();

        for (final int candidataAtual : CORDENADAS_CANDIDATAS){
            final int cordenadaCandidata = this.posicaoDaPeca + candidataAtual;
            if (TabuleiroUtils.isCordenadaValida(cordenadaCandidata)){

                //ignorar exceções as regras de movimentos legais
                if (isExcecaoNaPrimeiraColuna(this.posicaoDaPeca, candidataAtual) ||
                        isExcecaoNaSegundaColuna(this.posicaoDaPeca, candidataAtual) ||
                            isExcecaoNaSetimaColuna(this.posicaoDaPeca, candidataAtual) ||
                                isExcecaoNaOitavaColuna(this.posicaoDaPeca, candidataAtual)){
                    continue;
                }

                final Casa casaCandidata = tabuleiro.getCasa(cordenadaCandidata);
                if(!casaCandidata.isCasaOcupada()){
                    movimentosLegais.add(new MovimentoPrincipal(tabuleiro, this, cordenadaCandidata));
                } else {
                    final Peca pecaNoDestino = casaCandidata.getPeca();
                    final Equipe equipeDaPeca = pecaNoDestino.getEquipeDaPeca();
                    if (this.equipeDaPeca != equipeDaPeca){
                        movimentosLegais.add(new MovimentoAtaque(tabuleiro, this, cordenadaCandidata, pecaNoDestino));
                    }
                }
            }
        }

        return ImmutableList.copyOf(movimentosLegais);
    }

    //Exceções as regras
    private static boolean isExcecaoNaPrimeiraColuna(final int posicaoAtual, final int posicaoCandidata) {
        return TabuleiroUtils.PRIMEIRA_COLUNA[posicaoAtual] && (posicaoCandidata == -17 || posicaoCandidata == -10 ||
                posicaoCandidata == 6 || posicaoCandidata == 15);
    }

    private static boolean isExcecaoNaSegundaColuna(final int posicaoAtual, final int posicaoCandidata){
        return TabuleiroUtils.SEGUNDA_COLUNA[posicaoAtual] && (posicaoCandidata == -10 || posicaoCandidata == 6);
    }

    private static boolean isExcecaoNaSetimaColuna(final int posicaoAtual, final int posicaoCandidata) {
        return TabuleiroUtils.SETIMA_COLUNA[posicaoAtual] && (posicaoCandidata == 10 || posicaoCandidata == -6);
    }

    private static boolean isExcecaoNaOitavaColuna(final int posicaoAtual, final int posicaoCandidata){
        return TabuleiroUtils.OITAVA_COLUNA[posicaoAtual] && (posicaoCandidata == 17 || posicaoCandidata == 10 ||
            posicaoCandidata == -6 || posicaoCandidata == -15);
    }
}
