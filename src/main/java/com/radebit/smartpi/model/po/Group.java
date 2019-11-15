package com.radebit.smartpi.model.po;


import java.io.Serializable;

public class Group implements Serializable {

  private Integer id;
  private String groupName;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

}
