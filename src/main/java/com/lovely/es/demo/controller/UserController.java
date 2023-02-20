/**
 * 版权所有（c）2021. 上海海鼎信息工程股份有限公司，保留所有权利
 */
package com.lovely.es.demo.controller;

import java.util.List;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lovely.es.demo.commons.ResponseEntity;
import com.lovely.es.demo.entity.User;
import com.lovely.es.demo.repository.UserRepository;

/**
 * 图书检索服务
 * 
 * @author LiZhiXing
 */
@RestController
@RequestMapping(value = "/v1/user", produces = "application/json;charset=utf-8")
public class UserController {

  private final UserRepository userRepository;

  private final RestHighLevelClient restHighLevelClient;

  private final ElasticsearchTemplate elasticsearchTemplate;

  public UserController(UserRepository userRepository, RestHighLevelClient restHighLevelClient,
      ElasticsearchTemplate elasticsearchTemplate) {
    this.userRepository = userRepository;
    this.restHighLevelClient = restHighLevelClient;
    this.elasticsearchTemplate = elasticsearchTemplate;
  }

  @GetMapping(value = "/get")
  public ResponseEntity<User> get(@RequestParam("id") String id) {
    Assert.hasText(id, "id");
    return ResponseEntity.ok(null);
  }

  @GetMapping(value = "/findAll")
  public ResponseEntity<List<User>> findAll() {

    return ResponseEntity.ok(null);
  }

  @PostMapping(value = "/create")
  public ResponseEntity<String> create(@RequestBody User user) {
    Assert.notNull(user, "user");

    return ResponseEntity.ok("success");
  }

  @PostMapping(value = "/update")
  public ResponseEntity<User> update(@RequestBody User user) {
    Assert.notNull(user, "user");

    return ResponseEntity.ok(user);
  }

  @GetMapping(value = "delete")
  public ResponseEntity<Void> delete(@RequestParam("id") String id) {
    Assert.hasText(id, "id");
    return ResponseEntity.ok();
  }

}
