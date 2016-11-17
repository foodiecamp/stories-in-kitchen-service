/*************************************************************************
 *
 * Created by vinay on 11/16/16.
 */
package com.recipe.rest.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "rank", catalog = "npudb")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RankDO {
    @Column(name = "id", unique = true, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Integer id;

    @Column(name = "rank", nullable = true)
    @NotNull
    @Getter
    @Setter
    private int rank;

 
    @Column(name = "recipe_id", nullable = true)
    @Getter
    @Setter
    private Integer recipeId;

    @Column(name = "user_id", nullable = true)
    @Getter
    @Setter
    private Integer userId;


    @Column(name = "created_by", nullable = true, length = 1000)
    @Getter
    @Setter
    private String createdBy;

    @Column(name = "created_date", nullable = false, updatable=false)
    @Getter
    @Setter
    private Date createdDate;

    @Column(name = "updated_by", nullable = false, length = 100)
    @NotNull
    @Getter
    @Setter
    private String updatedBy;

    @Column(name = "updated_date", nullable = false)
    @Getter
    @Setter
    private Date updatedDate;
    
    
    
    @Column(name = "status", unique = true, nullable = true)
    @Id
    @Getter
    @Setter
    private Integer status;

	
	//TO Do modify createdBy and UpdateBy according to status in POST body
    @PrePersist
    protected void onCreate() {
        this.createdBy = "admin";
        this.updatedBy = "admin";
        this.createdDate = new Date();
        this.updatedDate = new Date();
    }

	//TO Do modify createdBy and UpdateBy according to status in POST body	
    @PreUpdate
    protected void onUpdate(){
        this.updatedBy = "admin";
        this.updatedDate = new Date();
    }
}
