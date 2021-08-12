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
    <style><%@include file="/css/cad_veiculo.css"%></style>
    <title>Veiculo</title>
</head>
<body>
    <div>
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

            <label for="cod_cliente">Nome do Proprietário: </label>
            <select id="cod_cliente" name="cod_cliente">
                <c:forEach var="cliente" items="${clientes}">
                    <option value="${cliente.cod_cliente}">${cliente.nome}</option>
                </c:forEach>
            </select> <br />
            <input type="submit" name="opcao" value="Cadastrar">
            <button type="button" class="btn-cancelar" onclick="window.history.back();">Cancelar</button>
        </form>
    </div>
</body>
</html>
