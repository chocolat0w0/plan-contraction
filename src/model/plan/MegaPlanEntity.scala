package model.plan

import model.account.{PremiumAccountEntity, AccountEntity}

class MegaPlanEntity extends PlanEntity {
  val name = "メガプラン"
  val fee = 9000
  val capacity = "7GB"
  def isValid(account:AccountEntity) = {
    if (account.isInstanceOf[PremiumAccountEntity]) true
    else throw new InvalidPlanException("メガプランはプレミアム会員のみです")
  }

}
