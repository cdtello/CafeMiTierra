<%@page import="java.text.DecimalFormat"%>
<%@page import="Clases.Producto"%>
<%@page import="Controladores.ControladorProductos"%>
<%@page import="Clases.Articulo"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession(true);
    ArrayList <Articulo> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Carrito Compras</title>
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
	
	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
                                    <li class="active"><h2>Carrito De Compras</h2></li>
				</ol>
			</div>
                        <div class="table-responsive cart_info" id="cart-contenedor">
				<table class="table table-condensed" id="tabla-contenedor">
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
							<td class="cart_delete">
                                                            <span id="idarticulo" style="display:none"><%= producto.getId() %></span>
                                                            <a class="cart_quantity_delete" href="" id="deleteitem">X</a>
							</td>
						</tr>
                                                <%}}%>
					</tbody>
				</table>
                      		<%if(articulos == null){%>
                                <span><h4> No Hay Articulos en el Carrito</h4></span>
                                <%}%>
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>Informacion General</h3>
				
			</div>
			<div class="row">
			
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
                                                        <li>Sub Total <span id="subtotal">$<%= formatea.format(total) %></span></li>
							<li>Costo Envio<span>$8.500</span></li>
                                                        <li>Total <span id="total">$<%= formatea.format(total + 8500) %></span></li>
						</ul>
							
							<a class="btn btn-default check_out" href="revisar.jsp">Comprar</a>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->

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
    <script src="js/carrito.js"></script>
</body>
</html>