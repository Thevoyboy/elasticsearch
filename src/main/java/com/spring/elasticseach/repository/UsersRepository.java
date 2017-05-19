package com.spring.elasticseach.repository;

import com.spring.elasticseach.model.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by harsh on 5/18/2017.
 */
public interface UsersRepository extends ElasticsearchRepository<Users, Long> {
    List<Users> findByName(String text);

    List<Users> findBySalary(Long salary);
}