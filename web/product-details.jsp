<%@page import="java.text.DecimalFormat"%>
<%@page import="Controladores.ControladorProductos"%>
<%@page import="Clases.Producto"%>
<!DOCTYPE html>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    Producto producto = new ControladorProductos().getProducto(id);
    DecimalFormat formatea = new DecimalFormat("###,###.##");
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Detalle Producto</title>
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
		<div class="header-middle"><!--header-middle-->
			<div class="container">
			</div>
		</div><!--/header-middle-->	
	</header><!--/header-->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-9 padding-right">
					<div class="product-details"><!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
                                                            <img src="<%= producto.getImagen() %>" alt="" />
							</div>
						</div>
						<div class="col-sm-7">
							<div class="product-information"><!--/product-information-->
                                                                <h2><%= producto.getNombre()  %></h2>
                                                                <p>Web ID: <%= producto.getId() %></p>
                                                                <form action="agregarproducto" method="post" >
								<span>
                                                                    <span>$<%= formatea.format(producto.getPrecio())  %></span>
									<label>Cantidad:</label>
                                                                        <input type="text" value="1" id="CantidadProducto" name="CantidadProducto"/>
                                                                        <input type="hidden" value="<%= producto.getId() %>" id="idProducto" name="idProducto"/>
									<button type="submit" class="btn btn-fefault cart">
										<i class="fa fa-shopping-cart"></i>
										Agregar Al Carrito
									</button>
								</span>
                                                                </form>        
								<p><b>Disponibilidad:</b> En Stock</p>
								<p><b>Condicion:</b> Nuevo</p>
								
							</div><!--/product-information-->
						</div>
					</div><!--/product-details-->					
					<div class="category-tab shop-details-tab"><!--category-tab-->
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								<li><a href="#detalles" data-toggle="tab">Detalles</a></li>
                                                		<li class="active"><a href="#comentarios" data-toggle="tab">Comentarios</a></li>
							</ul>
						</div>
						<div class="tab-content">
							<div class="tab-pane fade" id="detalles" >
								<p>Detalles del producto.</p>						
							</div>						
							<div class="tab-pane fade active in" id="comentarios" >
								<div class="col-sm-12">
                                                                	
									<p><b>Escribe tus Comentarios</b></p>
									
									<form action="#">
										<textarea name="" ></textarea>
										
										<button type="button" class="btn btn-default pull-right">
											OK
										</button>
									</form>
								</div>
							</div>							
						</div>
					</div><!--/category-tab-->	
				</div>
			</div>
		</div>
	</section>  
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
		
	</footer>
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>