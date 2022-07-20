package com.example.northwind.business.abstracts;

import com.example.northwind.core.entities.User;
import com.example.northwind.core.utilities.results.DataResult;
import com.example.northwind.core.utilities.results.Result;
import com.example.northwind.entities.concretes.Product;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();

    Result add(User user);

    DataResult<User> findByEmail(String email);

}
