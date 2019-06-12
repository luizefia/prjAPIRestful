package webServices;

import com.google.gson.Gson;
import dao.UsuarioDAO;
import model.Usuario;
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

@Path("/usuario")
public class UsuarioResource {

    @Context
    private UriInfo context;

    public UsuarioResource() {
    }

    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsuarioLista() {
        List<Usuario> lista;
        UsuarioDAO usuDao = new UsuarioDAO();
        Gson gson = new Gson();
        lista = usuDao.listar();
        return gson.toJson(lista);
    }
    
    @GET
    @Path("pesquisar/{CodigoUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getsuario(@PathParam("CodigoUsuario") int codigo) {
        UsuarioDAO usuDao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setCodigo(codigo);
        usuDao.buscar(usuario);
        Gson gson = new Gson();
        return gson.toJson(usuario);
    }

    @POST
    @Path("inserir")
    @Consumes(MediaType.APPLICATION_JSON)    
    public void postUsuario(String content) {
        Gson gson = new Gson();   
        Usuario usuario = (Usuario) gson.fromJson(content, Usuario.class);
        UsuarioDAO usuDao = new UsuarioDAO();
        usuDao.inserir(usuario);
    }
    
    @PUT
    @Path("alterar/{CodigoUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void putUsuario(@PathParam("CodigoUsuario")int codigo, String content) {
        Gson gson = new Gson();        
        Usuario usuario = (Usuario) gson.fromJson(content, Usuario.class);
        UsuarioDAO usuDao = new UsuarioDAO();
        usuDao.atualizar(usuario,codigo);        
    }

    @DELETE
    @Path("deletar/{CodigoUsuario}")
    public boolean delete(@PathParam("CodigoUsuario") int codigo) {
        Usuario usuario = new Usuario();
        usuario.setCodigo(codigo);
        UsuarioDAO usuDao = new UsuarioDAO();
        usuDao.buscar(usuario);
        return usuDao.excluir(usuario);
    }
}
