$(function () {
    function validarfields(login, clave, correo) {
        if (login.length > 1 && login.length <= 100) {
            if (clave.length > 1 && clave.length <= 1000) {
                if (correo.length > 1 && correo.length < 10) {
                                                 //validar campo detipo file
                                            var archivos = document.getElementById('archivos').files;
                                            if (archivos.length == 1) {
                                                for (var i=0; i<archivos.length; i++) {
                                                    var name = archivos[i].name;
                                                    var ext = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
                                                    if (ext != 'jpg' && ext != "png") {
                                                        alert('ARCHIVO ' + name + ' incorrecto,solo imagenes JPG y PNG');
                                                        return false;
                                                    }
                                                 }
                                                return true;
                                            } else {alert("POR FAVOR SELECCIONE  ARCHIVOS TIPO IMAGEN");}
                                        } else {alert("DEBE ESCRIBIR SU CORREO CORRECTAMENTE");}
                                    } else {alert("DEBE INGRESAR SU COTRASEÑA CORRECTAMENTE");}
                                } else {alert("DEBE EL SU USUARIO CORRECTAMENTE");}
        return false;
    }

    $('#btncrearUsuario').click(function (e) {
        e.preventDefault();
        var login = $('#usuario').val();
        var clave = $('#clave').val();
        var correo = $('#correo').val();
        if (validarfields(login, clave, correo)) {
            var data = new FormData($('#frm_nuevo')[0]);
            $.ajax({
                url: "ControlLoginSvt",
                type: "post",
                data: data,
                contentType: false,
                processData: false, 
                success : function (data){                  
                    alert(data);
                }
            });
        }
    });
});