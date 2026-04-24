public class QuantityMeasurementApp {

    public static void main(String[] args) {

        String input = "madam"; // You can change this input

        // Convert string to char array
        char[] arr = input.toCharArray();

        boolean isPalindrome = true;

        // Two-pointer approach
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        // Output result
        if (isPalindrome) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }
    }
}