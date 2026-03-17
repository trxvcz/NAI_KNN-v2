
void main() {
    File f = new File("iris.txt");
    ArrayList<Iris> dataset = new ArrayList<>();

    try {
        Scanner scanner = new Scanner(f);

        scanner.next();

        while(scanner.hasNext()){
            String line = scanner.next();
            dataset.add(new Iris(line));
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

    Knn model = new Knn(dataset, 5);
    double[] valid = {6.,3.,4.1,1.2};
    System.out.println(model.predict(valid));


}
