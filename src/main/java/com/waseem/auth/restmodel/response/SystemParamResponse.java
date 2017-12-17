package com.waseem.auth.restmodel.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.io.Serializable;

/**
 * Created by khan on 12/13/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@GeneratePojoBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SystemParamResponse implements Serializable {

  private static final long serialVersionUID = -2795410837550893184L;
  private String id;
  private String variable;
  private String value;
  private String description;
  private String createdBy;
  private String updatedBy;
  private String createdDate;
  private String updatedDate;
  private Long version;
  private String storeId;
}
