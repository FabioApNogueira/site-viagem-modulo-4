<table class="table">
                  <thead>
                    <tr>
                      <th scope="col">Clientes</th>
                      <th scope="col">Data</th>
                      <th scope="col">Id</th>
                      <th scope="col">Reserva</th>
                      <th scope="col">Total</th>
                      <th scope="col">Ações</th>
                    </tr>
                  </thead>
                  <tbody>
                     <jstl:forEach items="${compra}" var="c"> 


                    <tr>
                        <td>${c.id}</td>
                        <td>${c.cliente}</td>
                        <td>${c.data}</td>
                        <td>${c.reserva}</td>
                        <td>${c.total}</td>

                        <td>
                            <a href="compra-edit?id=${c.id}" class="btn btn-primary mb-1" >Editar</a>

                            <a href="compra-delete?id=${c.id}" onclick="return confirm('Deseja excluir ${c.cliente}?')" class="btn btn-danger mb-1">Excluir</a>
                        </td>

                    </tr>
                </jstl:forEach> 
               
                  </tbody>
                </table>