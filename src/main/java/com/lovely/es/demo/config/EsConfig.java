/**
 * 版权所有（c）2021. 上海海鼎信息工程股份有限公司，保留所有权利
 */
package com.lovely.es.demo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author LiZhiXing
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.lovely.es.demo")
public class EsConfig {

  @Bean
  public RestHighLevelClient restHighLevelClient() {
    RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
        RestClient.builder(new HttpHost("localhost", 9100, "http")));
    return restHighLevelClient;
  }

}
