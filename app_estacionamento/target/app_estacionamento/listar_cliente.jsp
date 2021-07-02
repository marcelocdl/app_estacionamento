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
    <title>Listagem dos Clientes</title>
</head>
<body>
    <h1>Lista dos clientes:</h1>
    <table border="1" cellpadding="5">
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
                    <a href="http://localhost:8080/app_estacionamento/cliente-controller?opcao=excluir&&id=${c.cod_cliente}">Excluir</a>
                    <a href="http://localhost:8080/app_estacionamento/cliente-controller?opcao=atualizar&&id=${c.cod_cliente}">Atualizar</a>
                </td>
            </tr>
        </c:forEach>
    </table> <br /><br />

    <a href="http://localhost:8080/app_estacionamento/">Voltar ao menu</a>
</body>
</html>
