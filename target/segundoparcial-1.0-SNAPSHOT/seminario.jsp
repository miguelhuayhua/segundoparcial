<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.miguel.parcialdao.models.Seminario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Seminario seminario = null;
    if (request.getAttribute("seminario") != null) {
        seminario = (Seminario) request.getAttribute("seminario");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta lang="es" http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>Seminario</title>
    </head>
    <body>
        <div class="container mt-5">

            <div class="row">

                <div class="col-6 offset-3">
                    <h3>Seminarios</h3>
                    <form action="seminario" method="post">
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1">Titulo:</span>
                            <input type="text" class="form-control"
                                   name="titulo" placeholder="Introduzca el titulo..."
                                   value = "<%=seminario.getTitulo()%>"
                                   aria-label="Username" aria-describedby="basic-addon1">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon2">Fecha:</span>

                            <input type="date" class="form-control" 
                                   name="fecha"
                                   value="<%=seminario.getFecha()%>"
                                   placeholder="Introduzca la fecha ..."  aria-describedby="basic-addon2">
                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon3">Cantidad de cupos:</span>

                            <input type="number" min="0" class="form-control" 
                                   name="cupo"
                                   value="<%=seminario.getCupo()%>"
                                   placeholder="Introduzca la cantidad de cupos..."  aria-describedby="basic-addon3">
                        </div>
                        <input type="number" name="id"
                               value="<%=seminario.getId()%>"
                               hidden>
                        <input class="btn btn-outline-success d-block mx-auto w-50" type="submit" value="Aceptar">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
