<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Creacion Productos</title>
<meta name="generator" content="WYSIWYG Web Builder 11 - http://www.wysiwygwebbuilder.com">
<link href="css/Proyecto.css" rel="stylesheet">
<link href="css/catalogo.css" rel="stylesheet">
<script type="text/javascript" src="js/productos.js"></script>
</head>

<style>
            li span {
                color:#fff;
                border:1px solid #ccc;
                background-color:#808080;
                margin-right:10px;
                padding: 0 2px;
                border-radius:4px;
                -moz-border-radius:4px;
                -webkit-border-radius:4px;
                -o-border-radius:4px;
                border-radius:4px;
                font-weight:bold;
                font-size:0.8em;
                cursor:pointer;
            }
</style>

<body>
<div id="container">
<div id="wb_TextContact" style="position:absolute;left:201px;top:78px;width:608px;height:100px;z-index:0;">
<img src="css/images/creacionp.png" id="TextContact" alt="Creacion De Catalogos" title="Creacion De Catalogos" style="width:608px;height:100px;"></div>
<form method="post" action="ManejadorCatalogo">
    <input type="submit" id="IngresarProducto" name="IngresarProducto" value="Ingresar Producto" style="position:absolute;left:449px;top:625px;width:177px;height:25px;z-index:1;">
    
    <input type="file" value="css\images\productos" id="Ruta" style="position:absolute;left:609px;top:231px;width:198px;height:21px;line-height:21px;z-index:2;" name="Ruta">
    
    <input type="text" id="EditIdProducto" style="position:absolute;left:339px;top:231px;width:86px;height:18px;line-height:18px;z-index:3;" name="EditIdProducto" value="">
    <label for="" id="Label1" style="position:absolute;left:201px;top:226px;width:130px;height:29px;line-height:29px;z-index:4;">Id Producto:</label>
    <label for="" id="Label2" style="position:absolute;left:201px;top:263px;width:130px;height:29px;line-height:29px;z-index:5;">Nombre:</label>
    <label for="" id="Label3" style="position:absolute;left:201px;top:504px;width:130px;height:29px;line-height:29px;z-index:6;">Descripcion:</label>
    <input type="text" id="EditNombreProducto" style="position:absolute;left:339px;top:268px;width:86px;height:18px;line-height:18px;z-index:7;" name="EditNombreProducto" value="">
    <label for="" id="Label4" style="position:absolute;left:449px;top:226px;width:130px;height:29px;line-height:29px;z-index:8;">Imagen:</label>
    <label for="" id="Label5" style="position:absolute;left:201px;top:300px;width:130px;height:29px;line-height:29px;z-index:9;">Precio:</label>
    <label for="" id="Label6" style="position:absolute;left:201px;top:411px;width:130px;height:29px;line-height:29px;z-index:10;">Descuento:</label>
    <label for="" id="Label7" style="position:absolute;left:201px;top:337px;width:130px;height:29px;line-height:29px;z-index:11;">Cantidad:</label>
    <label for="" id="Label8" style="position:absolute;left:201px;top:374px;width:130px;height:29px;line-height:29px;z-index:12;">Costo:</label>
    <label for="" id="Label9" style="position:absolute;left:449px;top:263px;width:152px;height:29px;line-height:29px;z-index:13;">Tipo Producto:</label>
    <label for="" id="Label10" style="position:absolute;left:449px;top:412px;width:141px;height:29px;line-height:29px;z-index:14;">Presentacion:</label>
    <label for="" id="Label11" style="position:absolute;left:449px;top:300px;width:130px;height:29px;line-height:29px;z-index:15;">Region:</label>
    <label for="" id="Label12" style="position:absolute;left:201px;top:448px;width:120px;height:24px;line-height:24px;z-index:16;">Finca:</label>
    <label for="" id="Label13" style="position:absolute;left:449px;top:337px;width:130px;height:29px;line-height:29px;z-index:17;">Variedad:</label>
    <label for="" id="Label14" style="position:absolute;left:449px;top:447px;width:130px;height:29px;line-height:29px;z-index:18;">Perfil:</label>
    <label for="" id="Label15" style="position:absolute;left:449px;top:374px;width:130px;height:29px;line-height:29px;z-index:19;">Cosecha:</label>
    <input type="text" id="EditPrecioProducto" style="position:absolute;left:339px;top:305px;width:86px;height:18px;line-height:18px;z-index:20;" name="EditPrecioProducto" value="">
    <input type="text" id="EditCantidadProducto" style="position:absolute;left:339px;top:342px;width:86px;height:18px;line-height:18px;z-index:21;" name="EditCantidadProducto" value="">
    <input type="text" id="EditCostoProducto" style="position:absolute;left:339px;top:379px;width:86px;height:18px;line-height:18px;z-index:22;" name="EditCostoProducto" value="">
    <input type="text" id="EditDescuentoProducto" style="position:absolute;left:339px;top:416px;width:86px;height:18px;line-height:18px;z-index:23;" name="EditDescuentoProducto" value="">
    <input type="text" id="EditFinca" style="position:absolute;left:339px;top:451px;width:86px;height:18px;line-height:18px;z-index:30;" name="EditFinca" value="">
    <select name="SeleccionTipo" size="1" id="SeleccionTipo" style="position:absolute;left:609px;top:265px;width:200px;height:28px;z-index:24;">
        <option selected value="caf">CAFÉ</option>
        <option value="art">ARTICULO</option>
    </select>
    <select name="SeleccionRegion" size="1" id="SeleccionRegion" style="position:absolute;left:609px;top:302px;width:200px;height:28px;z-index:25;">
        <option selected value="ant">Antioquia</option>
        <option value="boy">Boyaca</option>
        <option value="cal">Caldas</option>
        <option value="cau">Cauca</option>
        <option value="ces">Cesar</option>
        <option value="cun">Cundinamarca</option>
        <option value="hui">Huila</option>
        <option value="nar">Nariño</option>
        <option value="sat">Santander</option>
        <option value="qui">Quindio</option>
        <option value="ris">Risaralda</option>
        <option value="tol">Tolima</option>
        <option value="val">Valle</option>
    </select>
    <select name="SeleccionVariedad" size="1" id="SeleccionVariedad" style="position:absolute;left:609px;top:339px;width:200px;height:28px;z-index:26;">
        <option selected value="cit">Citrico</option>
        <option value="dul">Dulce</option>
        <option value="ave">Avellana</option>
        <option value="fru">Frutal</option>
        <option value="ach">Achocolatado</option>
        <option value="est">Estándar</option>
        <option value="fra">Frambuesa</option>
        <option value="her">Herbal</option>
    </select>
    <select name="SeleccionCosecha" size="1" id="SeleccionCosecha" style="position:absolute;left:609px;top:376px;width:200px;height:28px;z-index:27;">
        <option selected value="cp1">Principal(sep-dic)</option>
        <option value="cp2">Principal(mar-jun)</option>
        <option value="mi1">mitaca(abri-may)</option>
        <option value="mi2">mitaca(oct-nov)</option>
    </select>
    <select name="SeleccionPresentacion" size="1" id="SeleccionPresentacion" style="position:absolute;left:609px;top:413px;width:200px;height:28px;z-index:28;">
        <option selected value="mol">Molido</option>
        <option value="gra">Grano</option>
    </select>
    <select name="SeleccionPerfil" size="1" id="SeleccionPerfil" style="position:absolute;left:609px;top:448px;width:200px;height:28px;z-index:29;">
        <option selected value="sua">Suave</option>
        <option value="med">Medio</option>
        <option value="fue">Fuerte</option>
    </select>
    <textarea name="AreaDescripcion" id="AreaDescripcion" style="position:absolute;left:367px;top:504px;width:432px;height:90px;z-index:31;" rows="4" cols="69"></textarea>
</form>
<div id="wb_TextPro" style="position:absolute;left:293px;top:700px;width:400px;height:400px;z-index:0;">
    <font color="white">PRUEBA</font>
        <ul id="listaProductos">
            
        </ul>
</div>

</div>
    

</body>
</html>
