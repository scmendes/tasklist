package org.smendes.tasklist.repository;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.smendes.tasklist.entity.Tasklist;
import org.smendes.tasklist.util.DateUtil;

public class EntityToPersistListener {

	   @PrePersist
	   public void beforeCreate(final Tasklist reference) {
		   Date now = DateUtil.getCurrentDate(DateUtil.TIMEZONE_AMERICA_SAO_PAULO);
		   String nowAsString = DateUtil.dateTimeAsString(now);
		   
		   reference.setCreateDate(nowAsString);

		   if (reference.isDone() && (reference.getDoneDate() == null || reference.getDoneDate().isEmpty())) {
			   reference.setDoneDate(nowAsString);
		   }
		   
	   }	

	   @PreUpdate
	   public void beforeUpdate(final Tasklist reference) {
		   Date now = DateUtil.getCurrentDate(DateUtil.TIMEZONE_AMERICA_SAO_PAULO);
		   String nowAsString = DateUtil.dateTimeAsString(now);
		   
		   reference.setEditDate(nowAsString);
		   
		   if (reference.isDone() && (reference.getDoneDate() == null || reference.getDoneDate().isEmpty())) {
			   reference.setDoneDate(nowAsString);
		   }

	   }	
	   
}
