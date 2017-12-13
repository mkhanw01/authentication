package com.waseem.auth.restmodel;

/**
 * Created by khan on 12/13/17.
 */
public enum  ErrorCode {

  STORE_ID_MUST_NOT_BE_BLANK_OR_NULL("StoreId must not be blank or null");
  private String message;

  ErrorCode(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
