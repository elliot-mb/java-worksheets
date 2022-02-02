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


    public String isImpossible() {
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

        return "";
    }
    public String triangleType() {
        if (x1 == x2 && x2 == x3) {
            return "Equilateral";
        }

        //max

        if ((x1 == x2) || (x2 == x3) || (x1 == x3)) {
            

            return "Isoceles";
        }
    }

}