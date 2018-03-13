package com.xadrez.engine.pecas;

import com.google.common.collect.ImmutableList;
import com.xadrez.engine.Equipe;
import com.xadrez.engine.tabuleiro.Casa;
import com.xadrez.engine.tabuleiro.Movimento;
import com.xadrez.engine.tabuleiro.Tabuleiro;
import com.xadrez.engine.tabuleiro.TabuleiroUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Marco Antônio on 13/03/2018
 */
public class Rainha extends Peca{

    //União entre os movimentos do bispo e da torre
    private final static int [] CORDENADAS_CANDIDATAS = {-9, -8, -7, -1, 1, 7, 8, 9};

    Rainha(int posicaoDaPeca, Equipe equipeDaPeca) {
        super(posicaoDaPeca, equipeDaPeca);
    }

    @Override
    public Collection<Movimento> caluculoMovimentosLegais(final Tabuleiro tabuleiro) {

        List<Movimento> movimentosLegais = new ArrayList<>();

        for (int candidataAtual : CORDENADAS_CANDIDATAS){
            int cordernadaCandidata = this.posicaoDaPeca;
            while (TabuleiroUtils.isCordenadaValida(cordernadaCandidata)){
                cordernadaCandidata += candidataAtual;
                if (isExcecaoNaPrimeiraColuna(cordernadaCandidata, candidataAtual) ||
                        isExcecaoNaOitavaColuna(cordernadaCandidata, candidataAtual)){
                    break;
                }
                if (TabuleiroUtils.isCordenadaValida(cordernadaCandidata)){

                    final Casa casaCandidata = tabuleiro.getCasa(cordernadaCandidata);
                    if (!casaCandidata.isCasaOcupada()){
                        movimentosLegais.add(new Movimento.MovimentoPrincipal(tabuleiro, this, cordernadaCandidata));
                    }else {
                        final Peca pecaNaCasa = casaCandidata.getPeca();
                        final Equipe equipeDaPeca = pecaNaCasa.getEquipeDaPeca();
                        if (this.equipeDaPeca != equipeDaPeca){
                            movimentosLegais.add(new Movimento.MovimentoAtaque(tabuleiro, this, cordernadaCandidata, pecaNaCasa));
                        }
                        break;
                    }

                }
            }
        }

        return ImmutableList.copyOf(movimentosLegais);
    }

    //Exceções as regras
    private static boolean isExcecaoNaPrimeiraColuna(final int posicaoCorrente, final int posicaoCandidata) {
        return TabuleiroUtils.PRIMEIRA_COLUNA[posicaoCorrente] && (posicaoCandidata == -9 || posicaoCandidata == -1 || posicaoCandidata == 7);
    }

    private static boolean isExcecaoNaOitavaColuna(final int posicaoCorrente, final int posicaoCandidata){
        return TabuleiroUtils.OITAVA_COLUNA[posicaoCorrente] && (posicaoCandidata == 9 || posicaoCandidata == 1 || posicaoCandidata == -7);
    }
}
