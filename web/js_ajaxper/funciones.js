/***** FUNCIONES DE VALIDACI�N DE DATOS *****/
// FORMULARIO PROYECTO 
function abrirVentana(url, wi, he) {
    window.open(url, "nuevo", "directories=no, location=no, menubar=no, scrollbars=no, statusbar=no, tittlebar=no, width=" + wi + ", height=" + he + "");
}
function abrirVentanaNuevoTiempo(url, wi, he) {
    window.open(url, "nuevo", "directories=no, location=no, menubar=no, scrollbars=no, statusbar=no, tittlebar=no, width=" + wi + ", height=" + he + "");
}
// Se abre una nueva ventana
var newwindow;
function ventana_busq(url, ventana, width, heigh)
{
    newwindow = window.open(url, ventana, 'directories=no, location=no, menubar=no, tittlebar=no, statusbar=no, scrollbars=no, resizable=no, height=' + heigh + ', width=' + width + '');
    if (window.focus) {
        newwindow.focus();
    }
}
function ventana_busq_centro(url, ventana, width, heigh)
{
    newwindow = window.open(url, ventana, 'left=390, top=200, directories=no, location=no, menubar=no, tittlebar=no, statusbar=no, scrollbars=no, resizable=no, height=' + heigh + ', width=' + width);
    if (window.focus) {
        newwindow.focus();
    }
}
function AgregarLider2(id_lider, nombre_lider) {
    window.opener.document.grupo_periodo.id_lider.value = id_lider;
    window.opener.document.grupo_periodo.nombre_lider.value = nombre_lider;
}
function AgregarLider_asoc(id_lider_asoc, nombre_lider_asoc) {
    window.opener.document.grupo_periodo.id_lider_asoc.value = id_lider_asoc;
    window.opener.document.grupo_periodo.nombre_lider_asoc.value = nombre_lider_asoc;
}


function msj(div, mensaje) {
    var val = document.getElementById(div).innerHTML = mensaje;
    return val;
}
function clean_msj(div) {
    return document.getElementById(div).style.display = 'none';
}
function ver_msj(div) {
    return document.getElementById(div).style.display = 'block';
}

