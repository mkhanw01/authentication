package com.waseem.auth.restmodel.request;

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
public class SystemParamRequest implements Serializable {

  private static final long serialVersionUID = -7827200930627083476L;

  private String variable;
  private String value;
  private String description;
}
