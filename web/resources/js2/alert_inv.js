function alert_inv(){

    var cantidad = document.getElementById("cantidad").value;
    var costo_unitario = document.getElementById("costo_unitario").value;
    var costo_total = document.getElementById("costo_total").value;

    expresion = /\w+@\w+.+[a-z]/;

    if(cantidad === "" || costo_unitario === ""|| costo_total === ""){
        alert("Todos los campos son obligatorios");
        return false;
    }
    else if (cantidad.length<0){
        alert("Incluir un valor");
        return false;
    }
    else if (costo_unitario.length<0){
        alert("Incluir el costo unitario");
        return false;
    }
    else if (costo_total.length<0){
        alert("Incluir el costo total");
        return false;
    }
   
    }
    

