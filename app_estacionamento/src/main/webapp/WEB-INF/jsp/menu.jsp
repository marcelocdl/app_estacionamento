<%--
  Created by IntelliJ IDEA.
  User: Marcelo
  Date: 01/07/2021
  Time: 02:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style><%@include file="/css/menu.css"%></style>
    <title>Menu</title>
</head>
<body>
    <div class="container">
        <h1>Controle do estacionamento:</h1>
        <ul>
            <li class="dropdown">
                <a href="javascript:void(0)" class="dropbtn">Clientes</a>
                <div class="dropdown-content">
                    <a href="menu-controller?opcao=cadastrar-cliente">Cadastrar cliente</a>
                    <a href="http://localhost:8080/app_estacionamento/cliente-controller?opcao=listar">Mostrar clientes</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="javascript:void(0)" class="dropbtn">Veiculos</a>
                <div class="dropdown-content">
                    <a href="menu-controller?opcao=cadastrar-veiculo">Cadastrar veiculo</a>
                    <a href="http://localhost:8080/app_estacionamento/veiculo-controller?opcao=listar">Mostrar veiculos</a>
                </div>
            </li>
            <li class="dropdown">
                <a href="javascript:void(0)" class="dropbtn">Estadia</a>
                <div class="dropdown-content">
                    <a href="menu-controller?opcao=cadastrar-estadia">Cadastrar nova estadia</a>
                </div>
            </li>
        </ul>
    </div>
        <!--<div class="box">
            <table border="1" cellpadding="5">
                <tr>
                    <th>CLIENTE</th>
                    <th>VEICULO</th>
                </tr>
                <tr>
                    <td><a href="menu-controller?opcao=cadastrar-cliente">Cadastrar novo cliente</a></td>
                    <td><a href="menu-controller?opcao=cadastrar-veiculo">Cadastrar veiculo</a></td>
                </tr>
                <tr>
                    <td><a href="http://localhost:8080/app_estacionamento/cliente-controller?opcao=listar">Listar clientes</a></td>
                    <td><a href="http://localhost:8080/app_estacionamento/veiculo-controller?opcao=listar">Listar veiculos</a></td>
                </tr>
            </table>
        </div>
    </div> -->
    <div class="box">
        <h1>Estadias:</h1>

        <c:if test="${not empty retorno}">
            <h2>${retorno}</h2>
        </c:if>

        <table>
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
                <c:choose>
                    <c:when test="${e.hr_saida != NULL}">
                        <tr style="color: white; background-color: #5bbf47">
                    </c:when>
                    <c:otherwise>
                        <tr style="color: black; background-color: #ffffff">
                    </c:otherwise>
                </c:choose>
                    <td>${e.codEstadia}</td>
                    <td><fmt:formatDate value="${e.data}" pattern="dd/MM/yyyy" /></td>
                    <td>${e.hr_entrada}</td>
                    <td>${e.hr_saida}</td>
                    <td>${e.veiculo.placa}</td>
                    <td>${e.vaga.numVaga}</td>
                    <td>
                        <c:choose>
                            <c:when test="${e.hr_saida == NULL}">
                                <a href="estadia-controller?opcao=telaAtualizar&&id=${e.codEstadia}">Saída</a>
                            </c:when>
                            <c:otherwise>
                                SAIU
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
