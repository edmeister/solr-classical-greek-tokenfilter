package be.edmeister.solr.classicalgreek;


import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.AbstractAnalysisFactory;
import org.apache.lucene.analysis.util.MultiTermAwareComponent;
import org.apache.lucene.analysis.util.TokenFilterFactory;

import java.util.Map;

public class ClassicalGreekLowerCaseFilterFactory extends TokenFilterFactory implements MultiTermAwareComponent {

    public ClassicalGreekLowerCaseFilterFactory(Map<String, String> args) {
        super(args);

    }

    @Override
    public ClassicalGreekLowerCaseFilter create(TokenStream tokenStream) {
        return new ClassicalGreekLowerCaseFilter(tokenStream);
    }

    @Override
    public AbstractAnalysisFactory getMultiTermComponent() {
        return this;
    }
}
