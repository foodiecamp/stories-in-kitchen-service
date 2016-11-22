package com.recipe.rest.dao.rank;

import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.recipe.rest.entity.RankDO;

@Repository
public interface RankDAO extends GenericDAO<RankDO, Integer> {

}
