package model.account

import model.plan.PlanEntity

abstract class AccountEntity {
  val discount:Int
  def say():Unit
  def changePlan(current:PlanEntity, next:PlanEntity):Unit = {
    println("%sから%sに変更しました。".format(current.name, next.name))
  }
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
