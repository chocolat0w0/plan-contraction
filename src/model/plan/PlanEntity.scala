package model.plan

import model.account.AccountEntity

abstract class PlanEntity {
  val name:String
  val fee:Int
  val capacity:String
  def isValid(account:AccountEntity):Boolean
  def say(account:AccountEntity):Unit = {
    val total = fee - account.discount
    println("選択したのは%sで月%d円、容量は%sです。".format(name, total, capacity))
  }
}

object PlanEntity {
  def entity(str:String, account:AccountEntity):PlanEntity = {
    str match {
      case "small" =>
        val entity = new SmallPlanEntity()
        entity.isValid(account)
        entity
      case "normal" =>
        val entity = new NormalPlanEntity()
        entity.isValid(account)
        entity
      case "large" =>
        val entity = new LargePlanEntity()
        entity.isValid(account)
        entity
      case "mega" =>
        val entity = new MegaPlanEntity()
        entity.isValid(account)
        entity
      case _ => throw new NoPlanException
    }
  }
}

class NoPlanException extends Exception
class InvalidPlanException(val message:String) extends Exception
