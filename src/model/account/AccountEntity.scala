package model.account

abstract class AccountEntity {
  val discount:Int
  def say():Unit
}

object AccountEntity {
  def entity(str:String):AccountEntity = {
    str match {
      case "normal" => new NormalAccountEntity
      case "premium" => new PremiumAccountEntity
      case _ => throw new NoAccountException
    }
  }
}

class NoAccountException extends Exception
