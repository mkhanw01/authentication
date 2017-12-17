package com.waseem.auth.mastermodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by khan on 12/13/17.
 */

public enum SubStatus {
  OK("200.000", "OK"),
  BAD_REQUEST("400.000", "Bad PostgresRequest"),
  MANDATORY_HEADER_REQUIRED("401.001", "Mandatory Parameter Required"),
  UNKNOWN_ERROR("500.001", "Unknown Error"),
  SYSTEM_ERROR("500.002", "System Error"),
  DATA_NOT_FOUND("500.003", "Data Not Found");

  private String subCode;
  private String reason;

  SubStatus(String subCode, String reason) {
    this.subCode = subCode;
    this.reason = reason;
  }

  public String getSubCode() {
    return subCode;
  }

  public void setSubCode(String subCode) {
    this.subCode = subCode;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }
}
