<%--
  Created by IntelliJ IDEA.
  User: Marcelo
  Date: 01/07/2021
  Time: 02:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@include file="/css/cad_estadia.css"%></style>
    <title>Registro de Saída</title>
</head>
<body>
    <div>
        <h1>Registrar Saída</h1>

        <form action="estadia-controller" method="post">
          <label for="hr_saida">Hora de Saída:</label> <input type="text" id="hr_saida" name="hr_saida">  <br />
          <input type="hidden" name="idEstadia" id="idEstadia" value="${param.id}">
          <input type="submit" name="opcao" value="Atualizar">
          <button type="button" class="btn-cancelar" onclick="window.history.back();">Cancelar</button>
        </form>
    </div>
</body>
</html>
