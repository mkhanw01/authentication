package com.waseem.auth.mastermodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.waseem.auth.mastermodel.SubStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * Created by khan on 12/13/17.
 */
@GeneratePojoBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {
  private static final long serialVersionUID = 7710192229527975244L;


  @ApiModelProperty(notes = "Status code of response")
  private Integer code = HttpStatus.OK.value();

  @ApiModelProperty(notes = "Status sub code of response")
  private String subCode = SubStatus.OK.getSubCode();
  @ApiModelProperty(notes = "Message of response")
  private String message = HttpStatus.OK.getReasonPhrase();
  @ApiModelProperty(notes = "Object value of response")
  private T value;

  @ApiModelProperty(notes = "Total pages")
  private int totalPages;

  @ApiModelProperty(notes = "Total elements")
  private long totalElements;

  @Override
  public boolean equals(Object object) {
    return ObjectHelper.equals(this, object);
  }

  @Override
  public int hashCode() {
    return ObjectHelper.hashCode(this);
  }

  /**
   * Convert from VoucherBaseResponse to Spring Response Entity
   *
   * @return Spring Response Entity
   */
  public ResponseEntity<BaseResponse<T>> toResponse() {
    return new ResponseEntity<>(this, HttpStatus.valueOf(this.getCode()));
  }

}
