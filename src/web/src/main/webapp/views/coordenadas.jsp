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


<div class="contenedorForm">
  <h1>Timbre</h1>

  <form id="coordenadaForm" action="addCoordenada.html" method="post">
    <div class="clearfix headerFormulario header-timbre">
      <ul>
        <li>
          <label for="" class="label-superior">Tipo de Documento</label>
          <select name="tipoDocumento" id="tipoDocumento">
            <c:forEach items="${tiposDocumentos}" var="tipoDocumento">
              <option value="${tipoDocumento.id}">${tipoDocumento.codigo}</option>
            </c:forEach>
          </select>
        </li>
        <li>
          <label for="" class="label-superior">Imagen</label>
          <select name="imagenId" id="tituloImagen">
            <c:forEach items="${imagenes}" var="imagen">
              <option value="${imagen.id}" data-imagen="${imagen.base64}">${imagen.titulo}</option>
            </c:forEach>
          </select>
        </li>
        <li>
          <label for="" class="label-superior">Coordenadas X,Y</label>
          <input id="coordenadas" name="coordenadas" type="text" class="small">
        </li>
      </ul>
      <a id="addCordenada" class="boton float-der">Agregar Documento</a>
    </div>
  </form>

  <div class="clearfix contenedor-formulario adm-timbre">
    <div class="fila clearfix">

      <table id="timbresTable">
        <tr>
          <th>Tipo de Documento</th>
          <th>Coordenadas X,Y</th>
          <th>Imagen</th>
          <th></th>
        </tr>
        <c:forEach items="${coordenadas}" var="coordenada">
          <tr id="tr_${coordenada.id}">
            <td data-tipo-documento-id="${coordenada.tipoDocumento.id}">${coordenada.tipoDocumento.codigo}</td>
            <td class="editFields">${coordenada.x},${coordenada.y}</td>
            <td data-imagen-id="${coordenada.imagen.id}"><img src="data:image/jpeg;base64,${coordenada.imagen.base64}" style="height: 15px;width: 18px;" /> </td>
            <td style="text-align:center">
              <span id="eliminar_${coordenada.id}" class="boton-icono-min boton-eliminar-min" title="Eliminar">Eliminar</span>
            </td>
          </tr>

        </c:forEach>
      </table>
    </div>
  </div>
</div>

<!--Timbre-->
<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/vendor/select2-3.5.0/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/vendor/select2-3.5.0/select2_locale_es.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/timbre.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/coordenadas.js"></script>
</body>
</html>
