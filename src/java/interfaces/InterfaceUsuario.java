/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import model.Usuario;
import java.util.List;

/**
 *
 * @author LuiseFia
 */
public interface InterfaceUsuario {
    
    public abstract void inserir(Usuario entidade);
    public abstract boolean atualizar(Usuario entidade);
    public abstract boolean deletar(Usuario entidade);
    public abstract Usuario pesquisar(int codigo);
    public abstract List<Usuario> listarUsuarios();
    
}
