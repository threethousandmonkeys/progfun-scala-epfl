class Rational(x: Int, y: Int) {
  // like assert
  require(y != 0, "denominator must be nonzero")
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a
    else gcd(b, a % b)

  def this(x: Int) = this(x, 1)
//  private val g = gcd(x, y)

  def numer = x

  def denom = y

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  def +(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  /* however, it's not good
    cuz we always wanna simplify numbers as early as possible to
    avoid overflow!!!
   */
  override def toString = {
    val g = gcd(numer, denom)
    numer / g + "/" + denom / g
  }

  def unary_- : Rational = new Rational(-numer, denom)

  def - (that: Rational) = this + -that
}

// test:

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x.numer
x.denom
x - y -z
y + y

y < x
x max y
 new Rational(2)

//object rationals {
//  val x = new Rational(1, 2)
//  x.numer
//  x.denom
//}