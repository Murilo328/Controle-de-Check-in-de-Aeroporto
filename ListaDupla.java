package estrutura;

import modelo.Passageiro;

public class ListaDupla {

    private No inicio, fim;
    private int tamanho;

    public boolean vazia() {
        return inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    // Insere um novo nó no fim da lista.
    public void inserirFim(Passageiro passageiro) {
        No novo = new No(passageiro);
        if (vazia()) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setAnt(fim);
            fim.setProx(novo);
            fim = novo;
        }
        tamanho++;
    }

    // Remove o nó do início da lista e devolve o passageiro (null se vazia).
    public Passageiro removerInicio() {
        if (vazia()) {
            return null;
        }
        Passageiro removido = inicio.getPassageiro();
        inicio = inicio.getProx();
        if (inicio == null) {
            fim = null;
        } else {
            inicio.setAnt(null);
        }
        tamanho--;
        return removido;
    }

    // Devolve o passageiro do início sem remover (null se vazia).
    public Passageiro consultarInicio() {
        if (vazia()) {
            return null;
        }
        return inicio.getPassageiro();
    }

    // Percorre da frente para o fim montando o texto da lista.
    public String listar() {
        String texto = "";
        No atual = inicio;
        int posicao = 1;
        while (atual != null) {
            texto = texto + posicao + "º -> " + atual.getPassageiro() + "\n";
            atual = atual.getProx();
            posicao++;
        }
        return texto;
    }
}
