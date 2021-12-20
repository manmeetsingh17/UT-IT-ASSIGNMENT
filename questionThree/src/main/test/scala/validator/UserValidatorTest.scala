package validator

import db.CompanyReadDto
import models.{Company, User}
import org.mockito.MockitoSugar.{mock, when}


class UserValidatorTest extends org.scalatest.flatspec.AnyFlatSpec {

  val ManmeetEmployee : User = User("Manmeet", "Singh", 21, 600000, "Software Developer" ,"Knoldus", "manmeet.singh@knoldus.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmail = mock[EmailValidator]


  "User" should "be a valid User because Company exist in DB and email is valid" in{

    when(mockedCompanyReadDto.getCompanyByName(ManmeetEmployee.companyName)) thenReturn (Option(knoldusCompany))

    when(mockedEmail.emailIdIsValid(ManmeetEmployee.emailId)) thenReturn(true)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(ManmeetEmployee)
    assert(result)

  }

  "User" should "be a invalid because email is not valid" in{

    when(mockedCompanyReadDto.getCompanyByName(ManmeetEmployee.companyName)) thenReturn (Option(knoldusCompany))
    when(mockedEmail.emailIdIsValid(ManmeetEmployee.emailId)) thenReturn(false)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(ManmeetEmployee)
    assert(!result)

  }

  "User" should "be a invalid because company does not exist in the DB " in{

    when(mockedCompanyReadDto.getCompanyByName(ManmeetEmployee.companyName)) thenReturn(None)
    when(mockedEmail.emailIdIsValid(ManmeetEmployee.emailId)) thenReturn(true)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(ManmeetEmployee)
    assert(!result)

  }

  "User" should "be a invalid because company does not exist in the DB and email invalid" in{

    when(mockedCompanyReadDto.getCompanyByName(ManmeetEmployee.companyName)) thenReturn(None)
    when(mockedEmail.emailIdIsValid(ManmeetEmployee.emailId)) thenReturn(false)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(ManmeetEmployee)
    assert(!result)

  }

}
