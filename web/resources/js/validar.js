function validar(){

    var correo = document.getElementById("correo").value;
    var clave = document.getElementById("clave").value;

    expresion = /\w+@\w+.+[a-z]/;

    if(correo === "" || clave === ""){
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
    else if(clave.length>=9){
        alert("Contraseña demasiado larga");
        return false;
    }
    else if(clave.length<=7){
        alert("Contraseña demasiado corta");
        return false;
    }
    else if(correo==="admin@mars.com" && clave==="45587982"){
        alert("Ingreso correcto")
        window.location.href="admi/inicio.lum.xhtml";
    }
    
    else if(correo==="asist@mars.com" && clave==="46482785"){
        alert("Ingreso correcto")
        window.location.href="asistente/inicio.lum.xhtml";
    }
    else if(correo==="cliente1@hotmail.com" && clave==="36785941"){
        alert("Ingreso correcto")
        window.location.href="cliente/inicio.lum.xhtml";
    }
    else{
        alert("Contraseña incorrecta");
    }
}
