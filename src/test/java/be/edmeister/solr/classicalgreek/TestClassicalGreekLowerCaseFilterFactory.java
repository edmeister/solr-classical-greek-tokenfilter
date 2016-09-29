package be.edmeister.solr.classicalgreek;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.BaseTokenStreamFactoryTestCase;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class TestClassicalGreekLowerCaseFilterFactory extends BaseTokenStreamFactoryTestCase {


    @Test
    public void testNormalization() throws Exception {

        Map<String,String> strings = new HashMap<>();

        strings.put("ἀ", "α");
        strings.put("ἁ", "α");
        strings.put("ἂ", "α");
        strings.put("ἃ", "α");
        strings.put("ἄ", "α");
        strings.put("ἅ", "α");
        strings.put("ἆ", "α");
        strings.put("ἇ", "α");
        strings.put("Ἀ", "α");
        strings.put("Ἁ", "α");
        strings.put("Ἂ", "α");
        strings.put("Ἃ", "α");
        strings.put("Ἄ", "α");
        strings.put("Ἅ", "α");
        strings.put("Ἆ", "α");
        strings.put("Ἇ", "α");
        strings.put("ἐ", "ε");
        strings.put("ἑ", "ε");
        strings.put("ἒ", "ε");
        strings.put("ἓ", "ε");
        strings.put("ἔ", "ε");
        strings.put("ἕ", "ε");
        strings.put("Ἐ", "ε");
        strings.put("Ἑ", "ε");
        strings.put("Ἒ", "ε");
        strings.put("Ἓ", "ε");
        strings.put("Ἔ", "ε");
        strings.put("Ἕ", "ε");
        strings.put("ἠ", "η");
        strings.put("ἡ", "η");
        strings.put("ἢ", "η");
        strings.put("ἣ", "η");
        strings.put("ἤ", "η");
        strings.put("ἥ", "η");
        strings.put("ἦ", "η");
        strings.put("ἧ", "η");
        strings.put("Ἠ", "η");
        strings.put("Ἡ", "η");
        strings.put("Ἢ", "η");
        strings.put("Ἣ", "η");
        strings.put("Ἤ", "η");
        strings.put("Ἥ", "η");
        strings.put("Ἦ", "η");
        strings.put("Ἧ", "η");
        strings.put("ἰ", "ι");
        strings.put("ἱ", "ι");
        strings.put("ἲ", "ι");
        strings.put("ἳ", "ι");
        strings.put("ἴ", "ι");
        strings.put("ἵ", "ι");
        strings.put("ἶ", "ι");
        strings.put("ἷ", "ι");
        strings.put("Ἰ", "ι");
        strings.put("Ἱ", "ι");
        strings.put("Ἲ", "ι");
        strings.put("Ἳ", "ι");
        strings.put("Ἴ", "ι");
        strings.put("Ἵ", "ι");
        strings.put("Ἶ", "ι");
        strings.put("Ἷ", "ι");
        strings.put("ὀ", "ο");
        strings.put("ὁ", "ο");
        strings.put("ὂ", "ο");
        strings.put("ὃ", "ο");
        strings.put("ὄ", "ο");
        strings.put("ὅ", "ο");
        strings.put("Ὀ", "ο");
        strings.put("Ὁ", "ο");
        strings.put("Ὂ", "ο");
        strings.put("Ὃ", "ο");
        strings.put("Ὄ", "ο");
        strings.put("Ὅ", "ο");
        strings.put("ὐ", "υ");
        strings.put("ὑ", "υ");
        strings.put("ὒ", "υ");
        strings.put("ὓ", "υ");
        strings.put("ὔ", "υ");
        strings.put("ὕ", "υ");
        strings.put("ὖ", "υ");
        strings.put("ὗ", "υ");
        strings.put("Ὑ", "υ");
        strings.put("Ὓ", "υ");
        strings.put("Ὕ", "υ");
        strings.put("Ὗ", "υ");
        strings.put("ὠ", "ω");
        strings.put("ὡ", "ω");
        strings.put("ὢ", "ω");
        strings.put("ὣ", "ω");
        strings.put("ὤ", "ω");
        strings.put("ὥ", "ω");
        strings.put("ὦ", "ω");
        strings.put("ὧ", "ω");
        strings.put("Ὠ", "ω");
        strings.put("Ὡ", "ω");
        strings.put("Ὢ", "ω");
        strings.put("Ὣ", "ω");
        strings.put("Ὤ", "ω");
        strings.put("Ὥ", "ω");
        strings.put("Ὦ", "ω");
        strings.put("Ὧ", "ω");
        strings.put("ὰ", "α");
        strings.put("ά", "α");
        strings.put("ὲ", "ε");
        strings.put("έ", "ε");
        strings.put("ὴ", "η");
        strings.put("ή", "η");
        strings.put("ὶ", "ι");
        strings.put("ί", "ι");
        strings.put("ὸ", "ο");
        strings.put("ό", "ο");
        strings.put("ὺ", "υ");
        strings.put("ύ", "υ");
        strings.put("ὼ", "ω");
        strings.put("ώ", "ω");
        strings.put("ᾀ", "α");
        strings.put("ᾁ", "α");
        strings.put("ᾂ", "α");
        strings.put("ᾃ", "α");
        strings.put("ᾄ", "α");
        strings.put("ᾅ", "α");
        strings.put("ᾆ", "α");
        strings.put("ᾇ", "α");
        strings.put("ᾈ", "α");
        strings.put("ᾉ", "α");
        strings.put("ᾊ", "α");
        strings.put("ᾋ", "α");
        strings.put("ᾌ", "α");
        strings.put("ᾍ", "α");
        strings.put("ᾎ", "α");
        strings.put("ᾏ", "α");
        strings.put("ᾐ", "η");
        strings.put("ᾑ", "η");
        strings.put("ᾒ", "η");
        strings.put("ᾓ", "η");
        strings.put("ᾔ", "η");
        strings.put("ᾕ", "η");
        strings.put("ᾖ", "η");
        strings.put("ᾗ", "η");
        strings.put("ᾘ", "η");
        strings.put("ᾙ", "η");
        strings.put("ᾚ", "η");
        strings.put("ᾛ", "η");
        strings.put("ᾜ", "η");
        strings.put("ᾝ", "η");
        strings.put("ᾞ", "η");
        strings.put("ᾟ", "η");
        strings.put("ᾠ", "ω");
        strings.put("ᾡ", "ω");
        strings.put("ᾢ", "ω");
        strings.put("ᾣ", "ω");
        strings.put("ᾤ", "ω");
        strings.put("ᾥ", "ω");
        strings.put("ᾦ", "ω");
        strings.put("ᾧ", "ω");
        strings.put("ᾨ", "ω");
        strings.put("ᾩ", "ω");
        strings.put("ᾪ", "ω");
        strings.put("ᾫ", "ω");
        strings.put("ᾬ", "ω");
        strings.put("ᾭ", "ω");
        strings.put("ᾮ", "ω");
        strings.put("ᾯ", "ω");
        strings.put("ᾰ", "α");
        strings.put("ᾱ", "α");
        strings.put("ᾲ", "α");
        strings.put("ᾳ", "α");
        strings.put("ᾴ", "α");
        strings.put("ᾶ", "α");
        strings.put("ᾷ", "α");
        strings.put("Ᾰ", "α");
        strings.put("Ᾱ", "α");
        strings.put("Ὰ", "α");
        strings.put("Ά", "α");
        strings.put("ᾼ", "α");
        strings.put("ῂ", "η");
        strings.put("ῃ", "η");
        strings.put("ῄ", "η");
        strings.put("ῆ", "η");
        strings.put("ῇ", "η");
        strings.put("Ὲ", "ε");
        strings.put("Έ", "ε");
        strings.put("Ὴ", "η");
        strings.put("Ή", "η");
        strings.put("ῌ", "η");
        strings.put("ῐ", "ι");
        strings.put("ῑ", "ι");
        strings.put("ῒ", "ι");
        strings.put("ΐ", "ι");
        strings.put("ῖ", "ι");
        strings.put("ῗ", "ι");
        strings.put("Ῐ", "ι");
        strings.put("Ῑ", "ι");
        strings.put("Ὶ", "ι");
        strings.put("Ί", "ι");
        strings.put("ῠ", "υ");
        strings.put("ῡ", "υ");
        strings.put("ῢ", "υ");
        strings.put("ΰ", "υ");
        strings.put("ῤ", "ρ");
        strings.put("ῥ", "ρ");
        strings.put("ῦ", "υ");
        strings.put("ῧ", "υ");
        strings.put("Ῠ", "υ");
        strings.put("Ῡ", "υ");
        strings.put("Ὺ", "υ");
        strings.put("Ύ", "υ");
        strings.put("Ῥ", "ρ");
        strings.put("ῲ", "ω");
        strings.put("ῳ", "ω");
        strings.put("ῴ", "ω");
        strings.put("ῶ", "ω");
        strings.put("ῷ", "ω");
        strings.put("Ὸ", "ο");
        strings.put("Ό", "ο");
        strings.put("Ὼ", "ω");
        strings.put("Ώ", "ω");
        strings.put("ῼ", "ω");

        for(Map.Entry<String,String> entry : strings.entrySet()) {

            TokenFilter stream = this.createFilter(entry.getKey());
            assertTokenStreamContents(stream, new String[] { entry.getValue() });

        }

    }

    private TokenFilter createFilter(String input) throws Exception {

        Reader reader = new StringReader(input);
        TokenStream stream = whitespaceMockTokenizer(reader);

        ClassicalGreekLowerCaseFilterFactory factory = new ClassicalGreekLowerCaseFilterFactory(new HashMap<String,String>());

        return factory.create(stream);

    }

}
