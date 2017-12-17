package com.waseem.auth.model;

import com.waseem.auth.mastermodel.FieldName;
import lombok.Data;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by khan on 12/13/17.
 */
@GeneratePojoBuilder
@Data
@Entity
@Table(name = FieldName.SYSTEM_PARAM)
public class SystemParam implements Serializable {

  private static final long serialVersionUID = 3992867411963522834L;

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid",
      strategy = "uuid2")
  @Column(name = FieldName.ID)
  private String id;
  @Column(name = FieldName.STORE_ID)
  private String storeId;
  @Column(name = FieldName.MARK_FOR_DELETE)
  private boolean markForDelete;
  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = FieldName.CREATED_DATE,
      nullable = false)
  private Date createdDate;
  @LastModifiedDate
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = FieldName.UPDATED_DATE)
  private Date updatedDate;
  @CreatedBy
  @Column(name = FieldName.CREATED_BY)
  private String createdBy;
  @LastModifiedBy
  @Column(name = FieldName.UPDATED_BY)
  private String updatedBy;
  @Column(name = FieldName.VERSION)
  @javax.persistence.Version
  private Long version;

  @Column(name = FieldName.VARIABLE)
  private String variable;
  @Column(name = FieldName.VALUE)
  private String value;
  @Column(name = FieldName.DESCRIPTION)
  private String description;
}
