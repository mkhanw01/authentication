package com.waseem.auth.controller;

import com.waseem.auth.controller.intercepter.MandatoryParameterInterceptor;
import com.waseem.auth.mastermodel.BaseResponse;
import com.waseem.auth.mastermodel.BaseResponseBuilder;
import com.waseem.auth.restmodel.MandatoryParameter;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by khan on 12/13/17.
 */
public class BaseController {
  /**
   * Get mandatory parameter from http servlet request
   *
   * @param request servlet request
   * @return mandatory parameter or null
   */
  @ModelAttribute
  public MandatoryParameter getMandatoryParameter(HttpServletRequest request) {
    return (MandatoryParameter) request.getAttribute(MandatoryParameterInterceptor.PARAMETER);
  }


  /**
   * @param data data
   * @param <T> data type
   */
  public <T> BaseResponse<T> authResponse(T data) {
    return new BaseResponseBuilder<T>().withValue(data).build();
  }
}
