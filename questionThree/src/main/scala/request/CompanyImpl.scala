package request

import models.Company
import validator.CompanyValidator


class CompanyImpl(companyValidator: CompanyValidator) {
  def createCompany(company: Company): Option[String] = {
    if (companyValidator.companyIsValid(company)) Option(company.name)
    else None
  }

}
