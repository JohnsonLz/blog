package blog.beans;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity()
@Table(name="article")
public class Article implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "articleID", unique = true, nullable = false)
	private int articleID;
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=User.class)
	@JoinColumn(name = "author", referencedColumnName="userName", nullable = false)
	private User user;
	
	@Column(name="title",nullable = false,length =255)
	private String title;
	
	@Column(name="time",nullable = false, length = 16)
	private String time;
	
	@Column(name="content", nullable=false,columnDefinition="text")
	private String content;
	
	@Column(name="reviewNumber")
	private int reviewNumber;
	
	@Column(name="zanNumber")
	private int zanNumber;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title  =title;
	}
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content  =content;
	}
	
	public int getArticleID() {
		return articleID;
	}
	
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getReviewNumber() {
		return reviewNumber;
	}
	
	public void setReviewNumber(int reviewNumber) {
		this.reviewNumber = reviewNumber;
	}
	
	public int getZanNumber() {
		return zanNumber;
	}
	
	public void setZannNumber(int zanNumber) {
		this.zanNumber = zanNumber;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
}
