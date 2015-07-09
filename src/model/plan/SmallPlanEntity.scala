package model.plan

import model.account.{PremiumAccountEntity, AccountEntity}

class SmallPlanEntity extends PlanEntity {
  val name = "スモールプラン"
  val fee = 3000
  val capacity = "1GB"
  def isValid(account:AccountEntity) = true
}
