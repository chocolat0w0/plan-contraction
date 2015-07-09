package model.account

import model.plan.{NormalPlanEntity, MegaPlanEntity, SmallPlanEntity, PlanEntity}

abstract class AccountEntity {
  val discount:Int
  def say():Unit
  def changePlan(current:PlanEntity, next:PlanEntity):Unit = {
    if (next.isInstanceOf[SmallPlanEntity]) throw new InvalidChangePlanException(current, next)
    if (current.getClass == next.getClass) throw new InvalidChangePlanException(current, next)
    if (current.isInstanceOf[MegaPlanEntity] && next.isInstanceOf[NormalPlanEntity]) throw new InvalidChangePlanException(current, next)
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
class InvalidChangePlanException(val current:PlanEntity, val next:PlanEntity) extends Exception {
  val message = "%sから%sへの変更は不可能です。".format(current.name, next.name)
}
