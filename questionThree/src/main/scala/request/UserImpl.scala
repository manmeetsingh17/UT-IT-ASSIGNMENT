package request

import models.User
import validator.UserValidator

class UserImpl(userValidator: UserValidator) {

  def createUser(user: User): Option[String] = {
    if (userValidator.userIsValid(user)) Option(user.emailId)
    else None
  }

}
