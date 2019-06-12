package dao;

import connection.ConnectionFactory;
import model.Tarefa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LuiseFia
 */
public class TarefaDAO {

    ConnectionFactory conexao = new ConnectionFactory();

    public boolean inserir(Tarefa tarefa) {
        String sql = "INSERT into tb_tarefa(descricao,tempoEstimado,categoria,situacao,codigoUsuario)"
                + " values(?,?,?,?,?);";
        Boolean retorno = false;
        PreparedStatement pst = conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, tarefa.getDescricao());
            pst.setString(2, tarefa.getTempoEstimado());
            pst.setString(3, tarefa.getCategoria());
            pst.setString(4, tarefa.getSituacao());
            pst.setInt(5, tarefa.getCodigoUsuario());

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public void atualizar(Tarefa tarefa, int codigo) {
        String sql = "UPDATE tb_tarefa SET Descricao=?, TempoEstimado=?, Categoria=?, Situacao=?, CodigoUsuario=?"
                + " WHERE CodigoTarefa=?";
        Boolean retorno = false;
        PreparedStatement pst = conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, tarefa.getDescricao());
            pst.setString(2, tarefa.getTempoEstimado());
            pst.setString(3, tarefa.getCategoria());
            pst.setString(4, tarefa.getSituacao());
            pst.setInt(5, tarefa.getCodigoUsuario());
            pst.setInt(6, codigo);

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
    }

    public boolean excluir(Tarefa tarefa) {
        String sql = "DELETE FROM tb_tarefa WHERE codigoTarefa=?";
        Boolean retorno = false;
        PreparedStatement pst = conexao.getPreparedStatement(sql);
        try {
            pst.setInt(1, tarefa.getCodigoTarefa());
            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    public List<Tarefa> listar(int codigoUsuario) {
        String sql = "select tb_tarefa.codigoTarefa,tb_tarefa.descricao,tb_tarefa.tempoEstimado, tb_tarefa.categoria, tb_tarefa.situacao,tb_usuario.Nome from tb_tarefa"
                + " inner join tb_usuario on tb_tarefa.CodigoUsuario = tb_usuario.Codigo where tb_usuario.Codigo=?;";

        List<Tarefa> listaTarefas = new ArrayList<>();
        PreparedStatement pst = conexao.getPreparedStatement(sql);

        try {
            pst.setInt(1, codigoUsuario);

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setCodigoTarefa(res.getInt("CodigoTarefa"));
                tarefa.setDescricao(res.getString("Descricao"));
                tarefa.setCategoria(res.getString("Categoria"));
                tarefa.setSituacao(res.getString("Situacao"));
                tarefa.setTempoEstimado(res.getString("tempoEstimado"));
                tarefa.setNomeUsuario(res.getString("Nome"));
                tarefa.setCodigoUsuario(codigoUsuario);

                listaTarefas.add(tarefa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return listaTarefas;

    }
}
