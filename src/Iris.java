public class Iris {
    public double[]Params;
    public String Category;

    Iris(String line) {
        String[] strings = line.split(",");
        Params = new double[4];
        int i =0;
        while(i < strings.length) {
            try {
                Params[i] = Double.parseDouble(strings[i]);
            } catch (Exception e) {
                this.Category = strings[strings.length - 1];
            }
            i++;
        }
    }
}
