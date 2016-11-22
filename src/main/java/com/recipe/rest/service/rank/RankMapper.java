/*************************************************************************
 * Created by vinay on 11/16/16.
 */
package com.recipe.rest.service.rank;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.rest.common.View;
import com.recipe.rest.common.enums.ServiceOperation;
import com.recipe.rest.common.enums.DifficultyEnum;
//import com.recipe.rest.dao.rank.RankDAO;
import com.recipe.rest.dto.Rank;
import com.recipe.rest.entity.RankDO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Component
public class RankMapper {

//    @Autowired
//    RankDAO rankDAO;

    public RankDO mapToDO(Rank rankDTO, ServiceOperation serviceOperation) {
        RankDO rankDO = new RankDO();
        BeanUtils.copyProperties(rankDTO, rankDO);
        return rankDO;
    }

    public Rank mapToDTO(RankDO rankDO, ServiceOperation serviceOperation) throws Exception {
        Rank rankDTO = new Rank();
        BeanUtils.copyProperties(rankDO, rankDTO);
        
        return serializer(rankDTO, serviceOperation);
    }

    public List<Rank> mapToDTO(List<RankDO> rankDOList, ServiceOperation serviceOperation) throws Exception {
        if (CollectionUtils.isEmpty(rankDOList)) return Collections.emptyList();
        List<Rank> userList = new ArrayList<Rank>(rankDOList.size());
        Iterator<RankDO> rankDOListItr = rankDOList.iterator();
        while (rankDOListItr.hasNext()) {
            RankDO rankDO = rankDOListItr.next();
            Rank rankDTO = new Rank();
            BeanUtils.copyProperties(rankDO, rankDTO);
            
			rankDTO = serializer(rankDTO, serviceOperation);
            userList.add(rankDTO);
        }
        return userList;
    }

    

    

    private Rank serializer(Rank rankDTO, ServiceOperation serviceOperation) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        String strOutput;
        if (serviceOperation != null) {
            if (serviceOperation.equals(ServiceOperation.ADD))
                strOutput = objectMapper.writerWithView(View.PostResponse.class).writeValueAsString(rankDTO);
            else if (serviceOperation.equals(ServiceOperation.GET))
                strOutput = objectMapper.writerWithView(View.GetResponse.class).writeValueAsString(rankDTO);
            else
                strOutput = objectMapper.writeValueAsString(rankDTO);
        } else {
            strOutput = objectMapper.writeValueAsString(rankDTO);
        }
        Rank newRankDTO = objectMapper.readValue(strOutput, rankDTO.getClass());
        return newRankDTO;
    }
}
