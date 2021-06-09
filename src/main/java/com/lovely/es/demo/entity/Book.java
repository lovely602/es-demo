/**
 * 版权所有（c）2021. 上海海鼎信息工程股份有限公司，保留所有权利
 */
package com.lovely.es.demo.entity;

import java.util.Date;

import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * @author LiZhiXing
 */
@Getter
@Setter
@Document(indexName = "book")
public class Book {

  /** id */
  private String id;
  /** 书名 */
  private String name;
  /** 内容 */
  private String content;
  /** 作者 */
  private String author;
  /** 出版日期 */
  private Date publicDate;

}
