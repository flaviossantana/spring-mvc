<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Casa do Código</title>
</head>
<body>
<form action="/casadocodigo/produtos" method="post">
    <div>
        <label>Título</label>
        <input type="text" name="titulo">
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    <div>
        <label>Paginas</label>
        <input type="text" name="paginas">
    </div>
    <button type="submit">Cadastrar</button>
</form>
</body>
</html>