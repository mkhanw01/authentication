package com.waseem.auth.controller;

import com.waseem.auth.mastermodel.BaseResponse;
import com.waseem.auth.model.SystemParam;
import com.waseem.auth.restmodel.AuthApiPath;
import com.waseem.auth.restmodel.MandatoryParameter;
import com.waseem.auth.restmodel.request.SystemParamRequest;
import com.waseem.auth.restmodel.response.SystemParamResponse;
import com.waseem.auth.service.SystemParamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

import static com.waseem.auth.mastermodel.BeanMapper.map;


/**
 * Created by khan on 12/13/17.
 */
@RestController
@Api(value = "System param controller ",
    description = " SystemParam api services")
@RequestMapping(value = AuthApiPath.SYSTEM_PARAMETER)
public class SystemParamController extends BaseController {

  private static final Logger LOGGER = LoggerFactory.getLogger(SystemParamController.class);

  private SystemParamService systemParamService;

  @Autowired
  public SystemParamController(SystemParamService systemParamService) {
    this.systemParamService = systemParamService;
  }

  @PostMapping(value = AuthApiPath.ADD)
  @ApiOperation(value = "Add new system parameter")
  public BaseResponse<Boolean> addSystemParam(
      @Valid @ApiIgnore @ModelAttribute MandatoryParameter parameter,
      @RequestBody SystemParamRequest request) throws ReflectiveOperationException {
    LOGGER.info("#addSystemParam with request : {}, and parameter : {}", request, parameter);
    return authResponse(
        this.systemParamService.addSystemParam(map(request, SystemParam.class), parameter));
  }

  @GetMapping(value = AuthApiPath.FIND_BY_VARIABLE)
  @ApiOperation(value = "find system parameter")
  public BaseResponse<SystemParamResponse> findByVariable(
      @Valid @ApiIgnore @ModelAttribute MandatoryParameter parameter,
      @RequestParam String variable) throws ReflectiveOperationException {
    LOGGER.info("#findSystemParam with variable : {}, and parameter : {}", variable, parameter);
    return authResponse(map(this.systemParamService
            .findByVariableAndMarkForDelete(variable, parameter.getStoreId()),
        SystemParamResponse.class));
  }

}
