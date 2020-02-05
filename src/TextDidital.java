/*написать класс для работы с большми числами которые заданны в виде строк,
и могут иметь длину в 1000 символов, без использования стандотных
библиотечных классов типа BigDecimal.
a) реализовать операции +,-
*/

public class TextDidital {
    public static void main(String[] args) {

        String number1 = "800.00005";
        String number2 = "800";
        //System.out.println(additionTextDidital(number1, number2));
        System.out.println(subtractionTextDidital(number1, number2));
        //System.out.println(multiplicationTextDidital(number1, number2));
        //System.out.println(divisionTextDidital(number1, number2));

    }

    public static String divisionTextDidital(String operand1, String operand2) {
        int resultAddMantis = 0;
        StringBuilder number1 = new StringBuilder(operand1);
        if (number1.indexOf(".") == -1) {
            number1.append(".");
        }
        StringBuilder number2 = new StringBuilder(operand2);
        if (number2.indexOf(".") == -1) {
            number2.append(".");
        }
        int tmp = 0;

        int fractPart1 = getLengthFractionalParts(number1.toString());
        int fractPart2 = getLengthFractionalParts(number2.toString());
        int mantis = Math.max(fractPart1, fractPart2);
        number1 = new StringBuilder(operand1.replace(".", ""));
        number2 = new StringBuilder(operand2.replace(".", ""));
        StringBuilder result = new StringBuilder("0");

        if (fractPart1 <= fractPart2) {
            for (int i = 0; i < fractPart2 - fractPart1; i++) {
                number1.append("0");
            }
        } else {
            for (int i = 0; i < fractPart1 - fractPart2; i++) {
                number2.append("0");
            }
        }
        while (number1.length() != number2.length()) {
            if (number1.length() < number2.length()) {
                number1.insert(0, '0');
            } else {
                number2.insert(0, '0');
            }
        }

        while (firstOperandMore(number1, number2)) {
            resultAddMantis++;
            number1 = new StringBuilder(changeMantis(number1, -1));
            System.out.println(number1);
        }


        while (result.length() < 1000) {

        }

        return result.toString();
    }

    public static void pruningZero(StringBuilder value) {
        if (value.indexOf(".") != -1) {
            while (value.charAt(value.length() - 1) == '0') {
                value.deleteCharAt(value.length() - 1);
            }
        }
        while (value.charAt(0) == '0' && value.charAt(1) != '.') {
            value.deleteCharAt(0);
        }
        if (value.charAt(value.length() - 1) == '.') {
            value.deleteCharAt(value.length() - 1);
        }
    }

    public static String multiplicationTextDidital(String operand1, String operand2) {
        StringBuilder number1 = new StringBuilder(operand1);
        if (number1.indexOf(".") == -1) {
            number1.append(".");
        }
        StringBuilder number2 = new StringBuilder(operand2);
        if (number2.indexOf(".") == -1) {
            number2.append(".");
        }
        StringBuilder result = new StringBuilder("0");
        StringBuilder temp1;
        StringBuilder temp2;
        int indexDelimiter = number2.indexOf(".");
        number2.deleteCharAt(indexDelimiter);
        int value;

        for (int i = 0; i < number2.length(); i++) {
            value = Integer.parseInt(String.valueOf(number2.charAt(i)));
            if (value == 0) {
                continue;
            }
            temp1 = new StringBuilder(changeMantis(number1, indexDelimiter - i - 1));
            for (int j = 0; j < value; j++) {
                temp2 = new StringBuilder(result);
                result = new StringBuilder(additionTextDidital(temp2.toString(), temp1.toString()));
            }
        }
        return result.toString();
    }

