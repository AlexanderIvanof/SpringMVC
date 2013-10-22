package com.alex.spring.mvc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name  = "contact")
public class Contact implements Serializable {

	/**	Version */
	private static final long serialVersionUID = -837052584617815813L;
		

		private Long id;
		private int version;
		private String firstName;
		private String lastName;
		private Date birthDate;
		
		public Contact() {
		}

		/**
		 * @return the id
		 */
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the version
		 */
		@Version
		public int getVersion() {
			return version;
		}

		/**
		 * @param version the version to set
		 */
		public void setVersion(int version) {
			this.version = version;
		}

		/**
		 * @return the firstName
		 */
		@Column(name = "first_name")
		public String getFirstName() {
			return firstName;
		}

		/**
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * @return the lastName
		 */
		@Column(name = "last_name")
		public String getLastName() {
			return lastName;
		}

		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * @return the birthDate
		 */
		@Temporal(TemporalType.DATE)
		@Column(name = "birth_date")
		public Date getBirthDate() {
			return birthDate;
		}

		/**
		 * @param birthDate the birthDate to set
		 */
		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Contact [id=" + id + ", version=" + version + ", firstName="
					+ firstName + ", lastName=" + lastName + ", birthDate="
					+ birthDate + "]";
		}
		
}
