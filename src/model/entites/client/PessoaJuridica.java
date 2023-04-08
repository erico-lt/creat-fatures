package model.entites.client;

import model.entites.Clients;

public class PessoaJuridica extends Clients{
    private Long cnpj;
    
    public PessoaJuridica(String name, String telephone, String email, String address, Long cnpj, Integer codCliente) {
        super(name, telephone, email, address, codCliente);
        this.setCnpj(cnpj);              
    }

    public PessoaJuridica (Integer cod, String name) {
        super(cod, name);
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
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
