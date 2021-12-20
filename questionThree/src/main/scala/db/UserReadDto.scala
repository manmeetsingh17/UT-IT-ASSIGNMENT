package db


import jdk.jshell.spi.ExecutionControl.UserException

import scala.collection.immutable.HashMap

class UserReadDto {
  val ManmeetEmployee: UserReadDto = users("Manmeet")
  val abcEmployee: UserReadDto= users("abc.xyz@ola.in")

  val users: HashMap[String,UserReadDto] = HashMap("Manmeet"-> ManmeetEmployee,"abc"-> abcEmployee)

  def getUserByName(name: String): Option[UserReadDto] = users.get(name)


}
