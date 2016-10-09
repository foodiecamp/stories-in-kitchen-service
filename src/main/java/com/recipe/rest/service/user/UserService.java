/**
 * Created by Wo Chio Lao on 10/09/2016
 */
package com.recipe.rest.service.user;

import com.recipe.rest.dto.User;
import com.recipe.rest.entity.UserDO;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User findById(Integer id) throws Exception;

    public Map<String, List<User>> findAll() throws Exception;

    public User add(User userDTO) throws Exception;

    public void update(Integer id, User userDTO) throws Exception;

    public UserDO findByUsername(String username) throws Exception;

//    public void delete(Integer id) throws Exception;
}
