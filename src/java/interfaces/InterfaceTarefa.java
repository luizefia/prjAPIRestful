/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import model.Tarefa;
import java.util.List;

/**
 *
 * @author LuiseFia
 */
public interface InterfaceTarefa {
    public abstract void inserir(Tarefa entidade);
    public abstract boolean atualizar(Tarefa entidade);
    public abstract boolean deletar(Tarefa entidade);
    public abstract Tarefa pesquisar(int codigo);
    public abstract List<Tarefa> listarTarefas();
}
