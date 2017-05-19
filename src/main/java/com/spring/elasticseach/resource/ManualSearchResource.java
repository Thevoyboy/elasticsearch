package com.spring.elasticseach.resource;

import com.spring.elasticseach.builder.SearchQueryBuilder;
import com.spring.elasticseach.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by harsh on 5/19/2017.
 */
@RestController
@RequestMapping("/rest/manual/search")
public class ManualSearchResource {

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;
    @GetMapping(value = "/{text}")
    public List<Users> getAll(@PathVariable final String text){
        return searchQueryBuilder.getAll(text);
    }
}
