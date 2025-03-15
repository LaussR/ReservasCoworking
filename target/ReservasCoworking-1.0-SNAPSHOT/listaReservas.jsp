<%@ page import="java.util.List, model.Reserva, servlets.ReservaServlet" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Reservas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 20px;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 60%;
            margin: auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #28a745;
            color: white;
        }
        button {
            background-color: #dc3545;
            color: white;
            padding: 5px 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background-color: #c82333;
        }
        .back-btn {
            background-color: #007bff;
            margin-top: 20px;
        }
        .back-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Reservas Registradas</h2>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Fecha</th>
                <th>Espacio</th>
                <th>Duración</th>
                <th>Acción</th>
            </tr>
            <%
                List<Reserva> reservas = ReservaServlet.getReservas();
                for (Reserva r : reservas) {
            %>
            <tr>
                <td><%= r.getNombreUsuario() %></td>
                <td><%= r.getFecha() %></td>
                <td><%= r.getEspacio() %></td>
                <td><%= r.getDuracion() %> horas</td>
                <td>
                    <form action="EliminarReservaServlet" method="post">
                        <input type="hidden" name="nombre" value="<%= r.getNombreUsuario() %>">
                        <button type="submit">Eliminar</button>
                    </form>
                </td>
            </tr>
            <% } %>
        </table>
        <br>
        <a href="index.html"><button class="back-btn">Volver a Reservar</button></a>
    </div>
</body>
</html>
