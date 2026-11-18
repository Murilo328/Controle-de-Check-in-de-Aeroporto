package estrutura;

import modelo.Passageiro;

// Fila (FIFO) adaptada da ListaDupla:
// entra pelo fim da lista e sai pelo início.
public class Fila {

    private ListaDupla lista = new ListaDupla();

    // 1) Enfileirar
    public void enfileirar(Passageiro passageiro) {
        lista.inserirFim(passageiro);
    }

    // 2) Desenfileirar
    public Passageiro desenfileirar() {
        return lista.removerInicio();
    }

    // 3) Primeiro da fila (sem remover)
    public Passageiro primeiro() {
        return lista.consultarInicio();
    }

    // 4) Fila vazia?
    public boolean vazia() {
        return lista.vazia();
    }

    // 5) Tamanho da fila
    public int tamanho() {
        return lista.getTamanho();
    }

    // Auxiliar para exibir todos os passageiros aguardando
    public String exibir() {
        return lista.listar();
    }
}
