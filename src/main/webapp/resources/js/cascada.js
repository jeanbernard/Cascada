/**
 * Created by jeanbernard on 11/20/15.
 */

$(document).ready(function() {

    if($('h1').is('.editarEmpleado')) {
        fillDropdownDept(function(){
            $("#departamentosDropdown").val($("#deptEmpleado").val());
            fillDropdownPuestos();
        });
        autoCompleteField();
    }

    if($('h1').is('.crearEmpleado')) {
        fillDropdownDept();
        autoCompleteField();
    }

    if($("#departamentosDropdown").change(function() {
            fillDropdownPuestos();
        }));

    //$("#search-form").submit(function(event) {
    //
    //    // Prevent the form from submitting via the browser.
    //    event.preventDefault();
    //    searchViaAjax();
    //
    //});

});




function fillDropdownDept(callbackFunction) {

    var departamentoURL = "json/departamentos";

    return $.ajax({
        type: "GET",
        url: departamentoURL,
        dataType: 'json',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#departamentosDropdown").append('<option value="' + data[i].departamentoId + '">'
                    + data[i].nombre);

            }
            if (callbackFunction) {
                callbackFunction();
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

    $("#ingresos-criteria").autocomplete({
        minLength: 0,
        source : function (request, response) {
            $.ajax({
                url: "json/ingresos",
                dataType: 'json',
                contentType:"application/json",
                success: function(ingresosData) {
                    response($.map(ingresosData, function(item){
                        return {
                            label : item.nombre,
                            code : item.ingresoId,
                            name : item.nombre
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

var adddedIngresos = new Array();

function searchViaAjax() {
    $.ajax({
        type : "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url : "http://localhost:8080/empleado/crearEmpleado",
        data : JSON.stringify(adddedIngresos),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
        },
        error : function() {
            console.log("ERROR");
        },
        done : function() {
            console.log("DONE");
        }
    });
}

function addIngreso(ingresosData) {
    var tdValue = $("<td></td>");
    $(tdValue).append(ingresosData.label);

    var tdAction = $("<td></td>");
    //$(tdAction).append("<button type='button' onclick='removeDiagnosis(this);' class='btn btn-danger btn-rounded btn-condensed btn-sm'><span class='fa fa-times'></span></button>");

    var tr = $("<tr></tr>");
    $(tr).attr("id", ingresosData.code);
    $(tr).append(tdValue);
    //$(tr).append(tdAction);

    $("#ingresos-list").append(tr);

    adddedIngresos.push({
        codigo : ingresosData.code,
        nombre : ingresosData.name
    });
}

