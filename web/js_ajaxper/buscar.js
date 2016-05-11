
            // Buscar reporte - informe....
            $(document).ready(function() {
                $("#buscar_informe").keyup(function() {
                    str = $("#form_busqueda").serialize();
                    $("#buscar_informe_resul").hide("slow");
                    $("#div_cargando").show("slow");
                    $("#buscar_informe_resul").load("_gestion_personas_nro_asistencias_frame.jsp?"+str, "", function() {
                        $("#div_cargando").hide("slow");
                        $("#buscar_informe_resul").show("slow");
                    });
                });
            });
