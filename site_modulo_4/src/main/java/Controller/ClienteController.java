package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import modelo.Cliente;


@WebServlet(urlPatterns = {"/cliente", "/cliente-save", "/cliente-delete", "/cliente-edit", "/cliente-update"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	ClienteDAO cdao = new ClienteDAO();

    public ClienteController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath();
        switch (route) {
        case "/cliente":
            read(request,response);
            break;
        case "/cliente-save":
            save(request,response);
            break;
        case "/cliente-delete":
            delete(request,response);
            break;
       case "/cliente-edit":
			edit(request, response);
			break;
		case "/cliente-update":
			update(request, response);
			break;
        default:

            break;
        }

    }
 
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       
        
		
		modelo.Cliente cliente = null;
		cliente.setCep(request.getParameter("cep"));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setNome(request.getParameter("nome"));
        cliente.setTelefone(request.getParameter("telefone"));
        
        if(request.getParameter("id")!=null){
        	 cliente.setId(Integer.parseInt(request.getParameter("id")));
            cdao.update(cliente);

        }else {
            cdao.create(cliente);
        }
        response.sendRedirect("cliente");
    }
    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Cliente>clientes = cdao.read();
        request.setAttribute("clientes", clientes);
        RequestDispatcher rd=request.getRequestDispatcher("./cadastro.jsp");
        rd.forward(request, response);
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        cdao.delete(id);
        response.sendRedirect("cliente");
    }


	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Cliente cliente = cdao.readById(id);
		
		request.setAttribute("cliente", cliente);

		RequestDispatcher rd = request.getRequestDispatcher("./cadastro.jsp");
		rd.forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cliente cliente = null;
		cliente.setId(Integer.parseInt(request.getParameter("id")));
		cliente.setCep(request.getParameter("cep"));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setNome(request.getParameter("nome"));
        cliente.setTelefone(request.getParameter("telefone"));
		
		cdao.update(cliente);
		response.sendRedirect("cliente");
	}
	
	}