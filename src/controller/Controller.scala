package controller

import model.account.{NoAccountException, AccountEntity}
import model.plan.{NoPlanException, PlanEntity}

import scala.io.Source

/**
 * Created by shiori on 2015/07/08.
 */
object Controller {
  def main (args: Array[String]) {
    println("your account? normal/premium")
    val account = Source.stdin.getLines().toSeq.head
    println("plan? small/normal/large")
    val plan = Source.stdin.getLines().toSeq.head
    try {
      println(PlanEntity.message(PlanEntity.entity(plan), AccountEntity.entity(account)))
    } catch {
      case e:NoPlanException => println("プラン名が間違っています。")
      case e:NoAccountException => println("アカウント名が間違っています。")
      case _ => println("予期せぬエラー")
    }

  }

}
