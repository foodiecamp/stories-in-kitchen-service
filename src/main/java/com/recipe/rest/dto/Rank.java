/*************************************************************************
 * Created by vinay on 11/16/16.
 */
package com.recipe.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonView;
import com.recipe.rest.common.View;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@ToString
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("rank")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rank {

    @JsonView({View.GetResponse.class, View.PostResponse.class})
    private Integer id;

    @JsonView(View.GetResponse.class)
    private Integer rank;

    @JsonView(View.GetResponse.class)
    private Integer recipeId;

    @JsonView(View.GetResponse.class)
    private Integer userId;

    @JsonView(View.GetResponse.class)
    private String createdBy;

    @JsonView(View.GetResponse.class)
    private Date createdDate;

    @JsonView(View.GetResponse.class)
    private String updatedBy;

    @JsonView(View.GetResponse.class)
    private Date updatedDate;
    
    @JsonView(View.GetResponse.class)
    private Integer status;
}
