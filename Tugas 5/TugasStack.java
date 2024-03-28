import java.util.Scanner;
import java.util.Stack;

public class TugasStack {

    // Function to return precedence of operators
    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    // Function to return associativity of operators
    static char associativity(char c) {
        if (c == '^')
            return 'R';
        return 'L'; // Default to left-associative
    }

    // The main function to convert infix expression to postfix expression
    static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the scanned character is an operand, add it to the output string.
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || Character.isDigit(c)) {
                result.append(c);
            }
            // If the scanned character is an ‘(‘, push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ‘)’, pop and add to the output string from the stack
            // until an ‘(‘ is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Pop '('
            }
            // If an operator is scanned
            else {
                while (!stack.isEmpty() && (prec(s.charAt(i)) < prec(stack.peek()) ||
                        prec(s.charAt(i)) == prec(stack.peek()) &&
                                associativity(s.charAt(i)) == 'L')) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the remaining elements from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    static int evaluatePostfix(String exp) {
        // Create a stack
        Stack<Integer> stack = new Stack<>();

        // Scan all characters one by one
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the scanned character is an operand
            // (number here), push it to the stack.
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                // Operator case
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

	static boolean isalpha(char c)
    {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
 
    // Function to check if the character is digit
    static boolean isdigit(char c)
    {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
 
    // Function to check if the character is an operator
    static boolean isOperator(char c)
    {
        return (!isalpha(c) && !isdigit(c));
    }
 
    // Function to get priority of operators
    static int getPriority(char C)
    {
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        else if (C == '^')
            return 3;
 
        return 0;
    }
 
    // Reverse the letters of the word
    static String reverse(char str[], int start, int end)
    {
        // Temporary variable to store character
        char temp;
        while (start < end) {
            // Swapping the first and last character
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }
 
    // Function to convert infix to postfix expression
    static String infixToPostfix(char[] infix1)
    {
        String infix = '(' + String.valueOf(infix1) + ')';
 
        int l = infix.length();
        Stack<Character> char_stack = new Stack<>();
        String output = "";
 
        for (int i = 0; i < l; i++) {
 
            // If the scanned character is an
            // operand, add it to output.
            if (isalpha(infix.charAt(i))
                || isdigit(infix.charAt(i)))
                output += infix.charAt(i);
 
            // If the scanned character is an
            // ‘(‘, push it to the stack.
            else if (infix.charAt(i) == '(')
                char_stack.add('(');
 
            // If the scanned character is an
            // ‘)’, pop and output from the stack
            // until an ‘(‘ is encountered.
            else if (infix.charAt(i) == ')') {
                while (char_stack.peek() != '(') {
                    output += char_stack.peek();
                    char_stack.pop();
                }
 
                // Remove '(' from the stack
                char_stack.pop();
            }
 
            // Operator found
            else {
                if (isOperator(char_stack.peek())) {
                    while (
                        (getPriority(infix.charAt(i))
                         < getPriority(char_stack.peek()))
                        || (getPriority(infix.charAt(i))
                                <= getPriority(
                                    char_stack.peek())
                            && infix.charAt(i) == '^')) {
                        output += char_stack.peek();
                        char_stack.pop();
                    }
 
                    // Push current Operator on stack
                    char_stack.add(infix.charAt(i));
                }
            }
        }
        while (!char_stack.empty()) {
            output += char_stack.pop();
        }
        return output;
    }
 
    static String infixToPrefix(char[] infix)
    {
        // Reverse String and replace ( with ) and vice
        // versa Get Postfix Reverse Postfix
        int l = infix.length;
 
        // Reverse infix
        String infix1 = reverse(infix, 0, l - 1);
        infix = infix1.toCharArray();
 
        // Replace ( with ) and vice versa
        for (int i = 0; i < l; i++) {
 
            if (infix[i] == '(') {
                infix[i] = ')';
                i++;
            }
            else if (infix[i] == ')') {
                infix[i] = '(';
                i++;
            }
        }
 
        String prefix = infixToPostfix(infix);
 
        // Reverse postfix
        prefix = reverse(prefix.toCharArray(), 0, l - 1);
 
        return prefix;
    }

	static int evaluatePrefix(String exp) {
        Stack<Integer> stack = new Stack<>();

        // Read the expression from right to left
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val1 + val2);
                        break;
                    case '-':
                        stack.push(val1 - val2);
                        break;
                    case '*':
                        stack.push(val1 * val2);
                        break;
                    case '/':
                        stack.push(val1 / val2);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
		int pilihan;
		String exp;
		Scanner input = new Scanner(System.in);
	
		System.out.println("Selamat datang di program infix, postfix, dan prefix.");
		System.out.println("oleh Faturrohman Fairuz Zaki");
		System.out.println("1. Infix to Postfix");
		System.out.println("2. Infix to Prefix");
		System.out.println("3. Keluar program");
		System.out.print("Masukkan pilihan anda : ");
		pilihan = input.nextInt();
		
		input.nextLine();

		while (pilihan != 3) {
			if (pilihan == 1) {
				System.out.print("Masukkan infix notation : ");
				exp = input.nextLine();
				String postfixExp = infixToPostfix(exp);
				System.out.println("Postfix notation: " + postfixExp);
				int postfixResult = evaluatePostfix(postfixExp);
				System.out.println("Hasil evaluasi postfix: " + postfixResult);
			} else if (pilihan == 2) {
				System.out.print("Masukkan infix notation : ");
				exp = input.nextLine();
				String prefixExp = infixToPrefix(exp.toCharArray());
				System.out.println("Prefix notation: " + prefixExp);
				int prefixResult = evaluatePrefix(prefixExp);
				System.out.println("Hasil evaluasi prefix: " + prefixResult);
			} else {
				System.out.println("Pilihan tidak valid!");
			}
			System.out.print("Masukkan pilihan anda : ");
			pilihan = input.nextInt();
			input.nextLine();
		}
		System.out.println("Terima kasih telah menggunakan program ini!");
		input.close();
	}
	
}
