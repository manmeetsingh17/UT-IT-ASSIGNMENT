package request

import models.User
import validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}

/* In the below class, for each test case
* we are mocking UserValidator upon which UserImpl depends,
* Then, While creating an object for UserImpl class we passed on the mocked parameter.
* And, then we are matching our arguments combinations by using stub methods (when, thenReturn) using Mockito functions.
* Finally, we are creating a variable in which we are accessing the createUser method
* with the help of object created, then in the parameters we are passing values
 */
class UserImplTest extends org.scalatest.flatspec.AnyFlatSpec{
  val mockedUserValidate = mock[UserValidator]
  val ManmeetUser : User = User("Manmeet", "Singh", 22, 7000000, "Software Developer" ,"Knoldus", "manmeet.singh@knoldus.com")
  val NamanUser : User = User("Naman", "Singh", 24, 8000000, "Software Developer" ,"Naman Singh", "naman.singh@gmail.com")

  "User" should "be valid" in{
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(ManmeetUser)) thenReturn(true)
    val result = userImpl.createUser((ManmeetUser))
    assert(!result.isEmpty)
  }

  "User" should "be not be valid" in{
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(NamanUser)) thenReturn(false)
    val result = userImpl.createUser((NamanUser))
    assert(result.isEmpty)
  }

}
