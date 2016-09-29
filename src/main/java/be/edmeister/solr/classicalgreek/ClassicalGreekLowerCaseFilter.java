package be.edmeister.solr.classicalgreek;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.util.CharacterUtils;

import java.io.IOException;

public final class ClassicalGreekLowerCaseFilter extends TokenFilter {

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final CharacterUtils charUtils = CharacterUtils.getInstance();

    public ClassicalGreekLowerCaseFilter(TokenStream input) {
        super(input);
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
            char[] chArray = termAtt.buffer();
            int chLen = termAtt.length();
            for (int i = 0; i < chLen;) {
                i += Character.toChars(
                        lowerCase(charUtils.codePointAt(chArray, i, chLen)), chArray, i);
            }
            return true;
        } else {
            return false;
        }
    }

    private int lowerCase(int codepoint) {

        switch(codepoint) {
          /* There are two lowercase forms of sigma:
           *   U+03C2: small final sigma (end of word)
           *   U+03C3: small sigma (otherwise)
           *
           * Standardize both to U+03C3
           */
            case '\u03C2': /* small final sigma */
                return '\u03C3'; /* small sigma */

          /* Some greek characters contain diacritics.
           * This filter removes these, converting to the lowercase base form.
           */
            case '\u0386': /* capital alpha with tonos */
            case '\u03AC': /* small alpha with tonos */
            case '\u1F00': /* ἀ */
            case '\u1F01': /* ἁ */
            case '\u1F02': /* ἂ */
            case '\u1F03': /* ἃ */
            case '\u1F04': /* ἄ */
            case '\u1F05': /* ἅ */
            case '\u1F06': /* ἆ */
            case '\u1F07': /* ἇ */
            case '\u1F08': /* Ἀ */
            case '\u1F09': /* Ἁ */
            case '\u1F0A': /* Ἂ */
            case '\u1F0B': /* Ἃ */
            case '\u1F0C': /* Ἄ */
            case '\u1F0D': /* Ἅ */
            case '\u1F0E': /* Ἆ */
            case '\u1F0F': /* Ἇ */
            case '\u1F70': /* ὰ */
            case '\u1F71': /* ά */
            case '\u1F80': /* ᾀ */
            case '\u1F81': /* ᾁ */
            case '\u1F82': /* ᾂ */
            case '\u1F83': /* ᾃ */
            case '\u1F84': /* ᾄ */
            case '\u1F85': /* ᾅ */
            case '\u1F86': /* ᾆ */
            case '\u1F87': /* ᾇ */
            case '\u1F88': /* ᾈ */
            case '\u1F89': /* ᾉ */
            case '\u1F8A': /* ᾊ */
            case '\u1F8B': /* ᾋ */
            case '\u1F8C': /* ᾌ */
            case '\u1F8D': /* ᾍ */
            case '\u1F8E': /* ᾎ */
            case '\u1F8F': /* ᾏ */
            case '\u1FB0': /* ᾰ */
            case '\u1FB1': /* ᾱ */
            case '\u1FB2': /* ᾲ */
            case '\u1FB3': /* ᾳ */
            case '\u1FB4': /* ᾴ */
            case '\u1FB6': /* ᾶ */
            case '\u1FB7': /* ᾷ */
            case '\u1FB8': /* Ᾰ */
            case '\u1FB9': /* Ᾱ */
            case '\u1FBA': /* Ὰ */
            case '\u1FBB': /* Ά */
            case '\u1FBC': /* ᾼ */
                return '\u03B1'; /* small alpha */

            case '\u0388': /* capital epsilon with tonos */
            case '\u03AD': /* small epsilon with tonos */
            case '\u1F10': /* ἐ */
            case '\u1F11': /* ἑ */
            case '\u1F12': /* ἒ */
            case '\u1F13': /* ἓ */
            case '\u1F14': /* ἔ */
            case '\u1F15': /* ἕ */
            case '\u1F18': /* Ἐ */
            case '\u1F19': /* Ἑ */
            case '\u1F1A': /* Ἒ */
            case '\u1F1B': /* Ἓ */
            case '\u1F1C': /* Ἔ */
            case '\u1F1D': /* Ἕ */
            case '\u1F72': /* ὲ */
            case '\u1F73': /* έ */
            case '\u1FC8': /* Ὲ */
            case '\u1FC9': /* Έ */
                return '\u03B5'; /* small epsilon */

            case '\u0389': /* capital eta with tonos */
            case '\u03AE': /* small eta with tonos */
            case '\u1F20': /* ἠ */
            case '\u1F21': /* ἡ */
            case '\u1F22': /* ἢ */
            case '\u1F23': /* ἣ */
            case '\u1F24': /* ἤ */
            case '\u1F25': /* ἥ */
            case '\u1F26': /* ἦ */
            case '\u1F27': /* ἧ */
            case '\u1F28': /* Ἠ */
            case '\u1F29': /* Ἡ */
            case '\u1F2A': /* Ἢ */
            case '\u1F2B': /* Ἣ */
            case '\u1F2C': /* Ἤ */
            case '\u1F2D': /* Ἥ */
            case '\u1F2E': /* Ἦ */
            case '\u1F2F': /* Ἧ */
            case '\u1F74': /* ὴ */
            case '\u1F75': /* ή */
            case '\u1F90': /* ᾐ */
            case '\u1F91': /* ᾑ */
            case '\u1F92': /* ᾒ */
            case '\u1F93': /* ᾓ */
            case '\u1F94': /* ᾔ */
            case '\u1F95': /* ᾕ */
            case '\u1F96': /* ᾖ */
            case '\u1F97': /* ᾗ */
            case '\u1F98': /* ᾘ */
            case '\u1F99': /* ᾙ */
            case '\u1F9A': /* ᾚ */
            case '\u1F9B': /* ᾛ */
            case '\u1F9C': /* ᾜ */
            case '\u1F9D': /* ᾝ */
            case '\u1F9E': /* ᾞ */
            case '\u1F9F': /* ᾟ */
            case '\u1FC2': /* ῂ */
            case '\u1FC3': /* ῃ */
            case '\u1FC4': /* ῄ */
            case '\u1FC6': /* ῆ */
            case '\u1FC7': /* ῇ */
            case '\u1FCA': /* Ὴ */
            case '\u1FCB': /* Ή */
            case '\u1FCC': /* ῌ */
                return '\u03B7'; /* small eta */

            case '\u038A': /* capital iota with tonos */
            case '\u03AA': /* capital iota with dialytika */
            case '\u03AF': /* small iota with tonos */
            case '\u03CA': /* small iota with dialytika */
            case '\u0390': /* small iota with dialytika and tonos */
            case '\u1F76': /* ὶ */
            case '\u1F77': /* ί */
            case '\u1F30': /* ἰ */
            case '\u1F31': /* ἱ */
            case '\u1F32': /* ἲ */
            case '\u1F33': /* ἳ */
            case '\u1F34': /* ἴ */
            case '\u1F35': /* ἵ */
            case '\u1F36': /* ἶ */
            case '\u1F37': /* ἷ */
            case '\u1F38': /* Ἰ */
            case '\u1F39': /* Ἱ */
            case '\u1F3A': /* Ἲ */
            case '\u1F3B': /* Ἳ */
            case '\u1F3C': /* Ἴ */
            case '\u1F3D': /* Ἵ */
            case '\u1F3E': /* Ἶ */
            case '\u1F3F': /* Ἷ */
            case '\u1FD0': /* ῐ */
            case '\u1FD1': /* ῑ */
            case '\u1FD2': /* ῒ */
            case '\u1FD3': /* ΐ */
            case '\u1FD6': /* ῖ */
            case '\u1FD7': /* ῗ */
            case '\u1FD8': /* Ῐ */
            case '\u1FD9': /* Ῑ */
            case '\u1FDA': /* Ὶ */
            case '\u1FDB': /* Ί */
                return '\u03B9'; /* small iota */

            case '\u038E': /* capital upsilon with tonos */
            case '\u03AB': /* capital upsilon with dialytika */
            case '\u03CD': /* small upsilon with tonos */
            case '\u03CB': /* small upsilon with dialytika */
            case '\u03B0': /* small upsilon with dialytika and tonos */
            case '\u1F50': /* ὐ */
            case '\u1F51': /* ὑ */
            case '\u1F52': /* ὒ */
            case '\u1F53': /* ὓ */
            case '\u1F54': /* ὔ */
            case '\u1F55': /* ὕ */
            case '\u1F56': /* ὖ */
            case '\u1F57': /* ὗ */
            case '\u1F59': /* Ὑ */
            case '\u1F5B': /* Ὓ */
            case '\u1F5D': /* Ὕ */
            case '\u1F5F': /* Ὗ */
            case '\u1F7A': /* ὺ */
            case '\u1F7B': /* ύ */
            case '\u1FE0': /* ῠ */
            case '\u1FE1': /* ῡ */
            case '\u1FE2': /* ῢ */
            case '\u1FE3': /* ΰ */
            case '\u1FE6': /* ῦ */
            case '\u1FE7': /* ῧ */
            case '\u1FE8': /* Ῠ */
            case '\u1FE9': /* Ῡ */
            case '\u1FEA': /* Ὺ */
            case '\u1FEB': /* Ύ */
                return '\u03C5'; /* small upsilon */

            case '\u038C': /* capital omicron with tonos */
            case '\u03CC': /* small omicron with tonos */
            case '\u1F40': /* ὀ */
            case '\u1F41': /* ὁ */
            case '\u1F42': /* ὂ */
            case '\u1F43': /* ὃ */
            case '\u1F44': /* ὄ */
            case '\u1F45': /* ὅ */
            case '\u1F48': /* Ὀ */
            case '\u1F49': /* Ὁ */
            case '\u1F4A': /* Ὂ */
            case '\u1F4B': /* Ὃ */
            case '\u1F4C': /* Ὄ */
            case '\u1F4D': /* Ὅ */
            case '\u1F78': /* ὸ */
            case '\u1F79': /* ό */
            case '\u1FF8': /* Ὸ */
            case '\u1FF9': /* Ό */
                return '\u03BF'; /* small omicron */

            case '\u038F': /* capital omega with tonos */
            case '\u03CE': /* small omega with tonos */
            case '\u1F60': /* ὠ */
            case '\u1F61': /* ὡ */
            case '\u1F62': /* ὢ */
            case '\u1F63': /* ὣ */
            case '\u1F64': /* ὤ */
            case '\u1F65': /* ὥ */
            case '\u1F66': /* ὦ */
            case '\u1F67': /* ὧ */
            case '\u1F68': /* Ὠ */
            case '\u1F69': /* Ὡ */
            case '\u1F6A': /* Ὢ */
            case '\u1F6B': /* Ὣ */
            case '\u1F6C': /* Ὤ */
            case '\u1F6D': /* Ὥ */
            case '\u1F6E': /* Ὦ */
            case '\u1F6F': /* Ὧ */
            case '\u1F7C': /* ὼ */
            case '\u1F7D': /* ώ */
            case '\u1FA0': /* ᾠ */
            case '\u1FA1': /* ᾡ */
            case '\u1FA2': /* ᾢ */
            case '\u1FA3': /* ᾣ */
            case '\u1FA4': /* ᾤ */
            case '\u1FA5': /* ᾥ */
            case '\u1FA6': /* ᾦ */
            case '\u1FA7': /* ᾧ */
            case '\u1FA8': /* ᾨ */
            case '\u1FA9': /* ᾩ */
            case '\u1FAA': /* ᾪ */
            case '\u1FAB': /* ᾫ */
            case '\u1FAC': /* ᾬ */
            case '\u1FAD': /* ᾭ */
            case '\u1FAE': /* ᾮ */
            case '\u1FAF': /* ᾯ */
            case '\u1FF2': /* ῲ */
            case '\u1FF3': /* ῳ */
            case '\u1FF4': /* ῴ */
            case '\u1FF6': /* ῶ */
            case '\u1FF7': /* ῷ */
            case '\u1FFA': /* Ὼ */
            case '\u1FFB': /* Ώ */
            case '\u1FFC': /* ῼ */
                return '\u03C9'; /* small omega */

            case '\u1FE4': /* ῤ */
            case '\u1FE5': /* ῥ */
            case '\u1FEC': /* Ῥ */
                return '\u03C1'; /* ρ */

          /* The previous implementation did the conversion below.
           * Only implemented for backwards compatibility with old indexes.
           */

            case '\u03A2': /* reserved */
                return '\u03C2'; /* small final sigma */

            default:
                return Character.toLowerCase(codepoint);
        }
    }
}
