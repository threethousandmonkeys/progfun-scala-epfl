def factorial(n: Int): Int = {
  def loop(acc: Int, n: Int) : Int =
    if (n == 0) acc //accumulator
    else loop(acc * n, n - 1)
  loop(1, n)
}

factorial(4)