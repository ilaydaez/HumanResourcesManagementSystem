package ilayda.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","user"})
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="image_id")
	private int imageId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="image_path")
	private String imagePath;
	
	@Column(name="public_id")
	private String publicId;
	
//	@Column(name="upload_date")
//	private Date uploadDate;
	
	
	@ManyToOne()
	@JoinColumn(name = "id")
	private User user;
	
	public Image(String name, String imagePath, String publicId, User user) {
		this.name = name;
		this.imagePath = imagePath;
		this.publicId = publicId;
		this.user = user;

	}

}
