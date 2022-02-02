class TriangleWorld {
    public static void main(String[] args) {
        //Add instance calls - discuss with Elliot
        Triangle[] triangles = {
                new Triangle(1, 1, 1), //equilateral
                new Triangle(1, 2, 2), //isosceles
                new Triangle(2, 1, 1), //flat
                new Triangle(3, 1, 1), //impossible
                new Triangle(3, 7, 5), //scalene
                new Triangle(3, 4, 5)  //right
        };

        for(Triangle triangle : triangles){ //prints triangles
            System.out.println(triangle);
        }

        Triangle maker = new Triangle(0, 0, 0);
        maker.makeTriangle(2);

    }
}