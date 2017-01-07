/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    $('tr #deleteitem').click(function(e){
        e.preventDefault();
        var elemento = $(this);
        var idproducto = elemento.parent().find('#idarticulo').text();
        $.ajax({
                url : 'borraritem',
                type : 'post',
                data : {idproducto : idproducto},
                success : function(r){
                    elemento.parent().parent().remove();
                    var elementostabla = $('#tabla-contenedor tr');
                    if(elementostabla.length <= 1)
                    {
                        $('#cart-contenedor').append("<h4> No Hay Articulos en el Carrito</h4>");
                    }
                    var numero = parseInt(r);
                    var numtotal = numero + 8500;
                    $('#subtotal').text(numero); 
                    $('#total').text(numtotal);
                }
                })
    });

})
