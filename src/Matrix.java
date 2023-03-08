public class Matrix {
    private int row, colom, max, min;
    private int[][] data;

    public Matrix(int colom, int row, int max, int min){
        this.colom = colom;
        this.row = row;
        this.max = max;
        this.min = min;
        this.data = new int[colom][row];
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[i].length;j++){
                int rnd=(int)(Math.random()*(max - min + 1)) + min;
                data[i][j]=rnd;
            }
        }
    }

    public Matrix(Matrix other) {
        int rows = other.data.length;
        int colom = other.data[0].length;
        data = new int[rows][colom];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colom; j++) {
                data[i][j] = other.data[i][j];
            }
        }
    }

    public boolean isSquare(){
        return colom==row;
    }

    public boolean isRear(){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colom; j++) {
                if (i == j && data[i][j] != 1) {
                    return false;
                } 
                else if (i != j && data[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSymetric(){
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[i].length;j++){
                if(data[i][j]!=data[j][i]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDefenetlySame(Matrix other) {
        if (colom != other.colom || row != other.row) {
            return false;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colom; j++) {
                if (data[i][j] != other.data[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public Matrix subMatrix(int i, int j, int a, int b) {
        Matrix result = new Matrix(a, b, max, min);
        for (int k = 0; k < a; k++) {
            for (int l = 0; l < b; l++) {
                result.data[k][l] = data[k + i][l + j];
            }
        }
        return result;
    }

    public void show() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(i+".  " + "(");
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]);
                if (j != data[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print(")\n");
        }
    }
}
