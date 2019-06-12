package webServices;

import com.google.gson.Gson;
import dao.TarefaDAO;
import model.Tarefa;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author LuiseFia
 */
@Path("/tarefa")
public class TarefaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TarefaResource
     */
    public TarefaResource() {
    }

    @GET    
    @Path("lista/{CodigoUsuario}")    
    @Produces(MediaType.APPLICATION_JSON)
    public String getTarefaLista(@PathParam("CodigoUsuario")int codigo) {
        List<Tarefa> lista;
        TarefaDAO tarefadao = new TarefaDAO();
        Gson gson = new Gson();
        lista = tarefadao.listar(codigo);
        return gson.toJson(lista);      
    }
    
    @POST
    @Path("inserir")
    @Consumes(MediaType.APPLICATION_JSON)    
    public void postTarefa(String content) {
        Gson gson = new Gson();   
        Tarefa tarefa = (Tarefa) gson.fromJson(content, Tarefa.class);
        TarefaDAO tarefaDao = new TarefaDAO();
        tarefaDao.inserir(tarefa);
    }
    
    @PUT
    @Path("alterar/{CodigoTarefa}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void putTarefa(@PathParam("CodigoTarefa")int codigo, String content) {
        Gson gson = new Gson();        
        Tarefa tarefa = (Tarefa) gson.fromJson(content, Tarefa.class);
        TarefaDAO tarefaDao = new TarefaDAO();
        tarefaDao.atualizar(tarefa,codigo);        
    }
    
    @DELETE    
    @Path("deletar/{CodigoTarefa}")    
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteTarefa(@PathParam("CodigoTarefa")int codigo) {
        Tarefa tarefa = new Tarefa();
        TarefaDAO tarefadao = new TarefaDAO();
        tarefa.setCodigoTarefa(codigo);
        tarefadao.excluir(tarefa);
    }
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public void get() {        
        
    }
}
