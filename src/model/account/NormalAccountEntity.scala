package model.account

class NormalAccountEntity extends AccountEntity {
  val discount = 0
  def say() = println("お知らせ：【プレミアム会員になりませんか】")

}
