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
PrimeFaces.locales['es'] = { 
closeText: 'Cerrar', 
prevText: 'Anterior', nextText: 'Siguiente', monthNames: ['Enero','Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'], monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun','Jul','Ago','Sep','Oct','Nov','Dic'], dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'], dayNamesShort: ['Dom','Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'], dayNamesMin: ['D','L','M','X','J','V','S'], weekHeader: 'Semana', firstDay: 1, isRTL: false, showMonthAfterYear: false, yearSuffix: '', timeOnlyTitle: 'Sólo hora', timeText: 'Tiempo', hourText: 'Hora', minuteText: 'Minuto', secondText: 'Segundo', currentText: 'Fecha actual', ampm: false, month: 'Mes', week: 'Semana', day: 'Día', allDayText : 'Todo el día' };