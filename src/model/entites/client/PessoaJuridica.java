package model.entites.client;

import model.entites.Clients;

public class PessoaJuridica extends Clients{
    private Long cnpj;
    private Long inscEstadual; 

    public PessoaJuridica(String name, String telephone, String email, String[] address, Long cnpj, Long inscEstadual, Integer codCliente) {
        super(name, telephone, email, address, codCliente);
        this.setCnpj(cnpj);
        this.setInscEstadual(inscEstadual);        
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public Long getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(Long inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    @Override
    public int compareTo(Clients o) {        
        return 0;
    }

    @Override 
    public String toString() {
        return super.toString();
    }

}