    public static String additionTextDidital(String operand1, String operand2) {
        StringBuilder result = new StringBuilder();
        int tmp = 0;

        int fractPart1 = getLengthFractionalParts(operand1);
        int fractPart2 = getLengthFractionalParts(operand2);
        int mantis = Math.max(fractPart1, fractPart2);
        StringBuilder value1 = new StringBuilder(operand1.replace(".", ""));
        StringBuilder value2 = new StringBuilder(operand2.replace(".", ""));

        if (fractPart1 <= fractPart2) {
            for (int i = 0; i < fractPart2 - fractPart1; i++) {
                value1.append("0");
            }
        } else {
            for (int i = 0; i < fractPart1 - fractPart2; i++) {
                value2.append("0");
            }
        }
        value1.reverse();
        value2.reverse();

        while (value1.length() != value2.length()) {
            if (value1.length() < value2.length()) {
                value1.append("0");
            } else {
                value2.append("0");
            }
        }

        for (int i = 0; i < value1.length(); i++) {
            tmp += Integer.parseInt(String.valueOf(value1.charAt(i))) + Integer.parseInt(String.valueOf(value2.charAt(i)));
            result.append(tmp % 10);
            tmp /= 10;
        }

        if (tmp != 0) {
            result.append(tmp);
        }
        if (mantis > 0) {
            result.insert(mantis, '.');
        }
        return result.reverse().toString();

    }

    public static String subtractionTextDidital(String operand1, String operand2) {
        StringBuilder result = new StringBuilder("");
        int tmp = 0;
        int fractPart1 = getLengthFractionalParts(operand1);
        int fractPart2 = getLengthFractionalParts(operand2);
        int mantis = Math.max(fractPart1, fractPart2);
        boolean isNegativResult = false;
        StringBuilder value1 = new StringBuilder(operand1.replace(".", ""));
        StringBuilder value2 = new StringBuilder(operand2.replace(".", ""));

        if (fractPart1 <= fractPart2) {
            for (int i = 0; i < fractPart2 - fractPart1; i++) {
                value1.append("0");
            }
        } else {
            for (int i = 0; i < fractPart1 - fractPart2; i++) {
                value2.append("0");
            }
        }

        while (value1.length() != value2.length()) {
            if (value1.length() < value2.length()) {
                value1.insert(0, '0');
            } else {
                value2.insert(0, '0');
            }
        }

        isNegativResult = !firstOperandMore(value1, value2);

        if (isNegativResult) {
            StringBuilder tmpStr = value1;
            value1 = value2;
            value2 = tmpStr;
        }

        for (int i = value1.length() - 1; i >= 0; i--) {
            tmp += Integer.parseInt(String.valueOf(value1.charAt(i))) - Integer.parseInt(String.valueOf(value2.charAt(i)));
            if (tmp < 0) {
                result.insert(0, 10 + tmp);
                tmp = -1;
            } else {
                result.insert(0, tmp);
                tmp = 0;
            }
        }

        if (result.charAt(result.length() - 1) == '0') {
            result = result.deleteCharAt(result.length() - 1);
        }
        if (isNegativResult) {
            result.insert(0, '-');
        }
        if (mantis > 0) {
            result.insert(result.length() - mantis, '.');
        }
        pruningZero(result);

        return result.toString();
    }

    private static boolean firstOperandMore(StringBuilder value1, StringBuilder value2) {
        for (int i = 0; i < value1.length(); i++) {
            if (value1.charAt(i) > value2.charAt(i)) {
                return true;
            }
            if (value1.charAt(i) < value2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static int getLengthFractionalParts(String number) {
        int lengthFractionalParts = 0;
        if (number.contains(".")) {
            lengthFractionalParts = number.length() - number.indexOf('.') - 1;
        }
        return lengthFractionalParts;
    }

    private static StringBuilder changeMantis(StringBuilder number, int degreeTen) {
        int lengthFractionalParts = getLengthFractionalParts(number.toString());
        number.deleteCharAt(number.indexOf("."));
        int numberLength = number.length();
        if (degreeTen >= 0) {
            if (lengthFractionalParts > degreeTen) {
                number.insert(numberLength - (lengthFractionalParts - degreeTen), '.');
            } else {
                for (int i = 0; i < degreeTen - lengthFractionalParts; i++) {
                    number.append('0');
                }
            }
        } else {
            if (numberLength - lengthFractionalParts > -degreeTen) {
                number.insert(numberLength - (lengthFractionalParts - degreeTen), '.');
            } else {
                for (int i = 0; i < -degreeTen - (numberLength - lengthFractionalParts); i++) {
                    number.insert(0, '0');
                }
                number.insert(0, "0.");
            }
        }
        return number;
    }
}
