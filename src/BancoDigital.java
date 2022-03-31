import java.util.ArrayList;
import java.util.List;

public class BancoDigital {
   private String nome;
   private List<Conta> contas;

    public void adicionaConta(Conta conta){
        if(conta == null){
            throw new NullPointerException("Conta nao pode ser nulo");
        }
        getContas().add(conta);
    }

    public List<Conta> getContas() {
        if(contas == null){
            contas = new ArrayList<Conta>();
        }
        return contas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
