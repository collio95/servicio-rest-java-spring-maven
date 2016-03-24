package com.principal.services.rest.business.daos.perfInv;

import com.principal.services.rest.common.dto.perfil.inversionista.ClienteDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IClienteDAO {

  List<ClienteDTO> getClienteByRut(@Param("rut") String rut);

}
