package org.example.utilities;

import org.example.pojo.Post;

public class GetDetails {

  public static int getUserIdFromPostId(int id) {
    int modId = id % 10;
    int roundedId = id - modId;
    int userId;
    if (roundedId == id) {
      userId = roundedId / 10;
    } else {
      userId = roundedId / 10 + 1;
    }
    return userId;
  }

}
