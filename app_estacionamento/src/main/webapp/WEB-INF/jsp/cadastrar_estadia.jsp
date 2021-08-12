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
    <title>Cadastro de Estadia</title>
</head>
<body>
    <div>
        <h1>Cadastrar nova estadia</h1>
        <form action="estadia-controller" method="post">
            <label for="hr_entrada">Hora de Entrada:</label> <input type="text" id="hr_entrada" name="hr_entrada">  <br />
            <label for="num_vaga">Número da vaga: </label> <input type="number" id="num_vaga" name="num_vaga" > <br />
            <label for="cod_veiculo">Placa do veiculo: </label>
            <select id="cod_veiculo" name="cod_veiculo">
                <c:forEach var="veiculo" items="${veiculos}">
                    <option value="${veiculo.id}">${veiculo.placa}</option>
                </c:forEach>
            </select> <br />

            <input type="submit" name="opcao" value="Cadastrar">
            <button type="button" class="btn-cancelar" onclick="window.history.back();">Cancelar</button>
        </form>
    </div>
</body>
</html>
