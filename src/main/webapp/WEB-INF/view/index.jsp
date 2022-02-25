<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
	<h1>Cadastro de clientes</h1>
	
	<form action="salvarObj" method="post">
		<input type="hidden" name="id" value="${cliente.id }" required>
	
		<label>Nome:</label>
		<input type="text" name="nome" value="${cliente.nome }" required>
		<br>
		
		<label>Endereço:</label>
		<input type="text" name="endereco" value="${cliente.endereco }" required>
		<br>
		
		<label>Telefone ou Celular:</label>
		<input type="text" name="telefone" value="${cliente.telefone }" required>
		<br>
		
		<label>E-mail:</label>
		<input  type="email" name="email" value="${cliente.email }" required>
		<br>
		
		<label>Produto de Interesse:</label>
		<input type="text" name="prodInteresse" value="${cliente.prodInteresse }" required>
		<br>
		
		<label>Gênero:</label>
		<select name="genero">
			<option value="masculino" <c:if test="${cliente.genero.equals('masculino') }">selected</c:if>>Masculino</option>
			<option value="feminino" <c:if test="${cliente.genero.equals('feminino')}">selected</c:if>>Feminino</option>
			<option value="outros" <c:if test="${cliente.genero.equals('outros') }">selected</c:if>>Outros</option>
		</select>
		<br>
		
		<label>Data de Nascimento</label>
		<input type="date" name="dataNasc" value='<fmt:formatDate pattern="yyyy-MM-dd" value="${cliente.dataNasc.time }"/>' required>
		
		<br>
		
		<input type="submit" value="Cadastar">
	</form>
</body>
</html>