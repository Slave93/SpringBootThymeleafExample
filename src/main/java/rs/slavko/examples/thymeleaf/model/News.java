package rs.slavko.examples.thymeleaf.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String message;
    private Date created;
    private String author;

    public News(){
    }

    

    public News(String message, Date created, String author) {
		this.message = message;
		this.created = created;
		this.author = author;
	}



	public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
    
    
}
