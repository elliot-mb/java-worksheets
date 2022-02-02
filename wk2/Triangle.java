class Triangle {
    private int x1;
    private int x2;
    private int x3;

    Triangle(int x1, int x2, int x3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }


    static void makeTriangle(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    Triangle t = new Triangle(i, j, k);
                    System.out.println(t.triangleType() + "(" + i + ", " + j + ", " + k + ")");
                }
            }
        }
    } // the method is static because it does not need to be stateful/depends on no class and is not passed anything non-static

    //Helper Functions for triangle type

    //if b = 1 returns Isoceles else returns scalene, Impossible if the lengths of the two smaller sides does not equal/exceed the largest side
    public String isImpossible(boolean b) {
        if (x1 < x2) {
            if (x2 < x3) {
                if (x1 + x2 < x3) return "Impossible";
            }
            if (x1 + x3 < x2) return "Impossible";
        }

        if (x1 < x3) {
            if (x3 < x2) {
                if (x1 + x3 < x2) return "Impossible";
            }

            if (x1 + x2 < x3) return "Impossible";

        }

        if (x2 + x3 < x1) return "Impossible";

        if b return "Isoceles";
        return "Scalene"
    }

    //Finds largest side and checks that this is indeed the hypotenuse using Pythagoras' Theorem
    public boolean isRight() {
        if (x1 < x2) {
            if (x2 < x3) {
                if (Math.pow(x1, 2) + Math.pow(x2, 2) == Math.pow(x3, 2)) return true;
            }

            if (Math.pow(x1, 2) + Math.pow(x3, 2) == Math.pow(x2, 2)) return true;
        }

        if (x1 < x3) {
            if (x3 < x2) {
                if (Math.pow(x1, 2) + Math.pow(x3, 2) == Math.pow(x2, 2)) return true;
            }

            if (Math.pow(x1, 2) + Math.pow(x2, 2) == Math.pow(x3, 2)) return true;
        }

        if (Math.pow(x3, 2) + Math.pow(x2, 2) == Math.pow(x1, 2)) return true;
        return false;
    }

    //A triangle is flat if the sum of any two sides is equal to the other side
    public boolean isFlat() {
        boolean case1 = x1 + x2 == x3;
        boolean case2 = x2 + x3 == x1;
        boolean case3 = x3 + x1 == x2;

        if (case1 || case2 || case3) return true;

        return false;
    }

    public String triangleType() {
        if (x1 == x2 && x2 == x3) {
            return "Equilateral";
        }

        if ((x1 == x2) || (x2 == x3) || (x1 == x3)) {
            
            return isImpossible(true);
        }

        if ((a != b) && (b != c) && (a != c)) {
                if isRight() return "RightAngled";
                if isFlat() return "Flat";
                return isImpossible(false);
        }
    }

    //Add override instance here

}