package model.entites;

public class Clients  implements Comparable<Clients>{
    private String name;
    private long telephone;
    private String email;
    private String address;
    private Integer codCliente;    
    private long cpf_cnpj;

    public Clients(Integer cod, String name) {
        this.setCodCliente(cod);
        this.setName(name);
    }  

    public Clients(String name, long telephone, String email, String address, Integer codClient, long cpf_cnpj) {
        this.setName(name);
        this.setTelephone(telephone);
        this.setEmail(email);
        this.setAddress(address);
        this.setCodCliente(codClient);
        this.setCpf_cnpj(cpf_cnpj);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public void setCodCliente(Integer codClient) {
        this.codCliente = codClient;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public long getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(long cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    @Override 
    public String toString() {
        return this.getName() + "," + this.getCodCliente();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((codCliente == null) ? 0 : codCliente.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Clients other = (Clients) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (codCliente == null) {
            if (other.codCliente != null)
                return false;
        } else if (!codCliente.equals(other.codCliente))
            return false;
        return true;
    }

    @Override
    public int compareTo(Clients other) {
        return this.getCodCliente().compareTo(other.getCodCliente());         
    }    


  

}
