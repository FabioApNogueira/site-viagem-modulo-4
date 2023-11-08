package aplicacao;

import java.util.Scanner;

import dao.ReservaDAO;
import modelo.Reserva;

public class MainReserva {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ReservaDAO reservaDAO = new ReservaDAO();
		
		int opcao , id ; 
		
		String data; 
		float valor;
		
		
		do {
			
			System.out.println("\n============================== RESERVAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a data:");
				data = s.nextLine();
				System.out.println("Digite o valor:");
				valor = s.nextFloat();
				
				
				
				
				
				
			reservaDAO.create(new Reserva(valor, data));
				break;
			case 2:
				
				for (Reserva r : reservaDAO.read()) {
					r.mostrar();
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite a data:");
				data = s.nextLine();
				System.out.println("Digite o valor:");
				valor = s.nextFloat();
				
				
				
				reservaDAO.update(new Reserva(id, valor, data));
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				reservaDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Reserva reserva = reservaDAO.readById(id);
				
				reserva.mostrar();
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

}
