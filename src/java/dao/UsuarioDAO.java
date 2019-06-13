package dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author LuiseFia
 */
public class UsuarioDAO {

    public UsuarioDAO() {

    }
    ConnectionFactory conexao = new ConnectionFactory();

    public void inserir(Usuario usuario) {

        String sql = "insert into tb_usuario (Nome, Cargo, Endereco, HrTrabalho)"
                + " values (?,?,?,?)";
        PreparedStatement pst = conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getCargo());
            pst.setString(3, usuario.getEndereco());
            pst.setString(4, usuario.getHorarioTrabalho());
            pst.execute();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean atualizar(Usuario usuario, int codigo) {
        String sql = "UPDATE tb_usuario SET Nome=?, Cargo=?, Endereco=?, HrTrabalho=?"
                + " WHERE Codigo=?";
        Boolean retorno = false;
        PreparedStatement pst = conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getCargo());
            pst.setString(3, usuario.getEndereco());
            pst.setString(4, usuario.getHorarioTrabalho());
            pst.setInt(5, codigo);
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public boolean excluir(Usuario usuario) {
        String sql = "DELETE FROM tb_usuario WHERE codigo=?";
        Boolean retorno = false;
        PreparedStatement pst = conexao.getPreparedStatement(sql);
        try {

            pst.setInt(1, usuario.getCodigo());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        return retorno;
    }

    public List<Usuario> listar() {
        String sql = "SELECT * FROM tb_usuario";
        List<Usuario> retorno = new ArrayList<>();

        PreparedStatement pst = conexao.getPreparedStatement(sql);
        try {
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Usuario usuario = new Usuario();
                usuario.setCodigo(res.getInt("codigo"));
                usuario.setNome(res.getString("nome"));
                usuario.setCargo(res.getString("cargo"));
                usuario.setEndereco(res.getString("endereco"));
                usuario.setHorarioTrabalho(res.getString("HrTrabalho"));

                retorno.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public Usuario buscar(Usuario usuario) {
        String sql = "SELECT * FROM tb_usuario where codigo=?";
        Usuario retorno = null;

        PreparedStatement pst = conexao.getPreparedStatement(sql);
        try {
            pst.setInt(1, usuario.getCodigo());
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                retorno = new Usuario();
                usuario.setCodigo(res.getInt("codigo"));
                usuario.setNome(res.getString("nome"));
                usuario.setCargo(res.getString("cargo"));
                usuario.setEndereco(res.getString("endereco"));
                usuario.setHorarioTrabalho(res.getString("HrTrabalho"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}
