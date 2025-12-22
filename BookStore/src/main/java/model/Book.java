package model;

public class Book {
  private int id;
  private String title;
  private String author;
  private int count;
  
  
  public Book() {
	super();
   }

  public Book(int id, String title, String author, int count) {
	super();
	this.id = id;
	this.title = title;
	this.author = author;
	this.count = count;
  }

  public int getId() {
	return id;
  }

  public void setId(int id) {
	this.id = id;
  }

  public String getTitle() {
	return title;
  }

  public void setTitle(String title) {
	this.title = title;
  }

  public String getAuthor() {
	return author;
  }

  public void setAuthor(String author) {
	this.author = author;
  }

  public int getCount() {
	return count;
  }

  public void setCount(int count) {
	this.count = count;
  }
  
  
}
