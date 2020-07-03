abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2 // much have a override symbol, and have a correct name
  def bar = 3
}