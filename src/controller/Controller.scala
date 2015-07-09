package controller

import model.account.{NoAccountException, AccountEntity}
import model.plan.{InvalidPlanException, NoPlanException, PlanEntity}

import scala.io.Source

/**
 * Created by shiori on 2015/07/08.
 */
object Controller {
  def main (args: Array[String]) {
    println("your account? normal/premium")
    val accountStr = Source.stdin.getLines().toSeq.head
    println("plan? small/normal/large(/mega)")
    val planStr = Source.stdin.getLines().toSeq.head

    try {
      val account = AccountEntity.entity(accountStr)
      val plan = PlanEntity.entity(planStr, account)
      account.say()
      plan.say(account)
    } catch {
      case e:NoPlanException => println("プラン名が間違っています。")
      case e:NoAccountException => println("アカウント名が間違っています。")
      case e:InvalidPlanException => println(e.message)
      case _ => println("予期せぬエラー")
    }

  }

}
