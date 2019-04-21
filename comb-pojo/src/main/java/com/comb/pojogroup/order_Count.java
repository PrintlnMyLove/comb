package com.comb.pojogroup;

import java.io.Serializable;

/**
 * @author Zhengtao Yu
 * @ClassName order_Count
 * @Date 2019/4/20 11:23
 * @Version 1.0
 **/
public class order_Count implements Serializable {
    private String sellerId;
    private int orderNum;

  public String getSellerId() {
    return sellerId;
  }

  public void setSellerId(String sellerId) {
    this.sellerId = sellerId;
  }

  public int getOrderNum() {
    return orderNum;
  }

  public void setOrderNum(int orderNum) {
    this.orderNum = orderNum;
  }
}
