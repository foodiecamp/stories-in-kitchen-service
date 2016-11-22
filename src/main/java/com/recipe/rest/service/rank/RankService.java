/*************************************************************************
 * Created by vinay on 11/16/16.
 */
package com.recipe.rest.service.rank;

import com.recipe.rest.dto.Rank;

import java.util.List;
import java.util.Map;

public interface RankService {

    public Rank findById(Integer id) throws Exception;

    public Map<String, List<Rank>> findAll() throws Exception;

    public Rank add(Rank rankDTO) throws Exception;

//    public void update(Integer id, Rank rankDTO) throws Exception;
}
