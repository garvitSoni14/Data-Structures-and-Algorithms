package codevita;

import java.util.*;

public class Futuris {
    static class Env {
        Map<String, Integer> vars;
        Env(Map<String, Integer> vars) {
            this.vars = new HashMap<>(vars);
        }
        int getValue(String token) {
            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException e) {
                return vars.getOrDefault(token, 0);
            }
        }
        Env copy() {
            return new Env(vars);
        }
        void setVar(String var, int val) {
            vars.put(var, val);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> code = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            code.add(line);
        }
        // Last two lines: variables and values
        int n = code.size();
        String varsLine = code.get(n - 2);
        String valsLine = code.get(n - 1);

        Map<String, Integer> initialVars = new HashMap<>();
        String[] varsArr = varsLine.split("\\s+");
        String[] valsArr = valsLine.split("\\s+");
        for (int i = 0; i < varsArr.length; i++) {
            initialVars.put(varsArr[i], Integer.parseInt(valsArr[i]));
        }
        List<String> progLines = code.subList(0, n - 2);
        Env env = new Env(initialVars);

        List<String> output = execute(progLines, env, 0, progLines.size());
        for (String out : output) {
            System.out.println(out);
        }
    }

    static List<String> execute(List<String> lines, Env env, int start, int end) {
        List<String> output = new ArrayList<>();
        for (int i = start; i < end; ) {
            String line = lines.get(i);
            if (line.startsWith("if ")) {
                // Parse condition
                String cond = line.substring(3).trim();
                // Find block bounds and possible "No"
                int yesStart = i + 1;
                int yesEnd = -1;
                int noStart = -1;
                int noEnd = -1;

                int nest = 0;
                for (int j = yesStart; j < end; j++) {
                    String l = lines.get(j);
                    if (l.startsWith("if ") || l.startsWith("for ")) nest++;
                    else if (l.equals("end")) {
                        if (nest == 0) {
                            yesEnd = j;
                            break;
                        }
                        nest--;
                    } else if (l.equals("No") && nest == 0) {
                        yesEnd = j;
                        noStart = j + 1;
                        // Find end for No block
                        nest = 0;
                        for (int k = noStart; k < end; k++) {
                            String nl = lines.get(k);
                            if (nl.startsWith("if ") || nl.startsWith("for ")) nest++;
                            else if (nl.equals("end")) {
                                if (nest == 0) {
                                    noEnd = k;
                                    break;
                                }
                                nest--;
                            }
                        }
                        break;
                    }
                }
                if (noStart == -1) noStart = noEnd = yesEnd;

                boolean condVal = evalCondition(cond, env);
                if (condVal) {
                    output.addAll(execute(lines, env.copy(), yesStart + 1, yesEnd));
                } else {
                    if (noStart != noEnd)
                        output.addAll(execute(lines, env.copy(), noStart, noEnd));
                }
                i = (noEnd != -1 ? noEnd : yesEnd) + 1;

            } else if (line.startsWith("for ")) {
                // for iter_var start end
                String[] parts = line.split("\\s+");
                String iterVar = parts[1];
                int startVal = env.getValue(parts[2]);
                int endVal = env.getValue(parts[3]);

                int blockStart = i + 1;
                int blockEnd = -1;
                int nest = 0;
                for (int j = blockStart; j < end; j++) {
                    String l = lines.get(j);
                    if (l.startsWith("for ") || l.startsWith("if ")) nest++;
                    else if (l.equals("end")) {
                        if (nest == 0) {
                            blockEnd = j;
                            break;
                        }
                        nest--;
                    }
                }
                for (int v = startVal; v <= endVal; v++) {
                    Env newEnv = env.copy();
                    newEnv.setVar(iterVar, v);
                    output.addAll(execute(lines, newEnv, blockStart, blockEnd));
                }
                i = blockEnd + 1;
            } else if (line.startsWith("print ")) {
                String val = line.substring(6).trim();
                output.add(String.valueOf(env.getValue(val)));
                i++;
            } else {
                // Lines like Yes, No, end just skip
                i++;
            }
        }
        return output;
    }

    static boolean evalCondition(String cond, Env env) {
        String[] ops = {"==", "!=", "<", ">"};
        for (String op : ops) {
            int idx = cond.indexOf(op);
            if (idx != -1) {
                String left = cond.substring(0, idx).trim();
                String right = cond.substring(idx + op.length()).trim();
                int lv = env.getValue(left);
                int rv = env.getValue(right);
                switch (op) {
                    case "==": return lv == rv;
                    case "!=": return lv != rv;
                    case "<": return lv < rv;
                    case ">": return lv > rv;
                }
            }
        }
        return false; // Default fallback
    }
}

