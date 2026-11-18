package estrutura;

import modelo.Passageiro;

public class No {

    private Passageiro passageiro;
    private No prox, ant;

    public No(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    @Override
    public String toString() {
        return "No{" + "passageiro=" + passageiro + '}';
    }
}
