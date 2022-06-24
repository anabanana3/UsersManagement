package es.uv.adiez.entities;

import javax.persistence.*;

@Entity
@Table(name = "Files")
public class File {
	@Id @Column
	private String fileId;
	//Relacion * a 1 con User
	@ManyToOne
	@JoinColumn(name="validator")
	private User validator;
	//Relacion * a 1 con User
	@ManyToOne
	@JoinColumn(name="owner")
	private User owner;
	@Column
	private int previews;
	@Column
	private int downloads;
	
	public File() {}
	
	public File(String id, User validator, User owner, int previews, int downloads) {
		this.fileId = id;
		this.validator = validator;
		this.owner = owner;
		this.previews = previews;
		this.downloads = downloads;
	}
	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public User getValidator() {
		return validator;
	}
	public void setValidator(User validator) {
		this.validator = validator;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public int getPreviews() {
		return previews;
	}
	public void setPreviews(int previews) {
		this.previews = previews;
	}
	public int getDownloads() {
		return downloads;
	}
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
}
