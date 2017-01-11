
<%@page import="java.text.DecimalFormat"%>
<%@page import="Modelos.Consulta"%>
<%@page import="Clases.Suscripcion"%>
<%@page import="Clases.Usuario"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession(true);
   
    Usuario usu = sesion.getAttribute("Usuario") == null ? new Usuario() : (Usuario) sesion.getAttribute("Usuario");
    Consulta consultica = new Consulta();
    Suscripcion suscripcion = consultica.obtenerSuscripcion(usu.getId_suscripcion());
    DecimalFormat formatea = new DecimalFormat("###,###.##");
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Pago Suscripcion</title>
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
				<h2 class="heading">Pago De Suscripcion</h2>
			</div>

			<div class="shopper-informations">
				<div class="row">

					<div class="col-sm-6 clearfix">
						<div class="bill-to">
							<p>Informacion</p>
							<div class="step-one">
								<form>
									<div class="step-one"><h4 class="heading"><B>Id: </B> <%= usu.getId_identificacion()%></h4></div>
                                                                        <div class="step-one"><h4 class="heading"><B>Nombre: </B> <%= usu.getNombres() %> <%= usu.getApellidos() %></h4></div>
                                                                        <div class="step-one"><h4 class="heading"><B>Correo: </B> <%= usu.getCorreo() %></h4></div>
                                                                        <div class="step-one"><h4 class="heading"><B>Direccion: </B> <%= usu.getDireccion() %></h4></div>
                                                                        <div class="step-one"><h4 class="heading"><B>Domicilio: </B> <%= usu.getDomicilio() %></h4></div>
                                                     		</form>
							</div>
							
						</div>
					</div>
									
				</div>
			</div>
			<div class="review-payment">
				<h2>Revisar y Pagar</h2>
			</div>
                        <% if(usu.getId_suscripcion().compareTo("1")==0){ %>                                            
			<div class="table-responsive cart_info">
                        <form method="post" action="pagar" target="top">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Identificacion</td>
							<td class="description"></td>
							<td class="price">Suscripcion</td>							
							<td class="total">Total</td>
							<td></td>
						</tr>
                
					</thead>
					<tbody>
                                                <tr >
							<td class="cart_product"><%= suscripcion.getId_suscripcion() %></td>
							<td class="cart_description"></td>
							<td class="cart_price"><%= suscripcion.getNombre() %></td>							
                                                        <td class="cart_total"><%= formatea.format(suscripcion.getCosto()) %></td>
							<td></td>
						</tr>
                                         
                                                		<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
                                                                    
									
									<tr>
										<td>Total</td>
										<td><span>$<%= formatea.format(suscripcion.getCosto()) %></span></td>
                                                                                
                                                                                <input type="submit" class="btn btn-default check_out" id="BtnPagar" name="BtnPagar" value="Pagar">
                                                                                
									</tr>
                                                                    
								</table>
							</td>
					</tbody>
				</table>
                        </form>
			</div>
                        <% }%>
                        <% if(usu.getId_suscripcion().compareTo("2")==0){%>
                        
                        <div class="table-responsive cart_info">
                            <form method="post" action="pagar" target="top">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Identificacion</td>
							<td class="description"></td>
							<td class="price">Suscripcion</td>							
							<td class="total">Periodicidad</td>
							<td></td>
						</tr>
                
					</thead>
					<tbody>
                                                <tr >
							<td class="cart_product"><%= suscripcion.getId_suscripcion() %></td>
							<td class="cart_description"></td>
							<td class="cart_price"><%= suscripcion.getNombre() %></td>							
                                                        <td class="cart_total">
                                                            <select name="select-periodicidad" size="1" id="select-periodicidad" >
                                                                                        <option selected value="1">$20.000      Semanal</option>
                                                                                        <option value="2">$22.500       Quincenal</option> 
                                                                                        <option value="3">$25.000       Mensual</option> 
                                                                                    </select>
                                                            
                                                        </td>
							<td></td>
						</tr>
                                         
                                                		<td colspan="4">&nbsp;</td>
							<td colspan="2">
								<table class="table table-condensed total-result">
                                                                    
									
									<tr>
										
                                                                                <td><span>
                                                                                    
                                                                                        
                                                                                </span></td>
                                                                               
                                                                                <input type="submit" class="btn btn-default check_out" id="BtnPagar" name="BtnPagar" value="Pagar">
									</tr>
                                                                    
								</table>
							</td>
					</tbody>
				</table>
                        </form>
			</div>
                        <% }%>
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