package model.plan

import model.account.AccountEntity
import model.plan.PlanEntity

/**
 * Created by shiori on 2015/07/08.
 */
class LargePlanEntity extends PlanEntity {
  val name = "ラージプラン"
  val fee = 7000
  val capacity = "5GB"
  def isValid(account:AccountEntity) = true
}
