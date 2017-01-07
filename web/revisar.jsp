<%@page import="Clases.Usuario"%>
<%@page import="Clases.Producto"%>
<%@page import="Controladores.ControladorProductos"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Clases.Articulo"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession(true);
    ArrayList <Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
    Usuario usuario = (Usuario) sesion.getAttribute("Usuario");
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Revisar</title>
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
							<ul class="nav navbar-nav">
								<li><a href=""><i class="fa fa-facebook"></i></a></li>
							</ul>
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
				<h2 class="heading">Paso 1</h2>
			</div>

			<div class="shopper-informations">
				<div class="row">

					<div class="col-sm-5 clearfix">
						<div class="bill-to">
							<p>Bill To</p>
							<div class="form-one">
								<form>
									<div class="step-one"><h4 class="heading">Nombre</h4></div>
                                                                        <div class="step-one"><h4 class="heading">Apellido</h4></div>
                                                                        <div class="step-one"><h4 class="heading">Correo</h4></div>
                                                                        <div class="step-one"><h4 class="heading">Direccion</h4></div>
                                                     		</form>
							</div>
							<div class="form-two">
								<form>
									<div class="step-one"><h4 class="heading">Nombre</h4></div>
                                                                        <div class="step-one"><h4 class="heading">Apellido</h4></div>
                                                                        <div class="step-one"><h4 class="heading">Correo</h4></div>
                                                                        <div class="step-one"><h4 class="heading">Direccion</h4></div>
								</form>
							</div>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="order-message">
							<p>Orden de envio</p>
							<textarea name="message"  placeholder="Notas sobre su pedido, Notas especiales para entrega" rows="16"></textarea>
							
						</div>	
					</div>					
				</div>
			</div>
			<div class="review-payment">
				<h2>Revisar y Pagar</h2>
			</div>

			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Articulo</td>
							<td class="description"></td>
							<td class="price">Precio</td>
							<td class="quantity">Cantidad</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
                                            
                                            <%
                                                DecimalFormat formatea = new DecimalFormat("###,###.##");
                                                ControladorProductos cp = new ControladorProductos();
                                                int total = 0;
                                                if(articulos != null)
                                                {
                                                for(Articulo a : articulos)
                                                {
                                                    Producto producto = cp.getProducto(a.getIdProducto());
                                                    total = total + a.getCantidad() * producto.getPrecio();
                                            %>
						<tr>
							<td class="cart_product">
                                                            <a href=""><img src="<%= producto.getImagen()%>" alt="" width="120" height="120"></a>
							</td>
							<td class="cart_description">
                                                            <h4><a href=""><%= producto.getNombre()%></a></h4>
                                                            <p>Web ID: <%= producto.getId()%></p>
							</td>
							<td class="cart_price">
                                                            <p>$<%= formatea.format(producto.getPrecio())%></p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<h4 class="heading"><%= a.getCantidad() %></h4>																	
								</div>
							</td>
							<td class="cart_total">
                                                            <p class="cart_total_price">$<%= formatea.format(Math.round(producto.getPrecio()*a.getCantidad()*100.0)/100.0) %></p>
							</td>
							
						</tr>
                                                <%}}%>
                                                		<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
                                                                    
									<tr>
										<td>Subtotal</td>
										<td>$<%= formatea.format(total) %></td>
									</tr>
									
									<tr class="shipping-cost">
										<td>Costo Envio</td>
										<td>$8.500</td>										
									</tr>
									<tr>
										<td>Total</td>
										<td><span>$<%= formatea.format(total) %></span></td>
                                                                                <form action="aa.jsp">
                                                                                <input type="submit" class="btn btn-default check_out" id="BtnPagar" name="BtnPagar" value="Pagar">
                                                                                </form>
									</tr>
                                                                    
								</table>
							</td>
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