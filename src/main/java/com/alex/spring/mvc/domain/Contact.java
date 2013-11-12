package com.alex.spring.mvc.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name  = "contact")
public class Contact implements Serializable {

	/**	Version */
	private static final long serialVersionUID = -837052584617815813L;
		

		private Long id;
		private int version;
		private String firstName;
		private String lastName;
		private DateTime birthDate;
		private String description;
		private byte[] photo;
		
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
		@Column(name = "birth_date")
		@Type(type = "org.joda.time.contrlib.hibernate.PersistentDateTime")
		@DateTimeFormat(iso = ISO.DATE)
		public DateTime getBirthDate() {
			return birthDate;
		}
		
		@Transient
		public String getBirthDateString(){
			String result = "NONE";
			if(birthDate != null){
				result = org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy").print(birthDate);
			}
			return result;
		}

		/**
		 * @param birthDate the birthDate to set
		 */
		public void setBirthDate(DateTime birthDate) {
			this.birthDate = birthDate;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the photo
		 */
		@Column(name = "PHOTO")
		@Lob
		@Basic(fetch = FetchType.LAZY)
		public byte[] getPhoto() {
			return photo;
		}

		/**
		 * @param photo the photo to set
		 */
		public void setPhoto(byte[] photo) {
			this.photo = photo;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Contact [id=" + id + ", version=" + version
					+ ", firstName=" + firstName + ", lastName=" + lastName
					+ ", birthDate=" + birthDate + ", description="
					+ description + "]";
		}
		
}
