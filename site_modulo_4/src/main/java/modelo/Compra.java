package modelo;

public class Compra {

	private int id;
	private String data;
	private float total;
	private Cliente cliente;
	private Reserva reserva;

	public Compra() {
		super();
	}

	public Compra(String data, float total, Cliente cliente, Reserva reserva) {
		super();
		this.data = data;
		this.total = total;
		this.cliente = cliente;
		this.reserva = reserva;
	}

	public Compra(int id, String data, float total, Cliente cliente, Reserva reserva) {
		super();
		this.id = id;
		this.data = data;
		this.total = total;
		this.cliente = cliente;
		this.reserva = reserva;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
	public void mostrar() {
		System.out.println("==========================================================");
		System.out.println("ID: "+this.id);
		System.out.println("Cliente: "+this.cliente.getNome());
		System.out.println("Reserva: "+this.reserva);
		System.out.println("Valor: "+this.total);
		System.out.println("Data: "+this.data);
		System.out.println("==========================================================");
	}

}
