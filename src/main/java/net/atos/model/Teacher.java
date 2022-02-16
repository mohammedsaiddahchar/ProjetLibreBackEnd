package net.atos.model;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FullTimeTeacher.class, name = "fulltimeteacher"),
        @JsonSubTypes.Type(value = PartTimeTeacher.class, name = "parttimeteacher")
})
public abstract class Teacher extends Person {
}
