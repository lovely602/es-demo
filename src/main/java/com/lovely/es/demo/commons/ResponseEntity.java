package com.lovely.es.demo.commons;

import javax.xml.bind.annotation.XmlTransient;

import lombok.Getter;
import lombok.Setter;

/**
 * 请求响应体
 *
 * @author lizhixing
 */
@Getter
@Setter
public class ResponseEntity<T> {

  /** echoCode等于0表示成功，其余表示失败 */
  private int code;
  private String message;
  private int page;
  private int pageSize;
  private int pageCount;
  private int total;
  private T data;

  public static <T> ResponseEntity<T> ok(T body) {
    ResponseEntity<T> responseEntity = new ResponseEntity<>();
    responseEntity.setData(body);
    return responseEntity;
  }

  public static ResponseEntity<Void> ok() {
    return new ResponseEntity<>();
  }

  public boolean isSuccess() {
    return code == 0;
  }

  public static <T> ResponseEntity<T> fail(String message) {
    ResponseEntity<T> responseEntity = new ResponseEntity<>();
    responseEntity.setCode(-1);
    responseEntity.setMessage(message);
    responseEntity.setTotal(0);
    return responseEntity;
  }

  public ResponseEntity<T> ok(int page, int pageSize, int pageCount, int total, T data) {
    ResponseEntity<T> r = new ResponseEntity<>();
    r.setPage(page);
    r.setPageSize(pageSize);
    r.setPageCount(pageCount);
    r.setTotal(total);
    r.setData(data);
    return r;
  }

  public static <T> ResponseEntity<T> ok(int page, int pageSize, int total, T data) {

    ResponseEntity<T> responseEntity = new ResponseEntity<>();
    responseEntity.setData(data);
    responseEntity.setPage(page);
    responseEntity.setPageSize(pageSize);
    responseEntity.setTotal(total);
    if (pageSize > 0) {
      int pageCount = (total - 1) / pageSize + 1;
      responseEntity.setPageCount(pageCount);
    }

    return responseEntity;
  }

  @XmlTransient
  public void inject(int page, int pageSize, int total) {
    this.setPage(page);
    this.setPageSize(pageSize);
    this.setTotal(total);
    int pageCount = pageSize == 0 ? 0 : total / pageSize;
    if (pageCount * pageSize < total) {
      ++pageCount;
    }

    this.setPageCount(pageCount);
  }

}