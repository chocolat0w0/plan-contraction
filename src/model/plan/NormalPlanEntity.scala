package model.plan

import model.account.AccountEntity

class NormalPlanEntity extends PlanEntity {
  val name = "ノーマルプラン"
  val fee = 5000
  val capacity = "3GB"
  def isValid(account:AccountEntity) = true
}
