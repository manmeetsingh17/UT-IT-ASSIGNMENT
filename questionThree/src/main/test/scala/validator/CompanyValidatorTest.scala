package validator

import db.CompanyReadDto
import models.Company
import org.mockito.MockitoSugar.{mock, when}


class CompanyValidatorTest extends org.scalatest.flatspec.AnyFlatSpec {
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmail = mock[EmailValidator]


  "Company" should "be a valid as company does not exist in DB and email is valid" in{

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(None)
    when(mockedEmail.emailIdIsValid(knoldusCompany.emailId)) thenReturn(true)

    val companyValidator = new CompanyValidator(mockedCompanyReadDto, mockedEmail)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(result)

  }

  "Company" should "be a invalid because company does not exist in DB but email is invalid" in{

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(None)
    when(mockedEmail.emailIdIsValid(knoldusCompany.emailId)) thenReturn(false)

    val companyValidator = new CompanyValidator(mockedCompanyReadDto, mockedEmail)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

  "Company" should "be a invalid because company exist in the DB and email is valid" in{

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(Option(knoldusCompany))
    when(mockedEmail.emailIdIsValid(knoldusCompany.emailId)) thenReturn(true)

    val companyValidator = new CompanyValidator(mockedCompanyReadDto, mockedEmail)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)

  }

  "Company" should "be a invalid because company exist and email invalid" in{

    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn(Option(knoldusCompany))
    when(mockedEmail.emailIdIsValid(knoldusCompany.emailId)) thenReturn(false)

    val companyValidator = new CompanyValidator(mockedCompanyReadDto, mockedEmail)
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)

  }
}
