/**
 * 版权所有（c）2021. 上海海鼎信息工程股份有限公司，保留所有权利
 */
package com.lovely.es.demo.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * @author LiZhiXing
 */
@Setter
@Getter
@Document(indexName = "user", type = "user")
public class User {

  @Id
  private String id;
  /** 姓名 */
  private String name;
  /** 性别 */
  private String sex;
  /** 年龄 */
  private int age;
  /** 生日 */
  private Date birthday;
}
