package Model;

public class Pessoa {
    private String nomePiloto;
    private String cpf;

    public Pessoa(String nomePiloto, String cpf){
        this.nomePiloto = nomePiloto;
        this.cpf = cpf;
    }

    public String getNomePiloto() {
        return nomePiloto;
    }
    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void cadastro(String nomePiloto, String cpf) {

    }

    @Override
    public String toString() {
        return "\nNome do Piloto: " +nomePiloto+ " | CPF do Piloto: " +cpf;
    }
}
