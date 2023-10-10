package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.example.pojo.Album;
import org.example.pojo.Comment;
import org.example.pojo.CommentList;
import org.example.pojo.Photo;
import org.example.pojo.ToDo;
import org.example.utilities.ReqSpecBuilders;
import org.example.utilities.ResSpecBuilders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetNestedResources {
  @Test
  @Description("Get a Post's comments")
  @Feature("Get Nested Resources: Post")
  public void getPostComments(){
    Comment[] getPostComments= ReqSpecBuilders.getPostReq(1)
        .when().get("/posts/{id}/comments")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Comment[].class);
//    Check we have 5 comments
    Assert.assertEquals(getPostComments.length,5);
//    Verify fields of last comment
    Assert.assertEquals(getPostComments[4].getPostId(),1);
    Assert.assertEquals(getPostComments[4].getId(),5);
    Assert.assertEquals(getPostComments[4].getName(),"vero eaque aliquid doloribus et culpa");
    Assert.assertEquals(getPostComments[4].getEmail(),"Hayden@althea.biz");
    Assert.assertEquals(getPostComments[4].getBody(),"harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et");
  }
  @Test
  @Description("Get an invalid Post's comments")
  @Feature("Get Nested Resources: Post")
  public void getInvalidPostComments() {
    Comment[] getPostComments = ReqSpecBuilders.getPostReq(101)
        .when().get("/posts/{id}/comments")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Comment[].class);
    //    Check we have an empty array
    Assert.assertEquals(getPostComments.length,0);
  }
  @Test
  @Description("Get a Post's photos")
  @Feature("Get Nested Resources: Post")
  public void getPostPhotos(){
    Photo[] getPhotos=ReqSpecBuilders.getPostReq(2)
        .when().get("/albums/{id}/photos")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Photo[].class);
    //    Check array is of correct length
    Assert.assertEquals(getPhotos.length,50);
//    Check random photo has correct fields
    Assert.assertEquals(getPhotos[36].getAlbumId(),2);
    Assert.assertEquals(getPhotos[36].getId(),87);
    Assert.assertEquals(getPhotos[36].getTitle(),"eos nihil sunt accusantium omnis");
    Assert.assertEquals(getPhotos[36].getUrl(),"https://via.placeholder.com/600/224566");
    Assert.assertEquals(getPhotos[36].getThumbnailUrl(),"https://via.placeholder.com/150/224566");
  }
  @Test
  @Description("Get a User's albums")
  @Feature("Get Nested Resources: User")
  public void getUserAlbums(){
    Album[] getUserAlbums=ReqSpecBuilders.getPostReq(5)
        .when().get("/users/{id}/albums")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Album[].class);
    //    Check array is of correct length
    Assert.assertEquals(getUserAlbums.length,10);
    //    Check random album has correct fields
    Assert.assertEquals(getUserAlbums[4].getUserId(),5);
    Assert.assertEquals(getUserAlbums[4].getId(),45);
    Assert.assertEquals(getUserAlbums[4].getTitle(),"tenetur quos ea unde est enim corrupti qui");
  }
  @Test
  @Description("Get an invalid User's albums")
  @Feature("Get Nested Resources: User")
  public void getInvalidUserAlbums() {
    Album[] getInvalidUserAlbums = ReqSpecBuilders.getPostReq(11)
        .when().get("/users/{id}/albums")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Album[].class);
    //    Check array is empty
    Assert.assertEquals(getInvalidUserAlbums.length,0);
  }
  @Test
  @Description("Get a User's todos")
  @Feature("Get Nested Resources: User")
  public void getUserToDos() {
    ToDo[] getUserToDos = ReqSpecBuilders.getPostReq(3)
        .when().get("/users/{id}/todos")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(ToDo[].class);
    //    Check array is of correct length
    Assert.assertEquals(getUserToDos.length, 20);
    //    Check random todo has correct fields
    Assert.assertEquals(getUserToDos[7].getUserId(), 3);
    Assert.assertEquals(getUserToDos[7].getId(), 48);
    Assert.assertEquals(getUserToDos[7].getTitle(), "sit reprehenderit omnis quia");
    Assert.assertEquals(getUserToDos[7].getCompleted(), "false");
  }
    @Test
    @Description("Get an invalid User's todos")
    @Feature("Get Nested Resources: User")
    public void getInvalidUserToDos() {
      Album[] getInvalidUserToDos = ReqSpecBuilders.getPostReq(11)
          .when().get("/users/{id}/todos")
          .then().spec(ResSpecBuilders.resOk()).extract().response().as(Album[].class);
      //    Check array is empty
      Assert.assertEquals(getInvalidUserToDos.length,0);
    }



  }

