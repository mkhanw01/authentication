package com.waseem.auth.service.impl;

import com.waseem.auth.model.SystemParam;
import com.waseem.auth.repository.SystemParamRepository;
import com.waseem.auth.restmodel.MandatoryParameter;
import com.waseem.auth.service.SystemParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by khan on 12/13/17.
 */
@Service
public class SystemParamServiceImpl implements SystemParamService{

  private static final Logger LOGGER = LoggerFactory.getLogger(SystemParamServiceImpl.class);

  private SystemParamRepository paramRepository;

  @Autowired
  public SystemParamServiceImpl (SystemParamRepository paramRepository) {
    this.paramRepository = paramRepository;
  }

  @Override
  public boolean addSystemParam(SystemParam systemParam, MandatoryParameter parameter) {
    try {
      LOGGER.info("#saving systemParam : {}, with paramter : {}", systemParam, parameter);
      systemParam.setStoreId(parameter.getStoreId());
      systemParam.setCreatedBy(parameter.getUsername());
      systemParam.setUpdatedBy(parameter.getUsername());
      systemParam.setCreatedDate(new Date());
      systemParam.setUpdatedDate(new Date());
      this.paramRepository.save(systemParam);
      LOGGER.info("#Successfully save systemParam : {}", systemParam);
      return true;
    } catch (Exception e) {
      LOGGER.error("#failed to save systemParam : {}, with parameter : {}, and error : {}",
          systemParam, parameter, e);
      return false;
    }
  }

  @Override
  public SystemParam updateSystemParam(SystemParam systemParam, MandatoryParameter parameter) {

    return null;
  }

  @Override
  public SystemParam findByVariableAndMarkForDelete(String variable,
      String storeId) {
    return this.paramRepository.findByVariableAndMarkForDeleteFalseAndStoreId
        (variable, storeId);
  }

}
