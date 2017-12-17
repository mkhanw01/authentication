package com.waseem.auth.service;

import com.waseem.auth.model.SystemParam;
import com.waseem.auth.restmodel.MandatoryParameter;

/**
 * Created by khan on 12/13/17.
 */
public interface SystemParamService {
  boolean addSystemParam(SystemParam systemParam, MandatoryParameter parameter);
  SystemParam updateSystemParam(SystemParam systemParam, MandatoryParameter parameter);
  SystemParam findByVariableAndMarkForDelete(String variable, String storeId);
}
