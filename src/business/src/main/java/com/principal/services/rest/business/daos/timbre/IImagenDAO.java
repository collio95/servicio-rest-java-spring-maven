package com.principal.services.rest.business.daos.timbre;

import com.principal.services.rest.common.dto.timbre.ImagenDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public interface IImagenDAO {

  List<ImagenDTO> getImagenes();

  ImagenDTO getImagen(@Param("id") Long id);

  void saveImagen(ImagenDTO imagen);

  void updateImagen(ImagenDTO imagen);

  void deleteImagen(@Param("id") Long id);
}
