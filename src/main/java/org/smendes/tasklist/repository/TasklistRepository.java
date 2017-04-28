package org.smendes.tasklist.repository;

import java.util.List;

import org.smendes.tasklist.entity.Tasklist;
import org.springframework.data.repository.CrudRepository;

public interface TasklistRepository extends CrudRepository<Tasklist, Long> {

	  Tasklist findByFirstName(String firstName);

	  List<Tasklist> findByLastName(String lastName);
}