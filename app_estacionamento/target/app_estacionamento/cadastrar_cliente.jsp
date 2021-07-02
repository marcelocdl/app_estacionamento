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
    <title>Cliente</title>
    <style type="text/css">
        input{
            margin-bottom: 2px;
        }
    </style>
</head>
<body>

<form action="cliente-controller" method="post">

    <c:choose>
        <c:when test="${cliente.cod_cliente != null}">
            <h1>Editar cliente:</h1>
            <input type="hidden" name="id" value="${cliente.cod_cliente}">
        </c:when>
        <c:otherwise>
            <h1>Cadastrar cliente:</h1>
            <input type="hidden" name="id" value="0">
        </c:otherwise>
    </c:choose>

    <label for="nome">Nome:</label> <input type="text" id="nome" name="nome" value="${cliente.nome}">  <br />
    <label for="cpf">CPF: </label> <input type="text" id="cpf" name="cpf" placeholder="***.***.***-**" value="${cliente.cpf}" > <br />

    <input type="submit" name="opcao" value="Salvar">
    <a href="http://localhost:8080/app_estacionamento/">Cancelar</a>
</form>
</body>
</html>
