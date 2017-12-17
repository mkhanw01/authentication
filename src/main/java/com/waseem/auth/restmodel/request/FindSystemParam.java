package com.waseem.auth.restmodel.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.io.Serializable;

/**
 * Created by khan on 12/13/17.
 */
@Data
@GeneratePojoBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FindSystemParam implements Serializable {
  private static final long serialVersionUID = -1823859776223955375L;
  private String variable;
}
