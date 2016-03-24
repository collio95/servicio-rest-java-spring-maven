package com.principal.services.rest.controllers;

import com.principal.services.rest.common.dto.timbre.ImagenDTO;
import com.principal.services.rest.common.dto.timbre.TimbreDTO;
import com.principal.services.rest.common.dto.timbre.TipoDocumentoDTO;
import com.principal.services.rest.common.ejb.local.TimbreLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
@Controller
@RequestMapping("/timbre")
public class MantenedorTimbreController {

  @Autowired
  private TimbreLocal timbreService;

  @RequestMapping(value = "/imagen.html", method = RequestMethod.GET)
  public String imagen(Model model) {
    model.addAttribute("imagenes", timbreService.getImagenes());
    return "imagen";
  }

  @RequestMapping(value = "/tipoDocumento.html", method = RequestMethod.GET)
  public String tipoDocumento(Model model) {
    model.addAttribute("tiposDocumentos", timbreService.getTiposDocumentos());
    return "tipo_documento";
  }

  @RequestMapping(value = "/coordenadas.html", method = RequestMethod.GET)
  public String coordenadas(Model model) {
    model.addAttribute("tiposDocumentos", timbreService.getTiposDocumentos());
    model.addAttribute("imagenes", timbreService.getImagenes());
    model.addAttribute("coordenadas", timbreService.getTimbres());
    return "coordenadas";
  }

  @RequestMapping(value = "/addImage.html", method = RequestMethod.POST)
  public String addImage(@ModelAttribute("titulo") String titulo,
                         @ModelAttribute("imagen") MultipartFile imagen,
                         RedirectAttributes ra) throws Exception {

    if (!imagen.isEmpty()
      || "image/jpeg".equalsIgnoreCase(imagen.getContentType())
      || "image/png".equalsIgnoreCase(imagen.getContentType())
      ) {
      ImagenDTO imagenDTO = new ImagenDTO();
      imagenDTO.setTitulo(titulo);
      imagenDTO.setBase64(Base64Utils.encodeToString(imagen.getBytes()));
      imagenDTO.setAlto(92L);
      imagenDTO.setAncho(92L);
      timbreService.saveImagen(imagenDTO);
    }

    return "redirect:/timbre/imagen.html";
  }

  @RequestMapping(value = "/addTipoDocumento.html", method = RequestMethod.POST)
  public String addTipoDocumento(@ModelAttribute("tipoDocumento") TipoDocumentoDTO tipoDocumento,
                                 Model model) throws Exception {
    Long id = timbreService.saveTipoDocumento(tipoDocumento);
    tipoDocumento.setId(id);
    model.addAttribute("jsonResponse", tipoDocumento);
    return "jsonView";
  }

  @RequestMapping(value = "/addCoordenada.html", method = RequestMethod.POST)
  public String addCoordenada(@RequestBody TimbreDTO timbre) throws Exception {
    timbreService.saveTimbre(timbre);
    return "jsonView";
  }

  @RequestMapping(value = "/deleteImagen.json", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, String> deleteImagen(@ModelAttribute("id") Long id) throws Exception {
    timbreService.deleteImagen(id);
    Map<String, String> response = new HashMap<String, String>();
    response.put("status", "ok");
    return response;
  }


  @RequestMapping(value = "/deleteTipoDocumento.json", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, String> deleteTipoDocumento(@ModelAttribute("id") Long id) throws Exception {
    timbreService.deleteTipoDocumento(id);
    Map<String, String> response = new HashMap<String, String>();
    response.put("status", "ok");
    return response;
  }


  @RequestMapping(value = "/deleteCoordenada.json", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, String> deleteCoordenada(@ModelAttribute("id") Long id) throws Exception {
    timbreService.deleteTimbre(id);
    Map<String, String> response = new HashMap<String, String>();
    response.put("status", "ok");
    return response;
  }


}
