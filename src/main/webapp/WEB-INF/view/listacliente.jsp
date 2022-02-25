<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de clientes</h1>
	<table border ="1">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Endereço</th>
			<th>Telefone</th>
			<th>Email</th>
			<th>Produto de Interesse</th>
			<th>Genero</th>
			<th>Nascimento</th>
			<th>Data de Cadastro</th>
			<th>Ver+</th>
			<th>Excluir</th>
		</tr>
		<c:forEach items="${clientes }" var="c">
			<tr <c:if test="${j.idade < 18 }"> style="color: red;"</c:if>>
				<td>${c.id }</td>
				<td>${c.nome }</td>
				<td>${c.endereco }</td>
				<td>${c.telefone}</td>
				<td>${c.email }</td>
				<td>${c.prodInteresse }</td>
				<td>${c.genero }</td>
				<td><fmt:formatDate value="${c.dataNasc.time }" pattern="dd/MM/yyyy"/></td>
				<td><fmt:formatDate value="${c.dataCadastro.time }" pattern="dd/MM/yyyy"/></td>
				<td><a href="alterarCliente?idCliente=${c.id }" )>Ver +</a></td>
				<td><a href="excluirCliente?idCliente=${c.id }" onclick="return confirm('Confirmar exclusão do cliente ${c.nome}')">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>