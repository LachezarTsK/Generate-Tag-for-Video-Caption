
class Solution {

    private companion object {
        const val EMPTY_SPACE = ' '
        const val TAG_HEAD = '#'
        const val TAG_MAX_LENGTH = 100
    }

    fun generateTag(_caption: String): String {
        val caption = _caption.trim()
        if (caption.isEmpty()) {
            return TAG_HEAD.toString()
        }

        val tagVideoCaption = StringBuilder()
        tagVideoCaption.append(TAG_HEAD)
        tagVideoCaption.append(Character.toLowerCase(caption[0]))

        for (i in 1..<caption.length) {
            if (caption[i] == EMPTY_SPACE) {
                continue
            }
            if (caption[i - 1] == EMPTY_SPACE) {
                tagVideoCaption.append(Character.toUpperCase(caption[i]))
                continue
            }
            tagVideoCaption.append(Character.toLowerCase(caption[i]))
            if (tagVideoCaption.length == TAG_MAX_LENGTH) {
                break
            }
        }

        return tagVideoCaption.toString()
    }
}
