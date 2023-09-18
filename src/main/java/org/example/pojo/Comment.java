package org.example.pojo;

public class Comment {
  private int postId;
  private int id;
  private String name;
  private String email;
  private String body;


  public int getId() {
    return postId;
  }

  public void setId(int postId) {
    this.postId = postId;
  }

  public int getPostId() {
    return id;
  }

  public void setPostId(int postId) {
    this.id = postId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
