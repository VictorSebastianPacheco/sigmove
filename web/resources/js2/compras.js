function validarcom(){
    var nombrep = document.getElementById("nombrep").value;
    var telefonop = document.getElementById("telefonop").value;
    var direccion = document.getElementById("direccion").value;
    var comentarios = document.getElementById("comentarios").value;
    var nombrepre = document.getElementById("nombrepre").value;
    var cantidad = document.getElementById("cantidad").value;
    var nombre = document.getElementById("nombre").value;
    var apellido = document.getElementById("apellido").value;
    var correo = document.getElementById("correo").value;
    var telefono = document.getElementById("telefono").value;

    expresion = /\w+@\w+\.+[a-z]/;

    if(nombrep === "" || telefonop === "" || direccion === "" || comentarios === "" || nombrepre === "" || cantidad === "" || nombre === "" || apellido === "" || correo === "" || telefono === ""){
        alert("Todos los campos son obligatorios");
        return false;
    }
    else if (correo.length>30){
        alert("El correo tiene muchos caracteres");
        return false;
    }
    else if(!expresion.test(correo)){
        alert("El correo no es valido");
        return false;
    }
    else if (nombre.length>=45){
        alert("Supera el rango maximo");
        return false;
    }
    else if (apellido.length>=45){
        alert("Supera el rango maximo");
        return false;
    }
    else if (nombrepre.length>=45){
        alert("Supera el rango maximo");
        return false;
    }
    else if (nombrep.length>=45){
        alert("Supera el rango maximo");
        return false;
    }
    else if (cantidad.length>=5){
        alert("Supera el rango maximo");
        return false;
    }
    else if (telefono.length>=11){
        alert("Telefóno invalido");
        return false;
    }
    else if (telefonop.length>=11){
        alert("Telefóno invalido");
        return false;
    }
    else if (direccion.length>40){
        alert("Supera el rango establecido");
        return false;
    }
    else if (comentarios.length>=300){
        alert("Supera el rango establecido");
        return false;
    }
    if(nombrep !== "" || telefonop !== "" || direccion !== "" || comentarios !== "" || nombrepre !== "" || cantidad !== "" || nombre !== "" || apellido !== "" || correo !== "" || telefono !== ""){
        alert("Información almacenada exitosamente");
    }
}