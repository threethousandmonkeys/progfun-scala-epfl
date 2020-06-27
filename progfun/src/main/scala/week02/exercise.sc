def factorial(n: Int): Int = {
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc //accumulator
    else loop(acc * n, n - 1)

  loop(1, n)
}

factorial(3)

def sum(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, f(a)+acc)
  }

  loop(a, 0)
}
sum(x=>x*x, 3,5)

/*
currying as a way to define functions piecewise,
one parameter section after the other
 */
def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int,
                                                                    b: Int)
: Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a+1, b))

def product(f: Int => Int)(a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x * y, 1)(a, b)
//  if(a > b) 1
//  else f(a) * product(f)(a+1, b)

// test
product(x=>x*x)(3, 4)

def fact(n: Int) = product(x=>x)(1, n)
fact(5)

/*
Fix point: a number x is called a fixed point of a function f if f(x) = x
 */

