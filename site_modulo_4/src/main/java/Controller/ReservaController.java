package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReservaDAO;
import modelo.Reserva;



@WebServlet(urlPatterns = {"/reserva", "/reserva-save", "/reserva-delete","/reserva-edit", "/reserva-update"})
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	ReservaDAO ddao = new ReservaDAO();

    public ReservaController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath();
        switch (route) {
        case "/reserva":
            read(request,response);
            break;
        case "/reserva-save":
            save(request,response);
            break;
        case "/reserva-delete":
            delete(request,response);
            break;
            
        case "/reserva-edit":
			edit(request, response);
			break;
		case "/reserva-update":
			update(request, response);
			break;
        default:

            break;
        }
    }
 
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Reserva reserva = new Reserva();
    	reserva.setData_reserva(request.getParameter("data_reserva"));
    	reserva.setId_reserva(Integer.parseInt(request.getParameter("id_reserva")));
    	reserva.setValor_reserva(Float.parseFloat(request.getParameter("valor_reserva")));
        
        if(request.getParameter("id")!=null){
        	reserva.setId_reserva(Integer.parseInt(request.getParameter("id")));
            ddao.update(reserva);

        }else {
            ddao.create(reserva);
        }
        response.sendRedirect("reserva");
    }
    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Reserva>reserva = ddao.read();
        request.setAttribute("reserva", reserva);
        RequestDispatcher rd=request.getRequestDispatcher("./destino.jsp");
        rd.forward(request, response);
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ddao.delete(id);
        response.sendRedirect("reserva");
    }
    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Reserva reserva = ddao.readById(id);
		
		request.setAttribute("reserva", reserva);

		RequestDispatcher rd = request.getRequestDispatcher("./destino.jsp");
		rd.forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Reserva reserva = new Reserva();
    	reserva.setData_reserva(request.getParameter("data"));
    	reserva.setId_reserva(Integer.parseInt(request.getParameter("id")));
    	reserva.setValor_reserva(Float.parseFloat(request.getParameter("valor")));
				
		ddao.update(reserva);
		response.sendRedirect("reserva");
	}
	
	}