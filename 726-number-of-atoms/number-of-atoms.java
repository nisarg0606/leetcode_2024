class Solution {
    public String countOfAtoms(String formula) {
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int i = 0;
        while (i < formula.length()) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (c == ')') {
                HashMap<String, Integer> top = stack.pop();
                i++;
                int j = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = i == j ? 1 : Integer.parseInt(formula.substring(j, i));
                HashMap<String, Integer> prev = stack.peek();
                for (Map.Entry<String, Integer> entry : top.entrySet()) {
                    String atom = entry.getKey();
                    int num = entry.getValue();
                    prev.put(atom, prev.getOrDefault(atom, 0) + num * count);
                }
            } else {
                int j = i + 1;
                while (j < formula.length() && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String atom = formula.substring(i, j);
                i = j;
                while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    j++;
                }
                int count = j == i ? 1 : Integer.parseInt(formula.substring(i, j));
                i = j;
                stack.peek().put(atom, stack.peek().getOrDefault(atom, 0) + count);
            }
        }
        HashMap<String, Integer> map = stack.pop();
        List<String> atoms = new ArrayList<>(map.keySet());
        Collections.sort(atoms);
        StringBuilder sb = new StringBuilder();
        for (String atom : atoms) {
            sb.append(atom);
            if (map.get(atom) > 1) {
                sb.append(map.get(atom));
            }
        }
        return sb.toString();
    }
}