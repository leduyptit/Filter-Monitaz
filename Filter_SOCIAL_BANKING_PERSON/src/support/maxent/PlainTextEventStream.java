package maxent;

import com.google.common.base.Splitter;

import opennlp.model.Event;
import opennlp.model.EventStream;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import static com.google.common.collect.Lists.newArrayList;

public class PlainTextEventStream implements EventStream {

	private final Iterator<Learning> samples;

	public PlainTextEventStream(Collection<Learning> samples) {
		this.samples = samples.iterator();
	}

	

	@Override
	public Event next() throws IOException {
		return createEvent(samples.next());
	}

	private Event createEvent(Learning sample) {
		String[] context = buildContext(sample.getText());
		return new Event(sample.getKlass(), context);
	}

	@Override
	public boolean hasNext() throws IOException {
		return samples.hasNext();
	}
	public static String tokenizer(String s) {
		s = s.replaceAll("[0-9\\-\\+\\.]{9,15}", " sdt ");
		s = s.replaceAll("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", " email ");
		s = s.replaceAll(
				"(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?",
				" website ");
		return s;
	}

	public static String[] buildContext(String text) {
		text=tokenizer(text)
//				.replaceAll("\\p{P}", " ")
				.replaceAll("\\s+", " ")
		.toLowerCase(Locale.getDefault());
		List<String> tokens = newArrayList(Splitter.on(' ').split(text));
//		System.out.println(tokens);
		return tokens.toArray(new String[tokens.size()]);
	}
	public static void main(String[] args) throws IOException {
		buildContext(" ab@gmail.com   có   lẽ nào ?");
	}
	
}
