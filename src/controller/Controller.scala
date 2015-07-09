package controller

import model.account.{InvalidChangePlanException, NoAccountException, AccountEntity}
import model.plan.{InvalidPlanException, NoPlanException, PlanEntity}

import scala.io.Source

/**
 * Created by shiori on 2015/07/08.
 */
object Controller {
  def main (args: Array[String]) {
    println("your account? normal/premium")
    val accountStr = Source.stdin.getLines().toSeq.head
    println("current plan? small/normal/large(/mega)")
    val currentPlanStr = Source.stdin.getLines().toSeq.head
    println("next plan? small/normal/large(/mega)")
    val nextPlanStr = Source.stdin.getLines().toSeq.head

    try {
      val account = AccountEntity.entity(accountStr)
      val currentPlan = PlanEntity.entity(currentPlanStr, account)
      val nextPlan = PlanEntity.entity(nextPlanStr, account)
      account.say()
      account.changePlan(currentPlan, nextPlan)
      nextPlan.say(account)
    } catch {
      case e:NoPlanException => println("プラン名が間違っています。")
      case e:NoAccountException => println("アカウント名が間違っています。")
      case e:InvalidPlanException => println(e.message)
      case e:InvalidChangePlanException => println(e.message)
      case _ => println("予期せぬエラー")
    }

  }

}
