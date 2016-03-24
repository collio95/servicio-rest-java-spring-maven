<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Timbre - Coordenadas</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="description" content="">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/vendor/select2-3.5.0/select2.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
  <script type="text/javascript">
    var contextPath = '${pageContext.request.contextPath}';
  </script>
</head>
<body>
<!--[if lt IE 7]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade
  your browser</a> to improve your experience.</p>
<![endif]-->

<form id="imagenForm" action="addImage.html" method="post" enctype="multipart/form-data">
<div class="contenedorForm">
  <h1>Imagen</h1>

  <div class="clearfix headerFormulario header-timbre">
    <ul>
      <li>
        <label class="label-superior">Titulo Imagen</label>
        <input type="text" id="titulo" name="titulo" class="medium-timbre" maxlength="50">
      </li>
      <li>
        <label  class="label-superior">Imagen</label>
        <div id="fileUpload" class="fileUpload" style="width: 400px;">
          <span id="file-texto" class="texto-file"></span>
          <input id="imagen" name="imagen" type="file" class="upload" />
        </div>
      </li>
    </ul>
    <a id="addImage" class="boton float-der">Agregar Imagen</a>
  </div>

  <!--Cartas Imagen-->

  <c:forEach items="${imagenes}" var="imagen">
    <div class="carta-timbre" id="div_${imagen.id}">
      <a href="#" id="eliminar_${imagen.id}" class="btn-cerrar-carta"><span>X</span></a>
      <img src="data:image/jpeg;base64,${imagen.base64}">
      <h2>${imagen.titulo}</h2>
    </div>
  </c:forEach>
</form>

  <!-- Cartas Imagen-->
</div>


<!--Timbre-->
<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/vendor/select2-3.5.0/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/vendor/select2-3.5.0/select2_locale_es.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/timbre.js"></script>7
<script src="${pageContext.request.contextPath}/resources/js/imagen.js"></script>
</body>
</html>
