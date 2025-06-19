
public class Solution {

    private static final char EMPTY_SPACE = ' ';
    private static final char TAG_HEAD = '#';
    private static final int TAG_MAX_LENGTH = 100;

    public String generateTag(String caption) {
        caption = caption.trim();
        if (caption.isEmpty()) {
            return Character.toString(TAG_HEAD);
        }

        StringBuilder tagVideoCaption = new StringBuilder();
        tagVideoCaption.append(TAG_HEAD);
        tagVideoCaption.append(Character.toLowerCase(caption.charAt(0)));

        for (int i = 1; i < caption.length() && tagVideoCaption.length() < TAG_MAX_LENGTH; ++i) {
            if (caption.charAt(i) == EMPTY_SPACE) {
                continue;
            }
            if (caption.charAt(i - 1) == EMPTY_SPACE) {
                tagVideoCaption.append(Character.toUpperCase(caption.charAt(i)));
                continue;
            }
            tagVideoCaption.append(Character.toLowerCase(caption.charAt(i)));
        }

        return tagVideoCaption.toString();
    }
}
