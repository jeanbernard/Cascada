/**
 * Created by jeanbernard on 11/20/15.
 */

$(document).ready(function() {
    if($('h1').is('.editarEmpleado') || $('h1').is('.crearEmpleado')) {
        fillDropdownDept();
    }

    if($("#departamentosDropdown").change(function() {
            fillDropdownPuestos();
        }));

});


function fillDropdownDept() {

    var departamentoURL = "json/departamentos";

    $.ajax({
        type: "GET",
        url: departamentoURL,
        dataType: 'json',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#departamentosDropdown").append('<option value="' + data[i].departamentoId + '">'
                    + data[i].nombre);

            }
        }
    });
}

function fillDropdownPuestos() {

    $("#puestosDropdown").empty();
    var puestoURL = "json/puestos/";

    $.ajax({
        type: "GET",
        url: puestoURL,
        dataType: 'json',
        contentType: "application/json",
        data : {departamentoId : $("#departamentosDropdown").val()},
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#puestosDropdown").append('<option value="' + data[i].puestoId + '">'
                    + data[i].nombre);

            }
        }
    });
}