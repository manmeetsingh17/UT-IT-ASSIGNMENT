package db

import scala.collection.immutable.HashMap

class CompanyReadDto {
  val knoldusCompany: CompanyReadDto = companies("knoldus")
  val olaCompany: CompanyReadDto= companies("Bangalore")
  val companies: HashMap[String, CompanyReadDto] = HashMap("Knoldus"-> knoldusCompany, "OLA"-> olaCompany )

  def getCompanyByName(name: String): Option[CompanyReadDto] = companies.get(name)


}




