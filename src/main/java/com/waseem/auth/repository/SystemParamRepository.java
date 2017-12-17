package com.waseem.auth.repository;

import com.waseem.auth.model.SystemParam;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by khan on 12/13/17.
 */
public interface SystemParamRepository extends JpaRepository<SystemParam, String> {
  /**
   * return systemParam based on variable
   *
   * @param variable - unique identity
   * @param storeId - should not be null.
   * @return systemParam/null
   */
  SystemParam findByVariableAndMarkForDeleteFalseAndStoreId(String variable,String storeId);
}
