package model.entites;

public abstract class Clients  implements Comparable<Clients>{
    private String name;
    private String telephone;
    private String email;
    private String[] address = new String[4];
    private Integer codCliente;    

    public Clients(Integer cod, String name) {
        this.setCodCliente(cod);
        this.setName(name);
    }  

    public Clients(String name, String telephone, String email, String[] address, Integer codClient) {
        this.setName(name);
        this.setTelephone(telephone);
        this.setEmail(email);
        this.setAddress(address);
        this.setCodCliente(codClient);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        if(address.length < 4) {
            throw new NullPointerException("[ERRO] endereço incompleto");
        }
        for(int cont = 0; cont < this.getAddress().length - 1; cont++) {
            this.address[cont] = address[cont];
        }
    }

    public void setCodCliente(Integer codClient) {
        this.codCliente = codClient;
    }

    public Integer getCodCliente() {
        return codCliente;
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

}