/*   Registrar contratos.persona */
function nombresPersona(form) {
    var valor;
    if (form.nombres.value == 0) {
        ver_msj('msg_nombres_persona');
        msj('msg_nombres_persona', ' * Ingrese nombres.');
        form.nombres.value = "";
        form.nombres.focus();
        event.returnValue = false;
    }
    else {
        clean_msj('msg_nombres_persona');
    }
    return valor;
}
function apepatPersona(form) {
    var valor;
    if (form.apepat.value == 0) {
        ver_msj('msg_apepat_persona');
        msj('msg_apepat_persona', ' * Ingrese apellido paterno.');
        form.apepat.value = "";
        form.apepat.focus();
        event.returnValue = false;
    }
    else {
        clean_msj('msg_apepat_persona');
    }
    return valor;
}
function apematPersona(form) {
    var valor;
    if (form.apemat.value == 0) {
        ver_msj('msg_apemat_persona');
        msj('msg_apemat_persona', ' * Ingrese el apellido materno.');
        form.apemat.value = "";
        form.apemat.focus();
        event.returnValue = false;
    }
    else {
        clean_msj('msg_apemat_persona');
    }
    return valor;
}
function sexoPersona(form) {
    var valor;
    if (form.sexo.value == 0) {
        ver_msj('msg_sexo_persona');
        msj('msg_sexo_persona', ' * Seleccione sexo.');
        form.sexo.value = "";
        form.sexo.focus();
        event.returnValue = false;
    }
    else {
        clean_msj('msg_sexo_persona');
    }
    return valor;
}
function direccion_procedPersona(form) {
    var valor;
    if (form.direccion_proced.value == 0) {
        ver_msj('msg_direccion_proced_persona');
        msj('msg_direccion_proced_persona', ' * Ingrese la direccion.');
        form.direccion_proced.value = "";
        form.direccion_proced.focus();
        event.returnValue = false;
    }
    else {
        clean_msj('msg_direccion_proced_persona');
    }
    return valor;
}
function direccion_actualPersona(form) {
    var valor;
    if (form.direccion_actual.value == 0) {
        ver_msj('msg_direccion_actual_persona');
        msj('msg_direccion_actual_persona', ' * Ingrese la direccion.');
        form.direccion_actual.value = "";
        form.direccion_actual.focus();
        event.returnValue = false;
    }
    else {
        clean_msj('msg_direccion_actual_persona');
    }
    return valor;
}
function id_persona_tipoPersona(form) {
    var valor;
    if (form.id_persona_tipo.value == 0) {
        ver_msj('msg_id_persona_tipo_persona');
        msj('msg_id_persona_tipo_persona', ' * Seleccione tipo persona.');
        form.id_persona_tipo.value = "";
        form.id_persona_tipo.focus();
        event.returnValue = false;
    }
    else {
        clean_msj('msg_id_persona_tipo_persona');
    }
    return valor;
}
function id_religionPersona(form) {
    var valor;
    if (form.id_religion.value == 0) {
        ver_msj('msg_id_religion_persona');
        msj('msg_id_religion_persona', ' * Seleccione la religion.');
        form.id_religion.value = "";
        form.id_religion.focus();
        event.returnValue = false;
    }
    else {
        clean_msj('msg_id_persona_tipo_persona');
    }
    return valor;
}
function id_paisPersona(form) {
    var valor;
    if (form.id_pais.value == 0) {
        ver_msj('msg_id_pais_persona');
        msj('msg_id_pais_persona', ' * Sleccione el pais.');
        form.id_pais.value = "";
        form.id_pais.focus();
        event.returnValue = false;
    }
    else {
        clean_msj('msg_id_pais_persona');
    }
    return valor;
}
function departamento1Persona(form) {
    var valor;
    if (form.departamento1.value == 0) {
        ver_msj('msg_departamento1_persona');
        msj('msg_departamento1_persona', ' * Sleccione departamento.');
        form.departamento1.value = "";
        form.departamento1.focus();
        event.returnValue = false;
    }
    else {
        clean_msj('msg_departamento1_persona');
    }
    return valor;
}
function departamentoPersona(form) {
    if (form.id_pais.value != '')
    {
        var valor;
        if (form.departamento.value == 0) {
            ver_msj('msg_departamento_persona');
            msj('msg_departamento_persona', ' * Seleccione departamento.');
            form.departamento.value = "";
            form.departamento.focus();
            event.returnValue = false;
        }
        else {
            clean_msj('msg_departamento_persona');
        }
    }
    else {
        clean_msj('msg_departamento_persona');
    }
    return valor;
}
function provincia1Persona(form) {
    if (form.departamento1.value != '')
    {
        var valor;
        if (form.provincia1.value == 0) {
            ver_msj('msg_provincia1_persona');
            msj('msg_provincia1_persona', ' * Seleccione provincia.');
            form.provincia1.value = "";
            form.provincia1.focus();
            event.returnValue = false;
        }
        else {
            clean_msj('msg_provincia1_persona');
        }
    }
    else {
        clean_msj('msg_provincia1_persona');
    }
    return valor;
}
function provinciaPersona(form) {
    if (form.id_pais.value != '')
    {
        if (form.departamento.value != '')
        {
            var valor;
            if (form.provincia.value == 0) {
                ver_msj('msg_provincia_persona');
                msj('msg_provincia_persona', ' * Seleccione provincia.');
                form.provincia.value = "";
                form.provincia.focus();
                event.returnValue = false;
            }
            else {
                clean_msj('msg_provincia_persona');
            }
        }
        else {
            clean_msj('msg_provincia_persona');
        }
    }
    else {
        clean_msj('msg_provincia_persona');
    }
    return valor;
}
function id_ubigeo_actualPersona(form) {
    if (form.departamento1.value != '')
    {
        if (form.provincia1.value != '')
        {
            var valor;
            if (form.id_ubigeo_actual.value == 0) {
                ver_msj('msg_distrito1_persona');
                msj('msg_distrito1_persona', ' * Seleccione distrito.');
                form.id_ubigeo_actual.value = "";
                form.id_ubigeo_actual.focus();
                event.returnValue = false;
            }
            else {
                clean_msj('msg_distrito1_persona');
            }
        }
        else {
            clean_msj('msg_distrito1_persona');
        }
    }
    else {
        clean_msj('msg_distrito1_persona');
    }
    return valor;
}
function id_ubigeo_procedPersona(form) {
    var valor;

    if (form.id_pais.value != '')
    {
        if (form.departamento.value != '')
        {
            if (form.provincia.value != '')
            {
                if (form.id_ubigeo_proced.value == 0) {
                    ver_msj('msg_id_ubigeo_proced_persona');
                    msj('msg_id_ubigeo_proced_persona', ' * Seleccione distrito.');
                    form.id_ubigeo_proced.value = "";
                    form.id_ubigeo_proced.focus();
                    event.returnValue = false;
                }
                else {
                    clean_msj('msg_id_ubigeo_proced_persona');
                }
            }
            else {
                clean_msj('msg_id_ubigeo_proced_persona');
            }
        }
        else {
            clean_msj('msg_id_ubigeo_proced_persona');
        }
    }
    else {
        clean_msj('msg_id_ubigeo_proced_persona');
    }
    return valor;
}


//-----------------------------------

function direccionPersonaProv(form) {
    var valor;
    if (form.direccion.value == 0) {
        msj('msg_persona', ' * Ingrese la direccion.');
        form.direccion.value = "";
        form.direccion.focus();
        event.returnValue = false;
    }
    return valor;
}
function id_mod_precioPersona(form) {
    var valor;
    if (form.id_mod_precio.value == 0) {
        msj('msg_persona', ' * Seleccione el tipo de cliente o modalidad de precio.');
        form.id_mod_precio.value = "";
        form.id_mod_precio.focus();
        event.returnValue = false;
    }
    return valor;
}

function id_ubigeoPersona(form) {
    var valor;
    if (form.departamento.value != '')
    {
        if (form.provincia.value != '')
        {
            if (form.id_ubigeo.value == 0) {
                msj('msg_persona', ' * Seleccione el <b>distrito</b>.');
                form.id_ubigeo.value = "";
                form.id_ubigeo.focus();
                event.returnValue = false;
            }
        }
    }
    return valor;
}


