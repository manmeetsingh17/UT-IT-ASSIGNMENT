package validator

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec{


  val emailValidator = new EmailValidator()

  "Email" should "be valid" in {
    val result : Boolean = emailValidator.emailIdIsValid("manmeet.singh@gmail.com")
    assert(result==true)
  }

  "Email" should "be invalid because @ does not exist " in {
    val result : Boolean = emailValidator.emailIdIsValid("manmeet.singh@gmail.com")
    assert(result==false)
  }

  "Email" should "be invalid because it cannot contain space/tabs" in {
    val result : Boolean = emailValidator.emailIdIsValid("manmeet.singh@gmail.com")
    assert(result==false)
  }

  "Email" should "be invalid because of invalid top domain" in {
    val result : Boolean = emailValidator.emailIdIsValid("manmeet.singha@gmail.com")
    assert(result==false)
  }

  "Email" should "be invalid because email cannot start from any special symbol" in {
    val result : Boolean = emailValidator.emailIdIsValid("-gmail.com")
    assert(result==false)
  }

}
