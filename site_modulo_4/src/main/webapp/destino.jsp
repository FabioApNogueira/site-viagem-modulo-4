<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%-- <%@ page import="model.Cliente" %> --%>
<%-- <%@ page import="java.util.List" %> --%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FNViagens</title>
    <!--link css-->
    <link rel="stylesheet" href="backgrundvideo.css">
    <!--link css-->
    <!--link bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <!--link bootstrap-->
    <!--font awesome cdn-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <!--font awesome cdn-->
    <!--google fonts-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&family=Roboto:wght@500&display=swap" rel="stylesheet">
    <!--google fonts-->
    <style>

main {
    background-color:rgba(218, 213, 221, 0.897) ;
}

h1{
    margin-top: 10px;
   
}
h5{
    margin-top: 20px;

}
h4{
    margin-top: 50px;
}
.text{
    text-align: center;
    margin-bottom: 2%;
    
}

.form-container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 5%; 
        }
        
        .form-section {
            flex: 1;
            padding: 30px;
        }

        .middle-divider {
            height: 100%;
            margin: 1 10px;
        }



    footer {
      background-color: rgb(63, 63, 63);
      padding: 10px;
    }

    .footer-info {
      display: flex;
      justify-content: space-between;
    }

    .contact-info {
      color: white;
      font-size: medium;
     }

    .end-info {
      color: white;
      font-size: medium;
    }
    
    .footer-text {
      text-align: center;
      color: white;

    }

    .img-footer {
      width: 250px;
    }
  
    .insta {
      background: radial-gradient(circle at 30% 107%, #fdf497 0%, #fdf497 5%, #fd5949 45%, #d6249f 60%, #285AEB 90%);
      -webkit-background-clip: text;

      background-clip: text;
      -webkit-text-fill-color: transparent;
      cursor: pointer;
    }

    .face {
      color: #3B5998;
      cursor: pointer;
    }

    .tw {
      color: #00acee;
      cursor: pointer;
    }

    .mess {
      color: #3B5998;
      cursor: pointer;

    }

    .whats {
      color: rgb(50, 192, 14);
      cursor: pointer;
    }


    @media screen and (max-width:600px) {
      footer .footer-info {
        display: flex;
        flex-direction: column;

      }
    }
    /*fim footer */ 

    </style>
  </head>
<body>
<!--sessão navbar inicio-->

      <nav class="navbar navbar-expand-lg" id="navbar">
        <div class="container">
                <a class="navbar-brand" href="index.html" id="logo"><span>FN</span>Viagens</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                    <span><i class="fa-solid fa-bars"></i></span>
                </button>
           <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="index.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="destino.html">Destino</a> 
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="serviços.html">Serviços</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="promoções.html">Promoções</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contato.html">Contato</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="text" placeholder="Buscar">
                    <button class="btn btn-primary" type="button">Buscar</button>
                </form>
           </div>
        </div>
      </nav>
      <!--sessão navbar fim-->
  
 <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">Data</th>
                      <th scope="col">Valor</th>
                      <th scope="col">Ações</th>
                    </tr>
                  </thead>
                  <tbody>
                     <jstl:forEach items="${reserva}" var="d"> 


                    <tr>
                        <td>${d.id_reserva}</td>
                        <td>${d.data_reserva}</td>
                        <td>${d.valor_reserva}</td>

                        <td>
                            <a href="reserva-edit?id=${d.id_reserva}" class="btn btn-primary mb-1" >Editar</a>

                            <a href="reserva-delete?id=${d.id_reserva}" onclick="return confirm('Deseja excluir ${d.data_reserva}?')" class="btn btn-danger mb-1">Excluir</a>
                        </td>

                    </tr>
                </jstl:forEach> 
               
                  </tbody>
                </table>
                
                
  
 <!--sessão footer inicio-->

<footer id="footer">
    <h1><span>FN</span>Viagens</h1>
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Impedit, iure?</p>
    <div class="social-links">
        <i class="fa-brands fa-twitter"></i>
        <i class="fa-brands fa-facebook"></i>
        <i class="fa-brands fa-instagram"></i>
        <i class="fa-brands fa-youtube"></i>
        <i class="fa-brands fa-pinterest-p"></i>
    </div>
    <div class="credit">
        <p>Desenvolvido por:<a href="#">Fabio Ap Nogueira</a></p>
    </div>

    <div class="Copyright">
        <p>&copy;Copyright Fabio Ap Nogueira.Todos os direitos reservados</p>
    </div>

</footer>
    <!--sessão footer fim-->


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>
</body>
</html>