package request

import db.CompanyReadDto
import models.{Company, User}
import validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

/* In the below class we are performing Integration Testing for UserImpl,
* where we are creating an object for CompanyReadDto and EmailValidator class,
* then we creating an object for UserValidator class where we are passing above two objects as parameter,
* And, then we are making an object for UserImpl class passing above object created as parameter,
* Finally we are accessing createUser,
* in its parameter we are passing the value defined in each test cases
 */
class UserImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator(companyReadDto, emailValidator)
  val userImpl = new UserImpl(userValidator)

  "User" should "be valid" in {
    val ManmeetUser : User = User("Manmeet", "Singh", 22, 7000000, "Software Developer" ,"Knoldus", "manmeet.singh@knoldus.com")
    val result =  userImpl.createUser(ManmeetUser)
    assert(!result.isEmpty)
  }

  "User" should "be invalid as it company does not exists in DB" in {
    val JasUser : User = User("Jas", "J", 24, 5000000, "Software Developer" ,"HCL", "jasj123@gmail.com")
    val result =  userImpl.createUser(JasUser)
    assert(result.isEmpty)
  }

  "User" should "be invalid as email id is invalid" in {
    val ManmeetUser : User = User("Manmeet","Singh", 22, 7000000, "Software Developer" ,"Knoldus", "manmeet.singh@knoldus.com")
    val result = userImpl.createUser(ManmeetUser)
    assert(result.isEmpty)
  }
  "User" should "be invalid as email id is invalid" in {
    val ManmeetUser : User = User("Manmeet","Singh", 22, 7000000, "Software Developer" ,"Knoldus", "manmeet.singh@knoldus.com")
    val result = userImpl.createUser(ManmeetUser)
    assert(result.isEmpty)

  }
}