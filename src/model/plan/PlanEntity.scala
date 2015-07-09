package model.plan

import model.account.AccountEntity

abstract class PlanEntity {
  val name:String
  val fee:Int
  val capacity:String
}

object PlanEntity {
  def entity(str:String) = {
    str match {
      case "small" => new SmallPlanEntity
      case "normal" => new NormalPlanEntity
      case "large" => new LargePlanEntity
      case _ => throw new NoPlanException
    }
  }

  def message(plan: PlanEntity, account: AccountEntity) = {
    val fee = plan.fee - account.discount
    "選択したのは%sで月%d円、容量は%sです。".format(plan.name, fee, plan.capacity)
  }
}

class NoPlanException extends Exception