function RegistrarIntegrante()
{
    var fo = document.persona;
    if (id_religionPersona(fo) == false) {
        return false;
    }
    if (id_persona_tipoPersona(fo) == false) {
        return false;
    }
    if (direccion_actualPersona(fo) == false) {
        return false;
    }
    if (id_ubigeo_actualPersona(fo) == false) {
        return false;
    }
    if (provincia1Persona(fo) == false) {
        return false;
    }
    if (departamento1Persona(fo) == false) {
        return false;
    }
    if (direccion_procedPersona(fo) == false) {
        return false;
    }
    if (id_ubigeo_procedPersona(fo) == false) {
        return false;
    }
    if (provinciaPersona(fo) == false) {
        return false;
    }
    if (departamentoPersona(fo) == false) {
        return false;
    }
    if (id_paisPersona(fo) == false) {
        return false;
    }
    if (sexoPersona(fo) == false) {
        return false;
    }
    if (validaFechaDDMMAAAA(fo.fecha_nac.value) == false) {
        return false;
    }
    if (apematPersona(fo) == false) {
        return false;
    }
    if (apepatPersona(fo) == false) {
        return false;
    }
    if (nombresPersona(fo) == false) {
        return false;
    }
}

function ActualizarIntegrante()
{
    var fo = document.persona;
    if (id_religionPersona(fo) == false) {
        return false;
    }
    if (id_persona_tipoPersona(fo) == false) {
        return false;
    }
    if (direccion_actualPersona(fo) == false) {
        return false;
    }
    if (direccion_procedPersona(fo) == false) {
        return false;
    }
    if (sexoPersona(fo) == false) {
        return false;
    }
    if (validaFechaDDMMAAAA(fo.fecha_nac.value) == false) {
        return false;
    }
    if (apematPersona(fo) == false) {
        return false;
    }
    if (apepatPersona(fo) == false) {
        return false;
    }
    if (nombresPersona(fo) == false) {
        return false;
    }
}


// Validar Inicio
function validarInicio()
{
    var fo = document.inicio;
    opciones = document.getElementsByName("id_periodo");
    var seleccionado = false;
    var rel = "";
    for (var i = 0; i < opciones.length; i++) {
        if (opciones[i].checked) {
            seleccionado = true;
            rel = opciones[i].value;
            break;
        }
    }
    if (!seleccionado) {
        msj('msg_inicio', "Seleccione el <b>periodo</b>.");
        event.returnValue = false;
    }
    opciones1 = document.getElementsByName("id_ugel");
    var seleccionado1 = false;
    var rel1 = "";
    for (var e = 0; e < opciones1.length; e++) {
        if (opciones1[e].checked) {
            seleccionado1 = true;
            rel1 = opciones1[e].value;
            break;
        }
    }
    if (!seleccionado1) {
        msj('msg_inicio', "Seleccione la <b>UGEL</b>.");
        event.returnValue = false;
    }
}



/* Empesamos con evaluacion de Grupos pequeños */
// Insertar grupo
function id_tipo_grupoGrupo(form) {
    var valor;
    if (form.id_tipo_grupo.value == 0) {
        msj('msg_grupo', ' * Seleccione el tipo de grupo');
        form.id_tipo_grupo.value = "";
        form.id_tipo_grupo.focus();
        event.returnValue = false;
    }
    return valor;
}
function nombre_grupoGrupo(form) {
    var valor;
    if (form.nombre_grupo.value == 0) {
        msj('msg_grupo', ' * Ingrese el nombre del grupo');
        form.nombre_grupo.value = "";
        form.nombre_grupo.focus();
        event.returnValue = false;
    }
    else
    {
        if ((form.nombre_grupo.value).length < 5)
        {
            msj('msg_grupo', ' * El nombre es muy corto');
            form.nombre_grupo.focus();
            event.returnValue = false;
        }
    }
    return valor;
}
function RegistrarGrupo()
{
    var fo = document.grupo;
    if (nombre_grupoGrupo(fo) == false) {
        return false;
    }
    if (id_tipo_grupoGrupo(fo) == false) {
        return false;
    }

}

//Inscribir a un en un periodo: La inscripción de los grupos pequeños y demás
function RegistrarGrupo_periodo()
{
    var fo = document.grupo_periodo;
    if (lugar_nuevoGrupo_per(fo) == false) {
        return false;
    }
    if (id_lugarGrupo_per(fo) == false) {
        return false;
    }
    if (id_diaGrupo_per(fo) == false) {
        return false;
    }
    if (id_grupo_depGrupo_per(fo) == false) {
        return false;
    }
    if (id_periodoGrupo_per(fo) == false) {
        return false;
    }
    /*  if(id_lider_asocGrupo_per(fo)== false){
     return false;
     }
     if(id_liderGrupo_per(fo)== false){
     return false;
     }*/
    if (nombre_grupoGrupo_per(fo) == false) {
        return false;
    }
    if (id_tipo_grupoGrupo_per(fo) == false) {
        return false;
    }

}
//Inscribir a un en un periodo: La inscripción de los grupos pequeños y demás
function ActualizarGrupo_periodo()
{
    var fo = document.grupo_periodo;
    if (lugar_nuevoGrupo_periodo(fo) == false) {
        return false;
    }
    if (id_lugarGrupo_per(fo) == false) {
        return false;
    }
    if (id_diaGrupo_per(fo) == false) {
        return false;
    }
    if (id_grupo_depGrupo_per(fo) == false) {
        return false;
    }
    if (id_ent_acadGrupo_per(fo) == false) {
        return false;
    }
    if (nombre_grupoGrupo_per(fo) == false) {
        return false;
    }
}

