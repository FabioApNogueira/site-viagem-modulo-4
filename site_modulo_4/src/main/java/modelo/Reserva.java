package modelo;

public class Reserva {

	private int id_reserva;
	private float valor_reserva;
	private String data_reserva;

	public Reserva() {
		super();
	}

	public Reserva(int id_reserva, float valor_reserva, String data_reserva) {
		super();
		this.id_reserva = id_reserva;
		this.valor_reserva = valor_reserva;
		this.data_reserva = data_reserva;
	}

	public Reserva(float valor_reserva, String data_reserva) {
		super();
		this.valor_reserva = valor_reserva;
		this.data_reserva = data_reserva;
	}

	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}

	public float getValor_reserva() {
		return valor_reserva;
	}

	public void setValor_reserva(float valor_reserva) {
		this.valor_reserva = valor_reserva;
	}

	public String getData_reserva() {
		return data_reserva;
	}

	public void setData_reserva(String data_reserva) {
		this.data_reserva = data_reserva;
	}

	public void mostrar() {
	}
	}

