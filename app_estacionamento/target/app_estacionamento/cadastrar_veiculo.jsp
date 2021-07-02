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
    <title>Veiculo</title>
    <style type="text/css">
        input{
            margin-bottom: 2px;
        }
    </style>
</head>
<body>
    <form action="veiculo-controller" method="post">
        <c:choose>
            <c:when test="${veiculo.id != null}">
                <h1>Editar veiculo:</h1>
                <input type="hidden" name="id" value="${veiculo.id}">
            </c:when>
            <c:otherwise>
                <h1>Cadastrar veiculo:</h1>
                <input type="hidden" name="id" value="0">
            </c:otherwise>
        </c:choose>
        <label for="placa">Placa:</label> <input type="text" id="placa" name="placa" value="${veiculo.placa}">  <br />
        <label for="cor">Cor:</label> <input type="text" id="cor" name="cor" value="${veiculo.cor}"> <br />
        <label for="modelo">Modelo: </label> <input type="text" id="modelo" name="modelo" value="${veiculo.modelo}"> <br />
        <label for="cod_tipo">Tipo:</label>
            <select id="cod_tipo" name="cod_tipo">
                <option value=1 selected>Motocicleta</option>
                <option value=2 >Carro</option>
                <option value=3 >Outro</option>
            </select> <br />
        <label for="cod_cliente">Código do Proprietário: </label> <input type="number" id="cod_cliente"
                                                                         name="cod_cliente" value="${veiculo.cliente.cod_cliente}" > <br />

        <input type="submit" name="opcao" value="Cadastrar">
        <a href="http://localhost:8080/app_estacionamento/">Cancelar</a>
    </form>
</body>
</html>
