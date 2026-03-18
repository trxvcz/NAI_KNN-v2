
void main() {
    File f = new File("iris.txt");
    ArrayList<Iris> dataset = new ArrayList<>();

    try {
        Scanner scanner = new Scanner(f);
        //removing first line
        String line = scanner.nextLine();

        while(scanner.hasNext()){
            line = scanner.nextLine();
            dataset.add(new Iris(line));
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

    List<List<Iris>> split = getDatasets(dataset, 0.4, new Random(42));
    List<Iris> trainData = split.get(0);
    List<Iris> testData = split.get(1);

    Knn model = new Knn(trainData, 5);

    String[] preds = model.predict(getParams(testData));

    System.out.println(Knn.accuracyScore(preds,getCategories(testData)));

    File f1 = new File("test.txt");
    Knn model2 = new Knn(dataset, 5);

    System.out.println(model2.predict(f1));

}

// train_test_split
public List<List<Iris>> getDatasets(List<Iris> irises, double testSize, Random rand) {
    Map<String, List<Iris>> map = new HashMap<>();
    for (Iris i : irises) {
        map.computeIfAbsent(i.Category, j -> new ArrayList<>()).add(i);
    }

    List<Iris> trainSet = new ArrayList<>();
    List<Iris> testSet = new ArrayList<>();
    for(List<Iris> list : map.values()){
        Collections.shuffle(list,rand);

        int testCount =  (int) Math.round(list.size() * testSize);
        testSet.addAll(list.subList(0, testCount));
        trainSet.addAll(list.subList(testCount, list.size()));
    }

    return List.of(trainSet,testSet);

}

// makes 2d matrix of parameters -> x_train/x_test
public double[][] getParams(List<Iris>irises){
    double[][] y = new double[irises.size()][];
    for(int i = 0; i < irises.size(); i++){
        y[i] = irises.get(i).Params;
    }
    return y;
}

// makes vector from irises.category -> y_train,y_test
public String[] getCategories(List<Iris>irises){
    String[] categories = new String[irises.size()];
    for(int i = 0; i < irises.size(); i++){
        categories[i] = irises.get(i).Category;
    }
    return categories;
}
