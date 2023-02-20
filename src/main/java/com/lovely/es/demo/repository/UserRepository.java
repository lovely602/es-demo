/**
 * 版权所有（c）2021. 上海海鼎信息工程股份有限公司，保留所有权利
 */
package com.lovely.es.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lovely.es.demo.entity.User;

/**
 * @author LiZhiXing
 */
public interface UserRepository extends ElasticsearchRepository<User, String> {

}
