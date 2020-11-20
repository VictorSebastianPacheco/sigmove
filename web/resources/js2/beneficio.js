function enviarformulario(){
	var codigo1 = document.getElementById("codigo1").value;
	var codigo2 = document.getElementById("codigo2").value;

	expresion = /\w+@\w+.+[a-z]/;
	if(codigo1 === "" || codigo2 === ""){
        alert("Todos los campos son obligatorios");
        return false;
    }
    else if(codigo1.length>=9){
        alert("Codigo incorrecto");
        return false;
    }
    else if(isNaN(codigo1)){
        alert("No se reconoce código Beneficio");
        return false;
    }
    else if(codigo2.length>=9){
        alert("Codigo incorrecto");
        return false;
    }
    else if(isNaN(codigo2)){
        alert("No se reconoce código Producto");
        return false;
    }
    if(codigo1 !== "" || codigo2 !== ""){
        alert("Envio exitoso");
    }
}