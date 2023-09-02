public class TestLine {
    public static void main(String[] args){
        Line line1 = new Line(4,4,0,0,Color.Black);
        Line line2 = new Line(1,2,4,3,Color.White);
        Line line3 = new Line(7,3,8.23,7.99,Color.Orange);
        Line line4 = new Line(6.5,8.2,9.99,32.2,Color.Purple);

        System.out.printf("%30s has length %f \n",line1.toString(),line1.length());
        System.out.printf("%30s has length %f \n",line2.toString(),line2.length());
        System.out.printf("%30s has length %f \n",line3.toString(),line3.length());
        System.out.printf("%30s has length %f \n",line4.toString(),line4.length());
    }
}