function id_ent_acadGrupo_per(form) {
    var valor;
    if (form.id_ent_acad_dep.value == 0) {
        msj('msg_grupo_per', ' * Selecione una entidad academica.');
        form.id_ent_acad_dep.value = "";
        form.id_ent_acad_dep.focus();
        event.returnValue = false;
    }
    return valor;
}
function id_tipo_grupoGrupo_per(form) {
    var valor;
    if (form.id_tipo_grupo.value == 0) {
        msj('msg_grupo_per', ' * Falta el tipo de grupo');
        form.id_tipo_grupo.value = "";
        form.id_tipo_grupo.focus();
        event.returnValue = false;
    }
    return valor;
}
function nombre_grupoGrupo_per(form) {
    var valor;
    if (form.nombre_grupo.value == 0) {
        msj('msg_grupo_per', ' * Ingrese el nombre del grupo');
        form.nombre_grupo.value = "";
        form.nombre_grupo.focus();
        event.returnValue = false;
    }
    else
    {
        if ((form.nombre_grupo.value).length < 4)
        {
            msj('msg_grupo_per', ' * El nombre es muy corto');
            form.nombre_grupo.focus();
            event.returnValue = false;
        }
    }
    return valor;
}
function id_liderGrupo_per(form) {
    var valor;
    if (form.id_lider.value == 0) {
        msj('msg_grupo_per', ' * Busque y seleccione un lider.');
        form.id_lider.value = "";
        form.id_lider.focus();
        event.returnValue = false;
    }
    return valor;
}
function id_lider_asocGrupo_per(form) {
    var valor;
    if (form.id_lider_asoc.value == 0) {
        msj('msg_grupo_per', ' * Busque y seleccione un lider asociado.');
        form.id_lider_asoc.value = "";
        form.id_lider_asoc.focus();
        event.returnValue = false;
    }
    return valor;
}
function id_periodoGrupo_per(form) {
    var valor;
    if (form.id_periodo.value == 0) {
        msj('msg_grupo_per', ' * Seleccione el periodo.');
        form.id_periodo.value = "";
        form.id_periodo.focus();
        event.returnValue = false;
    }
    return valor;
}
function id_grupo_depGrupo_per(form) {
    var valor;
    if (form.id_grupo_dep.value == 0) {
        msj('msg_grupo_per', ' * Seleccione el grupo al que pertenece.');
        form.id_grupo_dep.value = "";
        form.id_grupo_dep.focus();
        event.returnValue = false;
    }
    return valor;
}
function id_diaGrupo_per(form) {
    var valor;
    if (form.id_dia.value == 0) {
        msj('msg_grupo_per', ' * Seleccione el dia de reunion.');
        form.id_dia.value = "";
        form.id_dia.focus();
        event.returnValue = false;
    }
    return valor;
}
function id_lugarGrupo_per(form) {
    var valor;
    if (form.id_lugar.value == 0)
    {
        msj('msg_grupo_per', ' * Seleccione el lugar de reunion.');
        form.id_lugar.value = "";
        form.id_lugar.focus();
        event.returnValue = false;
    }
    return valor;
}
function lugar_nuevoGrupo_per(form) {
    var valor;
    if (form.id_lugar.value == '1000') {
        if (form.nuevo_lugar_det.value == 0) {
            msj('msg_grupo_per', ' * Ingrese el lugar de reunion.');
            form.nuevo_lugar_det.value = "";
            form.nuevo_lugar_det.focus();
            event.returnValue = false;
        }
    }
    return valor;
}
function lugar_nuevoGrupo_periodo(form) {
    var valor;
    if (form.id_lugar.value == '100000') {
        if (form.nuevo_lugar_det.value == 0) {
            msj('msg_grupo_per', ' * Ingrese el lugar de reunion.');
            form.nuevo_lugar_det.value = "";
            form.nuevo_lugar_det.focus();
            event.returnValue = false;
        }
    }
    return valor;
}

