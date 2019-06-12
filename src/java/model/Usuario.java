package model;

/**
 *
 * @author LuiseFia
 */
public class Usuario {
    private String nome;
    private String cargo;
    private String endereco;
    private String horarioTrabalho;
    private int codigo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(String horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }    

    public Usuario(String nome, String cargo, String endereco, String horarioTrabalho, int codigo) {
        this.nome = nome;
        this.cargo = cargo;
        this.endereco = endereco;
        this.horarioTrabalho = horarioTrabalho;
        this.codigo = codigo;
    }

    public Usuario() {
    this("", "", "", "", 0);
    }  
    
}
