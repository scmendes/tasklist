package org.smendes.tasklist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tasklist {

  private @Id @GeneratedValue Long id;
  private String firstName, lastName, description;

  private Tasklist() {}

  public Tasklist(String firstName, String lastName, String description) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.description = description;
  }

	@Override
	public String toString() {
		return "Tasklist [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", description="
				+ description + "]";
	}
 
}