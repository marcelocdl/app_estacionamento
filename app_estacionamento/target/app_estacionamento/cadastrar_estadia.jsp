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
    <title>Cadastro de Estadia</title>
    <style type="text/css">
        input{
            margin-bottom: 2px;
        }
    </style>
</head>
<body>
<h1>Cadastrar nova estadia</h1>
    <form action="estadia-controller" method="post">
        <label for="hr_entrada">Hora de Entrada:</label> <input type="text" id="hr_entrada" name="hr_entrada">  <br />
        <label for="num_vaga">Número da vaga: </label> <input type="number" id="num_vaga" name="num_vaga" > <br />
        <label for="cod_veiculo">Código do veiculo: </label> <input type="number" id="cod_veiculo" name="cod_veiculo" > <br />

        <input type="submit" name="opcao" value="Cadastrar">
        <a href="http://localhost:8080/app_estacionamento/">Cancelar</a>
    </form>
</body>
</html>
