//object session {
//    1+2
//    def abs(x: Double) = if (x < 0) -x else x
//}
//
1 + 2
//def abs(x: Double) = if (x < 0) -x else x
//
////// reformat: opt + command + L
//def isGoodEnough(guess: Double, x: Double) =
//// this is a not good version
////    abs(guess * guess - x) < 0.001
//// here is more precise version: use propation instead of just a fix 0.001
//
//  abs(guess * guess - x) / x < 0.001
//
//def improve(guess: Double, x: Double) =
//  (guess + x / guess) / 2
//
//def sqrtIter(guess: Double, x: Double): Double =
//  if (isGoodEnough(guess, x)) guess
//  else sqrtIter(improve(guess, x), x)
//
//def sqrt(x: Double) = sqrtIter(1.0, x)
// and if the number is tooooo large, it would not ternimate.

/*
  till now, all the functions are sepreate, we need to warp them up

 */

def abs(x: Double) = if (x < 0) -x else x
/*
you can eliminate the occurrence of x since they are inside def sqrt
 */
def sqrt(x: Double) = {
  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  //// reformat: opt + command + L
  def isGoodEnough(guess: Double) =
  // this is a not good version
  //    abs(guess * guess - x) < 0.001
  // here is more precise version: use propation instead of just a fix 0.001

    abs(guess * guess - x) / x < 0.001

  def improve(guess: Double) =
    (guess + x / guess) / 2

  sqrtIter(1.0)
}

sqrt(2)
sqrt(4)
sqrt(0.00000001)
sqrt(0.00001)

/*
 semicolons may omit, only case which need it is more than one
 statement on one line.
 */

