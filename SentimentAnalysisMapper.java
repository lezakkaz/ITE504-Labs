import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SentimentAnalysisMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private Text sentiment = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] words = line.split(" ");
        if (words.length > 0) {
            sentiment.set(words[0]); // First word as the sentiment label (e.g., "positive" or "negative")
            context.write(sentiment, one);
        }
    }
}
