package model.plan

import model.account.AccountEntity

abstract class PlanEntity {
  /** プラン名 */
  val name:String
  /** 料金 */
  val fee:Int
  /** 高速データ通信容量 */
  val capacity:String

  /**
   * 指定されたアカウント種別での利用可否を返す
   * @param account プランを利用するアカウント
   * @return
   * @throws InvalidPlanException 利用付加エラー
   */
  def isValid(account:AccountEntity):Boolean

  /**
   * プラン情報を表示する
   * @param account プランを利用するアカウント
   */
  def say(account:AccountEntity):Unit = {
    val total = fee - account.discount
    println("選択したのは%sで月%d円、容量は%sです。".format(name, total, capacity))
  }
}

object PlanEntity {
  /**
   * プラン名に相当するPlanEntityを返す
   * @param str プラン名
   * @param account プランを利用するアカウント
   * @return
   * @throws NoPlanException プラン名不正エラー
   */
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
