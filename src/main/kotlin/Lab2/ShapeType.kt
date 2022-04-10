package Lab2

import kotlin.math.PI
import kotlin.math.sqrt

class Circle (R: Double,
              override val borderColor: Color,
              override val fillColor: Color) : ColoredShape2d {
    private val r: Double
    init {
        r = if (R <= 0) error("Radius of circle must be a positive") else R
    }
    override fun calcArea(): Double { return PI*r*r }
    override fun toString(): String { return "Circle($r, $borderColor, $fillColor)" }
}

class Square (A: Double,
              override val borderColor: Color,
              override val fillColor: Color) : ColoredShape2d {
    private val a: Double
    init {
        a = if (A <= 0) error("Side of square must be a positive") else A
    }
    override fun calcArea(): Double { return a*a }
    override fun toString(): String { return "Square($a, $borderColor, $fillColor)" }
}

class Rectangle (A: Double, B: Double,
                 override val borderColor: Color,
                 override val fillColor: Color) : ColoredShape2d {
    private val a: Double
    private val b: Double
    init {
        a = if (A <= 0) error("Side of rectangle must be a positive") else A
        b = if (B <= 0) error("Side of rectangle must be a positive") else B
        if (a == b) error("Two sides of the rectangle must be different")
    }
    override fun calcArea(): Double { return a*b }
    override fun toString(): String { return "Rectangle ($a, $b, $borderColor, $fillColor)" }
}

class Triangle (A: Double, B: Double, C: Double,
                override val borderColor: Color,
                override val fillColor: Color) : ColoredShape2d {
    private val a: Double
    private val b: Double
    private val c: Double
    init {
        a = if (A <= 0) error("Side of triangle must be a positive") else A
        b = if (B <= 0) error("Side of triangle must be a positive") else B
        c = if (C <= 0) error("Side of triangle must be a positive") else C
        if (a + b <= c || b + c <= a || a + c <= b) error("No triangle with these three sides")
    }
    override fun calcArea(): Double { return 0.25* sqrt((a+b+c)*(a+b-c)*(a-b+c)*(b-a+c)) }
    override fun toString(): String { return "Triangle ($a, $b, $c, $borderColor, $fillColor)" }
}
