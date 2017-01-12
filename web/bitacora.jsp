<%@page import="java.text.DecimalFormat"%>
<%@page import="Clases.Producto"%>
<%@page import="Modelos.ModeloProducto"%>
<%@page import="Clases.Compras"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.Consulta"%>
<%@page import="Clases.Usuario"%>
<%
    HttpSession sesion = request.getSession(true);
    Usuario usu = sesion.getAttribute("Usuario") == null ? null : (Usuario) sesion.getAttribute("Usuario");
    Consulta consultica = new Consulta();
    ArrayList <Compras>  compras = consultica.comprasPorUsuario(usu.getId_usuario());
    DecimalFormat formatea = new DecimalFormat("###,###.##");
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Bitacora</title>
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
				<h2 class="heading">Productos Adquiridos</h2>
			</div>


			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Articulo</td>
							<td class="description">Precio</td>	
                                                        <td></td>
                                                        
							<td class="total">Fecha de Compra</td>
                                                        <td ></td>
                                                        <td></td>
						</tr>
					</thead>
                                       
                                        <tbody> 
                                            <%
                                                ModeloProducto mp = new ModeloProducto();
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
                                                            $<%= formatea.format(producto.getPrecio())  %>
							</td>
                                                        <td></td>                                                        
							<td class="cart_price">
                                                            <%= consultica.obtenerFechaFactura(a.getId_factura()) %>
							</td>
                                                        <td>
                                                          
                                                        </td>
						</tr>                                                
                                                		
					</form>
                                        <% 
                                            ;}
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