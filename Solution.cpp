
#include <string>
using namespace std;

class Solution {

    static const char EMPTY_SPACE = ' ';
    static const char TAG_HEAD = '#';
    static const int TAG_MAX_LENGTH = 100;

public:
    string generateTag(string caption) const {
        caption = trim(caption);
        if (caption.empty()) {
            return string{ TAG_HEAD };
        }

        string tagVideoCaption;
        tagVideoCaption.push_back(TAG_HEAD);
        tagVideoCaption.push_back(tolower(caption[0]));

        for (int i = 1; i < caption.length() && tagVideoCaption.length() < TAG_MAX_LENGTH; ++i) {
            if (caption[i] == EMPTY_SPACE) {
                continue;
            }
            if (caption[i - 1] == EMPTY_SPACE) {
                tagVideoCaption.push_back(toupper(caption[i]));
                continue;
            }
            tagVideoCaption.push_back(tolower(caption[i]));
        }

        return tagVideoCaption;
    }

private:
    string trim(const string& input) const {
        int left = 0;
        int right = input.size() - 1;
        while (left <= right && input[left] == EMPTY_SPACE) {
            ++left;
        }
        while (left < right && input[right] == EMPTY_SPACE) {
            --right;
        }
        return input.substr(left, right - left + 1);
    }
};