// Valor Vacío
function FormAjax_bus_int()
{
    var fo = document.buscarint;
    if (valorForm_ajax(fo) == false) {
        return false;
    }
}
function valorForm_ajax(form) {
    var valor;
    if (form.valor.value == 0) {
        msj('msg_buscar', '');
        var obj = document.buscarint.buscar;
        obj.focus();
        if (obj.value != "") {
            obj.value += "";
        }
        event.returnValue = false;
    }
    return valor;
}
function validaFechaDDMMAAAA(fecha) {
    var valor;
    var fech = new Date();
    var dtCh = "/";
    var minYear = 1960;
    var maxYear = fech.getFullYear() - 1;// El año actual
    function isInteger(s) {
        var i;
        for (i = 0; i < s.length; i++) {
            var c = s.charAt(i);
            if (((c < "0") || (c > "9")))
                return false;
        }
        return true;
    }
    function stripCharsInBag(s, bag) {
        var i;
        var returnString = "";
        for (i = 0; i < s.length; i++) {
            var c = s.charAt(i);
            if (bag.indexOf(c) == -1)
                returnString += c;
        }
        return returnString;
    }
    function daysInFebruary(year) {
        return (((year % 4 == 0) && ((!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28);
    }
    function DaysArray(n) {
        for (var i = 1; i <= n; i++) {
            this[i] = 31
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                this[i] = 30
            }
            if (i == 2) {
                this[i] = 29
            }
        }
        return this
    }
    function isDate(dtStr) {
        var daysInMonth = DaysArray(12)
        var pos1 = dtStr.indexOf(dtCh)
        var pos2 = dtStr.indexOf(dtCh, pos1 + 1)
        var strDay = dtStr.substring(0, pos1)
        var strMonth = dtStr.substring(pos1 + 1, pos2)
        var strYear = dtStr.substring(pos2 + 1)
        strYr = strYear
        if (strDay.charAt(0) == "0" && strDay.length > 1)
            strDay = strDay.substring(1)
        if (strMonth.charAt(0) == "0" && strMonth.length > 1)
            strMonth = strMonth.substring(1)
        for (var i = 1; i <= 3; i++) {
            if (strYr.charAt(0) == "0" && strYr.length > 1)
                strYr = strYr.substring(1)
        }
        month = parseInt(strMonth)
        day = parseInt(strDay)
        year = parseInt(strYr)
        if (pos1 == -1 || pos2 == -1) {
            return false
        }
        if (strMonth.length < 1 || month < 1 || month > 12) {
            return false
        }
        if (strDay.length < 1 || day < 1 || day > 31 || (month == 2 && day > daysInFebruary(year)) || day > daysInMonth[month]) {
            return false
        }
        if (strYear.length != 4 || year == 0 || year < minYear || year > maxYear) {
            return false
        }
        if (dtStr.indexOf(dtCh, pos2 + 1) != -1 || isInteger(stripCharsInBag(dtStr, dtCh)) == false) {
            return false
        }
        return true
    }
    if (isDate(fecha)) {
        clean_msj('msg_fecha_nac_persona');
    } else {
        document.persona.fecha_nac.focus();
        ver_msj('msg_fecha_nac_persona');
        msj('msg_fecha_nac_persona', ' * La fecha entre: ' + minYear + ' y ' + maxYear);
        event.returnValue = false;
    }
    return valor;
}

/* Valiar Login*/
function nombre_accesoLogin(form) {
    var valor;
    if (form.nombre_acceso.value == 0) {
        msj('msg_login', ' * Ingrese el nombre de usuario.');
        form.nombre_acceso.value = "";
        form.nombre_acceso.focus();
        event.returnValue = false;
    }
    return valor;
}
function codigo_accesoLogin(form) {
    var valor;
    if (form.codigo_acceso.value == 0) {
        msj('msg_login', ' * Ingrese la contrasena.');
        form.codigo_acceso.value = "";
        form.codigo_acceso.focus();
        event.returnValue = false;
    }
    return valor;
}

function Login()
{
    var fo = document.loginform;
    if (codigo_accesoLogin(fo) == false) {
        return false;
    }
    if (nombre_accesoLogin(fo) == false) {
        return false;
    }
}
// Seleccionar integrante para la asistencia
function Seleccionar_persona_asis(id_persona, nombre_person) {
    window.document.asist_reg.id_persona.value = id_persona;
    document.getElementById("nombre_persona").value = nombre_person;
}


function RegistrarGrupo_Cargo()
{
    var fo = document.grupo_cargo;
    opciones = document.getElementsByName("id_inscripcion");
    var seleccionado = false;
    var rel = "";
    for (var i = 0; i < opciones.length; i++) {
        if (opciones[i].checked) {
            seleccionado = true;
            rel = opciones[i].value;
            break;
        }
    }
    if (!seleccionado) {
        msj('msg_grupo_cargo', "* Seleccione un integrante.");
        var obj = document.grupo_cargo.buscar;
        obj.focus();
        if (obj.value != "") {
            obj.value += "";

        }
        event.returnValue = false;
    }
    if (id_cargoGr_car(fo) == false) {
        return false;
    }
}
function id_cargoGr_car(form) {
    var valor;
    if (form.id_cargo.value == 0) {
        msj('msg_grupo_cargo', ' * Seleccione el cargo.');
        form.id_cargo.value = "";
        form.id_cargo.focus();
        event.returnValue = false;
    }
    return valor;
}

/* REGISTRAR REUNIÓN */
function RegistrarEvento()
{
    var fo = document.evento;

    if (hora_finEvento(fo) == false) {
        return false;
    }
    if (fecha_finEvento(fo) == false) {
        return false;
    }
    if (hora_inicioEvento(fo) == false) {
        return false;
    }
    if (fecha_inicioEvento(fo) == false) {
        return false;
    }
    if (id_lugarEvento(fo) == false) {
        return false;
    }
    if (id_tipo_eventoEvento(fo) == false) {
        return false;
    }
}
function id_tipo_eventoEvento(form) {
    var valor;
    if (form.id_tipo_evento.value == 0) {
        msj('msg_evento', ' * Seleccione el tipo de evento.');
        form.id_tipo_evento.value = "";
        form.id_tipo_evento.focus();
        event.returnValue = false;
    }
    return valor;
}
function fecha_inicioEvento(form) {
    var valor;
    if (form.fecha_inicio.value == 0) {
        msj('msg_evento', ' * Seleccione la fecha de reunion.');
        form.fecha_inicio.value = "";
        form.fecha_inicio.focus();
        event.returnValue = false;
    }
    return valor;
}
function fecha_finEvento(form) {
    var valor;
    if (form.fecha_fin.value == 0) {
        msj('msg_evento', ' * Seleccione la fecha final.');
        form.fecha_fin.value = "";
        form.fecha_fin.focus();
        event.returnValue = false;
    }
    return valor;
}
function hora_inicioEvento(form) {
    var valor;
    if (form.hora_inicio.value == 0) {
        msj('msg_evento', ' * Ingrese la hora de inicio.');
        form.hora_inicio.value = "";
        form.hora_inicio.focus();
        event.returnValue = false;
    }
    return valor;
}
function hora_finEvento(form) {
    var valor;
    if (form.hora_fin.value == 0) {
        msj('msg_evento', ' * Ingrese la hora final.');
        form.hora_fin.value = "";
        form.hora_fin.focus();
        event.returnValue = false;
    }
    return valor;
}
function id_lugarEvento(form) {
    var valor;
    if (form.id_lugar.value == 0) {
        msj('msg_evento', ' * Buscar y seleccionar el lugar.');
        form.nombre_lugar.value = "";
        form.nombre_lugar.focus();
        event.returnValue = false;
    }
    return valor;
}


function Seleccionar_depar_carg(id_depar_cargo, nombre_depar) {
    window.document.cargo_config.id_depar_cargo.value = id_depar_cargo;
    window.document.cargo_config.buscar_dep.value = nombre_depar;
    $("#result,#busq_depar_cargo_resul").hide("slow");
    var obj = document.cargo_config.buscar_car;
    obj.focus();
    if (obj.value != "") {
        obj.value += "";
    }
}
function Seleccionar_cargo(id_cargo, nombre_cargo) {
    window.document.cargo_config.id_cargo.value = id_cargo;
    window.document.cargo_config.buscar_car.value = nombre_cargo;
    $("#result,#busq_cargos_resul").hide("slow");
}
function Seleccionar_lugar(id_lugar, nombre_lugar) {
    window.document.evento.id_lugar.value = id_lugar;
    window.document.evento.nombre_lugar.value = nombre_lugar;

    $("#result,#busq_lugar_resul").hide("slow");
    var obj = document.evento.fecha_inicio;
    obj.focus();
    if (obj.value != "") {
        obj.value += "";
    }
}

function Seleccionar_persona_programa(id_persona, buscar_persona, id_grado_acad) {
    window.document.programa_desarrollo.id_persona.value = id_persona;
    window.document.programa_desarrollo.buscar_persona.value = buscar_persona;
    window.document.programa_desarrollo.id_grado_acad.value = id_grado_acad;
    if (id_grado_acad != '')
    {
        window.document.programa_desarrollo.id_grado_acad.value = id_grado_acad;

    }
    $("#result,#buscar_todas_per_resul").hide("slow");
}

function Seleccionar_solo_int_programa(id_persona, buscar_persona, id_grado_acad) {
    window.document.programa_desarrollo.id_persona.value = id_persona;
    window.document.programa_desarrollo.buscar_persona.value = buscar_persona;
    if (id_grado_acad != '')
    {
        window.document.programa_desarrollo.id_grado_acad.value = id_grado_acad;

    }
    $("#result,#buscar_integ_per_resul").hide("slow");
}
function Seleccionar_actividad(nombre_actividad) {
    window.document.programa_desarrollo.nombre_actividad.value = nombre_actividad;
    $("#result,#busq_actividad_resul").hide("slow");
    var obj = document.programa_desarrollo.descripcion;
    obj.focus();
    if (obj.value != "") {
        obj.value += "";
    }
}
function Seleccionar_grupo_prog(id_grupo, nombre_grupo) {
    window.document.programa_desarrollo.id_grupo.value = id_grupo;
    window.document.programa_desarrollo.nombre_grupo.value = nombre_grupo;
    $("#result,#buscar_grupo_prog_resul").hide("slow");
}
function Cerrar_mas() {
    $("#result,#mas_opciones_resul").hide("slow");
    document.info.ver.value = "ver";
}

function Selec_persona_prog_plataf(id_persona, buscar_persona, id_grado_acad) {
    window.document.programa_plataforma.id_persona.value = id_persona;
    window.document.programa_plataforma.buscar_persona.value = buscar_persona;
    if (id_grado_acad != '')
    {
        window.document.programa_plataforma.id_grado_acad.value = id_grado_acad;

    }
    $("#result,#buscar_todas_per_resul").hide("slow");
}

function Seleccionar_solo_int_prog_plat(id_persona, buscar_persona, id_grado_acad) {
    window.document.programa_plataforma.id_persona.value = id_persona;
    window.document.programa_plataforma.buscar_persona.value = buscar_persona;
    if (id_grado_acad != '')
    {
        window.document.programa_plataforma.id_grado_acad.value = id_grado_acad;

    }
    $("#result,#buscar_integ_per_resul").hide("slow");
}
function Seleccionar_grupo_prog_plat(id_grupo, nombre_grupo) {
    window.document.programa_plataforma.id_grupo.value = id_grupo;
    window.document.programa_plataforma.nombre_grupo.value = nombre_grupo;
    $("#result,#buscar_grupo_prog_resul").hide("slow");
}

function Selec_persona_prog_mas_part(id_persona, buscar_persona, id_grado_acad) {
    window.document.programa_mas_participante.id_persona.value = id_persona;
    window.document.programa_mas_participante.buscar_persona.value = buscar_persona;
    if (id_grado_acad != '')
    {
        window.document.programa_mas_participante.id_grado_acad.value = id_grado_acad;

    }
    $("#result,#buscar_todas_per_resul").hide("slow");
}
function Seleccionar_solo_int_prog_mas(id_persona, buscar_persona, id_grado_acad) {
    window.document.programa_mas_participante.id_persona.value = id_persona;
    window.document.programa_mas_participante.buscar_persona.value = buscar_persona;
    if (id_grado_acad != '')
    {
        window.document.programa_mas_participante.id_grado_acad.value = id_grado_acad;

    }
    $("#result,#buscar_integ_per_resul").hide("slow");
}
function Seleccionar_grupo_prog_mas(id_grupo, nombre_grupo) {
    window.document.programa_mas_participante.id_grupo.value = id_grupo;
    window.document.programa_mas_participante.nombre_grupo.value = nombre_grupo;
    $("#result,#buscar_grupo_prog_resul").hide("slow");
}
function Seleccionar_tipo_evento(id_tipo_evento, descripcion) {
    window.document.tipo_evento_conf.descripcion.value = descripcion;
    window.document.tipo_evento_conf.id_tipo_evento.value = id_tipo_evento;
    $("#result,#busq_tipo_evento_resul").hide("slow");
}
function Seleccionar_actividad_sug(nombre_actividad) {
    window.document.programa_sugerente.nombre_actividad.value = nombre_actividad;
    $("#result,#busq_actividad_resul").hide("slow");
    var obj = document.programa_sugerente.descripcion;
    obj.focus();
    if (obj.value != "") {
        obj.value += "";
    }
}
function Seleccionar_tipo_asis(id_tipo_asistente, nombre_tipo_asis) {
    window.document.tipo_asistente_conf.id_tipo_asistente.value = id_tipo_asistente;
    window.document.tipo_asistente_conf.nombre_tipo_asis.value = nombre_tipo_asis;
    $("#result,#busq_tipo_asis_resul").hide("slow");
    var obj = document.tipo_asistente_conf.opcion;
    obj.focus();
}
function Selec_persona_us(id_persona, nombres) {
    window.document.usuario.id_persona.value = id_persona;
    window.document.usuario.nombre_persona.value = nombres;
    $("#result,#pers_resul").hide("slow");
    var obj = document.usuario.nombre_acceso;
    obj.focus();
}
function Selec_persona_incid(id_persona, nombres) {
    window.document.incidencia_persona.id_pers.value = id_persona;
    window.document.incidencia_persona.nombre_persona.value = nombres;
    $("#result,#pers_resul").hide("slow");
    var obj = document.incidencia_persona.descargo;
    obj.focus();
}
function Selec_lider_grupo(id_persona, nombres) {
    window.document.grupo_periodo.id_lider.value = id_persona;
    window.document.grupo_periodo.nombre_lider.value = nombres;
    $("#result,#pers_resul").hide("slow");
    var obj = document.grupo_periodo.id_grupo_dep;
    obj.focus();
}
function Selec_lugar_reunion(id_lugar, nombre_lugar) {
    window.document.grupo_periodo.id_lugar.value = id_lugar;
    window.document.grupo_periodo.nombre_lugar.value = nombre_lugar;
    $("#result,#busq_lugar_resul").hide("slow");
    var obj = document.grupo_periodo.blanco_baut;
    obj.focus();
}
function Selec_grupo_usuario(id_grupo, nombre_grupo) {
    window.document.usuario_grupo.id_grupo.value = id_grupo;
    window.document.usuario_grupo.nombre_grupo.value = nombre_grupo;
    $("#result,#busq_grupo_resul").hide("slow");
    var obj = document.usuario_grupo.id_perfil;
    obj.focus();
}
function Selec_dist_proc(id_ubigeo, nombre_distrito) {
    window.document.persona.id_ubigeo_proced.value = id_ubigeo;
    window.document.persona.nombre_distrito_proc.value = nombre_distrito;
    $("#result,#busq_dis_proc_resul").hide("slow");
    var obj = document.persona.direccion_proced;
    obj.focus();
}
function Selec_dist_act(id_ubigeo, nombre_distrito) {
    window.document.persona.id_ubigeo_actual.value = id_ubigeo;
    window.document.persona.nombre_distrito_act.value = nombre_distrito;
    $("#result,#busq_dis_act_resul").hide("slow");
    var obj = document.persona.direccion_actual;
    obj.focus();
}
function Selec_ent_acad(id_ent_acad, nombre_ent_acad) {
    window.document.persona.id_ent_acad.value = id_ent_acad;
    window.document.persona.nombre_ent_acad.value = nombre_ent_acad;
    $("#result,#busq_entidad_acad_resul").hide("slow");
    var obj = document.persona.cod_univer;
    obj.focus();
}
function Selec_respons_cargo(id_inscripcion, nombres) {
    window.document.grupo_cargo.id_inscripcion.value = id_inscripcion;
    window.document.grupo_cargo.nombre_respons.value = nombres;
    $("#result,#busq_respons_resul").hide("slow");
    var obj = document.grupo_cargo.opcion;
    obj.focus();
}
function Selec_lugar_evento(id_lugar, nombre_lugar) {
    window.document.evento.id_lugar.value = id_lugar;
    window.document.evento.nombre_lugar.value = nombre_lugar;
    $("#result,#busq_lugar_resul").hide("slow");
    var obj = document.evento.resumen;
    obj.focus();
}
function Selec_lugar_estudio(id_lugar, nombre_lugar) {
    window.document.estudio.id_lugar.value = id_lugar;
    window.document.estudio.nombre_lugar.value = nombre_lugar;
    $("#result,#busq_lugar_resul").hide("slow");
    var obj = document.estudio.nota;
    obj.focus();
}
function ValidarImagenPublic(form) {
    var valor;
    if (form.file.value == 0) {
        msj('msg_resultado', ' * Seleccione una foto.');
        form.file.value = "";
        form.file.focus();
        event.returnValue = false;
    }
    return valor;
}
function Seleccionar_integ_subgrupo(id_persona, nombre_persona) {
    window.document.sub_grupo_integ.id_persona.value = id_persona;
    window.document.sub_grupo_integ.buscar.value = nombre_persona;
    $("#result,#pers_resul").hide("slow");
}

function Seleccionar_persona_est(id_persona, nombre_persona, id_estado_civil) {
    window.document.estudiante_biblia.id_persona.value = id_persona;
    window.document.estudiante_biblia.nombre_persona.value = nombre_persona;
    window.document.estudiante_biblia.id_estado_civil.value = id_estado_civil;
    $("#result,#pers_resul").hide("slow");
}
function Selecc_debu_visitado(id_visitado, nombre_visitado, celular) {
    var telef = window.document.debu_visita_pastoral.telefono.value;
    window.document.debu_visita_pastoral.id_visitado.value = id_visitado;
    window.document.debu_visita_pastoral.nombre_visitado.value = nombre_visitado;
    if (telef == '') {
        window.document.debu_visita_pastoral.telefono.value = celular;
    }
    $("#result,#pers_resul").hide("slow");
}
function Selecc_debu_visitador(id_persona, nombre_persona) {
    window.document.debu_visita_pastoral.id_visitante.value = id_persona;
    window.document.debu_visita_pastoral.nombre_visitador.value = nombre_persona;
    $("#result,#visitador_resul").hide("slow");
}

function RegistrarEstudio()
{
    var fo = document.estudio;
    opciones = document.getElementsByName("id_instructor");
    var seleccionado = false;
    var rel = "";
    for (var i = 0; i < opciones.length; i++) {
        if (opciones[i].checked) {
            seleccionado = true;
            rel = opciones[i].value;
            break;
        }
    }
    if (!seleccionado) {
        msj('msg_estudio', "Seleccione al menos un instructor.");
        event.returnValue = false;
    }
}
// Script para ../registro_miembro
function Selec_persona_rm(id_persona, nombre_persona, id_estado_civil, id_relig, id_ent_acad) {
    window.document.registro_miembro.id_persona.value = id_persona;
    window.document.registro_miembro.nombre_persona.value = nombre_persona;
    window.document.registro_miembro.id_estado_civil.value = id_estado_civil;
    window.document.registro_miembro.id_religion_ant.value = id_relig;
    window.document.registro_miembro.id_ent_acad.value = id_ent_acad;
    $("#result,#pers_bau_resul").hide("slow");
    $("#result,#div_ver_grupo").show("slow");
}
function Selec_padre_rm(id_persona, nombre_persona) {
    window.document.registro_miembro.id_padre.value = id_persona;
    window.document.registro_miembro.nombre_padre.value = nombre_persona;
    $("#result,#padre_bau_resul").hide("slow");
}
function Selec_madre_rm(id_persona, nombre_persona) {
    window.document.registro_miembro.id_madre.value = id_persona;
    window.document.registro_miembro.nombre_madre.value = nombre_persona;
    $("#result,#madre_bau_resul").hide("slow");
}
function Selec_pastor_ofi_rm(id_persona, nombre_persona) {
    window.document.registro_miembro.id_pastor_ofi.value = id_persona;
    window.document.registro_miembro.pastor_oficiante.value = nombre_persona;
    $("#result,#pastor_ofic_resul").hide("slow");
}
function Selec_pastor_dist_rm(id_persona, nombre_persona) {
    window.document.registro_miembro.id_pastor_dist.value = id_persona;
    window.document.registro_miembro.pastor_distrital.value = nombre_persona;
    $("#result,#pastor_dist_resul").hide("slow");
}
function Selec_grupo_rm(id_grupo, nombre_grupo) {
    window.document.registro_miembro.id_grupo.value = id_grupo;
    window.document.registro_miembro.nombre_grupo.value = nombre_grupo;
    $("#result,#buscar_grupo_resul").hide("slow");
}
// Parentezco
function Selec_persona_paren(id_persona, nombre_persona) {
    window.document.new_paren.id_persona.value = id_persona;
    window.document.new_paren.nombre_persona.value = nombre_persona;

    $("#result,#pers_paren_resul").hide("slow");
    $("#div_relacion").show("slow");

    $("#tipo_paren_resul").load("busq/busq_tipo_paren.jsp?id_persona=" + id_persona, "", function() {
        $("#tipo_paren_resul").show("slow");
    });
}


