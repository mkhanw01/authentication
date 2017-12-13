package com.waseem.auth.controller.intercepter;


import com.waseem.auth.restmodel.ErrorCode;
import com.waseem.auth.restmodel.MandatoryParameter;
import com.waseem.auth.restmodel.MandatoryParameterBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import static com.google.common.base.Preconditions.checkArgument;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by khan on 12/13/17.
 */
public class MandatoryParameterInterceptor extends HandlerInterceptorAdapter {
  /**
   * HttpServletRequest attribute name
   */
  public static String PARAMETER = "mandatory";

  /**
   * Get mandatory parameter from servlet request
   *
   * @param request servlet request
   * @return mandatory parameter
   */
  protected MandatoryParameter validateAndGetMandatoryParameter(HttpServletRequest request) {
    String STORE_ID = request.getHeader("storeId");
    String USER_NAME = request.getHeader("username");

    checkArgument(StringUtils.isNotBlank(STORE_ID), ErrorCode.STORE_ID_MUST_NOT_BE_BLANK_OR_NULL);

    return new MandatoryParameterBuilder().withStoreId(STORE_ID).withUsername(USER_NAME).build();
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    MandatoryParameter parameter = this.validateAndGetMandatoryParameter(request);
    request.setAttribute(PARAMETER, parameter);
    return true;
  }
}
