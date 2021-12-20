package validator

import db.CompanyReadDto
import models.User
class UserValidator(companyName:CompanyReadDto, validateEmail:EmailValidator) {
  def userIsValid(user: User): Boolean = {
    if (!companyName.getCompanyByName(user.companyName).isEmpty &&
      validateEmail.emailIdIsValid(user.emailId))
      true
    else
      false
  }

}
