package com.waseem.auth.restmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by khan on 12/13/17.
 */
@GeneratePojoBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MandatoryParameter implements Serializable{
  private static final long serialVersionUID = 5625694297096869253L;

  @NotEmpty
  private String storeId;
  private String username;

}
