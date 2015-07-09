package model.account

class PremiumAccountEntity extends AccountEntity{
  val discount = 1000
  def say() = println("お知らせ：【プレミアム会員の継続利用について】")
}
