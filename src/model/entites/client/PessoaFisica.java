package model.entites.client;

import model.entites.Clients;

public class PessoaFisica extends Clients{
    private Long cpf;    

    public PessoaFisica(Integer cod, String name) {
        super(cod, name); 
    }

    public PessoaFisica(String name, String telephone, String email, String address, Long cpf, Integer codCliente) {
        super(name, telephone, email, address, codCliente);     
        this.setCpf(cpf);        
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public int compareTo(Clients cliente) {
        return this.getCodCliente().compareTo(cliente.getCodCliente());
    }

    @Override 
    public String toString() {
        return super.toString();
    }

}
