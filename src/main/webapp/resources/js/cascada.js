/**
 * Created by jeanbernard on 11/20/15.
 */

$(document).ready(function() {
    if($('h1').is('.crearPuesto')) {
        fillDropdownDept();
    }
});


function fillDropdownDept() {

    var departamentoURL = "json/departamentos"

    $.ajax({
        type: "GET",
        url: departamentoURL,
        dataType: 'json',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#departments").append('<option value="' + data[i].nombre + '">'
                    + data[i].nombre);
            }
        }
    });
}
