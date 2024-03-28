import os

def prec(c):
	if c == '^':
		return 3
	elif c == '/' or c == '*':
		return 2
	elif c == '+' or c == '-':
		return 1
	else:
		return -1

def associativity(c):
	if c == '^':
		return 'R'
	return 'L' # Default to left-associative

def infix_to_postfix(s):
	result = []
	stack = []

	for i in range(len(s)):
		c = s[i]

		# If the scanned character is an operand, add it to the output string.
		if ('a' <= c <= 'z') or ('A' <= c <= 'Z') or ('0' <= c <= '9'):
			result.append(c)
		# If the scanned character is an ‘(‘, push it to the stack.
		elif c == '(':
			stack.append(c)
		# If the scanned character is an ‘)’, pop and add to the output string from the stack
		# until an ‘(‘ is encountered.
		elif c == ')':
			while stack and stack[-1] != '(':
				result.append(stack.pop())
			stack.pop() # Pop '('
		# If an operator is scanned
		else:
			while stack and (prec(s[i]) < prec(stack[-1]) or
							(prec(s[i]) == prec(stack[-1]) and associativity(s[i]) == 'L')):
				result.append(stack.pop())
			stack.append(c)

	# Pop all the remaining elements from the stack
	while stack:
		result.append(stack.pop())

	return ''.join(result)

def isOperator(c):
    return (not c.isalpha()) and (not c.isdigit())
 
 
 
# Function to get the priority of operators
def getPriority(c):
    if c == '-' or c == '+':
        return 1
    elif c == '*' or c == '/':
        return 2
    elif c == '^':
        return 3
    return 0
 
 
   
# Function to convert the infix expression to postfix
def infixToPostfix(infix):
    infix = '(' + infix + ')'
    l = len(infix)
    char_stack = []
    output = ""
 
    for i in range(l):
         
        # Check if the character is alphabet or digit
        if infix[i].isalpha() or infix[i].isdigit():
            output += infix[i]
             
        # If the character is '(' push it in the stack
        elif infix[i] == '(':
            char_stack.append(infix[i])
         
        # If the character is ')' pop from the stack
        elif infix[i] == ')':
            while char_stack[-1] != '(':
                output += char_stack.pop()
            char_stack.pop()
         
        # Found an operator
        else:
            if isOperator(char_stack[-1]):
                if infix[i] == '^':
                    while getPriority(infix[i]) <= getPriority(char_stack[-1]):
                        output += char_stack.pop()
                else:
                    while getPriority(infix[i]) < getPriority(char_stack[-1]):
                        output += char_stack.pop()
                char_stack.append(infix[i])
 
    while len(char_stack) != 0:
        output += char_stack.pop()
    return output
 
 
 
# Function to convert infix expression to prefix
def infixToPrefix(infix):
    l = len(infix)
 
    infix = infix[::-1]
 
    for i in range(l):
        if infix[i] == '(':
            infix[i] = ')'
        elif infix[i] == ')':
            infix[i] = '('
 
    prefix = infixToPostfix(infix)
    prefix = prefix[::-1]
 
    return prefix

# Python program to evaluate value of a postfix expression


# Class to convert the expression
class Evaluate:

	# Constructor to initialize the class variables
	def __init__(self, capacity):
		self.top = -1
		self.capacity = capacity
		
		# This array is used a stack
		self.array = []

	# Check if the stack is empty
	def isEmpty(self):
		return True if self.top == -1 else False

	# Return the value of the top of the stack
	def peek(self):
		return self.array[-1]

	# Pop the element from the stack
	def pop(self):
		if not self.isEmpty():
			self.top -= 1
			return self.array.pop()
		else:
			return "$"

	# Push the element to the stack
	def push(self, op):
		self.top += 1
		self.array.append(op)

	# The main function that converts given infix expression
	# to postfix expression
	def evaluatePostfix(self, exp):

		# Iterate over the expression for conversion
		for i in exp:

			# If the scanned character is an operand
			# (number here) push it to the stack
			if i.isdigit():
				self.push(i)

			# If the scanned character is an operator,
			# pop two elements from stack and apply it.
			else:
				val1 = self.pop()
				val2 = self.pop()
				self.push(str(eval(val2 + i + val1)))

		return int(self.pop())
	
	def evaluatePrefix(self, exp):
		# Iterate over the expression for conversion
		for i in exp[::-1]:

			# If the scanned character is an operand
			# (number here) push it to the stack
			if i.isdigit():
				self.push(i)

			# If the scanned character is an operator,
			# pop two elements from stack and apply it.
			else:
				val1 = self.pop()
				val2 = self.pop()
				self.push(str(eval(val1 + i + val2)))

		return int(self.pop())

def main():
    print("# Selamat datang di Program infix, postfix, dan prefix #")
    print("========# oleh: Faturrohman Fairuz Zaki #========")
    print("=================================================")
    print("1. Infix to Postfix")
    print("2. Infix to Prefix")
    print("3. Keluar Program")

    return choice

while True:
	choice = main()
	if choice == "1":
		infix = input("Masukkan infix notation : ")
		postfix = infix_to_postfix(infix)
		obj = Evaluate(len(infix))
		postfixEval = obj.evaluatePostfix(postfix)
		print("Postfix notation : " + postfix)
		print("Postfix evaluation: "  + str(postfixEval))
	elif choice == "2":
		infix = input("Masukkan infix notation : ")
		prefix = infixToPrefix(infix)
		obj = Evaluate(len(infix))
		prefixEval = obj.evaluatePrefix(prefix)
		print("Prefix notation : " + prefix)
		print("Prefix evaluation : " + str(prefixEval))
	elif choice == "3":
		os.system('cls' if os.name == 'nt' else 'clear')
		print("Terima Kasih")
		exit()
	else:
		os.system('cls' if os.name == 'nt' else 'clear')
		print("Input tidak valid!")