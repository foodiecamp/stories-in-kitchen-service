/*************************************************************************
 * Created by vinay on 11/16/16.
 */
package com.recipe.rest.dao.rank;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;
import com.recipe.rest.entity.RankDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RankDAOImpl extends GenericDAOImpl<RankDO, Integer> implements RankDAO {

    @Override
    @PersistenceContext(unitName="recipeRestPersistence")
    @Qualifier(value="entityManagerFactory")
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    @Override
    @Autowired
    @Qualifier(value="searchProcessor")
    public void setSearchProcessor(JPASearchProcessor searchProcessor) {
        super.setSearchProcessor(searchProcessor);
    }

}
