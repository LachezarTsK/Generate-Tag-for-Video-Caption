
package main
import "strings"

const EMPTY_SPACE = ' '
const TAG_HEAD = '#'
const TAG_MAX_LENGTH = 100

func generateTag(caption string) string {
    caption = strings.Trim(caption, " ")
    if len(caption) == 0 {
        return string(TAG_HEAD)
    }

    tagVideoCaption := make([]byte, 2)
    tagVideoCaption[0] = TAG_HEAD
    tagVideoCaption[1] = strings.ToLower(string(caption[0]))[0]

    for i := 1; i < len(caption); i++ {
        if caption[i] == EMPTY_SPACE {
            continue
        }
        if caption[i - 1] == EMPTY_SPACE {
            tagVideoCaption = append(tagVideoCaption, strings.ToUpper(string(caption[i]))[0])
            continue
        }
        tagVideoCaption = append(tagVideoCaption, strings.ToLower(string(caption[i]))[0])
        if len(tagVideoCaption) == TAG_MAX_LENGTH {
            break
        }
    }

    return string(tagVideoCaption)
}
