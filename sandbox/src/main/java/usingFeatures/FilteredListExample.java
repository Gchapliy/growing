package usingFeatures;

import com.google.common.collect.Lists;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;

public class FilteredListExample {
    public static void main(String[] args) {
        FilteredList<Integer> filteredList = new FilteredList(FXCollections.observableList(Lists.newArrayList(1,2,3,4,5)), p -> true);
        filteredList.setPredicate(p -> p.compareTo(2) != 0);
        //filteredList.setPredicate(filteredList.getPredicate().and(p -> p != 3));

        System.out.println(filteredList);
    }
}
