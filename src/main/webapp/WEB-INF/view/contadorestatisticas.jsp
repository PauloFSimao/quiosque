<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estat�sticas</title>
</head>
<body>
	<h1>Estat�sticas dos clientes cadastrados</h1>
	<p>Quantidade de clientes do g�nero Masculino: ${masculino }</p>
	<p>Quantidade de clientes do g�nero Feminino: ${feminino }</p>
	<p>Quantidade de clientes do g�nero Outros: ${outros }</p>
	<p>Quantidade de clientes Jovens: ${jovem }</p>
	<p>Quantidade de clientes Adultos: ${adulto }</p>
	<p>Quantidade de clientes Idosos: ${idoso }</p>
	<p>Quantidade de clientes cadastrados na segunda: ${segunda }</p>
	<p>Quantidade de clientes cadastrados na terca: ${terca }</p>
	<p>Quantidade de clientes cadastrados na quarta: ${quarta }</p>
	<p>Quantidade de clientes cadastrados na quinta: ${quinta }</p>
	<p>Quantidade de clientes cadastrados na sexta: ${sexta }</p>
	<p>Quantidade de clientes cadastrados na sabado: ${sabado }</p>
	<p>Quantidade de clientes cadastrados na domingo: ${domingo }</p>
	<p>Quantidade de clientes que se cadastraram de manh�: ${manha }</p>
	<p>Quantidade de clientes que se cadastraram de tarde: ${tarde }</p>
	<p>Quantidade de clientes que se cadastraram de noite: ${noite }</p>
</body>
</html>