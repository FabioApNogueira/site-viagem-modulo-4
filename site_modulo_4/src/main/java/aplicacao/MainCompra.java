package aplicacao;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.ReservaDAO;
import modelo.Cliente;
import modelo.Compra;
import modelo.Reserva;

public class MainCompra {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		CompraDAO compraDAO = new CompraDAO();
		ReservaDAO reservaDAO = new ReservaDAO();
		ClienteDAO clienteDAO = new ClienteDAO();

		int opcao, id, id_cliente, id_reserva;
		String data;
		float total;

		do {

			System.out.println("\n============================== COMPRAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite o ID do cliente:");
				id_cliente = s.nextInt();
				s.nextLine();
				System.out.println("Digite o ID do reserva:");
				id_reserva = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data:");
				data = s.nextLine();
				System.out.println("Digite o valor:");
				total = s.nextFloat();

				Cliente cliente = clienteDAO.readById(id_cliente);
				Reserva reserva = reservaDAO.readById(id_reserva);

				compraDAO.create(new Compra(data, total, cliente, reserva));
				break;
			case 2:

				for (Compra c : compraDAO.read()) {
					c.mostrar();
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o ID do cliente:");
				id_cliente = s.nextInt();
				s.nextLine();
				System.out.println("Digite o ID do reserva:");
				id_reserva = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data:");
				data = s.nextLine();
				System.out.println("Digite o valor:");
				total = s.nextFloat();

				Cliente cliente1 = clienteDAO.readById(id_cliente);
				Reserva reserva1 = reservaDAO.readById(id_reserva);

				compraDAO.update(new Compra(id, data, total, cliente1, reserva1));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				compraDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Compra compra = compraDAO.readById(id);

				compra.mostrar();
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}
