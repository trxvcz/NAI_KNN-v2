import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Knn {
    private List<Iris> dataset;
    private int KNearestNeighbours;

    private record DistanceFromVector(String category,double distance){}

    public Knn(List<Iris> dataset, int k) {
        this.dataset = dataset;
        this.KNearestNeighbours = k;
        if (k%2==0) System.out.println("Warning: K better to be odd, otherwise in draw result will be chosen random");
    }

    private double calculateEuclideanDistance(double[] vector1, double[] vector2){
        if ((vector1.length) != vector2.length) {
//            System.out.println(vector1.length + " != " + vector2.length);
            throw new IllegalArgumentException("vectors must have same dimension");
        }
        double sum = 0.0;
        for (int i = 0; i < vector2.length; i++) {
            double diff = vector1[i] - vector2[i];
            sum += diff * diff;
        }
        return Math.sqrt(sum);
    }

    public String predict(double[] valid) {
        List<DistanceFromVector> distancesList = new ArrayList<>();

        for (Iris i : dataset) {
            distancesList.add(new DistanceFromVector(i.Category,calculateEuclideanDistance(i.Params, valid)));
        }


        Map<String, Integer> counts = new HashMap<>();
        distancesList.stream()
                .sorted(Comparator.comparingDouble(DistanceFromVector::distance))
                .limit(this.KNearestNeighbours)
                .forEach(d -> counts.put(d.category(), counts.getOrDefault(d.category(), 0) + 1));

//        System.out.println(counts);
        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public String[] predict(double[][] valid) {
        ArrayList<String> result = new ArrayList<>();

        for (double[] v : valid) {
            result.add(predict(v));
        }
        return result.toArray(new String[0]);
    }

    public double predict(File f){
        ArrayList<Iris> testSet = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(f);
            //removing first line
            scanner.nextLine();

            while(scanner.hasNext()){
                String line = scanner.nextLine();
                testSet.add(new Iris(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        double[][] irisParams = new double[testSet.size()][];
        String[] testSetLabels = new String[testSet.size()];
        for (int i = 0; i < testSet.size(); i++) {
            irisParams[i] = testSet.get(i).Params;
            testSetLabels[i] = testSet.get(i).Category;
        }

        String[] resultLabels = predict(irisParams);

        return accuracyScore(resultLabels, testSetLabels);
    };

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

    public static double accuracyScore(String[] predResult,String[] realResult){
        int count_correct = 0;
        for(int i = 0; i < predResult.length; i++){
            if(predResult[i].equals(realResult[i])){
                count_correct++;
            }
        }
        return (double)count_correct/realResult.length;
    }

}
