<!doctype html>

<head>
<meta charset="utf-8">
<title>Master</title>
<meta name="generator" content="WYSIWYG Web Builder 11 - http://www.wysiwygwebbuilder.com">
<link href="css/Proyecto.css" rel="stylesheet">
<link href="css/master.css" rel="stylesheet">
</head>

<div id="container">

</div>
<div id="PageHeader1" style="position:absolute;text-align:center;left:0px;top:0px;width:100%;height:134px;z-index:7777;">
<div id="PageHeader1_Container" style="width:994px;position:relative;margin-left:auto;margin-right:auto;text-align:left;">
<div id="wb_Image1" style="position:absolute;left:23px;top:0px;width:114px;height:110px;z-index:0;">
<img src="css/images/cafe-col.png" id="Image1" alt=""></div>
<div id="wb_TextArt1" style="position:absolute;left:148px;top:12px;width:469px;height:52px;z-index:1;">
<img src="css/images/img0004.png" id="TextArt1" alt="Caf&#233; Mi Tierra" title="Caf&#233; Mi Tierra" style="width:469px;height:52px;"></div>
<div id="wb_CssMenu1" style="position:absolute;left:625px;top:80px;width:369px;height:30px;text-align:center;z-index:2;">
    

    
<ul>
<li class="firstmain"><a href="./productos.jsp" target="ventana" title="index">Productos</a>
</li>
<li><a href="./cart.jsp" target="ventana" title="productos">Carrito</a>
</li>
<li><a href="./ranking.jsp" target="ventana" title="ranking">Ranking</a>
</li>
<li><a href="./contactenos.jsp" target="ventana" title="contactenos">Contactenos</a>
</li>
</ul>
</div>
    <div id="NOM" style="position:absolute;left:800px;top:5px;width:369px;height:30px;text-align:center;z-index:2;">
    
    <div id="wb_Image1" style="position:absolute;left:130px;top:0px;width:30px;height:30px;z-index:0;">
    <img src="css/images/icono.png" id="Image1" alt=""></div>    
    <ul>
        <li>
            <div id="wb_Image1" style="position:absolute;left:160px;top:0px;width:30px;height:30px;z-index:0;">
            <jsp:useBean id="Usuario" scope="session" class="Clases.Usuario" />
            <h6><FONT COLOR="white"><jsp:getProperty name="Usuario" property="usuario" /></FONT></h6>
            </div> 
        </li>
        <li>
            <form method="post" action="CerrarSesion" target="top" >
            <input type="submit" id="BtnCerrar" name="BtnCerrar" value="" style=" background: url('css/images/cerrar_sesion1.png');position:absolute;left:150px;top:40px;width:95px;height:27px;z-index:0;" >
            
        </form>
        </li>
    </ul>
    </div>

    
</div>
</div>
<div id="Layer1" style="position:absolute;text-align:center;left:0%;top:134px;width:99.7988%;height:9px;z-index:5;">
<div id="Layer1_Container" style="width:992px;position:relative;margin-left:auto;margin-right:auto;text-align:left;">
</div>
</div>


