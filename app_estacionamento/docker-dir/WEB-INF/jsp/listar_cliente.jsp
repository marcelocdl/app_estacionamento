<%--
  Created by IntelliJ IDEA.
  User: Marcelo
  Date: 01/07/2021
  Time: 18:41
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
    <title>Listagem dos Clientes</title>
</head>
<body>
    <div>
        <h1>Lista dos clientes:</h1>
        <table>
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Ações</th>
            </tr>

            <c:forEach var="c" items="${clientes}">
                <tr>
                    <td>${c.cod_cliente}</td>
                    <td>${c.nome}</td>
                    <td>${c.cpf}</td>
                    <td>
                        <a class="btn-deletar"
                           href="http://localhost:8080/app_estacionamento/cliente-controller?opcao=excluir&&id=${c.cod_cliente}">Excluir</a>
                        <a class="btn-editar"
                           href="http://localhost:8080/app_estacionamento/cliente-controller?opcao=atualizar&&id=${c.cod_cliente}">Atualizar</a>
                    </td>
                </tr>
            </c:forEach>
        </table> <br /><br />

        <a href="http://localhost:8080/app_estacionamento/">Voltar ao menu</a>
    </div>
</body>
</html>
