public class Cliente {
    private static final int TAMANHO_CPF = 11;
    private static final int TAMANHO_CNPJ = 14;
    public enum TipoPessoa {FISICA, JURIDICA};
    private static int SEQUENCIAL = 1;

    public Integer codigo;
    public String nome;
    private String documento;
    public TipoPessoa tipo;

    public Cliente(String nome, String documento, TipoPessoa tipo) {
        this.codigo = SEQUENCIAL++;
        this.nome = nome;
        this.documento = documento;
        this.tipo = tipo;
    }

    public Cliente(String nome, String documento) {
        this.codigo = SEQUENCIAL++;
        this.nome = nome;
        this.setDocumento(documento);
    }

    public void setDocumento(String documento) {

        if (documento == null || documento.isEmpty()){
            throw new RuntimeException("Documento não pode ser nulo ou vazio!");
        }
        else {
            documento = documento.replaceAll("\\p{Punct}", "");

            if (documento.length() == TAMANHO_CPF) {
                setDocumento(documento, tipo = TipoPessoa.FISICA);
            } else if (documento.length() == TAMANHO_CNPJ) {
                setDocumento(documento, tipo = TipoPessoa.JURIDICA);
            } else {
                throw new RuntimeException("Documento invalido para pessoa fisica ou juridica");
            }
        }
    }

    protected void imprimirInfosCliente() {
        System.out.println(String.format("Nome: %s", this.getNome()));
        System.out.println(String.format("Documento: %s", this.getDocumento()));
        System.out.println(String.format("Codigo: %s ", this.getCodigo()));
        System.out.println(String.format("Tipo: %s", this.getTipo()));
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "codigo = " + codigo +
                ", nome = '" + nome + '\'' +
                ", documento = '" + documento + '\'' +
                ", tipo = " + tipo +
                '}';
    }

    public String getDocumento() {
        return documento;
    }

    public Integer getCodigo() {
        return codigo;
    }

    private void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    private void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    private void setDocumento(String documento, TipoPessoa tipo){
        this.documento = documento;
        this.tipo = tipo;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
