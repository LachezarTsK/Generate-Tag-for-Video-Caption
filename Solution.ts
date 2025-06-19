
function generateTag(caption: string): string {
    const EMPTY_SPACE = ' ';
    const TAG_HEAD = '#';
    const TAG_MAX_LENGTH = 100;

    caption = caption.trim();
    if (caption.length === 0) {
        return TAG_HEAD;
    }

    const tagVideoCaption: string[] = new Array();
    tagVideoCaption.push(TAG_HEAD);
    tagVideoCaption.push((caption.charAt(0)).toLowerCase());

    for (let i = 1; i < caption.length && tagVideoCaption.length < TAG_MAX_LENGTH; ++i) {
        if (caption.charAt(i) === EMPTY_SPACE) {
            continue;
        }
        if (caption.charAt(i - 1) === EMPTY_SPACE) {
            tagVideoCaption.push((caption.charAt(i)).toUpperCase());
            continue;
        }
        tagVideoCaption.push((caption.charAt(i)).toLowerCase());
    }

    return tagVideoCaption.join('');
};
