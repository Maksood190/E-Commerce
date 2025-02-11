package com.project.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class CurrentUserSession {

	
	 @Id
	    private String uuid;
	    private Long customerId;
	    
	    public CurrentUserSession() {
			// TODO Auto-generated constructor stub
		}

		public CurrentUserSession(String uuid, Long customerId) {
			super();
			this.uuid = uuid;
			this.customerId = customerId;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
	    
	    
	    
}
