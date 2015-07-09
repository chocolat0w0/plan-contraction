package model.account

import model.plan.{NormalPlanEntity, MegaPlanEntity, SmallPlanEntity, PlanEntity}

abstract class AccountEntity {
  /** 値引額 */
  val discount:Int

  /**
   * お知らせを表示する
   */
  def say():Unit

  /**
   * 契約プランを変更する
   * @param current 現在契約しているプラン
   * @param next 次に契約したいプラン
   * @throws InvalidChangePlanException プラン変更不可エラー
   */
  def changePlan(current:PlanEntity, next:PlanEntity):Unit = {
    if (next.isInstanceOf[SmallPlanEntity]) throw new InvalidChangePlanException(current, next)
    if (current.getClass == next.getClass) throw new InvalidChangePlanException(current, next)
    if (current.isInstanceOf[MegaPlanEntity] && next.isInstanceOf[NormalPlanEntity]) throw new InvalidChangePlanException(current, next)
    println("%sから%sに変更しました。".format(current.name, next.name))
  }
}

object AccountEntity {
  /**
   * アカウント名に相当するAccountEntityを返す
   * @param str アカウント名
   * @return
   * @throws NoAccountException アカウント名不正エラー
   */
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
