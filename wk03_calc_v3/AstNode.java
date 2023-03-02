/*
 * @topic T10173 Desktop Calculator v3
 * @brief class AstNode represents a building block for AST, the abstract syntax tree
 */
package wk03_calc_v3;



public class AstNode {

    // ---------------------------
    // constants
    // ---------------------------
    public static final int NUMBER = 'N';
    public static final int END = 'Z';
    public static final int ERROR = 'E';
    public static final int IDENTIFIER = 'I';

    // ---------------------------
    // data
    // ---------------------------
    public int type;
    public String value;
    public AstNode leftNode;
    public AstNode rightNode;

    // ---------------------------
    // constructors
    // ---------------------------
    public AstNode(int type) {
        this.type = type;
        this.value = "";
        this.leftNode = null;
        this.rightNode = null;

    }// AstNode

    public AstNode(int type, String value) {
        this.type = type;
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }// AstNode

    // ---------------------------
    // operations
    // ---------------------------
    public void print(int level) {
        for (int idx = 0; idx < level; ++idx) {
            System.out.print(".");
        }
        System.out.println(value);
        if (leftNode != null) {
            leftNode.print(level + 1);
        }
        if (rightNode != null) {
            rightNode.print(level + 1);
        }
    }// print

    public double evaluate(int level) {
        if (type == '-' || type == '+' || type == '/' || type == '*' || type == '%') {
            if (leftNode == null) {
                return -rightNode.evaluate(level + 1);
            } else if (type == '-') {
                return leftNode.evaluate(level + 1) - rightNode.evaluate(level + 1);
            } else if (type == '+') {
                return leftNode.evaluate(level + 1) + rightNode.evaluate(level + 1);
                // division by 0 fix
            } else if (type == '/' && Double.parseDouble(rightNode.value) == 0) {
                throw new ArithmeticException("Error cannot divide by 0");
             
            } else if (type == '/' && Double.parseDouble(rightNode.value)!=0) {
                return leftNode.evaluate(level + 1) / rightNode.evaluate(level + 1);
                
            } else if (type == '*') {
                return leftNode.evaluate(level + 1) * rightNode.evaluate(level + 1);
            } else if (type == '%') {
                return leftNode.evaluate(level + 1) % rightNode.evaluate(level + 1);
            }
        } else {
            return (Double.parseDouble(value));
        }
        return (0.0);
    }
}
