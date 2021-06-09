/**
 * 版权所有（c）2021. 上海海鼎信息工程股份有限公司，保留所有权利
 */
package com.lovely.es.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lovely.es.demo.commons.ResponseEntity;
import com.lovely.es.demo.entity.Book;
import com.lovely.es.demo.repository.BookRepository;

/**
 * 图书检索服务
 * 
 * @author LiZhiXing
 */
@RestController
@RequestMapping(value = "/v1/book", produces = "application/json;charset=utf-8")
public class BookController {

  private final BookRepository bookRepository;

  private final RestHighLevelClient restHighLevelClient;

  private final ElasticsearchTemplate elasticsearchTemplate;

  public BookController(BookRepository bookRepository, RestHighLevelClient restHighLevelClient,
      ElasticsearchTemplate elasticsearchTemplate) {
    this.bookRepository = bookRepository;
    this.restHighLevelClient = restHighLevelClient;
    this.elasticsearchTemplate = elasticsearchTemplate;
  }

  @GetMapping(value = "/get")
  public ResponseEntity<Book> get(@RequestParam("id") String id) {
    Assert.hasText(id, "id");
    Book book = bookRepository.findBookById(id);
    return ResponseEntity.ok(book);
  }

  @GetMapping(value = "/findAll")
  public ResponseEntity<List<Book>> findAll() {
    Iterable<Book> result = bookRepository.findAll();
    List<Book> books = new ArrayList<>();
    result.forEach(books::add);
    return ResponseEntity.ok(books);
  }

  @PostMapping(value = "/create")
  public ResponseEntity<String> create(@RequestBody Book book) {
    Assert.notNull(book, "book");

    bookRepository.save(book);
    return ResponseEntity.ok("success");
  }

  @PostMapping(value = "/update")
  public ResponseEntity<Book> update(@RequestBody Book entity) {
    Assert.notNull(entity, "book");
    Book book = bookRepository.findBookById(entity.getId());
    if (Objects.isNull(book)) {
      return ResponseEntity.fail("文档不存在");
    }
    bookRepository.save(entity);
    return ResponseEntity.ok(entity);
  }

  @GetMapping(value = "delete")
  public ResponseEntity<Void> delete(@RequestParam("id") String id) {
    Assert.hasText(id, "id");
    bookRepository.deleteById(id);
    return ResponseEntity.ok();
  }

}
