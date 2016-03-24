package com.principal.services.rest.business.daos.perfInv;

import com.principal.services.rest.common.dto.perfil.inversionista.ClasificacionDTO;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * User: Sergio Puas (sjpuas) - Bennu Ltda.
 * Project: rest-core
 */
public interface IPerfilBduDAO {

  Boolean clientExists(@Param("rut") String rut);

  ClasificacionDTO getPerfilById(@Param("id") Long id);

  ClasificacionDTO getPerfilByRut(@Param("rut") String rut);

  void updatePerfilIdByRut(@Param("id") Long id,@Param("rut") String rut);

}
