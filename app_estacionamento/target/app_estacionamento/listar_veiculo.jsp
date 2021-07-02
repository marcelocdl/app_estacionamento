<%--
  Created by IntelliJ IDEA.
  User: Marcelo
  Date: 01/07/2021
  Time: 02:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>

<html>
<head>
    <title>Listagem de Veículos</title>
</head>
<body>
    <h1>Lista dos veículos:</h1>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Placa</th>
            <th>Modelo</th>
            <th>Cor</th>
            <th>Tipo</th>
            <th>Proprietário</th>
            <th>Ações</th>
        </tr>

        <c:forEach var="v" items="${veiculos}">
            <tr>
                <td>${v.id}</td>
                <td>${v.placa}</td>
                <td>${v.modelo}</td>
                <td>${v.cor}</td>
                <td>${v.tipo.descricao}</td>
                <td>${v.cliente.nome}</td>
                <td>
                    <a href="http://localhost:8080/app_estacionamento/veiculo-controller?opcao=excluir&&id=${v.id}">Excluir</a>
                    <a href="http://localhost:8080/app_estacionamento/veiculo-controller?opcao=atualizar&&id=${v.id}">Atualizar</a>
                </td>
            </tr>
        </c:forEach>

    </table> <br /><br />

    <a href="http://localhost:8080/app_estacionamento/">Voltar ao menu</a>
</body>
</html>
