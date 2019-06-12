package model;
/**
 *
 * @author LuiseFia
 */
public class Tarefa {

    private int codigoTarefa;
    private int codigoUsuario;
    private String descricao;
    private String tempoEstimado;
    private String categoria;
    private String situacao;
    private String nomeUsuario;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public int getCodigoTarefa() {
        return codigoTarefa;
    }

    public void setCodigoTarefa(int codigoTarefa) {
        this.codigoTarefa = codigoTarefa;
    }

    public String getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(String tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public Tarefa(int codigoTarefa, String descricao, String tempoEstimado, String categoria, String situacao, String nomeUsuario) {
        this.codigoTarefa = codigoTarefa;
        this.descricao = descricao;
        this.tempoEstimado = tempoEstimado;
        this.categoria = categoria;
        this.situacao = situacao;
        this.nomeUsuario = nomeUsuario;
    }

    public Tarefa() {
    this(0, "", "", "", "", "");
    }

}
