package model.plan

import model.plan.SmallPlanEntity

/**
 * Created by shiori on 2015/07/08.
 */
abstract class PlanEntity {
  def name:String
  def fee:Int
  def capacity:String
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

  def message(plan: PlanEntity) = {
    "選択したのは%sで月%d円、容量は%sです。".format(plan.name, plan.fee, plan.capacity)
  }
}

class NoPlanException extends Exception
