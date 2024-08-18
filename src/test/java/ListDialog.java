public class ListDialog {
    public enum NumberWord {
        zero(0, "Command one"),
        one(1, "Command two"),
        two(2, "Command three"),
        three(3, "Command four");

        private final int code;
        private final String word;

        NumberWord(int code, String word) {
            this.code = code;
            this.word = word;
        }

        public int getCode() {
            return code;
        }

        public String getWord() {
            return word;
        }
        public static String fromCodetoWord(int code) {
            for (NumberWord number : NumberWord.values()) {
                if (number.getCode() == code) {
                    return number.word;
                }
            }

            throw new IllegalArgumentException("Invalid code: " + code);
        }
    }



}
