package com.tsystems.javaschool.tasks.calculator;

public class Calculator {

    private static final char[] operations = new char[]{'+', '-', '*', '/'};

    /**
     * Evaluate statement represented as string.
     *
     * @param statement mathematical statement containing digits, '.' (dot) as decimal mark,
     *                  parentheses, operations signs '+', '-', '*', '/'<br>
     *                  Example: <code>(1 + 38) * 4.5 - 1 / 2.</code>
     * @return string value containing result of evaluation or null if statement is invalid
     */
    public String evaluate(String statement) {
        if ((statement == null) || statement.trim().isEmpty()) {
            return null;
        }

        statement = statement.replaceAll(" ", "");
        for (char ch : operations) {
            if (statement.endsWith(String.valueOf(ch))) {
                return null;
            }
        }

        if (statement.startsWith("+") || statement.startsWith("*") || statement.startsWith("/")
                || statement.startsWith(".") || statement.endsWith(".")) {
            return null;
        }

        int leftParenthesisCount = (int) statement.chars().filter(ch -> ch == '(').count();
        int rightParenthesisCount = (int) statement.chars().filter(ch -> ch == ')').count();
        if ((leftParenthesisCount != rightParenthesisCount)
                || (statement.indexOf(')') < statement.indexOf('('))) {
            return null;
        }

        String[] incorrectOperations = new String[]{
                ",", "..", ".+", ".-", ".*", "./", ".(", ".)",
                ")(", "()", "(*", "(/", "(.", ").",
                "++", "+-", "+*", "+/", "+)", "+.",
                "--", "-+", "-*", "-/", "-)", "-.",
                "**", "*+", "*-", "*/", "*)", "*.",
                "//", "/+", "/-", "/*", "/)", "/."
        };
        for (String s : incorrectOperations) {
            if (statement.contains(s)) {
                return null;
            }
        }

        boolean isFirstNumberNegative = statement.startsWith("-") || statement.startsWith("(-");
        String stringResult = calculatedStatement(statement, leftParenthesisCount, isFirstNumberNegative);
        double doubleResult = Double.parseDouble(stringResult);
        if ((doubleResult == Double.POSITIVE_INFINITY) || (doubleResult == Double.NEGATIVE_INFINITY)
                || (stringResult.equals("NaN"))) {
            return null;
        }
        stringResult = doubleResult % 1 == 0
                ? String.valueOf((int) doubleResult)
                : String.format("%.4f", Double.parseDouble(stringResult));
        if (stringResult.contains(".")) {
            while (stringResult.endsWith("0")) {
                stringResult = stringResult.substring(0, stringResult.length() - 1);
            }
        }
        return stringResult;
    }

    private String calculatedStatement(String statement, int leftParenthesisCount, boolean isFirstNumberNegative) {
        int operationCount = 0;
        if (isFirstNumberNegative || statement.startsWith("-")) {
            statement = statement.replaceFirst("-", "");
            isFirstNumberNegative = true;
        }
        for (char ch : operations) {
            operationCount += statement.chars().filter(c -> c == ch).count();
        }

        if (operationCount == 0) {
            return statement;
        }

        int operationIndex = 0;
        String operation = "";
        if (operationCount == 1) {
            for (char ch : operations) {
                if (statement.contains(String.valueOf(ch))) {
                    operationIndex = statement.indexOf(ch);
                    operation = String.valueOf(ch);
                    break;
                }
            }
            String[] operateNumbers = findOperateNumbers(statement, operationIndex);
            return String.valueOf(operate(Double.parseDouble(operateNumbers[0]), Double.parseDouble(operateNumbers[1]),
                    operation, isFirstNumberNegative));
        } else {
            if (leftParenthesisCount >= 1) {
                int indexOfLeftParenthesis = statement.indexOf('(');
                int indexOfRightParenthesis = statement.indexOf(')');
                String currentOperation = statement.substring(indexOfLeftParenthesis + 1, indexOfRightParenthesis);
                String currentResult = calculatedStatement(currentOperation, 0, isFirstNumberNegative);
                String currentStatement = statement.replace("(" + currentOperation + ")", currentResult);
                return calculatedStatement(currentStatement, --leftParenthesisCount, isFirstNumberNegative);
            }

            boolean hasMultiplicationOrDivision = false;
            for (int i = 0; i < statement.length(); i++) {
                if ((statement.charAt(i) == operations[2]) || (statement.charAt(i) == operations[3])) {
                    operationIndex = i;
                    operation = String.valueOf(statement.charAt(i));
                    hasMultiplicationOrDivision = true;
                    break;
                }
            }

            if (!hasMultiplicationOrDivision) {
                for (int i = 0; i < statement.length(); i++) {
                    if ((statement.charAt(i) == operations[0]) || (statement.charAt(i) == operations[1])) {
                        operationIndex = i;
                        operation = String.valueOf(statement.charAt(i));
                        break;
                    }
                }
            }

            return getCurrentResult(statement, isFirstNumberNegative, operationIndex, operation);
        }
    }

