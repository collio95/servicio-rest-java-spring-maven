(function (root, factory) {
  root.Timbre = factory(root, {}, root.jQuery, root.contextPath || '/principal-services-rest');
}(window, function (root, Timbre, $, contextPath) {

  var ImagenController = Timbre.ImagenController = function () {
    this.initialize.apply(this, arguments);
  };

  $.extend(ImagenController.prototype, {
    initialize: function () {
      this.bindEvents();
      this.imagenModel = new ImagenModel();
    },
    bindEvents: function () {
      var $imagen = $('#imagen'),
        $fileTexto = $('#file-texto'),
        $addImage = $("#addImage"),
        $imagenForm = $("#imagenForm"),
        $eliminarButtons = $("[id*=eliminar_]"),
        _this = this;

      $addImage.on({
        click: function (e) {
          e.preventDefault();
          _this.imagenModel.validate();
          if (_this.imagenModel.isValid()) {
            $imagenForm.submit();
          }
        }
      });

      $imagen.on({
        change: function () {
          var filename = $(this).val();
          $fileTexto.html(filename);
        }
      });

      $eliminarButtons.on({
        click: function (e) {
          e.preventDefault();
          var id = $(this).attr("id").split("_")[1];
          $.post(contextPath + '/timbre/deleteImagen.json', {id: id}, function (json) {
            $("#div_" + id).remove();
          }, "json");
        }
      });

    }
  });


  var TipoDocumentoController = Timbre.TipoDocumentoController = function () {
    this.initialize.apply(this, arguments);
  };

  $.extend(TipoDocumentoController.prototype, {
    initialize: function () {
      this.bindEvents();
      this.tipoDocumento = new TipoDocumentoModel();
    },
    bindEvents: function () {
      var $agregarDocumento = $("#agregarDocumento"),
        $tiposDocumentosTable = $("#tiposDocumentosTable"),
        $editFields = $(".editFields"),
        $inputEdit = $(".inputEdit"),
        $tiposDocumentosBody = $("#tiposDocumentosBody"),
        _this = this;


      $agregarDocumento.on('click', function (e) {
        e.preventDefault();
        _this.tipoDocumento.validate();
        if (_this.tipoDocumento.isValid()) {
          var data = {
            id: null,
            codigo: _this.tipoDocumento.get("codigo"),
            descripcion: _this.tipoDocumento.get("descripcion")
          };

          $.post('addTipoDocumento.html', data, function (json) {
            $("#tipoDocumentoForm").find("input").val("");
            var tipoDocTr = [];
            tipoDocTr.push("<tr id=\"tr_" + json.id + "\">");
            tipoDocTr.push("<td class=\"editFields\">" + json.codigo + "</td>");
            tipoDocTr.push("<td class=\"editFields\">" + json.descripcion + "</td>");
            tipoDocTr.push("<td style=\"text-align:center\">");
            tipoDocTr.push("<span id=\"eliminar_" + json.id + "\" class=\"boton-icono-min boton-eliminar-min\" title=\"Eliminar\">Eliminar</span>");
            tipoDocTr.push("</td>");
            tipoDocTr.push("</tr>");
            $tiposDocumentosBody.append(tipoDocTr.join(''));
          }, 'json');
        }
      });

      $tiposDocumentosTable.on('click', '.boton-eliminar-min', function (e) {
        e.preventDefault();
        var id = $(this).attr("id").split("_")[1];
        $.post(contextPath + '/timbre/deleteTipoDocumento.json', {id: id}, function (json) {
          $("#tr_" + id).remove();
        }, "json");
      });

      $tiposDocumentosTable.on('click', '.editFields', function (e) {
        e.preventDefault();
        var value = $(this).text();
        var input = "<input type='text' class='inputEdit' value='" + value + "'>";
        $(this).html(input);
        $(this).removeClass("editFields");
      });

      $tiposDocumentosTable.on('blur', '.inputEdit', function (e) {
        var value = $(this).val(),
          $parent = $(this).parent(),
          $tr = $parent.parent();
        $parent.html(value);
        $parent.addClass("editFields");

        var data = {
          id: $tr.attr("id").split("_")[1],
          codigo: $($tr.find("td")[0]).text(),
          descripcion: $($tr.find("td")[1]).text()
        };

        $.post('addTipoDocumento.html', data, function (json) {
        }, 'json');

      });

    }
  });


  var CoordenadaController = Timbre.CoordenadaController = function () {
    this.initialize.apply(this, arguments);
  };

  $.extend(CoordenadaController.prototype, {
    initialize: function () {
      this.bindEvents();
      this.coordenadaModel = new CoordenadaModel();
    },
    bindEvents: function () {
      var $addCordenada = $("#addCordenada"),
        $timbresTable = $("#timbresTable"),
        $coordenadaForm = $("#coordenadaForm"),
        $eliminarButtons = $("[id*=eliminar_]"),
        $tipoDocumento = $("#tipoDocumento"),
        $tituloImagen = $("#tituloImagen"),
        _this = this;


      $tipoDocumento.select2({width: "240px"});
      $tituloImagen.select2({width: "240px", formatResult: this.formatImage});

      $addCordenada.on({
        click: function (e) {
          e.preventDefault();
          _this.coordenadaModel.validate();
          if (_this.coordenadaModel.isValid()) {

            var coordenadas = _this.coordenadaModel.get("coordenadas");
            var x = coordenadas.split(",")[0];
            var y = coordenadas.split(",")[1];

            var data = {
              imagen: {
                id: _this.coordenadaModel.get("tituloImagen")
              },
              tipoDocumento: {
                id: _this.coordenadaModel.get("tipoDocumento")
              },
              x: x,
              y: y
            };
            $.ajax(
              {
                url:"addCoordenada.html",
                type: "POST",
                data: JSON.stringify( data ),
                success: function(){
                  location.reload();
                },
                dataType: "json",
                contentType: "application/json"
              } );
          }
        }
      });

      $timbresTable.on('click', '.editFields', function (e) {
        e.preventDefault();
        var value = $(this).text();
        var input = "<input type='text' class='inputEdit' value='" + value + "'>";
        $(this).html(input);
        $(this).removeClass("editFields");
      });

      $timbresTable.on('blur', '.inputEdit', function (e) {
        var value = $(this).val(),
          $parent = $(this).parent(),
          $tr = $parent.parent();
        $parent.html(value);
        $parent.addClass("editFields");

        var coordenadas = $($tr.find("td")[1]).text();
        var x = coordenadas.split(",")[0];
        var y = coordenadas.split(",")[1];

        var data = {
          id: $tr.attr("id").split("_")[1],
          imagen: {
            id: $($tr.find("td")[2]).data("imagen-id")
          },
          tipoDocumento: {
            id: $($tr.find("td")[0]).data("tipo-documento-id")
          },
          x: x,
          y: y
        };


        $.ajax(
          {
            url:"addCoordenada.html",
            type: "POST",
            data: JSON.stringify( data ),
            success: function(){},
            dataType: "json",
            contentType: "application/json"
          } );
      });

      $eliminarButtons.on({
        click: function (e) {
          e.preventDefault();
          var id = $(this).attr("id").split("_")[1];
          $.post(contextPath + '/timbre/deleteCoordenada.json', {id: id}, function (json) {
            $("#tr_" + id).remove();
          }, "json");
        }
      });

    },
    formatImage: function (image) {
      if (!image.id) {
        return image.text;
      }
      var base64 = $("#tituloImagen>option[value=" + image.id + "]").data("imagen");
      var $option = $(
        '<span><img src="data:image/jpeg;base64,' + base64 + '" style="height: 15px;width: 18px;" /> ' + image.text + '</span>'
      );
      return $option;
    }
  });


  var Model = function () {
  };
  $.extend(Model.prototype, {
    initialize: function (attributes) {
      this.attributes = attributes || {};
      this.valid = true;
    },
    get: function (attr) {
      return this.attributes[attr];
    },
    set: function (key, val) {
      if (key == null) return this;
      this._previousAttributes = $.extend(this.attributes);
      this.attributes[key] = val;
    },
    previous: function (attr) {
      if (attr == null || !this._previousAttributes) return null;
      return this._previousAttributes[attr];
    },
    isValid: function () {
      return this.valid;
    },
    toJSON: function () {
      return $.extend({}, this.attributes);
    }
  });

  var ImagenModel = Timbre.ImagenModel = function () {
    this.initialize.apply(this, arguments);
  };

  $.extend(ImagenModel.prototype, Model.prototype, {
    bindData: function () {
      var $titulo = $("#titulo"),
        $imagen = $("#imagen"),
        $fileUpload = $("#fileUpload");

      this.valid = true;
      $titulo.removeClass("campo-error");
      $fileUpload.removeClass("campo-error");

      this.set("titulo", $titulo.val());
      this.set("imagen", $imagen.val());
    },
    validate: function () {
      this.bindData();
      if (this.get("titulo") == "") {
        this.valid = false;
        $("#titulo").addClass("campo-error");
      } else if (this.get("imagen") == "") {
        this.valid = false;
        $("#fileUpload").addClass("campo-error");
      }
    }
  });


  var TipoDocumentoModel = Timbre.TipoDocumentoModel = function () {
    this.initialize.apply(this, arguments);
  };

  $.extend(TipoDocumentoModel.prototype, Model.prototype, {
    bindData: function () {
      var $codigo = $("#codigo"),
        $descripcion = $("#descripcion");

      this.valid = true;
      $codigo.removeClass("campo-error");
      $descripcion.removeClass("campo-error");

      this.set("codigo", $codigo.val());
      this.set("descripcion", $descripcion.val());
    },
    validate: function () {
      this.bindData();
      if (this.get("codigo") == "") {
        this.valid = false;
        $("#codigo").addClass("campo-error");
      } else if (this.get("descripcion") == "") {
        this.valid = false;
        $("#descripcion").addClass("campo-error");
      }
    }
  });

  var CoordenadaModel = Timbre.CoordenadaModel = function () {
    this.initialize.apply(this, arguments);
  };

  $.extend(CoordenadaModel.prototype, Model.prototype, {
    bindData: function () {
      var $tipoDocumento = $("#tipoDocumento"),
        $tituloImagen = $("#tituloImagen"),
        $coordenadas = $("#coordenadas");

      this.valid = true;
      $tipoDocumento.removeClass("campo-error");
      $tituloImagen.removeClass("campo-error");
      $coordenadas.removeClass("campo-error");

      this.set("tipoDocumento", $tipoDocumento.val());
      this.set("tituloImagen", $tituloImagen.val());
      this.set("coordenadas", $coordenadas.val());
    },
    validate: function () {
      this.bindData();
      var coordenadas = this.get("coordenadas").split(",");
      if (this.get("tipoDocumento") == "") {
        this.valid = false;
        $("#tipoDocumento").addClass("campo-error");
      } else if (this.get("tituloImagen") == "") {
        this.valid = false;
        $("#tituloImagen").addClass("campo-error");
      } else if (this.get("coordenadas") == ""
        || coordenadas.length != 2
        || coordenadas[0] == "" || isNaN(coordenadas[0])
        || coordenadas[1] == "" || isNaN(coordenadas[1])) {
        this.valid = false;
        $("#coordenadas").addClass("campo-error");
      }
    }
  });


  return Timbre;

}));
