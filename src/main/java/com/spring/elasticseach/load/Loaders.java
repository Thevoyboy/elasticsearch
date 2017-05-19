package com.spring.elasticseach.load;

import com.spring.elasticseach.model.Users;
import com.spring.elasticseach.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by harsh on 5/18/2017.
 */
@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(Users.class);
        System.out.println("Loading Data");
        usersRepository.save(getData());
        System.out.printf("Loading Completed");

    }

    private List<Users> getData() {
        List<Users> userses = new ArrayList<>();
        userses.add(new Users("Harsha",123L, "Developer", 12000L));
        userses.add(new Users("Anurag",1234L, "Engineer", 22000L));
        userses.add(new Users("Ravi",1235L, "Data Admin", 12000L));
        return userses;
    }
}
