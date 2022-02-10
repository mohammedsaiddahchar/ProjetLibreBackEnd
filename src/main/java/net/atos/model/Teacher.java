package net.atos.model;


import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public abstract class Teacher extends Person {
}
