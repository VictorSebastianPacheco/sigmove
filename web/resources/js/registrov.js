function registrovali(){
    var nombre = document.getElementById("nombre").value;
    var apellido = document.getElementById("apellido").value;
    var email = document.getElementById("email").value;
    var pass = document.getElementById("pass").value;
    var confpass = document.getElementById("confpass").value;

    expresion = /\w+@\w+\.+[a-z]/;

    if(nombre === "" || apellido === "" || email === "" || pass === "" || confpass === ""){
        alert("Todos los campos son obligatorios");
        return false;
    }
    else if (email.length>30){
        alert("El correo tiene muchos caracteres");
        return false;
    }
    else if(!expresion.test(email)){
        alert("El correo no es valido");
        return false;
    }
    else if(pass.length>=9){
        alert("Contraseña demasiado larga");
        return false;
    }
    else if(pass.length<=7){
        alert("Contraseña demasiado corta");
        return false;
    }
    else if(confpass!=pass){
        alert("Contraseña no coincide");
        return false;
    }
    else if(confpass==pass){
        alert("Registro exitoso, por favor inicie sesión")
        window.location.href="login.html";
    }
}