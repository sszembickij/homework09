/*написать класс для работы с большми числами которые заданны в виде строк,
и могут иметь длину в 1000 символов, без использования стандотных
библиотечных классов типа BigDecimal.
a) реализовать операции +,-
*/

public class TextDidital {
    public static void main(String[] args) {

        String number1 = "173.55";
        String number2 = "90.5";
        //System.out.println(additionTextDidital(number1, number2));
        System.out.println(subtractionTextDidital(number1, number2));

    }


    public static String additionTextDidital(String operand1, String operand2) {
        StringBuilder result = new StringBuilder("");
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

        if (value1.length() < value2.length()) {
            value1.reverse();
            for (int i = 0; i < value2.length() - value1.length(); i++) {
                value1.append("0");
            }
            value1.reverse();
        } else {
            value2.reverse();
            for (int i = 0; i < value1.length() - value2.length(); i++) {
                value2.append("0");
            }
            value1.reverse();
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

        if (value1.length() < value2.length()) {
            value1.reverse();
            for (int i = 0; i < value2.length() - value1.length(); i++) {
                value1.append("0");
            }
            value1.reverse();
        } else {
            value2.reverse();
            for (int i = 0; i < value1.length() - value2.length(); i++) {
                value2.append("0");
            }
            value1.reverse();
        }

        for (int i = value1.length() - 1; i >= 0; i++) {
            if (value1.charAt(i) > value2.charAt(i)) {
                break;
            }
            if (value1.charAt(i) <= value2.charAt(i)) {
                isNegativResult = true;
                break;
            }
        }

        if (isNegativResult) {
            StringBuilder tmpStr = value1;
            value1 = value2;
            value2 = tmpStr;
        }

        for (int i = 0; i < value1.length(); i++) {
            tmp += Integer.parseInt(String.valueOf(value1.charAt(i))) - Integer.parseInt(String.valueOf(value2.charAt(i)));
            if (tmp < 0) {
                result.append(10 + tmp);
                tmp = -1;
            } else {
                result.append(tmp);
                tmp = 0;
            }
        }

        if (result.charAt(result.length() - 1) == '0') {
            result = result.deleteCharAt(result.length() - 1);
        }
        if (isNegativResult) {
            result.append("-");
        }
        if (mantis > 0) {
            result.insert(mantis, '.');
        }
        return result.reverse().toString();

    }

    private static int getLengthFractionalParts(String number) {
        int lengthFractionalParts = 0;
        if (number.contains(".")) {
            lengthFractionalParts = number.length() - number.indexOf(".") - 1;
        }
        return lengthFractionalParts;
    }
}
