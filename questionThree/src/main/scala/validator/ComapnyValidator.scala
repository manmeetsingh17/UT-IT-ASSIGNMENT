package validator

import db.CompanyReadDto
import models.Company

class CompanyValidator(companyName: CompanyReadDto, validateEmail:EmailValidator) {

  def companyIsValid(company: Company): Boolean = {
    if(companyName.getCompanyByName(company.name).isEmpty &&
      validateEmail.emailIdIsValid(company.emailId))
      true
    else
      false
  }


}
