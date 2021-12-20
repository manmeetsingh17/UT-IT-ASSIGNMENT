package request

class Password {
  def isPasswordValid(InputPassword:String):
  Boolean=
    InputPassword.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,15}$")

}
