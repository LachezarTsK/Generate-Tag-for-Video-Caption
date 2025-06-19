
using System;
using System.Text;

public class Solution
{
    private static readonly char EMPTY_SPACE = ' ';
    private static readonly char TAG_HEAD = '#';
    private static readonly int TAG_MAX_LENGTH = 100;

    public string GenerateTag(string caption)
    {
        caption = caption.Trim();
        if (caption.Length == 0)
        {
            return char.ToString(TAG_HEAD);
        }

        StringBuilder tagVideoCaption = new StringBuilder();
        tagVideoCaption.Append(TAG_HEAD);
        tagVideoCaption.Append(char.ToLower(caption[0]));

        for (int i = 1; i < caption.Length && tagVideoCaption.Length < TAG_MAX_LENGTH; ++i)
        {
            if (caption[i] == EMPTY_SPACE)
            {
                continue;
            }
            if (caption[i - 1] == EMPTY_SPACE)
            {
                tagVideoCaption.Append(char.ToUpper(caption[i]));
                continue;
            }
            tagVideoCaption.Append(char.ToLower(caption[i]));
        }

        return tagVideoCaption.ToString();
    }
}
