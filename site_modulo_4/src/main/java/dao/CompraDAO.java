package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Cliente;
import modelo.Compra;
import modelo.Reserva;

public class CompraDAO {
	public void create(Compra compra) {

		String sql = "insert into Compra (id_cliente, id_reserva, data_compra, total_compra) values ( ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, compra.getCliente().getId());
			pstm.setInt(2, compra.getReserva().getId_reserva());
			pstm.setString(3, compra.getData());
			pstm.setFloat(4, compra.getTotal());
			

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public List<Compra> read() {
		List<Compra> compras = new ArrayList<Compra>();
		String sql = "select * from compra";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Compra compra = new Compra();

				compra.setId(rset.getInt("id_compra"));
				compra.setData(rset.getString("data_compra"));
				compra.setTotal(rset.getFloat("total_compra"));
				int id_cliente = rset.getInt("id_cliente");
				ClienteDAO clientedao = new ClienteDAO();
				Cliente cliente = clientedao.readById(id_cliente);
				compra.setCliente(cliente);
				int id_reserva = rset.getInt("id_reserva");
				ReservaDAO reservadao = new ReservaDAO();
				Reserva reserva = reservadao.readById(id_reserva);
				compra.setReserva(reserva);

				compras.add(compra);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return compras;
	}

	
	public void update(Compra compra) {
		String sql = "UPDATE Compra SET id_cliente = ?, id_reserva = ?, data_compra = ?, total_compra = ? WHERE id_compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, compra.getCliente().getId());
			pstm.setInt(2, compra.getReserva().getId_reserva());
			pstm.setString(3, compra.getData());
			pstm.setFloat(4, compra.getTotal());
			pstm.setInt(5, compra.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void delete(int id) {
		String sql = "DELETE FROM Compra WHERE id_compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public Compra readById(int id) {
		Compra compra = new Compra();
		String sql = "select * from Compra WHERE id_compra = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			compra.setId(rset.getInt("id_compra"));
			compra.setData(rset.getString("data_compra"));
			compra.setTotal(rset.getFloat("total_compra"));
			int id_cliente = rset.getInt("id_cliente");
			ClienteDAO clientedao = new ClienteDAO();
			Cliente cliente = clientedao.readById(id_cliente);
			compra.setCliente(cliente);
			int id_reserva = rset.getInt("id_reserva");
			ReservaDAO reservadao = new ReservaDAO();
			Reserva reserva = reservadao.readById(id_reserva);
			compra.setReserva(reserva);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return compra;
	}
}
