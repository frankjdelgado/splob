<%@page import="model.TUsuario,java.util.List"%>
<%@page contentType="application/json; charset=UTF-8" %>
[<% List<TUsuario> usuarios = (List<TUsuario>)request.getAttribute("lista"); for(TUsuario user : usuarios){%>
{"alias":"<%=user.getAlias()%>", "id":"<%=user.getId()%>", "password":"<%=user.getPassword()%>","email":"<%=user.getEmail()%>"}<%}%>]