    private String getCurrentResult(String statement, boolean isFirstNumberNegative, int operationIndex, String operation) {
        String[] operateNumbers = findOperateNumbers(statement, operationIndex);
        if (operateNumbers[0].startsWith("-")) {
            isFirstNumberNegative = true;
            operateNumbers[0] = operateNumbers[0].replace("-", "");
        }
        if (operateNumbers[1].startsWith("-")) {
            isFirstNumberNegative = true;
            operateNumbers[1] = operateNumbers[1].replace("-", "");
        }

        String[] stringNumbers = new String[operateNumbers.length];
        for (int i = 0; i < operateNumbers.length; i++) {
            if (operateNumbers[i].contains(".")) {
                if (Double.parseDouble(operateNumbers[i]) % 1 == 0) {
                    stringNumbers[i] = String.valueOf((int) Double.parseDouble(operateNumbers[i]));
                } else {
                    stringNumbers[i] = String.valueOf(Double.parseDouble(operateNumbers[i]));
                }
            } else {
                stringNumbers[i] = String.valueOf((operateNumbers[i]));
            }
            statement = statement.replace(operateNumbers[i], stringNumbers[i]);
        }

        String replacedExpression = stringNumbers[0] + operation + stringNumbers[1];
        double currentResult = operate(Double.parseDouble(operateNumbers[0]), Double.parseDouble(operateNumbers[1]),
                operation, isFirstNumberNegative);
        String currentStringResult = currentResult % 1 == 0
                ? String.valueOf((int) currentResult)
                : String.valueOf(currentResult);
        statement = statement.replace(replacedExpression, currentStringResult);
        return calculatedStatement(statement, 0, isFirstNumberNegative);
    }

    private String[] findOperateNumbers(String statement, int operationIndex) {
        char[] chars = statement.toCharArray();

        StringBuilder fistNumber = new StringBuilder();
        for (int i = operationIndex - 1; i >= 0; i--) {
            if (Character.isDigit(chars[i]) || (chars[i] == '.')) {
                fistNumber.append(chars[i]);
            } else {
                break;
            }
        }
        fistNumber.reverse();

        StringBuilder secondNumber = new StringBuilder();
        for (int i = operationIndex + 1; i < chars.length; i++) {
            if ((chars[operationIndex + 1] == '-') && (i == operationIndex + 1)) {
                secondNumber.insert(0, chars[i++]);
            }
            if (Character.isDigit(chars[i]) || (chars[i] == '.')) {
                secondNumber.append(chars[i]);
            } else {
                break;
            }
        }

        return new String[]{fistNumber.toString(), secondNumber.toString()};
    }

    public double operate(double firstNumber, double secondNumber, String operation, boolean isFirstElementNegative) {
        firstNumber = isFirstElementNegative ? -firstNumber : firstNumber;
        switch (operation) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                return firstNumber / secondNumber;
            default:
                return 0;
        }
    }

}
