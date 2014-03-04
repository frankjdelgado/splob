<%@page import="model.TUsuario,java.util.List"%>
<%@page contentType="text/json"%>
"data":{[<% List<TUsuario> usuarios = (List<TUsuario>)request.getAttribute("lista"); for(TUsuario user : usuarios){%>
{"alias":"<%=user.getAlias()%>", "id":"<%=user.getId()%>", "password":"<%=user.getPassword()%>","email":"<%=user.getEmail()%>"},<br>
<%}%>]}
