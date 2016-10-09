/**
 * Created by Wo Chio Lao on 10/09/2016
 */
package com.recipe.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonView;
import com.recipe.rest.common.View;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ToString
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonView({View.GetResponse.class, View.PostResponse.class})
    private Integer id;

    @JsonView(View.GetResponse.class)
    private String username;

    @JsonView(View.PostResponse.class)
    private String password;

    @JsonView(View.GetResponse.class)
    private String email;

    @JsonView(View.GetResponse.class)
    private String nickname;

    @JsonView(View.GetResponse.class)
    private String createdBy;

    @JsonView(View.GetResponse.class)
    private Date createdDate;

    @JsonView(View.GetResponse.class)
    private String updatedBy;

    @JsonView(View.GetResponse.class)
    private Date updatedDate;
}
