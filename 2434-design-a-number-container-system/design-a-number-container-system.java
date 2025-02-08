class NumberContainers {
    private Map<Integer, Integer> indexToNumber; // index -> number
    private Map<Integer, TreeSet<Integer>> numberToIndex; // number -> sorted indices

    public NumberContainers() {
        indexToNumber = new HashMap<>();
        numberToIndex = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            if (oldNumber == number)
                return; // No change needed

            numberToIndex.get(oldNumber).remove(index);
            if (numberToIndex.get(oldNumber).isEmpty()) {
                numberToIndex.remove(oldNumber);
            }
        }

        indexToNumber.put(index, number);
        numberToIndex.putIfAbsent(number, new TreeSet<>());
        numberToIndex.get(number).add(index);
    }

    public int find(int number) {
        return numberToIndex.containsKey(number) ? numberToIndex.get(number).first() : -1;
    }

}
