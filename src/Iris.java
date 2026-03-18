public class Iris {
    public double[] Params;
    public String Category;

    Iris(String line) {
        String[] strings = line.split(",");
        this.Category = strings[strings.length - 1].trim();

        Params = new double[strings.length - 1];
        for (int i = 0; i < strings.length - 1; i++) {
            Params[i] = Double.parseDouble(strings[i]);
        }
    }
}
