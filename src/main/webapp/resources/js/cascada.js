/**
 * Created by jeanbernard on 11/20/15.
 */

$(document).ready(function() {
    if($('h1').is('.editarEmpleado') || $('h1').is('.crearEmpleado')) {
        fillDropdownDept();
        autoCompleteField();
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

function autoCompleteField() {

    var test;

    $("#ingresos-criteria").autocomplete({
        minLength: 0,
        source : function (request, response) {
            $.ajax({
                url: "json/ingresos",
                dataType: 'json',
                contentType:"application/json",
                success: function(ingresosData) {
                    response($.map(ingresosData, function(item){
                        test = item.nombre;
                        return {
                            label : item.nombre
                        }
                    }))
                }
            })
        },
        messages: {
            noResults: '',
            results: function() {}
        },
        select: function(event, ui) {
            $("#ingresos-criteria").val(ui.item.label);
            addIngreso(ui.item);
            return false;
        },
        close: function() {
            $("#ingresos-criteria").val("");
        }
    });

}

function addIngreso(ingresosData) {
    var tdValue = $("<td></td>");
    $(tdValue).append(ingresosData.label);

    var tr = $("<tr></tr>");
    $(tr).attr("id", ingresosData.code);
    $(tr).append(tdValue);

    $("#ingresos-list").append(tr);

}