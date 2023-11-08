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
import dao.CompraDAO;
import dao.ReservaDAO;
import modelo.Cliente;
import modelo.Compra;
import modelo.Reserva;

@WebServlet(urlPatterns = { "/compra", "/compra-save", "/compra-delete", "/compra-edit", "/compra-update" })
public class CompraController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Cliente cliente = new Cliente();
	ClienteDAO cdao = new ClienteDAO();
	CompraDAO cmdao = new CompraDAO();
	ReservaDAO ddao = new ReservaDAO();
	Reserva reserva = new Reserva();	

	public CompraController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String route = request.getServletPath();
		switch (route) {
		case "/compra":
			read(request, response);
			break;
		case "/compra-save":
			save(request, response);
			break;
		case "/compra-delete":
			delete(request, response);
			break;
		case "/compra-edit":
			edit(request, response);
			break;
		case "/compra-update":
			update(request, response);
			break;
		default:
			response.sendRedirect("/index.html");
			break;
		}
	}
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Compra compra = new Compra();
		int idcliente = Integer.parseInt(request.getParameter("cliente"));
		int idreserva = Integer.parseInt(request.getParameter("reserva"));
		compra.setCliente(cdao.readById(idcliente));
		compra.setReserva(ddao.readById(idreserva));

		Cliente cliente = cdao.readById(idcliente);
		Reserva reserva = ddao.readById(idreserva);

		compra.setCliente(cliente);
		compra.setData(request.getParameter("data"));
		compra.setId(Integer.parseInt(request.getParameter("id")));
		compra.setReserva(reserva);
		compra.setTotal(Float.parseFloat(request.getParameter("total")));
		compra.setReserva(ddao.readById(idreserva));

		if (request.getParameter("id") != null) {
			compra.setId(Integer.parseInt(request.getParameter("id")));
			cmdao.update(compra);

		} else {
			cmdao.create(compra);
		}
		response.sendRedirect("compra");

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Compra> compra = cmdao.read();
		request.setAttribute("compra", compra);
		RequestDispatcher rd = request.getRequestDispatcher("./Compra.jsp");
		rd.forward(request, response);
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		cmdao.delete(id);
		response.sendRedirect("compra");
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Compra compra = cmdao.readById(id);
		request.setAttribute("compra", compra);
		RequestDispatcher rd = request.getRequestDispatcher("./compra.jsp");
		rd.forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compra compra = new Compra();
		int idcliente = Integer.parseInt(request.getParameter("cliente"));
		int idreserva = Integer.parseInt(request.getParameter("reserva"));
		compra.setCliente(cdao.readById(idcliente));
		compra.setReserva(ddao.readById(idreserva));
		Cliente cliente = cdao.readById(idcliente);
		Reserva reserva = ddao.readById(idreserva);
		compra.setCliente(cliente);
		compra.setData(request.getParameter("data"));
		compra.setId(Integer.parseInt(request.getParameter("id")));
		compra.setReserva(reserva);
		compra.setTotal(Float.parseFloat(request.getParameter("total")));
		compra.setReserva(ddao.readById(idreserva));
		cmdao.update(compra);
		response.sendRedirect("compra");
	}
}
