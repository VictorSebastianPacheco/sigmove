function contacto(){
    var correo = document.getElementById("correo").value;
    var nombre = document.getElementById("nombre").value;
    var telefono = document.getElementById("telefono").value;
    var mensaje = document.getElementById("mensaje").value;

    expresion = /\w+@\w+\.+[a-z]/;

    if(correo === "" || nombre === "" || telefono === "" || mensaje === ""){
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
    else if(telefono.length>=11){
        alert("Telefono incorrecto");
        return false;
    }
    else if(mensaje.length<=500){
        alert("Gracias por preferirnos, en el transcurso del día se comunican contigo")
        window.location.href="index.html";
    }
}