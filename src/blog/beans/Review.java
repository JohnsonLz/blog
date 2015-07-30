package blog.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity()
@Table(name="review")
public class Review {

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "reviewID", unique = true, nullable = false)
	private int reviewID;
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=User.class)
	@JoinColumn(name = "reviewer", referencedColumnName="userName", nullable = false)
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=Article.class)
	@JoinColumn(name = "articleID", referencedColumnName="articleID", nullable = false)
	private Article article;
	
	@Column(name="time", nullable= false, length =32)
	private String time;
	
	@Column(name="content", nullable = false, length=255)
	private String content;
	
	public void setReviewID(int id) {
		this.reviewID = id;
	}
	
	public int getReviewID() {
		return reviewID;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public Article getArticle() {
		return article;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
}
