import java.util.*;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {

        List<List<String>> res = new ArrayList<>();
        Set<String> foodSet = new TreeSet<>();
        Map<Integer, Table> tableMap = new TreeMap<>();

        for (List<String> order : orders) {
            Integer tableNum = Integer.valueOf(order.get(1));
            String foodName = order.get(2);
            foodSet.add(foodName);

            Table table = tableMap.get(tableNum);
            if (table != null){
                table.addFood(foodName);
            } else {
                table = new Table(tableNum);
                table.addFood(foodName);
                tableMap.put(tableNum, table);
            }
        }

        // 页头
        List<String> tableHead = new ArrayList<>(foodSet.size() + 1);
        tableHead.add("Table");
        tableHead.addAll(foodSet);
        res.add(tableHead);

        for (Map.Entry<Integer, Table> entry : tableMap.entrySet()) {
            List<String> row = new ArrayList<>(foodSet.size() + 1);
            row.add(String.valueOf(entry.getKey()));
            Table table = entry.getValue();
            for (String tableNum : foodSet) {
                row.add(String.valueOf(table.foodNum(tableNum)));
            }
            res.add(row);
        }

        return res;
    }

    static class Table implements Comparable<Table> {

        final int tableNum;
        private final Map<String, Integer> foods;

        Table(int tableNum) {
            this.tableNum = tableNum;
            foods = new HashMap<>();
        }

        void addFood(String foodName) {
            Integer foodNum = foods.getOrDefault(foodName, 0);
            foods.put(foodName, foodNum + 1);
        }

        int foodNum(String foodName){
            return foods.getOrDefault(foodName, 0);
        }

        @Override
        public int compareTo(Table o) {
            return this.tableNum - o.tableNum;
        }
    }
}
