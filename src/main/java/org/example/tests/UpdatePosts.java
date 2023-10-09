package org.example.tests;

import io.qameta.allure.Description;
import org.example.pojo.Post;
import org.example.utilities.ReqSpecBuilders;
import org.example.utilities.ResSpecBuilders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdatePosts {
  @Test
  @Description("Update a Post's Id")
public void updatePostTitle() {
//    Update Post Title
  Post titlePost = new Post();
  titlePost.setTitle("New Title");
  Post updatePostTitle = ReqSpecBuilders.createPostReq(titlePost)
      .when().put("posts/1")
      .then().spec(ResSpecBuilders.resOk()).extract().response().as(Post.class);
  //Assert title has changed
  Assert.assertEquals(updatePostTitle.getTitle(), "New Title");
  Assert.assertEquals(updatePostTitle.getId(), 1);
}
@Test
@Description("Update a Post's Body")
public void updatePostBody() {
  Post bodyPost = new Post();
  bodyPost.setBody("This is my newest post");
  Post updatePostBody = ReqSpecBuilders.createPostReq(bodyPost)
      .when().put("posts/1")
      .then().spec(ResSpecBuilders.resOk()).extract().response().as(Post.class);
  //Assert body has changed
  Assert.assertEquals(updatePostBody.getBody(), "This is my newest post");
  Assert.assertEquals(updatePostBody.getId(), 1);
}
}

