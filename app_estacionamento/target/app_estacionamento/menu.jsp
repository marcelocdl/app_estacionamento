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
<body>
    <h1>Controle do estacionamento:</h1>
    <table border="1" cellpadding="5">
        <tr>
            <th>CLIENTE</th>
            <th>VEICULO</th>
        </tr>
        <tr>
            <td><a href="cadastrar_cliente.jsp">Cadastrar novo cliente</a></td>
            <td><a href="cadastrar_veiculo.jsp">Cadastrar veiculo</a></td>
        </tr>
        <tr>
            <td><a href="http://localhost:8080/app_estacionamento/cliente-controller?opcao=listar">Listar clientes</a></td>
            <td><a href="http://localhost:8080/app_estacionamento/veiculo-controller?opcao=listar">Listar veiculos</a></td>
        </tr>
    </table>

    <h1>Estadias:</h1>

    <h3><a href="cadastrar_estadia.jsp">Cadastrar nova Estadia</a></h3>

    <table border="1" cellpadding="5">
        <tr>
            <th>Código</th>
            <th>Data</th>
            <th>Entrada</th>
            <th>Saída</th>
            <th>Veiculo</th>
            <th>Vaga</th>
            <th>Opção</th>
        </tr>

        <c:forEach var="e" items="${estadias}">
            <tr>
                <td>${e.codEstadia}</td>
                <td>${e.data}</td>
                <td>${e.hr_entrada}</td>
                <td>${e.hr_saida}</td>
                <td>${e.veiculo.placa}</td>
                <td>${e.vaga.numVaga}</td>
                <td>
                    <a href="http://localhost:8080/app_estacionamento/saida_estadia.jsp?opcao=Atualizar&&id=${e.codEstadia}">Saída</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
