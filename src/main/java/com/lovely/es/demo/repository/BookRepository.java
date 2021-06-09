/**
 * 版权所有（c）2021. 上海海鼎信息工程股份有限公司，保留所有权利
 */
package com.lovely.es.demo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lovely.es.demo.entity.Book;

/**
 * @author LiZhiXing
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {

  /**
   * 通过名称找书
   * 
   * @param name
   *          书名
   * @return 书
   */
  Book findByName(String name);

  /**
   * 通过作者找书
   * 
   * @param author
   *          作者
   * @return 书
   */
  List<Book> findByAuthor(String author);

  /**
   * 通过id找书
   * 
   * @param id
   *          id
   * @return 书
   */
  Book findBookById(String id);
}
