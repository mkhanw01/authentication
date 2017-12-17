package com.waseem.auth.restmodel;

/**
 * Created by khan on 12/13/17.
 */
public interface AuthApiPath {

  String BASE_PATH ="/x-auth";
  String API ="/api";

  /* System parameter api path */

  String SYSTEM_PARAMETER = API+"/systemParameter";
  String UPDATE_BY_VARIABLE="/updateByVariable";
  String ADD="/add";
  String FIND_BY_VARIABLE="/findByVariable";

}
