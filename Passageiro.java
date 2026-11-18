package modelo;

public class Passageiro {

    private static int proximoId = 1;

    private int id;
    private String nome;
    private String documento;
    private String voo;
    private String destino;

    public Passageiro(String nome, String documento, String voo, String destino) {
        this.id = proximoId;
        proximoId++;
        this.nome = nome;
        this.documento = documento;
        this.voo = voo;
        this.destino = destino;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getVoo() {
        return voo;
    }

    public void setVoo(String voo) {
        this.voo = voo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Passageiro{id=" + id + ", nome=" + nome + ", documento=" + documento
                + ", voo=" + voo + ", destino=" + destino + "}";
    }
}
