package org.example.tests;

import org.example.utilities.ReqSpecBuilders;
import org.example.utilities.ResSpecBuilders;
import org.testng.annotations.Test;

public class DeletePosts {
  @Test
  public void deletePost(){
    ReqSpecBuilders.deletePostReq(1)
        .when().delete("/posts/{id}")
        .then().spec(ResSpecBuilders.resOk());
  }
}
