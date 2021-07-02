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
  <title>Registro de Saída</title>
  <style type="text/css">
    input{
      margin-bottom: 2px;
    }
  </style>
</head>
<body>
  <h1>Registrar Saída</h1>

  <form action="estadia-controller" method="post">
    <label for="hr_saida">Hora de Saída:</label> <input type="text" id="hr_saida" name="hr_saida">  <br />
    <input type="hidden" name="idEstadia" id="idEstadia" value="${param.id}">
    <input type="submit" name="opcao" value="Atualizar">
    <a href="http://localhost:8080/app_estacionamento/">Cancelar</a>
  </form>
</body>
</html>
