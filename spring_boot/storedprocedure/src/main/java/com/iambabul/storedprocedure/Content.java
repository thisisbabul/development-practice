package com.iambabul.storedprocedure;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Data
@Slf4j
@Entity
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "getContents", procedureName = "getContents"),
        @NamedStoredProcedureQuery(name = "getContentById", procedureName = "getContentById", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "contentId", type = Long.class)
        })})
public class Content {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String text;
    private Date created;
    private Date updated;
}
