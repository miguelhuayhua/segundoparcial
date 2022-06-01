<%@page import="com.miguel.parcialdao.models.Participante"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.miguel.parcialdao.models.Seminario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    List<Seminario> seminarioLista = (List<Seminario>) request.getAttribute("seminarioLista");
    List<Participante> participanteLista = (List<Participante>) request.getAttribute("participanteLista");

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link href="css/styles.css" rel="stylesheet">
        <title>Home</title>
    </head>
    <body>
        <div class="row mt-4">

            <div class="col-sm-12 col-md-8 offset-md-2 col-lg-6 offset-lg-3">
                <div class="card">
                    <div class="card-body">
                        <blockquote class="blockquote mb-0">
                            <h4>SEGUNDO PARCIAL TEM-742</h4>
                            <p>Nombre y Apellidos: Miguel Huayhua Condori <br>
                                Carnet: 9190304
                            </p>


                            <footer class="blockquote-footer">Adicional: <cite title="Source Title">
                                    <p>
                                        Celular: 69848691
                                        <br>
                                        R.U.: 200028431
                                    </p>
                                </cite>
                            </footer>
                        </blockquote>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">

            <div class="mt-4">	
                <ul  class="nav nav-pills">
                    <li class="active">
                        <a  href="#1a" data-toggle="tab">
                            <button class="btn btn-dark me-5">
                                Participantes
                            </button>
                        </a>
                    </li>
                    <li><a href="#2a" data-toggle="tab">
                            <button class="btn btn-dark">
                                Seminarios
                            </button>
                        </a>
                    </li>
                </ul>

                <div class="container-fluid">
                    <div class="tab-content">
                        <div class="tab-pane active" id="1a">
                            <div class="row my-3 my-md-5">
                                <div class="col-12 col-md-10 offset-md-1">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">ID</th>
                                                <th scope="col">Apellidos</th>
                                                <th scope="col">Nombres</th>
                                                <th scope="col">Seminario</th>
                                                <th scope="col">Confirmado</th>
                                                <th scope="col"></th>
                                                <th scope="col"></th>
                                            </tr>
                                        </thead>
                                        <tbody class="table-group-divider">
                                            <c:forEach var="participante" items="${participanteLista}" >
                                                <tr>
                                                    <td><c:out default="-" value="${participante.getId()}"/></td>
                                                    <td><c:out default="-" value="${participante.getApellidos()}"/></td>
                                                    <td><c:out default="-" value="${participante.getNombres()}"/></td>
                                                    <td><c:out default="-" value="${participante.getSeminario().getTitulo()}"/></td>


                                                    <td>
                                                        <c:if test="${participante.getConfirmado()==1}">
                                                            <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckCheckedDisabled" checked disabled>
                                                        </c:if>
                                                        <c:if test="${participante.getConfirmado()==0}">
                                                            <input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckCheckedDisabled" disabled>

                                                        </c:if>
                                                    </td>
                                                    <td>
                                                        <a
                                                            href="seminario?id=<c:out default="-" value="${participante.getId()}"/>&type=UPDATE">
                                                            <button class="btn btn-info">Editar</button>
                                                        </a> 
                                                    </td>

                                                    <td><a
                                                            href="seminario?id=<c:out default="-" value="${participante.getId()}"/>&type=DELETE">
                                                            <button class="btn btn-danger">Eliminar</button>
                                                        </a> 
                                                    </td>

                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="2a">
                            <div class="rowrow my-3 my-md-5" >
                                <div class="col-12 col-md-10 offset-md-1">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">ID</th>
                                                <th scope="col">Titulo</th>
                                                <th scope="col">Fecha</th>
                                                <th scope="col">Cupos</th>
                                                <th scope="col"></th>
                                                <th scope="col"></th>
                                            </tr>
                                        </thead>
                                        <tbody class="table-group-divider">
                                            <c:forEach var="seminario" items="${seminarioLista}">
                                                <tr>
                                                    <td><c:out default="-" value="${seminario.getId()}"/></td>
                                                    <td><c:out default="-" value="${seminario.getTitulo()}"/></td>
                                                    <td><c:out default="-" value="${seminario.getFecha()}"/></td>
                                                    <td><c:out default="-" value="${seminario.getCupo()}"/></td>
                                                    <td>
                                                        <a
                                                            href="seminario?id=<c:out default="-" value="${seminario.getId()}"/>&type=UPDATE">
                                                            <button class="btn btn-info">Editar</button>
                                                        </a> 
                                                    </td>

                                                    <td><a
                                                            href="seminario?id=<c:out default="-" value="${seminario.getId()}"/>&type=DELETE">
                                                            <button class="btn btn-danger">Eliminar</button>
                                                        </a> 
                                                    </td>

                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </body>
</html>
