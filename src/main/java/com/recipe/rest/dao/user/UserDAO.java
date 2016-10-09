/**
 * Created by Wo Chio Lao on 10/09/2016
 */
package com.recipe.rest.dao.user;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.recipe.rest.dto.User;
import com.recipe.rest.entity.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends GenericDAO<UserDO, Integer> {

    public List<UserDO> findByUsername(String username);

}
