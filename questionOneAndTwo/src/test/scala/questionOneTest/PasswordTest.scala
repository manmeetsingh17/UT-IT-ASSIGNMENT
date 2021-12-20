package questionOneTest

import org.scalatest.flatspec.AnyFlatSpec
import questionOne.Password

class PasswordTest extends AnyFlatSpec {

  "password" should "be valid" in {
    val password = new Password()
    assert(password.isPasswordValid("Man@123"))

  }

  "password" should "invalid if we have any blank space/tabs" in {
    val password = new Password()
    assert(!password.isPasswordValid("Manmeet Singh@123"))
  }

  "password" should "invalid if we do not have at least one digit" in {
    val password = new Password()
    assert(!password.isPasswordValid("Man@org"))
  }

  "password" should "invalid if it is less than length 8" in {
    val password = new Password()
    assert(!password.isPasswordValid("ManmeetSingh17"))
  }

  "password" should "invalid if we do not have at least one lowercase" in {
    val password = new Password()
    assert(!password.isPasswordValid("MANMEET@123"))
  }

  "password" should "invalid if it is more than length 15" in {
    val passowrd = new Password()
    assert(!passowrd.isPasswordValid("ManmeetSingh@123"))
  }

  "password" should "invalid if we do not have at least one Uppercase " in {
    val password = new Password()
    assert(!password.isPasswordValid("Manmeetsingh@1234"))
  }

  "password" should "invalid if we do not have any special symbol" in {
    val password = new Password()
    assert(!password.isPasswordValid("Manmeet1234"))
  }
}
