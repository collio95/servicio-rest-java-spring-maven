<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Timbre - Tipo de Documento</title>
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
  <h1>Tipo de Documento</h1>

  <form id="tipoDocumentoForm">
    <div class="clearfix headerFormulario header-timbre">
      <ul>
        <li>
          <label class="label-superior">Codigo</label>
          <input id="codigo" name="codigo" type="text" class="small-timbre">
        </li>
        <li>
          <label class="label-superior">Descripcion</label>
          <input id="descripcion" name="descripcion" type="text" class="large-timbre">
        </li>
      </ul>
      <a href="#" id="agregarDocumento" class="boton float-der">Agregar Tipo Documento</a>
    </div>
  </form>

  <div class="clearfix contenedor-formulario adm-timbre">
    <div class="fila clearfix">

      <table id="tiposDocumentosTable">
        <thead>
        <tr>
          <th class="small-timbre">Código</th>
          <th>Descripción</th>
          <th></th>
        </tr>
        </thead>
        <tbody id="tiposDocumentosBody">
          <c:forEach items="${tiposDocumentos}" var="tipoDocumento">
            <tr id="tr_${tipoDocumento.id}">
              <td class="editFields">${tipoDocumento.codigo}</td>
              <td class="editFields">${tipoDocumento.descripcion}</td>
              <td style="text-align:center">
                <span id="eliminar_${tipoDocumento.id}" class="boton-icono-min boton-eliminar-min" title="Eliminar">Eliminar</span>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>


<!--Timbre-->
<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/vendor/select2-3.5.0/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/vendor/select2-3.5.0/select2_locale_es.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/timbre.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/tipoDocumento.js"></script>
</body>
</html>
