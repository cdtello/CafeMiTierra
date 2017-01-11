<%@page import="Clases.Producto"%>
<%@page import="Modelos.ModeloProducto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Usuario"%>
<%@page import="Clases.Compras"%>
<%@page import="Modelos.Consulta"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession(true);
    Usuario usu = sesion.getAttribute("Usuario") == null ? null : (Usuario) sesion.getAttribute("Usuario");
    Consulta consultica = new Consulta();
    ArrayList <Compras>  compras = consultica.comprasNoCalificadas(usu.getId_usuario());
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Calificar Compras</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
						</div>
					</div>
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
	
	
		<!--/header-bottom-->
	</header><!--/header-->

	<section id="cart_items">
		<div class="container">
			<div class="step-one">
				<h2 class="heading">Calificar Productos Adquiridos</h2>
			</div>


			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Articulo</td>
							<td class="description">Comentario</td>	
                                                        <td></td>
                                                        
							<td class="total">Calificacion</td>
							<td></td>
                                                        <td></td>
						</tr>
					</thead>
                                       
                                        <tbody> 
                                            <%
                                                ModeloProducto mp = new ModeloProducto();
                                                int boton = 0;
                                                for(Compras a : compras)
                                                {
                                                   Producto producto = mp.getProducto(a.getId_producto());
                                                    
                                            %>
                                        <form action="calificacion" method="post">
						<tr>
							<td class="cart_product">
                                                            <a href=""><img src="<%= producto.getImagen() %>" alt="" width="120" height="120"></a>
							</td>
							<td class="cart_price">
                                                            <textarea name="comentario" id="comentario" placeholder="Comentarios..." rows="6"></textarea>
							</td>
                                                        <td></td>                                                        
							<td class="cart_price">
                                                            <select name="seleccion_calificacion" size="1" id="ComboSuscripcion" >
                                                                <option selected value="1">Muy Malo</option>
                                                                <option value="2">Malo</option>
                                                                <option value="3">Regular</option>
                                                                <option value="4">Bueno</option>
                                                                <option value="5">Muy Bueno</option>
                                                            </select> 
							</td>
                                                        <td>
                                                            <input type="submit" class="btn btn-default check_out" id="BtnCalificar<%= boton%>" name="BtnCalificar<%= boton%>" value="Calificar"> 
                                                            <input type="hidden" name="producto_id" id="producto_id" value="<%= producto.getId() %>">
                                                            <input type="hidden" name="compra_id" id="compra_id" value="<%= a.getId_compra() %>">
                                                        </td>
						</tr>                                                
                                                		
					</form>
                                        <% 
                                            boton++;}
                                        %>
					</tbody>
				</table>
			</div>
		
		</div>
	</section> <!--/#cart_items-->
<footer id="footer"><!--Footer-->
		<div class="footer-top">
			<div class="container">
				<div class="row">
                                    	<div class="col-sm-3">
					</div>
                            
					<div class="col-sm-2">
						<div class="companyinfo">
							<h2><span>C.L.A.N</span>-Developers.</h2
                                                        <p>Orgullosamente Colombianos</p>
						</div>
					</div>
				
					<div class="col-sm-3">
						<div class="address">
							<img src="css/images/mapa.png" alt="" />
							
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="footer-widget">
			<div class="container">
				
			</div>
		</div>
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright 2017 Cafe Mi Tierra Inc. All rights reserved.</p>
					<p class="pull-right">Desarrollado por: Los Mejores<span></span></p>
				</div>
			</div>
		</div>
		
	</footer><!--/Footer-->
	

	
	


    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>