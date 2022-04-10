package Lab2

class ShapeCollector {
    val listShape: MutableList<ColoredShape2d> = mutableListOf()

    fun addShape (Shape: ColoredShape2d) { listShape.add(Shape)}

    fun smallestShape() : Shape2d {
        if (listShape.isEmpty()) throw IllegalArgumentException("Collector shapes is empty!")
        else {
            var smallestShape = listShape[0]
            for(temp in listShape) {
                if (temp.calcArea() < smallestShape.calcArea()) {
                    smallestShape = temp
                }
            }
            return smallestShape
        }
    }

    fun largestShape() : Shape2d {
        if (listShape.isEmpty()) throw IllegalArgumentException("Collector shapes is empty!")
        else {
            var largestShape = listShape[0]
            for(temp in listShape) {
                if (temp.calcArea() > largestShape.calcArea()) {
                    largestShape = temp
                }
            }
            return largestShape
        }
    }

    fun sumArea(): Double {
        if (listShape.isEmpty()) throw IllegalArgumentException("Collector shapes is empty!")
        else {
            var sumArea = 0.0
            for(temp in listShape) {
                sumArea += temp.calcArea()
            }
            return sumArea
        }
    }

    fun shapeBorderColor(Color: Color): List<ColoredShape2d> {
        if (listShape.isEmpty()) throw IllegalArgumentException("Collector shapes is empty!")
        else {
            val searchList: MutableList<ColoredShape2d> = mutableListOf()
            for (temp in listShape) {
                if (temp.borderColor == Color)
                    searchList.add(temp)
            }
            return searchList
        }
    }

    fun shapeFillColor(Color: Color): List<ColoredShape2d> {
        if (listShape.isEmpty()) throw IllegalArgumentException("Collector shapes is empty!")
        else {
            val searchList: MutableList<ColoredShape2d> = mutableListOf()
            for (temp in listShape) {
                if (temp.fillColor == Color)
                    searchList.add(temp)
            }
            return searchList
        }
    }

    fun allStoredShapes(): List<ColoredShape2d> {
        return listShape.toList()
    }

    fun numberShapes(): Int {
        return listShape.size
    }

    fun getShapesGroupedByBorderColor(): Map<Color,List<ColoredShape2d>> {
        if (listShape.isEmpty()) throw IllegalArgumentException("Collector shapes is empty!")
        else {
            val map = mutableMapOf<Color, List<ColoredShape2d>>()
            for (shape in listShape) {
                map[shape.borderColor] = shapeBorderColor(shape.borderColor)
            }
            return map
        }
    }

    fun getShapesGroupedByFillColor(): Map<Color,List<ColoredShape2d>> {
        if (listShape.isEmpty()) throw IllegalArgumentException("Collector shapes is empty!")
        else {
            val map = mutableMapOf<Color, List<ColoredShape2d>>()
            for (shape in listShape) {
                map[shape.fillColor] = shapeFillColor(shape.fillColor)
            }
            return map
        }
    }

    inline fun<reified T> shapesByType() : List<ColoredShape2d> {
        if (listShape.isEmpty()) throw IllegalArgumentException("Collector shapes is empty!")
        else {
            val newList = mutableListOf<ColoredShape2d>()
            for (Shape in listShape) {
                if (Shape is T) {
                    newList.add(Shape)
                }
            }
            return newList
        }
    }

}
