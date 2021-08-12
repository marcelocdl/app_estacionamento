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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@include file="/css/lista.css"%></style>
    <title>Listagem de Veículos</title>
</head>
<body>
    <div>
        <h1>Lista dos veículos:</h1>
        <table>
            <tr>
                <th>Código</th>
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
                        <a class="btn-deletar"
                           href="http://localhost:8080/app_estacionamento/veiculo-controller?opcao=excluir&&id=${v.id}">Excluir</a>
                        <a class="btn-editar"
                           href="http://localhost:8080/app_estacionamento/veiculo-controller?opcao=atualizar&&id=${v.id}">Atualizar</a>
                    </td>
                </tr>
            </c:forEach>

        </table> <br /><br />

        <a href="http://localhost:8080/app_estacionamento/">Voltar ao menu</a>
    </div>
</body>
</html>
